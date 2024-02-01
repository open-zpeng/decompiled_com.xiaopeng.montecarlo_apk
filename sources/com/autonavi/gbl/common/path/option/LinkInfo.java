package com.autonavi.gbl.common.path.option;

import com.autonavi.gbl.common.model.Coord2DInt32;
import com.autonavi.gbl.common.model.Coord3DInt32;
import com.autonavi.gbl.common.path.model.AssistantAction;
import com.autonavi.gbl.common.path.model.CameraExt;
import com.autonavi.gbl.common.path.model.CameraExt3d;
import com.autonavi.gbl.common.path.model.ExactTrafficItem;
import com.autonavi.gbl.common.path.model.FloorInfo;
import com.autonavi.gbl.common.path.model.Formway;
import com.autonavi.gbl.common.path.model.GantryInfo;
import com.autonavi.gbl.common.path.model.HeightDiffData;
import com.autonavi.gbl.common.path.model.LinkType;
import com.autonavi.gbl.common.path.model.MainAction;
import com.autonavi.gbl.common.path.model.Ownership;
import com.autonavi.gbl.common.path.model.RoadClass;
import com.autonavi.gbl.common.path.model.RoadFacility;
import com.autonavi.gbl.common.path.model.RoadSlopeInfo;
import com.autonavi.gbl.common.path.model.SlopeInfo;
import com.autonavi.gbl.common.path.model.TurnInfo;
import com.autonavi.gbl.servicemanager.RefInfo;
import com.autonavi.gbl.servicemanager.RefManage;
import java.math.BigInteger;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LinkInfo {
    private static RefInfo.Callback refCallback = new RefInfo.Callback() { // from class: com.autonavi.gbl.common.path.option.LinkInfo.1
        @Override // com.autonavi.gbl.servicemanager.RefInfo.Callback
        public void delete(long j) {
            LinkInfo.destroyNativeObj(j);
        }
    };
    private Object ref;
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native boolean convertCameraTo3DCameraNative(long j, LinkInfo linkInfo, long j2, CameraExt cameraExt, long j3, CameraExt3d cameraExt3d);

    private static native long createNativeObj();

    private static native long createNativeObj1(long j, LinkInfo linkInfo);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void destroyNativeObj(long j);

    private static native long get32TopoIDNative(long j, LinkInfo linkInfo);

    private static native ExactTrafficItem get3DExactTrafficItemNative(long j, LinkInfo linkInfo);

    private static native boolean get3DPointsNative(long j, LinkInfo linkInfo, ArrayList<Coord3DInt32> arrayList);

    private static native BigInteger get64TopoIDNative(long j, LinkInfo linkInfo);

    private static native long getAdcodeNative(long j, LinkInfo linkInfo);

    private static native boolean getAllSlopeInfoNative(long j, LinkInfo linkInfo, ArrayList<SlopeInfo> arrayList);

    private static native int getAssistantActionNative(long j, LinkInfo linkInfo);

    private static native boolean getCameraExtNative(long j, LinkInfo linkInfo, ArrayList<CameraExt> arrayList);

    private static native ExactTrafficItem getExactTrafficItemNative(long j, LinkInfo linkInfo);

    private static native int getFineStatusNative(long j, LinkInfo linkInfo);

    private static native void getFloorInfoNative(long j, LinkInfo linkInfo, long j2, FloorInfo floorInfo);

    private static native int getFormwayNative(long j, LinkInfo linkInfo);

    private static native short getGantryInfosNative(long j, LinkInfo linkInfo, ArrayList<GantryInfo> arrayList);

    private static native HeightDiffData getHeightDiffDataNative(long j, LinkInfo linkInfo);

    private static native boolean getInnerRoadNative(long j, LinkInfo linkInfo);

    private static native short getLaneNumNative(long j, LinkInfo linkInfo);

    private static native int getLengthNative(long j, LinkInfo linkInfo);

    private static native short getLimitFlagNative(long j, LinkInfo linkInfo);

    private static native short getLinkDirectionNative(long j, LinkInfo linkInfo);

    private static native int getLinkIndexNative(long j, LinkInfo linkInfo);

    private static native int getLinkTypeNative(long j, LinkInfo linkInfo);

    private static native int getMainActionNative(long j, LinkInfo linkInfo);

    private static native long getNativeTypeHandleNative(long j, LinkInfo linkInfo);

    private static native int getOwnershipNative(long j, LinkInfo linkInfo);

    private static native boolean getPointsNative(long j, LinkInfo linkInfo, ArrayList<Coord2DInt32> arrayList);

    private static native long getRelatedPathIDNative(long j, LinkInfo linkInfo);

    private static native int getRelatedSegmentIndexNative(long j, LinkInfo linkInfo);

    private static native int getRoadClassNative(long j, LinkInfo linkInfo);

    private static native short getRoadDirectionNative(long j, LinkInfo linkInfo);

    private static native short getRoadFacilityCountNative(long j, LinkInfo linkInfo);

    private static native RoadFacility getRoadFacilityNative(long j, LinkInfo linkInfo, short s);

    private static native String getRoadNameNative(long j, LinkInfo linkInfo);

    private static native RoadSlopeInfo getRoadSlopInfoNative(long j, LinkInfo linkInfo);

    private static native String getServiceNameNative(long j, LinkInfo linkInfo);

    private static native short getSpeedLimitNative(long j, LinkInfo linkInfo);

    private static native short getSpeedNative(long j, LinkInfo linkInfo);

    private static native long getStaticTravelTimeNative(long j, LinkInfo linkInfo);

    private static native short getStatusNative(long j, LinkInfo linkInfo);

    private static native long getTPIDNative(long j, LinkInfo linkInfo);

    private static native long getTileIDNative(long j, LinkInfo linkInfo);

    private static native long getTravelTimeNative(long j, LinkInfo linkInfo);

    private static native short getTurnInfoCountNative(long j, LinkInfo linkInfo);

    private static native TurnInfo getTurnInfoNative(long j, LinkInfo linkInfo, short s);

    private static native int getURIDNative(long j, LinkInfo linkInfo);

    private static native boolean hasMixForkNative(long j, LinkInfo linkInfo);

    private static native boolean hasMultiOutNative(long j, LinkInfo linkInfo);

    private static native boolean hasParallelRoadNative(long j, LinkInfo linkInfo);

    private static native boolean hasTrafficLightNative(long j, LinkInfo linkInfo);

    private static native boolean isAtServiceNative(long j, LinkInfo linkInfo);

    private static native boolean isOverHeadNative(long j, LinkInfo linkInfo);

    private static native boolean isParkingRoadNative(long j, LinkInfo linkInfo);

    private static native boolean isRestrictingNative(long j, LinkInfo linkInfo);

    private static native boolean isSupport3DNavigationNative(long j, LinkInfo linkInfo);

    private static native boolean isTollNative(long j, LinkInfo linkInfo);

    private static native boolean isValidNative(long j, LinkInfo linkInfo);

    private static native void setTravelTimeNative(long j, LinkInfo linkInfo, long j2);

    public LinkInfo(long j, boolean z) {
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

    public static long getCPtr(LinkInfo linkInfo) {
        if (linkInfo == null) {
            return 0L;
        }
        return linkInfo.swigCPtr;
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

    public LinkInfo() {
        this(createNativeObj(), true);
    }

    public LinkInfo(LinkInfo linkInfo) {
        this(createNativeObj1(getCPtr(linkInfo), linkInfo), true);
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

    public int getRelatedSegmentIndex() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRelatedSegmentIndexNative(j, this);
    }

    public int getLinkIndex() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLinkIndexNative(j, this);
    }

    public int getLength() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLengthNative(j, this);
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

    public long getStaticTravelTime() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getStaticTravelTimeNative(j, this);
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

    public String getRoadName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRoadNameNative(j, this);
    }

    public short getRoadFacilityCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRoadFacilityCountNative(j, this);
    }

    public RoadFacility getRoadFacility(short s) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRoadFacilityNative(j, this, s);
    }

    public long get32TopoID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return get32TopoIDNative(j, this);
    }

    public BigInteger get64TopoID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return get64TopoIDNative(j, this);
    }

    public int getURID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getURIDNative(j, this);
    }

    public long getTileID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTileIDNative(j, this);
    }

    public long getTPID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTPIDNative(j, this);
    }

    public short getLinkDirection() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLinkDirectionNative(j, this);
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

    public long getAdcode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAdcodeNative(j, this);
    }

    @LinkType.LinkType1
    public int getLinkType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLinkTypeNative(j, this);
    }

    @Formway.Formway1
    public int getFormway() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getFormwayNative(j, this);
    }

    @RoadClass.RoadClass1
    public int getRoadClass() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRoadClassNative(j, this);
    }

    public short getRoadDirection() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRoadDirectionNative(j, this);
    }

    @Ownership.Ownership1
    public int getOwnership() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getOwnershipNative(j, this);
    }

    public boolean isToll() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isTollNative(j, this);
    }

    public boolean isOverHead() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isOverHeadNative(j, this);
    }

    public boolean hasParallelRoad() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return hasParallelRoadNative(j, this);
    }

    public boolean hasMultiOut() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return hasMultiOutNative(j, this);
    }

    public boolean hasTrafficLight() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return hasTrafficLightNative(j, this);
    }

    public boolean hasMixFork() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return hasMixForkNative(j, this);
    }

    public boolean isAtService() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isAtServiceNative(j, this);
    }

    public boolean isSupport3DNavigation() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isSupport3DNavigationNative(j, this);
    }

    public boolean isRestricting() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isRestrictingNative(j, this);
    }

    public short getSpeedLimit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSpeedLimitNative(j, this);
    }

    public short getLimitFlag() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLimitFlagNative(j, this);
    }

    public short getSpeed() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSpeedNative(j, this);
    }

    public short getStatus() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getStatusNative(j, this);
    }

    public int getFineStatus() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getFineStatusNative(j, this);
    }

    public ArrayList<CameraExt> getCameraExt() {
        ArrayList<CameraExt> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getCameraExt(arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getCameraExt(ArrayList<CameraExt> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCameraExtNative(j, this, arrayList);
    }

    public CameraExt3d convertCameraTo3DCamera(CameraExt cameraExt) {
        CameraExt3d cameraExt3d = new CameraExt3d();
        if (Boolean.valueOf(convertCameraTo3DCamera(cameraExt, cameraExt3d)).booleanValue()) {
            return cameraExt3d;
        }
        return null;
    }

    private boolean convertCameraTo3DCamera(CameraExt cameraExt, CameraExt3d cameraExt3d) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return convertCameraTo3DCameraNative(j, this, 0L, cameraExt, 0L, cameraExt3d);
    }

    public short getTurnInfoCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTurnInfoCountNative(j, this);
    }

    public TurnInfo getTurnInfo(short s) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTurnInfoNative(j, this, s);
    }

    public ExactTrafficItem get3DExactTrafficItem() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return get3DExactTrafficItemNative(j, this);
    }

    public ExactTrafficItem getExactTrafficItem() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getExactTrafficItemNative(j, this);
    }

    public HeightDiffData getHeightDiffData() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getHeightDiffDataNative(j, this);
    }

    public String getServiceName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getServiceNameNative(j, this);
    }

    public long getNativeTypeHandle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getNativeTypeHandleNative(j, this);
    }

    public RoadSlopeInfo getRoadSlopInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRoadSlopInfoNative(j, this);
    }

    public ArrayList<GantryInfo> getGantryInfos() {
        ArrayList<GantryInfo> arrayList = new ArrayList<>();
        Short.valueOf(getGantryInfos(arrayList));
        return arrayList;
    }

    private short getGantryInfos(ArrayList<GantryInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getGantryInfosNative(j, this, arrayList);
    }

    public boolean getInnerRoad() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getInnerRoadNative(j, this);
    }

    public boolean isParkingRoad() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isParkingRoadNative(j, this);
    }

    public FloorInfo getFloorInfo() {
        FloorInfo floorInfo = new FloorInfo();
        getFloorInfo(floorInfo);
        return floorInfo;
    }

    private void getFloorInfo(FloorInfo floorInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getFloorInfoNative(j, this, 0L, floorInfo);
    }

    public ArrayList<SlopeInfo> getAllSlopeInfo() {
        ArrayList<SlopeInfo> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getAllSlopeInfo(arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getAllSlopeInfo(ArrayList<SlopeInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAllSlopeInfoNative(j, this, arrayList);
    }

    public short getLaneNum() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLaneNumNative(j, this);
    }
}
