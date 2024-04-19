package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.NoScrollListView;
import com.xiaopeng.montecarlo.views.poicard.CommonChargePrice;
import com.xiaopeng.montecarlo.views.poicard.XpChargePrice;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.Map;
/* loaded from: classes3.dex */
public class PoiCardPriceContainer extends XLinearLayout implements CommonChargePrice.OnPriceExpandDisplayControllerListener, XpChargePrice.OnPriceExpandDisplayControllerListener, BasePoiCardViewContract {
    public static final String KEY_IS_REFRESH = "isRefresh";
    public static final String KEY_POI_INFO = "poiInfo";
    public static final String KEY_PRICE_LISTENER = "priceListener";
    private static final L.Tag TAG = new L.Tag("Card_PCPriceC");
    private XTextView mBlPriceInfo;
    private CommonChargePrice mCommonChargePriceContainer;
    private Context mContext;
    private LayoutInflater mInflater;
    private boolean mIsPriceExpand;
    private boolean mIsRefresh;
    private OnChildLayoutCompletedListener mLayoutListener;
    private XPPoiInfo mPoiInfo;
    private XImageButton mPriceExpand;
    private PoiCardPriceContainerListener mPriceListener;
    private ViewGroup mRootView;
    private XpChargePrice mXpChargePriceContainer;

    /* loaded from: classes3.dex */
    public interface PoiCardPriceContainerListener {
        void oneExpandStatusChanged(boolean z);
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
    }

    public PoiCardPriceContainer(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        super(context);
        this.mIsPriceExpand = false;
        this.mIsRefresh = false;
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mRootView = (ViewGroup) this.mInflater.inflate(R.layout.layout_poi_price_container, (ViewGroup) this, true);
        this.mRootView.setMinimumHeight(ContextUtils.getDimensionPixelSize(R.dimen.poi_item_height));
        setOrientation(1);
        executeAfterViewInflated(this.mRootView);
    }

    public boolean isPriceExpandVisible() {
        XImageButton xImageButton = this.mPriceExpand;
        return xImageButton != null && xImageButton.getVisibility() == 0;
    }

    public NoScrollListView getCommonPriceInfo() {
        CommonChargePrice commonChargePrice = this.mCommonChargePriceContainer;
        if (commonChargePrice == null) {
            return null;
        }
        return commonChargePrice.getCommonPriceInfo();
    }

    public NoScrollListView getXpPriceInfo() {
        XpChargePrice xpChargePrice = this.mXpChargePriceContainer;
        if (xpChargePrice == null) {
            return null;
        }
        return xpChargePrice.getXpPriceInfo();
    }

    public void showCommonChargePriceContainer() {
        resetPriceContainer();
        CommonChargePrice commonChargePrice = this.mCommonChargePriceContainer;
        if (commonChargePrice != null && commonChargePrice.getVisibility() != 0) {
            this.mCommonChargePriceContainer.setVisibility(0);
        }
        XImageButton xImageButton = this.mPriceExpand;
        if (xImageButton == null || xImageButton.getVisibility() == 0) {
            return;
        }
        this.mPriceExpand.setVisibility(0);
    }

    private void resetPriceContainer() {
        XTextView xTextView = this.mBlPriceInfo;
        if (xTextView != null && xTextView.getVisibility() != 8) {
            this.mBlPriceInfo.setVisibility(8);
        }
        CommonChargePrice commonChargePrice = this.mCommonChargePriceContainer;
        if (commonChargePrice != null && commonChargePrice.getVisibility() != 8) {
            this.mCommonChargePriceContainer.setVisibility(8);
        }
        XpChargePrice xpChargePrice = this.mXpChargePriceContainer;
        if (xpChargePrice == null || xpChargePrice.getVisibility() == 8) {
            return;
        }
        this.mXpChargePriceContainer.setVisibility(8);
    }

    public void resetListener() {
        CommonChargePrice commonChargePrice = this.mCommonChargePriceContainer;
        if (commonChargePrice != null) {
            commonChargePrice.setListener(null);
        }
        XpChargePrice xpChargePrice = this.mXpChargePriceContainer;
        if (xpChargePrice != null) {
            xpChargePrice.setListener(null);
        }
    }

    public void showCommonChargePriceInfo() {
        CommonChargePrice commonChargePrice = this.mCommonChargePriceContainer;
        if (commonChargePrice == null || this.mPoiInfo == null) {
            return;
        }
        commonChargePrice.setListener(this);
        showCommonChargePriceContainer();
        if (this.mIsPriceExpand) {
            this.mCommonChargePriceContainer.hideCurrentCommonChargePrice();
            this.mCommonChargePriceContainer.showCommonPriceInfo();
        } else {
            this.mCommonChargePriceContainer.showCurrentCommonChargePrice();
            this.mCommonChargePriceContainer.hideCommonPriceInfo();
        }
        if (this.mIsRefresh) {
            return;
        }
        this.mCommonChargePriceContainer.renderCommonChargePrice(this.mPoiInfo);
    }

    private void priceExpandDisplayController(boolean z) {
        XImageButton xImageButton = this.mPriceExpand;
        if (xImageButton != null) {
            xImageButton.setVisibility(z ? 0 : 8);
        }
    }

    public void showBlChargePriceInfo() {
        XTextView xTextView;
        if (this.mPoiInfo == null) {
            return;
        }
        showNormalPriceContainer();
        if (this.mIsRefresh || (xTextView = this.mBlPriceInfo) == null) {
            return;
        }
        xTextView.setText(this.mPoiInfo.getPrice());
    }

    public void showNormalPriceContainer() {
        resetPriceContainer();
        XTextView xTextView = this.mBlPriceInfo;
        if (xTextView != null) {
            xTextView.setVisibility(0);
        }
    }

    private void showXpChargePriceContainer() {
        resetPriceContainer();
        XpChargePrice xpChargePrice = this.mXpChargePriceContainer;
        if (xpChargePrice != null && xpChargePrice.getVisibility() != 0) {
            this.mXpChargePriceContainer.setVisibility(0);
        }
        XImageButton xImageButton = this.mPriceExpand;
        if (xImageButton == null || xImageButton.getVisibility() == 0) {
            return;
        }
        this.mPriceExpand.setVisibility(0);
    }

    public void renderParkPrice() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        if (xPPoiInfo == null || this.mBlPriceInfo == null) {
            return;
        }
        if (TextUtils.isEmpty(xPPoiInfo.getPrice())) {
            if (TextUtils.isEmpty(this.mBlPriceInfo.getText())) {
                hidePrice();
                return;
            }
            return;
        }
        showPrice();
        showNormalPriceContainer();
        this.mBlPriceInfo.setText(this.mPoiInfo.getPrice());
    }

    public void showPrice() {
        setVisibility(0);
    }

    public void hidePrice() {
        setVisibility(8);
        XImageButton xImageButton = this.mPriceExpand;
        if (xImageButton != null) {
            xImageButton.setVisibility(8);
        }
        resetPriceContainer();
    }

    public void expandListenerController() {
        PoiCardPriceContainerListener poiCardPriceContainerListener = this.mPriceListener;
        if (poiCardPriceContainerListener == null) {
            return;
        }
        setOnExpandListener(this, poiCardPriceContainerListener);
        XImageButton xImageButton = this.mPriceExpand;
        if (xImageButton != null) {
            setOnExpandListener(xImageButton, this.mPriceListener);
        }
        if (getCommonPriceInfo() != null) {
            setOnExpandListener(getCommonPriceInfo(), this.mPriceListener);
        }
        if (getXpPriceInfo() != null) {
            setOnExpandListener(getXpPriceInfo(), this.mPriceListener);
        }
    }

    private void setOnExpandListener(View view, final PoiCardPriceContainerListener poiCardPriceContainerListener) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardPriceContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PoiCardPriceContainer.this.updateExpandStatus(view2, poiCardPriceContainerListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateExpandStatus(View view, PoiCardPriceContainerListener poiCardPriceContainerListener) {
        if (view.getVisibility() == 0 && isPriceExpandVisible()) {
            this.mIsPriceExpand = !this.mIsPriceExpand;
            setPriceExpandStatus(this.mIsPriceExpand);
            if (poiCardPriceContainerListener != null) {
                poiCardPriceContainerListener.oneExpandStatusChanged(this.mIsPriceExpand);
            }
        }
    }

    private void setPriceExpandStatus(boolean z) {
        Drawable drawable;
        XImageButton xImageButton = this.mPriceExpand;
        if (xImageButton != null) {
            if (z) {
                drawable = ThemeWatcherUtil.getDrawable(R.drawable.vector_ic_xsmall_upper);
            } else {
                drawable = ThemeWatcherUtil.getDrawable(R.drawable.vector_ic_xsmall_lower);
            }
            xImageButton.setImageDrawable(drawable);
        }
    }

    public void showXpChargePriceInfo() {
        XpChargePrice xpChargePrice = this.mXpChargePriceContainer;
        if (xpChargePrice == null || this.mPoiInfo == null) {
            return;
        }
        xpChargePrice.setListener(this);
        showXpChargePriceContainer();
        if (this.mIsPriceExpand) {
            this.mXpChargePriceContainer.hideCurrentXpChargePrice();
            this.mXpChargePriceContainer.showXpPriceInfo();
            if (this.mXpChargePriceContainer.isHaveDesc()) {
                this.mXpChargePriceContainer.showXpChargePriceExternal();
            } else {
                this.mXpChargePriceContainer.hideXpChargePriceExternal();
            }
        } else {
            this.mXpChargePriceContainer.showCurrentXpChargePrice();
            this.mXpChargePriceContainer.hideXpPriceInfo();
            this.mXpChargePriceContainer.hideXpChargePriceExternal();
        }
        if (this.mIsRefresh) {
            return;
        }
        this.mXpChargePriceContainer.renderXPChargePrice(this.mPoiInfo, this.mIsPriceExpand);
    }

    public void resetPriceInfo() {
        hidePrice();
        XTextView xTextView = this.mBlPriceInfo;
        if (xTextView != null) {
            xTextView.setText((CharSequence) null);
        }
        setPriceExpandStatus(this.mIsPriceExpand);
    }

    public void resetPriceExpandState() {
        this.mIsPriceExpand = false;
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.CommonChargePrice.OnPriceExpandDisplayControllerListener, com.xiaopeng.montecarlo.views.poicard.XpChargePrice.OnPriceExpandDisplayControllerListener
    public void onPriceExpandDisplayController(boolean z) {
        priceExpandDisplayController(z);
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void init(Context context, Map<String, Object> map) {
        formatParams(context, map);
        initView();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeAfterViewInflated(View view) {
        if (view == null) {
            L.e(TAG, "execute after view inflated view is null");
            return;
        }
        this.mPriceExpand = (XImageButton) view.findViewById(R.id.iv_price_expand);
        this.mBlPriceInfo = (XTextView) view.findViewById(R.id.tv_price_info_bl);
        this.mCommonChargePriceContainer = (CommonChargePrice) view.findViewById(R.id.container_common_charge_price);
        this.mXpChargePriceContainer = (XpChargePrice) view.findViewById(R.id.container_xp_charge_price);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        setViewListener();
        renderPriceInfo();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
        expandListenerController();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void refresh(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        this.mLayoutListener = onChildLayoutCompletedListener;
        formatParams(context, map);
        executeViewOperation();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void formatParams(Context context, Map<String, Object> map) {
        if (context == null) {
            throw new IllegalArgumentException("context can not be null");
        }
        if (map == null) {
            throw new IllegalArgumentException("params can not be null");
        }
        this.mContext = context;
        if (map.get("poiInfo") != null) {
            this.mPoiInfo = (XPPoiInfo) map.get("poiInfo");
        }
        if (map.get(KEY_PRICE_LISTENER) != null) {
            this.mPriceListener = (PoiCardPriceContainerListener) map.get(KEY_PRICE_LISTENER);
        }
        if (map.get("isRefresh") != null) {
            this.mIsRefresh = ((Boolean) map.get("isRefresh")).booleanValue();
        }
    }

    private void renderPriceInfo() {
        if (this.mPoiInfo == null) {
            return;
        }
        if (!this.mIsRefresh) {
            resetPriceExpandState();
        }
        resetPriceInfo();
        if (XPPoiCategory.isCharge(this.mPoiInfo.getCategory())) {
            renderChargePrice();
        } else if (XPPoiCategory.isParking(this.mPoiInfo.getCategory())) {
            renderParkPrice();
        }
    }

    private void renderChargePrice() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        if (xPPoiInfo == null) {
            return;
        }
        if (TextUtils.isEmpty(xPPoiInfo.getPrice())) {
            hidePrice();
            return;
        }
        showPrice();
        if (XPPoiCategory.isXPSelfCharge(this.mPoiInfo.getCategory()) || XPPoiCategory.isXPJoinCharge(this.mPoiInfo.getCategory()) || XPPoiCategory.isXPCooperateCharge(this.mPoiInfo.getCategory())) {
            showXpChargePriceInfo();
        } else if (XPPoiCategory.isCommonCharge(this.mPoiInfo.getCategory())) {
            showCommonChargePriceInfo();
        } else {
            showBlChargePriceInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mLayoutListener = null;
    }
}
