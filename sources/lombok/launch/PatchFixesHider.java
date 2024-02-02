package lombok.launch;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Application;
import com.xiaopeng.lib.framework.locationmodule.LocationImpl;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation;
import com.xiaopeng.montecarlo.root.httpclient.constants.HttpConst;
import io.reactivex.disposables.Disposable;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import lombok.eclipse.EcjAugments;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IAnnotatable;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.jdt.internal.core.SourceField;
import org.eclipse.jdt.internal.core.dom.rewrite.NodeRewriteEvent;
import org.eclipse.jdt.internal.core.dom.rewrite.RewriteEvent;
import org.eclipse.jdt.internal.core.dom.rewrite.TokenScanner;
import org.eclipse.jdt.internal.corext.refactoring.SearchResultGroup;
import org.eclipse.jdt.internal.corext.refactoring.structure.ASTNodeSearchUtil;
/* JADX WARN: Classes with same name are omitted:
  classes3.dex
 */
/* loaded from: xp_Montecarlo-benchEdward.apk:Class50/lombok/launch/PatchFixesHider.SCL.lombok */
final class PatchFixesHider {
    PatchFixesHider() {
    }

    /* JADX WARN: Classes with same name are omitted:
      classes3.dex
     */
    /* loaded from: xp_Montecarlo-benchEdward.apk:Class50/lombok/launch/PatchFixesHider$Util.SCL.lombok */
    public static final class Util {
        private static ClassLoader shadowLoader;

        public static Class<?> shadowLoadClass(String name) {
            try {
                if (shadowLoader == null) {
                    try {
                        Class.forName("lombok.core.LombokNode");
                        shadowLoader = Util.class.getClassLoader();
                    } catch (ClassNotFoundException unused) {
                        shadowLoader = Main.getShadowClassLoader();
                    }
                }
                return Class.forName(name, true, shadowLoader);
            } catch (ClassNotFoundException e) {
                throw sneakyThrow(e);
            }
        }

        public static Method findMethod(Class<?> type, String name, Class<?>... clsArr) {
            try {
                return type.getDeclaredMethod(name, clsArr);
            } catch (NoSuchMethodException e) {
                throw sneakyThrow(e);
            }
        }

        public static Object invokeMethod(Method method, Object... args) {
            try {
                return method.invoke(null, args);
            } catch (IllegalAccessException e) {
                throw sneakyThrow(e);
            } catch (InvocationTargetException e2) {
                throw sneakyThrow(e2.getCause());
            }
        }

        private static RuntimeException sneakyThrow(Throwable t) {
            if (t == null) {
                throw new NullPointerException(HttpConst.XP_CLIENT_PARAMETER_T);
            }
            sneakyThrow0(t);
            return null;
        }

        private static <T extends Throwable> void sneakyThrow0(Throwable t) throws Throwable {
            throw t;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      classes3.dex
     */
    /* loaded from: xp_Montecarlo-benchEdward.apk:Class50/lombok/launch/PatchFixesHider$LombokDeps.SCL.lombok */
    public static final class LombokDeps {
        public static final Method ADD_LOMBOK_NOTES;
        public static final Method POST_COMPILER_BYTES_STRING;
        public static final Method POST_COMPILER_OUTPUTSTREAM;
        public static final Method POST_COMPILER_BUFFEREDOUTPUTSTREAM_STRING_STRING;

        static {
            Class<?> shadowed = Util.shadowLoadClass("lombok.eclipse.agent.PatchFixesShadowLoaded");
            ADD_LOMBOK_NOTES = Util.findMethod(shadowed, "addLombokNotesToEclipseAboutDialog", String.class, String.class);
            POST_COMPILER_BYTES_STRING = Util.findMethod(shadowed, "runPostCompiler", byte[].class, String.class);
            POST_COMPILER_OUTPUTSTREAM = Util.findMethod(shadowed, "runPostCompiler", OutputStream.class);
            POST_COMPILER_BUFFEREDOUTPUTSTREAM_STRING_STRING = Util.findMethod(shadowed, "runPostCompiler", BufferedOutputStream.class, String.class, String.class);
        }

        public static String addLombokNotesToEclipseAboutDialog(String origReturnValue, String key) {
            try {
                return (String) Util.invokeMethod(ADD_LOMBOK_NOTES, origReturnValue, key);
            } catch (Throwable unused) {
                return origReturnValue;
            }
        }

        public static byte[] runPostCompiler(byte[] bytes, String fileName) {
            return (byte[]) Util.invokeMethod(POST_COMPILER_BYTES_STRING, bytes, fileName);
        }

        public static OutputStream runPostCompiler(OutputStream out) throws IOException {
            return (OutputStream) Util.invokeMethod(POST_COMPILER_OUTPUTSTREAM, out);
        }

        public static BufferedOutputStream runPostCompiler(BufferedOutputStream out, String path, String name) throws IOException {
            return (BufferedOutputStream) Util.invokeMethod(POST_COMPILER_BUFFEREDOUTPUTSTREAM_STRING_STRING, out, path, name);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      classes3.dex
     */
    /* loaded from: xp_Montecarlo-benchEdward.apk:Class50/lombok/launch/PatchFixesHider$Transform.SCL.lombok */
    public static final class Transform {
        private static final Method TRANSFORM;
        private static final Method TRANSFORM_SWAPPED;

        static {
            Class<?> shadowed = Util.shadowLoadClass("lombok.eclipse.TransformEclipseAST");
            TRANSFORM = Util.findMethod(shadowed, "transform", Parser.class, CompilationUnitDeclaration.class);
            TRANSFORM_SWAPPED = Util.findMethod(shadowed, "transform_swapped", CompilationUnitDeclaration.class, Parser.class);
        }

        public static void transform(Parser parser, CompilationUnitDeclaration ast) throws IOException {
            Util.invokeMethod(TRANSFORM, parser, ast);
        }

        public static void transform_swapped(CompilationUnitDeclaration ast, Parser parser) throws IOException {
            Util.invokeMethod(TRANSFORM_SWAPPED, ast, parser);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      classes3.dex
     */
    /* loaded from: xp_Montecarlo-benchEdward.apk:Class50/lombok/launch/PatchFixesHider$Delegate.SCL.lombok */
    public static final class Delegate {
        private static final Method HANDLE_DELEGATE_FOR_TYPE = null;
        private static final Method GET_CHILDREN = null;

        /* JADX WARN: Multi-variable type inference failed */
        public Delegate() {
            super/*android.animation.ObjectAnimator*/.cancel();
            return;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [android.animation.Animator, android.animation.Animator[]] */
        /* JADX WARN: Type inference failed for: r0v3, types: [void, java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r0v5, types: [void, java.lang.reflect.Method] */
        static String getOtherJavaStackTrace(Thread thread) {
            ?? loadAnimator = AnimatorInflater.loadAnimator("lombok.eclipse.agent.PatchDelegatePortal", "lombok.eclipse.agent.PatchDelegatePortal");
            new Class[1][0] = Object.class;
            HANDLE_DELEGATE_FOR_TYPE = AnimatorSet.playTogether((Animator[]) loadAnimator);
            Class[] clsArr = {Object.class, Object.class};
            GET_CHILDREN = AnimatorSet.playTogether((Animator[]) loadAnimator);
            return;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.animation.ObjectAnimator, java.lang.Boolean, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v3, types: [void, long] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.String] */
        public static long getThreadNativePeerValue(Thread thread) {
            ?? r0 = (Boolean) ObjectAnimator.ofInt(HANDLE_DELEGATE_FOR_TYPE, (String) new Object[]{thread}, (int[]) null);
            return r0.setPropertyName(r0);
        }

        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('javaElement' java.lang.Object)]), block:B:2:0x0000 */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object[], long] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.String] */
        public static long getUsableSpace(String str) {
            Object javaElement;
            return (Object[]) ObjectAnimator.ofInt(GET_CHILDREN, (String) new Object[]{str, javaElement}, 1);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      classes3.dex
     */
    /* loaded from: xp_Montecarlo-benchEdward.apk:Class50/lombok/launch/PatchFixesHider$ValPortal.SCL.lombok */
    public static final class ValPortal {
        private static final Method COPY_INITIALIZATION_OF_FOR_EACH_ITERABLE;
        private static final Method COPY_INITIALIZATION_OF_LOCAL_DECLARATION;
        private static final Method ADD_FINAL_AND_VAL_ANNOTATION_TO_VARIABLE_DECLARATION_STATEMENT;
        private static final Method ADD_FINAL_AND_VAL_ANNOTATION_TO_SINGLE_VARIABLE_DECLARATION;

        static {
            Class<?> shadowed = Util.shadowLoadClass("lombok.eclipse.agent.PatchValEclipsePortal");
            COPY_INITIALIZATION_OF_FOR_EACH_ITERABLE = Util.findMethod(shadowed, "copyInitializationOfForEachIterable", Object.class);
            COPY_INITIALIZATION_OF_LOCAL_DECLARATION = Util.findMethod(shadowed, "copyInitializationOfLocalDeclaration", Object.class);
            ADD_FINAL_AND_VAL_ANNOTATION_TO_VARIABLE_DECLARATION_STATEMENT = Util.findMethod(shadowed, "addFinalAndValAnnotationToVariableDeclarationStatement", Object.class, Object.class, Object.class);
            ADD_FINAL_AND_VAL_ANNOTATION_TO_SINGLE_VARIABLE_DECLARATION = Util.findMethod(shadowed, "addFinalAndValAnnotationToSingleVariableDeclaration", Object.class, Object.class, Object.class);
        }

        public static void copyInitializationOfForEachIterable(Object parser) {
            Util.invokeMethod(COPY_INITIALIZATION_OF_FOR_EACH_ITERABLE, parser);
        }

        public static void copyInitializationOfLocalDeclaration(Object parser) {
            Util.invokeMethod(COPY_INITIALIZATION_OF_LOCAL_DECLARATION, parser);
        }

        public static void addFinalAndValAnnotationToVariableDeclarationStatement(Object converter, Object out, Object in) {
            Util.invokeMethod(ADD_FINAL_AND_VAL_ANNOTATION_TO_VARIABLE_DECLARATION_STATEMENT, converter, out, in);
        }

        public static void addFinalAndValAnnotationToSingleVariableDeclaration(Object converter, Object out, Object in) {
            Util.invokeMethod(ADD_FINAL_AND_VAL_ANNOTATION_TO_SINGLE_VARIABLE_DECLARATION, converter, out, in);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      classes3.dex
     */
    /* loaded from: xp_Montecarlo-benchEdward.apk:Class50/lombok/launch/PatchFixesHider$Val.SCL.lombok */
    public static final class Val {
        private static final Method SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED;
        private static final Method SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED2;
        private static final Method HANDLE_VAL_FOR_LOCAL_DECLARATION;
        private static final Method HANDLE_VAL_FOR_FOR_EACH;

        static {
            Class<?> shadowed = Util.shadowLoadClass("lombok.eclipse.agent.PatchVal");
            SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED = Util.findMethod(shadowed, "skipResolveInitializerIfAlreadyCalled", Expression.class, BlockScope.class);
            SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED2 = Util.findMethod(shadowed, "skipResolveInitializerIfAlreadyCalled2", Expression.class, BlockScope.class, LocalDeclaration.class);
            HANDLE_VAL_FOR_LOCAL_DECLARATION = Util.findMethod(shadowed, "handleValForLocalDeclaration", LocalDeclaration.class, BlockScope.class);
            HANDLE_VAL_FOR_FOR_EACH = Util.findMethod(shadowed, "handleValForForEach", ForeachStatement.class, BlockScope.class);
        }

        public static TypeBinding skipResolveInitializerIfAlreadyCalled(Expression expr, BlockScope scope) {
            return (TypeBinding) Util.invokeMethod(SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED, expr, scope);
        }

        public static TypeBinding skipResolveInitializerIfAlreadyCalled2(Expression expr, BlockScope scope, LocalDeclaration decl) {
            return (TypeBinding) Util.invokeMethod(SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED2, expr, scope, decl);
        }

        public static boolean handleValForLocalDeclaration(LocalDeclaration local, BlockScope scope) {
            return ((Boolean) Util.invokeMethod(HANDLE_VAL_FOR_LOCAL_DECLARATION, local, scope)).booleanValue();
        }

        public static boolean handleValForForEach(ForeachStatement forEach, BlockScope scope) {
            return ((Boolean) Util.invokeMethod(HANDLE_VAL_FOR_FOR_EACH, forEach, scope)).booleanValue();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      classes3.dex
     */
    /* loaded from: xp_Montecarlo-benchEdward.apk:Class50/lombok/launch/PatchFixesHider$ExtensionMethod.SCL.lombok */
    public static final class ExtensionMethod {
        private static final Method RESOLVE_TYPE = null;
        private static final Method ERROR_NO_METHOD_FOR = null;
        private static final Method INVALID_METHOD = null;
        private static final Method INVALID_METHOD2 = null;
        private static final Method NON_STATIC_ACCESS_TO_STATIC_METHOD = null;

        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
            	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
            	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:136)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
            */
        public ExtensionMethod(int r3) {
            /*
                r2 = this;
                r0 = r2
                super/*android.app.Application*/.getPackageName()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: lombok.launch.PatchFixesHider.ExtensionMethod.satellites(int):com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation");
        }

        /*  JADX ERROR: IllegalArgumentException in pass: ConstructorVisitor
            java.lang.IllegalArgumentException: Illegal Capacity: -1
            	at java.base/java.util.ArrayList.<init>(ArrayList.java:160)
            	at jadx.core.dex.nodes.InsnNode.<init>(InsnNode.java:37)
            	at jadx.core.dex.instructions.BaseInvokeNode.<init>(BaseInvokeNode.java:11)
            	at jadx.core.dex.instructions.mods.ConstructorInsn.<init>(ConstructorInsn.java:28)
            	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:66)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:53)
            	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:36)
            */
        static int satellites() {
            /*
                Method dump skipped, instructions count: 162
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: lombok.launch.PatchFixesHider.ExtensionMethod.satellites():int");
        }

        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0009: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('resolvedType' org.eclipse.jdt.internal.compiler.lookup.TypeBinding)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('methodCall' org.eclipse.jdt.internal.compiler.ast.MessageSend)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 8, insn: 0x0011: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('scope' org.eclipse.jdt.internal.compiler.lookup.BlockScope)])
        , block:B:2:0x0000 */
        /* JADX WARN: Type inference failed for: r0v1, types: [void] */
        /* JADX WARN: Type inference failed for: r0v2, types: [org.eclipse.jdt.internal.compiler.lookup.TypeBinding, void] */
        public static void seal() {
            TypeBinding resolvedType;
            MessageSend methodCall;
            BlockScope scope;
            Method method = RESOLVE_TYPE;
            Object[] objArr = {resolvedType, methodCall, scope};
        }

        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0009: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('problemReporter' org.eclipse.jdt.internal.compiler.problem.ProblemReporter)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('messageSend' org.eclipse.jdt.internal.compiler.ast.MessageSend)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 8, insn: 0x0011: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('recType' org.eclipse.jdt.internal.compiler.lookup.TypeBinding)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 9, insn: 0x0015: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('params' org.eclipse.jdt.internal.compiler.lookup.TypeBinding[])])
        , block:B:2:0x0000 */
        public static int sourceType() {
            ProblemReporter problemReporter;
            MessageSend messageSend;
            TypeBinding recType;
            TypeBinding[] params;
            Method method = ERROR_NO_METHOD_FOR;
            Object[] objArr = {problemReporter, messageSend, recType, params};
            Application.onLowMemory();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('messageSend' org.eclipse.jdt.internal.compiler.ast.MessageSend)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 8, insn: 0x0011: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('method' org.eclipse.jdt.internal.compiler.lookup.MethodBinding)])
        , block:B:2:0x0000 */
        public static ILocation sourceType(int i) {
            MessageSend messageSend;
            MethodBinding method;
            Method method2 = INVALID_METHOD;
            Object[] objArr = {i, messageSend, method};
            Application.onLowMemory();
            return;
        }

        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0009: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('problemReporter' org.eclipse.jdt.internal.compiler.problem.ProblemReporter)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('messageSend' org.eclipse.jdt.internal.compiler.ast.MessageSend)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 8, insn: 0x0011: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('method' org.eclipse.jdt.internal.compiler.lookup.MethodBinding)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 9, insn: 0x0015: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('scope' org.eclipse.jdt.internal.compiler.lookup.Scope)])
        , block:B:2:0x0000 */
        public static float speed() {
            ProblemReporter problemReporter;
            MessageSend messageSend;
            MethodBinding method;
            Scope scope;
            Method method2 = INVALID_METHOD2;
            Object[] objArr = {problemReporter, messageSend, method, scope};
            Application.onLowMemory();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('location' org.eclipse.jdt.internal.compiler.ast.ASTNode)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 8, insn: 0x0011: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('method' org.eclipse.jdt.internal.compiler.lookup.MethodBinding)])
        , block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 9, insn: 0x0015: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('messageSend' org.eclipse.jdt.internal.compiler.ast.MessageSend)])
        , block:B:2:0x0000 */
        public static LocationImpl speed(float f) {
            ASTNode location;
            MethodBinding method;
            MessageSend messageSend;
            Method method2 = NON_STATIC_ACCESS_TO_STATIC_METHOD;
            Object[] objArr = {f, location, method, messageSend};
            Application.onLowMemory();
            return;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      classes3.dex
     */
    /* loaded from: xp_Montecarlo-benchEdward.apk:Class50/lombok/launch/PatchFixesHider$Javadoc.SCL.lombok */
    public static final class Javadoc {
        private static final Method GET_HTML = null;
        private static final Method PRINT_METHOD = null;

        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
            	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
            	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:136)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
            */
        public Javadoc(java.lang.Throwable r3) {
            /*
                r2 = this;
                r0 = r2
                super/*android.app.Activity*/.getApplication()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: lombok.launch.PatchFixesHider.Javadoc.onError(java.lang.Throwable):void");
        }

        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 8
            	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
            	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:136)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
            */
        /* renamed from: <init>  reason: not valid java name */
        static void m252init(
        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 8
            	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
            	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:28)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:136)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
            */
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:227)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:222)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:167)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:372)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            */

        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('member' org.eclipse.jdt.core.IJavaElement)]), block:B:2:0x0000 */
        /* JADX WARN: Type inference failed for: r0v0, types: [int, java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String, void] */
        public static void onSubscribe(Disposable disposable) {
            IJavaElement member;
            Object[] objArr = {disposable, member};
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 7, insn: 0x000d: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('tab' int)]), block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 8, insn: 0x0014: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('output' java.lang.StringBuffer)]), block:B:2:0x0000 */
        /* JADX WARN: Not initialized variable reg: 9, insn: 0x0018: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
          (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('type' org.eclipse.jdt.internal.compiler.ast.TypeDeclaration)])
        , block:B:2:0x0000 */
        /* JADX WARN: Type inference failed for: r0v0, types: [int, java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.StringBuffer, void] */
        /* JADX WARN: Type inference failed for: r4v2, types: [void] */
        /* JADX WARN: Type inference failed for: r7v0, types: [android.content.Intent, int] */
        public static void onSuccess(Object obj) {
            ?? r7;
            StringBuffer output;
            TypeDeclaration type;
            ?? r0 = PRINT_METHOD;
            Object[] objArr = {obj, Activity.startActivityForResult(r7, r7), output, type};
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      classes3.dex
     */
    /* loaded from: xp_Montecarlo-benchEdward.apk:Class50/lombok/launch/PatchFixesHider$PatchFixes.SCL.lombok */
    public static final class PatchFixes {
        public static final int ALREADY_PROCESSED_FLAG = 8388608;

        public static boolean isGenerated(org.eclipse.jdt.core.dom.ASTNode node) {
            boolean result = false;
            try {
                result = ((Boolean) node.getClass().getField("$isGenerated").get(node)).booleanValue();
                if (!result && node.getParent() != null && (node.getParent() instanceof QualifiedName)) {
                    result = isGenerated(node.getParent());
                }
            } catch (Exception unused) {
            }
            return result;
        }

        public static boolean isGenerated(ASTNode node) {
            boolean result = false;
            try {
                result = node.getClass().getField("$generatedBy").get(node) != null;
            } catch (Exception unused) {
            }
            return result;
        }

        public static boolean isListRewriteOnGeneratedNode(ListRewrite rewrite) {
            return isGenerated(rewrite.getParent());
        }

        public static boolean returnFalse(Object object) {
            return false;
        }

        public static boolean returnTrue(Object object) {
            return true;
        }

        public static List removeGeneratedNodes(List list) {
            try {
                List realNodes = new ArrayList(list.size());
                for (Object node : list) {
                    if (!isGenerated((org.eclipse.jdt.core.dom.ASTNode) node)) {
                        realNodes.add(node);
                    }
                }
                return realNodes;
            } catch (Exception unused) {
                return list;
            }
        }

        public static String getRealMethodDeclarationSource(String original, Object processor, MethodDeclaration declaration) throws Exception {
            if (isGenerated((org.eclipse.jdt.core.dom.ASTNode) declaration)) {
                List<Annotation> annotations = new ArrayList<>();
                for (Object modifier : declaration.modifiers()) {
                    if (modifier instanceof Annotation) {
                        Annotation annotation = (Annotation) modifier;
                        String qualifiedAnnotationName = annotation.resolveTypeBinding().getQualifiedName();
                        if (!"java.lang.Override".equals(qualifiedAnnotationName) && !"java.lang.SuppressWarnings".equals(qualifiedAnnotationName)) {
                            annotations.add(annotation);
                        }
                    }
                }
                StringBuilder signature = new StringBuilder();
                addAnnotations(annotations, signature);
                if (((Boolean) processor.getClass().getDeclaredField("fPublic").get(processor)).booleanValue()) {
                    signature.append("public ");
                }
                if (((Boolean) processor.getClass().getDeclaredField("fAbstract").get(processor)).booleanValue()) {
                    signature.append("abstract ");
                }
                signature.append(declaration.getReturnType2().toString()).append(" ").append(declaration.getName().getFullyQualifiedName()).append("(");
                boolean first = true;
                for (Object parameter : declaration.parameters()) {
                    if (!first) {
                        signature.append(", ");
                    }
                    first = false;
                    signature.append(parameter);
                }
                signature.append(");");
                return signature.toString();
            }
            return original;
        }

        public static void addAnnotations(List<Annotation> annotations, StringBuilder signature) {
            Iterator<Annotation> it = annotations.iterator();
            while (it.hasNext()) {
                SingleMemberAnnotation singleMemberAnnotation = (Annotation) it.next();
                List<String> values = new ArrayList<>();
                if (singleMemberAnnotation.isSingleMemberAnnotation()) {
                    SingleMemberAnnotation smAnn = singleMemberAnnotation;
                    values.add(smAnn.getValue().toString());
                } else if (singleMemberAnnotation.isNormalAnnotation()) {
                    NormalAnnotation normalAnn = (NormalAnnotation) singleMemberAnnotation;
                    for (Object value : normalAnn.values()) {
                        values.add(value.toString());
                    }
                }
                signature.append("@").append(singleMemberAnnotation.resolveTypeBinding().getQualifiedName());
                if (!values.isEmpty()) {
                    signature.append("(");
                    boolean first = true;
                    for (String string : values) {
                        if (!first) {
                            signature.append(", ");
                        }
                        first = false;
                        signature.append('\"').append(string).append('\"');
                    }
                    signature.append(")");
                }
                signature.append(" ");
            }
        }

        public static MethodDeclaration getRealMethodDeclarationNode(IMethod sourceMethod, CompilationUnit cuUnit) throws JavaModelException {
            AbstractTypeDeclaration typeDeclaration;
            MethodDeclaration methodDeclarationNode = ASTNodeSearchUtil.getMethodDeclarationNode(sourceMethod, cuUnit);
            if (isGenerated((org.eclipse.jdt.core.dom.ASTNode) methodDeclarationNode)) {
                Stack<IType> typeStack = new Stack<>();
                for (IType declaringType = sourceMethod.getDeclaringType(); declaringType != null; declaringType = declaringType.getDeclaringType()) {
                    typeStack.push(declaringType);
                }
                IType rootType = typeStack.pop();
                AbstractTypeDeclaration findTypeDeclaration = findTypeDeclaration(rootType, cuUnit.types());
                while (true) {
                    typeDeclaration = findTypeDeclaration;
                    if (typeStack.isEmpty() || typeDeclaration == null) {
                        break;
                    }
                    findTypeDeclaration = findTypeDeclaration(typeStack.pop(), typeDeclaration.bodyDeclarations());
                }
                if (typeStack.isEmpty() && typeDeclaration != null) {
                    String methodName = sourceMethod.getElementName();
                    for (Object declaration : typeDeclaration.bodyDeclarations()) {
                        if (declaration instanceof MethodDeclaration) {
                            MethodDeclaration methodDeclaration = (MethodDeclaration) declaration;
                            if (methodDeclaration.getName().toString().equals(methodName)) {
                                return methodDeclaration;
                            }
                        }
                    }
                }
            }
            return methodDeclarationNode;
        }

        public static AbstractTypeDeclaration findTypeDeclaration(IType searchType, List<?> nodes) {
            for (Object object : nodes) {
                if (object instanceof AbstractTypeDeclaration) {
                    AbstractTypeDeclaration typeDeclaration = (AbstractTypeDeclaration) object;
                    if (typeDeclaration.getName().toString().equals(searchType.getElementName())) {
                        return typeDeclaration;
                    }
                }
            }
            return null;
        }

        public static int getSourceEndFixed(int sourceEnd, ASTNode node) throws Exception {
            ASTNode object;
            if (sourceEnd == -1 && (object = (ASTNode) node.getClass().getField("$generatedBy").get(node)) != null) {
                return object.sourceEnd;
            }
            return sourceEnd;
        }

        public static int fixRetrieveStartingCatchPosition(int original, int start) {
            return original == -1 ? start : original;
        }

        public static int fixRetrieveIdentifierEndPosition(int original, int start, int end) {
            if (original != -1 && original >= start) {
                return original;
            }
            return end;
        }

        public static int fixRetrieveEllipsisStartPosition(int original, int end) {
            return original == -1 ? end : original;
        }

        public static int fixRetrieveStartBlockPosition(int original, int start) {
            return original == -1 ? start : original;
        }

        public static int fixRetrieveRightBraceOrSemiColonPosition(int original, int end) {
            return original == -1 ? end : original;
        }

        public static int fixRetrieveRightBraceOrSemiColonPosition(int retVal, AbstractMethodDeclaration amd) {
            if (retVal != -1 || amd == null) {
                return retVal;
            }
            boolean isGenerated = EcjAugments.ASTNode_generatedBy.get(amd) != null;
            if (isGenerated) {
                return amd.declarationSourceEnd;
            }
            return -1;
        }

        public static int fixRetrieveRightBraceOrSemiColonPosition(int retVal, FieldDeclaration fd) {
            if (retVal != -1 || fd == null) {
                return retVal;
            }
            boolean isGenerated = EcjAugments.ASTNode_generatedBy.get(fd) != null;
            if (isGenerated) {
                return fd.declarationSourceEnd;
            }
            return -1;
        }

        public static int fixRetrieveProperRightBracketPosition(int retVal, Type type) {
            if (retVal != -1 || type == null) {
                return retVal;
            }
            if (isGenerated((org.eclipse.jdt.core.dom.ASTNode) type)) {
                return (type.getStartPosition() + type.getLength()) - 1;
            }
            return -1;
        }

        public static boolean checkBit24(Object node) throws Exception {
            int bits = ((Integer) node.getClass().getField("bits").get(node)).intValue();
            return (bits & 8388608) != 0;
        }

        public static boolean skipRewritingGeneratedNodes(org.eclipse.jdt.core.dom.ASTNode node) throws Exception {
            return ((Boolean) node.getClass().getField("$isGenerated").get(node)).booleanValue();
        }

        public static void setIsGeneratedFlag(org.eclipse.jdt.core.dom.ASTNode domNode, ASTNode internalNode) throws Exception {
            if (internalNode == null || domNode == null) {
                return;
            }
            boolean isGenerated = EcjAugments.ASTNode_generatedBy.get(internalNode) != null;
            if (isGenerated) {
                domNode.getClass().getField("$isGenerated").set(domNode, true);
            }
        }

        public static void setIsGeneratedFlagForName(Name name, Object internalNode) throws Exception {
            if (internalNode instanceof ASTNode) {
                boolean isGenerated = EcjAugments.ASTNode_generatedBy.get((ASTNode) internalNode) != null;
                if (isGenerated) {
                    name.getClass().getField("$isGenerated").set(name, true);
                }
            }
        }

        public static RewriteEvent[] listRewriteHandleGeneratedMethods(RewriteEvent parent) {
            RewriteEvent[] children = parent.getChildren();
            List<RewriteEvent> newChildren = new ArrayList<>();
            List<RewriteEvent> modifiedChildren = new ArrayList<>();
            for (RewriteEvent child : children) {
                boolean isGenerated = isGenerated((org.eclipse.jdt.core.dom.ASTNode) child.getOriginalValue());
                if (isGenerated) {
                    boolean isReplacedOrRemoved = child.getChangeKind() == 4 || child.getChangeKind() == 2;
                    boolean convertingFromMethod = child.getOriginalValue() instanceof MethodDeclaration;
                    if (isReplacedOrRemoved && convertingFromMethod && child.getNewValue() != null) {
                        modifiedChildren.add(new NodeRewriteEvent((Object) null, child.getNewValue()));
                    }
                } else {
                    newChildren.add(child);
                }
            }
            newChildren.addAll(modifiedChildren);
            return (RewriteEvent[]) newChildren.toArray(new RewriteEvent[0]);
        }

        public static int getTokenEndOffsetFixed(TokenScanner scanner, int token, int startOffset, Object domNode) throws CoreException {
            boolean isGenerated = false;
            try {
                isGenerated = ((Boolean) domNode.getClass().getField("$isGenerated").get(domNode)).booleanValue();
            } catch (Exception unused) {
            }
            if (isGenerated) {
                return -1;
            }
            return scanner.getTokenEndOffset(token, startOffset);
        }

        public static IMethod[] removeGeneratedMethods(IMethod[] methods) throws Exception {
            List<IMethod> result = new ArrayList<>();
            for (IMethod m : methods) {
                if (m.getNameRange().getLength() > 0 && !m.getNameRange().equals(m.getSourceRange())) {
                    result.add(m);
                }
            }
            return result.size() == methods.length ? methods : (IMethod[]) result.toArray(new IMethod[0]);
        }

        public static SearchMatch[] removeGenerated(SearchMatch[] returnValue) {
            int j;
            List<SearchMatch> result = new ArrayList<>();
            for (SearchMatch searchResult : returnValue) {
                if (searchResult.getElement() instanceof IField) {
                    IField field = (IField) searchResult.getElement();
                    IAnnotation annotation = field.getAnnotation("Generated");
                    j = annotation != null ? j + 1 : 0;
                }
                result.add(searchResult);
            }
            return (SearchMatch[]) result.toArray(new SearchMatch[0]);
        }

        public static SearchResultGroup[] createFakeSearchResult(SearchResultGroup[] returnValue, Object processor) throws Exception {
            Field declaredField;
            if ((returnValue == null || returnValue.length == 0) && (declaredField = processor.getClass().getDeclaredField("fField")) != null) {
                declaredField.setAccessible(true);
                SourceField fField = (SourceField) declaredField.get(processor);
                IAnnotation dataAnnotation = fField.getDeclaringType().getAnnotation("Data");
                if (dataAnnotation != null) {
                    return new SearchResultGroup[]{new SearchResultGroup((IResource) null, new SearchMatch[1])};
                }
            }
            return returnValue;
        }

        public static SimpleName[] removeGeneratedSimpleNames(SimpleName[] in) throws Exception {
            Field f = SimpleName.class.getField("$isGenerated");
            int count = 0;
            for (int i = 0; i < in.length; i++) {
                if (in[i] == null || !((Boolean) f.get(in[i])).booleanValue()) {
                    count++;
                }
            }
            if (count == in.length) {
                return in;
            }
            SimpleName[] newSimpleNames = new SimpleName[count];
            int count2 = 0;
            for (int i2 = 0; i2 < in.length; i2++) {
                if (in[i2] == null || !((Boolean) f.get(in[i2])).booleanValue()) {
                    int i3 = count2;
                    count2++;
                    newSimpleNames[i3] = in[i2];
                }
            }
            return newSimpleNames;
        }

        public static org.eclipse.jdt.internal.compiler.ast.Annotation[] convertAnnotations(org.eclipse.jdt.internal.compiler.ast.Annotation[] out, IAnnotatable annotatable) {
            try {
                IAnnotation[] in = annotatable.getAnnotations();
                if (out == null) {
                    return null;
                }
                int toWrite = 0;
                for (int idx = 0; idx < out.length; idx++) {
                    String oName = new String(out[idx].type.getLastToken());
                    boolean found = false;
                    int length = in.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        IAnnotation i2 = in[i];
                        String name = i2.getElementName();
                        int li = name.lastIndexOf(46);
                        if (li > -1) {
                            name = name.substring(li + 1);
                        }
                        if (!name.equals(oName)) {
                            i++;
                        } else {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        toWrite++;
                    } else {
                        out[idx] = null;
                    }
                }
                org.eclipse.jdt.internal.compiler.ast.Annotation[] replace = out;
                if (toWrite < out.length) {
                    replace = new org.eclipse.jdt.internal.compiler.ast.Annotation[toWrite];
                    int idx2 = 0;
                    for (int i3 = 0; i3 < out.length; i3++) {
                        if (out[i3] != null) {
                            int i4 = idx2;
                            idx2++;
                            replace[i4] = out[i3];
                        }
                    }
                }
                return replace;
            } catch (Exception unused) {
                return out;
            }
        }
    }
}
