package lombok.eclipse.agent;

import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import lombok.Lombok;
import lombok.permit.Permit;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractVariableDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.parser.Parser;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/agent/PatchValEclipse.SCL.lombok */
public class PatchValEclipse {
    private static final Field FIELD_NAME_INDEX;

    public static void copyInitializationOfForEachIterable(Parser parser) {
        try {
            ForeachStatement[] foreachStatementArr = (ASTNode[]) Reflection.astStackField.get(parser);
            int astPtr = ((Integer) Reflection.astPtrField.get(parser)).intValue();
            ForeachStatement foreachDecl = foreachStatementArr[astPtr];
            Expression expression = foreachDecl.collection;
            if (expression == null) {
                return;
            }
            boolean val = couldBeVal(parser == null ? null : parser.compilationUnit == null ? null : parser.compilationUnit.imports, foreachDecl.elementVariable.type);
            boolean var = couldBeVar(parser == null ? null : parser.compilationUnit == null ? null : parser.compilationUnit.imports, foreachDecl.elementVariable.type);
            if (foreachDecl.elementVariable != null) {
                if (val || var) {
                    try {
                        if (Reflection.iterableCopyField == null) {
                            return;
                        }
                        Reflection.iterableCopyField.set(foreachDecl.elementVariable, expression);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static void copyInitializationOfLocalDeclaration(Parser parser) {
        Expression expression;
        try {
            AbstractVariableDeclaration[] abstractVariableDeclarationArr = (ASTNode[]) Reflection.astStackField.get(parser);
            int astPtr = ((Integer) Reflection.astPtrField.get(parser)).intValue();
            AbstractVariableDeclaration variableDecl = abstractVariableDeclarationArr[astPtr];
            if ((variableDecl instanceof LocalDeclaration) && (expression = variableDecl.initialization) != null) {
                boolean val = couldBeVal(parser == null ? null : parser.compilationUnit == null ? null : parser.compilationUnit.imports, variableDecl.type);
                boolean var = couldBeVar(parser == null ? null : parser.compilationUnit == null ? null : parser.compilationUnit.imports, variableDecl.type);
                if (val || var) {
                    try {
                        if (Reflection.initCopyField == null) {
                            return;
                        }
                        Reflection.initCopyField.set(variableDecl, expression);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    private static boolean couldBeVal(ImportReference[] imports, TypeReference type) {
        return PatchVal.couldBe(imports, "lombok.val", type);
    }

    private static boolean couldBeVar(ImportReference[] imports, TypeReference type) {
        return PatchVal.couldBe(imports, "lombok.experimental.var", type) || PatchVal.couldBe(imports, "lombok.var", type);
    }

    public static void addFinalAndValAnnotationToSingleVariableDeclaration(Object converter, SingleVariableDeclaration out, LocalDeclaration in) {
        List<IExtendedModifier> modifiers = out.modifiers();
        addFinalAndValAnnotationToModifierList(converter, modifiers, out.getAST(), in);
    }

    public static void addFinalAndValAnnotationToVariableDeclarationStatement(Object converter, VariableDeclarationStatement out, LocalDeclaration in) {
        List<IExtendedModifier> modifiers = out.modifiers();
        addFinalAndValAnnotationToModifierList(converter, modifiers, out.getAST(), in);
    }

    public static void addFinalAndValAnnotationToModifierList(Object converter, List<IExtendedModifier> modifiers, AST ast, LocalDeclaration in) {
        Annotation[] annotationArr;
        Name typeName;
        if (in.annotations == null) {
            return;
        }
        boolean found = false;
        Annotation valAnnotation = null;
        Annotation varAnnotation = null;
        for (Annotation ann : in.annotations) {
            if (couldBeVal(null, ann.type)) {
                found = true;
                valAnnotation = ann;
            }
            if (couldBeVar(null, ann.type)) {
                found = true;
                varAnnotation = ann;
            }
        }
        if (found && modifiers != null) {
            boolean finalIsPresent = false;
            boolean valIsPresent = false;
            boolean varIsPresent = false;
            for (Object present : modifiers) {
                if (present instanceof Modifier) {
                    Modifier.ModifierKeyword keyword = ((Modifier) present).getKeyword();
                    if (keyword != null) {
                        if (keyword.toFlagValue() == 16) {
                            finalIsPresent = true;
                        }
                    }
                }
                if ((present instanceof org.eclipse.jdt.core.dom.Annotation) && (typeName = ((org.eclipse.jdt.core.dom.Annotation) present).getTypeName()) != null) {
                    String fullyQualifiedName = typeName.getFullyQualifiedName();
                    valIsPresent = ("val".equals(fullyQualifiedName) || "lombok.val".equals(fullyQualifiedName)) ? true : true;
                    if ("var".equals(fullyQualifiedName) || "lombok.var".equals(fullyQualifiedName) || "lombok.experimental.var".equals(fullyQualifiedName)) {
                        varIsPresent = true;
                    }
                }
            }
            if (!finalIsPresent && valAnnotation != null) {
                modifiers.add(createModifier(ast, Modifier.ModifierKeyword.FINAL_KEYWORD, valAnnotation.sourceStart, valAnnotation.sourceEnd));
            }
            if (!valIsPresent && valAnnotation != null) {
                MarkerAnnotation newAnnotation = createValVarAnnotation(ast, valAnnotation, valAnnotation.sourceStart, valAnnotation.sourceEnd);
                try {
                    Reflection.astConverterRecordNodes.invoke(converter, newAnnotation, valAnnotation);
                    Reflection.astConverterRecordNodes.invoke(converter, newAnnotation.getTypeName(), valAnnotation.type);
                    modifiers.add(newAnnotation);
                } catch (IllegalAccessException e) {
                    throw Lombok.sneakyThrow(e);
                } catch (InvocationTargetException e2) {
                    throw Lombok.sneakyThrow(e2.getCause());
                }
            }
            if (!varIsPresent && varAnnotation != null) {
                MarkerAnnotation newAnnotation2 = createValVarAnnotation(ast, varAnnotation, varAnnotation.sourceStart, varAnnotation.sourceEnd);
                try {
                    Reflection.astConverterRecordNodes.invoke(converter, newAnnotation2, varAnnotation);
                    Reflection.astConverterRecordNodes.invoke(converter, newAnnotation2.getTypeName(), varAnnotation.type);
                    modifiers.add(newAnnotation2);
                } catch (IllegalAccessException e3) {
                    throw Lombok.sneakyThrow(e3);
                } catch (InvocationTargetException e4) {
                    throw Lombok.sneakyThrow(e4.getCause());
                }
            }
        }
    }

    public static Modifier createModifier(AST ast, Modifier.ModifierKeyword keyword, int start, int end) {
        try {
            Modifier modifier = (Modifier) Reflection.modifierConstructor.newInstance(ast);
            if (modifier != null) {
                modifier.setKeyword(keyword);
                modifier.setSourceRange(start, (end - start) + 1);
            }
            return modifier;
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (InstantiationException e2) {
            throw Lombok.sneakyThrow(e2);
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v62, types: [char[]] */
    public static MarkerAnnotation createValVarAnnotation(AST ast, Annotation original, int start, int end) {
        char[][] tokens;
        try {
            MarkerAnnotation out = (MarkerAnnotation) Reflection.markerAnnotationConstructor.newInstance(ast);
            if (original.type instanceof SingleTypeReference) {
                tokens = new char[]{original.type.token};
            } else if (original.type instanceof QualifiedTypeReference) {
                tokens = original.type.tokens;
            } else {
                return null;
            }
            if (out != null) {
                SimpleName valName = ast.newSimpleName(new String(tokens[tokens.length - 1]));
                valName.setSourceRange(start, (end - start) + 1);
                if (tokens.length == 1) {
                    out.setTypeName(valName);
                    setIndex(valName, 1);
                } else if (tokens.length == 2) {
                    SimpleName lombokName = ast.newSimpleName("lombok");
                    lombokName.setSourceRange(start, (end - start) + 1);
                    setIndex(lombokName, 1);
                    setIndex(valName, 2);
                    QualifiedName fullName = ast.newQualifiedName(lombokName, valName);
                    setIndex(fullName, 1);
                    fullName.setSourceRange(start, (end - start) + 1);
                    out.setTypeName(fullName);
                } else {
                    SimpleName lombokName2 = ast.newSimpleName("lombok");
                    lombokName2.setSourceRange(start, (end - start) + 1);
                    SimpleName experimentalName = ast.newSimpleName("experimental");
                    lombokName2.setSourceRange(start, (end - start) + 1);
                    setIndex(lombokName2, 1);
                    setIndex(experimentalName, 2);
                    setIndex(valName, 3);
                    QualifiedName lombokExperimentalName = ast.newQualifiedName(lombokName2, experimentalName);
                    lombokExperimentalName.setSourceRange(start, (end - start) + 1);
                    setIndex(lombokExperimentalName, 1);
                    QualifiedName fullName2 = ast.newQualifiedName(lombokExperimentalName, valName);
                    setIndex(fullName2, 1);
                    fullName2.setSourceRange(start, (end - start) + 1);
                    out.setTypeName(fullName2);
                }
                out.setSourceRange(start, (end - start) + 1);
            }
            return out;
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (InstantiationException e2) {
            throw Lombok.sneakyThrow(e2);
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3);
        }
    }

    static {
        Field f = null;
        try {
            f = Permit.getField(Name.class, CPSearchParam.PARAM_KEY_INDEX);
        } catch (Throwable unused) {
        }
        FIELD_NAME_INDEX = f;
    }

    private static void setIndex(Name name, int index) {
        try {
            if (FIELD_NAME_INDEX != null) {
                FIELD_NAME_INDEX.set(name, Integer.valueOf(index));
            }
        } catch (Exception unused) {
        }
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/eclipse/agent/PatchValEclipse$Reflection.SCL.lombok */
    public static final class Reflection {
        private static final Field initCopyField;
        private static final Field iterableCopyField;
        private static final Field astStackField;
        private static final Field astPtrField;
        private static final Constructor<Modifier> modifierConstructor;
        private static final Constructor<MarkerAnnotation> markerAnnotationConstructor;
        private static final Method astConverterRecordNodes;

        static {
            Field a = null;
            Field b = null;
            Field c = null;
            Field d = null;
            Constructor<Modifier> f = null;
            Constructor<MarkerAnnotation> g = null;
            Method h = null;
            try {
                a = Permit.getField(LocalDeclaration.class, "$initCopy");
                b = Permit.getField(LocalDeclaration.class, "$iterableCopy");
            } catch (Throwable unused) {
            }
            try {
                c = Permit.getField(Parser.class, "astStack");
                d = Permit.getField(Parser.class, "astPtr");
                f = Permit.getConstructor(Modifier.class, AST.class);
                g = Permit.getConstructor(MarkerAnnotation.class, AST.class);
                Class<?> z = Class.forName("org.eclipse.jdt.core.dom.ASTConverter");
                h = Permit.getMethod(z, "recordNodes", org.eclipse.jdt.core.dom.ASTNode.class, ASTNode.class);
            } catch (Throwable unused2) {
            }
            initCopyField = a;
            iterableCopyField = b;
            astStackField = c;
            astPtrField = d;
            modifierConstructor = f;
            markerAnnotationConstructor = g;
            astConverterRecordNodes = h;
        }
    }
}
