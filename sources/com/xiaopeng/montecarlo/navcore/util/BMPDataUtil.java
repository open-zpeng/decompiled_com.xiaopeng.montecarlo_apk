package com.xiaopeng.montecarlo.navcore.util;

import android.graphics.Bitmap;
import com.xiaopeng.montecarlo.root.util.L;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.commons.compress.archivers.tar.TarConstants;
/* loaded from: classes3.dex */
public class BMPDataUtil {
    private static final L.Tag TAG = new L.Tag("BMPDataUtil");
    private static int[] sPixels = new int[1048576];

    public static byte[] bitmap2JpgData(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bitmap == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (IOException e) {
            e = e;
            byteArrayOutputStream = null;
        }
        try {
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream)) {
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            return null;
        }
        return null;
    }

    public static byte[] bitmap2PngData(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bitmap == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (IOException e) {
            e = e;
            byteArrayOutputStream = null;
        }
        try {
            if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)) {
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            return null;
        }
        return null;
    }

    public static byte[] bitmap2Bmp565Data(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] addBmp2Rgb565 = addBmp2Rgb565(iArr, width, height);
        byte[] addBmp565FileHeader = addBmp565FileHeader(addBmp2Rgb565.length + 66);
        byte[] addBmp565InfoHeader = addBmp565InfoHeader(width, height);
        byte[] addBmp565RgbQuad = addBmp565RgbQuad();
        byte[] bArr = new byte[addBmp2Rgb565.length + 66];
        System.arraycopy(addBmp565FileHeader, 0, bArr, 0, addBmp565FileHeader.length);
        System.arraycopy(addBmp565InfoHeader, 0, bArr, 14, addBmp565InfoHeader.length);
        System.arraycopy(addBmp565RgbQuad, 0, bArr, 54, addBmp565RgbQuad.length);
        System.arraycopy(addBmp2Rgb565, 0, bArr, 66, addBmp2Rgb565.length);
        return bArr;
    }

    public static byte[] bitmap2Bmp888Data(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] addBmp2Rgb888 = addBmp2Rgb888(iArr, width, height);
        byte[] addBmp888FileHeader = addBmp888FileHeader(addBmp2Rgb888.length);
        byte[] addBmp888InfoHeader = addBmp888InfoHeader(width, height);
        byte[] bArr = new byte[addBmp2Rgb888.length + 54];
        System.arraycopy(addBmp888FileHeader, 0, bArr, 0, addBmp888FileHeader.length);
        System.arraycopy(addBmp888InfoHeader, 0, bArr, 14, addBmp888InfoHeader.length);
        System.arraycopy(addBmp2Rgb888, 0, bArr, 54, addBmp2Rgb888.length);
        return bArr;
    }

    public static void bitmap2RGB565Data(byte[] bArr, Bitmap bitmap) {
        if (bitmap == null || bArr == null) {
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        bitmap.getPixels(sPixels, 0, width, 0, 0, width, height);
        int i = height * width;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + width;
            int i5 = i4 - 1;
            while (i2 <= i5) {
                int[] iArr = sPixels;
                bArr[i3] = (byte) (((iArr[i2] >> 13) & 7) | ((iArr[i2] >> 16) & 248));
                bArr[i3 + 1] = (byte) ((((iArr[i2] >> 10) & 7) << 5) | ((iArr[i2] & 248) >> 3));
                i3 += 2;
                i2++;
            }
            i2 = i4;
        }
    }

    public static void bitmap2RGB888Data(byte[] bArr, Bitmap bitmap) {
        if (bitmap == null || bArr == null) {
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        bitmap.getPixels(sPixels, 0, width, 0, 0, width, height);
        int i = height * width;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + width;
            int i5 = i4 - 1;
            while (i2 <= i5) {
                int[] iArr = sPixels;
                bArr[i3] = (byte) ((iArr[i2] >> 16) & 255);
                bArr[i3 + 1] = (byte) ((iArr[i2] >> 8) & 255);
                bArr[i3 + 2] = (byte) (iArr[i2] & 255);
                i3 += 3;
                i2++;
            }
            i2 = i4;
        }
    }

    private static byte[] addBmp2Rgb565(int[] iArr, int i, int i2) {
        int length = iArr.length;
        L.Tag tag = TAG;
        L.i(tag, "addBmp2Rgb565 b.length:" + iArr.length + " w:" + i + " h:" + i2);
        byte[] bArr = new byte[i2 * i * 2];
        int i3 = length + (-1);
        int i4 = 0;
        while (i3 >= i) {
            int i5 = i3 - i;
            for (int i6 = i5 + 1; i6 <= i3; i6++) {
                bArr[i4] = (byte) (((iArr[i6] & 248) >> 3) | (((iArr[i6] >> 10) & 7) << 5));
                bArr[i4 + 1] = (byte) (((iArr[i6] >> 13) & 7) | ((iArr[i6] >> 16) & 248));
                i4 += 2;
            }
            i3 = i5;
        }
        return bArr;
    }

    private static byte[] addBmp565FileHeader(int i) {
        return new byte[]{66, 77, (byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255), 0, 0, 0, 0, 66, 0, 0, 0};
    }

    private static byte[] addBmp565InfoHeader(int i, int i2) {
        return new byte[]{40, 0, 0, 0, (byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255), (byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255), 1, 0, 16, 0, 3, 0, 0, 0, 0, 0, 0, 0, -48, 2, 0, 0, -32, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    private static byte[] addBmp565RgbQuad() {
        return new byte[]{0, -8, 0, 0, -32, 7, 0, 0, 31, 0, 0, 0};
    }

    private static byte[] addBmp2Rgb888(int[] iArr, int i, int i2) {
        int length = iArr.length;
        L.Tag tag = TAG;
        L.i(tag, "addBmp2Rgb888 b.length:" + iArr.length + " w:" + i + " h:" + i2);
        byte[] bArr = new byte[i2 * i * 3];
        int i3 = length + (-1);
        int i4 = 0;
        while (i3 >= i) {
            int i5 = i3 - i;
            for (int i6 = i5 + 1; i6 <= i3; i6++) {
                bArr[i4] = (byte) (iArr[i6] & 255);
                bArr[i4 + 1] = (byte) ((iArr[i6] >> 8) & 255);
                bArr[i4 + 2] = (byte) ((iArr[i6] >> 16) & 255);
                i4 += 3;
            }
            i3 = i5;
        }
        return bArr;
    }

    private static byte[] addBmp888FileHeader(int i) {
        return new byte[]{66, 77, (byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255), 0, 0, 0, 0, TarConstants.LF_FIFO, 0, 0, 0};
    }

    private static byte[] addBmp888InfoHeader(int i, int i2) {
        return new byte[]{40, 0, 0, 0, (byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255), (byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255), 1, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, -48, 2, 0, 0, -32, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}
