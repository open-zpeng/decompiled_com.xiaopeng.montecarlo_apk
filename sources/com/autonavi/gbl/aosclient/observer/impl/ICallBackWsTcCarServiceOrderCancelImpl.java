package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcCarServiceOrderCancelResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcCarServiceOrderCancel;
@IntfAuto(target = ICallBackWsTcCarServiceOrderCancel.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTcCarServiceOrderCancelImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTcCarServiceOrderCancelImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTcCarServiceOrderCancelImpl_change_ownership(ICallBackWsTcCarServiceOrderCancelImpl iCallBackWsTcCarServiceOrderCancelImpl, long j, boolean z);

    private static native void ICallBackWsTcCarServiceOrderCancelImpl_director_connect(ICallBackWsTcCarServiceOrderCancelImpl iCallBackWsTcCarServiceOrderCancelImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTcCarServiceOrderCancelImpl iCallBackWsTcCarServiceOrderCancelImpl, long j2, GWsTcCarServiceOrderCancelResponseParam gWsTcCarServiceOrderCancelResponseParam);

    public ICallBackWsTcCarServiceOrderCancelImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTcCarServiceOrderCancelImpl) && getUID(this) == getUID((ICallBackWsTcCarServiceOrderCancelImpl) obj);
    }

    private static long getUID(ICallBackWsTcCarServiceOrderCancelImpl iCallBackWsTcCarServiceOrderCancelImpl) {
        long cPtr = getCPtr(iCallBackWsTcCarServiceOrderCancelImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTcCarServiceOrderCancelImpl iCallBackWsTcCarServiceOrderCancelImpl) {
        if (iCallBackWsTcCarServiceOrderCancelImpl == null) {
            return 0L;
        }
        return iCallBackWsTcCarServiceOrderCancelImpl.swigCPtr;
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
        ICallBackWsTcCarServiceOrderCancelImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTcCarServiceOrderCancelImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTcCarServiceOrderCancelResponseParam gWsTcCarServiceOrderCancelResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTcCarServiceOrderCancelResponseParam);
    }

    public ICallBackWsTcCarServiceOrderCancelImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTcCarServiceOrderCancelImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
