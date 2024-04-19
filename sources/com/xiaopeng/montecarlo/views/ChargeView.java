package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class ChargeView extends XLinearLayout {
    public static final int CHARGE_FAST_VIEW = 1;
    public static final int CHARGE_SLOW_VIEW = 2;
    public static final int CHARGE_ULTRA_VIEW = 0;
    private XTextView mChargeContentLeft;
    private XTextView mChargeContentTotal;
    private XImageView mChargeIcon;
    private Context mContext;
    private ViewGroup mRootView;

    public ChargeView(Context context) {
        super(context);
        initView();
    }

    public ChargeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public ChargeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private int getChargeContentColor(int i, int i2, boolean z) {
        if (i2 == 0) {
            return ThemeWatcherUtil.getColor(R.color.poi_card_text_color_02);
        }
        if (i == 0) {
            return ThemeWatcherUtil.getColor(R.color.vector_ultra_fill_color);
        }
        if (i == 1) {
            return ThemeWatcherUtil.getColor(R.color.vector_midquick_path1_fill_color);
        }
        return ThemeWatcherUtil.getColor(R.color.vector_midslow_path1_fill_color);
    }

    private int getChargeImage(int i, int i2) {
        if (i == 0) {
            return ThemeWatcherUtil.getDrawableResId(i2 > 0 ? R.drawable.vector_tag_texttag_ultra : R.drawable.vector_tag_texttag_unavailable_ultra);
        } else if (i == 1) {
            return ThemeWatcherUtil.getDrawableResId(i2 > 0 ? R.drawable.vector_tag_texttag_smallquick : R.drawable.vector_tag_texttag_smallunavailable_quick);
        } else {
            return ThemeWatcherUtil.getDrawableResId(i2 > 0 ? R.drawable.vector_tag_texttag_smallslow : R.drawable.vector_tag_texttag_smallunavailable_slow);
        }
    }

    public void initChargeData(int i, int i2, int i3, boolean z) {
        if (i2 >= 0) {
            this.mChargeContentLeft.setText(String.format(ContextUtils.getString(R.string.poi_charge_status_available), Integer.valueOf(i2)));
            XTextView xTextView = this.mChargeContentTotal;
            xTextView.setText("/" + String.format(ContextUtils.getString(R.string.poi_charge_status_used), Integer.valueOf(i3)));
            this.mChargeContentLeft.setTextColor(getChargeContentColor(i, i2, z));
        } else {
            this.mChargeContentTotal.setText(String.format(ContextUtils.getString(R.string.poi_charge_status_total), Integer.valueOf(i3)));
        }
        this.mChargeIcon.setImageResource(getChargeImage(i, i2));
        this.mChargeContentTotal.setTextColor(ThemeWatcherUtil.getColor(R.color.poi_card_text_color_02));
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.layout_charge_view, this);
        this.mChargeContentLeft = (XTextView) this.mRootView.findViewById(R.id.charge_content_left);
        this.mChargeContentTotal = (XTextView) this.mRootView.findViewById(R.id.charge_content_total);
        this.mChargeIcon = (XImageView) this.mRootView.findViewById(R.id.icon_charge);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 21;
        layoutParams.setMarginEnd(ContextUtils.getDimensionPixelSize(R.dimen.charge_view_margin_end));
        setLayoutParams(layoutParams);
        setPadding(0, 0, ContextUtils.getDimensionPixelSize(R.dimen.charge_view_padding_right), 0);
        setMinimumWidth(ContextUtils.getDimensionPixelSize(R.dimen.charge_view_min_width));
    }
}
