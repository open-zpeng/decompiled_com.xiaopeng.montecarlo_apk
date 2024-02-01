package lombok.core;

import java.util.Collections;
import java.util.List;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/LombokApp.SCL.lombok */
public abstract class LombokApp {
    public abstract int runApp(List<String> list) throws Exception;

    public abstract String getAppName();

    public abstract String getAppDescription();

    public List<String> getAppAliases() {
        return Collections.emptyList();
    }

    public boolean isDebugTool() {
        return false;
    }
}
