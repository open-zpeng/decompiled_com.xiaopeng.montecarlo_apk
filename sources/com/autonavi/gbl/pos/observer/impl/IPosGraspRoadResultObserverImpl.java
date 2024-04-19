package com.autonavi.gbl.pos.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.pos.model.GraspRoadResult;
import com.autonavi.gbl.pos.observer.IPosGraspRoadResultObserver;
@IntfAuto(target = IPosGraspRoadResultObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPosGraspRoadResultObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IPosGraspRoadResultObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IPosGraspRoadResultObserverImpl_change_ownership(IPosGraspRoadResultObserverImpl iPosGraspRoadResultObserverImpl, long j, boolean z);

    private static native void IPosGraspRoadResultObserverImpl_director_connect(IPosGraspRoadResultObserverImpl iPosGraspRoadResultObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGraspRoadResultNative(long j, IPosGraspRoadResultObserverImpl iPosGraspRoadResultObserverImpl, long j2, GraspRoadResult graspRoadResult);

    public IPosGraspRoadResultObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPosGraspRoadResultObserverImpl) && getUID(this) == getUID((IPosGraspRoadResultObserverImpl) obj);
    }

    private static long getUID(IPosGraspRoadResultObserverImpl iPosGraspRoadResultObserverImpl) {
        long cPtr = getCPtr(iPosGraspRoadResultObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPosGraspRoadResultObserverImpl iPosGraspRoadResultObserverImpl) {
        if (iPosGraspRoadResultObserverImpl == null) {
            return 0L;
        }
        return iPosGraspRoadResultObserverImpl.swigCPtr;
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
        IPosGraspRoadResultObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IPosGraspRoadResultObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onGraspRoadResult(GraspRoadResult graspRoadResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGraspRoadResultNative(j, this, 0L, graspRoadResult);
    }

    public IPosGraspRoadResultObserverImpl() {
        this(createNativeObj(), true);
        PosObserverJNI.swig_jni_init();
        IPosGraspRoadResultObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
