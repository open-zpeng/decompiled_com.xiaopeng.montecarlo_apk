package com.autonavi.gbl.map.adapter;

import java.util.zip.CRC32;
/* loaded from: classes.dex */
public class GLMD5Util {
    public static String getByteArrayCRC32(byte[] bArr) {
        try {
            CRC32 crc32 = new CRC32();
            crc32.update(bArr);
            return Long.toString(crc32.getValue());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
