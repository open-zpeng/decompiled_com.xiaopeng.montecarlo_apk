package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamQuitResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamQuit;
@IntfAuto(target = ICallBackWsTserviceTeamQuit.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTserviceTeamQuitImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTserviceTeamQuitImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTserviceTeamQuitImpl_change_ownership(ICallBackWsTserviceTeamQuitImpl iCallBackWsTserviceTeamQuitImpl, long j, boolean z);

    private static native void ICallBackWsTserviceTeamQuitImpl_director_connect(ICallBackWsTserviceTeamQuitImpl iCallBackWsTserviceTeamQuitImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTserviceTeamQuitImpl iCallBackWsTserviceTeamQuitImpl, long j2, GWsTserviceTeamQuitResponseParam gWsTserviceTeamQuitResponseParam);

    public ICallBackWsTserviceTeamQuitImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTserviceTeamQuitImpl) && getUID(this) == getUID((ICallBackWsTserviceTeamQuitImpl) obj);
    }

    private static long getUID(ICallBackWsTserviceTeamQuitImpl iCallBackWsTserviceTeamQuitImpl) {
        long cPtr = getCPtr(iCallBackWsTserviceTeamQuitImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTserviceTeamQuitImpl iCallBackWsTserviceTeamQuitImpl) {
        if (iCallBackWsTserviceTeamQuitImpl == null) {
            return 0L;
        }
        return iCallBackWsTserviceTeamQuitImpl.swigCPtr;
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
        ICallBackWsTserviceTeamQuitImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTserviceTeamQuitImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTserviceTeamQuitResponseParam gWsTserviceTeamQuitResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTserviceTeamQuitResponseParam);
    }

    public ICallBackWsTserviceTeamQuitImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTserviceTeamQuitImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
