package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GWsTcFuelGetwaitingpayordersResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcFuelGetwaitingpayorders;
@IntfAuto(target = ICallBackWsTcFuelGetwaitingpayorders.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTcFuelGetwaitingpayordersImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTcFuelGetwaitingpayordersImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTcFuelGetwaitingpayordersImpl_change_ownership(ICallBackWsTcFuelGetwaitingpayordersImpl iCallBackWsTcFuelGetwaitingpayordersImpl, long j, boolean z);

    private static native void ICallBackWsTcFuelGetwaitingpayordersImpl_director_connect(ICallBackWsTcFuelGetwaitingpayordersImpl iCallBackWsTcFuelGetwaitingpayordersImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTcFuelGetwaitingpayordersImpl iCallBackWsTcFuelGetwaitingpayordersImpl, long j2, GWsTcFuelGetwaitingpayordersResponseParam gWsTcFuelGetwaitingpayordersResponseParam);

    public ICallBackWsTcFuelGetwaitingpayordersImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTcFuelGetwaitingpayordersImpl) && getUID(this) == getUID((ICallBackWsTcFuelGetwaitingpayordersImpl) obj);
    }

    private static long getUID(ICallBackWsTcFuelGetwaitingpayordersImpl iCallBackWsTcFuelGetwaitingpayordersImpl) {
        long cPtr = getCPtr(iCallBackWsTcFuelGetwaitingpayordersImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTcFuelGetwaitingpayordersImpl iCallBackWsTcFuelGetwaitingpayordersImpl) {
        if (iCallBackWsTcFuelGetwaitingpayordersImpl == null) {
            return 0L;
        }
        return iCallBackWsTcFuelGetwaitingpayordersImpl.swigCPtr;
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
        ICallBackWsTcFuelGetwaitingpayordersImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTcFuelGetwaitingpayordersImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTcFuelGetwaitingpayordersResponseParam gWsTcFuelGetwaitingpayordersResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTcFuelGetwaitingpayordersResponseParam);
    }

    public ICallBackWsTcFuelGetwaitingpayordersImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTcFuelGetwaitingpayordersImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
