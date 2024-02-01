package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsMapapiLinkidsResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiLinkids;
@IntfAuto(target = ICallBackWsMapapiLinkids.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsMapapiLinkidsImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsMapapiLinkidsImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsMapapiLinkidsImpl_change_ownership(ICallBackWsMapapiLinkidsImpl iCallBackWsMapapiLinkidsImpl, long j, boolean z);

    private static native void ICallBackWsMapapiLinkidsImpl_director_connect(ICallBackWsMapapiLinkidsImpl iCallBackWsMapapiLinkidsImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsMapapiLinkidsImpl iCallBackWsMapapiLinkidsImpl, long j2, GWsMapapiLinkidsResponseParam gWsMapapiLinkidsResponseParam);

    public ICallBackWsMapapiLinkidsImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsMapapiLinkidsImpl) && getUID(this) == getUID((ICallBackWsMapapiLinkidsImpl) obj);
    }

    private static long getUID(ICallBackWsMapapiLinkidsImpl iCallBackWsMapapiLinkidsImpl) {
        long cPtr = getCPtr(iCallBackWsMapapiLinkidsImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsMapapiLinkidsImpl iCallBackWsMapapiLinkidsImpl) {
        if (iCallBackWsMapapiLinkidsImpl == null) {
            return 0L;
        }
        return iCallBackWsMapapiLinkidsImpl.swigCPtr;
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
        ICallBackWsMapapiLinkidsImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsMapapiLinkidsImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsMapapiLinkidsResponseParam gWsMapapiLinkidsResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsMapapiLinkidsResponseParam);
    }

    public ICallBackWsMapapiLinkidsImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsMapapiLinkidsImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
