package com.xiaopeng.montecarlo.navcore.mapdisplay;

import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.root.util.L;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class MapTextureCache extends LruCache<String, Integer> {
    @NonNull
    private static final L.Tag TAG = new L.Tag("MapTextureCache");
    private WeakReference<MapViewWrapper> mMapViewWrapperWeakReference;

    public MapTextureCache(int i, MapViewWrapper mapViewWrapper) {
        super(i);
        this.mMapViewWrapperWeakReference = new WeakReference<>(mapViewWrapper);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.util.LruCache
    public void entryRemoved(boolean z, String str, @NonNull Integer num, Integer num2) {
        WeakReference<MapViewWrapper> weakReference;
        if (!z || (weakReference = this.mMapViewWrapperWeakReference) == null || weakReference.get() == null) {
            return;
        }
        L.Tag tag = TAG;
        L.d(tag, "TEXTURECACHE remove texture cache : " + str);
        this.mMapViewWrapperWeakReference.get().cleanOverlayTexture(Integer.parseInt(str), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.util.LruCache
    public int sizeOf(String str, @Nullable Integer num) {
        if (num == null || num.intValue() <= 0) {
            return 1;
        }
        return num.intValue();
    }
}
