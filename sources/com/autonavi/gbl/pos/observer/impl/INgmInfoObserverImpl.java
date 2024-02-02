package com.autonavi.gbl.pos.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.pos.model.NgmDiff;
import com.autonavi.gbl.pos.observer.INgmInfoObserver;
@IntfAuto(target = INgmInfoObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class INgmInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(INgmInfoObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void INgmInfoObserverImpl_change_ownership(INgmInfoObserverImpl iNgmInfoObserverImpl, long j, boolean z);

    private static native void INgmInfoObserverImpl_director_connect(INgmInfoObserverImpl iNgmInfoObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onNgmInfoUpdateNative(long j, INgmInfoObserverImpl iNgmInfoObserverImpl, long j2, NgmDiff ngmDiff);

    public INgmInfoObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof INgmInfoObserverImpl) && getUID(this) == getUID((INgmInfoObserverImpl) obj);
    }

    private static long getUID(INgmInfoObserverImpl iNgmInfoObserverImpl) {
        long cPtr = getCPtr(iNgmInfoObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(INgmInfoObserverImpl iNgmInfoObserverImpl) {
        if (iNgmInfoObserverImpl == null) {
            return 0L;
        }
        return iNgmInfoObserverImpl.swigCPtr;
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
        INgmInfoObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        INgmInfoObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onNgmInfoUpdate(NgmDiff ngmDiff) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onNgmInfoUpdateNative(j, this, 0L, ngmDiff);
    }

    public INgmInfoObserverImpl() {
        this(createNativeObj(), true);
        PosObserverJNI.swig_jni_init();
        INgmInfoObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
