package lombok.installer.eclipse;

import java.util.Collections;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/installer/eclipse/RhdsLocationProvider.SCL.lombok */
public class RhdsLocationProvider extends EclipseProductLocationProvider {
    private static final EclipseProductDescriptor RHDS = new StandardProductDescriptor("Red Hat JBoss Developer Studio", "devstudio", "studio", RhdsLocationProvider.class.getResource("rhds.png"), Collections.emptySet());

    public RhdsLocationProvider() {
        super(RHDS);
    }
}
