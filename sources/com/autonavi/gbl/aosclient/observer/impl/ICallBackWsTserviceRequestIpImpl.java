package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceRequestIpResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceRequestIp;
@IntfAuto(target = ICallBackWsTserviceRequestIp.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTserviceRequestIpImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTserviceRequestIpImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTserviceRequestIpImpl_change_ownership(ICallBackWsTserviceRequestIpImpl iCallBackWsTserviceRequestIpImpl, long j, boolean z);

    private static native void ICallBackWsTserviceRequestIpImpl_director_connect(ICallBackWsTserviceRequestIpImpl iCallBackWsTserviceRequestIpImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTserviceRequestIpImpl iCallBackWsTserviceRequestIpImpl, long j2, GWsTserviceRequestIpResponseParam gWsTserviceRequestIpResponseParam);

    public ICallBackWsTserviceRequestIpImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTserviceRequestIpImpl) && getUID(this) == getUID((ICallBackWsTserviceRequestIpImpl) obj);
    }

    private static long getUID(ICallBackWsTserviceRequestIpImpl iCallBackWsTserviceRequestIpImpl) {
        long cPtr = getCPtr(iCallBackWsTserviceRequestIpImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTserviceRequestIpImpl iCallBackWsTserviceRequestIpImpl) {
        if (iCallBackWsTserviceRequestIpImpl == null) {
            return 0L;
        }
        return iCallBackWsTserviceRequestIpImpl.swigCPtr;
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
        ICallBackWsTserviceRequestIpImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTserviceRequestIpImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTserviceRequestIpResponseParam gWsTserviceRequestIpResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTserviceRequestIpResponseParam);
    }

    public ICallBackWsTserviceRequestIpImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTserviceRequestIpImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
