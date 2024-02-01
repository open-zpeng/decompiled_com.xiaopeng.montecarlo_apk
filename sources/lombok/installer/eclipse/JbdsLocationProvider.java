package lombok.installer.eclipse;

import java.util.Collections;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/installer/eclipse/JbdsLocationProvider.SCL.lombok */
public class JbdsLocationProvider extends EclipseProductLocationProvider {
    private static final EclipseProductDescriptor JBDS = new StandardProductDescriptor("JBoss Developer Studio", "jbdevstudio", "studio", JbdsLocationProvider.class.getResource("jbds.png"), Collections.emptySet());

    public JbdsLocationProvider() {
        super(JBDS);
    }
}
