package com.autonavi.common.tool.util;

import android.database.Cursor;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class IOUtil {

    /* loaded from: classes.dex */
    public interface ReadFileCallback {
        boolean onLine(String str);
    }

    private IOUtil() {
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void closeQuietly(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static byte[] readBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    closeQuietly(byteArrayOutputStream);
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            closeQuietly(byteArrayOutputStream);
            throw th;
        }
    }

    public static String readStr(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[1024];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read >= 0) {
                sb.append(cArr, 0, read);
            } else {
                return sb.toString();
            }
        }
    }

    public static void writeStr(OutputStream outputStream, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
        outputStreamWriter.write(str);
        outputStreamWriter.flush();
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        if (!(outputStream instanceof BufferedOutputStream)) {
            outputStream = new BufferedOutputStream(outputStream);
        }
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    public static boolean deleteFileOrDir(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (!deleteFileOrDir(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static void writeStringToFile(String str, File file, boolean z) {
        PrintWriter printWriter;
        if (TextUtils.isEmpty(str) || file == null || !file.exists()) {
            return;
        }
        PrintWriter printWriter2 = null;
        try {
            try {
                printWriter = new PrintWriter(new FileOutputStream(file, z));
            } catch (Throwable th) {
                th = th;
            }
            try {
                printWriter.print(str);
                printWriter.flush();
                printWriter.close();
            } catch (Throwable th2) {
                th = th2;
                printWriter2 = printWriter;
                try {
                    th.printStackTrace();
                    if (printWriter2 != null) {
                        printWriter2.close();
                    }
                } catch (Throwable th3) {
                    if (printWriter2 != null) {
                        try {
                            printWriter2.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void writeStringToFile(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        writeStringToFile(str, new File(str2), z);
    }

    public static String readStr(File file) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                String readStr = readStr(fileInputStream2);
                closeQuietly(fileInputStream2);
                return readStr;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    th.printStackTrace();
                    return "";
                } finally {
                    closeQuietly(fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void readFile(String str, ReadFileCallback readFileCallback) {
        readFile(new File(str), readFileCallback);
    }

    public static void readFile(File file, ReadFileCallback readFileCallback) {
        String readLine;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
            } while (!readFileCallback.onLine(readLine));
            bufferedReader.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void deleteFile(File file) {
        if (file == null) {
            return;
        }
        File[] listFiles = file.listFiles();
        if (file.isDirectory() && listFiles != null) {
            for (File file2 : listFiles) {
                deleteFile(file2);
            }
        }
        file.delete();
    }
}
