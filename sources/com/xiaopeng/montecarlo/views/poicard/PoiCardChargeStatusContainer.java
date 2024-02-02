package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepCharging;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepInfoPoi;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.views.ChargeView;
import com.xiaopeng.montecarlo.views.poicard.PoiCardEntryContainer;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.Map;
/* loaded from: classes3.dex */
public class PoiCardChargeStatusContainer extends XRelativeLayout implements BasePoiCardViewContract {
    public static final String KEY_IS_SETTING_HOME_OR_OFFICE = "isSettingHomeOrOffice";
    public static final String KEY_MAX_DISPLAY_WIDTH = "maxDisplayWidth";
    public static final String KEY_POI_INFO = "poiInfo";
    private static final L.Tag TAG = new L.Tag("Card_PCCSC");
    private XLinearLayout mChargeContainer;
    private XTextView mChargeDetailBtn;
    private Context mContext;
    private PoiCardEntryContainer.OnPoiCardEntryContainerClickListener mDetailClickListener;
    private LayoutInflater mInflater;
    private Boolean mIsSettingHomeOrOffice;
    private OnChildLayoutCompletedListener mLayoutListener;
    private Integer mMaxDisplayWidth;
    private XPPoiInfo mPoiInfo;
    private ViewGroup mRootView;

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
    }

    public PoiCardChargeStatusContainer(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        super(context);
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mRootView = (ViewGroup) this.mInflater.inflate(R.layout.layout_charge_status_for_poi_card, (ViewGroup) this, true);
        this.mRootView.setMinimumHeight(ContextUtils.getDimensionPixelSize(R.dimen.poi_item_height));
        this.mChargeDetailBtn = (XTextView) this.mRootView.findViewById(R.id.charge_detail);
        executeAfterViewInflated(this.mRootView);
    }

    public void renderChargeView(final XPDeepCharging xPDeepCharging, final int i, final boolean z) {
        if (this.mChargeContainer == null || xPDeepCharging == null) {
            return;
        }
        post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardChargeStatusContainer.1
            @Override // java.lang.Runnable
            public void run() {
                ChargeView chargeView;
                int i2;
                PoiCardChargeStatusContainer.this.mChargeContainer.removeAllViews();
                if (xPDeepCharging.getNumFastFree() > 0 || xPDeepCharging.getNumFast() > 0 || xPDeepCharging.getNumSlowFree() > 0 || xPDeepCharging.getNumSlow() > 0) {
                    ChargeView chargeView2 = null;
                    if (xPDeepCharging.getNumFastFree() > 0 || xPDeepCharging.getNumFast() > 0) {
                        chargeView = new ChargeView(PoiCardChargeStatusContainer.this.getContext());
                        chargeView.initChargeData(true, xPDeepCharging.getNumFastFree(), xPDeepCharging.getNumFast(), z);
                    } else {
                        chargeView = null;
                    }
                    if (xPDeepCharging.getNumSlowFree() > 0 || xPDeepCharging.getNumSlow() > 0) {
                        chargeView2 = new ChargeView(PoiCardChargeStatusContainer.this.getContext());
                        chargeView2.initChargeData(false, xPDeepCharging.getNumSlowFree(), xPDeepCharging.getNumSlow(), z);
                    }
                    if (chargeView != null) {
                        i2 = RootUtil.getViewWidth(chargeView) + 0;
                        PoiCardChargeStatusContainer.this.mChargeContainer.addView(chargeView);
                    } else {
                        i2 = 0;
                    }
                    if (chargeView2 != null) {
                        i2 += RootUtil.getViewWidth(chargeView2);
                        PoiCardChargeStatusContainer.this.mChargeContainer.addView(chargeView2);
                    }
                    if (i2 > i) {
                        PoiCardChargeStatusContainer.this.mChargeContainer.setOrientation(1);
                    } else {
                        PoiCardChargeStatusContainer.this.mChargeContainer.setOrientation(0);
                    }
                    PoiCardChargeStatusContainer.this.calculateChargeViewPosition(chargeView, chargeView2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateChargeViewPosition(ChargeView chargeView, ChargeView chargeView2) {
        if (this.mChargeContainer != null) {
            setChargeViewLayoutParams(chargeView, true);
            setChargeViewLayoutParams(chargeView2, false);
        }
    }

    private void setChargeViewLayoutParams(ChargeView chargeView, boolean z) {
        if (this.mChargeContainer == null || chargeView == null) {
            return;
        }
        int dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.poi_charge_view_offset);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.topMargin = dimensionPixelSize;
        if (this.mChargeContainer.getOrientation() == 1 && z) {
            layoutParams.bottomMargin = 0;
        } else {
            layoutParams.bottomMargin = dimensionPixelSize;
        }
        chargeView.setLayoutParams(layoutParams);
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
        this.mChargeContainer = (XLinearLayout) view.findViewById(R.id.charge_container);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        setViewListener();
        onInitOrThemeSwitch();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
        renderChargeInfo();
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
        if (map.get("isSettingHomeOrOffice") != null) {
            this.mIsSettingHomeOrOffice = (Boolean) map.get("isSettingHomeOrOffice");
        }
        if (map.get(KEY_MAX_DISPLAY_WIDTH) != null) {
            this.mMaxDisplayWidth = (Integer) map.get(KEY_MAX_DISPLAY_WIDTH);
        }
        if (map.get("clickListener") != null) {
            this.mDetailClickListener = (PoiCardEntryContainer.OnPoiCardEntryContainerClickListener) map.get("clickListener");
        }
    }

    private void renderChargeInfo() {
        setVisibility(8);
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        if (xPPoiInfo == null) {
            return;
        }
        XPDeepInfoPoi xPDeepInfoPoi = xPPoiInfo.getXPDeepInfoPoi();
        XPDeepCharging xPDeepCharging = null;
        if (xPDeepInfoPoi != null && xPDeepInfoPoi.getChargeData() != null && xPDeepInfoPoi.getChargeData().length > 0) {
            xPDeepCharging = xPDeepInfoPoi.getChargeData()[0];
        }
        if (xPDeepCharging != null) {
            renderChargeView(xPDeepCharging);
        }
        renderDetailBtn();
    }

    private void renderDetailBtn() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        if (xPPoiInfo == null) {
            return;
        }
        if (!XPPoiCategory.isXPSelfCharge(xPPoiInfo.getCategory()) || this.mIsSettingHomeOrOffice.booleanValue() || !XPAccountServiceWrapper.getInstance().isLoginXp()) {
            this.mChargeDetailBtn.setVisibility(8);
            setOnClickListener(null);
            return;
        }
        this.mChargeDetailBtn.setVisibility(0);
        setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardChargeStatusContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PoiCardChargeStatusContainer.this.mDetailClickListener != null) {
                    PoiCardChargeStatusContainer.this.mDetailClickListener.onBtnParkClicked();
                }
            }
        });
    }

    public void renderChargeView(XPDeepCharging xPDeepCharging) {
        if (xPDeepCharging == null || this.mPoiInfo == null) {
            return;
        }
        boolean z = xPDeepCharging.getNumFastFree() > 0 || xPDeepCharging.getNumFast() > 0 || xPDeepCharging.getNumSlowFree() > 0 || xPDeepCharging.getNumSlow() > 0;
        setVisibility(z ? 0 : 8);
        if (z) {
            renderChargeView(xPDeepCharging, this.mMaxDisplayWidth.intValue(), this.mPoiInfo.isOffline());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mLayoutListener = null;
    }
}
