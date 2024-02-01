package com.autonavi.gbl.map.layer.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.observer.ICarObserver;
@IntfAuto(target = ICarObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ICarObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ICarObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICarObserverImpl_change_ownership(ICarObserverImpl iCarObserverImpl, long j, boolean z);

    private static native void ICarObserverImpl_director_connect(ICarObserverImpl iCarObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onCarClickNative(long j, ICarObserverImpl iCarObserverImpl, long j2, CarLoc carLoc);

    private static native void onCarLocChangeNative(long j, ICarObserverImpl iCarObserverImpl, long j2, CarLoc carLoc);

    public ICarObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICarObserverImpl) && getUID(this) == getUID((ICarObserverImpl) obj);
    }

    private static long getUID(ICarObserverImpl iCarObserverImpl) {
        long cPtr = getCPtr(iCarObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICarObserverImpl iCarObserverImpl) {
        if (iCarObserverImpl == null) {
            return 0L;
        }
        return iCarObserverImpl.swigCPtr;
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
        ICarObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICarObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public ICarObserverImpl() {
        this(createNativeObj(), true);
        MapLayerObserverJNI.swig_jni_init();
        ICarObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void onCarClick(CarLoc carLoc) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onCarClickNative(j, this, 0L, carLoc);
    }

    public void onCarLocChange(CarLoc carLoc) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onCarLocChangeNative(j, this, 0L, carLoc);
    }
}
