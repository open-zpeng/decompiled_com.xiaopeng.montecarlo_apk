package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamInfoUpdateResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamInfoUpdate;
@IntfAuto(target = ICallBackWsTserviceTeamInfoUpdate.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTserviceTeamInfoUpdateImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTserviceTeamInfoUpdateImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTserviceTeamInfoUpdateImpl_change_ownership(ICallBackWsTserviceTeamInfoUpdateImpl iCallBackWsTserviceTeamInfoUpdateImpl, long j, boolean z);

    private static native void ICallBackWsTserviceTeamInfoUpdateImpl_director_connect(ICallBackWsTserviceTeamInfoUpdateImpl iCallBackWsTserviceTeamInfoUpdateImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTserviceTeamInfoUpdateImpl iCallBackWsTserviceTeamInfoUpdateImpl, long j2, GWsTserviceTeamInfoUpdateResponseParam gWsTserviceTeamInfoUpdateResponseParam);

    public ICallBackWsTserviceTeamInfoUpdateImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTserviceTeamInfoUpdateImpl) && getUID(this) == getUID((ICallBackWsTserviceTeamInfoUpdateImpl) obj);
    }

    private static long getUID(ICallBackWsTserviceTeamInfoUpdateImpl iCallBackWsTserviceTeamInfoUpdateImpl) {
        long cPtr = getCPtr(iCallBackWsTserviceTeamInfoUpdateImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTserviceTeamInfoUpdateImpl iCallBackWsTserviceTeamInfoUpdateImpl) {
        if (iCallBackWsTserviceTeamInfoUpdateImpl == null) {
            return 0L;
        }
        return iCallBackWsTserviceTeamInfoUpdateImpl.swigCPtr;
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
        ICallBackWsTserviceTeamInfoUpdateImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTserviceTeamInfoUpdateImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTserviceTeamInfoUpdateResponseParam gWsTserviceTeamInfoUpdateResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTserviceTeamInfoUpdateResponseParam);
    }

    public ICallBackWsTserviceTeamInfoUpdateImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTserviceTeamInfoUpdateImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
