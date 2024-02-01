package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsAppConfAppUpdateResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAppConfAppUpdate;
@IntfAuto(target = ICallBackWsAppConfAppUpdate.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsAppConfAppUpdateImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsAppConfAppUpdateImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsAppConfAppUpdateImpl_change_ownership(ICallBackWsAppConfAppUpdateImpl iCallBackWsAppConfAppUpdateImpl, long j, boolean z);

    private static native void ICallBackWsAppConfAppUpdateImpl_director_connect(ICallBackWsAppConfAppUpdateImpl iCallBackWsAppConfAppUpdateImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsAppConfAppUpdateImpl iCallBackWsAppConfAppUpdateImpl, long j2, GWsAppConfAppUpdateResponseParam gWsAppConfAppUpdateResponseParam);

    public ICallBackWsAppConfAppUpdateImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsAppConfAppUpdateImpl) && getUID(this) == getUID((ICallBackWsAppConfAppUpdateImpl) obj);
    }

    private static long getUID(ICallBackWsAppConfAppUpdateImpl iCallBackWsAppConfAppUpdateImpl) {
        long cPtr = getCPtr(iCallBackWsAppConfAppUpdateImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsAppConfAppUpdateImpl iCallBackWsAppConfAppUpdateImpl) {
        if (iCallBackWsAppConfAppUpdateImpl == null) {
            return 0L;
        }
        return iCallBackWsAppConfAppUpdateImpl.swigCPtr;
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
        ICallBackWsAppConfAppUpdateImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsAppConfAppUpdateImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsAppConfAppUpdateResponseParam gWsAppConfAppUpdateResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsAppConfAppUpdateResponseParam);
    }

    public ICallBackWsAppConfAppUpdateImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsAppConfAppUpdateImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
