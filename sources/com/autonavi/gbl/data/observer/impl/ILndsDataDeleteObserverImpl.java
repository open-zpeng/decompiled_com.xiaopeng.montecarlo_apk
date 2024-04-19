package com.autonavi.gbl.data.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.data.model.LndsSourceDataType;
import com.autonavi.gbl.data.observer.ILndsDataDeleteObserver;
@IntfAuto(target = ILndsDataDeleteObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILndsDataDeleteObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ILndsDataDeleteObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ILndsDataDeleteObserverImpl_change_ownership(ILndsDataDeleteObserverImpl iLndsDataDeleteObserverImpl, long j, boolean z);

    private static native void ILndsDataDeleteObserverImpl_director_connect(ILndsDataDeleteObserverImpl iLndsDataDeleteObserverImpl, long j, boolean z, boolean z2);

    private static native void afterDataDeleteNative(long j, ILndsDataDeleteObserverImpl iLndsDataDeleteObserverImpl, int i, int i2);

    private static native void beforeDataDeleteNative(long j, ILndsDataDeleteObserverImpl iLndsDataDeleteObserverImpl, int i, int i2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    public ILndsDataDeleteObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILndsDataDeleteObserverImpl) && getUID(this) == getUID((ILndsDataDeleteObserverImpl) obj);
    }

    private static long getUID(ILndsDataDeleteObserverImpl iLndsDataDeleteObserverImpl) {
        long cPtr = getCPtr(iLndsDataDeleteObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILndsDataDeleteObserverImpl iLndsDataDeleteObserverImpl) {
        if (iLndsDataDeleteObserverImpl == null) {
            return 0L;
        }
        return iLndsDataDeleteObserverImpl.swigCPtr;
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
        ILndsDataDeleteObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ILndsDataDeleteObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void beforeDataDelete(int i, @LndsSourceDataType.LndsSourceDataType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        beforeDataDeleteNative(j, this, i, i2);
    }

    public void afterDataDelete(int i, @LndsSourceDataType.LndsSourceDataType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        afterDataDeleteNative(j, this, i, i2);
    }

    public ILndsDataDeleteObserverImpl() {
        this(createNativeObj(), true);
        DataObserverJNI.swig_jni_init();
        ILndsDataDeleteObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
