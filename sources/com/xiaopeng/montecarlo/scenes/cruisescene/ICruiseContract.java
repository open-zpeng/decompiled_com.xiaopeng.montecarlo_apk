package com.xiaopeng.montecarlo.scenes.cruisescene;

import android.os.Bundle;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.xiaopeng.montecarlo.base.IBasePresenter;
import com.xiaopeng.montecarlo.base.IMapLogicView;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCruiseCongestionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import java.util.List;
/* loaded from: classes3.dex */
public interface ICruiseContract {

    /* loaded from: classes3.dex */
    public interface CheckAndMoveCarGreetingListner {
        void checkAndCallBackUserSearchInThread();
    }

    /* loaded from: classes3.dex */
    public interface LogicView extends IMapLogicView<CruiseScenePresenter> {
        void dismissLoadingDialog();

        CarLoc getCarLocation();

        void goToMapOnCruise();

        void hideCruisePoiPop();

        void initDialogTimer();

        void initRecomendChargeListener();

        boolean isNeedShowResumeTripShowing();

        boolean isResumeTripState();

        boolean isSearchLoading();

        boolean isTopSceneCruise();

        void moveSearchBar(boolean z);

        void onHideCruiseLaneInfo();

        void onMapRecenterUpdate();

        void onShowCruiseLaneInfo(XPLaneInfo xPLaneInfo);

        void onStateActive();

        void onStateImmersion();

        void onUpdateCruiseCongestionInfo(XPCruiseCongestionInfo xPCruiseCongestionInfo);

        void onUpdateCruiseFacility(List<XPFacilityInfo> list);

        void registerMapStateObserver();

        void remoteClearRenderRoutes(long j, boolean z);

        void remoteSetMapLevel(int i);

        void renderCommutingForecastRoutes(IPathResult iPathResult, long j, boolean z);

        void renderLayoutByDayNightStatus();

        void resumeTrip(boolean z, boolean z2);

        void setAiMsgShow(boolean z);

        void showCommutingForecast(int i, long j, long j2);

        void showLoadingDialog();

        void showResumeTripDialog();

        void startNaviGuiderScene();

        void startRecommendCharge();

        void startRouteSceneForResumeTrip(Bundle bundle);

        void stopRecommendCharge();

        void unregisterMapStateObserver();

        void updateAlreadyResumeTripState(boolean z);

        void updateMapCurrentRoadName(String str);

        void updateMapCurrentRoadStatus(boolean z);

        void updateSearchPanel(boolean z);

        void updateViews();
    }

    /* loaded from: classes3.dex */
    public interface Presenter extends IBasePresenter, CheckAndMoveCarGreetingListner {
        void cancelRestoreRoute();

        boolean checkIsLegal();

        boolean checkShowNaviGuiderView();

        void goBackMapCenter();

        void init();

        void initView(boolean z);

        void requestResumeTrip(Bundle bundle);
    }
}
