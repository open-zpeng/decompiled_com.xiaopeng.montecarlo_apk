package lombok.javac.handlers.singulars;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.util.List;
import lombok.AccessLevel;
import lombok.core.LombokImmutableList;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;
import lombok.javac.handlers.JavacSingularsRecipes;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/handlers/singulars/JavacJavaUtilSetSingularizer.SCL.lombok */
public class JavacJavaUtilSetSingularizer extends JavacJavaUtilListSetSingularizer {
    @Override // lombok.javac.handlers.singulars.JavacJavaUtilListSetSingularizer, lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public /* bridge */ /* synthetic */ List generateFields(JavacSingularsRecipes.SingularData singularData, JavacNode javacNode, JCTree jCTree) {
        return super.generateFields(singularData, javacNode, jCTree);
    }

    @Override // lombok.javac.handlers.singulars.JavacJavaUtilListSetSingularizer, lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public /* bridge */ /* synthetic */ void generateMethods(CheckerFrameworkVersion checkerFrameworkVersion, JavacSingularsRecipes.SingularData singularData, boolean z, JavacNode javacNode, JCTree jCTree, boolean z2, JavacSingularsRecipes.ExpressionMaker expressionMaker, JavacSingularsRecipes.StatementMaker statementMaker, AccessLevel accessLevel) {
        super.generateMethods(checkerFrameworkVersion, singularData, z, javacNode, jCTree, z2, expressionMaker, statementMaker, accessLevel);
    }

    @Override // lombok.javac.handlers.singulars.JavacJavaUtilListSetSingularizer, lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public /* bridge */ /* synthetic */ List listFieldsToBeGenerated(JavacSingularsRecipes.SingularData singularData, JavacNode javacNode) {
        return super.listFieldsToBeGenerated(singularData, javacNode);
    }

    @Override // lombok.javac.handlers.singulars.JavacJavaUtilListSetSingularizer, lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public /* bridge */ /* synthetic */ List listMethodsToBeGenerated(JavacSingularsRecipes.SingularData singularData, JavacNode javacNode) {
        return super.listMethodsToBeGenerated(singularData, javacNode);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public LombokImmutableList<String> getSupportedTypes() {
        return LombokImmutableList.of("java.util.Set", "java.util.SortedSet", "java.util.NavigableSet");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public String getEmptyMaker(String target) {
        return target.endsWith("SortedSet") ? "java.util.Collections.emptySortedSet" : target.endsWith("NavigableSet") ? "java.util.Collections.emptyNavigableSet" : "java.util.Collections.emptySet";
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public void appendBuildCode(JavacSingularsRecipes.SingularData data, JavacNode builderType, JCTree source, ListBuffer<JCTree.JCStatement> statements, Name targetVariableName, String builderVariable) {
        JavacTreeMaker maker = builderType.getTreeMaker();
        if (data.getTargetFqn().equals("java.util.Set")) {
            statements.appendList(createJavaUtilSetMapInitialCapacitySwitchStatements(maker, data, builderType, false, "emptySet", "singleton", "LinkedHashSet", source, builderVariable));
        } else {
            statements.appendList(createJavaUtilSimpleCreationAndFillStatements(maker, data, builderType, false, true, false, true, "TreeSet", source, builderVariable));
        }
    }
}
