package com.autonavi.common.tool.util;

import android.text.TextUtils;
import com.alibaba.android.ark.AIMGroupService;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class MessageDigestUtil {
    private static final char[] MD5_STR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String md5(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes("utf-8");
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[digest.length * 2];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                cArr[i] = MD5_STR[(b >>> 4) & 15];
                i = i2 + 1;
                cArr[i2] = MD5_STR[b & 15];
            }
            return new String(cArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFileMD5(String str) {
        int i;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
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
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i2 = b & AIMGroupService.AIM_MAX_GROUP_MEMBER_CURSOR;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFileMD5(File file) {
        int i;
        try {
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
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
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b : digest) {
                    int i2 = b & AIMGroupService.AIM_MAX_GROUP_MEMBER_CURSOR;
                    if (i2 < 16) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(Integer.toHexString(i2));
                }
                return stringBuffer.toString();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getStringMD5(String str) {
        try {
            return getByteArrayMD5(replaceBlank(str).getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getByteArrayMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[digest.length * 2];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                cArr[i] = MD5_STR[(b >> 4) & 15];
                i = i2 + 1;
                cArr[i2] = MD5_STR[b & 15];
            }
            return new String(cArr);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String replaceBlank(String str) {
        return str != null ? Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("") : "";
    }

    public static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] bytes = URLEncoder.encode(str, "UTF-8").getBytes("UTF-8");
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] + 16);
                int i2 = bytes[i] & AIMGroupService.AIM_MAX_GROUP_MEMBER_CURSOR;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
