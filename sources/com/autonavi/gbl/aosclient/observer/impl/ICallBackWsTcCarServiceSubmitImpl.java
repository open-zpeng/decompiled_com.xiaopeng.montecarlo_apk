package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcCarServiceSubmitResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcCarServiceSubmit;
@IntfAuto(target = ICallBackWsTcCarServiceSubmit.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTcCarServiceSubmitImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTcCarServiceSubmitImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTcCarServiceSubmitImpl_change_ownership(ICallBackWsTcCarServiceSubmitImpl iCallBackWsTcCarServiceSubmitImpl, long j, boolean z);

    private static native void ICallBackWsTcCarServiceSubmitImpl_director_connect(ICallBackWsTcCarServiceSubmitImpl iCallBackWsTcCarServiceSubmitImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTcCarServiceSubmitImpl iCallBackWsTcCarServiceSubmitImpl, long j2, GWsTcCarServiceSubmitResponseParam gWsTcCarServiceSubmitResponseParam);

    public ICallBackWsTcCarServiceSubmitImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTcCarServiceSubmitImpl) && getUID(this) == getUID((ICallBackWsTcCarServiceSubmitImpl) obj);
    }

    private static long getUID(ICallBackWsTcCarServiceSubmitImpl iCallBackWsTcCarServiceSubmitImpl) {
        long cPtr = getCPtr(iCallBackWsTcCarServiceSubmitImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTcCarServiceSubmitImpl iCallBackWsTcCarServiceSubmitImpl) {
        if (iCallBackWsTcCarServiceSubmitImpl == null) {
            return 0L;
        }
        return iCallBackWsTcCarServiceSubmitImpl.swigCPtr;
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
        ICallBackWsTcCarServiceSubmitImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTcCarServiceSubmitImpl_change_ownership(this, this.swigCPtr, true);
    }

    public ICallBackWsTcCarServiceSubmitImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTcCarServiceSubmitImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void onRecvAck(GWsTcCarServiceSubmitResponseParam gWsTcCarServiceSubmitResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTcCarServiceSubmitResponseParam);
    }
}
