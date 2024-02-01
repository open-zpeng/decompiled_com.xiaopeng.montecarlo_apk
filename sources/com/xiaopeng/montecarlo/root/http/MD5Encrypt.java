package com.xiaopeng.montecarlo.root.http;

import android.text.TextUtils;
import com.alibaba.android.ark.AIMGroupService;
import com.xiaopeng.montecarlo.root.util.L;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public class MD5Encrypt {
    private static final String ENCNAME = "MD5";
    private static final String ENCODE = "UTF-8";
    private static final L.Tag TAG = new L.Tag("MD5Encrypt");

    public static String getMessageDigest(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes("UTF-8");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(bytes);
        return bytes2Hex(messageDigest.digest()).toLowerCase();
    }

    public static String getMD5Three(String str) {
        FileInputStream fileInputStream = null;
        try {
            try {
                byte[] bArr = new byte[8192];
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                FileInputStream fileInputStream2 = new FileInputStream(new File(str));
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return "";
                            } catch (Exception unused) {
                                return "";
                            }
                        }
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                }
                fileInputStream2.close();
                String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
                try {
                    fileInputStream2.close();
                } catch (Exception unused3) {
                }
                return bigInteger;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String bytes2Hex(byte[] bArr) {
        String str = "";
        if (bArr == null) {
            return "";
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & AIMGroupService.AIM_MAX_GROUP_MEMBER_CURSOR);
            if (hexString.length() == 1) {
                str = str + "0";
            }
            str = str + hexString;
        }
        return str;
    }
}
