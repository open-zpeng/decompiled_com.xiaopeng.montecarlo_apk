package com.autonavi.gbl.pos.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.pos.model.LocParallelRoadInfo;
import com.autonavi.gbl.pos.observer.IPosParallelRoadObserver;
@IntfAuto(target = IPosParallelRoadObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPosParallelRoadObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IPosParallelRoadObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IPosParallelRoadObserverImpl_change_ownership(IPosParallelRoadObserverImpl iPosParallelRoadObserverImpl, long j, boolean z);

    private static native void IPosParallelRoadObserverImpl_director_connect(IPosParallelRoadObserverImpl iPosParallelRoadObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onParallelRoadUpdateNative(long j, IPosParallelRoadObserverImpl iPosParallelRoadObserverImpl, long j2, LocParallelRoadInfo locParallelRoadInfo);

    public IPosParallelRoadObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPosParallelRoadObserverImpl) && getUID(this) == getUID((IPosParallelRoadObserverImpl) obj);
    }

    private static long getUID(IPosParallelRoadObserverImpl iPosParallelRoadObserverImpl) {
        long cPtr = getCPtr(iPosParallelRoadObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPosParallelRoadObserverImpl iPosParallelRoadObserverImpl) {
        if (iPosParallelRoadObserverImpl == null) {
            return 0L;
        }
        return iPosParallelRoadObserverImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
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
        IPosParallelRoadObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IPosParallelRoadObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onParallelRoadUpdate(LocParallelRoadInfo locParallelRoadInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onParallelRoadUpdateNative(j, this, 0L, locParallelRoadInfo);
    }

    public IPosParallelRoadObserverImpl() {
        this(createNativeObj(), true);
        PosObserverJNI.swig_jni_init();
        IPosParallelRoadObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
