package com.xiaopeng.montecarlo.navcore.xptbt;

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
import java.util.List;
/* loaded from: classes3.dex */
public class BaseNaviListener implements INaviListener {
    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onBeforePathChanged(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onChangeNaviPath(long j) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onDeletePath(List<Long> list, long j, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onMainPathChanged() {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onNaviStart(int i) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onNaviStop(int i, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onObtainAsyncInfo(XPObtainInfo xPObtainInfo) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onReroute(RouteParams routeParams) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onSelectMainPathStatus(long j, int i) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowNaviCamera(List<XPCameraInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowNaviIntervalCamera(List<XPCameraInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowNaviManeuver(XPManeuverInfo xPManeuverInfo) {
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
    public void onUpdateIntervalCameraDynamicInfo(List<XPCameraInfo> list) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateNaviInfo(List<XPNaviInfo> list) {
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
    public void onUpdateTMCLightBar(List<ILightBarInfo> list, int i, boolean z) {
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
}
