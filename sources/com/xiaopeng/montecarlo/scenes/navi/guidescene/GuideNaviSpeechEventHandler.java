package com.xiaopeng.montecarlo.scenes.navi.guidescene;

import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView;
import com.xiaopeng.montecarlo.scenes.navi.NaviSpeechEventHandler;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import java.util.List;
/* loaded from: classes3.dex */
public class GuideNaviSpeechEventHandler extends NaviSpeechEventHandler {
    private INaviContract.LogicView mLogicView;
    private NaviScenePresenter mPresenter;

    @Override // com.xiaopeng.montecarlo.scenes.navi.INaviSpeechEventHandler
    public void onZoomIn() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.INaviSpeechEventHandler
    public void onZoomOut() {
    }

    public GuideNaviSpeechEventHandler(IBaseNaviLogicView iBaseNaviLogicView, NaviScenePresenter naviScenePresenter) {
        super(iBaseNaviLogicView, naviScenePresenter);
        this.mPresenter = naviScenePresenter;
        this.mLogicView = (INaviContract.LogicView) iBaseNaviLogicView;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.INaviSpeechEventHandler
    public void onViaAdd(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo != null) {
            RouteRequest createAddViaRequest = RouteRequest.createAddViaRequest(xPPoiInfo, TBTManager.getInstance().getCurrentRouteRequestId());
            if (createAddViaRequest != null) {
                createAddViaRequest.setRequestFrom(1);
                createAddViaRequest.setRoutePreference(SettingWrapper.getAllSettingValue());
            }
            this.mBasePresenter.requestReroute(createAddViaRequest, 0);
            INaviContract.LogicView logicView = this.mLogicView;
            if (logicView != null) {
                logicView.removeChildScene();
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.INaviSpeechEventHandler
    public void onNewDestWithViasReroute(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2, List<XPViaPoint> list, int i, int i2, int i3) {
        if (xPPoiInfo2 != null) {
            if (i <= 0) {
                i = SettingWrapper.getAllSettingValue();
            }
            this.mBasePresenter.onDestinationUpdate(DecoratorType.END_POINT, RouteRequest.createNewDesRequestWithVias(xPPoiInfo, xPPoiInfo2, list, i, i2, i3).setRequestFrom(1).toBundle());
            INaviContract.LogicView logicView = this.mLogicView;
            if (logicView != null) {
                logicView.removeChildScene();
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.INaviSpeechEventHandler
    public void onStopNavi() {
        TBTManager.getInstance().stopNavi(true);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.INaviSpeechEventHandler
    public void onReroute() {
        this.mBasePresenter.requestReroute(9, 1, true);
        INaviContract.LogicView logicView = this.mLogicView;
        if (logicView != null) {
            logicView.removeChildScene();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.INaviSpeechEventHandler
    public void onStartNavi() {
        this.mBasePresenter.requestReroute(9, 1, true);
        INaviContract.LogicView logicView = this.mLogicView;
        if (logicView != null) {
            logicView.removeChildScene();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.INaviSpeechEventHandler
    public void onSelectRecommendPark(final int i, final boolean z) {
        if (this.mLogicView != null) {
            UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$GuideNaviSpeechEventHandler$jieY9Nrxfd0Vq-hpjDta4LuZCJs
                @Override // java.lang.Runnable
                public final void run() {
                    GuideNaviSpeechEventHandler.this.lambda$onSelectRecommendPark$0$GuideNaviSpeechEventHandler(i, z);
                }
            });
            if (!z || TBTManager.getInstance().getRecommendParkingHelper() == null) {
                return;
            }
            List<XPPoiInfo> recommendParks = TBTManager.getInstance().getRecommendParkingHelper().getRecommendParks();
            if (!CollectionUtils.isNotEmpty(recommendParks) || i <= -1 || i >= recommendParks.size()) {
                return;
            }
            this.mPresenter.requestRouteToRecommendParking(recommendParks.get(i));
        }
    }

    public /* synthetic */ void lambda$onSelectRecommendPark$0$GuideNaviSpeechEventHandler(int i, boolean z) {
        INaviContract.LogicView logicView = this.mLogicView;
        if (logicView != null) {
            logicView.onSelectRecommendParking(i, z);
        }
    }
}
