package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.views.ChargePriceAdapter;
import com.xiaopeng.montecarlo.views.NoScrollListView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.List;
/* loaded from: classes3.dex */
public class XpChargePrice extends XLinearLayout {
    private static final L.Tag TAG = new L.Tag("XpChargePrice");
    private ChargePriceAdapter mAdapter;
    private Context mContext;
    private XpChargePriceItem mCurrentXpChargePrice;
    private LayoutInflater mInflater;
    private boolean mIsHaveDesc;
    private OnPriceExpandDisplayControllerListener mListener;
    private XLinearLayout mXpChargePriceExternal;
    private NoScrollListView mXpPriceInfo;
    private XTextView mXpPriceParkCategory;
    private XTextView mXpPriceParkCategoryTitle;
    private XTextView mXpPriceSlowCategory;
    private XTextView mXpPriceSlowCategoryTitle;

    /* loaded from: classes3.dex */
    public interface OnPriceExpandDisplayControllerListener {
        void onPriceExpandDisplayController(boolean z);
    }

    public boolean isHaveDesc() {
        return this.mIsHaveDesc;
    }

    public NoScrollListView getXpPriceInfo() {
        return this.mXpPriceInfo;
    }

    public void setListener(OnPriceExpandDisplayControllerListener onPriceExpandDisplayControllerListener) {
        this.mListener = onPriceExpandDisplayControllerListener;
    }

    public XpChargePrice(Context context) {
        super(context);
        this.mIsHaveDesc = false;
        init(context);
    }

    public XpChargePrice(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsHaveDesc = false;
        init(context);
    }

    public XpChargePrice(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsHaveDesc = false;
        init(context);
    }

    @RequiresApi(api = 21)
    public XpChargePrice(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mIsHaveDesc = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initView();
    }

    public void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        View inflate = this.mInflater.inflate(R.layout.layout_xp_charge_price, (ViewGroup) this, true);
        if (Utils.isPortrait()) {
            inflate.setPadding(inflate.getPaddingLeft(), inflate.getPaddingTop(), inflate.getPaddingRight(), ContextUtils.getDimensionPixelSize(R.dimen.poi_card_view_charge_price_bottom_padding));
        }
        this.mCurrentXpChargePrice = (XpChargePriceItem) inflate.findViewById(R.id.current_xp_charge_price);
        this.mXpPriceInfo = (NoScrollListView) inflate.findViewById(R.id.lv_xp_price_info);
        this.mXpChargePriceExternal = (XLinearLayout) inflate.findViewById(R.id.container_xp_charge_price_external);
        this.mXpPriceParkCategoryTitle = (XTextView) inflate.findViewById(R.id.tv_xp_price_park_category_title);
        this.mXpPriceParkCategory = (XTextView) inflate.findViewById(R.id.tv_xp_price_park_category);
        this.mXpPriceSlowCategoryTitle = (XTextView) inflate.findViewById(R.id.tv_xp_price_slow_category_title);
        this.mXpPriceSlowCategory = (XTextView) inflate.findViewById(R.id.tv_xp_price_slow_category);
        setOrientation(1);
    }

    public void showXpPriceInfo() {
        NoScrollListView noScrollListView = this.mXpPriceInfo;
        if (noScrollListView == null || noScrollListView.getVisibility() == 0) {
            return;
        }
        this.mXpPriceInfo.setVisibility(0);
    }

    public void hideXpPriceInfo() {
        NoScrollListView noScrollListView = this.mXpPriceInfo;
        if (noScrollListView == null || noScrollListView.getVisibility() == 8) {
            return;
        }
        this.mXpPriceInfo.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void renderXPChargePrice(com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo r16, boolean r17) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.views.poicard.XpChargePrice.renderXPChargePrice(com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo, boolean):void");
    }

    private void renderPriceDesc(List<String[]> list, boolean z) {
        this.mIsHaveDesc = CollectionUtils.isNotEmpty(list);
        if (this.mIsHaveDesc && z) {
            showXpChargePriceExternal();
        } else {
            hideXpChargePriceExternal();
        }
    }

    public void showXpChargePriceExternal() {
        XLinearLayout xLinearLayout = this.mXpChargePriceExternal;
        if (xLinearLayout == null || xLinearLayout.getVisibility() == 0) {
            return;
        }
        this.mXpChargePriceExternal.setVisibility(0);
    }

    public void hideXpChargePriceExternal() {
        XLinearLayout xLinearLayout = this.mXpChargePriceExternal;
        if (xLinearLayout == null || xLinearLayout.getVisibility() == 8) {
            return;
        }
        this.mXpChargePriceExternal.setVisibility(8);
    }

    public void showCurrentXpChargePrice() {
        XpChargePriceItem xpChargePriceItem = this.mCurrentXpChargePrice;
        if (xpChargePriceItem == null || xpChargePriceItem.getVisibility() == 0) {
            return;
        }
        this.mCurrentXpChargePrice.setVisibility(0);
    }

    public void hideCurrentXpChargePrice() {
        XpChargePriceItem xpChargePriceItem = this.mCurrentXpChargePrice;
        if (xpChargePriceItem == null || xpChargePriceItem.getVisibility() == 8) {
            return;
        }
        this.mCurrentXpChargePrice.setVisibility(8);
    }
}
