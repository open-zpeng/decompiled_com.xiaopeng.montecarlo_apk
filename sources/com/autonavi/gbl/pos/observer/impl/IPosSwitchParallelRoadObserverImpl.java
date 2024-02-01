package com.autonavi.gbl.pos.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.pos.observer.IPosSwitchParallelRoadObserver;
@IntfAuto(target = IPosSwitchParallelRoadObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPosSwitchParallelRoadObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IPosSwitchParallelRoadObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IPosSwitchParallelRoadObserverImpl_change_ownership(IPosSwitchParallelRoadObserverImpl iPosSwitchParallelRoadObserverImpl, long j, boolean z);

    private static native void IPosSwitchParallelRoadObserverImpl_director_connect(IPosSwitchParallelRoadObserverImpl iPosSwitchParallelRoadObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onSwitchParallelRoadFinishedNative(long j, IPosSwitchParallelRoadObserverImpl iPosSwitchParallelRoadObserverImpl);

    public IPosSwitchParallelRoadObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPosSwitchParallelRoadObserverImpl) && getUID(this) == getUID((IPosSwitchParallelRoadObserverImpl) obj);
    }

    private static long getUID(IPosSwitchParallelRoadObserverImpl iPosSwitchParallelRoadObserverImpl) {
        long cPtr = getCPtr(iPosSwitchParallelRoadObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPosSwitchParallelRoadObserverImpl iPosSwitchParallelRoadObserverImpl) {
        if (iPosSwitchParallelRoadObserverImpl == null) {
            return 0L;
        }
        return iPosSwitchParallelRoadObserverImpl.swigCPtr;
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
        IPosSwitchParallelRoadObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IPosSwitchParallelRoadObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onSwitchParallelRoadFinished() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onSwitchParallelRoadFinishedNative(j, this);
    }

    public IPosSwitchParallelRoadObserverImpl() {
        this(createNativeObj(), true);
        PosObserverJNI.swig_jni_init();
        IPosSwitchParallelRoadObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
