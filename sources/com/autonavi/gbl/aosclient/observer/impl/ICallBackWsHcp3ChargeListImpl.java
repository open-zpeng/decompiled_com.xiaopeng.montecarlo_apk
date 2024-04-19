package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GWsHcp3ChargeListResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsHcp3ChargeList;
@IntfAuto(target = ICallBackWsHcp3ChargeList.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsHcp3ChargeListImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsHcp3ChargeListImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsHcp3ChargeListImpl_change_ownership(ICallBackWsHcp3ChargeListImpl iCallBackWsHcp3ChargeListImpl, long j, boolean z);

    private static native void ICallBackWsHcp3ChargeListImpl_director_connect(ICallBackWsHcp3ChargeListImpl iCallBackWsHcp3ChargeListImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsHcp3ChargeListImpl iCallBackWsHcp3ChargeListImpl, long j2, GWsHcp3ChargeListResponseParam gWsHcp3ChargeListResponseParam);

    public ICallBackWsHcp3ChargeListImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsHcp3ChargeListImpl) && getUID(this) == getUID((ICallBackWsHcp3ChargeListImpl) obj);
    }

    private static long getUID(ICallBackWsHcp3ChargeListImpl iCallBackWsHcp3ChargeListImpl) {
        long cPtr = getCPtr(iCallBackWsHcp3ChargeListImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsHcp3ChargeListImpl iCallBackWsHcp3ChargeListImpl) {
        if (iCallBackWsHcp3ChargeListImpl == null) {
            return 0L;
        }
        return iCallBackWsHcp3ChargeListImpl.swigCPtr;
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
        ICallBackWsHcp3ChargeListImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsHcp3ChargeListImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsHcp3ChargeListResponseParam gWsHcp3ChargeListResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsHcp3ChargeListResponseParam);
    }

    public ICallBackWsHcp3ChargeListImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsHcp3ChargeListImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
