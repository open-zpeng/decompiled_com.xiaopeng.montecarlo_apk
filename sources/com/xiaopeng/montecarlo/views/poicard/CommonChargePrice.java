package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.views.ChargePriceAdapter;
import com.xiaopeng.montecarlo.views.NoScrollListView;
import com.xiaopeng.xui.widget.XLinearLayout;
/* loaded from: classes3.dex */
public class CommonChargePrice extends XLinearLayout {
    private static final L.Tag TAG = new L.Tag("CommonChargePrice");
    private ChargePriceAdapter mAdapter;
    private NoScrollListView mCommonPriceInfo;
    private Context mContext;
    private CommonChargePriceItem mCurrentCommonChargePrice;
    private LayoutInflater mInflater;
    private OnPriceExpandDisplayControllerListener mListener;

    /* loaded from: classes3.dex */
    public interface OnPriceExpandDisplayControllerListener {
        void onPriceExpandDisplayController(boolean z);
    }

    public void setListener(OnPriceExpandDisplayControllerListener onPriceExpandDisplayControllerListener) {
        this.mListener = onPriceExpandDisplayControllerListener;
    }

    public NoScrollListView getCommonPriceInfo() {
        return this.mCommonPriceInfo;
    }

    public CommonChargePrice(Context context) {
        super(context);
        init(context);
    }

    public CommonChargePrice(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CommonChargePrice(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    @RequiresApi(api = 21)
    public CommonChargePrice(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        View inflate = this.mInflater.inflate(R.layout.layout_common_charge_price, (ViewGroup) this, true);
        this.mCurrentCommonChargePrice = (CommonChargePriceItem) inflate.findViewById(R.id.current_common_charge_price);
        this.mCommonPriceInfo = (NoScrollListView) inflate.findViewById(R.id.lv_common_price_info);
        setOrientation(1);
    }

    public void hideCurrentCommonChargePrice() {
        CommonChargePriceItem commonChargePriceItem = this.mCurrentCommonChargePrice;
        if (commonChargePriceItem == null || commonChargePriceItem.getVisibility() == 8) {
            return;
        }
        this.mCurrentCommonChargePrice.setVisibility(8);
    }

    public void showCurrentCommonChargePrice() {
        CommonChargePriceItem commonChargePriceItem = this.mCurrentCommonChargePrice;
        if (commonChargePriceItem == null || commonChargePriceItem.getVisibility() == 0) {
            return;
        }
        this.mCurrentCommonChargePrice.setVisibility(0);
    }

    public void showCommonPriceInfo() {
        NoScrollListView noScrollListView = this.mCommonPriceInfo;
        if (noScrollListView == null || noScrollListView.getVisibility() == 0) {
            return;
        }
        this.mCommonPriceInfo.setVisibility(0);
    }

    public void hideCommonPriceInfo() {
        NoScrollListView noScrollListView = this.mCommonPriceInfo;
        if (noScrollListView == null || noScrollListView.getVisibility() == 8) {
            return;
        }
        this.mCommonPriceInfo.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void renderCommonChargePrice(com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo r12) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.views.poicard.CommonChargePrice.renderCommonChargePrice(com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo):void");
    }
}
