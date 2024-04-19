package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GCouponrecvapplyResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackCouponrecvapply;
@IntfAuto(target = ICallBackCouponrecvapply.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackCouponrecvapplyImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackCouponrecvapplyImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackCouponrecvapplyImpl_change_ownership(ICallBackCouponrecvapplyImpl iCallBackCouponrecvapplyImpl, long j, boolean z);

    private static native void ICallBackCouponrecvapplyImpl_director_connect(ICallBackCouponrecvapplyImpl iCallBackCouponrecvapplyImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackCouponrecvapplyImpl iCallBackCouponrecvapplyImpl, long j2, GCouponrecvapplyResponseParam gCouponrecvapplyResponseParam);

    public ICallBackCouponrecvapplyImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackCouponrecvapplyImpl) && getUID(this) == getUID((ICallBackCouponrecvapplyImpl) obj);
    }

    private static long getUID(ICallBackCouponrecvapplyImpl iCallBackCouponrecvapplyImpl) {
        long cPtr = getCPtr(iCallBackCouponrecvapplyImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackCouponrecvapplyImpl iCallBackCouponrecvapplyImpl) {
        if (iCallBackCouponrecvapplyImpl == null) {
            return 0L;
        }
        return iCallBackCouponrecvapplyImpl.swigCPtr;
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
        ICallBackCouponrecvapplyImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackCouponrecvapplyImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GCouponrecvapplyResponseParam gCouponrecvapplyResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gCouponrecvapplyResponseParam);
    }

    public ICallBackCouponrecvapplyImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackCouponrecvapplyImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
