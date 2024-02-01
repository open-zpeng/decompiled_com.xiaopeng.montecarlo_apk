package lombok.core.handlers;

import java.util.Arrays;
import java.util.List;
import lombok.core.runtimeDependencies.RuntimeDependencyInfo;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/handlers/SneakyThrowsAndCleanupDependencyInfo.SCL.lombok */
public class SneakyThrowsAndCleanupDependencyInfo implements RuntimeDependencyInfo {
    @Override // lombok.core.runtimeDependencies.RuntimeDependencyInfo
    public List<String> getRuntimeDependencies() {
        return Arrays.asList("lombok/Lombok.class");
    }

    @Override // lombok.core.runtimeDependencies.RuntimeDependencyInfo
    public List<String> getRuntimeDependentsDescriptions() {
        return Arrays.asList("@SneakyThrows (only when delomboking - using @SneakyThrows in code that is compiled with lombok on the classpath does not create the dependency)", "@Cleanup (only when delomboking - using @Cleanup in code that is compiled with lombok on the classpath does not create the dependency)");
    }
}
