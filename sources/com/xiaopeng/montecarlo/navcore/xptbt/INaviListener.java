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
public interface INaviListener {
    void onBeforePathChanged(boolean z);

    void onChangeNaviPath(long j);

    void onDeletePath(List<Long> list, long j, boolean z);

    default void onHideSRTrafficView() {
    }

    void onMainPathChanged();

    void onNaviStart(int i);

    void onNaviStop(int i, boolean z);

    default void onNaviStopWaitingForTTs(int i, boolean z) {
    }

    void onObtainAsyncInfo(XPObtainInfo xPObtainInfo);

    void onReroute(RouteParams routeParams);

    void onSelectMainPathStatus(long j, int i);

    void onShowNaviCamera(List<XPCameraInfo> list);

    void onShowNaviIntervalCamera(List<XPCameraInfo> list);

    void onShowNaviManeuver(XPManeuverInfo xPManeuverInfo);

    default void onShowSRTrafficView(int i) {
    }

    void onShowTollGateLane(XPTollGateInfo xPTollGateInfo);

    void onSuggestChangePath(long j, long j2, long j3);

    void onUpdateCrossImage(XPCrossImageInfo xPCrossImageInfo, int i, boolean z);

    void onUpdateExitDirectionInfo(XPExitDirectionInfo xPExitDirectionInfo);

    void onUpdateIntervalCameraDynamicInfo(List<XPCameraInfo> list);

    void onUpdateNaviInfo(List<XPNaviInfo> list);

    void onUpdateNaviLaneInfo(XPLaneInfo xPLaneInfo, boolean z);

    void onUpdateRemainDis(long j, int i, int i2);

    void onUpdateSAPA(List<XPFacilityInfo> list);

    void onUpdateTMCCongestionInfo(XPNaviCongestionInfo xPNaviCongestionInfo);

    void onUpdateTMCLightBar(List<ILightBarInfo> list, int i, boolean z);

    void onUpdateTREvent(List<XPPathTrafficEventInfo> list, int i);

    void onUpdateTRPlayView(XPRouteTrafficEventInfo xPRouteTrafficEventInfo);

    void onUpdateViaPass(long j);
}
