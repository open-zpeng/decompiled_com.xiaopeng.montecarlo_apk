package com.xiaopeng.montecarlo.root.util.ioutil;

import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.autonavi.common.tool.FDManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* loaded from: classes2.dex */
public class FileUtil {
    private static final L.Tag TAG = new L.Tag("FileUtil");

    public static Date getLastModifyTime(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(file.lastModified());
            return calendar.getTime();
        }
        return null;
    }

    public static long getDirSize(File file, boolean z) {
        File[] listFiles;
        long length;
        long j = 0;
        if (file == null || !file.exists()) {
            L.w(TAG, "does not exist");
            return 0L;
        }
        L.i(TAG, file.getAbsolutePath());
        if (file.isFile()) {
            return file.length();
        }
        for (File file2 : file.listFiles()) {
            if (!file2.isDirectory()) {
                length = file2.length();
            } else if (z) {
                length = getDirSize(file2, z);
            }
            j += length;
        }
        return j;
    }

    public static ArrayList<File> getFilesInDir(String str, FileFilter fileFilter) {
        ArrayList<File> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles(fileFilter);
                for (File file2 : listFiles) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    public static boolean deleteDir(File file) {
        String[] list;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!deleteDir(new File(file, str))) {
                    L.i(TAG, "deleteDir failed : " + str);
                } else {
                    L.i(TAG, "deleteDir succeed : " + str);
                }
            }
        }
        return file.delete();
    }

    public static String loadFromAssets(String str) {
        try {
            InputStream open = ContextUtils.getContext().getAssets().open(str);
            r0 = open != null ? inputStream2String(open) : null;
            if (open != null) {
                open.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return r0;
    }

    public static String inputStream2String(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (inputStream == null) {
            return sb.toString();
        }
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                sb.append(new String(bArr, 0, read));
            } else {
                return sb.toString();
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static byte[] loadDataFromAssets(java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r1 = 0
            if (r0 != 0) goto L73
            android.content.Context r0 = com.xiaopeng.montecarlo.root.util.ContextUtils.getContext()     // Catch: java.io.IOException -> L6f
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch: java.io.IOException -> L6f
            java.io.InputStream r6 = r0.open(r6)     // Catch: java.io.IOException -> L6f
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L56
            r0.<init>()     // Catch: java.lang.Throwable -> L56
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L3e
        L1c:
            r3 = -1
            int r4 = r6.read(r2)     // Catch: java.lang.Throwable -> L3e
            if (r3 == r4) goto L28
            r3 = 0
            r0.write(r2, r3, r4)     // Catch: java.lang.Throwable -> L3e
            goto L1c
        L28:
            r0.flush()     // Catch: java.lang.Throwable -> L3e
            byte[] r2 = r0.toByteArray()     // Catch: java.lang.Throwable -> L3e
            r0.close()     // Catch: java.lang.Throwable -> L39
            if (r6 == 0) goto L37
            r6.close()     // Catch: java.io.IOException -> L6c
        L37:
            r1 = r2
            goto L73
        L39:
            r0 = move-exception
            goto L58
        L3b:
            r2 = move-exception
            r3 = r1
            goto L44
        L3e:
            r2 = move-exception
            throw r2     // Catch: java.lang.Throwable -> L40
        L40:
            r3 = move-exception
            r5 = r3
            r3 = r2
            r2 = r5
        L44:
            if (r3 == 0) goto L4f
            r0.close()     // Catch: java.lang.Throwable -> L4a
            goto L52
        L4a:
            r0 = move-exception
            r3.addSuppressed(r0)     // Catch: java.lang.Throwable -> L56
            goto L52
        L4f:
            r0.close()     // Catch: java.lang.Throwable -> L56
        L52:
            throw r2     // Catch: java.lang.Throwable -> L56
        L53:
            r0 = move-exception
            r2 = r1
            goto L5b
        L56:
            r0 = move-exception
            r2 = r1
        L58:
            r1 = r0
            throw r1     // Catch: java.lang.Throwable -> L5a
        L5a:
            r0 = move-exception
        L5b:
            if (r6 == 0) goto L6b
            if (r1 == 0) goto L68
            r6.close()     // Catch: java.lang.Throwable -> L63
            goto L6b
        L63:
            r6 = move-exception
            r1.addSuppressed(r6)     // Catch: java.io.IOException -> L6c
            goto L6b
        L68:
            r6.close()     // Catch: java.io.IOException -> L6c
        L6b:
            throw r0     // Catch: java.io.IOException -> L6c
        L6c:
            r6 = move-exception
            r1 = r2
            goto L70
        L6f:
            r6 = move-exception
        L70:
            r6.printStackTrace()
        L73:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.root.util.ioutil.FileUtil.loadDataFromAssets(java.lang.String):byte[]");
    }

    public static String[] getFileNameFromAssets(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return ContextUtils.getContext().getAssets().list(str);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean copyAssetsFolder(String str, String str2) {
        return copyAssetsFolder(null, str, str2);
    }

    public static boolean copyAssetsFolder(@Nullable AssetManager assetManager, String str, String str2) {
        int length = str == null ? 0 : str.length();
        if (length == 0) {
            L.e(TAG, "copyAssetsFolder fail as srcFile path is empty,newPath:" + str2);
            return false;
        }
        if (assetManager == null) {
            if (ContextUtils.getContext() == null) {
                L.e(TAG, "copyAssetsFolder fail as context is null,src:" + str);
                return false;
            }
            assetManager = ContextUtils.getContext().getAssets();
        }
        if (str.endsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            str = str.substring(0, length - 1);
        }
        try {
            String[] list = assetManager.list(str);
            if (list != null && list.length > 0) {
                new File(str2).mkdirs();
                boolean z = true;
                for (String str3 : list) {
                    z &= copyAssetsFolder(assetManager, str + MqttTopic.TOPIC_LEVEL_SEPARATOR + str3, str2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + str3);
                }
                return z;
            }
            try {
                InputStream open = assetManager.open(str);
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                if (open != null) {
                    open.close();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                L.w(TAG, "复制asset文件出错: " + str + FDManager.LINE_SEPERATOR + e.getMessage());
                return false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void copyFileFromAssets(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str2 + File.separator + str3);
        try {
            InputStream open = ContextUtils.getContext().getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = open.read(bArr);
                if (-1 == read) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            if (open != null) {
                open.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean copyAssets(File file, String str) {
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        boolean z = false;
        try {
            InputStream open = ContextUtils.getContext().getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read < 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            z = true;
            fileOutputStream.close();
            if (open != null) {
                open.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    public static boolean existFile(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static boolean copyFolder(String str, String str2) {
        String[] list;
        File file;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        File file2 = new File(str2);
        if (!file2.exists() && !file2.mkdirs()) {
            L.w(TAG, ">>> copyFolder cannot create directory by newPath");
            return false;
        }
        File file3 = new File(str);
        if (!file3.exists()) {
            L.w(TAG, str + " does not exist");
            return false;
        }
        for (String str3 : file3.list()) {
            if (str.endsWith(File.separator)) {
                file = new File(str + str3);
            } else {
                file = new File(str + File.separator + str3);
            }
            if (file.isDirectory()) {
                return copyFolder(file.getPath(), str2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + str3);
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(str2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + file.getName());
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static boolean copyFile(String str, String str2, String str3, String str4) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            L.w(TAG, ">>> copyFile error : empty para");
            return false;
        }
        File file = new File(str + MqttTopic.TOPIC_LEVEL_SEPARATOR + str3);
        if (!file.exists()) {
            L.w(TAG, ">>> copyFile error : old file was not exist");
            return false;
        }
        File file2 = new File(str2);
        if (!file2.exists()) {
            boolean mkdir = file2.mkdir();
            L.Tag tag = TAG;
            L.i(tag, "check mkdir" + str2 + "ret:" + mkdir);
        }
        if (!TextUtils.isEmpty(str4)) {
            str3 = str4;
        }
        File file3 = new File(str2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + str3);
        if (file3.exists()) {
            file3.delete();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            file3.createNewFile();
            FileDescriptor fd = fileOutputStream.getFD();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            fd.sync();
            z = true;
            fileOutputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            L.Tag tag2 = TAG;
            L.e(tag2, file3.getAbsolutePath() + " " + e.getMessage());
            e.printStackTrace();
        }
        return z;
    }

    public static void createFileWithByte(String str, String str2, byte[] bArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            L.w(TAG, ">>> createFileWithByte error : empty para");
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str + MqttTopic.TOPIC_LEVEL_SEPARATOR + str2);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            file2.createNewFile();
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            } catch (Exception e) {
                L.Tag tag = TAG;
                L.e(tag, file2.getName() + " " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void deleteFilesInFolder(String str, FileFilter fileFilter) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles(fileFilter);
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    public static void createFileDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static byte[] file2byte(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return file2byte(new File(str));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static byte[] file2byte(java.io.File r7) {
        /*
            boolean r0 = r7.exists()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.io.IOException -> L60
            r0.<init>(r7)     // Catch: java.io.IOException -> L60
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L4a
            r2.<init>()     // Catch: java.lang.Throwable -> L4a
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L32
        L16:
            int r4 = r0.read(r3)     // Catch: java.lang.Throwable -> L32
            r5 = -1
            if (r4 == r5) goto L22
            r5 = 0
            r2.write(r3, r5, r4)     // Catch: java.lang.Throwable -> L32
            goto L16
        L22:
            byte[] r3 = r2.toByteArray()     // Catch: java.lang.Throwable -> L32
            r2.close()     // Catch: java.lang.Throwable -> L2d
            r0.close()     // Catch: java.io.IOException -> L5e
            goto L65
        L2d:
            r1 = move-exception
            goto L4d
        L2f:
            r3 = move-exception
            r4 = r1
            goto L38
        L32:
            r3 = move-exception
            throw r3     // Catch: java.lang.Throwable -> L34
        L34:
            r4 = move-exception
            r6 = r4
            r4 = r3
            r3 = r6
        L38:
            if (r4 == 0) goto L43
            r2.close()     // Catch: java.lang.Throwable -> L3e
            goto L46
        L3e:
            r2 = move-exception
            r4.addSuppressed(r2)     // Catch: java.lang.Throwable -> L4a
            goto L46
        L43:
            r2.close()     // Catch: java.lang.Throwable -> L4a
        L46:
            throw r3     // Catch: java.lang.Throwable -> L4a
        L47:
            r2 = move-exception
            r3 = r1
            goto L4f
        L4a:
            r2 = move-exception
            r3 = r1
            r1 = r2
        L4d:
            throw r1     // Catch: java.lang.Throwable -> L4e
        L4e:
            r2 = move-exception
        L4f:
            if (r1 == 0) goto L5a
            r0.close()     // Catch: java.lang.Throwable -> L55
            goto L5d
        L55:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch: java.io.IOException -> L5e
            goto L5d
        L5a:
            r0.close()     // Catch: java.io.IOException -> L5e
        L5d:
            throw r2     // Catch: java.io.IOException -> L5e
        L5e:
            r0 = move-exception
            goto L62
        L60:
            r0 = move-exception
            r3 = r1
        L62:
            r0.printStackTrace()
        L65:
            com.xiaopeng.montecarlo.root.util.L$Tag r0 = com.xiaopeng.montecarlo.root.util.ioutil.FileUtil.TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "File2byte: path = "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.xiaopeng.montecarlo.root.util.L.d(r0, r7)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.root.util.ioutil.FileUtil.file2byte(java.io.File):byte[]");
    }

    public static void safetyClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static File createNewFileWith755Permission(String str) {
        File file;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file2 = new File(str.substring(0, str.lastIndexOf(File.separator)));
            if (!file2.exists()) {
                file2.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            file = new File(str);
        } catch (Exception e2) {
            e = e2;
            file = null;
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            setFileWith755Permission(file);
            return file;
        }
        setFileWith755Permission(file);
        return file;
    }

    public static void setFileWith755Permission(File file) {
        if (file == null) {
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "setFileWith755Permission-- " + file.getAbsolutePath());
        if (Build.VERSION.SDK_INT >= 26) {
            Path path = Paths.get(file.getAbsolutePath(), new String[0]);
            try {
                Set<PosixFilePermission> permissions = ((PosixFileAttributes) Files.readAttributes(path, PosixFileAttributes.class, new LinkOption[0])).permissions();
                permissions.add(PosixFilePermission.OWNER_WRITE);
                permissions.add(PosixFilePermission.OWNER_READ);
                permissions.add(PosixFilePermission.OWNER_EXECUTE);
                permissions.add(PosixFilePermission.GROUP_READ);
                permissions.add(PosixFilePermission.GROUP_EXECUTE);
                permissions.add(PosixFilePermission.OTHERS_READ);
                permissions.add(PosixFilePermission.OTHERS_EXECUTE);
                Files.setPosixFilePermissions(path, permissions);
            } catch (IOException e) {
                L.w(TAG, e.getMessage());
            }
        }
    }

    public static String getFilePermission(File file) {
        if (file == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        L.Tag tag = TAG;
        L.i(tag, "getFilePermission-- " + file.getAbsolutePath());
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                for (PosixFilePermission posixFilePermission : ((PosixFileAttributes) Files.readAttributes(Paths.get(file.getAbsolutePath(), new String[0]), PosixFileAttributes.class, new LinkOption[0])).permissions()) {
                    sb.append(posixFilePermission.name());
                    sb.append(",");
                }
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                }
                L.Tag tag2 = TAG;
                L.i(tag2, "getFilePermission-- " + file.getAbsolutePath() + ",permission:" + sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static void setFilePermissionRecursion(File file) {
        if (file != null && file.exists()) {
            setFileWith755Permission(file);
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "setProtoDataFilePermission 755 file:" + file.getAbsolutePath());
            }
            File parentFile = file.getParentFile();
            if (parentFile == null || RootUtil.MNT_VMAP.equals(parentFile.getAbsolutePath())) {
                return;
            }
            setFilePermissionRecursion(parentFile);
            return;
        }
        L.e(TAG, "setProtoDataFilePermission fail folder not exists");
    }

    public static void outputFilePermission(File file) {
        if (file != null && file.exists()) {
            getFilePermission(file);
            File parentFile = file.getParentFile();
            if (parentFile == null || RootUtil.MNT_VMAP.equals(parentFile.getAbsolutePath())) {
                return;
            }
            outputFilePermission(parentFile);
            return;
        }
        L.e(TAG, "outputFilePermission fail folder not exists");
    }
}
