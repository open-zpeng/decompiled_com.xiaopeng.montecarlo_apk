package com.autonavi.gbl.lane.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.LaneService;
import com.autonavi.gbl.lane.model.AutopilotData;
import com.autonavi.gbl.lane.model.LaneDriveMode;
import com.autonavi.gbl.lane.model.LaneInitParam;
import com.autonavi.gbl.lane.model.LaneLndsAutoDownloadMode;
import com.autonavi.gbl.lane.model.LaneRenderParam;
import com.autonavi.gbl.lane.model.LaneRenderScreen;
import com.autonavi.gbl.lane.model.LaneTileType;
import com.autonavi.gbl.lane.model.LndsDataPriority;
import com.autonavi.gbl.lane.observer.impl.ILaneDiagnosisObserverImpl;
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

    private static native void addLaneDiagnosisObserverNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, ILaneDiagnosisObserverImpl iLaneDiagnosisObserverImpl);

    private static native void addLaneObserverNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, ILaneObserverImpl iLaneObserverImpl);

    private static native long createLaneRenderServiceNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, LaneRenderParam laneRenderParam);

    private static native boolean destroyLaneRenderServiceNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, ILaneRenderServiceImpl iLaneRenderServiceImpl);

    private static native void destroyNativeObj(long j);

    private static native String getEngineVersionNative();

    private static native long getLaneMockServiceNative(long j, ILaneServiceImpl iLaneServiceImpl);

    private static native long getLaneNaviServiceNative(long j, ILaneServiceImpl iLaneServiceImpl);

    private static native long getLaneRenderServiceNative(long j, ILaneServiceImpl iLaneServiceImpl, int i);

    private static native long getLaneServicePlayerNative(long j, ILaneServiceImpl iLaneServiceImpl);

    private static native long getLaneServiceRecorderNative(long j, ILaneServiceImpl iLaneServiceImpl);

    private static native long getLaneServiceToolNative(long j, ILaneServiceImpl iLaneServiceImpl);

    private static native String getVersionNative(long j, ILaneServiceImpl iLaneServiceImpl);

    private static native boolean initNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, LaneInitParam laneInitParam);

    private static native int isInitNative(long j, ILaneServiceImpl iLaneServiceImpl);

    private static native void logSwitchNative(long j, ILaneServiceImpl iLaneServiceImpl, int i);

    private static native boolean openLNDSDataDownloadNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native void removeLaneDiagnosisObserverNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, ILaneDiagnosisObserverImpl iLaneDiagnosisObserverImpl);

    private static native void removeLaneObserverNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, ILaneObserverImpl iLaneObserverImpl);

    private static native boolean setAutopilotDataNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, AutopilotData autopilotData);

    private static native boolean setDriveModeNative(long j, ILaneServiceImpl iLaneServiceImpl, int i);

    private static native boolean setLNDSAutoDownloadModeNative(long j, ILaneServiceImpl iLaneServiceImpl, int i);

    private static native boolean setLNDSDataLimit1Native(long j, ILaneServiceImpl iLaneServiceImpl, boolean z);

    private static native boolean setLNDSDataLimitNative(long j, ILaneServiceImpl iLaneServiceImpl, boolean z, int i);

    private static native boolean setLoadDataPriorityNative(long j, ILaneServiceImpl iLaneServiceImpl, int i);

    private static native boolean setOnlineTileLimitNative(long j, ILaneServiceImpl iLaneServiceImpl, int i, int i2);

    private static native boolean setResourceProxyNative(long j, ILaneServiceImpl iLaneServiceImpl, long j2, ILaneResourceProxyImpl iLaneResourceProxyImpl);

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
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
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

    public boolean setResourceProxy(ILaneResourceProxyImpl iLaneResourceProxyImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setResourceProxyNative(j, this, ILaneResourceProxyImpl.getCPtr(iLaneResourceProxyImpl), iLaneResourceProxyImpl);
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

    public ILaneRenderServiceImpl createLaneRenderService(LaneRenderParam laneRenderParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createLaneRenderServiceNative = createLaneRenderServiceNative(j, this, 0L, laneRenderParam);
        if (createLaneRenderServiceNative == 0) {
            return null;
        }
        return new ILaneRenderServiceImpl(createLaneRenderServiceNative, false);
    }

    public boolean destroyLaneRenderService(ILaneRenderServiceImpl iLaneRenderServiceImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return destroyLaneRenderServiceNative(j, this, ILaneRenderServiceImpl.getCPtr(iLaneRenderServiceImpl), iLaneRenderServiceImpl);
    }

    public ILaneRenderServiceImpl getLaneRenderService(@LaneRenderScreen.LaneRenderScreen1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long laneRenderServiceNative = getLaneRenderServiceNative(j, this, i);
        if (laneRenderServiceNative == 0) {
            return null;
        }
        return new ILaneRenderServiceImpl(laneRenderServiceNative, false);
    }

    public boolean openLNDSDataDownload(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openLNDSDataDownloadNative(j, this, z);
    }

    public boolean setLNDSDataLimit(boolean z, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLNDSDataLimitNative(j, this, z, i);
    }

    public boolean setLNDSDataLimit(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLNDSDataLimit1Native(j, this, z);
    }

    public boolean setOnlineTileLimit(@LaneTileType.LaneTileType1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setOnlineTileLimitNative(j, this, i, i2);
    }

    public boolean setLNDSAutoDownloadMode(@LaneLndsAutoDownloadMode.LaneLndsAutoDownloadMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLNDSAutoDownloadModeNative(j, this, i);
    }

    public boolean setLoadDataPriority(@LndsDataPriority.LndsDataPriority1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setLoadDataPriorityNative(j, this, i);
    }

    public boolean setAutopilotData(AutopilotData autopilotData) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setAutopilotDataNative(j, this, 0L, autopilotData);
    }

    public boolean setDriveMode(@LaneDriveMode.LaneDriveMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setDriveModeNative(j, this, i);
    }

    public ILaneNaviServiceImpl getLaneNaviService() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long laneNaviServiceNative = getLaneNaviServiceNative(j, this);
        if (laneNaviServiceNative == 0) {
            return null;
        }
        return new ILaneNaviServiceImpl(laneNaviServiceNative, false);
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

    public void addLaneDiagnosisObserver(ILaneDiagnosisObserverImpl iLaneDiagnosisObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addLaneDiagnosisObserverNative(j, this, ILaneDiagnosisObserverImpl.getCPtr(iLaneDiagnosisObserverImpl), iLaneDiagnosisObserverImpl);
    }

    public void removeLaneDiagnosisObserver(ILaneDiagnosisObserverImpl iLaneDiagnosisObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeLaneDiagnosisObserverNative(j, this, ILaneDiagnosisObserverImpl.getCPtr(iLaneDiagnosisObserverImpl), iLaneDiagnosisObserverImpl);
    }
}
