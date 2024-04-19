package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GParkOrderListResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackParkOrderList;
@IntfAuto(target = ICallBackParkOrderList.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackParkOrderListImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackParkOrderListImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackParkOrderListImpl_change_ownership(ICallBackParkOrderListImpl iCallBackParkOrderListImpl, long j, boolean z);

    private static native void ICallBackParkOrderListImpl_director_connect(ICallBackParkOrderListImpl iCallBackParkOrderListImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackParkOrderListImpl iCallBackParkOrderListImpl, long j2, GParkOrderListResponseParam gParkOrderListResponseParam);

    public ICallBackParkOrderListImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackParkOrderListImpl) && getUID(this) == getUID((ICallBackParkOrderListImpl) obj);
    }

    private static long getUID(ICallBackParkOrderListImpl iCallBackParkOrderListImpl) {
        long cPtr = getCPtr(iCallBackParkOrderListImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackParkOrderListImpl iCallBackParkOrderListImpl) {
        if (iCallBackParkOrderListImpl == null) {
            return 0L;
        }
        return iCallBackParkOrderListImpl.swigCPtr;
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
        ICallBackParkOrderListImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackParkOrderListImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GParkOrderListResponseParam gParkOrderListResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gParkOrderListResponseParam);
    }

    public ICallBackParkOrderListImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackParkOrderListImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
