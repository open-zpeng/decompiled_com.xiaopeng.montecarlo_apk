package com.xiaopeng.montecarlo.xpglide;

import android.text.TextUtils;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.SafeKeyGenerator;
import com.xiaopeng.montecarlo.root.util.L;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
class XpGlideDiskCacheWrapper implements DiskCache, IXpGlideCache {
    private static final int APP_VERSION = 1;
    private static final L.Tag TAG = new L.Tag("XpGlideDiskCacheWrapper");
    private static final int VALUE_COUNT = 1;
    private static XpGlideDiskCacheWrapper mWrapper;
    private final File mDirectory;
    private DiskLruCache mDiskLruCache;
    private final long mMaxSize;
    private final DiskCacheWriteLocker mWriteLocker = new DiskCacheWriteLocker();
    private final Map<String, Key> mKeyMap = new HashMap();
    private final SafeKeyGenerator mSafeKeyGenerator = new SafeKeyGenerator();

    @Deprecated
    public static synchronized DiskCache get(File file, long j) {
        XpGlideDiskCacheWrapper xpGlideDiskCacheWrapper;
        synchronized (XpGlideDiskCacheWrapper.class) {
            if (mWrapper == null) {
                mWrapper = new XpGlideDiskCacheWrapper(file, j);
            }
            xpGlideDiskCacheWrapper = mWrapper;
        }
        return xpGlideDiskCacheWrapper;
    }

    public static DiskCache create(File file, long j) {
        return new XpGlideDiskCacheWrapper(file, j);
    }

    @Deprecated
    protected XpGlideDiskCacheWrapper(File file, long j) {
        this.mDirectory = file;
        this.mMaxSize = j;
    }

    private synchronized DiskLruCache getDiskCache() throws IOException {
        if (this.mDiskLruCache == null) {
            this.mDiskLruCache = DiskLruCache.open(this.mDirectory, 1, 1, this.mMaxSize);
        }
        return this.mDiskLruCache;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File get(Key key) {
        String safeKey = this.mSafeKeyGenerator.getSafeKey(key);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "Get: getSafeKey: " + safeKey + " for for Key: " + key);
        }
        try {
            DiskLruCache.Value value = getDiskCache().get(safeKey);
            if (value != null) {
                return value.getFile(0);
            }
            return null;
        } catch (IOException e) {
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.w(tag2, "Unable to get from disk cache" + e);
                return null;
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(Key key, DiskCache.Writer writer) {
        DiskLruCache diskCache;
        String safeKey = this.mSafeKeyGenerator.getSafeKey(key);
        this.mWriteLocker.acquire(safeKey);
        try {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "Put: Obtained: " + safeKey + " for for Key: " + key);
            }
            try {
                diskCache = getDiskCache();
            } catch (IOException e) {
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.w(tag2, "Unable to put to disk cache" + e);
                }
            }
            if (diskCache.get(safeKey) != null) {
                return;
            }
            DiskLruCache.Editor edit = diskCache.edit(safeKey);
            if (edit == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + safeKey);
            }
            try {
                if (writer.write(edit.getFile(0))) {
                    edit.commit();
                }
                this.mKeyMap.put(XpGlideUtil.getUrlFromKey(key), key);
                edit.abortUnlessCommitted();
            } catch (Throwable th) {
                edit.abortUnlessCommitted();
                throw th;
            }
        } finally {
            this.mWriteLocker.release(safeKey);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key key) {
        String safeKey = this.mSafeKeyGenerator.getSafeKey(key);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.i(tag, "delete: key =  " + key + " , safeKey = " + safeKey);
        }
        try {
            this.mKeyMap.remove(XpGlideUtil.getUrlFromKey(key));
            getDiskCache().remove(safeKey);
        } catch (IOException e) {
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.w(tag2, "Unable to delete from disk cache" + e);
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public synchronized void clear() {
        try {
            getDiskCache().delete();
        } catch (IOException e) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.w(tag, "Unable to clear disk cache or disk cache cleared externally" + e);
            }
        }
        resetDiskCache();
    }

    private synchronized void resetDiskCache() {
        this.mDiskLruCache = null;
    }

    @Override // com.xiaopeng.montecarlo.xpglide.IXpGlideCache
    public void removeCache(String str) {
        Key key;
        if (TextUtils.isEmpty(str) || (key = this.mKeyMap.get(str)) == null) {
            return;
        }
        delete(key);
    }
}
