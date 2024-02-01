package lombok.javac.java8;

import com.sun.tools.javac.parser.Scanner;
import com.sun.tools.javac.parser.ScannerFactory;
import com.sun.tools.javac.util.Context;
import java.nio.CharBuffer;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/java8/CommentCollectingScannerFactory.SCL.lombok */
public class CommentCollectingScannerFactory extends ScannerFactory {
    public static boolean findTextBlocks;

    public static void preRegister(final Context context) {
        if (context.get(scannerFactoryKey) == null) {
            Context.Factory<ScannerFactory> factory = new Context.Factory() { // from class: lombok.javac.java8.CommentCollectingScannerFactory.1MyFactory
                public Object make() {
                    return new CommentCollectingScannerFactory(context);
                }

                public Object make(Context c) {
                    return new CommentCollectingScannerFactory(c);
                }
            };
            context.put(scannerFactoryKey, factory);
        }
    }

    protected CommentCollectingScannerFactory(Context context) {
        super(context);
    }

    public Scanner newScanner(CharSequence input, boolean keepDocComments) {
        if (input instanceof CharBuffer) {
            CharBuffer buf = (CharBuffer) input;
            return new CommentCollectingScanner(this, new CommentCollectingTokenizer(this, buf, findTextBlocks));
        }
        char[] array = input.toString().toCharArray();
        return newScanner(array, array.length, keepDocComments);
    }

    public Scanner newScanner(char[] input, int inputLength, boolean keepDocComments) {
        return new CommentCollectingScanner(this, new CommentCollectingTokenizer(this, input, inputLength, findTextBlocks));
    }
}
