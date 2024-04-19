package com.autonavi.gbl.data.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.model.OperationErrCode;
import com.autonavi.gbl.data.model.OperationType;
import com.autonavi.gbl.data.model.TaskStatusCode;
import com.autonavi.gbl.data.observer.IDownloadObserver;
import java.util.ArrayList;
@IntfAuto(target = IDownloadObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IDownloadObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IDownloadObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IDownloadObserverImpl_change_ownership(IDownloadObserverImpl iDownloadObserverImpl, long j, boolean z);

    private static native void IDownloadObserverImpl_director_connect(IDownloadObserverImpl iDownloadObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onDownLoadStatusNative(long j, IDownloadObserverImpl iDownloadObserverImpl, int i, int i2, int i3, int i4, int i5);

    private static native void onOperatedNative(long j, IDownloadObserverImpl iDownloadObserverImpl, int i, int i2, int i3, ArrayList<Integer> arrayList);

    private static native void onPercentNative(long j, IDownloadObserverImpl iDownloadObserverImpl, int i, int i2, int i3, int i4, float f);

    public IDownloadObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IDownloadObserverImpl) && getUID(this) == getUID((IDownloadObserverImpl) obj);
    }

    private static long getUID(IDownloadObserverImpl iDownloadObserverImpl) {
        long cPtr = getCPtr(iDownloadObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IDownloadObserverImpl iDownloadObserverImpl) {
        if (iDownloadObserverImpl == null) {
            return 0L;
        }
        return iDownloadObserverImpl.swigCPtr;
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
        IDownloadObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IDownloadObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onOperated(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, @OperationType.OperationType1 int i3, ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onOperatedNative(j, this, i, i2, i3, arrayList);
    }

    public void onDownLoadStatus(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, @TaskStatusCode.TaskStatusCode1 int i4, @OperationErrCode.OperationErrCode1 int i5) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onDownLoadStatusNative(j, this, i, i2, i3, i4, i5);
    }

    public void onPercent(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, int i4, float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onPercentNative(j, this, i, i2, i3, i4, f);
    }

    public IDownloadObserverImpl() {
        this(createNativeObj(), true);
        DataObserverJNI.swig_jni_init();
        IDownloadObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
