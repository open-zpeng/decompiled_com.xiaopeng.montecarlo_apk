package com.autonavi.gbl.guide.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.path.model.TollGateInfo;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
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
import com.autonavi.gbl.guide.observer.INaviObserver;
import com.autonavi.gbl.util.model.BinaryStream;
import java.util.ArrayList;
@IntfAuto(target = INaviObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class INaviObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(INaviObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void INaviObserverImpl_change_ownership(INaviObserverImpl iNaviObserverImpl, long j, boolean z);

    private static native void INaviObserverImpl_director_connect(INaviObserverImpl iNaviObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onCarOnRouteAgainNative(long j, INaviObserverImpl iNaviObserverImpl);

    private static native void onChangeNaviPathNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, long j3);

    private static native void onCurrentRoadSpeedNative(long j, INaviObserverImpl iNaviObserverImpl, int i);

    private static native void onDeletePathNative(long j, INaviObserverImpl iNaviObserverImpl, ArrayList<Long> arrayList);

    private static native void onDriveReportNative(long j, INaviObserverImpl iNaviObserverImpl, String str, long j2, NaviStatisticsInfo naviStatisticsInfo);

    private static native void onFileOperationNotifyNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, FileOperationEvent fileOperationEvent);

    private static native void onHideCrossImageNative(long j, INaviObserverImpl iNaviObserverImpl, int i);

    private static native void onHideNaviLaneInfoNative(long j, INaviObserverImpl iNaviObserverImpl);

    private static native void onHideTMCIncidentReportNative(long j, INaviObserverImpl iNaviObserverImpl, int i);

    private static native void onMainNaviPathNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, PathInfoImpl pathInfoImpl);

    private static native void onNaviArriveNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, int i);

    private static native void onNaviStopNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, int i);

    private static native void onObtainAdvancedManeuverIconDataNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, ManeuverIconResponseData maneuverIconResponseData);

    private static native void onObtainExitDirectionInfoNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, ExitDirectionResponseData exitDirectionResponseData);

    private static native void onObtainManeuverIconDataNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, ManeuverIconResponseData maneuverIconResponseData);

    private static native void onObtainSAPAInfoNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, SAPAInquireResponseData sAPAInquireResponseData);

    private static native void onPassLast3DSegmentNative(long j, INaviObserverImpl iNaviObserverImpl);

    private static native void onQueryAppointLanesInfoNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, ArrayList<LaneInfo> arrayList);

    private static native void onRerouteNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, IRouteOptionImpl iRouteOptionImpl);

    private static native void onSelectMainPathStatusNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, int i);

    private static native void onShowCrossImageNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, CrossImageInfo crossImageInfo);

    private static native void onShowDriveEventTipNative(long j, INaviObserverImpl iNaviObserverImpl, ArrayList<DriveEventTip> arrayList);

    private static native void onShowLockScreenTipNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, LockScreenTip lockScreenTip);

    private static native void onShowNaviCameraNative(long j, INaviObserverImpl iNaviObserverImpl, ArrayList<NaviCamera> arrayList);

    private static native void onShowNaviCrossTMCNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, BinaryStream binaryStream);

    private static native void onShowNaviFacilityNative(long j, INaviObserverImpl iNaviObserverImpl, ArrayList<NaviRoadFacility> arrayList);

    private static native void onShowNaviIntervalCameraNative(long j, INaviObserverImpl iNaviObserverImpl, ArrayList<NaviIntervalCamera> arrayList);

    private static native void onShowNaviLaneInfoNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, LaneInfo laneInfo);

    private static native void onShowNaviManeuverNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, ManeuverInfo maneuverInfo);

    private static native void onShowNaviWeatherNative(long j, INaviObserverImpl iNaviObserverImpl, ArrayList<NaviWeatherInfo> arrayList);

    private static native void onShowSameDirectionMixForkInfoNative(long j, INaviObserverImpl iNaviObserverImpl, ArrayList<MixForkInfo> arrayList);

    private static native void onShowTMCIncidentReportNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, TMCIncidentReport tMCIncidentReport);

    private static native void onShowTollGateLaneNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, TollGateInfo tollGateInfo);

    private static native void onSuggestChangePathNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, long j3, long j4, SuggestChangePathReason suggestChangePathReason);

    private static native void onUpdateChargeStationPassNative(long j, INaviObserverImpl iNaviObserverImpl, long j2);

    private static native void onUpdateDynamicOperationDisplayEventNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, DynamicOperationDisplayEvent dynamicOperationDisplayEvent);

    private static native void onUpdateElecVehicleETAInfoNative(long j, INaviObserverImpl iNaviObserverImpl, ArrayList<ElecVehicleETAInfo> arrayList);

    private static native void onUpdateExitDirectionInfoNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, ExitDirectionInfo exitDirectionInfo);

    private static native void onUpdateIntervalCameraDynamicInfoNative(long j, INaviObserverImpl iNaviObserverImpl, ArrayList<NaviIntervalCameraDynamicInfo> arrayList);

    private static native void onUpdateIsSupportSimple3DNative(long j, INaviObserverImpl iNaviObserverImpl, boolean z);

    private static native void onUpdateNaviInfoNative(long j, INaviObserverImpl iNaviObserverImpl, ArrayList<NaviInfo> arrayList);

    private static native void onUpdateNaviSocolEventNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, SocolEventInfo socolEventInfo);

    private static native void onUpdateSAPANative(long j, INaviObserverImpl iNaviObserverImpl, ArrayList<NaviFacility> arrayList);

    private static native void onUpdateSocolTextNative(long j, INaviObserverImpl iNaviObserverImpl, String str);

    private static native void onUpdateTMCCongestionInfoNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, NaviCongestionInfo naviCongestionInfo);

    private static native void onUpdateTMCLightBarNative(long j, INaviObserverImpl iNaviObserverImpl, ArrayList<LightBarInfo> arrayList, long j2, boolean z);

    private static native void onUpdateTREventNative(long j, INaviObserverImpl iNaviObserverImpl, ArrayList<PathTrafficEventInfo> arrayList, long j2);

    private static native void onUpdateTRPlayViewNative(long j, INaviObserverImpl iNaviObserverImpl, long j2, RouteTrafficEventInfo routeTrafficEventInfo);

    private static native void onUpdateTrafficSignalInfoNative(long j, INaviObserverImpl iNaviObserverImpl, ArrayList<TrafficSignal> arrayList);

    private static native void onUpdateViaPassNative(long j, INaviObserverImpl iNaviObserverImpl, long j2);

    public INaviObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof INaviObserverImpl) && getUID(this) == getUID((INaviObserverImpl) obj);
    }

    private static long getUID(INaviObserverImpl iNaviObserverImpl) {
        long cPtr = getCPtr(iNaviObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(INaviObserverImpl iNaviObserverImpl) {
        if (iNaviObserverImpl == null) {
            return 0L;
        }
        return iNaviObserverImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        INaviObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        INaviObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onUpdateNaviInfo(ArrayList<NaviInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateNaviInfoNative(j, this, arrayList);
    }

    public void onUpdateExitDirectionInfo(ExitDirectionInfo exitDirectionInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateExitDirectionInfoNative(j, this, 0L, exitDirectionInfo);
    }

    public void onShowCrossImage(CrossImageInfo crossImageInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onShowCrossImageNative(j, this, 0L, crossImageInfo);
    }

    public void onShowNaviCrossTMC(BinaryStream binaryStream) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onShowNaviCrossTMCNative(j, this, 0L, binaryStream);
    }

    public void onHideCrossImage(@CrossType.CrossType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onHideCrossImageNative(j, this, i);
    }

    public void onPassLast3DSegment() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onPassLast3DSegmentNative(j, this);
    }

    public void onShowNaviLaneInfo(LaneInfo laneInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onShowNaviLaneInfoNative(j, this, 0L, laneInfo);
    }

    public void onHideNaviLaneInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onHideNaviLaneInfoNative(j, this);
    }

    public void onShowNaviManeuver(ManeuverInfo maneuverInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onShowNaviManeuverNative(j, this, 0L, maneuverInfo);
    }

    public void onShowNaviCamera(ArrayList<NaviCamera> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onShowNaviCameraNative(j, this, arrayList);
    }

    public void onShowNaviIntervalCamera(ArrayList<NaviIntervalCamera> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onShowNaviIntervalCameraNative(j, this, arrayList);
    }

    public void onUpdateIntervalCameraDynamicInfo(ArrayList<NaviIntervalCameraDynamicInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateIntervalCameraDynamicInfoNative(j, this, arrayList);
    }

    public void onUpdateSAPA(ArrayList<NaviFacility> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateSAPANative(j, this, arrayList);
    }

    public void onNaviArrive(long j, @NaviType.NaviType1 int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onNaviArriveNative(j2, this, j, i);
    }

    public void onNaviStop(long j, @NaviType.NaviType1 int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onNaviStopNative(j2, this, j, i);
    }

    public void onUpdateViaPass(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onUpdateViaPassNative(j2, this, j);
    }

    public void onShowLockScreenTip(LockScreenTip lockScreenTip) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onShowLockScreenTipNative(j, this, 0L, lockScreenTip);
    }

    public void onDriveReport(String str, NaviStatisticsInfo naviStatisticsInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onDriveReportNative(j, this, str, 0L, naviStatisticsInfo);
    }

    public void onShowDriveEventTip(ArrayList<DriveEventTip> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onShowDriveEventTipNative(j, this, arrayList);
    }

    public void onReroute(IRouteOptionImpl iRouteOptionImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRerouteNative(j, this, IRouteOptionImpl.getCPtr(iRouteOptionImpl), iRouteOptionImpl);
    }

    public void onCarOnRouteAgain() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onCarOnRouteAgainNative(j, this);
    }

    public void onUpdateTMCLightBar(ArrayList<LightBarInfo> arrayList, long j, boolean z) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onUpdateTMCLightBarNative(j2, this, arrayList, j, z);
    }

    public void onUpdateTMCCongestionInfo(NaviCongestionInfo naviCongestionInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateTMCCongestionInfoNative(j, this, 0L, naviCongestionInfo);
    }

    public void onUpdateTREvent(ArrayList<PathTrafficEventInfo> arrayList, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onUpdateTREventNative(j2, this, arrayList, j);
    }

    public void onUpdateTRPlayView(RouteTrafficEventInfo routeTrafficEventInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateTRPlayViewNative(j, this, 0L, routeTrafficEventInfo);
    }

    public void onShowTMCIncidentReport(TMCIncidentReport tMCIncidentReport) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onShowTMCIncidentReportNative(j, this, 0L, tMCIncidentReport);
    }

    public void onHideTMCIncidentReport(@TMCIncidentType.TMCIncidentType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onHideTMCIncidentReportNative(j, this, i);
    }

    public void onUpdateSocolText(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateSocolTextNative(j, this, str);
    }

    public void onUpdateIsSupportSimple3D(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateIsSupportSimple3DNative(j, this, z);
    }

    public void onDeletePath(ArrayList<Long> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onDeletePathNative(j, this, arrayList);
    }

    public void onChangeNaviPath(long j, long j2) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        onChangeNaviPathNative(j3, this, j, j2);
    }

    public void onMainNaviPath(PathInfoImpl pathInfoImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onMainNaviPathNative(j, this, PathInfoImpl.getCPtr(pathInfoImpl), pathInfoImpl);
    }

    public void onSelectMainPathStatus(long j, @ChangeNaviPathResult.ChangeNaviPathResult1 int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onSelectMainPathStatusNative(j2, this, j, i);
    }

    public void onSuggestChangePath(long j, long j2, SuggestChangePathReason suggestChangePathReason) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        onSuggestChangePathNative(j3, this, j, j2, 0L, suggestChangePathReason);
    }

    public void onObtainManeuverIconData(ManeuverIconResponseData maneuverIconResponseData) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onObtainManeuverIconDataNative(j, this, 0L, maneuverIconResponseData);
    }

    public void onObtainAdvancedManeuverIconData(ManeuverIconResponseData maneuverIconResponseData) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onObtainAdvancedManeuverIconDataNative(j, this, 0L, maneuverIconResponseData);
    }

    public void onObtainExitDirectionInfo(ExitDirectionResponseData exitDirectionResponseData) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onObtainExitDirectionInfoNative(j, this, 0L, exitDirectionResponseData);
    }

    public void onObtainSAPAInfo(SAPAInquireResponseData sAPAInquireResponseData) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onObtainSAPAInfoNative(j, this, 0L, sAPAInquireResponseData);
    }

    public void onShowSameDirectionMixForkInfo(ArrayList<MixForkInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onShowSameDirectionMixForkInfoNative(j, this, arrayList);
    }

    public void onShowNaviWeather(ArrayList<NaviWeatherInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onShowNaviWeatherNative(j, this, arrayList);
    }

    public void onShowNaviFacility(ArrayList<NaviRoadFacility> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onShowNaviFacilityNative(j, this, arrayList);
    }

    public void onShowTollGateLane(TollGateInfo tollGateInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onShowTollGateLaneNative(j, this, 0L, tollGateInfo);
    }

    public void onUpdateTrafficSignalInfo(ArrayList<TrafficSignal> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateTrafficSignalInfoNative(j, this, arrayList);
    }

    public void onUpdateElecVehicleETAInfo(ArrayList<ElecVehicleETAInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateElecVehicleETAInfoNative(j, this, arrayList);
    }

    public void onCurrentRoadSpeed(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onCurrentRoadSpeedNative(j, this, i);
    }

    public void onUpdateNaviSocolEvent(SocolEventInfo socolEventInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateNaviSocolEventNative(j, this, 0L, socolEventInfo);
    }

    public void onUpdateChargeStationPass(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onUpdateChargeStationPassNative(j2, this, j);
    }

    public void onUpdateDynamicOperationDisplayEvent(DynamicOperationDisplayEvent dynamicOperationDisplayEvent) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateDynamicOperationDisplayEventNative(j, this, 0L, dynamicOperationDisplayEvent);
    }

    public void onQueryAppointLanesInfo(long j, ArrayList<LaneInfo> arrayList) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onQueryAppointLanesInfoNative(j2, this, j, arrayList);
    }

    public void onFileOperationNotify(FileOperationEvent fileOperationEvent) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onFileOperationNotifyNative(j, this, 0L, fileOperationEvent);
    }

    public INaviObserverImpl() {
        this(createNativeObj(), true);
        GuideObserverJNI.swig_jni_init();
        INaviObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
