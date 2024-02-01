package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import androidx.annotation.NonNull;
import com.xiaopeng.xui.widget.XLinearLayout;
/* loaded from: classes3.dex */
public class NoScrollListView extends XLinearLayout {
    private BaseAdapter mAdapter;

    public NoScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setAdapter(@NonNull BaseAdapter baseAdapter) {
        this.mAdapter = baseAdapter;
    }

    public void bindLinearLayout() {
        int count = this.mAdapter.getCount();
        removeAllViews();
        for (int i = 0; i < count; i++) {
            addView(this.mAdapter.getView(i, null, null), i);
        }
    }
}
