package com.autonavi.gbl.pos.replay.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.pos.model.LocSignData;
import com.autonavi.gbl.pos.replay.model.PosReplayStatus;
import com.autonavi.gbl.pos.replay.observer.IPosReplayObserver;
@IntfAuto(target = IPosReplayObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPosReplayObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IPosReplayObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IPosReplayObserverImpl_change_ownership(IPosReplayObserverImpl iPosReplayObserverImpl, long j, boolean z);

    private static native void IPosReplayObserverImpl_director_connect(IPosReplayObserverImpl iPosReplayObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGpsReplayStatusUpdateNative(long j, IPosReplayObserverImpl iPosReplayObserverImpl, int i);

    private static native void onLocSignDataUpdateNative(long j, IPosReplayObserverImpl iPosReplayObserverImpl, long j2, LocSignData locSignData);

    public IPosReplayObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPosReplayObserverImpl) && getUID(this) == getUID((IPosReplayObserverImpl) obj);
    }

    private static long getUID(IPosReplayObserverImpl iPosReplayObserverImpl) {
        long cPtr = getCPtr(iPosReplayObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPosReplayObserverImpl iPosReplayObserverImpl) {
        if (iPosReplayObserverImpl == null) {
            return 0L;
        }
        return iPosReplayObserverImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
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
        IPosReplayObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IPosReplayObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onLocSignDataUpdate(LocSignData locSignData) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onLocSignDataUpdateNative(j, this, 0L, locSignData);
    }

    public void onGpsReplayStatusUpdate(@PosReplayStatus.PosReplayStatus1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGpsReplayStatusUpdateNative(j, this, i);
    }

    public IPosReplayObserverImpl() {
        this(createNativeObj(), true);
        PosReplayObserverJNI.swig_jni_init();
        IPosReplayObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
