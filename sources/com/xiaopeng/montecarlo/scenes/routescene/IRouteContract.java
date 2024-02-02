package com.xiaopeng.montecarlo.scenes.routescene;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.path.model.AvoidTrafficJamInfo;
import com.autonavi.gbl.common.path.model.TrafficIncident;
import com.xiaopeng.montecarlo.base.IBasePresenter;
import com.xiaopeng.montecarlo.base.IMapLogicView;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.navcore.bean.route.RouteDetailInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPOddInfo;
import com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract;
import com.xiaopeng.montecarlo.trafficevent.TrafficEventPopParam;
import com.xiaopeng.montecarlo.views.ChargeRouteView;
import java.util.List;
/* loaded from: classes2.dex */
public interface IRouteContract {

    /* loaded from: classes2.dex */
    public interface LogicView extends IMapLogicView<RouteScenePresenter> {
        public static final int ROUTE_MESSAGE_TYPE_DIALOG = 1;
        public static final int ROUTE_MESSAGE_TYPE_TOAST = 0;
        public static final int ROUTE_MESSAGE_TYPE_TOAST_MID = 2;

        void addRouteChargeToBar(ChargeRouteView.ChargePoint chargePoint, double d, boolean z);

        void cancelCountdownGuide(boolean z);

        RouteRequest convertBundle2Request(Bundle bundle);

        void createRouteContent(IPathResult iPathResult, int i);

        void focusRouteChargeOnBar(ChargeRouteView.ChargePoint chargePoint);

        String getAvoidJamDesc(AvoidTrafficJamInfo avoidTrafficJamInfo);

        int getErrorCodeLen();

        String getIncidentDesc(TrafficIncident trafficIncident);

        int getOfflineRemainTime();

        RestrictHelper getRestrictHelper();

        String getSpeechSelectRouteStr(int i);

        void goBackToRoute();

        boolean hasChildScene();

        void hideExploreAndReferenceForVoice();

        void hideOffline();

        void hidePoiPop();

        void hideRouteChargePanel(boolean z);

        void hideRouting();

        void hideTip();

        void initRouteChargeBar(long j, long j2, long j3, double d, boolean z);

        boolean isOfflineRoutePanelExpand();

        boolean isRouting();

        void onInfoflowCardHeightChanged(int i);

        void onInitView();

        void onRouteElemClick();

        void openFavourate();

        void openSearchNormal();

        void removeChildScene();

        void removeRouteChargesOnBar(List<String> list, double d, boolean z);

        void renderRoute(int i);

        void renderRoutes(IPathResult iPathResult, int i);

        void routePanelInvisible();

        void showChargeLoading(boolean z);

        void showOfflineTips(boolean z);

        void showOverViewButton(boolean z);

        void showPoiPop(DecoratorType decoratorType, XPPoiInfo xPPoiInfo);

        void showRouteChargeDetailView(boolean z, boolean z2, boolean z3, String str, String str2, long j, long j2, boolean z4, long j3, boolean z5, boolean z6);

        void showRouteChargePlanDialog(String str, String str2, IRouteChargeContract.IRoutePlanConfirmCallBack iRoutePlanConfirmCallBack);

        void showRouteFailMsg(int i);

        void showRouteMsg(int i, int i2);

        void showRouteMsg(int i, String str);

        void showRoutePanelWithAnimate();

        void showRoutePreview();

        void showRouteTrafficEventPop(TrafficEventPopParam trafficEventPopParam);

        void showRouting(boolean z);

        void showTip(int i, String str);

        void startCountdownGuide(boolean z);

        void startExplore(int i, long j, int i2, boolean z);

        void startGuidance(boolean z, long j, int i, int i2);

        void updateDebugContainerDisplayState(boolean z);

        void updateMapUi();

        void updateOddInfo(List<XPOddInfo> list);

        void updatePathK(double d);

        void updatePreviewRect(RectDouble rectDouble);

        void updatePreviewRect(RectDouble rectDouble, int i);

        void updateRouteChargeCarRemain();

        void updateRouteChargePlanSwitchStatus(boolean z, boolean z2);

        void updateRouteChargesBar(long j, long j2, long j3, List<ChargeRouteView.ChargePoint> list, double d, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface Presenter extends IBasePresenter {
        void cancelRoute();

        void collectRouteDetailInfo(long j, RouteDetailInfo routeDetailInfo, int i, boolean z);

        void countDownOnEnd();

        XPCoordinate2DDouble getEndPoint();

        void handleDetailIncident();

        void hideRouteChargePanel(boolean z);

        boolean isRouteChargeEnable();

        boolean isRouteChargeFocused();

        boolean onBackPressed();

        void onBackResult(int i, RouteRequest routeRequest);

        void onClickBlank();

        void onClickStartNavi(boolean z);

        void onInit(MainContext mainContext, RouteSaveState routeSaveState);

        void onResume(boolean z, @Nullable RouteRequest routeRequest);

        void onRouteChargePlanBtnSwitched(boolean z);

        void onSceneNewBridge(boolean z, @Nullable RouteRequest routeRequest);

        void onUninit();

        long requestReroute(boolean z);

        long requestRoute(RouteRequest routeRequest);

        void sendStatDataForBtnNavi();

        void sendStatDataForRoutePlate(int i, Object... objArr);

        void setSelectRoute(int i);

        void startExplore();

        void startExploreCountDown();

        void startGuidance();

        void startGuidance(int i);

        void startRestoreGuidance();

        void startSpeechDialog();

        void stopSpeechDialog();

        void updateDataWhenRequest(String str, boolean z, int i, boolean z2, boolean z3, int i2);

        void updateSelectRoute(int i);
    }
}
