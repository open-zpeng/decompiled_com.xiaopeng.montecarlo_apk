package com.xiaopeng.montecarlo.navcore.xptbt;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.INaviPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCameraInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCruiseCongestionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCruiseInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPExitDirectionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviCongestionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPPathTrafficEventInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPRouteTrafficEventInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTollGateInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTrafficEventInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
/* loaded from: classes3.dex */
public class GuideDataManager {
    private static final int CAMERA_DIS = 700;
    protected static final int SIMULATION_DEFAULT_SPEED = 60;
    private static final int SIMULATION_MAX_SPEED = 5000;
    private static final int SIMULATION_SPEED_ADJ_FAST = 100;
    private static final int SIMULATION_SPEED_ADJ_SLOW = 10;
    private static final L.Tag TAG = new L.Tag("GuideDataManager");
    private XPCruiseCongestionInfo mCruiseCongestionInfo;
    private XPLaneInfo mCruiseLaneInfo;
    private XPPoiInfo mLastEndInfo;
    private XPPoiInfo mLastNaviEndInfo;
    private int mLastPassedIndexDiff;
    private List<ILightBarInfo> mLightBarInfos;
    private List<XPCameraInfo> mNaviCameras;
    private XPNaviCongestionInfo mNaviCongestionInfo;
    private XPCrossImageInfo mNaviCrossImageInfo;
    private XPExitDirectionInfo mNaviExitDirectionInfo;
    private XPNaviInfo mNaviInfo;
    private List<XPNaviInfo> mNaviInfoList;
    private List<XPCameraInfo> mNaviIntervalCameras;
    private List<XPCameraInfo> mNaviIntervalDynamicCameras;
    private XPLaneInfo mNaviLaneInfo;
    private XPManeuverInfo mNaviManeuverInfo;
    private INaviPath mNaviPath;
    private List<XPFacilityInfo> mNaviSapas;
    private long mParallelRoadId;
    private List<XPPathTrafficEventInfo> mPathTrafficEventInfos;
    private RouteParams mRestoreRouteParams;
    private float mRouteRemainDist;
    private XPRouteTrafficEventInfo mRouteTrafficEventInfo;
    private int mSRTrafficEventType;
    private XPCruiseInfo mXPCruiseInfo;
    private List<XPFacilityInfo> mXPFacilityInfos;
    private XPTollGateInfo mXPTollGateInfo;
    private long mCurrentNaviId = -1;
    private long mOldNaviId = -1;
    private long mRecommendNaviId = -1;
    private int mOldPathIndex = 0;
    private int mCurrentPathIndex = 0;
    private long mCurrentPathId = -1;
    private int mSimulationSpeed = 60;
    private int mLightBarPassedIndex = 0;
    private int mCurrentRoadSpeed = -1;
    private int mCurrentCameraSpeed = -1;
    private int mCurrentCameraDist = -1;

    private boolean isNeedSaveCurrentNaviId(int i) {
        return 11 == i || 13 == i || 7 == i || 6 == i;
    }

    public void reset() {
        if (L.ENABLE) {
            L.d(TAG, "reset");
        }
        if (-1 != this.mCurrentNaviId) {
            TBTManager.getInstance().clearRouteData(this.mCurrentNaviId);
            this.mCurrentNaviId = -1L;
        }
        if (-1 != this.mOldNaviId) {
            TBTManager.getInstance().clearRouteData(this.mOldNaviId);
            this.mOldNaviId = -1L;
        }
        if (-1 != this.mRecommendNaviId) {
            TBTManager.getInstance().clearRouteData(this.mRecommendNaviId);
            this.mRecommendNaviId = -1L;
        }
        INaviPath iNaviPath = this.mNaviPath;
        if (iNaviPath != null) {
            iNaviPath.recycle();
            this.mNaviPath = null;
        }
        this.mOldPathIndex = 0;
        this.mCurrentPathIndex = 0;
        this.mCurrentPathId = -1L;
        this.mNaviInfo = null;
        this.mNaviInfoList = null;
        this.mNaviCrossImageInfo = null;
        this.mNaviLaneInfo = null;
        this.mNaviManeuverInfo = null;
        this.mNaviCameras = null;
        this.mNaviIntervalCameras = null;
        this.mNaviIntervalDynamicCameras = null;
        this.mNaviCongestionInfo = null;
        this.mNaviExitDirectionInfo = null;
        this.mNaviSapas = null;
        this.mLastPassedIndexDiff = 0;
        this.mRestoreRouteParams = null;
        this.mXPFacilityInfos = null;
        this.mXPCruiseInfo = null;
        this.mCruiseCongestionInfo = null;
        this.mCruiseLaneInfo = null;
        this.mLightBarInfos = null;
        this.mLightBarPassedIndex = 0;
        this.mPathTrafficEventInfos = null;
        this.mRouteTrafficEventInfo = null;
        this.mCurrentRoadSpeed = -1;
    }

    public void setCurrentNaviId(long j, int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setCurrentNaviId naviId = " + j + " , routeType = " + i);
        }
        long j2 = this.mCurrentNaviId;
        if (-1 != j2 && j2 != j) {
            if (isNeedSaveCurrentNaviId(i)) {
                long j3 = this.mOldNaviId;
                if (-1 != j3 && j3 != j) {
                    TBTManager.getInstance().clearRouteData(this.mOldNaviId);
                }
                this.mOldNaviId = this.mCurrentNaviId;
                this.mOldPathIndex = this.mCurrentPathIndex;
            } else {
                TBTManager.getInstance().clearRouteData(this.mCurrentNaviId);
                this.mOldNaviId = -1L;
            }
        }
        this.mCurrentNaviId = j;
        this.mLastNaviEndInfo = null;
        long j4 = this.mRecommendNaviId;
        if (-1 != j4 && j4 != j) {
            TBTManager.getInstance().clearRouteData(this.mRecommendNaviId);
        }
        INaviPath iNaviPath = this.mNaviPath;
        if (iNaviPath != null) {
            iNaviPath.recycle();
        }
        RouteDataModel routeData = TBTManager.getInstance().getRouteData(this.mCurrentNaviId);
        this.mNaviPath = obtainNaviPath(routeData.mRouteResult.mPathResult, routeData.mRouteParams, i);
    }

    public void updatePathIndex(int i) {
        INaviPath iNaviPath = this.mNaviPath;
        if (iNaviPath != null) {
            int naviPathCount = iNaviPath.getNaviPathCount();
            if (i < 0 || i >= naviPathCount) {
                return;
            }
            this.mCurrentPathIndex = i;
            this.mCurrentPathId = this.mNaviPath.getPathId(this.mCurrentPathIndex);
            TBTManager.getInstance().updateCurrentRouteInfo(this.mCurrentNaviId, this.mCurrentPathIndex);
            L.Tag tag = TAG;
            L.i(tag, ">>> updatePathIndex index=" + i + " pathID=" + this.mNaviPath.getPathId(i));
            updateRouteContent(i);
        }
    }

    public long getMainPathId() {
        return this.mCurrentPathId;
    }

    public int getCurrentNaviPathIndex() {
        return this.mCurrentPathIndex;
    }

    public IPathResult getCurrentNaviPathResult() {
        RouteDataModel routeData;
        if (-1 == this.mCurrentNaviId || (routeData = TBTManager.getInstance().getRouteData(this.mCurrentNaviId)) == null || routeData.mRouteResult == null || routeData.mRouteResult.mPathResult == null) {
            return null;
        }
        return routeData.mRouteResult.mPathResult;
    }

    public IPathResult getRecommendNaviPathResult() {
        RouteDataModel routeData;
        if (-1 == this.mRecommendNaviId || (routeData = TBTManager.getInstance().getRouteData(this.mRecommendNaviId)) == null || routeData.mRouteResult == null || routeData.mRouteResult.mPathResult == null) {
            return null;
        }
        return routeData.mRouteResult.mPathResult;
    }

    public IVariantPath getOldNaviVariantPath() {
        RouteDataModel routeData;
        int i;
        if (-1 == this.mOldNaviId || (routeData = TBTManager.getInstance().getRouteData(this.mOldNaviId)) == null || routeData.mRouteResult == null || routeData.mRouteResult.mPathResult == null || (i = this.mOldPathIndex) < 0 || i >= routeData.mRouteResult.mPathResult.getPathCount()) {
            return null;
        }
        return routeData.mRouteResult.mPathResult.getPath(this.mOldPathIndex);
    }

    public void setNaviPathType(int i) {
        INaviPath iNaviPath = this.mNaviPath;
        if (iNaviPath != null) {
            iNaviPath.setNaviPathType(i);
        }
    }

    public long addCurrentPathToMultiPathResult(@NonNull RouteResult routeResult) {
        IVariantPath currentVariantPath = getCurrentVariantPath();
        if (currentVariantPath != null) {
            routeResult.mPathResult.addPath(currentVariantPath);
            routeResult.mRouteInfos.add(getCurrentRouteInfo());
        }
        return routeResult.mPathResult.getPathCount() - 1;
    }

    public boolean removeDeletePath(long j) {
        RouteDataModel routeData;
        if (-1 == this.mCurrentNaviId || (routeData = TBTManager.getInstance().getRouteData(this.mCurrentNaviId)) == null || routeData.mRouteResult == null || routeData.mRouteResult.mPathResult == null) {
            return false;
        }
        routeData.mRouteResult.mPathResult.removePath(getVariantPath(j));
        routeData.mRouteResult.removeRouteInfo(j);
        return true;
    }

    public IVariantPath getCurrentVariantPath() {
        RouteDataModel routeData;
        if (-1 == this.mCurrentNaviId || (routeData = TBTManager.getInstance().getRouteData(this.mCurrentNaviId)) == null || routeData.mRouteResult == null || routeData.mRouteResult.mPathResult == null) {
            return null;
        }
        return routeData.mRouteResult.mPathResult.getPath(this.mCurrentPathIndex);
    }

    public RouteResult.RouteInfo getCurrentRouteInfo() {
        RouteDataModel routeData;
        if (-1 == this.mCurrentNaviId || (routeData = TBTManager.getInstance().getRouteData(this.mCurrentNaviId)) == null || routeData.mRouteResult == null || routeData.mRouteResult.mRouteInfos == null) {
            return null;
        }
        int size = routeData.mRouteResult.mRouteInfos.size();
        int i = this.mCurrentPathIndex;
        if (i < 0 || i >= size) {
            return null;
        }
        return routeData.mRouteResult.mRouteInfos.get(this.mCurrentPathIndex);
    }

    public RouteParams getCurrentRouteParams() {
        RouteDataModel routeData;
        if (-1 == this.mCurrentNaviId || (routeData = TBTManager.getInstance().getRouteData(this.mCurrentNaviId)) == null || routeData.mRouteParams == null) {
            return null;
        }
        return routeData.mRouteParams;
    }

    public long getCurrentPathId() {
        INaviPath iNaviPath = this.mNaviPath;
        if (iNaviPath != null) {
            return iNaviPath.getPathId(this.mCurrentPathIndex);
        }
        return -1L;
    }

    public IVariantPath getVariantPath(long j) {
        INaviPath iNaviPath = this.mNaviPath;
        if (iNaviPath != null) {
            return iNaviPath.getVariantPath(j);
        }
        return null;
    }

    public int getPathIndexFormPathId(long j) {
        RouteDataModel routeData;
        if (-1 == this.mCurrentNaviId || (routeData = TBTManager.getInstance().getRouteData(this.mCurrentNaviId)) == null || routeData.mRouteResult == null || routeData.mRouteResult.mPathResult == null) {
            return -1;
        }
        return routeData.mRouteResult.mPathResult.getPathIndex(j);
    }

    public RouteParams getRestoreRouteParams() {
        return this.mRestoreRouteParams;
    }

    public void setRestoreRouteParams(RouteParams routeParams) {
        this.mRestoreRouteParams = routeParams;
    }

    public INaviPath getNaviPath() {
        return this.mNaviPath;
    }

    public long getCurrentNaviId() {
        return this.mCurrentNaviId;
    }

    public long getOldNaviId() {
        return this.mOldNaviId;
    }

    public long getRecommendNaviId() {
        return this.mRecommendNaviId;
    }

    public void setRecommendNaviId(long j) {
        long j2 = this.mRecommendNaviId;
        if (-1 != j2 && j2 != j && j2 != this.mCurrentNaviId) {
            TBTManager.getInstance().clearRouteData(this.mRecommendNaviId);
        }
        this.mRecommendNaviId = j;
    }

    public int getSimulationSpeed() {
        return this.mSimulationSpeed;
    }

    public void updateSimulationSpeed(int i) {
        this.mSimulationSpeed = i;
    }

    public int incSimulationSpeed() {
        int i = this.mSimulationSpeed;
        if (i >= 200) {
            this.mSimulationSpeed = i + 100;
        } else {
            this.mSimulationSpeed = i + 10;
        }
        if (this.mSimulationSpeed > 5000) {
            this.mSimulationSpeed = 5000;
        }
        return this.mSimulationSpeed;
    }

    public int decSimulationSpeed() {
        int i = this.mSimulationSpeed;
        if (i >= 200) {
            this.mSimulationSpeed = i - 100;
        } else {
            this.mSimulationSpeed = i - 10;
        }
        if (this.mSimulationSpeed < 0) {
            this.mSimulationSpeed = 0;
        }
        return this.mSimulationSpeed;
    }

    public XPNaviInfo getNaviInfo() {
        return this.mNaviInfo;
    }

    public void setNaviInfo(XPNaviInfo xPNaviInfo) {
        this.mNaviInfo = xPNaviInfo;
    }

    public List<XPNaviInfo> getNaviInfoList() {
        return this.mNaviInfoList;
    }

    public void setNaviInfoList(List<XPNaviInfo> list) {
        this.mNaviInfoList = list;
    }

    public XPCrossImageInfo getNaviCrossImageInfo() {
        return this.mNaviCrossImageInfo;
    }

    public void setNaviCrossImageInfo(XPCrossImageInfo xPCrossImageInfo) {
        this.mNaviCrossImageInfo = xPCrossImageInfo;
    }

    public XPLaneInfo getNaviLaneInfo() {
        return this.mNaviLaneInfo;
    }

    public void setNaviLaneInfo(XPLaneInfo xPLaneInfo) {
        this.mNaviLaneInfo = xPLaneInfo;
    }

    public XPManeuverInfo getNaviManeuverInfo() {
        return this.mNaviManeuverInfo;
    }

    public void setNaviManeuverInfo(XPManeuverInfo xPManeuverInfo) {
        this.mNaviManeuverInfo = xPManeuverInfo;
    }

    public List<XPCameraInfo> getNaviCameras() {
        return this.mNaviCameras;
    }

    public void setNaviCameras(List<XPCameraInfo> list) {
        this.mNaviCameras = list;
    }

    public XPCameraInfo getCurrentCameraByNavCamera() {
        List<XPCameraInfo> list = this.mNaviCameras;
        if (list != null) {
            for (XPCameraInfo xPCameraInfo : list) {
                if (xPCameraInfo != null && (xPCameraInfo.mType == 0 || 10 == xPCameraInfo.mType)) {
                    if (xPCameraInfo.mDistance <= 700 && !CollectionUtils.isEmpty(xPCameraInfo.mSpeed) && xPCameraInfo.mSpeed[0] != 0 && xPCameraInfo.mSpeed[0] != 255) {
                        return xPCameraInfo;
                    }
                }
            }
        }
        return null;
    }

    public List<XPCameraInfo> getNaviIntervalCameras() {
        return this.mNaviIntervalCameras;
    }

    public void setNaviIntervalCameras(List<XPCameraInfo> list) {
        this.mNaviIntervalCameras = list;
    }

    public List<XPCameraInfo> getNaviIntervalDynamicCameras() {
        return this.mNaviIntervalDynamicCameras;
    }

    public void setNaviIntervalDynamicCameras(List<XPCameraInfo> list) {
        this.mNaviIntervalDynamicCameras = list;
    }

    public XPNaviCongestionInfo getNaviCongestionInfo() {
        return this.mNaviCongestionInfo;
    }

    public void setNaviCongestionInfo(XPNaviCongestionInfo xPNaviCongestionInfo) {
        this.mNaviCongestionInfo = xPNaviCongestionInfo;
    }

    public XPExitDirectionInfo getNaviExitDirectionInfo() {
        return this.mNaviExitDirectionInfo;
    }

    public void setNaviExitDirectionInfo(XPExitDirectionInfo xPExitDirectionInfo) {
        this.mNaviExitDirectionInfo = xPExitDirectionInfo;
    }

    public long getParallelRoadId() {
        return this.mParallelRoadId;
    }

    public void setParallelRoadId(long j) {
        this.mParallelRoadId = j;
    }

    public int getLastPassedIndexDiff() {
        return this.mLastPassedIndexDiff;
    }

    public void setLastPassedIndexDiff(int i) {
        this.mLastPassedIndexDiff = i;
    }

    private INaviPath obtainNaviPath(IPathResult iPathResult, RouteParams routeParams, int i) {
        XPNaviPath xPNaviPath = new XPNaviPath();
        xPNaviPath.createNaviPath(iPathResult, routeParams, i);
        return xPNaviPath;
    }

    private void updateRouteContent(int i) {
        RouteDataModel routeData;
        RouteResult.RouteInfo routeInfo;
        if (-1 == this.mCurrentNaviId || (routeData = TBTManager.getInstance().getRouteData(this.mCurrentNaviId)) == null || routeData.mRouteResult == null || routeData.mRouteParams == null) {
            return;
        }
        int size = routeData.mRouteResult.mRouteInfos.size();
        if (i >= 0 && i < size && (routeInfo = routeData.mRouteResult.mRouteInfos.get(i)) != null) {
            routeData.mRouteParams.mRouteContent = routeInfo.mContentName;
        }
        if (routeData.mRouteParams.mRestoreRouteData != null) {
            routeData.mRouteParams.mRestoreRouteData.updatePathID(routeData.mRouteResult, this.mCurrentPathId);
            TBTManager.getInstance().saveCurrentRouteHistory();
        }
    }

    public XPPoiInfo getLastNaviEndInfo() {
        return this.mLastNaviEndInfo;
    }

    public void saveNaviEndInfo() {
        RouteDataModel routeData = TBTManager.getInstance().getRouteData(this.mCurrentNaviId);
        if (routeData == null || routeData.mRouteParams == null) {
            return;
        }
        this.mLastNaviEndInfo = routeData.mRouteParams.mEndInfo;
    }

    public void saveNaviInfoForDataLog() {
        RouteDataModel routeData = TBTManager.getInstance().getRouteData(this.mCurrentNaviId);
        if (routeData != null && routeData.mRouteParams != null) {
            this.mLastEndInfo = routeData.mRouteParams.mEndInfo;
        }
        XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
        if (naviInfo == null) {
            return;
        }
        this.mRouteRemainDist = (float) naviInfo.mRouteRemainDist;
    }

    public XPPoiInfo getLastEndInfoForDataLog() {
        return this.mLastEndInfo;
    }

    public float getRouteRemainDistForDataLog() {
        return this.mRouteRemainDist;
    }

    public void resetLastNaviEndInfo() {
        this.mLastNaviEndInfo = null;
    }

    public List<XPFacilityInfo> getXPFacilityInfos() {
        return this.mXPFacilityInfos;
    }

    public void setXPFacilityInfos(List<XPFacilityInfo> list) {
        this.mXPFacilityInfos = list;
    }

    public List<XPFacilityInfo> getNaviSapas() {
        return this.mNaviSapas;
    }

    public void setNaviSapas(List<XPFacilityInfo> list) {
        this.mNaviSapas = list;
    }

    public XPCruiseInfo getXPCruiseInfo() {
        return this.mXPCruiseInfo;
    }

    public void setXPCruiseInfo(XPCruiseInfo xPCruiseInfo) {
        this.mXPCruiseInfo = xPCruiseInfo;
    }

    public XPLaneInfo getCruiseLaneInfo() {
        return this.mCruiseLaneInfo;
    }

    public void setCruiseLaneInfo(XPLaneInfo xPLaneInfo) {
        this.mCruiseLaneInfo = xPLaneInfo;
    }

    public XPCruiseCongestionInfo getCruiseCongestionInfo() {
        return this.mCruiseCongestionInfo;
    }

    public void setCruiseCongestionInfo(XPCruiseCongestionInfo xPCruiseCongestionInfo) {
        this.mCruiseCongestionInfo = xPCruiseCongestionInfo;
    }

    public XPTollGateInfo getXPTollGateInfo() {
        return this.mXPTollGateInfo;
    }

    public void setXPTollGateInfo(XPTollGateInfo xPTollGateInfo) {
        this.mXPTollGateInfo = xPTollGateInfo;
    }

    public List<ILightBarInfo> getLightBarInfos() {
        return this.mLightBarInfos;
    }

    public void setLightBarInfos(List<ILightBarInfo> list) {
        this.mLightBarInfos = list;
    }

    public int getLightBarPassedIndex() {
        return this.mLightBarPassedIndex;
    }

    public void setLightBarPassedIndex(int i) {
        this.mLightBarPassedIndex = i;
    }

    public List<XPPathTrafficEventInfo> getPathTrafficEventInfos() {
        return this.mPathTrafficEventInfos;
    }

    public void setPathTrafficEventInfos(List<XPPathTrafficEventInfo> list) {
        this.mPathTrafficEventInfos = list;
    }

    public XPRouteTrafficEventInfo getRouteTrafficEventInfo() {
        return this.mRouteTrafficEventInfo;
    }

    public void setRouteTrafficEventInfo(XPRouteTrafficEventInfo xPRouteTrafficEventInfo) {
        this.mRouteTrafficEventInfo = xPRouteTrafficEventInfo;
    }

    public XPTrafficEventInfo getCurrentTrafficEventInfo(int i) {
        XPPathTrafficEventInfo xPPathTrafficEventInfo;
        if (CollectionUtils.isEmpty(this.mPathTrafficEventInfos) || (xPPathTrafficEventInfo = this.mPathTrafficEventInfos.get(0)) == null || CollectionUtils.isEmpty(xPPathTrafficEventInfo.mEventInfoArray)) {
            return null;
        }
        for (XPTrafficEventInfo xPTrafficEventInfo : xPPathTrafficEventInfo.mEventInfoArray) {
            if (xPTrafficEventInfo != null && i == xPTrafficEventInfo.mId) {
                return xPTrafficEventInfo;
            }
        }
        return null;
    }

    public int getSRTrafficEventType() {
        return this.mSRTrafficEventType;
    }

    public void setSRTrafficEventType(int i) {
        this.mSRTrafficEventType = i;
    }

    public int getCurrentRoadSpeed() {
        return this.mCurrentRoadSpeed;
    }

    public void setCurrentRoadSpeed(int i) {
        this.mCurrentRoadSpeed = i;
    }

    public int getCurrentCameraSpeed() {
        return this.mCurrentCameraSpeed;
    }

    public void setCurrentCameraSpeed(int i) {
        this.mCurrentCameraSpeed = i;
    }

    public int getCurrentCameraDist() {
        return this.mCurrentCameraDist;
    }

    public void setCurrentCameraDist(int i) {
        this.mCurrentCameraDist = i;
    }
}
