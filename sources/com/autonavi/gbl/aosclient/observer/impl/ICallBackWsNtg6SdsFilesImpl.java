package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GWsNtg6SdsFilesResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsNtg6SdsFiles;
@IntfAuto(target = ICallBackWsNtg6SdsFiles.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsNtg6SdsFilesImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsNtg6SdsFilesImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsNtg6SdsFilesImpl_change_ownership(ICallBackWsNtg6SdsFilesImpl iCallBackWsNtg6SdsFilesImpl, long j, boolean z);

    private static native void ICallBackWsNtg6SdsFilesImpl_director_connect(ICallBackWsNtg6SdsFilesImpl iCallBackWsNtg6SdsFilesImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsNtg6SdsFilesImpl iCallBackWsNtg6SdsFilesImpl, long j2, GWsNtg6SdsFilesResponseParam gWsNtg6SdsFilesResponseParam);

    public ICallBackWsNtg6SdsFilesImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsNtg6SdsFilesImpl) && getUID(this) == getUID((ICallBackWsNtg6SdsFilesImpl) obj);
    }

    private static long getUID(ICallBackWsNtg6SdsFilesImpl iCallBackWsNtg6SdsFilesImpl) {
        long cPtr = getCPtr(iCallBackWsNtg6SdsFilesImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsNtg6SdsFilesImpl iCallBackWsNtg6SdsFilesImpl) {
        if (iCallBackWsNtg6SdsFilesImpl == null) {
            return 0L;
        }
        return iCallBackWsNtg6SdsFilesImpl.swigCPtr;
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
        ICallBackWsNtg6SdsFilesImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsNtg6SdsFilesImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsNtg6SdsFilesResponseParam gWsNtg6SdsFilesResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsNtg6SdsFilesResponseParam);
    }

    public ICallBackWsNtg6SdsFilesImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsNtg6SdsFilesImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
