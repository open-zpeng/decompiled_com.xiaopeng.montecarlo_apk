package com.autonavi.gbl.data.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.MergedStatusInfo;
import com.autonavi.gbl.data.observer.IMergedStatusInfoObserver;
@IntfAuto(target = IMergedStatusInfoObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IMergedStatusInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IMergedStatusInfoObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IMergedStatusInfoObserverImpl_change_ownership(IMergedStatusInfoObserverImpl iMergedStatusInfoObserverImpl, long j, boolean z);

    private static native void IMergedStatusInfoObserverImpl_director_connect(IMergedStatusInfoObserverImpl iMergedStatusInfoObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onMergedStatusInfoNative(long j, IMergedStatusInfoObserverImpl iMergedStatusInfoObserverImpl, long j2, MergedStatusInfo mergedStatusInfo);

    public IMergedStatusInfoObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMergedStatusInfoObserverImpl) && getUID(this) == getUID((IMergedStatusInfoObserverImpl) obj);
    }

    private static long getUID(IMergedStatusInfoObserverImpl iMergedStatusInfoObserverImpl) {
        long cPtr = getCPtr(iMergedStatusInfoObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMergedStatusInfoObserverImpl iMergedStatusInfoObserverImpl) {
        if (iMergedStatusInfoObserverImpl == null) {
            return 0L;
        }
        return iMergedStatusInfoObserverImpl.swigCPtr;
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
        IMergedStatusInfoObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IMergedStatusInfoObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onMergedStatusInfo(MergedStatusInfo mergedStatusInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onMergedStatusInfoNative(j, this, 0L, mergedStatusInfo);
    }

    public IMergedStatusInfoObserverImpl() {
        this(createNativeObj(), true);
        DataObserverJNI.swig_jni_init();
        IMergedStatusInfoObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
