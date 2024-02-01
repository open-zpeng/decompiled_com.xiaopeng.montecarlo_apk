package com.xiaopeng.montecarlo.views.volumn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.views.volumn.seekbar.VerticalSeekBar;
import com.xiaopeng.xui.widget.XFrameLayout;
/* loaded from: classes3.dex */
public class VerticalSeekBarWrapper extends XFrameLayout {
    private static final L.Tag TAG = new L.Tag("VerticalSeekBarWrapper");

    public VerticalSeekBarWrapper(Context context) {
        this(context, null, 0);
    }

    public VerticalSeekBarWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalSeekBarWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        applyViewRotation(i, i2);
        super.onSizeChanged(i, i2, i3, i4);
    }

    private void applyViewRotation(int i, int i2) {
        VerticalSeekBar childSeekBar = getChildSeekBar();
        if (childSeekBar != null) {
            boolean z = getLayoutDirection() == 0;
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            L.Tag tag = TAG;
            L.i(tag, "onSizeChangedUseViewRotation w:" + i + ", hPadding:" + paddingLeft + ", h:" + i2 + ", vPadding:" + paddingTop);
            int rotationAngle = childSeekBar.getRotationAngle();
            ViewGroup.LayoutParams layoutParams = childSeekBar.getLayoutParams();
            if (rotationAngle == 0) {
                childSeekBar.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, i - paddingTop), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(0, i2 - paddingLeft), 1073741824));
                layoutParams.width = -1;
                layoutParams.height = Math.max(0, i2 - paddingTop);
            } else {
                int i3 = i2 - paddingTop;
                childSeekBar.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, i3), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(0, i - paddingLeft), 1073741824));
                layoutParams.width = Math.max(0, i3);
                layoutParams.height = -2;
            }
            int measuredWidth = childSeekBar.getMeasuredWidth();
            int measuredHeight = childSeekBar.getMeasuredHeight();
            float max = (Math.max(0, i - paddingLeft) - measuredHeight) * 0.5f;
            childSeekBar.setLayoutParams(layoutParams);
            childSeekBar.setPivotX(z ? 0.0f : Math.max(0, i2 - paddingTop));
            childSeekBar.setPivotY(0.0f);
            L.Tag tag2 = TAG;
            L.i(tag2, "applyViewRotation rotationAngle:" + rotationAngle + ", isLTR:" + z + ", seekBarMeasuredWidth:" + measuredWidth + ", seekBarMeasuredHeight:" + measuredHeight + ", hPadding:" + paddingLeft + ", vPadding:" + paddingTop + ", w:" + i + ", h:" + i2 + ", hOffset:" + max);
            if (rotationAngle == 90) {
                childSeekBar.setRotation(90.0f);
                if (z) {
                    childSeekBar.setTranslationX(measuredHeight + max);
                    childSeekBar.setTranslationY(0.0f);
                    return;
                }
                childSeekBar.setTranslationX(-max);
                childSeekBar.setTranslationY(measuredWidth);
            } else if (rotationAngle != 270) {
            } else {
                childSeekBar.setRotation(270.0f);
                if (z) {
                    childSeekBar.setTranslationX(0.0f);
                    childSeekBar.setTranslationY(measuredWidth);
                    if (L.ENABLE) {
                        L.Tag tag3 = TAG;
                        L.d(tag3, "setTranslationX 0.0setTranslationY" + measuredWidth);
                        return;
                    }
                    return;
                }
                childSeekBar.setTranslationX(-(measuredHeight + max));
                childSeekBar.setTranslationY(0.0f);
            }
        }
    }

    private VerticalSeekBar getChildSeekBar() {
        View childAt = getChildCount() > 0 ? getChildAt(0) : null;
        if (childAt instanceof VerticalSeekBar) {
            return (VerticalSeekBar) childAt;
        }
        return null;
    }
}
