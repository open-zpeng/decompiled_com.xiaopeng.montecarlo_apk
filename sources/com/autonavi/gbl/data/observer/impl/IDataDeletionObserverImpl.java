package com.autonavi.gbl.data.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.observer.IDataDeletionObserver;
@IntfAuto(target = IDataDeletionObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IDataDeletionObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IDataDeletionObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IDataDeletionObserverImpl_change_ownership(IDataDeletionObserverImpl iDataDeletionObserverImpl, long j, boolean z);

    private static native void IDataDeletionObserverImpl_director_connect(IDataDeletionObserverImpl iDataDeletionObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onAfterDataDeletionNative(long j, IDataDeletionObserverImpl iDataDeletionObserverImpl, int i, int i2, int i3);

    private static native void onBeforeDataDeletionNative(long j, IDataDeletionObserverImpl iDataDeletionObserverImpl, int i, int i2, int i3);

    public IDataDeletionObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IDataDeletionObserverImpl) && getUID(this) == getUID((IDataDeletionObserverImpl) obj);
    }

    private static long getUID(IDataDeletionObserverImpl iDataDeletionObserverImpl) {
        long cPtr = getCPtr(iDataDeletionObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IDataDeletionObserverImpl iDataDeletionObserverImpl) {
        if (iDataDeletionObserverImpl == null) {
            return 0L;
        }
        return iDataDeletionObserverImpl.swigCPtr;
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
        IDataDeletionObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IDataDeletionObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onBeforeDataDeletion(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onBeforeDataDeletionNative(j, this, i, i2, i3);
    }

    public void onAfterDataDeletion(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onAfterDataDeletionNative(j, this, i, i2, i3);
    }

    public IDataDeletionObserverImpl() {
        this(createNativeObj(), true);
        DataObserverJNI.swig_jni_init();
        IDataDeletionObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
