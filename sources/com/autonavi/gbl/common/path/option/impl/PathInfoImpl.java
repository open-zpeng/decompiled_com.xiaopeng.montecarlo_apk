package com.autonavi.gbl.common.path.option.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord2DInt32;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.ElecKeyPointConfig;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.path.model.AbnormalSection;
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
import com.autonavi.gbl.common.path.model.PathCamera;
import com.autonavi.gbl.common.path.model.PathCamera3d;
import com.autonavi.gbl.common.path.model.PathDescriptionInfo;
import com.autonavi.gbl.common.path.model.PathGrayInfo;
import com.autonavi.gbl.common.path.model.PathPriorityType;
import com.autonavi.gbl.common.path.model.PathShadowPoint;
import com.autonavi.gbl.common.path.model.PathType;
import com.autonavi.gbl.common.path.model.RestAreaInfo;
import com.autonavi.gbl.common.path.model.RestTollGateInfo;
import com.autonavi.gbl.common.path.model.RestrictionInfo;
import com.autonavi.gbl.common.path.model.RoadExtraSceneInfo;
import com.autonavi.gbl.common.path.model.RouteForbidden;
import com.autonavi.gbl.common.path.model.TipInfo;
import com.autonavi.gbl.common.path.model.TrafficIncident;
import com.autonavi.gbl.common.path.model.TrafficJamInfo;
import com.autonavi.gbl.common.path.model.ViaPointAggregateInfo;
import com.autonavi.gbl.common.path.model.ViaPointInfo;
import com.autonavi.gbl.common.path.model.ViaRoadInfo;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.RouteType;
import java.util.ArrayList;
@IntfAuto(target = PathInfo.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class PathInfoImpl {
    private static BindTable BIND_TABLE = new BindTable(PathInfoImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void buildRarefyPointNative(long j, PathInfoImpl pathInfoImpl, long j2, long j3, long j4, Coord2DDouble coord2DDouble, long j5, long j6, ArrayList<Coord2DDouble> arrayList);

    private static native void clearPlayPointNative(long j, PathInfoImpl pathInfoImpl);

    private static native long createNativeObj();

    private static native long createNativeObj1(long j, PathInfoImpl pathInfoImpl);

    private static native void destroyNativeObj(long j);

    private static native short getAbnormalSectionCountNative(long j, PathInfoImpl pathInfoImpl);

    private static native AbnormalSection getAbnormalSectionNative(long j, PathInfoImpl pathInfoImpl, short s);

    private static native byte getAbnormalStateNative(long j, PathInfoImpl pathInfoImpl);

    private static native boolean getAll3DCamerasNative(long j, PathInfoImpl pathInfoImpl, ArrayList<PathCamera3d> arrayList);

    private static native boolean getAll3DTrafficLightsNative(long j, PathInfoImpl pathInfoImpl, ArrayList<Coord3DDouble> arrayList);

    private static native boolean getAllCamerasNative(long j, PathInfoImpl pathInfoImpl, ArrayList<PathCamera> arrayList);

    private static native boolean getAllTrafficLightsNative(long j, PathInfoImpl pathInfoImpl, ArrayList<Coord2DDouble> arrayList);

    private static native void getAlongRoadIDNative(long j, PathInfoImpl pathInfoImpl, long j2, long j3, ArrayList<Long> arrayList);

    private static native long getAvoidLimitReasonCountNative(long j, PathInfoImpl pathInfoImpl);

    private static native AvoidLimitReason getAvoidLimitReasonNative(long j, PathInfoImpl pathInfoImpl, short s);

    private static native short getAvoidTrafficJamCountNative(long j, PathInfoImpl pathInfoImpl);

    private static native AvoidTrafficJamInfo getAvoidTrafficJamNative(long j, PathInfoImpl pathInfoImpl, short s);

    private static native boolean getBoundNative(long j, PathInfoImpl pathInfoImpl, long j2, long j3, long j4, long j5, RectDouble rectDouble);

    private static native boolean getChargeStationInfoNative(long j, PathInfoImpl pathInfoImpl, ArrayList<ChargeStationInfo> arrayList);

    private static native boolean getCityAdcodeListNative(long j, PathInfoImpl pathInfoImpl, ArrayList<Long> arrayList);

    private static native boolean getClosestPointNative(long j, PathInfoImpl pathInfoImpl, long j2, Coord2DDouble coord2DDouble, long j3, Coord2DDouble coord2DDouble2);

    private static native void getCloudShowInfoNative(long j, PathInfoImpl pathInfoImpl, ArrayList<CloudShowInfo> arrayList);

    private static native long getDataVersionNative(long j, PathInfoImpl pathInfoImpl);

    private static native long getDifferentPointsNative(long j, PathInfoImpl pathInfoImpl, ArrayList<DifferentPoint> arrayList);

    private static native long getDifferentSectionsNative(long j, PathInfoImpl pathInfoImpl, ArrayList<DifferentSection> arrayList);

    private static native long getETASavedTimeNative(long j, PathInfoImpl pathInfoImpl);

    private static native ElecPathInfo getElecPathInfoNative(long j, PathInfoImpl pathInfoImpl);

    private static native boolean getElecPathKeyPointNative(long j, PathInfoImpl pathInfoImpl, long j2, ElecKeyPointConfig elecKeyPointConfig, long j3, Coord2DInt32 coord2DInt32);

    private static native short getEndDirectionNative(long j, PathInfoImpl pathInfoImpl);

    private static native POIInfo getEndPoiNative(long j, PathInfoImpl pathInfoImpl);

    private static native short getForbiddenInfoCountNative(long j, PathInfoImpl pathInfoImpl);

    private static native RouteForbidden getForbiddenInfoNative(long j, PathInfoImpl pathInfoImpl, short s);

    private static native boolean getGrayPointIndexNative(long j, PathInfoImpl pathInfoImpl, long j2, PathShadowPoint pathShadowPoint, long j3, PathGrayInfo pathGrayInfo);

    private static native long getGroupSegmentCountNative(long j, PathInfoImpl pathInfoImpl);

    private static native GroupSegment getGroupSegmentNative(long j, PathInfoImpl pathInfoImpl, long j2);

    private static native void getJamSegmentNative(long j, PathInfoImpl pathInfoImpl, ArrayList<JamSegment> arrayList);

    private static native short getLabelInfoCountNative(long j, PathInfoImpl pathInfoImpl);

    private static native LabelInfo getLabelInfoNative(long j, PathInfoImpl pathInfoImpl, short s);

    private static native long getLengthNative(long j, PathInfoImpl pathInfoImpl);

    private static native boolean getLightBarItemsNative(long j, PathInfoImpl pathInfoImpl, ArrayList<LightBarItem> arrayList);

    private static native void getLineIconPointsNative(long j, PathInfoImpl pathInfoImpl, ArrayList<LineIconPoint> arrayList);

    private static native LineItem getLineItemNative(long j, PathInfoImpl pathInfoImpl, boolean z);

    private static native long getMainRouteRemainTollCostNative(long j, PathInfoImpl pathInfoImpl);

    private static native long getNativeTypeHandleNative(long j, PathInfoImpl pathInfoImpl);

    private static native String getNaviIDNative(long j, PathInfoImpl pathInfoImpl);

    private static native long getNormalPlanTimeNative(long j, PathInfoImpl pathInfoImpl);

    private static native boolean getODDPointsNative(long j, PathInfoImpl pathInfoImpl, long j2, ArrayList<Coord2DDouble> arrayList);

    private static native long getOddSegInfosNative(long j, PathInfoImpl pathInfoImpl, ArrayList<OddSegInfo> arrayList);

    private static native PathDescriptionInfo getPathDescriptionInfoNative(long j, PathInfoImpl pathInfoImpl);

    private static native long getPathIDNative(long j, PathInfoImpl pathInfoImpl);

    private static native long getPathIndexNative(long j, PathInfoImpl pathInfoImpl);

    private static native void getPathViaPointInfoNative(long j, PathInfoImpl pathInfoImpl, ArrayList<ViaPointAggregateInfo> arrayList);

    private static native void getPathViaRoadInfoNative(long j, PathInfoImpl pathInfoImpl, ArrayList<ViaRoadInfo> arrayList);

    private static native long getPlayPointCountNative(long j, PathInfoImpl pathInfoImpl);

    private static native long getPreviousNaviPathIDNative(long j, PathInfoImpl pathInfoImpl);

    private static native int getPriorityNative(long j, PathInfoImpl pathInfoImpl);

    private static native long getRemainTollCostNative(long j, PathInfoImpl pathInfoImpl);

    private static native void getRestAreasNative(long j, PathInfoImpl pathInfoImpl, long j2, long j3, ArrayList<RestAreaInfo> arrayList);

    private static native void getRestTollGateNative(long j, PathInfoImpl pathInfoImpl, long j2, long j3, ArrayList<RestTollGateInfo> arrayList);

    private static native RestrictionInfo getRestrictionInfoNative(long j, PathInfoImpl pathInfoImpl);

    private static native short getReverseLabelInfoCountNative(long j, PathInfoImpl pathInfoImpl);

    private static native LabelInfo getReverseLabelInfoNative(long j, PathInfoImpl pathInfoImpl, short s);

    private static native void getRoadExtraSceneInfoNative(long j, PathInfoImpl pathInfoImpl, ArrayList<RoadExtraSceneInfo> arrayList);

    private static native short getRoadStatusFlagNative(long j, PathInfoImpl pathInfoImpl);

    private static native int getRouteTypeNative(long j, PathInfoImpl pathInfoImpl);

    private static native boolean getSegEndPointListNative(long j, PathInfoImpl pathInfoImpl, ArrayList<Coord2DInt32> arrayList);

    private static native long getSegmentCountNative(long j, PathInfoImpl pathInfoImpl);

    private static native boolean getSegmentInfoNative(long j, PathInfoImpl pathInfoImpl, long j2, long j3, SegmentInfoImpl segmentInfoImpl);

    private static native long getStaticTravelTimeNative(long j, PathInfoImpl pathInfoImpl);

    private static native long getStrategyNative(long j, PathInfoImpl pathInfoImpl);

    private static native TipInfo getTipNative(long j, PathInfoImpl pathInfoImpl);

    private static native int getTollCostNative(long j, PathInfoImpl pathInfoImpl);

    private static native short getTrafficIncidentCountNative(long j, PathInfoImpl pathInfoImpl, boolean z);

    private static native TrafficIncident getTrafficIncidentNative(long j, PathInfoImpl pathInfoImpl, short s, boolean z);

    private static native short getTrafficJamCountNative(long j, PathInfoImpl pathInfoImpl);

    private static native TrafficJamInfo getTrafficJamInfoNative(long j, PathInfoImpl pathInfoImpl, short s);

    private static native long getTrafficLightCountNative(long j, PathInfoImpl pathInfoImpl);

    private static native long getTravelTimeNative(long j, PathInfoImpl pathInfoImpl);

    private static native int getTypeNative(long j, PathInfoImpl pathInfoImpl);

    private static native boolean getViaPointInfoNative(long j, PathInfoImpl pathInfoImpl, ArrayList<ViaPointInfo> arrayList);

    private static native boolean hasBetterETAPathNative(long j, PathInfoImpl pathInfoImpl);

    private static native boolean isAvoidLimitRoadNative(long j, PathInfoImpl pathInfoImpl);

    private static native boolean isHolidayFreeNative(long j, PathInfoImpl pathInfoImpl);

    private static native boolean isNeedEncodePathDataNative(long j, PathInfoImpl pathInfoImpl, boolean z, boolean z2);

    private static native boolean isOnlineNative(long j, PathInfoImpl pathInfoImpl);

    private static native boolean isTruckPathNative(long j, PathInfoImpl pathInfoImpl);

    private static native boolean isValidNative(long j, PathInfoImpl pathInfoImpl);

    private static native void resetGrayPathInfoNative(long j, PathInfoImpl pathInfoImpl);

    private static native void setPriorityNative(long j, PathInfoImpl pathInfoImpl, int i);

    private static native boolean updateTmcBarNative(long j, PathInfoImpl pathInfoImpl, ArrayList<LightBarItem> arrayList);

    public PathInfoImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof PathInfoImpl) && getUID(this) == getUID((PathInfoImpl) obj);
    }

    private static long getUID(PathInfoImpl pathInfoImpl) {
        long cPtr = getCPtr(pathInfoImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(PathInfoImpl pathInfoImpl) {
        if (pathInfoImpl == null) {
            return 0L;
        }
        return pathInfoImpl.swigCPtr;
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

    public ArrayList<Coord2DDouble> getAllTrafficLights() {
        ArrayList<Coord2DDouble> arrayList = new ArrayList<>();
        if (getAllTrafficLights(arrayList)) {
            return arrayList;
        }
        return null;
    }

    public ArrayList<Coord3DDouble> getAll3DTrafficLights() {
        ArrayList<Coord3DDouble> arrayList = new ArrayList<>();
        if (getAll3DTrafficLights(arrayList)) {
            return arrayList;
        }
        return null;
    }

    public ArrayList<PathCamera> getAllCameras() {
        ArrayList<PathCamera> arrayList = new ArrayList<>();
        if (getAllCameras(arrayList)) {
            return arrayList;
        }
        return null;
    }

    public ArrayList<PathCamera3d> getAll3DCameras() {
        ArrayList<PathCamera3d> arrayList = new ArrayList<>();
        if (getAll3DCameras(arrayList)) {
            return arrayList;
        }
        return null;
    }

    public ArrayList<LightBarItem> getLightBarItems() {
        ArrayList<LightBarItem> arrayList = new ArrayList<>();
        if (getLightBarItems(arrayList)) {
            return arrayList;
        }
        return null;
    }

    public SegmentInfoImpl getSegmentInfo(long j) {
        SegmentInfoImpl segmentInfoImpl = new SegmentInfoImpl();
        if (getSegmentInfo(j, segmentInfoImpl)) {
            return segmentInfoImpl;
        }
        return null;
    }

    public ArrayList<JamSegment> getJamSegment() {
        ArrayList<JamSegment> arrayList = new ArrayList<>();
        getJamSegment(arrayList);
        return arrayList;
    }

    public ArrayList<LineIconPoint> getLineIconPoints() {
        ArrayList<LineIconPoint> arrayList = new ArrayList<>();
        getLineIconPoints(arrayList);
        return arrayList;
    }

    public ArrayList<Long> getAlongRoadID(long j, long j2) {
        ArrayList<Long> arrayList = new ArrayList<>();
        getAlongRoadID(j, j2, arrayList);
        return arrayList;
    }

    public ArrayList<Coord2DDouble> buildRarefyPoint(long j, long j2, Coord2DDouble coord2DDouble, long j3, long j4) {
        ArrayList<Coord2DDouble> arrayList = new ArrayList<>();
        buildRarefyPoint(j, j2, coord2DDouble, j3, j4, arrayList);
        return arrayList;
    }

    public Coord2DDouble getClosestPoint(Coord2DDouble coord2DDouble) {
        Coord2DDouble coord2DDouble2 = new Coord2DDouble();
        if (getClosestPoint(coord2DDouble, coord2DDouble2)) {
            return coord2DDouble2;
        }
        return null;
    }

    public RectDouble getBound(long j, long j2, long j3) {
        RectDouble rectDouble = new RectDouble();
        if (getBound(j, j2, j3, rectDouble)) {
            return rectDouble;
        }
        return null;
    }

    public ArrayList<RestAreaInfo> getRestAreas(long j, long j2) {
        ArrayList<RestAreaInfo> arrayList = new ArrayList<>();
        getRestAreas(j, j2, arrayList);
        return arrayList;
    }

    public ArrayList<RestTollGateInfo> getRestTollGate(long j, long j2) {
        ArrayList<RestTollGateInfo> arrayList = new ArrayList<>();
        getRestTollGate(j, j2, arrayList);
        return arrayList;
    }

    public ArrayList<Coord2DInt32> getSegEndPointList() {
        ArrayList<Coord2DInt32> arrayList = new ArrayList<>();
        if (getSegEndPointList(arrayList)) {
            return arrayList;
        }
        return null;
    }

    public ArrayList<Long> getCityAdcodeList() {
        ArrayList<Long> arrayList = new ArrayList<>();
        if (getCityAdcodeList(arrayList)) {
            return arrayList;
        }
        return null;
    }

    public PathGrayInfo getGrayPointIndex(PathShadowPoint pathShadowPoint) {
        PathGrayInfo pathGrayInfo = new PathGrayInfo();
        if (getGrayPointIndex(pathShadowPoint, pathGrayInfo)) {
            return pathGrayInfo;
        }
        return null;
    }

    public ArrayList<ViaPointInfo> getViaPointInfo() {
        ArrayList<ViaPointInfo> arrayList = new ArrayList<>();
        if (getViaPointInfo(arrayList)) {
            return arrayList;
        }
        return null;
    }

    public ArrayList<ChargeStationInfo> getChargeStationInfo() {
        ArrayList<ChargeStationInfo> arrayList = new ArrayList<>();
        if (getChargeStationInfo(arrayList)) {
            return arrayList;
        }
        return null;
    }

    public ArrayList<RoadExtraSceneInfo> getRoadExtraSceneInfo() {
        ArrayList<RoadExtraSceneInfo> arrayList = new ArrayList<>();
        getRoadExtraSceneInfo(arrayList);
        return arrayList;
    }

    public Coord2DInt32 getElecPathKeyPoint(ElecKeyPointConfig elecKeyPointConfig) {
        Coord2DInt32 coord2DInt32 = new Coord2DInt32();
        if (getElecPathKeyPoint(elecKeyPointConfig, coord2DInt32)) {
            return coord2DInt32;
        }
        return null;
    }

    public ArrayList<ViaRoadInfo> getPathViaRoadInfo() {
        ArrayList<ViaRoadInfo> arrayList = new ArrayList<>();
        getPathViaRoadInfo(arrayList);
        return arrayList;
    }

    public ArrayList<ViaPointAggregateInfo> getPathViaPointInfo() {
        ArrayList<ViaPointAggregateInfo> arrayList = new ArrayList<>();
        getPathViaPointInfo(arrayList);
        return arrayList;
    }

    public ArrayList<CloudShowInfo> getCloudShowInfo() {
        ArrayList<CloudShowInfo> arrayList = new ArrayList<>();
        getCloudShowInfo(arrayList);
        return arrayList;
    }

    public ArrayList<Coord2DDouble> getODDPoints(long j) {
        ArrayList<Coord2DDouble> arrayList = new ArrayList<>();
        if (getODDPoints(j, arrayList)) {
            return arrayList;
        }
        return null;
    }

    public ArrayList<OddSegInfo> getOddSegInfos() {
        ArrayList<OddSegInfo> arrayList = new ArrayList<>();
        getOddSegInfos(arrayList);
        return arrayList;
    }

    public ArrayList<DifferentPoint> getDifferentPoints() {
        ArrayList<DifferentPoint> arrayList = new ArrayList<>();
        getDifferentPoints(arrayList);
        return arrayList;
    }

    public ArrayList<DifferentSection> getDifferentSections() {
        ArrayList<DifferentSection> arrayList = new ArrayList<>();
        getDifferentSections(arrayList);
        return arrayList;
    }

    public PathInfoImpl() {
        this(createNativeObj(), true);
    }

    public PathInfoImpl(PathInfoImpl pathInfoImpl) {
        this(createNativeObj1(getCPtr(pathInfoImpl), pathInfoImpl), true);
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

    private boolean getAllTrafficLights(ArrayList<Coord2DDouble> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAllTrafficLightsNative(j, this, arrayList);
    }

    private boolean getAll3DTrafficLights(ArrayList<Coord3DDouble> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAll3DTrafficLightsNative(j, this, arrayList);
    }

    private boolean getAllCameras(ArrayList<PathCamera> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAllCamerasNative(j, this, arrayList);
    }

    private boolean getAll3DCameras(ArrayList<PathCamera3d> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAll3DCamerasNative(j, this, arrayList);
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

    private boolean getSegmentInfo(long j, SegmentInfoImpl segmentInfoImpl) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return getSegmentInfoNative(j2, this, j, SegmentInfoImpl.getCPtr(segmentInfoImpl), segmentInfoImpl);
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

    public long getPlayPointCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPlayPointCountNative(j, this);
    }

    public void clearPlayPoint() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearPlayPointNative(j, this);
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

    private long getDifferentPoints(ArrayList<DifferentPoint> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDifferentPointsNative(j, this, arrayList);
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

    private void getLineIconPoints(ArrayList<LineIconPoint> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getLineIconPointsNative(j, this, arrayList);
    }

    private void getAlongRoadID(long j, long j2, ArrayList<Long> arrayList) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        getAlongRoadIDNative(j3, this, j, j2, arrayList);
    }

    private void buildRarefyPoint(long j, long j2, Coord2DDouble coord2DDouble, long j3, long j4, ArrayList<Coord2DDouble> arrayList) {
        long j5 = this.swigCPtr;
        if (j5 == 0) {
            throw new NullPointerException();
        }
        buildRarefyPointNative(j5, this, j, j2, 0L, coord2DDouble, j3, j4, arrayList);
    }

    private boolean getClosestPoint(Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getClosestPointNative(j, this, 0L, coord2DDouble, 0L, coord2DDouble2);
    }

    private boolean getBound(long j, long j2, long j3, RectDouble rectDouble) {
        long j4 = this.swigCPtr;
        if (j4 == 0) {
            throw new NullPointerException();
        }
        return getBoundNative(j4, this, j, j2, j3, 0L, rectDouble);
    }

    private void getRestAreas(long j, long j2, ArrayList<RestAreaInfo> arrayList) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        getRestAreasNative(j3, this, j, j2, arrayList);
    }

    private void getRestTollGate(long j, long j2, ArrayList<RestTollGateInfo> arrayList) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        getRestTollGateNative(j3, this, j, j2, arrayList);
    }

    private boolean getSegEndPointList(ArrayList<Coord2DInt32> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getSegEndPointListNative(j, this, arrayList);
    }

    private boolean getCityAdcodeList(ArrayList<Long> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCityAdcodeListNative(j, this, arrayList);
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

    private boolean getViaPointInfo(ArrayList<ViaPointInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getViaPointInfoNative(j, this, arrayList);
    }

    private boolean getChargeStationInfo(ArrayList<ChargeStationInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getChargeStationInfoNative(j, this, arrayList);
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

    private boolean getElecPathKeyPoint(ElecKeyPointConfig elecKeyPointConfig, Coord2DInt32 coord2DInt32) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getElecPathKeyPointNative(j, this, 0L, elecKeyPointConfig, 0L, coord2DInt32);
    }

    private void getPathViaRoadInfo(ArrayList<ViaRoadInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getPathViaRoadInfoNative(j, this, arrayList);
    }

    private void getPathViaPointInfo(ArrayList<ViaPointAggregateInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getPathViaPointInfoNative(j, this, arrayList);
    }

    private void getCloudShowInfo(ArrayList<CloudShowInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getCloudShowInfoNative(j, this, arrayList);
    }

    private long getOddSegInfos(ArrayList<OddSegInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getOddSegInfosNative(j, this, arrayList);
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

    public long getNativeTypeHandle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getNativeTypeHandleNative(j, this);
    }
}
