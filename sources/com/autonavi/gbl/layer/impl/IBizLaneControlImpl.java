package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.lane.model.LaneNaviCamera;
import com.autonavi.gbl.lane.model.LaneNaviCongestionInfo;
import com.autonavi.gbl.lane.model.LanePathTrafficEventInfo;
import com.autonavi.gbl.lane.model.TravelPoint;
import com.autonavi.gbl.lane.model.TurnBubbleInfo;
import com.autonavi.gbl.layer.BizLaneControl;
import com.autonavi.gbl.layer.model.BizLaneType;
import com.autonavi.gbl.layer.model.LanePriorityMode;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import java.util.ArrayList;
@IntfAuto(target = BizLaneControl.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IBizLaneControlImpl {
    private static BindTable BIND_TABLE = new BindTable(IBizLaneControlImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native long getLaneLayerNative(long j, IBizLaneControlImpl iBizLaneControlImpl, int i);

    private static native void setPriorityModeNative(long j, IBizLaneControlImpl iBizLaneControlImpl, int i);

    private static native void updateLaneGuideCameraNative(long j, IBizLaneControlImpl iBizLaneControlImpl, ArrayList<LaneNaviCamera> arrayList);

    private static native void updateLaneGuideCongestionNative(long j, IBizLaneControlImpl iBizLaneControlImpl, long j2, LaneNaviCongestionInfo laneNaviCongestionInfo);

    private static native void updateLaneGuideEndNative(long j, IBizLaneControlImpl iBizLaneControlImpl, ArrayList<TravelPoint> arrayList);

    private static native void updateLaneGuideEventNative(long j, IBizLaneControlImpl iBizLaneControlImpl, long j2, LanePathTrafficEventInfo lanePathTrafficEventInfo);

    private static native void updateLaneGuideTurnNative(long j, IBizLaneControlImpl iBizLaneControlImpl, long j2, TurnBubbleInfo turnBubbleInfo);

    private static native void updateLaneGuideViaNative(long j, IBizLaneControlImpl iBizLaneControlImpl, ArrayList<TravelPoint> arrayList);

    private static native void updateViaPassIndexNative(long j, IBizLaneControlImpl iBizLaneControlImpl, long j2);

    public IBizLaneControlImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBizLaneControlImpl) && getUID(this) == getUID((IBizLaneControlImpl) obj);
    }

    private static long getUID(IBizLaneControlImpl iBizLaneControlImpl) {
        long cPtr = getCPtr(iBizLaneControlImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBizLaneControlImpl iBizLaneControlImpl) {
        if (iBizLaneControlImpl == null) {
            return 0L;
        }
        return iBizLaneControlImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    protected synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setPriorityMode(@LanePriorityMode.LanePriorityMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPriorityModeNative(j, this, i);
    }

    public void updateLaneGuideCamera(ArrayList<LaneNaviCamera> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateLaneGuideCameraNative(j, this, arrayList);
    }

    public void updateLaneGuideCongestion(LaneNaviCongestionInfo laneNaviCongestionInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateLaneGuideCongestionNative(j, this, 0L, laneNaviCongestionInfo);
    }

    public void updateLaneGuideEvent(LanePathTrafficEventInfo lanePathTrafficEventInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateLaneGuideEventNative(j, this, 0L, lanePathTrafficEventInfo);
    }

    public void updateLaneGuideTurn(TurnBubbleInfo turnBubbleInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateLaneGuideTurnNative(j, this, 0L, turnBubbleInfo);
    }

    public void updateLaneGuideVia(ArrayList<TravelPoint> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateLaneGuideViaNative(j, this, arrayList);
    }

    public void updateViaPassIndex(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        updateViaPassIndexNative(j2, this, j);
    }

    public void updateLaneGuideEnd(ArrayList<TravelPoint> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateLaneGuideEndNative(j, this, arrayList);
    }

    public BaseLayerImpl getLaneLayer(@BizLaneType.BizLaneType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        long laneLayerNative = getLaneLayerNative(j, this, i);
        if (laneLayerNative == 0) {
            return null;
        }
        return new BaseLayerImpl(laneLayerNative, false);
    }
}
