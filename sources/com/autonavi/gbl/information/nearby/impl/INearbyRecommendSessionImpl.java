package com.autonavi.gbl.information.nearby.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.information.nearby.NearbyRecommendSession;
import com.autonavi.gbl.information.nearby.model.NearbyRecommendParam;
import com.autonavi.gbl.information.nearby.model.NearbyRecommendPoiRetainParam;
import com.autonavi.gbl.information.nearby.observer.impl.INearbyRecommendObserverImpl;
import com.autonavi.gbl.search.model.SearchTabInfo;
import java.util.ArrayList;
@IntfAuto(target = NearbyRecommendSession.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class INearbyRecommendSessionImpl {
    private static BindTable BIND_TABLE = new BindTable(INearbyRecommendSessionImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void abortNative(long j, INearbyRecommendSessionImpl iNearbyRecommendSessionImpl, long j2);

    private static native int clickTabNative(long j, INearbyRecommendSessionImpl iNearbyRecommendSessionImpl, long j2, SearchTabInfo searchTabInfo);

    private static native void destroyNativeObj(long j);

    private static native int dislikeNative(long j, INearbyRecommendSessionImpl iNearbyRecommendSessionImpl, long j2, NearbyRecommendPoiRetainParam nearbyRecommendPoiRetainParam);

    private static native int likeNative(long j, INearbyRecommendSessionImpl iNearbyRecommendSessionImpl, long j2, NearbyRecommendPoiRetainParam nearbyRecommendPoiRetainParam);

    private static native int onClickPoiNative(long j, INearbyRecommendSessionImpl iNearbyRecommendSessionImpl, long j2, NearbyRecommendPoiRetainParam nearbyRecommendPoiRetainParam);

    private static native int onShowPoiNative(long j, INearbyRecommendSessionImpl iNearbyRecommendSessionImpl, ArrayList<NearbyRecommendPoiRetainParam> arrayList);

    private static native int onShowTabNative(long j, INearbyRecommendSessionImpl iNearbyRecommendSessionImpl, long j2, SearchTabInfo searchTabInfo);

    private static native long requestNative(long j, INearbyRecommendSessionImpl iNearbyRecommendSessionImpl, long j2, NearbyRecommendParam nearbyRecommendParam, long j3, INearbyRecommendObserverImpl iNearbyRecommendObserverImpl);

    private static native void setLocationNative(long j, INearbyRecommendSessionImpl iNearbyRecommendSessionImpl, long j2, Coord2DDouble coord2DDouble);

    private static native int setPersonalizeEnableNative(long j, INearbyRecommendSessionImpl iNearbyRecommendSessionImpl, boolean z);

    public INearbyRecommendSessionImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof INearbyRecommendSessionImpl) && getUID(this) == getUID((INearbyRecommendSessionImpl) obj);
    }

    private static long getUID(INearbyRecommendSessionImpl iNearbyRecommendSessionImpl) {
        long cPtr = getCPtr(iNearbyRecommendSessionImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(INearbyRecommendSessionImpl iNearbyRecommendSessionImpl) {
        if (iNearbyRecommendSessionImpl == null) {
            return 0L;
        }
        return iNearbyRecommendSessionImpl.swigCPtr;
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

    public long request(NearbyRecommendParam nearbyRecommendParam, INearbyRecommendObserverImpl iNearbyRecommendObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestNative(j, this, 0L, nearbyRecommendParam, INearbyRecommendObserverImpl.getCPtr(iNearbyRecommendObserverImpl), iNearbyRecommendObserverImpl);
    }

    public void abort(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        abortNative(j2, this, j);
    }

    public void setLocation(Coord2DDouble coord2DDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setLocationNative(j, this, 0L, coord2DDouble);
    }

    public int onShowPoi(ArrayList<NearbyRecommendPoiRetainParam> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onShowPoiNative(j, this, arrayList);
    }

    public int onShowTab(SearchTabInfo searchTabInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onShowTabNative(j, this, 0L, searchTabInfo);
    }

    public int onClickPoi(NearbyRecommendPoiRetainParam nearbyRecommendPoiRetainParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onClickPoiNative(j, this, 0L, nearbyRecommendPoiRetainParam);
    }

    public int clickTab(SearchTabInfo searchTabInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return clickTabNative(j, this, 0L, searchTabInfo);
    }

    public int like(NearbyRecommendPoiRetainParam nearbyRecommendPoiRetainParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return likeNative(j, this, 0L, nearbyRecommendPoiRetainParam);
    }

    public int dislike(NearbyRecommendPoiRetainParam nearbyRecommendPoiRetainParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return dislikeNative(j, this, 0L, nearbyRecommendPoiRetainParam);
    }

    public int setPersonalizeEnable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setPersonalizeEnableNative(j, this, z);
    }
}
