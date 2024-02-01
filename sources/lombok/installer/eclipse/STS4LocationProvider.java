package lombok.installer.eclipse;

import java.util.Arrays;
import java.util.Collections;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/installer/eclipse/STS4LocationProvider.SCL.lombok */
public class STS4LocationProvider extends EclipseProductLocationProvider {
    private static final EclipseProductDescriptor STS4 = new StandardProductDescriptor("Spring Tools Suite 4", "SpringToolSuite4", "sts", STS4LocationProvider.class.getResource("STS.png"), Collections.unmodifiableList(Arrays.asList("springsource", "spring-tool-suite")));

    public STS4LocationProvider() {
        super(STS4);
    }
}
