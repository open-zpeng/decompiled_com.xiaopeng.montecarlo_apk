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
public class XpChargePriceItem extends XRelativeLayout {
    private Context mContext;
    private LayoutInflater mInflater;
    private XTextView mXpPriceExternal;
    private XTextView mXpPriceTime;
    private XTextView mXpPriceValue;

    public XpChargePriceItem(Context context) {
        super(context);
        init(context);
    }

    public XpChargePriceItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public XpChargePriceItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    @RequiresApi(api = 21)
    public XpChargePriceItem(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        View inflate = this.mInflater.inflate(R.layout.xp_charge_price_item, (ViewGroup) this, false);
        this.mXpPriceTime = (XTextView) inflate.findViewById(R.id.tv_xp_price_time);
        this.mXpPriceValue = (XTextView) inflate.findViewById(R.id.tv_xp_price_value);
        this.mXpPriceExternal = (XTextView) inflate.findViewById(R.id.tv_xp_price_external);
        addView(inflate);
    }

    public void setXpPriceTimeText(String str) {
        XTextView xTextView = this.mXpPriceTime;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    public void setXpPriceTimeTextColor(int i) {
        XTextView xTextView = this.mXpPriceTime;
        if (xTextView != null) {
            xTextView.setTextColor(i);
        }
    }

    public void setXpPriceValueText(String str) {
        XTextView xTextView = this.mXpPriceValue;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    public void setXpPriceValueTextColor(int i) {
        XTextView xTextView = this.mXpPriceValue;
        if (xTextView != null) {
            xTextView.setTextColor(i);
        }
    }

    public void setXpPriceExternalText(String str) {
        XTextView xTextView = this.mXpPriceExternal;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    public void setXpPriceExternalTextColor(int i) {
        XTextView xTextView = this.mXpPriceExternal;
        if (xTextView != null) {
            xTextView.setTextColor(i);
        }
    }
}
