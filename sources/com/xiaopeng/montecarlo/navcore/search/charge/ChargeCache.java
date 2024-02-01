package com.xiaopeng.montecarlo.navcore.search.charge;

import android.util.LruCache;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class ChargeCache {
    private static final L.Tag TAG = new L.Tag("ChargeCache");
    private final int MAX_CACHE_SIZE = 1000;
    private final int SIZE_OF_CACHE = 10;
    private LruCache<String, ChargeCacheInfo> mCache = new LruCache<String, ChargeCacheInfo>(10000) { // from class: com.xiaopeng.montecarlo.navcore.search.charge.ChargeCache.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        public int sizeOf(String str, ChargeCacheInfo chargeCacheInfo) {
            return 10;
        }
    };

    public ChargeCacheInfo getValue(String str) {
        return this.mCache.get(str);
    }

    public void putValue(String str, ChargeCacheInfo chargeCacheInfo) {
        this.mCache.put(str, chargeCacheInfo);
    }

    public void remove(String str) {
        this.mCache.remove(str);
    }
}
