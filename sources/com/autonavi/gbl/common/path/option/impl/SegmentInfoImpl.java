package com.autonavi.gbl.common.path.option.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.Coord2DInt32;
import com.autonavi.gbl.common.model.Coord3DInt32;
import com.autonavi.gbl.common.path.model.AssistantAction;
import com.autonavi.gbl.common.path.model.MainAction;
import com.autonavi.gbl.common.path.model.ManeuverIcon;
import com.autonavi.gbl.common.path.model.Slope;
import com.autonavi.gbl.common.path.option.SegmentInfo;
import java.util.ArrayList;
@IntfAuto(target = SegmentInfo.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class SegmentInfoImpl {
    private static BindTable BIND_TABLE = new BindTable(SegmentInfoImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native long createNativeObj1(long j, SegmentInfoImpl segmentInfoImpl);

    private static native void destroyNativeObj(long j);

    private static native short get3DJunctionIndexNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native boolean get3DPointsNative(long j, SegmentInfoImpl segmentInfoImpl, ArrayList<Coord3DInt32> arrayList);

    private static native int getAssistantActionNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native String getCrossingNameNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native String getExitNameNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native String getGuideboardNameNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native long getLengthNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native long getLinkCountNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native boolean getLinkInfoNative(long j, SegmentInfoImpl segmentInfoImpl, long j2, long j3, LinkInfoImpl linkInfoImpl);

    private static native int getMainActionNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native ManeuverIcon getManeuverIconNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native long getPlayPointCountNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native boolean getPointsNative(long j, SegmentInfoImpl segmentInfoImpl, ArrayList<Coord2DInt32> arrayList);

    private static native long getRelatedPathIDNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native int getSegmentIndexNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native int getSlopeNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native int getTollCostNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native long getTollDistNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native String getTollRoadNameNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native long getTrafficLightNumNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native long getTravelTimeNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native short getUturnAndArrivedestNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native boolean hasCrossImageNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native boolean is3DJunctionNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native boolean isEndOfRoadNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native boolean isReqVectorCrossNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native boolean isRightPassAreaNative(long j, SegmentInfoImpl segmentInfoImpl);

    private static native boolean isValidNative(long j, SegmentInfoImpl segmentInfoImpl);

    public SegmentInfoImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof SegmentInfoImpl) && getUID(this) == getUID((SegmentInfoImpl) obj);
    }

    private static long getUID(SegmentInfoImpl segmentInfoImpl) {
        long cPtr = getCPtr(segmentInfoImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(SegmentInfoImpl segmentInfoImpl) {
        if (segmentInfoImpl == null) {
            return 0L;
        }
        return segmentInfoImpl.swigCPtr;
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

    public LinkInfoImpl getLinkInfo(long j) {
        LinkInfoImpl linkInfoImpl = new LinkInfoImpl();
        if (getLinkInfo(j, linkInfoImpl)) {
            return linkInfoImpl;
        }
        return null;
    }

    public ArrayList<Coord2DInt32> getPoints() {
        ArrayList<Coord2DInt32> arrayList = new ArrayList<>();
        if (getPoints(arrayList)) {
            return arrayList;
        }
        return null;
    }

    public ArrayList<Coord3DInt32> get3DPoints() {
        ArrayList<Coord3DInt32> arrayList = new ArrayList<>();
        if (get3DPoints(arrayList)) {
            return arrayList;
        }
        return null;
    }

    public SegmentInfoImpl() {
        this(createNativeObj(), true);
    }

    public SegmentInfoImpl(SegmentInfoImpl segmentInfoImpl) {
        this(createNativeObj1(getCPtr(segmentInfoImpl), segmentInfoImpl), true);
    }

    public boolean isValid() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isValidNative(j, this);
    }

    public long getRelatedPathID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRelatedPathIDNative(j, this);
    }

    public int getSegmentIndex() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSegmentIndexNative(j, this);
    }

    @MainAction.MainAction1
    public int getMainAction() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMainActionNative(j, this);
    }

    @AssistantAction.AssistantAction1
    public int getAssistantAction() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAssistantActionNative(j, this);
    }

    @Slope.Slope1
    public int getSlope() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSlopeNative(j, this);
    }

    public long getLength() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLengthNative(j, this);
    }

    public int getTollCost() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTollCostNative(j, this);
    }

    public long getTollDist() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTollDistNative(j, this);
    }

    private boolean getPoints(ArrayList<Coord2DInt32> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPointsNative(j, this, arrayList);
    }

    private boolean get3DPoints(ArrayList<Coord3DInt32> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return get3DPointsNative(j, this, arrayList);
    }

    public long getTravelTime() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTravelTimeNative(j, this);
    }

    public long getTrafficLightNum() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTrafficLightNumNative(j, this);
    }

    public long getLinkCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLinkCountNative(j, this);
    }

    private boolean getLinkInfo(long j, LinkInfoImpl linkInfoImpl) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return getLinkInfoNative(j2, this, j, LinkInfoImpl.getCPtr(linkInfoImpl), linkInfoImpl);
    }

    public boolean hasCrossImage() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return hasCrossImageNative(j, this);
    }

    public boolean isReqVectorCross() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isReqVectorCrossNative(j, this);
    }

    public boolean isRightPassArea() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isRightPassAreaNative(j, this);
    }

    public boolean is3DJunction() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return is3DJunctionNative(j, this);
    }

    public boolean isEndOfRoad() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isEndOfRoadNative(j, this);
    }

    public short get3DJunctionIndex() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return get3DJunctionIndexNative(j, this);
    }

    public String getTollRoadName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTollRoadNameNative(j, this);
    }

    public String getGuideboardName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getGuideboardNameNative(j, this);
    }

    public String getExitName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getExitNameNative(j, this);
    }

    public String getCrossingName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCrossingNameNative(j, this);
    }

    public ManeuverIcon getManeuverIcon() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getManeuverIconNative(j, this);
    }

    public long getPlayPointCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPlayPointCountNative(j, this);
    }

    public short getUturnAndArrivedest() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getUturnAndArrivedestNative(j, this);
    }
}
