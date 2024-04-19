package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamUserStatusResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamUserStatus;
@IntfAuto(target = ICallBackWsTserviceTeamUserStatus.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTserviceTeamUserStatusImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTserviceTeamUserStatusImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTserviceTeamUserStatusImpl_change_ownership(ICallBackWsTserviceTeamUserStatusImpl iCallBackWsTserviceTeamUserStatusImpl, long j, boolean z);

    private static native void ICallBackWsTserviceTeamUserStatusImpl_director_connect(ICallBackWsTserviceTeamUserStatusImpl iCallBackWsTserviceTeamUserStatusImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTserviceTeamUserStatusImpl iCallBackWsTserviceTeamUserStatusImpl, long j2, GWsTserviceTeamUserStatusResponseParam gWsTserviceTeamUserStatusResponseParam);

    public ICallBackWsTserviceTeamUserStatusImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTserviceTeamUserStatusImpl) && getUID(this) == getUID((ICallBackWsTserviceTeamUserStatusImpl) obj);
    }

    private static long getUID(ICallBackWsTserviceTeamUserStatusImpl iCallBackWsTserviceTeamUserStatusImpl) {
        long cPtr = getCPtr(iCallBackWsTserviceTeamUserStatusImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTserviceTeamUserStatusImpl iCallBackWsTserviceTeamUserStatusImpl) {
        if (iCallBackWsTserviceTeamUserStatusImpl == null) {
            return 0L;
        }
        return iCallBackWsTserviceTeamUserStatusImpl.swigCPtr;
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
        ICallBackWsTserviceTeamUserStatusImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTserviceTeamUserStatusImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTserviceTeamUserStatusResponseParam gWsTserviceTeamUserStatusResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTserviceTeamUserStatusResponseParam);
    }

    public ICallBackWsTserviceTeamUserStatusImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTserviceTeamUserStatusImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
