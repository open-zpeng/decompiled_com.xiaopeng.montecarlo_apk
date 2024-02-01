package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsMapapiPoiVoicesearchResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsMapapiPoiVoicesearch;
@IntfAuto(target = ICallBackWsMapapiPoiVoicesearch.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsMapapiPoiVoicesearchImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsMapapiPoiVoicesearchImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsMapapiPoiVoicesearchImpl_change_ownership(ICallBackWsMapapiPoiVoicesearchImpl iCallBackWsMapapiPoiVoicesearchImpl, long j, boolean z);

    private static native void ICallBackWsMapapiPoiVoicesearchImpl_director_connect(ICallBackWsMapapiPoiVoicesearchImpl iCallBackWsMapapiPoiVoicesearchImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsMapapiPoiVoicesearchImpl iCallBackWsMapapiPoiVoicesearchImpl, long j2, GWsMapapiPoiVoicesearchResponseParam gWsMapapiPoiVoicesearchResponseParam);

    public ICallBackWsMapapiPoiVoicesearchImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsMapapiPoiVoicesearchImpl) && getUID(this) == getUID((ICallBackWsMapapiPoiVoicesearchImpl) obj);
    }

    private static long getUID(ICallBackWsMapapiPoiVoicesearchImpl iCallBackWsMapapiPoiVoicesearchImpl) {
        long cPtr = getCPtr(iCallBackWsMapapiPoiVoicesearchImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsMapapiPoiVoicesearchImpl iCallBackWsMapapiPoiVoicesearchImpl) {
        if (iCallBackWsMapapiPoiVoicesearchImpl == null) {
            return 0L;
        }
        return iCallBackWsMapapiPoiVoicesearchImpl.swigCPtr;
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
        ICallBackWsMapapiPoiVoicesearchImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsMapapiPoiVoicesearchImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsMapapiPoiVoicesearchResponseParam gWsMapapiPoiVoicesearchResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsMapapiPoiVoicesearchResponseParam);
    }

    public ICallBackWsMapapiPoiVoicesearchImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsMapapiPoiVoicesearchImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
