package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GGasstationcalpriceResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackGasstationcalprice;
@IntfAuto(target = ICallBackGasstationcalprice.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackGasstationcalpriceImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackGasstationcalpriceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackGasstationcalpriceImpl_change_ownership(ICallBackGasstationcalpriceImpl iCallBackGasstationcalpriceImpl, long j, boolean z);

    private static native void ICallBackGasstationcalpriceImpl_director_connect(ICallBackGasstationcalpriceImpl iCallBackGasstationcalpriceImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackGasstationcalpriceImpl iCallBackGasstationcalpriceImpl, long j2, GGasstationcalpriceResponseParam gGasstationcalpriceResponseParam);

    public ICallBackGasstationcalpriceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackGasstationcalpriceImpl) && getUID(this) == getUID((ICallBackGasstationcalpriceImpl) obj);
    }

    private static long getUID(ICallBackGasstationcalpriceImpl iCallBackGasstationcalpriceImpl) {
        long cPtr = getCPtr(iCallBackGasstationcalpriceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackGasstationcalpriceImpl iCallBackGasstationcalpriceImpl) {
        if (iCallBackGasstationcalpriceImpl == null) {
            return 0L;
        }
        return iCallBackGasstationcalpriceImpl.swigCPtr;
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
        ICallBackGasstationcalpriceImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackGasstationcalpriceImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GGasstationcalpriceResponseParam gGasstationcalpriceResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gGasstationcalpriceResponseParam);
    }

    public ICallBackGasstationcalpriceImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackGasstationcalpriceImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
