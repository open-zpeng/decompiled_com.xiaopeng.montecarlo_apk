package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsShieldAsbpApiUploadResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldAsbpApiUpload;
@IntfAuto(target = ICallBackWsShieldAsbpApiUpload.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsShieldAsbpApiUploadImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsShieldAsbpApiUploadImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsShieldAsbpApiUploadImpl_change_ownership(ICallBackWsShieldAsbpApiUploadImpl iCallBackWsShieldAsbpApiUploadImpl, long j, boolean z);

    private static native void ICallBackWsShieldAsbpApiUploadImpl_director_connect(ICallBackWsShieldAsbpApiUploadImpl iCallBackWsShieldAsbpApiUploadImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsShieldAsbpApiUploadImpl iCallBackWsShieldAsbpApiUploadImpl, long j2, GWsShieldAsbpApiUploadResponseParam gWsShieldAsbpApiUploadResponseParam);

    public ICallBackWsShieldAsbpApiUploadImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsShieldAsbpApiUploadImpl) && getUID(this) == getUID((ICallBackWsShieldAsbpApiUploadImpl) obj);
    }

    private static long getUID(ICallBackWsShieldAsbpApiUploadImpl iCallBackWsShieldAsbpApiUploadImpl) {
        long cPtr = getCPtr(iCallBackWsShieldAsbpApiUploadImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsShieldAsbpApiUploadImpl iCallBackWsShieldAsbpApiUploadImpl) {
        if (iCallBackWsShieldAsbpApiUploadImpl == null) {
            return 0L;
        }
        return iCallBackWsShieldAsbpApiUploadImpl.swigCPtr;
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
        ICallBackWsShieldAsbpApiUploadImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsShieldAsbpApiUploadImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsShieldAsbpApiUploadResponseParam gWsShieldAsbpApiUploadResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsShieldAsbpApiUploadResponseParam);
    }

    public ICallBackWsShieldAsbpApiUploadImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsShieldAsbpApiUploadImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
