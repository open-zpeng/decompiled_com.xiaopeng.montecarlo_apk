package lombok.core;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/DiagnosticsReceiver.SCL.lombok */
public interface DiagnosticsReceiver {
    public static final DiagnosticsReceiver CONSOLE = new DiagnosticsReceiver() { // from class: lombok.core.DiagnosticsReceiver.1
        @Override // lombok.core.DiagnosticsReceiver
        public void addError(String message) {
            System.err.println("Error: " + message);
        }

        @Override // lombok.core.DiagnosticsReceiver
        public void addWarning(String message) {
            System.out.println("Warning: " + message);
        }
    };

    void addError(String str);

    void addWarning(String str);
}
