package com.autonavi.gbl.lane.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.lane.model.LaneNaviCamera;
import com.autonavi.gbl.lane.model.LaneNaviCongestionInfo;
import com.autonavi.gbl.lane.model.LanePathTrafficEventInfo;
import com.autonavi.gbl.lane.model.TravelPoint;
import com.autonavi.gbl.lane.model.TurnBubbleInfo;
import com.autonavi.gbl.lane.observer.ILaneNaviObserver;
import java.util.ArrayList;
@IntfAuto(target = ILaneNaviObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILaneNaviObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ILaneNaviObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ILaneNaviObserverImpl_change_ownership(ILaneNaviObserverImpl iLaneNaviObserverImpl, long j, boolean z);

    private static native void ILaneNaviObserverImpl_director_connect(ILaneNaviObserverImpl iLaneNaviObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onShowNaviCameraNative(long j, ILaneNaviObserverImpl iLaneNaviObserverImpl, ArrayList<LaneNaviCamera> arrayList, int i);

    private static native void onUpdateTMCCongestionInfoNative(long j, ILaneNaviObserverImpl iLaneNaviObserverImpl, long j2, LaneNaviCongestionInfo laneNaviCongestionInfo, int i);

    private static native void onUpdateTREventNative(long j, ILaneNaviObserverImpl iLaneNaviObserverImpl, long j2, LanePathTrafficEventInfo lanePathTrafficEventInfo, int i);

    private static native void onUpdateTravelPointInfoNative(long j, ILaneNaviObserverImpl iLaneNaviObserverImpl, ArrayList<TravelPoint> arrayList, int i);

    private static native void onUpdateTurnBubbleInfoNative(long j, ILaneNaviObserverImpl iLaneNaviObserverImpl, long j2, TurnBubbleInfo turnBubbleInfo);

    public ILaneNaviObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILaneNaviObserverImpl) && getUID(this) == getUID((ILaneNaviObserverImpl) obj);
    }

    private static long getUID(ILaneNaviObserverImpl iLaneNaviObserverImpl) {
        long cPtr = getCPtr(iLaneNaviObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILaneNaviObserverImpl iLaneNaviObserverImpl) {
        if (iLaneNaviObserverImpl == null) {
            return 0L;
        }
        return iLaneNaviObserverImpl.swigCPtr;
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
        ILaneNaviObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ILaneNaviObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onShowNaviCamera(ArrayList<LaneNaviCamera> arrayList, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onShowNaviCameraNative(j, this, arrayList, i);
    }

    public void onUpdateTMCCongestionInfo(LaneNaviCongestionInfo laneNaviCongestionInfo, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateTMCCongestionInfoNative(j, this, 0L, laneNaviCongestionInfo, i);
    }

    public void onUpdateTREvent(LanePathTrafficEventInfo lanePathTrafficEventInfo, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateTREventNative(j, this, 0L, lanePathTrafficEventInfo, i);
    }

    public void onUpdateTurnBubbleInfo(TurnBubbleInfo turnBubbleInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateTurnBubbleInfoNative(j, this, 0L, turnBubbleInfo);
    }

    public void onUpdateTravelPointInfo(ArrayList<TravelPoint> arrayList, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateTravelPointInfoNative(j, this, arrayList, i);
    }

    public ILaneNaviObserverImpl() {
        this(createNativeObj(), true);
        LaneObserverJNI.swig_jni_init();
        ILaneNaviObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
