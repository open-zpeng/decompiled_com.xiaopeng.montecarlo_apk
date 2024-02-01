package lombok.core.configuration;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import lombok.ConfigurationKeys;
import lombok.core.configuration.ConfigurationSource;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/configuration/BubblingConfigurationResolver.SCL.lombok */
public class BubblingConfigurationResolver implements ConfigurationResolver {
    private final ConfigurationFile start;
    private final ConfigurationFileToSource fileMapper;

    public BubblingConfigurationResolver(ConfigurationFile start, ConfigurationFileToSource fileMapper) {
        this.start = start;
        this.fileMapper = fileMapper;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.List, T, java.util.ArrayList] */
    @Override // lombok.core.configuration.ConfigurationResolver
    public <T> T resolve(ConfigurationKey<T> key) {
        ConfigurationSource source;
        boolean isList = key.getType().isList();
        List<List<ConfigurationSource.ListModification>> listModificationsList = null;
        boolean stopBubbling = false;
        ConfigurationFile currentLevel = this.start;
        Collection<ConfigurationFile> visited = new HashSet<>();
        while (true) {
            if (stopBubbling || currentLevel == null) {
                break;
            }
            Deque<ConfigurationFile> round = new ArrayDeque<>();
            round.push(currentLevel);
            while (!round.isEmpty()) {
                ConfigurationFile currentFile = round.pop();
                if (currentFile != null && visited.add(currentFile) && (source = this.fileMapper.parsed(currentFile)) != null) {
                    for (ConfigurationFile importFile : source.imports()) {
                        round.push(importFile);
                    }
                    ConfigurationSource.Result stop = source.resolve(ConfigurationKeys.STOP_BUBBLING);
                    stopBubbling = stopBubbling || (stop != null && Boolean.TRUE.equals(stop.getValue()));
                    ConfigurationSource.Result result = source.resolve(key);
                    if (result != null) {
                        if (isList) {
                            if (listModificationsList == null) {
                                listModificationsList = new ArrayList<>();
                            }
                            listModificationsList.add((List) result.getValue());
                        }
                        if (result.isAuthoritative()) {
                            if (!isList) {
                                return (T) result.getValue();
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
            currentLevel = currentLevel.parent();
        }
        if (isList) {
            if (listModificationsList == null) {
                return (T) Collections.emptyList();
            }
            ?? r0 = (T) new ArrayList();
            Collections.reverse(listModificationsList);
            for (List<ConfigurationSource.ListModification> listModifications : listModificationsList) {
                if (listModifications != null) {
                    for (ConfigurationSource.ListModification modification : listModifications) {
                        r0.remove(modification.getValue());
                        if (modification.isAdded()) {
                            r0.add(modification.getValue());
                        }
                    }
                }
            }
            return r0;
        }
        return null;
    }
}
