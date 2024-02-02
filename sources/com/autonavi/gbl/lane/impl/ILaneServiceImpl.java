package com.autonavi.gbl.lane.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.lane.LaneService;
import com.autonavi.gbl.lane.model.CarStyleInfo;
import com.autonavi.gbl.lane.model.Decision;
import com.autonavi.gbl.lane.model.DecisionDirectionStyle;
import com.autonavi.gbl.lane.model.DecisionLineStyleInfo;
import com.autonavi.gbl.lane.model.DynamicViewMode;
import com.autonavi.gbl.lane.model.LDWInfo;
import com.autonavi.gbl.lane.model.LDWLineStyleInfo;
import com.autonavi.gbl.lane.model.LaneCameraParam;
import com.autonavi.gbl.lane.model.LaneCameraParamType;
import com.autonavi.gbl.lane.model.LaneDynamicLevelType;
import com.autonavi.gbl.lane.model.LaneInitParam;
import com.autonavi.gbl.lane.model.LaneMapViewParam;
import com.autonavi.gbl.lane.model.LndsDataPriority;
import com.autonavi.gbl.lane.model.SRObjectRenderInfos;
import com.autonavi.gbl.lane.model.SRObjects;
import com.autonavi.gbl.lane.model.WarnInfos;
import com.autonavi.gbl.lane.observer.impl.ILaneObserverImpl;
import com.autonavi.gbl.lane.observer.impl.ILaneResourceProxyImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
@IntfAuto(target = LaneService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILaneServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(ILaneServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addLaneObserverNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, ILaneObserverImpl iLaneObserverImpl);

    private static native boolean attachMapViewNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, LaneMapViewParam laneMapViewParam);

    private static native void destroyNativeObj(long j);

    private static native boolean detachMapViewNative(long j, ILaneServiceImpl iLaneServiceImpl);

    private static native boolean enterLaneNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native String getEngineVersionNative();

    private static native boolean getLaneCameraParamNative(long j, ILaneServiceImpl iLaneServiceImpl, int i, long j2, LaneCameraParam laneCameraParam);

    private static native long getLaneMockServiceNative(long j, ILaneServiceImpl iLaneServiceImpl);

    private static native long getLaneServicePlayerNative(long j, ILaneServiceImpl iLaneServiceImpl);

    private static native long getLaneServiceRecorderNative(long j, ILaneServiceImpl iLaneServiceImpl);

    private static native long getLaneServiceToolNative(long j, ILaneServiceImpl iLaneServiceImpl);

    private static native boolean getSRObjectRenderInfosNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, SRObjectRenderInfos sRObjectRenderInfos);

    private static native String getVersionNative(long j, ILaneServiceImpl iLaneServiceImpl);

    private static native boolean initNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, LaneInitParam laneInitParam);

    private static native int isInitNative(long j, ILaneServiceImpl iLaneServiceImpl);

    private static native boolean lockPitchAngleNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native void logSwitchNative(long j, ILaneServiceImpl iLaneServiceImpl, int i);

    private static native boolean openCalcRoadPolygonNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native boolean openCarUpModeNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native boolean openDynamicLevelNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native boolean openDynamicViewAngleNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native boolean openFollowModeNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native boolean openLCCNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native boolean openLNDSDataDownloadNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native boolean openLaneCarNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native boolean openLaneWorkNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native boolean openNaviLineFishboneNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native boolean openNaviLineNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native boolean openNaviLineOutlineNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native boolean openShowOccpyLaneNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native boolean openShowRoadPolygonNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native boolean openTunnelViewAngleNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native void removeLaneObserverNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, ILaneObserverImpl iLaneObserverImpl);

    private static native boolean setCarStyleInfoNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, CarStyleInfo carStyleInfo);

    private static native boolean setDecisionDirectionStyleNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, DecisionDirectionStyle decisionDirectionStyle);

    private static native boolean setDecisionLineStyleNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, DecisionLineStyleInfo decisionLineStyleInfo);

    private static native boolean setDecisionNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, Decision decision);

    private static native boolean setDynamicViewModeNative(long j, ILaneServiceImpl iLaneServiceImpl, int i);

    private static native boolean setLDWInfoNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, LDWInfo lDWInfo);

    private static native boolean setLDWLineStyleNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, LDWLineStyleInfo lDWLineStyleInfo);

    private static native boolean setLaneCameraParamNative(long j, ILaneServiceImpl iLaneServiceImpl, int i, long j2, LaneCameraParam laneCameraParam);

    private static native boolean setLaneDynamicLevelNative(long j, ILaneServiceImpl iLaneServiceImpl, int i, float f);

    private static native boolean setLoadDataPriorityNative(long j, ILaneServiceImpl iLaneServiceImpl, int i);

    private static native boolean setNaviLineLengthNative(long j, ILaneServiceImpl iLaneServiceImpl, float f);

    private static native boolean setPersonNumNative(long j, ILaneServiceImpl iLaneServiceImpl, int i);

    private static native boolean setResourceProxyNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, ILaneResourceProxyImpl iLaneResourceProxyImpl);

    private static native boolean setSRObjectNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, SRObjects sRObjects);

    private static native boolean setWarnInfoNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, WarnInfos warnInfos);

    private static native void unInitNative(long j, ILaneServiceImpl iLaneServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected ILaneServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILaneServiceImpl) && getUID(this) == getUID((ILaneServiceImpl) obj);
    }

    private static long getUID(ILaneServiceImpl iLaneServiceImpl) {
        long cPtr = getCPtr(iLaneServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILaneServiceImpl iLaneServiceImpl) {
        if (iLaneServiceImpl == null) {
            return 0L;
        }
        return iLaneServiceImpl.swigCPtr;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        return this.swigCPtr;
    }

    protected synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public LaneCameraParam getLaneCameraParam(@LaneCameraParamType.LaneCameraParamType1 int i) {
        LaneCameraParam laneCameraParam = new LaneCameraParam();
        if (getLaneCameraParam(i, laneCameraParam)) {
            return laneCameraParam;
        }
        return null;
    }

    public SRObjectRenderInfos getSRObjectRenderInfos() {
        SRObjectRenderInfos sRObjectRenderInfos = new SRObjectRenderInfos();
        if (getSRObjectRenderInfos(sRObjectRenderInfos)) {
            return sRObjectRenderInfos;
        }
        return null;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInitNative(j, this);
    }

    public String getVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVersionNative(j, this);
    }

    public static String getEngineVersion() {
        return getEngineVersionNative();
    }

    public boolean init(LaneInitParam laneInitParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, laneInitParam);
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }

    public void logSwitch(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        logSwitchNative(j, this, i);
    }

    public boolean attachMapView(LaneMapViewParam laneMapViewParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return attachMapViewNative(j, this, 0L, laneMapViewParam);
    }

    public boolean detachMapView() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return detachMapViewNative(j, this);
    }

    public boolean setResourceProxy(ILaneResourceProxyImpl iLaneResourceProxyImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setResourceProxyNative(j, this, ILaneResourceProxyImpl.getCPtr(iLaneResourceProxyImpl), iLaneResourceProxyImpl);
    }

    public boolean setSRObject(SRObjects sRObjects) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setSRObjectNative(j, this, 0L, sRObjects);
    }

    public boolean setCarStyleInfo(CarStyleInfo carStyleInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setCarStyleInfoNative(j, this, 0L, carStyleInfo);
    }

    public boolean setDecisionLineStyle(DecisionLineStyleInfo decisionLineStyleInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setDecisionLineStyleNative(j, this, 0L, decisionLineStyleInfo);
    }

    public boolean setDecisionDirectionStyle(DecisionDirectionStyle decisionDirectionStyle) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setDecisionDirectionStyleNative(j, this, 0L, decisionDirectionStyle);
    }

    public boolean setDecision(Decision decision) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setDecisionNative(j, this, 0L, decision);
    }

    public boolean setWarnInfo(WarnInfos warnInfos) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setWarnInfoNative(j, this, 0L, warnInfos);
    }

    public boolean setLDWLineStyle(LDWLineStyleInfo lDWLineStyleInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLDWLineStyleNative(j, this, 0L, lDWLineStyleInfo);
    }

    public boolean setLDWInfo(LDWInfo lDWInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLDWInfoNative(j, this, 0L, lDWInfo);
    }

    public boolean openDynamicViewAngle(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openDynamicViewAngleNative(j, this, z);
    }

    public boolean openTunnelViewAngle(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openTunnelViewAngleNative(j, this, z);
    }

    public boolean setDynamicViewMode(@DynamicViewMode.DynamicViewMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setDynamicViewModeNative(j, this, i);
    }

    public boolean openLCC(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openLCCNative(j, this, z);
    }

    public boolean openLNDSDataDownload(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openLNDSDataDownloadNative(j, this, z);
    }

    public boolean openLaneWork(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openLaneWorkNative(j, this, z);
    }

    public boolean enterLane(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return enterLaneNative(j, this, z);
    }

    public boolean openShowOccpyLane(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openShowOccpyLaneNative(j, this, z);
    }

    public boolean openNaviLine(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openNaviLineNative(j, this, z);
    }

    public boolean openNaviLineFishbone(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openNaviLineFishboneNative(j, this, z);
    }

    public boolean openNaviLineOutline(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openNaviLineOutlineNative(j, this, z);
    }

    public boolean setNaviLineLength(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setNaviLineLengthNative(j, this, f);
    }

    public boolean openLaneCar(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openLaneCarNative(j, this, z);
    }

    public boolean setLoadDataPriority(@LndsDataPriority.LndsDataPriority1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLoadDataPriorityNative(j, this, i);
    }

    public boolean setPersonNum(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setPersonNumNative(j, this, i);
    }

    public boolean openFollowMode(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openFollowModeNative(j, this, z);
    }

    public boolean openDynamicLevel(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openDynamicLevelNative(j, this, z);
    }

    public boolean openCarUpMode(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openCarUpModeNative(j, this, z);
    }

    public boolean lockPitchAngle(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return lockPitchAngleNative(j, this, z);
    }

    public boolean setLaneDynamicLevel(@LaneDynamicLevelType.LaneDynamicLevelType1 int i, float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLaneDynamicLevelNative(j, this, i, f);
    }

    public boolean openCalcRoadPolygon(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openCalcRoadPolygonNative(j, this, z);
    }

    public boolean openShowRoadPolygon(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openShowRoadPolygonNative(j, this, z);
    }

    public boolean setLaneCameraParam(@LaneCameraParamType.LaneCameraParamType1 int i, LaneCameraParam laneCameraParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLaneCameraParamNative(j, this, i, 0L, laneCameraParam);
    }

    private boolean getLaneCameraParam(@LaneCameraParamType.LaneCameraParamType1 int i, LaneCameraParam laneCameraParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLaneCameraParamNative(j, this, i, 0L, laneCameraParam);
    }

    private boolean getSRObjectRenderInfos(SRObjectRenderInfos sRObjectRenderInfos) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSRObjectRenderInfosNative(j, this, 0L, sRObjectRenderInfos);
    }

    public ILaneServiceRecorderImpl getLaneServiceRecorder() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long laneServiceRecorderNative = getLaneServiceRecorderNative(j, this);
        if (laneServiceRecorderNative == 0) {
            return null;
        }
        return new ILaneServiceRecorderImpl(laneServiceRecorderNative, false);
    }

    public ILaneServicePlayerImpl getLaneServicePlayer() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long laneServicePlayerNative = getLaneServicePlayerNative(j, this);
        if (laneServicePlayerNative == 0) {
            return null;
        }
        return new ILaneServicePlayerImpl(laneServicePlayerNative, false);
    }

    public ILaneServiceToolImpl getLaneServiceTool() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long laneServiceToolNative = getLaneServiceToolNative(j, this);
        if (laneServiceToolNative == 0) {
            return null;
        }
        return new ILaneServiceToolImpl(laneServiceToolNative, false);
    }

    public ILaneMockServiceImpl getLaneMockService() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long laneMockServiceNative = getLaneMockServiceNative(j, this);
        if (laneMockServiceNative == 0) {
            return null;
        }
        return new ILaneMockServiceImpl(laneMockServiceNative, false);
    }

    public void addLaneObserver(ILaneObserverImpl iLaneObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addLaneObserverNative(j, this, ILaneObserverImpl.getCPtr(iLaneObserverImpl), iLaneObserverImpl);
    }

    public void removeLaneObserver(ILaneObserverImpl iLaneObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeLaneObserverNative(j, this, ILaneObserverImpl.getCPtr(iLaneObserverImpl), iLaneObserverImpl);
    }
}
