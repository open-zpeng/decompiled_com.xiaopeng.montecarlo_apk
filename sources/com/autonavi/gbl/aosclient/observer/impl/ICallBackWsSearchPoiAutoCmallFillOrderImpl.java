package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsSearchPoiAutoCmallFillOrderResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsSearchPoiAutoCmallFillOrder;
@IntfAuto(target = ICallBackWsSearchPoiAutoCmallFillOrder.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsSearchPoiAutoCmallFillOrderImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsSearchPoiAutoCmallFillOrderImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsSearchPoiAutoCmallFillOrderImpl_change_ownership(ICallBackWsSearchPoiAutoCmallFillOrderImpl iCallBackWsSearchPoiAutoCmallFillOrderImpl, long j, boolean z);

    private static native void ICallBackWsSearchPoiAutoCmallFillOrderImpl_director_connect(ICallBackWsSearchPoiAutoCmallFillOrderImpl iCallBackWsSearchPoiAutoCmallFillOrderImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsSearchPoiAutoCmallFillOrderImpl iCallBackWsSearchPoiAutoCmallFillOrderImpl, long j2, GWsSearchPoiAutoCmallFillOrderResponseParam gWsSearchPoiAutoCmallFillOrderResponseParam);

    public ICallBackWsSearchPoiAutoCmallFillOrderImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsSearchPoiAutoCmallFillOrderImpl) && getUID(this) == getUID((ICallBackWsSearchPoiAutoCmallFillOrderImpl) obj);
    }

    private static long getUID(ICallBackWsSearchPoiAutoCmallFillOrderImpl iCallBackWsSearchPoiAutoCmallFillOrderImpl) {
        long cPtr = getCPtr(iCallBackWsSearchPoiAutoCmallFillOrderImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsSearchPoiAutoCmallFillOrderImpl iCallBackWsSearchPoiAutoCmallFillOrderImpl) {
        if (iCallBackWsSearchPoiAutoCmallFillOrderImpl == null) {
            return 0L;
        }
        return iCallBackWsSearchPoiAutoCmallFillOrderImpl.swigCPtr;
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
        ICallBackWsSearchPoiAutoCmallFillOrderImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsSearchPoiAutoCmallFillOrderImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsSearchPoiAutoCmallFillOrderResponseParam gWsSearchPoiAutoCmallFillOrderResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsSearchPoiAutoCmallFillOrderResponseParam);
    }

    public ICallBackWsSearchPoiAutoCmallFillOrderImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsSearchPoiAutoCmallFillOrderImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
