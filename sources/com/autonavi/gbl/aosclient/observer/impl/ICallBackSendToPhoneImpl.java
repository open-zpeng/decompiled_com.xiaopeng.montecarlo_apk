package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GSendToPhoneResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackSendToPhone;
@IntfAuto(target = ICallBackSendToPhone.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackSendToPhoneImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackSendToPhoneImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackSendToPhoneImpl_change_ownership(ICallBackSendToPhoneImpl iCallBackSendToPhoneImpl, long j, boolean z);

    private static native void ICallBackSendToPhoneImpl_director_connect(ICallBackSendToPhoneImpl iCallBackSendToPhoneImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackSendToPhoneImpl iCallBackSendToPhoneImpl, long j2, GSendToPhoneResponseParam gSendToPhoneResponseParam);

    public ICallBackSendToPhoneImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackSendToPhoneImpl) && getUID(this) == getUID((ICallBackSendToPhoneImpl) obj);
    }

    private static long getUID(ICallBackSendToPhoneImpl iCallBackSendToPhoneImpl) {
        long cPtr = getCPtr(iCallBackSendToPhoneImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackSendToPhoneImpl iCallBackSendToPhoneImpl) {
        if (iCallBackSendToPhoneImpl == null) {
            return 0L;
        }
        return iCallBackSendToPhoneImpl.swigCPtr;
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
        ICallBackSendToPhoneImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackSendToPhoneImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GSendToPhoneResponseParam gSendToPhoneResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gSendToPhoneResponseParam);
    }

    public ICallBackSendToPhoneImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackSendToPhoneImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
