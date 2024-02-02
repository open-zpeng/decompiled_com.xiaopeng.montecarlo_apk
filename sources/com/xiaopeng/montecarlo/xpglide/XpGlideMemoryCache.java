package com.xiaopeng.montecarlo.xpglide;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
class XpGlideMemoryCache extends LruResourceCache implements IXpGlideCache {
    private static final L.Tag TAG = new L.Tag("XpGlideMemoryCache");
    private final Map<String, Key> mUrlKeyMap;

    public XpGlideMemoryCache(long j) {
        super(j);
        this.mUrlKeyMap = new HashMap();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.util.LruCache
    @Nullable
    public synchronized Resource<?> remove(@NonNull Key key) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.i(tag, "remove: key = " + key.toString());
        }
        this.mUrlKeyMap.remove(XpGlideUtil.getUrlFromKey(key));
        return (Resource) super.remove((XpGlideMemoryCache) key);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.util.LruCache
    @Nullable
    public synchronized Resource<?> put(@NonNull Key key, @Nullable Resource<?> resource) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "put: key = " + key.toString());
        }
        this.mUrlKeyMap.put(XpGlideUtil.getUrlFromKey(key), key);
        return (Resource) super.put((XpGlideMemoryCache) key, (Key) resource);
    }

    @Override // com.bumptech.glide.util.LruCache
    @Nullable
    public synchronized Resource<?> get(@NonNull Key key) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "get: key = " + key.toString());
        }
        return (Resource) super.get((XpGlideMemoryCache) key);
    }

    @Override // com.xiaopeng.montecarlo.xpglide.IXpGlideCache
    public void removeCache(String str) {
        Key key;
        if (TextUtils.isEmpty(str) || (key = this.mUrlKeyMap.get(str)) == null) {
            return;
        }
        remove(key);
    }
}
