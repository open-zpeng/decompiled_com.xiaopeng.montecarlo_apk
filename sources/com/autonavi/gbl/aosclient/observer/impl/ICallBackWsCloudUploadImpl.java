package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsCloudUploadResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsCloudUpload;
@IntfAuto(target = ICallBackWsCloudUpload.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsCloudUploadImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsCloudUploadImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsCloudUploadImpl_change_ownership(ICallBackWsCloudUploadImpl iCallBackWsCloudUploadImpl, long j, boolean z);

    private static native void ICallBackWsCloudUploadImpl_director_connect(ICallBackWsCloudUploadImpl iCallBackWsCloudUploadImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsCloudUploadImpl iCallBackWsCloudUploadImpl, long j2, GWsCloudUploadResponseParam gWsCloudUploadResponseParam);

    public ICallBackWsCloudUploadImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsCloudUploadImpl) && getUID(this) == getUID((ICallBackWsCloudUploadImpl) obj);
    }

    private static long getUID(ICallBackWsCloudUploadImpl iCallBackWsCloudUploadImpl) {
        long cPtr = getCPtr(iCallBackWsCloudUploadImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsCloudUploadImpl iCallBackWsCloudUploadImpl) {
        if (iCallBackWsCloudUploadImpl == null) {
            return 0L;
        }
        return iCallBackWsCloudUploadImpl.swigCPtr;
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
        ICallBackWsCloudUploadImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsCloudUploadImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsCloudUploadResponseParam gWsCloudUploadResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsCloudUploadResponseParam);
    }

    public ICallBackWsCloudUploadImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsCloudUploadImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
