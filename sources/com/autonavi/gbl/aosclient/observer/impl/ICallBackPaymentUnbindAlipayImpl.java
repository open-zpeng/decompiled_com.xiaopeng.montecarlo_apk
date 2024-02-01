package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GPaymentUnbindAlipayResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackPaymentUnbindAlipay;
@IntfAuto(target = ICallBackPaymentUnbindAlipay.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackPaymentUnbindAlipayImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackPaymentUnbindAlipayImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackPaymentUnbindAlipayImpl_change_ownership(ICallBackPaymentUnbindAlipayImpl iCallBackPaymentUnbindAlipayImpl, long j, boolean z);

    private static native void ICallBackPaymentUnbindAlipayImpl_director_connect(ICallBackPaymentUnbindAlipayImpl iCallBackPaymentUnbindAlipayImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackPaymentUnbindAlipayImpl iCallBackPaymentUnbindAlipayImpl, long j2, GPaymentUnbindAlipayResponseParam gPaymentUnbindAlipayResponseParam);

    public ICallBackPaymentUnbindAlipayImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackPaymentUnbindAlipayImpl) && getUID(this) == getUID((ICallBackPaymentUnbindAlipayImpl) obj);
    }

    private static long getUID(ICallBackPaymentUnbindAlipayImpl iCallBackPaymentUnbindAlipayImpl) {
        long cPtr = getCPtr(iCallBackPaymentUnbindAlipayImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackPaymentUnbindAlipayImpl iCallBackPaymentUnbindAlipayImpl) {
        if (iCallBackPaymentUnbindAlipayImpl == null) {
            return 0L;
        }
        return iCallBackPaymentUnbindAlipayImpl.swigCPtr;
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
        ICallBackPaymentUnbindAlipayImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackPaymentUnbindAlipayImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GPaymentUnbindAlipayResponseParam gPaymentUnbindAlipayResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gPaymentUnbindAlipayResponseParam);
    }

    public ICallBackPaymentUnbindAlipayImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackPaymentUnbindAlipayImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
