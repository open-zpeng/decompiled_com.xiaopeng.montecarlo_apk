package lombok.javac.java7;

import com.sun.tools.javac.parser.EndPosParser;
import com.sun.tools.javac.parser.Lexer;
import com.sun.tools.javac.parser.ParserFactory;
import com.sun.tools.javac.tree.JCTree;
import java.util.List;
import lombok.javac.CommentCatcher;
import lombok.javac.CommentInfo;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/java7/CommentCollectingParser.SCL.lombok */
class CommentCollectingParser extends EndPosParser {
    private final Lexer lexer;

    /* JADX INFO: Access modifiers changed from: protected */
    public CommentCollectingParser(ParserFactory fac, Lexer S, boolean keepDocComments, boolean keepLineMap) {
        super(fac, S, keepDocComments, keepLineMap);
        this.lexer = S;
    }

    public JCTree.JCCompilationUnit parseCompilationUnit() {
        JCTree.JCCompilationUnit result = super.parseCompilationUnit();
        if (this.lexer instanceof CommentCollectingScanner) {
            List<CommentInfo> comments = this.lexer.getComments();
            CommentCatcher.JCCompilationUnit_comments.set(result, comments);
        }
        return result;
    }
}
