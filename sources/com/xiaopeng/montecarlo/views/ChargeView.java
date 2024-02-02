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
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* loaded from: classes3.dex */
public class ChargeView extends XLinearLayout {
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

    private int getChargeContentColor(boolean z, int i, boolean z2) {
        if (i == 0) {
            return ThemeWatcherUtil.getColor(R.color.poi_card_text_color_02);
        }
        return ThemeWatcherUtil.getColor(z ? R.color.vector_midquick_path1_fill_color : R.color.vector_midslow_path1_fill_color);
    }

    private int getChargeImage(boolean z, int i, boolean z2) {
        if (Utils.isPortrait()) {
            if (i == 0) {
                return ThemeWatcherUtil.getDrawableResId(z ? R.drawable.vector_tag_texttag_smallunavailable_quick : R.drawable.vector_tag_texttag_smallunavailable_slow);
            }
            return ThemeWatcherUtil.getDrawableResId(z ? R.drawable.vector_tag_texttag_smallquick : R.drawable.vector_tag_texttag_smallslow);
        } else if (i == 0) {
            return ThemeWatcherUtil.getDrawableResId(z ? R.drawable.vector_tag_texttag_midunavailable_quick : R.drawable.vector_tag_texttag_midunavailable_slow);
        } else {
            return ThemeWatcherUtil.getDrawableResId(z ? R.drawable.vector_tag_texttag_midquick : R.drawable.vector_tag_texttag_midslow);
        }
    }

    public void initChargeData(boolean z, int i, int i2, boolean z2) {
        if (i >= 0) {
            this.mChargeContentLeft.setText(String.format(ContextUtils.getString(R.string.poi_charge_status_available), Integer.valueOf(i)));
            XTextView xTextView = this.mChargeContentTotal;
            xTextView.setText(MqttTopic.TOPIC_LEVEL_SEPARATOR + String.format(ContextUtils.getString(R.string.poi_charge_status_used), Integer.valueOf(i2)));
            this.mChargeContentLeft.setTextColor(getChargeContentColor(z, i, z2));
        } else {
            this.mChargeContentTotal.setText(String.format(ContextUtils.getString(R.string.poi_charge_status_total), Integer.valueOf(i2)));
        }
        this.mChargeIcon.setImageResource(getChargeImage(z, i, z2));
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
