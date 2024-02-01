package lombok.javac.java8;

import com.sun.tools.javac.parser.JavacParser;
import com.sun.tools.javac.parser.Lexer;
import com.sun.tools.javac.parser.ParserFactory;
import com.sun.tools.javac.tree.JCTree;
import lombok.javac.CommentCatcher;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/java8/CommentCollectingParser.SCL.lombok */
class CommentCollectingParser extends JavacParser {
    private final Lexer lexer;

    /* JADX INFO: Access modifiers changed from: protected */
    public CommentCollectingParser(ParserFactory fac, Lexer S, boolean keepDocComments, boolean keepLineMap, boolean keepEndPositions) {
        super(fac, S, keepDocComments, keepLineMap, keepEndPositions);
        this.lexer = S;
    }

    public JCTree.JCCompilationUnit parseCompilationUnit() {
        JCTree.JCCompilationUnit result = super.parseCompilationUnit();
        if (this.lexer instanceof CommentCollectingScanner) {
            CommentCatcher.JCCompilationUnit_comments.set(result, this.lexer.getComments());
            CommentCatcher.JCCompilationUnit_textBlockStarts.set(result, this.lexer.getTextBlockStarts());
        }
        return result;
    }
}
