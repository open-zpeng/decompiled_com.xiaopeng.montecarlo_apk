package lombok.javac.handlers;

import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.code.Types;
import com.sun.tools.javac.model.JavacTypes;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import lombok.ConfigurationKeys;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.experimental.Delegate;
import lombok.javac.FindTypeVarScanner;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacResolution;
import lombok.javac.JavacTreeMaker;
import lombok.javac.ResolutionResetNeeded;
import org.tukaani.xz.common.Util;
@HandlerPriority(65536)
@ResolutionResetNeeded
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/HandleDelegate.SCL.lombok */
public class HandleDelegate extends JavacAnnotationHandler<Delegate> {
    private static final List<String> METHODS_IN_OBJECT = Collections.unmodifiableList(Arrays.asList("hashCode()", "canEqual(java.lang.Object)", "equals(java.lang.Object)", "wait()", "wait(long)", "wait(long, int)", "notify()", "notifyAll()", "toString()", "getClass()", "clone()", "finalize()"));
    private static final String LEGALITY_OF_DELEGATE = "@Delegate is legal only on instance fields or no-argument instance methods.";
    private static final String RECURSION_NOT_ALLOWED = "@Delegate does not support recursion (delegating to a type that itself has @Delegate members). Member \"%s\" is @Delegate in type \"%s\"";
    public static final int HANDLE_DELEGATE_PRIORITY = 65536;

    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/HandleDelegate$CantMakeDelegates.SCL.lombok */
    public static class CantMakeDelegates extends Exception {
        Set<String> conflicted;
    }

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Delegate> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        DelegateReceiver delegateReceiver;
        Type delegateType;
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.DELEGATE_FLAG_USAGE, "@Delegate");
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, Delegate.class, lombok.Delegate.class);
        Name delegateName = annotationNode.toName(annotationNode.up().getName());
        JavacResolution reso = new JavacResolution(annotationNode.getContext());
        JCTree.JCVariableDecl jCVariableDecl = (JCTree) annotationNode.up().get();
        if (annotationNode.up().getKind() == AST.Kind.FIELD) {
            if ((jCVariableDecl.mods.flags & 8) != 0) {
                annotationNode.addError(LEGALITY_OF_DELEGATE);
                return;
            }
            delegateReceiver = DelegateReceiver.FIELD;
            Type delegateType2 = ((JCTree) jCVariableDecl).type;
            if (delegateType2 == null) {
                reso.resolveClassMember(annotationNode.up());
            }
            delegateType = ((JCTree) jCVariableDecl).type;
        } else if (annotationNode.up().getKind() == AST.Kind.METHOD) {
            if (!(jCVariableDecl instanceof JCTree.JCMethodDecl)) {
                annotationNode.addError(LEGALITY_OF_DELEGATE);
                return;
            }
            JCTree.JCMethodDecl methodDecl = (JCTree.JCMethodDecl) jCVariableDecl;
            if (!methodDecl.params.isEmpty() || (methodDecl.mods.flags & 8) != 0) {
                annotationNode.addError(LEGALITY_OF_DELEGATE);
                return;
            }
            delegateReceiver = DelegateReceiver.METHOD;
            Type delegateType3 = methodDecl.restype.type;
            if (delegateType3 == null) {
                reso.resolveClassMember(annotationNode.up());
            }
            delegateType = methodDecl.restype.type;
        } else {
            return;
        }
        List<Object> delegateTypes = annotation.getActualExpressions("types");
        List<Object> excludeTypes = annotation.getActualExpressions("excludes");
        List<Type> toDelegate = new ArrayList<>();
        List<Type> toExclude = new ArrayList<>();
        if (delegateTypes.isEmpty()) {
            if (delegateType != null) {
                toDelegate.add(delegateType);
            }
        } else {
            for (Object dt : delegateTypes) {
                if ((dt instanceof JCTree.JCFieldAccess) && ((JCTree.JCFieldAccess) dt).name.toString().equals("class")) {
                    if (((JCTree.JCFieldAccess) dt).selected.type == null) {
                        reso.resolveClassMember(annotationNode);
                    }
                    Type type = ((JCTree.JCFieldAccess) dt).selected.type;
                    if (type != null) {
                        toDelegate.add(type);
                    }
                }
            }
        }
        for (Object et : excludeTypes) {
            if ((et instanceof JCTree.JCFieldAccess) && ((JCTree.JCFieldAccess) et).name.toString().equals("class")) {
                if (((JCTree.JCFieldAccess) et).selected.type == null) {
                    reso.resolveClassMember(annotationNode);
                }
                Type type2 = ((JCTree.JCFieldAccess) et).selected.type;
                if (type2 != null) {
                    toExclude.add(type2);
                }
            }
        }
        List<MethodSig> signaturesToDelegate = new ArrayList<>();
        List<MethodSig> signaturesToExclude = new ArrayList<>();
        Set<String> banList = new HashSet<>();
        banList.addAll(METHODS_IN_OBJECT);
        JavacNode typeNode = JavacHandlerUtil.upToTypeNode(annotationNode);
        for (Symbol m : typeNode.get().sym.getEnclosedElements()) {
            if (m instanceof Symbol.MethodSymbol) {
                banList.add(printSig(m.asType(), m.name, annotationNode.getTypesUtil()));
            }
        }
        try {
            for (Type t : toExclude) {
                if (t instanceof Type.ClassType) {
                    Type.ClassType ct = (Type.ClassType) t;
                    addMethodBindings(signaturesToExclude, ct, annotationNode.getTypesUtil(), banList);
                } else {
                    annotationNode.addError("@Delegate can only use concrete class types, not wildcards, arrays, type variables, or primitives.");
                    return;
                }
            }
            for (MethodSig sig : signaturesToExclude) {
                banList.add(printSig(sig.type, sig.name, annotationNode.getTypesUtil()));
            }
            for (Type t2 : toDelegate) {
                Type unannotatedType = Unannotated.unannotatedType(t2);
                if (unannotatedType instanceof Type.ClassType) {
                    Type.ClassType ct2 = (Type.ClassType) unannotatedType;
                    addMethodBindings(signaturesToDelegate, ct2, annotationNode.getTypesUtil(), banList);
                } else {
                    annotationNode.addError("@Delegate can only use concrete class types, not wildcards, arrays, type variables, or primitives.");
                    return;
                }
            }
            for (MethodSig sig2 : signaturesToDelegate) {
                generateAndAdd(sig2, annotationNode, delegateName, delegateReceiver);
            }
        } catch (DelegateRecursion e) {
            annotationNode.addError(String.format(RECURSION_NOT_ALLOWED, e.member, e.type));
        }
    }

    public void generateAndAdd(MethodSig sig, JavacNode annotation, Name delegateName, DelegateReceiver delegateReceiver) {
        List<JCTree.JCMethodDecl> toAdd = new ArrayList<>();
        try {
            toAdd.add(createDelegateMethod(sig, annotation, delegateName, delegateReceiver));
            for (JCTree.JCMethodDecl method : toAdd) {
                JavacHandlerUtil.injectMethod(annotation.up().up(), method);
            }
        } catch (JavacResolution.TypeNotConvertibleException e) {
            annotation.addError("Can't create delegate method for " + sig.name + ": " + e.getMessage());
        } catch (CantMakeDelegates e2) {
            annotation.addError("There's a conflict in the names of type parameters. Fix it by renaming the following type parameters of your class: " + e2.conflicted);
        }
    }

    public void checkConflictOfTypeVarNames(MethodSig sig, JavacNode annotation) throws CantMakeDelegates {
        com.sun.tools.javac.util.List<JCTree.JCTypeParameter> list;
        if (sig.elem.getTypeParameters().isEmpty()) {
            return;
        }
        Set<String> usedInOurType = new HashSet<>();
        JavacNode javacNode = annotation;
        while (true) {
            JavacNode enclosingType = javacNode;
            if (enclosingType == null) {
                break;
            }
            if (enclosingType.getKind() == AST.Kind.TYPE && (list = enclosingType.get().typarams) != null) {
                for (JCTree.JCTypeParameter param : list) {
                    if (param.name != null) {
                        usedInOurType.add(param.name.toString());
                    }
                }
            }
            javacNode = enclosingType.up();
        }
        Set<String> usedInMethodSig = new HashSet<>();
        for (TypeParameterElement param2 : sig.elem.getTypeParameters()) {
            usedInMethodSig.add(param2.getSimpleName().toString());
        }
        usedInMethodSig.retainAll(usedInOurType);
        if (usedInMethodSig.isEmpty()) {
            return;
        }
        FindTypeVarScanner scanner = new FindTypeVarScanner();
        sig.elem.asType().accept(scanner, (Object) null);
        Set<String> names = new HashSet<>(scanner.getTypeVariables());
        names.removeAll(usedInMethodSig);
        if (!names.isEmpty()) {
            CantMakeDelegates cmd = new CantMakeDelegates();
            cmd.conflicted = usedInMethodSig;
            throw cmd;
        }
    }

    public JCTree.JCMethodDecl createDelegateMethod(MethodSig sig, JavacNode annotation, Name delegateName, DelegateReceiver delegateReceiver) throws JavacResolution.TypeNotConvertibleException, CantMakeDelegates {
        com.sun.tools.javac.util.List<JCTree.JCAnnotation> annotations;
        checkConflictOfTypeVarNames(sig, annotation);
        JavacTreeMaker maker = annotation.getTreeMaker();
        if (sig.isDeprecated) {
            annotations = com.sun.tools.javac.util.List.of(maker.Annotation(JavacHandlerUtil.genJavaLangTypeRef(annotation, "Deprecated"), com.sun.tools.javac.util.List.nil()));
        } else {
            annotations = com.sun.tools.javac.util.List.nil();
        }
        JCTree.JCModifiers mods = maker.Modifiers(1L, annotations);
        JCTree.JCExpression returnType = JavacResolution.typeToJCTree(sig.type.getReturnType(), annotation.getAst(), true);
        boolean useReturn = sig.type.getReturnType().getKind() != TypeKind.VOID;
        ListBuffer<JCTree.JCVariableDecl> params = sig.type.getParameterTypes().isEmpty() ? null : new ListBuffer<>();
        ListBuffer<JCTree.JCExpression> args = sig.type.getParameterTypes().isEmpty() ? null : new ListBuffer<>();
        ListBuffer<JCTree.JCExpression> thrown = sig.type.getThrownTypes().isEmpty() ? null : new ListBuffer<>();
        ListBuffer<JCTree.JCTypeParameter> typeParams = sig.type.getTypeVariables().isEmpty() ? null : new ListBuffer<>();
        ListBuffer<JCTree.JCExpression> typeArgs = sig.type.getTypeVariables().isEmpty() ? null : new ListBuffer<>();
        Types types = Types.instance(annotation.getContext());
        for (Type.TypeVar typeVar : sig.type.getTypeVariables()) {
            Name name = typeVar.tsym.name;
            ListBuffer<JCTree.JCExpression> bounds = new ListBuffer<>();
            Iterator it = types.getBounds(typeVar).iterator();
            while (it.hasNext()) {
                Type type = (Type) it.next();
                bounds.append(JavacResolution.typeToJCTree(type, annotation.getAst(), true));
            }
            typeParams.append(maker.TypeParameter(name, bounds.toList()));
            typeArgs.append(maker.Ident(name));
        }
        for (Type type2 : sig.type.getThrownTypes()) {
            thrown.append(JavacResolution.typeToJCTree(type2, annotation.getAst(), true));
        }
        int idx = 0;
        String[] paramNames = sig.getParameterNames();
        boolean varargs = sig.elem.isVarArgs();
        for (Type type3 : sig.type.getParameterTypes()) {
            long flags = JavacHandlerUtil.addFinalIfNeeded(8589934592L, annotation.getContext());
            JCTree.JCModifiers paramMods = maker.Modifiers(flags);
            int i = idx;
            idx++;
            Name name2 = annotation.toName(paramNames[i]);
            if (varargs && idx == paramNames.length) {
                paramMods.flags |= Util.BACKWARD_SIZE_MAX;
            }
            params.append(maker.VarDef(paramMods, name2, JavacResolution.typeToJCTree(type3, annotation.getAst(), true), null));
            args.append(maker.Ident(name2));
        }
        JCTree.JCMethodInvocation Apply = maker.Apply(toList(typeArgs), maker.Select(delegateReceiver.get(annotation, delegateName), sig.name), toList(args));
        JCTree.JCBlock bodyBlock = maker.Block(0L, com.sun.tools.javac.util.List.of(useReturn ? maker.Return(Apply) : maker.Exec(Apply)));
        return JavacHandlerUtil.recursiveSetGeneratedBy(maker.MethodDef(mods, sig.name, returnType, toList(typeParams), toList(params), toList(thrown), bodyBlock, null), annotation.get(), annotation.getContext());
    }

    public static <T> com.sun.tools.javac.util.List<T> toList(ListBuffer<T> collection) {
        return collection == null ? com.sun.tools.javac.util.List.nil() : collection.toList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/HandleDelegate$DelegateRecursion.SCL.lombok */
    public static class DelegateRecursion extends Throwable {
        final String type;
        final String member;

        public DelegateRecursion(String type, String member) {
            this.type = type;
            this.member = member;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void addMethodBindings(java.util.List<lombok.javac.handlers.HandleDelegate.MethodSig> r9, com.sun.tools.javac.code.Type.ClassType r10, com.sun.tools.javac.model.JavacTypes r11, java.util.Set<java.lang.String> r12) throws lombok.javac.handlers.HandleDelegate.DelegateRecursion {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: lombok.javac.handlers.HandleDelegate.addMethodBindings(java.util.List, com.sun.tools.javac.code.Type$ClassType, com.sun.tools.javac.model.JavacTypes, java.util.Set):void");
    }

    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/HandleDelegate$MethodSig.SCL.lombok */
    public static class MethodSig {
        final Name name;
        final ExecutableType type;
        final boolean isDeprecated;
        final ExecutableElement elem;

        MethodSig(Name name, ExecutableType type, boolean isDeprecated, ExecutableElement elem) {
            this.name = name;
            this.type = type;
            this.isDeprecated = isDeprecated;
            this.elem = elem;
        }

        String[] getParameterNames() {
            List<? extends VariableElement> paramList = this.elem.getParameters();
            String[] paramNames = new String[paramList.size()];
            for (int i = 0; i < paramNames.length; i++) {
                paramNames[i] = ((VariableElement) paramList.get(i)).getSimpleName().toString();
            }
            return paramNames;
        }

        public String toString() {
            return String.valueOf(this.isDeprecated ? "@Deprecated " : "") + this.name + " " + this.type;
        }
    }

    public static String printSig(ExecutableType method, Name name, JavacTypes types) {
        StringBuilder sb = new StringBuilder();
        sb.append(name.toString()).append("(");
        boolean first = true;
        for (TypeMirror param : method.getParameterTypes()) {
            if (!first) {
                sb.append(", ");
            }
            first = false;
            sb.append(typeBindingToSignature(param, types));
        }
        return sb.append(")").toString();
    }

    public static String typeBindingToSignature(TypeMirror binding, JavacTypes types) {
        return types.erasure(binding).toString();
    }

    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/HandleDelegate$DelegateReceiver.SCL.lombok */
    public enum DelegateReceiver {
        METHOD { // from class: lombok.javac.handlers.HandleDelegate.DelegateReceiver.1
            @Override // lombok.javac.handlers.HandleDelegate.DelegateReceiver
            public JCTree.JCExpression get(JavacNode node, Name name) {
                com.sun.tools.javac.util.List<JCTree.JCExpression> nilExprs = com.sun.tools.javac.util.List.nil();
                JavacTreeMaker maker = node.getTreeMaker();
                return maker.Apply(nilExprs, maker.Select(maker.Ident(node.toName("this")), name), nilExprs);
            }
        },
        FIELD { // from class: lombok.javac.handlers.HandleDelegate.DelegateReceiver.2
            @Override // lombok.javac.handlers.HandleDelegate.DelegateReceiver
            public JCTree.JCExpression get(JavacNode node, Name name) {
                JavacTreeMaker maker = node.getTreeMaker();
                return maker.Select(maker.Ident(node.toName("this")), name);
            }
        };

        public abstract JCTree.JCExpression get(JavacNode javacNode, Name name);

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static DelegateReceiver[] valuesCustom() {
            DelegateReceiver[] valuesCustom = values();
            int length = valuesCustom.length;
            DelegateReceiver[] delegateReceiverArr = new DelegateReceiver[length];
            System.arraycopy(valuesCustom, 0, delegateReceiverArr, 0, length);
            return delegateReceiverArr;
        }

        /* synthetic */ DelegateReceiver(DelegateReceiver delegateReceiver) {
            this();
        }
    }

    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/HandleDelegate$Unannotated.SCL.lombok */
    private static class Unannotated {
        private static final Method unannotated;

        private Unannotated() {
        }

        static {
            Method m = null;
            try {
                m = Type.class.getDeclaredMethod("unannotatedType", new Class[0]);
            } catch (Exception unused) {
            }
            unannotated = m;
        }

        static Type unannotatedType(Type t) {
            if (unannotated == null) {
                return t;
            }
            try {
                return (Type) unannotated.invoke(t, new Object[0]);
            } catch (Exception unused) {
                return t;
            }
        }
    }
}
