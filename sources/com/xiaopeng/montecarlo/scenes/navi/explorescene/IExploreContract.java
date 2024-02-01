package com.xiaopeng.montecarlo.scenes.navi.explorescene;

import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCameraInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPObtainInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTollGateInfo;
import com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView;
import com.xiaopeng.montecarlo.scenes.navi.IBaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.NaviPresenterData;
import java.util.List;
/* loaded from: classes3.dex */
public interface IExploreContract {

    /* loaded from: classes3.dex */
    public interface LogicView extends IBaseNaviLogicView<ExploreScenePresenter> {
        public static final int EXPLORE_MESSAGE_TYPE_DIALOG = 1;
        public static final int EXPLORE_MESSAGE_TYPE_TOAST = 0;

        void initRestrictHelper();

        boolean isMapPoiLocked();

        @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
        void onAsyncManeuverInfo(XPManeuverInfo xPManeuverInfo);

        void onHideNaviLaneInfo();

        void onMainPathChanged();

        void onShowNaviLaneInfo(XPLaneInfo xPLaneInfo);

        @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView
        void onShowNaviManeuver(XPManeuverInfo xPManeuverInfo, XPObtainInfo xPObtainInfo);

        void onUpdateNaviCamera(List<XPCameraInfo> list);

        void onUpdateTollGateInfo(XPTollGateInfo xPTollGateInfo);

        void renderLayoutByDayNightStatus();

        void showStartExploreMsg();

        void unInitData();

        void updateNaviInfo(List<XPNaviInfo> list, int i);

        void updateViewOnSelectRoute(int i);
    }

    /* loaded from: classes3.dex */
    public interface Presenter extends IBaseNaviPresenter {
        XPNaviInfo getNaviInfo(List<XPNaviInfo> list, long j);

        void onNewBridge(NaviPresenterData naviPresenterData);

        void onUpdateNaviInfo(List<XPNaviInfo> list);
    }
}
