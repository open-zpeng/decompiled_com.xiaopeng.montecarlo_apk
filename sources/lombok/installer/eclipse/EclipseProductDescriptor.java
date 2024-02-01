package lombok.installer.eclipse;

import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/installer/eclipse/EclipseProductDescriptor.SCL.lombok */
public interface EclipseProductDescriptor {
    String getProductName();

    String getWindowsExecutableName();

    String getUnixAppName();

    String getMacAppName();

    String getDirectoryName();

    List<String> getExecutableNames();

    List<String> getSourceDirsOnWindows();

    List<String> getSourceDirsOnMac();

    List<String> getSourceDirsOnUnix();

    String getIniFileName();

    Pattern getLocationSelectors();

    URL getIdeIcon();
}
