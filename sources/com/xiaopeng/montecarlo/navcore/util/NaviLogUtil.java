package com.xiaopeng.montecarlo.navcore.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.common.tool.FDManager;
import com.autonavi.gbl.aosclient.model.CEtaRequestReponseParam;
import com.autonavi.gbl.aosclient.model.GNavigationEtaqueryAckRouteList;
import com.autonavi.gbl.aosclient.model.GNavigationEtaqueryAckRouteListPath;
import com.autonavi.gbl.aosclient.model.GNavigationEtaqueryResponseParam;
import com.autonavi.gbl.aosclient.model.GTrafficEventDetailResponseParam;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.path.model.AvoidJamArea;
import com.autonavi.gbl.common.path.model.AvoidRestrictArea;
import com.autonavi.gbl.common.path.model.ForbiddenInfo;
import com.autonavi.gbl.common.path.model.POIInfo;
import com.autonavi.gbl.common.path.model.RoadClosedArea;
import com.autonavi.gbl.common.path.option.POIForRequest;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.xiaopeng.montecarlo.navcore.bean.favorite.DataTransform;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountSettingInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.DataOperation;
import com.xiaopeng.montecarlo.navcore.location.DRServiceManager;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPBaseLinkAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPBaseSegmentAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPDrivePathAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfoPanel;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPSoundInfo;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.logcat.LogHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class NaviLogUtil {
    private static final L.Tag TAG = new L.Tag("NaviLogUtil");

    public static String dumpRerouteOption(@Nullable RouteOption routeOption) {
        if (routeOption == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("device: " + NavCoreUtil.getDiu());
        sb.append(" ConstrainCode:" + routeOption.getConstrainCode());
        int routeType = routeOption.getRouteType();
        sb.append(" RerouteType:" + routeType + FDManager.LINE_SEPERATOR);
        POIForRequest pOIForRequest = routeOption.getPOIForRequest();
        long j = 0;
        long j2 = 0L;
        while (j2 < pOIForRequest.getPointSize(0)) {
            POIInfo point = pOIForRequest.getPoint(0, j2);
            if (2 == routeType && j2 == j) {
                DRServiceManager.getInstance().reportYaw(point.realPos.lat, point.realPos.lon);
            }
            sb.append("PointTypeStart:" + j2 + " " + dumpBLPOIInfo(point) + FDManager.LINE_SEPERATOR);
            j2++;
            j = 0;
        }
        for (long j3 = 0; j3 < pOIForRequest.getPointSize(2); j3++) {
            POIInfo point2 = pOIForRequest.getPoint(2, j3);
            sb.append("PointTypeEnd:" + j3 + " " + dumpBLPOIInfo(point2) + FDManager.LINE_SEPERATOR);
        }
        for (long j4 = 0; j4 < pOIForRequest.getPointSize(1); j4++) {
            POIInfo point3 = pOIForRequest.getPoint(1, j4);
            sb.append("PointTypeVia:" + j4 + " " + dumpBLPOIInfo(point3) + FDManager.LINE_SEPERATOR);
        }
        sb.append("carDir:" + pOIForRequest.getDirection());
        return sb.toString();
    }

    public static final String dumpBLPOIInfo(POIInfo pOIInfo) {
        if (pOIInfo == null) {
            return "poiInfo=null";
        }
        StringBuilder sb = new StringBuilder();
        Coord2DDouble coord2DDouble = pOIInfo.realPos;
        if (coord2DDouble != null) {
            sb.append(" lon:" + coord2DDouble.lon);
            sb.append(" lat:" + coord2DDouble.lat);
        } else {
            sb.append(" lon:0.0");
            sb.append(" lat:0.0");
        }
        Coord2DDouble coord2DDouble2 = pOIInfo.naviPos;
        if (coord2DDouble2 != null) {
            sb.append(" naviLon:" + coord2DDouble2.lon);
            sb.append(" naviLat:" + coord2DDouble2.lat);
        } else {
            sb.append(" naviLon:0.0");
            sb.append(" naviLat:0.0");
        }
        sb.append(" sigshelter:" + pOIInfo.sigshelter);
        sb.append(" type:" + pOIInfo.type);
        sb.append(" roadId:" + pOIInfo.roadID);
        sb.append(" poiID:" + pOIInfo.poiID);
        sb.append(" name:" + pOIInfo.name);
        sb.append(" floorName:" + pOIInfo.floorName);
        sb.append(" parentName:" + pOIInfo.parentName);
        sb.append(" angle:" + pOIInfo.angel);
        sb.append(" parentID:" + pOIInfo.parentID);
        sb.append(" parentRel:" + pOIInfo.parentRel);
        sb.append(" typeCode:" + pOIInfo.typeCode);
        sb.append(" overhead:" + ((int) pOIInfo.overhead));
        return sb.toString();
    }

    public static final String dumpXPPOIInfo(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            return "poiInfo=null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" lon:" + xPPoiInfo.getDisplayLon());
        sb.append(" lat:" + xPPoiInfo.getDisplayLat());
        sb.append(" naviLon:" + xPPoiInfo.getNaviLon());
        sb.append(" naviLat:" + xPPoiInfo.getNaviLat());
        sb.append(" exitLon:" + xPPoiInfo.getNaviPoint(true).mLon);
        sb.append(" exitLat:" + xPPoiInfo.getNaviPoint(true).mLat);
        sb.append(" enterLon:" + xPPoiInfo.getNaviPoint(false).mLon);
        sb.append(" enterLat:" + xPPoiInfo.getNaviPoint(false).mLat);
        sb.append(" angle:" + xPPoiInfo.getAngel());
        sb.append(" sigshelter:" + xPPoiInfo.getSigshelter());
        sb.append(" type:" + Integer.toString(xPPoiInfo.getType()));
        sb.append(" roadId:" + xPPoiInfo.getRoadId());
        sb.append(" poiID:" + xPPoiInfo.getPoiId());
        sb.append(" name:" + xPPoiInfo.getName());
        sb.append(" address:" + xPPoiInfo.getAddress());
        sb.append(" floorName:" + xPPoiInfo.getFloorName());
        sb.append(" parentName:" + xPPoiInfo.getParentName());
        sb.append(" parentID:" + xPPoiInfo.getParentID());
        sb.append(" parentRel:" + xPPoiInfo.getParentRel());
        sb.append(" overhead:" + ((int) xPPoiInfo.getOverhead()));
        sb.append(" typeCode:" + xPPoiInfo.getTypeCode());
        sb.append(" category:" + Integer.toString(xPPoiInfo.getCategory()));
        sb.append(" BLCategory:" + xPPoiInfo.getBlCategory());
        sb.append(" isInAOI : " + xPPoiInfo.isInAOI());
        return sb.toString();
    }

    public static final String dumpHistoryRecordInfo(HistoryRecordInfo historyRecordInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(dumpXPPOIInfo(historyRecordInfo.getXPPoiInfo()));
        sb.append(" viaPois:[");
        if (CollectionUtils.isNotEmpty(historyRecordInfo.getViaPois())) {
            for (XPPoiInfo xPPoiInfo : historyRecordInfo.getViaPois()) {
                sb.append(xPPoiInfo.getName());
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String dumpCurrentLinkPointsWhenReroute(@Nullable IVariantPath iVariantPath, int i, int i2, int i3) {
        XPDrivePathAccessor drivePathAccessor;
        StringBuilder sb = new StringBuilder();
        if (iVariantPath == null || (drivePathAccessor = iVariantPath.getDrivePathAccessor()) == null) {
            return "";
        }
        sb.append("path id: " + drivePathAccessor.getPathID());
        if (i >= 0) {
            long j = i;
            if (j <= drivePathAccessor.getSegmentCount() - 1) {
                sb.append(", current seg index: " + i);
                XPBaseSegmentAccessor segmentAccessor = drivePathAccessor.getSegmentAccessor(j);
                if (segmentAccessor != null) {
                    int i4 = 0;
                    if (i2 >= 0) {
                        long j2 = i2;
                        if (j2 <= segmentAccessor.getLinkCount() - 1) {
                            sb.append(", current link index: " + i2);
                            XPBaseLinkAccessor linkAccessor = segmentAccessor.getLinkAccessor(j2);
                            if (linkAccessor != null) {
                                ArrayList<Coord2DDouble> points = linkAccessor.getPoints();
                                if (CollectionUtils.isNotEmpty(points)) {
                                    for (Coord2DDouble coord2DDouble : points) {
                                        sb.append(", point ");
                                        sb.append(i4 + ": " + coord2DDouble.lon + ", " + coord2DDouble.lat);
                                        i4++;
                                    }
                                }
                                if (i3 < 0) {
                                    drivePathAccessor.recycle();
                                    return sb.toString();
                                }
                                sb.append(", current point index: " + i3);
                            }
                        }
                    }
                    ArrayList<Coord2DDouble> points2 = segmentAccessor.getPoints();
                    if (CollectionUtils.isNotEmpty(points2)) {
                        for (Coord2DDouble coord2DDouble2 : points2) {
                            sb.append(", point ");
                            sb.append(i4 + ": " + coord2DDouble2.lon + ", " + coord2DDouble2.lat);
                            i4++;
                            if (i4 > 5) {
                                break;
                            }
                        }
                    }
                    sb.append(", current link index is illegal");
                    drivePathAccessor.recycle();
                    return sb.toString();
                }
                drivePathAccessor.recycle();
                return sb.toString();
            }
        }
        sb.append(", current seg index is illegal");
        drivePathAccessor.recycle();
        return sb.toString();
    }

    public static String dumpTTS(XPSoundInfo xPSoundInfo) {
        StringBuilder sb = new StringBuilder();
        if (xPSoundInfo == null) {
            return "info = NULL";
        }
        sb.append("onPlayTTS:");
        sb.append(xPSoundInfo.mText);
        sb.append(" scT:");
        sb.append(xPSoundInfo.mSceneType);
        sb.append(", naviT:");
        sb.append(xPSoundInfo.mNaviType);
        sb.append(", soT:");
        sb.append(xPSoundInfo.mSoundType);
        sb.append(", ssT:");
        sb.append(xPSoundInfo.mSubSoundType);
        sb.append(", scT:");
        sb.append(xPSoundInfo.mSubCameraType);
        sb.append(", sS:");
        sb.append(xPSoundInfo.mSubCategory);
        sb.append(", csT:");
        sb.append(xPSoundInfo.mCruiseSoundType);
        return sb.toString();
    }

    public static String dumpNaviInfo(XPNaviInfo xPNaviInfo) {
        StringBuilder sb = new StringBuilder();
        if (xPNaviInfo == null) {
            return "";
        }
        sb.append("crossManeuverID:" + xPNaviInfo.mCrossManeuverID);
        sb.append(", curRouteName:" + xPNaviInfo.mCurRouteName);
        sb.append(", cityCode:" + xPNaviInfo.mCityCode);
        sb.append(", curLinkIdx:" + xPNaviInfo.mCurLinkIdx);
        sb.append(", curLinkSpeed:" + xPNaviInfo.mCurLinkSpeed);
        sb.append(", curPointIdx:" + xPNaviInfo.mCurPointIdx);
        sb.append(", curRoadClass:" + xPNaviInfo.mCurRoadClass);
        sb.append(", driveDist:" + xPNaviInfo.mDriveDist);
        sb.append(", driveTime:" + xPNaviInfo.mDriveTime);
        sb.append(", linkRemainDist:" + xPNaviInfo.mLinkRemainDist);
        sb.append(", routeRemainDist:" + xPNaviInfo.mRouteRemainDist);
        sb.append(", routeRemainLightCount:" + xPNaviInfo.mRouteRemainLightCount);
        sb.append(", routeRemainTime:" + xPNaviInfo.mRouteRemainTime);
        sb.append(FDManager.LINE_SEPERATOR);
        for (int i = 0; i < xPNaviInfo.mNaviInfoData.length; i++) {
            sb.append("NaviInfoPanel: " + i);
            XPNaviInfoPanel xPNaviInfoPanel = xPNaviInfo.mNaviInfoData[i];
            sb.append("， maneuverID: " + xPNaviInfoPanel.mManeuverID);
            sb.append("， nextRouteName: " + xPNaviInfoPanel.mNextRouteName);
            sb.append("， segmentRemainDist: " + xPNaviInfoPanel.mSegmentRemainDist);
            sb.append("， segmentRemainTime: " + xPNaviInfoPanel.mSegmentRemainTime);
            sb.append(FDManager.LINE_SEPERATOR);
        }
        for (int i2 = 0; xPNaviInfo.mNextCrossInfo != null && i2 < xPNaviInfo.mNextCrossInfo.length; i2++) {
            sb.append("CrossInfo: " + i2);
            XPCrossNaviInfo xPCrossNaviInfo = xPNaviInfo.mNextCrossInfo[i2];
            sb.append("， maneuverID: " + xPCrossNaviInfo.mManeuverID);
            sb.append("， nextRouteName: " + xPCrossNaviInfo.mNextRoadName);
            sb.append("， assistAction: " + xPCrossNaviInfo.mAssistAction);
            sb.append("， viaNum: " + ((int) xPCrossNaviInfo.mViaNum));
            sb.append("， curToSegmentDist: " + xPCrossNaviInfo.mCurToSegmentDist);
            sb.append("， curToSegmentTime: " + xPCrossNaviInfo.mCurToSegmentTime);
            sb.append(FDManager.LINE_SEPERATOR);
        }
        if (xPNaviInfo.mViaRemainDist != null && xPNaviInfo.mViaRemainDist.length > 0) {
            sb.append("ViaRemainDist: ");
            for (int i3 = 0; i3 < xPNaviInfo.mViaRemainDist.length; i3++) {
                sb.append(", { dis: ");
                sb.append(xPNaviInfo.mViaRemainDist[i3]);
                if (xPNaviInfo.mViaRemainTime != null && xPNaviInfo.mViaRemainTime.length > 0 && i3 < xPNaviInfo.mViaRemainTime.length) {
                    sb.append("， time: " + xPNaviInfo.mViaRemainTime[i3]);
                }
                sb.append(" }");
            }
        }
        return sb.toString();
    }

    public static void quickSwitchBLLog(boolean z) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_OPEN_BL_LOG, z);
        LogHelper.getInstance().initNaviLogFolder();
        ServiceMgr serviceMgrInstance = ServiceMgr.getServiceMgrInstance();
        UserLogControl userLogControl = UserLogControl.INSTANCE;
        serviceMgrInstance.switchLog(UserLogControl.getBLLogLevel());
    }

    public static void quickSwitchLoc(boolean z) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_OPEN_LOC_LOG, z);
        TBTManager.getInstance().setSignalRecordSwitch(z);
        SRNaviManager.getInstance().setSignalRecordSwitch(z);
    }

    public static void quickSwitchAllLog(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "quickSwitchAllLog:" + z);
        quickSwitchBLLog(z);
        LogHelper.getInstance().quickSwitchXPLog(z);
        quickSwitchLoc(z);
    }

    public static String getCEtaRequestReponseParamString(CEtaRequestReponseParam cEtaRequestReponseParam) {
        return "CEtaRequestReponseParam: result: " + cEtaRequestReponseParam.result + ", distance: " + cEtaRequestReponseParam.distance + ", travel_time:" + cEtaRequestReponseParam.travel_time + ", status:" + cEtaRequestReponseParam.status + ", mNetErrorCode: " + cEtaRequestReponseParam.mNetErrorCode + ", message: " + cEtaRequestReponseParam.message + ", timestamp: " + cEtaRequestReponseParam.timestamp + ", version: " + cEtaRequestReponseParam.version + ", code: " + cEtaRequestReponseParam.code;
    }

    public static String getGNavigationEtaqueryResponseParamString(GNavigationEtaqueryResponseParam gNavigationEtaqueryResponseParam) {
        StringBuilder sb = new StringBuilder("GNavigationEtaqueryResponseParam: ");
        sb.append("code: ");
        sb.append(gNavigationEtaqueryResponseParam.code);
        sb.append(", message: ");
        sb.append(gNavigationEtaqueryResponseParam.message);
        sb.append(", result: ");
        sb.append(gNavigationEtaqueryResponseParam.result);
        sb.append(", mNetErrorCode: ");
        sb.append(gNavigationEtaqueryResponseParam.mNetErrorCode);
        sb.append(", {");
        Iterator<GNavigationEtaqueryAckRouteList> it = gNavigationEtaqueryResponseParam.route_list.iterator();
        while (it.hasNext()) {
            GNavigationEtaqueryAckRouteList next = it.next();
            sb.append(" route status: ");
            sb.append(next.status);
            sb.append(", start_idx: ");
            sb.append(next.start_idx);
            sb.append(", end_idx:");
            sb.append(next.end_idx);
            sb.append(", {");
            Iterator<GNavigationEtaqueryAckRouteListPath> it2 = next.path.iterator();
            while (it2.hasNext()) {
                GNavigationEtaqueryAckRouteListPath next2 = it2.next();
                sb.append(" {");
                sb.append(" [ ");
                sb.append("distance: ");
                sb.append(next2.distance);
                sb.append("]");
                sb.append(", [travel_time: ");
                sb.append(next2.travel_time);
                sb.append("]");
                sb.append(" }, ");
            }
            sb.append(" }, ");
        }
        sb.append(" } ");
        return sb.toString();
    }

    public static String getTrafficParamString(GTrafficEventDetailResponseParam gTrafficEventDetailResponseParam) {
        if (gTrafficEventDetailResponseParam == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("traffic event { ");
        sb.append("result: ");
        sb.append(gTrafficEventDetailResponseParam.result);
        sb.append(", mNetErrorCode: ");
        sb.append(gTrafficEventDetailResponseParam.mNetErrorCode);
        sb.append(", code: ");
        sb.append(gTrafficEventDetailResponseParam.code);
        if (gTrafficEventDetailResponseParam.EventData != null) {
            sb.append(", layertag: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.layertag);
            sb.append(", layer: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.layer);
            sb.append(", title: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.title);
            sb.append(", eventname: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.eventname);
            sb.append(", address: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.address);
            sb.append(", head: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.head);
            sb.append(", desc: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.desc);
            sb.append(", infostartdate: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.infostartdate);
            sb.append(", infoenddate: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.infoenddate);
            sb.append(", infotimeseg: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.infotimeseg);
            sb.append(", lastupdate: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.lastupdate);
            sb.append(", expirytime: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.expirytime);
            sb.append(", nick: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.nick);
            sb.append(", source: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.source);
            sb.append(", official: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.official);
            sb.append(", picurl: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.picurl);
            sb.append(", socol_picture: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.socol_picture != null ? gTrafficEventDetailResponseParam.EventData.socol_picture.socol_picture : "");
            sb.append(", lane: ");
            sb.append(gTrafficEventDetailResponseParam.EventData.lane);
            sb.append(" }");
        } else {
            sb.append(" }");
        }
        return sb.toString();
    }

    public static String getNavExternalDataString(Object obj) {
        if (obj == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (obj instanceof AvoidJamArea) {
            AvoidJamArea avoidJamArea = (AvoidJamArea) obj;
            sb.append("AvoidJamArea >>> ");
            sb.append("pos: ");
            if (avoidJamArea.pos2D == null && avoidJamArea.pos3D == null) {
                sb.append("null");
            } else if (avoidJamArea.pos2D != null) {
                sb.append(avoidJamArea.pos2D.lat);
                sb.append(",");
                sb.append(avoidJamArea.pos2D.lon);
            } else {
                sb.append(avoidJamArea.pos3D.lat);
                sb.append(",");
                sb.append(avoidJamArea.pos3D.lon);
            }
            sb.append(", distance: ");
            sb.append(avoidJamArea.distance);
            sb.append(", eventType: ");
            sb.append(avoidJamArea.eventType);
            sb.append(", roadName: ");
            sb.append(avoidJamArea.roadName);
            sb.append(", saveTime: ");
            sb.append(avoidJamArea.saveTime);
            sb.append(", state: ");
            sb.append((int) avoidJamArea.state);
        } else if (obj instanceof ForbiddenInfo) {
            ForbiddenInfo forbiddenInfo = (ForbiddenInfo) obj;
            sb.append(", ForbiddenInfo >>> ");
            sb.append("pos: ");
            if (forbiddenInfo.pos2D == null && forbiddenInfo.pos3D == null) {
                sb.append("null");
            } else if (forbiddenInfo.pos2D != null) {
                sb.append(forbiddenInfo.pos2D.lat);
                sb.append(",");
                sb.append(forbiddenInfo.pos2D.lon);
            } else {
                sb.append(forbiddenInfo.pos3D.lat);
                sb.append(",");
                sb.append(forbiddenInfo.pos3D.lon);
            }
            sb.append(", distance: ");
            sb.append(forbiddenInfo.distance);
            sb.append(", action: ");
            sb.append((int) forbiddenInfo.action);
            sb.append(", roadName: ");
            sb.append(forbiddenInfo.roadName);
            sb.append(", starTime: ");
            sb.append(forbiddenInfo.starTime);
            sb.append(", endTime: ");
            sb.append(forbiddenInfo.endTime);
            sb.append(", id: ");
            sb.append(forbiddenInfo.id);
        } else if (obj instanceof RoadClosedArea) {
            RoadClosedArea roadClosedArea = (RoadClosedArea) obj;
            sb.append("RoadClosedArea >>> ");
            sb.append("pos: ");
            if (roadClosedArea.pos2D == null && roadClosedArea.pos3D == null) {
                sb.append("null");
            } else if (roadClosedArea.pos2D != null) {
                sb.append(roadClosedArea.pos2D.lat);
                sb.append(",");
                sb.append(roadClosedArea.pos2D.lon);
            } else {
                sb.append(roadClosedArea.pos3D.lat);
                sb.append(",");
                sb.append(roadClosedArea.pos3D.lon);
            }
            sb.append(", distance: ");
            sb.append(roadClosedArea.distance);
            sb.append(", desc: ");
            sb.append(roadClosedArea.desc);
            sb.append(", title: ");
            sb.append(roadClosedArea.title);
            sb.append(", startTime: ");
            sb.append(roadClosedArea.startTime);
            sb.append(", endTime: ");
            sb.append(roadClosedArea.endTime);
            sb.append(", eventType: ");
            sb.append(roadClosedArea.eventType);
        } else if (obj instanceof AvoidRestrictArea) {
            AvoidRestrictArea avoidRestrictArea = (AvoidRestrictArea) obj;
            sb.append("RoadClosedArea >>> ");
            sb.append("pos: ");
            if (avoidRestrictArea.pos2D == null && avoidRestrictArea.pos3D == null) {
                sb.append("null");
            } else if (avoidRestrictArea.pos2D != null) {
                sb.append(avoidRestrictArea.pos2D.lat);
                sb.append(",");
                sb.append(avoidRestrictArea.pos2D.lon);
            } else {
                sb.append(avoidRestrictArea.pos3D.lat);
                sb.append(",");
                sb.append(avoidRestrictArea.pos3D.lon);
            }
            sb.append(", distance: ");
            sb.append(avoidRestrictArea.distance);
            sb.append(", policyName: ");
            sb.append(avoidRestrictArea.policyName);
            sb.append(", priority: ");
            sb.append((int) avoidRestrictArea.priority);
            sb.append(", roadName: ");
            sb.append(avoidRestrictArea.roadName);
            sb.append(", type: ");
            sb.append((int) avoidRestrictArea.type);
        } else {
            sb.append(" unexpected type: " + obj);
        }
        return sb.toString();
    }

    public static final String dumpAccountSetInfo(AccountSettingInfo accountSettingInfo) {
        if (accountSettingInfo == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("AccountSettingInfo: ");
        sb.append("name: " + accountSettingInfo.getName());
        sb.append(", value: " + accountSettingInfo.getValue());
        return sb.toString();
    }

    public static final String dumpDataOperation(@NonNull DataOperation dataOperation) {
        StringBuilder sb = new StringBuilder();
        sb.append("DataOperation: ");
        sb.append("dataId: " + dataOperation.getDataId());
        sb.append(", dataType: " + dataOperation.getDataType());
        sb.append(", createTime: " + dataOperation.getCreateTime());
        sb.append(", updateTime: " + dataOperation.getUpdateTime());
        sb.append(", operationType: " + dataOperation.getOperationType());
        sb.append(", version: " + dataOperation.getVersion());
        sb.append(", preVersion: " + dataOperation.getPreVersion());
        sb.append(", dataContent: " + dataOperation.getDataContent());
        return sb.toString();
    }

    public static final String dumpDataTransform(@NonNull DataTransform dataTransform) {
        XPPoiInfo xPPoiInfo;
        if (dataTransform instanceof FavoriteAddress) {
            xPPoiInfo = ((FavoriteAddress) dataTransform).getXPPoiInfo();
        } else {
            xPPoiInfo = dataTransform instanceof HistoryRecordInfo ? ((HistoryRecordInfo) dataTransform).getXPPoiInfo() : null;
        }
        return dumpXPPOIInfo(xPPoiInfo);
    }

    public static int getBLLocLogType() {
        int i = CarServiceManager.getInstance().hasXpuForNgp() ? 5 : 1;
        L.Tag tag = TAG;
        L.i(tag, "bl loc type:" + i);
        return i;
    }
}
