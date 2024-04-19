package com.xiaopeng.montecarlo.root.http;

import android.text.TextUtils;
import com.alibaba.android.ark.AIMGroupService;
import com.xiaopeng.montecarlo.root.util.L;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public class SignUtil {
    public static final String ENCRYPT_TYPE_MD5 = "MD5";
    private static final L.Tag TAG = new L.Tag("SignUtil");

    public static String signForDianPing(Map<String, String> map, String str, String str2) {
        ArrayList<String> arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getValue())) {
                arrayList.add(entry.getKey());
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        for (String str3 : arrayList) {
            sb.append(str3);
            sb.append(map.get(str3).trim());
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        String trim = sb.toString().trim();
        if (str2.equals("MD5")) {
            try {
                return MD5Encrypt.getMessageDigest(trim);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return "";
    }

    public static String sha256_HMAC(String str, String str2) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(str2.getBytes("UTF-8"), "HmacSHA256"));
            return byteArrayToHexString(mac.doFinal(str.getBytes()));
        } catch (Exception e) {
            L.w(TAG, "sha256_HMAC exception error");
            e.printStackTrace();
            return "";
        }
    }

    public static String sha256(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            return byteArrayToHexString(messageDigest.digest());
        } catch (Exception e) {
            L.w(TAG, "sha256 exception error");
            e.printStackTrace();
            return "";
        }
    }

    private static String byteArrayToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; bArr != null && i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i] & AIMGroupService.AIM_MAX_GROUP_MEMBER_CURSOR);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString().toLowerCase();
    }

    private static String sortList(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(((String) arrayList.get(i)).toUpperCase());
            sb.append("=");
            sb.append(map.get(arrayList.get(i)));
            if (i != arrayList.size() - 1) {
                sb.append("&");
            }
        }
        return sb.toString();
    }
}
