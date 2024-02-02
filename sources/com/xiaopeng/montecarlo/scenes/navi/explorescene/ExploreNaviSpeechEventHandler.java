package com.xiaopeng.montecarlo.scenes.navi.explorescene;

import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView;
import com.xiaopeng.montecarlo.scenes.navi.NaviSpeechEventHandler;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes2.dex */
public class ExploreNaviSpeechEventHandler extends NaviSpeechEventHandler {
    public static final int PARALLEL_REROUTE = 2;
    public static final int REROUTE = 1;
    public static final int SET_DESTINATION_RECOMMEND_PARKING = 3;
    public static final int UPDATE_WAY_POINT_OR_SET_DESTINATION = 0;
    private WeakReference<ExploreScenePresenter> mPresenter;

    @Override // com.xiaopeng.montecarlo.scenes.navi.INaviSpeechEventHandler
    public void onSelectRecommendPark(int i, boolean z) {
    }

    public ExploreNaviSpeechEventHandler(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        super(iBaseNaviLogicView, baseNaviPresenter);
        this.mPresenter = new WeakReference<>((ExploreScenePresenter) baseNaviPresenter);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.INaviSpeechEventHandler
    public void onViaAdd(XPPoiInfo xPPoiInfo) {
        if (this.mPresenter.get() == null || xPPoiInfo == null) {
            return;
        }
        RouteRequest createAddViaRequest = RouteRequest.createAddViaRequest(xPPoiInfo, TBTManager.getInstance().getCurrentRouteRequestId());
        if (createAddViaRequest != null) {
            createAddViaRequest.setRequestFrom(1);
            createAddViaRequest.setRoutePreference(SettingWrapper.getAllSettingValue());
        }
        this.mBasePresenter.requestReroute(createAddViaRequest, 0);
        this.mBaseLogicView.removeChildScene();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.INaviSpeechEventHandler
    public void onNewDestWithViasReroute(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2, List<XPViaPoint> list, int i, int i2, int i3) {
        if (this.mPresenter.get() == null) {
            return;
        }
        this.mPresenter.get().setIsStartNaviImmediately(i2 == 1);
        if (i <= 0) {
            i = SettingWrapper.getAllSettingValue();
        }
        this.mBasePresenter.requestReroute(RouteRequest.createNewDesRequestWithVias(xPPoiInfo, xPPoiInfo2, list, i, i2, i3).setRequestFrom(1), 0);
        this.mBaseLogicView.removeChildScene();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.INaviSpeechEventHandler
    public void onReroute() {
        this.mBasePresenter.requestReroute(9, 1, true);
        if (this.mBaseLogicView != null) {
            this.mBaseLogicView.removeChildScene();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.INaviSpeechEventHandler
    public void onStartNavi() {
        if (this.mPresenter.get() == null) {
            return;
        }
        this.mPresenter.get().setSelectRoute(this.mPresenter.get().getSelectRoute());
        this.mPresenter.get().startGuidance();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.INaviSpeechEventHandler
    public void onZoomIn() {
        this.mPresenter.get().updateLastUpdateTime();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.INaviSpeechEventHandler
    public void onZoomOut() {
        this.mPresenter.get().updateLastUpdateTime();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.INaviSpeechEventHandler
    public void onStopNavi() {
        TBTManager.getInstance().stopNavi(true);
    }
}
