package com.autonavi.gbl.data.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.data.model.AutoInitResponseData;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.observer.IHotUpdateCheckObserver;
@IntfAuto(target = IHotUpdateCheckObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IHotUpdateCheckObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IHotUpdateCheckObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IHotUpdateCheckObserverImpl_change_ownership(IHotUpdateCheckObserverImpl iHotUpdateCheckObserverImpl, long j, boolean z);

    private static native void IHotUpdateCheckObserverImpl_director_connect(IHotUpdateCheckObserverImpl iHotUpdateCheckObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onInitNotifyNative(long j, IHotUpdateCheckObserverImpl iHotUpdateCheckObserverImpl, int i, long j2, AutoInitResponseData autoInitResponseData);

    public IHotUpdateCheckObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IHotUpdateCheckObserverImpl) && getUID(this) == getUID((IHotUpdateCheckObserverImpl) obj);
    }

    private static long getUID(IHotUpdateCheckObserverImpl iHotUpdateCheckObserverImpl) {
        long cPtr = getCPtr(iHotUpdateCheckObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IHotUpdateCheckObserverImpl iHotUpdateCheckObserverImpl) {
        if (iHotUpdateCheckObserverImpl == null) {
            return 0L;
        }
        return iHotUpdateCheckObserverImpl.swigCPtr;
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
        IHotUpdateCheckObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IHotUpdateCheckObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onInitNotify(@OperationErrCode.OperationErrCode1 int i, AutoInitResponseData autoInitResponseData) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onInitNotifyNative(j, this, i, 0L, autoInitResponseData);
    }

    public IHotUpdateCheckObserverImpl() {
        this(createNativeObj(), true);
        DataObserverJNI.swig_jni_init();
        IHotUpdateCheckObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
