package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GWsAudiHcp3EventSearchResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAudiHcp3EventSearch;
@IntfAuto(target = ICallBackWsAudiHcp3EventSearch.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsAudiHcp3EventSearchImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsAudiHcp3EventSearchImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsAudiHcp3EventSearchImpl_change_ownership(ICallBackWsAudiHcp3EventSearchImpl iCallBackWsAudiHcp3EventSearchImpl, long j, boolean z);

    private static native void ICallBackWsAudiHcp3EventSearchImpl_director_connect(ICallBackWsAudiHcp3EventSearchImpl iCallBackWsAudiHcp3EventSearchImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsAudiHcp3EventSearchImpl iCallBackWsAudiHcp3EventSearchImpl, long j2, GWsAudiHcp3EventSearchResponseParam gWsAudiHcp3EventSearchResponseParam);

    public ICallBackWsAudiHcp3EventSearchImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsAudiHcp3EventSearchImpl) && getUID(this) == getUID((ICallBackWsAudiHcp3EventSearchImpl) obj);
    }

    private static long getUID(ICallBackWsAudiHcp3EventSearchImpl iCallBackWsAudiHcp3EventSearchImpl) {
        long cPtr = getCPtr(iCallBackWsAudiHcp3EventSearchImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsAudiHcp3EventSearchImpl iCallBackWsAudiHcp3EventSearchImpl) {
        if (iCallBackWsAudiHcp3EventSearchImpl == null) {
            return 0L;
        }
        return iCallBackWsAudiHcp3EventSearchImpl.swigCPtr;
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
        ICallBackWsAudiHcp3EventSearchImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsAudiHcp3EventSearchImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsAudiHcp3EventSearchResponseParam gWsAudiHcp3EventSearchResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsAudiHcp3EventSearchResponseParam);
    }

    public ICallBackWsAudiHcp3EventSearchImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsAudiHcp3EventSearchImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
