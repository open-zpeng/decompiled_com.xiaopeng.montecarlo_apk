package lombok.installer.eclipse;

import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.carservice.ICarService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import lombok.installer.CorruptedIdeLocationException;
import lombok.installer.IdeLocation;
import lombok.installer.IdeLocationProvider;
import lombok.installer.OsUtils;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/installer/eclipse/EclipseProductLocationProvider.SCL.lombok */
public class EclipseProductLocationProvider implements IdeLocationProvider {
    private final EclipseProductDescriptor descriptor;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$installer$OsUtils$OS;

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$installer$OsUtils$OS() {
        int[] iArr = $SWITCH_TABLE$lombok$installer$OsUtils$OS;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[OsUtils.OS.valuesCustom().length];
        try {
            iArr2[OsUtils.OS.MAC_OS_X.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[OsUtils.OS.UNIX.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[OsUtils.OS.WINDOWS.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$lombok$installer$OsUtils$OS = iArr2;
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EclipseProductLocationProvider(EclipseProductDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    @Override // lombok.installer.IdeLocationProvider
    public final IdeLocation create(String path) throws CorruptedIdeLocationException {
        return create0(path);
    }

    private IdeLocation create0(String path) throws CorruptedIdeLocationException {
        if (path == null) {
            throw new NullPointerException("path");
        }
        String iniName = this.descriptor.getIniFileName();
        File p = new File(path);
        if (p.exists()) {
            if (p.isDirectory()) {
                for (String possibleExeName : this.descriptor.getExecutableNames()) {
                    File f = new File(p, possibleExeName);
                    if (f.exists()) {
                        return findEclipseIniFromExe(f, 0);
                    }
                }
                File f2 = new File(p, iniName);
                if (f2.exists()) {
                    return makeLocation(IdeLocation.canonical(p), f2);
                }
            }
            if (p.isFile() && p.getName().equalsIgnoreCase(iniName)) {
                return makeLocation(IdeLocation.canonical(p.getParentFile()), p);
            }
            if (this.descriptor.getExecutableNames().contains(p.getName().toLowerCase())) {
                return findEclipseIniFromExe(p, 0);
            }
            return null;
        }
        return null;
    }

    private IdeLocation findEclipseIniFromExe(File exePath, int loopCounter) throws CorruptedIdeLocationException {
        String iniName = this.descriptor.getIniFileName();
        File ini = new File(exePath.getParentFile(), iniName);
        if (ini.isFile()) {
            return makeLocation(IdeLocation.canonical(exePath), ini);
        }
        String macAppName = this.descriptor.getMacAppName();
        File ini2 = new File(exePath.getParentFile(), String.valueOf(macAppName) + "/Contents/MacOS/" + iniName);
        if (ini2.isFile()) {
            return makeLocation(IdeLocation.canonical(exePath), ini2);
        }
        File ini3 = new File(exePath.getParentFile(), String.valueOf(macAppName) + "/Contents/Eclipse/" + iniName);
        if (ini3.isFile()) {
            return makeLocation(IdeLocation.canonical(exePath), ini3);
        }
        if (loopCounter < 50) {
            try {
                String oPath = exePath.getAbsolutePath();
                String nPath = exePath.getCanonicalPath();
                if (!oPath.equals(nPath)) {
                    try {
                        IdeLocation loc = findEclipseIniFromExe(new File(nPath), loopCounter + 1);
                        if (loc != null) {
                            return loc;
                        }
                    } catch (CorruptedIdeLocationException unused) {
                    }
                }
            } catch (IOException unused2) {
            }
        }
        String path = exePath.getAbsolutePath();
        try {
            path = exePath.getCanonicalPath();
        } catch (IOException unused3) {
        }
        String unixAppName = this.descriptor.getUnixAppName();
        if (path.equals("/usr/bin/" + unixAppName) || path.equals("/bin/" + unixAppName) || path.equals("/usr/local/bin/" + unixAppName)) {
            File ini4 = new File("/usr/lib/" + unixAppName + MqttTopic.TOPIC_LEVEL_SEPARATOR + iniName);
            if (ini4.isFile()) {
                return makeLocation(path, ini4);
            }
            File ini5 = new File("/usr/local/lib/" + unixAppName + MqttTopic.TOPIC_LEVEL_SEPARATOR + iniName);
            if (ini5.isFile()) {
                return makeLocation(path, ini5);
            }
            File ini6 = new File("/usr/local/etc/" + unixAppName + MqttTopic.TOPIC_LEVEL_SEPARATOR + iniName);
            if (ini6.isFile()) {
                return makeLocation(path, ini6);
            }
            File ini7 = new File("/etc/" + iniName);
            if (ini7.isFile()) {
                return makeLocation(path, ini7);
            }
            return null;
        }
        return null;
    }

    private IdeLocation makeLocation(String name, File ini) throws CorruptedIdeLocationException {
        return new EclipseProductLocation(this.descriptor, name, ini);
    }

    @Override // lombok.installer.IdeLocationProvider
    public Pattern getLocationSelectors() {
        return this.descriptor.getLocationSelectors();
    }

    @Override // lombok.installer.IdeLocationProvider
    public void findIdes(List<IdeLocation> locations, List<CorruptedIdeLocationException> problems) {
        switch ($SWITCH_TABLE$lombok$installer$OsUtils$OS()[OsUtils.getOS().ordinal()]) {
            case 1:
                new MacFinder().findEclipse(locations, problems);
                return;
            case 2:
                new WindowsFinder().findEclipse(locations, problems);
                return;
            case 3:
            default:
                new UnixFinder().findEclipse(locations, problems);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> transformToFiles(List<String> fileNames) {
        List<File> files = new ArrayList<>();
        for (String fileName : fileNames) {
            files.add(new File(fileName));
        }
        return files;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> getFlatSourceLocationsOnUnix() {
        List<File> dirs = new ArrayList<>();
        dirs.add(new File("/usr/bin/"));
        dirs.add(new File("/usr/local/bin/"));
        dirs.add(new File(System.getProperty("user.home", "."), "bin/"));
        return dirs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> getNestedSourceLocationOnUnix() {
        List<File> dirs = new ArrayList<>();
        dirs.add(new File("/usr/local/share"));
        dirs.add(new File("/usr/local"));
        dirs.add(new File("/usr/share"));
        return dirs;
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/installer/eclipse/EclipseProductLocationProvider$UnixFinder.SCL.lombok */
    private class UnixFinder extends DirectoryFinder {
        UnixFinder() {
            super(EclipseProductLocationProvider.this.getNestedSourceLocationOnUnix(), EclipseProductLocationProvider.this.getFlatSourceLocationsOnUnix());
        }

        @Override // lombok.installer.eclipse.EclipseProductLocationProvider.DirectoryFinder
        protected String findEclipseOnPlatform(File dir) {
            File possible = new File(dir, EclipseProductLocationProvider.this.descriptor.getUnixAppName());
            if (possible.exists()) {
                return possible.getAbsolutePath();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> getSourceDirsOnWindowsWithDriveLetters() {
        List<String> driveLetters = Arrays.asList(ICarService.CAR_STAGE_C);
        try {
            driveLetters = OsUtils.getDrivesOnWindows();
        } catch (Throwable ignore) {
            ignore.printStackTrace();
        }
        List<String> sourceDirs = new ArrayList<>();
        for (String letter : driveLetters) {
            for (String possibleSource : this.descriptor.getSourceDirsOnWindows()) {
                if (!isDriveSpecificOnWindows(possibleSource)) {
                    sourceDirs.add(String.valueOf(letter) + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + possibleSource);
                }
            }
        }
        for (String possibleSource2 : this.descriptor.getSourceDirsOnWindows()) {
            if (isDriveSpecificOnWindows(possibleSource2)) {
                sourceDirs.add(possibleSource2);
            }
        }
        return sourceDirs;
    }

    private boolean isDriveSpecificOnWindows(String path) {
        return path.length() > 1 && path.charAt(1) == ':';
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/installer/eclipse/EclipseProductLocationProvider$WindowsFinder.SCL.lombok */
    private class WindowsFinder extends DirectoryFinder {
        WindowsFinder() {
            super(EclipseProductLocationProvider.this.transformToFiles(EclipseProductLocationProvider.this.getSourceDirsOnWindowsWithDriveLetters()), Collections.emptyList());
        }

        @Override // lombok.installer.eclipse.EclipseProductLocationProvider.DirectoryFinder
        protected String findEclipseOnPlatform(File dir) {
            File possible = new File(dir, EclipseProductLocationProvider.this.descriptor.getWindowsExecutableName());
            if (possible.isFile()) {
                return dir.getAbsolutePath();
            }
            return null;
        }
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/installer/eclipse/EclipseProductLocationProvider$MacFinder.SCL.lombok */
    private class MacFinder extends DirectoryFinder {
        MacFinder() {
            super(EclipseProductLocationProvider.this.transformToFiles(EclipseProductLocationProvider.this.descriptor.getSourceDirsOnMac()), Collections.emptyList());
        }

        @Override // lombok.installer.eclipse.EclipseProductLocationProvider.DirectoryFinder
        protected String findEclipseOnPlatform(File dir) {
            if (dir.getName().toLowerCase().equals(EclipseProductLocationProvider.this.descriptor.getMacAppName().toLowerCase())) {
                return dir.getParent();
            }
            if (dir.getName().toLowerCase().contains(EclipseProductLocationProvider.this.descriptor.getDirectoryName()) && new File(dir, EclipseProductLocationProvider.this.descriptor.getMacAppName()).exists()) {
                return dir.toString();
            }
            return null;
        }
    }

    /* loaded from: xp_Montecarlo-benchEdward.apk:lombok/installer/eclipse/EclipseProductLocationProvider$DirectoryFinder.SCL.lombok */
    private abstract class DirectoryFinder {
        private final List<File> flatSourceDirs;
        private final List<File> nestedSourceDirs;

        abstract String findEclipseOnPlatform(File file);

        DirectoryFinder(List<File> nestedSourceDirs, List<File> flatSourceDirs) {
            this.nestedSourceDirs = nestedSourceDirs;
            this.flatSourceDirs = flatSourceDirs;
        }

        void findEclipse(List<IdeLocation> locations, List<CorruptedIdeLocationException> problems) {
            for (File dir : this.nestedSourceDirs) {
                recurseDirectory(locations, problems, dir);
            }
            for (File dir2 : this.flatSourceDirs) {
                findEclipse(locations, problems, dir2);
            }
        }

        void recurseDirectory(List<IdeLocation> locations, List<CorruptedIdeLocationException> problems, File dir) {
            recurseDirectory0(locations, problems, dir, 0, false);
        }

        private void recurseDirectory0(List<IdeLocation> locations, List<CorruptedIdeLocationException> problems, File f, int loopCounter, boolean nameFound) {
            File[] listFiles = f.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File dir : listFiles) {
                if (dir.isDirectory()) {
                    if (!nameFound) {
                        try {
                            if (!dir.getName().toLowerCase().contains(EclipseProductLocationProvider.this.descriptor.getDirectoryName())) {
                            }
                        } catch (Exception unused) {
                        }
                    }
                    findEclipse(locations, problems, dir);
                    if (loopCounter < 50) {
                        recurseDirectory0(locations, problems, dir, loopCounter + 1, true);
                    }
                }
            }
        }

        private void findEclipse(List<IdeLocation> locations, List<CorruptedIdeLocationException> problems, File dir) {
            String eclipseLocation = findEclipseOnPlatform(dir);
            if (eclipseLocation != null) {
                try {
                    IdeLocation newLocation = EclipseProductLocationProvider.this.create(eclipseLocation);
                    if (newLocation != null) {
                        locations.add(newLocation);
                    }
                } catch (CorruptedIdeLocationException e) {
                    problems.add(e);
                }
            }
        }
    }
}
