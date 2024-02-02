package com.xiaopeng.montecarlo.navcore.xptbt;

import android.car.hardware.xpu.XpuProtoMessage;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.common.path.model.POIInfo;
import com.autonavi.gbl.common.path.model.TollGateInfo;
import com.autonavi.gbl.common.path.option.POIForRequest;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.guide.GuideService;
import com.autonavi.gbl.guide.model.CrossImageInfo;
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
import com.autonavi.gbl.guide.model.NaviWeatherInfo;
import com.autonavi.gbl.guide.model.PathTrafficEventInfo;
import com.autonavi.gbl.guide.model.RouteTrafficEventInfo;
import com.autonavi.gbl.guide.model.SAPAInquireResponseData;
import com.autonavi.gbl.guide.model.SocolEventInfo;
import com.autonavi.gbl.guide.model.SoundInfo;
import com.autonavi.gbl.guide.model.SuggestChangePathReason;
import com.autonavi.gbl.guide.model.TMCIncidentReport;
import com.autonavi.gbl.guide.model.TrafficSignal;
import com.autonavi.gbl.guide.model.guidecontrol.CameraParam;
import com.autonavi.gbl.guide.model.guidecontrol.Param;
import com.autonavi.gbl.guide.observer.ICruiseObserver;
import com.autonavi.gbl.guide.observer.INaviObserver;
import com.autonavi.gbl.guide.observer.ISoundPlayObserver;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.autonavi.gbl.util.model.BinaryStream;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.setting.SettingBLManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.util.NaviLogUtil;
import com.xiaopeng.montecarlo.navcore.util.XPUDataFormatHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.INaviPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPAsyncInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverConfig;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviPath;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.carservice.ICarService;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class GuideServiceWrapper {
    private static final long REQUEST_MUTI_ROUTE_IGNORE_TIME = 1000;
    private static final L.Tag TAG = new L.Tag("GuideServiceWrapper");
    private GuideManager mGuideManager;
    private GuideService mGuideService;
    private long mPreRerouteTime;
    private final ISoundPlayObserver mSoundPlayObserver = new ISoundPlayObserver() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.GuideServiceWrapper.1
        @Override // com.autonavi.gbl.guide.observer.ISoundPlayObserver
        public boolean isPlaying() {
            return false;
        }

        @Override // com.autonavi.gbl.guide.observer.ISoundPlayObserver
        public void onPlayTTS(SoundInfo soundInfo) {
            if (soundInfo != null) {
                try {
                    if (!TextUtils.isEmpty(soundInfo.text)) {
                        GuideServiceWrapper.this.mGuideManager.onPlayTTS(BLDataModelUtil.toXPSoundInfo(soundInfo));
                        return;
                    }
                } catch (Exception e) {
                    NavCoreUtil.postCrashToast();
                    e.printStackTrace();
                    L.Tag tag = GuideServiceWrapper.TAG;
                    L.e(tag, "onPlayTTS error:" + e.getMessage());
                    return;
                }
            }
            L.w(GuideServiceWrapper.TAG, "onPlayTTS: soundInfo is null or soundInfo.text is empty!!! ");
        }

        @Override // com.autonavi.gbl.guide.observer.ISoundPlayObserver
        public void onPlayRing(int i) {
            L.Tag tag = GuideServiceWrapper.TAG;
            L.i(tag, "onPlayRing: " + i);
        }
    };
    private final ICruiseObserver mCruiseObserver = new ICruiseObserver() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.GuideServiceWrapper.2
        @Override // com.autonavi.gbl.guide.observer.ICruiseObserver
        public void onUpdateCruiseSocolEvent(SocolEventInfo socolEventInfo) {
        }

        @Override // com.autonavi.gbl.guide.observer.ICruiseObserver
        public void onUpdateCruiseTimeAndDist(CruiseTimeAndDist cruiseTimeAndDist) {
        }

        @Override // com.autonavi.gbl.guide.observer.ICruiseObserver
        public void onUpdateElecCameraInfo(ArrayList<CruiseFacilityInfo> arrayList) {
        }

        @Override // com.autonavi.gbl.guide.observer.ICruiseObserver
        public void onUpdateCruiseFacility(ArrayList<CruiseFacilityInfo> arrayList) {
            if (L.ENABLE) {
                L.d(GuideServiceWrapper.TAG, "onUpdateCruiseFacility");
            }
            ArrayList arrayList2 = null;
            if (arrayList != null) {
                try {
                    arrayList2 = new ArrayList();
                    Iterator<CruiseFacilityInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(BLDataModelUtil.toXPCruiseFacilityInfo(it.next()));
                    }
                } catch (Exception e) {
                    NavCoreUtil.postCrashToast();
                    e.printStackTrace();
                    L.Tag tag = GuideServiceWrapper.TAG;
                    L.e(tag, "onUpdateCruiseFacility error:" + e.getMessage());
                    return;
                }
            }
            GuideServiceWrapper.this.mGuideManager.onUpdateCruiseFacility(arrayList2);
        }

        @Override // com.autonavi.gbl.guide.observer.ICruiseObserver
        public void onUpdateCruiseInfo(CruiseInfo cruiseInfo) {
            if (L.ENABLE) {
                L.d(GuideServiceWrapper.TAG, "onUpdateCruiseInfo");
            }
            try {
                GuideServiceWrapper.this.mGuideManager.onUpdateCruiseInfo(BLDataModelUtil.toXPCruiseInfo(cruiseInfo));
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.e(GuideServiceWrapper.TAG, "onUpdateCruiseInfo error");
            }
        }

        @Override // com.autonavi.gbl.guide.observer.ICruiseObserver
        public void onUpdateCruiseCongestionInfo(CruiseCongestionInfo cruiseCongestionInfo) {
            if (L.ENABLE) {
                L.d(GuideServiceWrapper.TAG, "onUpdateCruiseCongestionInfo: ");
            }
            try {
                GuideServiceWrapper.this.mGuideManager.onUpdateCruiseCongestionInfo(BLDataModelUtil.toXPCruiseCongestionInfo(cruiseCongestionInfo));
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.e(GuideServiceWrapper.TAG, "onUpdateCruiseCongestionInfo error");
            }
        }

        @Override // com.autonavi.gbl.guide.observer.ICruiseObserver
        public void onShowCruiseLaneInfo(LaneInfo laneInfo) {
            if (L.ENABLE) {
                L.d(GuideServiceWrapper.TAG, "onShowCruiseLaneInfo");
            }
            try {
                GuideServiceWrapper.this.mGuideManager.onUpdateCruiseLaneInfo(BLDataModelUtil.toXPLaneInfo(laneInfo), true);
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.e(GuideServiceWrapper.TAG, "onShowCruiseLaneInfo error");
            }
        }

        @Override // com.autonavi.gbl.guide.observer.ICruiseObserver
        public void onHideCruiseLaneInfo() {
            if (L.ENABLE) {
                L.d(GuideServiceWrapper.TAG, "onHideCruiseLaneInfo");
            }
            try {
                GuideServiceWrapper.this.mGuideManager.onUpdateCruiseLaneInfo(null, false);
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.e(GuideServiceWrapper.TAG, "onHideCruiseLaneInfo error");
            }
        }

        @Override // com.autonavi.gbl.guide.observer.ICruiseObserver
        public void onUpdateCruiseEvent(CruiseEventInfo cruiseEventInfo) {
            if (L.ENABLE) {
                L.d(GuideServiceWrapper.TAG, "onUpdateCruiseEvent");
            }
            try {
                GuideServiceWrapper.this.mGuideManager.onUpdateCruiseEvent(BLDataModelUtil.toXPCruiseEventInfo(cruiseEventInfo));
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag = GuideServiceWrapper.TAG;
                L.e(tag, "onUpdateCruiseEvent error:" + e.getMessage());
            }
        }
    };
    private final INaviObserver mNaviObserver = new INaviObserver() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.GuideServiceWrapper.3
        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onCarOnRouteAgain() {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onHideTMCIncidentReport(int i) {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onMainNaviPath(PathInfo pathInfo) {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onObtainExitDirectionInfo(ExitDirectionResponseData exitDirectionResponseData) {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onObtainSAPAInfo(SAPAInquireResponseData sAPAInquireResponseData) {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onPassLast3DSegment() {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onShowLockScreenTip(LockScreenTip lockScreenTip) {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onShowNaviCrossTMC(BinaryStream binaryStream) {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onShowNaviFacility(ArrayList<NaviRoadFacility> arrayList) {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onShowNaviWeather(ArrayList<NaviWeatherInfo> arrayList) {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onShowSameDirectionMixForkInfo(@Nullable ArrayList<MixForkInfo> arrayList) {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onShowTMCIncidentReport(TMCIncidentReport tMCIncidentReport) {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onUpdateChargeStationPass(long j) {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onUpdateDynamicOperationDisplayEvent(DynamicOperationDisplayEvent dynamicOperationDisplayEvent) {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onUpdateElecVehicleETAInfo(ArrayList<ElecVehicleETAInfo> arrayList) {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onUpdateIsSupportSimple3D(boolean z) {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onUpdateNaviSocolEvent(SocolEventInfo socolEventInfo) {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onUpdateSocolText(String str) {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onUpdateTrafficSignalInfo(ArrayList<TrafficSignal> arrayList) {
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onUpdateNaviInfo(ArrayList<NaviInfo> arrayList) {
            if (L.ENABLE) {
                L.d(GuideServiceWrapper.TAG, "onUpdateNaviInfo");
            }
            ArrayList arrayList2 = null;
            if (arrayList != null) {
                try {
                    arrayList2 = new ArrayList();
                    Iterator<NaviInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(BLDataModelUtil.toXPNaviInfo(it.next()));
                    }
                } catch (Exception e) {
                    NavCoreUtil.postCrashToast();
                    e.printStackTrace();
                    L.Tag tag = GuideServiceWrapper.TAG;
                    L.e(tag, "onUpdateNaviInfo error:" + e.getMessage());
                    return;
                }
            }
            GuideServiceWrapper.this.mGuideManager.onUpdateNaviInfo(arrayList2);
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onUpdateExitDirectionInfo(ExitDirectionInfo exitDirectionInfo) {
            if (L.ENABLE) {
                L.d(GuideServiceWrapper.TAG, "onUpdateExitDirectionInfo");
            }
            try {
                GuideServiceWrapper.this.mGuideManager.onUpdateExitDirectionInfo(BLDataModelUtil.toXPExitDirectionInfo(exitDirectionInfo));
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag = GuideServiceWrapper.TAG;
                L.e(tag, "onUpdateExitDirectionInfo error:" + e.getMessage());
            }
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onShowCrossImage(CrossImageInfo crossImageInfo) {
            L.Tag tag = GuideServiceWrapper.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onShowCrossImage type = ");
            sb.append(crossImageInfo != null ? crossImageInfo.type : -1);
            L.i(tag, sb.toString());
            try {
                GuideServiceWrapper.this.mGuideManager.onUpdateCrossImage(BLDataModelUtil.toXPCrossImageInfo(crossImageInfo), 0, true);
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag2 = GuideServiceWrapper.TAG;
                L.e(tag2, "onShowCrossImage error:" + e.getMessage());
            }
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onHideCrossImage(int i) {
            L.Tag tag = GuideServiceWrapper.TAG;
            L.i(tag, "onHideCrossImage type = " + i);
            try {
                GuideServiceWrapper.this.mGuideManager.onUpdateCrossImage(null, i, false);
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag2 = GuideServiceWrapper.TAG;
                L.e(tag2, "onHideCrossImage error:" + e.getMessage());
            }
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onShowNaviLaneInfo(@Nullable LaneInfo laneInfo) {
            if (L.ENABLE) {
                L.d(GuideServiceWrapper.TAG, "onShowNaviLaneInfo");
            }
            try {
                GuideServiceWrapper.this.mGuideManager.onUpdateNaviLaneInfo(BLDataModelUtil.toXPLaneInfo(laneInfo), true);
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag = GuideServiceWrapper.TAG;
                L.e(tag, "onShowNaviLaneInfo error:" + e.getMessage());
            }
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onHideNaviLaneInfo() {
            if (L.ENABLE) {
                L.d(GuideServiceWrapper.TAG, "onHideNaviLaneInfo");
            }
            try {
                GuideServiceWrapper.this.mGuideManager.onUpdateNaviLaneInfo(null, false);
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag = GuideServiceWrapper.TAG;
                L.e(tag, "onHideNaviLaneInfo error:" + e.getMessage());
            }
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onShowNaviManeuver(ManeuverInfo maneuverInfo) {
            L.Tag tag = GuideServiceWrapper.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onShowNaviManeuver maneuverId=");
            sb.append(maneuverInfo == null ? -1L : maneuverInfo.maneuverID);
            L.i(tag, sb.toString());
            try {
                XPManeuverInfo xPManeuverInfo = BLDataModelUtil.toXPManeuverInfo(maneuverInfo);
                if (xPManeuverInfo != null) {
                    GuideServiceWrapper.this.mGuideManager.onShowNaviManeuver(xPManeuverInfo);
                }
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag2 = GuideServiceWrapper.TAG;
                L.e(tag2, "onShowNaviManeuver error:" + e.getMessage());
            }
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onShowNaviCamera(ArrayList<NaviCamera> arrayList) {
            if (L.ENABLE) {
                L.Tag tag = GuideServiceWrapper.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onShowNaviCamera: ");
                sb.append(arrayList == null ? "null" : Integer.valueOf(arrayList.size()));
                L.d(tag, sb.toString());
            }
            ArrayList arrayList2 = null;
            if (arrayList != null) {
                try {
                    arrayList2 = new ArrayList();
                    Iterator<NaviCamera> it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(BLDataModelUtil.toXPCameraInfo(it.next()));
                    }
                } catch (Exception e) {
                    NavCoreUtil.postCrashToast();
                    e.printStackTrace();
                    L.Tag tag2 = GuideServiceWrapper.TAG;
                    L.e(tag2, "onShowNaviCamera error:" + e.getMessage());
                    return;
                }
            }
            GuideServiceWrapper.this.mGuideManager.onShowNaviCamera(arrayList2);
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onShowNaviIntervalCamera(ArrayList<NaviIntervalCamera> arrayList) {
            if (L.ENABLE) {
                L.d(GuideServiceWrapper.TAG, "onShowNaviIntervalCamera");
            }
            ArrayList arrayList2 = null;
            if (arrayList != null) {
                try {
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        NaviIntervalCamera naviIntervalCamera = arrayList.get(i);
                        if (naviIntervalCamera != null && (naviIntervalCamera.speed == null || naviIntervalCamera.speed.size() == 0 || naviIntervalCamera.speed.get(0).shortValue() == 0 || naviIntervalCamera.speed.get(0).shortValue() == 255)) {
                            arrayList.remove(i);
                            size = arrayList.size();
                            i--;
                        }
                        i++;
                    }
                    arrayList2 = new ArrayList();
                    Iterator<NaviIntervalCamera> it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(BLDataModelUtil.toXPCameraInfo(it.next()));
                    }
                } catch (Exception e) {
                    NavCoreUtil.postCrashToast();
                    e.printStackTrace();
                    L.e(GuideServiceWrapper.TAG, "onShowNaviIntervalCamera error:" + e.getMessage());
                    return;
                }
            }
            GuideServiceWrapper.this.mGuideManager.onShowNaviIntervalCamera(arrayList2);
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onUpdateIntervalCameraDynamicInfo(ArrayList<NaviIntervalCameraDynamicInfo> arrayList) {
            if (L.ENABLE) {
                L.d(GuideServiceWrapper.TAG, "onUpdateIntervalCameraDynamicInfo");
            }
            ArrayList arrayList2 = null;
            if (arrayList != null) {
                try {
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        NaviIntervalCameraDynamicInfo naviIntervalCameraDynamicInfo = arrayList.get(i);
                        if (naviIntervalCameraDynamicInfo != null) {
                            L.i(GuideServiceWrapper.TAG, ">>> onUpdateIntervalCameraDynamicInfo speed length=" + naviIntervalCameraDynamicInfo.speed.size());
                            if (naviIntervalCameraDynamicInfo.speed == null || naviIntervalCameraDynamicInfo.speed.size() == 0 || naviIntervalCameraDynamicInfo.speed.get(0).shortValue() == 0 || naviIntervalCameraDynamicInfo.speed.get(0).shortValue() == 255 || naviIntervalCameraDynamicInfo.averageSpeed == -1) {
                                arrayList.remove(i);
                                size = arrayList.size();
                                i--;
                            }
                        }
                        i++;
                    }
                    arrayList2 = new ArrayList();
                    Iterator<NaviIntervalCameraDynamicInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(BLDataModelUtil.toXPCameraInfo(it.next()));
                    }
                } catch (Exception e) {
                    NavCoreUtil.postCrashToast();
                    e.printStackTrace();
                    L.e(GuideServiceWrapper.TAG, "onUpdateIntervalCameraDynamicInfo error:" + e.getMessage());
                    return;
                }
            }
            GuideServiceWrapper.this.mGuideManager.onUpdateIntervalCameraDynamicInfo(arrayList2);
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onUpdateSAPA(ArrayList<NaviFacility> arrayList) {
            if (L.ENABLE) {
                L.d(GuideServiceWrapper.TAG, "onUpdateSAPA");
            }
            ArrayList arrayList2 = null;
            if (arrayList != null) {
                try {
                    arrayList2 = new ArrayList();
                    Iterator<NaviFacility> it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(BLDataModelUtil.toXPFacilityInfo(it.next()));
                    }
                } catch (Exception e) {
                    NavCoreUtil.postCrashToast();
                    e.printStackTrace();
                    L.Tag tag = GuideServiceWrapper.TAG;
                    L.e(tag, "onUpdateSAPA error:" + e.getMessage());
                    return;
                }
            }
            GuideServiceWrapper.this.mGuideManager.onUpdateSAPA(arrayList2);
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onNaviArrive(long j, int i) {
            if (L.ENABLE) {
                L.d(GuideServiceWrapper.TAG, "onNaviArrive");
            }
            GuideServiceWrapper.this.mGuideManager.naviArriveStop();
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onNaviStop(long j, int i) {
            if (L.ENABLE) {
                L.Tag tag = GuideServiceWrapper.TAG;
                L.d(tag, "onNaviStop type=" + i);
            }
            try {
                GuideServiceWrapper.this.mGuideManager.onNaviStop(i, true);
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag2 = GuideServiceWrapper.TAG;
                L.e(tag2, "onNaviStop error:" + e.getMessage());
            }
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onUpdateViaPass(long j) {
            L.Tag tag = GuideServiceWrapper.TAG;
            L.i(tag, "onUpdateViaPass index=" + j);
            try {
                GuideServiceWrapper.this.mGuideManager.onUpdateViaPass(j);
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag2 = GuideServiceWrapper.TAG;
                L.e(tag2, "onUpdateViaPass error:" + e.getMessage());
            }
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onDriveReport(String str, NaviStatisticsInfo naviStatisticsInfo) {
            GuideServiceWrapper.this.mGuideManager.onDriveReport(str, naviStatisticsInfo);
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onShowDriveEventTip(ArrayList<DriveEventTip> arrayList) {
            GuideServiceWrapper.this.mGuideManager.onShowDriveEventTip(arrayList);
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onReroute(RouteOption routeOption) {
            try {
                L.Tag tag = GuideServiceWrapper.TAG;
                L.i(tag, ">>>onReroute: " + NaviLogUtil.dumpRerouteOption(routeOption));
                if (routeOption != null) {
                    if (14 == routeOption.getRouteType()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        long j = currentTimeMillis - GuideServiceWrapper.this.mPreRerouteTime;
                        GuideServiceWrapper.this.mPreRerouteTime = currentTimeMillis;
                        if (j <= 1000) {
                            L.Tag tag2 = GuideServiceWrapper.TAG;
                            L.i(tag2, "onReroute mutiroute high frequency, ignore diffTime = " + j);
                            return;
                        }
                    }
                    RouteOption create = RouteOption.create();
                    create.copy(routeOption);
                    RouteParams rerouteOption2RouteParams = GuideServiceWrapper.this.rerouteOption2RouteParams(create);
                    if (rerouteOption2RouteParams != null) {
                        GuideServiceWrapper.this.mGuideManager.onReroute(rerouteOption2RouteParams);
                        return;
                    }
                    L.e(GuideServiceWrapper.TAG, "onReroute routeParams == null ");
                    RouteOption.destroy(create);
                }
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag3 = GuideServiceWrapper.TAG;
                L.e(tag3, "onReroute error:" + e.getMessage());
            }
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onUpdateTMCLightBar(ArrayList<LightBarInfo> arrayList, long j, boolean z) {
            if (L.ENABLE) {
                L.Tag tag = GuideServiceWrapper.TAG;
                L.d(tag, "onUpdateTMCLightBar: i: " + j + ", b: " + z);
            }
            ArrayList arrayList2 = null;
            if (arrayList != null) {
                try {
                    arrayList2 = new ArrayList();
                    Iterator<LightBarInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(BLDataModelUtil.toXPLightBarInfo(it.next()));
                    }
                } catch (Exception e) {
                    NavCoreUtil.postCrashToast();
                    e.printStackTrace();
                    L.Tag tag2 = GuideServiceWrapper.TAG;
                    L.e(tag2, "onUpdateTMCLightBar error:" + e.getMessage());
                    return;
                }
            }
            GuideServiceWrapper.this.mGuideManager.onUpdateTMCLightBar(arrayList2, (int) j, z);
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onUpdateTMCCongestionInfo(NaviCongestionInfo naviCongestionInfo) {
            if (L.ENABLE) {
                L.d(GuideServiceWrapper.TAG, "onUpdateTMCCongestionInfo");
            }
            try {
                GuideServiceWrapper.this.mGuideManager.onUpdateTMCCongestionInfo(BLDataModelUtil.toXPNaviCongestionInfo(naviCongestionInfo));
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag = GuideServiceWrapper.TAG;
                L.e(tag, "onUpdateTMCCongestionInfo error:" + e.getMessage());
            }
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onUpdateTREvent(ArrayList<PathTrafficEventInfo> arrayList, long j) {
            if (L.ENABLE) {
                L.Tag tag = GuideServiceWrapper.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onUpdateTREvent list size = ");
                sb.append(arrayList != null ? Integer.valueOf(arrayList.size()) : " 0");
                sb.append(" count = ");
                sb.append(j);
                L.d(tag, sb.toString());
            }
            ArrayList arrayList2 = null;
            if (arrayList != null) {
                try {
                    arrayList2 = new ArrayList();
                    Iterator<PathTrafficEventInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(BLDataModelUtil.toXPPathTrafficEventInfo(it.next()));
                    }
                } catch (Exception e) {
                    NavCoreUtil.postCrashToast();
                    e.printStackTrace();
                    L.Tag tag2 = GuideServiceWrapper.TAG;
                    L.e(tag2, "onUpdateTREvent error:" + e.getMessage());
                    return;
                }
            }
            GuideServiceWrapper.this.mGuideManager.onUpdateTREvent(arrayList2, (int) j);
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onUpdateTRPlayView(RouteTrafficEventInfo routeTrafficEventInfo) {
            if (L.ENABLE) {
                L.d(GuideServiceWrapper.TAG, "onUpdateTRPlayView");
            }
            try {
                GuideServiceWrapper.this.mGuideManager.onUpdateTRPlayView(BLDataModelUtil.toXPRouteTrafficEventInfo(routeTrafficEventInfo));
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag = GuideServiceWrapper.TAG;
                L.e(tag, "onUpdateTRPlayView error:" + e.getMessage());
            }
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onDeletePath(ArrayList<Long> arrayList) {
            L.Tag tag = GuideServiceWrapper.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onDeletePath list = ");
            sb.append(arrayList == null ? "null" : arrayList.toString());
            L.i(tag, sb.toString());
            try {
                GuideServiceWrapper.this.mGuideManager.onDeletePath(arrayList);
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag2 = GuideServiceWrapper.TAG;
                L.e(tag2, "onDeletePath error:" + e.getMessage());
            }
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onChangeNaviPath(long j, long j2) {
            L.Tag tag = GuideServiceWrapper.TAG;
            L.i(tag, "onChangeNaviPath pathId =" + j2);
            try {
                GuideServiceWrapper.this.mGuideManager.onChangeNaviPath(j2);
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag2 = GuideServiceWrapper.TAG;
                L.e(tag2, "onChangeNaviPath error:" + e.getMessage());
            }
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onSelectMainPathStatus(long j, int i) {
            L.Tag tag = GuideServiceWrapper.TAG;
            L.i(tag, "onSelectMainPathStatus pathId=" + j + " result=" + i);
            try {
                GuideServiceWrapper.this.mGuideManager.onSelectMainPathStatus(j, i);
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag2 = GuideServiceWrapper.TAG;
                L.e(tag2, "onSelectMainPathStatus error:" + e.getMessage());
            }
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onSuggestChangePath(long j, long j2, SuggestChangePathReason suggestChangePathReason) {
            if (L.ENABLE) {
                L.Tag tag = GuideServiceWrapper.TAG;
                L.d(tag, "onSuggestChangePath newPathId =" + j + " oldPathId=" + j2);
            }
            try {
                GuideServiceWrapper.this.mGuideManager.onSuggestChangePath(j, j2, suggestChangePathReason != null ? suggestChangePathReason.saveTime : -1L);
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag2 = GuideServiceWrapper.TAG;
                L.e(tag2, "onSuggestChangePath error:" + e.getMessage());
            }
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onObtainManeuverIconData(ManeuverIconResponseData maneuverIconResponseData) {
            L.Tag tag = GuideServiceWrapper.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onObtainAsyncInfo reqId=");
            sb.append(maneuverIconResponseData == null ? -1 : maneuverIconResponseData.requestID);
            L.i(tag, sb.toString());
            try {
                GuideServiceWrapper.this.mGuideManager.onObtainAsyncInfo(BLDataModelUtil.toXPObtainInfo(maneuverIconResponseData));
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag2 = GuideServiceWrapper.TAG;
                L.e(tag2, "onObtainAsyncInfo error:" + e.getMessage());
            }
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onShowTollGateLane(TollGateInfo tollGateInfo) {
            if (L.ENABLE) {
                L.d(GuideServiceWrapper.TAG, "onShowTollGateLane");
            }
            try {
                GuideServiceWrapper.this.mGuideManager.onShowTollGateLane(BLDataModelUtil.toXPTollGateInfo(tollGateInfo));
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag = GuideServiceWrapper.TAG;
                L.e(tag, "onShowTollGateLane error:" + e.getMessage());
            }
        }

        @Override // com.autonavi.gbl.guide.observer.INaviObserver
        public void onCurrentRoadSpeed(int i) {
            if (L.ENABLE) {
                L.Tag tag = GuideServiceWrapper.TAG;
                L.d(tag, "onCurrentRoadSpeed = " + i);
            }
            try {
                GuideServiceWrapper.this.mGuideManager.onCurrentRoadSpeed(i);
            } catch (Exception e) {
                NavCoreUtil.postCrashToast();
                e.printStackTrace();
                L.Tag tag2 = GuideServiceWrapper.TAG;
                L.e(tag2, "onCurrentRoadSpeed error:" + e.getMessage());
            }
        }
    };
    private boolean mIsGuideServiceInitialized = false;
    private ICarService.ICarXPUDataCallBack mICarXPUDataCallBack = new ICarService.ICarXPUDataCallBack() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.GuideServiceWrapper.4
        @Override // com.xiaopeng.montecarlo.root.carservice.ICarService.ICarXPUDataCallBack
        public ArrayList<XpuProtoMessage.V2_Point> getCurrentRouteAllPoints() {
            return XPUDataFormatHelper.getInstance().getCurrentRouteAllPoints();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuideServiceWrapper(GuideManager guideManager) {
        this.mGuideManager = guideManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean initGuide() {
        if (this.mGuideService == null) {
            this.mGuideService = (GuideService) ServiceMgr.getServiceMgrInstance().getBLService(15);
            if (this.mGuideService == null) {
                L.e(TAG, "initGuide failed");
                this.mIsGuideServiceInitialized = false;
                return false;
            }
        }
        if (this.mGuideService.isInit() == 1) {
            if (this.mGuideService.init() != 0) {
                L.e(TAG, "initGuide failed");
                this.mGuideService = null;
                this.mIsGuideServiceInitialized = false;
                return false;
            }
            this.mGuideService.control(54, "1");
            this.mGuideService.control(15, "3");
            this.mGuideService.control(52, "1");
            this.mGuideService.control(67, "3");
            this.mGuideService.control(61, "1");
            Param param = new Param();
            param.type = 8;
            param.camera = new CameraParam();
            param.camera.enable = true;
            param.camera.maxCount = 3;
            param.camera.filter = new int[32];
            param.camera.filter[0] = 0;
            param.camera.filter[1] = 3;
            param.camera.filter[2] = 4;
            param.camera.filter[3] = 6;
            param.camera.filter[4] = 2;
            param.camera.filter[5] = 5;
            param.camera.filter[6] = 1;
            this.mGuideService.setParam(param);
            this.mGuideService.addCruiseObserver(this.mCruiseObserver);
            this.mGuideService.addNaviObserver(this.mNaviObserver);
            this.mGuideService.addSoundPlayObserver(this.mSoundPlayObserver);
            this.mIsGuideServiceInitialized = true;
            adjustSimulationSpeed(String.valueOf(60));
            setVehicleId(SettingWrapper.getLicensePlate());
            setETARestriction(SettingWrapper.isOpenPlateSwitch());
            setVehicleType("2");
            SettingBLManager.getInstance().initPlayStyle();
            SettingBLManager.getInstance().setCruiseBroadcast();
            SettingBLManager.getInstance().setDayNightMode();
            CarServiceManager.getInstance().setICarXPUDataCallBack(this.mICarXPUDataCallBack);
        } else {
            this.mIsGuideServiceInitialized = true;
        }
        return true;
    }

    private boolean checkGuideServiceInitialized() {
        if (this.mIsGuideServiceInitialized) {
            return true;
        }
        if (L.ENABLE) {
            L.d(TAG, "mGuideService is not initialized ! ");
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setVehicleId(String str) {
        if (checkGuideServiceInitialized()) {
            return this.mGuideService.control(35, str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setETARestriction(boolean z) {
        if (checkGuideServiceInitialized()) {
            return this.mGuideService.control(42, z ? "1" : "0");
        }
        return false;
    }

    public void setVehicleType(String str) {
        if (checkGuideServiceInitialized()) {
            this.mGuideService.control(36, str);
        }
    }

    public GuideService getGuideService() {
        return this.mGuideService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean startNavi(long j, int i) {
        if (checkGuideServiceInitialized()) {
            L.Tag tag = TAG;
            L.i(tag, ">>> startNavi type=" + i);
            return this.mGuideService.startNavi(j, i);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopNavi(long j) {
        if (checkGuideServiceInitialized()) {
            this.mGuideService.stopNavi(j);
            CarServiceManager.getInstance().stopNaviRoutingInfoRequest(TBTManager.getInstance().getCurrentNaviPathId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNaviPath(INaviPath iNaviPath, int i) {
        if (checkGuideServiceInitialized() && iNaviPath != null) {
            L.Tag tag = TAG;
            L.i(tag, ">>> setNaviPath index=" + i + " pathID=" + iNaviPath.getPathId(i) + " pathCount=" + iNaviPath.getNaviPathCount());
            this.mGuideService.setNaviPath(((XPNaviPath) iNaviPath).getNaviPath(), (long) i);
            CarServiceManager.getInstance().updateNaviPathNaviRoutingInfoRequest(TBTManager.getInstance().getCurrentNaviPathId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long asyncManeuverInfo(XPAsyncInfo xPAsyncInfo) {
        if (checkGuideServiceInitialized() && xPAsyncInfo != null && xPAsyncInfo.mObject != null && (xPAsyncInfo.mObject instanceof XPManeuverConfig)) {
            return this.mGuideService.obtainManeuverIconData(BLDataModelUtil.toBLManeuverConfig((XPManeuverConfig) xPAsyncInfo.mObject));
        }
        return -1L;
    }

    long asyncSAPAInfo(boolean z) {
        if (checkGuideServiceInitialized()) {
            return this.mGuideService.obtainSAPAInfo(z);
        }
        return -1L;
    }

    long asyncExitDirection(boolean z) {
        if (checkGuideServiceInitialized()) {
            return this.mGuideService.obtainExitDirectionInfo(z);
        }
        return -1L;
    }

    public void playNaviManual() {
        if (checkGuideServiceInitialized()) {
            this.mGuideService.playNaviManual();
        }
    }

    public void adjustSimulationSpeed(String str) {
        if (checkGuideServiceInitialized()) {
            this.mGuideService.control(34, str);
        }
    }

    public void selectMainPathId(long j) {
        if (checkGuideServiceInitialized()) {
            this.mGuideService.selectMainPathID(j);
        }
    }

    public void setNaviInfoCount(int i) {
        if (checkGuideServiceInitialized()) {
            this.mGuideService.control(73, String.valueOf(i));
        }
    }

    public void setCruiseAheadTraffic(boolean z) {
        if (checkGuideServiceInitialized()) {
            this.mGuideService.control(5, z ? "1" : "0");
        }
    }

    public void setCruiseOpenCamera(int i) {
        if (checkGuideServiceInitialized()) {
            this.mGuideService.control(33, String.valueOf(i));
        }
    }

    public void setPlayStyle(int i) {
        if (checkGuideServiceInitialized()) {
            this.mGuideService.control(22, String.valueOf(i));
        }
    }

    public void setDayNightMode(int i) {
        if (checkGuideServiceInitialized()) {
            this.mGuideService.control(47, String.valueOf(i));
        }
    }

    public void setEnter3D(boolean z) {
        if (checkGuideServiceInitialized()) {
            this.mGuideService.control(56, z ? "1" : "0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RouteParams rerouteOption2RouteParams(@NonNull RouteOption routeOption) {
        String str;
        XPPoiInfo xPPoiInfo;
        XPPoiInfo xPPoiInfo2;
        ArrayList arrayList;
        POIInfo point;
        int routeStrategy = routeOption.getRouteStrategy();
        int constrainCode = routeOption.getConstrainCode();
        int routeType = routeOption.getRouteType();
        RouteParams currentNaviRouteParams = TBTManager.getInstance().getCurrentNaviRouteParams();
        if (currentNaviRouteParams != null) {
            routeStrategy = currentNaviRouteParams.mRouteCalcType;
            constrainCode = currentNaviRouteParams.mConstrainCode;
            str = currentNaviRouteParams.mRouteContent;
            POIForRequest pOIForRequest = routeOption.getPOIForRequest();
            XPPoiInfo xPPoiInfo3 = (pOIForRequest == null || (point = pOIForRequest.getPoint(0, 0L)) == null) ? null : new XPPoiInfo(point);
            xPPoiInfo = xPPoiInfo3 == null ? TBTManager.getInstance().getStartPOIFromCurrent() : xPPoiInfo3;
            xPPoiInfo2 = currentNaviRouteParams.mEndInfo.deepClone();
            if (xPPoiInfo != null) {
                L.i(TAG, ">>> rerouteOption2RouteParams start=" + NaviLogUtil.dumpXPPOIInfo(xPPoiInfo));
            }
            if (xPPoiInfo2 != null) {
                L.i(TAG, ">>> rerouteOption2RouteParams endInfo=" + NaviLogUtil.dumpXPPOIInfo(xPPoiInfo2));
            }
            if (currentNaviRouteParams.mViaInfos == null || currentNaviRouteParams.mViaInfos.size() <= 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (XPViaPoint xPViaPoint : currentNaviRouteParams.mViaInfos) {
                    if (xPViaPoint != null && xPViaPoint.getPoiPoint() != null) {
                        XPViaPoint deepClone = xPViaPoint.deepClone();
                        arrayList.add(deepClone);
                        if (deepClone.getPoiPoint() != null) {
                            L.i(TAG, ">>> rerouteOption2RouteParams via=" + NaviLogUtil.dumpXPPOIInfo(deepClone.getPoiPoint()));
                        }
                    }
                }
            }
        } else {
            str = "";
            xPPoiInfo = null;
            xPPoiInfo2 = null;
            arrayList = null;
        }
        if (xPPoiInfo == null || xPPoiInfo2 == null) {
            return null;
        }
        return new RouteParams.Builder().setStartInfo(xPPoiInfo).setEndInfo(xPPoiInfo2).setViaInfos(arrayList).setRouteCalcType(routeStrategy).setConstrainCode(constrainCode).setRerouteType(routeType).setRouteLevel(1).setRouteContent(str).setRerouteOption(routeOption).build();
    }
}
