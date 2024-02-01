package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcCommonAgreementSignResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcCommonAgreementSign;
@IntfAuto(target = ICallBackWsTcCommonAgreementSign.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTcCommonAgreementSignImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTcCommonAgreementSignImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTcCommonAgreementSignImpl_change_ownership(ICallBackWsTcCommonAgreementSignImpl iCallBackWsTcCommonAgreementSignImpl, long j, boolean z);

    private static native void ICallBackWsTcCommonAgreementSignImpl_director_connect(ICallBackWsTcCommonAgreementSignImpl iCallBackWsTcCommonAgreementSignImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTcCommonAgreementSignImpl iCallBackWsTcCommonAgreementSignImpl, long j2, GWsTcCommonAgreementSignResponseParam gWsTcCommonAgreementSignResponseParam);

    public ICallBackWsTcCommonAgreementSignImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTcCommonAgreementSignImpl) && getUID(this) == getUID((ICallBackWsTcCommonAgreementSignImpl) obj);
    }

    private static long getUID(ICallBackWsTcCommonAgreementSignImpl iCallBackWsTcCommonAgreementSignImpl) {
        long cPtr = getCPtr(iCallBackWsTcCommonAgreementSignImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTcCommonAgreementSignImpl iCallBackWsTcCommonAgreementSignImpl) {
        if (iCallBackWsTcCommonAgreementSignImpl == null) {
            return 0L;
        }
        return iCallBackWsTcCommonAgreementSignImpl.swigCPtr;
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
        ICallBackWsTcCommonAgreementSignImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTcCommonAgreementSignImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTcCommonAgreementSignResponseParam gWsTcCommonAgreementSignResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTcCommonAgreementSignResponseParam);
    }

    public ICallBackWsTcCommonAgreementSignImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTcCommonAgreementSignImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
