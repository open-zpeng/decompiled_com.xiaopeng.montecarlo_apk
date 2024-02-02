package lombok.javac.handlers.singulars;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.util.List;
import lombok.AccessLevel;
import lombok.core.LombokImmutableList;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.javac.JavacNode;
import lombok.javac.handlers.JavacSingularsRecipes;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/javac/handlers/singulars/JavacGuavaTableSingularizer.SCL.lombok */
public class JavacGuavaTableSingularizer extends JavacGuavaSingularizer {
    private static final LombokImmutableList<String> SUFFIXES = LombokImmutableList.of("rowKey", "columnKey", "value");
    private static final LombokImmutableList<String> SUPPORTED_TYPES = LombokImmutableList.of("com.google.common.collect.ImmutableTable");

    @Override // lombok.javac.handlers.singulars.JavacGuavaSingularizer, lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public /* bridge */ /* synthetic */ List generateFields(JavacSingularsRecipes.SingularData singularData, JavacNode javacNode, JCTree jCTree) {
        return super.generateFields(singularData, javacNode, jCTree);
    }

    @Override // lombok.javac.handlers.singulars.JavacGuavaSingularizer, lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public /* bridge */ /* synthetic */ void generateMethods(CheckerFrameworkVersion checkerFrameworkVersion, JavacSingularsRecipes.SingularData singularData, boolean z, JavacNode javacNode, JCTree jCTree, boolean z2, JavacSingularsRecipes.ExpressionMaker expressionMaker, JavacSingularsRecipes.StatementMaker statementMaker, AccessLevel accessLevel) {
        super.generateMethods(checkerFrameworkVersion, singularData, z, javacNode, jCTree, z2, expressionMaker, statementMaker, accessLevel);
    }

    @Override // lombok.javac.handlers.singulars.JavacGuavaSingularizer, lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public /* bridge */ /* synthetic */ void appendBuildCode(JavacSingularsRecipes.SingularData singularData, JavacNode javacNode, JCTree jCTree, ListBuffer listBuffer, Name name, String str) {
        super.appendBuildCode(singularData, javacNode, jCTree, listBuffer, name, str);
    }

    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public LombokImmutableList<String> getSupportedTypes() {
        return SUPPORTED_TYPES;
    }

    @Override // lombok.javac.handlers.singulars.JavacGuavaSingularizer
    protected LombokImmutableList<String> getArgumentSuffixes() {
        return SUFFIXES;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // lombok.javac.handlers.JavacSingularsRecipes.JavacSingularizer
    public String getAddMethodName() {
        return "put";
    }

    @Override // lombok.javac.handlers.singulars.JavacGuavaSingularizer
    protected String getAddAllTypeName() {
        return "com.google.common.collect.Table";
    }
}
