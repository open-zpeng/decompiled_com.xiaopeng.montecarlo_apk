package com.autonavi.gbl.data.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.observer.IDataInitObserver;
@IntfAuto(target = IDataInitObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IDataInitObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IDataInitObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IDataInitObserverImpl_change_ownership(IDataInitObserverImpl iDataInitObserverImpl, long j, boolean z);

    private static native void IDataInitObserverImpl_director_connect(IDataInitObserverImpl iDataInitObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onInitNative(long j, IDataInitObserverImpl iDataInitObserverImpl, int i, int i2, int i3);

    public IDataInitObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IDataInitObserverImpl) && getUID(this) == getUID((IDataInitObserverImpl) obj);
    }

    private static long getUID(IDataInitObserverImpl iDataInitObserverImpl) {
        long cPtr = getCPtr(iDataInitObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IDataInitObserverImpl iDataInitObserverImpl) {
        if (iDataInitObserverImpl == null) {
            return 0L;
        }
        return iDataInitObserverImpl.swigCPtr;
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
        IDataInitObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IDataInitObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onInit(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, @OperationErrCode.OperationErrCode1 int i3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onInitNative(j, this, i, i2, i3);
    }

    public IDataInitObserverImpl() {
        this(createNativeObj(), true);
        DataObserverJNI.swig_jni_init();
        IDataInitObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
