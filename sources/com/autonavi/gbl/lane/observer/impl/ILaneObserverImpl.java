package com.autonavi.gbl.lane.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.lane.model.AnchorScaleTime;
import com.autonavi.gbl.lane.model.LaneNaviStatus;
import com.autonavi.gbl.lane.model.LanePositionStatus;
import com.autonavi.gbl.lane.observer.ILaneObserver;
@IntfAuto(target = ILaneObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILaneObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ILaneObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ILaneObserverImpl_change_ownership(ILaneObserverImpl iLaneObserverImpl, long j, boolean z);

    private static native void ILaneObserverImpl_director_connect(ILaneObserverImpl iLaneObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onAnchorScaleChangeNative(long j, ILaneObserverImpl iLaneObserverImpl, int i);

    private static native void onLaneLndsDataDistanceNative(long j, ILaneObserverImpl iLaneObserverImpl, float f);

    private static native void onLaneNaviEnterPointDistanceNative(long j, ILaneObserverImpl iLaneObserverImpl, float f);

    private static native void onLaneNaviStatusNative(long j, ILaneObserverImpl iLaneObserverImpl, int i);

    private static native void onLanePositionStatusNative(long j, ILaneObserverImpl iLaneObserverImpl, int i);

    public ILaneObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILaneObserverImpl) && getUID(this) == getUID((ILaneObserverImpl) obj);
    }

    private static long getUID(ILaneObserverImpl iLaneObserverImpl) {
        long cPtr = getCPtr(iLaneObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILaneObserverImpl iLaneObserverImpl) {
        if (iLaneObserverImpl == null) {
            return 0L;
        }
        return iLaneObserverImpl.swigCPtr;
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
        ILaneObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ILaneObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onAnchorScaleChange(@AnchorScaleTime.AnchorScaleTime1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onAnchorScaleChangeNative(j, this, i);
    }

    public void onLanePositionStatus(@LanePositionStatus.LanePositionStatus1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onLanePositionStatusNative(j, this, i);
    }

    public void onLaneNaviStatus(@LaneNaviStatus.LaneNaviStatus1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onLaneNaviStatusNative(j, this, i);
    }

    public void onLaneNaviEnterPointDistance(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onLaneNaviEnterPointDistanceNative(j, this, f);
    }

    public void onLaneLndsDataDistance(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onLaneLndsDataDistanceNative(j, this, f);
    }

    public ILaneObserverImpl() {
        this(createNativeObj(), true);
        LaneObserverJNI.swig_jni_init();
        ILaneObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
