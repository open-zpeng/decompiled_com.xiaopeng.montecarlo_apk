package com.xiaopeng.montecarlo.navcore.mapdisplay;

import android.graphics.Bitmap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes3.dex */
public class JPEGSaveFileRunnable extends SaveFileRunnable {
    public JPEGSaveFileRunnable(PoolBitmap poolBitmap, File file) {
        super(poolBitmap, file);
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.SaveFileRunnable
    void save(File file, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        if (file.exists()) {
            file.delete();
        }
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (IOException e) {
            e = e;
            fileOutputStream = null;
        }
        try {
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }
}
