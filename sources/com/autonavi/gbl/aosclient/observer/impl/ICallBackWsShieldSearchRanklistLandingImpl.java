package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchRanklistLandingResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldSearchRanklistLanding;
@IntfAuto(target = ICallBackWsShieldSearchRanklistLanding.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsShieldSearchRanklistLandingImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsShieldSearchRanklistLandingImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsShieldSearchRanklistLandingImpl_change_ownership(ICallBackWsShieldSearchRanklistLandingImpl iCallBackWsShieldSearchRanklistLandingImpl, long j, boolean z);

    private static native void ICallBackWsShieldSearchRanklistLandingImpl_director_connect(ICallBackWsShieldSearchRanklistLandingImpl iCallBackWsShieldSearchRanklistLandingImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsShieldSearchRanklistLandingImpl iCallBackWsShieldSearchRanklistLandingImpl, long j2, GWsShieldSearchRanklistLandingResponseParam gWsShieldSearchRanklistLandingResponseParam);

    public ICallBackWsShieldSearchRanklistLandingImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsShieldSearchRanklistLandingImpl) && getUID(this) == getUID((ICallBackWsShieldSearchRanklistLandingImpl) obj);
    }

    private static long getUID(ICallBackWsShieldSearchRanklistLandingImpl iCallBackWsShieldSearchRanklistLandingImpl) {
        long cPtr = getCPtr(iCallBackWsShieldSearchRanklistLandingImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsShieldSearchRanklistLandingImpl iCallBackWsShieldSearchRanklistLandingImpl) {
        if (iCallBackWsShieldSearchRanklistLandingImpl == null) {
            return 0L;
        }
        return iCallBackWsShieldSearchRanklistLandingImpl.swigCPtr;
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
        ICallBackWsShieldSearchRanklistLandingImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsShieldSearchRanklistLandingImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsShieldSearchRanklistLandingResponseParam gWsShieldSearchRanklistLandingResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsShieldSearchRanklistLandingResponseParam);
    }

    public ICallBackWsShieldSearchRanklistLandingImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsShieldSearchRanklistLandingImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
