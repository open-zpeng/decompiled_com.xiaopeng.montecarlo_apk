package com.xiaopeng.montecarlo.root.util.ioutil;

import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.logcat.ILogFileOperationCallback;
import com.xiaopeng.montecarlo.root.util.logcat.LogDir;
import com.xiaopeng.montecarlo.root.util.logcat.LogFileStatus;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes3.dex */
public class ZipUtil {
    private static final String FILE_SUFFIX_GZ = ".gz";
    private static final String FILE_SUFFIX_ZIP = ".zip";
    private static final String FILE_SUFFIX_ZS = ".zs";
    private static final L.Tag TAG = new L.Tag("ZipUtil");
    private static final int ZIP_BUFFER = 4096;

    public static boolean isZipFile(File file) {
        return true;
    }

    private static void recursionZip(ZipOutputStream zipOutputStream, File file, String str, ILogFileOperationCallback iLogFileOperationCallback) throws Exception {
        FileInputStream fileInputStream;
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                recursionZip(zipOutputStream, file2, str + file.getName() + File.separator, iLogFileOperationCallback);
            }
            return;
        }
        byte[] bArr = new byte[4096];
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e) {
                throw e;
            }
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            L.i(TAG, "add zip file: " + file.getName());
            iLogFileOperationCallback.onStatusChange(LogFileStatus.CopyLogFileStatus.LOG_FILE_ZIP_PROCESS, LogFileStatus.CopyLogFileErrCode.LOG_FILE_NO_ERROR, 0L, file.getName());
            zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return;
                }
            }
        } catch (Exception e2) {
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static void zipFolderToSingleFile(LogDir logDir, ZipOutputStream zipOutputStream, ILogFileOperationCallback iLogFileOperationCallback) throws Exception {
        FileInputStream fileInputStream;
        String udiskDirName = logDir.getUdiskDirName();
        Iterator<File> it = FileUtil.getFilesInDir(logDir.getAbsSourcePath(), new LogFileFilter()).iterator();
        while (it.hasNext()) {
            File next = it.next();
            if (next.isDirectory() && logDir.isNeedRecursive()) {
                if (logDir.isNeedRecursive()) {
                    zipFolderToSingleFile(new LogDir(logDir.getUdiskDirName() + File.separator + next.getName(), next.getAbsolutePath(), logDir.isNeedRecursive()), zipOutputStream, iLogFileOperationCallback);
                }
            } else if (next.isFile()) {
                byte[] bArr = new byte[4096];
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(next);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                    }
                } catch (Exception e) {
                    e = e;
                }
                try {
                    L.Tag tag = TAG;
                    L.i(tag, "add zip file: " + next.getName());
                    iLogFileOperationCallback.onStatusChange(LogFileStatus.CopyLogFileStatus.LOG_FILE_ZIP_PROCESS, LogFileStatus.CopyLogFileErrCode.LOG_FILE_NO_ERROR, next.length(), next.getName());
                    zipOutputStream.putNextEntry(new ZipEntry(udiskDirName + File.separator + next.getName()));
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                    fileInputStream.close();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    L.Tag tag2 = TAG;
                    L.w(tag2, "throw:" + e.getMessage());
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } else {
                continue;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.OutputStream, java.io.FileOutputStream] */
    public static boolean zipFolders2SingleFile(ArrayList<LogDir> arrayList, String str, String str2, ILogFileOperationCallback iLogFileOperationCallback) {
        FileDescriptor fd;
        ZipOutputStream zipOutputStream;
        File file = new File(str);
        ?? exists = file.exists();
        if (exists == 0) {
            file.mkdir();
        }
        ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                exists = new FileOutputStream(str + str2 + FILE_SUFFIX_ZIP);
                try {
                    fd = exists.getFD();
                    zipOutputStream = new ZipOutputStream(exists);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                Iterator<LogDir> it = arrayList.iterator();
                while (it.hasNext()) {
                    zipFolderToSingleFile(it.next(), zipOutputStream, iLogFileOperationCallback);
                }
                L.i(TAG, "zipFolderToSingleFile all done");
                zipOutputStream.flush();
                zipOutputStream.finish();
                exists.flush();
                fd.sync();
                try {
                    zipOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    exists.close();
                    return true;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return true;
                }
            } catch (Exception e4) {
                e = e4;
                zipOutputStream2 = zipOutputStream;
                L.e(TAG, e.getMessage());
                e.printStackTrace();
                if (zipOutputStream2 != null) {
                    try {
                        zipOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                if (exists != 0) {
                    try {
                        exists.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream2 = zipOutputStream;
                if (zipOutputStream2 != null) {
                    try {
                        zipOutputStream2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                if (exists != 0) {
                    try {
                        exists.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            exists = 0;
        } catch (Throwable th3) {
            th = th3;
            exists = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x01e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x019a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.util.zip.ZipOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zipFolderToSingleFile(java.io.File r19, java.lang.String r20, java.lang.String r21, boolean r22, com.xiaopeng.montecarlo.root.util.logcat.ILogFileOperationCallback r23) {
        /*
            Method dump skipped, instructions count: 491
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.root.util.ioutil.ZipUtil.zipFolderToSingleFile(java.io.File, java.lang.String, java.lang.String, boolean, com.xiaopeng.montecarlo.root.util.logcat.ILogFileOperationCallback):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x010c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x012a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0141 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0102 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0134 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0119 A[Catch: IOException -> 0x00be, TRY_ENTER, TRY_LEAVE, TryCatch #17 {IOException -> 0x00be, blocks: (B:38:0x00b9, B:83:0x0119), top: B:126:0x004a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00bf -> B:125:0x011c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zipFile(java.io.File r8, java.lang.String r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.root.util.ioutil.ZipUtil.zipFile(java.io.File, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v6 */
    public static boolean zipFile(String str, String str2) {
        ZipOutputStream zipOutputStream;
        File file;
        try {
            try {
                zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                boolean zipFile = zipFile(file.getParent() + File.separator, new File(str).getName(), zipOutputStream);
                zipOutputStream.flush();
                zipOutputStream.finish();
                zipOutputStream.close();
                str = zipFile;
            } catch (IOException unused) {
                str = 0;
                str = 0;
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                return str;
            } catch (Throwable th) {
                th = th;
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            zipOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream = null;
        }
        return str;
    }

    private static boolean zipFile(String str, String str2, ZipOutputStream zipOutputStream) {
        FileInputStream fileInputStream;
        if (zipOutputStream == null) {
            return false;
        }
        File file = new File(str + str2);
        if (file.isFile()) {
            ZipEntry zipEntry = new ZipEntry(str2);
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    zipOutputStream.putNextEntry(zipEntry);
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                    zipOutputStream.closeEntry();
                    zipOutputStream.flush();
                    zipOutputStream.finish();
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        zipOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (IOException unused) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    try {
                        zipOutputStream.close();
                        return false;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    try {
                        zipOutputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0134 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x012a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0118  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.util.zip.ZipInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String unZipFolder(java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.root.util.ioutil.ZipUtil.unZipFolder(java.lang.String, java.lang.String):java.lang.String");
    }
}
