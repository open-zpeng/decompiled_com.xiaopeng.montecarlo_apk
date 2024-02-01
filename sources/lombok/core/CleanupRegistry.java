package lombok.core;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/CleanupRegistry.SCL.lombok */
public class CleanupRegistry {
    private final ConcurrentMap<CleanupKey, CleanupTask> tasks = new ConcurrentHashMap();

    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/CleanupRegistry$CleanupKey.SCL.lombok */
    private static final class CleanupKey {
        private final String key;
        private final Object target;

        CleanupKey(String key, Object target) {
            this.key = key;
            this.target = target;
        }

        public boolean equals(Object other) {
            if (other == null) {
                return false;
            }
            if (other == this) {
                return true;
            }
            if (other instanceof CleanupKey) {
                CleanupKey o = (CleanupKey) other;
                return this.key.equals(o.key) && this.target == o.target;
            }
            return false;
        }

        public int hashCode() {
            return (109 * System.identityHashCode(this.target)) + this.key.hashCode();
        }
    }

    public void registerTask(String key, Object target, CleanupTask task) {
        CleanupKey ck = new CleanupKey(key, target);
        this.tasks.putIfAbsent(ck, task);
    }

    public void run() {
        for (CleanupTask task : this.tasks.values()) {
            task.cleanup();
        }
        this.tasks.clear();
    }
}
