package com.xiaopeng.montecarlo.navcore.mapdisplay;

import android.graphics.Bitmap;
import java.io.File;
/* loaded from: classes3.dex */
public abstract class SaveFileRunnable implements Runnable {
    private final File mFile;
    private final PoolBitmap mPoolBitmap;

    abstract void save(File file, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: package-private */
    public SaveFileRunnable(PoolBitmap poolBitmap, File file) {
        this.mPoolBitmap = poolBitmap;
        this.mPoolBitmap.lock();
        this.mFile = file;
    }

    @Override // java.lang.Runnable
    public void run() {
        save(this.mFile, this.mPoolBitmap.mBitmap);
        this.mPoolBitmap.unlock();
        this.mPoolBitmap.recycle();
    }
}
