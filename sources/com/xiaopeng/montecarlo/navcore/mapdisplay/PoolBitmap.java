package com.xiaopeng.montecarlo.navcore.mapdisplay;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class PoolBitmap {
    private static final int MAX_POOL_SIZE = 50;
    private static PoolBitmap sPool;
    public Bitmap mBitmap;
    PoolBitmap mNext;
    private int mUsedCount = 0;
    public static final Object sPoolSync = new Object();
    private static int sPoolSize = 0;

    PoolBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public static PoolBitmap obtainBitmap(int i, int i2) {
        synchronized (sPoolSync) {
            if (sPool != null) {
                PoolBitmap poolBitmap = sPool;
                sPool = poolBitmap.mNext;
                poolBitmap.mNext = null;
                sPoolSize--;
                if (poolBitmap.mBitmap.getWidth() != i || poolBitmap.mBitmap.getHeight() != i2) {
                    if (!poolBitmap.mBitmap.isRecycled()) {
                        poolBitmap.mBitmap.recycle();
                    }
                    poolBitmap.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
                }
                return poolBitmap;
            }
            return new PoolBitmap(Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565));
        }
    }

    public synchronized void lock() {
        this.mUsedCount++;
    }

    public synchronized void unlock() {
        this.mUsedCount--;
    }

    public synchronized void recycle() {
        if (this.mUsedCount > 0) {
            return;
        }
        synchronized (sPoolSync) {
            if (this.mNext != null) {
                return;
            }
            if (sPoolSize < 50) {
                this.mNext = sPool;
                sPool = this;
                sPoolSize++;
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        recycle();
    }
}
