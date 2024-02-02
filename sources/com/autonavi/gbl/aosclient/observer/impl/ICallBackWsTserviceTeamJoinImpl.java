package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamJoinResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamJoin;
@IntfAuto(target = ICallBackWsTserviceTeamJoin.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTserviceTeamJoinImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTserviceTeamJoinImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTserviceTeamJoinImpl_change_ownership(ICallBackWsTserviceTeamJoinImpl iCallBackWsTserviceTeamJoinImpl, long j, boolean z);

    private static native void ICallBackWsTserviceTeamJoinImpl_director_connect(ICallBackWsTserviceTeamJoinImpl iCallBackWsTserviceTeamJoinImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTserviceTeamJoinImpl iCallBackWsTserviceTeamJoinImpl, long j2, GWsTserviceTeamJoinResponseParam gWsTserviceTeamJoinResponseParam);

    public ICallBackWsTserviceTeamJoinImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTserviceTeamJoinImpl) && getUID(this) == getUID((ICallBackWsTserviceTeamJoinImpl) obj);
    }

    private static long getUID(ICallBackWsTserviceTeamJoinImpl iCallBackWsTserviceTeamJoinImpl) {
        long cPtr = getCPtr(iCallBackWsTserviceTeamJoinImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTserviceTeamJoinImpl iCallBackWsTserviceTeamJoinImpl) {
        if (iCallBackWsTserviceTeamJoinImpl == null) {
            return 0L;
        }
        return iCallBackWsTserviceTeamJoinImpl.swigCPtr;
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
        ICallBackWsTserviceTeamJoinImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTserviceTeamJoinImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTserviceTeamJoinResponseParam gWsTserviceTeamJoinResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTserviceTeamJoinResponseParam);
    }

    public ICallBackWsTserviceTeamJoinImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTserviceTeamJoinImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
