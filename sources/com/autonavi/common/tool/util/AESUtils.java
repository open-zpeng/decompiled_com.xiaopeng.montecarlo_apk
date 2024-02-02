package com.autonavi.common.tool.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class AESUtils {
    public static final String IV = "0/YlofxqeTHYyA==";
    public static final String KEY = "5FrulYREMC5yAA==";

    public static String Encrypt(String str) throws Exception {
        return Encrypt(str.getBytes());
    }

    public static String Encrypt(byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(IV.getBytes()));
        return Base64Encoder.encode(cipher.doFinal(bArr));
    }

    public static String Decrypt(String str) throws Exception {
        try {
            Cipher.getInstance("AES/CBC/PKCS5Padding").init(2, new SecretKeySpec(KEY.getBytes("utf-8"), "AES"), new IvParameterSpec(IV.getBytes()));
            return null;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    private static String getOrderMap(Map<String, Object> map) {
        ArrayList<String> arrayList = new ArrayList();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            arrayList.add(entry.getValue().toString());
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            sb.append(str);
        }
        return sb.toString();
    }
}
