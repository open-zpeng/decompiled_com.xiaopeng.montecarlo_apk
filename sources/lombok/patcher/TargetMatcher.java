package lombok.patcher;

import java.util.Collection;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/patcher/TargetMatcher.SCL.lombok */
public interface TargetMatcher {
    Collection<String> getAffectedClasses();

    boolean matches(String str, String str2, String str3);

    String describe();
}
