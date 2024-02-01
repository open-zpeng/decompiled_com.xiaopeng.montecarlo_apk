package lombok.javac.java6;

import com.sun.tools.javac.main.JavaCompiler;
import com.sun.tools.javac.parser.Lexer;
import com.sun.tools.javac.parser.Parser;
import com.sun.tools.javac.util.Context;
import java.lang.reflect.Field;
import lombok.permit.Permit;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/java6/CommentCollectingParserFactory.SCL.lombok */
public class CommentCollectingParserFactory extends Parser.Factory {
    static Context.Key<Parser.Factory> key() {
        return parserFactoryKey;
    }

    protected CommentCollectingParserFactory(Context context) {
        super(context);
    }

    public Parser newParser(Lexer S, boolean keepDocComments, boolean genEndPos) {
        Object x = new CommentCollectingParser(this, S, true);
        return (Parser) x;
    }

    public static void setInCompiler(JavaCompiler compiler, Context context) {
        context.put(key(), (Object) null);
        try {
            Field field = Permit.getField(JavaCompiler.class, "parserFactory");
            field.set(compiler, new CommentCollectingParserFactory(context));
        } catch (Exception e) {
            throw new IllegalStateException("Could not set comment sensitive parser in the compiler", e);
        }
    }
}
