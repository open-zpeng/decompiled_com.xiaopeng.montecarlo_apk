package com.xiaopeng.montecarlo.service.minimap;

import com.xiaopeng.montecarlo.navcore.xptbt.GuideManager;
import com.xiaopeng.montecarlo.navcore.xptbt.INaviListener;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
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
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import java.util.List;
/* loaded from: classes3.dex */
public class MiniNaviListener implements INaviListener, GuideManager.IRerouteListener {
    private static final L.Tag TAG = new L.Tag("MiniNaviListener");
    private MiniMapServiceHelper mMiniMapServiceHelper;

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onObtainAsyncInfo(XPObtainInfo xPObtainInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onReroute(RouteParams routeParams) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.IRerouteListener
    public void onRerouteError(long j, RouteResult routeResult) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.IRerouteListener
    public void onRerouteOddError(long j) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.IRerouteListener
    public void onRerouteOddSuccess(long j, RouteResult routeResult) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowNaviCamera(List<XPCameraInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowNaviIntervalCamera(List<XPCameraInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowTollGateLane(XPTollGateInfo xPTollGateInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onSuggestChangePath(long j, long j2, long j3) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateExitDirectionInfo(XPExitDirectionInfo xPExitDirectionInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateIntervalCameraDynamicInfo(List<XPCameraInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateNaviLaneInfo(XPLaneInfo xPLaneInfo, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateRemainDis(long j, int i, int i2) {
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

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.IRerouteListener
    public void stopOnlineRouteRetryTimer() {
    }

    public MiniNaviListener(MiniMapServiceHelper miniMapServiceHelper) {
        this.mMiniMapServiceHelper = miniMapServiceHelper;
    }

    public void release() {
        this.mMiniMapServiceHelper = null;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateNaviInfo(List<XPNaviInfo> list) {
        if (this.mMiniMapServiceHelper == null || list == null || list.size() <= 0 || list.get(0) == null) {
            return;
        }
        this.mMiniMapServiceHelper.updateNaviInfo(list.get(0));
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateCrossImage(XPCrossImageInfo xPCrossImageInfo, int i, boolean z) {
        if (z) {
            this.mMiniMapServiceHelper.onShowCrossImage(xPCrossImageInfo);
        } else {
            this.mMiniMapServiceHelper.onHideCrossImage(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowNaviManeuver(XPManeuverInfo xPManeuverInfo) {
        MiniMapServiceHelper miniMapServiceHelper = this.mMiniMapServiceHelper;
        if (miniMapServiceHelper != null) {
            miniMapServiceHelper.showNaviManeuver(xPManeuverInfo);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateTMCLightBar(List<ILightBarInfo> list, int i, boolean z) {
        if (z) {
            this.mMiniMapServiceHelper.updateRouteTmc(list);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onNaviStop(final int i, boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniNaviListener.1
            @Override // java.lang.Runnable
            public void run() {
                L.Tag tag = MiniNaviListener.TAG;
                L.i(tag, ">>> onNaviStop type=" + i);
                if (MiniNaviListener.this.mMiniMapServiceHelper != null) {
                    MiniNaviListener.this.mMiniMapServiceHelper.onNaviStop(i);
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateViaPass(long j) {
        MiniMapServiceHelper miniMapServiceHelper = this.mMiniMapServiceHelper;
        if (miniMapServiceHelper != null) {
            miniMapServiceHelper.updateViaPass(j);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onDeletePath(final List<Long> list, final long j, final boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniNaviListener.2
            @Override // java.lang.Runnable
            public void run() {
                if (MiniNaviListener.this.mMiniMapServiceHelper != null) {
                    MiniNaviListener.this.mMiniMapServiceHelper.deletePath(list, j, z);
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onChangeNaviPath(final long j) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniNaviListener.3
            @Override // java.lang.Runnable
            public void run() {
                if (MiniNaviListener.this.mMiniMapServiceHelper != null) {
                    MiniNaviListener.this.mMiniMapServiceHelper.selectMainPath(j);
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onSelectMainPathStatus(final long j, int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniNaviListener.4
            @Override // java.lang.Runnable
            public void run() {
                if (MiniNaviListener.this.mMiniMapServiceHelper != null) {
                    MiniNaviListener.this.mMiniMapServiceHelper.selectMainPath(j);
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onBeforePathChanged(boolean z) {
        MiniMapServiceHelper miniMapServiceHelper = this.mMiniMapServiceHelper;
        if (miniMapServiceHelper != null) {
            miniMapServiceHelper.clearOverlay();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onMainPathChanged() {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniNaviListener.5
            @Override // java.lang.Runnable
            public void run() {
                if (MiniNaviListener.this.mMiniMapServiceHelper != null) {
                    MiniNaviListener.this.mMiniMapServiceHelper.drawRoute();
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onNaviStart(final int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniNaviListener.6
            @Override // java.lang.Runnable
            public void run() {
                if (MiniNaviListener.this.mMiniMapServiceHelper != null) {
                    if (2 == i) {
                        MiniNaviListener.this.mMiniMapServiceHelper.startCruise();
                    } else {
                        MiniNaviListener.this.mMiniMapServiceHelper.startNavi();
                    }
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.IRerouteListener
    public void onRerouteSuccess(long j, RouteResult routeResult) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniNaviListener.7
            @Override // java.lang.Runnable
            public void run() {
                if (MiniNaviListener.this.mMiniMapServiceHelper != null) {
                    MiniNaviListener.this.mMiniMapServiceHelper.drawRoute();
                    MiniNaviListener.this.mMiniMapServiceHelper.showNaviManeuver(TBTManager.getInstance().getNaviManeuverInfo());
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onTBTStatusUpdate(final int i, final int i2) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniNaviListener.8
            @Override // java.lang.Runnable
            public void run() {
                if (MiniNaviListener.this.mMiniMapServiceHelper != null && 2 == i && i2 == 1) {
                    L.i(MiniNaviListener.TAG, "onTBTStatusUpdate to navi");
                    MiniNaviListener.this.mMiniMapServiceHelper.updateResMarker();
                }
            }
        });
    }
}
