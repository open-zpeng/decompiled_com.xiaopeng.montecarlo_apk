package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener;
import com.xiaopeng.montecarlo.navcore.powerdistance.route.RoutePowerDisHelper;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.BatteryView;
import com.xiaopeng.montecarlo.views.NaviImageView;
import com.xiaopeng.montecarlo.views.font.XpFontTagHandler;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XLoading;
import com.xiaopeng.xui.widget.XTextView;
import java.util.Map;
/* loaded from: classes3.dex */
public class PoiCardCarRemainDistance extends XLinearLayout implements BasePoiCardViewContract, OnUpdateRemainDisListener {
    static final int FAKE_PROGRESS_1 = 50;
    static final int FAKE_PROGRESS_2 = 70;
    public static final String KEY_DATA_PROVIDER = "dataProvider";
    public static final String KEY_IS_REFRESH = "isRefresh";
    public static final String KEY_MAIN_CONTEXT = "mainContext";
    public static final String KEY_POI_INFO = "poiInfo";
    private static final L.Tag TAG = new L.Tag("Card_PCCRD");
    private XTextView mBatteryChargeTips;
    private BatteryView mBatteryIcon;
    private XLoading mBatteryLoading;
    private XTextView mBatteryStatus;
    private XTextView mBatteryStatusTips;
    private Context mContext;
    private IPoiCardDataProvider mDataProvider;
    private LayoutInflater mInflater;
    private boolean mIsRefresh;
    private OnChildLayoutCompletedListener mLayoutListener;
    private XLoading mLoading;
    private MainContext mMainContext;
    private NaviImageView mMileIcon;
    private XTextView mNaviDistance;
    private XPPoiInfo mPoiInfo;
    private ViewGroup mRootView;
    private RoutePowerDisHelper mRoutePowerDisHelper;
    private XpFontTagHandler mXpFontTagHandler;

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
    }

    public PoiCardCarRemainDistance(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        super(context);
        this.mIsRefresh = false;
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mRootView = (ViewGroup) this.mInflater.inflate(R.layout.layout_car_remain_distance_in_poi_pop, (ViewGroup) this, true);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRootView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 16;
        }
        layoutParams.height = ContextUtils.getDimensionPixelSize(R.dimen.poi_item_height);
        this.mRootView.setLayoutParams(layoutParams);
        setGravity(16);
        executeAfterViewInflated(this.mRootView);
    }

    public void setMileIconImageDrawable(Drawable drawable) {
        NaviImageView naviImageView = this.mMileIcon;
        if (naviImageView != null) {
            naviImageView.setImageDrawable(drawable);
        }
    }

    public void setNaviDistanceTextColor(int i) {
        XTextView xTextView = this.mNaviDistance;
        if (xTextView != null) {
            xTextView.setTextColor(i);
        }
    }

    public void setNaviDistanceText(String str) {
        XTextView xTextView = this.mNaviDistance;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    public void setNaviDistanceText(Spanned spanned) {
        XTextView xTextView = this.mNaviDistance;
        if (xTextView != null) {
            xTextView.setText(spanned);
        }
    }

    public void showNaviDistanceProgressBar() {
        XLoading xLoading = this.mLoading;
        if (xLoading == null || xLoading.getVisibility() == 0) {
            return;
        }
        this.mLoading.setVisibility(0);
    }

    public void hideNaviDistanceProgressBar() {
        XLoading xLoading = this.mLoading;
        if (xLoading == null || xLoading.getVisibility() == 8) {
            return;
        }
        this.mLoading.setVisibility(8);
    }

    public void showBatteryIcon() {
        BatteryView batteryView = this.mBatteryIcon;
        if (batteryView == null || batteryView.getVisibility() == 0) {
            return;
        }
        this.mBatteryIcon.setVisibility(0);
    }

    public void hideBatteryIcon() {
        BatteryView batteryView = this.mBatteryIcon;
        if (batteryView == null || batteryView.getVisibility() == 8) {
            return;
        }
        this.mBatteryIcon.setVisibility(8);
    }

    public void updateBattery(int i, int i2, int i3) {
        BatteryView batteryView = this.mBatteryIcon;
        if (batteryView != null) {
            batteryView.updateBattery(i, i2, i3);
        }
    }

    public void updateBatteryStatus(int i, int i2, int i3) {
        BatteryView batteryView = this.mBatteryIcon;
        if (batteryView != null) {
            batteryView.updateBatteryStatus(i, i2, i3);
        }
    }

    public void setBatteryStatusTextColor(int i) {
        XTextView xTextView = this.mBatteryStatus;
        if (xTextView != null) {
            xTextView.setTextColor(i);
        }
    }

    public void setBatteryStatusText(String str) {
        XTextView xTextView = this.mBatteryStatus;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    public void setBatteryStatusLoadingTextColor(int i) {
        XTextView xTextView = this.mBatteryStatusTips;
        if (xTextView != null) {
            xTextView.setTextColor(i);
        }
    }

    public void showBatteryStatusLoading() {
        XTextView xTextView = this.mBatteryStatusTips;
        if (xTextView == null || xTextView.getVisibility() == 0) {
            return;
        }
        this.mBatteryStatusTips.setVisibility(0);
    }

    public void setBatteryStatusLoadingText(String str) {
        XTextView xTextView = this.mBatteryStatusTips;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    public void hideBatteryStatusLoading() {
        XTextView xTextView = this.mBatteryStatusTips;
        if (xTextView == null || xTextView.getVisibility() == 8) {
            return;
        }
        this.mBatteryStatusTips.setVisibility(8);
    }

    public void showBatteryStatusProgressBar() {
        XLoading xLoading = this.mBatteryLoading;
        if (xLoading == null || xLoading.getVisibility() == 0) {
            return;
        }
        this.mBatteryLoading.setVisibility(0);
    }

    public void hideBatteryStatusProgressBar() {
        XLoading xLoading = this.mBatteryLoading;
        if (xLoading == null || xLoading.getVisibility() == 8) {
            return;
        }
        this.mBatteryLoading.setVisibility(8);
    }

    public void hideBatteryChargeTips() {
        XTextView xTextView = this.mBatteryChargeTips;
        if (xTextView == null || xTextView.getVisibility() == 8) {
            return;
        }
        this.mBatteryChargeTips.setVisibility(8);
    }

    public void showBatteryChargeTips() {
        XTextView xTextView = this.mBatteryChargeTips;
        if (xTextView == null || xTextView.getVisibility() == 0) {
            return;
        }
        this.mBatteryChargeTips.setVisibility(0);
    }

    public void setBatteryChargeTipsText(String str) {
        XTextView xTextView = this.mBatteryChargeTips;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    public void setBatteryChargeTipsTextColor(int i) {
        XTextView xTextView = this.mBatteryChargeTips;
        if (xTextView != null) {
            xTextView.setTextColor(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void init(Context context, Map<String, Object> map) {
        formatParams(context, map);
        this.mXpFontTagHandler = new XpFontTagHandler(ContextUtils.getContext().getResources().getDisplayMetrics());
        initView();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeAfterViewInflated(View view) {
        if (view == null) {
            L.e(TAG, "execute after view inflated view is null");
            return;
        }
        this.mMileIcon = (NaviImageView) view.findViewById(R.id.mile_icon);
        this.mLoading = (XLoading) view.findViewById(R.id.progressBar_navi_distance);
        this.mNaviDistance = (XTextView) view.findViewById(R.id.navi_distance);
        this.mBatteryIcon = (BatteryView) view.findViewById(R.id.battery_icon);
        this.mBatteryStatusTips = (XTextView) view.findViewById(R.id.loading_battery_status);
        this.mBatteryLoading = (XLoading) view.findViewById(R.id.progressBar_battery_status);
        this.mBatteryStatus = (XTextView) view.findViewById(R.id.battery_status);
        this.mBatteryChargeTips = (XTextView) view.findViewById(R.id.battery_charge_tips);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        setViewListener();
        renderNaviInfo();
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
        if (map.get("isRefresh") != null) {
            this.mIsRefresh = ((Boolean) map.get("isRefresh")).booleanValue();
        }
        L.Tag tag = TAG;
        L.i(tag, "formatParams mIsRefresh:" + this.mIsRefresh);
        if (map.get("poiInfo") != null) {
            XPPoiInfo xPPoiInfo = (XPPoiInfo) map.get("poiInfo");
            if (!NavCoreUtil.isSamePOI(xPPoiInfo, this.mPoiInfo)) {
                if (L.ENABLE) {
                    L.d(TAG, "formatParams is not SamePOI : closeRoutePowerDisHelper");
                }
                closeRoutePowerDisHelper();
                IPoiCardDataProvider iPoiCardDataProvider = this.mDataProvider;
                if (iPoiCardDataProvider != null) {
                    iPoiCardDataProvider.cancelLastRoute();
                }
                this.mIsRefresh = false;
            }
            this.mPoiInfo = xPPoiInfo;
        }
        if (map.get("mainContext") != null) {
            this.mMainContext = (MainContext) map.get("mainContext");
        }
        if (map.get(KEY_DATA_PROVIDER) != null) {
            this.mDataProvider = (IPoiCardDataProvider) map.get(KEY_DATA_PROVIDER);
        }
    }

    private void renderNaviInfo() {
        if (this.mIsRefresh || this.mMainContext == null) {
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "renderNaviInfo");
        }
        resetNaviInfo();
        if (this.mMainContext.getMapView() == null) {
            L.w(TAG, "renderNaviInfo mMapViewWrapper is null");
            return;
        }
        updateRoutingStatus(true);
        calculateRouteDistance();
    }

    private void updateRoutingStatus(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateRoutingStatus isShowRouting = " + z);
        }
        if (z) {
            showBatteryStatusProgressBar();
            showNaviDistanceProgressBar();
            hideBatteryIcon();
            updateBattery(0, 50, 70);
            setNaviDistanceText(ContextUtils.getString(R.string.unit_km));
            setBatteryStatusTextColor(ContextUtils.getColor(ThemeWatcherUtil.getColorResId(R.color.poi_card_text_color_02)));
            setBatteryStatusText(ContextUtils.getString(R.string.unit_km));
            showBatteryStatusLoading();
            setBatteryStatusLoadingText(ContextUtils.getString(R.string.tv_power_endurance_name_loading));
            hideBatteryChargeTips();
            return;
        }
        hideBatteryStatusProgressBar();
        hideNaviDistanceProgressBar();
        hideBatteryStatusLoading();
        showBatteryChargeTips();
        setNaviDistanceText("");
        setBatteryStatusText("");
    }

    private void calculateRouteDistance() {
        if (this.mPoiInfo == null) {
            return;
        }
        int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
        boolean z = true;
        if (carRemainDistance > 200000 && carRemainDistance > this.mPoiInfo.getDefaultDistanceForDisplay()) {
            if (L.ENABLE) {
                L.d(TAG, "calculateRouteDistance carRemainDis > 200Km && carRemainDis > horizontal distance");
            }
        } else if (this.mPoiInfo.getDefaultDistanceForDisplay() > 200000.0d) {
            z = false;
        } else if (L.ENABLE) {
            L.d(TAG, "calculateRouteDistance horizontal distance <= 200Km");
        }
        if (L.ENABLE) {
            boolean isRouting = TBTManager.getInstance().isRouting();
            L.d(TAG, "calculateRouteDistance isNeedRoute:" + z + ", isRouting: " + isRouting);
        }
        if (z) {
            if (L.ENABLE) {
                L.d(TAG, "calculateRouteDistance route");
            }
            XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
            IPoiCardDataProvider iPoiCardDataProvider = this.mDataProvider;
            if (iPoiCardDataProvider != null) {
                iPoiCardDataProvider.route(startPOIFromCurrent, this.mPoiInfo);
                return;
            }
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "calculateRouteDistance updateRoutingStatus");
        }
        updateRoutingStatus(false);
        formatNaviDistance(getDistanceString(this.mPoiInfo.getDefaultDistanceForDisplay()), this.mPoiInfo.getDefaultDistanceForDisplay());
    }

    private void resetNaviInfo() {
        setNaviDistanceText("");
        setBatteryStatusText("");
        setBatteryChargeTipsText("");
    }

    private void formatNaviDistance(String[] strArr, double d) {
        formatNaviDistance(null, null, strArr, d);
    }

    private void formatNaviDistance(IVariantPath iVariantPath, IPathResult iPathResult, String[] strArr, double d) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "formatNaviDistance distance = " + d);
        }
        settingNaviDistance(strArr);
        int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
        if (iVariantPath == null) {
            refreshNaviDistance(carRemainDistance, (int) (carRemainDistance - d), (int) d);
        } else if (this.mRoutePowerDisHelper != null) {
            if (iVariantPath.getPathId() == this.mRoutePowerDisHelper.getPathId()) {
                this.mRoutePowerDisHelper.updateRemainDis();
                return;
            }
            closeRoutePowerDisHelper();
            refreshNaviDistance(carRemainDistance, (int) (carRemainDistance - d), (int) d);
        }
    }

    public void settingNaviDistance(String[] strArr) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "settingNaviDistance distanceStr:" + strArr);
        }
        String str = strArr.length > 1 ? strArr[1] : "";
        String string = ContextUtils.getString(R.string.pattern_nav_distance_in_poi_pop);
        setNaviDistanceText(String.format(string, strArr[0] + str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshNaviDistance(int i, int i2, int i3) {
        int i4;
        if (L.ENABLE) {
            L.d(TAG, "refreshNaviDistance carRemainDis = " + i);
        }
        showBatteryStatus(i, i2, i3);
        long j = i;
        renderBatteryStatus(j, i2);
        try {
            i4 = NaviUtil.checkDistanceReachableStatus(j, i2);
        } catch (NaviUtil.DistanceStatusIllegalArgumentException unused) {
            if (L.ENABLE) {
                L.d(TAG, "INVALID remain dis and leftDistance remain dis: " + i + " leftDis: " + i2);
            }
            i4 = 2;
        }
        if (i4 == 0) {
            handleDistanceUnreachable(i3, i);
        } else if (i4 == 1) {
            showBatteryStatusBigThan1Km(i2);
        } else if (i4 != 2) {
        } else {
            showBatteryLow();
        }
    }

    public void showBatteryStatus(int i, int i2, int i3) {
        showBatteryIcon();
        updateBatteryStatus(i, i2, i3);
    }

    public void showBatteryStatusBigThan1Km(int i) {
        String[] remainDistanceArray = NaviUtil.getRemainDistanceArray(i);
        setBatteryStatusText(String.format(ContextUtils.getString(R.string.tv_power_endurance_name_para), remainDistanceArray[0], remainDistanceArray[1]));
    }

    public void showBatteryLow() {
        setBatteryStatusText(ContextUtils.getString(R.string.route_detail_endurance_lower_power));
    }

    private void handleDistanceUnreachable(double d, int i) {
        showBatteryStatusUnableReach();
        int maxMileAge = CarServiceManager.getInstance().getMaxMileAge();
        int ceil = maxMileAge > 0 ? (int) Math.ceil((d - i) / (maxMileAge * 0.8d)) : 0;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "handleDistanceUnreachable distance:" + d + ",carRemainDis:" + i + ",maxDistance:" + maxMileAge + ",diff:" + ceil);
        }
        if (ceil <= 0) {
            ceil = 1;
        }
        if (ceil <= 2) {
            showChargeTimesLessThanTwice(ceil);
        } else {
            showChargeTimesMoreThanTwice();
        }
    }

    public void showBatteryStatusUnableReach() {
        setBatteryStatusText(ContextUtils.getString(R.string.charge_unable_reach_des));
    }

    public void showChargeTimesLessThanTwice(int i) {
        setBatteryChargeTipsText(String.format(ContextUtils.getString(R.string.charge_times), Integer.valueOf(i)));
    }

    public void showChargeTimesMoreThanTwice() {
        setBatteryChargeTipsText(ContextUtils.getString(R.string.charge_times_multi));
    }

    private void renderBatteryStatus(long j, int i) {
        showRuleTextColor(NaviUtil.checkColorStatus(j, i));
    }

    public String[] getDistanceString(double d) {
        return NaviUtil.getDistanceArray(d);
    }

    public void showRuleTextColor(int i) {
        setBatteryStatusTextColor(i);
        setBatteryChargeTipsTextColor(i);
    }

    public void closeRoutePowerDisHelper() {
        RoutePowerDisHelper routePowerDisHelper = this.mRoutePowerDisHelper;
        if (routePowerDisHelper != null) {
            routePowerDisHelper.close();
            this.mRoutePowerDisHelper = null;
        }
    }

    public void onRouteSuccess(IVariantPath iVariantPath, IPathResult iPathResult, RouteResult.RouteInfo routeInfo, XPPoiInfo xPPoiInfo) {
        if (L.ENABLE) {
            L.d(TAG, "onRouteSuccess");
        }
        updateRoutingStatus(false);
        closeRoutePowerDisHelper();
        this.mRoutePowerDisHelper = new RoutePowerDisHelper(null, iVariantPath, iPathResult, this);
        formatNaviDistance(iVariantPath, iPathResult, getDistanceString(routeInfo.mPathLength), routeInfo.mPathLength);
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener
    public void onUpdateRemainDis(long j, final int i, final int i2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onUpdateRemainDis remainDis = " + i2);
        }
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardCarRemainDistance.1
            @Override // java.lang.Runnable
            public void run() {
                PoiCardCarRemainDistance.this.refreshNaviDistance(CarServiceManager.getInstance().getCarRemainDistance(), i2, i);
            }
        });
        closeRoutePowerDisHelper();
    }

    public void onRouteFailure(XPPoiInfo xPPoiInfo) {
        if (L.ENABLE) {
            L.d(TAG, "onRouteFailure");
        }
        updateRoutingStatus(false);
        formatNaviDistance(getDistanceString(this.mPoiInfo.getDefaultDistanceForDisplay()), this.mPoiInfo.getDefaultDistanceForDisplay());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        closeRoutePowerDisHelper();
        this.mLayoutListener = null;
    }

    public void noticeCardHide() {
        if (L.ENABLE) {
            L.d(TAG, "noticeCardHide");
        }
        closeRoutePowerDisHelper();
    }
}
