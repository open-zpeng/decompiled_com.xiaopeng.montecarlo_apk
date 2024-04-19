package com.autonavi.gbl.common.path.option;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
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
import com.autonavi.gbl.common.path.model.PathIndoorParkingInfo;
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
import com.autonavi.gbl.common.path.option.RouteType;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import com.autonavi.gbl.common.path.option.impl.SegmentInfoImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = PathInfoImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class PathInfo {
    private static String PACKAGE = ReflexTool.PN(PathInfo.class);
    private PathInfoImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected PathInfo(long j, boolean z) {
        this(new PathInfoImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(PathInfo.class, this, this.mControl);
        }
    }

    public PathInfo() {
        this(new PathInfoImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(PathInfo.class, this, this.mControl);
        }
    }

    public PathInfo(PathInfo pathInfo) {
        this(new PathInfoImpl((PathInfoImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.common.path.option.PathInfo", pathInfo)));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(PathInfo.class, this, this.mControl);
        }
    }

    public PathInfo(PathInfoImpl pathInfoImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(pathInfoImpl);
    }

    private void $constructor(PathInfoImpl pathInfoImpl) {
        if (pathInfoImpl != null) {
            this.mControl = pathInfoImpl;
            this.mTargetId = String.format("PathInfo_%s_%d", String.valueOf(PathInfoImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected PathInfoImpl getControl() {
        return this.mControl;
    }

    public ArrayList<Coord2DDouble> getAllTrafficLights() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getAllTrafficLights();
        }
        return null;
    }

    public ArrayList<Coord3DDouble> getAll3DTrafficLights() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getAll3DTrafficLights();
        }
        return null;
    }

    public ArrayList<PathCamera> getAllCameras() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getAllCameras();
        }
        return null;
    }

    public ArrayList<PathCamera3d> getAll3DCameras() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getAll3DCameras();
        }
        return null;
    }

    public ArrayList<LightBarItem> getLightBarItems() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getLightBarItems();
        }
        return null;
    }

    public SegmentInfo getSegmentInfo(long j) {
        SegmentInfoImpl segmentInfo;
        try {
            Method method = PathInfo.class.getMethod("getSegmentInfo", Long.TYPE);
            PathInfoImpl pathInfoImpl = this.mControl;
            if (pathInfoImpl != null && (segmentInfo = pathInfoImpl.getSegmentInfo(j)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (SegmentInfo) typeHelper.transfer(method, -1, (Object) segmentInfo, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.option.PathInfo.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public ArrayList<JamSegment> getJamSegment() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getJamSegment();
        }
        return null;
    }

    public ArrayList<LineIconPoint> getLineIconPoints() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getLineIconPoints();
        }
        return null;
    }

    public ArrayList<Long> getAlongRoadID(long j, long j2) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getAlongRoadID(j, j2);
        }
        return null;
    }

    public ArrayList<Coord2DDouble> buildRarefyPoint(long j, long j2, Coord2DDouble coord2DDouble, long j3, long j4) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.buildRarefyPoint(j, j2, coord2DDouble, j3, j4);
        }
        return null;
    }

    public Coord2DDouble getClosestPoint(Coord2DDouble coord2DDouble) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getClosestPoint(coord2DDouble);
        }
        return null;
    }

    public RectDouble getBound(long j, long j2, long j3) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getBound(j, j2, j3);
        }
        return null;
    }

    public ArrayList<RestAreaInfo> getRestAreas(long j, long j2) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getRestAreas(j, j2);
        }
        return null;
    }

    public ArrayList<RestTollGateInfo> getRestTollGate(long j, long j2) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getRestTollGate(j, j2);
        }
        return null;
    }

    public ArrayList<Coord2DInt32> getSegEndPointList() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getSegEndPointList();
        }
        return null;
    }

    public ArrayList<Long> getCityAdcodeList() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getCityAdcodeList();
        }
        return null;
    }

    public PathGrayInfo getGrayPointIndex(PathShadowPoint pathShadowPoint) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getGrayPointIndex(pathShadowPoint);
        }
        return null;
    }

    public ArrayList<ViaPointInfo> getViaPointInfo() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getViaPointInfo();
        }
        return null;
    }

    public ArrayList<ChargeStationInfo> getChargeStationInfo() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getChargeStationInfo();
        }
        return null;
    }

    public ArrayList<RoadExtraSceneInfo> getRoadExtraSceneInfo() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getRoadExtraSceneInfo();
        }
        return null;
    }

    public Coord2DInt32 getElecPathKeyPoint(ElecKeyPointConfig elecKeyPointConfig) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getElecPathKeyPoint(elecKeyPointConfig);
        }
        return null;
    }

    public ArrayList<ViaRoadInfo> getPathViaRoadInfo() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getPathViaRoadInfo();
        }
        return null;
    }

    public ArrayList<ViaPointAggregateInfo> getPathViaPointInfo() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getPathViaPointInfo();
        }
        return null;
    }

    public ArrayList<CloudShowInfo> getCloudShowInfo() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getCloudShowInfo();
        }
        return null;
    }

    public ArrayList<Coord2DDouble> getODDPoints(long j) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getODDPoints(j);
        }
        return null;
    }

    public ArrayList<OddSegInfo> getOddSegInfos() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getOddSegInfos();
        }
        return null;
    }

    public ArrayList<DifferentPoint> getDifferentPoints() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getDifferentPoints();
        }
        return null;
    }

    public ArrayList<DifferentSection> getDifferentSections() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getDifferentSections();
        }
        return null;
    }

    public PathIndoorParkingInfo getIndoorParkingInfo() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getIndoorParkingInfo();
        }
        return null;
    }

    public String getPlanChannelId() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getPlanChannelId();
        }
        return null;
    }

    public String getOfflineReqCustomIdentityId() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getOfflineReqCustomIdentityId();
        }
        return null;
    }

    public boolean isValid() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.isValid();
        }
        return false;
    }

    public long getPathID() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getPathID();
        }
        return 0L;
    }

    @PathType.PathType1
    public int getType() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getType();
        }
        return Integer.MIN_VALUE;
    }

    public long getLength() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getLength();
        }
        return 0L;
    }

    public long getStrategy() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getStrategy();
        }
        return 0L;
    }

    public long getTravelTime() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getTravelTime();
        }
        return 0L;
    }

    public long getStaticTravelTime() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getStaticTravelTime();
        }
        return 0L;
    }

    public int getTollCost() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getTollCost();
        }
        return 0;
    }

    public long getTrafficLightCount() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getTrafficLightCount();
        }
        return 0L;
    }

    public String getNaviID() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getNaviID();
        }
        return null;
    }

    public boolean isOnline() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.isOnline();
        }
        return false;
    }

    public long getSegmentCount() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getSegmentCount();
        }
        return 0L;
    }

    public short getLabelInfoCount() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getLabelInfoCount();
        }
        return (short) 0;
    }

    public LabelInfo getLabelInfo(short s) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getLabelInfo(s);
        }
        return null;
    }

    public short getReverseLabelInfoCount() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getReverseLabelInfoCount();
        }
        return (short) 0;
    }

    public LabelInfo getReverseLabelInfo(short s) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getReverseLabelInfo(s);
        }
        return null;
    }

    public short getTrafficJamCount() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getTrafficJamCount();
        }
        return (short) 0;
    }

    public TrafficJamInfo getTrafficJamInfo(short s) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getTrafficJamInfo(s);
        }
        return null;
    }

    public long getGroupSegmentCount() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getGroupSegmentCount();
        }
        return 0L;
    }

    public GroupSegment getGroupSegment(long j) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getGroupSegment(j);
        }
        return null;
    }

    public short getTrafficIncidentCount(boolean z) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getTrafficIncidentCount(z);
        }
        return (short) 0;
    }

    public TrafficIncident getTrafficIncident(short s, boolean z) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getTrafficIncident(s, z);
        }
        return null;
    }

    public long getAvoidLimitReasonCount() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getAvoidLimitReasonCount();
        }
        return 0L;
    }

    public AvoidLimitReason getAvoidLimitReason(short s) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getAvoidLimitReason(s);
        }
        return null;
    }

    public short getAvoidTrafficJamCount() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getAvoidTrafficJamCount();
        }
        return (short) 0;
    }

    public AvoidTrafficJamInfo getAvoidTrafficJam(short s) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getAvoidTrafficJam(s);
        }
        return null;
    }

    public short getForbiddenInfoCount() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getForbiddenInfoCount();
        }
        return (short) 0;
    }

    public RouteForbidden getForbiddenInfo(short s) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getForbiddenInfo(s);
        }
        return null;
    }

    public byte getAbnormalState() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getAbnormalState();
        }
        return (byte) 0;
    }

    public short getAbnormalSectionCount() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getAbnormalSectionCount();
        }
        return (short) 0;
    }

    public AbnormalSection getAbnormalSection(short s) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getAbnormalSection(s);
        }
        return null;
    }

    public RestrictionInfo getRestrictionInfo() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getRestrictionInfo();
        }
        return null;
    }

    public POIInfo getEndPoi() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getEndPoi();
        }
        return null;
    }

    public TipInfo getTip() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getTip();
        }
        return null;
    }

    public short getEndDirection() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getEndDirection();
        }
        return (short) 0;
    }

    public boolean isHolidayFree() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.isHolidayFree();
        }
        return false;
    }

    public boolean hasBetterETAPath() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.hasBetterETAPath();
        }
        return false;
    }

    public boolean isAvoidLimitRoad() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.isAvoidLimitRoad();
        }
        return false;
    }

    public boolean isTruckPath() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.isTruckPath();
        }
        return false;
    }

    public boolean isNeedEncodePathData(boolean z, boolean z2) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.isNeedEncodePathData(z, z2);
        }
        return false;
    }

    public long getDataVersion() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getDataVersion();
        }
        return 0L;
    }

    public long getETASavedTime() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getETASavedTime();
        }
        return 0L;
    }

    public long getNormalPlanTime() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getNormalPlanTime();
        }
        return 0L;
    }

    public long getPreviousNaviPathID() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getPreviousNaviPathID();
        }
        return 0L;
    }

    public long getPlayPointCount() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getPlayPointCount();
        }
        return 0L;
    }

    public void clearPlayPoint() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            pathInfoImpl.clearPlayPoint();
        }
    }

    public void setPriority(@PathPriorityType.PathPriorityType1 int i) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            pathInfoImpl.setPriority(i);
        }
    }

    @PathPriorityType.PathPriorityType1
    public int getPriority() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getPriority();
        }
        return Integer.MIN_VALUE;
    }

    public long getPathIndex() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getPathIndex();
        }
        return 0L;
    }

    @RouteType.RouteType1
    public int getRouteType() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getRouteType();
        }
        return Integer.MIN_VALUE;
    }

    public LineItem getLineItem(boolean z) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getLineItem(z);
        }
        return null;
    }

    public boolean updateTmcBar(ArrayList<LightBarItem> arrayList) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.updateTmcBar(arrayList);
        }
        return false;
    }

    public void resetGrayPathInfo() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            pathInfoImpl.resetGrayPathInfo();
        }
    }

    public ElecPathInfo getElecPathInfo() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getElecPathInfo();
        }
        return null;
    }

    public PathDescriptionInfo getPathDescriptionInfo() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getPathDescriptionInfo();
        }
        return null;
    }

    public long getRemainTollCost() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getRemainTollCost();
        }
        return 0L;
    }

    public long getMainRouteRemainTollCost() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getMainRouteRemainTollCost();
        }
        return 0L;
    }

    public short getRoadStatusFlag() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getRoadStatusFlag();
        }
        return (short) 0;
    }

    public long getNativeTypeHandle() {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            return pathInfoImpl.getNativeTypeHandle();
        }
        return 0L;
    }

    public void setLineItemNaviToConsis(LineItem lineItem) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            pathInfoImpl.setLineItemNaviToConsis(lineItem);
        }
    }

    public void setTravelTime(long j) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            pathInfoImpl.setTravelTime(j);
        }
    }

    public void setPlanChannelId(String str) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            pathInfoImpl.setPlanChannelId(str);
        }
    }

    public void setOfflineReqCustomIdentityId(String str) {
        PathInfoImpl pathInfoImpl = this.mControl;
        if (pathInfoImpl != null) {
            pathInfoImpl.setOfflineReqCustomIdentityId(str);
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.option.PathInfo.2
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.option.PathInfo.3
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.option.PathInfo.4
        }));
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            ReflexTool.invokeDeclMethodSafe(this.mControl, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mControl = null;
        }
        unbind();
    }
}
