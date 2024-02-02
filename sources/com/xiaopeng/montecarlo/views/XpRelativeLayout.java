package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.xui.widget.XRelativeLayout;
/* loaded from: classes3.dex */
public class XpRelativeLayout extends XRelativeLayout {
    private static final L.Tag TAG = new L.Tag("XpRelativeLayout");
    private OnViewStateChangedListener mStateChangedListener;

    public void setStateChangedListener(OnViewStateChangedListener onViewStateChangedListener) {
        this.mStateChangedListener = onViewStateChangedListener;
    }

    public XpRelativeLayout(Context context) {
        super(context);
    }

    public XpRelativeLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public XpRelativeLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public XpRelativeLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.View
    public void setVisibility(int i) {
        if (i == getVisibility()) {
            return;
        }
        super.setVisibility(i);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setVisibility new:" + i + ",mStateChangedListener:" + this.mStateChangedListener);
        }
        OnViewStateChangedListener onViewStateChangedListener = this.mStateChangedListener;
        if (onViewStateChangedListener != null) {
            onViewStateChangedListener.onVisibleStateChanged(this, this, i);
        }
    }
}
