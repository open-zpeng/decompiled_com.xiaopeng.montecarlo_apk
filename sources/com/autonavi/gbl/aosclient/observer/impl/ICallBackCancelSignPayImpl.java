package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GCancelSignPayResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackCancelSignPay;
@IntfAuto(target = ICallBackCancelSignPay.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackCancelSignPayImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackCancelSignPayImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackCancelSignPayImpl_change_ownership(ICallBackCancelSignPayImpl iCallBackCancelSignPayImpl, long j, boolean z);

    private static native void ICallBackCancelSignPayImpl_director_connect(ICallBackCancelSignPayImpl iCallBackCancelSignPayImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackCancelSignPayImpl iCallBackCancelSignPayImpl, long j2, GCancelSignPayResponseParam gCancelSignPayResponseParam);

    public ICallBackCancelSignPayImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackCancelSignPayImpl) && getUID(this) == getUID((ICallBackCancelSignPayImpl) obj);
    }

    private static long getUID(ICallBackCancelSignPayImpl iCallBackCancelSignPayImpl) {
        long cPtr = getCPtr(iCallBackCancelSignPayImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackCancelSignPayImpl iCallBackCancelSignPayImpl) {
        if (iCallBackCancelSignPayImpl == null) {
            return 0L;
        }
        return iCallBackCancelSignPayImpl.swigCPtr;
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
        ICallBackCancelSignPayImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackCancelSignPayImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GCancelSignPayResponseParam gCancelSignPayResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gCancelSignPayResponseParam);
    }

    public ICallBackCancelSignPayImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackCancelSignPayImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
