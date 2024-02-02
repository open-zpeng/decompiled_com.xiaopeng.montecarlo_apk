package lombok.core;

import java.util.Collections;
import java.util.List;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/core/LombokApp.SCL.lombok */
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
