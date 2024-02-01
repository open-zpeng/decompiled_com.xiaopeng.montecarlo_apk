package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
/* loaded from: classes3.dex */
public class LinearLayoutMapBtnBg extends LinearLayoutToggleBtnBg {
    private static final L.Tag TAG = new L.Tag("LinearLayoutToggleBtnBg");
    private int mBgResId;

    @Override // com.xiaopeng.montecarlo.views.LinearLayoutToggleBtnBg
    public void refresh() {
    }

    public LinearLayoutMapBtnBg(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBgResId = -1;
    }

    public LinearLayoutMapBtnBg(Context context) {
        super(context);
        this.mBgResId = -1;
    }

    public LinearLayoutMapBtnBg(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBgResId = -1;
    }

    @Override // com.xiaopeng.montecarlo.views.LinearLayoutToggleBtnBg
    public void updateBg() {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            if (getChildAt(i2).getVisibility() == 0) {
                i++;
            }
        }
        if (i <= 0) {
            setBackground(null);
            this.mBgResId = -1;
            updateSize(false);
            return;
        }
        updateSize(true);
        this.mBgResId = R.drawable.drawable_map_buttons_map_left_btn_bg;
        setBackground(ThemeWatcherUtil.getDrawable(this.mBgResId));
    }

    private void updateSize(boolean z) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = z ? -2 : ContextUtils.getDimensionPixelSize(R.dimen.shadow_margin);
        layoutParams.height = z ? ContextUtils.getDimensionPixelSize(R.dimen.layout_map_button_bg_height) : 0;
        setLayoutParams(layoutParams);
    }
}
