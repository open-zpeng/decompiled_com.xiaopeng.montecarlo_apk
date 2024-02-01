package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GAddressPredictResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackAddressPredict;
@IntfAuto(target = ICallBackAddressPredict.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackAddressPredictImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackAddressPredictImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackAddressPredictImpl_change_ownership(ICallBackAddressPredictImpl iCallBackAddressPredictImpl, long j, boolean z);

    private static native void ICallBackAddressPredictImpl_director_connect(ICallBackAddressPredictImpl iCallBackAddressPredictImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackAddressPredictImpl iCallBackAddressPredictImpl, long j2, GAddressPredictResponseParam gAddressPredictResponseParam);

    public ICallBackAddressPredictImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackAddressPredictImpl) && getUID(this) == getUID((ICallBackAddressPredictImpl) obj);
    }

    private static long getUID(ICallBackAddressPredictImpl iCallBackAddressPredictImpl) {
        long cPtr = getCPtr(iCallBackAddressPredictImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackAddressPredictImpl iCallBackAddressPredictImpl) {
        if (iCallBackAddressPredictImpl == null) {
            return 0L;
        }
        return iCallBackAddressPredictImpl.swigCPtr;
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
        ICallBackAddressPredictImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackAddressPredictImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GAddressPredictResponseParam gAddressPredictResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gAddressPredictResponseParam);
    }

    public ICallBackAddressPredictImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackAddressPredictImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
