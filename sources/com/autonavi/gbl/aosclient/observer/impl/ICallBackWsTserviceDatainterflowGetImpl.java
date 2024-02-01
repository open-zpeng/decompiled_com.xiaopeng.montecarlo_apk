package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceDatainterflowGetResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceDatainterflowGet;
@IntfAuto(target = ICallBackWsTserviceDatainterflowGet.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTserviceDatainterflowGetImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTserviceDatainterflowGetImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTserviceDatainterflowGetImpl_change_ownership(ICallBackWsTserviceDatainterflowGetImpl iCallBackWsTserviceDatainterflowGetImpl, long j, boolean z);

    private static native void ICallBackWsTserviceDatainterflowGetImpl_director_connect(ICallBackWsTserviceDatainterflowGetImpl iCallBackWsTserviceDatainterflowGetImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTserviceDatainterflowGetImpl iCallBackWsTserviceDatainterflowGetImpl, long j2, GWsTserviceDatainterflowGetResponseParam gWsTserviceDatainterflowGetResponseParam);

    public ICallBackWsTserviceDatainterflowGetImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTserviceDatainterflowGetImpl) && getUID(this) == getUID((ICallBackWsTserviceDatainterflowGetImpl) obj);
    }

    private static long getUID(ICallBackWsTserviceDatainterflowGetImpl iCallBackWsTserviceDatainterflowGetImpl) {
        long cPtr = getCPtr(iCallBackWsTserviceDatainterflowGetImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTserviceDatainterflowGetImpl iCallBackWsTserviceDatainterflowGetImpl) {
        if (iCallBackWsTserviceDatainterflowGetImpl == null) {
            return 0L;
        }
        return iCallBackWsTserviceDatainterflowGetImpl.swigCPtr;
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
        ICallBackWsTserviceDatainterflowGetImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTserviceDatainterflowGetImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTserviceDatainterflowGetResponseParam gWsTserviceDatainterflowGetResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTserviceDatainterflowGetResponseParam);
    }

    public ICallBackWsTserviceDatainterflowGetImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTserviceDatainterflowGetImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
