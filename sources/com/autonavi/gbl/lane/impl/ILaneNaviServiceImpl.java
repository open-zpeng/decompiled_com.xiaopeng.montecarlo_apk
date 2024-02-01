package com.autonavi.gbl.lane.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.LaneNaviService;
import com.autonavi.gbl.lane.model.LaneNaviParamType;
import com.autonavi.gbl.lane.observer.impl.ILaneDigitalTrackObserverImpl;
@IntfAuto(target = LaneNaviService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILaneNaviServiceImpl {
    private static BindTable BIND_TABLE = new BindTable(ILaneNaviServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addObserverNative(long j, ILaneNaviServiceImpl iLaneNaviServiceImpl, long j2, ILaneDigitalTrackObserverImpl iLaneDigitalTrackObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native boolean enterLaneNative(long j, ILaneNaviServiceImpl iLaneNaviServiceImpl, boolean z);

    private static native String getEngineVersionNative();

    private static native boolean openCalcRoadPolygonNative(long j, ILaneNaviServiceImpl iLaneNaviServiceImpl, boolean z);

    private static native boolean openLaneWorkNative(long j, ILaneNaviServiceImpl iLaneNaviServiceImpl, boolean z);

    private static native boolean openNaviLineNative(long j, ILaneNaviServiceImpl iLaneNaviServiceImpl, boolean z);

    private static native boolean openShowOccpyLaneNative(long j, ILaneNaviServiceImpl iLaneNaviServiceImpl, boolean z);

    private static native void removeObserverNative(long j, ILaneNaviServiceImpl iLaneNaviServiceImpl, long j2, ILaneDigitalTrackObserverImpl iLaneDigitalTrackObserverImpl);

    private static native boolean setOddShowNumNative(long j, ILaneNaviServiceImpl iLaneNaviServiceImpl, int i);

    private static native int setParamNative(long j, ILaneNaviServiceImpl iLaneNaviServiceImpl, int i, String str);

    private static native boolean setPersonNumNative(long j, ILaneNaviServiceImpl iLaneNaviServiceImpl, int i);

    public ILaneNaviServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILaneNaviServiceImpl) && getUID(this) == getUID((ILaneNaviServiceImpl) obj);
    }

    private static long getUID(ILaneNaviServiceImpl iLaneNaviServiceImpl) {
        long cPtr = getCPtr(iLaneNaviServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILaneNaviServiceImpl iLaneNaviServiceImpl) {
        if (iLaneNaviServiceImpl == null) {
            return 0L;
        }
        return iLaneNaviServiceImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
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

    public static String getEngineVersion() {
        return getEngineVersionNative();
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

    public boolean setPersonNum(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setPersonNumNative(j, this, i);
    }

    public boolean openCalcRoadPolygon(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return openCalcRoadPolygonNative(j, this, z);
    }

    public boolean setOddShowNum(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setOddShowNumNative(j, this, i);
    }

    public int setParam(@LaneNaviParamType.LaneNaviParamType1 int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setParamNative(j, this, i, str);
    }

    public void addObserver(ILaneDigitalTrackObserverImpl iLaneDigitalTrackObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addObserverNative(j, this, ILaneDigitalTrackObserverImpl.getCPtr(iLaneDigitalTrackObserverImpl), iLaneDigitalTrackObserverImpl);
    }

    public void removeObserver(ILaneDigitalTrackObserverImpl iLaneDigitalTrackObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeObserverNative(j, this, ILaneDigitalTrackObserverImpl.getCPtr(iLaneDigitalTrackObserverImpl), iLaneDigitalTrackObserverImpl);
    }
}
