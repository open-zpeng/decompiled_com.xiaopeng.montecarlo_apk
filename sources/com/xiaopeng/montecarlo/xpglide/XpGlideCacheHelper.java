package com.xiaopeng.montecarlo.xpglide;

import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.request.target.Target;
import com.xiaopeng.montecarlo.root.util.L;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Map;
/* loaded from: classes3.dex */
public class XpGlideCacheHelper {
    private XpGlideDiskCacheWrapper mDiskCache;
    private DiskCache.Factory mDiskCacheFactory;
    private XpGlideActiveResourcesWrapper mGlideActiveResourcesWrapper;
    private boolean mIsInitialized = false;
    private XpGlideMemoryCache mLruResourceCache;
    private static final L.Tag TAG = new L.Tag("XpGlideCacheHelper");
    private static final XpGlideCacheHelper INSTANCE = new XpGlideCacheHelper();

    public static XpGlideCacheHelper getInstance() {
        return INSTANCE;
    }

    public void init(Context context) {
        this.mLruResourceCache = new XpGlideMemoryCache(new MemorySizeCalculator.Builder(context).setMemoryCacheScreens(2.0f).build().getMemoryCacheSize());
        this.mDiskCache = (XpGlideDiskCacheWrapper) XpGlideDiskCacheWrapper.create(new File(context.getCacheDir(), "image_manager_disk_cache"), 262144000L);
        this.mDiskCacheFactory = new DiskCache.Factory() { // from class: com.xiaopeng.montecarlo.xpglide.-$$Lambda$XpGlideCacheHelper$tew8gMMcDMLePZs5TyGgfko_Du8
            @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
            public final DiskCache build() {
                return XpGlideCacheHelper.this.lambda$init$0$XpGlideCacheHelper();
            }
        };
        this.mIsInitialized = true;
    }

    public /* synthetic */ DiskCache lambda$init$0$XpGlideCacheHelper() {
        return this.mDiskCache;
    }

    public LruResourceCache getLruResourceCache() {
        if (!this.mIsInitialized) {
            throw new IllegalStateException("call init() first ");
        }
        return this.mLruResourceCache;
    }

    public DiskCache.Factory getDiskCacheFactory() {
        if (!this.mIsInitialized) {
            throw new IllegalStateException("call init() first ");
        }
        return this.mDiskCacheFactory;
    }

    public void wrapWeakRefCache(Glide glide) {
        if (!this.mIsInitialized) {
            throw new IllegalStateException("call init() first ");
        }
        try {
            Field declaredField = Glide.class.getDeclaredField("engine");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(glide);
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "wrappWeakRef: engine = " + obj);
            }
            Field declaredField2 = obj.getClass().getDeclaredField("activeResources");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "wrappWeakRef: activeResources = " + obj2);
            }
            Field declaredField3 = obj2.getClass().getDeclaredField("activeEngineResources");
            declaredField3.setAccessible(true);
            Map map = (Map) declaredField3.get(obj2);
            if (L.ENABLE) {
                L.Tag tag3 = TAG;
                L.d(tag3, "wrappWeakRef: activeEngineResources = " + map);
            }
            this.mGlideActiveResourcesWrapper = new XpGlideActiveResourcesWrapper(map);
            declaredField3.set(obj2, this.mGlideActiveResourcesWrapper);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void removeCache(Target target, String str) {
        if (!this.mIsInitialized) {
            throw new IllegalStateException("call init() first ");
        }
        L.Tag tag = TAG;
        L.i(tag, "====== removeCache: " + str);
        if (target != null) {
            target.setRequest(null);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        removeCache(str);
    }

    private void removeCache(String str) {
        XpGlideMemoryCache xpGlideMemoryCache = this.mLruResourceCache;
        if (xpGlideMemoryCache != null) {
            xpGlideMemoryCache.removeCache(str);
        }
        XpGlideDiskCacheWrapper xpGlideDiskCacheWrapper = this.mDiskCache;
        if (xpGlideDiskCacheWrapper != null) {
            xpGlideDiskCacheWrapper.removeCache(str);
        }
        XpGlideActiveResourcesWrapper xpGlideActiveResourcesWrapper = this.mGlideActiveResourcesWrapper;
        if (xpGlideActiveResourcesWrapper != null) {
            xpGlideActiveResourcesWrapper.removeCache(str);
        }
    }
}
