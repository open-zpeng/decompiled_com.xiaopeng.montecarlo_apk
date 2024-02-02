package lombok.eclipse.agent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lombok.Lombok;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/agent/PatchValEclipsePortal.SCL.lombok */
public class PatchValEclipsePortal {
    static final String LOCALDECLARATION_SIG = "org.eclipse.jdt.internal.compiler.ast.LocalDeclaration";
    static final String PARSER_SIG = "org.eclipse.jdt.internal.compiler.parser.Parser";
    static final String VARIABLEDECLARATIONSTATEMENT_SIG = "org.eclipse.jdt.core.dom.VariableDeclarationStatement";
    static final String SINGLEVARIABLEDECLARATION_SIG = "org.eclipse.jdt.core.dom.SingleVariableDeclaration";
    static final String ASTCONVERTER_SIG = "org.eclipse.jdt.core.dom.ASTConverter";

    public static void copyInitializationOfForEachIterable(Object parser) {
        try {
            Reflection.copyInitializationOfForEachIterable.invoke(null, parser);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(Reflection.problem);
                throw e2;
            }
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }

    public static void copyInitializationOfLocalDeclaration(Object parser) {
        try {
            Reflection.copyInitializationOfLocalDeclaration.invoke(null, parser);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(Reflection.problem);
                throw e2;
            }
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }

    public static void addFinalAndValAnnotationToVariableDeclarationStatement(Object converter, Object out, Object in) {
        try {
            Reflection.addFinalAndValAnnotationToVariableDeclarationStatement.invoke(null, converter, out, in);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(Reflection.problem);
                throw e2;
            }
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }

    public static void addFinalAndValAnnotationToSingleVariableDeclaration(Object converter, Object out, Object in) {
        try {
            Reflection.addFinalAndValAnnotationToSingleVariableDeclaration.invoke(null, converter, out, in);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(Reflection.problem);
                throw e2;
            }
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/agent/PatchValEclipsePortal$Reflection.SCL.lombok */
    private static final class Reflection {
        public static final Method copyInitializationOfForEachIterable;
        public static final Method copyInitializationOfLocalDeclaration;
        public static final Method addFinalAndValAnnotationToVariableDeclarationStatement;
        public static final Method addFinalAndValAnnotationToSingleVariableDeclaration;
        public static final Throwable problem;

        private Reflection() {
        }

        static {
            Method m = null;
            Method n = null;
            Method o = null;
            Method p = null;
            Throwable problem_ = null;
            try {
                m = PatchValEclipse.class.getMethod("copyInitializationOfForEachIterable", Class.forName(PatchValEclipsePortal.PARSER_SIG));
                n = PatchValEclipse.class.getMethod("copyInitializationOfLocalDeclaration", Class.forName(PatchValEclipsePortal.PARSER_SIG));
                o = PatchValEclipse.class.getMethod("addFinalAndValAnnotationToVariableDeclarationStatement", Object.class, Class.forName(PatchValEclipsePortal.VARIABLEDECLARATIONSTATEMENT_SIG), Class.forName(PatchValEclipsePortal.LOCALDECLARATION_SIG));
                p = PatchValEclipse.class.getMethod("addFinalAndValAnnotationToSingleVariableDeclaration", Object.class, Class.forName(PatchValEclipsePortal.SINGLEVARIABLEDECLARATION_SIG), Class.forName(PatchValEclipsePortal.LOCALDECLARATION_SIG));
            } catch (Throwable t) {
                problem_ = t;
            }
            copyInitializationOfForEachIterable = m;
            copyInitializationOfLocalDeclaration = n;
            addFinalAndValAnnotationToVariableDeclarationStatement = o;
            addFinalAndValAnnotationToSingleVariableDeclaration = p;
            problem = problem_;
        }
    }
}
