package lombok.eclipse.agent;

import com.xiaopeng.montecarlo.navcore.util.BLParams;
import java.lang.reflect.Field;
import lombok.Lombok;
import lombok.eclipse.Eclipse;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.permit.Permit;
import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ConditionalExpression;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;
import org.eclipse.jdt.internal.compiler.ast.FunctionalExpression;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.ast.LambdaExpression;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MarkerAnnotation;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.impl.ReferenceContext;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.CompilationUnitScope;
import org.eclipse.jdt.internal.compiler.lookup.ImportBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/agent/PatchVal.SCL.lombok */
public class PatchVal {
    public static TypeBinding skipResolveInitializerIfAlreadyCalled(Expression expr, BlockScope scope) {
        if (expr.resolvedType != null) {
            return expr.resolvedType;
        }
        try {
            return expr.resolveType(scope);
        } catch (ArrayIndexOutOfBoundsException unused) {
            return null;
        } catch (NullPointerException unused2) {
            return null;
        }
    }

    public static TypeBinding skipResolveInitializerIfAlreadyCalled2(Expression expr, BlockScope scope, LocalDeclaration decl) {
        if (decl == null || !LocalDeclaration.class.equals(decl.getClass()) || expr.resolvedType == null) {
            try {
                return expr.resolveType(scope);
            } catch (ArrayIndexOutOfBoundsException unused) {
                return null;
            } catch (NullPointerException unused2) {
                return null;
            }
        }
        return expr.resolvedType;
    }

    public static boolean matches(String key, char[] array) {
        if (array == null || key.length() != array.length) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (key.charAt(i) != array[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean couldBe(ImportBinding[] imports, String key, TypeReference ref) {
        String[] keyParts = key.split("\\.");
        if (ref instanceof SingleTypeReference) {
            char[] token = ((SingleTypeReference) ref).token;
            if (matches(keyParts[keyParts.length - 1], token)) {
                if (imports == null) {
                    return true;
                }
                for (ImportBinding ib : imports) {
                    ImportReference ir = ib.reference;
                    if (ir != null && !ir.isStatic()) {
                        boolean star = (ir.bits & 131072) != 0;
                        int len = keyParts.length - (star ? 1 : 0);
                        char[][] t = ir.tokens;
                        if (len == t.length) {
                            for (int i = 0; i < len; i++) {
                                if (keyParts[i].length() != t[i].length) {
                                    break;
                                }
                                for (int j = 0; j < t[i].length; j++) {
                                    if (keyParts[i].charAt(j) != t[i][j]) {
                                        break;
                                    }
                                }
                            }
                            return true;
                        }
                        continue;
                    }
                }
                return false;
            }
            return false;
        } else if (ref instanceof QualifiedTypeReference) {
            char[][] tokens = ((QualifiedTypeReference) ref).tokens;
            if (keyParts.length != tokens.length) {
                return false;
            }
            for (int i2 = 0; i2 < tokens.length; i2++) {
                String part = keyParts[i2];
                char[] token2 = tokens[i2];
                if (!matches(part, token2)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean couldBe(ImportReference[] imports, String key, TypeReference ref) {
        String[] keyParts = key.split("\\.");
        if (ref instanceof SingleTypeReference) {
            char[] token = ((SingleTypeReference) ref).token;
            if (matches(keyParts[keyParts.length - 1], token)) {
                if (imports == null) {
                    return true;
                }
                for (ImportReference ir : imports) {
                    if (!ir.isStatic()) {
                        boolean star = (ir.bits & 131072) != 0;
                        int len = keyParts.length - (star ? 1 : 0);
                        char[][] t = ir.tokens;
                        if (len == t.length) {
                            for (int i = 0; i < len; i++) {
                                if (keyParts[i].length() != t[i].length) {
                                    break;
                                }
                                for (int j = 0; j < t[i].length; j++) {
                                    if (keyParts[i].charAt(j) != t[i][j]) {
                                        break;
                                    }
                                }
                            }
                            return true;
                        }
                        continue;
                    }
                }
                return false;
            }
            return false;
        } else if (ref instanceof QualifiedTypeReference) {
            char[][] tokens = ((QualifiedTypeReference) ref).tokens;
            if (keyParts.length != tokens.length) {
                return false;
            }
            for (int i2 = 0; i2 < tokens.length; i2++) {
                String part = keyParts[i2];
                char[] token2 = tokens[i2];
                if (!matches(part, token2)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private static boolean is(TypeReference ref, BlockScope scope, String key) {
        Scope s;
        Scope scope2 = scope.parent;
        while (true) {
            s = scope2;
            if (s == null || (s instanceof CompilationUnitScope)) {
                break;
            }
            Scope ns = s.parent;
            scope2 = ns == s ? null : ns;
        }
        ImportBinding[] imports = null;
        if (s instanceof CompilationUnitScope) {
            imports = ((CompilationUnitScope) s).imports;
        }
        if (couldBe(imports, key, ref)) {
            TypeBinding resolvedType = ref.resolvedType;
            if (resolvedType == null) {
                resolvedType = ref.resolveType(scope, false);
            }
            if (resolvedType == null) {
                return false;
            }
            char[] pkg = resolvedType.qualifiedPackageName();
            char[] nm = resolvedType.qualifiedSourceName();
            int pkgFullLength = pkg.length > 0 ? pkg.length + 1 : 0;
            char[] fullName = new char[pkgFullLength + nm.length];
            if (pkg.length > 0) {
                System.arraycopy(pkg, 0, fullName, 0, pkg.length);
                fullName[pkg.length] = '.';
            }
            System.arraycopy(nm, 0, fullName, pkgFullLength, nm.length);
            return matches(key, fullName);
        }
        return false;
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/agent/PatchVal$Reflection.SCL.lombok */
    public static final class Reflection {
        private static final Field initCopyField;
        private static final Field iterableCopyField;

        static {
            Field a = null;
            Field b = null;
            try {
                a = Permit.getField(LocalDeclaration.class, "$initCopy");
                b = Permit.getField(LocalDeclaration.class, "$iterableCopy");
            } catch (Throwable unused) {
            }
            initCopyField = a;
            iterableCopyField = b;
        }
    }

    public static boolean handleValForLocalDeclaration(LocalDeclaration local, BlockScope scope) {
        TypeBinding resolved;
        if (local == null || !LocalDeclaration.class.equals(local.getClass())) {
            return false;
        }
        boolean decomponent = false;
        boolean val = isVal(local, scope);
        boolean var = isVar(local, scope);
        if (val || var) {
            if (val) {
                StackTraceElement[] st = new Throwable().getStackTrace();
                int i = 0;
                while (true) {
                    if (i >= st.length - 2 || i >= 10) {
                        break;
                    } else if (!st[i].getClassName().equals("lombok.launch.PatchFixesHider$Val")) {
                        i++;
                    } else {
                        boolean valInForStatement = st[i + 1].getClassName().equals("org.eclipse.jdt.internal.compiler.ast.LocalDeclaration") && st[i + 2].getClassName().equals("org.eclipse.jdt.internal.compiler.ast.ForStatement");
                        if (valInForStatement) {
                            return false;
                        }
                    }
                }
            }
            Expression init = local.initialization;
            if (init == null && Reflection.initCopyField != null) {
                try {
                    init = (Expression) Reflection.initCopyField.get(local);
                } catch (Exception unused) {
                }
            }
            if (init == null && Reflection.iterableCopyField != null) {
                try {
                    init = (Expression) Reflection.iterableCopyField.get(local);
                    decomponent = true;
                } catch (Exception unused2) {
                }
            }
            TypeReference replacement = null;
            if (init != null) {
                if (init.getClass().getName().equals("org.eclipse.jdt.internal.compiler.ast.LambdaExpression")) {
                    return false;
                }
                Constant oldConstant = init.constant;
                try {
                    resolved = decomponent ? getForEachComponentType(init, scope) : resolveForExpression(init, scope);
                } catch (NullPointerException unused3) {
                    resolved = null;
                }
                if (resolved != null) {
                    try {
                        replacement = EclipseHandlerUtil.makeType(resolved, local.type, false);
                        if (!decomponent) {
                            init.resolvedType = replacement.resolveType(scope);
                        }
                    } catch (Exception unused4) {
                    }
                } else if ((init instanceof MessageSend) && init.actualReceiverType == null) {
                    init.constant = oldConstant;
                }
            }
            if (val) {
                local.modifiers |= 16;
            }
            local.annotations = addValAnnotation(local.annotations, local.type, scope);
            local.type = replacement != null ? replacement : new QualifiedTypeReference(TypeConstants.JAVA_LANG_OBJECT, Eclipse.poss(local.type, 3));
            return false;
        }
        return false;
    }

    private static boolean isVar(LocalDeclaration local, BlockScope scope) {
        return is(local.type, scope, "lombok.experimental.var") || is(local.type, scope, "lombok.var");
    }

    private static boolean isVal(LocalDeclaration local, BlockScope scope) {
        return is(local.type, scope, "lombok.val");
    }

    public static boolean handleValForForEach(ForeachStatement forEach, BlockScope scope) {
        TypeBinding component;
        if (forEach.elementVariable == null) {
            return false;
        }
        boolean val = isVal(forEach.elementVariable, scope);
        boolean var = isVar(forEach.elementVariable, scope);
        if ((val || var) && (component = getForEachComponentType(forEach.collection, scope)) != null) {
            TypeReference replacement = EclipseHandlerUtil.makeType(component, forEach.elementVariable.type, false);
            if (val) {
                forEach.elementVariable.modifiers |= 16;
            }
            forEach.elementVariable.annotations = addValAnnotation(forEach.elementVariable.annotations, forEach.elementVariable.type, scope);
            forEach.elementVariable.type = replacement != null ? replacement : new QualifiedTypeReference(TypeConstants.JAVA_LANG_OBJECT, Eclipse.poss(forEach.elementVariable.type, 3));
            return false;
        }
        return false;
    }

    private static Annotation[] addValAnnotation(Annotation[] originals, TypeReference originalRef, BlockScope scope) {
        Annotation[] newAnn;
        if (originals != null) {
            newAnn = new Annotation[1 + originals.length];
            System.arraycopy(originals, 0, newAnn, 0, originals.length);
        } else {
            newAnn = new Annotation[1];
        }
        newAnn[newAnn.length - 1] = new MarkerAnnotation(originalRef, originalRef.sourceStart);
        return newAnn;
    }

    private static TypeBinding getForEachComponentType(Expression collection, BlockScope scope) {
        if (collection != null) {
            TypeBinding resolved = collection.resolvedType;
            if (resolved == null) {
                resolved = resolveForExpression(collection, scope);
            }
            if (resolved == null) {
                return null;
            }
            if (resolved.isArrayType()) {
                return resolved.elementsType();
            }
            if (resolved instanceof ReferenceBinding) {
                ParameterizedTypeBinding findSuperTypeOriginatingFrom = resolved.findSuperTypeOriginatingFrom(38, false);
                TypeVariableBinding[] typeVariableBindingArr = null;
                if (findSuperTypeOriginatingFrom != null) {
                    switch (findSuperTypeOriginatingFrom.kind()) {
                        case 260:
                            typeVariableBindingArr = findSuperTypeOriginatingFrom.arguments;
                            break;
                        case BLParams.SearchOverlayExitEntrance /* 1028 */:
                            return null;
                        case 2052:
                            typeVariableBindingArr = findSuperTypeOriginatingFrom.typeVariables();
                            break;
                    }
                }
                if (typeVariableBindingArr != null && typeVariableBindingArr.length == 1) {
                    return typeVariableBindingArr[0];
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private static TypeBinding resolveForExpression(Expression collection, BlockScope scope) {
        try {
            return collection.resolveType(scope);
        } catch (ArrayIndexOutOfBoundsException unused) {
            return null;
        } catch (AbortCompilation e) {
            if (collection instanceof ConditionalExpression) {
                ConditionalExpression cexp = (ConditionalExpression) collection;
                Expression ifTrue = cexp.valueIfTrue;
                FunctionalExpression functionalExpression = cexp.valueIfFalse;
                TypeBinding ifTrueResolvedType = ifTrue.resolvedType;
                CategorizedProblem problem = e.problem;
                if (ifTrueResolvedType != null && ((Expression) functionalExpression).resolvedType == null && problem.getCategoryID() == 40) {
                    CompilationResult compilationResult = e.compilationResult;
                    CategorizedProblem[] problems = compilationResult.problems;
                    int problemCount = compilationResult.problemCount;
                    int i = 0;
                    while (true) {
                        if (i >= problemCount) {
                            break;
                        } else if (problems[i] != problem) {
                            i++;
                        } else {
                            problems[i] = null;
                            if (i + 1 < problemCount) {
                                System.arraycopy(problems, i + 1, problems, i, (problemCount - i) + 1);
                            }
                        }
                    }
                    compilationResult.removeProblem(problem);
                    if (!compilationResult.hasErrors()) {
                        clearIgnoreFurtherInvestigationField(scope.referenceContext());
                        setValue(getField(CompilationResult.class, "hasMandatoryErrors"), compilationResult, false);
                    }
                    if (functionalExpression instanceof FunctionalExpression) {
                        FunctionalExpression functionalExpression2 = functionalExpression;
                        functionalExpression2.setExpectedType(ifTrueResolvedType);
                    }
                    if (((Expression) functionalExpression).resolvedType == null) {
                        functionalExpression.resolve(scope);
                    }
                    return ifTrueResolvedType;
                }
            }
            throw e;
        }
    }

    private static void clearIgnoreFurtherInvestigationField(ReferenceContext currentContext) {
        if (currentContext instanceof AbstractMethodDeclaration) {
            AbstractMethodDeclaration methodDeclaration = (AbstractMethodDeclaration) currentContext;
            methodDeclaration.ignoreFurtherInvestigation = false;
        } else if (!(currentContext instanceof LambdaExpression)) {
            if (currentContext instanceof TypeDeclaration) {
                TypeDeclaration typeDeclaration = (TypeDeclaration) currentContext;
                typeDeclaration.ignoreFurtherInvestigation = false;
            } else if (currentContext instanceof CompilationUnitDeclaration) {
                CompilationUnitDeclaration typeDeclaration2 = (CompilationUnitDeclaration) currentContext;
                typeDeclaration2.ignoreFurtherInvestigation = false;
            } else {
                throw new UnsupportedOperationException("clearIgnoreFurtherInvestigationField for " + currentContext.getClass());
            }
        } else {
            ReferenceContext referenceContext = (LambdaExpression) currentContext;
            setValue(getField(LambdaExpression.class, "ignoreFurtherInvestigation"), referenceContext, false);
            Scope scope = ((LambdaExpression) referenceContext).enclosingScope.parent;
            while (true) {
                Scope parent = scope;
                if (parent != null) {
                    switch (parent.kind) {
                        case 2:
                        case 3:
                            ReferenceContext parentAST = parent.referenceContext();
                            if (parentAST == referenceContext) {
                                break;
                            } else {
                                clearIgnoreFurtherInvestigationField(parentAST);
                                return;
                            }
                    }
                    scope = parent.parent;
                } else {
                    return;
                }
            }
        }
    }

    private static void setValue(Field field, Object object, Object value) {
        try {
            field.set(object, value);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        }
    }

    private static Field getField(Class<?> clazz, String name) {
        try {
            return Permit.getField(clazz, name);
        } catch (NoSuchFieldException e) {
            throw Lombok.sneakyThrow(e);
        }
    }
}
