package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GQueryCarMsgResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackQueryCarMsg;
@IntfAuto(target = ICallBackQueryCarMsg.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackQueryCarMsgImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackQueryCarMsgImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackQueryCarMsgImpl_change_ownership(ICallBackQueryCarMsgImpl iCallBackQueryCarMsgImpl, long j, boolean z);

    private static native void ICallBackQueryCarMsgImpl_director_connect(ICallBackQueryCarMsgImpl iCallBackQueryCarMsgImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackQueryCarMsgImpl iCallBackQueryCarMsgImpl, long j2, GQueryCarMsgResponseParam gQueryCarMsgResponseParam);

    public ICallBackQueryCarMsgImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackQueryCarMsgImpl) && getUID(this) == getUID((ICallBackQueryCarMsgImpl) obj);
    }

    private static long getUID(ICallBackQueryCarMsgImpl iCallBackQueryCarMsgImpl) {
        long cPtr = getCPtr(iCallBackQueryCarMsgImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackQueryCarMsgImpl iCallBackQueryCarMsgImpl) {
        if (iCallBackQueryCarMsgImpl == null) {
            return 0L;
        }
        return iCallBackQueryCarMsgImpl.swigCPtr;
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
        ICallBackQueryCarMsgImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackQueryCarMsgImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GQueryCarMsgResponseParam gQueryCarMsgResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gQueryCarMsgResponseParam);
    }

    public ICallBackQueryCarMsgImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackQueryCarMsgImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
