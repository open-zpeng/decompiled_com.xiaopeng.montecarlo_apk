package com.autonavi.gbl.guide.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.model.TollGateInfo;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.RouteOption;
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
import com.autonavi.gbl.guide.model.impl.NaviCongestionInfoImpl;
import com.autonavi.gbl.guide.observer.INaviObserver;
import com.autonavi.gbl.guide.observer.impl.INaviObserverImpl;
import com.autonavi.gbl.util.model.BinaryStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = INaviObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class NaviObserverRouter extends INaviObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(NaviObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(NaviObserverRouter.class);
    private TypeHelper mHelper;
    private INaviObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, INaviObserver iNaviObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(INaviObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iNaviObserver;
    }

    protected NaviObserverRouter(String str, INaviObserver iNaviObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iNaviObserver);
    }

    protected NaviObserverRouter(String str, INaviObserver iNaviObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iNaviObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.router.NaviObserverRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.router.NaviObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onUpdateNaviInfo(ArrayList<NaviInfo> arrayList) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onUpdateNaviInfo(arrayList);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onUpdateExitDirectionInfo(ExitDirectionInfo exitDirectionInfo) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onUpdateExitDirectionInfo(exitDirectionInfo);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onShowCrossImage(CrossImageInfo crossImageInfo) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onShowCrossImage(crossImageInfo);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onShowNaviCrossTMC(BinaryStream binaryStream) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onShowNaviCrossTMC(binaryStream);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onHideCrossImage(@CrossType.CrossType1 int i) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onHideCrossImage(i);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onPassLast3DSegment() {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onPassLast3DSegment();
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onShowNaviLaneInfo(LaneInfo laneInfo) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onShowNaviLaneInfo(laneInfo);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onHideNaviLaneInfo() {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onHideNaviLaneInfo();
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onShowNaviManeuver(ManeuverInfo maneuverInfo) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onShowNaviManeuver(maneuverInfo);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onShowNaviCamera(ArrayList<NaviCamera> arrayList) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onShowNaviCamera(arrayList);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onShowNaviIntervalCamera(ArrayList<NaviIntervalCamera> arrayList) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onShowNaviIntervalCamera(arrayList);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onUpdateIntervalCameraDynamicInfo(ArrayList<NaviIntervalCameraDynamicInfo> arrayList) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onUpdateIntervalCameraDynamicInfo(arrayList);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onUpdateSAPA(ArrayList<NaviFacility> arrayList) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onUpdateSAPA(arrayList);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onNaviArrive(long j, @NaviType.NaviType1 int i) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onNaviArrive(j, i);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onNaviStop(long j, @NaviType.NaviType1 int i) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onNaviStop(j, i);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onUpdateViaPass(long j) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onUpdateViaPass(j);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onShowLockScreenTip(LockScreenTip lockScreenTip) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onShowLockScreenTip(lockScreenTip);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onDriveReport(String str, NaviStatisticsInfo naviStatisticsInfo) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onDriveReport(str, naviStatisticsInfo);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onShowDriveEventTip(ArrayList<DriveEventTip> arrayList) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onShowDriveEventTip(arrayList);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onReroute(IRouteOptionImpl iRouteOptionImpl) {
        try {
            Method method = NaviObserverRouter.class.getMethod("onReroute", IRouteOptionImpl.class);
            if (iRouteOptionImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (RouteOption) typeHelper.transfer(method, 0, iRouteOptionImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $rerouteOption == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.router.NaviObserverRouter.3
                    }));
                }
            }
            INaviObserver iNaviObserver = this.mObserver;
            if (iNaviObserver != null) {
                iNaviObserver.onReroute(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onCarOnRouteAgain() {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onCarOnRouteAgain();
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onUpdateTMCLightBar(ArrayList<LightBarInfo> arrayList, long j, boolean z) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onUpdateTMCLightBar(arrayList, j, z);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onUpdateTMCCongestionInfo(NaviCongestionInfoImpl naviCongestionInfoImpl) {
        try {
            Method method = NaviObserverRouter.class.getMethod("onUpdateTMCCongestionInfo", NaviCongestionInfoImpl.class);
            if (naviCongestionInfoImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (NaviCongestionInfo) typeHelper.transfer(method, 0, naviCongestionInfoImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $info == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.router.NaviObserverRouter.4
                    }));
                }
            }
            INaviObserver iNaviObserver = this.mObserver;
            if (iNaviObserver != null) {
                iNaviObserver.onUpdateTMCCongestionInfo(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onUpdateTREvent(ArrayList<PathTrafficEventInfo> arrayList, long j) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onUpdateTREvent(arrayList, j);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onUpdateTRPlayView(RouteTrafficEventInfo routeTrafficEventInfo) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onUpdateTRPlayView(routeTrafficEventInfo);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onShowTMCIncidentReport(TMCIncidentReport tMCIncidentReport) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onShowTMCIncidentReport(tMCIncidentReport);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onHideTMCIncidentReport(@TMCIncidentType.TMCIncidentType1 int i) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onHideTMCIncidentReport(i);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onUpdateSocolText(String str) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onUpdateSocolText(str);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onUpdateIsSupportSimple3D(boolean z) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onUpdateIsSupportSimple3D(z);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onDeletePath(ArrayList<Long> arrayList) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onDeletePath(arrayList);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onChangeNaviPath(long j, long j2) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onChangeNaviPath(j, j2);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onMainNaviPath(PathInfoImpl pathInfoImpl) {
        try {
            Method method = NaviObserverRouter.class.getMethod("onMainNaviPath", PathInfoImpl.class);
            if (pathInfoImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (PathInfo) typeHelper.transfer(method, 0, pathInfoImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pathInfo == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.router.NaviObserverRouter.5
                    }));
                }
            }
            INaviObserver iNaviObserver = this.mObserver;
            if (iNaviObserver != null) {
                iNaviObserver.onMainNaviPath(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onSelectMainPathStatus(long j, @ChangeNaviPathResult.ChangeNaviPathResult1 int i) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onSelectMainPathStatus(j, i);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onSuggestChangePath(long j, long j2, SuggestChangePathReason suggestChangePathReason) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onSuggestChangePath(j, j2, suggestChangePathReason);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onObtainManeuverIconData(ManeuverIconResponseData maneuverIconResponseData) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onObtainManeuverIconData(maneuverIconResponseData);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onObtainExitDirectionInfo(ExitDirectionResponseData exitDirectionResponseData) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onObtainExitDirectionInfo(exitDirectionResponseData);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onObtainSAPAInfo(SAPAInquireResponseData sAPAInquireResponseData) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onObtainSAPAInfo(sAPAInquireResponseData);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onShowSameDirectionMixForkInfo(ArrayList<MixForkInfo> arrayList) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onShowSameDirectionMixForkInfo(arrayList);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onShowNaviWeather(ArrayList<NaviWeatherInfo> arrayList) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onShowNaviWeather(arrayList);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onShowNaviFacility(ArrayList<NaviRoadFacility> arrayList) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onShowNaviFacility(arrayList);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onShowTollGateLane(TollGateInfo tollGateInfo) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onShowTollGateLane(tollGateInfo);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onUpdateTrafficSignalInfo(ArrayList<TrafficSignal> arrayList) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onUpdateTrafficSignalInfo(arrayList);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onUpdateElecVehicleETAInfo(ArrayList<ElecVehicleETAInfo> arrayList) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onUpdateElecVehicleETAInfo(arrayList);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onCurrentRoadSpeed(int i) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onCurrentRoadSpeed(i);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onUpdateNaviSocolEvent(SocolEventInfo socolEventInfo) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onUpdateNaviSocolEvent(socolEventInfo);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onUpdateChargeStationPass(long j) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onUpdateChargeStationPass(j);
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.INaviObserverImpl
    public void onUpdateDynamicOperationDisplayEvent(DynamicOperationDisplayEvent dynamicOperationDisplayEvent) {
        INaviObserver iNaviObserver = this.mObserver;
        if (iNaviObserver != null) {
            iNaviObserver.onUpdateDynamicOperationDisplayEvent(dynamicOperationDisplayEvent);
        }
    }
}
