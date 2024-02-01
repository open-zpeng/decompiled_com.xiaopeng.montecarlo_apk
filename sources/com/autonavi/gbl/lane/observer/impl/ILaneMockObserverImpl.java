package com.autonavi.gbl.lane.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.observer.ILaneMockObserver;
@IntfAuto(target = ILaneMockObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILaneMockObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ILaneMockObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ILaneMockObserverImpl_change_ownership(ILaneMockObserverImpl iLaneMockObserverImpl, long j, boolean z);

    private static native void ILaneMockObserverImpl_director_connect(ILaneMockObserverImpl iLaneMockObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onLaneMockFinishNative(long j, ILaneMockObserverImpl iLaneMockObserverImpl);

    public ILaneMockObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILaneMockObserverImpl) && getUID(this) == getUID((ILaneMockObserverImpl) obj);
    }

    private static long getUID(ILaneMockObserverImpl iLaneMockObserverImpl) {
        long cPtr = getCPtr(iLaneMockObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILaneMockObserverImpl iLaneMockObserverImpl) {
        if (iLaneMockObserverImpl == null) {
            return 0L;
        }
        return iLaneMockObserverImpl.swigCPtr;
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
        ILaneMockObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ILaneMockObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onLaneMockFinish() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onLaneMockFinishNative(j, this);
    }

    public ILaneMockObserverImpl() {
        this(createNativeObj(), true);
        LaneObserverJNI.swig_jni_init();
        ILaneMockObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
