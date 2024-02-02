package com.autonavi.gbl.pos.replay.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.pos.impl.IPosServiceImpl;
import com.autonavi.gbl.pos.replay.PosReplayService;
import com.autonavi.gbl.pos.replay.observer.impl.IPosReplayObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
@IntfAuto(target = PosReplayService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPosReplayServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IPosReplayServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addPosReplayObserverNative(long j, IPosReplayServiceImpl iPosReplayServiceImpl, long j2, IPosReplayObserverImpl iPosReplayObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native int isInitNative(long j, IPosReplayServiceImpl iPosReplayServiceImpl);

    private static native void pauseNative(long j, IPosReplayServiceImpl iPosReplayServiceImpl);

    private static native void removePosReplayObserverNative(long j, IPosReplayServiceImpl iPosReplayServiceImpl, long j2, IPosReplayObserverImpl iPosReplayObserverImpl);

    private static native void resumeNative(long j, IPosReplayServiceImpl iPosReplayServiceImpl);

    private static native void setLocPathNative(long j, IPosReplayServiceImpl iPosReplayServiceImpl, String str);

    private static native void setPosServiceNative(long j, IPosReplayServiceImpl iPosReplayServiceImpl, long j2, IPosServiceImpl iPosServiceImpl);

    private static native void setReplaySpeedTimeNative(long j, IPosReplayServiceImpl iPosReplayServiceImpl, long j2);

    private static native void startNative(long j, IPosReplayServiceImpl iPosReplayServiceImpl);

    private static native void stopNative(long j, IPosReplayServiceImpl iPosReplayServiceImpl);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IPosReplayServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPosReplayServiceImpl) && getUID(this) == getUID((IPosReplayServiceImpl) obj);
    }

    private static long getUID(IPosReplayServiceImpl iPosReplayServiceImpl) {
        long cPtr = getCPtr(iPosReplayServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPosReplayServiceImpl iPosReplayServiceImpl) {
        if (iPosReplayServiceImpl == null) {
            return 0L;
        }
        return iPosReplayServiceImpl.swigCPtr;
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

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInitNative(j, this);
    }

    public void setPosService(IPosServiceImpl iPosServiceImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPosServiceNative(j, this, IPosServiceImpl.getCPtr(iPosServiceImpl), iPosServiceImpl);
    }

    public void setLocPath(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setLocPathNative(j, this, str);
    }

    public void setReplaySpeedTime(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setReplaySpeedTimeNative(j2, this, j);
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

    public void pause() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        pauseNative(j, this);
    }

    public void resume() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resumeNative(j, this);
    }

    public void addPosReplayObserver(IPosReplayObserverImpl iPosReplayObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addPosReplayObserverNative(j, this, IPosReplayObserverImpl.getCPtr(iPosReplayObserverImpl), iPosReplayObserverImpl);
    }

    public void removePosReplayObserver(IPosReplayObserverImpl iPosReplayObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removePosReplayObserverNative(j, this, IPosReplayObserverImpl.getCPtr(iPosReplayObserverImpl), iPosReplayObserverImpl);
    }
}
