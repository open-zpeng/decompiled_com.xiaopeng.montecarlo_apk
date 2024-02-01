package com.xiaopeng.montecarlo.views.observable;

import android.view.ViewGroup;
/* loaded from: classes3.dex */
public interface Scrollable {
    void addScrollViewCallbacks(ObservableScrollViewCallbacks observableScrollViewCallbacks);

    void clearScrollViewCallbacks();

    int getCurrentScrollY();

    void removeScrollViewCallbacks(ObservableScrollViewCallbacks observableScrollViewCallbacks);

    void scrollVerticallyTo(int i);

    @Deprecated
    void setScrollViewCallbacks(ObservableScrollViewCallbacks observableScrollViewCallbacks);

    void setTouchInterceptionViewGroup(ViewGroup viewGroup);
}
