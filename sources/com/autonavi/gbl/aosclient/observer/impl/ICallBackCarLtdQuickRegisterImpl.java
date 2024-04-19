package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GCarLtdQuickRegisterResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdQuickRegister;
@IntfAuto(target = ICallBackCarLtdQuickRegister.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackCarLtdQuickRegisterImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackCarLtdQuickRegisterImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackCarLtdQuickRegisterImpl_change_ownership(ICallBackCarLtdQuickRegisterImpl iCallBackCarLtdQuickRegisterImpl, long j, boolean z);

    private static native void ICallBackCarLtdQuickRegisterImpl_director_connect(ICallBackCarLtdQuickRegisterImpl iCallBackCarLtdQuickRegisterImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackCarLtdQuickRegisterImpl iCallBackCarLtdQuickRegisterImpl, long j2, GCarLtdQuickRegisterResponseParam gCarLtdQuickRegisterResponseParam);

    public ICallBackCarLtdQuickRegisterImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackCarLtdQuickRegisterImpl) && getUID(this) == getUID((ICallBackCarLtdQuickRegisterImpl) obj);
    }

    private static long getUID(ICallBackCarLtdQuickRegisterImpl iCallBackCarLtdQuickRegisterImpl) {
        long cPtr = getCPtr(iCallBackCarLtdQuickRegisterImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackCarLtdQuickRegisterImpl iCallBackCarLtdQuickRegisterImpl) {
        if (iCallBackCarLtdQuickRegisterImpl == null) {
            return 0L;
        }
        return iCallBackCarLtdQuickRegisterImpl.swigCPtr;
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
        ICallBackCarLtdQuickRegisterImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackCarLtdQuickRegisterImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GCarLtdQuickRegisterResponseParam gCarLtdQuickRegisterResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gCarLtdQuickRegisterResponseParam);
    }

    public ICallBackCarLtdQuickRegisterImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackCarLtdQuickRegisterImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
