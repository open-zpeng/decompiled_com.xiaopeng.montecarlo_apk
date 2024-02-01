package com.xiaopeng.montecarlo.views.keyboard;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.xui.widget.XLinearLayout;
/* loaded from: classes3.dex */
public class KeyRowLayout extends XLinearLayout {
    private static final float RATIO_FUN_CONFIRM = 0.625f;
    private static final L.Tag TAG = new L.Tag("KeyRowLayout");
    private int mFunKeyCount;
    private int mFunKeyIndex;
    private int mFunKeySpace;
    private int mGeneralKeySpace;
    private boolean mIsSpecial;
    private int mMaxColumn;
    private int mWidthUnused;

    public KeyRowLayout(Context context) {
        this(context, false);
    }

    public KeyRowLayout(Context context, boolean z) {
        super(context);
        setOrientation(0);
        setClipToPadding(false);
        setClipChildren(false);
        this.mIsSpecial = z;
    }

    public void setMaxColumn(int i) {
        this.mMaxColumn = i;
    }

    public void setFunKeyCount(int i) {
        this.mFunKeyCount = i;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int childCount = getChildCount();
        if (!this.mIsSpecial) {
            int i3 = this.mFunKeySpace;
            int i4 = (((size - (i3 * 8)) * 3) / 10) + i3;
            float generalKeyWidth = getGeneralKeyWidth(size, i4, (int) (i4 * RATIO_FUN_CONFIRM));
            this.mFunKeyIndex = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt instanceof KeyView) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((KeyView) childAt).getLayoutParams();
                    layoutParams.width = (int) generalKeyWidth;
                    i5 += layoutParams.width + this.mGeneralKeySpace;
                }
            }
            this.mWidthUnused = size - (i5 - this.mGeneralKeySpace);
            if (this.mFunKeyCount > 0) {
                setPadding(0, 0, 0, 0);
            } else {
                int i7 = this.mWidthUnused / 2;
                setPadding(i7, getPaddingTop(), i7, getPaddingBottom());
            }
        }
        super.onMeasure(i, i2);
    }

    private float getGeneralKeyWidth(int i, int i2, int i3) {
        if (L.ENABLE) {
            L.d(TAG, "width = [" + i + "], delAndConfirmWidth = [" + i2 + "], confirmKeyWidth = [" + i3 + "]");
        }
        int i4 = this.mMaxColumn;
        int i5 = this.mGeneralKeySpace;
        float f = (i - ((i4 - 1) * i5)) / i4;
        int i6 = 0;
        int i7 = this.mFunKeyCount;
        if (i7 == 1) {
            i6 = i3 + i5;
        } else if (i7 == 2) {
            i6 = i2 + i5;
        }
        int childCount = getChildCount() - this.mFunKeyCount;
        float f2 = (i - i6) - ((childCount - 1) * this.mGeneralKeySpace);
        float f3 = childCount;
        return f2 < f * f3 ? f2 / f3 : f;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mFunKeyCount > 0) {
            ViewCompat.offsetLeftAndRight(getChildAt(this.mFunKeyIndex), this.mWidthUnused);
            if (this.mFunKeyCount == 2) {
                ViewCompat.offsetLeftAndRight(getChildAt(this.mFunKeyIndex + 1), this.mWidthUnused + (this.mFunKeySpace - this.mGeneralKeySpace));
            }
        }
    }
}
