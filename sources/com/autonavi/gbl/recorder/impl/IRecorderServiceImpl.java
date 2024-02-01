package com.autonavi.gbl.recorder.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.recorder.RecorderService;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
@IntfAuto(target = RecorderService.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IRecorderServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IRecorderServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native long getPlayerNative(long j, IRecorderServiceImpl iRecorderServiceImpl);

    private static native long getRecorderNative(long j, IRecorderServiceImpl iRecorderServiceImpl);

    private static native String getVersionNative(long j, IRecorderServiceImpl iRecorderServiceImpl);

    private static native int isInitNative(long j, IRecorderServiceImpl iRecorderServiceImpl);

    private static native void logSwitchNative(long j, IRecorderServiceImpl iRecorderServiceImpl, int i);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IRecorderServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IRecorderServiceImpl) && getUID(this) == getUID((IRecorderServiceImpl) obj);
    }

    private static long getUID(IRecorderServiceImpl iRecorderServiceImpl) {
        long cPtr = getCPtr(iRecorderServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IRecorderServiceImpl iRecorderServiceImpl) {
        if (iRecorderServiceImpl == null) {
            return 0L;
        }
        return iRecorderServiceImpl.swigCPtr;
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

    public void logSwitch(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        logSwitchNative(j, this, i);
    }

    public IRecorderImpl getRecorder() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long recorderNative = getRecorderNative(j, this);
        if (recorderNative == 0) {
            return null;
        }
        return new IRecorderImpl(recorderNative, false);
    }

    public IPlayerImpl getPlayer() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long playerNative = getPlayerNative(j, this);
        if (playerNative == 0) {
            return null;
        }
        return new IPlayerImpl(playerNative, false);
    }
}
