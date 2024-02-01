package lombok.installer;

import java.util.List;
import java.util.regex.Pattern;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/installer/IdeLocationProvider.SCL.lombok */
public interface IdeLocationProvider {
    IdeLocation create(String str) throws CorruptedIdeLocationException;

    Pattern getLocationSelectors();

    void findIdes(List<IdeLocation> list, List<CorruptedIdeLocationException> list2);
}
