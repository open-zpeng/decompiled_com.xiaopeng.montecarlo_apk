package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ViewFlipper;
/* loaded from: classes3.dex */
public class ViewFlipperExt extends ViewFlipper {
    private int mIndex;

    public ViewFlipperExt(Context context) {
        super(context);
        this.mIndex = 0;
    }

    public ViewFlipperExt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIndex = 0;
    }

    public void resetIndex() {
        this.mIndex = 0;
    }

    @Override // android.widget.ViewAnimator
    public View getCurrentView() {
        return getChildAt(this.mIndex % getChildCount());
    }

    public View getNextView() {
        return getChildAt((this.mIndex + 1) % getChildCount());
    }

    public void updateIndex() {
        this.mIndex++;
    }
}
