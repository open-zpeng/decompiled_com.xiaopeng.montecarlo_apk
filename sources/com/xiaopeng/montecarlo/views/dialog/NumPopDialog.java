package com.xiaopeng.montecarlo.views.dialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
/* loaded from: classes3.dex */
public class NumPopDialog extends XBaseDialog implements View.OnClickListener {
    private Context mContext;
    ViewGroup mDialContent;
    ViewGroup mDialRoot;

    @Override // com.xiaopeng.montecarlo.views.dialog.XBaseDialog
    public void setIsNight(boolean z) {
        updateTheme();
        super.setIsNight(z);
    }

    public NumPopDialog(Context context, String str) {
        super(context, R.style.pop_dialog_large, R.style.pop_dialog_dail_style, true, true);
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_poi_dial_list, (ViewGroup) null);
        initView(inflate, str);
        setTitleBarVisibility(false);
        setContentView(inflate, false);
    }

    private void initView(View view, String str) {
        CharSequence[] split = str.split(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
        int length = split.length <= 2 ? split.length : 2;
        if (length <= 0) {
            return;
        }
        this.mDialRoot = (ViewGroup) view.findViewById(R.id.poi_pop_dial_top);
        this.mDialContent = (ViewGroup) view.findViewById(R.id.poi_dial_container);
        for (int i = 0; i < length; i++) {
            final TextView textView = new TextView(this.mContext);
            textView.setText(split[i]);
            int dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.poi_dial_list_height);
            int i2 = length - 1;
            if (i == i2) {
                dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.poi_dial_list_last_height);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dimensionPixelSize);
            layoutParams.gravity = 17;
            textView.setLayoutParams(layoutParams);
            textView.setPadding(ContextUtils.getDimensionPixelSize(R.dimen.poi_dial_phone_horizontal_padding), 0, ContextUtils.getDimensionPixelSize(R.dimen.poi_dial_phone_horizontal_padding), 0);
            textView.setGravity(17);
            updateTV(textView);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.dialog.NumPopDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TextUtils.isEmpty(textView.getText().toString())) {
                        NumPopDialog.this.dismiss();
                        return;
                    }
                    NumPopDialog.this.mContext.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + ((TextView) view2).getText().toString())));
                    NumPopDialog.this.dismiss();
                }
            });
            this.mDialContent.addView(textView);
            if (i < i2) {
                addHorizontalLineView(this.mDialContent);
            }
        }
        this.mDialRoot.setOnClickListener(this);
    }

    private void updateTV(TextView textView) {
        textView.setCompoundDrawablesWithIntrinsicBounds(ThemeWatcherUtil.getDrawable(R.drawable.vector_ic_mid_phone), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setTextAppearance(this.mContext, ThemeWatcherUtil.isDayMode() ? R.style.poi_body_contact_style : R.style.poi_body_contact_style_night);
    }

    private void updateTheme() {
        if (this.mDialContent != null) {
            for (int i = 0; i < this.mDialContent.getChildCount(); i++) {
                View childAt = this.mDialContent.getChildAt(i);
                if (childAt instanceof TextView) {
                    updateTV((TextView) childAt);
                } else {
                    childAt.setBackgroundColor(ContextUtils.getColor(ThemeWatcherUtil.getColorResId(R.color.color_poi_card_view_dial_view_divider)));
                }
            }
        }
    }

    private void addHorizontalLineView(ViewGroup viewGroup) {
        View view = new View(this.mContext);
        view.setLayoutParams(new LinearLayout.LayoutParams(ContextUtils.getDimensionPixelSize(R.dimen.dimen_poi_card_view_poi_dial_list_line_width), ContextUtils.getDimensionPixelSize(R.dimen.dimen_poi_card_view_poi_dial_list_line_divider_height)));
        view.setBackgroundColor(ContextUtils.getColor(ThemeWatcherUtil.getColorResId(R.color.color_poi_card_view_dial_view_divider)));
        viewGroup.addView(view);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.poi_pop_dial_top) {
            return;
        }
        dismiss();
    }
}
