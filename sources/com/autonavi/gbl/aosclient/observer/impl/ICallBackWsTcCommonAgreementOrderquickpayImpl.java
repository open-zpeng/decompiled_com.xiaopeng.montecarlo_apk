package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcCommonAgreementOrderquickpayResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcCommonAgreementOrderquickpay;
@IntfAuto(target = ICallBackWsTcCommonAgreementOrderquickpay.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTcCommonAgreementOrderquickpayImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTcCommonAgreementOrderquickpayImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTcCommonAgreementOrderquickpayImpl_change_ownership(ICallBackWsTcCommonAgreementOrderquickpayImpl iCallBackWsTcCommonAgreementOrderquickpayImpl, long j, boolean z);

    private static native void ICallBackWsTcCommonAgreementOrderquickpayImpl_director_connect(ICallBackWsTcCommonAgreementOrderquickpayImpl iCallBackWsTcCommonAgreementOrderquickpayImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTcCommonAgreementOrderquickpayImpl iCallBackWsTcCommonAgreementOrderquickpayImpl, long j2, GWsTcCommonAgreementOrderquickpayResponseParam gWsTcCommonAgreementOrderquickpayResponseParam);

    public ICallBackWsTcCommonAgreementOrderquickpayImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTcCommonAgreementOrderquickpayImpl) && getUID(this) == getUID((ICallBackWsTcCommonAgreementOrderquickpayImpl) obj);
    }

    private static long getUID(ICallBackWsTcCommonAgreementOrderquickpayImpl iCallBackWsTcCommonAgreementOrderquickpayImpl) {
        long cPtr = getCPtr(iCallBackWsTcCommonAgreementOrderquickpayImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTcCommonAgreementOrderquickpayImpl iCallBackWsTcCommonAgreementOrderquickpayImpl) {
        if (iCallBackWsTcCommonAgreementOrderquickpayImpl == null) {
            return 0L;
        }
        return iCallBackWsTcCommonAgreementOrderquickpayImpl.swigCPtr;
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
        ICallBackWsTcCommonAgreementOrderquickpayImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTcCommonAgreementOrderquickpayImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTcCommonAgreementOrderquickpayResponseParam gWsTcCommonAgreementOrderquickpayResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTcCommonAgreementOrderquickpayResponseParam);
    }

    public ICallBackWsTcCommonAgreementOrderquickpayImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTcCommonAgreementOrderquickpayImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
