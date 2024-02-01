package lombok.installer;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/installer/UninstallException.SCL.lombok */
public class UninstallException extends Exception {
    private boolean warning;

    public UninstallException(String message, Throwable cause) {
        super(message, cause);
    }

    public UninstallException(boolean warning, String message, Throwable cause) {
        super(message, cause);
        this.warning = warning;
    }

    public boolean isWarning() {
        return this.warning;
    }
}
