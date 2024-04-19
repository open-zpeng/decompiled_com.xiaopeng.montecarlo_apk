package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchRanklistPortalResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldSearchRanklistPortal;
@IntfAuto(target = ICallBackWsShieldSearchRanklistPortal.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsShieldSearchRanklistPortalImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsShieldSearchRanklistPortalImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsShieldSearchRanklistPortalImpl_change_ownership(ICallBackWsShieldSearchRanklistPortalImpl iCallBackWsShieldSearchRanklistPortalImpl, long j, boolean z);

    private static native void ICallBackWsShieldSearchRanklistPortalImpl_director_connect(ICallBackWsShieldSearchRanklistPortalImpl iCallBackWsShieldSearchRanklistPortalImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsShieldSearchRanklistPortalImpl iCallBackWsShieldSearchRanklistPortalImpl, long j2, GWsShieldSearchRanklistPortalResponseParam gWsShieldSearchRanklistPortalResponseParam);

    public ICallBackWsShieldSearchRanklistPortalImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsShieldSearchRanklistPortalImpl) && getUID(this) == getUID((ICallBackWsShieldSearchRanklistPortalImpl) obj);
    }

    private static long getUID(ICallBackWsShieldSearchRanklistPortalImpl iCallBackWsShieldSearchRanklistPortalImpl) {
        long cPtr = getCPtr(iCallBackWsShieldSearchRanklistPortalImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsShieldSearchRanklistPortalImpl iCallBackWsShieldSearchRanklistPortalImpl) {
        if (iCallBackWsShieldSearchRanklistPortalImpl == null) {
            return 0L;
        }
        return iCallBackWsShieldSearchRanklistPortalImpl.swigCPtr;
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
        ICallBackWsShieldSearchRanklistPortalImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsShieldSearchRanklistPortalImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsShieldSearchRanklistPortalResponseParam gWsShieldSearchRanklistPortalResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsShieldSearchRanklistPortalResponseParam);
    }

    public ICallBackWsShieldSearchRanklistPortalImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsShieldSearchRanklistPortalImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
