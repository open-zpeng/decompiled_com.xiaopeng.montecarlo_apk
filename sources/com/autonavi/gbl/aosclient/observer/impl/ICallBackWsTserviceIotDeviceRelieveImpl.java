package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotDeviceRelieveResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceIotDeviceRelieve;
@IntfAuto(target = ICallBackWsTserviceIotDeviceRelieve.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTserviceIotDeviceRelieveImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTserviceIotDeviceRelieveImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTserviceIotDeviceRelieveImpl_change_ownership(ICallBackWsTserviceIotDeviceRelieveImpl iCallBackWsTserviceIotDeviceRelieveImpl, long j, boolean z);

    private static native void ICallBackWsTserviceIotDeviceRelieveImpl_director_connect(ICallBackWsTserviceIotDeviceRelieveImpl iCallBackWsTserviceIotDeviceRelieveImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTserviceIotDeviceRelieveImpl iCallBackWsTserviceIotDeviceRelieveImpl, long j2, GWsTserviceIotDeviceRelieveResponseParam gWsTserviceIotDeviceRelieveResponseParam);

    public ICallBackWsTserviceIotDeviceRelieveImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTserviceIotDeviceRelieveImpl) && getUID(this) == getUID((ICallBackWsTserviceIotDeviceRelieveImpl) obj);
    }

    private static long getUID(ICallBackWsTserviceIotDeviceRelieveImpl iCallBackWsTserviceIotDeviceRelieveImpl) {
        long cPtr = getCPtr(iCallBackWsTserviceIotDeviceRelieveImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTserviceIotDeviceRelieveImpl iCallBackWsTserviceIotDeviceRelieveImpl) {
        if (iCallBackWsTserviceIotDeviceRelieveImpl == null) {
            return 0L;
        }
        return iCallBackWsTserviceIotDeviceRelieveImpl.swigCPtr;
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
        ICallBackWsTserviceIotDeviceRelieveImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTserviceIotDeviceRelieveImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTserviceIotDeviceRelieveResponseParam gWsTserviceIotDeviceRelieveResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTserviceIotDeviceRelieveResponseParam);
    }

    public ICallBackWsTserviceIotDeviceRelieveImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTserviceIotDeviceRelieveImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
