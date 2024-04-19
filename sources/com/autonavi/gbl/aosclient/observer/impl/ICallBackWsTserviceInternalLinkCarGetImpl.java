package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GWsTserviceInternalLinkCarGetResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceInternalLinkCarGet;
@IntfAuto(target = ICallBackWsTserviceInternalLinkCarGet.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTserviceInternalLinkCarGetImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTserviceInternalLinkCarGetImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTserviceInternalLinkCarGetImpl_change_ownership(ICallBackWsTserviceInternalLinkCarGetImpl iCallBackWsTserviceInternalLinkCarGetImpl, long j, boolean z);

    private static native void ICallBackWsTserviceInternalLinkCarGetImpl_director_connect(ICallBackWsTserviceInternalLinkCarGetImpl iCallBackWsTserviceInternalLinkCarGetImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTserviceInternalLinkCarGetImpl iCallBackWsTserviceInternalLinkCarGetImpl, long j2, GWsTserviceInternalLinkCarGetResponseParam gWsTserviceInternalLinkCarGetResponseParam);

    public ICallBackWsTserviceInternalLinkCarGetImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTserviceInternalLinkCarGetImpl) && getUID(this) == getUID((ICallBackWsTserviceInternalLinkCarGetImpl) obj);
    }

    private static long getUID(ICallBackWsTserviceInternalLinkCarGetImpl iCallBackWsTserviceInternalLinkCarGetImpl) {
        long cPtr = getCPtr(iCallBackWsTserviceInternalLinkCarGetImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTserviceInternalLinkCarGetImpl iCallBackWsTserviceInternalLinkCarGetImpl) {
        if (iCallBackWsTserviceInternalLinkCarGetImpl == null) {
            return 0L;
        }
        return iCallBackWsTserviceInternalLinkCarGetImpl.swigCPtr;
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
        ICallBackWsTserviceInternalLinkCarGetImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTserviceInternalLinkCarGetImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTserviceInternalLinkCarGetResponseParam gWsTserviceInternalLinkCarGetResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTserviceInternalLinkCarGetResponseParam);
    }

    public ICallBackWsTserviceInternalLinkCarGetImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTserviceInternalLinkCarGetImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
