package lombok.installer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/installer/CorruptedIdeLocationException.SCL.lombok */
public class CorruptedIdeLocationException extends Exception {
    private final String ideType;

    public CorruptedIdeLocationException(String message, String ideType, Throwable cause) {
        super(message, cause);
        this.ideType = ideType;
    }

    public String getIdeType() {
        return this.ideType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showDialog(JFrame appWindow) {
        JOptionPane.showMessageDialog(appWindow, getMessage(), "Cannot configure " + this.ideType + " installation", 2);
    }
}
