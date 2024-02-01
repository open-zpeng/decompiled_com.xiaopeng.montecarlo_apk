package lombok.patcher;

import java.security.ProtectionDomain;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/patcher/Filter.SCL.lombok */
public interface Filter {
    public static final Filter ALWAYS = new Filter() { // from class: lombok.patcher.Filter.1
        @Override // lombok.patcher.Filter
        public boolean shouldTransform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
            return true;
        }
    };

    boolean shouldTransform(ClassLoader classLoader, String str, Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr);
}
