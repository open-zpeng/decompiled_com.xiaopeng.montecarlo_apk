package com.xiaopeng.montecarlo.scenes.navi;

import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.INaviListener;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCameraInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPExitDirectionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviCongestionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPObtainInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPPathTrafficEventInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPRouteTrafficEventInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTollGateInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.stat.NaviStatUtil;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes2.dex */
public class NaviListener implements INaviListener {
    private static final int VIA_REMIND_DIS = 1000;
    protected WeakReference<IBaseNaviLogicView> mBaseLogicView;
    protected WeakReference<BaseNaviPresenter> mBasePresenter;
    private boolean mChargeViaRemind = false;

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onBeforePathChanged(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onMainPathChanged() {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onNaviStart(int i) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onSelectMainPathStatus(long j, int i) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowNaviCamera(List<XPCameraInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowTollGateLane(XPTollGateInfo xPTollGateInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onSuggestChangePath(long j, long j2, long j3) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateCrossImage(XPCrossImageInfo xPCrossImageInfo, int i, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateExitDirectionInfo(XPExitDirectionInfo xPExitDirectionInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateNaviInfo(List<XPNaviInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateNaviLaneInfo(XPLaneInfo xPLaneInfo, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateSAPA(List<XPFacilityInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateTMCCongestionInfo(XPNaviCongestionInfo xPNaviCongestionInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateTREvent(List<XPPathTrafficEventInfo> list, int i) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateTRPlayView(XPRouteTrafficEventInfo xPRouteTrafficEventInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateViaPass(long j) {
    }

    public NaviListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        this.mBaseLogicView = new WeakReference<>(iBaseNaviLogicView);
        this.mBasePresenter = new WeakReference<>(baseNaviPresenter);
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowNaviManeuver(XPManeuverInfo xPManeuverInfo) {
        if (xPManeuverInfo == null || this.mBaseLogicView.get() == null || this.mBasePresenter.get() == null) {
            return;
        }
        this.mBasePresenter.get().updateNaviManeuerInfo(xPManeuverInfo);
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowNaviIntervalCamera(final List<XPCameraInfo> list) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.NaviListener.1
            @Override // java.lang.Runnable
            public void run() {
                if (NaviListener.this.mBaseLogicView.get() == null || NaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                NaviListener.this.mBaseLogicView.get().onShowNaviIntervalCamera(list);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateIntervalCameraDynamicInfo(final List<XPCameraInfo> list) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.NaviListener.2
            @Override // java.lang.Runnable
            public void run() {
                if (NaviListener.this.mBaseLogicView.get() == null || NaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                NaviListener.this.mBaseLogicView.get().onUpdateIntervalCameraDynamicInfo(list);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateTMCLightBar(final List<ILightBarInfo> list, int i, final boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.NaviListener.3
            @Override // java.lang.Runnable
            public void run() {
                if (NaviListener.this.mBaseLogicView.get() == null || NaviListener.this.mBasePresenter.get() == null || !z) {
                    return;
                }
                NaviListener.this.mBaseLogicView.get().getMapView().getBizControlManager().updateRouteTmc(list);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onObtainAsyncInfo(final XPObtainInfo xPObtainInfo) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.NaviListener.4
            @Override // java.lang.Runnable
            public void run() {
                if (NaviListener.this.mBaseLogicView.get() == null || NaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                if (xPObtainInfo != null) {
                    NaviListener.this.mBaseLogicView.get().onShowNaviManeuver(null, xPObtainInfo);
                    return;
                }
                NaviListener.this.mBaseLogicView.get().onShowNaviManeuver(TBTManager.getInstance().getNaviManeuverInfo(), null);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onNaviStopWaitingForTTs(final int i, final boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.NaviListener.5
            @Override // java.lang.Runnable
            public void run() {
                if (NaviListener.this.mBaseLogicView.get() == null || NaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                NaviListener.this.mBasePresenter.get().stopNaviWaitingForTTs(i, z);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onNaviStop(final int i, final boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.NaviListener.6
            @Override // java.lang.Runnable
            public void run() {
                if (NaviListener.this.mBaseLogicView.get() == null || NaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                NaviListener.this.mBasePresenter.get().stopNavi(i, z);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onReroute(final RouteParams routeParams) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.NaviListener.7
            @Override // java.lang.Runnable
            public void run() {
                if (NaviListener.this.mBaseLogicView.get() == null || NaviListener.this.mBasePresenter.get() == null || routeParams == null || NaviListener.this.mBaseLogicView == null || NavCoreUtil.isSilentCalcRoute(routeParams.mRerouteType) || !TBTManager.getInstance().isRouting()) {
                    return;
                }
                NaviListener.this.mBaseLogicView.get().onShowRouting(!routeParams.mCurRequestIsOnline);
            }
        });
        if (routeParams == null || this.mBaseLogicView.get() == null || NavCoreUtil.isSilentCalcRoute(routeParams.mRerouteType)) {
            return;
        }
        NaviStatUtil.sendStatDataWhenDeviation(this.mBaseLogicView.get().getMainContext(), routeParams.mEndInfo);
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onDeletePath(final List<Long> list, final long j, final boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.NaviListener.8
            @Override // java.lang.Runnable
            public void run() {
                if (NaviListener.this.mBaseLogicView.get() == null || NaviListener.this.mBasePresenter.get() == null || CollectionUtils.isEmpty(list) || z) {
                    return;
                }
                NaviListener.this.mBasePresenter.get().deleteCandidatePath(list, j);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onChangeNaviPath(final long j) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.NaviListener.9
            @Override // java.lang.Runnable
            public void run() {
                if (NaviListener.this.mBaseLogicView.get() == null || NaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                boolean isOpenRadar = SettingWrapper.isOpenRadar();
                NaviListener.this.mBasePresenter.get().selectMainPath(j, false);
                if (isOpenRadar) {
                    return;
                }
                NaviListener.this.mBasePresenter.get().updateTBTAndRoute(false, TBTManager.getInstance().getCurrentNaviId(), TBTManager.getInstance().getCurrentNaviPathIndex());
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateRemainDis(final long j, final int i, final int i2) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.NaviListener.10
            @Override // java.lang.Runnable
            public void run() {
                if (NaviListener.this.mBaseLogicView.get() == null || NaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                NaviListener.this.mBaseLogicView.get().onUpdateRemainDis(j, i, i2);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowSRTrafficView(final int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.NaviListener.11
            @Override // java.lang.Runnable
            public void run() {
                if (NaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                NaviListener.this.mBasePresenter.get().updateSRTrafficView(i);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onHideSRTrafficView() {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.NaviListener.12
            @Override // java.lang.Runnable
            public void run() {
                if (NaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                NaviListener.this.mBasePresenter.get().updateSRTrafficView(0);
            }
        });
    }
}
