package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamInfoGetResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamInfoGet;
@IntfAuto(target = ICallBackWsTserviceTeamInfoGet.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTserviceTeamInfoGetImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTserviceTeamInfoGetImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTserviceTeamInfoGetImpl_change_ownership(ICallBackWsTserviceTeamInfoGetImpl iCallBackWsTserviceTeamInfoGetImpl, long j, boolean z);

    private static native void ICallBackWsTserviceTeamInfoGetImpl_director_connect(ICallBackWsTserviceTeamInfoGetImpl iCallBackWsTserviceTeamInfoGetImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTserviceTeamInfoGetImpl iCallBackWsTserviceTeamInfoGetImpl, long j2, GWsTserviceTeamInfoGetResponseParam gWsTserviceTeamInfoGetResponseParam);

    public ICallBackWsTserviceTeamInfoGetImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTserviceTeamInfoGetImpl) && getUID(this) == getUID((ICallBackWsTserviceTeamInfoGetImpl) obj);
    }

    private static long getUID(ICallBackWsTserviceTeamInfoGetImpl iCallBackWsTserviceTeamInfoGetImpl) {
        long cPtr = getCPtr(iCallBackWsTserviceTeamInfoGetImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTserviceTeamInfoGetImpl iCallBackWsTserviceTeamInfoGetImpl) {
        if (iCallBackWsTserviceTeamInfoGetImpl == null) {
            return 0L;
        }
        return iCallBackWsTserviceTeamInfoGetImpl.swigCPtr;
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
        ICallBackWsTserviceTeamInfoGetImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTserviceTeamInfoGetImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTserviceTeamInfoGetResponseParam gWsTserviceTeamInfoGetResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTserviceTeamInfoGetResponseParam);
    }

    public ICallBackWsTserviceTeamInfoGetImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTserviceTeamInfoGetImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
