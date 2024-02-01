package lombok.installer.eclipse;

import java.util.Collections;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/installer/eclipse/MyEclipseLocationProvider.SCL.lombok */
public class MyEclipseLocationProvider extends EclipseProductLocationProvider {
    private static final EclipseProductDescriptor MY_ECLIPSE = new StandardProductDescriptor("MyEclipse", "myeclipse", "myeclipse", MyEclipseLocationProvider.class.getResource("myeclipse.png"), Collections.emptySet());

    public MyEclipseLocationProvider() {
        super(MY_ECLIPSE);
    }
}
