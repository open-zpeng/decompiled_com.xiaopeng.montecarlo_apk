package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsAutoCollectResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAutoCollect;
@IntfAuto(target = ICallBackWsAutoCollect.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsAutoCollectImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsAutoCollectImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsAutoCollectImpl_change_ownership(ICallBackWsAutoCollectImpl iCallBackWsAutoCollectImpl, long j, boolean z);

    private static native void ICallBackWsAutoCollectImpl_director_connect(ICallBackWsAutoCollectImpl iCallBackWsAutoCollectImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsAutoCollectImpl iCallBackWsAutoCollectImpl, long j2, GWsAutoCollectResponseParam gWsAutoCollectResponseParam);

    public ICallBackWsAutoCollectImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsAutoCollectImpl) && getUID(this) == getUID((ICallBackWsAutoCollectImpl) obj);
    }

    private static long getUID(ICallBackWsAutoCollectImpl iCallBackWsAutoCollectImpl) {
        long cPtr = getCPtr(iCallBackWsAutoCollectImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsAutoCollectImpl iCallBackWsAutoCollectImpl) {
        if (iCallBackWsAutoCollectImpl == null) {
            return 0L;
        }
        return iCallBackWsAutoCollectImpl.swigCPtr;
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
        ICallBackWsAutoCollectImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsAutoCollectImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsAutoCollectResponseParam gWsAutoCollectResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsAutoCollectResponseParam);
    }

    public ICallBackWsAutoCollectImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsAutoCollectImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
