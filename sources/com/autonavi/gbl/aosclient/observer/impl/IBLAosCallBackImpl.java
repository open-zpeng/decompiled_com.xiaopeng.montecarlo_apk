package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.BLResponseBase;
import com.autonavi.gbl.aosclient.observer.IBLAosCallBack;
@IntfAuto(target = IBLAosCallBack.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IBLAosCallBackImpl {
    private static BindTable BIND_TABLE = new BindTable(IBLAosCallBackImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IBLAosCallBackImpl_change_ownership(IBLAosCallBackImpl iBLAosCallBackImpl, long j, boolean z);

    private static native void IBLAosCallBackImpl_director_connect(IBLAosCallBackImpl iBLAosCallBackImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvResponseNative(long j, IBLAosCallBackImpl iBLAosCallBackImpl, long j2, BLResponseBase bLResponseBase);

    public IBLAosCallBackImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBLAosCallBackImpl) && getUID(this) == getUID((IBLAosCallBackImpl) obj);
    }

    private static long getUID(IBLAosCallBackImpl iBLAosCallBackImpl) {
        long cPtr = getCPtr(iBLAosCallBackImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBLAosCallBackImpl iBLAosCallBackImpl) {
        if (iBLAosCallBackImpl == null) {
            return 0L;
        }
        return iBLAosCallBackImpl.swigCPtr;
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
        IBLAosCallBackImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IBLAosCallBackImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvResponse(BLResponseBase bLResponseBase) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvResponseNative(j, this, 0L, bLResponseBase);
    }

    public IBLAosCallBackImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        IBLAosCallBackImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
