package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcFuelCreateResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcFuelCreate;
@IntfAuto(target = ICallBackWsTcFuelCreate.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTcFuelCreateImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTcFuelCreateImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTcFuelCreateImpl_change_ownership(ICallBackWsTcFuelCreateImpl iCallBackWsTcFuelCreateImpl, long j, boolean z);

    private static native void ICallBackWsTcFuelCreateImpl_director_connect(ICallBackWsTcFuelCreateImpl iCallBackWsTcFuelCreateImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTcFuelCreateImpl iCallBackWsTcFuelCreateImpl, long j2, GWsTcFuelCreateResponseParam gWsTcFuelCreateResponseParam);

    public ICallBackWsTcFuelCreateImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTcFuelCreateImpl) && getUID(this) == getUID((ICallBackWsTcFuelCreateImpl) obj);
    }

    private static long getUID(ICallBackWsTcFuelCreateImpl iCallBackWsTcFuelCreateImpl) {
        long cPtr = getCPtr(iCallBackWsTcFuelCreateImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTcFuelCreateImpl iCallBackWsTcFuelCreateImpl) {
        if (iCallBackWsTcFuelCreateImpl == null) {
            return 0L;
        }
        return iCallBackWsTcFuelCreateImpl.swigCPtr;
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
        ICallBackWsTcFuelCreateImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTcFuelCreateImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTcFuelCreateResponseParam gWsTcFuelCreateResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTcFuelCreateResponseParam);
    }

    public ICallBackWsTcFuelCreateImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTcFuelCreateImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
