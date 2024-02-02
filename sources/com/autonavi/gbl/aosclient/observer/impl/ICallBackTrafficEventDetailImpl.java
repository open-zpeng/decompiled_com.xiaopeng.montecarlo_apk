package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GTrafficEventDetailResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackTrafficEventDetail;
@IntfAuto(target = ICallBackTrafficEventDetail.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackTrafficEventDetailImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackTrafficEventDetailImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackTrafficEventDetailImpl_change_ownership(ICallBackTrafficEventDetailImpl iCallBackTrafficEventDetailImpl, long j, boolean z);

    private static native void ICallBackTrafficEventDetailImpl_director_connect(ICallBackTrafficEventDetailImpl iCallBackTrafficEventDetailImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackTrafficEventDetailImpl iCallBackTrafficEventDetailImpl, long j2, GTrafficEventDetailResponseParam gTrafficEventDetailResponseParam);

    public ICallBackTrafficEventDetailImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackTrafficEventDetailImpl) && getUID(this) == getUID((ICallBackTrafficEventDetailImpl) obj);
    }

    private static long getUID(ICallBackTrafficEventDetailImpl iCallBackTrafficEventDetailImpl) {
        long cPtr = getCPtr(iCallBackTrafficEventDetailImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackTrafficEventDetailImpl iCallBackTrafficEventDetailImpl) {
        if (iCallBackTrafficEventDetailImpl == null) {
            return 0L;
        }
        return iCallBackTrafficEventDetailImpl.swigCPtr;
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
        ICallBackTrafficEventDetailImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackTrafficEventDetailImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GTrafficEventDetailResponseParam gTrafficEventDetailResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gTrafficEventDetailResponseParam);
    }

    public ICallBackTrafficEventDetailImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackTrafficEventDetailImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
