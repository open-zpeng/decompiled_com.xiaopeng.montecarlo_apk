package lombok.launch;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
/* loaded from: classes3.dex */
class Main {
    private static ShadowClassLoader classLoader;

    Main() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized ClassLoader getShadowClassLoader() {
        ShadowClassLoader shadowClassLoader;
        synchronized (Main.class) {
            if (classLoader == null) {
                classLoader = new ShadowClassLoader(Main.class.getClassLoader(), "lombok", null, Arrays.asList(new String[0]), Arrays.asList("lombok.patcher.Symbols"));
            }
            shadowClassLoader = classLoader;
        }
        return shadowClassLoader;
    }

    public static void main(String[] strArr) throws Throwable {
        try {
            getShadowClassLoader().loadClass("lombok.core.Main").getMethod("main", String[].class).invoke(null, strArr);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}
