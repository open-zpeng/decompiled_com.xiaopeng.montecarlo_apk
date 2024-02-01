package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamUserTnnUpdateResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamUserTnnUpdate;
@IntfAuto(target = ICallBackWsTserviceTeamUserTnnUpdate.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTserviceTeamUserTnnUpdateImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTserviceTeamUserTnnUpdateImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTserviceTeamUserTnnUpdateImpl_change_ownership(ICallBackWsTserviceTeamUserTnnUpdateImpl iCallBackWsTserviceTeamUserTnnUpdateImpl, long j, boolean z);

    private static native void ICallBackWsTserviceTeamUserTnnUpdateImpl_director_connect(ICallBackWsTserviceTeamUserTnnUpdateImpl iCallBackWsTserviceTeamUserTnnUpdateImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTserviceTeamUserTnnUpdateImpl iCallBackWsTserviceTeamUserTnnUpdateImpl, long j2, GWsTserviceTeamUserTnnUpdateResponseParam gWsTserviceTeamUserTnnUpdateResponseParam);

    public ICallBackWsTserviceTeamUserTnnUpdateImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTserviceTeamUserTnnUpdateImpl) && getUID(this) == getUID((ICallBackWsTserviceTeamUserTnnUpdateImpl) obj);
    }

    private static long getUID(ICallBackWsTserviceTeamUserTnnUpdateImpl iCallBackWsTserviceTeamUserTnnUpdateImpl) {
        long cPtr = getCPtr(iCallBackWsTserviceTeamUserTnnUpdateImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTserviceTeamUserTnnUpdateImpl iCallBackWsTserviceTeamUserTnnUpdateImpl) {
        if (iCallBackWsTserviceTeamUserTnnUpdateImpl == null) {
            return 0L;
        }
        return iCallBackWsTserviceTeamUserTnnUpdateImpl.swigCPtr;
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
        ICallBackWsTserviceTeamUserTnnUpdateImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTserviceTeamUserTnnUpdateImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTserviceTeamUserTnnUpdateResponseParam gWsTserviceTeamUserTnnUpdateResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTserviceTeamUserTnnUpdateResponseParam);
    }

    public ICallBackWsTserviceTeamUserTnnUpdateImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTserviceTeamUserTnnUpdateImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
