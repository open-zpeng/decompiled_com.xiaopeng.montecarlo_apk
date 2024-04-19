package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class CommonChargePriceItem extends XRelativeLayout {
    private Context mContext;
    private LayoutInflater mInflater;
    private XTextView mPriceExternal;
    private XTextView mPriceTime;
    private XTextView mPriceValue;

    public CommonChargePriceItem(Context context) {
        super(context);
        init(context);
    }

    public CommonChargePriceItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CommonChargePriceItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    @RequiresApi(api = 21)
    public CommonChargePriceItem(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        View inflate = this.mInflater.inflate(R.layout.common_charge_price_item, (ViewGroup) this, false);
        this.mPriceTime = (XTextView) inflate.findViewById(R.id.tv_price_time);
        this.mPriceValue = (XTextView) inflate.findViewById(R.id.tv_price_value);
        this.mPriceExternal = (XTextView) inflate.findViewById(R.id.tv_price_external);
        addView(inflate);
    }

    public void setPriceTimeText(String str) {
        XTextView xTextView = this.mPriceTime;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    public void setPriceValueText(String str) {
        XTextView xTextView = this.mPriceValue;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    public void setPriceExternalText(String str) {
        XTextView xTextView = this.mPriceExternal;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }
}
