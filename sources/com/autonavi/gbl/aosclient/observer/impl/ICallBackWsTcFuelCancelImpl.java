package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcFuelCancelResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcFuelCancel;
@IntfAuto(target = ICallBackWsTcFuelCancel.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTcFuelCancelImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTcFuelCancelImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTcFuelCancelImpl_change_ownership(ICallBackWsTcFuelCancelImpl iCallBackWsTcFuelCancelImpl, long j, boolean z);

    private static native void ICallBackWsTcFuelCancelImpl_director_connect(ICallBackWsTcFuelCancelImpl iCallBackWsTcFuelCancelImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTcFuelCancelImpl iCallBackWsTcFuelCancelImpl, long j2, GWsTcFuelCancelResponseParam gWsTcFuelCancelResponseParam);

    public ICallBackWsTcFuelCancelImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTcFuelCancelImpl) && getUID(this) == getUID((ICallBackWsTcFuelCancelImpl) obj);
    }

    private static long getUID(ICallBackWsTcFuelCancelImpl iCallBackWsTcFuelCancelImpl) {
        long cPtr = getCPtr(iCallBackWsTcFuelCancelImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTcFuelCancelImpl iCallBackWsTcFuelCancelImpl) {
        if (iCallBackWsTcFuelCancelImpl == null) {
            return 0L;
        }
        return iCallBackWsTcFuelCancelImpl.swigCPtr;
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
        ICallBackWsTcFuelCancelImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTcFuelCancelImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTcFuelCancelResponseParam gWsTcFuelCancelResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTcFuelCancelResponseParam);
    }

    public ICallBackWsTcFuelCancelImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTcFuelCancelImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
