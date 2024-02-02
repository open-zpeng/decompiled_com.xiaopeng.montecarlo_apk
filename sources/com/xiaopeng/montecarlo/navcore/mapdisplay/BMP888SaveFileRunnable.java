package com.xiaopeng.montecarlo.navcore.mapdisplay;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.compress.archivers.tar.TarConstants;
/* loaded from: classes2.dex */
public class BMP888SaveFileRunnable extends SaveFileRunnable {
    public BMP888SaveFileRunnable(PoolBitmap poolBitmap, File file) {
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
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            byte[] addBMP_RGB_888 = addBMP_RGB_888(iArr, width, height);
            byte[] addBMPImageHeader = addBMPImageHeader(addBMP_RGB_888.length);
            byte[] addBMPImageInfosHeader = addBMPImageInfosHeader(width, height);
            bArr = new byte[addBMP_RGB_888.length + 54];
            System.arraycopy(addBMPImageHeader, 0, bArr, 0, addBMPImageHeader.length);
            System.arraycopy(addBMPImageInfosHeader, 0, bArr, 14, addBMPImageInfosHeader.length);
            System.arraycopy(addBMP_RGB_888, 0, bArr, 54, addBMP_RGB_888.length);
            fileOutputStream = new FileOutputStream(file);
        } catch (IOException e) {
            e = e;
        }
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private byte[] addBMPImageHeader(int i) {
        return new byte[]{66, 77, (byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255), 0, 0, 0, 0, TarConstants.LF_FIFO, 0, 0, 0};
    }

    private byte[] addBMPImageInfosHeader(int i, int i2) {
        return new byte[]{40, 0, 0, 0, (byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255), (byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255), 1, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, -48, 2, 0, 0, -32, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    private byte[] addBMP_RGB_888(int[] iArr, int i, int i2) {
        int length = iArr.length;
        Log.i("MediaCodec", "b.length:" + iArr.length + " w:" + i + " h:" + i2);
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
}
