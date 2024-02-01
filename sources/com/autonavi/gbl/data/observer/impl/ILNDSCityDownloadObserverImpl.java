package com.autonavi.gbl.data.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.LNDSFileRecoverStatus;
import com.autonavi.gbl.data.model.TaskStatusCode;
import com.autonavi.gbl.data.observer.ILNDSCityDownloadObserver;
@IntfAuto(target = ILNDSCityDownloadObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILNDSCityDownloadObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ILNDSCityDownloadObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ILNDSCityDownloadObserverImpl_change_ownership(ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl, long j, boolean z);

    private static native void ILNDSCityDownloadObserverImpl_director_connect(ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onDownloadErrorNative(long j, ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl, int i, int i2);

    private static native void onDownloadProgressNative(long j, ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl, int i, long j2, float f);

    private static native void onDownloadStatusNative(long j, ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl, int i, int i2);

    private static native void onDownloadVersionNative(long j, ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl, int i, String str);

    private static native void onFileRecoverStatusNative(long j, ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl, int i);

    private static native void onMergeProgressNative(long j, ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl, int i, float f);

    public ILNDSCityDownloadObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILNDSCityDownloadObserverImpl) && getUID(this) == getUID((ILNDSCityDownloadObserverImpl) obj);
    }

    private static long getUID(ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl) {
        long cPtr = getCPtr(iLNDSCityDownloadObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl) {
        if (iLNDSCityDownloadObserverImpl == null) {
            return 0L;
        }
        return iLNDSCityDownloadObserverImpl.swigCPtr;
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
        ILNDSCityDownloadObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ILNDSCityDownloadObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onDownloadVersion(int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onDownloadVersionNative(j, this, i, str);
    }

    public void onDownloadStatus(int i, @TaskStatusCode.TaskStatusCode1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onDownloadStatusNative(j, this, i, i2);
    }

    public void onDownloadError(int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onDownloadErrorNative(j, this, i, i2);
    }

    public void onDownloadProgress(int i, long j, float f) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onDownloadProgressNative(j2, this, i, j, f);
    }

    public void onMergeProgress(int i, float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onMergeProgressNative(j, this, i, f);
    }

    public void onFileRecoverStatus(@LNDSFileRecoverStatus.LNDSFileRecoverStatus1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onFileRecoverStatusNative(j, this, i);
    }

    public ILNDSCityDownloadObserverImpl() {
        this(createNativeObj(), true);
        DataObserverJNI.swig_jni_init();
        ILNDSCityDownloadObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
