package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GCarLtdBindResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdBind;
@IntfAuto(target = ICallBackCarLtdBind.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackCarLtdBindImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackCarLtdBindImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackCarLtdBindImpl_change_ownership(ICallBackCarLtdBindImpl iCallBackCarLtdBindImpl, long j, boolean z);

    private static native void ICallBackCarLtdBindImpl_director_connect(ICallBackCarLtdBindImpl iCallBackCarLtdBindImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackCarLtdBindImpl iCallBackCarLtdBindImpl, long j2, GCarLtdBindResponseParam gCarLtdBindResponseParam);

    public ICallBackCarLtdBindImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackCarLtdBindImpl) && getUID(this) == getUID((ICallBackCarLtdBindImpl) obj);
    }

    private static long getUID(ICallBackCarLtdBindImpl iCallBackCarLtdBindImpl) {
        long cPtr = getCPtr(iCallBackCarLtdBindImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackCarLtdBindImpl iCallBackCarLtdBindImpl) {
        if (iCallBackCarLtdBindImpl == null) {
            return 0L;
        }
        return iCallBackCarLtdBindImpl.swigCPtr;
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
        ICallBackCarLtdBindImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackCarLtdBindImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GCarLtdBindResponseParam gCarLtdBindResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gCarLtdBindResponseParam);
    }

    public ICallBackCarLtdBindImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackCarLtdBindImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
