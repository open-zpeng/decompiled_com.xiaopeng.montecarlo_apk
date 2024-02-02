package lombok.installer.eclipse;

import java.util.Collections;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/installer/eclipse/AngularIDELocationProvider.SCL.lombok */
public class AngularIDELocationProvider extends EclipseProductLocationProvider {
    private static final EclipseProductDescriptor ANGULAR = new StandardProductDescriptor("Angular IDE", "angularide", "angular", AngularIDELocationProvider.class.getResource("angular.png"), Collections.emptySet());

    public AngularIDELocationProvider() {
        super(ANGULAR);
    }
}
