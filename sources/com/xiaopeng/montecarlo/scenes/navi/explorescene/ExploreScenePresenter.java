package com.xiaopeng.montecarlo.scenes.navi.explorescene;

import android.os.Bundle;
import androidx.annotation.MainThread;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.path.model.RouteLimitInfo;
import com.autonavi.gbl.layer.GuideLabelLayerItem;
import com.autonavi.gbl.layer.GuideTrafficEventLayerItem;
import com.autonavi.gbl.layer.RouteTrafficEventTipsLayerItem;
import com.autonavi.gbl.layer.model.BizRoadFacilityType;
import com.autonavi.gbl.layer.model.RouteTrafficEventTipsPoint;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.PointLayerItem;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.model.PathMatchInfo;
import com.autonavi.gbl.map.layer.observer.impl.ClickViewIdInfo;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.bridge.NaviBridge;
import com.xiaopeng.montecarlo.constants.SystemConst;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.route.RouteDetailInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.mapdisplay.IXpLayerClickObserver;
import com.xiaopeng.montecarlo.navcore.setting.SettingBLManager;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.tts.TTSProxy;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import com.xiaopeng.montecarlo.navcore.util.CalculatePreviewUtil;
import com.xiaopeng.montecarlo.navcore.util.TBTUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.ViasHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.OddDataHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCameraInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navresetore.NavRestoreManager;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.NaviMapDecoratorRouteUpdateListener;
import com.xiaopeng.montecarlo.scenes.navi.NaviParallelRoadEventHandler;
import com.xiaopeng.montecarlo.scenes.navi.NaviPresenterData;
import com.xiaopeng.montecarlo.scenes.navi.NaviPresenterListener;
import com.xiaopeng.montecarlo.scenes.navi.NaviRestrictEventCallback;
import com.xiaopeng.montecarlo.scenes.navi.NaviRouteUpdateContractImpl;
import com.xiaopeng.montecarlo.scenes.navi.NaviSceneMapFragmentListener;
import com.xiaopeng.montecarlo.scenes.navi.NaviXPNetworkListener;
import com.xiaopeng.montecarlo.scenes.navi.SRNaviListener;
import com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract;
import com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.scenes.routescene.RouteVuiHelper;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.stat.ExploreStatUtil;
import com.xiaopeng.montecarlo.stat.MapOpStatUtil;
import com.xiaopeng.montecarlo.stat.NaviStatUtil;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.views.RouteDetailPanel;
import com.xiaopeng.xui.widget.XLinearLayout;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
/* loaded from: classes3.dex */
public class ExploreScenePresenter extends BaseNaviPresenter<IExploreContract.LogicView> implements IExploreContract.Presenter {
    private static final L.Tag TAG = new L.Tag("ExploreScenePresenter");
    public static final int UPDATE_INTERVAL_TIME = 10000;
    private XPPointBaseData[] mCameras;
    private boolean mIsClickStartNavi;
    private boolean mIsFirstEnter;
    private boolean mIsStartNaviImmediately;
    private long mLastTime;

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    protected int getTBTStatus() {
        return 2;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter, com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    protected boolean isIgnoreDeletePath() {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    protected boolean isPreview() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter, com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onDestroy() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter, com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
    }

    public ExploreScenePresenter(IExploreContract.LogicView logicView) {
        super(logicView);
        this.mLastTime = System.currentTimeMillis();
        this.mIsClickStartNavi = false;
        this.mIsStartNaviImmediately = false;
        this.mIsFirstEnter = true;
        getLogicView().setPresenter(this);
    }

    public void startExplore(boolean z, long j, int i) {
        if (L.ENABLE) {
            L.d(TAG, "startExplore");
        }
        updateTBTInfo(z, j, i);
    }

    public void updateTBTInfo(boolean z, long j, int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateTBTInfo isNeedStartNavi:" + z);
        }
        updateTBTAndRoute(z, j, i);
    }

    public void updateExplorePanel(boolean z) {
        if (L.ENABLE) {
            L.d(TAG, "updateExplorePanel");
        }
        if (1 == StateManager.getInstance().getState()) {
            getLogicView().onStateImmersion();
            StateManager.getInstance().setStateMode(1);
        } else {
            getLogicView().onStateActive();
            StateManager.getInstance().start(1, 10000);
        }
        if (TBTManager.getInstance().isSimulateGuidance()) {
            getLogicView().onShowSimulatePanel();
        } else {
            getLogicView().onHideSimulatePanel();
        }
        if (z) {
            getLogicView().onShowRoute(TBTManager.getInstance().getCurrentNaviPathResult(), TBTManager.getInstance().getCurrentNaviPathIndex());
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    public void enterOverViewMode() {
        if (L.ENABLE) {
            L.d(TAG, "enterOverViewMode");
        }
        if (TBTManager.getInstance().getNaviPath() != null) {
            this.mSavedMapMode = getMapView().getMapMode();
            this.mSavedMapLevel = getMapView().getMapLevel();
            getMapView().getBizControlManager().openDynamicLevel(false);
            getMapView().getBizControlManager().setFollowMode(false);
            getMapView().setMapMode(0, false);
            updatePreview();
            return;
        }
        L.e(TAG, "enterOverViewMode naviPath is null.");
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    protected NaviPresenterListener getNaviPresenterListener() {
        return new NaviPresenterListener.Builder().naviStateListener(new ExploreNaviStateListener(getLogicView(), this)).naviSpeechEventHandler(new ExploreNaviSpeechEventHandler(getLogicView(), this)).restrictEventCallback(new NaviRestrictEventCallback()).rerouteListener(new ExploreNaviRerouteListener(getLogicView(), this)).mapDecoratorRouteUpdateListener(new NaviMapDecoratorRouteUpdateListener(getLogicView(), this)).recommendRouteSwitchListener(new ExploreNaviRecommendRouteSwitchListener(getLogicView(), this)).parallelRoadEventHandler(new NaviParallelRoadEventHandler(getLogicView(), this)).naviListener(new ExploreNaviListener(getLogicView(), this)).sceneMapFragmentListener(new NaviSceneMapFragmentListener(getLogicView(), this)).setXPNetworkListener(new NaviXPNetworkListener(getLogicView(), this)).setRouteUpdateListener(new NaviRouteUpdateContractImpl(getLogicView(), this)).setSRInfoChangedListener(new SRNaviListener(getLogicView(), this)).build();
    }

    public void updatePreview() {
        if (L.ENABLE) {
            L.d(TAG, "updatePreview");
        }
        IPathResult currentNaviPathResult = TBTManager.getInstance().getCurrentNaviPathResult();
        if (currentNaviPathResult != null) {
            if (TBTManager.getInstance().getNaviInfo() != null) {
                updatePreviewByCurrentLocation();
            } else {
                updatePreviewByBound(CalculatePreviewUtil.getPathBound(currentNaviPathResult));
            }
        }
    }

    @MainThread
    public void updatePreviewByCurrentLocation() {
        if (L.ENABLE) {
            L.d(TAG, "updatePreviewByCurrentLocation");
        }
        IPathResult currentNaviPathResult = TBTManager.getInstance().getCurrentNaviPathResult();
        if (currentNaviPathResult != null) {
            RectDouble naviPathBound = CalculatePreviewUtil.getNaviPathBound(TBTManager.getInstance().getCurrentNaviVariantPath(), TBTManager.getInstance().getNaviInfo());
            if (naviPathBound != null) {
                L.Tag tag = TAG;
                L.i(tag, ">>>updatePreviewByCurrentLocation rect[" + naviPathBound.left + ", " + naviPathBound.top + ", " + naviPathBound.right + ", " + naviPathBound.bottom);
            }
            if (isRectDoubleValid(naviPathBound)) {
                updatePreviewByBound(naviPathBound);
            } else {
                updatePreviewByBound(CalculatePreviewUtil.getPathBound(currentNaviPathResult));
            }
        } else if (L.ENABLE) {
            L.e(TAG, "updatePreviewByCurrentLocation pathResult is null.");
        }
    }

    private void updatePreviewByBound(RectDouble rectDouble) {
        RouteParams currentNaviRouteParams;
        if (L.ENABLE) {
            L.d(TAG, "updatePreviewByBound");
        }
        if (rectDouble != null && (currentNaviRouteParams = TBTManager.getInstance().getCurrentNaviRouteParams()) != null && currentNaviRouteParams.mEndInfo != null) {
            rectDouble = CalculatePreviewUtil.rectUnion(rectDouble, currentNaviRouteParams.mEndInfo.getDisplayLon(), currentNaviRouteParams.mEndInfo.getDisplayLat());
        }
        getLogicView().onUpdatePreview(rectDouble);
    }

    public void updateLastUpdateTime() {
        if (L.ENABLE) {
            L.d(TAG, "updateLastUpdateTime");
        }
        this.mLastTime = System.currentTimeMillis();
    }

    public void destroyExplore() {
        CarLoc originCarLocation;
        PathMatchInfo pathMatchInfo;
        if (L.ENABLE) {
            L.d(TAG, "destroyExplore");
        }
        exitOverviewMode(StateManager.getInstance().getState() != 0);
        if (this.mIsNeedGotoMapCenter && (originCarLocation = TBTManager.getInstance().getOriginCarLocation()) != null) {
            if (CollectionUtils.isNotEmpty(originCarLocation.vecPathMatchInfo) && (pathMatchInfo = originCarLocation.vecPathMatchInfo.get(0)) != null) {
                TBTManager.getInstance().getPosServiceWrapper().setMockCarLocation(new XPCoordinate2DDouble(pathMatchInfo.longitude, pathMatchInfo.latitude));
            }
            getMapView().getBizControlManager().setCarLocation(originCarLocation);
            getMapView().goToMapCenter(originCarLocation);
        }
        EventBus.getDefault().unregister(this);
        TBTManager.getInstance().removeNaviListener(getNaviListener());
        getRerouteListener().stopOnlineRouteRetryTimer();
        TBTManager.getInstance().removeRerouteListener(getRerouteListener());
        SRNaviManager.getInstance().removeSRInfoChangedListener(getSRInfoChangedListener());
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter, com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onResume() {
        super.onResume();
        if (this.mIsFirstEnter) {
            this.mIsFirstEnter = false;
            enterOverViewMode();
            updateExplorePanel(false);
        } else {
            updateExplorePanel(true);
            updateRemainDis();
        }
        restoreRecommendRouteShow();
        StateManager.getInstance().addListener(getStateListener());
        SettingBLManager.getInstance().setRadarState();
        getLogicView().renderLayoutByDayNightStatus();
    }

    public void updateCameraViews() {
        if (L.ENABLE) {
            L.d(TAG, "updateCameraViews");
        }
        getLogicView().onUpdateIntervalCameraDynamicInfo(TBTManager.getInstance().getNaviIntervalDynamicCameras());
        getLogicView().onUpdateNaviCamera(TBTManager.getInstance().getNaviCamera());
        getLogicView().onShowNaviIntervalCamera(TBTManager.getInstance().getNaviIntervalCameras());
    }

    public void updateNaviLaneViews() {
        XPLaneInfo naviLaneInfo = TBTManager.getInstance().getNaviLaneInfo();
        if (naviLaneInfo != null) {
            getLogicView().onShowNaviLaneInfo(naviLaneInfo);
        } else {
            getLogicView().onHideNaviLaneInfo();
        }
    }

    private void updateManeuverInfo() {
        XPManeuverInfo naviManeuverInfo = TBTManager.getInstance().getNaviManeuverInfo();
        if (naviManeuverInfo != null) {
            getLogicView().onAsyncManeuverInfo(naviManeuverInfo);
            updateNaviManeuerInfo(naviManeuverInfo);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter, com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onPause() {
        super.onPause();
        StateManager.getInstance().removeListener(getStateListener());
    }

    public void showNavCameraImage(List<XPCameraInfo> list) {
        int i = 0;
        if (CollectionUtils.isNotEmpty(list)) {
            this.mCameras = new XPPointBaseData[list.size()];
            for (XPCameraInfo xPCameraInfo : list) {
                XPPointBaseData xPPointBaseData = new XPPointBaseData();
                xPPointBaseData.id = xPCameraInfo.toString();
                xPPointBaseData.position.lon = xPCameraInfo.mCoord2D.mLon;
                xPPointBaseData.position.lat = xPCameraInfo.mCoord2D.mLat;
                this.mCameras[i] = xPPointBaseData;
                i++;
            }
            getMapView().getBizControlManager().addItems(BizControlWrapper.BIZ_CONTROL_TYPE_ROADFACILITY, BizRoadFacilityType.BizRoadFacilityTypeGuideCameraNormal, this.mCameras);
            return;
        }
        XPPointBaseData[] xPPointBaseDataArr = this.mCameras;
        if (xPPointBaseDataArr == null || xPPointBaseDataArr.length <= 0) {
            return;
        }
        while (i < this.mCameras.length) {
            getMapView().getBizControlManager().removeItem(BizControlWrapper.BIZ_CONTROL_TYPE_ROADFACILITY, BizRoadFacilityType.BizRoadFacilityTypeGuideCameraNormal, this.mCameras[i].id);
            i++;
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    protected void beforeStopNavi(boolean z) {
        XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
        if (TBTManager.getInstance().getCurrentNaviVariantPath() == null || naviInfo == null) {
            return;
        }
        if (z) {
            ExploreStatUtil.sendStatDataWhenExitRoutingByButton(getLogicView().getMainContext());
        } else {
            NaviStatUtil.sendStatDataWhenSystemStopNavi(getLogicView().getMainContext(), TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation(), (float) naviInfo.mRouteRemainDist, TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentNaviId()));
        }
    }

    public void updateViaPass(long j) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateViaPass: " + j);
        }
        getLogicView().onUpdateViaPass(j);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    public boolean deleteCandidatePath(List<Long> list, long j) {
        if (super.deleteCandidatePath(list, j)) {
            updatePreview();
            return true;
        }
        return false;
    }

    public int getSelectRoute() {
        return TBTManager.getInstance().getCurrentNaviPathIndex();
    }

    public void setSelectRoute(int i) {
        if (L.ENABLE) {
            L.d(TAG, "setSelectRoute");
        }
        IPathResult currentNaviPathResult = TBTManager.getInstance().getCurrentNaviPathResult();
        if (currentNaviPathResult != null) {
            TBTManager.getInstance().selectMainPathId(TBTUtil.getPathId(currentNaviPathResult.getPath(i)));
            updatePreview();
        }
    }

    public void startGuidance() {
        startGuidance(false, true, false);
    }

    public void startGuidance(boolean z, boolean z2, boolean z3) {
        if (L.ENABLE) {
            L.d(TAG, "startGuidance");
        }
        destroyExplore();
        Bundle bundle = new Bundle();
        bundle.putBoolean(NaviUtil.IS_NEED_START_NAVI_KEY, false);
        bundle.putBoolean(SystemConst.ROUTE_MANUAL, z);
        bundle.putBoolean(NaviUtil.IS_NEED_TTSPROXY_SPEAK, z2);
        bundle.putBoolean(NaviUtil.IS_NEED_TO_SR, z3);
        bundle.putLong(SystemConst.START_NAVI_ID, TBTManager.getInstance().getCurrentNaviId());
        bundle.putInt(SystemConst.START_NAVI_PATH_INDEX, TBTManager.getInstance().getCurrentNaviPathIndex());
        if (this.mTryCountOffline > 0) {
            bundle.putInt(SystemConst.ISOFFLINE_TYPE_KEY, 0);
        }
        IVariantPath variantPath = TBTManager.getInstance().getVariantPath(TBTManager.getInstance().getCurrentNaviId(), TBTManager.getInstance().getCurrentNaviPathIndex());
        if (variantPath != null) {
            ViasHelper.getInstance().updateViaInfos(variantPath.getPathId());
        }
        getLogicView().startScene(new NaviBridge().enableKillTopSceneMode().setBundle(bundle));
    }

    public boolean isDrawMultiRoute() {
        return !TBTManager.getInstance().isSimulateGuidance();
    }

    public boolean getClickStartNaviState() {
        return this.mIsClickStartNavi;
    }

    public void setClickStartNaviState(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setClickStartNaviState state:" + z);
        }
        this.mIsClickStartNavi = z;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    public void onShowRecommendRoute(IPathResult iPathResult, IVariantPath iVariantPath, int i, RouteLimitInfo routeLimitInfo) {
        if (i < 0 || routeLimitInfo == null || 5 == i) {
            return;
        }
        super.onShowRecommendRoute(iPathResult, iVariantPath, i, routeLimitInfo);
        onNewRoute(iPathResult, iVariantPath, i, routeLimitInfo);
    }

    public void onNewRoute(IPathResult iPathResult, IVariantPath iVariantPath, int i, RouteLimitInfo routeLimitInfo) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onNewRoute routeType:" + i);
        }
        getLogicView().hideRouteChargePanelView(true);
        getMapView().getBizControlManager().removeRoute(BLParams.RouteOverlayGuide, true);
        updateTBTInfo(false, TBTManager.getInstance().getCurrentNaviId(), TBTManager.getInstance().getCurrentNaviPathIndex());
        updatePreview();
    }

    public void showExploreEnterVoiceAlert() {
        L.i(TAG, "show explore enter voice alert!");
        TTSProxy.getInstance().speak(ContextUtils.getString(R.string.explore_page_enter_voice_alert), null);
    }

    public boolean getIsStartNaviImmediately() {
        return this.mIsStartNaviImmediately;
    }

    public void setIsStartNaviImmediately(boolean z) {
        this.mIsStartNaviImmediately = z;
    }

    public long getLastTime() {
        return this.mLastTime;
    }

    public void setLastTime(long j) {
        this.mLastTime = j;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    protected IXpLayerClickObserver getBizOverlayObserver() {
        return new IXpLayerClickObserver() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreScenePresenter.1
            @Override // com.autonavi.gbl.map.layer.observer.ILayerClickObserver
            public void onNotifyClick(BaseLayer baseLayer, LayerItem layerItem, ClickViewIdInfo clickViewIdInfo) {
                if (TBTManager.getInstance().getCurrentStatus() != 2) {
                    return;
                }
                if (!ExploreScenePresenter.this.preventMultiClick()) {
                    L.i(ExploreScenePresenter.TAG, "onNotifyClick preventMultiClick");
                    return;
                }
                long j = 0;
                try {
                    j = Long.parseLong(layerItem.getID());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                int itemType = layerItem.getItemType();
                int businessType = layerItem.getBusinessType();
                if (L.ENABLE) {
                    L.Tag tag = ExploreScenePresenter.TAG;
                    L.d(tag, "onClick id: " + j + ", itemType: " + itemType + " clickType: " + businessType);
                }
                ExploreScenePresenter.this.handleNotifyClick(j, businessType, layerItem);
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
        } else {
            if (i != 6022) {
                if (i == 6029 && (layerItem instanceof GuideLabelLayerItem) && (guideLabelLayerItem = (GuideLabelLayerItem) layerItem) != null) {
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
            } else {
                RouteTrafficEventTipsLayerItem routeTrafficEventTipsLayerItem = (RouteTrafficEventTipsLayerItem) layerItem;
                if (routeTrafficEventTipsLayerItem != null) {
                    handleBizRouteTypeTrafficEventTipClick(routeTrafficEventTipsLayerItem.getMTrafficEventTipsInfo());
                }
            }
        }
    }

    private void handleBizRouteTypeTrafficEventTipClick(final RouteTrafficEventTipsPoint routeTrafficEventTipsPoint) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreScenePresenter.2
            @Override // java.lang.Runnable
            public void run() {
                RouteTrafficEventTipsPoint routeTrafficEventTipsPoint2 = routeTrafficEventTipsPoint;
                if (routeTrafficEventTipsPoint2 == null || routeTrafficEventTipsPoint2.mP20Point == null || routeTrafficEventTipsPoint.mTrafficIncident == null) {
                    return;
                }
                ExploreScenePresenter.this.onTrafficEventClick(routeTrafficEventTipsPoint.mP20Point.lon, routeTrafficEventTipsPoint.mP20Point.lat, routeTrafficEventTipsPoint.mTrafficIncident.ID);
            }
        });
    }

    private void handleBizRouteFacilityTypeTrafficEventTipClick(final double d, final double d2, final GuideTrafficEventLayerItem guideTrafficEventLayerItem) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreScenePresenter.3
            @Override // java.lang.Runnable
            public void run() {
                GuideTrafficEventLayerItem guideTrafficEventLayerItem2 = guideTrafficEventLayerItem;
                if (guideTrafficEventLayerItem2 != null) {
                    ExploreScenePresenter.this.onTrafficEventClick(d, d2, guideTrafficEventLayerItem2.getMId());
                }
            }
        });
    }

    private void handleBizRouteTypeGuideLabelClick(final long j, final double d, final double d2) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreScenePresenter.4
            @Override // java.lang.Runnable
            public void run() {
                IPathResult routePathResult = TBTManager.getInstance().getRoutePathResult(TBTManager.getInstance().getCurrentRouteRequestId());
                if (routePathResult != null) {
                    ExploreScenePresenter.this.getLogicView().onSelectRoute(routePathResult.getPathIndex(j));
                    MapOpStatUtil.sendStatDataWhenMapClick(ExploreScenePresenter.this.getLogicView().getMainContext(), BLParams.RouteOverlayGuide, 5, d, d2);
                }
            }
        });
    }

    private void handleBizRouteTypePathClick(final long j, final double d, final double d2) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreScenePresenter.5
            @Override // java.lang.Runnable
            public void run() {
                IPathResult routePathResult = TBTManager.getInstance().getRoutePathResult(TBTManager.getInstance().getCurrentRouteRequestId());
                if (routePathResult != null) {
                    ExploreScenePresenter.this.getLogicView().onSelectRoute(routePathResult.getPathIndex(j));
                    MapOpStatUtil.sendStatDataWhenMapClick(ExploreScenePresenter.this.getLogicView().getMainContext(), BLParams.RouteOverlayGuide, 5, d, d2);
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviPresenter
    public void onViewCreated(NaviPresenterData naviPresenterData) {
        EventBus.getDefault().register(this);
        NavRestoreManager.getInstance().addRestoreListener(this);
        TBTManager.getInstance().addNaviListener(getNaviListener());
        TBTManager.getInstance().addRerouteListener(getRerouteListener());
        SRNaviManager.getInstance().addSRInfoChangedListener(getSRInfoChangedListener());
        updateOverlayObserver(true, new String[0]);
        setClickStartNaviState(false);
        OddDataHelper.getInstance().addUpdateOddInfoListener(this);
        getLogicView().initRestrictHelper();
        RouteRequest routeRequest = naviPresenterData.getRouteRequest();
        long naviId = naviPresenterData.getNaviId();
        int pathIndex = naviPresenterData.getPathIndex();
        if (!naviPresenterData.getIsFirstEnter() && TBTManager.getInstance().isNaviStop()) {
            resetWhenNoNavi();
            return;
        }
        if (routeRequest != null) {
            requestReroute(routeRequest, 0);
        } else {
            startExplore(naviPresenterData.getIsNeedStartNavi(), naviId, pathIndex);
            if (naviPresenterData.getIsFromCommuting() || naviPresenterData.getIsReqRestrict()) {
                requestRestrict();
            }
            if (naviPresenterData.getOfflineRemainCount() != -1) {
                setTryCountOffline(1);
            }
        }
        if (naviPresenterData.getIsFirstEnter()) {
            exploreEnterVoiceAlertController(naviPresenterData);
            getLogicView().showStartExploreMsg();
        }
        getLogicView().getMainContext().setSceneMapFragmentListener(getSceneMapFragmentListener());
        XPNetworkManager.INSTANCE.addNetworkListener(getXPNetworkListener());
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNaviPresenter
    public void onDestroyView() {
        setClickStartNaviState(false);
        getLogicView().getMainContext().removeSceneMapFragmentListener(getSceneMapFragmentListener());
        destroyExplore();
        updateOverlayObserver(false, new String[0]);
        RestrictHelper restrictHelper = getLogicView().getRestrictHelper();
        if (restrictHelper != null) {
            restrictHelper.unInit();
        }
        getLogicView().getMainContext().updateRecenterShowTag(true);
        XPNetworkManager.INSTANCE.removeNetworkListener(getXPNetworkListener());
        getLogicView().unInitData();
        NavRestoreManager.getInstance().removeRestoreListener(this);
        OddDataHelper.getInstance().removeUpdateOddInfoListener(this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract.Presenter
    public void onNewBridge(NaviPresenterData naviPresenterData) {
        if (naviPresenterData == null) {
            throw new IllegalArgumentException(" NaviPresenterData is null");
        }
        requestReroute(naviPresenterData.getRouteRequest(), naviPresenterData.getRequestType() > -1 ? naviPresenterData.getRequestType() : 0, naviPresenterData.getIsFilterCharge());
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    public void onSelectRoute(int i) {
        L.Tag tag = TAG;
        L.i(tag, "onSelectRoute index:" + i);
        sendStatDataWhenRouteSelect(i);
        if (i == getSelectRoute()) {
            updatePreview();
            return;
        }
        setSelectRoute(i);
        getLogicView().updateViewOnSelectRoute(i);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract.Presenter
    public void onUpdateNaviInfo(List<XPNaviInfo> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            getLogicView().updateNaviInfo(list, i);
        }
        getLogicView().onUpdateNaviInfo(list);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract.Presenter
    public XPNaviInfo getNaviInfo(List<XPNaviInfo> list, long j) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            XPNaviInfo xPNaviInfo = list.get(i);
            if (xPNaviInfo != null && j == xPNaviInfo.mPathID) {
                return xPNaviInfo;
            }
        }
        return null;
    }

    public IVariantPath getVariantPath(long j) {
        IPathResult currentNaviPathResult = TBTManager.getInstance().getCurrentNaviPathResult();
        if (currentNaviPathResult != null) {
            return currentNaviPathResult.getPath(j);
        }
        return null;
    }

    private void sendStatDataWhenStartNavi() {
        ExploreStatUtil.sendStatDataWhenStartNavi(getLogicView().getMainContext());
    }

    private void sendStatDataWhenRouteSelect(int i) {
        MainContext mainContext = getLogicView().getMainContext();
        if (i == 0) {
            ExploreStatUtil.sendStatDataWhenFirstCardSelected(mainContext);
        } else if (i == 1) {
            ExploreStatUtil.sendStatDataWhenSecondCardSelected(mainContext);
        } else if (i != 2) {
        } else {
            ExploreStatUtil.sendStatDataWhenThirdCardSelected(mainContext);
        }
    }

    private void exploreEnterVoiceAlertController(NaviPresenterData naviPresenterData) {
        if (naviPresenterData == null || naviPresenterData.getIsFromCommuting() || !naviPresenterData.getIsNeedTTSProxySpeak()) {
            return;
        }
        showExploreEnterVoiceAlert();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    protected void exitPreviewByNaviStop() {
        if (isPreview()) {
            getMapView().exitPreview(true, true);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        switch (speechNaviEvent.what) {
            case 407:
                L.i(TAG, "SPEECH_MAP_MODE_NORTH_UP");
                getLogicView().getSpeechEventBizHelper().setMapModeNorthUpNotSupported(iCommandCallback);
                return true;
            case SpeechNaviEvent.SPEECH_MAP_MODE_HEAD_UP_2D /* 408 */:
                L.i(TAG, "SPEECH_MAP_MODE_HEAD_UP_2D");
                getLogicView().getSpeechEventBizHelper().setMapModeHeadUp2DNotSupported(iCommandCallback);
                return true;
            case SpeechNaviEvent.SPEECH_MAP_MODE_HEAD_UP_3D /* 409 */:
                L.i(TAG, "SPEECH_MAP_MODE_HEAD_UP_3D");
                getLogicView().getSpeechEventBizHelper().setMapModeHeadUp3DNotSupported(iCommandCallback);
                return true;
            default:
                return super.onSpeechEvent(speechNaviEvent, iCommandCallback);
        }
    }

    public void collectRouteDetailInfoForVui(RouteDetailInfo routeDetailInfo, int i, XLinearLayout xLinearLayout, RouteDetailPanel routeDetailPanel, String str) {
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("collectRouteDetailInfoForVui"));
        }
        RouteVuiHelper.updateRouteVui(routeDetailInfo, i, xLinearLayout, routeDetailPanel, getLogicView().getMainContext().getCurrentScene());
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter
    public void enableLaneNaviMode() {
        stopSwitchToSRTimer();
    }
}
