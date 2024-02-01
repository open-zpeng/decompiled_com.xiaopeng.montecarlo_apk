package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GParkOrderCreateResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackParkOrderCreate;
@IntfAuto(target = ICallBackParkOrderCreate.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackParkOrderCreateImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackParkOrderCreateImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackParkOrderCreateImpl_change_ownership(ICallBackParkOrderCreateImpl iCallBackParkOrderCreateImpl, long j, boolean z);

    private static native void ICallBackParkOrderCreateImpl_director_connect(ICallBackParkOrderCreateImpl iCallBackParkOrderCreateImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackParkOrderCreateImpl iCallBackParkOrderCreateImpl, long j2, GParkOrderCreateResponseParam gParkOrderCreateResponseParam);

    public ICallBackParkOrderCreateImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackParkOrderCreateImpl) && getUID(this) == getUID((ICallBackParkOrderCreateImpl) obj);
    }

    private static long getUID(ICallBackParkOrderCreateImpl iCallBackParkOrderCreateImpl) {
        long cPtr = getCPtr(iCallBackParkOrderCreateImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackParkOrderCreateImpl iCallBackParkOrderCreateImpl) {
        if (iCallBackParkOrderCreateImpl == null) {
            return 0L;
        }
        return iCallBackParkOrderCreateImpl.swigCPtr;
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
        ICallBackParkOrderCreateImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackParkOrderCreateImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GParkOrderCreateResponseParam gParkOrderCreateResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gParkOrderCreateResponseParam);
    }

    public ICallBackParkOrderCreateImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackParkOrderCreateImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
