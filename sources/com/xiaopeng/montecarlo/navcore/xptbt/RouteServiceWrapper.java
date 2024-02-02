package com.xiaopeng.montecarlo.navcore.xptbt;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.path.model.LabelInfo;
import com.autonavi.gbl.common.path.model.LightBarItem;
import com.autonavi.gbl.common.path.model.OddSegInfo;
import com.autonavi.gbl.common.path.model.POIInfo;
import com.autonavi.gbl.common.path.model.RouteLimitInfo;
import com.autonavi.gbl.common.path.model.ViaPointInfo;
import com.autonavi.gbl.common.path.option.CurrentNaviInfo;
import com.autonavi.gbl.common.path.option.CurrentPositionInfo;
import com.autonavi.gbl.common.path.option.POIForRequest;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.RouteOption;
import com.autonavi.gbl.pos.model.LocInfo;
import com.autonavi.gbl.pos.model.LocParallelRoadInfo;
import com.autonavi.gbl.route.RouteService;
import com.autonavi.gbl.route.model.PathResultData;
import com.autonavi.gbl.route.model.RouteControlKey;
import com.autonavi.gbl.route.observer.IRouteResultObserver;
import com.autonavi.gbl.search.model.SearchRoadId;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPSearchRoadId;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.util.NaviLogUtil;
import com.xiaopeng.montecarlo.navcore.util.SpatialUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPBaseLinkAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPBaseSegmentAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPDrivePathAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPOddInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPVariantPath;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class RouteServiceWrapper implements IRouteResultObserver {
    private static final int CALL_TIMEOUT_TIMER = 20000;
    private static final int MAX_POINT_SIZE = 2000;
    private static final String REQUEST_ROUTE_OUT_TIMER = "10000";
    private static final L.Tag TAG = new L.Tag("RouteServiceWrapper");
    private RouteParams mCurrentRouteParams;
    private final RouteManager mRouteManager;
    private RouteService mRouteService;
    private final int ODD_DEFAULT_DIST = 500;
    private final int DEFAULT_ODD_LEN = 100000;
    private final XCountDownTimer.ITimerCallback mTimerCallback = new XCountDownTimer.ITimerCallback() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.RouteServiceWrapper.1
        @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
        public void onTick(long j) {
        }

        @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
        public void onTimeOut() {
            boolean z;
            int i;
            L.i(RouteServiceWrapper.TAG, ">>> onTimeOut request route timer out mCurrentRouteParams =" + RouteServiceWrapper.this.mCurrentRouteParams);
            if (RouteServiceWrapper.this.mCurrentRouteParams != null) {
                int i2 = RouteServiceWrapper.this.mCurrentRouteParams.mRerouteType;
                boolean z2 = true ^ RouteServiceWrapper.this.mCurrentRouteParams.mCurRequestIsOnline;
                RouteServiceWrapper.this.mCurrentRouteParams = null;
                i = i2;
                z = z2;
            } else {
                z = false;
                i = 1;
            }
            RouteServiceWrapper.this.mRouteManager.onNewRouteError(0, i, 13, null, z, false);
        }
    };
    private final XCountDownTimer mTimer = new XCountDownTimer(SRNaviManager.SR_DATA_INTERVAL_LEVEL1, this.mTimerCallback);

    /* JADX INFO: Access modifiers changed from: package-private */
    public RouteServiceWrapper(RouteManager routeManager) {
        this.mRouteManager = routeManager;
    }

    public boolean initRouteService() {
        if (this.mRouteService == null) {
            this.mRouteService = (RouteService) ServiceMgr.getServiceMgrInstance().getBLService(16);
            if (this.mRouteService == null) {
                L.e(TAG, "initRouteService failed");
                return false;
            }
        }
        if (this.mRouteService.isInit() == 1) {
            if (this.mRouteService.init() != 0) {
                this.mRouteService = null;
                return false;
            }
            this.mRouteService.addRouteResultObserver(this);
            setVehicleType("2");
            setVehicleId(SettingWrapper.getLicensePlate());
            setETARestriction(SettingWrapper.isOpenPlateSwitch());
            this.mRouteService.control(309, "1");
            this.mRouteService.control(450, "C04030345001");
            this.mRouteService.control(27, NavCoreUtil.getDiu());
            this.mRouteService.control(RouteControlKey.RouteControlKeySetTotalTime, "10000");
        }
        return true;
    }

    @Override // com.autonavi.gbl.route.observer.IRouteResultObserver
    public void onNewRoute(PathResultData pathResultData, ArrayList<PathInfo> arrayList, RouteLimitInfo routeLimitInfo) {
        L.Tag tag = TAG;
        L.i(tag, "onNewRoute RouteMode: " + pathResultData.mode + " RouteType: " + pathResultData.type + " routeRespCategory:" + pathResultData.routeRespCategory);
        try {
            this.mTimer.stop();
            this.mCurrentRouteParams = null;
            if (pathResultData.routeRespCategory == 3) {
                this.mRouteManager.onOddData();
            } else {
                this.mRouteManager.onNewRoute(pathResultData.mode, pathResultData.type, new XPPathResult(arrayList), routeLimitInfo, pathResultData.isLocal);
            }
        } catch (Exception e) {
            NavCoreUtil.postCrashToast();
            e.printStackTrace();
            L.Tag tag2 = TAG;
            L.w(tag2, "onNewRoute error:" + e.getMessage());
        }
    }

    @Override // com.autonavi.gbl.route.observer.IRouteResultObserver
    public void onNewRouteError(PathResultData pathResultData, RouteLimitInfo routeLimitInfo) {
        L.Tag tag = TAG;
        L.i(tag, "onNewRouteError RouteMode:" + pathResultData.mode + " RouteType:" + pathResultData.type + " error code:" + pathResultData.errorCode + " isLocal:" + pathResultData.isLocal);
        try {
            this.mTimer.stop();
            this.mCurrentRouteParams = null;
            if (pathResultData.routeRespCategory == 3) {
                this.mRouteManager.onOddDataError();
            } else {
                this.mRouteManager.onNewRouteError(pathResultData.mode, pathResultData.type, pathResultData.errorCode, routeLimitInfo, pathResultData.isLocal, pathResultData.isChange);
            }
        } catch (Exception e) {
            NavCoreUtil.postCrashToast();
            e.printStackTrace();
            L.Tag tag2 = TAG;
            L.w(tag2, "onNewRouteError error:" + e.getMessage());
        }
    }

    public void cancelRoute(long j) {
        RouteService routeService = this.mRouteService;
        if (routeService != null) {
            routeService.abortRequest(j);
        }
    }

    public long requestRoute(RouteParams routeParams) {
        if (CollectionUtils.isNotEmpty(routeParams.mViaInfos)) {
            if (routeParams.mViaInfos.size() > 12) {
                return 0L;
            }
            int i = 0;
            int i2 = 0;
            for (XPViaPoint xPViaPoint : routeParams.mViaInfos) {
                if (xPViaPoint.getViaType() == 2) {
                    i++;
                } else if (xPViaPoint.getViaType() == 4) {
                    i2++;
                }
            }
            if (i > 3 || i2 > 9) {
                return 0L;
            }
        }
        RouteOption convertParamsToRouteOption = convertParamsToRouteOption(routeParams);
        long requestRoute = this.mRouteService.requestRoute(convertParamsToRouteOption);
        RouteOption.destroy(convertParamsToRouteOption);
        L.i(TAG, "request route result = " + requestRoute + " isOnline = " + routeParams.mCurRequestIsOnline);
        if (requestRoute != 0) {
            this.mCurrentRouteParams = routeParams;
            this.mTimer.start();
        }
        return requestRoute;
    }

    public long requestReroute(RouteParams routeParams) {
        filterRouteChargeVias(routeParams);
        RouteOption convertParamsToRerouteOption = convertParamsToRerouteOption(routeParams);
        long requestRoute = this.mRouteService.requestRoute(convertParamsToRerouteOption);
        L.Tag tag = TAG;
        L.i(tag, "request Reroute result = " + requestRoute);
        if (routeParams == null || routeParams.mRerouteOption == null) {
            RouteOption.destroy(convertParamsToRerouteOption);
        }
        if (requestRoute != 0) {
            this.mCurrentRouteParams = routeParams;
            this.mTimer.start();
        }
        return requestRoute;
    }

    private void filterRouteChargeVias(RouteParams routeParams) {
        if (routeParams == null || CollectionUtils.isEmpty(routeParams.mViaInfos) || !routeParams.mIsFilterCharge || !isNeedFilterChargeVia(routeParams.mRerouteType)) {
            return;
        }
        Iterator<XPViaPoint> it = routeParams.mViaInfos.iterator();
        boolean z = false;
        while (it.hasNext()) {
            XPViaPoint next = it.next();
            if (next != null && next.isChargeVia()) {
                it.remove();
                z = true;
            }
        }
        if (z) {
            routeParams.mChargeFiltered = true;
        }
    }

    private boolean isNeedFilterChargeVia(int i) {
        boolean isNavInHighWay = isNavInHighWay();
        boolean z = ((3 == i || 7 == i || 6 == i || 11 == i || 12 == i) && isNavInHighWay) || 9 == i;
        L.Tag tag = TAG;
        L.i(tag, "isNeedFilterChargeVia isNeedFilter=" + z + ", isNavInHighWay: " + isNavInHighWay);
        return z;
    }

    private boolean isNavInHighWay() {
        XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
        if (naviInfo != null) {
            L.Tag tag = TAG;
            L.i(tag, "isNavInHighWay naviInfo.mCurRoadClass=" + naviInfo.mCurRoadClass);
            if (naviInfo.mCurRoadClass == 0) {
                return true;
            }
        }
        return false;
    }

    public void setVehicleType(String str) {
        RouteService routeService = this.mRouteService;
        if (routeService != null) {
            routeService.control(3, str);
        }
    }

    public void setVehicleId(String str) {
        RouteService routeService = this.mRouteService;
        if (routeService != null) {
            routeService.control(1, str);
        }
    }

    public void setETARestriction(boolean z) {
        RouteService routeService = this.mRouteService;
        if (routeService != null) {
            routeService.control(2, z ? "1" : "0");
        }
    }

    public void parsePathOdd(@NonNull RouteResult routeResult) {
        XPDrivePathAccessor drivePathAccessor;
        IPathResult iPathResult = routeResult.mPathResult;
        if (iPathResult == null) {
            L.i(TAG, ">>> parsePathOdd but pathResult was null");
            return;
        }
        long pathCount = iPathResult.getPathCount();
        L.Tag tag = TAG;
        L.i(tag, ">>> parsePathOdd pathCount=" + pathCount);
        for (int i = 0; i < pathCount; i++) {
            XPVariantPath xPVariantPath = (XPVariantPath) iPathResult.getPath(i);
            if (xPVariantPath != null && (drivePathAccessor = xPVariantPath.getDrivePathAccessor()) != null) {
                parseOddInfo(drivePathAccessor, routeResult.getRouteInfo(i));
            }
        }
    }

    public RouteResult parsePath(@NonNull IPathResult iPathResult, boolean z) {
        long j;
        int size;
        long j2;
        int size2;
        Coord2DDouble coord2DDouble;
        IPathResult iPathResult2 = iPathResult;
        RouteResult routeResult = new RouteResult();
        routeResult.mPathResult = iPathResult2;
        long pathCount = iPathResult.getPathCount();
        L.i(TAG, ">>> parsePath pathCount=" + pathCount);
        short s = 0;
        int i = 0;
        while (i < pathCount) {
            XPVariantPath xPVariantPath = (XPVariantPath) iPathResult2.getPath(i);
            if (xPVariantPath == null) {
                j = pathCount;
            } else {
                XPDrivePathAccessor drivePathAccessor = xPVariantPath.getDrivePathAccessor();
                if (drivePathAccessor != null) {
                    RouteResult.RouteInfo routeInfo = new RouteResult.RouteInfo();
                    routeInfo.mPathId = drivePathAccessor.getPathID();
                    if (drivePathAccessor.getLabelInfoCount() > 0) {
                        LabelInfo labelInfo = drivePathAccessor.getLabelInfo(s);
                        if (labelInfo != null && !TextUtils.isEmpty(labelInfo.content)) {
                            routeInfo.mContentName = labelInfo.content;
                        }
                    } else {
                        L.i(TAG, ">>> parsePath LabelInfoCount is 0");
                    }
                    routeInfo.mPathLength = drivePathAccessor.getLength();
                    routeInfo.mTravelTime = drivePathAccessor.getTravelTime();
                    routeInfo.mTrafficLightCount = drivePathAccessor.getTrafficLightCount();
                    routeInfo.mTollCost = drivePathAccessor.getTollCost();
                    long segmentCount = drivePathAccessor.getSegmentCount();
                    if (L.ENABLE) {
                        L.d(TAG, "segCount:" + segmentCount);
                    }
                    XPBaseSegmentAccessor segmentAccessor = drivePathAccessor.getSegmentAccessor(segmentCount - 1);
                    if (segmentAccessor != null) {
                        ArrayList<Coord2DDouble> points = segmentAccessor.getPoints();
                        if (CollectionUtils.isNotEmpty(points) && (coord2DDouble = points.get(points.size() - 1)) != null) {
                            XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble();
                            xPCoordinate2DDouble.mLon = coord2DDouble.lon;
                            xPCoordinate2DDouble.mLat = coord2DDouble.lat;
                            routeInfo.mLastPoint = xPCoordinate2DDouble;
                        }
                    }
                    ArrayList<LightBarItem> lightBarItems = drivePathAccessor.getLightBarItems();
                    if (lightBarItems != null && (size2 = lightBarItems.size()) > 0) {
                        routeInfo.mLightBarItems = new ArrayList();
                        for (int i2 = s; i2 < size2; i2++) {
                            routeInfo.mLightBarItems.add(BLDataModelUtil.toXPLightBarItem(lightBarItems.get(i2)));
                        }
                    }
                    routeInfo.mRestrictionInfo = BLDataModelUtil.toXPRestrictionInfo(drivePathAccessor.getRestrictionInfo());
                    ArrayList<ViaPointInfo> viaPointInfo = drivePathAccessor.getViaPointInfo();
                    if (viaPointInfo == null || (size = viaPointInfo.size()) <= 0) {
                        j = pathCount;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        StringBuilder sb = L.ENABLE ? new StringBuilder("via info: ") : null;
                        long j3 = 0;
                        int i3 = s;
                        int i4 = i3;
                        while (i3 < size) {
                            ViaPointInfo viaPointInfo2 = viaPointInfo.get(i3);
                            if (viaPointInfo2 == null) {
                                j2 = pathCount;
                            } else {
                                if (L.ENABLE && sb != null) {
                                    sb.append("{");
                                    sb.append(i3);
                                    sb.append(": ");
                                    sb.append("segment index == ");
                                    sb.append((int) viaPointInfo2.segmentIdx);
                                }
                                int i5 = viaPointInfo2.segmentIdx;
                                for (int i6 = i4; i6 < i5; i6++) {
                                    long j4 = pathCount;
                                    XPBaseSegmentAccessor segmentAccessor2 = drivePathAccessor.getSegmentAccessor(i6);
                                    if (segmentAccessor2 != null) {
                                        j3 += segmentAccessor2.getLength();
                                    }
                                    pathCount = j4;
                                }
                                j2 = pathCount;
                                if (L.ENABLE && sb != null) {
                                    sb.append(", dis == ");
                                    sb.append(j3);
                                    sb.append("}, ");
                                }
                                arrayList.add(Long.valueOf(j3));
                                i4 = i5;
                            }
                            i3 = (short) (i3 + 1);
                            pathCount = j2;
                            i4 = i4;
                        }
                        j = pathCount;
                        if (L.ENABLE && sb != null) {
                            L.d(TAG, sb.toString());
                        }
                        L.i(TAG, "viasDis size " + arrayList.size());
                        routeInfo.mViasDisList = arrayList;
                    }
                    if (z) {
                        parseOddInfo(drivePathAccessor, routeInfo);
                    }
                    routeResult.mRouteInfos.add(routeInfo);
                    drivePathAccessor.recycle();
                } else {
                    j = pathCount;
                    L.w(TAG, ">>> parsePath xpVariantpath is null");
                }
            }
            i++;
            iPathResult2 = iPathResult;
            pathCount = j;
            s = 0;
        }
        return routeResult;
    }

    private void parseOddInfo(XPDrivePathAccessor xPDrivePathAccessor, RouteResult.RouteInfo routeInfo) {
        if (xPDrivePathAccessor == null || routeInfo == null) {
            return;
        }
        List<OddSegInfo> oddSegInfos = xPDrivePathAccessor.getOddSegInfos();
        if (CollectionUtils.isNotEmpty(oddSegInfos)) {
            int size = oddSegInfos.size();
            L.i(TAG, "parseOddInfo odd data size = " + size);
            XPOddInfo xPOddInfo = BLDataModelUtil.toXPOddInfo(oddSegInfos.get(0));
            List<Coord2DDouble> oddPoints = xPDrivePathAccessor.getOddPoints(0L);
            XPOddInfo xPOddInfo2 = xPOddInfo;
            for (int i = 1; i < size; i++) {
                if (oddSegInfos.get(i).m_OddLen >= 100000) {
                    XPOddInfo xPOddInfo3 = BLDataModelUtil.toXPOddInfo(oddSegInfos.get(i));
                    List<Coord2DDouble> oddPoints2 = xPDrivePathAccessor.getOddPoints(i);
                    if (LocationUtils.getDistance(BLDataModelUtil.toXPCoord2DDouble(oddPoints.get(oddPoints.size() - 1)), BLDataModelUtil.toXPCoord2DDouble(oddPoints2.get(0))) < 500.0d) {
                        xPOddInfo2.mEndSegIdx = xPOddInfo3.mEndSegIdx;
                        xPOddInfo2.mEndLinkIdx = xPOddInfo3.mEndLinkIdx;
                        xPOddInfo2.mEndOffSet = xPOddInfo3.mEndOffSet;
                        xPOddInfo2.mOddLen += xPOddInfo3.mOddLen;
                        oddPoints.addAll(oddPoints2);
                        if (i == size - 1) {
                            for (Coord2DDouble coord2DDouble : oddPoints) {
                                xPOddInfo2.mPoints.add(BLDataModelUtil.toXPCoord3DDouble(coord2DDouble));
                            }
                            routeInfo.mOddInfos.add(xPOddInfo2);
                        }
                    } else {
                        for (Coord2DDouble coord2DDouble2 : oddPoints) {
                            xPOddInfo2.mPoints.add(BLDataModelUtil.toXPCoord3DDouble(coord2DDouble2));
                        }
                        routeInfo.mOddInfos.add(xPOddInfo2);
                        xPOddInfo2 = xPOddInfo3;
                        oddPoints = oddPoints2;
                    }
                }
            }
            L.i(TAG, "parseOddInfo odd data new size = " + routeInfo.mOddInfos.size());
            return;
        }
        L.i(TAG, "parseOddInfo odd data was null");
    }

    @NonNull
    private RouteOption convertParamsToRouteOption(RouteParams routeParams) {
        updateRouteCalcType(routeParams);
        updateRouteNetworkState(routeParams);
        return getRouteOption(routeParams);
    }

    @NonNull
    private RouteOption convertParamsToRerouteOption(RouteParams routeParams) {
        updateRouteCalcType(routeParams);
        updateRouteNetworkState(routeParams);
        return getRerouteOption(routeParams);
    }

    private boolean isOddEnabled() {
        return DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_ENABLE_ODD_DISPLAY, false);
    }

    @NonNull
    public RouteOption getRouteOption(@NonNull RouteParams routeParams) {
        POIInfo bLPOIInfo;
        LocInfo currentLocInfo;
        RouteOption create = RouteOption.create();
        POIForRequest create2 = POIForRequest.create();
        boolean z = true;
        if (routeParams.mStartInfo != null) {
            POIInfo bLPOIInfo2 = routeParams.mStartInfo.toBLPOIInfo(true);
            if (!routeParams.mCurRequestIsOnline && (currentLocInfo = TBTManager.getInstance().getCurrentLocInfo()) != null) {
                bLPOIInfo2.roadID = currentLocInfo.roadId;
            }
            create2.addPoint(0, bLPOIInfo2);
            L.i(TAG, "PointTypeStart:" + NaviLogUtil.dumpBLPOIInfo(bLPOIInfo2));
        }
        if (routeParams.mEndInfo != null) {
            create2.addPoint(2, routeParams.mEndInfo.toBLPOIInfo(false));
            L.i(TAG, "PointTypeEnd:" + NaviLogUtil.dumpBLPOIInfo(bLPOIInfo));
        }
        List<XPViaPoint> list = routeParams.mViaInfos;
        if (CollectionUtils.isNotEmpty(list)) {
            for (XPViaPoint xPViaPoint : list) {
                POIInfo bLPOIInfo3 = xPViaPoint.toBLPOIInfo(false);
                if (!xPViaPoint.getIsPassedVia()) {
                    create2.addPoint(1, bLPOIInfo3);
                    L.i(TAG, "PointTypeVia:" + NaviLogUtil.dumpBLPOIInfo(bLPOIInfo3));
                } else {
                    L.i(TAG, "getRouteOption ignore passed PointTypeVia:" + NaviLogUtil.dumpBLPOIInfo(bLPOIInfo3));
                }
            }
        }
        updateRouteLocInfo(create2);
        create.setPOIForRequest(create2);
        create.setRouteStrategy(routeParams.mRouteCalcType);
        create.setOddFunction((routeParams.mIsRequestOdd && isOddEnabled()) ? false : false, routeParams.mIsOddMergeResp);
        create.setConstrainCode(routeParams.mConstrainCode | 12);
        L.i(TAG, "ConstrainCode:" + routeParams.mConstrainCode + " RouteType:" + routeParams.mRouteCalcType + ", DIU: " + NavCoreUtil.getDiu());
        POIForRequest.destroy(create2);
        return create;
    }

    @NonNull
    private RouteOption getRerouteOption(@Nullable RouteParams routeParams) {
        XPVariantPath xPVariantPath;
        if (routeParams == null) {
            return RouteOption.create();
        }
        RouteOption routeOption = routeParams.mRerouteOption;
        if (routeOption == null) {
            routeOption = RouteOption.create();
        }
        POIForRequest create = POIForRequest.create();
        boolean z = true;
        if (routeParams.mStartInfo != null) {
            if (4 == routeParams.mRerouteType) {
                long parallelRoadId = TBTManager.getInstance().getParallelRoadId();
                XPPoiInfo xPPoiInfo = routeParams.mStartInfo;
                if (parallelRoadId == -1) {
                    parallelRoadId = 0;
                }
                xPPoiInfo.setRoadId(parallelRoadId);
            }
            create.addPoint(0, routeParams.mStartInfo.toBLPOIInfo(true));
            L.i(TAG, "PointTypeStart:" + NaviLogUtil.dumpXPPOIInfo(routeParams.mStartInfo));
        } else {
            L.e(TAG, "getRerouteOption add start point  failure option.mStartInfo is NULL ");
        }
        if (routeParams.mEndInfo != null) {
            create.addPoint(2, routeParams.mEndInfo.toBLPOIInfo(false));
            L.i(TAG, "PointTypeEnd:" + NaviLogUtil.dumpXPPOIInfo(routeParams.mEndInfo));
        } else {
            L.e(TAG, "getRerouteOption add end point failure option.mEndInfo is NULL ");
        }
        List<XPViaPoint> list = routeParams.mViaInfos;
        if (CollectionUtils.isNotEmpty(list)) {
            for (XPViaPoint xPViaPoint : list) {
                POIInfo bLPOIInfo = xPViaPoint.toBLPOIInfo(false);
                if (!xPViaPoint.getIsPassedVia()) {
                    create.addPoint(1, bLPOIInfo);
                    L.i(TAG, "getRerouteOption add PointTypeVia: " + NaviLogUtil.dumpBLPOIInfo(bLPOIInfo));
                } else {
                    L.i(TAG, "getRerouteOption ignore passed PointTypeVia: " + NaviLogUtil.dumpBLPOIInfo(bLPOIInfo));
                }
            }
        }
        routeOption.setRouteStrategy(routeParams.mRouteCalcType);
        int i = routeParams.mConstrainCode | 12;
        routeOption.setConstrainCode(i);
        XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
        if (naviInfo != null) {
            CurrentPositionInfo currentPositionInfo = new CurrentPositionInfo();
            currentPositionInfo.linkIndex = naviInfo.mCurLinkIdx;
            currentPositionInfo.pointIndex = naviInfo.mCurPointIdx;
            currentPositionInfo.segmentIndex = naviInfo.mCurSegIdx;
            if (4 == routeParams.mRerouteType) {
                LocParallelRoadInfo locParallelRoadInfo = TBTManager.getInstance().getPosServiceWrapper().getLocParallelRoadInfo();
                if (locParallelRoadInfo != null) {
                    currentPositionInfo.parallelRoadFlag = (short) locParallelRoadInfo.flag;
                    currentPositionInfo.overheadFlag = (short) locParallelRoadInfo.hwFlag;
                }
                if (currentPositionInfo.overheadFlag != 0) {
                    routeOption.setParalleType(2);
                }
                if (currentPositionInfo.parallelRoadFlag != 0) {
                    routeOption.setParalleType(1);
                }
            }
            routeOption.setCurrentLocation(currentPositionInfo);
            CurrentNaviInfo currentNaviInfo = new CurrentNaviInfo();
            currentNaviInfo.remainRouteDist = (int) naviInfo.mRouteRemainDist;
            currentNaviInfo.remainRouteTime = (int) naviInfo.mRouteRemainTime;
            currentNaviInfo.remainSegmentDist = naviInfo.mNaviInfoData[naviInfo.mNaviInfoFlag].mSegmentRemainDist;
            currentNaviInfo.drivingRouteDist = naviInfo.mDriveDist;
            currentNaviInfo.rerouteCount = naviInfo.mRingOutCnt;
            routeOption.setRemainNaviInfo(currentNaviInfo);
        }
        IVariantPath currentNaviVariantPath = TBTManager.getInstance().getCurrentNaviVariantPath();
        if (currentNaviVariantPath != null && (xPVariantPath = (XPVariantPath) currentNaviVariantPath) != null && xPVariantPath.getVariantPath() != null) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("setNaviPath:");
            sb.append(xPVariantPath.getPathId());
            sb.append(", rerouteOption: ");
            sb.append(routeOption);
            sb.append(", null == params.mRerouteOption: ");
            sb.append(routeParams.mRerouteOption == null);
            L.i(tag, sb.toString());
            if (routeParams.mRerouteOption == null) {
                routeOption.setNaviPath(xPVariantPath.getVariantPath());
            }
        }
        updateRouteLocInfo(create);
        routeOption.setPOIForRequest(create);
        routeOption.setRouteType(routeParams.mRerouteType);
        routeOption.setOddFunction((routeParams.mIsRequestOdd && isOddEnabled()) ? false : false, routeParams.mIsOddMergeResp);
        POIForRequest.destroy(create);
        L.i(TAG, "ConstrainCode:" + i + " RouteType:" + routeParams.mRouteCalcType + ", DIU: " + NavCoreUtil.getDiu());
        return routeOption;
    }

    private void updateRouteLocInfo(POIForRequest pOIForRequest) {
        LocInfo currentLocInfo = TBTManager.getInstance().getCurrentLocInfo();
        if (currentLocInfo == null || pOIForRequest == null) {
            return;
        }
        pOIForRequest.setDirection(currentLocInfo.matchRoadCourse);
        pOIForRequest.setReliability(currentLocInfo.courseAcc);
        pOIForRequest.setAngleType(currentLocInfo.startDirType);
        pOIForRequest.setAngleGps(currentLocInfo.gpsDir);
        pOIForRequest.setAngleComp(currentLocInfo.compassDir);
        pOIForRequest.setSpeed(currentLocInfo.speed);
        pOIForRequest.setSigType(currentLocInfo.startPosType);
        pOIForRequest.setFittingDir(currentLocInfo.fittingCourse);
        pOIForRequest.setFittingCredit(currentLocInfo.fittingCourseAcc);
        pOIForRequest.setPrecision(currentLocInfo.posAcc);
        L.Tag tag = TAG;
        L.i(tag, "updateRouteLocInfo direction=" + currentLocInfo.matchRoadCourse + " gpsDir=" + currentLocInfo.gpsDir);
    }

    private void updateRouteCalcType(@Nullable RouteParams routeParams) {
        if (routeParams != null) {
            if (routeParams.mRouteCalcType == -1 || routeParams.mConstrainCode == -1) {
                int i = routeParams.mRoutePreference;
                if (i <= 0) {
                    i = SettingWrapper.getAllSettingValue();
                }
                boolean isAvoidCongestionEnabled = SettingWrapper.isAvoidCongestionEnabled(i);
                boolean isAvoidChargeEnabled = SettingWrapper.isAvoidChargeEnabled(i);
                boolean isNoFreewaysEnabled = SettingWrapper.isNoFreewaysEnabled(i);
                boolean isHighwayPriorityEnabled = SettingWrapper.isHighwayPriorityEnabled(i);
                int i2 = 4;
                int i3 = 0;
                if (isAvoidCongestionEnabled && isAvoidChargeEnabled && isNoFreewaysEnabled) {
                    i2 = 12;
                } else if (!isAvoidCongestionEnabled || !isNoFreewaysEnabled) {
                    if (isAvoidCongestionEnabled && isAvoidChargeEnabled) {
                        i2 = 12;
                    } else if (isAvoidChargeEnabled && isNoFreewaysEnabled) {
                        i2 = 1;
                        i3 = 1;
                    } else {
                        if (!isAvoidCongestionEnabled || !isHighwayPriorityEnabled) {
                            if (isHighwayPriorityEnabled) {
                                i2 = 0;
                            } else if (isAvoidChargeEnabled) {
                                i2 = 1;
                            } else if (isNoFreewaysEnabled) {
                                i2 = 0;
                            } else if (!isAvoidCongestionEnabled) {
                                i2 = 13;
                            }
                        }
                        i3 = 64;
                    }
                    routeParams.mRouteCalcType = i2;
                    routeParams.mConstrainCode = i3;
                    L.i(TAG, "RouteCalcType:" + i2 + "ConstrainCode:" + i3);
                }
                i3 = 1;
                routeParams.mRouteCalcType = i2;
                routeParams.mConstrainCode = i3;
                L.i(TAG, "RouteCalcType:" + i2 + "ConstrainCode:" + i3);
            }
        }
    }

    public int getSegmentLength(IVariantPath iVariantPath, long j) {
        XPDrivePathAccessor drivePathAccessor;
        if (iVariantPath != null && (drivePathAccessor = iVariantPath.getDrivePathAccessor()) != null) {
            XPBaseSegmentAccessor segmentAccessor = drivePathAccessor.getSegmentAccessor(j);
            r0 = segmentAccessor != null ? (int) segmentAccessor.getLength() : 0;
            drivePathAccessor.recycle();
        }
        return r0;
    }

    public int getSegmentFormway(IVariantPath iVariantPath, long j, long j2) {
        XPDrivePathAccessor drivePathAccessor;
        XPBaseLinkAccessor linkAccessor;
        XPVariantPath xPVariantPath = (XPVariantPath) iVariantPath;
        int i = -1;
        if (xPVariantPath != null && xPVariantPath.getVariantPath() != null && (drivePathAccessor = xPVariantPath.getDrivePathAccessor()) != null) {
            XPBaseSegmentAccessor segmentAccessor = drivePathAccessor.getSegmentAccessor(j);
            if (segmentAccessor != null && (linkAccessor = segmentAccessor.getLinkAccessor(j2)) != null) {
                i = linkAccessor.getFormway();
            }
            drivePathAccessor.recycle();
        }
        return i;
    }

    public List<XPCoordinate2DDouble> getCurrentRoutePoints() {
        IVariantPath path;
        int i;
        int i2;
        RouteResult routeResult = TBTManager.getInstance().getRouteResult(TBTManager.getInstance().getCurrentRouteRequestId());
        ArrayList arrayList = null;
        if (routeResult != null && routeResult.mPathResult != null && (path = routeResult.mPathResult.getPath(TBTManager.getInstance().getCurrentRoutePathIndex())) != null && (path instanceof XPVariantPath)) {
            L.i(TAG, "getCurrentRoutePoints variantPath:" + path.getPathId());
            XPDrivePathAccessor drivePathAccessor = path.getDrivePathAccessor();
            if (drivePathAccessor != null) {
                XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
                if (naviInfo != null) {
                    i2 = naviInfo.mCurSegIdx;
                    i = naviInfo.mCurLinkIdx;
                } else {
                    i = 0;
                    i2 = 0;
                }
                ArrayList arrayList2 = new ArrayList();
                int i3 = i2;
                while (true) {
                    long j = i3;
                    if (j >= drivePathAccessor.getSegmentCount()) {
                        break;
                    }
                    XPBaseSegmentAccessor segmentAccessor = drivePathAccessor.getSegmentAccessor(j);
                    if (segmentAccessor != null) {
                        if (i3 == i2) {
                            int i4 = i + 1;
                            while (true) {
                                long j2 = i4;
                                if (j2 >= segmentAccessor.getLinkCount()) {
                                    break;
                                }
                                XPBaseLinkAccessor linkAccessor = segmentAccessor.getLinkAccessor(j2);
                                if (linkAccessor != null) {
                                    arrayList2.addAll(linkAccessor.getPoints());
                                }
                                i4++;
                            }
                        } else {
                            arrayList2.addAll(segmentAccessor.getPoints());
                        }
                        if (arrayList2.size() > 2000) {
                            break;
                        }
                    }
                    i3++;
                }
                drivePathAccessor.recycle();
                if (arrayList2.size() < 2) {
                    L.i(TAG, "getRoutePoints:" + arrayList2.size() + ", startSegIdx:" + i2 + ", startLinkIdx:" + i);
                    RouteParams routeParams = this.mCurrentRouteParams;
                    if (routeParams != null && routeParams.mEndInfo != null) {
                        arrayList2.add(new Coord2DDouble(this.mCurrentRouteParams.mEndInfo.getNaviLon(), this.mCurrentRouteParams.mEndInfo.getNaviLat()));
                    }
                    XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
                    if (currentLocation != null) {
                        arrayList2.add(new Coord2DDouble(currentLocation.mLon, currentLocation.mLat));
                    }
                }
                List<Coord2DDouble> reducePoints = SpatialUtils.reducePoints(arrayList2);
                if (CollectionUtils.isNotEmpty(reducePoints)) {
                    arrayList = new ArrayList();
                    for (int i5 = 0; i5 < reducePoints.size(); i5++) {
                        arrayList.add(new XPCoordinate2DDouble(reducePoints.get(i5)));
                    }
                }
            }
        }
        return arrayList;
    }

    public List<XPCoordinate2DDouble> getCurrentRouteAllPoints() {
        IVariantPath path;
        int i;
        int i2;
        RouteResult routeResult = TBTManager.getInstance().getRouteResult(TBTManager.getInstance().getCurrentRouteRequestId());
        if (routeResult != null && routeResult.mPathResult != null && (path = routeResult.mPathResult.getPath(TBTManager.getInstance().getCurrentRoutePathIndex())) != null && (path instanceof XPVariantPath)) {
            L.i(TAG, "getCurrentRoutePoints variantPath:" + path.getPathId());
            XPDrivePathAccessor drivePathAccessor = path.getDrivePathAccessor();
            if (drivePathAccessor != null) {
                XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
                if (naviInfo != null) {
                    i2 = naviInfo.mCurSegIdx;
                    i = naviInfo.mCurLinkIdx;
                } else {
                    i = 0;
                    i2 = 0;
                }
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                while (true) {
                    long j = i3;
                    if (j >= drivePathAccessor.getSegmentCount()) {
                        break;
                    }
                    XPBaseSegmentAccessor segmentAccessor = drivePathAccessor.getSegmentAccessor(j);
                    if (segmentAccessor != null) {
                        int i4 = 0;
                        while (true) {
                            long j2 = i4;
                            if (j2 < segmentAccessor.getLinkCount()) {
                                XPBaseLinkAccessor linkAccessor = segmentAccessor.getLinkAccessor(j2);
                                if (linkAccessor != null) {
                                    arrayList.addAll(linkAccessor.getPoints());
                                }
                                i4++;
                            }
                        }
                    }
                    i3++;
                }
                drivePathAccessor.recycle();
                if (arrayList.size() < 2) {
                    L.i(TAG, "getRoutePoints:" + arrayList.size() + ", startSegIdx:" + i2 + ", startLinkIdx:" + i);
                    RouteParams routeParams = this.mCurrentRouteParams;
                    if (routeParams != null && routeParams.mEndInfo != null) {
                        arrayList.add(new Coord2DDouble(this.mCurrentRouteParams.mEndInfo.getNaviLon(), this.mCurrentRouteParams.mEndInfo.getNaviLat()));
                    }
                    XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
                    if (currentLocation != null) {
                        arrayList.add(new Coord2DDouble(currentLocation.mLon, currentLocation.mLat));
                    }
                }
                if (CollectionUtils.isNotEmpty(arrayList)) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i5 = 0; i5 < arrayList.size(); i5++) {
                        arrayList2.add(new XPCoordinate2DDouble((Coord2DDouble) arrayList.get(i5)));
                    }
                    return arrayList2;
                }
            }
        }
        return null;
    }

    public XPSearchRoadId[] getCurrentRoadIds() {
        IVariantPath path;
        XPDrivePathAccessor drivePathAccessor;
        RouteResult routeResult = TBTManager.getInstance().getRouteResult(TBTManager.getInstance().getCurrentRouteRequestId());
        if (routeResult == null || routeResult.mPathResult == null || (path = routeResult.mPathResult.getPath(TBTManager.getInstance().getCurrentRoutePathIndex())) == null || !(path instanceof XPVariantPath) || (drivePathAccessor = path.getDrivePathAccessor()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long segmentCount = drivePathAccessor.getSegmentCount();
        for (long j = 0; j < segmentCount; j++) {
            XPBaseSegmentAccessor segmentAccessor = drivePathAccessor.getSegmentAccessor(j);
            if (segmentAccessor != null) {
                long linkCount = segmentAccessor.getLinkCount();
                for (long j2 = 0; j2 < linkCount; j2++) {
                    XPBaseLinkAccessor linkAccessor = segmentAccessor.getLinkAccessor(j2);
                    if (linkAccessor != null) {
                        SearchRoadId searchRoadId = new SearchRoadId();
                        searchRoadId.roadId = (int) linkAccessor.getTPID();
                        searchRoadId.tileId = (int) linkAccessor.getTileID();
                        searchRoadId.urId = linkAccessor.getURID();
                        arrayList.add(searchRoadId);
                    }
                }
            }
        }
        XPSearchRoadId[] xPSearchRoadIdArr = new XPSearchRoadId[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            xPSearchRoadIdArr[i] = new XPSearchRoadId((SearchRoadId) arrayList.get(i));
        }
        drivePathAccessor.recycle();
        return xPSearchRoadIdArr;
    }

    private void updateRouteNetworkState(@Nullable RouteParams routeParams) {
        boolean z;
        if (routeParams == null) {
            return;
        }
        int i = routeParams.mConstrainCode | 256;
        if ((!XPNetworkManager.INSTANCE.isNetworkConnected() || routeParams.mNetworkProperty == 0) && 14 != routeParams.mRerouteType) {
            z = true;
        } else {
            i ^= 256;
            z = false;
        }
        routeParams.mConstrainCode = i;
        routeParams.mCurRequestIsOnline = !z;
    }
}
