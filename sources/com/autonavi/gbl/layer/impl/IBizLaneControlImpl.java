package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.LaneNaviBubbleInfo;
import com.autonavi.gbl.lane.model.LaneNaviCamera;
import com.autonavi.gbl.lane.model.LaneNaviCongestionInfo;
import com.autonavi.gbl.lane.model.LaneNaviInfo;
import com.autonavi.gbl.lane.model.LaneOddInfo;
import com.autonavi.gbl.lane.model.LanePathTrafficEventInfo;
import com.autonavi.gbl.lane.model.SpecialLaneBubbleInfo;
import com.autonavi.gbl.lane.model.TravelPoint;
import com.autonavi.gbl.lane.model.TurnBubbleInfo;
import com.autonavi.gbl.layer.BizLaneControl;
import com.autonavi.gbl.layer.model.BizLaneType;
import com.autonavi.gbl.layer.model.LanePriorityMode;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import java.util.ArrayList;
@IntfAuto(target = BizLaneControl.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBizLaneControlImpl extends IBizControlImpl {
    private static BindTable BIND_TABLE = new BindTable(IBizLaneControlImpl.class);
    private transient long swigCPtr;

    private static native long IBizLaneControlImpl_SWIGUpcast(long j);

    private static native void destroyNativeObj(long j);

    private static native long getLaneLayerNative(long j, IBizLaneControlImpl iBizLaneControlImpl, int i);

    private static native void setPriorityModeNative(long j, IBizLaneControlImpl iBizLaneControlImpl, int i);

    private static native void updateLaneGuideBusNative(long j, IBizLaneControlImpl iBizLaneControlImpl, long j2, SpecialLaneBubbleInfo specialLaneBubbleInfo);

    private static native void updateLaneGuideCameraNative(long j, IBizLaneControlImpl iBizLaneControlImpl, ArrayList<LaneNaviCamera> arrayList);

    private static native void updateLaneGuideCongestionNative(long j, IBizLaneControlImpl iBizLaneControlImpl, long j2, LaneNaviCongestionInfo laneNaviCongestionInfo);

    private static native void updateLaneGuideEndNative(long j, IBizLaneControlImpl iBizLaneControlImpl, ArrayList<TravelPoint> arrayList);

    private static native void updateLaneGuideEventNative(long j, IBizLaneControlImpl iBizLaneControlImpl, long j2, LanePathTrafficEventInfo lanePathTrafficEventInfo);

    private static native void updateLaneGuideHovNative(long j, IBizLaneControlImpl iBizLaneControlImpl, long j2, SpecialLaneBubbleInfo specialLaneBubbleInfo);

    private static native void updateLaneGuideOddNative(long j, IBizLaneControlImpl iBizLaneControlImpl, ArrayList<LaneOddInfo> arrayList);

    private static native void updateLaneGuideSolidLineNative(long j, IBizLaneControlImpl iBizLaneControlImpl, ArrayList<LaneNaviBubbleInfo> arrayList);

    private static native void updateLaneGuideTurnNative(long j, IBizLaneControlImpl iBizLaneControlImpl, long j2, TurnBubbleInfo turnBubbleInfo);

    private static native void updateLaneGuideViaNative(long j, IBizLaneControlImpl iBizLaneControlImpl, ArrayList<TravelPoint> arrayList);

    private static native void updateLaneNaviInfoNative(long j, IBizLaneControlImpl iBizLaneControlImpl, long j2, LaneNaviInfo laneNaviInfo);

    private static native void updateViaPassIndexNative(long j, IBizLaneControlImpl iBizLaneControlImpl, long j2);

    public IBizLaneControlImpl(long j, boolean z) {
        super(IBizLaneControlImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof IBizLaneControlImpl) {
            return getUID(this) == getUID((IBizLaneControlImpl) obj);
        }
        return super.equals(obj);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.impl.IBizControlImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public void setPriorityMode(@LanePriorityMode.LanePriorityMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPriorityModeNative(j, this, i);
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

    public void updateLaneGuideOdd(ArrayList<LaneOddInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateLaneGuideOddNative(j, this, arrayList);
    }

    public void updateLaneGuideBus(SpecialLaneBubbleInfo specialLaneBubbleInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateLaneGuideBusNative(j, this, 0L, specialLaneBubbleInfo);
    }

    public void updateLaneGuideHov(SpecialLaneBubbleInfo specialLaneBubbleInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateLaneGuideHovNative(j, this, 0L, specialLaneBubbleInfo);
    }

    public void updateLaneGuideSolidLine(ArrayList<LaneNaviBubbleInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateLaneGuideSolidLineNative(j, this, arrayList);
    }

    public void updateLaneNaviInfo(LaneNaviInfo laneNaviInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updateLaneNaviInfoNative(j, this, 0L, laneNaviInfo);
    }
}
