package com.xiaopeng.montecarlo.scenes.navi.guidescene;

import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.path.model.RouteLimitInfo;
import com.autonavi.gbl.layer.GuideLabelLayerItem;
import com.autonavi.gbl.layer.GuideTrafficEventLayerItem;
import com.autonavi.gbl.layer.RouteTrafficEventTipsLayerItem;
import com.autonavi.gbl.layer.model.BizAGroupBusinessInfo;
import com.autonavi.gbl.layer.model.BizSearchType;
import com.autonavi.gbl.layer.model.RouteTrafficEventTipsPoint;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.PointLayerItem;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.model.ClickViewIdInfo;
import com.autonavi.gbl.map.layer.model.PathMatchInfo;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelHelper;
import com.xiaopeng.montecarlo.dynamiclevel.guide.GuideDynamicLevelHelper;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
import com.xiaopeng.montecarlo.navcore.event.AIRecommendParkEvent;
import com.xiaopeng.montecarlo.navcore.event.GuideWrapperNaviEvent;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IXpLayerClickObserver;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.setting.SettingBLManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.speech.aios.NaviModel;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.tts.TTSProxy;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import com.xiaopeng.montecarlo.navcore.util.CalculatePreviewUtil;
import com.xiaopeng.montecarlo.navcore.util.TBTUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.BLDataModelUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.RecommendParkingHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.OddDataHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTollGateInfo;
import com.xiaopeng.montecarlo.navresetore.NavRestoreManager;
import com.xiaopeng.montecarlo.root.account.AccountEventCallback;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.DebugCacheConsts;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.config.Configuration;
import com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.IRecommendParkingListener;
import com.xiaopeng.montecarlo.scenes.navi.NaviMapDecoratorRouteUpdateListener;
import com.xiaopeng.montecarlo.scenes.navi.NaviParallelRoadEventHandler;
import com.xiaopeng.montecarlo.scenes.navi.NaviPresenterData;
import com.xiaopeng.montecarlo.scenes.navi.NaviPresenterListener;
import com.xiaopeng.montecarlo.scenes.navi.NaviRestrictEventCallback;
import com.xiaopeng.montecarlo.scenes.navi.NaviRouteUpdateContractImpl;
import com.xiaopeng.montecarlo.scenes.navi.SRNaviListener;
import com.xiaopeng.montecarlo.scenes.navi.SRViewAngleOperator;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.SapaChargeDataHelper;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.sapa.SapaData;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.stat.MapOpStatUtil;
import com.xiaopeng.montecarlo.stat.NaviStatUtil;
import com.xiaopeng.montecarlo.util.MapUtil;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes3.dex */
public class NaviScenePresenter extends BaseNaviPresenter<INaviContract.LogicView> implements INaviContract.Presenter {
    public static final int CAR_MOVE_DISTANCE = 50;
    public static final int GUIDE_MODE_NORMAL = 0;
    public static final int GUIDE_MODE_OVERVIEW = 1;
    private static final L.Tag TAG = new L.Tag("NaviScenePresenter");
    private AccountEventCallback mAccountEventCallback;
    private int mCurrentMode;
    @VisibleForTesting
    protected DynamicLevelHelper mDynamicLevelHelper;
    private boolean mIsLastRadarOpen;
    private boolean mIsOfflineReroute;
    private long mLastPathID;
    private int mLastRecommendFocusedIndex;
    private XPPoiInfo mOldcurrentPoi;
    @VisibleForTesting
    protected ArrayList<BizAGroupBusinessInfo> mRecommendParkData;
    SRViewAngleOperator mSRViewAngleOperator;
    private SapaChargeDataHelper mSapaChargeDataHelper;
    private List<SapaData> mSapaDataList;
    CarServiceManager.IXPCarStateListener mXPCarStateListener;

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    protected int getTBTStatus() {
        return 1;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter, com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
    }

    public boolean isEagleEyeViewSettingEnabled() {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter, com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onDestroy() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter, com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
    }

    public void updateEagleViewMode(boolean z) {
    }

    public NaviScenePresenter(INaviContract.LogicView logicView) {
        super(logicView);
        this.mLastRecommendFocusedIndex = 0;
        this.mSRViewAngleOperator = null;
        this.mSapaChargeDataHelper = new SapaChargeDataHelper(new SapaChargeDataHelper.SapaChargeListener() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter.1
            @Override // com.xiaopeng.montecarlo.scenes.navi.guidescene.SapaChargeDataHelper.SapaChargeListener
            public void onChargeInfoUpdate() {
                NaviScenePresenter.this.getLogicView().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CollectionUtils.isEmpty(NaviScenePresenter.this.mSapaDataList)) {
                            return;
                        }
                        for (SapaData sapaData : NaviScenePresenter.this.mSapaDataList) {
                            SapaData cache = NaviScenePresenter.this.mSapaChargeDataHelper.getCache(sapaData.mXPFacilityInfo.mName);
                            if (cache != null) {
                                sapaData.mCharegeInfo = cache.mCharegeInfo;
                            }
                        }
                    }
                });
            }
        });
        this.mAccountEventCallback = new AccountEventCallback() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter.2
            @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
            public void accountSyncFinish() {
            }

            @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
            public void amapQuickLogin() {
            }

            @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
            public void initAccountFinish() {
            }

            @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
            public void xpMapLogin() {
            }

            @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
            public void refreshSettingInfos(int i, int i2) {
                if (NaviUtil.isNeedReroute(i, i2)) {
                    NaviScenePresenter.this.requestReroute(3, 1, true);
                }
            }
        };
        this.mXPCarStateListener = new AnonymousClass3();
        getLogicView().setPresenter(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass3 implements CarServiceManager.IXPCarStateListener {
        AnonymousClass3() {
        }

        public /* synthetic */ void lambda$onXPolitDriveModeStatusChange$0$NaviScenePresenter$3() {
            NaviScenePresenter.this.updateAccSpeed(SRNaviManager.getInstance().getCruiseSpeed());
        }

        @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
        public void onXPolitDriveModeStatusChange(CarServiceManager.XPolitDriveMode xPolitDriveMode) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$NaviScenePresenter$3$JgEEvGLDbJhOyisMmw5cGKb_lac
                @Override // java.lang.Runnable
                public final void run() {
                    NaviScenePresenter.AnonymousClass3.this.lambda$onXPolitDriveModeStatusChange$0$NaviScenePresenter$3();
                }
            });
        }
    }

    public void create() {
        getLogicView().initView();
        this.mSRViewAngleOperator = new SRViewAngleOperator(getLogicView().getMainContext());
        registerAccountEventCallback();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviPresenter
    public void onViewCreated(@NonNull NaviPresenterData naviPresenterData) {
        this.mDynamicLevelHelper = new GuideDynamicLevelHelper(getMapView());
        updateOverlayObserver(true, BizControlWrapper.BIZ_CONTROL_TYPE_SEARCH);
        EventBus.getDefault().register(this);
        NavRestoreManager.getInstance().addRestoreListener(this);
        TBTManager.getInstance().addRerouteListener(getRerouteListener());
        TBTManager.getInstance().addNaviListener(getNaviListener());
        SRNaviManager.getInstance().addSRInfoChangedListener(getSRInfoChangedListener());
        OddDataHelper.getInstance().addUpdateOddInfoListener(this);
        CarServiceManager.getInstance().addCarStateListener(this.mXPCarStateListener);
        if (naviPresenterData.getIsNeedTTSProxySpeak()) {
            TTSProxy.getInstance().shutUp(null);
            TTSProxy.getInstance().speak(ContextUtils.getString(R.string.explore_start_navi), null);
        }
        if (naviPresenterData.getIsFirstEnter()) {
            if (naviPresenterData.getRouteRequest() != null) {
                requestReroute(naviPresenterData.getRouteRequest(), naviPresenterData.getRequestType() > -1 ? naviPresenterData.getRequestType() : 0, naviPresenterData.getIsFilterCharge());
            } else {
                startTbt(naviPresenterData.getIsNeedStartNavi(), naviPresenterData.getIsManual(), naviPresenterData.getNaviId(), naviPresenterData.getPathIndex());
                RouteParams currentNaviRouteParams = TBTManager.getInstance().getCurrentNaviRouteParams();
                r1 = currentNaviRouteParams != null ? currentNaviRouteParams.mCurRequestIsOnline : true;
                if (naviPresenterData.getOfflineRemainCount() != -1) {
                    updateOfflineRouteTryCount(naviPresenterData.getOfflineRemainCount());
                    getLogicView().initOfflineRoutePanel(naviPresenterData.getOfflineRemainCount());
                } else if (!r1) {
                    updateOfflineRouteTryCount(0);
                    getLogicView().initOfflineRoutePanel(0);
                }
            }
        } else if (TBTManager.getInstance().isNaviStop()) {
            resetWhenNoNavi();
            return;
        } else {
            RouteRequest routeRequest = naviPresenterData.getRouteRequest();
            if (routeRequest != null && routeRequest.getRequestFrom() == 1) {
                handleVoiceNaviAfterRestore(naviPresenterData);
            } else {
                restoreInit();
            }
            RouteParams currentNaviRouteParams2 = TBTManager.getInstance().getCurrentNaviRouteParams();
            r1 = currentNaviRouteParams2 != null ? currentNaviRouteParams2.mCurRequestIsOnline : true;
            if (!r1) {
                updateOfflineRouteTryCount(0);
                getLogicView().initOfflineRoutePanel(0);
            }
        }
        getLogicView().initData(r1);
        if (naviPresenterData.getIsFromCommuting() || naviPresenterData.getIsReqRestrict()) {
            requestRestrict();
        }
        if (naviPresenterData.getIsNeedToSrNav()) {
            enterSRNaviMode();
        }
    }

    private void handleVoiceNaviAfterRestore(NaviPresenterData naviPresenterData) {
        RouteRequest routeRequest;
        if (naviPresenterData == null || (routeRequest = naviPresenterData.getRouteRequest()) == null || routeRequest.getRequestFrom() != 1 || !naviPresenterData.getIsManual()) {
            return;
        }
        requestReroute(routeRequest, naviPresenterData.getRequestType() > -1 ? naviPresenterData.getRequestType() : 0, naviPresenterData.getIsFilterCharge());
    }

    private void restoreInit() {
        openCruiseAheadTrafficBroadcast();
        this.mCurrentMode = 0;
        updateTBTAndRoute(true, TBTManager.getInstance().getCurrentNaviId(), TBTManager.getInstance().getCurrentNaviPathIndex());
        getMapView().goBackCenter(false);
        getMapView().setMapLevel(17.0f);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, " GuideCarUp : " + getMapView().getBizControlManager().getCarUpMode());
        }
        getMapView().getBizControlManager().setCarLineAndNaviEndVisible(true);
        StateManager.getInstance().start(0, 10000);
        getLogicView().restoreMotionEventFlag();
        getLogicView().initMapMode();
    }

    public void setStateModeAndTimeByMapMode() {
        boolean z = 1 != StateManager.getInstance().getState();
        if (isPreview()) {
            StateManager.getInstance().setStateModeAndTime(1, 10000, z);
        } else if (isLaneViewShow()) {
            StateManager.getInstance().setStateModeAndTime(1, 5000, z);
        } else {
            StateManager.getInstance().setStateModeAndTime(0, 10000, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter, com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onResume() {
        MapViewWrapper mapView;
        super.onResume();
        getLogicView().initListener();
        if (1 == StateManager.getInstance().getState()) {
            getStateListener().onStateChange(1);
        } else {
            if (1 == getCurrentMode() && (mapView = getMapView()) != null && mapView.getPreviewParam() == null) {
                enterOverViewMode();
            }
            getStateListener().onStateChange(0);
        }
        if (this.mCurrentMode == 0) {
            getMapView().getBizControlManager().setFollowMode(true);
        }
        setStateModeAndTimeByMapMode();
        updateNaviPanel();
        updateRemainDis();
        updateSAPA();
        if (!getLogicView().is3DCrossShow()) {
            getLogicView().onUpdate3DTo2DButton(false);
            getLogicView().onOverviewModeChanged(1 == getCurrentMode());
        }
        RecommendParkingHelper recommendParkingHelper = TBTManager.getInstance().getRecommendParkingHelper();
        if (recommendParkingHelper != null) {
            if (recommendParkingHelper.isShowRecommendRark() && !getLogicView().isShowRecommendPark() && getLogicView().canShowElement(UIRelationshipConfig.ELEMENT_RECOMMEND_PARK)) {
                getLogicView().onShowRecommendParking(recommendParkingHelper.getRecommendParks(), recommendParkingHelper.isMatchAIRecommendCondition(TBTManager.getInstance().getNaviInfo()));
            } else if (getLogicView().isShowRecommendPark() && !recommendParkingHelper.isShowRecommendRark()) {
                getLogicView().onHideRecommendParking();
            }
        }
        SettingBLManager.getInstance().setRadarState();
        if (isLaneViewShow()) {
            updateSRTrafficView(TBTManager.getInstance().getSRTrafficEventType());
            refreshSpeedInfo();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter, com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onPause() {
        super.onPause();
        getLogicView().onHideRouting();
        getLogicView().unInitListener();
        disableDynamicLevel();
        clearParkingOverlay();
        getLogicView().hideCrossUI();
        stopSwitchToSRTimer();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviPresenter
    public void onDestroyView() {
        destroyTbt();
        NavRestoreManager.getInstance().removeRestoreListener(this);
        unRegisterAccountEventCallback();
        stopSwitchToSRTimer();
        OddDataHelper.getInstance().removeUpdateOddInfoListener(this);
        clearTrafficLightOverlay();
        CarServiceManager.getInstance().removeCarStateListener(this.mXPCarStateListener);
        SapaChargeDataHelper sapaChargeDataHelper = this.mSapaChargeDataHelper;
        if (sapaChargeDataHelper != null) {
            sapaChargeDataHelper.release();
        }
    }

    public void startTbt(boolean z, boolean z2, long j, int i) {
        L.i(TAG, String.format("startTbt isNeedStartNavi:%s isManual:%s requestId:%s pathIndex:%s", Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j), Integer.valueOf(i)));
        openCruiseAheadTrafficBroadcast();
        this.mCurrentMode = 0;
        if (getMapView().isPreview()) {
            getMapView().exitPreview(false, true);
        }
        getLogicView().initMapMode();
        updateTBTAndRoute(z, j, i);
        getMapView().goBackCenter();
        getMapView().setMapLevel(17.0f);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, " GuideCarUp : " + getMapView().getBizControlManager().getCarUpMode());
        }
        XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentNaviId());
        getMapView().getBizControlManager().setCarLineAndNaviEndVisible(true);
        StateManager.getInstance().start(0, 10000);
        RouteParams currentNaviRouteParams = TBTManager.getInstance().getCurrentNaviRouteParams();
        if (currentNaviRouteParams != null) {
            getLogicView().sendStatDataWhenSystemStartNavi(getLogicView().getMainContext(), currentNaviRouteParams.mStartInfo, TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation(), endInfo, z2, currentNaviRouteParams);
        }
        PostChargeStationStatus.getInstance().postStartNaviStatus();
    }

    public void updateNaviInfo(List<XPNaviInfo> list, boolean z) {
        if (list == null || list.get(0) == null) {
            if (L.ENABLE) {
                L.d(TAG, ">>> updateInfo infos was null or first of infos was null!");
            }
        } else if (getLogicView().isSceneResumed()) {
            XPNaviInfo xPNaviInfo = list.get(0);
            if (this.mLastPathID != xPNaviInfo.mPathID || z) {
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, ">>> updateNaviInfo mLastPathID:" + this.mLastPathID + " naviInfo.pathID:" + xPNaviInfo.mPathID);
                }
                if (!z) {
                    if (L.ENABLE) {
                        L.d(TAG, "updateNaviRemainInfo by mLastPathID != naviInfo.mPathID ");
                    }
                    updateNaviRemainInfo(true);
                }
                long currentNaviId = TBTManager.getInstance().getCurrentNaviId();
                RouteResult.RouteInfo routeResultInfo = TBTManager.getInstance().getRouteResultInfo(currentNaviId, xPNaviInfo.mPathID);
                if (routeResultInfo != null) {
                    RouteDataModel routeData = TBTManager.getInstance().getRouteData(currentNaviId);
                    getLogicView().onUpdateTraffic(routeResultInfo.mPathLength, (routeData == null || routeData.mRouteParams == null) ? false : routeData.mRouteParams.mCurRequestIsOnline);
                    getLogicView().updateViewState();
                    RouteParams currentNaviRouteParams = TBTManager.getInstance().getCurrentNaviRouteParams();
                    if (currentNaviRouteParams != null && currentNaviRouteParams.mCurRequestIsOnline) {
                        ILightBarInfo lightBarInfo = TBTManager.getInstance().getLightBarInfo(routeResultInfo.mPathId);
                        int lightBarPassedIndex = TBTManager.getInstance().getLightBarPassedIndex();
                        if (lightBarInfo == null) {
                            lightBarInfo = BLDataModelUtil.toXPLightBarInfo(routeResultInfo.mLightBarItems, routeResultInfo.mPathId);
                        }
                        if (lightBarInfo != null) {
                            getLogicView().onUpdateTMCLightBar(lightBarInfo, lightBarPassedIndex, true);
                            if (L.ENABLE) {
                                L.Tag tag2 = TAG;
                                L.d(tag2, ">>> updateNaviInfo updateTMCLightBar pathID:" + lightBarInfo.getPathId());
                            }
                        }
                    }
                    if (this.mLastPathID != xPNaviInfo.mPathID) {
                        this.mLastPathID = routeResultInfo.mPathId;
                        getLogicView().onShowExitInfo(null);
                    } else {
                        getLogicView().onShowExitInfo(TBTManager.getInstance().getNaviExitDirectionInfo());
                    }
                }
            }
            getLogicView().onUpdateNaviInfo(list);
            this.mDynamicLevelHelper.sendUpdateInfoMsg(xPNaviInfo);
            if (TBTManager.getInstance().getRecommendParkingHelper() == null || !TBTManager.getInstance().getRecommendParkingHelper().isShowRecommendRark()) {
                return;
            }
            if (this.mOldcurrentPoi == null) {
                this.mOldcurrentPoi = getCurrentPoi();
            } else if (getLogicView().isShowContinueNavi() || !getLogicView().isExpandRecommendParking() || LocationUtils.getDistance(this.mOldcurrentPoi, getCurrentPoi()) <= 50.0d) {
            } else {
                if (L.ENABLE) {
                    L.d(TAG, ">>> updateInfo infos set park zoom level.");
                }
                setRecommendParkZoomLevel(false);
            }
        }
    }

    @MainThread
    public void updateNaviPanel() {
        updateLaneView();
        XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
        if (naviInfo != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(naviInfo);
            L.i(TAG, "updateNaviPanel invoke updateNaviInfo");
            updateNaviInfo(arrayList, true);
        }
        if (TBTManager.getInstance().isSimulateGuidance()) {
            getLogicView().onShowSimulatePanel();
        } else {
            getLogicView().onHideSimulatePanel();
        }
        if (CollectionUtils.isNotEmpty(this.mRecommendParkData)) {
            addParkOverlay();
            int i = this.mLastRecommendFocusedIndex;
            if (i <= -1) {
                i = 0;
            }
            showRecommendParkingFocus(i);
        }
        restoreRecommendRouteShow();
    }

    @MainThread
    public void updateLaneView() {
        if (Utils.isLandscape()) {
            return;
        }
        XPLaneInfo naviLaneInfo = TBTManager.getInstance().getNaviLaneInfo();
        XPTollGateInfo xPTollGateInfo = TBTManager.getInstance().getXPTollGateInfo();
        if (naviLaneInfo != null) {
            getLogicView().onShowNaviLaneInfo(naviLaneInfo);
        } else if (xPTollGateInfo != null) {
            handleTollGateInfo(xPTollGateInfo);
        } else {
            getLogicView().onHideNaviLaneInfo();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    @MainThread
    public void enterOverViewMode() {
        RectDouble updateOverViewRectWithRadarSetting;
        IPathResult currentNaviPathResult = TBTManager.getInstance().getCurrentNaviPathResult();
        XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
        IVariantPath currentNaviVariantPath = TBTManager.getInstance().getCurrentNaviVariantPath();
        if (currentNaviPathResult != null) {
            StringBuilder sb = L.ENABLE ? new StringBuilder(">>>enterOverViewMode") : null;
            if (naviInfo != null && currentNaviVariantPath != null && this.mLastPathID == currentNaviVariantPath.getPathId()) {
                updateOverViewRectWithRadarSetting = CalculatePreviewUtil.getNaviPathBound(currentNaviVariantPath, naviInfo);
                if (L.ENABLE && sb != null) {
                    sb.append(" naviInfo.curSegIdx=");
                    sb.append(naviInfo.mCurSegIdx);
                    sb.append(" naviInfo.curLinkIdx=");
                    sb.append(naviInfo.mCurLinkIdx);
                    sb.append(" naviInfo.curPointIdx=");
                    sb.append(naviInfo.mCurPointIdx);
                }
                if (isRectDoubleValid(updateOverViewRectWithRadarSetting)) {
                    if (L.ENABLE && sb != null) {
                        sb.append(", By CurrentLocation, ");
                    }
                    if (SettingWrapper.isOpenRadar()) {
                        for (int i = 0; i < currentNaviPathResult.getPathCount(); i++) {
                            if (currentNaviPathResult.getPath(i) != null && currentNaviPathResult.getPath(i).getPathId() != currentNaviVariantPath.getPathId()) {
                                CalculatePreviewUtil.getPathBound(currentNaviPathResult.getPath(i), updateOverViewRectWithRadarSetting);
                            }
                        }
                    }
                } else {
                    updateOverViewRectWithRadarSetting = updateOverViewRectWithRadarSetting(currentNaviPathResult, currentNaviVariantPath);
                }
            } else {
                updateOverViewRectWithRadarSetting = updateOverViewRectWithRadarSetting(currentNaviPathResult, currentNaviVariantPath);
            }
            if (L.ENABLE && sb != null) {
                sb.append(", By ");
                sb.append(SettingWrapper.isOpenRadar() ? "pathResult" : "variantPath");
                sb.append(", rect is null: ");
                sb.append(updateOverViewRectWithRadarSetting == null);
            }
            if (updateOverViewRectWithRadarSetting != null) {
                RouteParams currentNaviRouteParams = TBTManager.getInstance().getCurrentNaviRouteParams();
                if (currentNaviRouteParams != null && currentNaviRouteParams.mEndInfo != null) {
                    updateOverViewRectWithRadarSetting = CalculatePreviewUtil.rectUnion(updateOverViewRectWithRadarSetting, currentNaviRouteParams.mEndInfo.getDisplayLon(), currentNaviRouteParams.mEndInfo.getDisplayLat());
                }
                if (L.ENABLE && sb != null) {
                    sb.append(", rect[");
                    sb.append(updateOverViewRectWithRadarSetting.left);
                    sb.append(", ");
                    sb.append(updateOverViewRectWithRadarSetting.top);
                    sb.append(", ");
                    sb.append(updateOverViewRectWithRadarSetting.right);
                    sb.append(", ");
                    sb.append(updateOverViewRectWithRadarSetting.bottom);
                    sb.append("]");
                }
                enterOverViewMode(updateOverViewRectWithRadarSetting, true);
            }
            if (L.ENABLE && sb != null) {
                L.d(TAG, sb.toString());
            }
        }
        updateEagleViewMode(false);
    }

    private RectDouble updateOverViewRectWithRadarSetting(IPathResult iPathResult, IVariantPath iVariantPath) {
        if (SettingWrapper.isOpenRadar()) {
            return CalculatePreviewUtil.getPathBound(iPathResult);
        }
        return CalculatePreviewUtil.getPathBound(iVariantPath);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    public boolean isPreview() {
        return this.mCurrentMode == 1;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    protected void exitPreviewByNaviStop() {
        if (isPreview()) {
            this.mCurrentMode = 0;
            getMapView().exitPreview(true, true);
        }
    }

    @MainThread
    private void enterOverViewMode(RectDouble rectDouble, boolean z) {
        switchToSDForShowView();
        disableDynamicLevel();
        if (this.mCurrentMode == 0) {
            this.mSavedMapLevel = getMapView().getMapLevel();
            this.mSavedMapMode = getMapView().getMapMode();
        }
        getMapView().getBizControlManager().setFollowMode(false);
        getMapView().setMapMode(0, false);
        getLogicView().onUpdatePreview(rectDouble);
        this.mCurrentMode = 1;
        getLogicView().onOverviewModeChanged(true);
        getMapView().getBizControlManager().setCarLineAndNaviEndVisible(false);
        if (z) {
            StateManager.getInstance().start(1, 10000);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    public void exitOverviewMode() {
        super.exitOverviewMode();
        if (L.ENABLE) {
            L.d(TAG, "exitOverviewMode");
        }
        this.mCurrentMode = 0;
        if (this.mSavedMapMode != -1) {
            getMapView().restoreCarPosition();
        }
        getLogicView().onOverviewModeChanged(false);
        getMapView().getBizControlManager().setCarLineAndNaviEndVisible(true);
        StateManager.getInstance().start(0, 10000);
        updateEagleViewMode(true);
        enableDynamicLevel();
        restoreMapState();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    protected NaviPresenterListener getNaviPresenterListener() {
        return new NaviPresenterListener.Builder().naviStateListener(new GuideNaviStateListener(getLogicView(), this)).naviSpeechEventHandler(new GuideNaviSpeechEventHandler(getLogicView(), this)).mapSceneEventHandler(new GuideNaviMapSceneEventHandler(getLogicView(), this)).restrictEventCallback(new NaviRestrictEventCallback()).rerouteListener(new GuideNaviRerouteListener(getLogicView(), this)).mapDecoratorRouteUpdateListener(new NaviMapDecoratorRouteUpdateListener(getLogicView(), this)).recommendRouteSwitchListener(new GuideNaviRecommendRouteSwitchListener(getLogicView(), this)).parallelRoadEventHandler(new NaviParallelRoadEventHandler(getLogicView(), this)).naviListener(new GuideNaviListener(getLogicView(), this)).recommendParkingListener(new GuideNaviRecommendParkingListener(getLogicView(), this)).setRouteUpdateListener(new NaviRouteUpdateContractImpl(getLogicView(), this)).setSRInfoChangedListener(new SRNaviListener(getLogicView(), this)).build();
    }

    public int getCurrentMode() {
        return this.mCurrentMode;
    }

    @MainThread
    public void destroyTbt() {
        CarLoc originCarLocation;
        PathMatchInfo pathMatchInfo;
        EventBus.getDefault().unregister(this);
        if (1 == this.mCurrentMode) {
            exitOverviewMode();
        }
        getMapView().getBizControlManager().setCarLineAndNaviEndVisible(false);
        if (this.mIsNeedGotoMapCenter && (originCarLocation = TBTManager.getInstance().getOriginCarLocation()) != null) {
            if (CollectionUtils.isNotEmpty(originCarLocation.vecPathMatchInfo) && (pathMatchInfo = originCarLocation.vecPathMatchInfo.get(0)) != null) {
                TBTManager.getInstance().getPosServiceWrapper().setMockCarLocation(new XPCoordinate2DDouble(pathMatchInfo.longitude, pathMatchInfo.latitude));
            }
            getMapView().getBizControlManager().setCarLocation(originCarLocation);
            getMapView().goToMapCenter(originCarLocation);
            getMapView().setIsNeedBackToStart(true);
        }
        this.mLastPathID = -1L;
        TBTManager.getInstance().removeRerouteListener(getRerouteListener());
        TBTManager.getInstance().removeNaviListener(getNaviListener());
        SRNaviManager.getInstance().removeSRInfoChangedListener(getSRInfoChangedListener());
        this.mDynamicLevelHelper.release();
        updateOverlayObserver(false, BizControlWrapper.BIZ_CONTROL_TYPE_SEARCH);
    }

    public void clearParkingOverlay() {
        getMapView().getBizControlManager().clearAllItems(BizControlWrapper.BIZ_CONTROL_TYPE_SEARCH, 7010L);
    }

    private void resetNaviViewStatus() {
        if (L.ENABLE) {
            L.d(TAG, "resetNaviViewStatus");
        }
        getMapView().goBackCenter();
        getLogicView().onHideRecommendParking();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRecommendParkZoomLevel(boolean z) {
        if (this.mCurrentMode == 1 || isLaneViewShow() || CollectionUtils.isEmpty(this.mRecommendParkData)) {
            return;
        }
        disableDynamicLevel();
        getMapView().getBizControlManager().setFollowMode(false);
        XPPoiInfo currentPoi = getCurrentPoi();
        RectDouble previewRect = getMapView().getPreviewRect(getBizPointBaseDataList(this.mRecommendParkData, transformPointData(currentPoi), transformPointData(TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentNaviId()))));
        if (previewRect == null) {
            L.d(TAG, " setRecommendParkZoomLevel bound null");
            return;
        }
        Coord2DDouble coord2DDouble = new Coord2DDouble(previewRect.left + ((previewRect.right - previewRect.left) / 2.0d), previewRect.bottom + ((previewRect.top - previewRect.bottom) / 2.0d));
        XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble();
        xPCoordinate2DDouble.mLon = coord2DDouble.lon;
        xPCoordinate2DDouble.mLat = coord2DDouble.lat;
        XPCoordinate2DDouble xPCoordinate2DDouble2 = new XPCoordinate2DDouble();
        XPCoordinate2DDouble xPCoordinate2DDouble3 = new XPCoordinate2DDouble();
        XPCoordinate2DDouble xPCoordinate2DDouble4 = new XPCoordinate2DDouble();
        XPCoordinate2DDouble xPCoordinate2DDouble5 = new XPCoordinate2DDouble();
        xPCoordinate2DDouble2.mLon = previewRect.left;
        xPCoordinate2DDouble2.mLat = previewRect.top;
        xPCoordinate2DDouble3.mLon = previewRect.right;
        xPCoordinate2DDouble3.mLat = previewRect.bottom;
        xPCoordinate2DDouble4.mLon = previewRect.left;
        xPCoordinate2DDouble4.mLat = previewRect.bottom;
        xPCoordinate2DDouble5.mLon = previewRect.right;
        xPCoordinate2DDouble5.mLat = previewRect.top;
        if (isRecommendParkDebug()) {
            MapUtil.addMapOverLayItems(getLogicView().getMainContext(), 450, xPCoordinate2DDouble2, xPCoordinate2DDouble3, xPCoordinate2DDouble4, xPCoordinate2DDouble5, xPCoordinate2DDouble);
            MapUtil.drawPolygonByPoint(getLogicView().getMainContext(), xPCoordinate2DDouble2, xPCoordinate2DDouble4, xPCoordinate2DDouble3, xPCoordinate2DDouble5);
        }
        float min = Math.min(getMapView().getMapZoom(xPCoordinate2DDouble2, xPCoordinate2DDouble3, ContextUtils.getDimensionPixelSize(R.dimen.recommend_park_target_display_area), ContextUtils.getDimensionPixelSize(R.dimen.recommend_park_target_display_area)), getMapView().getMapZoom(xPCoordinate2DDouble4, xPCoordinate2DDouble5, ContextUtils.getDimensionPixelSize(R.dimen.recommend_park_target_display_area), ContextUtils.getDimensionPixelSize(R.dimen.recommend_park_target_display_area)));
        if (L.ENABLE) {
            L.d(TAG, "============>   start   recommendPark auto zoom   ");
            L.Tag tag = TAG;
            L.d(tag, "finalZoomLevel : " + min);
        }
        getMapView().setMapViewLeftTop(ContextUtils.getDimensionPixelSize(R.dimen.recommend_park_target_left) + (ContextUtils.getDimensionPixelSize(R.dimen.recommend_park_target_width) / 2), ContextUtils.getDimensionPixelSize(R.dimen.recommend_park_target_margin_top) + (ContextUtils.getDimensionPixelSize(R.dimen.recommend_park_target_height) / 2));
        getMapView().setPoiToCenter(xPCoordinate2DDouble);
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "moveMapto :  lon:  " + coord2DDouble.lon + "  , lat:  " + coord2DDouble.lat + "  screenX:  " + (RootUtil.getScreenWidth() / 2) + "  screenY:  " + (ContextUtils.getDimensionPixelSize(R.dimen.recommend_park_target_margin_top) + (ContextUtils.getDimensionPixelSize(R.dimen.recommend_park_target_height) / 2)));
        }
        getMapView().animateZoomTo(min);
        if (L.ENABLE) {
            L.Tag tag3 = TAG;
            L.d(tag3, "setMapLevel " + min);
        }
        if (isRecommendParkDebug()) {
            getLogicView().runOnUiThreadDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter.4
                @Override // java.lang.Runnable
                public void run() {
                    NaviScenePresenter.this.drawHotSpotPoint();
                }
            }, 500L);
        }
        this.mOldcurrentPoi = currentPoi;
    }

    public void checkMoveParkItem(int i, int i2, int i3, int i4, int i5) {
        if (!CollectionUtils.isEmpty(this.mRecommendParkData) && CollectionUtils.isIndexLegal(i, this.mRecommendParkData) && getLogicView().getMainContext().getMapView().isPoiOutOfBound(this.mRecommendParkData.get(i).mPos3D.lon, this.mRecommendParkData.get(i).mPos3D.lat, i2, i3, i4, i5)) {
            setRecommendParkZoomLevel(true);
        }
    }

    @MainThread
    public void showRecommendParkImage(List<XPPoiInfo> list, boolean z) {
        if (CollectionUtils.isNotEmpty(list)) {
            this.mRecommendParkData = new ArrayList<>();
            int i = 0;
            for (XPPoiInfo xPPoiInfo : list) {
                BizAGroupBusinessInfo bizAGroupBusinessInfo = new BizAGroupBusinessInfo();
                bizAGroupBusinessInfo.id = i + "";
                bizAGroupBusinessInfo.mPos3D.lon = xPPoiInfo.getDisplayLon();
                bizAGroupBusinessInfo.mPos3D.lat = xPPoiInfo.getDisplayLat();
                this.mRecommendParkData.add(bizAGroupBusinessInfo);
                i++;
            }
            if (!Configuration.Dependency.AIASSISTANT_ENABLE || z) {
                setRecommendParkZoomLevel(false);
            }
            getLogicView().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter.5
                @Override // java.lang.Runnable
                public void run() {
                    NaviScenePresenter.this.addParkOverlay();
                }
            });
            return;
        }
        hideRecommendParkImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addParkOverlay() {
        if (CollectionUtils.isNotEmpty(this.mRecommendParkData)) {
            getMapView().getBizControlManager().setVisible(BizControlWrapper.BIZ_CONTROL_TYPE_SEARCH, BizSearchType.BizSearchTypePoiParkRoute, true);
            getMapView().getBizControlManager().addItems(BizControlWrapper.BIZ_CONTROL_TYPE_SEARCH, BizSearchType.BizSearchTypePoiParkRoute, this.mRecommendParkData);
        }
    }

    @VisibleForTesting
    protected void drawHotSpotPoint() {
        XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble();
        Coord2DDouble pixelToLonLat = getLogicView().getMapView().pixelToLonLat(130L, 444L);
        if (pixelToLonLat != null) {
            xPCoordinate2DDouble.mLat = pixelToLonLat.lat;
            xPCoordinate2DDouble.mLon = pixelToLonLat.lon;
        }
        XPCoordinate2DDouble xPCoordinate2DDouble2 = new XPCoordinate2DDouble();
        Coord2DDouble pixelToLonLat2 = getLogicView().getMapView().pixelToLonLat(RootUtil.getScreenWidth() - 130, 444L);
        if (pixelToLonLat2 != null) {
            xPCoordinate2DDouble2.mLat = pixelToLonLat2.lat;
            xPCoordinate2DDouble2.mLon = pixelToLonLat2.lon;
        }
        XPCoordinate2DDouble xPCoordinate2DDouble3 = new XPCoordinate2DDouble();
        Coord2DDouble pixelToLonLat3 = getLogicView().getMapView().pixelToLonLat(130L, 1404L);
        if (pixelToLonLat3 != null) {
            xPCoordinate2DDouble3.mLat = pixelToLonLat3.lat;
            xPCoordinate2DDouble3.mLon = pixelToLonLat3.lon;
        }
        XPCoordinate2DDouble xPCoordinate2DDouble4 = new XPCoordinate2DDouble();
        Coord2DDouble pixelToLonLat4 = getLogicView().getMapView().pixelToLonLat(RootUtil.getScreenWidth() - 130, 1404L);
        if (pixelToLonLat4 != null) {
            xPCoordinate2DDouble4.mLat = pixelToLonLat4.lat;
            xPCoordinate2DDouble4.mLon = pixelToLonLat4.lon;
        }
        XPCoordinate2DDouble xPCoordinate2DDouble5 = new XPCoordinate2DDouble();
        Coord2DDouble pixelToLonLat5 = getLogicView().getMapView().pixelToLonLat(RootUtil.getScreenWidth() / 2, 904L);
        if (pixelToLonLat5 != null) {
            xPCoordinate2DDouble5.mLat = pixelToLonLat5.lat;
            xPCoordinate2DDouble5.mLon = pixelToLonLat5.lon;
        }
        MapUtil.addMapOverLayItems(getLogicView().getMainContext(), xPCoordinate2DDouble, xPCoordinate2DDouble2, xPCoordinate2DDouble3, xPCoordinate2DDouble4, xPCoordinate2DDouble5);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    public void stopNavi(int i, boolean z) {
        super.stopNavi(i, z);
        getLogicView().refreshMapStatus();
        if (isRecommendParkDebug()) {
            getMapView().getBizControlManager().stopNavi();
        }
        PostChargeStationStatus.getInstance().postStopNaviStatus();
    }

    protected boolean isRecommendParkDebug() {
        return DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_XP_RECOMMEND_PARK, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_RECOMMEND_PARK);
    }

    protected BizAGroupBusinessInfo transformPointData(XPPoiInfo xPPoiInfo) {
        BizAGroupBusinessInfo bizAGroupBusinessInfo = new BizAGroupBusinessInfo();
        if (xPPoiInfo != null) {
            bizAGroupBusinessInfo.mPos3D.lat = xPPoiInfo.getDisplayLat();
            bizAGroupBusinessInfo.mPos3D.lon = xPPoiInfo.getDisplayLon();
        }
        return bizAGroupBusinessInfo;
    }

    protected ArrayList<BizAGroupBusinessInfo> getBizPointBaseDataList(ArrayList<BizAGroupBusinessInfo> arrayList, BizAGroupBusinessInfo... bizAGroupBusinessInfoArr) {
        if (CollectionUtils.isEmpty(arrayList)) {
            return null;
        }
        ArrayList<BizAGroupBusinessInfo> arrayList2 = new ArrayList<>(arrayList);
        arrayList2.addAll(Arrays.asList(bizAGroupBusinessInfoArr));
        return arrayList2;
    }

    protected XPPoiInfo getCurrentPoi() {
        return TBTManager.getInstance().generateStartPoint(TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation());
    }

    public void hideRecommendParkImage() {
        this.mRecommendParkData = null;
        if (StateManager.getInstance().getState() == 1) {
            enableDynamicLevel();
        }
        getMapView().getBizControlManager().clearAllItems(BizControlWrapper.BIZ_CONTROL_TYPE_SEARCH, 7010L);
    }

    @MainThread
    public void showRecommendParkingFocus(int i) {
        getMapView().getBizControlManager().setFocus(BizControlWrapper.BIZ_CONTROL_TYPE_SEARCH, 7010L, String.valueOf(i), true);
        this.mLastRecommendFocusedIndex = i;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    protected void beforeStopNavi(boolean z) {
        if (getLogicView().isExpandRecommendParking()) {
            getMapView().goBackCenterAndRestoreCarPosition(true);
        }
        XPPoiInfo lastEndInfoForDataLog = TBTManager.getInstance().getLastEndInfoForDataLog();
        float routeRemainDistForDataLog = TBTManager.getInstance().getRouteRemainDistForDataLog();
        if (z) {
            NaviStatUtil.sendStatDataWhenStopNaviByButton(getLogicView().getMainContext(), TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation(), routeRemainDistForDataLog, lastEndInfoForDataLog);
        } else {
            NaviStatUtil.sendStatDataWhenSystemStopNavi(getLogicView().getMainContext(), TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation(), routeRemainDistForDataLog, lastEndInfoForDataLog);
        }
        resetCruiseAheadTrafficBroadcastWithSetting();
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEvent(AIRecommendParkEvent aIRecommendParkEvent) {
        requestRouteToRecommendParking(aIRecommendParkEvent.getEndInfo());
    }

    public void requestRouteToRecommendParking(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "reroute to recommendpark: " + xPPoiInfo.getName());
        getLogicView().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter.6
            @Override // java.lang.Runnable
            public void run() {
                NaviScenePresenter.this.getLogicView().checkMapviewMode3D();
            }
        });
        this.mRequestType = 3;
        XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
        requestReroute(new RouteParams.Builder().setStartInfo(startPOIFromCurrent).setEndInfo(xPPoiInfo).setViaInfos(TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentNaviId())).setRouteLevel(2).setIsRequestOdd(CarServiceManager.getInstance().isNGPOn()).setRerouteType(9).build(), false);
    }

    @MainThread
    public void playNaviManual() {
        TBTManager.getInstance().playNaviManual();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    public void updateRoute(IPathResult iPathResult, int i, boolean z, boolean z2) {
        L.Tag tag = TAG;
        L.i(tag, ">>> updateRoute index = " + i);
        super.updateRoute(iPathResult, i, z, z2);
    }

    @MainThread
    private void showComparingRoutes(IVariantPath iVariantPath, IVariantPath iVariantPath2, int i) {
        hideCrossImage();
        if (iVariantPath != null && iVariantPath2 != null) {
            this.mIsLastRadarOpen = SettingWrapper.isOpenRadar();
            L.Tag tag = TAG;
            L.i(tag, "RECOMMEND_ROUTE showComparingRoutes mIsLastRadarOpen: " + this.mIsLastRadarOpen);
            if (this.mIsLastRadarOpen) {
                SettingWrapper.setRadarStatus(false);
            }
            clearOldOverlay(false);
            getMapView().getBizControlManager().drawComparingRoutes(BLParams.RouteOverlayGuide, i, 0, true, TBTManager.getInstance().getCurrentNaviRouteParams(), iVariantPath, iVariantPath2);
            RectDouble pathBound = CalculatePreviewUtil.getPathBound(iVariantPath, CalculatePreviewUtil.getNaviPathBound(iVariantPath2, TBTManager.getInstance().getNaviInfo()));
            if (pathBound != null) {
                if (1 == this.mCurrentMode) {
                    exitOverviewMode();
                    enterOverViewMode(pathBound, true);
                    return;
                }
                enterOverViewMode(pathBound, false);
                return;
            }
            return;
        }
        L.Tag tag2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(iVariantPath2 == null ? " old path is null" : "");
        sb.append(iVariantPath == null ? ", new path is null" : "");
        L.w(tag2, sb.toString());
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    public void onShowRecommendRoute(@NonNull IPathResult iPathResult, IVariantPath iVariantPath, int i, @NonNull RouteLimitInfo routeLimitInfo) {
        if (i < 0 || routeLimitInfo == null) {
            return;
        }
        super.onShowRecommendRoute(iPathResult, iVariantPath, i, routeLimitInfo);
        if (!isSceneStrictLegal()) {
            if (i != 5) {
                onNewRouteUpdateUI();
                return;
            }
            return;
        }
        IVariantPath path = iPathResult.getPath(0);
        disableDynamicLevel();
        if (i != 5) {
            showComparingRoutes(path, iVariantPath, 0);
        } else {
            showComparingRoutes(path, iVariantPath, 1);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    public boolean isIgnoreETAReroute(int i) {
        return 5 == i && (SettingWrapper.isOpenRadar() || NaviModel.getInstance().isShowingDialog());
    }

    private void drawCarLine() {
        if (TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentNaviId()) != null) {
            getMapView().getBizControlManager().setCarLineAndNaviEndVisible(true);
        } else {
            L.w(TAG, "endInfo is null !");
        }
    }

    public void onUpdateViaPass(long j) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateViaPass: " + j);
        }
        getLogicView().onUpdateViaPass(j);
    }

    @MainThread
    public void onNewRouteUpdateUI() {
        getLogicView().hideRouteChargePanelView(true);
        this.mIsOfflineReroute = false;
        if (this.mIsLastRadarOpen) {
            SettingWrapper.setRadarStatus(true);
            this.mIsLastRadarOpen = false;
        }
        drawCarLine();
        getMapView().getBizControlManager().removeRoute(BLParams.RouteOverlayGuide, true);
        updateTBTAndRoute(false, TBTManager.getInstance().getCurrentNaviId(), TBTManager.getInstance().getCurrentNaviPathIndex());
        int i = this.mRequestType;
        if (i == 0) {
            PostChargeStationStatus.getInstance().postUpdateRouteStatus();
            disableDynamicLevel();
            enterOverViewMode();
        } else if (i == 3) {
            resetNaviViewStatus();
            disableDynamicLevel();
        } else if (getLogicView().isSceneResumed()) {
            if (1 == this.mCurrentMode) {
                exitOverviewMode();
            } else {
                getMapView().goBackCenter(true, true, false);
                getMapView().getBizControlManager().setCarLineAndNaviEndVisible(true);
                getLogicView().onOverviewModeChanged(false);
            }
        }
        if (isNeedCountdownToSRNavi(this.mRequestType)) {
            startSwitchToSRTimer();
        }
        this.mRequestType = -1;
    }

    public void exitCross3D() {
        TBTManager.getInstance().hideNaviCrossImage(4);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onNaviEvent(final GuideWrapperNaviEvent guideWrapperNaviEvent) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter.7
            @Override // java.lang.Runnable
            public void run() {
                NaviScenePresenter.this.onNaviEventInUiThread(guideWrapperNaviEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void onNaviEventInUiThread(GuideWrapperNaviEvent guideWrapperNaviEvent) {
        if (guideWrapperNaviEvent == null) {
            return;
        }
        int type = guideWrapperNaviEvent.getType();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>> onNaviEventInUiThread type = " + type);
        }
        IRecommendParkingListener recommendParkingListener = getRecommendParkingListener();
        if (recommendParkingListener != null) {
            if (type != 23) {
                if (type != 24) {
                    return;
                }
                recommendParkingListener.onHideRecommendParking();
                return;
            }
            List<XPPoiInfo> list = guideWrapperNaviEvent.getList();
            boolean booleanValue = guideWrapperNaviEvent.getBooleanValue();
            if (CollectionUtils.isNotEmpty(list)) {
                getLogicView().checkMapviewMode3D();
                recommendParkingListener.onShowRecommendParking(list, booleanValue);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        int i = speechNaviEvent.what;
        if (i == 202) {
            L.i(TAG, "SPEECH_OPEN_OVERVIEW");
            getLogicView().getSpeechEventBizHelper().openOverview(this);
        } else if (i == 203) {
            L.i(TAG, "SPEECH_CLOSE_OVERVIEW");
            getLogicView().getSpeechEventBizHelper().closeOverview(this);
        } else if (i == 411) {
            L.i(TAG, "SPEECH_EXIT_CROSS_3D");
            getLogicView().getSpeechEventBizHelper().exitCross3D(this);
        } else if (i == 503) {
            L.i(TAG, "SPEECH_SWITCH_SMART_SCALE");
            getLogicView().getSpeechEventBizHelper().switchSmartScale(speechNaviEvent, this);
        } else if (i != 2009) {
            switch (i) {
                case 407:
                    if (this.mCurrentMode == 1) {
                        L.i(TAG, "SPEECH_MAP_MODE_NORTH_UP");
                        getLogicView().getSpeechEventBizHelper().setMapModeNorthUpNotSupported(iCommandCallback);
                        return true;
                    }
                    break;
                case SpeechNaviEvent.SPEECH_MAP_MODE_HEAD_UP_2D /* 408 */:
                    if (this.mCurrentMode == 1) {
                        L.i(TAG, "SPEECH_MAP_MODE_HEAD_UP_2D");
                        getLogicView().getSpeechEventBizHelper().setMapModeHeadUp2DNotSupported(iCommandCallback);
                        return true;
                    }
                    break;
                case 409:
                    if (this.mCurrentMode == 1) {
                        L.i(TAG, "SPEECH_MAP_MODE_HEAD_UP_3D");
                        getLogicView().getSpeechEventBizHelper().setMapModeHeadUp3DNotSupported(iCommandCallback);
                        return true;
                    }
                    break;
                default:
                    return super.onSpeechEvent(speechNaviEvent, iCommandCallback);
            }
        } else {
            L.i(TAG, "SPEECH_VOICE_EXIT_SR_LANE_MODE");
            getLogicView().getSpeechEventBizHelper().exitSROrLaneMode(this);
            return true;
        }
        return false;
    }

    public void executeSpeechCmdExitCross3D() {
        getMapSceneEventHandler().exitCross3D();
    }

    public void executeSpeechCmdCloseOverview() {
        getMapSceneEventHandler().onSwitchOverview(false);
    }

    public void executeSpeechCmdOpenOverview() {
        getMapSceneEventHandler().onSwitchOverview(true);
    }

    public void disableDynamicLevel() {
        getMapView().getBizControlManager().openDynamicLevel(false);
        if (L.ENABLE) {
            L.d(TAG, "disableDynamicLevel");
        }
        this.mDynamicLevelHelper.disableDynamicLevel();
    }

    public void enableDynamicLevel() {
        if (L.ENABLE) {
            L.d(TAG, "enableDynamicLevel");
        }
        if ((StateManager.getInstance().getState() == 1) && getLogicView().isSceneLegal()) {
            if (SettingWrapper.isDynamicLevelEnabled()) {
                getMapView().getBizControlManager().openDynamicLevel(true, 0);
                if (StateManager.getInstance().getState() == 1) {
                    this.mDynamicLevelHelper.enableDynamicLevel();
                    return;
                }
                return;
            }
            if (L.ENABLE) {
                L.d(TAG, "enableDynamicLevel updateMapLevel");
            }
            MapUtil.updateMapLevel(getLogicView().getMainContext());
            return;
        }
        L.i(TAG, "enableDynamicLevel error (active state)");
    }

    @MainThread
    public void switchOverView() {
        getLogicView().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter.8
            @Override // java.lang.Runnable
            public void run() {
                if (!(1 == NaviScenePresenter.this.mCurrentMode)) {
                    NaviScenePresenter.this.enterOverViewMode();
                } else {
                    NaviScenePresenter.this.exitOverviewMode();
                }
            }
        });
    }

    @MainThread
    public void switchOverView(boolean z) {
        if (z) {
            enterOverViewMode();
        } else {
            exitOverviewMode();
        }
    }

    public long requestOnlineReroute() {
        XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentNaviId());
        if (endInfo == null) {
            return -1L;
        }
        XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
        RouteParams currentNaviRouteParams = TBTManager.getInstance().getCurrentNaviRouteParams();
        if (currentNaviRouteParams == null) {
            return -1L;
        }
        this.mIsOfflineReroute = true;
        return requestReroute(new RouteParams.Builder().setStartInfo(startPOIFromCurrent).setEndInfo(endInfo).setViaInfos(currentNaviRouteParams.mViaInfos).setRerouteType(3).setConstrainCode(currentNaviRouteParams.mConstrainCode).setIsRequestOdd(CarServiceManager.getInstance().isNGPOn()).setRouteCalcType(currentNaviRouteParams.mRouteCalcType).setNetworkProperty(1).build(), false);
    }

    public void openCruiseAheadTrafficBroadcast() {
        L.i(TAG, "open cruise ahead traffic broadcast");
        SettingBLManager.getInstance().openAheadTraffic();
    }

    public void resetCruiseAheadTrafficBroadcastWithSetting() {
        SettingBLManager.getInstance().setCruiseBroadcast();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter, com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
    public void onTimeOut() {
        super.onTimeOut();
        ignoreRecommendRoute();
    }

    public void ignoreRecommendRoute() {
        if (this.mIsLastRadarOpen) {
            SettingWrapper.setRadarStatus(true);
            this.mIsLastRadarOpen = false;
        }
        IPathResult currentNaviPathResult = TBTManager.getInstance().getCurrentNaviPathResult();
        int currentNaviPathIndex = TBTManager.getInstance().getCurrentNaviPathIndex();
        if (currentNaviPathResult != null) {
            updateRoute(currentNaviPathResult, currentNaviPathIndex, false, true);
        }
        TBTManager.getInstance().clearRecommendPathResult();
        if (1 == this.mCurrentMode) {
            exitOverviewMode();
            enableDynamicLevel();
        }
    }

    public boolean switchRecommendRoute(IVariantPath iVariantPath, int i) {
        int pathIndexFromPathId;
        IPathResult recommendNaviPathResult = TBTManager.getInstance().getRecommendNaviPathResult();
        if (recommendNaviPathResult != null && (pathIndexFromPathId = TBTUtil.getPathIndexFromPathId(recommendNaviPathResult, iVariantPath)) > -1) {
            if (TBTManager.getInstance().getMap() != null) {
                TBTManager.getInstance().getMap().getBizControlManager().switchRecommendRoute();
            }
            TBTManager.getInstance().setCurrentNaviId(TBTManager.getInstance().getRecommendNaviId(), i);
            TBTManager.getInstance().updatePathIndex(pathIndexFromPathId);
            TBTManager.getInstance().setNaviPath(pathIndexFromPathId);
            List<XPViaPoint> passedViasPoiInfo = TBTManager.getInstance().getPassedViasPoiInfo(TBTManager.getInstance().getCurrentNaviId());
            TBTManager.getInstance().setLastPassedIndexDiff(passedViasPoiInfo != null ? passedViasPoiInfo.size() : 0);
            return true;
        }
        return false;
    }

    public void updateOfflineRouteTryCount(int i) {
        if (i < 0) {
            return;
        }
        if (i > 0) {
            this.mTryCountOffline = 1;
        } else {
            this.mTryCountOffline = 1;
        }
    }

    public long getLastPathID() {
        return this.mLastPathID;
    }

    public void setRequestType(int i) {
        this.mRequestType = i;
    }

    public boolean getIsLastRadarOpen() {
        return this.mIsLastRadarOpen;
    }

    public void setIsLastRadarOpen(boolean z) {
        this.mIsLastRadarOpen = z;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    protected IXpLayerClickObserver getBizOverlayObserver() {
        return new IXpLayerClickObserver() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter.9
            @Override // com.autonavi.gbl.map.layer.observer.ILayerClickObserver
            public void onNotifyClick(BaseLayer baseLayer, LayerItem layerItem, ClickViewIdInfo clickViewIdInfo) {
                long j;
                try {
                    j = Long.parseLong(layerItem.getID());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    j = 0;
                }
                int businessType = layerItem.getBusinessType();
                L.Tag tag = NaviScenePresenter.TAG;
                L.i(tag, ">>> onNotifyClick id=" + j + " clickType =" + businessType);
                NaviScenePresenter.this.handleNotifyClick(j, businessType, layerItem);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNotifyClick(long j, int i, LayerItem layerItem) {
        double d;
        GuideLabelLayerItem guideLabelLayerItem;
        PointLayerItem pointLayerItem;
        Coord3DDouble position;
        double d2 = 0.0d;
        if (!(layerItem instanceof PointLayerItem) || (pointLayerItem = (PointLayerItem) layerItem) == null || (position = pointLayerItem.getPosition()) == null) {
            d = 0.0d;
        } else {
            d2 = position.lon;
            d = position.lat;
        }
        if (i == 5008) {
            if (layerItem instanceof GuideTrafficEventLayerItem) {
                handleBizRouteFacilityTypeTrafficEventTipClick(d2, d, (GuideTrafficEventLayerItem) layerItem);
            }
        } else if (i == 6009) {
            handleBizRouteTypePathClick(j, d2, d);
        } else if (i == 6022) {
            RouteTrafficEventTipsLayerItem routeTrafficEventTipsLayerItem = (RouteTrafficEventTipsLayerItem) layerItem;
            if (routeTrafficEventTipsLayerItem != null) {
                handleBizRouteTypeTrafficEventTipClick(routeTrafficEventTipsLayerItem.getMTrafficEventTipsInfo());
            }
        } else if (i != 6029) {
            if (i != 7010) {
                return;
            }
            handleGuideOverlayTypeParkingClick((int) j);
        } else if (!(layerItem instanceof GuideLabelLayerItem) || (guideLabelLayerItem = (GuideLabelLayerItem) layerItem) == null) {
        } else {
            long mPathId = guideLabelLayerItem.getMPathId();
            if (L.ENABLE) {
                L.d(TAG, "CANDIDATE_PATH onClick pathID: " + mPathId);
            }
            Coord3DDouble position2 = guideLabelLayerItem.getPosition();
            if (position2 != null) {
                d2 = position2.lon;
                d = position2.lat;
            }
            handleBizRouteTypeGuideLabelClick(mPathId, d2, d);
        }
    }

    private void handleBizRouteTypeGuideLabelClick(final long j, final double d, final double d2) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter.10
            @Override // java.lang.Runnable
            public void run() {
                TBTManager.getInstance().selectMainPathId(j);
                MapOpStatUtil.sendStatDataWhenMapClick(NaviScenePresenter.this.getLogicView().getMainContext(), BLParams.RouteOverlayGuide, 5, d, d2);
            }
        });
    }

    private void handleBizRouteFacilityTypeTrafficEventTipClick(final double d, final double d2, final GuideTrafficEventLayerItem guideTrafficEventLayerItem) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter.11
            @Override // java.lang.Runnable
            public void run() {
                GuideTrafficEventLayerItem guideTrafficEventLayerItem2 = guideTrafficEventLayerItem;
                if (guideTrafficEventLayerItem2 != null) {
                    NaviScenePresenter.this.onTrafficEventClick(d, d2, guideTrafficEventLayerItem2.getMId());
                }
            }
        });
    }

    private void handleBizRouteTypeTrafficEventTipClick(final RouteTrafficEventTipsPoint routeTrafficEventTipsPoint) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter.12
            @Override // java.lang.Runnable
            public void run() {
                RouteTrafficEventTipsPoint routeTrafficEventTipsPoint2 = routeTrafficEventTipsPoint;
                if (routeTrafficEventTipsPoint2 == null || routeTrafficEventTipsPoint2.mP20Point == null || routeTrafficEventTipsPoint.mTrafficIncident == null) {
                    return;
                }
                NaviScenePresenter.this.onTrafficEventClick(routeTrafficEventTipsPoint.mP20Point.lon, routeTrafficEventTipsPoint.mP20Point.lat, routeTrafficEventTipsPoint.mTrafficIncident.ID);
            }
        });
    }

    private void handleGuideOverlayTypeParkingClick(final int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter.13
            @Override // java.lang.Runnable
            public void run() {
                NaviScenePresenter.this.getLogicView().onSelectRecommendParking(i, false);
                if (!CollectionUtils.isNotEmpty(NaviScenePresenter.this.mRecommendParkData) || !CollectionUtils.isIndexLegal(i, NaviScenePresenter.this.mRecommendParkData) || NaviScenePresenter.this.mRecommendParkData.get(i) == null || NaviScenePresenter.this.mRecommendParkData.get(i).mPos3D == null) {
                    return;
                }
                MapOpStatUtil.sendStatDataWhenMapClick(NaviScenePresenter.this.getLogicView().getMainContext(), 525, 2, NaviScenePresenter.this.mRecommendParkData.get(i).mPos3D.lon, NaviScenePresenter.this.mRecommendParkData.get(i).mPos3D.lat);
            }
        });
    }

    private void handleBizRouteTypePathClick(final long j, final double d, final double d2) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter.14
            @Override // java.lang.Runnable
            public void run() {
                TBTManager.getInstance().selectMainPathId(j);
                MapOpStatUtil.sendStatDataWhenMapClick(NaviScenePresenter.this.getLogicView().getMainContext(), BLParams.RouteOverlayGuide, 5, d, d2);
            }
        });
    }

    public void onUpdateSAPA(List<XPFacilityInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isNotEmpty(list)) {
            StringBuilder sb = new StringBuilder("SAPA:");
            int i = -1;
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            for (XPFacilityInfo xPFacilityInfo : list) {
                if (arrayList.size() < 3 && (i2 < 2 || xPFacilityInfo.mType != 1)) {
                    if (xPFacilityInfo.mType == 1) {
                        i2++;
                    } else if (xPFacilityInfo.mType == 0) {
                        i++;
                        if (NaviUtil.isSapaHasCharge(xPFacilityInfo.mSapaDetail)) {
                            i3++;
                        }
                    }
                    SapaData sapaData = new SapaData(i4, i, i3, xPFacilityInfo);
                    SapaData cache = this.mSapaChargeDataHelper.getCache(xPFacilityInfo.mName);
                    if (cache != null) {
                        sapaData.mCharegeInfo = cache.mCharegeInfo;
                    }
                    arrayList.add(sapaData);
                    i4++;
                }
                sb.append(xPFacilityInfo.mName + ", ");
            }
            if (L.ENABLE) {
                L.d(TAG, sb.toString());
            }
        }
        this.mSapaDataList = arrayList;
        this.mSapaChargeDataHelper.update(this.mSapaDataList);
        updateSAPA();
    }

    public void updateSAPA() {
        getLogicView().onUpdateSAPA(this.mSapaDataList);
        if (L.ENABLE) {
            L.d(TAG, "updateSAPA interval");
        }
    }

    public boolean isHaveSAPA() {
        return CollectionUtils.isNotEmpty(this.mSapaDataList);
    }

    @MainThread
    public void updateOverViewState(boolean z, boolean z2) {
        boolean isMapLightColumn = Utils.isMapLightColumn();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateOverViewState: isMapLightColumn " + isMapLightColumn);
        }
        if (isMapLightColumn) {
            getLogicView().exchangeEagleEyeView(false, false);
        } else {
            getLogicView().exchangeEagleEyeView(z, z2);
        }
        getLogicView().onUpdateTrafficView(isMapLightColumn);
    }

    public void refresh2DCross() {
        XPCrossImageInfo naviCrossImageInfo = TBTManager.getInstance().getNaviCrossImageInfo();
        if (naviCrossImageInfo != null) {
            if (naviCrossImageInfo.mType == 1 || naviCrossImageInfo.mType == 3) {
                getLogicView().onShowCrossImage(naviCrossImageInfo);
            }
        }
    }

    public void refreshCross() {
        XPCrossImageInfo naviCrossImageInfo = TBTManager.getInstance().getNaviCrossImageInfo();
        if (naviCrossImageInfo != null) {
            getLogicView().onShowCrossImage(naviCrossImageInfo);
        }
    }

    @MainThread
    public void hide2DCrossImage() {
        XPCrossImageInfo naviCrossImageInfo = TBTManager.getInstance().getNaviCrossImageInfo();
        if (naviCrossImageInfo != null) {
            if (naviCrossImageInfo.mType == 1 || naviCrossImageInfo.mType == 3) {
                getLogicView().onHideCrossImage(naviCrossImageInfo.mType);
            }
        }
    }

    @MainThread
    public void hideCrossImage() {
        XPCrossImageInfo naviCrossImageInfo = TBTManager.getInstance().getNaviCrossImageInfo();
        if (naviCrossImageInfo != null) {
            getLogicView().onHideCrossImage(naviCrossImageInfo.mType);
        }
    }

    public XPCrossImageInfo getNaviCrossImageInfo() {
        return TBTManager.getInstance().getNaviCrossImageInfo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isOfflineReroute() {
        return this.mIsOfflineReroute;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOfflineReroute(boolean z) {
        this.mIsOfflineReroute = z;
    }

    public void onStop() {
        hideCrossImage();
    }

    public void naviToPark(View view) {
        switch (view.getId()) {
            case R.id.btn_recommend_park1 /* 2131296437 */:
                getLogicView().naviTo1thRecommendPark(view);
                return;
            case R.id.btn_recommend_park2 /* 2131296438 */:
                getLogicView().naviTo2thRecommendPark(view);
                return;
            case R.id.btn_recommend_park3 /* 2131296439 */:
                getLogicView().naviTo3thRecommendPark(view);
                return;
            default:
                return;
        }
    }

    public void showParkDetail(View view) {
        switch (view.getId()) {
            case R.id.btn_recommend_park1 /* 2131296437 */:
                getLogicView().show1thRecommendParkDetail(view);
                return;
            case R.id.btn_recommend_park2 /* 2131296438 */:
                getLogicView().show2thRecommendParkDetail(view);
                return;
            case R.id.btn_recommend_park3 /* 2131296439 */:
                getLogicView().show3thRecommendParkDetail(view);
                return;
            default:
                return;
        }
    }

    public void registerAccountEventCallback() {
        XPAccountServiceWrapper.getInstance().registerAccountEventCallback(this.mAccountEventCallback);
    }

    public void unRegisterAccountEventCallback() {
        XPAccountServiceWrapper.getInstance().unRegisterAccountEventCallback(this.mAccountEventCallback);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    public void onSelectRoute(int i) {
        if (L.ENABLE) {
            L.d(TAG, "setSelectRoute");
        }
        IPathResult currentNaviPathResult = TBTManager.getInstance().getCurrentNaviPathResult();
        if (currentNaviPathResult != null) {
            TBTManager.getInstance().selectMainPathId(TBTUtil.getPathId(currentNaviPathResult.getPath(i)));
        }
    }

    public void switchSmartScale(SpeechNaviEvent speechNaviEvent) {
        if (speechNaviEvent == null) {
            L.e(TAG, "switchSmartScale event is null");
        } else if (speechNaviEvent.getSwitchState()) {
            enableDynamicLevel();
        } else {
            disableDynamicLevel();
        }
    }

    public void exitSROrLaneMode() {
        switchToSDForShowView();
    }

    public void refreshSpeedInfo() {
        if (Utils.isLandscape() && isLaneViewShow()) {
            int limitSpeed = SRNaviManager.getInstance().getLimitSpeed();
            int cruiseSpeed = SRNaviManager.getInstance().getCruiseSpeed();
            if (limitSpeed != 0) {
                updateLimitSpeed(limitSpeed);
            }
            if (cruiseSpeed != 0) {
                updateAccSpeed(cruiseSpeed);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter, com.xiaopeng.montecarlo.scenes.navi.BaseNgpPresenter
    public void updateDriveModeStatus(int i) {
        super.updateDriveModeStatus(i);
        if (Utils.isLandscape() && isLaneViewShow()) {
            updateAccSpeed(SRNaviManager.getInstance().getCruiseSpeed());
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    public void updateAccSpeed(float f) {
        getLogicView().onUpdateAccSpeed(f > 0.0f ? String.format(Locale.getDefault(Locale.Category.FORMAT), "%d", Integer.valueOf(Math.round(f))) : "");
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    public void updateLimitSpeed(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateLimitSpeed speed = " + i);
        }
        getLogicView().onUpdateLimitSpeed(i > 0 ? String.valueOf(i) : "");
    }

    public void resetDefaultSRViewAngle() {
        if (1 != this.mSRViewAngleOperator.getCurrentSRViewAngle()) {
            L.i(TAG, "onStateImmersion, set default SR view angle and mSRViewAngleBtnGroup clear check");
            this.mSRViewAngleOperator.setSrViewAngle(1);
            getLogicView().clearSRViewAngleBtnGroupCheck();
        }
    }

    public void setSRViewAngle(int i) {
        this.mSRViewAngleOperator.setSrViewAngle(i);
    }
}
