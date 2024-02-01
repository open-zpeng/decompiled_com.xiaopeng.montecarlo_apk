package lombok.javac.java9;

import com.sun.tools.javac.main.JavaCompiler;
import com.sun.tools.javac.parser.JavacParser;
import com.sun.tools.javac.parser.ParserFactory;
import com.sun.tools.javac.parser.ScannerFactory;
import com.sun.tools.javac.util.Context;
import java.lang.reflect.Field;
import lombok.permit.Permit;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/java9/CommentCollectingParserFactory.SCL.lombok */
public class CommentCollectingParserFactory extends ParserFactory {
    private final Context context;

    static Context.Key<ParserFactory> key() {
        return parserFactoryKey;
    }

    protected CommentCollectingParserFactory(Context context) {
        super(context);
        this.context = context;
    }

    public JavacParser newParser(CharSequence input, boolean keepDocComments, boolean keepEndPos, boolean keepLineMap) {
        return newParser(input, keepDocComments, keepEndPos, keepLineMap, false);
    }

    public JavacParser newParser(CharSequence input, boolean keepDocComments, boolean keepEndPos, boolean keepLineMap, boolean parseModuleInfo) {
        ScannerFactory scannerFactory = ScannerFactory.instance(this.context);
        Object x = new CommentCollectingParser(this, scannerFactory.newScanner(input, true), true, keepLineMap, keepEndPos, parseModuleInfo);
        return (JavacParser) x;
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
