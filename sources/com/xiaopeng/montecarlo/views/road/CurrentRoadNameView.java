package com.xiaopeng.montecarlo.views.road;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.vui.VuiView;
/* loaded from: classes3.dex */
public class CurrentRoadNameView extends AppCompatButton implements VuiView {
    @DrawableRes
    private static final int DEFAULT_CURRENT_ROAD_NAME_RES_ID = 2131230985;
    private static final L.Tag TAG = new L.Tag("CurrentRoadNameView");
    @DrawableRes
    int mBgResId;
    int[] mPressState;
    private XpThemeSwitchReceiver.ThemeSwitchListener mThemeSwitchListener;
    int[] mUnpressState;

    public CurrentRoadNameView(Context context) {
        this(context, null);
    }

    public CurrentRoadNameView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CurrentRoadNameView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBgResId = R.drawable.layer_bg_guide_current_road;
        this.mPressState = new int[]{16842919};
        this.mUnpressState = new int[0];
        this.mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.road.CurrentRoadNameView.1
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public void onThemeSwitch(int i2) {
                CurrentRoadNameView.this.updateBg();
            }
        };
        initVui(this, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CurrentRoadNameViewStyle);
        if (obtainStyledAttributes != null) {
            this.mBgResId = obtainStyledAttributes.getResourceId(0, this.mBgResId);
            obtainStyledAttributes.recycle();
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        releaseVui();
    }

    @Override // android.view.View
    protected void dispatchSetPressed(boolean z) {
        if (getBackground() instanceof StateListDrawable) {
            ((StateListDrawable) getBackground()).setState(z ? this.mPressState : this.mUnpressState);
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, getPaddingLeft() + "___");
            }
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateBg();
        ThemeWatcherUtil.addXpThemeSwitchListener(this.mThemeSwitchListener);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcherUtil.removeXpThemeListener(this.mThemeSwitchListener);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        setVuiVisibility(this, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBg() {
        if (getCompoundDrawables()[0] != null) {
            setCompoundDrawablesWithIntrinsicBounds(ThemeWatcherUtil.getDrawable(R.drawable.vector_ic_small_carlocation), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        setBackgroundDrawable(ThemeWatcherUtil.getDrawable(this.mBgResId));
        setTextColor(ThemeWatcherUtil.getColor(R.color.main_title_text_color));
    }
}
