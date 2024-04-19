package com.autonavi.gbl.pos.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.observer.impl.IThreadObserverImpl;
import com.autonavi.gbl.pos.PosService;
import com.autonavi.gbl.pos.model.EUserDevInfo;
import com.autonavi.gbl.pos.model.EventTrackHistory;
import com.autonavi.gbl.pos.model.LocGPSHistory;
import com.autonavi.gbl.pos.model.LocLogConf;
import com.autonavi.gbl.pos.model.LocModeType;
import com.autonavi.gbl.pos.model.LocSignData;
import com.autonavi.gbl.pos.model.LocSwitchRoadType;
import com.autonavi.gbl.pos.model.PosVersion;
import com.autonavi.gbl.pos.model.PosWorkPath;
import com.autonavi.gbl.pos.observer.impl.INgmInfoObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosAttitudeAngleObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosDrInfoObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosGraspRoadResultObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosLocInfoObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosMapMatchFeedbackObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosParallelRoadObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosSensorParaObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosSignInfoObserverImpl;
import com.autonavi.gbl.pos.observer.impl.IPosSwitchParallelRoadObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ErrorCode;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.math.BigInteger;
@IntfAuto(target = PosService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPosServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IPosServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addAttitudeAngleObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosAttitudeAngleObserverImpl iPosAttitudeAngleObserverImpl);

    private static native void addGraspRoadResultObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosGraspRoadResultObserverImpl iPosGraspRoadResultObserverImpl);

    private static native void addLocInfoObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosLocInfoObserverImpl iPosLocInfoObserverImpl, int i);

    private static native void addMapMatchFeedbackObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosMapMatchFeedbackObserverImpl iPosMapMatchFeedbackObserverImpl);

    private static native void addNgmInfoObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, INgmInfoObserverImpl iNgmInfoObserverImpl);

    private static native void addParallelRoadObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosParallelRoadObserverImpl iPosParallelRoadObserverImpl);

    private static native void addPosDrInfoObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosDrInfoObserverImpl iPosDrInfoObserverImpl);

    private static native void addSensorParaObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosSensorParaObserverImpl iPosSensorParaObserverImpl);

    private static native void addSignInfoObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosSignInfoObserverImpl iPosSignInfoObserverImpl);

    private static native void addSwitchParallelRoadObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosSwitchParallelRoadObserverImpl iPosSwitchParallelRoadObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native void encryptLonLatNative(long j, Coord3DDouble coord3DDouble, long j2, Coord3DDouble coord3DDouble2);

    private static native String getDebugInfoNative(long j, IPosServiceImpl iPosServiceImpl, int i);

    private static native String getEngineVersionNative();

    private static native boolean getGPSHistoryNative(long j, IPosServiceImpl iPosServiceImpl, long j2, LocGPSHistory locGPSHistory);

    private static native int initNative(long j, IPosServiceImpl iPosServiceImpl, long j2, PosWorkPath posWorkPath, long j3, LocModeType locModeType, long j4, IThreadObserverImpl iThreadObserverImpl);

    private static native int isInitNative(long j, IPosServiceImpl iPosServiceImpl);

    private static native int regenerateLocStorageFromOldVersionNative(String str, String str2, int i);

    private static native void removeAttitudeAngleObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosAttitudeAngleObserverImpl iPosAttitudeAngleObserverImpl);

    private static native void removeGraspRoadResultObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosGraspRoadResultObserverImpl iPosGraspRoadResultObserverImpl);

    private static native void removeLocInfoObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosLocInfoObserverImpl iPosLocInfoObserverImpl);

    private static native void removeMapMatchFeedbackObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosMapMatchFeedbackObserverImpl iPosMapMatchFeedbackObserverImpl);

    private static native void removeNgmInfoObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, INgmInfoObserverImpl iNgmInfoObserverImpl);

    private static native void removeParallelRoadObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosParallelRoadObserverImpl iPosParallelRoadObserverImpl);

    private static native void removePosDrInfoObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosDrInfoObserverImpl iPosDrInfoObserverImpl);

    private static native void removeSensorParaObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosSensorParaObserverImpl iPosSensorParaObserverImpl);

    private static native void removeSignInfoObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosSignInfoObserverImpl iPosSignInfoObserverImpl);

    private static native void removeSwitchParallelRoadObserverNative(long j, IPosServiceImpl iPosServiceImpl, long j2, IPosSwitchParallelRoadObserverImpl iPosSwitchParallelRoadObserverImpl);

    private static native boolean requestCallBackPosNative(long j, IPosServiceImpl iPosServiceImpl, int i);

    private static native void saveLocStorageNative(long j, IPosServiceImpl iPosServiceImpl);

    private static native void setContextPosNative(long j, IPosServiceImpl iPosServiceImpl, long j2, Coord3DDouble coord3DDouble, float f);

    private static native void setDefaultPosNative(long j, IPosServiceImpl iPosServiceImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void setEventTrackHistoryNative(long j, IPosServiceImpl iPosServiceImpl, long j2, EventTrackHistory eventTrackHistory);

    private static native void setHDLaneMockRangeNative(long j, IPosServiceImpl iPosServiceImpl, double d);

    private static native void setIssueSubmitInfoNative(long j, IPosServiceImpl iPosServiceImpl, String str);

    private static native void setLaneRes4DebugNative(long j, IPosServiceImpl iPosServiceImpl, boolean z, int i, int i2, int i3);

    private static native void setLaneSwitchNative(long j, IPosServiceImpl iPosServiceImpl, boolean z);

    private static native void setOverheadSwitchNative(long j, IPosServiceImpl iPosServiceImpl, boolean z);

    private static native void setSignInfoNative(long j, IPosServiceImpl iPosServiceImpl, long j2, LocSignData locSignData);

    private static native void setUserDevInfoNative(long j, IPosServiceImpl iPosServiceImpl, int i, String str);

    private static native void setViaductRecognizeSwitchNative(long j, IPosServiceImpl iPosServiceImpl, boolean z);

    private static native void signalRecordSwitchNative(long j, IPosServiceImpl iPosServiceImpl, boolean z, long j2, LocLogConf locLogConf);

    private static native void switchParallelRoadNative(long j, IPosServiceImpl iPosServiceImpl, int i, BigInteger bigInteger);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IPosServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPosServiceImpl) && getUID(this) == getUID((IPosServiceImpl) obj);
    }

    private static long getUID(IPosServiceImpl iPosServiceImpl) {
        long cPtr = getCPtr(iPosServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPosServiceImpl iPosServiceImpl) {
        if (iPosServiceImpl == null) {
            return 0L;
        }
        return iPosServiceImpl.swigCPtr;
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

    public static Coord3DDouble encryptLonLat(Coord3DDouble coord3DDouble) {
        Coord3DDouble coord3DDouble2 = new Coord3DDouble();
        encryptLonLat(coord3DDouble, coord3DDouble2);
        return coord3DDouble2;
    }

    public LocGPSHistory getGPSHistory() {
        LocGPSHistory locGPSHistory = new LocGPSHistory();
        if (getGPSHistory(locGPSHistory)) {
            return locGPSHistory;
        }
        return null;
    }

    public static String getEngineVersion() {
        return getEngineVersionNative();
    }

    public static int regenerateLocStorageFromOldVersion(String str, String str2, @PosVersion.PosVersion1 int i) {
        return regenerateLocStorageFromOldVersionNative(str, str2, i);
    }

    @ErrorCode.ErrorCode1
    public int init(PosWorkPath posWorkPath, LocModeType locModeType, IThreadObserverImpl iThreadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, posWorkPath, 0L, locModeType, IThreadObserverImpl.getCPtr(iThreadObserverImpl), iThreadObserverImpl);
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

    public void setSignInfo(LocSignData locSignData) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setSignInfoNative(j, this, 0L, locSignData);
    }

    public void switchParallelRoad(@LocSwitchRoadType.LocSwitchRoadType1 int i, BigInteger bigInteger) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        switchParallelRoadNative(j, this, i, bigInteger);
    }

    public void saveLocStorage() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        saveLocStorageNative(j, this);
    }

    public void signalRecordSwitch(boolean z, LocLogConf locLogConf) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        signalRecordSwitchNative(j, this, z, 0L, locLogConf);
    }

    public boolean requestCallBackPos(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestCallBackPosNative(j, this, i);
    }

    public void setDefaultPos(Coord3DDouble coord3DDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setDefaultPosNative(j, this, 0L, coord3DDouble);
    }

    public void setContextPos(Coord3DDouble coord3DDouble, float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setContextPosNative(j, this, 0L, coord3DDouble, f);
    }

    public void setIssueSubmitInfo(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setIssueSubmitInfoNative(j, this, str);
    }

    private static void encryptLonLat(Coord3DDouble coord3DDouble, Coord3DDouble coord3DDouble2) {
        encryptLonLatNative(0L, coord3DDouble, 0L, coord3DDouble2);
    }

    public void addLocInfoObserver(IPosLocInfoObserverImpl iPosLocInfoObserverImpl, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addLocInfoObserverNative(j, this, IPosLocInfoObserverImpl.getCPtr(iPosLocInfoObserverImpl), iPosLocInfoObserverImpl, i);
    }

    public void removeLocInfoObserver(IPosLocInfoObserverImpl iPosLocInfoObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeLocInfoObserverNative(j, this, IPosLocInfoObserverImpl.getCPtr(iPosLocInfoObserverImpl), iPosLocInfoObserverImpl);
    }

    public void addParallelRoadObserver(IPosParallelRoadObserverImpl iPosParallelRoadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addParallelRoadObserverNative(j, this, IPosParallelRoadObserverImpl.getCPtr(iPosParallelRoadObserverImpl), iPosParallelRoadObserverImpl);
    }

    public void removeParallelRoadObserver(IPosParallelRoadObserverImpl iPosParallelRoadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeParallelRoadObserverNative(j, this, IPosParallelRoadObserverImpl.getCPtr(iPosParallelRoadObserverImpl), iPosParallelRoadObserverImpl);
    }

    public void addSwitchParallelRoadObserver(IPosSwitchParallelRoadObserverImpl iPosSwitchParallelRoadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addSwitchParallelRoadObserverNative(j, this, IPosSwitchParallelRoadObserverImpl.getCPtr(iPosSwitchParallelRoadObserverImpl), iPosSwitchParallelRoadObserverImpl);
    }

    public void removeSwitchParallelRoadObserver(IPosSwitchParallelRoadObserverImpl iPosSwitchParallelRoadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeSwitchParallelRoadObserverNative(j, this, IPosSwitchParallelRoadObserverImpl.getCPtr(iPosSwitchParallelRoadObserverImpl), iPosSwitchParallelRoadObserverImpl);
    }

    public void addSignInfoObserver(IPosSignInfoObserverImpl iPosSignInfoObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addSignInfoObserverNative(j, this, IPosSignInfoObserverImpl.getCPtr(iPosSignInfoObserverImpl), iPosSignInfoObserverImpl);
    }

    public void removeSignInfoObserver(IPosSignInfoObserverImpl iPosSignInfoObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeSignInfoObserverNative(j, this, IPosSignInfoObserverImpl.getCPtr(iPosSignInfoObserverImpl), iPosSignInfoObserverImpl);
    }

    public void addMapMatchFeedbackObserver(IPosMapMatchFeedbackObserverImpl iPosMapMatchFeedbackObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addMapMatchFeedbackObserverNative(j, this, IPosMapMatchFeedbackObserverImpl.getCPtr(iPosMapMatchFeedbackObserverImpl), iPosMapMatchFeedbackObserverImpl);
    }

    public void removeMapMatchFeedbackObserver(IPosMapMatchFeedbackObserverImpl iPosMapMatchFeedbackObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeMapMatchFeedbackObserverNative(j, this, IPosMapMatchFeedbackObserverImpl.getCPtr(iPosMapMatchFeedbackObserverImpl), iPosMapMatchFeedbackObserverImpl);
    }

    public void addNgmInfoObserver(INgmInfoObserverImpl iNgmInfoObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addNgmInfoObserverNative(j, this, INgmInfoObserverImpl.getCPtr(iNgmInfoObserverImpl), iNgmInfoObserverImpl);
    }

    public void removeNgmInfoObserver(INgmInfoObserverImpl iNgmInfoObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeNgmInfoObserverNative(j, this, INgmInfoObserverImpl.getCPtr(iNgmInfoObserverImpl), iNgmInfoObserverImpl);
    }

    public void addSensorParaObserver(IPosSensorParaObserverImpl iPosSensorParaObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addSensorParaObserverNative(j, this, IPosSensorParaObserverImpl.getCPtr(iPosSensorParaObserverImpl), iPosSensorParaObserverImpl);
    }

    public void removeSensorParaObserver(IPosSensorParaObserverImpl iPosSensorParaObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeSensorParaObserverNative(j, this, IPosSensorParaObserverImpl.getCPtr(iPosSensorParaObserverImpl), iPosSensorParaObserverImpl);
    }

    public void addPosDrInfoObserver(IPosDrInfoObserverImpl iPosDrInfoObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addPosDrInfoObserverNative(j, this, IPosDrInfoObserverImpl.getCPtr(iPosDrInfoObserverImpl), iPosDrInfoObserverImpl);
    }

    public void removePosDrInfoObserver(IPosDrInfoObserverImpl iPosDrInfoObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removePosDrInfoObserverNative(j, this, IPosDrInfoObserverImpl.getCPtr(iPosDrInfoObserverImpl), iPosDrInfoObserverImpl);
    }

    public void addAttitudeAngleObserver(IPosAttitudeAngleObserverImpl iPosAttitudeAngleObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addAttitudeAngleObserverNative(j, this, IPosAttitudeAngleObserverImpl.getCPtr(iPosAttitudeAngleObserverImpl), iPosAttitudeAngleObserverImpl);
    }

    public void removeAttitudeAngleObserver(IPosAttitudeAngleObserverImpl iPosAttitudeAngleObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeAttitudeAngleObserverNative(j, this, IPosAttitudeAngleObserverImpl.getCPtr(iPosAttitudeAngleObserverImpl), iPosAttitudeAngleObserverImpl);
    }

    public void addGraspRoadResultObserver(IPosGraspRoadResultObserverImpl iPosGraspRoadResultObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addGraspRoadResultObserverNative(j, this, IPosGraspRoadResultObserverImpl.getCPtr(iPosGraspRoadResultObserverImpl), iPosGraspRoadResultObserverImpl);
    }

    public void removeGraspRoadResultObserver(IPosGraspRoadResultObserverImpl iPosGraspRoadResultObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeGraspRoadResultObserverNative(j, this, IPosGraspRoadResultObserverImpl.getCPtr(iPosGraspRoadResultObserverImpl), iPosGraspRoadResultObserverImpl);
    }

    public String getDebugInfo(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDebugInfoNative(j, this, i);
    }

    public void setOverheadSwitch(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setOverheadSwitchNative(j, this, z);
    }

    public void setViaductRecognizeSwitch(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setViaductRecognizeSwitchNative(j, this, z);
    }

    public void setUserDevInfo(@EUserDevInfo.EUserDevInfo1 int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setUserDevInfoNative(j, this, i, str);
    }

    private boolean getGPSHistory(LocGPSHistory locGPSHistory) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getGPSHistoryNative(j, this, 0L, locGPSHistory);
    }

    public void setLaneSwitch(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setLaneSwitchNative(j, this, z);
    }

    public void setLaneRes4Debug(boolean z, int i, int i2, int i3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setLaneRes4DebugNative(j, this, z, i, i2, i3);
    }

    public void setEventTrackHistory(EventTrackHistory eventTrackHistory) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setEventTrackHistoryNative(j, this, 0L, eventTrackHistory);
    }

    public void setHDLaneMockRange(double d) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setHDLaneMockRangeNative(j, this, d);
    }
}
