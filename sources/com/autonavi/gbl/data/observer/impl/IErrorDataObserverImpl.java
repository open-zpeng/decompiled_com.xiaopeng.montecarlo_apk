package com.autonavi.gbl.data.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.data.model.DataErrorType;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.observer.IErrorDataObserver;
@IntfAuto(target = IErrorDataObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IErrorDataObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IErrorDataObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IErrorDataObserverImpl_change_ownership(IErrorDataObserverImpl iErrorDataObserverImpl, long j, boolean z);

    private static native void IErrorDataObserverImpl_director_connect(IErrorDataObserverImpl iErrorDataObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onDeleteErrorDataNative(long j, IErrorDataObserverImpl iErrorDataObserverImpl, int i, int i2, int i3, int i4);

    private static native void onErrorNotifyHNative(long j, IErrorDataObserverImpl iErrorDataObserverImpl, int i, int i2, int i3, int i4, String str);

    private static native void onErrorNotifyNative(long j, IErrorDataObserverImpl iErrorDataObserverImpl, int i, int i2, int i3, int i4, String str);

    public IErrorDataObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IErrorDataObserverImpl) && getUID(this) == getUID((IErrorDataObserverImpl) obj);
    }

    private static long getUID(IErrorDataObserverImpl iErrorDataObserverImpl) {
        long cPtr = getCPtr(iErrorDataObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IErrorDataObserverImpl iErrorDataObserverImpl) {
        if (iErrorDataObserverImpl == null) {
            return 0L;
        }
        return iErrorDataObserverImpl.swigCPtr;
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
        IErrorDataObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IErrorDataObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onErrorNotify(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, @DataErrorType.DataErrorType1 int i4, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onErrorNotifyNative(j, this, i, i2, i3, i4, str);
    }

    public void onErrorNotifyH(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, @DataErrorType.DataErrorType1 int i4, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onErrorNotifyHNative(j, this, i, i2, i3, i4, str);
    }

    public void onDeleteErrorData(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, @OperationErrCode.OperationErrCode1 int i4) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onDeleteErrorDataNative(j, this, i, i2, i3, i4);
    }

    public IErrorDataObserverImpl() {
        this(createNativeObj(), true);
        DataObserverJNI.swig_jni_init();
        IErrorDataObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
