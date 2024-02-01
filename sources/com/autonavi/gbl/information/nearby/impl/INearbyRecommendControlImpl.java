package com.autonavi.gbl.information.nearby.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.nearby.NearbyRecommendControl;
import com.autonavi.gbl.information.nearby.model.NearbyRecommendSessionInitParam;
@IntfAuto(target = NearbyRecommendControl.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class INearbyRecommendControlImpl {
    private static BindTable BIND_TABLE = new BindTable(INearbyRecommendControlImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createSessionNative(long j, INearbyRecommendControlImpl iNearbyRecommendControlImpl, long j2, NearbyRecommendSessionInitParam nearbyRecommendSessionInitParam);

    private static native void destroyNativeObj(long j);

    private static native void destroySessionNative(long j, INearbyRecommendControlImpl iNearbyRecommendControlImpl, long j2, INearbyRecommendSessionImpl iNearbyRecommendSessionImpl);

    private static native void unInitNative(long j, INearbyRecommendControlImpl iNearbyRecommendControlImpl);

    public INearbyRecommendControlImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof INearbyRecommendControlImpl) && getUID(this) == getUID((INearbyRecommendControlImpl) obj);
    }

    private static long getUID(INearbyRecommendControlImpl iNearbyRecommendControlImpl) {
        long cPtr = getCPtr(iNearbyRecommendControlImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(INearbyRecommendControlImpl iNearbyRecommendControlImpl) {
        if (iNearbyRecommendControlImpl == null) {
            return 0L;
        }
        return iNearbyRecommendControlImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }

    public INearbyRecommendSessionImpl createSession(NearbyRecommendSessionInitParam nearbyRecommendSessionInitParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long createSessionNative = createSessionNative(j, this, 0L, nearbyRecommendSessionInitParam);
        if (createSessionNative == 0) {
            return null;
        }
        return new INearbyRecommendSessionImpl(createSessionNative, false);
    }

    public void destroySession(INearbyRecommendSessionImpl iNearbyRecommendSessionImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        destroySessionNative(j, this, INearbyRecommendSessionImpl.getCPtr(iNearbyRecommendSessionImpl), iNearbyRecommendSessionImpl);
    }
}
