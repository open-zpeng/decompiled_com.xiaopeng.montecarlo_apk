package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcOrderListResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcOrderList;
@IntfAuto(target = ICallBackWsTcOrderList.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTcOrderListImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTcOrderListImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTcOrderListImpl_change_ownership(ICallBackWsTcOrderListImpl iCallBackWsTcOrderListImpl, long j, boolean z);

    private static native void ICallBackWsTcOrderListImpl_director_connect(ICallBackWsTcOrderListImpl iCallBackWsTcOrderListImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTcOrderListImpl iCallBackWsTcOrderListImpl, long j2, GWsTcOrderListResponseParam gWsTcOrderListResponseParam);

    public ICallBackWsTcOrderListImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTcOrderListImpl) && getUID(this) == getUID((ICallBackWsTcOrderListImpl) obj);
    }

    private static long getUID(ICallBackWsTcOrderListImpl iCallBackWsTcOrderListImpl) {
        long cPtr = getCPtr(iCallBackWsTcOrderListImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTcOrderListImpl iCallBackWsTcOrderListImpl) {
        if (iCallBackWsTcOrderListImpl == null) {
            return 0L;
        }
        return iCallBackWsTcOrderListImpl.swigCPtr;
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
        ICallBackWsTcOrderListImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTcOrderListImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTcOrderListResponseParam gWsTcOrderListResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTcOrderListResponseParam);
    }

    public ICallBackWsTcOrderListImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTcOrderListImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
