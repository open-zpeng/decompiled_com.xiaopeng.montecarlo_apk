package lombok.installer.eclipse;

import java.util.Collections;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/installer/eclipse/RhcrLocationProvider.SCL.lombok */
public class RhcrLocationProvider extends EclipseProductLocationProvider {
    private static final EclipseProductDescriptor RHCR = new StandardProductDescriptor("Red Hat CodeReady Studio", "codereadystudio", "studio", RhcrLocationProvider.class.getResource("rhds.png"), Collections.emptySet());

    public RhcrLocationProvider() {
        super(RHCR);
    }
}
