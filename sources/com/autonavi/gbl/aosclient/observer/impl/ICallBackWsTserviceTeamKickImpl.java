package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamKickResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamKick;
@IntfAuto(target = ICallBackWsTserviceTeamKick.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTserviceTeamKickImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTserviceTeamKickImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTserviceTeamKickImpl_change_ownership(ICallBackWsTserviceTeamKickImpl iCallBackWsTserviceTeamKickImpl, long j, boolean z);

    private static native void ICallBackWsTserviceTeamKickImpl_director_connect(ICallBackWsTserviceTeamKickImpl iCallBackWsTserviceTeamKickImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTserviceTeamKickImpl iCallBackWsTserviceTeamKickImpl, long j2, GWsTserviceTeamKickResponseParam gWsTserviceTeamKickResponseParam);

    public ICallBackWsTserviceTeamKickImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTserviceTeamKickImpl) && getUID(this) == getUID((ICallBackWsTserviceTeamKickImpl) obj);
    }

    private static long getUID(ICallBackWsTserviceTeamKickImpl iCallBackWsTserviceTeamKickImpl) {
        long cPtr = getCPtr(iCallBackWsTserviceTeamKickImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTserviceTeamKickImpl iCallBackWsTserviceTeamKickImpl) {
        if (iCallBackWsTserviceTeamKickImpl == null) {
            return 0L;
        }
        return iCallBackWsTserviceTeamKickImpl.swigCPtr;
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
        ICallBackWsTserviceTeamKickImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTserviceTeamKickImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTserviceTeamKickResponseParam gWsTserviceTeamKickResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTserviceTeamKickResponseParam);
    }

    public ICallBackWsTserviceTeamKickImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTserviceTeamKickImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
