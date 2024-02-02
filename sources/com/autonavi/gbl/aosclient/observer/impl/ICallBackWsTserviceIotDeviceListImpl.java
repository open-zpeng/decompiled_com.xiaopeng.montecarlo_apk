package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotDeviceListResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceIotDeviceList;
@IntfAuto(target = ICallBackWsTserviceIotDeviceList.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTserviceIotDeviceListImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTserviceIotDeviceListImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTserviceIotDeviceListImpl_change_ownership(ICallBackWsTserviceIotDeviceListImpl iCallBackWsTserviceIotDeviceListImpl, long j, boolean z);

    private static native void ICallBackWsTserviceIotDeviceListImpl_director_connect(ICallBackWsTserviceIotDeviceListImpl iCallBackWsTserviceIotDeviceListImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTserviceIotDeviceListImpl iCallBackWsTserviceIotDeviceListImpl, long j2, GWsTserviceIotDeviceListResponseParam gWsTserviceIotDeviceListResponseParam);

    public ICallBackWsTserviceIotDeviceListImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTserviceIotDeviceListImpl) && getUID(this) == getUID((ICallBackWsTserviceIotDeviceListImpl) obj);
    }

    private static long getUID(ICallBackWsTserviceIotDeviceListImpl iCallBackWsTserviceIotDeviceListImpl) {
        long cPtr = getCPtr(iCallBackWsTserviceIotDeviceListImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTserviceIotDeviceListImpl iCallBackWsTserviceIotDeviceListImpl) {
        if (iCallBackWsTserviceIotDeviceListImpl == null) {
            return 0L;
        }
        return iCallBackWsTserviceIotDeviceListImpl.swigCPtr;
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
        ICallBackWsTserviceIotDeviceListImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTserviceIotDeviceListImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTserviceIotDeviceListResponseParam gWsTserviceIotDeviceListResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTserviceIotDeviceListResponseParam);
    }

    public ICallBackWsTserviceIotDeviceListImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTserviceIotDeviceListImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
