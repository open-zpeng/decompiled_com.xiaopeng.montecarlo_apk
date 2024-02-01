package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsAosDestinationSearchResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsAosDestinationSearch;
@IntfAuto(target = ICallBackWsAosDestinationSearch.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsAosDestinationSearchImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsAosDestinationSearchImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsAosDestinationSearchImpl_change_ownership(ICallBackWsAosDestinationSearchImpl iCallBackWsAosDestinationSearchImpl, long j, boolean z);

    private static native void ICallBackWsAosDestinationSearchImpl_director_connect(ICallBackWsAosDestinationSearchImpl iCallBackWsAosDestinationSearchImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsAosDestinationSearchImpl iCallBackWsAosDestinationSearchImpl, long j2, GWsAosDestinationSearchResponseParam gWsAosDestinationSearchResponseParam);

    public ICallBackWsAosDestinationSearchImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsAosDestinationSearchImpl) && getUID(this) == getUID((ICallBackWsAosDestinationSearchImpl) obj);
    }

    private static long getUID(ICallBackWsAosDestinationSearchImpl iCallBackWsAosDestinationSearchImpl) {
        long cPtr = getCPtr(iCallBackWsAosDestinationSearchImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsAosDestinationSearchImpl iCallBackWsAosDestinationSearchImpl) {
        if (iCallBackWsAosDestinationSearchImpl == null) {
            return 0L;
        }
        return iCallBackWsAosDestinationSearchImpl.swigCPtr;
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
        ICallBackWsAosDestinationSearchImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsAosDestinationSearchImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsAosDestinationSearchResponseParam gWsAosDestinationSearchResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsAosDestinationSearchResponseParam);
    }

    public ICallBackWsAosDestinationSearchImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsAosDestinationSearchImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
