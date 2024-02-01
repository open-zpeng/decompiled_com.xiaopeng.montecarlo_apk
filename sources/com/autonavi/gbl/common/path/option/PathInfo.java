package com.autonavi.gbl.common.path.option;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord2DInt32;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.ElecKeyPointConfig;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.path.model.AbnormalSection;
import com.autonavi.gbl.common.path.model.AlongWayProbeConfig;
import com.autonavi.gbl.common.path.model.AvoidLimitReason;
import com.autonavi.gbl.common.path.model.AvoidTrafficJamInfo;
import com.autonavi.gbl.common.path.model.ChargeStationInfo;
import com.autonavi.gbl.common.path.model.CloudShowInfo;
import com.autonavi.gbl.common.path.model.DifferentPoint;
import com.autonavi.gbl.common.path.model.DifferentSection;
import com.autonavi.gbl.common.path.model.ElecPathInfo;
import com.autonavi.gbl.common.path.model.GroupSegment;
import com.autonavi.gbl.common.path.model.JamSegment;
import com.autonavi.gbl.common.path.model.LabelInfo;
import com.autonavi.gbl.common.path.model.LightBarItem;
import com.autonavi.gbl.common.path.model.LineIconPoint;
import com.autonavi.gbl.common.path.model.LineItem;
import com.autonavi.gbl.common.path.model.OddSegInfo;
import com.autonavi.gbl.common.path.model.POIInfo;
import com.autonavi.gbl.common.path.model.PathCameraExt;
import com.autonavi.gbl.common.path.model.PathCameraExt3d;
import com.autonavi.gbl.common.path.model.PathDescriptionInfo;
import com.autonavi.gbl.common.path.model.PathGrayInfo;
import com.autonavi.gbl.common.path.model.PathIndoorParkingInfo;
import com.autonavi.gbl.common.path.model.PathPriorityType;
import com.autonavi.gbl.common.path.model.PathShadowPoint;
import com.autonavi.gbl.common.path.model.PathType;
import com.autonavi.gbl.common.path.model.ProbeNaviInfo;
import com.autonavi.gbl.common.path.model.ProbeResult;
import com.autonavi.gbl.common.path.model.RestAreaInfo;
import com.autonavi.gbl.common.path.model.RestTollGateInfo;
import com.autonavi.gbl.common.path.model.RestrictionInfo;
import com.autonavi.gbl.common.path.model.RoadExtraSceneInfo;
import com.autonavi.gbl.common.path.model.RouteForbidden;
import com.autonavi.gbl.common.path.model.RouteHttpProtocolParam;
import com.autonavi.gbl.common.path.model.TipInfo;
import com.autonavi.gbl.common.path.model.TrafficIncident;
import com.autonavi.gbl.common.path.model.TrafficJamInfo;
import com.autonavi.gbl.common.path.model.ViaMergeInfo;
import com.autonavi.gbl.common.path.model.ViaPointAggregateInfo;
import com.autonavi.gbl.common.path.model.ViaPointInfo;
import com.autonavi.gbl.common.path.model.ViaRoadInfo;
import com.autonavi.gbl.common.path.option.RouteType;
import com.autonavi.gbl.servicemanager.RefInfo;
import com.autonavi.gbl.servicemanager.RefManage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PathInfo {
    private static RefInfo.Callback refCallback = new RefInfo.Callback() { // from class: com.autonavi.gbl.common.path.option.PathInfo.1
        @Override // com.autonavi.gbl.servicemanager.RefInfo.Callback
        public void delete(long j) {
            PathInfo.destroyNativeObj(j);
        }
    };
    private Object ref;
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void buildRarefyPointNative(long j, PathInfo pathInfo, long j2, AlongWayProbeConfig alongWayProbeConfig, long j3, ProbeNaviInfo probeNaviInfo, long j4, ProbeResult probeResult);

    private static native long createNativeObj();

    private static native long createNativeObj1(long j, PathInfo pathInfo);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void destroyNativeObj(long j);

    private static native short getAbnormalSectionCountNative(long j, PathInfo pathInfo);

    private static native AbnormalSection getAbnormalSectionNative(long j, PathInfo pathInfo, short s);

    private static native byte getAbnormalStateNative(long j, PathInfo pathInfo);

    private static native boolean getAll3DCamerasNative(long j, PathInfo pathInfo, ArrayList<PathCameraExt3d> arrayList);

    private static native boolean getAll3DTrafficLightsNative(long j, PathInfo pathInfo, ArrayList<Coord3DDouble> arrayList);

    private static native boolean getAllCamerasNative(long j, PathInfo pathInfo, ArrayList<PathCameraExt> arrayList);

    private static native boolean getAllTrafficLightsNative(long j, PathInfo pathInfo, ArrayList<Coord2DDouble> arrayList);

    private static native void getAlongRoadIDNative(long j, PathInfo pathInfo, long j2, long j3, ArrayList<Long> arrayList);

    private static native long getAvoidLimitReasonCountNative(long j, PathInfo pathInfo);

    private static native AvoidLimitReason getAvoidLimitReasonNative(long j, PathInfo pathInfo, short s);

    private static native short getAvoidTrafficJamCountNative(long j, PathInfo pathInfo);

    private static native AvoidTrafficJamInfo getAvoidTrafficJamNative(long j, PathInfo pathInfo, short s);

    private static native boolean getBoundNative(long j, PathInfo pathInfo, long j2, long j3, long j4, long j5, RectDouble rectDouble);

    private static native boolean getChargeStationInfoNative(long j, PathInfo pathInfo, ArrayList<ChargeStationInfo> arrayList);

    private static native boolean getCityAdcodeListNative(long j, PathInfo pathInfo, ArrayList<Long> arrayList);

    private static native boolean getClosestPointNative(long j, PathInfo pathInfo, long j2, Coord2DDouble coord2DDouble, long j3, Coord2DDouble coord2DDouble2);

    private static native void getCloudShowInfoNative(long j, PathInfo pathInfo, ArrayList<CloudShowInfo> arrayList);

    private static native long getDataVersionNative(long j, PathInfo pathInfo);

    private static native long getDifferentPointsNative(long j, PathInfo pathInfo, ArrayList<DifferentPoint> arrayList);

    private static native long getDifferentSectionsNative(long j, PathInfo pathInfo, ArrayList<DifferentSection> arrayList);

    private static native long getETASavedTimeNative(long j, PathInfo pathInfo);

    private static native ElecPathInfo getElecPathInfoNative(long j, PathInfo pathInfo);

    private static native boolean getElecPathKeyPointNative(long j, PathInfo pathInfo, long j2, ElecKeyPointConfig elecKeyPointConfig, long j3, Coord2DInt32 coord2DInt32);

    private static native short getEndDirectionNative(long j, PathInfo pathInfo);

    private static native POIInfo getEndPoiNative(long j, PathInfo pathInfo);

    private static native long getEstimateBinaryDataSizeNative(long j, PathInfo pathInfo);

    private static native short getForbiddenInfoCountNative(long j, PathInfo pathInfo);

    private static native RouteForbidden getForbiddenInfoNative(long j, PathInfo pathInfo, short s);

    private static native boolean getGrayPointIndexNative(long j, PathInfo pathInfo, long j2, PathShadowPoint pathShadowPoint, long j3, PathGrayInfo pathGrayInfo);

    private static native long getGroupSegmentCountNative(long j, PathInfo pathInfo);

    private static native GroupSegment getGroupSegmentNative(long j, PathInfo pathInfo, long j2);

    private static native boolean getHttpProtocolParamNative(long j, PathInfo pathInfo, long j2, RouteHttpProtocolParam routeHttpProtocolParam);

    private static native boolean getIndoorParkingInfoNative(long j, PathInfo pathInfo, long j2, PathIndoorParkingInfo pathIndoorParkingInfo);

    private static native void getJamSegmentNative(long j, PathInfo pathInfo, ArrayList<JamSegment> arrayList);

    private static native long getLabelInfoBatchIdxNative(long j, PathInfo pathInfo);

    private static native short getLabelInfoCountNative(long j, PathInfo pathInfo);

    private static native LabelInfo getLabelInfoNative(long j, PathInfo pathInfo, short s);

    private static native long getLengthNative(long j, PathInfo pathInfo);

    private static native boolean getLightBarItemsNative(long j, PathInfo pathInfo, ArrayList<LightBarItem> arrayList);

    private static native void getLineIconPointsNative(long j, PathInfo pathInfo, ArrayList<LineIconPoint> arrayList);

    private static native LineItem getLineItemNative(long j, PathInfo pathInfo, boolean z);

    private static native long getMainRouteRemainTollCostNative(long j, PathInfo pathInfo);

    private static native long getNativeTypeHandleNative(long j, PathInfo pathInfo);

    private static native String getNaviIDNative(long j, PathInfo pathInfo);

    private static native long getNormalPlanTimeNative(long j, PathInfo pathInfo);

    private static native boolean getODDPointsNative(long j, PathInfo pathInfo, long j2, ArrayList<Coord2DDouble> arrayList);

    private static native long getOddSegInfosNative(long j, PathInfo pathInfo, ArrayList<OddSegInfo> arrayList);

    private static native void getOfflineReqCustomIdentityIdNative(long j, PathInfo pathInfo, String[] strArr);

    private static native PathDescriptionInfo getPathDescriptionInfoNative(long j, PathInfo pathInfo);

    private static native long getPathIDNative(long j, PathInfo pathInfo);

    private static native long getPathIndexNative(long j, PathInfo pathInfo);

    private static native void getPathViaPointInfoNative(long j, PathInfo pathInfo, ArrayList<ViaPointAggregateInfo> arrayList);

    private static native void getPathViaRoadInfoNative(long j, PathInfo pathInfo, ArrayList<ViaRoadInfo> arrayList);

    private static native void getPlanChannelIdNative(long j, PathInfo pathInfo, String[] strArr);

    private static native long getPreviousNaviPathIDNative(long j, PathInfo pathInfo);

    private static native int getPriorityNative(long j, PathInfo pathInfo);

    private static native long getRemainTollCostNative(long j, PathInfo pathInfo);

    private static native void getRestAreasNative(long j, PathInfo pathInfo, long j2, long j3, ArrayList<RestAreaInfo> arrayList);

    private static native void getRestTollGateNative(long j, PathInfo pathInfo, long j2, long j3, ArrayList<RestTollGateInfo> arrayList);

    private static native RestrictionInfo getRestrictionInfoNative(long j, PathInfo pathInfo);

    private static native short getReverseLabelInfoCountNative(long j, PathInfo pathInfo);

    private static native LabelInfo getReverseLabelInfoNative(long j, PathInfo pathInfo, short s);

    private static native void getRoadExtraSceneInfoNative(long j, PathInfo pathInfo, ArrayList<RoadExtraSceneInfo> arrayList);

    private static native short getRoadStatusFlagNative(long j, PathInfo pathInfo);

    private static native int getRouteTypeNative(long j, PathInfo pathInfo);

    private static native boolean getSegEndPointListNative(long j, PathInfo pathInfo, ArrayList<Coord2DInt32> arrayList);

    private static native long getSegmentCountNative(long j, PathInfo pathInfo);

    private static native boolean getSegmentInfoNative(long j, PathInfo pathInfo, long j2, long j3, SegmentInfo segmentInfo);

    private static native long getStaticTravelTimeNative(long j, PathInfo pathInfo);

    private static native long getStrategyNative(long j, PathInfo pathInfo);

    private static native TipInfo getTipNative(long j, PathInfo pathInfo);

    private static native int getTollCostNative(long j, PathInfo pathInfo);

    private static native short getTrafficIncidentCountNative(long j, PathInfo pathInfo, boolean z);

    private static native TrafficIncident getTrafficIncidentNative(long j, PathInfo pathInfo, short s, boolean z);

    private static native short getTrafficJamCountNative(long j, PathInfo pathInfo);

    private static native TrafficJamInfo getTrafficJamInfoNative(long j, PathInfo pathInfo, short s);

    private static native long getTrafficLightCountNative(long j, PathInfo pathInfo);

    private static native long getTravelTimeNative(long j, PathInfo pathInfo);

    private static native int getTypeNative(long j, PathInfo pathInfo);

    private static native boolean getViaPoiAndChargeStationMergeInfoNative(long j, PathInfo pathInfo, ArrayList<ViaMergeInfo> arrayList);

    private static native boolean getViaPointInfoNative(long j, PathInfo pathInfo, ArrayList<ViaPointInfo> arrayList);

    private static native boolean hasBetterETAPathNative(long j, PathInfo pathInfo);

    private static native boolean isAvoidLimitRoadNative(long j, PathInfo pathInfo);

    private static native boolean isHolidayFreeNative(long j, PathInfo pathInfo);

    private static native boolean isNeedEncodePathDataNative(long j, PathInfo pathInfo, boolean z, boolean z2);

    private static native boolean isOnlineNative(long j, PathInfo pathInfo);

    private static native boolean isTruckPathNative(long j, PathInfo pathInfo);

    private static native boolean isValidNative(long j, PathInfo pathInfo);

    private static native void resetGrayPathInfoNative(long j, PathInfo pathInfo);

    private static native void setLineItemNaviToConsisNative(long j, PathInfo pathInfo, long j2, LineItem lineItem);

    private static native void setOfflineReqCustomIdentityIdNative(long j, PathInfo pathInfo, String str);

    private static native void setPlanChannelIdNative(long j, PathInfo pathInfo, String str);

    private static native void setPriorityNative(long j, PathInfo pathInfo, int i);

    private static native void setTravelTimeNative(long j, PathInfo pathInfo, long j2);

    private static native boolean updateTmcBarNative(long j, PathInfo pathInfo, ArrayList<LightBarItem> arrayList);

    public PathInfo(long j, boolean z) {
        this.ref = null;
        this.swigCMemOwn = z;
        this.swigCPtr = j;
        if (true == this.swigCMemOwn) {
            long j2 = this.swigCPtr;
            if (j2 != 0) {
                this.ref = RefManage.register(this, j2, getPathID(), (int) getEstimateBinaryDataSize(), refCallback);
            }
        }
    }

    public static long getCPtr(PathInfo pathInfo) {
        if (pathInfo == null) {
            return 0L;
        }
        return pathInfo.swigCPtr;
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

    public PathInfo() {
        this(createNativeObj(), true);
    }

    public PathInfo(PathInfo pathInfo) {
        this(createNativeObj1(getCPtr(pathInfo), pathInfo), true);
    }

    public boolean isValid() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isValidNative(j, this);
    }

    public long getPathID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPathIDNative(j, this);
    }

    @PathType.PathType1
    public int getType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTypeNative(j, this);
    }

    public long getLength() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLengthNative(j, this);
    }

    public long getStrategy() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getStrategyNative(j, this);
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

    public int getTollCost() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTollCostNative(j, this);
    }

    public long getTrafficLightCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTrafficLightCountNative(j, this);
    }

    public ArrayList<Coord2DDouble> getAllTrafficLights() {
        ArrayList<Coord2DDouble> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getAllTrafficLights(arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getAllTrafficLights(ArrayList<Coord2DDouble> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAllTrafficLightsNative(j, this, arrayList);
    }

    public ArrayList<Coord3DDouble> getAll3DTrafficLights() {
        ArrayList<Coord3DDouble> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getAll3DTrafficLights(arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getAll3DTrafficLights(ArrayList<Coord3DDouble> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAll3DTrafficLightsNative(j, this, arrayList);
    }

    public ArrayList<PathCameraExt> getAllCameras() {
        ArrayList<PathCameraExt> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getAllCameras(arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getAllCameras(ArrayList<PathCameraExt> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAllCamerasNative(j, this, arrayList);
    }

    public ArrayList<PathCameraExt3d> getAll3DCameras() {
        ArrayList<PathCameraExt3d> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getAll3DCameras(arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getAll3DCameras(ArrayList<PathCameraExt3d> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAll3DCamerasNative(j, this, arrayList);
    }

    public ArrayList<LightBarItem> getLightBarItems() {
        ArrayList<LightBarItem> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getLightBarItems(arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getLightBarItems(ArrayList<LightBarItem> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLightBarItemsNative(j, this, arrayList);
    }

    public String getNaviID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getNaviIDNative(j, this);
    }

    public boolean isOnline() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isOnlineNative(j, this);
    }

    public long getSegmentCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSegmentCountNative(j, this);
    }

    public SegmentInfo getSegmentInfo(long j) {
        SegmentInfo segmentInfo = new SegmentInfo();
        if (Boolean.valueOf(getSegmentInfo(j, segmentInfo)).booleanValue()) {
            return segmentInfo;
        }
        return null;
    }

    private boolean getSegmentInfo(long j, SegmentInfo segmentInfo) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return getSegmentInfoNative(j2, this, j, SegmentInfo.getCPtr(segmentInfo), segmentInfo);
    }

    public short getLabelInfoCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLabelInfoCountNative(j, this);
    }

    public LabelInfo getLabelInfo(short s) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLabelInfoNative(j, this, s);
    }

    public short getReverseLabelInfoCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getReverseLabelInfoCountNative(j, this);
    }

    public LabelInfo getReverseLabelInfo(short s) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getReverseLabelInfoNative(j, this, s);
    }

    public short getTrafficJamCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTrafficJamCountNative(j, this);
    }

    public TrafficJamInfo getTrafficJamInfo(short s) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTrafficJamInfoNative(j, this, s);
    }

    public long getGroupSegmentCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getGroupSegmentCountNative(j, this);
    }

    public GroupSegment getGroupSegment(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return getGroupSegmentNative(j2, this, j);
    }

    public short getTrafficIncidentCount(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTrafficIncidentCountNative(j, this, z);
    }

    public TrafficIncident getTrafficIncident(short s, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTrafficIncidentNative(j, this, s, z);
    }

    public long getAvoidLimitReasonCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAvoidLimitReasonCountNative(j, this);
    }

    public AvoidLimitReason getAvoidLimitReason(short s) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAvoidLimitReasonNative(j, this, s);
    }

    public short getAvoidTrafficJamCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAvoidTrafficJamCountNative(j, this);
    }

    public AvoidTrafficJamInfo getAvoidTrafficJam(short s) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAvoidTrafficJamNative(j, this, s);
    }

    public short getForbiddenInfoCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getForbiddenInfoCountNative(j, this);
    }

    public RouteForbidden getForbiddenInfo(short s) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getForbiddenInfoNative(j, this, s);
    }

    public byte getAbnormalState() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAbnormalStateNative(j, this);
    }

    public short getAbnormalSectionCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAbnormalSectionCountNative(j, this);
    }

    public AbnormalSection getAbnormalSection(short s) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAbnormalSectionNative(j, this, s);
    }

    public RestrictionInfo getRestrictionInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRestrictionInfoNative(j, this);
    }

    public POIInfo getEndPoi() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getEndPoiNative(j, this);
    }

    public TipInfo getTip() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTipNative(j, this);
    }

    public short getEndDirection() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getEndDirectionNative(j, this);
    }

    public boolean isHolidayFree() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isHolidayFreeNative(j, this);
    }

    public boolean hasBetterETAPath() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return hasBetterETAPathNative(j, this);
    }

    public boolean isAvoidLimitRoad() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isAvoidLimitRoadNative(j, this);
    }

    public boolean isTruckPath() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isTruckPathNative(j, this);
    }

    public boolean isNeedEncodePathData(boolean z, boolean z2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isNeedEncodePathDataNative(j, this, z, z2);
    }

    public long getDataVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDataVersionNative(j, this);
    }

    public long getETASavedTime() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getETASavedTimeNative(j, this);
    }

    public long getNormalPlanTime() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getNormalPlanTimeNative(j, this);
    }

    public long getPreviousNaviPathID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPreviousNaviPathIDNative(j, this);
    }

    public void setPriority(@PathPriorityType.PathPriorityType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPriorityNative(j, this, i);
    }

    @PathPriorityType.PathPriorityType1
    public int getPriority() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPriorityNative(j, this);
    }

    public long getPathIndex() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPathIndexNative(j, this);
    }

    public ArrayList<DifferentPoint> getDifferentPoints() {
        ArrayList<DifferentPoint> arrayList = new ArrayList<>();
        Long.valueOf(getDifferentPoints(arrayList));
        return arrayList;
    }

    private long getDifferentPoints(ArrayList<DifferentPoint> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDifferentPointsNative(j, this, arrayList);
    }

    public ArrayList<DifferentSection> getDifferentSections() {
        ArrayList<DifferentSection> arrayList = new ArrayList<>();
        Long.valueOf(getDifferentSections(arrayList));
        return arrayList;
    }

    private long getDifferentSections(ArrayList<DifferentSection> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDifferentSectionsNative(j, this, arrayList);
    }

    @RouteType.RouteType1
    public int getRouteType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRouteTypeNative(j, this);
    }

    public ArrayList<JamSegment> getJamSegment() {
        ArrayList<JamSegment> arrayList = new ArrayList<>();
        getJamSegment(arrayList);
        return arrayList;
    }

    private void getJamSegment(ArrayList<JamSegment> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getJamSegmentNative(j, this, arrayList);
    }

    public LineItem getLineItem(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLineItemNative(j, this, z);
    }

    public ArrayList<LineIconPoint> getLineIconPoints() {
        ArrayList<LineIconPoint> arrayList = new ArrayList<>();
        getLineIconPoints(arrayList);
        return arrayList;
    }

    private void getLineIconPoints(ArrayList<LineIconPoint> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getLineIconPointsNative(j, this, arrayList);
    }

    public ArrayList<Long> getAlongRoadID(long j, long j2) {
        ArrayList<Long> arrayList = new ArrayList<>();
        getAlongRoadID(j, j2, arrayList);
        return arrayList;
    }

    private void getAlongRoadID(long j, long j2, ArrayList<Long> arrayList) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        getAlongRoadIDNative(j3, this, j, j2, arrayList);
    }

    public ProbeResult buildRarefyPoint(AlongWayProbeConfig alongWayProbeConfig, ProbeNaviInfo probeNaviInfo) {
        ProbeResult probeResult = new ProbeResult();
        buildRarefyPoint(alongWayProbeConfig, probeNaviInfo, probeResult);
        return probeResult;
    }

    private void buildRarefyPoint(AlongWayProbeConfig alongWayProbeConfig, ProbeNaviInfo probeNaviInfo, ProbeResult probeResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        buildRarefyPointNative(j, this, 0L, alongWayProbeConfig, 0L, probeNaviInfo, 0L, probeResult);
    }

    public Coord2DDouble getClosestPoint(Coord2DDouble coord2DDouble) {
        Coord2DDouble coord2DDouble2 = new Coord2DDouble();
        if (Boolean.valueOf(getClosestPoint(coord2DDouble, coord2DDouble2)).booleanValue()) {
            return coord2DDouble2;
        }
        return null;
    }

    private boolean getClosestPoint(Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getClosestPointNative(j, this, 0L, coord2DDouble, 0L, coord2DDouble2);
    }

    public RectDouble getBound(long j, long j2, long j3) {
        RectDouble rectDouble = new RectDouble();
        if (Boolean.valueOf(getBound(j, j2, j3, rectDouble)).booleanValue()) {
            return rectDouble;
        }
        return null;
    }

    private boolean getBound(long j, long j2, long j3, RectDouble rectDouble) {
        long j4 = this.swigCPtr;
        if (j4 == 0) {
            throw new NullPointerException();
        }
        return getBoundNative(j4, this, j, j2, j3, 0L, rectDouble);
    }

    public ArrayList<RestAreaInfo> getRestAreas(long j, long j2) {
        ArrayList<RestAreaInfo> arrayList = new ArrayList<>();
        getRestAreas(j, j2, arrayList);
        return arrayList;
    }

    private void getRestAreas(long j, long j2, ArrayList<RestAreaInfo> arrayList) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        getRestAreasNative(j3, this, j, j2, arrayList);
    }

    public ArrayList<RestTollGateInfo> getRestTollGate(long j, long j2) {
        ArrayList<RestTollGateInfo> arrayList = new ArrayList<>();
        getRestTollGate(j, j2, arrayList);
        return arrayList;
    }

    private void getRestTollGate(long j, long j2, ArrayList<RestTollGateInfo> arrayList) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        getRestTollGateNative(j3, this, j, j2, arrayList);
    }

    public ArrayList<Coord2DInt32> getSegEndPointList() {
        ArrayList<Coord2DInt32> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getSegEndPointList(arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getSegEndPointList(ArrayList<Coord2DInt32> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSegEndPointListNative(j, this, arrayList);
    }

    public ArrayList<Long> getCityAdcodeList() {
        ArrayList<Long> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getCityAdcodeList(arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getCityAdcodeList(ArrayList<Long> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCityAdcodeListNative(j, this, arrayList);
    }

    public PathGrayInfo getGrayPointIndex(PathShadowPoint pathShadowPoint) {
        PathGrayInfo pathGrayInfo = new PathGrayInfo();
        if (Boolean.valueOf(getGrayPointIndex(pathShadowPoint, pathGrayInfo)).booleanValue()) {
            return pathGrayInfo;
        }
        return null;
    }

    private boolean getGrayPointIndex(PathShadowPoint pathShadowPoint, PathGrayInfo pathGrayInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getGrayPointIndexNative(j, this, 0L, pathShadowPoint, 0L, pathGrayInfo);
    }

    public boolean updateTmcBar(ArrayList<LightBarItem> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateTmcBarNative(j, this, arrayList);
    }

    public void resetGrayPathInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resetGrayPathInfoNative(j, this);
    }

    public ElecPathInfo getElecPathInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getElecPathInfoNative(j, this);
    }

    public ArrayList<ViaPointInfo> getViaPointInfo() {
        ArrayList<ViaPointInfo> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getViaPointInfo(arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getViaPointInfo(ArrayList<ViaPointInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getViaPointInfoNative(j, this, arrayList);
    }

    public ArrayList<ChargeStationInfo> getChargeStationInfo() {
        ArrayList<ChargeStationInfo> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getChargeStationInfo(arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getChargeStationInfo(ArrayList<ChargeStationInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getChargeStationInfoNative(j, this, arrayList);
    }

    public ArrayList<RoadExtraSceneInfo> getRoadExtraSceneInfo() {
        ArrayList<RoadExtraSceneInfo> arrayList = new ArrayList<>();
        getRoadExtraSceneInfo(arrayList);
        return arrayList;
    }

    private void getRoadExtraSceneInfo(ArrayList<RoadExtraSceneInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getRoadExtraSceneInfoNative(j, this, arrayList);
    }

    public PathDescriptionInfo getPathDescriptionInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPathDescriptionInfoNative(j, this);
    }

    public Coord2DInt32 getElecPathKeyPoint(ElecKeyPointConfig elecKeyPointConfig) {
        Coord2DInt32 coord2DInt32 = new Coord2DInt32();
        if (Boolean.valueOf(getElecPathKeyPoint(elecKeyPointConfig, coord2DInt32)).booleanValue()) {
            return coord2DInt32;
        }
        return null;
    }

    private boolean getElecPathKeyPoint(ElecKeyPointConfig elecKeyPointConfig, Coord2DInt32 coord2DInt32) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getElecPathKeyPointNative(j, this, 0L, elecKeyPointConfig, 0L, coord2DInt32);
    }

    public ArrayList<ViaRoadInfo> getPathViaRoadInfo() {
        ArrayList<ViaRoadInfo> arrayList = new ArrayList<>();
        getPathViaRoadInfo(arrayList);
        return arrayList;
    }

    private void getPathViaRoadInfo(ArrayList<ViaRoadInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getPathViaRoadInfoNative(j, this, arrayList);
    }

    public ArrayList<ViaPointAggregateInfo> getPathViaPointInfo() {
        ArrayList<ViaPointAggregateInfo> arrayList = new ArrayList<>();
        getPathViaPointInfo(arrayList);
        return arrayList;
    }

    private void getPathViaPointInfo(ArrayList<ViaPointAggregateInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getPathViaPointInfoNative(j, this, arrayList);
    }

    public ArrayList<CloudShowInfo> getCloudShowInfo() {
        ArrayList<CloudShowInfo> arrayList = new ArrayList<>();
        getCloudShowInfo(arrayList);
        return arrayList;
    }

    private void getCloudShowInfo(ArrayList<CloudShowInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getCloudShowInfoNative(j, this, arrayList);
    }

    public ArrayList<OddSegInfo> getOddSegInfos() {
        ArrayList<OddSegInfo> arrayList = new ArrayList<>();
        Long.valueOf(getOddSegInfos(arrayList));
        return arrayList;
    }

    private long getOddSegInfos(ArrayList<OddSegInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getOddSegInfosNative(j, this, arrayList);
    }

    public ArrayList<Coord2DDouble> getODDPoints(long j) {
        ArrayList<Coord2DDouble> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getODDPoints(j, arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getODDPoints(long j, ArrayList<Coord2DDouble> arrayList) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return getODDPointsNative(j2, this, j, arrayList);
    }

    public long getRemainTollCost() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRemainTollCostNative(j, this);
    }

    public long getMainRouteRemainTollCost() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMainRouteRemainTollCostNative(j, this);
    }

    public short getRoadStatusFlag() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getRoadStatusFlagNative(j, this);
    }

    public PathIndoorParkingInfo getIndoorParkingInfo() {
        PathIndoorParkingInfo pathIndoorParkingInfo = new PathIndoorParkingInfo();
        if (Boolean.valueOf(getIndoorParkingInfo(pathIndoorParkingInfo)).booleanValue()) {
            return pathIndoorParkingInfo;
        }
        return null;
    }

    private boolean getIndoorParkingInfo(PathIndoorParkingInfo pathIndoorParkingInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getIndoorParkingInfoNative(j, this, 0L, pathIndoorParkingInfo);
    }

    public ArrayList<ViaMergeInfo> getViaPoiAndChargeStationMergeInfo() {
        ArrayList<ViaMergeInfo> arrayList = new ArrayList<>();
        if (Boolean.valueOf(getViaPoiAndChargeStationMergeInfo(arrayList)).booleanValue()) {
            return arrayList;
        }
        return null;
    }

    private boolean getViaPoiAndChargeStationMergeInfo(ArrayList<ViaMergeInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getViaPoiAndChargeStationMergeInfoNative(j, this, arrayList);
    }

    public long getLabelInfoBatchIdx() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLabelInfoBatchIdxNative(j, this);
    }

    private long getEstimateBinaryDataSize() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getEstimateBinaryDataSizeNative(j, this);
    }

    public long getNativeTypeHandle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getNativeTypeHandleNative(j, this);
    }

    public RouteHttpProtocolParam getHttpProtocolParam() {
        RouteHttpProtocolParam routeHttpProtocolParam = new RouteHttpProtocolParam();
        if (Boolean.valueOf(getHttpProtocolParam(routeHttpProtocolParam)).booleanValue()) {
            return routeHttpProtocolParam;
        }
        return null;
    }

    private boolean getHttpProtocolParam(RouteHttpProtocolParam routeHttpProtocolParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getHttpProtocolParamNative(j, this, 0L, routeHttpProtocolParam);
    }

    public void setLineItemNaviToConsis(LineItem lineItem) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setLineItemNaviToConsisNative(j, this, 0L, lineItem);
    }

    public void setTravelTime(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setTravelTimeNative(j2, this, j);
    }

    public void setPlanChannelId(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setPlanChannelIdNative(j, this, str);
    }

    public String getPlanChannelId() {
        String[] strArr = new String[1];
        getPlanChannelId(strArr);
        return strArr[0];
    }

    private void getPlanChannelId(String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getPlanChannelIdNative(j, this, strArr);
    }

    public void setOfflineReqCustomIdentityId(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setOfflineReqCustomIdentityIdNative(j, this, str);
    }

    public String getOfflineReqCustomIdentityId() {
        String[] strArr = new String[1];
        getOfflineReqCustomIdentityId(strArr);
        return strArr[0];
    }

    private void getOfflineReqCustomIdentityId(String[] strArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getOfflineReqCustomIdentityIdNative(j, this, strArr);
    }
}
