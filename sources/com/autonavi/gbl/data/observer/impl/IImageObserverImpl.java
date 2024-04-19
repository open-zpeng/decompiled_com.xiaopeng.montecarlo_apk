package com.autonavi.gbl.data.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.observer.IImageObserver;
@IntfAuto(target = IImageObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IImageObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IImageObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IImageObserverImpl_change_ownership(IImageObserverImpl iImageObserverImpl, long j, boolean z);

    private static native void IImageObserverImpl_director_connect(IImageObserverImpl iImageObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onDownloadImageNative(long j, IImageObserverImpl iImageObserverImpl, int i, int i2, String str, int i3);

    public IImageObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IImageObserverImpl) && getUID(this) == getUID((IImageObserverImpl) obj);
    }

    private static long getUID(IImageObserverImpl iImageObserverImpl) {
        long cPtr = getCPtr(iImageObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IImageObserverImpl iImageObserverImpl) {
        if (iImageObserverImpl == null) {
            return 0L;
        }
        return iImageObserverImpl.swigCPtr;
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
        IImageObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IImageObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onDownloadImage(int i, @OperationErrCode.OperationErrCode1 int i2, String str, @DataType.DataType1 int i3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onDownloadImageNative(j, this, i, i2, str, i3);
    }

    public IImageObserverImpl() {
        this(createNativeObj(), true);
        DataObserverJNI.swig_jni_init();
        IImageObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
