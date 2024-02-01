package com.xiaopeng.montecarlo.xpglide;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.xiaopeng.montecarlo.root.util.L;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
final class XpGlideActiveResourcesWrapper<K, V> implements Map<K, V>, Cloneable, Serializable, IXpGlideCache {
    private static final L.Tag TAG = new L.Tag("XpGlideActiveResources");
    private Map<K, V> mTarget;
    private Map<String, Key> mTemp = new HashMap();

    public XpGlideActiveResourcesWrapper(Map<K, V> map) {
        this.mTarget = map;
    }

    @Override // java.util.Map
    public int size() {
        return this.mTarget.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.mTarget.isEmpty();
    }

    @Override // java.util.Map
    public boolean containsKey(@Nullable Object obj) {
        return this.mTarget.containsValue(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(@Nullable Object obj) {
        return this.mTarget.containsValue(obj);
    }

    @Override // java.util.Map
    @Nullable
    public V get(@Nullable Object obj) {
        return this.mTarget.get(obj);
    }

    @Override // java.util.Map
    @Nullable
    public V put(@NonNull K k, @NonNull V v) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "put: key = " + k);
        }
        Key key = (Key) k;
        this.mTemp.put(XpGlideUtil.getUrlFromKey(key), key);
        return this.mTarget.put(k, v);
    }

    @Override // java.util.Map
    @Nullable
    public V remove(@Nullable Object obj) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "remove: " + obj.toString());
        }
        Key key = (Key) obj;
        this.mTemp.remove(XpGlideUtil.getUrlFromKey(key), key);
        return this.mTarget.remove(obj);
    }

    @Override // java.util.Map
    public void putAll(@NonNull Map<? extends K, ? extends V> map) {
        this.mTarget.putAll(map);
    }

    @Override // java.util.Map
    public void clear() {
        this.mTemp.clear();
        this.mTarget.clear();
    }

    @Override // java.util.Map
    @NonNull
    public Set<K> keySet() {
        return this.mTarget.keySet();
    }

    @Override // java.util.Map
    @NonNull
    public Collection<V> values() {
        return this.mTarget.values();
    }

    @Override // java.util.Map
    @NonNull
    public Set<Map.Entry<K, V>> entrySet() {
        return this.mTarget.entrySet();
    }

    @Override // com.xiaopeng.montecarlo.xpglide.IXpGlideCache
    public void removeCache(String str) {
        Key key;
        if (TextUtils.isEmpty(str) || (key = this.mTemp.get(str)) == null) {
            return;
        }
        remove(key);
    }
}
