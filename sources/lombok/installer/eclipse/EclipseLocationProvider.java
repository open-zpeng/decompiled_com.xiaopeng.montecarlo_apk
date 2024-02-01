package lombok.installer.eclipse;

import java.util.Collections;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/installer/eclipse/EclipseLocationProvider.SCL.lombok */
public class EclipseLocationProvider extends EclipseProductLocationProvider {
    private static final EclipseProductDescriptor ECLIPSE = new StandardProductDescriptor("Eclipse", "eclipse", "eclipse", EclipseLocationProvider.class.getResource("eclipse.png"), Collections.emptySet());

    public EclipseLocationProvider() {
        super(ECLIPSE);
    }
}
