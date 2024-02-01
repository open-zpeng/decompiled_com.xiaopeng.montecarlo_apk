package lombok.patcher;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/patcher/Version.SCL.lombok */
public class Version {
    private static final String VERSION = "0.40";

    private Version() {
    }

    public static void main(String[] args) {
        System.out.println(VERSION);
    }

    public static String getVersion() {
        return VERSION;
    }
}
