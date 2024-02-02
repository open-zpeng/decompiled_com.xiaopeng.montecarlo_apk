package com.xiaopeng.montecarlo.root.util.ioutil;

import com.xiaopeng.montecarlo.root.util.L;
import java.io.BufferedInputStream;
import java.util.BitSet;
import org.apache.commons.compress.utils.CharsetNames;
/* loaded from: classes2.dex */
public class EncodeUtil {
    private static final int BYTE_SIZE = 8;
    private static final String CODE_GBK = "GBK";
    private static final String CODE_UTF8 = "UTF-8";
    private static final String CODE_UTF8_BOM = "UTF-8_BOM";
    private static final L.Tag TAG = new L.Tag("EncodeUtil");

    public static String getEncode(BufferedInputStream bufferedInputStream, boolean z) throws Exception {
        bufferedInputStream.mark(0);
        byte[] bArr = new byte[3];
        bufferedInputStream.read(bArr);
        String str = "UTF-8";
        if (bArr[0] == -1 && bArr[1] == -2) {
            str = CharsetNames.UTF_16;
        } else if (bArr[0] == -2 && bArr[1] == -1) {
            str = "Unicode";
        } else if (bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) {
            if (!z) {
                str = CODE_UTF8_BOM;
            }
        } else if (!isUTF8(bufferedInputStream)) {
            str = CODE_GBK;
        }
        L.Tag tag = TAG;
        L.i(tag, "getEncode: " + str);
        return str;
    }

    private static boolean isUTF8(BufferedInputStream bufferedInputStream) throws Exception {
        bufferedInputStream.reset();
        int read = bufferedInputStream.read();
        do {
            BitSet convert2BitSet = convert2BitSet(read);
            if (convert2BitSet.get(0) && !checkMultiByte(bufferedInputStream, convert2BitSet)) {
                return false;
            }
            read = bufferedInputStream.read();
        } while (read != -1);
        return true;
    }

    private static boolean checkMultiByte(BufferedInputStream bufferedInputStream, BitSet bitSet) throws Exception {
        byte[] bArr = new byte[getCountOfSequential(bitSet) - 1];
        bufferedInputStream.read(bArr);
        for (byte b : bArr) {
            if (!checkUtf8Byte(b)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkUtf8Byte(byte b) throws Exception {
        BitSet convert2BitSet = convert2BitSet(b);
        return convert2BitSet.get(0) && !convert2BitSet.get(1);
    }

    private static int getCountOfSequential(BitSet bitSet) {
        int i = 0;
        for (int i2 = 0; i2 < 8 && bitSet.get(i2); i2++) {
            i++;
        }
        return i;
    }

    private static BitSet convert2BitSet(int i) {
        BitSet bitSet = new BitSet(8);
        for (int i2 = 0; i2 < 8; i2++) {
            if (((i >> ((8 - i2) - 1)) & 1) == 1) {
                bitSet.set(i2);
            }
        }
        return bitSet;
    }
}
