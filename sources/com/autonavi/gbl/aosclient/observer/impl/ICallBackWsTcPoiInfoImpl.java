package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcPoiInfoResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcPoiInfo;
@IntfAuto(target = ICallBackWsTcPoiInfo.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTcPoiInfoImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTcPoiInfoImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTcPoiInfoImpl_change_ownership(ICallBackWsTcPoiInfoImpl iCallBackWsTcPoiInfoImpl, long j, boolean z);

    private static native void ICallBackWsTcPoiInfoImpl_director_connect(ICallBackWsTcPoiInfoImpl iCallBackWsTcPoiInfoImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTcPoiInfoImpl iCallBackWsTcPoiInfoImpl, long j2, GWsTcPoiInfoResponseParam gWsTcPoiInfoResponseParam);

    public ICallBackWsTcPoiInfoImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTcPoiInfoImpl) && getUID(this) == getUID((ICallBackWsTcPoiInfoImpl) obj);
    }

    private static long getUID(ICallBackWsTcPoiInfoImpl iCallBackWsTcPoiInfoImpl) {
        long cPtr = getCPtr(iCallBackWsTcPoiInfoImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTcPoiInfoImpl iCallBackWsTcPoiInfoImpl) {
        if (iCallBackWsTcPoiInfoImpl == null) {
            return 0L;
        }
        return iCallBackWsTcPoiInfoImpl.swigCPtr;
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
        ICallBackWsTcPoiInfoImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTcPoiInfoImpl_change_ownership(this, this.swigCPtr, true);
    }

    public ICallBackWsTcPoiInfoImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTcPoiInfoImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void onRecvAck(GWsTcPoiInfoResponseParam gWsTcPoiInfoResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTcPoiInfoResponseParam);
    }
}
