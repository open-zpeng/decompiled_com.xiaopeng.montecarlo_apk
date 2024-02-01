package com.autonavi.gbl.lane.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.lane.LaneMockService;
import com.autonavi.gbl.lane.model.LaneChangeDirection;
import com.autonavi.gbl.lane.observer.impl.ILaneMockObserverImpl;
@IntfAuto(target = LaneMockService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILaneMockServiceImpl {
    private static BindTable BIND_TABLE = new BindTable(ILaneMockServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addLaneMockObserverNative(long j, ILaneMockServiceImpl iLaneMockServiceImpl, long j2, ILaneMockObserverImpl iLaneMockObserverImpl);

    private static native boolean changeLaneNative(long j, ILaneMockServiceImpl iLaneMockServiceImpl, int i);

    private static native void destroyNativeObj(long j);

    private static native void removeLaneMockObserverNative(long j, ILaneMockServiceImpl iLaneMockServiceImpl, long j2, ILaneMockObserverImpl iLaneMockObserverImpl);

    private static native void setNaviPathNative(long j, ILaneMockServiceImpl iLaneMockServiceImpl, long j2, PathInfo pathInfo);

    private static native boolean setPlaySpeedNative(long j, ILaneMockServiceImpl iLaneMockServiceImpl, float f);

    private static native void startNative(long j, ILaneMockServiceImpl iLaneMockServiceImpl);

    private static native void stopNative(long j, ILaneMockServiceImpl iLaneMockServiceImpl);

    public ILaneMockServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILaneMockServiceImpl) && getUID(this) == getUID((ILaneMockServiceImpl) obj);
    }

    private static long getUID(ILaneMockServiceImpl iLaneMockServiceImpl) {
        long cPtr = getCPtr(iLaneMockServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILaneMockServiceImpl iLaneMockServiceImpl) {
        if (iLaneMockServiceImpl == null) {
            return 0L;
        }
        return iLaneMockServiceImpl.swigCPtr;
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

    public void start() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        startNative(j, this);
    }

    public void stop() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        stopNative(j, this);
    }

    public void setNaviPath(PathInfo pathInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setNaviPathNative(j, this, PathInfo.getCPtr(pathInfo), pathInfo);
    }

    public boolean setPlaySpeed(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setPlaySpeedNative(j, this, f);
    }

    public boolean changeLane(@LaneChangeDirection.LaneChangeDirection1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return changeLaneNative(j, this, i);
    }

    public void addLaneMockObserver(ILaneMockObserverImpl iLaneMockObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addLaneMockObserverNative(j, this, ILaneMockObserverImpl.getCPtr(iLaneMockObserverImpl), iLaneMockObserverImpl);
    }

    public void removeLaneMockObserver(ILaneMockObserverImpl iLaneMockObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeLaneMockObserverNative(j, this, ILaneMockObserverImpl.getCPtr(iLaneMockObserverImpl), iLaneMockObserverImpl);
    }
}
