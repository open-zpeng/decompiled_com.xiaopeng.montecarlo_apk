package com.autonavi.gbl.guide.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.guide.model.CruiseEventInfo;
import com.autonavi.gbl.guide.model.CruiseFacilityInfo;
import com.autonavi.gbl.guide.model.CruiseInfo;
import com.autonavi.gbl.guide.model.CruiseTimeAndDist;
import com.autonavi.gbl.guide.model.LaneInfo;
import com.autonavi.gbl.guide.model.SocolEventInfo;
import com.autonavi.gbl.guide.observer.ICruiseObserver;
import java.util.ArrayList;
@IntfAuto(target = ICruiseObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICruiseObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ICruiseObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICruiseObserverImpl_change_ownership(ICruiseObserverImpl iCruiseObserverImpl, long j, boolean z);

    private static native void ICruiseObserverImpl_director_connect(ICruiseObserverImpl iCruiseObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onHideCruiseLaneInfoNative(long j, ICruiseObserverImpl iCruiseObserverImpl);

    private static native void onShowCruiseLaneInfoNative(long j, ICruiseObserverImpl iCruiseObserverImpl, long j2, LaneInfo laneInfo);

    private static native void onUpdateCruiseCongestionInfoNative(long j, ICruiseObserverImpl iCruiseObserverImpl, long j2, CruiseCongestionInfo cruiseCongestionInfo);

    private static native void onUpdateCruiseEventNative(long j, ICruiseObserverImpl iCruiseObserverImpl, long j2, CruiseEventInfo cruiseEventInfo);

    private static native void onUpdateCruiseFacilityNative(long j, ICruiseObserverImpl iCruiseObserverImpl, ArrayList<CruiseFacilityInfo> arrayList);

    private static native void onUpdateCruiseInfoNative(long j, ICruiseObserverImpl iCruiseObserverImpl, long j2, CruiseInfo cruiseInfo);

    private static native void onUpdateCruiseSocolEventNative(long j, ICruiseObserverImpl iCruiseObserverImpl, long j2, SocolEventInfo socolEventInfo);

    private static native void onUpdateCruiseTimeAndDistNative(long j, ICruiseObserverImpl iCruiseObserverImpl, long j2, CruiseTimeAndDist cruiseTimeAndDist);

    private static native void onUpdateElecCameraInfoNative(long j, ICruiseObserverImpl iCruiseObserverImpl, ArrayList<CruiseFacilityInfo> arrayList);

    public ICruiseObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICruiseObserverImpl) && getUID(this) == getUID((ICruiseObserverImpl) obj);
    }

    private static long getUID(ICruiseObserverImpl iCruiseObserverImpl) {
        long cPtr = getCPtr(iCruiseObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICruiseObserverImpl iCruiseObserverImpl) {
        if (iCruiseObserverImpl == null) {
            return 0L;
        }
        return iCruiseObserverImpl.swigCPtr;
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
        ICruiseObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICruiseObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onUpdateCruiseFacility(ArrayList<CruiseFacilityInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateCruiseFacilityNative(j, this, arrayList);
    }

    public void onUpdateElecCameraInfo(ArrayList<CruiseFacilityInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateElecCameraInfoNative(j, this, arrayList);
    }

    public void onUpdateCruiseInfo(CruiseInfo cruiseInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateCruiseInfoNative(j, this, 0L, cruiseInfo);
    }

    public void onUpdateCruiseTimeAndDist(CruiseTimeAndDist cruiseTimeAndDist) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateCruiseTimeAndDistNative(j, this, 0L, cruiseTimeAndDist);
    }

    public void onUpdateCruiseCongestionInfo(CruiseCongestionInfo cruiseCongestionInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateCruiseCongestionInfoNative(j, this, 0L, cruiseCongestionInfo);
    }

    public void onShowCruiseLaneInfo(LaneInfo laneInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onShowCruiseLaneInfoNative(j, this, 0L, laneInfo);
    }

    public void onHideCruiseLaneInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onHideCruiseLaneInfoNative(j, this);
    }

    public void onUpdateCruiseEvent(CruiseEventInfo cruiseEventInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateCruiseEventNative(j, this, 0L, cruiseEventInfo);
    }

    public void onUpdateCruiseSocolEvent(SocolEventInfo socolEventInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateCruiseSocolEventNative(j, this, 0L, socolEventInfo);
    }

    public ICruiseObserverImpl() {
        this(createNativeObj(), true);
        GuideObserverJNI.swig_jni_init();
        ICruiseObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
