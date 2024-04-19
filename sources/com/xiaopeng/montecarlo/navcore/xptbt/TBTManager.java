package com.xiaopeng.montecarlo.navcore.xptbt;

import android.app.Application;
import android.content.Intent;
import android.os.SystemProperties;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.aosclient.BLAosServiceManager;
import com.autonavi.gbl.common.model.TbtCommonControl;
import com.autonavi.gbl.common.model.UserConfig;
import com.autonavi.gbl.common.model.WorkPath;
import com.autonavi.gbl.layer.model.BizRouteType;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.model.PathMatchInfo;
import com.autonavi.gbl.pos.model.LocInfo;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.irdeto.securesdk.core.SSUtils;
import com.xiaopeng.lib.utils.view.ToastUtils;
import com.xiaopeng.montecarlo.navcore.adasehp.EHPServiceManager;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.location.XPLocInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPSearchRoadId;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.location.DRServiceManager;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IMapDelegate;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener;
import com.xiaopeng.montecarlo.navcore.powerdistance.PowerDistanceManager;
import com.xiaopeng.montecarlo.navcore.powerdistance.navi.NaviPowerDisHelperContainer;
import com.xiaopeng.montecarlo.navcore.powerdistance.route.RoutePowerDisHelper;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.GuideManager;
import com.xiaopeng.montecarlo.navcore.xptbt.PosServiceWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.RouteManager;
import com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.ICMNavigationInfoUpload;
import com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.INavigationInfoUploadStrategy;
import com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.XUINavigationInfoUpload;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.INaviPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPAsyncInfo;
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
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPOddInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTollGateInfo;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.theme.ThemeType;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.LocationDataUploader;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class TBTManager {
    public static final int CRUISE_STATUS = 0;
    public static final int EXIT_GUIDE_STATUS = 3;
    public static final int EXPLORE_STATUS = 2;
    public static final int MAX_BL_VIA_SIZE = 12;
    public static final int MAX_CHARGE_VIA_SIZE = 9;
    public static final int MAX_VISIBLE_VIA_SIZE = 3;
    public static final int NAVIGATION_STATUS = 1;
    public static final int NAVI_ASYNC_MANEUVERICON_HEIGHT = 90;
    public static final int NAVI_ASYNC_MANEUVERICON_WIDTH = 90;
    private static final String SYSTEM_PRODUCT_MODEL = "ro.product.model";
    private static final String XPENG_DEVICE_NAME = "XPEV";
    private static final String XPENG_MANUFACTURER_NAME = "Xpeng Motors";
    private BatteryPreHeatHelper mBatteryPreHeatHelper;
    private BLAosServiceManager mBlAosServiceManager;
    private CarServiceManager mCarServiceManager;
    private volatile int mCurrentRoutePathIndex;
    private volatile long mCurrentRouteRequestId;
    private DRServiceManager mDRServiceManager;
    private GuideManager mGuideManager;
    private LocationDataUploader mLocationDataUploader;
    private IMapDelegate mMapDelegate;
    private long mNaviId;
    private CarLoc mOriginCarLocation;
    private PosServiceWrapper mPosServiceWrapper;
    private RouteAosResponseObserver mRouteAosResponseObserver;
    private RouteManager mRouteManager;
    private static final L.Tag TAG = new L.Tag("TBTManager");
    private static final L.Tag sTAG = new L.Tag("TBTManager");
    private static final TBTManager sInstance = new TBTManager();
    private int mMaxViaSize = 3;
    private boolean mSimulateGuidance = false;
    private volatile int mCurrentStatus = 0;
    private ThemeType mCurrentThemeType = ThemeType.DEFAULT_THEME_TYPE;
    private boolean mIsInit = false;
    private boolean mSRLevel = false;
    private boolean mIsNeedMiniMap = false;
    private boolean mNavRestoreTimerOpen = false;

    public void clearEagleyeRoute() {
    }

    private TBTManager() {
    }

    @NonNull
    public static TBTManager getInstance() {
        return sInstance;
    }

    public boolean init(@NonNull Application application, boolean z) {
        if (this.mPosServiceWrapper == null) {
            this.mPosServiceWrapper = new PosServiceWrapper();
        }
        if (this.mRouteManager == null) {
            this.mRouteManager = new RouteManager();
        }
        if (this.mGuideManager == null) {
            this.mGuideManager = new GuideManager();
        }
        if (this.mCarServiceManager == null) {
            this.mCarServiceManager = CarServiceManager.getInstance();
        }
        if (this.mLocationDataUploader == null) {
            this.mLocationDataUploader = new LocationDataUploader(application);
        }
        if (this.mDRServiceManager == null) {
            this.mDRServiceManager = DRServiceManager.getInstance();
        }
        initNavigationInfoUploadStrategy(this.mCarServiceManager.getCarType());
        if (this.mPosServiceWrapper.initPos(z, this.mCarServiceManager.getCarType(), CarFeatureManager.INSTANCE.isAutoPolitIMUEnable())) {
            if (!this.mDRServiceManager.isStart()) {
                this.mDRServiceManager.init(z, this.mPosServiceWrapper, this.mLocationDataUploader);
            }
            initTbtCommonComponent();
            if (this.mRouteManager.initRouteService() && this.mGuideManager.initGuideService(RootUtil.SD_CARD_DIR_GUIDE) && ServiceMgr.getServiceMgrInstance().bindPos2Guide(this.mPosServiceWrapper.getPosService(), this.mGuideManager.getGuideService()) == 0) {
                if (this.mBlAosServiceManager == null) {
                    this.mBlAosServiceManager = (BLAosServiceManager) ServiceMgr.getServiceMgrInstance().getBLService(14);
                }
                this.mBlAosServiceManager.networkChange(4);
                initAosServiceCarInfo();
                if (CarFeatureManager.INSTANCE.isBatteryPreHeatEnable()) {
                    this.mBatteryPreHeatHelper = new BatteryPreHeatHelper();
                    this.mBatteryPreHeatHelper.start();
                }
                this.mIsInit = true;
                return true;
            }
            return false;
        }
        return false;
    }

    private void initAosServiceCarInfo() {
        String str = SystemProperties.get(SYSTEM_PRODUCT_MODEL, this.mCarServiceManager.getHardwareCarType());
        L.Tag tag = sTAG;
        L.i(tag, "initAosServiceCarInfo manufacturer = Xpeng Motors device = XPEV model = " + str);
        BLAosServiceManager bLAosServiceManager = this.mBlAosServiceManager;
        if (bLAosServiceManager != null) {
            bLAosServiceManager.setCarInfo(str, XPENG_DEVICE_NAME, XPENG_MANUFACTURER_NAME);
        }
    }

    public void updateNetworkStatus(final int i) {
        WorkThreadUtil.getInstance().executeScheduledBusinessTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.TBTManager.1
            @Override // java.lang.Runnable
            public void run() {
                L.Tag tag = TBTManager.sTAG;
                L.i(tag, "updateNetworkStatus networkStatus = " + i);
                ServiceMgr.getServiceMgrInstance().networkChange(i);
                if (TBTManager.this.mBlAosServiceManager != null) {
                    TBTManager.this.mBlAosServiceManager.networkChange(i);
                }
                EHPServiceManager.getInstance().updateNetworkStatus(i);
            }
        }, 0L, TimeUnit.MILLISECONDS);
    }

    private void initTbtCommonComponent() {
        String str = RootUtil.SD_CARD_NAVI_PATH + File.separator;
        WorkPath workPath = new WorkPath();
        workPath.setCache(str + SSUtils.O00000o0);
        workPath.setNavi(str + "navi");
        workPath.setRes(str + "res");
        UserConfig userConfig = new UserConfig();
        userConfig.setDeviceID(NavCoreUtil.getDiu());
        userConfig.setUserBatch("0");
        TbtCommonControl tbtCommonControl = TbtCommonControl.getInstance();
        tbtCommonControl.init(workPath, userConfig);
        tbtCommonControl.setTBTResReader(new TBTResReaderImpl());
    }

    public void initAsyncInfoColor(int i, int i2, int i3) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.initAsyncInfoColor(i, i2, i3);
        }
    }

    public boolean isInit() {
        return this.mIsInit;
    }

    public int getManeuverBackColor() {
        return this.mGuideManager.getManeuverBackColor();
    }

    public int getManeuverRoadColor() {
        return this.mGuideManager.getManeuverRoadColor();
    }

    public int getManeuverArrowColor() {
        return this.mGuideManager.getManeuverArrowColor();
    }

    private void initNavigationInfoUploadStrategy(int i) {
        INavigationInfoUploadStrategy iCMNavigationInfoUpload;
        if (CarFeatureManager.INSTANCE.isXUIServiceInfoUploadEnable()) {
            iCMNavigationInfoUpload = new XUINavigationInfoUpload();
        } else {
            iCMNavigationInfoUpload = CarFeatureManager.INSTANCE.isICMInfoUploadEnable() ? new ICMNavigationInfoUpload() : null;
        }
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null && guideManager.getNavigationInfoUpload() == null) {
            this.mGuideManager.setNavigationInfoUpload(iCMNavigationInfoUpload);
        }
        if (iCMNavigationInfoUpload == null) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.-$$Lambda$TBTManager$dfTBmr8tXhzwMjxlCJ5ToggcNxA
                @Override // java.lang.Runnable
                public final void run() {
                    ToastUtils.showToast(ContextUtils.getContext(), "车型不确定，仪表协议须适配");
                }
            });
        }
    }

    public boolean isSimulateGuidance() {
        return this.mSimulateGuidance;
    }

    public void enableSimulateGuidance(boolean z) {
        this.mSimulateGuidance = z;
    }

    public boolean isNavRestoreTimerOpen() {
        return this.mNavRestoreTimerOpen;
    }

    public void setNavRestoreTimerOpen(boolean z) {
        this.mNavRestoreTimerOpen = z;
    }

    public int getCurrentStatus() {
        return this.mCurrentStatus;
    }

    public synchronized void setCurrentStatus(int i) {
        if (this.mCurrentStatus == i) {
            return;
        }
        if (this.mGuideManager != null) {
            this.mGuideManager.updateTBTStatus(this.mCurrentStatus, i);
        }
        this.mCurrentStatus = i;
        L.Tag tag = TAG;
        L.i(tag, "update currentStatus to:" + this.mCurrentStatus);
    }

    public boolean isInNaviMode() {
        int currentStatus = getInstance().getCurrentStatus();
        return 1 == currentStatus || 2 == currentStatus;
    }

    public boolean isNaviStop() {
        return this.mGuideManager.isNaviStop();
    }

    public void addRouteListener(RouteManager.IRouteResultListener iRouteResultListener) {
        this.mRouteManager.addRouteListener(iRouteResultListener);
    }

    public void removeRouteListener(RouteManager.IRouteResultListener iRouteResultListener) {
        this.mRouteManager.removeRouteListener(iRouteResultListener);
    }

    public long requestRoute(RouteParams routeParams, RouteManager.IRouteResultListener iRouteResultListener) {
        return this.mRouteManager.requestRoute(routeParams, iRouteResultListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long requestRouteReroute(RouteParams routeParams, RouteManager.IRouteResultListener iRouteResultListener) {
        return this.mRouteManager.requestReroute(routeParams, iRouteResultListener);
    }

    public void cancelRequestRoute(long j) {
        this.mRouteManager.abortRoute(j);
    }

    public void setVehicleId(String str) {
        RouteManager routeManager = this.mRouteManager;
        if (routeManager != null) {
            routeManager.setVehicleId(str);
        }
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.setVehicleId(str);
        }
        L.Tag tag = sTAG;
        L.i(tag, "setVehicleId plate: " + str);
    }

    public void setETARestriction(boolean z) {
        RouteManager routeManager = this.mRouteManager;
        if (routeManager != null) {
            routeManager.setETARestriction(z);
        }
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.setETARestriction(z);
        }
        L.Tag tag = sTAG;
        L.i(tag, "setETARestriction isopen: " + z);
    }

    public RouteDataModel getRouteData(long j) {
        return this.mRouteManager.getRouteData(j);
    }

    public RouteResult getRouteResult(long j) {
        return this.mRouteManager.getRouteResult(j);
    }

    public IVariantPath getVariantPath(long j, int i) {
        return this.mRouteManager.getVariantPath(j, i);
    }

    public RouteResult.RouteInfo getRouteResultInfo(long j, long j2) {
        return this.mRouteManager.getRouteResultInfo(j, j2);
    }

    public List<XPOddInfo> getRouteOddInfos(long j, int i) {
        return this.mRouteManager.getRouteOddInfos(j, i);
    }

    public void clearRouteData(long j) {
        this.mRouteManager.clearRouteData(j);
    }

    public void clearAllRouteData() {
        this.mRouteManager.clearAllRouteData();
    }

    public List<XPViaPoint> getPassedViasPoiInfo(long j) {
        return this.mRouteManager.getPassedViasPoiInfos(j);
    }

    public List<XPViaPoint> getUnPassedViasPoiInfo(long j) {
        return this.mRouteManager.getUnPassedViasPoiInfos(j);
    }

    public void updateViaPass(long j, int i) {
        this.mRouteManager.updateViaPass(j, i);
    }

    public XPPoiInfo getStartInfo(long j) {
        return this.mRouteManager.getStartInfo(j);
    }

    public XPPoiInfo getEndInfo(long j) {
        return this.mRouteManager.getEndInfo(j);
    }

    public List<XPViaPoint> getViaInfos(long j) {
        return this.mRouteManager.getViaInfos(j);
    }

    public List<XPViaPoint> getChargeViaInfos(long j) {
        ArrayList arrayList = new ArrayList();
        for (XPViaPoint xPViaPoint : this.mRouteManager.getViaInfos(j)) {
            if (xPViaPoint.isChargeVia()) {
                arrayList.add(xPViaPoint);
            }
        }
        return arrayList;
    }

    public List<XPViaPoint> getUnPassedChargeViaInfos(long j) {
        ArrayList arrayList = new ArrayList();
        List<XPViaPoint> unPassedViasPoiInfos = this.mRouteManager.getUnPassedViasPoiInfos(j);
        if (unPassedViasPoiInfos != null) {
            for (XPViaPoint xPViaPoint : unPassedViasPoiInfos) {
                if (xPViaPoint.isChargeVia()) {
                    arrayList.add(xPViaPoint);
                }
            }
        }
        return arrayList;
    }

    public XPCoordinate2DDouble getRouteLastPoint(long j, int i) {
        return this.mRouteManager.getRouteLastPoint(j, i);
    }

    public int getRouteType(long j) {
        return this.mRouteManager.getRouteType(j);
    }

    public IPathResult getRoutePathResult(long j) {
        return this.mRouteManager.getRoutePathResult(j);
    }

    public boolean isRouting() {
        RouteManager routeManager = this.mRouteManager;
        return (routeManager == null || routeManager.getRouteState() == 0) ? false : true;
    }

    public boolean isRouting(long j) {
        return this.mRouteManager.isRouting(j);
    }

    public RouteParams getRouteParams(long j) {
        return this.mRouteManager.getRouteParams(j);
    }

    public int getSegmentLength(IVariantPath iVariantPath, long j) {
        return this.mRouteManager.getSegmentLength(iVariantPath, j);
    }

    public int getSegmentFormway(IVariantPath iVariantPath, long j, long j2) {
        return this.mRouteManager.getSegmentFormway(iVariantPath, j, j2);
    }

    public List<XPCoordinate2DDouble> getCurrentRoutePoints() {
        RouteManager routeManager = this.mRouteManager;
        if (routeManager != null) {
            return routeManager.getCurrentRoutePoints();
        }
        return null;
    }

    public List<XPCoordinate2DDouble> getCurrentRouteAllPoints() {
        RouteManager routeManager = this.mRouteManager;
        if (routeManager != null) {
            return routeManager.getCurrentRouteAllPoints();
        }
        return null;
    }

    public XPSearchRoadId[] getCurrentRoadIds() {
        RouteManager routeManager = this.mRouteManager;
        if (routeManager != null) {
            return routeManager.getCurrentRoadIds();
        }
        return null;
    }

    public void addRerouteListener(GuideManager.IRerouteListener iRerouteListener) {
        this.mGuideManager.addRerouteListener(iRerouteListener);
    }

    public void removeRerouteListener(GuideManager.IRerouteListener iRerouteListener) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.removeRerouteListener(iRerouteListener);
        }
    }

    public void addCruiseListener(ICruiseListener iCruiseListener) {
        this.mGuideManager.addCruiseListener(iCruiseListener);
    }

    public void removeCruiseListener(ICruiseListener iCruiseListener) {
        this.mGuideManager.removeCruiseListener(iCruiseListener);
    }

    public void addNaviListener(INaviListener iNaviListener) {
        this.mGuideManager.addNaviListener(iNaviListener);
    }

    public void removeNaviListener(INaviListener iNaviListener) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.removeNaviListener(iNaviListener);
        }
    }

    public void addSoundPlayListener(ISoundPlayListener iSoundPlayListener) {
        this.mGuideManager.addSoundPlayListener(iSoundPlayListener);
    }

    public void removeSoundPlayListener(ISoundPlayListener iSoundPlayListener) {
        this.mGuideManager.removeSoundPlayListener(iSoundPlayListener);
    }

    public void restoreNavi(int i, boolean z, RouteManager.IRestoreListener iRestoreListener) {
        this.mRouteManager.restoreNavi(i, z, iRestoreListener);
    }

    public long requestReroute(RouteParams routeParams, GuideManager.IRerouteListener iRerouteListener) {
        return this.mGuideManager.requestReroute(routeParams, iRerouteListener);
    }

    public RouteParams getRestoreRouteParams() {
        return this.mGuideManager.getRestoreRouteParams();
    }

    public void setRestoreRouteParams(RouteParams routeParams) {
        this.mGuideManager.setRestoreRouteParams(routeParams);
    }

    public void saveCurrentRouteHistory() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.saveCurrentRouteHistory();
        }
    }

    public void clearRouteParams() {
        this.mGuideManager.removeRouteHistory();
    }

    public boolean isNeedRestoreRoute() {
        return this.mGuideManager.isNeedRestoreRoute();
    }

    public long getCurrentNaviId() {
        return this.mGuideManager.getCurrentNaviId();
    }

    public long getCurrentNaviPathId() {
        return this.mGuideManager.getCurrentNaviPathId();
    }

    public int getCurrentNaviPathIndex() {
        return this.mGuideManager.getCurrentNaviPathIndex();
    }

    public IPathResult getCurrentNaviPathResult() {
        return this.mGuideManager.getCurrentNaviPathResult();
    }

    public IPathResult getRecommendNaviPathResult() {
        return this.mGuideManager.getRecommendNaviPathResult();
    }

    public IVariantPath getOldNaviVariantPath() {
        return this.mGuideManager.getOldNaviVariantPath();
    }

    public void clearRecommendPathResult() {
        this.mGuideManager.setRecommendNaviId(-1L);
    }

    public long getRecommendNaviId() {
        return this.mGuideManager.getRecommendNaviId();
    }

    public void resetNaviData() {
        this.mGuideManager.reset();
    }

    public void updateCarLocIcon() {
        IMapDelegate iMapDelegate = this.mMapDelegate;
        if (iMapDelegate != null) {
            iMapDelegate.updateCarLocIcon();
        }
        if (isMiniMapEnable()) {
            Intent intent = new Intent();
            intent.setClassName(ContextUtils.getContext().getPackageName(), "com.xiaopeng.montecarlo.service.minimap.MiniMapService");
            intent.setAction("com.xiaopeng.montecarlo.minimap.ACTION_CAR_ICON_CHANGE");
            ContextUtils.getContext().startService(intent);
            L.i(sTAG, "MiniMapService startService ACTION_CAR_ICON_CHANGE in updateCarLocIcon tbtmanager");
        }
    }

    public void startCruise(int i) {
        startCruise(i, true);
    }

    public void startCruise(int i, boolean z) {
        IMapDelegate iMapDelegate = this.mMapDelegate;
        if (iMapDelegate != null) {
            iMapDelegate.initCruiseCar(i, z);
        }
        startCruise();
    }

    public void startCruise() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.stopNavi(false);
            setEhpConfigValue(true);
            this.mGuideManager.startNavi(2);
            setCurrentStatus(0);
            this.mCurrentRouteRequestId = -1L;
            this.mCurrentRoutePathIndex = 0;
            getInstance().setCruiseAheadTraffic(SettingWrapper.isCruiseAheadTraffict());
            PowerDistanceManager.getInstance().clearKValue();
            if (CarFeatureManager.INSTANCE.isCurrentRoadSpeedLimitOn()) {
                WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.TBTManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CarServiceManager.getInstance().isD22()) {
                            CarServiceManager.getInstance().setIntelligentSpeedLimitValue(31);
                        } else {
                            CarServiceManager.getInstance().setCurrentRoadSpeedLimit(0);
                        }
                    }
                });
            }
        }
    }

    public void startNavi(long j, int i, int i2, int i3, boolean z) {
        if (this.mGuideManager == null) {
            return;
        }
        RouteDataModel routeData = getRouteData(j);
        XPCoordinate2DDouble currentLocation = this.mPosServiceWrapper.getCurrentLocation();
        PathMatchInfo pathMatchInfo = new PathMatchInfo();
        pathMatchInfo.longitude = currentLocation.mLon;
        pathMatchInfo.latitude = currentLocation.mLat;
        ArrayList arrayList = new ArrayList();
        arrayList.add(pathMatchInfo);
        this.mOriginCarLocation = new CarLoc(0, 0L, arrayList);
        if (routeData == null || routeData.mRouteResult == null) {
            return;
        }
        this.mGuideManager.stopNavi(false);
        this.mGuideManager.getRecommendParkingHelper().onStopNavi();
        this.mGuideManager.needWaitGuideEndTTS();
        this.mGuideManager.setCurrentNaviId(j, routeData.mRouteResult.mRouteType);
        EHPServiceManager.getInstance().setAutoUpdateRoute(true);
        this.mGuideManager.updatePathIndex(i);
        this.mGuideManager.setNaviPath(i);
        initNaviCar(i2, i3);
        if (this.mSimulateGuidance) {
            this.mGuideManager.startNavi(1);
        } else {
            this.mGuideManager.startNavi(0);
        }
        setCurrentStatus(i3);
        this.mGuideManager.getRecommendParkingHelper().onNaviStart();
        this.mGuideManager.saveCurrentRouteHistory();
        if (z) {
            return;
        }
        List<XPViaPoint> passedViasPoiInfo = getInstance().getPassedViasPoiInfo(j);
        getInstance().setLastPassedIndexDiff(passedViasPoiInfo != null ? passedViasPoiInfo.size() : 0);
    }

    public void setEhpConfigValue(boolean z) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.setEhpConfigValue(z);
        }
    }

    public void initNaviCar(int i, int i2) {
        IMapDelegate iMapDelegate = this.mMapDelegate;
        if (iMapDelegate != null) {
            if (this.mSimulateGuidance) {
                iMapDelegate.initNaviCar(4, i);
                return;
            }
            iMapDelegate.initNaviCar(5, i);
            IMapDelegate iMapDelegate2 = this.mMapDelegate;
            boolean z = true;
            if (i2 != 2 && (i2 != 1 || !SettingWrapper.isOpenRadar())) {
                z = false;
            }
            iMapDelegate2.setBizRouteOverlayVisible(BizRouteType.BizRouteTypeGuideLabel, z);
        }
    }

    public void stopNavi(boolean z) {
        if (this.mGuideManager != null) {
            if (3 == this.mCurrentStatus) {
                this.mGuideManager.lambda$postNaviStop$0$GuideManager(isSimulateGuidance() ? 1 : 0, false);
            } else if (this.mCurrentStatus != 0) {
                setCurrentStatus(0);
                this.mGuideManager.stopNaviByUser(z);
            }
        }
    }

    public XPPoiInfo getLastNaviEndInfo() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            return guideManager.getLastNaviEndInfo();
        }
        return null;
    }

    public void resetLastNaviEndInfo() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.resetLastNaviEndInfo();
        }
    }

    public XPPoiInfo getLastEndInfoForDataLog() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            return guideManager.getLastEndInfoForDataLog();
        }
        return null;
    }

    public float getRouteRemainDistForDataLog() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            return guideManager.getRouteRemainDistForDataLog();
        }
        return 0.0f;
    }

    public void startRoute(int i) {
        IMapDelegate iMapDelegate = this.mMapDelegate;
        if (iMapDelegate != null) {
            iMapDelegate.initRouteCar(i);
        }
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.stopNavi(false);
        }
    }

    public void setCurrentNaviId(long j, int i) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.setCurrentNaviId(j, i);
        }
    }

    public void updatePathIndex(int i) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.updatePathIndex(i);
        }
    }

    public void asyncManeuverInfo(XPAsyncInfo xPAsyncInfo) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.asyncManeuverInfo(xPAsyncInfo);
        }
    }

    public void asyncManeuverInfo(XPManeuverInfo xPManeuverInfo) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.asyncManeuverInfo(xPManeuverInfo);
        }
    }

    public void playNaviManual() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.playNaviManual();
        }
    }

    public void selectMainPathId(long j) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.selectMainPathId(j);
        }
    }

    public void resumeSimulation() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.resumeSimulation();
        }
    }

    public void pauseSimulation() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.pauseSimulation();
        }
    }

    public void adjustSimulation(boolean z) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.adjustSimulation(z);
        }
    }

    public int getSimulationSpeed() {
        if (!isSimulateGuidance() || this.mGuideManager == null || this.mCurrentStatus == 0) {
            return 0;
        }
        return this.mGuideManager.getSimulationSpeed();
    }

    public void setNaviInfoCount(int i) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.setNaviInfoCount(i);
        }
    }

    public void setCruiseAheadTraffic(boolean z) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.setCruiseAheadTraffic(z);
        }
    }

    public void setCruiseOpenCamera(int i) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.setCruiseOpenCamera(i);
        }
    }

    public void setPlayStyle(int i) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.setPlayStyle(i);
        }
    }

    public void setDayNightMode(int i) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.setDayNightMode(i);
        }
    }

    public void setEnter3D(boolean z) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.setEnter3D(z);
        }
    }

    public int getRecommendParkingNum() {
        if (getRecommendParkingHelper() != null) {
            if (L.ENABLE) {
                L.Tag tag = sTAG;
                L.d(tag, "RecommendParkingNum  is " + getRecommendParkingHelper().getRecommendParkingNum());
            }
            return getRecommendParkingHelper().getRecommendParkingNum();
        } else if (L.ENABLE) {
            L.d(sTAG, "RecommendParkingHelper  is  null");
            return 0;
        } else {
            return 0;
        }
    }

    public INaviPath getNaviPath() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            return guideManager.getNaviPath();
        }
        return null;
    }

    public void setNaviPath(int i) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.setNaviPath(i);
        }
    }

    public IVariantPath getCurrentNaviVariantPath() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            return guideManager.getCurrentVariantPath();
        }
        return null;
    }

    public XPNaviInfo getNaviInfo() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            return guideManager.getNaviInfo();
        }
        return null;
    }

    public XPNaviInfo getNaviInfo(long j) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            return guideManager.getNaviInfo(j);
        }
        return null;
    }

    public List<XPCameraInfo> getNaviCamera() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            return guideManager.getNaviCamera();
        }
        return null;
    }

    public long getParallelRoadId() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager == null) {
            return 0L;
        }
        return guideManager.getParallelRoadId();
    }

    public void setParallelRoadId(long j) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager == null) {
            return;
        }
        guideManager.setParallelRoadId(j);
    }

    public int getLastPassedIndexDiff() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager == null) {
            return 0;
        }
        return guideManager.getLastPassedIndexDiff();
    }

    public void setLastPassedIndexDiff(int i) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.setLastPassedIndexDiff(i);
        }
    }

    public XPManeuverInfo getNaviManeuverInfo() {
        return this.mGuideManager.getNaviManeuverInfo();
    }

    public XPCrossImageInfo getNaviCrossImageInfo() {
        return this.mGuideManager.getNaviCrossImageInfo();
    }

    public void hideNaviCrossImage(int i) {
        this.mGuideManager.onUpdateCrossImage(null, i, false);
    }

    public XPExitDirectionInfo getNaviExitDirectionInfo() {
        return this.mGuideManager.getNaviExitDirectionInfo();
    }

    public void setNaviExitDirectionInfo(XPExitDirectionInfo xPExitDirectionInfo) {
        this.mGuideManager.setNaviExitDirectionInfo(xPExitDirectionInfo);
    }

    public XPLaneInfo getNaviLaneInfo() {
        return this.mGuideManager.getNaviLaneInfo();
    }

    public XPTollGateInfo getXPTollGateInfo() {
        return this.mGuideManager.getXPTollGateInfo();
    }

    public List<XPCameraInfo> getNaviIntervalCameras() {
        return this.mGuideManager.getNaviIntervalCameras();
    }

    public List<XPCameraInfo> getNaviIntervalDynamicCameras() {
        return this.mGuideManager.getNaviIntervalDynamicCameras();
    }

    public XPNaviCongestionInfo getNaviCongestionInfo() {
        return this.mGuideManager.getNaviCongestionInfo();
    }

    public XPCruiseCongestionInfo getCruiseCongestionInfo() {
        return this.mGuideManager.getCruiseCongestionInfo();
    }

    public ConcurrentHashMap<Long, NaviPowerDisHelperContainer.NaviPowerDisData> getNaviRemainDisMap() {
        return this.mGuideManager.getNaviRemainDisMap();
    }

    public RouteParams getCurrentNaviRouteParams() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager == null) {
            return null;
        }
        return guideManager.getCurrentRouteParams();
    }

    @Nullable
    public RecommendParkingHelper getRecommendParkingHelper() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            return guideManager.getRecommendParkingHelper();
        }
        return null;
    }

    public int getPassingViaIndex() {
        RouteParams currentNaviRouteParams;
        if (this.mGuideManager == null || (currentNaviRouteParams = getCurrentNaviRouteParams()) == null) {
            return -1;
        }
        List<XPViaPoint> list = currentNaviRouteParams.mViaInfos;
        if (CollectionUtils.isNotEmpty(list)) {
            for (int lastPassedIndexDiff = getInstance().getLastPassedIndexDiff(); lastPassedIndexDiff < list.size(); lastPassedIndexDiff++) {
                if (!list.get(lastPassedIndexDiff).getIsPassedVia()) {
                    return lastPassedIndexDiff;
                }
            }
            return -1;
        }
        return -1;
    }

    public void getViaRemain(int i, OnUpdateRemainDisListener onUpdateRemainDisListener) {
        int passingViaIndex = getPassingViaIndex();
        RouteParams currentNaviRouteParams = getCurrentNaviRouteParams();
        if (i < passingViaIndex || currentNaviRouteParams == null || !CollectionUtils.isIndexLegal(i, currentNaviRouteParams.mViaInfos)) {
            return;
        }
        XPNaviInfo naviInfo = getInstance().getNaviInfo();
        IVariantPath currentNaviVariantPath = getInstance().getCurrentNaviVariantPath();
        IPathResult currentNaviPathResult = getInstance().getCurrentNaviPathResult();
        int i2 = i - passingViaIndex;
        if (naviInfo == null || CollectionUtils.isEmpty(naviInfo.mViaRemainDist) || i2 >= naviInfo.mViaRemainDist.length || currentNaviVariantPath == null || currentNaviPathResult == null) {
            return;
        }
        int i3 = naviInfo.mCurSegIdx;
        int i4 = naviInfo.mCurLinkIdx;
        int i5 = naviInfo.mViaRemainDist[i2];
        if (L.ENABLE) {
            L.Tag tag = sTAG;
            L.d(tag, " getViaRemain   viaIndex:" + i + "startSeq:" + i3 + " startLink:" + i4 + " disToTarget:" + i5);
        }
        new RoutePowerDisHelper(onUpdateRemainDisListener, false, true).updateRemainDis(i3, i4, i5, currentNaviVariantPath, currentNaviPathResult);
    }

    public void setMapDelegate(IMapDelegate iMapDelegate) {
        this.mMapDelegate = iMapDelegate;
    }

    public void removeRoute(int i, boolean z) {
        IMapDelegate iMapDelegate = this.mMapDelegate;
        if (iMapDelegate != null) {
            iMapDelegate.removeRoute(i, z);
        }
    }

    public void removeRouteCache(int i) {
        IMapDelegate iMapDelegate = this.mMapDelegate;
        if (iMapDelegate != null) {
            iMapDelegate.removeRouteCache(i);
        }
    }

    public void clearBizRouteOverlay(int i) {
        IMapDelegate iMapDelegate = this.mMapDelegate;
        if (iMapDelegate != null) {
            iMapDelegate.clearBizRouteOverlay(i);
        }
    }

    public int getMapMode() {
        IMapDelegate iMapDelegate = this.mMapDelegate;
        if (iMapDelegate != null) {
            return iMapDelegate.getMapMode();
        }
        return 0;
    }

    @NonNull
    public XPPoiInfo getStartPOIFromCurrent() {
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        XPCoordinate2DDouble currentLocation = getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation != null) {
            xPPoiInfo.setDisplayLat(currentLocation.mLat);
            xPPoiInfo.setDisplayLon(currentLocation.mLon);
            if (L.ENABLE) {
                L.Tag tag = sTAG;
                L.d(tag, "getStartPOIFromCurrent car location is " + currentLocation.mLat + ", " + currentLocation.mLon);
            }
        } else {
            xPPoiInfo.setDisplayLat(23.1595867537d);
            xPPoiInfo.setDisplayLon(113.3850753307d);
            L.w(sTAG, "car location is null");
        }
        xPPoiInfo.setType(0);
        return xPPoiInfo;
    }

    public LocInfo getCurrentLocInfo() {
        PosServiceWrapper posServiceWrapper = this.mPosServiceWrapper;
        if (posServiceWrapper != null) {
            return posServiceWrapper.getCurrentLocInfo();
        }
        return null;
    }

    public void setNavigationInfo(byte[] bArr) {
        CarServiceManager carServiceManager = this.mCarServiceManager;
        if (carServiceManager != null) {
            carServiceManager.setNavigationInfo(bArr);
        }
    }

    public PosServiceWrapper getPosServiceWrapper() {
        return this.mPosServiceWrapper;
    }

    public void setSignalRecordSwitch(boolean z) {
        PosServiceWrapper posServiceWrapper = this.mPosServiceWrapper;
        if (posServiceWrapper != null) {
            posServiceWrapper.setSignalRecordSwitch(z);
        }
    }

    public CarLoc getOriginCarLocation() {
        return this.mOriginCarLocation;
    }

    public boolean isHomeEndInfo(long j) {
        XPPoiInfo endInfo = this.mRouteManager.getEndInfo(j);
        return endInfo != null && FavoriteDataManager.getInstance().isHome(endInfo);
    }

    public boolean isCompanyEndInfo(long j) {
        XPPoiInfo endInfo = this.mRouteManager.getEndInfo(j);
        return endInfo != null && FavoriteDataManager.getInstance().isCompany(endInfo);
    }

    public float getCarSpeed() {
        CarServiceManager carServiceManager = this.mCarServiceManager;
        if (carServiceManager == null || this.mDRServiceManager == null) {
            return 0.0f;
        }
        if (carServiceManager.isCarServiceAvailable()) {
            return this.mCarServiceManager.getCarSpeed();
        }
        return this.mDRServiceManager.getCarSpeed();
    }

    public boolean isMiniMapEnable() {
        return CarFeatureManager.INSTANCE.isMiniMapEnable();
    }

    public XPPoiInfo generateStartPoint(XPCoordinate2DDouble xPCoordinate2DDouble) {
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        xPPoiInfo.setDisplayLat(xPCoordinate2DDouble.mLat);
        xPPoiInfo.setDisplayLon(xPCoordinate2DDouble.mLon);
        xPPoiInfo.setType(0);
        return xPPoiInfo;
    }

    public int getMaxViaSize() {
        return this.mMaxViaSize;
    }

    public void setMaxViaSize(int i) {
        if (i > 12) {
            i = 12;
        }
        if (i < 3) {
            i = 3;
        }
        this.mMaxViaSize = i;
    }

    public synchronized void updateCurrentRouteInfo(long j, int i) {
        this.mCurrentRouteRequestId = j;
        this.mCurrentRoutePathIndex = i;
        L.Tag tag = sTAG;
        L.i(tag, "updateCurrentRouteInfo mCurrentRouteRequestId:" + this.mCurrentRouteRequestId);
    }

    public synchronized long getCurrentRouteRequestId() {
        return this.mCurrentRouteRequestId;
    }

    public int getCurrentRoutePathIndex() {
        return this.mCurrentRoutePathIndex;
    }

    public boolean isExistRoute() {
        return this.mCurrentRouteRequestId != -1;
    }

    public List<XPFacilityInfo> getNaviSapas() {
        return this.mGuideManager.getNaviSapas();
    }

    public List<XPFacilityInfo> getXPFacilityInfos() {
        return this.mGuideManager.getXPFacilityInfos();
    }

    public XPCruiseInfo getXPCruiseInfo() {
        return this.mGuideManager.getXPCruiseInfo();
    }

    public void setXPCruiseInfo(XPCruiseInfo xPCruiseInfo) {
        this.mGuideManager.setXPCruiseInfo(xPCruiseInfo);
    }

    public XPLaneInfo getCruiseLaneInfo() {
        return this.mGuideManager.getCruiseLaneInfo();
    }

    public void updateNaviStopInfo() {
        this.mGuideManager.updateNaviStopInfo();
    }

    public void resetNaviInfo() {
        this.mGuideManager.resetNaviInfo();
    }

    public void updateSRInfo(boolean z) {
        this.mGuideManager.updateSRInfo(z);
    }

    public String getHighWayInfo() {
        return this.mGuideManager.getHighWayInfo();
    }

    public void addPosRoadIdChangedListener(PosServiceWrapper.IPosRoadChangedCallback iPosRoadChangedCallback) {
        this.mPosServiceWrapper.addPosRoadChangedListener(iPosRoadChangedCallback);
    }

    public void removePosRoadIdChangedListener(PosServiceWrapper.IPosRoadChangedCallback iPosRoadChangedCallback) {
        this.mPosServiceWrapper.removePosRoadChangedListener(iPosRoadChangedCallback);
    }

    public void setCurrentThemeType(ThemeType themeType) {
        if (L.ENABLE) {
            L.Tag tag = sTAG;
            L.d(tag, L.formatDayNightSwitchLog("setCurrentThemeType themeType:" + themeType));
        }
        this.mCurrentThemeType = themeType;
    }

    public boolean isDayMode() {
        return this.mCurrentThemeType.isDayMode();
    }

    public void onSwitchTheme(ThemeType themeType) {
        this.mCurrentThemeType = themeType;
        XPManeuverInfo naviManeuverInfo = getNaviManeuverInfo();
        if (naviManeuverInfo != null) {
            if (L.ENABLE) {
                L.Tag tag = sTAG;
                L.d(tag, ">>>> onSwitchTheme maneuverInfo id=" + naviManeuverInfo.mManeuverID);
            }
            asyncManeuverInfo(naviManeuverInfo);
        }
    }

    public boolean isNeedMiniMap() {
        return this.mIsNeedMiniMap;
    }

    public void setIsNeedMinimap(boolean z) {
        this.mIsNeedMiniMap = z;
    }

    public void updateLocInfo(XPLocInfo xPLocInfo) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            guideManager.updateLocInfo(xPLocInfo);
        }
    }

    public void clearCalibrationAndReboot() {
        PosServiceWrapper posServiceWrapper = this.mPosServiceWrapper;
        if (posServiceWrapper != null) {
            posServiceWrapper.clearCalibrationAndReboot();
        }
    }

    public ILightBarInfo getLightBarInfo(long j) {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            return guideManager.getLightBarInfo(j);
        }
        return null;
    }

    public MapViewWrapper getMap() {
        IMapDelegate iMapDelegate = this.mMapDelegate;
        if (iMapDelegate != null) {
            return iMapDelegate.getMapView();
        }
        return null;
    }

    public boolean isLaneMode() {
        MapViewWrapper map = getMap();
        return map != null && map.isLaneMode();
    }

    public int getLightBarPassedIndex() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            return guideManager.getLightBarPassedIndex();
        }
        return 0;
    }

    public int getSRTrafficEventType() {
        GuideManager guideManager = this.mGuideManager;
        if (guideManager != null) {
            return guideManager.getSRTrafficEventType();
        }
        return 0;
    }

    public void swtichSensor(boolean z) {
        DRServiceManager dRServiceManager = this.mDRServiceManager;
        if (dRServiceManager != null) {
            dRServiceManager.switchSensor(z);
        }
    }

    public boolean isIMUSensorInDR() {
        DRServiceManager dRServiceManager = this.mDRServiceManager;
        if (dRServiceManager != null) {
            return dRServiceManager.isImuSensor();
        }
        L.w(sTAG, "DRServiceManager is not initalized");
        return false;
    }

    public long getNaviId() {
        return this.mNaviId;
    }

    public void setNaviId(long j) {
        this.mNaviId = j;
    }

    public void enableSRLevel(boolean z) {
        this.mSRLevel = z;
    }

    public boolean isSRLevel() {
        return this.mSRLevel;
    }

    public boolean is3DCrossShow() {
        MapViewWrapper map = getMap();
        if (map == null || map.getBizControlManager() == null) {
            return false;
        }
        return getMap().getBizControlManager().is3DCrossShow();
    }
}
