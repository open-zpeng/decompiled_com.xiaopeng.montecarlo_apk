package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GTrafficRestrictResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackTrafficRestrict;
@IntfAuto(target = ICallBackTrafficRestrict.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackTrafficRestrictImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackTrafficRestrictImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackTrafficRestrictImpl_change_ownership(ICallBackTrafficRestrictImpl iCallBackTrafficRestrictImpl, long j, boolean z);

    private static native void ICallBackTrafficRestrictImpl_director_connect(ICallBackTrafficRestrictImpl iCallBackTrafficRestrictImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackTrafficRestrictImpl iCallBackTrafficRestrictImpl, long j2, GTrafficRestrictResponseParam gTrafficRestrictResponseParam);

    public ICallBackTrafficRestrictImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackTrafficRestrictImpl) && getUID(this) == getUID((ICallBackTrafficRestrictImpl) obj);
    }

    private static long getUID(ICallBackTrafficRestrictImpl iCallBackTrafficRestrictImpl) {
        long cPtr = getCPtr(iCallBackTrafficRestrictImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackTrafficRestrictImpl iCallBackTrafficRestrictImpl) {
        if (iCallBackTrafficRestrictImpl == null) {
            return 0L;
        }
        return iCallBackTrafficRestrictImpl.swigCPtr;
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
        ICallBackTrafficRestrictImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackTrafficRestrictImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GTrafficRestrictResponseParam gTrafficRestrictResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gTrafficRestrictResponseParam);
    }

    public ICallBackTrafficRestrictImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackTrafficRestrictImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
