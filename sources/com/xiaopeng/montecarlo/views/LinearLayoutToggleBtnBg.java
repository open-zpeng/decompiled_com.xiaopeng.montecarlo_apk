package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XLinearLayout;
/* loaded from: classes3.dex */
public class LinearLayoutToggleBtnBg extends XLinearLayout {
    @DrawableRes
    private static final int S_DEFAULT_MULTI_BG_RES_ID = 2131231430;
    @DrawableRes
    private static final int S_DEFAULT_SINGLE_BG_RES_ID = 2131231592;
    private static final L.Tag TAG = new L.Tag("LinearLayoutToggleBtnBg");
    @DrawableRes
    private int mBgResId;
    private XpThemeSwitchReceiver.ThemeSwitchListener mThemeSwitchListener;

    public LinearLayoutToggleBtnBg(Context context) {
        this(context, null);
    }

    public LinearLayoutToggleBtnBg(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutToggleBtnBg(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.LinearLayoutToggleBtnBg.1
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public void onThemeSwitch(int i2) {
                LinearLayoutToggleBtnBg.this.updateBg();
            }
        };
        initAttris(context, attributeSet);
        L.Tag tag = TAG;
        L.i(tag, "LinearLayoutToggleBtnBg : " + ThemeWatcherUtil.getDayNightMode());
    }

    private void initAttris(Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutToggleBtnBgStyle);
        if (obtainStyledAttributes != null) {
            this.mBgResId = obtainStyledAttributes.getResourceId(0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    protected void onChildVisibilityChanged(View view, int i, int i2) {
        updateBg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        L.Tag tag = TAG;
        L.i(tag, "onAttachedToWindow : " + ThemeWatcherUtil.getDayNightMode());
        updateBg();
        ThemeWatcherUtil.addXpThemeSwitchListener(this.mThemeSwitchListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcherUtil.removeXpThemeListener(this.mThemeSwitchListener);
    }

    public void refresh() {
        updateBg();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void updateBg() {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            if (getChildAt(i2).getVisibility() == 0) {
                i++;
            }
        }
        if (i <= 0) {
            renderEmptyContentBg();
        } else if (i < 2) {
            renderSingeContentBg();
        } else {
            renderMultiContentsBg(i);
        }
    }

    private void renderMultiContentsBg(int i) {
        int i2 = this.mBgResId;
        if (i2 == 0) {
            i2 = R.drawable.png_togglebutton_bg_normal;
        }
        setBackground(ThemeWatcherUtil.getDrawable(i2));
        int dimensionPixelSize = (i - 1) * getResources().getDimensionPixelSize(R.dimen.toggle_button_bg_multi_margin_add);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.toggle_button_bg_single_margin);
        int i3 = dimensionPixelSize + dimensionPixelSize2;
        setPadding(dimensionPixelSize2, i3, dimensionPixelSize2, i3);
    }

    private void renderSingeContentBg() {
        int i = this.mBgResId;
        if (i == 0) {
            i = R.drawable.togglebutton_bg_normal_single;
        }
        setBackground(ThemeWatcherUtil.getDrawable(i));
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.toggle_button_bg_single_margin);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }

    private void renderEmptyContentBg() {
        setBackground(null);
    }
}
