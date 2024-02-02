package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GCarLtdUnbindResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdUnbind;
@IntfAuto(target = ICallBackCarLtdUnbind.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackCarLtdUnbindImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackCarLtdUnbindImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackCarLtdUnbindImpl_change_ownership(ICallBackCarLtdUnbindImpl iCallBackCarLtdUnbindImpl, long j, boolean z);

    private static native void ICallBackCarLtdUnbindImpl_director_connect(ICallBackCarLtdUnbindImpl iCallBackCarLtdUnbindImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackCarLtdUnbindImpl iCallBackCarLtdUnbindImpl, long j2, GCarLtdUnbindResponseParam gCarLtdUnbindResponseParam);

    public ICallBackCarLtdUnbindImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackCarLtdUnbindImpl) && getUID(this) == getUID((ICallBackCarLtdUnbindImpl) obj);
    }

    private static long getUID(ICallBackCarLtdUnbindImpl iCallBackCarLtdUnbindImpl) {
        long cPtr = getCPtr(iCallBackCarLtdUnbindImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackCarLtdUnbindImpl iCallBackCarLtdUnbindImpl) {
        if (iCallBackCarLtdUnbindImpl == null) {
            return 0L;
        }
        return iCallBackCarLtdUnbindImpl.swigCPtr;
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
        ICallBackCarLtdUnbindImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackCarLtdUnbindImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GCarLtdUnbindResponseParam gCarLtdUnbindResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gCarLtdUnbindResponseParam);
    }

    public ICallBackCarLtdUnbindImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackCarLtdUnbindImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
