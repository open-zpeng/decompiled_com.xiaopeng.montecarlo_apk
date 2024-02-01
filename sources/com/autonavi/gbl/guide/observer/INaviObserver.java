package com.autonavi.gbl.guide.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.ElecVehicleETAInfo;
import com.autonavi.gbl.common.path.model.TollGateInfo;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.guide.model.ChangeNaviPathResult;
import com.autonavi.gbl.guide.model.CrossImageInfo;
import com.autonavi.gbl.guide.model.CrossType;
import com.autonavi.gbl.guide.model.DriveEventTip;
import com.autonavi.gbl.guide.model.DriveReport;
import com.autonavi.gbl.guide.model.DynamicOperationDisplayEvent;
import com.autonavi.gbl.guide.model.ExitDirectionInfo;
import com.autonavi.gbl.guide.model.ExitDirectionResponseData;
import com.autonavi.gbl.guide.model.FileOperationEvent;
import com.autonavi.gbl.guide.model.LaneInfo;
import com.autonavi.gbl.guide.model.LightBarDetail;
import com.autonavi.gbl.guide.model.LightBarInfo;
import com.autonavi.gbl.guide.model.LockScreenTip;
import com.autonavi.gbl.guide.model.ManeuverIconResponseData;
import com.autonavi.gbl.guide.model.ManeuverInfo;
import com.autonavi.gbl.guide.model.MixForkInfo;
import com.autonavi.gbl.guide.model.NaviCameraExt;
import com.autonavi.gbl.guide.model.NaviCongestionInfo;
import com.autonavi.gbl.guide.model.NaviFacility;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.guide.model.NaviIntervalCameraDynamicInfo;
import com.autonavi.gbl.guide.model.NaviOddInfo;
import com.autonavi.gbl.guide.model.NaviRoadFacility;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.model.NaviWeatherInfo;
import com.autonavi.gbl.guide.model.PathTrafficEventInfo;
import com.autonavi.gbl.guide.model.RouteTrafficEventInfo;
import com.autonavi.gbl.guide.model.SAPAInquireResponseData;
import com.autonavi.gbl.guide.model.SocolEventInfo;
import com.autonavi.gbl.guide.model.SuggestChangePathReason;
import com.autonavi.gbl.guide.model.TMCIncidentReport;
import com.autonavi.gbl.guide.model.TMCIncidentType;
import com.autonavi.gbl.guide.model.TrafficLightCountdown;
import com.autonavi.gbl.guide.model.TrafficSignal;
import com.autonavi.gbl.guide.router.NaviObserverRouter;
import com.autonavi.gbl.util.model.BinaryStream;
import java.util.ArrayList;
@IntfAuto(target = NaviObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface INaviObserver {
    default void onCarOnRouteAgain() {
    }

    default void onChangeNaviPath(long j, long j2) {
    }

    default void onCurrentRoadSpeed(int i) {
    }

    default void onDeletePath(ArrayList<Long> arrayList) {
    }

    default void onDriveReport(DriveReport driveReport) {
    }

    default void onFileOperationNotify(FileOperationEvent fileOperationEvent) {
    }

    default void onHideCrossImage(@CrossType.CrossType1 int i) {
    }

    default void onHideNaviLaneInfo() {
    }

    default void onHideTMCIncidentReport(@TMCIncidentType.TMCIncidentType1 int i) {
    }

    default void onMainNaviPath(PathInfo pathInfo) {
    }

    default void onNaviArrive(long j, @NaviType.NaviType1 int i) {
    }

    default void onNaviStop(long j, @NaviType.NaviType1 int i) {
    }

    default void onObtainAdvancedManeuverIconData(ManeuverIconResponseData maneuverIconResponseData) {
    }

    default void onObtainExitDirectionInfo(ExitDirectionResponseData exitDirectionResponseData) {
    }

    default void onObtainManeuverIconData(ManeuverIconResponseData maneuverIconResponseData) {
    }

    default void onObtainSAPAInfo(SAPAInquireResponseData sAPAInquireResponseData) {
    }

    default void onPassLast3DSegment() {
    }

    default void onQueryAppointLanesInfo(long j, ArrayList<LaneInfo> arrayList) {
    }

    default void onReroute(RouteOption routeOption) {
    }

    default void onSelectMainPathStatus(long j, @ChangeNaviPathResult.ChangeNaviPathResult1 int i) {
    }

    default void onShowCrossImage(CrossImageInfo crossImageInfo) {
    }

    default void onShowDriveEventTip(ArrayList<DriveEventTip> arrayList) {
    }

    default void onShowLockScreenTip(LockScreenTip lockScreenTip) {
    }

    default void onShowNaviCameraExt(ArrayList<NaviCameraExt> arrayList) {
    }

    default void onShowNaviCrossTMC(BinaryStream binaryStream) {
    }

    default void onShowNaviFacility(ArrayList<NaviRoadFacility> arrayList) {
    }

    default void onShowNaviLaneInfo(LaneInfo laneInfo) {
    }

    default void onShowNaviManeuver(ManeuverInfo maneuverInfo) {
    }

    default void onShowNaviWeather(ArrayList<NaviWeatherInfo> arrayList) {
    }

    default void onShowSameDirectionMixForkInfo(ArrayList<MixForkInfo> arrayList) {
    }

    default void onShowTMCIncidentReport(TMCIncidentReport tMCIncidentReport) {
    }

    default void onShowTollGateLane(TollGateInfo tollGateInfo) {
    }

    default void onSuggestChangePath(long j, long j2, SuggestChangePathReason suggestChangePathReason) {
    }

    default void onUpdateChargeStationPass(long j) {
    }

    default void onUpdateDynamicOperationDisplayEvent(DynamicOperationDisplayEvent dynamicOperationDisplayEvent) {
    }

    default void onUpdateElecVehicleETAInfo(ArrayList<ElecVehicleETAInfo> arrayList) {
    }

    default void onUpdateExitDirectionInfo(ExitDirectionInfo exitDirectionInfo) {
    }

    default void onUpdateIntervalCameraDynamicInfo(ArrayList<NaviIntervalCameraDynamicInfo> arrayList) {
    }

    default void onUpdateIsSupportSimple3D(boolean z) {
    }

    default void onUpdateNaviInfo(ArrayList<NaviInfo> arrayList) {
    }

    default void onUpdateNaviOddInfo(NaviOddInfo naviOddInfo) {
    }

    default void onUpdateNaviSocolEvent(SocolEventInfo socolEventInfo) {
    }

    default void onUpdateSAPA(ArrayList<NaviFacility> arrayList) {
    }

    default void onUpdateSocolText(String str) {
    }

    default void onUpdateTMCCongestionInfo(NaviCongestionInfo naviCongestionInfo) {
    }

    default void onUpdateTMCLightBar(ArrayList<LightBarInfo> arrayList, LightBarDetail lightBarDetail, long j, boolean z) {
    }

    default void onUpdateTREvent(ArrayList<PathTrafficEventInfo> arrayList, long j) {
    }

    default void onUpdateTRPlayView(RouteTrafficEventInfo routeTrafficEventInfo) {
    }

    default void onUpdateTrafficLightCountdown(ArrayList<TrafficLightCountdown> arrayList) {
    }

    default void onUpdateTrafficSignalInfo(ArrayList<TrafficSignal> arrayList) {
    }

    default void onUpdateViaPass(long j) {
    }
}
