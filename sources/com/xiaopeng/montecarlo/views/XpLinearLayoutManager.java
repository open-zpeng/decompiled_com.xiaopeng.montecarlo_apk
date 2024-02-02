package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes3.dex */
public class XpLinearLayoutManager extends LinearLayoutManager {
    private XpLinearLayoutManagerListener mListener;

    /* loaded from: classes3.dex */
    public interface XpLinearLayoutManagerListener {
        void onLayoutCompleted();
    }

    public XpLinearLayoutManager(Context context) {
        super(context);
    }

    public XpLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public XpLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public XpLinearLayoutManager(Context context, XpLinearLayoutManagerListener xpLinearLayoutManagerListener) {
        super(context);
        this.mListener = xpLinearLayoutManagerListener;
    }

    public XpLinearLayoutManager(Context context, int i, boolean z, XpLinearLayoutManagerListener xpLinearLayoutManagerListener) {
        super(context, i, z);
        this.mListener = xpLinearLayoutManagerListener;
    }

    public XpLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2, XpLinearLayoutManagerListener xpLinearLayoutManagerListener) {
        super(context, attributeSet, i, i2);
        this.mListener = xpLinearLayoutManagerListener;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        XpLinearLayoutManagerListener xpLinearLayoutManagerListener = this.mListener;
        if (xpLinearLayoutManagerListener != null) {
            xpLinearLayoutManagerListener.onLayoutCompleted();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
