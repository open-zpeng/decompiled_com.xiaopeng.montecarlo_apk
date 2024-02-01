package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsChargeListResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsChargeList;
@IntfAuto(target = ICallBackWsChargeList.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsChargeListImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsChargeListImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsChargeListImpl_change_ownership(ICallBackWsChargeListImpl iCallBackWsChargeListImpl, long j, boolean z);

    private static native void ICallBackWsChargeListImpl_director_connect(ICallBackWsChargeListImpl iCallBackWsChargeListImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsChargeListImpl iCallBackWsChargeListImpl, long j2, GWsChargeListResponseParam gWsChargeListResponseParam);

    public ICallBackWsChargeListImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsChargeListImpl) && getUID(this) == getUID((ICallBackWsChargeListImpl) obj);
    }

    private static long getUID(ICallBackWsChargeListImpl iCallBackWsChargeListImpl) {
        long cPtr = getCPtr(iCallBackWsChargeListImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsChargeListImpl iCallBackWsChargeListImpl) {
        if (iCallBackWsChargeListImpl == null) {
            return 0L;
        }
        return iCallBackWsChargeListImpl.swigCPtr;
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
        ICallBackWsChargeListImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsChargeListImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsChargeListResponseParam gWsChargeListResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsChargeListResponseParam);
    }

    public ICallBackWsChargeListImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsChargeListImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
