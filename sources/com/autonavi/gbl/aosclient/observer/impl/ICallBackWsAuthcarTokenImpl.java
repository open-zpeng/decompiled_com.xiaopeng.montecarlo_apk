package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsAuthcarTokenResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAuthcarToken;
@IntfAuto(target = ICallBackWsAuthcarToken.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsAuthcarTokenImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsAuthcarTokenImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsAuthcarTokenImpl_change_ownership(ICallBackWsAuthcarTokenImpl iCallBackWsAuthcarTokenImpl, long j, boolean z);

    private static native void ICallBackWsAuthcarTokenImpl_director_connect(ICallBackWsAuthcarTokenImpl iCallBackWsAuthcarTokenImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsAuthcarTokenImpl iCallBackWsAuthcarTokenImpl, long j2, GWsAuthcarTokenResponseParam gWsAuthcarTokenResponseParam);

    public ICallBackWsAuthcarTokenImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsAuthcarTokenImpl) && getUID(this) == getUID((ICallBackWsAuthcarTokenImpl) obj);
    }

    private static long getUID(ICallBackWsAuthcarTokenImpl iCallBackWsAuthcarTokenImpl) {
        long cPtr = getCPtr(iCallBackWsAuthcarTokenImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsAuthcarTokenImpl iCallBackWsAuthcarTokenImpl) {
        if (iCallBackWsAuthcarTokenImpl == null) {
            return 0L;
        }
        return iCallBackWsAuthcarTokenImpl.swigCPtr;
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
        ICallBackWsAuthcarTokenImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsAuthcarTokenImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsAuthcarTokenResponseParam gWsAuthcarTokenResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsAuthcarTokenResponseParam);
    }

    public ICallBackWsAuthcarTokenImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsAuthcarTokenImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
