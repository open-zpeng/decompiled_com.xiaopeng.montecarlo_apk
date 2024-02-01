package com.xiaopeng.montecarlo.util;

import android.util.SparseArray;
import android.view.View;
/* loaded from: classes3.dex */
public class LayerHolder {
    private final int mViewType;
    private View rootView;
    private final SparseArray<View> viewCache = new SparseArray<>();

    public LayerHolder(View view, int i) {
        this.rootView = null;
        this.rootView = view;
        this.mViewType = i;
    }

    public <T extends View> T getView(int i) {
        T t = (T) this.viewCache.get(i);
        if (t == null) {
            T t2 = (T) this.rootView.findViewById(i);
            this.viewCache.put(i, t2);
            return t2;
        }
        return t;
    }

    public View getRootView() {
        return this.rootView;
    }

    public int getViewType() {
        return this.mViewType;
    }

    public void recycle() {
        this.rootView = null;
        this.viewCache.clear();
    }
}
