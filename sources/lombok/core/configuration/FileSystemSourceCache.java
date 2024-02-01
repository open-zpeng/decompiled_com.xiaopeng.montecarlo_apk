package lombok.core.configuration;

import java.io.File;
import java.net.URI;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import lombok.core.debug.ProblemReporter;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/configuration/FileSystemSourceCache.SCL.lombok */
public class FileSystemSourceCache {
    private static final long FULL_CACHE_CLEAR_INTERVAL = TimeUnit.MINUTES.toMillis(30);
    private static final long RECHECK_FILESYSTEM = TimeUnit.SECONDS.toMillis(2);
    private static final long NEVER_CHECKED = -1;
    static final long MISSING = -88;
    private final ConcurrentMap<ConfigurationFile, Content> fileCache = new ConcurrentHashMap();
    private final ConcurrentMap<URI, ConfigurationFile> uriCache = new ConcurrentHashMap();
    private volatile long lastCacheClear = System.currentTimeMillis();

    private void cacheClear() {
        long now = System.currentTimeMillis();
        long delta = now - this.lastCacheClear;
        if (delta > FULL_CACHE_CLEAR_INTERVAL) {
            this.lastCacheClear = now;
            this.fileCache.clear();
            this.uriCache.clear();
        }
    }

    public ConfigurationFileToSource fileToSource(final ConfigurationParser parser) {
        return new ConfigurationFileToSource() { // from class: lombok.core.configuration.FileSystemSourceCache.1
            @Override // lombok.core.configuration.ConfigurationFileToSource
            public ConfigurationSource parsed(ConfigurationFile fileLocation) {
                return FileSystemSourceCache.this.parseIfNeccesary(fileLocation, parser);
            }
        };
    }

    public ConfigurationFile forUri(URI javaFile) {
        if (javaFile == null) {
            return null;
        }
        cacheClear();
        ConfigurationFile result = this.uriCache.get(javaFile);
        if (result == null) {
            URI uri = javaFile.normalize();
            if (!uri.isAbsolute()) {
                uri = URI.create("file:" + uri.toString());
            }
            try {
                File file = new File(uri);
                if (!file.exists()) {
                    throw new IllegalArgumentException("File does not exist: " + uri);
                }
                File directory = file.isDirectory() ? file : file.getParentFile();
                if (directory != null) {
                    result = ConfigurationFile.forDirectory(directory);
                }
                this.uriCache.put(javaFile, result);
            } catch (IllegalArgumentException unused) {
            } catch (Exception e) {
                ProblemReporter.error("Can't find absolute path of file being compiled: " + javaFile, e);
            }
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [lombok.core.configuration.FileSystemSourceCache$Content, java.lang.Throwable] */
    public ConfigurationSource parseIfNeccesary(ConfigurationFile file, ConfigurationParser parser) {
        long now = System.currentTimeMillis();
        ?? ensureContent = ensureContent(file);
        synchronized (ensureContent) {
            if (ensureContent.lastChecked != -1 && now - ensureContent.lastChecked < RECHECK_FILESYSTEM) {
                return ensureContent.source;
            }
            ensureContent.lastChecked = now;
            long previouslyModified = ensureContent.lastModified;
            ensureContent.lastModified = file.getLastModifiedOrMissing();
            if (ensureContent.lastModified != previouslyModified) {
                ensureContent.source = ensureContent.lastModified == MISSING ? null : SingleConfigurationSource.parse(file, parser);
            }
            return ensureContent.source;
        }
    }

    private Content ensureContent(ConfigurationFile context) {
        Content content = this.fileCache.get(context);
        if (content != null) {
            return content;
        }
        this.fileCache.putIfAbsent(context, Content.empty());
        return this.fileCache.get(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/configuration/FileSystemSourceCache$Content.SCL.lombok */
    public static class Content {
        ConfigurationSource source;
        long lastModified;
        long lastChecked;

        private Content(ConfigurationSource source, long lastModified, long lastChecked) {
            this.source = source;
            this.lastModified = lastModified;
            this.lastChecked = lastChecked;
        }

        static Content empty() {
            return new Content(null, FileSystemSourceCache.MISSING, -1L);
        }
    }
}
