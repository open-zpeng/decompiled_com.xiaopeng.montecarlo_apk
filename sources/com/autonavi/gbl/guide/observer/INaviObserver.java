package com.autonavi.gbl.guide.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.TollGateInfo;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.guide.model.ChangeNaviPathResult;
import com.autonavi.gbl.guide.model.CrossImageInfo;
import com.autonavi.gbl.guide.model.CrossType;
import com.autonavi.gbl.guide.model.DriveEventTip;
import com.autonavi.gbl.guide.model.DynamicOperationDisplayEvent;
import com.autonavi.gbl.guide.model.ElecVehicleETAInfo;
import com.autonavi.gbl.guide.model.ExitDirectionInfo;
import com.autonavi.gbl.guide.model.ExitDirectionResponseData;
import com.autonavi.gbl.guide.model.FileOperationEvent;
import com.autonavi.gbl.guide.model.LaneInfo;
import com.autonavi.gbl.guide.model.LightBarInfo;
import com.autonavi.gbl.guide.model.LockScreenTip;
import com.autonavi.gbl.guide.model.ManeuverIconResponseData;
import com.autonavi.gbl.guide.model.ManeuverInfo;
import com.autonavi.gbl.guide.model.MixForkInfo;
import com.autonavi.gbl.guide.model.NaviCamera;
import com.autonavi.gbl.guide.model.NaviCongestionInfo;
import com.autonavi.gbl.guide.model.NaviFacility;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.guide.model.NaviIntervalCamera;
import com.autonavi.gbl.guide.model.NaviIntervalCameraDynamicInfo;
import com.autonavi.gbl.guide.model.NaviRoadFacility;
import com.autonavi.gbl.guide.model.NaviStatisticsInfo;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.model.NaviWeatherInfo;
import com.autonavi.gbl.guide.model.PathTrafficEventInfo;
import com.autonavi.gbl.guide.model.RouteTrafficEventInfo;
import com.autonavi.gbl.guide.model.SAPAInquireResponseData;
import com.autonavi.gbl.guide.model.SocolEventInfo;
import com.autonavi.gbl.guide.model.SuggestChangePathReason;
import com.autonavi.gbl.guide.model.TMCIncidentReport;
import com.autonavi.gbl.guide.model.TMCIncidentType;
import com.autonavi.gbl.guide.model.TrafficSignal;
import com.autonavi.gbl.guide.router.NaviObserverRouter;
import com.autonavi.gbl.util.model.BinaryStream;
import java.util.ArrayList;
@IntfAuto(target = NaviObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface INaviObserver {
    void onCarOnRouteAgain();

    void onChangeNaviPath(long j, long j2);

    void onCurrentRoadSpeed(int i);

    void onDeletePath(ArrayList<Long> arrayList);

    void onDriveReport(String str, NaviStatisticsInfo naviStatisticsInfo);

    void onFileOperationNotify(FileOperationEvent fileOperationEvent);

    void onHideCrossImage(@CrossType.CrossType1 int i);

    void onHideNaviLaneInfo();

    void onHideTMCIncidentReport(@TMCIncidentType.TMCIncidentType1 int i);

    void onMainNaviPath(PathInfo pathInfo);

    void onNaviArrive(long j, @NaviType.NaviType1 int i);

    void onNaviStop(long j, @NaviType.NaviType1 int i);

    void onObtainAdvancedManeuverIconData(ManeuverIconResponseData maneuverIconResponseData);

    void onObtainExitDirectionInfo(ExitDirectionResponseData exitDirectionResponseData);

    void onObtainManeuverIconData(ManeuverIconResponseData maneuverIconResponseData);

    void onObtainSAPAInfo(SAPAInquireResponseData sAPAInquireResponseData);

    void onPassLast3DSegment();

    void onQueryAppointLanesInfo(long j, ArrayList<LaneInfo> arrayList);

    void onReroute(RouteOption routeOption);

    void onSelectMainPathStatus(long j, @ChangeNaviPathResult.ChangeNaviPathResult1 int i);

    void onShowCrossImage(CrossImageInfo crossImageInfo);

    void onShowDriveEventTip(ArrayList<DriveEventTip> arrayList);

    void onShowLockScreenTip(LockScreenTip lockScreenTip);

    void onShowNaviCamera(ArrayList<NaviCamera> arrayList);

    void onShowNaviCrossTMC(BinaryStream binaryStream);

    void onShowNaviFacility(ArrayList<NaviRoadFacility> arrayList);

    void onShowNaviIntervalCamera(ArrayList<NaviIntervalCamera> arrayList);

    void onShowNaviLaneInfo(LaneInfo laneInfo);

    void onShowNaviManeuver(ManeuverInfo maneuverInfo);

    void onShowNaviWeather(ArrayList<NaviWeatherInfo> arrayList);

    void onShowSameDirectionMixForkInfo(ArrayList<MixForkInfo> arrayList);

    void onShowTMCIncidentReport(TMCIncidentReport tMCIncidentReport);

    void onShowTollGateLane(TollGateInfo tollGateInfo);

    void onSuggestChangePath(long j, long j2, SuggestChangePathReason suggestChangePathReason);

    void onUpdateChargeStationPass(long j);

    void onUpdateDynamicOperationDisplayEvent(DynamicOperationDisplayEvent dynamicOperationDisplayEvent);

    void onUpdateElecVehicleETAInfo(ArrayList<ElecVehicleETAInfo> arrayList);

    void onUpdateExitDirectionInfo(ExitDirectionInfo exitDirectionInfo);

    void onUpdateIntervalCameraDynamicInfo(ArrayList<NaviIntervalCameraDynamicInfo> arrayList);

    void onUpdateIsSupportSimple3D(boolean z);

    void onUpdateNaviInfo(ArrayList<NaviInfo> arrayList);

    void onUpdateNaviSocolEvent(SocolEventInfo socolEventInfo);

    void onUpdateSAPA(ArrayList<NaviFacility> arrayList);

    void onUpdateSocolText(String str);

    void onUpdateTMCCongestionInfo(NaviCongestionInfo naviCongestionInfo);

    void onUpdateTMCLightBar(ArrayList<LightBarInfo> arrayList, long j, boolean z);

    void onUpdateTREvent(ArrayList<PathTrafficEventInfo> arrayList, long j);

    void onUpdateTRPlayView(RouteTrafficEventInfo routeTrafficEventInfo);

    void onUpdateTrafficSignalInfo(ArrayList<TrafficSignal> arrayList);

    void onUpdateViaPass(long j);
}
