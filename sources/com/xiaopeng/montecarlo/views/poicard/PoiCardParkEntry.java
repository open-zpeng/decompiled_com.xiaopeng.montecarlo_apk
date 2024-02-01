package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.views.poicard.PoiCardEntryContainer;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.Map;
/* loaded from: classes3.dex */
public class PoiCardParkEntry extends XLinearLayout implements BasePoiCardViewContract, View.OnClickListener {
    private static final L.Tag TAG = new L.Tag("PoiCardParkEntry");
    private XTextView mBtnPark;
    private LinearLayout mBtnParkContainer;
    private PoiCardEntryContainer.OnPoiCardEntryContainerClickListener mClickListener;
    private Context mContext;
    private LayoutInflater mInflater;
    private boolean mIsSettingHomeOrOffice;
    private OnChildLayoutCompletedListener mLayoutListener;
    private XPPoiInfo mPoiInfo;
    private ViewGroup mRootView;

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void refresh(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
    }

    public PoiCardParkEntry(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        super(context);
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mLayoutListener = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PoiCardEntryContainer.OnPoiCardEntryContainerClickListener onPoiCardEntryContainerClickListener;
        if (view.getId() == R.id.poi_btn_park && (onPoiCardEntryContainerClickListener = this.mClickListener) != null) {
            onPoiCardEntryContainerClickListener.onBtnParkClicked();
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void init(Context context, Map<String, Object> map) {
        formatParams(context, map);
        initView();
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mRootView = (ViewGroup) this.mInflater.inflate(R.layout.layout_poi_entry_item_park, (ViewGroup) this, true);
        setOrientation(1);
        executeAfterViewInflated(this.mRootView);
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeAfterViewInflated(View view) {
        if (view == null) {
            L.e(TAG, "execute after view inflated view is null");
            return;
        }
        this.mBtnParkContainer = (LinearLayout) view.findViewById(R.id.poi_btn_park_container);
        this.mBtnPark = (XTextView) view.findViewById(R.id.poi_btn_park);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        setViewListener();
        renderSelectChargeSpotButtonStatus();
    }

    public void renderSelectChargeSpotButtonStatus() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        if (xPPoiInfo == null) {
            return;
        }
        if (!XPPoiCategory.isXPSelfCharge(xPPoiInfo.getCategory()) || this.mIsSettingHomeOrOffice || !XPAccountServiceWrapper.getInstance().isLoginXp()) {
            hideSelectChargeButton();
        } else {
            showSelectChargeButton();
        }
    }

    public void hideSelectChargeButton() {
        hideBtnParkContainer();
    }

    public void showSelectChargeButton() {
        showBtnParkContainer();
        setVisibility(0);
    }

    public void hideBtnParkContainer() {
        LinearLayout linearLayout = this.mBtnParkContainer;
        if (linearLayout == null || linearLayout.getVisibility() == 8) {
            return;
        }
        this.mBtnParkContainer.setVisibility(8);
    }

    public void showBtnParkContainer() {
        LinearLayout linearLayout = this.mBtnParkContainer;
        if (linearLayout == null || linearLayout.getVisibility() == 0) {
            return;
        }
        this.mBtnParkContainer.setVisibility(0);
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
        XTextView xTextView = this.mBtnPark;
        if (xTextView != null) {
            xTextView.setOnClickListener(this);
        }
    }

    public void setBtnParkTextColor(ColorStateList colorStateList) {
        XTextView xTextView = this.mBtnPark;
        if (xTextView != null) {
            xTextView.setTextColor(colorStateList);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void formatParams(Context context, Map<String, Object> map) {
        this.mContext = context;
        if (map.get("poiInfo") != null) {
            this.mPoiInfo = (XPPoiInfo) map.get("poiInfo");
        }
        if (map.get("isSettingHomeOrOffice") != null) {
            this.mIsSettingHomeOrOffice = ((Boolean) map.get("isSettingHomeOrOffice")).booleanValue();
        }
        if (map.get("clickListener") != null) {
            this.mClickListener = (PoiCardEntryContainer.OnPoiCardEntryContainerClickListener) map.get("clickListener");
        }
    }
}
