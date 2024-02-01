package lombok.core;

import java.util.Collection;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/ImportList.SCL.lombok */
public interface ImportList {
    String getFullyQualifiedNameForSimpleName(String str);

    String getFullyQualifiedNameForSimpleNameNoAliasing(String str);

    boolean hasStarImport(String str);

    Collection<String> applyNameToStarImports(String str, String str2);

    String applyUnqualifiedNameToPackage(String str);
}
