package com.xiaopeng.montecarlo.navcore.xptbt;

import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfoPanel;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class CloudRouteDataHelper {
    private static final int CURRENT_ROUTE_NAVI_INFO_INDEX = 0;
    private static final L.Tag TAG = new L.Tag("CloudRouteDataHelper");
    private static CloudRouteDataHelper sCloudRoutDataHelper = new CloudRouteDataHelper();
    private int mCurrentThroughViaIndex;
    private boolean mIsEnableCloudRoute = false;
    private Map<Integer, Integer> mRealViaIndexMap = new HashMap();

    public static CloudRouteDataHelper getInstance() {
        return sCloudRoutDataHelper;
    }

    public boolean isCloudRouteModeOpen() {
        return this.mIsEnableCloudRoute;
    }

    public void enableCloudRouteMode(boolean z, String str) {
        L.Tag tag = TAG;
        L.i(tag, "enableCloudRouteMode " + z + ", previous state is " + this.mIsEnableCloudRoute + ", from " + str);
        if (z != this.mIsEnableCloudRoute) {
            this.mIsEnableCloudRoute = z;
            if (z) {
                TBTManager.getInstance().setNaviInfoCount(2);
                TBTManager.getInstance().setMaxViaSize(12);
                return;
            }
            TBTManager.getInstance().setNaviInfoCount(1);
            TBTManager.getInstance().setMaxViaSize(3);
        }
    }

    private boolean isInvisibleViaWithIndex(int i) {
        XPViaPoint viaPoiInfo = getViaPoiInfo(i);
        if (viaPoiInfo == null) {
            return false;
        }
        return getInstance().isInvisibleVia(viaPoiInfo);
    }

    private XPViaPoint getViaPoiInfo(int i) {
        RouteParams currentNaviRouteParams = TBTManager.getInstance().getCurrentNaviRouteParams();
        if (currentNaviRouteParams == null || !CollectionUtils.isNotEmpty(currentNaviRouteParams.mViaInfos) || i < 0 || i >= currentNaviRouteParams.mViaInfos.size()) {
            return null;
        }
        return currentNaviRouteParams.mViaInfos.get(i);
    }

    public boolean checkAndReplaceViaInfo(XPManeuverInfo xPManeuverInfo) {
        if (this.mIsEnableCloudRoute && isNeedModifyForCloudRoute()) {
            XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
            XPCrossNaviInfo xPCrossNaviInfo = naviInfo.mNextCrossInfo[0];
            xPManeuverInfo.mPathID = naviInfo.mPathID;
            xPManeuverInfo.mManeuverID = xPCrossNaviInfo.mCrossManeuverID;
            xPManeuverInfo.mSegmentIndex = xPCrossNaviInfo.mSegIdx;
            return true;
        }
        return false;
    }

    public NaviTipsData updateNaviTipsInfoForCloudRoute(XPNaviInfo xPNaviInfo) {
        RouteParams currentNaviRouteParams;
        int i;
        int i2;
        if (this.mIsEnableCloudRoute) {
            XPNaviInfoPanel[] xPNaviInfoPanelArr = xPNaviInfo.mNaviInfoData;
            XPCrossNaviInfo[] xPCrossNaviInfoArr = xPNaviInfo.mNextCrossInfo;
            if (xPNaviInfoPanelArr == null || (currentNaviRouteParams = TBTManager.getInstance().getCurrentNaviRouteParams()) == null) {
                return null;
            }
            if (10 == xPNaviInfo.mCrossManeuverID) {
                this.mCurrentThroughViaIndex = currentNaviRouteParams.mViaInfos.size() - xPNaviInfo.mViaRemainDist.length;
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "mCurrentThroughViaIndex: " + currentNaviRouteParams.mViaInfos.size() + " - " + xPNaviInfo.mViaRemainDist.length + " = " + this.mCurrentThroughViaIndex);
                }
                if (!isNeedModifyForCloudRoute() || xPCrossNaviInfoArr == null || xPCrossNaviInfoArr.length <= 0) {
                    return null;
                }
                int i3 = xPNaviInfoPanelArr[xPNaviInfo.mNaviInfoFlag].mSegmentRemainDist + xPCrossNaviInfoArr[0].mCurToSegmentDist;
                int i4 = xPNaviInfoPanelArr[xPNaviInfo.mNaviInfoFlag].mSegmentRemainTime + xPCrossNaviInfoArr[0].mCurToSegmentTime;
                int i5 = xPCrossNaviInfoArr[0].mManeuverID;
                if (10 == i5 && L.ENABLE) {
                    L.d(TAG, "maneuverID, crossNaviInfo == naviInfoData");
                }
                String str = xPCrossNaviInfoArr[0].mNextRoadName;
                if (xPCrossNaviInfoArr.length > 1) {
                    i2 = xPCrossNaviInfoArr[1].mCurToSegmentDist;
                    i = xPCrossNaviInfoArr[1].mManeuverID;
                } else {
                    int i6 = xPCrossNaviInfoArr[0].mCurToSegmentDist;
                    i = xPCrossNaviInfoArr[0].mManeuverID;
                    i2 = i6;
                }
                NaviTipsData naviTipsData = new NaviTipsData();
                naviTipsData.setDistance(i3);
                naviTipsData.setRemainTime(i4);
                naviTipsData.setManeuverID(i5);
                naviTipsData.setNextRouteName(str);
                naviTipsData.setNextDistance(i2);
                naviTipsData.setNextManeuverID(i);
                return naviTipsData;
            }
            this.mCurrentThroughViaIndex = -1;
            if (L.ENABLE) {
                L.d(TAG, "mCurrentThroughViaIndex: -1");
            }
            return null;
        }
        return null;
    }

    private boolean isNeedModifyForCloudRoute() {
        int i;
        return this.mIsEnableCloudRoute && (i = this.mCurrentThroughViaIndex) >= 0 && isInvisibleViaWithIndex(i);
    }

    public int getRealViaIndex(int i) {
        Integer num;
        return (this.mIsEnableCloudRoute && (num = this.mRealViaIndexMap.get(Integer.valueOf(i))) != null) ? num.intValue() : i;
    }

    public void createRealViaIndexMap(long j) {
        this.mRealViaIndexMap.clear();
        if (this.mIsEnableCloudRoute) {
            L.i(TAG, "createRealViaIndexMap");
            List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(j);
            if (viaInfos != null) {
                int i = 0;
                for (int i2 = 0; i2 < viaInfos.size(); i2++) {
                    if (isInvisibleVia(viaInfos.get(i2))) {
                        this.mRealViaIndexMap.put(Integer.valueOf(i2), -1);
                    } else {
                        this.mRealViaIndexMap.put(Integer.valueOf(i2), Integer.valueOf(i));
                        i++;
                    }
                }
            }
        }
    }

    public void clearRealViaIndexMap() {
        this.mRealViaIndexMap.clear();
    }

    public List<XPViaPoint> getRealViaList(long j) {
        return getRealViaList(TBTManager.getInstance().getViaInfos(j), j);
    }

    public List<XPViaPoint> getRealViaList(List<XPViaPoint> list, long j) {
        if (!this.mIsEnableCloudRoute) {
            return TBTManager.getInstance().getViaInfos(j);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (XPViaPoint xPViaPoint : list) {
                if (!isInvisibleVia(xPViaPoint)) {
                    arrayList.add(xPViaPoint);
                }
            }
        }
        return arrayList;
    }

    public boolean isInvisibleVia(XPViaPoint xPViaPoint) {
        if (xPViaPoint != null && this.mIsEnableCloudRoute) {
            return xPViaPoint.getViaType() == 0 || 3 == xPViaPoint.getViaType();
        }
        return false;
    }

    public boolean isNeedModifyTTSForVia() {
        return this.mIsEnableCloudRoute && isInvisibleViaWithIndex(this.mCurrentThroughViaIndex);
    }
}
