package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsPpContactUnbindMobileResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpContactUnbindMobile;
@IntfAuto(target = ICallBackWsPpContactUnbindMobile.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsPpContactUnbindMobileImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsPpContactUnbindMobileImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsPpContactUnbindMobileImpl_change_ownership(ICallBackWsPpContactUnbindMobileImpl iCallBackWsPpContactUnbindMobileImpl, long j, boolean z);

    private static native void ICallBackWsPpContactUnbindMobileImpl_director_connect(ICallBackWsPpContactUnbindMobileImpl iCallBackWsPpContactUnbindMobileImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsPpContactUnbindMobileImpl iCallBackWsPpContactUnbindMobileImpl, long j2, GWsPpContactUnbindMobileResponseParam gWsPpContactUnbindMobileResponseParam);

    public ICallBackWsPpContactUnbindMobileImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsPpContactUnbindMobileImpl) && getUID(this) == getUID((ICallBackWsPpContactUnbindMobileImpl) obj);
    }

    private static long getUID(ICallBackWsPpContactUnbindMobileImpl iCallBackWsPpContactUnbindMobileImpl) {
        long cPtr = getCPtr(iCallBackWsPpContactUnbindMobileImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsPpContactUnbindMobileImpl iCallBackWsPpContactUnbindMobileImpl) {
        if (iCallBackWsPpContactUnbindMobileImpl == null) {
            return 0L;
        }
        return iCallBackWsPpContactUnbindMobileImpl.swigCPtr;
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
        ICallBackWsPpContactUnbindMobileImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsPpContactUnbindMobileImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsPpContactUnbindMobileResponseParam gWsPpContactUnbindMobileResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsPpContactUnbindMobileResponseParam);
    }

    public ICallBackWsPpContactUnbindMobileImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsPpContactUnbindMobileImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
