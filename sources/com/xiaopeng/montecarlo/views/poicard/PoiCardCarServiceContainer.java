package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCarServiceInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.Map;
/* loaded from: classes3.dex */
public class PoiCardCarServiceContainer extends XLinearLayout implements BasePoiCardViewContract {
    public static final String KEY_POI_INFO = "poiInfo";
    private static final L.Tag TAG = new L.Tag("PoiCardCarServiceContainer");
    private Context mContext;
    private OnChildLayoutCompletedListener mLayoutListener;
    private XPPoiInfo mPoiInfo;
    private ViewGroup mRootView;
    private XTextView mTvDelivery;
    private XTextView mTvExperience;
    private XTextView mTvOpen;
    private XTextView mTvService;

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
    }

    public PoiCardCarServiceContainer(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        super(context);
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.layout_poi_card_carservice_container, (ViewGroup) this, true);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRootView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.bottomMargin = ContextUtils.getDimensionPixelSize(R.dimen.poi_address_bottom_margin);
        this.mRootView.setLayoutParams(layoutParams);
        executeAfterViewInflated(this.mRootView);
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
        this.mTvExperience = (XTextView) view.findViewById(R.id.tv_experience);
        this.mTvService = (XTextView) view.findViewById(R.id.tv_service);
        this.mTvDelivery = (XTextView) view.findViewById(R.id.tv_delivery);
        this.mTvOpen = (XTextView) view.findViewById(R.id.tv_open);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        setViewListener();
        renderCarServiceTag();
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
    }

    private void renderCarServiceTag() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        if (xPPoiInfo == null || xPPoiInfo.getXPCarServiceInfo() == null) {
            this.mTvExperience.setVisibility(8);
            this.mTvService.setVisibility(8);
            this.mTvDelivery.setVisibility(8);
            this.mTvOpen.setVisibility(8);
            return;
        }
        XPCarServiceInfo xPCarServiceInfo = this.mPoiInfo.getXPCarServiceInfo();
        if (xPCarServiceInfo.isExpCenter()) {
            this.mTvExperience.setVisibility(0);
        } else {
            this.mTvExperience.setVisibility(8);
        }
        if (xPCarServiceInfo.isSerCenter()) {
            this.mTvService.setVisibility(0);
        } else {
            this.mTvService.setVisibility(8);
        }
        if (xPCarServiceInfo.isDelCenter()) {
            this.mTvDelivery.setVisibility(0);
        } else {
            this.mTvDelivery.setVisibility(8);
        }
        if (2 == xPCarServiceInfo.getStatus()) {
            this.mTvOpen.setVisibility(0);
        } else {
            this.mTvOpen.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mLayoutListener = null;
    }
}
