package lombok.core;

import com.autonavi.common.tool.FDManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/Main.SCL.lombok */
public class Main {
    private static final Collection<?> HELP_SWITCHES = Collections.unmodifiableList(Arrays.asList("/?", "/h", "/help", "-h", "-help", "--help", "help", "h"));
    private final List<LombokApp> apps;
    private final List<String> args;

    public static void main(String[] args) throws IOException {
        Thread.currentThread().setContextClassLoader(Main.class.getClassLoader());
        int err = new Main(SpiLoadUtil.readAllFromIterator(SpiLoadUtil.findServices(LombokApp.class)), Arrays.asList(args)).go();
        if (err != 0) {
            System.exit(err);
        }
    }

    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/Main$VersionApp.SCL.lombok */
    public static class VersionApp extends LombokApp {
        @Override // lombok.core.LombokApp
        public String getAppName() {
            return "version";
        }

        @Override // lombok.core.LombokApp
        public String getAppDescription() {
            return "prints lombok's version.";
        }

        @Override // lombok.core.LombokApp
        public List<String> getAppAliases() {
            return Arrays.asList("-version", "--version");
        }

        @Override // lombok.core.LombokApp
        public int runApp(List<String> args) {
            System.out.println(Version.getFullVersion());
            return 0;
        }
    }

    /* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/Main$LicenseApp.SCL.lombok */
    public static class LicenseApp extends LombokApp {
        @Override // lombok.core.LombokApp
        public String getAppName() {
            return "license";
        }

        @Override // lombok.core.LombokApp
        public String getAppDescription() {
            return "prints license information.";
        }

        @Override // lombok.core.LombokApp
        public List<String> getAppAliases() {
            return Arrays.asList("licence", "copyright", "copyleft", "gpl");
        }

        @Override // lombok.core.LombokApp
        public int runApp(List<String> args) {
            try {
                InputStream in = Main.class.getResourceAsStream("/LICENSE");
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] b = new byte[65536];
                while (true) {
                    int r = in.read(b);
                    if (r != -1) {
                        out.write(b, 0, r);
                    } else {
                        System.out.println(new String(out.toByteArray()));
                        in.close();
                        return 0;
                    }
                }
            } catch (Exception unused) {
                System.err.println("License file not found. Check https://projectlombok.org/LICENSE");
                return 1;
            }
        }
    }

    public Main(List<LombokApp> apps, List<String> args) {
        this.apps = apps;
        this.args = args;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int go() {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: lombok.core.Main.go():int");
    }

    public void printHelp(String message, PrintStream out) {
        if (message != null) {
            out.println(message);
            out.println("------------------------------");
        }
        out.println("projectlombok.org " + Version.getFullVersion());
        out.println("Copyright (C) 2009-2018 The Project Lombok Authors.");
        out.println("Run 'lombok license' to see the lombok license agreement.");
        out.println();
        out.println("Run lombok without any parameters to start the graphical installer.");
        out.println("Other available commands:");
        for (LombokApp app : this.apps) {
            if (!app.isDebugTool()) {
                String[] desc = app.getAppDescription().split(FDManager.LINE_SEPERATOR);
                int i = 0;
                while (i < desc.length) {
                    Object[] objArr = new Object[2];
                    objArr[0] = i == 0 ? app.getAppName() : "";
                    objArr[1] = desc[i];
                    out.printf("  %15s    %s\n", objArr);
                    i++;
                }
            }
        }
        out.println();
        out.println("Run lombok commandName --help for more info on each command.");
    }
}
