package lombok.installer;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/installer/InstallException.SCL.lombok */
public class InstallException extends Exception {
    private boolean warning;

    public InstallException(String message, Throwable cause) {
        super(message, cause);
    }

    public InstallException(boolean warning, String message, Throwable cause) {
        super(message, cause);
        this.warning = warning;
    }

    public boolean isWarning() {
        return this.warning;
    }
}
