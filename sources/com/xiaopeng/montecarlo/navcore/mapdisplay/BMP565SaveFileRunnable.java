package com.xiaopeng.montecarlo.navcore.mapdisplay;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes3.dex */
public class BMP565SaveFileRunnable extends SaveFileRunnable {
    public BMP565SaveFileRunnable(PoolBitmap poolBitmap, File file) {
        super(poolBitmap, file);
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.SaveFileRunnable
    void save(File file, Bitmap bitmap) {
        byte[] bArr;
        FileOutputStream fileOutputStream;
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    int[] iArr = new int[width * height];
                    bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
                    byte[] addBMP_RGB_565 = addBMP_RGB_565(iArr, width, height);
                    byte[] addBMPImageHeader = addBMPImageHeader(addBMP_RGB_565.length + 66);
                    byte[] addBMPImageInfosHeader = addBMPImageInfosHeader(width, height);
                    byte[] add565RgbQuad = add565RgbQuad();
                    bArr = new byte[addBMP_RGB_565.length + 66];
                    System.arraycopy(addBMPImageHeader, 0, bArr, 0, addBMPImageHeader.length);
                    System.arraycopy(addBMPImageInfosHeader, 0, bArr, 14, addBMPImageInfosHeader.length);
                    System.arraycopy(add565RgbQuad, 0, bArr, 54, add565RgbQuad.length);
                    System.arraycopy(addBMP_RGB_565, 0, bArr, 66, addBMP_RGB_565.length);
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                fileOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    private byte[] addBMPImageHeader(int i) {
        return new byte[]{66, 77, (byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255), 0, 0, 0, 0, 66, 0, 0, 0};
    }

    private byte[] addBMPImageInfosHeader(int i, int i2) {
        return new byte[]{40, 0, 0, 0, (byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255), (byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255), 1, 0, 16, 0, 3, 0, 0, 0, 0, 0, 0, 0, -48, 2, 0, 0, -32, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    private byte[] add565RgbQuad() {
        return new byte[]{0, -8, 0, 0, -32, 7, 0, 0, 31, 0, 0, 0};
    }

    private byte[] addBMP_RGB_565(int[] iArr, int i, int i2) {
        int length = iArr.length;
        Log.i("MediaCodec", "b.length:" + iArr.length + " w:" + i + " h:" + i2);
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
}
