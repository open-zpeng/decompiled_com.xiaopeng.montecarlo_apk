package com.xiaopeng.montecarlo.navcore.util;

import android.content.Context;
import android.database.Cursor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
public class IOUtils {
    private static final String PROJECT_DIR_NAME = "autotest";

    public static byte[] decodeAssetResData(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    open.close();
                    return byteArray;
                }
            }
        } catch (IOException | OutOfMemoryError unused) {
            return null;
        }
    }

    public static String getFileMD5(String str) {
        FileInputStream fileInputStream;
        int i;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    int i2 = b & 255;
                    if (i2 < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(i2));
                }
                String sb2 = sb.toString();
                closeQuietly(fileInputStream);
                return sb2;
            } catch (Exception unused) {
                closeQuietly(fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static String getFileMD5(File file) {
        FileInputStream fileInputStream;
        int i;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                fileInputStream.close();
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    int i2 = b & 255;
                    if (i2 < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(i2));
                }
                String sb2 = sb.toString();
                closeQuietly(fileInputStream);
                return sb2;
            } catch (Exception unused) {
                closeQuietly(fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static void closeQuietly(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getByteArrayMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
