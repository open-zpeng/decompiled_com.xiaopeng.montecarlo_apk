package com.xiaopeng.montecarlo.scenes.searchscene;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
/* loaded from: classes3.dex */
public class TopSmoothScroller extends LinearSmoothScroller {
    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    protected int getHorizontalSnapPreference() {
        return -1;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    protected int getVerticalSnapPreference() {
        return -1;
    }

    public TopSmoothScroller(Context context) {
        super(context);
    }
}
