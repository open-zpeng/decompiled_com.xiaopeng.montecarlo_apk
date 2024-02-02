package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GWsPpAccountProfileUpdateResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAccountProfileUpdate;
@IntfAuto(target = ICallBackWsPpAccountProfileUpdate.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsPpAccountProfileUpdateImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsPpAccountProfileUpdateImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsPpAccountProfileUpdateImpl_change_ownership(ICallBackWsPpAccountProfileUpdateImpl iCallBackWsPpAccountProfileUpdateImpl, long j, boolean z);

    private static native void ICallBackWsPpAccountProfileUpdateImpl_director_connect(ICallBackWsPpAccountProfileUpdateImpl iCallBackWsPpAccountProfileUpdateImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsPpAccountProfileUpdateImpl iCallBackWsPpAccountProfileUpdateImpl, long j2, GWsPpAccountProfileUpdateResponseParam gWsPpAccountProfileUpdateResponseParam);

    public ICallBackWsPpAccountProfileUpdateImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsPpAccountProfileUpdateImpl) && getUID(this) == getUID((ICallBackWsPpAccountProfileUpdateImpl) obj);
    }

    private static long getUID(ICallBackWsPpAccountProfileUpdateImpl iCallBackWsPpAccountProfileUpdateImpl) {
        long cPtr = getCPtr(iCallBackWsPpAccountProfileUpdateImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsPpAccountProfileUpdateImpl iCallBackWsPpAccountProfileUpdateImpl) {
        if (iCallBackWsPpAccountProfileUpdateImpl == null) {
            return 0L;
        }
        return iCallBackWsPpAccountProfileUpdateImpl.swigCPtr;
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
        ICallBackWsPpAccountProfileUpdateImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsPpAccountProfileUpdateImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsPpAccountProfileUpdateResponseParam gWsPpAccountProfileUpdateResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsPpAccountProfileUpdateResponseParam);
    }

    public ICallBackWsPpAccountProfileUpdateImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsPpAccountProfileUpdateImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
