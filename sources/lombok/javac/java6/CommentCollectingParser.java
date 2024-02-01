package lombok.javac.java6;

import com.sun.tools.javac.parser.EndPosParser;
import com.sun.tools.javac.parser.Lexer;
import com.sun.tools.javac.parser.Parser;
import com.sun.tools.javac.tree.JCTree;
import lombok.javac.CommentCatcher;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/java6/CommentCollectingParser.SCL.lombok */
class CommentCollectingParser extends EndPosParser {
    private final Lexer lexer;

    /* JADX INFO: Access modifiers changed from: protected */
    public CommentCollectingParser(Parser.Factory fac, Lexer S, boolean keepDocComments) {
        super(fac, S, keepDocComments);
        this.lexer = S;
    }

    public JCTree.JCCompilationUnit compilationUnit() {
        JCTree.JCCompilationUnit result = super.compilationUnit();
        if (this.lexer instanceof CommentCollectingScanner) {
            CommentCatcher.JCCompilationUnit_comments.set(result, this.lexer.getComments());
        }
        return result;
    }
}
