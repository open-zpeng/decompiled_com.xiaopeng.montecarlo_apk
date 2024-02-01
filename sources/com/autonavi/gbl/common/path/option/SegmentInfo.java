package com.autonavi.gbl.common.path.option;

import com.autonavi.gbl.common.model.Coord2DInt32;
import com.autonavi.gbl.common.model.Coord3DInt32;
import com.autonavi.gbl.common.path.model.AssistantAction;
import com.autonavi.gbl.common.path.model.MainAction;
import com.autonavi.gbl.common.path.model.ManeuverIcon;
import com.autonavi.gbl.common.path.model.Slope;
import com.autonavi.gbl.servicemanager.RefInfo;
import com.autonavi.gbl.servicemanager.RefManage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SegmentInfo {
    private static RefInfo.Callback refCallback = new RefInfo.Callback() { // from class: com.autonavi.gbl.common.path.option.SegmentInfo.1
        @Override // com.autonavi.gbl.servicemanager.RefInfo.Callback
        public void delete(long j) {
            SegmentInfo.destroyNativeObj(j);
        }
    };
    private Object ref;
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native long createNativeObj1(long j, SegmentInfo segmentInfo);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void destroyNativeObj(long j);

    private static native short get3DJunctionIndexNative(long j, SegmentInfo segmentInfo);

    private static native boolean get3DPointsNative(long j, SegmentInfo segmentInfo, ArrayList<Coord3DInt32> arrayList);

    private static native int getAssistantActionNative(long j, SegmentInfo segmentInfo);

    private static native String getCrossingNameNative(long j, SegmentInfo segmentInfo);

    private static native String getExitNameNative(long j, SegmentInfo segmentInfo);

    private static native String getGuideboardNameNative(long j, SegmentInfo segmentInfo);

    private static native long getLengthNative(long j, SegmentInfo segmentInfo);

    private static native long getLinkCountNative(long j, SegmentInfo segmentInfo);

    private static native boolean getLinkInfoNative(long j, SegmentInfo segmentInfo, long j2, long j3, LinkInfo linkInfo);

    private static native int getMainActionNative(long j, SegmentInfo segmentInfo);

    private static native ManeuverIcon getManeuverIconNative(long j, SegmentInfo segmentInfo);

    private static native boolean getPointsNative(long j, SegmentInfo segmentInfo, ArrayList<Coord2DInt32> arrayList);

    private static native long getRelatedPathIDNative(long j, SegmentInfo segmentInfo);

    private static native int getSegmentIndexNative(long j, SegmentInfo segmentInfo);

    private static native int getSlopeNative(long j, SegmentInfo segmentInfo);

    private static native int getTollCostNative(long j, SegmentInfo segmentInfo);

    private static native long getTollDistNative(long j, SegmentInfo segmentInfo);

    private static native String getTollRoadNameNative(long j, SegmentInfo segmentInfo);

    private static native long getTrafficLightNumNative(long j, SegmentInfo segmentInfo);

    private static native long getTravelTimeNative(long j, SegmentInfo segmentInfo);

    private static native short getUturnAndArrivedestNative(long j, SegmentInfo segmentInfo);

    private static native boolean hasCrossImageNative(long j, SegmentInfo segmentInfo);

    private static native boolean is3DJunctionNative(long j, SegmentInfo segmentInfo);

    private static native boolean isEndOfRoadNative(long j, SegmentInfo segmentInfo);

    private static native boolean isReqVectorCrossNative(long j, SegmentInfo segmentInfo);

    private static native boolean isRightPassAreaNative(long j, SegmentInfo segmentInfo);

    private static native boolean isValidNative(long j, SegmentInfo segmentInfo);

    private static native void setTravelTimeNative(long j, SegmentInfo segmentInfo, long j2);

    public SegmentInfo(long j, boolean z) {
        this.ref = null;
        this.swigCMemOwn = z;
        this.swigCPtr = j;
        if (true == this.swigCMemOwn) {
            long j2 = this.swigCPtr;
            if (j2 != 0) {
                this.ref = RefManage.register(this, j2, 0L, 0, refCallback);
            }
        }
    }

    public static long getCPtr(SegmentInfo segmentInfo) {
        if (segmentInfo == null) {
            return 0L;
        }
        return segmentInfo.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
                RefManage.unregister(this, this.ref);
            }
            this.swigCPtr = 0L;
        }
    }

    public SegmentInfo() {
        this(createNativeObj(), true);
    }

    public SegmentInfo(SegmentInfo segmentInfo) {
        this(createNativeObj1(getCPtr(segmentInfo), segmentInfo), true);
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

    public ArrayList<Coord2DInt32> getPoints() {
        ArrayList<Coord2DInt32> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getPoints(arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getPoints(ArrayList<Coord2DInt32> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPointsNative(j, this, arrayList);
    }

    public ArrayList<Coord3DInt32> get3DPoints() {
        ArrayList<Coord3DInt32> arrayList = new ArrayList<>();
        if (Boolean.valueOf(get3DPoints(arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean get3DPoints(ArrayList<Coord3DInt32> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return get3DPointsNative(j, this, arrayList);
    }

    public void setTravelTime(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setTravelTimeNative(j2, this, j);
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

    public LinkInfo getLinkInfo(long j) {
        LinkInfo linkInfo = new LinkInfo();
        if (Boolean.valueOf(getLinkInfo(j, linkInfo)).booleanValue()) {
            return linkInfo;
        }
        return null;
    }

    private boolean getLinkInfo(long j, LinkInfo linkInfo) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return getLinkInfoNative(j2, this, j, LinkInfo.getCPtr(linkInfo), linkInfo);
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

    public short getUturnAndArrivedest() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getUturnAndArrivedestNative(j, this);
    }
}
