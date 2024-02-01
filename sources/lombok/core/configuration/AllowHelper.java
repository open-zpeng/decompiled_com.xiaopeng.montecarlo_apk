package lombok.core.configuration;

import java.util.Collection;
import java.util.Collections;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/configuration/AllowHelper.SCL.lombok */
public final class AllowHelper {
    private static final Collection<? extends ConfigurationKey<?>> ALLOWABLE = Collections.emptySet();

    private AllowHelper() {
    }

    public static boolean isAllowable(ConfigurationKey<?> key) {
        return ALLOWABLE.contains(key);
    }
}
