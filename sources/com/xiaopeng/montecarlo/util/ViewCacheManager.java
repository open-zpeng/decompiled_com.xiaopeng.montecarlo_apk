package com.xiaopeng.montecarlo.util;

import android.view.View;
import androidx.annotation.LayoutRes;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
/* loaded from: classes3.dex */
public class ViewCacheManager {
    private static final L.Tag TAG = new L.Tag("ViewCacheManager");
    private int MAX_POOL_SIZE;
    private ConcurrentHashMap<String, LayerHolder> viewCache = new ConcurrentHashMap<>();
    private ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    public ViewCacheManager(int i) {
        this.MAX_POOL_SIZE = 4;
        this.MAX_POOL_SIZE = i;
    }

    public LayerHolder getView(int i, @LayoutRes int i2) {
        return getView(i, i2, "");
    }

    public LayerHolder getView(int i, @LayoutRes int i2, String str) {
        String str2 = i + str;
        LayerHolder layerHolder = this.viewCache.get(str2);
        if (layerHolder == null && (layerHolder = this.viewCache.get(str2)) == null) {
            layerHolder = new LayerHolder(View.inflate(ContextUtils.getContext(), i2, null), i);
            this.viewCache.put(str2, layerHolder);
            this.queue.add(str2);
            int size = this.viewCache.size();
            L.i(TAG, "create LayerHolder type : " + str2 + " poolSize : " + size);
            if (size > this.MAX_POOL_SIZE) {
                String poll = this.queue.poll();
                if (poll != null) {
                    this.viewCache.remove(poll);
                }
                L.i(TAG, "remove LayerHolder mapKey : " + poll + " poolSize : " + this.viewCache.size());
            }
        }
        return layerHolder;
    }

    public void removeHolder(final int i) {
        L.Tag tag = TAG;
        L.i(tag, "removeHolder type : " + i);
        this.viewCache.forEach(new BiConsumer() { // from class: com.xiaopeng.montecarlo.util.-$$Lambda$ViewCacheManager$e1ChsUJoUp_HTG9zTNP4C2jTQW8
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ViewCacheManager.this.lambda$removeHolder$0$ViewCacheManager(i, (String) obj, (LayerHolder) obj2);
            }
        });
    }

    public /* synthetic */ void lambda$removeHolder$0$ViewCacheManager(int i, String str, LayerHolder layerHolder) {
        if (layerHolder.getViewType() == i) {
            this.viewCache.remove(str);
        }
    }

    public void resetCache() {
        ConcurrentHashMap<String, LayerHolder> concurrentHashMap = this.viewCache;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                LayerHolder layerHolder = this.viewCache.get(str);
                if (layerHolder != null) {
                    layerHolder.recycle();
                    this.viewCache.remove(str);
                }
            }
        }
    }
}
