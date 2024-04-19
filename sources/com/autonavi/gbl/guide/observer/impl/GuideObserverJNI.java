package com.autonavi.gbl.guide.observer.impl;

import com.autonavi.gbl.common.path.model.TollGateInfo;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import com.autonavi.gbl.guide.model.ChangeNaviPathResult;
import com.autonavi.gbl.guide.model.CrossImageInfo;
import com.autonavi.gbl.guide.model.CrossType;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.guide.model.CruiseEventInfo;
import com.autonavi.gbl.guide.model.CruiseFacilityInfo;
import com.autonavi.gbl.guide.model.CruiseInfo;
import com.autonavi.gbl.guide.model.CruiseTimeAndDist;
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
import com.autonavi.gbl.guide.model.PlayRingType;
import com.autonavi.gbl.guide.model.RouteTrafficEventInfo;
import com.autonavi.gbl.guide.model.SAPAInquireResponseData;
import com.autonavi.gbl.guide.model.SocolEventInfo;
import com.autonavi.gbl.guide.model.SoundInfo;
import com.autonavi.gbl.guide.model.SuggestChangePathReason;
import com.autonavi.gbl.guide.model.TMCIncidentReport;
import com.autonavi.gbl.guide.model.TMCIncidentType;
import com.autonavi.gbl.guide.model.TrafficSignal;
import com.autonavi.gbl.util.model.BinaryStream;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GuideObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_ICruiseObserverImpl_onUpdateCruiseFacility(ICruiseObserverImpl iCruiseObserverImpl, ArrayList<CruiseFacilityInfo> arrayList) {
        iCruiseObserverImpl.onUpdateCruiseFacility(arrayList);
    }

    public static void SwigDirector_ICruiseObserverImpl_onUpdateElecCameraInfo(ICruiseObserverImpl iCruiseObserverImpl, ArrayList<CruiseFacilityInfo> arrayList) {
        iCruiseObserverImpl.onUpdateElecCameraInfo(arrayList);
    }

    public static void SwigDirector_ICruiseObserverImpl_onUpdateCruiseInfo(ICruiseObserverImpl iCruiseObserverImpl, CruiseInfo cruiseInfo) {
        iCruiseObserverImpl.onUpdateCruiseInfo(cruiseInfo);
    }

    public static void SwigDirector_ICruiseObserverImpl_onUpdateCruiseTimeAndDist(ICruiseObserverImpl iCruiseObserverImpl, CruiseTimeAndDist cruiseTimeAndDist) {
        iCruiseObserverImpl.onUpdateCruiseTimeAndDist(cruiseTimeAndDist);
    }

    public static void SwigDirector_ICruiseObserverImpl_onUpdateCruiseCongestionInfo(ICruiseObserverImpl iCruiseObserverImpl, CruiseCongestionInfo cruiseCongestionInfo) {
        iCruiseObserverImpl.onUpdateCruiseCongestionInfo(cruiseCongestionInfo);
    }

    public static void SwigDirector_ICruiseObserverImpl_onShowCruiseLaneInfo(ICruiseObserverImpl iCruiseObserverImpl, LaneInfo laneInfo) {
        iCruiseObserverImpl.onShowCruiseLaneInfo(laneInfo);
    }

    public static void SwigDirector_ICruiseObserverImpl_onHideCruiseLaneInfo(ICruiseObserverImpl iCruiseObserverImpl) {
        iCruiseObserverImpl.onHideCruiseLaneInfo();
    }

    public static void SwigDirector_ICruiseObserverImpl_onUpdateCruiseEvent(ICruiseObserverImpl iCruiseObserverImpl, CruiseEventInfo cruiseEventInfo) {
        iCruiseObserverImpl.onUpdateCruiseEvent(cruiseEventInfo);
    }

    public static void SwigDirector_ICruiseObserverImpl_onUpdateCruiseSocolEvent(ICruiseObserverImpl iCruiseObserverImpl, SocolEventInfo socolEventInfo) {
        iCruiseObserverImpl.onUpdateCruiseSocolEvent(socolEventInfo);
    }

    public static void SwigDirector_INaviObserverImpl_onUpdateNaviInfo(INaviObserverImpl iNaviObserverImpl, ArrayList<NaviInfo> arrayList) {
        iNaviObserverImpl.onUpdateNaviInfo(arrayList);
    }

    public static void SwigDirector_INaviObserverImpl_onUpdateExitDirectionInfo(INaviObserverImpl iNaviObserverImpl, ExitDirectionInfo exitDirectionInfo) {
        iNaviObserverImpl.onUpdateExitDirectionInfo(exitDirectionInfo);
    }

    public static void SwigDirector_INaviObserverImpl_onShowCrossImage(INaviObserverImpl iNaviObserverImpl, CrossImageInfo crossImageInfo) {
        iNaviObserverImpl.onShowCrossImage(crossImageInfo);
    }

    public static void SwigDirector_INaviObserverImpl_onShowNaviCrossTMC(INaviObserverImpl iNaviObserverImpl, BinaryStream binaryStream) {
        iNaviObserverImpl.onShowNaviCrossTMC(binaryStream);
    }

    public static void SwigDirector_INaviObserverImpl_onHideCrossImage(INaviObserverImpl iNaviObserverImpl, @CrossType.CrossType1 int i) {
        iNaviObserverImpl.onHideCrossImage(i);
    }

    public static void SwigDirector_INaviObserverImpl_onPassLast3DSegment(INaviObserverImpl iNaviObserverImpl) {
        iNaviObserverImpl.onPassLast3DSegment();
    }

    public static void SwigDirector_INaviObserverImpl_onShowNaviLaneInfo(INaviObserverImpl iNaviObserverImpl, LaneInfo laneInfo) {
        iNaviObserverImpl.onShowNaviLaneInfo(laneInfo);
    }

    public static void SwigDirector_INaviObserverImpl_onHideNaviLaneInfo(INaviObserverImpl iNaviObserverImpl) {
        iNaviObserverImpl.onHideNaviLaneInfo();
    }

    public static void SwigDirector_INaviObserverImpl_onShowNaviManeuver(INaviObserverImpl iNaviObserverImpl, ManeuverInfo maneuverInfo) {
        iNaviObserverImpl.onShowNaviManeuver(maneuverInfo);
    }

    public static void SwigDirector_INaviObserverImpl_onShowNaviCamera(INaviObserverImpl iNaviObserverImpl, ArrayList<NaviCamera> arrayList) {
        iNaviObserverImpl.onShowNaviCamera(arrayList);
    }

    public static void SwigDirector_INaviObserverImpl_onShowNaviIntervalCamera(INaviObserverImpl iNaviObserverImpl, ArrayList<NaviIntervalCamera> arrayList) {
        iNaviObserverImpl.onShowNaviIntervalCamera(arrayList);
    }

    public static void SwigDirector_INaviObserverImpl_onUpdateIntervalCameraDynamicInfo(INaviObserverImpl iNaviObserverImpl, ArrayList<NaviIntervalCameraDynamicInfo> arrayList) {
        iNaviObserverImpl.onUpdateIntervalCameraDynamicInfo(arrayList);
    }

    public static void SwigDirector_INaviObserverImpl_onUpdateSAPA(INaviObserverImpl iNaviObserverImpl, ArrayList<NaviFacility> arrayList) {
        iNaviObserverImpl.onUpdateSAPA(arrayList);
    }

    public static void SwigDirector_INaviObserverImpl_onNaviArrive(INaviObserverImpl iNaviObserverImpl, long j, @NaviType.NaviType1 int i) {
        iNaviObserverImpl.onNaviArrive(j, i);
    }

    public static void SwigDirector_INaviObserverImpl_onNaviStop(INaviObserverImpl iNaviObserverImpl, long j, @NaviType.NaviType1 int i) {
        iNaviObserverImpl.onNaviStop(j, i);
    }

    public static void SwigDirector_INaviObserverImpl_onUpdateViaPass(INaviObserverImpl iNaviObserverImpl, long j) {
        iNaviObserverImpl.onUpdateViaPass(j);
    }

    public static void SwigDirector_INaviObserverImpl_onShowLockScreenTip(INaviObserverImpl iNaviObserverImpl, LockScreenTip lockScreenTip) {
        iNaviObserverImpl.onShowLockScreenTip(lockScreenTip);
    }

    public static void SwigDirector_INaviObserverImpl_onDriveReport(INaviObserverImpl iNaviObserverImpl, String str, NaviStatisticsInfo naviStatisticsInfo) {
        iNaviObserverImpl.onDriveReport(str, naviStatisticsInfo);
    }

    public static void SwigDirector_INaviObserverImpl_onShowDriveEventTip(INaviObserverImpl iNaviObserverImpl, ArrayList<DriveEventTip> arrayList) {
        iNaviObserverImpl.onShowDriveEventTip(arrayList);
    }

    public static void SwigDirector_INaviObserverImpl_onReroute(INaviObserverImpl iNaviObserverImpl, IRouteOptionImpl iRouteOptionImpl) {
        iNaviObserverImpl.onReroute(iRouteOptionImpl);
    }

    public static void SwigDirector_INaviObserverImpl_onCarOnRouteAgain(INaviObserverImpl iNaviObserverImpl) {
        iNaviObserverImpl.onCarOnRouteAgain();
    }

    public static void SwigDirector_INaviObserverImpl_onUpdateTMCLightBar(INaviObserverImpl iNaviObserverImpl, ArrayList<LightBarInfo> arrayList, long j, boolean z) {
        iNaviObserverImpl.onUpdateTMCLightBar(arrayList, j, z);
    }

    public static void SwigDirector_INaviObserverImpl_onUpdateTMCCongestionInfo(INaviObserverImpl iNaviObserverImpl, NaviCongestionInfo naviCongestionInfo) {
        iNaviObserverImpl.onUpdateTMCCongestionInfo(naviCongestionInfo);
    }

    public static void SwigDirector_INaviObserverImpl_onUpdateTREvent(INaviObserverImpl iNaviObserverImpl, ArrayList<PathTrafficEventInfo> arrayList, long j) {
        iNaviObserverImpl.onUpdateTREvent(arrayList, j);
    }

    public static void SwigDirector_INaviObserverImpl_onUpdateTRPlayView(INaviObserverImpl iNaviObserverImpl, RouteTrafficEventInfo routeTrafficEventInfo) {
        iNaviObserverImpl.onUpdateTRPlayView(routeTrafficEventInfo);
    }

    public static void SwigDirector_INaviObserverImpl_onShowTMCIncidentReport(INaviObserverImpl iNaviObserverImpl, TMCIncidentReport tMCIncidentReport) {
        iNaviObserverImpl.onShowTMCIncidentReport(tMCIncidentReport);
    }

    public static void SwigDirector_INaviObserverImpl_onHideTMCIncidentReport(INaviObserverImpl iNaviObserverImpl, @TMCIncidentType.TMCIncidentType1 int i) {
        iNaviObserverImpl.onHideTMCIncidentReport(i);
    }

    public static void SwigDirector_INaviObserverImpl_onUpdateSocolText(INaviObserverImpl iNaviObserverImpl, String str) {
        iNaviObserverImpl.onUpdateSocolText(str);
    }

    public static void SwigDirector_INaviObserverImpl_onUpdateIsSupportSimple3D(INaviObserverImpl iNaviObserverImpl, boolean z) {
        iNaviObserverImpl.onUpdateIsSupportSimple3D(z);
    }

    public static void SwigDirector_INaviObserverImpl_onDeletePath(INaviObserverImpl iNaviObserverImpl, ArrayList<Long> arrayList) {
        iNaviObserverImpl.onDeletePath(arrayList);
    }

    public static void SwigDirector_INaviObserverImpl_onChangeNaviPath(INaviObserverImpl iNaviObserverImpl, long j, long j2) {
        iNaviObserverImpl.onChangeNaviPath(j, j2);
    }

    public static void SwigDirector_INaviObserverImpl_onMainNaviPath(INaviObserverImpl iNaviObserverImpl, PathInfoImpl pathInfoImpl) {
        iNaviObserverImpl.onMainNaviPath(pathInfoImpl);
    }

    public static void SwigDirector_INaviObserverImpl_onSelectMainPathStatus(INaviObserverImpl iNaviObserverImpl, long j, @ChangeNaviPathResult.ChangeNaviPathResult1 int i) {
        iNaviObserverImpl.onSelectMainPathStatus(j, i);
    }

    public static void SwigDirector_INaviObserverImpl_onSuggestChangePath(INaviObserverImpl iNaviObserverImpl, long j, long j2, SuggestChangePathReason suggestChangePathReason) {
        iNaviObserverImpl.onSuggestChangePath(j, j2, suggestChangePathReason);
    }

    public static void SwigDirector_INaviObserverImpl_onObtainManeuverIconData(INaviObserverImpl iNaviObserverImpl, ManeuverIconResponseData maneuverIconResponseData) {
        iNaviObserverImpl.onObtainManeuverIconData(maneuverIconResponseData);
    }

    public static void SwigDirector_INaviObserverImpl_onObtainAdvancedManeuverIconData(INaviObserverImpl iNaviObserverImpl, ManeuverIconResponseData maneuverIconResponseData) {
        iNaviObserverImpl.onObtainAdvancedManeuverIconData(maneuverIconResponseData);
    }

    public static void SwigDirector_INaviObserverImpl_onObtainExitDirectionInfo(INaviObserverImpl iNaviObserverImpl, ExitDirectionResponseData exitDirectionResponseData) {
        iNaviObserverImpl.onObtainExitDirectionInfo(exitDirectionResponseData);
    }

    public static void SwigDirector_INaviObserverImpl_onObtainSAPAInfo(INaviObserverImpl iNaviObserverImpl, SAPAInquireResponseData sAPAInquireResponseData) {
        iNaviObserverImpl.onObtainSAPAInfo(sAPAInquireResponseData);
    }

    public static void SwigDirector_INaviObserverImpl_onShowSameDirectionMixForkInfo(INaviObserverImpl iNaviObserverImpl, ArrayList<MixForkInfo> arrayList) {
        iNaviObserverImpl.onShowSameDirectionMixForkInfo(arrayList);
    }

    public static void SwigDirector_INaviObserverImpl_onShowNaviWeather(INaviObserverImpl iNaviObserverImpl, ArrayList<NaviWeatherInfo> arrayList) {
        iNaviObserverImpl.onShowNaviWeather(arrayList);
    }

    public static void SwigDirector_INaviObserverImpl_onShowNaviFacility(INaviObserverImpl iNaviObserverImpl, ArrayList<NaviRoadFacility> arrayList) {
        iNaviObserverImpl.onShowNaviFacility(arrayList);
    }

    public static void SwigDirector_INaviObserverImpl_onShowTollGateLane(INaviObserverImpl iNaviObserverImpl, TollGateInfo tollGateInfo) {
        iNaviObserverImpl.onShowTollGateLane(tollGateInfo);
    }

    public static void SwigDirector_INaviObserverImpl_onUpdateTrafficSignalInfo(INaviObserverImpl iNaviObserverImpl, ArrayList<TrafficSignal> arrayList) {
        iNaviObserverImpl.onUpdateTrafficSignalInfo(arrayList);
    }

    public static void SwigDirector_INaviObserverImpl_onUpdateElecVehicleETAInfo(INaviObserverImpl iNaviObserverImpl, ArrayList<ElecVehicleETAInfo> arrayList) {
        iNaviObserverImpl.onUpdateElecVehicleETAInfo(arrayList);
    }

    public static void SwigDirector_INaviObserverImpl_onCurrentRoadSpeed(INaviObserverImpl iNaviObserverImpl, int i) {
        iNaviObserverImpl.onCurrentRoadSpeed(i);
    }

    public static void SwigDirector_INaviObserverImpl_onUpdateNaviSocolEvent(INaviObserverImpl iNaviObserverImpl, SocolEventInfo socolEventInfo) {
        iNaviObserverImpl.onUpdateNaviSocolEvent(socolEventInfo);
    }

    public static void SwigDirector_INaviObserverImpl_onUpdateChargeStationPass(INaviObserverImpl iNaviObserverImpl, long j) {
        iNaviObserverImpl.onUpdateChargeStationPass(j);
    }

    public static void SwigDirector_INaviObserverImpl_onUpdateDynamicOperationDisplayEvent(INaviObserverImpl iNaviObserverImpl, DynamicOperationDisplayEvent dynamicOperationDisplayEvent) {
        iNaviObserverImpl.onUpdateDynamicOperationDisplayEvent(dynamicOperationDisplayEvent);
    }

    public static void SwigDirector_INaviObserverImpl_onQueryAppointLanesInfo(INaviObserverImpl iNaviObserverImpl, long j, ArrayList<LaneInfo> arrayList) {
        iNaviObserverImpl.onQueryAppointLanesInfo(j, arrayList);
    }

    public static void SwigDirector_INaviObserverImpl_onFileOperationNotify(INaviObserverImpl iNaviObserverImpl, FileOperationEvent fileOperationEvent) {
        iNaviObserverImpl.onFileOperationNotify(fileOperationEvent);
    }

    public static void SwigDirector_ISoundPlayObserverImpl_onPlayTTS(ISoundPlayObserverImpl iSoundPlayObserverImpl, SoundInfo soundInfo) {
        iSoundPlayObserverImpl.onPlayTTS(soundInfo);
    }

    public static void SwigDirector_ISoundPlayObserverImpl_onPlayRing(ISoundPlayObserverImpl iSoundPlayObserverImpl, @PlayRingType.PlayRingType1 int i) {
        iSoundPlayObserverImpl.onPlayRing(i);
    }

    public static boolean SwigDirector_ISoundPlayObserverImpl_isPlaying(ISoundPlayObserverImpl iSoundPlayObserverImpl) {
        return iSoundPlayObserverImpl.isPlaying();
    }
}
