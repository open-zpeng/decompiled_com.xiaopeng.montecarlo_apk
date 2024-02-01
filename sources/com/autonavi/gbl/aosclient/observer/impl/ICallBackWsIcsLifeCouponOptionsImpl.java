package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsIcsLifeCouponOptionsResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsIcsLifeCouponOptions;
@IntfAuto(target = ICallBackWsIcsLifeCouponOptions.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsIcsLifeCouponOptionsImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsIcsLifeCouponOptionsImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsIcsLifeCouponOptionsImpl_change_ownership(ICallBackWsIcsLifeCouponOptionsImpl iCallBackWsIcsLifeCouponOptionsImpl, long j, boolean z);

    private static native void ICallBackWsIcsLifeCouponOptionsImpl_director_connect(ICallBackWsIcsLifeCouponOptionsImpl iCallBackWsIcsLifeCouponOptionsImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsIcsLifeCouponOptionsImpl iCallBackWsIcsLifeCouponOptionsImpl, long j2, GWsIcsLifeCouponOptionsResponseParam gWsIcsLifeCouponOptionsResponseParam);

    public ICallBackWsIcsLifeCouponOptionsImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsIcsLifeCouponOptionsImpl) && getUID(this) == getUID((ICallBackWsIcsLifeCouponOptionsImpl) obj);
    }

    private static long getUID(ICallBackWsIcsLifeCouponOptionsImpl iCallBackWsIcsLifeCouponOptionsImpl) {
        long cPtr = getCPtr(iCallBackWsIcsLifeCouponOptionsImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsIcsLifeCouponOptionsImpl iCallBackWsIcsLifeCouponOptionsImpl) {
        if (iCallBackWsIcsLifeCouponOptionsImpl == null) {
            return 0L;
        }
        return iCallBackWsIcsLifeCouponOptionsImpl.swigCPtr;
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
        ICallBackWsIcsLifeCouponOptionsImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsIcsLifeCouponOptionsImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsIcsLifeCouponOptionsResponseParam gWsIcsLifeCouponOptionsResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsIcsLifeCouponOptionsResponseParam);
    }

    public ICallBackWsIcsLifeCouponOptionsImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsIcsLifeCouponOptionsImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
