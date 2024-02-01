package com.autonavi.gbl.data.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.observer.IDataListObserver;
@IntfAuto(target = IDataListObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IDataListObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IDataListObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IDataListObserverImpl_change_ownership(IDataListObserverImpl iDataListObserverImpl, long j, boolean z);

    private static native void IDataListObserverImpl_director_connect(IDataListObserverImpl iDataListObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRequestDataListCheckNative(long j, IDataListObserverImpl iDataListObserverImpl, int i, int i2, int i3);

    public IDataListObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IDataListObserverImpl) && getUID(this) == getUID((IDataListObserverImpl) obj);
    }

    private static long getUID(IDataListObserverImpl iDataListObserverImpl) {
        long cPtr = getCPtr(iDataListObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IDataListObserverImpl iDataListObserverImpl) {
        if (iDataListObserverImpl == null) {
            return 0L;
        }
        return iDataListObserverImpl.swigCPtr;
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
        IDataListObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IDataListObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRequestDataListCheck(@DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRequestDataListCheckNative(j, this, i, i2, i3);
    }

    public IDataListObserverImpl() {
        this(createNativeObj(), true);
        DataObserverJNI.swig_jni_init();
        IDataListObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
