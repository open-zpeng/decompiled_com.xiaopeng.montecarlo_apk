package com.autonavi.gbl.pos.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.pos.model.LocMMFeedbackInfo;
import com.autonavi.gbl.pos.observer.IPosMapMatchFeedbackObserver;
@IntfAuto(target = IPosMapMatchFeedbackObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPosMapMatchFeedbackObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IPosMapMatchFeedbackObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IPosMapMatchFeedbackObserverImpl_change_ownership(IPosMapMatchFeedbackObserverImpl iPosMapMatchFeedbackObserverImpl, long j, boolean z);

    private static native void IPosMapMatchFeedbackObserverImpl_director_connect(IPosMapMatchFeedbackObserverImpl iPosMapMatchFeedbackObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onMapMatchFeedbackUpdateNative(long j, IPosMapMatchFeedbackObserverImpl iPosMapMatchFeedbackObserverImpl, long j2, LocMMFeedbackInfo locMMFeedbackInfo);

    public IPosMapMatchFeedbackObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPosMapMatchFeedbackObserverImpl) && getUID(this) == getUID((IPosMapMatchFeedbackObserverImpl) obj);
    }

    private static long getUID(IPosMapMatchFeedbackObserverImpl iPosMapMatchFeedbackObserverImpl) {
        long cPtr = getCPtr(iPosMapMatchFeedbackObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPosMapMatchFeedbackObserverImpl iPosMapMatchFeedbackObserverImpl) {
        if (iPosMapMatchFeedbackObserverImpl == null) {
            return 0L;
        }
        return iPosMapMatchFeedbackObserverImpl.swigCPtr;
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
        IPosMapMatchFeedbackObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IPosMapMatchFeedbackObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onMapMatchFeedbackUpdate(LocMMFeedbackInfo locMMFeedbackInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onMapMatchFeedbackUpdateNative(j, this, 0L, locMMFeedbackInfo);
    }

    public IPosMapMatchFeedbackObserverImpl() {
        this(createNativeObj(), true);
        PosObserverJNI.swig_jni_init();
        IPosMapMatchFeedbackObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
