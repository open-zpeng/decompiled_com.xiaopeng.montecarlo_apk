package lombok.patcher;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/patcher/ClassRootFinder.SCL.lombok */
public class ClassRootFinder {
    private static String urlDecode(String in, boolean forceUtf8) {
        String name;
        if (forceUtf8) {
            name = "UTF-8";
        } else {
            try {
                name = Charset.defaultCharset().name();
            } catch (UnsupportedEncodingException unused) {
                try {
                    return URLDecoder.decode(in, "UTF-8");
                } catch (UnsupportedEncodingException unused2) {
                    return in;
                }
            }
        }
        return URLDecoder.decode(in, name);
    }

    public static String findClassRootOfSelf() {
        return findClassRootOfClass(ClassRootFinder.class);
    }

    public static String findClassRootOfClass(Class<?> context) {
        String packageBase;
        String self;
        String name = context.getName();
        int idx = name.lastIndexOf(46);
        if (idx > -1) {
            packageBase = name.substring(0, idx);
            name = name.substring(idx + 1);
        } else {
            packageBase = "";
        }
        URL selfURL = context.getResource(String.valueOf(name) + ".class");
        String self2 = selfURL.toString();
        if (self2.startsWith("file:/")) {
            String path = urlDecode(self2.substring(5), false);
            if (!new File(path).exists()) {
                path = urlDecode(self2.substring(5), true);
            }
            String suffix = MqttTopic.TOPIC_LEVEL_SEPARATOR + packageBase.replace('.', '/') + MqttTopic.TOPIC_LEVEL_SEPARATOR + name + ".class";
            if (!path.endsWith(suffix)) {
                throw new IllegalArgumentException("Unknown path structure: " + path);
            }
            self = path.substring(0, path.length() - suffix.length());
        } else if (self2.startsWith("jar:")) {
            int sep = self2.indexOf(33);
            if (sep == -1) {
                throw new IllegalArgumentException("No separator in jar protocol: " + self2);
            }
            String jarLoc = self2.substring(4, sep);
            if (!jarLoc.startsWith("file:/")) {
                throw new IllegalArgumentException("Unknown path structure: " + self2);
            }
            String path2 = urlDecode(jarLoc.substring(5), false);
            if (!new File(path2).exists()) {
                path2 = urlDecode(jarLoc.substring(5), true);
            }
            self = path2;
        } else {
            throw new IllegalArgumentException("Unknown protocol: " + self2);
        }
        if (self.isEmpty()) {
            self = MqttTopic.TOPIC_LEVEL_SEPARATOR;
        }
        return self;
    }

    public static void main(String[] args) {
        System.out.println(findClassRootOfSelf());
    }
}
