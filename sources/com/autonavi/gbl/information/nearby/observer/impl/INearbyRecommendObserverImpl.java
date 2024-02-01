package com.autonavi.gbl.information.nearby.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.nearby.model.NearbyRecommendResult;
import com.autonavi.gbl.information.nearby.observer.INearbyRecommendObserver;
@IntfAuto(target = INearbyRecommendObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class INearbyRecommendObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(INearbyRecommendObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void INearbyRecommendObserverImpl_change_ownership(INearbyRecommendObserverImpl iNearbyRecommendObserverImpl, long j, boolean z);

    private static native void INearbyRecommendObserverImpl_director_connect(INearbyRecommendObserverImpl iNearbyRecommendObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onResultNative(long j, INearbyRecommendObserverImpl iNearbyRecommendObserverImpl, int i, long j2, NearbyRecommendResult nearbyRecommendResult);

    public INearbyRecommendObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof INearbyRecommendObserverImpl) && getUID(this) == getUID((INearbyRecommendObserverImpl) obj);
    }

    private static long getUID(INearbyRecommendObserverImpl iNearbyRecommendObserverImpl) {
        long cPtr = getCPtr(iNearbyRecommendObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(INearbyRecommendObserverImpl iNearbyRecommendObserverImpl) {
        if (iNearbyRecommendObserverImpl == null) {
            return 0L;
        }
        return iNearbyRecommendObserverImpl.swigCPtr;
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
        INearbyRecommendObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        INearbyRecommendObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onResult(int i, NearbyRecommendResult nearbyRecommendResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onResultNative(j, this, i, 0L, nearbyRecommendResult);
    }

    public INearbyRecommendObserverImpl() {
        this(createNativeObj(), true);
        InformationNearbyObserverJNI.swig_jni_init();
        INearbyRecommendObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
