package com.xiaopeng.montecarlo.navcore.xptbt;

import android.text.TextUtils;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.LightBarItem;
import com.autonavi.gbl.common.path.model.OddSegInfo;
import com.autonavi.gbl.common.path.model.RestrictionInfo;
import com.autonavi.gbl.common.path.model.TollGateInfo;
import com.autonavi.gbl.common.path.model.TrafficItem;
import com.autonavi.gbl.guide.model.CrossImageInfo;
import com.autonavi.gbl.guide.model.CrossNaviInfo;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.guide.model.CruiseEventInfo;
import com.autonavi.gbl.guide.model.CruiseFacilityInfo;
import com.autonavi.gbl.guide.model.CruiseInfo;
import com.autonavi.gbl.guide.model.ExitDirectionInfo;
import com.autonavi.gbl.guide.model.LaneInfo;
import com.autonavi.gbl.guide.model.LightBarInfo;
import com.autonavi.gbl.guide.model.LinkLineStatus;
import com.autonavi.gbl.guide.model.ManeuverConfig;
import com.autonavi.gbl.guide.model.ManeuverIconResponseData;
import com.autonavi.gbl.guide.model.ManeuverInfo;
import com.autonavi.gbl.guide.model.NaviCameraExt;
import com.autonavi.gbl.guide.model.NaviCongestionDetailInfo;
import com.autonavi.gbl.guide.model.NaviCongestionInfo;
import com.autonavi.gbl.guide.model.NaviFacility;
import com.autonavi.gbl.guide.model.NaviInfo;
import com.autonavi.gbl.guide.model.NaviInfoPanel;
import com.autonavi.gbl.guide.model.NaviIntervalCameraDynamicInfo;
import com.autonavi.gbl.guide.model.NotAvoidInfo;
import com.autonavi.gbl.guide.model.PathTrafficEventInfo;
import com.autonavi.gbl.guide.model.RouteTrafficEventInfo;
import com.autonavi.gbl.guide.model.SoundInfo;
import com.autonavi.gbl.guide.model.TrafficEventInfo;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCameraInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCoord3DDouble;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCruiseCongestionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCruiseEventInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCruiseInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPExitDirectionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLightBarItem;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLinkLineStatus;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverConfig;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviCongestionDetailInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviCongestionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfoPanel;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNotAvoidInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPObtainInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPOddInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPPathTrafficEventInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPRestrictionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPRouteTrafficEventInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPSoundInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTollGateInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTrafficEventInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTrafficItem;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class BLDataModelUtil {
    BLDataModelUtil() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPLaneInfo toXPLaneInfo(LaneInfo laneInfo) {
        int size;
        int size2;
        if (laneInfo == null) {
            return null;
        }
        XPLaneInfo xPLaneInfo = new XPLaneInfo();
        if (laneInfo.backLane != null && (size2 = laneInfo.backLane.size()) > 0) {
            xPLaneInfo.mBackLane = new int[size2];
            for (int i = 0; i < size2; i++) {
                xPLaneInfo.mBackLane[i] = laneInfo.backLane.get(i).intValue();
            }
        }
        if (laneInfo.frontLane != null && (size = laneInfo.frontLane.size()) > 0) {
            xPLaneInfo.mFrontLane = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                xPLaneInfo.mFrontLane[i2] = laneInfo.frontLane.get(i2).intValue();
            }
        }
        if (laneInfo.point != null) {
            xPLaneInfo.mPoint = toXPCoord2DDouble(laneInfo.point);
        }
        return xPLaneInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPFacilityInfo toXPCruiseFacilityInfo(CruiseFacilityInfo cruiseFacilityInfo) {
        if (cruiseFacilityInfo == null) {
            return null;
        }
        XPFacilityInfo xPFacilityInfo = new XPFacilityInfo();
        xPFacilityInfo.mType = cruiseFacilityInfo.type;
        xPFacilityInfo.mRemainDist = cruiseFacilityInfo.distance;
        xPFacilityInfo.mLimitSpeed = cruiseFacilityInfo.limitSpeed;
        xPFacilityInfo.mPos = toXPCoord2DDouble(cruiseFacilityInfo.pos);
        return xPFacilityInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPCruiseInfo toXPCruiseInfo(CruiseInfo cruiseInfo) {
        if (cruiseInfo == null) {
            return null;
        }
        XPCruiseInfo xPCruiseInfo = new XPCruiseInfo();
        xPCruiseInfo.mRoadName = cruiseInfo.roadName;
        xPCruiseInfo.mRoadClass = cruiseInfo.roadClass;
        return xPCruiseInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPCruiseCongestionInfo toXPCruiseCongestionInfo(CruiseCongestionInfo cruiseCongestionInfo) {
        if (cruiseCongestionInfo == null) {
            return null;
        }
        XPCruiseCongestionInfo xPCruiseCongestionInfo = new XPCruiseCongestionInfo();
        xPCruiseCongestionInfo.mRoadName = cruiseCongestionInfo.roadName;
        xPCruiseCongestionInfo.mCongestionStatus = cruiseCongestionInfo.congestionStatus;
        xPCruiseCongestionInfo.mEtaTime = cruiseCongestionInfo.etaTime;
        xPCruiseCongestionInfo.mLength = cruiseCongestionInfo.length;
        if (cruiseCongestionInfo.vecLinkData != null) {
            xPCruiseCongestionInfo.mLinkData = new XPLinkLineStatus[cruiseCongestionInfo.vecLinkData.size()];
            for (int i = 0; i < cruiseCongestionInfo.vecLinkData.size(); i++) {
                xPCruiseCongestionInfo.mLinkData[i] = toXPLinkLineStatus(cruiseCongestionInfo.vecLinkData.get(i));
            }
        }
        return xPCruiseCongestionInfo;
    }

    protected static XPLinkLineStatus toXPLinkLineStatus(LinkLineStatus linkLineStatus) {
        if (linkLineStatus == null) {
            return null;
        }
        XPLinkLineStatus xPLinkLineStatus = new XPLinkLineStatus();
        xPLinkLineStatus.mStatus = linkLineStatus.status;
        ArrayList<Coord2DDouble> arrayList = linkLineStatus.shapePoints;
        if (arrayList != null) {
            xPLinkLineStatus.mShapePoints = new ArrayList();
            for (Coord2DDouble coord2DDouble : arrayList) {
                xPLinkLineStatus.mShapePoints.add(toXPCoord2DDouble(coord2DDouble));
            }
        }
        return xPLinkLineStatus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPNaviInfo toXPNaviInfo(NaviInfo naviInfo) {
        int size;
        int size2;
        int size3;
        int size4;
        if (naviInfo == null) {
            return null;
        }
        XPNaviInfo xPNaviInfo = new XPNaviInfo();
        xPNaviInfo.mPathID = naviInfo.pathID;
        xPNaviInfo.mType = naviInfo.type;
        xPNaviInfo.mRouteRemainDist = naviInfo.routeRemain.dist;
        xPNaviInfo.mRouteRemainTime = naviInfo.routeRemain.time;
        int i = 0;
        if (naviInfo.viaRemain != null && naviInfo.viaRemain.size() > 0 && (size4 = naviInfo.viaRemain.size()) > 0) {
            xPNaviInfo.mViaRemainDist = new int[size4];
            for (int i2 = 0; i2 < size4; i2++) {
                xPNaviInfo.mViaRemainDist[i2] = naviInfo.viaRemain.get(i2).dist;
            }
        }
        if (naviInfo.viaRemain != null && naviInfo.viaRemain.size() > 0 && (size3 = naviInfo.viaRemain.size()) > 0) {
            xPNaviInfo.mViaRemainTime = new int[size3];
            for (int i3 = 0; i3 < size3; i3++) {
                xPNaviInfo.mViaRemainTime[i3] = naviInfo.viaRemain.get(i3).time;
            }
        }
        xPNaviInfo.mRouteRemainLightCount = naviInfo.routeRemainLightCount;
        xPNaviInfo.mLinkRemainDist = naviInfo.linkRemainDist;
        xPNaviInfo.mCurSegIdx = naviInfo.curSegIdx;
        xPNaviInfo.mCurLinkIdx = naviInfo.curLinkIdx;
        xPNaviInfo.mCurPointIdx = naviInfo.curPointIdx;
        xPNaviInfo.mCurRoadClass = naviInfo.curRoadClass;
        xPNaviInfo.mCurRouteName = naviInfo.curRouteName;
        xPNaviInfo.mRingOutCnt = naviInfo.ringOutCnt;
        xPNaviInfo.mDriveTime = naviInfo.driveTime;
        xPNaviInfo.mDriveDist = naviInfo.driveDist;
        xPNaviInfo.mCityCode = naviInfo.cityCode;
        xPNaviInfo.mCurLinkSpeed = naviInfo.curLinkSpeed;
        xPNaviInfo.mNotAvoidInfo = toXPNotAvoidInfo(naviInfo.notAvoidInfo);
        xPNaviInfo.mCrossManeuverID = naviInfo.crossManeuverID;
        if (naviInfo.nextCrossInfo != null && (size2 = naviInfo.nextCrossInfo.size()) > 0) {
            xPNaviInfo.mNextCrossInfo = new XPCrossNaviInfo[size2];
            for (int i4 = 0; i4 < size2; i4++) {
                xPNaviInfo.mNextCrossInfo[i4] = toXPCrossNaviInfo(naviInfo.nextCrossInfo.get(i4));
            }
        }
        xPNaviInfo.mNaviInfoFlag = 0;
        if (naviInfo.NaviInfoData != null && (size = naviInfo.NaviInfoData.size()) > 0) {
            xPNaviInfo.mNaviInfoData = new XPNaviInfoPanel[size];
            for (int i5 = 0; i5 < size; i5++) {
                xPNaviInfo.mNaviInfoData[i5] = toXPNaviInfoPanel(naviInfo.NaviInfoData.get(i5));
            }
            if (naviInfo.NaviInfoFlag >= 0 && naviInfo.NaviInfoFlag < size) {
                i = naviInfo.NaviInfoFlag;
            }
            xPNaviInfo.mNaviInfoFlag = i;
        }
        return xPNaviInfo;
    }

    protected static XPNotAvoidInfo toXPNotAvoidInfo(NotAvoidInfo notAvoidInfo) {
        if (notAvoidInfo == null) {
            return null;
        }
        XPNotAvoidInfo xPNotAvoidInfo = new XPNotAvoidInfo();
        xPNotAvoidInfo.mType = notAvoidInfo.type;
        xPNotAvoidInfo.mDistToCar = notAvoidInfo.distToCar;
        xPNotAvoidInfo.mCoord2D = toXPCoord2DDouble(notAvoidInfo.coord2D);
        xPNotAvoidInfo.mCoord3D = toXPCoord3DDouble(notAvoidInfo.coord3D);
        xPNotAvoidInfo.mForbidType = notAvoidInfo.forbidType;
        xPNotAvoidInfo.mValid = notAvoidInfo.valid;
        return xPNotAvoidInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPCoordinate2DDouble toXPCoord2DDouble(Coord2DDouble coord2DDouble) {
        if (coord2DDouble == null) {
            return null;
        }
        XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble();
        xPCoordinate2DDouble.mLat = coord2DDouble.lat;
        xPCoordinate2DDouble.mLon = coord2DDouble.lon;
        return xPCoordinate2DDouble;
    }

    protected static XPCoord3DDouble toXPCoord3DDouble(Coord3DDouble coord3DDouble) {
        if (coord3DDouble == null) {
            return null;
        }
        XPCoord3DDouble xPCoord3DDouble = new XPCoord3DDouble();
        xPCoord3DDouble.mLat = coord3DDouble.lat;
        xPCoord3DDouble.mLon = coord3DDouble.lon;
        xPCoord3DDouble.mZ = coord3DDouble.z;
        return xPCoord3DDouble;
    }

    protected static XPCrossNaviInfo toXPCrossNaviInfo(CrossNaviInfo crossNaviInfo) {
        if (crossNaviInfo == null) {
            return null;
        }
        XPCrossNaviInfo xPCrossNaviInfo = new XPCrossNaviInfo();
        xPCrossNaviInfo.mPathID = crossNaviInfo.pathID;
        xPCrossNaviInfo.mSegIdx = crossNaviInfo.segIdx;
        xPCrossNaviInfo.mMainAction = crossNaviInfo.mainAction;
        xPCrossNaviInfo.mAssistAction = crossNaviInfo.assistAction;
        xPCrossNaviInfo.mManeuverID = crossNaviInfo.maneuverID;
        xPCrossNaviInfo.mCrossManeuverID = crossNaviInfo.crossManeuverID;
        xPCrossNaviInfo.mNextRoadName = crossNaviInfo.nextRoadName;
        xPCrossNaviInfo.mCurToSegmentDist = crossNaviInfo.curToSegmentDist;
        xPCrossNaviInfo.mCurToSegmentTime = crossNaviInfo.curToSegmentTime;
        xPCrossNaviInfo.mOutCnt = crossNaviInfo.outCnt;
        xPCrossNaviInfo.mViaNum = crossNaviInfo.viaNum;
        xPCrossNaviInfo.mDestDirection = crossNaviInfo.destDirection;
        xPCrossNaviInfo.mTunnelFlag = crossNaviInfo.tunnelFlag;
        xPCrossNaviInfo.mReversed = crossNaviInfo.reversed;
        xPCrossNaviInfo.mRev = crossNaviInfo.rev;
        return xPCrossNaviInfo;
    }

    protected static XPNaviInfoPanel toXPNaviInfoPanel(NaviInfoPanel naviInfoPanel) {
        if (naviInfoPanel == null) {
            return null;
        }
        XPNaviInfoPanel xPNaviInfoPanel = new XPNaviInfoPanel();
        xPNaviInfoPanel.mManeuverID = naviInfoPanel.maneuverID;
        xPNaviInfoPanel.mSegmentRemainDist = naviInfoPanel.segmentRemain.dist;
        xPNaviInfoPanel.mSegmentRemainTime = naviInfoPanel.segmentRemain.time;
        xPNaviInfoPanel.mNextRouteName = naviInfoPanel.nextRouteName;
        xPNaviInfoPanel.mNextRoadNameSegIdx = naviInfoPanel.nextRoadNameSegIdx;
        xPNaviInfoPanel.mNextRoadNameLinkIdx = naviInfoPanel.nextRoadNameLinkIdx;
        xPNaviInfoPanel.mSplit = naviInfoPanel.split;
        return xPNaviInfoPanel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPExitDirectionInfo toXPExitDirectionInfo(ExitDirectionInfo exitDirectionInfo) {
        if (exitDirectionInfo == null) {
            return null;
        }
        XPExitDirectionInfo xPExitDirectionInfo = new XPExitDirectionInfo();
        if (exitDirectionInfo.exitNameInfo != null) {
            xPExitDirectionInfo.mExitNameInfo = RootUtil.deepCopy(exitDirectionInfo.exitNameInfo);
        }
        if (exitDirectionInfo.directionInfo != null) {
            xPExitDirectionInfo.mDirectionInfo = RootUtil.deepCopy(exitDirectionInfo.directionInfo);
        }
        xPExitDirectionInfo.mDisToCurrentPos = exitDirectionInfo.disToCurrentPos;
        xPExitDirectionInfo.mRemainTime = exitDirectionInfo.remainTime;
        xPExitDirectionInfo.mEntranceExit = exitDirectionInfo.entranceExit;
        return xPExitDirectionInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPCrossImageInfo toXPCrossImageInfo(CrossImageInfo crossImageInfo) {
        if (crossImageInfo == null) {
            return null;
        }
        XPCrossImageInfo xPCrossImageInfo = new XPCrossImageInfo();
        xPCrossImageInfo.mType = crossImageInfo.type;
        if (crossImageInfo.dataBuf != null) {
            xPCrossImageInfo.mDataBuf = (byte[]) crossImageInfo.dataBuf.clone();
        }
        if (crossImageInfo.arrowDataBuf != null) {
            xPCrossImageInfo.mArrowDataBuf = (byte[]) crossImageInfo.arrowDataBuf.clone();
        }
        xPCrossImageInfo.mCrossImageID = crossImageInfo.crossImageID.longValue();
        xPCrossImageInfo.mIsOnlyVector = crossImageInfo.isOnlyVector;
        return xPCrossImageInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPManeuverInfo toXPManeuverInfo(ManeuverInfo maneuverInfo) {
        if (maneuverInfo == null) {
            return null;
        }
        XPManeuverInfo xPManeuverInfo = new XPManeuverInfo();
        xPManeuverInfo.mType = maneuverInfo.type;
        xPManeuverInfo.mPathID = maneuverInfo.pathID;
        xPManeuverInfo.mSegmentIndex = maneuverInfo.segmentIndex;
        xPManeuverInfo.mManeuverID = maneuverInfo.maneuverID;
        if (maneuverInfo.manuverbuffer != null && maneuverInfo.manuverbuffer.dataBuf != null && maneuverInfo.manuverbuffer.dataBuf.buffer != null) {
            xPManeuverInfo.mDataBuf = (byte[]) maneuverInfo.manuverbuffer.dataBuf.buffer.clone();
        }
        return xPManeuverInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPCameraInfo toXPCameraInfo(NaviCameraExt naviCameraExt, int i, ArrayList<Short> arrayList, boolean z) {
        int size;
        if (naviCameraExt == null) {
            return null;
        }
        XPCameraInfo xPCameraInfo = new XPCameraInfo();
        xPCameraInfo.mCoord2D = toXPCoord2DDouble(naviCameraExt.coord2D);
        xPCameraInfo.mCoord3D = toXPCoord3DDouble(naviCameraExt.coord3D);
        xPCameraInfo.mType = i;
        xPCameraInfo.mDistance = naviCameraExt.distance;
        xPCameraInfo.isSame = z;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            xPCameraInfo.mSpeed = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                xPCameraInfo.mSpeed[i2] = arrayList.get(i2).shortValue();
            }
        }
        xPCameraInfo.mRoadClass = naviCameraExt.roadClass;
        return xPCameraInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPCameraInfo toXPCameraInfo(NaviIntervalCameraDynamicInfo naviIntervalCameraDynamicInfo) {
        int size;
        if (naviIntervalCameraDynamicInfo == null) {
            return null;
        }
        XPCameraInfo xPCameraInfo = new XPCameraInfo();
        if (naviIntervalCameraDynamicInfo.speed != null && (size = naviIntervalCameraDynamicInfo.speed.size()) > 0) {
            xPCameraInfo.mSpeed = new int[size];
            for (int i = 0; i < size; i++) {
                xPCameraInfo.mSpeed[i] = naviIntervalCameraDynamicInfo.speed.get(i).shortValue();
            }
        }
        xPCameraInfo.mDistance = naviIntervalCameraDynamicInfo.distance;
        xPCameraInfo.mRemainDistance = naviIntervalCameraDynamicInfo.remainDistance;
        xPCameraInfo.mAverageSpeed = naviIntervalCameraDynamicInfo.averageSpeed;
        xPCameraInfo.mReasonableSpeedInRemainDist = naviIntervalCameraDynamicInfo.reasonableSpeedInRemainDist;
        return xPCameraInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPFacilityInfo toXPFacilityInfo(NaviFacility naviFacility) {
        if (naviFacility == null) {
            return null;
        }
        XPFacilityInfo xPFacilityInfo = new XPFacilityInfo();
        xPFacilityInfo.mRemainDist = naviFacility.remainDist;
        xPFacilityInfo.mType = naviFacility.type;
        String str = naviFacility.name;
        String string = ContextUtils.getString(R.string.tts_gas_station);
        if (!TextUtils.isEmpty(naviFacility.name) && naviFacility.name.contains(string)) {
            str = naviFacility.name.replace(string, ContextUtils.getString(R.string.tts_service_area));
        }
        xPFacilityInfo.mName = str;
        xPFacilityInfo.mPos = toXPCoord2DDouble(naviFacility.pos);
        xPFacilityInfo.mSapaDetail = naviFacility.sapaDetail;
        return xPFacilityInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ILightBarInfo toXPLightBarInfo(LightBarInfo lightBarInfo) {
        if (lightBarInfo == null) {
            return null;
        }
        return new XPLightBarInfo(lightBarInfo);
    }

    public static ILightBarInfo toXPLightBarInfo(List<XPLightBarItem> list, long j) {
        return new XPLightBarInfo(list, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPLightBarItem toXPLightBarItem(LightBarItem lightBarItem) {
        if (lightBarItem == null) {
            return null;
        }
        XPLightBarItem xPLightBarItem = new XPLightBarItem();
        xPLightBarItem.mStatus = lightBarItem.status;
        xPLightBarItem.mLength = lightBarItem.length;
        xPLightBarItem.mStartLinkIdx = lightBarItem.startLinkIdx;
        xPLightBarItem.mStartSegmentIdx = lightBarItem.startSegmentIdx;
        xPLightBarItem.mStartLinkStatus = lightBarItem.startLinkStatus;
        xPLightBarItem.mEndSegmentIdx = lightBarItem.endSegmentIdx;
        xPLightBarItem.mEndLinkIndex = lightBarItem.endLinkIndex;
        xPLightBarItem.mEndLinkStatus = lightBarItem.endLinkStatus;
        xPLightBarItem.mStartTrafficItem = toXPTrafficItem(lightBarItem.startTrafficItem);
        xPLightBarItem.mStart3dTrafficItem = toXPTrafficItem(lightBarItem.start3dTrafficItem);
        xPLightBarItem.mEndTrafficItem = toXPTrafficItem(lightBarItem.endTrafficItem);
        xPLightBarItem.mEnd3dTrafficItem = toXPTrafficItem(lightBarItem.end3dTrafficItem);
        return xPLightBarItem;
    }

    protected static XPTrafficItem toXPTrafficItem(TrafficItem trafficItem) {
        if (trafficItem == null) {
            return null;
        }
        XPTrafficItem xPTrafficItem = new XPTrafficItem();
        xPTrafficItem.mLength = trafficItem.length;
        xPTrafficItem.mTravelTime = trafficItem.travelTime;
        xPTrafficItem.mRatio = trafficItem.ratio;
        xPTrafficItem.mStartIndex = trafficItem.startIndex;
        xPTrafficItem.mEndIndex = trafficItem.endIndex;
        xPTrafficItem.mStatus = trafficItem.status;
        xPTrafficItem.mSpeed = trafficItem.speed;
        xPTrafficItem.mCredibility = trafficItem.credibility;
        xPTrafficItem.mReverse = trafficItem.reverse;
        xPTrafficItem.mStartPnt = toXPCoord3DDouble(trafficItem.startPnt);
        xPTrafficItem.mEndPnt = toXPCoord3DDouble(trafficItem.endPnt);
        return xPTrafficItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPNaviCongestionInfo toXPNaviCongestionInfo(NaviCongestionInfo naviCongestionInfo) {
        int size;
        if (naviCongestionInfo == null) {
            return null;
        }
        XPNaviCongestionInfo xPNaviCongestionInfo = new XPNaviCongestionInfo();
        IPathResult currentNaviPathResult = TBTManager.getInstance().getCurrentNaviPathResult();
        if (currentNaviPathResult != null && currentNaviPathResult.getPath(naviCongestionInfo.pathID) != null) {
            xPNaviCongestionInfo.mPath = currentNaviPathResult.getPath(naviCongestionInfo.pathID);
        }
        xPNaviCongestionInfo.mPathID = naviCongestionInfo.pathID;
        xPNaviCongestionInfo.mTotalTimeOfSeconds = naviCongestionInfo.totalTimeOfSeconds;
        xPNaviCongestionInfo.mTotalRemainDist = naviCongestionInfo.totalRemainDist;
        xPNaviCongestionInfo.mUnobstructed = naviCongestionInfo.unobstructed;
        if (naviCongestionInfo.congestionInfos != null && (size = naviCongestionInfo.congestionInfos.size()) > 0) {
            xPNaviCongestionInfo.mCongestionInfos = new XPNaviCongestionDetailInfo[size];
            for (int i = 0; i < size; i++) {
                xPNaviCongestionInfo.mCongestionInfos[i] = toXPNaviCongestionDetailInfo(naviCongestionInfo.congestionInfos.get(i));
            }
        }
        return xPNaviCongestionInfo;
    }

    protected static XPNaviCongestionDetailInfo toXPNaviCongestionDetailInfo(NaviCongestionDetailInfo naviCongestionDetailInfo) {
        if (naviCongestionDetailInfo == null) {
            return null;
        }
        XPNaviCongestionDetailInfo xPNaviCongestionDetailInfo = new XPNaviCongestionDetailInfo();
        xPNaviCongestionDetailInfo.mTimeOfSeconds = naviCongestionDetailInfo.timeOfSeconds;
        xPNaviCongestionDetailInfo.mScopeFlag = naviCongestionDetailInfo.scopeFlag;
        xPNaviCongestionDetailInfo.mBeginSegmentIndex = naviCongestionDetailInfo.beginSegmentIndex;
        xPNaviCongestionDetailInfo.mBeginLinkIndex = naviCongestionDetailInfo.beginLinkIndex;
        xPNaviCongestionDetailInfo.mBeginSectionIndex = naviCongestionDetailInfo.beginSectionIndex;
        xPNaviCongestionDetailInfo.mEndSegmentIndex = naviCongestionDetailInfo.endSegmentIndex;
        xPNaviCongestionDetailInfo.mEndLinkIndex = naviCongestionDetailInfo.endLinkIndex;
        xPNaviCongestionDetailInfo.mEndSectionIndex = naviCongestionDetailInfo.endSectionIndex;
        xPNaviCongestionDetailInfo.mStatus = naviCongestionDetailInfo.status;
        xPNaviCongestionDetailInfo.mRemainDist = naviCongestionDetailInfo.remainDist;
        xPNaviCongestionDetailInfo.mBeginExactLength = naviCongestionDetailInfo.beginExactLength;
        xPNaviCongestionDetailInfo.mBeginExactPoint = toXPCoord2DDouble(naviCongestionDetailInfo.beginExactPoint);
        xPNaviCongestionDetailInfo.mBeginCoorIndex = naviCongestionDetailInfo.beginCoorIndex;
        xPNaviCongestionDetailInfo.mEndExactLength = naviCongestionDetailInfo.endExactLength;
        xPNaviCongestionDetailInfo.mEndExactPoint = toXPCoord2DDouble(naviCongestionDetailInfo.endExactPoint);
        xPNaviCongestionDetailInfo.mEndCoorIndex = naviCongestionDetailInfo.endCoorIndex;
        xPNaviCongestionDetailInfo.mBeginExactLength3D = naviCongestionDetailInfo.beginExactLength3D;
        xPNaviCongestionDetailInfo.mBeginExactPoint3D = toXPCoord3DDouble(naviCongestionDetailInfo.beginExactPoint3D);
        xPNaviCongestionDetailInfo.mBeginCoorIndex3D = naviCongestionDetailInfo.beginCoorIndex3D;
        xPNaviCongestionDetailInfo.mEndExactLength3D = naviCongestionDetailInfo.endExactLength3D;
        xPNaviCongestionDetailInfo.mEndExactPoint3D = toXPCoord3DDouble(naviCongestionDetailInfo.endExactPoint3D);
        xPNaviCongestionDetailInfo.mEndCoorIndex3D = naviCongestionDetailInfo.endCoorIndex3D;
        return xPNaviCongestionDetailInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPPathTrafficEventInfo toXPPathTrafficEventInfo(PathTrafficEventInfo pathTrafficEventInfo) {
        if (pathTrafficEventInfo == null) {
            return null;
        }
        XPPathTrafficEventInfo xPPathTrafficEventInfo = new XPPathTrafficEventInfo();
        xPPathTrafficEventInfo.mPathID = pathTrafficEventInfo.pathID;
        xPPathTrafficEventInfo.mAction = pathTrafficEventInfo.action;
        if (pathTrafficEventInfo.eventInfoArray != null) {
            xPPathTrafficEventInfo.mEventInfoArray = new ArrayList();
            Iterator<TrafficEventInfo> it = pathTrafficEventInfo.eventInfoArray.iterator();
            while (it.hasNext()) {
                xPPathTrafficEventInfo.mEventInfoArray.add(toXPTrafficEventInfo(it.next()));
            }
        }
        return xPPathTrafficEventInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPRouteTrafficEventInfo toXPRouteTrafficEventInfo(RouteTrafficEventInfo routeTrafficEventInfo) {
        if (routeTrafficEventInfo == null) {
            return null;
        }
        XPRouteTrafficEventInfo xPRouteTrafficEventInfo = new XPRouteTrafficEventInfo();
        xPRouteTrafficEventInfo.mId = routeTrafficEventInfo.id;
        xPRouteTrafficEventInfo.mType = routeTrafficEventInfo.type;
        xPRouteTrafficEventInfo.mBrief = routeTrafficEventInfo.brief;
        xPRouteTrafficEventInfo.mSourceDesc = routeTrafficEventInfo.sourceDesc;
        return xPRouteTrafficEventInfo;
    }

    protected static XPTrafficEventInfo toXPTrafficEventInfo(TrafficEventInfo trafficEventInfo) {
        if (trafficEventInfo == null) {
            return null;
        }
        XPTrafficEventInfo xPTrafficEventInfo = new XPTrafficEventInfo();
        xPTrafficEventInfo.mType = trafficEventInfo.type;
        xPTrafficEventInfo.mLayer = trafficEventInfo.layer;
        xPTrafficEventInfo.mLayerTag = trafficEventInfo.layerTag;
        xPTrafficEventInfo.mId = trafficEventInfo.id;
        xPTrafficEventInfo.mCoord2D = toXPCoord2DDouble(trafficEventInfo.coord2D);
        xPTrafficEventInfo.mCoord3D = toXPCoord3DDouble(trafficEventInfo.coord3D);
        xPTrafficEventInfo.mOfficial = trafficEventInfo.official;
        xPTrafficEventInfo.mDetail = trafficEventInfo.detail;
        xPTrafficEventInfo.mLane = trafficEventInfo.lane;
        return xPTrafficEventInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPObtainInfo toXPObtainInfo(ManeuverIconResponseData maneuverIconResponseData) {
        if (maneuverIconResponseData == null) {
            return null;
        }
        XPObtainInfo xPObtainInfo = new XPObtainInfo();
        xPObtainInfo.mWhat = 2;
        xPObtainInfo.mReqID = maneuverIconResponseData.requestID;
        if (maneuverIconResponseData.data != null) {
            xPObtainInfo.mData = (byte[]) maneuverIconResponseData.data.clone();
        }
        xPObtainInfo.mObject = maneuverIconResponseData.requestConfig;
        return xPObtainInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPTollGateInfo toXPTollGateInfo(TollGateInfo tollGateInfo) {
        if (tollGateInfo == null) {
            return null;
        }
        XPTollGateInfo xPTollGateInfo = new XPTollGateInfo();
        if (tollGateInfo.laneTypes != null && tollGateInfo.laneTypes.size() > 0) {
            xPTollGateInfo.mLaneTypes = new ArrayList();
            Iterator<Integer> it = tollGateInfo.laneTypes.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (next != null) {
                    xPTollGateInfo.mLaneTypes.add(next);
                }
            }
        }
        return xPTollGateInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPSoundInfo toXPSoundInfo(SoundInfo soundInfo) {
        if (soundInfo == null) {
            return null;
        }
        XPSoundInfo xPSoundInfo = new XPSoundInfo();
        xPSoundInfo.mText = soundInfo.text;
        xPSoundInfo.mSceneType = soundInfo.sceneType;
        xPSoundInfo.mNaviType = soundInfo.naviType;
        xPSoundInfo.mSoundType = soundInfo.soundType;
        xPSoundInfo.mSubSoundType = soundInfo.subSoundType;
        xPSoundInfo.mSubCameraType = soundInfo.subCameraType;
        xPSoundInfo.mSubCategory = soundInfo.subCategory;
        xPSoundInfo.mMaxValidDis = soundInfo.maxValidDis;
        xPSoundInfo.mMinValidDis = soundInfo.minValidDis;
        xPSoundInfo.mCruiseSoundType = soundInfo.cruiseSoundType;
        xPSoundInfo.mRingType = soundInfo.ringType;
        return xPSoundInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPRestrictionInfo toXPRestrictionInfo(RestrictionInfo restrictionInfo) {
        if (restrictionInfo == null || TextUtils.isEmpty(restrictionInfo.title)) {
            return null;
        }
        XPRestrictionInfo xPRestrictionInfo = new XPRestrictionInfo();
        xPRestrictionInfo.mTitle = restrictionInfo.title;
        xPRestrictionInfo.mDesc = restrictionInfo.desc;
        xPRestrictionInfo.mTips = restrictionInfo.tips;
        xPRestrictionInfo.mCityCode = restrictionInfo.cityCode;
        xPRestrictionInfo.mType = restrictionInfo.type;
        xPRestrictionInfo.mTitleType = restrictionInfo.titleType;
        if (restrictionInfo.ruleIDs != null) {
            xPRestrictionInfo.mRuleIDs = new ArrayList<>();
            Iterator<Long> it = restrictionInfo.ruleIDs.iterator();
            while (it.hasNext()) {
                xPRestrictionInfo.mRuleIDs.add(Long.valueOf(it.next().longValue()));
            }
        }
        if (restrictionInfo.tailNums != null) {
            xPRestrictionInfo.mTailNums = new ArrayList<>();
            Iterator<Short> it2 = restrictionInfo.tailNums.iterator();
            while (it2.hasNext()) {
                xPRestrictionInfo.mTailNums.add(Byte.valueOf((byte) it2.next().shortValue()));
            }
        }
        return xPRestrictionInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ManeuverConfig toBLManeuverConfig(XPManeuverConfig xPManeuverConfig) {
        if (xPManeuverConfig == null) {
            return null;
        }
        ManeuverConfig maneuverConfig = new ManeuverConfig();
        maneuverConfig.width = xPManeuverConfig.mWidth;
        maneuverConfig.height = xPManeuverConfig.mHeight;
        maneuverConfig.backColor = xPManeuverConfig.mBackColor;
        maneuverConfig.roadColor = xPManeuverConfig.mRoadColor;
        maneuverConfig.arrowColor = xPManeuverConfig.mArrowColor;
        maneuverConfig.pathID = xPManeuverConfig.mPathID;
        maneuverConfig.segmentIdx = xPManeuverConfig.mSegmentIdx;
        maneuverConfig.maneuverID = xPManeuverConfig.mManeuverId;
        return maneuverConfig;
    }

    public static CrossImageInfo toBLCrossImageInfo(XPCrossImageInfo xPCrossImageInfo) {
        if (xPCrossImageInfo == null) {
            return null;
        }
        CrossImageInfo crossImageInfo = new CrossImageInfo();
        crossImageInfo.type = xPCrossImageInfo.mType;
        if (xPCrossImageInfo.mDataBuf != null) {
            crossImageInfo.dataBuf = (byte[]) xPCrossImageInfo.mDataBuf.clone();
        }
        if (xPCrossImageInfo.mArrowDataBuf != null) {
            crossImageInfo.arrowDataBuf = (byte[]) xPCrossImageInfo.mArrowDataBuf.clone();
        }
        crossImageInfo.crossImageID = new BigInteger(String.valueOf(xPCrossImageInfo.mCrossImageID));
        crossImageInfo.isOnlyVector = xPCrossImageInfo.mIsOnlyVector;
        return crossImageInfo;
    }

    public static LightBarInfo toBLLightBarInfo(List<XPLightBarItem> list, long j) {
        LightBarInfo lightBarInfo = new LightBarInfo();
        lightBarInfo.pathID = j;
        if (list != null) {
            lightBarInfo.itemList = new ArrayList<>();
            for (XPLightBarItem xPLightBarItem : list) {
                lightBarInfo.itemList.add(toBLLightBarItem(xPLightBarItem));
            }
        }
        return lightBarInfo;
    }

    protected static LightBarItem toBLLightBarItem(XPLightBarItem xPLightBarItem) {
        if (xPLightBarItem == null) {
            return null;
        }
        LightBarItem lightBarItem = new LightBarItem();
        lightBarItem.status = xPLightBarItem.mStatus;
        lightBarItem.length = xPLightBarItem.mLength;
        lightBarItem.startLinkIdx = xPLightBarItem.mStartLinkIdx;
        lightBarItem.startSegmentIdx = xPLightBarItem.mStartSegmentIdx;
        lightBarItem.startLinkStatus = xPLightBarItem.mStartLinkStatus;
        lightBarItem.endSegmentIdx = xPLightBarItem.mEndSegmentIdx;
        lightBarItem.endLinkIndex = xPLightBarItem.mEndLinkIndex;
        lightBarItem.endLinkStatus = xPLightBarItem.mEndLinkStatus;
        lightBarItem.startTrafficItem = toBLTrafficItem(xPLightBarItem.mStartTrafficItem);
        lightBarItem.start3dTrafficItem = toBLTrafficItem(xPLightBarItem.mStart3dTrafficItem);
        lightBarItem.endTrafficItem = toBLTrafficItem(xPLightBarItem.mEndTrafficItem);
        lightBarItem.end3dTrafficItem = toBLTrafficItem(xPLightBarItem.mEnd3dTrafficItem);
        return lightBarItem;
    }

    protected static TrafficItem toBLTrafficItem(XPTrafficItem xPTrafficItem) {
        if (xPTrafficItem == null) {
            return null;
        }
        TrafficItem trafficItem = new TrafficItem();
        trafficItem.length = xPTrafficItem.mLength;
        trafficItem.travelTime = xPTrafficItem.mTravelTime;
        trafficItem.ratio = xPTrafficItem.mRatio;
        trafficItem.startIndex = xPTrafficItem.mStartIndex;
        trafficItem.endIndex = xPTrafficItem.mEndIndex;
        trafficItem.status = xPTrafficItem.mStatus;
        trafficItem.speed = xPTrafficItem.mSpeed;
        trafficItem.credibility = xPTrafficItem.mCredibility;
        trafficItem.reverse = xPTrafficItem.mReverse;
        trafficItem.startPnt = toBLCoord3DDouble(xPTrafficItem.mStartPnt);
        trafficItem.endPnt = toBLCoord3DDouble(xPTrafficItem.mEndPnt);
        return trafficItem;
    }

    public static Coord3DDouble toBLCoord3DDouble(XPCoord3DDouble xPCoord3DDouble) {
        if (xPCoord3DDouble == null) {
            return null;
        }
        Coord3DDouble coord3DDouble = new Coord3DDouble();
        coord3DDouble.lon = xPCoord3DDouble.mLon;
        coord3DDouble.lat = xPCoord3DDouble.mLat;
        coord3DDouble.z = xPCoord3DDouble.mZ;
        return coord3DDouble;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPOddInfo toXPOddInfo(OddSegInfo oddSegInfo) {
        if (oddSegInfo == null) {
            return null;
        }
        XPOddInfo xPOddInfo = new XPOddInfo();
        xPOddInfo.mOddLen = oddSegInfo.m_OddLen;
        xPOddInfo.mStartSegIdx = oddSegInfo.m_StartSegIdx;
        xPOddInfo.mStartLinkIdx = oddSegInfo.m_StartLinkIdx;
        xPOddInfo.mStartOffSet = oddSegInfo.m_StartOffSet;
        xPOddInfo.mEndSegIdx = oddSegInfo.m_EndSegIdx;
        xPOddInfo.mEndLinkIdx = oddSegInfo.m_EndLinkIdx;
        xPOddInfo.mEndOffSet = oddSegInfo.m_EndOffSet;
        return xPOddInfo;
    }

    public static XPOddInfo copyXPOddInfo(XPOddInfo xPOddInfo) {
        XPOddInfo xPOddInfo2 = new XPOddInfo();
        xPOddInfo2.mOddLen = xPOddInfo.mOddLen;
        xPOddInfo2.mStartSegIdx = xPOddInfo.mStartSegIdx;
        xPOddInfo2.mStartLinkIdx = xPOddInfo.mStartLinkIdx;
        xPOddInfo2.mStartOffSet = xPOddInfo.mStartOffSet;
        xPOddInfo2.mEndSegIdx = xPOddInfo.mEndSegIdx;
        xPOddInfo2.mEndLinkIdx = xPOddInfo.mEndLinkIdx;
        xPOddInfo2.mEndOffSet = xPOddInfo.mEndOffSet;
        xPOddInfo2.mPoints.addAll(xPOddInfo.mPoints);
        return xPOddInfo2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPCoord3DDouble toXPCoord3DDouble(Coord2DDouble coord2DDouble) {
        if (coord2DDouble == null) {
            return null;
        }
        XPCoord3DDouble xPCoord3DDouble = new XPCoord3DDouble();
        xPCoord3DDouble.mLon = coord2DDouble.lon;
        xPCoord3DDouble.mLat = coord2DDouble.lat;
        xPCoord3DDouble.mZ = 0.0d;
        return xPCoord3DDouble;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static XPCruiseEventInfo toXPCruiseEventInfo(CruiseEventInfo cruiseEventInfo) {
        if (cruiseEventInfo == null) {
            return null;
        }
        XPCruiseEventInfo xPCruiseEventInfo = new XPCruiseEventInfo();
        xPCruiseEventInfo.mEventID = cruiseEventInfo.eventID;
        xPCruiseEventInfo.mEventPos = toXPCoord2DDouble(cruiseEventInfo.eventPos);
        xPCruiseEventInfo.mEventType = cruiseEventInfo.eventType;
        xPCruiseEventInfo.mLayer = cruiseEventInfo.layer;
        xPCruiseEventInfo.mLayerTag = cruiseEventInfo.layerTag;
        return xPCruiseEventInfo;
    }
}
