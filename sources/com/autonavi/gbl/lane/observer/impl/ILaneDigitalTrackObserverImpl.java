package com.autonavi.gbl.lane.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.observer.ILaneDigitalTrackObserver;
import com.autonavi.gbl.util.model.BinaryStream;
@IntfAuto(target = ILaneDigitalTrackObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILaneDigitalTrackObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ILaneDigitalTrackObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ILaneDigitalTrackObserverImpl_change_ownership(ILaneDigitalTrackObserverImpl iLaneDigitalTrackObserverImpl, long j, boolean z);

    private static native void ILaneDigitalTrackObserverImpl_director_connect(ILaneDigitalTrackObserverImpl iLaneDigitalTrackObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onUpdateDigitalTrackNative(long j, ILaneDigitalTrackObserverImpl iLaneDigitalTrackObserverImpl, long j2, BinaryStream binaryStream);

    public ILaneDigitalTrackObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILaneDigitalTrackObserverImpl) && getUID(this) == getUID((ILaneDigitalTrackObserverImpl) obj);
    }

    private static long getUID(ILaneDigitalTrackObserverImpl iLaneDigitalTrackObserverImpl) {
        long cPtr = getCPtr(iLaneDigitalTrackObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILaneDigitalTrackObserverImpl iLaneDigitalTrackObserverImpl) {
        if (iLaneDigitalTrackObserverImpl == null) {
            return 0L;
        }
        return iLaneDigitalTrackObserverImpl.swigCPtr;
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
        ILaneDigitalTrackObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ILaneDigitalTrackObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onUpdateDigitalTrack(BinaryStream binaryStream) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateDigitalTrackNative(j, this, 0L, binaryStream);
    }

    public ILaneDigitalTrackObserverImpl() {
        this(createNativeObj(), true);
        LaneObserverJNI.swig_jni_init();
        ILaneDigitalTrackObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
