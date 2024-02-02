package com.xiaopeng.montecarlo.scenes.navi.guidescene;

import android.view.View;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPExitDirectionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPObtainInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTollGateInfo;
import com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView;
import com.xiaopeng.montecarlo.scenes.navi.IBaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.sapa.SapaData;
import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipConfig;
import java.util.List;
/* loaded from: classes2.dex */
public interface INaviContract {

    /* loaded from: classes2.dex */
    public interface LogicView extends IBaseNaviLogicView<NaviScenePresenter> {
        public static final int NAV_MESSAGE_TYPE_DIALOG = 1;
        public static final int NAV_MESSAGE_TYPE_TOAST = 0;

        boolean canShowElement(@UIRelationshipConfig.UIElementDef String str);

        void checkMapviewMode3D();

        void clearSRViewAngleBtnGroupCheck();

        void closeRecommendPark();

        void exchangeEagleEyeView(boolean z, boolean z2);

        void hideCrossUI();

        void initData(boolean z);

        void initListener();

        void initMapMode();

        void initOfflineRoutePanel(int i);

        void initView();

        boolean is3DCrossShow();

        boolean isExpandRecommendParking();

        boolean isMapPoiLocked();

        boolean isOfflineRoutePanelExpand();

        boolean isShowContinueNavi();

        boolean isShowRecommendPark();

        void naviTo1thRecommendPark(View view);

        void naviTo2thRecommendPark(View view);

        void naviTo3thRecommendPark(View view);

        @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
        void onAsyncManeuverInfo(XPManeuverInfo xPManeuverInfo);

        void onHideCrossImage(int i);

        void onHideNaviLaneInfo();

        void onHideOfflineRoutePanel();

        void onHideRecommendParking();

        void onOverviewModeChanged(boolean z);

        void onSelectRecommendParking(int i, boolean z);

        void onShowCrossImage(XPCrossImageInfo xPCrossImageInfo);

        void onShowExitInfo(XPExitDirectionInfo xPExitDirectionInfo);

        void onShowNaviLaneInfo(XPLaneInfo xPLaneInfo);

        @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
        void onShowNaviManeuver(XPManeuverInfo xPManeuverInfo, XPObtainInfo xPObtainInfo);

        void onShowOfflineRoutePanel(boolean z);

        void onShowRecommendParking(List<XPPoiInfo> list, boolean z);

        void onUpdate3DTo2DButton(boolean z);

        void onUpdateAccSpeed(String str);

        void onUpdateLimitSpeed(String str);

        void onUpdateSAPA(List<SapaData> list);

        void onUpdateTMCLightBar(ILightBarInfo iLightBarInfo, int i, boolean z);

        void onUpdateTollGateInfo(XPTollGateInfo xPTollGateInfo);

        void onUpdateTraffic(double d, boolean z);

        void onUpdateTrafficView(boolean z);

        void refreshMapStatus();

        void restoreMotionEventFlag();

        void sendStatDataWhenSystemStartNavi(MainContext mainContext, XPPoiInfo xPPoiInfo, XPCoordinate2DDouble xPCoordinate2DDouble, XPPoiInfo xPPoiInfo2, boolean z, RouteParams routeParams);

        void show1thRecommendParkDetail(View view);

        void show2thRecommendParkDetail(View view);

        void show3thRecommendParkDetail(View view);

        void unInitListener();

        void updateViewState();
    }

    /* loaded from: classes2.dex */
    public interface Presenter extends IBaseNaviPresenter {
    }
}
