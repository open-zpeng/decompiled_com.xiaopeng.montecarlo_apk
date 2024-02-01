package com.autonavi.gbl.lane.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.LanePlayerMessage;
import com.autonavi.gbl.lane.observer.ILanePlayerAdapter;
@IntfAuto(target = ILanePlayerAdapter.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILanePlayerAdapterImpl {
    private static BindTable BIND_TABLE = new BindTable(ILanePlayerAdapterImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ILanePlayerAdapterImpl_change_ownership(ILanePlayerAdapterImpl iLanePlayerAdapterImpl, long j, boolean z);

    private static native void ILanePlayerAdapterImpl_director_connect(ILanePlayerAdapterImpl iLanePlayerAdapterImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean onLaneDataNative(long j, ILanePlayerAdapterImpl iLanePlayerAdapterImpl, long j2, LanePlayerMessage lanePlayerMessage);

    private static native boolean onLaneDataSwigExplicitILanePlayerAdapterImplNative(long j, ILanePlayerAdapterImpl iLanePlayerAdapterImpl, long j2, LanePlayerMessage lanePlayerMessage);

    public ILanePlayerAdapterImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILanePlayerAdapterImpl) && getUID(this) == getUID((ILanePlayerAdapterImpl) obj);
    }

    private static long getUID(ILanePlayerAdapterImpl iLanePlayerAdapterImpl) {
        long cPtr = getCPtr(iLanePlayerAdapterImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILanePlayerAdapterImpl iLanePlayerAdapterImpl) {
        if (iLanePlayerAdapterImpl == null) {
            return 0L;
        }
        return iLanePlayerAdapterImpl.swigCPtr;
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
        ILanePlayerAdapterImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ILanePlayerAdapterImpl_change_ownership(this, this.swigCPtr, true);
    }

    public boolean onLaneData(LanePlayerMessage lanePlayerMessage) {
        if (this.swigCPtr != 0) {
            return getClass() == ILanePlayerAdapterImpl.class ? onLaneDataNative(this.swigCPtr, this, 0L, lanePlayerMessage) : onLaneDataSwigExplicitILanePlayerAdapterImplNative(this.swigCPtr, this, 0L, lanePlayerMessage);
        }
        throw new NullPointerException();
    }

    public ILanePlayerAdapterImpl() {
        this(createNativeObj(), true);
        LaneObserverJNI.swig_jni_init();
        ILanePlayerAdapterImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
