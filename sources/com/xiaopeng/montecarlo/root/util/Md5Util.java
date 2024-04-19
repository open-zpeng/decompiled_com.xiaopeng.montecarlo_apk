package com.xiaopeng.montecarlo.root.util;

import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public class Md5Util {
    private static String[] sCharSet = {"0", "1", "2", "3", "4", "5", BuildInfoUtils.BID_PT_SPECIAL_2, "7", BLParams.AOS_ROUTE_TYPE_NO_FREEWAY, "9", "a", "b", "c", "d", "e", "f"};

    public static String toMd5Hex(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("md5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder(32);
            for (byte b : digest) {
                sb.append(sCharSet[(b >>> 4) & 15]);
                sb.append(sCharSet[b & 15]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toBit16Md5Hex(String str) {
        return toMd5Hex(str).substring(8, 24);
    }
}
