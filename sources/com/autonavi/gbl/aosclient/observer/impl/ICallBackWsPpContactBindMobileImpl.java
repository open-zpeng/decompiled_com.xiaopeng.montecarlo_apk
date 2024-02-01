package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsPpContactBindMobileResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpContactBindMobile;
@IntfAuto(target = ICallBackWsPpContactBindMobile.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsPpContactBindMobileImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsPpContactBindMobileImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsPpContactBindMobileImpl_change_ownership(ICallBackWsPpContactBindMobileImpl iCallBackWsPpContactBindMobileImpl, long j, boolean z);

    private static native void ICallBackWsPpContactBindMobileImpl_director_connect(ICallBackWsPpContactBindMobileImpl iCallBackWsPpContactBindMobileImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsPpContactBindMobileImpl iCallBackWsPpContactBindMobileImpl, long j2, GWsPpContactBindMobileResponseParam gWsPpContactBindMobileResponseParam);

    public ICallBackWsPpContactBindMobileImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsPpContactBindMobileImpl) && getUID(this) == getUID((ICallBackWsPpContactBindMobileImpl) obj);
    }

    private static long getUID(ICallBackWsPpContactBindMobileImpl iCallBackWsPpContactBindMobileImpl) {
        long cPtr = getCPtr(iCallBackWsPpContactBindMobileImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsPpContactBindMobileImpl iCallBackWsPpContactBindMobileImpl) {
        if (iCallBackWsPpContactBindMobileImpl == null) {
            return 0L;
        }
        return iCallBackWsPpContactBindMobileImpl.swigCPtr;
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
        ICallBackWsPpContactBindMobileImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsPpContactBindMobileImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsPpContactBindMobileResponseParam gWsPpContactBindMobileResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsPpContactBindMobileResponseParam);
    }

    public ICallBackWsPpContactBindMobileImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsPpContactBindMobileImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
