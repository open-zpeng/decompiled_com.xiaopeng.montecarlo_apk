package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.widget.XRelativeLayout;
/* loaded from: classes3.dex */
public class SapaContainerView extends XRelativeLayout {
    private int mMargin;
    private int mOffset;
    private int mWidth;

    public SapaContainerView(Context context) {
        this(context, null);
    }

    public SapaContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SapaContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOffset = 0;
        this.mMargin = 0;
        this.mWidth = 0;
        this.mOffset = getContext().getResources().getDimensionPixelSize(R.dimen.guide_sapa_item_space);
        this.mMargin = getContext().getResources().getDimensionPixelSize(R.dimen.guide_sapa_padding);
        this.mWidth = getContext().getResources().getDimensionPixelSize(R.dimen.guide_sapa_width);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0) {
                i3 += childAt.getMeasuredHeight();
                if (i4 > 0) {
                    i3 -= this.mOffset + (this.mMargin * 2);
                }
            }
        }
        setMeasuredDimension(this.mWidth, i3);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        int childCount = getChildCount();
        boolean z3 = true;
        int measuredHeight = getMeasuredHeight();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 0) {
                if (z3) {
                    i5 = measuredHeight - childAt.getMeasuredHeight();
                    childAt.layout(0, i5, childAt.getMeasuredWidth(), measuredHeight);
                    z2 = false;
                } else {
                    int i7 = measuredHeight + this.mOffset + (this.mMargin * 2);
                    int measuredHeight2 = i7 - childAt.getMeasuredHeight();
                    childAt.layout(0, measuredHeight2, childAt.getMeasuredWidth(), i7);
                    z2 = z3;
                    i5 = measuredHeight2;
                }
                boolean z4 = z2;
                measuredHeight = i5;
                z3 = z4;
            }
        }
    }
}
