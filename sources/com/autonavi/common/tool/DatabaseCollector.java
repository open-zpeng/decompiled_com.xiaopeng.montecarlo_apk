package com.autonavi.common.tool;

import android.app.Application;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.autonavi.common.tool.util.IOUtil;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes.dex */
public class DatabaseCollector {
    public static String getDatabaseInfo(Throwable th, Application application) {
        File parentFile;
        final StringBuilder sb = new StringBuilder();
        try {
            sb.append("\nAppendInfo:\n");
            File dataDirectory = Environment.getDataDirectory();
            StatFs statFs = new StatFs(dataDirectory.getAbsolutePath());
            sb.append("\t");
            sb.append("Data TotalBytes:");
            sb.append(statFs.getBlockCount() * statFs.getBlockSize());
            sb.append(" AvailableBytes:");
            sb.append(statFs.getAvailableBlocks() * statFs.getBlockSize());
            sb.append(FDManager.LINE_SEPERATOR);
            if (Build.VERSION.SDK_INT >= 9) {
                sb.append("\t");
                sb.append("Data TotalSpace:");
                sb.append(dataDirectory.getTotalSpace());
                sb.append(" UsableSpace:");
                sb.append(dataDirectory.getUsableSpace());
                sb.append(FDManager.LINE_SEPERATOR);
            }
            try {
                sb.append("\t");
                sb.append("NDK_getUsableSpace:");
                sb.append(dumpcrash.getUsableSpace(dataDirectory.getPath()));
                sb.append(FDManager.LINE_SEPERATOR);
            } catch (Throwable unused) {
            }
            if (Utils.checkException(th, SQLiteCantOpenDatabaseException.class)) {
                int limitFdCount = getLimitFdCount();
                int currentFdCount = getCurrentFdCount();
                sb.append("\t");
                sb.append("limitCount:");
                sb.append(limitFdCount);
                sb.append(" currentCount:");
                sb.append(currentFdCount);
                sb.append(FDManager.LINE_SEPERATOR);
                if (currentFdCount <= limitFdCount && currentFdCount / limitFdCount > 0.95d) {
                    FDManager.getInstance().releaseFd();
                    sb.append("FDinfo:\n");
                    for (String str : FDManager.getFDList(false)) {
                        sb.append("\t");
                        sb.append(str);
                        sb.append(FDManager.LINE_SEPERATOR);
                    }
                }
            }
            sb.append("Mounts:\n");
            IOUtil.readFile(new File("/proc/self/mounts"), new IOUtil.ReadFileCallback() { // from class: com.autonavi.common.tool.DatabaseCollector.1
                @Override // com.autonavi.common.tool.util.IOUtil.ReadFileCallback
                public boolean onLine(String str2) {
                    StringBuilder sb2 = sb;
                    sb2.append("\t");
                    sb2.append(str2);
                    sb2.append(FDManager.LINE_SEPERATOR);
                    return false;
                }
            });
            sb.append("\nDumpDatabases:\n");
            File databasePath = application.getDatabasePath("aMap.db");
            if (databasePath == null) {
                parentFile = new File(application.getFilesDir().getParentFile(), "databases");
            } else {
                parentFile = databasePath.getParentFile();
            }
            for (File file = parentFile; file != null; file = file.getParentFile()) {
                sb.append("\t dir=");
                sb.append(file.getPath());
                sb.append(" canRead:");
                sb.append(file.canRead());
                sb.append(" canWrite:");
                sb.append(file.canWrite());
                sb.append(" canExecute:");
                sb.append(file.canExecute());
                sb.append(FDManager.LINE_SEPERATOR);
            }
            for (File file2 : parentFile.listFiles(new FileFilter() { // from class: com.autonavi.common.tool.DatabaseCollector.2
                @Override // java.io.FileFilter
                public boolean accept(File file3) {
                    return !file3.getName().endsWith("-journal");
                }
            })) {
                sb.append(getDatabaseInfo(file2));
            }
        } catch (Throwable th2) {
            try {
                sb.append("getDatabaseInfoError." + th2.toString());
            } catch (Throwable unused2) {
            }
        }
        return sb.toString();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static java.lang.String getDatabaseInfo(java.io.File r17) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.common.tool.DatabaseCollector.getDatabaseInfo(java.io.File):java.lang.String");
    }

    private static int getLimitFdCount() {
        final int[] iArr = new int[1];
        IOUtil.readFile(new File("/proc/self/limits"), new IOUtil.ReadFileCallback() { // from class: com.autonavi.common.tool.DatabaseCollector.3
            @Override // com.autonavi.common.tool.util.IOUtil.ReadFileCallback
            public boolean onLine(String str) {
                if (str.contains("Max open files")) {
                    String[] split = str.split("\\s+");
                    if (split == null || split.length <= 4) {
                        return true;
                    }
                    iArr[0] = Integer.valueOf(split[3]).intValue();
                    return true;
                }
                return false;
            }
        });
        return iArr[0];
    }

    private static int getCurrentFdCount() {
        try {
            File file = new File("/proc/self/fd");
            if (file.exists() && file.isDirectory()) {
                return file.listFiles().length;
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
