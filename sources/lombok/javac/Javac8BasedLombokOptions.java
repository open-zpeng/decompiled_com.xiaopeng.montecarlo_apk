package lombok.javac;

import com.sun.tools.javac.main.Option;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Options;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/javac/Javac8BasedLombokOptions.SCL.lombok */
public class Javac8BasedLombokOptions extends LombokOptions {
    public static Javac8BasedLombokOptions replaceWithDelombokOptions(Context context) {
        Options options = Options.instance(context);
        context.put(optionsKey, (Object) null);
        Javac8BasedLombokOptions result = new Javac8BasedLombokOptions(context);
        result.putAll(options);
        return result;
    }

    private Javac8BasedLombokOptions(Context context) {
        super(context);
    }

    @Override // lombok.javac.LombokOptions
    public void putJavacOption(String optionName, String value) {
        String optionText = Option.valueOf(optionName).text;
        put(optionText, value);
    }
}
