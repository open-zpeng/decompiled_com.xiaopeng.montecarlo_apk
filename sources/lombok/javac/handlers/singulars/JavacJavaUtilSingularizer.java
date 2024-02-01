package lombok.javac.handlers.singulars;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import lombok.javac.Javac;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
import lombok.javac.handlers.JavacHandlerUtil;
import lombok.javac.handlers.JavacSingularsRecipes;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/singulars/JavacJavaUtilSingularizer.SCL.lombok */
abstract class JavacJavaUtilSingularizer extends JavacSingularsRecipes.JavacSingularizer {
    /* JADX INFO: Access modifiers changed from: protected */
    public List<JCTree.JCStatement> createJavaUtilSetMapInitialCapacitySwitchStatements(JavacTreeMaker maker, JavacSingularsRecipes.SingularData data, JavacNode builderType, boolean mapMode, String emptyCollectionMethod, String singletonCollectionMethod, String targetType, JCTree source, String builderVariable) {
        List<JCTree.JCExpression> args;
        List<JCTree.JCExpression> jceBlank = List.nil();
        ListBuffer<JCTree.JCCase> cases = new ListBuffer<>();
        if (emptyCollectionMethod != null) {
            JCTree.JCCase emptyCase = maker.Case(maker.Literal(Javac.CTC_INT, 0), List.of(maker.Exec(maker.Assign(maker.Ident(data.getPluralName()), maker.Apply(jceBlank, JavacHandlerUtil.chainDots(builderType, "java", "util", "Collections", emptyCollectionMethod), jceBlank))), maker.Break(null)));
            cases.append(emptyCase);
        }
        if (singletonCollectionMethod != null) {
            JCTree.JCMethodInvocation Apply = maker.Apply(jceBlank, JavacHandlerUtil.chainDots(builderType, builderVariable, data.getPluralName() + (mapMode ? "$key" : ""), "get"), List.of(maker.Literal(Javac.CTC_INT, 0)));
            if (mapMode) {
                args = List.of(Apply, maker.Apply(jceBlank, JavacHandlerUtil.chainDots(builderType, builderVariable, data.getPluralName() + (mapMode ? "$value" : ""), "get"), List.of(maker.Literal(Javac.CTC_INT, 0))));
            } else {
                args = List.of(Apply);
            }
            JCTree.JCCase singletonCase = maker.Case(maker.Literal(Javac.CTC_INT, 1), List.of(maker.Exec(maker.Assign(maker.Ident(data.getPluralName()), maker.Apply(jceBlank, JavacHandlerUtil.chainDots(builderType, "java", "util", "Collections", singletonCollectionMethod), args))), maker.Break(null)));
            cases.append(singletonCase);
        }
        List<JCTree.JCStatement> statements = createJavaUtilSimpleCreationAndFillStatements(maker, data, builderType, mapMode, false, true, emptyCollectionMethod == null, targetType, source, builderVariable);
        JCTree.JCCase defaultCase = maker.Case(null, statements);
        cases.append(defaultCase);
        JCTree.JCSwitch Switch = maker.Switch(getSize(maker, builderType, mapMode ? builderType.toName(data.getPluralName() + "$key") : data.getPluralName(), true, false, builderVariable), cases.toList());
        JCTree.JCExpression localShadowerType = JavacHandlerUtil.chainDotsString(builderType, data.getTargetFqn());
        return List.of(maker.VarDef(maker.Modifiers(0L), data.getPluralName(), addTypeArgs(mapMode ? 2 : 1, false, builderType, localShadowerType, data.getTypeArgs(), source), null), Switch);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JCTree.JCStatement createConstructBuilderVarIfNeeded(JavacTreeMaker maker, JavacSingularsRecipes.SingularData data, JavacNode builderType, boolean mapMode, JCTree source) {
        JCTree.JCExpressionStatement jCExpressionStatement;
        List<JCTree.JCExpression> jceBlank = List.nil();
        Name v1Name = mapMode ? builderType.toName(data.getPluralName() + "$key") : data.getPluralName();
        Name v2Name = mapMode ? builderType.toName(data.getPluralName() + "$value") : null;
        JCTree.JCBinary Binary = maker.Binary(Javac.CTC_EQUAL, maker.Select(maker.Ident(builderType.toName("this")), v1Name), maker.Literal(Javac.CTC_BOT, null));
        JCTree.JCFieldAccess Select = maker.Select(maker.Ident(builderType.toName("this")), v1Name);
        JCTree.JCExpression v1Type = JavacHandlerUtil.chainDots(builderType, "java", "util", "ArrayList");
        JCTree.JCExpressionStatement Exec = maker.Exec(maker.Assign(Select, maker.NewClass(null, jceBlank, addTypeArgs(1, false, builderType, v1Type, data.getTypeArgs(), source), jceBlank, null)));
        if (mapMode) {
            JCTree.JCFieldAccess Select2 = maker.Select(maker.Ident(builderType.toName("this")), v2Name);
            JCTree.JCExpression v2Type = JavacHandlerUtil.chainDots(builderType, "java", "util", "ArrayList");
            List<JCTree.JCExpression> tArgs = data.getTypeArgs();
            jCExpressionStatement = maker.Block(0L, List.of(Exec, maker.Exec(maker.Assign(Select2, maker.NewClass(null, jceBlank, addTypeArgs(1, false, builderType, v2Type, (tArgs == null || tArgs.tail == null) ? List.nil() : tArgs.tail, source), jceBlank, null)))));
        } else {
            jCExpressionStatement = Exec;
        }
        return maker.If(Binary, jCExpressionStatement, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<JCTree.JCStatement> createJavaUtilSimpleCreationAndFillStatements(JavacTreeMaker maker, JavacSingularsRecipes.SingularData data, JavacNode builderType, boolean mapMode, boolean defineVar, boolean addInitialCapacityArg, boolean nullGuard, String targetType, JCTree source, String builderVariable) {
        JCTree.JCVariableDecl Exec;
        JCTree.JCForLoop Exec2;
        List<JCTree.JCExpression> jceBlank = List.nil();
        Name thisName = builderType.toName(builderVariable);
        List<JCTree.JCExpression> constructorArgs = List.nil();
        if (addInitialCapacityArg) {
            Name varName = mapMode ? builderType.toName(data.getPluralName() + "$key") : data.getPluralName();
            JCTree.JCBinary Binary = maker.Binary(Javac.CTC_LESS_THAN, getSize(maker, builderType, varName, nullGuard, true, builderVariable), maker.Literal(Javac.CTC_INT, 1073741824));
            JCTree.JCExpression integerMaxValue = JavacHandlerUtil.genJavaLangTypeRef(builderType, "Integer", "MAX_VALUE");
            constructorArgs = List.of(maker.Conditional(Binary, maker.Binary(Javac.CTC_PLUS, maker.Binary(Javac.CTC_PLUS, maker.Literal(Javac.CTC_INT, 1), getSize(maker, builderType, varName, nullGuard, true, builderVariable)), maker.Binary(Javac.CTC_DIV, maker.Parens(maker.Binary(Javac.CTC_MINUS, getSize(maker, builderType, varName, nullGuard, true, builderVariable), maker.Literal(Javac.CTC_INT, 3))), maker.Literal(Javac.CTC_INT, 3))), integerMaxValue));
        }
        JCTree.JCExpression targetTypeExpr = JavacHandlerUtil.chainDots(builderType, "java", "util", targetType);
        JCTree.JCNewClass NewClass = maker.NewClass(null, jceBlank, addTypeArgs(mapMode ? 2 : 1, false, builderType, targetTypeExpr, data.getTypeArgs(), source), constructorArgs, null);
        if (defineVar) {
            JCTree.JCExpression localShadowerType = JavacHandlerUtil.chainDotsString(builderType, data.getTargetFqn());
            Exec = maker.VarDef(maker.Modifiers(0L), data.getPluralName(), addTypeArgs(mapMode ? 2 : 1, false, builderType, localShadowerType, data.getTypeArgs(), source), NewClass);
        } else {
            Exec = maker.Exec(maker.Assign(maker.Ident(data.getPluralName()), NewClass));
        }
        if (mapMode) {
            Name ivar = builderType.toName("$i");
            Name keyVarName = builderType.toName(data.getPluralName() + "$key");
            Exec2 = maker.ForLoop(List.of(maker.VarDef(maker.Modifiers(0L), ivar, maker.TypeIdent(Javac.CTC_INT), maker.Literal(Javac.CTC_INT, 0))), maker.Binary(Javac.CTC_LESS_THAN, maker.Ident(ivar), getSize(maker, builderType, keyVarName, nullGuard, true, builderVariable)), List.of(maker.Exec(maker.Unary(Javac.CTC_POSTINC, maker.Ident(ivar)))), maker.Exec(maker.Apply(jceBlank, maker.Select(maker.Ident(data.getPluralName()), builderType.toName("put")), List.of(maker.Apply(jceBlank, JavacHandlerUtil.chainDots(builderType, builderVariable, data.getPluralName() + "$key", "get"), List.of(maker.Ident(ivar))), maker.TypeCast((JCTree) createTypeArgs(2, false, builderType, data.getTypeArgs(), source).get(1), maker.Apply(jceBlank, JavacHandlerUtil.chainDots(builderType, builderVariable, data.getPluralName() + "$value", "get"), List.of(maker.Ident(ivar))))))));
        } else {
            Exec2 = maker.Exec(maker.Apply(jceBlank, maker.Select(maker.Ident(data.getPluralName()), builderType.toName("addAll")), List.of(maker.Select(maker.Ident(thisName), data.getPluralName()))));
        }
        if (nullGuard) {
            Exec2 = maker.If(maker.Binary(Javac.CTC_NOT_EQUAL, maker.Select(maker.Ident(thisName), mapMode ? builderType.toName(data.getPluralName() + "$key") : data.getPluralName()), maker.Literal(Javac.CTC_BOT, null)), Exec2, null);
        }
        return List.of(Exec, Exec2, maker.Exec(maker.Assign(maker.Ident(data.getPluralName()), maker.Apply(jceBlank, JavacHandlerUtil.chainDots(builderType, "java", "util", "Collections", "unmodifiable" + data.getTargetSimpleType()), List.of(maker.Ident(data.getPluralName()))))));
    }
}
