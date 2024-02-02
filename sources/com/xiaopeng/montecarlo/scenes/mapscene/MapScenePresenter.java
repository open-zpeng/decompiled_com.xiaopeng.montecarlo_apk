package com.xiaopeng.montecarlo.scenes.mapscene;

import android.app.Application;
import android.graphics.Point;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.layer.model.BizRouteType;
import com.autonavi.gbl.map.adapter.MapSurfaceView;
import com.autonavi.gbl.map.model.MapLabelItem;
import com.autonavi.gbl.pos.model.LocParallelRoadInfo;
import com.xiaopeng.lib.bughunter.anr.UILooperObserver;
import com.xiaopeng.montecarlo.appengine.MapStatusService;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.BasePresenter;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.bridge.SearchResultBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.mapoverlay.poidetail.PoiDetailDecorator;
import com.xiaopeng.montecarlo.mapoverlay.search.SearchDecorator;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
import com.xiaopeng.montecarlo.navcore.database.LccGeoFenceDataHelper;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.LccGeoFenceInfo;
import com.xiaopeng.montecarlo.navcore.event.DRDebugEvent;
import com.xiaopeng.montecarlo.navcore.event.GuideWrapperNaviEvent;
import com.xiaopeng.montecarlo.navcore.event.ParallelRoadEvent;
import com.xiaopeng.montecarlo.navcore.event.SRDebugEvent;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.location.LocationServiceManager;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.setting.SettingBLManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.speech.bean.SpeechDataCenterPoi;
import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.util.CommonUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TTSManager;
import com.xiaopeng.montecarlo.root.account.AccountEventCallback;
import com.xiaopeng.montecarlo.root.account.AccountObservable;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.AudioManagerWrapper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.scenes.mapscene.IMapContract;
import com.xiaopeng.montecarlo.scenes.mapscene.SceneMapEvent;
import com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack;
import com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.MapDataProvider;
import com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.MapSceneRequestParam;
import com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.MapSceneResultData;
import com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.MapStatus;
import com.xiaopeng.montecarlo.scenes.mapscene.favoriteoverlay.FavoriteOverlayManager;
import com.xiaopeng.montecarlo.stat.MapOpStatUtil;
import com.xiaopeng.montecarlo.trafficevent.TrafficEventPopParam;
import com.xiaopeng.montecarlo.util.ActivityLifecycleHelper;
import com.xiaopeng.montecarlo.util.AudioUtil;
import com.xiaopeng.montecarlo.util.MapUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.views.XPMapSurfaceView;
import com.xiaopeng.montecarlo.views.volumn.VolumePanelView;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes2.dex */
public class MapScenePresenter extends BasePresenter implements IMapContract.Presenter, IMapDataCallBack, VolumePanelView.IVolumePanelEventListener, AudioUtil.IAudioChangedListener {
    private static final int NAVI_VOLUME_REMEMBER_TIMES = 3;
    private static final int PER_DELAY_SYNC_MAP_OPERATION_TO_AI = 5000;
    private static final int QUERY_CP_INTERVAL = 600000;
    private static final L.Tag TAG = new L.Tag("MapScenePresenter");
    private static final int VOLUME_ILLEGAL = -1;
    protected final Application mApplication;
    private boolean mChargeEnable;
    private FavoriteOverlayManager mFavoriteOverlayManager;
    private boolean mHasSendVolStatData;
    private LccGeoFenceHelper mLccGeoFenceHelper;
    protected IMapContract.LogicView mLogicView;
    protected MainContext mMainContext;
    protected CustomMapListener mMapListener;
    private MapPrepareLayerStyle mMapStyleReader;
    protected MapViewWrapper mMapViewWrapper;
    private ScratchSpotBroadcastHelper mScratchSpotBroadcastHelper;
    private long mLastSyncTimeToAI = 0;
    private boolean mIsNeedShowRecenter = true;
    private boolean mIsLocationInfoShow = false;
    private boolean mShowVolumePanel = true;
    private List<XPPoiInfo> mShowCPList = new ArrayList();
    private int mSystemVolume = -1;
    private MapDataProviderProxy mMapDataProviderProxy = new MapDataProviderProxy(this);
    private MapDataProvider mMapDataProvider = new MapDataProvider(this.mMapDataProviderProxy);
    private boolean mShowRecenterAlways = false;
    private XPCarStateListener mXPCarStateListener = new XPCarStateListener();
    private AccountEventCallback mAccountEventCallback = new AccountEventCallback() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.1
        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void accountSyncFinish() {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void amapQuickLogin() {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void xpMapLogin() {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void refreshSettingInfos(int i, int i2) {
            L.i(MapScenePresenter.TAG, "account refresh");
            MapScenePresenter.this.updateInfoWhenAccountChanged();
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void initAccountFinish() {
            L.i(MapScenePresenter.TAG, "init account finish");
            MapScenePresenter.this.updateInfoWhenAccountChanged();
        }
    };
    private Observer mXPAccountChangeObserver = new Observer() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.2
        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            UserInfo userInfo;
            if (!(obj instanceof UserInfo) || (userInfo = (UserInfo) obj) == null) {
                return;
            }
            UserInfo.InfoType infoType = userInfo.getInfoType();
            UserInfo.UserType userType = userInfo.getUserType();
            L.Tag tag = MapScenePresenter.TAG;
            L.i(tag, "mXPAccountChangeObserver update infoType = " + infoType + ", userType = " + userType);
            if (infoType == UserInfo.InfoType.CHANGED) {
                MapScenePresenter.this.setChargeEnable(SettingWrapper.isChargeEnable());
            }
        }
    };

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack
    public int getChargeUpdateInterval() {
        return 600000;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataCache(@NonNull MapSceneResultData mapSceneResultData) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchStart(MapSceneRequestParam mapSceneRequestParam) {
    }

    public MapScenePresenter(@NonNull Application application, @NonNull IMapContract.LogicView logicView, @NonNull MainContext mainContext) {
        if (logicView == null) {
            throw new IllegalArgumentException("logicView is null");
        }
        if (mainContext == null) {
            throw new IllegalArgumentException("mainContext is null");
        }
        this.mApplication = application;
        this.mLogicView = logicView;
        this.mMainContext = mainContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInfoWhenAccountChanged() {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.3
            @Override // java.lang.Runnable
            public void run() {
                MapScenePresenter.this.updateTTSPlayStyle();
                MapScenePresenter.this.updateMapMode();
                MapScenePresenter.this.setChargeEnable(SettingWrapper.isChargeEnable());
                SettingBLManager.getInstance().setCruiseBroadcast();
                SettingBLManager.getInstance().setVehicleId(SettingWrapper.getLicensePlate());
                SettingBLManager.getInstance().setETARestriction();
                SettingBLManager.getInstance().setTrafficState();
            }
        });
    }

    public void init() {
        this.mMapDataProviderProxy.connect(this);
        this.mLogicView.setPresenter(this);
        AudioUtil.getInstance().addAudioChangedListener(this);
        initFavoriteOverlay();
        if (CommonUtil.isScratchSpotEnable()) {
            setScratchSpotEnable(SettingWrapper.isScratchSpotEnable());
        } else {
            setScratchSpotEnable(false);
        }
        if (CarFeatureManager.INSTANCE.isLccGeoFenceEnable()) {
            if (this.mLccGeoFenceHelper == null) {
                this.mLccGeoFenceHelper = new LccGeoFenceHelper();
            }
            this.mLccGeoFenceHelper.start();
        }
    }

    public void registerEventBus() {
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    public void goToRootPage(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "goToRootPage isRestoerCreation:" + z);
        if (!z) {
            this.mLogicView.goToRootPage();
        } else {
            UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.-$$Lambda$MapScenePresenter$Syy8GMLD3k9ZcvngU5bjRhbCllo
                @Override // java.lang.Runnable
                public final void run() {
                    MapScenePresenter.this.lambda$goToRootPage$0$MapScenePresenter();
                }
            }, 10L);
        }
    }

    public /* synthetic */ void lambda$goToRootPage$0$MapScenePresenter() {
        IBaseScene currentScene = this.mLogicView.getMainContext().getCurrentScene();
        boolean z = currentScene == null || StatusConst.Mode.EMPTY == currentScene.getMode();
        L.Tag tag = TAG;
        L.w(tag, "goToRootPage failure isEmptyScene:" + z);
        if (z) {
            this.mLogicView.goToRootPage();
        }
    }

    private void unInit() {
        this.mLogicView.setPresenter((MapScenePresenter) null);
        AudioUtil.getInstance().removeAudioChangedListener(this);
        ScratchSpotBroadcastHelper scratchSpotBroadcastHelper = this.mScratchSpotBroadcastHelper;
        if (scratchSpotBroadcastHelper != null) {
            scratchSpotBroadcastHelper.stop();
        }
        LccGeoFenceHelper lccGeoFenceHelper = this.mLccGeoFenceHelper;
        if (lccGeoFenceHelper != null) {
            lccGeoFenceHelper.stop();
        }
    }

    @MainThread
    public void bindMapEngine(MapSurfaceView mapSurfaceView, int i, int i2, int i3) {
        this.mMapViewWrapper = MapDisplayManager.getInstance().getMapViewControl(i3);
        initMapListener();
        MapViewWrapper mapViewWrapper = this.mMapViewWrapper;
        if (mapViewWrapper == null) {
            this.mMapViewWrapper = MapDisplayManager.getInstance().createMapEngineWrapper(this.mApplication, mapSurfaceView, i, i2, this.mMapListener, ThemeWatcherUtil.getMapModeByCurrentTheme(), i3);
            this.mMapViewWrapper.setCarLocIconHelper(new CarLocIconHelper(getMapView()));
            MapViewWrapper mapViewWrapper2 = this.mMapViewWrapper;
            this.mMapStyleReader = new MapPrepareLayerStyle(mapViewWrapper2, mapViewWrapper2.getMainEngineID(), this.mMainContext, false);
            this.mMapStyleReader.init();
            this.mMapViewWrapper.initBizStyleReader(this.mMapStyleReader, ThemeWatcherUtil.getMapModeByCurrentTheme());
            this.mMapViewWrapper.setMapLevel(17.0f);
            this.mMapViewWrapper.setTrafficState(SettingWrapper.isRealTimeTraffic());
            this.mMapViewWrapper.updateTrafficEventLayerState();
            this.mMapViewWrapper.lockMapCameraDegree(true);
            this.mMapViewWrapper.lockMapAngle(true);
        } else {
            mapViewWrapper.bindMapSurfaceView(this.mApplication, mapSurfaceView, i, i2, this.mMapListener, ThemeWatcherUtil.getMapModeByCurrentTheme(), null);
            MapViewWrapper mapViewWrapper3 = this.mMapViewWrapper;
            this.mMapStyleReader = new MapPrepareLayerStyle(mapViewWrapper3, mapViewWrapper3.getMainEngineID(), this.mMainContext, false);
            this.mMapStyleReader.init();
            this.mMapViewWrapper.initBizStyleReader(this.mMapStyleReader, ThemeWatcherUtil.getMapModeByCurrentTheme());
        }
        if (TBTManager.getInstance().getCurrentStatus() == 1 || TBTManager.getInstance().getCurrentStatus() == 2) {
            this.mMapViewWrapper.initNaviCar(ThemeWatcherUtil.getMapModeByCurrentTheme());
            this.mMapViewWrapper.getBizControlManager().initNaviCar(true);
            if (!TBTManager.getInstance().isSimulateGuidance()) {
                this.mMapViewWrapper.getBizControlManager().setVisible(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeGuideLabel, TBTManager.getInstance().getCurrentStatus() == 2 || (TBTManager.getInstance().getCurrentStatus() == 1 && SettingWrapper.isOpenRadar()));
            }
        }
        this.mMapViewWrapper.getBizControlManager().openDynamicLevel(false, 1);
        ActivityLifecycleHelper.getInstance().registerActivityLifecycleListener(this.mMapStyleReader);
        if (mapSurfaceView instanceof XPMapSurfaceView) {
            ((XPMapSurfaceView) mapSurfaceView).setEngineId(this.mMapViewWrapper.getMainEngineID());
        }
    }

    protected void initMapListener() {
        if (this.mMapListener == null) {
            this.mMapListener = new CustomMapListener(this);
        }
    }

    public void initFavoriteOverlayManager() {
        MapViewWrapper mapViewWrapper = this.mMapViewWrapper;
        if (mapViewWrapper == null) {
            throw new IllegalArgumentException("mMapViewWrapper is null, please call bindMapEngine first!");
        }
        this.mFavoriteOverlayManager = new FavoriteOverlayManager(this.mMainContext, mapViewWrapper);
    }

    public void unbindMapSurfaceView(@NonNull MapSurfaceView mapSurfaceView) {
        this.mMapViewWrapper.unInitMapView(mapSurfaceView);
        ActivityLifecycleHelper.getInstance().unregisterActivityLifecycleListener(this.mMapStyleReader);
    }

    public void initMapMode() {
        int savedMapMode = MapUtil.getSavedMapMode(false);
        L.Tag tag = TAG;
        L.i(tag, "initialized map mode： " + savedMapMode);
        this.mMapViewWrapper.setMapMode(savedMapMode, true, false);
    }

    public MapViewWrapper getMapView() {
        return this.mMapViewWrapper;
    }

    public void addSceneMapListener(SceneMapEvent.SceneMapListener sceneMapListener) {
        this.mMapListener.addSceneMapListener(sceneMapListener);
    }

    public void removeSceneMapListener(SceneMapEvent.SceneMapListener sceneMapListener) {
        this.mMapListener.removeSceneMapListener(sceneMapListener);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onResume() {
        super.onResume();
        if (L.ENABLE) {
            L.d(TAG, "====onResume");
        }
        updateMapUI();
        showSRData(SRNaviManager.getInstance().getIsShowSRData());
    }

    public void onRestoreView() {
        if (L.ENABLE) {
            L.d(TAG, "====onRestoreView");
        }
        updateMapUI();
    }

    @MainThread
    private void updateMapUI() {
        updateMapLevelText();
        updateZoomBtnStatus();
        updateMapModeButton();
        updateRecenterStatus();
        hideParallelButton();
        updateVolumeBtnStatus();
    }

    @MainThread
    public void updateFavoriteOverlay() {
        FavoriteOverlayManager favoriteOverlayManager = this.mFavoriteOverlayManager;
        if (favoriteOverlayManager != null) {
            favoriteOverlayManager.updateFavoriteOverlay();
        }
    }

    public void onPauseView() {
        int mapViewLeft = getMapView().getMapViewLeft();
        int mapViewTop = getMapView().getMapViewTop();
        L.Tag tag = TAG;
        L.i(tag, "onPauseView map offset left:" + mapViewLeft + ",top:" + mapViewTop);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onPause() {
        super.onPause();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onDestroy() {
        super.onDestroy();
        unInit();
        this.mFavoriteOverlayManager.destroy();
        this.mMapListener.destroy();
        this.mMapDataProvider.deInit();
        this.mMapDataProviderProxy.disConnecte();
    }

    public void unregisterEventBus() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
        super.show();
        if (checkIsLegal()) {
            this.mLogicView.show();
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
        super.hide();
        if (checkIsLegal()) {
            this.mLogicView.hide();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.Presenter
    public void goBackMapCenter() {
        if (checkIsLegal()) {
            this.mMapViewWrapper.restoreCarPosition();
            this.mMapViewWrapper.goBackCenter();
            MapUtil.updateMapLevel(this.mMainContext);
        }
    }

    public void setPoiToCenter(double d, double d2) {
        if (checkIsLegal()) {
            this.mMapViewWrapper.setPoiToCenter(new XPCoordinate2DDouble(d, d2));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.Presenter
    public void switchMapMode() {
        if (this.mMainContext == null) {
            return;
        }
        int mapMode = (this.mMapViewWrapper.getMapMode() + 1) % 3;
        setMapMode(mapMode);
        this.mLogicView.popToastForMapModeChange(mapMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTTSPlayStyle() {
        if (SettingWrapper.getCurrentBroadcastStyle() != TTSManager.getInstance().getCurrentBroadcastStyle()) {
            L.i(TAG, "updateInfoWhenAccountChanged need updateTTSPlayStyle");
            SettingWrapper.notifyBroadcastStyleChange();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMapMode() {
        this.mLogicView.updateMapMode();
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.Presenter
    public void registerAccountAsync() {
        XPAccountServiceWrapper.getInstance().registerAccountEventCallback(this.mAccountEventCallback);
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.Presenter
    public void unregisterAccountAsync() {
        XPAccountServiceWrapper.getInstance().unRegisterAccountEventCallback(this.mAccountEventCallback);
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.Presenter
    public void registerAccountChangeObserver() {
        AccountObservable.getInstance().addObserver(this.mXPAccountChangeObserver);
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.Presenter
    public void unregisterAccountChangeObserver() {
        AccountObservable.getInstance().deleteObserver(this.mXPAccountChangeObserver);
    }

    public void focusPoiDecorator(final DecoratorType decoratorType, final String str, final String str2, final int i, final int i2) {
        final Coord2DDouble p20ToLonLat = getMapView().p20ToLonLat(i, i2);
        this.mLogicView.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.4
            @Override // java.lang.Runnable
            public void run() {
                IBaseScene currentScene;
                if (MapScenePresenter.this.checkIsLegal() && (currentScene = MapScenePresenter.this.mMainContext.getCurrentScene()) != null && currentScene.allowRgc()) {
                    Bundle bundle = new Bundle();
                    bundle.putString(PoiDetailDecorator.SEARCH_POI_ID, str);
                    bundle.putString(PoiDetailDecorator.SEARCH_NAME, str2);
                    bundle.putInt(PoiDetailDecorator.SEARCH_PX, i);
                    bundle.putInt(PoiDetailDecorator.SEARCH_PY, i2);
                    XPPoiInfo xPPoiInfo = new XPPoiInfo();
                    xPPoiInfo.setPoiId(str);
                    Coord2DDouble coord2DDouble = p20ToLonLat;
                    if (coord2DDouble != null) {
                        xPPoiInfo.setDisplayLat(coord2DDouble.lat);
                        xPPoiInfo.setDisplayLon(p20ToLonLat.lon);
                    }
                    MapScenePresenter.this.mMainContext.getDecoratorManager().showMapDecorator(currentScene, decoratorType, bundle);
                    MapScenePresenter.this.mMainContext.getDecoratorManager().focus(currentScene, decoratorType, xPPoiInfo);
                }
            }
        });
        if (p20ToLonLat != null) {
            MapOpStatUtil.sendStatDataWhenMapClick(this.mMainContext, 1027, 0, p20ToLonLat.lon, p20ToLonLat.lat);
        }
    }

    public void collapsePoiDecorator() {
        this.mLogicView.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.5
            @Override // java.lang.Runnable
            public void run() {
                MapScenePresenter.this.mMainContext.getDecoratorManager().clearFocus(MapScenePresenter.this.mMainContext.getCurrentScene());
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onParallelRoadEvent(ParallelRoadEvent parallelRoadEvent) {
        if (parallelRoadEvent == null) {
            return;
        }
        if (this.mMainContext.getCurrentScene() != null) {
            if (TBTManager.getInstance().getCurrentStatus() == 0 || TBTManager.getInstance().isSimulateGuidance()) {
                L.i(TAG, ">>> onParallelRoadEvent current is not NAVI or in simulate guide");
                return;
            }
            int type = parallelRoadEvent.getType();
            if (type != 0) {
                if (type != 1) {
                    return;
                }
                this.mLogicView.onParallelRoadSwitchFinish();
                return;
            } else if (parallelRoadEvent.mLocParallelRoadInfo != null) {
                L.Tag tag = TAG;
                L.i(tag, ">>> onParallelRoadEvent flag = " + parallelRoadEvent.mLocParallelRoadInfo.flag + " status = " + parallelRoadEvent.mLocParallelRoadInfo.status + " wflag = " + parallelRoadEvent.mLocParallelRoadInfo.hwFlag);
                L.Tag tag2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(">>> onParallelRoadEvent parallelRoadList = ");
                sb.append(parallelRoadEvent.mLocParallelRoadInfo.parallelRoadList == null ? -1 : parallelRoadEvent.mLocParallelRoadInfo.parallelRoadList.size());
                L.i(tag2, sb.toString());
                if (parallelRoadEvent.mLocParallelRoadInfo.flag == 0 && parallelRoadEvent.mLocParallelRoadInfo.hwFlag == 0) {
                    this.mLogicView.updateParallelRoadBtnStatus(false);
                    return;
                } else {
                    this.mLogicView.updateParallelRoadBtnStatus(true);
                    return;
                }
            } else {
                this.mLogicView.updateParallelRoadBtnStatus(false);
                return;
            }
        }
        L.i(TAG, ">>> onParallelRoadEvent current scene is null");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDRDebugMessage(DRDebugEvent dRDebugEvent) {
        if (isSceneResumed() && dRDebugEvent != null) {
            int type = dRDebugEvent.getType();
            if (type == 0) {
                if (this.mIsLocationInfoShow) {
                    this.mLogicView.updateDRDebugMessage(dRDebugEvent.mDRMessage);
                }
            } else if (type == 2) {
                if (this.mIsLocationInfoShow) {
                    this.mLogicView.updateLocationInfo(LocationUtils.latLonToLogString(dRDebugEvent.mLocation));
                }
            } else if (type == 3) {
                if (this.mIsLocationInfoShow) {
                    this.mLogicView.updateADRDebugMessage(dRDebugEvent.mADRMessage);
                }
            } else if (type == 4 && this.mIsLocationInfoShow) {
                this.mLogicView.updateCalibrationSpeedMessage(Float.toString(dRDebugEvent.mCalibrationSpeed));
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSRDebugMessage(SRDebugEvent sRDebugEvent) {
        if (checkIsLegal() && sRDebugEvent != null) {
            switch (sRDebugEvent.getType()) {
                case 0:
                    this.mLogicView.updateDebugSRInfoTips(sRDebugEvent.mTipsType);
                    return;
                case 1:
                    this.mLogicView.updateDebugSRLcTips(sRDebugEvent.mTipsType);
                    this.mLogicView.updateDebugSRODDSt(sRDebugEvent.mTipsType1);
                    return;
                case 2:
                    this.mLogicView.updateDebugSROperateTips(sRDebugEvent.mTipsType);
                    return;
                case 3:
                    this.mLogicView.updateDebugSRDisplaySt(sRDebugEvent.mTipsType);
                    return;
                case 4:
                    this.mLogicView.updateDebugSRLaneSt(sRDebugEvent.mTipsType);
                    return;
                case 5:
                    this.mLogicView.updateDebugSRTTSSt(sRDebugEvent.mTipsType);
                    return;
                case 6:
                    this.mLogicView.updateDebugSRDriveMode(sRDebugEvent.mTipsType);
                    return;
                case 7:
                    this.mLogicView.updateDebugSRFrameRate(sRDebugEvent.mTipsType);
                    this.mLogicView.updateDebugSRFrameAveCostTime(sRDebugEvent.mTipsType1);
                    return;
                case 8:
                    this.mLogicView.updateDebugSRLndsDis(sRDebugEvent.mTipsType, sRDebugEvent.mTipsType1);
                    return;
                default:
                    return;
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNaviEvent(GuideWrapperNaviEvent guideWrapperNaviEvent) {
        if (guideWrapperNaviEvent != null && guideWrapperNaviEvent.getType() == 13) {
            L.i(TAG, "receive event navi stop");
            IMapContract.LogicView logicView = this.mLogicView;
            if (logicView != null) {
                logicView.executeAfterNaviStop();
            }
        }
    }

    public boolean zoomIn() {
        boolean zoomIn = this.mMapViewWrapper.zoomIn();
        if (!zoomIn) {
            this.mLogicView.updateZoomInOutBtnStatus(false, true);
        }
        return zoomIn;
    }

    public boolean zoomOut() {
        boolean zoomOut = this.mMapViewWrapper.zoomOut();
        if (!zoomOut) {
            this.mLogicView.updateZoomInOutBtnStatus(true, false);
        }
        return zoomOut;
    }

    public boolean canZoomIn() {
        return this.mMapViewWrapper.canZoomIn();
    }

    public boolean canZoomOut() {
        return this.mMapViewWrapper.canZoomOut();
    }

    public boolean canZoom(int i) {
        return this.mMapViewWrapper.canZoom(i);
    }

    public void roadChange() {
        LocParallelRoadInfo locParallelRoadInfo = TBTManager.getInstance().getPosServiceWrapper().getLocParallelRoadInfo();
        if (locParallelRoadInfo == null) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(">>> roadChange return locParallelRoadInfo = ");
                sb.append(locParallelRoadInfo == null ? null : locParallelRoadInfo.parallelRoadList);
                L.d(tag, sb.toString());
            }
        } else if (locParallelRoadInfo.flag == 0 && locParallelRoadInfo.hwFlag == 0) {
        } else {
            long j = -1;
            int i = -1;
            if (locParallelRoadInfo.parallelRoadList != null && locParallelRoadInfo.parallelRoadList.get(0) != null) {
                j = Long.parseLong(locParallelRoadInfo.parallelRoadList.get(0).roadId.toString());
            }
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, ">>> roadChange change road roadId = " + j);
            }
            if (locParallelRoadInfo.flag != 0) {
                i = locParallelRoadInfo.flag == 1 ? 0 : 1;
            } else if (locParallelRoadInfo.hwFlag != 0) {
                i = locParallelRoadInfo.hwFlag == 1 ? 2 : 3;
            }
            TBTManager.getInstance().getPosServiceWrapper().switchParallelRoad(i, 0L);
            TBTManager.getInstance().getPosServiceWrapper().updateLocParallelRoadInfo(locParallelRoadInfo);
            TBTManager.getInstance().setParallelRoadId(j);
        }
    }

    public int getCurrentRoadFlag() {
        LocParallelRoadInfo locParallelRoadInfo = TBTManager.getInstance().getPosServiceWrapper().getLocParallelRoadInfo();
        if (locParallelRoadInfo != null) {
            return locParallelRoadInfo.flag;
        }
        return 0;
    }

    public int getCurrentRoadHWFlag() {
        LocParallelRoadInfo locParallelRoadInfo = TBTManager.getInstance().getPosServiceWrapper().getLocParallelRoadInfo();
        if (locParallelRoadInfo != null) {
            return locParallelRoadInfo.hwFlag;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onMapCenterChanged(double d, double d2, boolean z) {
        if (z) {
            return;
        }
        this.mLogicView.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.6
            @Override // java.lang.Runnable
            public void run() {
                if (MapScenePresenter.this.checkIsLegal()) {
                    MapScenePresenter.this.mLogicView.updateDebugMapCenter();
                    MapScenePresenter.this.updateRecenterStatus();
                    MapScenePresenter.this.updateMapAngle();
                    MapScenePresenter.this.queryChargeDB(false);
                    MapScenePresenter.this.updateVPAOverlay();
                }
            }
        });
    }

    void updateMapAngle() {
        if (checkIsLegal()) {
            this.mLogicView.updateMapAngle();
        }
    }

    public void updateRecenterStatus() {
        UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.-$$Lambda$MapScenePresenter$XmUQHbUolPZ8f3wmPeP3doBOZmc
            @Override // java.lang.Runnable
            public final void run() {
                MapScenePresenter.this.lambda$updateRecenterStatus$1$MapScenePresenter();
            }
        });
    }

    public /* synthetic */ void lambda$updateRecenterStatus$1$MapScenePresenter() {
        if (isSceneResumed()) {
            boolean needShowRecenterIsNavi = this.mShowRecenterAlways ? true : this.mMapViewWrapper.needShowRecenterIsNavi(true);
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "updateRecenterStatus needShow--->1:" + needShowRecenterIsNavi);
            }
            if (!this.mIsNeedShowRecenter) {
                needShowRecenterIsNavi = false;
            }
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "updateRecenterStatus needShow--->2:" + needShowRecenterIsNavi);
            }
            boolean isRecenterBtnVisible = this.mLogicView.isRecenterBtnVisible();
            if (L.ENABLE) {
                L.Tag tag3 = TAG;
                L.d(tag3, "updateRecenterStatus isRealShow:" + needShowRecenterIsNavi + ",isShowRecenter:" + isRecenterBtnVisible);
            }
            if (needShowRecenterIsNavi != isRecenterBtnVisible) {
                this.mLogicView.updateRecenterBtnStatus(needShowRecenterIsNavi);
                this.mLogicView.hideVolumePanel();
            }
        }
    }

    public void updateRecenterShowTag(boolean z) {
        this.mIsNeedShowRecenter = z;
    }

    @MainThread
    private void hideParallelButton() {
        if (checkIsLegal()) {
            this.mLogicView.updateParallelRoadBtnStatus(false);
        }
    }

    public void onMapLevelChanged(boolean z, final boolean z2) {
        if (z) {
            return;
        }
        UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.-$$Lambda$MapScenePresenter$a2uhQPLcNJ1Z3ierHypHFe_0Esk
            @Override // java.lang.Runnable
            public final void run() {
                MapScenePresenter.this.lambda$onMapLevelChanged$2$MapScenePresenter(z2);
            }
        });
    }

    public /* synthetic */ void lambda$onMapLevelChanged$2$MapScenePresenter(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onMapLevelChanged current level:" + this.mMapViewWrapper.getMapLevel());
        }
        updateMapLevelText();
        updateZoomBtnStatus();
        updateRecenterStatus();
        if (z) {
            updateFavoriteOverlay();
        }
        updateVPAOverlay();
        queryChargeDB(false);
        if (this.mMapViewWrapper.getMapLevel() >= 9 || !VoiceFullScenesUtil.isSceneVuiSupport()) {
            return;
        }
        MapVuiHelper.getInstance().clearAlterLabelTableForVui(2);
    }

    public void onMotionEvent(long j, int i, long j2, long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastSyncTimeToAI >= UILooperObserver.ANR_TRIGGER_TIME) {
            this.mLastSyncTimeToAI = currentTimeMillis;
            VoiceFusionUtil.getInstance().sendGUIEventWhenMapOperation();
        }
        this.mMainContext.getCurrentScene().onMotionEvent(j, i, j2, j3);
    }

    public void updateMapLevelText() {
        if (isSceneResumed()) {
            this.mLogicView.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.7
                @Override // java.lang.Runnable
                public void run() {
                    int scaleLineLength = MapScenePresenter.this.mMapViewWrapper.getScaleLineLength();
                    MapScenePresenter.this.mLogicView.updateScaleText(MapScenePresenter.this.mMapViewWrapper.getMapLevel() - 3, scaleLineLength);
                }
            });
        }
    }

    public void setFollowMode(final boolean z) {
        this.mLogicView.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.8
            @Override // java.lang.Runnable
            public void run() {
                MapScenePresenter.this.mMapViewWrapper.getBizControlManager().setFollowMode(z);
            }
        });
    }

    public void updateZoomBtnStatus() {
        if (checkIsLegal()) {
            final boolean z = this.mMapViewWrapper.getMapLevel() > this.mMapViewWrapper.getMinMapLevel();
            final boolean z2 = this.mMapViewWrapper.getMapLevel() < this.mMapViewWrapper.getMaxMapLevel();
            this.mLogicView.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.9
                @Override // java.lang.Runnable
                public void run() {
                    MapScenePresenter.this.mLogicView.updateZoomInOutBtnStatus(z2, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onMapModeChanged(final int i) {
        this.mLogicView.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.10
            @Override // java.lang.Runnable
            public void run() {
                MapScenePresenter.this.updateMapModeButton(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onMapAnimationFinished(long j) {
        UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.-$$Lambda$MapScenePresenter$gy0UcT8SEA4UfDwTC06nJJssBGU
            @Override // java.lang.Runnable
            public final void run() {
                MapScenePresenter.this.lambda$onMapAnimationFinished$3$MapScenePresenter();
            }
        });
    }

    public /* synthetic */ void lambda$onMapAnimationFinished$3$MapScenePresenter() {
        updateRecenterStatus();
        updateMapAngle();
    }

    @MainThread
    public void updateMapModeButton() {
        MapViewWrapper mapViewWrapper = this.mMapViewWrapper;
        if (mapViewWrapper != null) {
            updateMapModeButton(mapViewWrapper.getMapMode());
        }
    }

    @MainThread
    public void updateMapModeButton(final int i) {
        UiHandlerUtil.getInstance().runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.-$$Lambda$MapScenePresenter$31mPvY9cKNhtBhrjkQSS4kGWDiM
            @Override // java.lang.Runnable
            public final void run() {
                MapScenePresenter.this.lambda$updateMapModeButton$4$MapScenePresenter(i);
            }
        });
    }

    public /* synthetic */ void lambda$updateMapModeButton$4$MapScenePresenter(int i) {
        if (1 == i) {
            this.mLogicView.switchHeadUp2D();
        } else if (i == 0) {
            this.mLogicView.switchNorthUp();
        } else if (2 == i) {
            this.mLogicView.switchHeadUp3D();
        }
    }

    public void lockMapTouchEvent() {
        this.mMapListener.lockMapTouchEvent();
    }

    public boolean setMapTouchEnable(boolean z) {
        return this.mMapViewWrapper.setMapTouchEnable(z);
    }

    public void unlockMapTouchEvent() {
        this.mMapListener.unlockMapTouchEvent();
    }

    public void lockMapPoiEvent() {
        this.mMapListener.lockMapPoiEvent();
    }

    public boolean isMapPoiLocked() {
        return this.mMapListener.isMapPoiLocked();
    }

    public void unlockMapPoiEvent() {
        this.mMapListener.unlockMapPoiEvent();
    }

    public boolean isSceneResumed() {
        IMapContract.LogicView logicView = this.mLogicView;
        return logicView != null && logicView.isSceneResumed();
    }

    protected boolean checkIsLegal() {
        IMapContract.LogicView logicView = this.mLogicView;
        return logicView != null && logicView.isSceneLegal();
    }

    public void showSRData(boolean z) {
        this.mLogicView.showDebugSRData(z);
        if (z) {
            this.mLogicView.updateDebugSRInfoTips(SRNaviManager.getInstance().getScuNgpInfoTips1Status());
            this.mLogicView.updateDebugSRLcTips(SRNaviManager.getInstance().getScuNgpLcTips1Status());
            this.mLogicView.updateDebugSROperateTips(SRNaviManager.getInstance().getScuNgpOpeButtonStatus());
            this.mLogicView.updateDebugSRDisplaySt(SRNaviManager.getInstance().getSRDisplayState());
            this.mLogicView.updateDebugSRODDSt(SRNaviManager.getInstance().getScuQuitNgpOddStatus());
            this.mLogicView.updateDebugSRTTSSt(SRNaviManager.getInstance().getNGPLCTips1TTSStatus());
            this.mLogicView.updateDebugSRLaneSt(SRNaviManager.getInstance().getNGPLaneChangedStatus());
            this.mLogicView.updateDebugSRDriveMode(SRNaviManager.getInstance().getDriveMode());
        }
    }

    public void showLocationInfo(boolean z) {
        this.mIsLocationInfoShow = z;
        this.mLogicView.showLocationInfo(z);
        if (this.mIsLocationInfoShow) {
            this.mLogicView.updateLocationInfo(LocationUtils.latLonToLogString(LocationServiceManager.getInstance().getCurrentLocation()));
        }
    }

    public boolean isLocationInfoShow() {
        return this.mIsLocationInfoShow;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0203  */
    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onSpeechEvent(com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent r5, com.xiaopeng.montecarlo.speech.command.ICommandCallback r6) {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.onSpeechEvent(com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent, com.xiaopeng.montecarlo.speech.command.ICommandCallback):boolean");
    }

    public boolean executeSpeechCmdVoiceSearchDataFetched(SpeechNaviEvent speechNaviEvent) {
        IBaseScene currentScene = this.mMainContext.getCurrentScene();
        currentScene.removeAllChildScene();
        if (Utils.isSearchResultScene(currentScene)) {
            return false;
        }
        L.i(TAG, "SPEECH_VOICE_SEARCH_DATA_FETCHED");
        handleVoiceSearchDataFetchedEvent(speechNaviEvent.getVoiceSearchData());
        return true;
    }

    private void handleVoiceSearchDataFetchedEvent(final String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "handleVoiceSearchDataFetchedEvent voiceSearchData:" + str);
        }
        final IBaseScene currentScene = this.mMainContext.getCurrentScene();
        if (Utils.isSearchResultScene(currentScene)) {
            if (L.ENABLE) {
                L.d(TAG, "handleVoiceSearchDataFetchedEvent current scene is SearchResult,no need to jump to");
                return;
            }
            return;
        }
        WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.11
            @Override // java.lang.Runnable
            public void run() {
                VoiceFusionUtil.getInstance().analysisVoiceFusionData(str, new VoiceFusionUtil.OnVoiceFusionDataAnalysisListener() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.11.1
                    @Override // com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil.OnVoiceFusionDataAnalysisListener
                    public void onSuccess(Map<String, Object> map) {
                        if (currentScene.isSceneLegal()) {
                            if (!VoiceFusionUtil.getInstance().isCarSpeechDialogShowing()) {
                                L.w(MapScenePresenter.TAG, "executeWhenVoiceSearchFusionDataFetched speech is not showing");
                                return;
                            }
                            if (L.ENABLE) {
                                L.d(MapScenePresenter.TAG, "handleVoiceSearchDataFetchedEvent onSuccess");
                            }
                            MapScenePresenter.this.jumpToSearchResultForVoiceFusion(map);
                        }
                    }

                    @Override // com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil.OnVoiceFusionDataAnalysisListener
                    public void onError(Exception exc) {
                        L.Tag tag2 = MapScenePresenter.TAG;
                        L.e(tag2, "handleVoiceSearchDataFetchedEvent onError:" + exc);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToSearchResultForVoiceFusion(Map<String, Object> map) {
        if (L.ENABLE) {
            L.d(TAG, "jumpToSearchResultForVoiceFusion data:" + map);
        }
        IBaseScene currentScene = this.mLogicView.getMainContext().getCurrentScene();
        currentScene.setRestoreMapStatus(getMapView().storeMapState());
        Bundle bundle = new Bundle();
        bundle.putInt(SearchBridge.PREVIOUS_SCENE_MODE, currentScene.getMode().ordinal());
        if (map.get(VoiceFusionUtil.KEY_KEYWORD) != null) {
            bundle.putString(SearchBridge.SEARCH_KEYWORD_TEXT, map.get(VoiceFusionUtil.KEY_KEYWORD).toString());
        }
        if (map.get("data") != null) {
            bundle.putParcelableArrayList("search_result", new ArrayList<>((List) map.get("data")));
        }
        if (map.get(VoiceFusionUtil.KEY_IS_ONWAY) != null) {
            bundle.putBoolean(SearchBridge.KEY_IS_ONWAY_OF_VOICE_FUSION, ((Boolean) map.get(VoiceFusionUtil.KEY_IS_ONWAY)).booleanValue());
        }
        bundle.putInt(SearchBridge.KEY_START_FROM, 2);
        int i = 100;
        if (map.get(VoiceFusionUtil.KEY_CENTER_POI) != null) {
            SpeechDataCenterPoi speechDataCenterPoi = (SpeechDataCenterPoi) map.get(VoiceFusionUtil.KEY_CENTER_POI);
            XPPoiInfo xPPoiInfo = new XPPoiInfo();
            xPPoiInfo.setDisplayLon(speechDataCenterPoi.getLongitude());
            xPPoiInfo.setDisplayLat(speechDataCenterPoi.getLatitude().doubleValue());
            xPPoiInfo.setName(speechDataCenterPoi.getName());
            bundle.putParcelable(SearchBridge.SEARCH_AROUND_ITEM, xPPoiInfo);
            bundle.putInt(SearchBridge.SEARCH_MODE, 101);
        } else {
            bundle.putInt(SearchBridge.SEARCH_MODE, 100);
        }
        if (1 != TBTManager.getInstance().getCurrentStatus() && 2 != TBTManager.getInstance().getCurrentStatus()) {
            i = -1;
        }
        if (i != -1) {
            currentScene.startScene(new SearchResultBridge().setBundle(bundle), i);
        } else {
            currentScene.startScene(new SearchResultBridge().setBundle(bundle));
        }
    }

    public void executeSpeechCmdSetPoiToCenter(SpeechNaviEvent speechNaviEvent) {
        PoiBean poiBean = speechNaviEvent.getPoiBean();
        setPoiToCenter(poiBean.getLongitude(), poiBean.getLatitude());
    }

    public void executeSpeechCmdSwitchChargingStation(SpeechNaviEvent speechNaviEvent) {
        setChargeEnable(speechNaviEvent.getSwitchState());
        if (speechNaviEvent.getSwitchState()) {
            SpeechStatProxy.getInstance().sendStatDataForSpeech(11, 2);
        } else {
            SpeechStatProxy.getInstance().sendStatDataForSpeech(12, 2);
        }
    }

    public void executeSpeechCmdMapModeHeadUp3D() {
        setMapMode(2);
        SpeechStatProxy.getInstance().sendStatDataForSpeech(40, 2);
    }

    public void executeSpeechCmdMapModeHeadUp2D() {
        setMapMode(1);
        SpeechStatProxy.getInstance().sendStatDataForSpeech(41, 2);
    }

    public void executeSpeechCmdMapModeNorthUp() {
        setMapMode(0);
        SpeechStatProxy.getInstance().sendStatDataForSpeech(42, 2);
    }

    public void executeSpeechCmdZoomOutMin() {
        if (canZoomOut()) {
            zoomOutToMin();
            SpeechStatProxy.getInstance().sendStatDataForSpeech(39, 2);
            return;
        }
        SpeechStatProxy.getInstance().sendStatDataForSpeech(39, 0);
    }

    public void executeSpeechCmdZoomOut() {
        if (canZoomOut()) {
            zoomOut();
            SpeechStatProxy.getInstance().sendStatDataForSpeech(39, 2);
            return;
        }
        SpeechStatProxy.getInstance().sendStatDataForSpeech(39, 0);
    }

    public void executeSpeechCmdZoomInMax() {
        if (canZoomIn()) {
            zoomInToMax();
            SpeechStatProxy.getInstance().sendStatDataForSpeech(38, 2);
            return;
        }
        SpeechStatProxy.getInstance().sendStatDataForSpeech(38, 0);
    }

    public void executeSpeechCmdZoomIn() {
        if (canZoomIn()) {
            zoomIn();
            SpeechStatProxy.getInstance().sendStatDataForSpeech(38, 2);
            return;
        }
        SpeechStatProxy.getInstance().sendStatDataForSpeech(38, 0);
    }

    public void executeSpeechCmdZoom(int i) {
        if (canZoom(i)) {
            zoom(i);
            L.d(TAG, "set map level to specified level successful!");
            return;
        }
        L.d(TAG, "set map level to specified level unsuccessful!");
    }

    public void zoomOutToMin() {
        this.mMapViewWrapper.zoomMin();
    }

    public void zoomInToMax() {
        this.mMapViewWrapper.zoomMax();
    }

    public void zoom(int i) {
        this.mMapViewWrapper.setMapLevel(i);
    }

    public void switchRoad(boolean z) {
        LocParallelRoadInfo locParallelRoadInfo = TBTManager.getInstance().getPosServiceWrapper().getLocParallelRoadInfo();
        boolean z2 = false;
        if (locParallelRoadInfo != null && ((z && 1 != locParallelRoadInfo.flag) || ((!z && 1 == locParallelRoadInfo.flag) || ((z && 1 != locParallelRoadInfo.hwFlag) || (!z && 1 == locParallelRoadInfo.hwFlag))))) {
            z2 = true;
        }
        if (z2) {
            roadChange();
            MapOpStatUtil.sendStatDataWhenMapRoadChange(this.mMainContext);
        }
    }

    private void setMapMode(int i) {
        MapUtil.saveMapMode(i, this.mMainContext.getCurrentScene().isPreScene(StatusConst.Mode.NAVI, true));
        this.mMapViewWrapper.setMapMode(i);
    }

    public void notifyOnClickBlank(final long j, final float f, final float f2) {
        this.mLogicView.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.12
            @Override // java.lang.Runnable
            public void run() {
                if (MapScenePresenter.this.mMainContext == null || MapScenePresenter.this.mMainContext.getCurrentScene() == null || !MapScenePresenter.this.mMainContext.getCurrentScene().isSceneLegal()) {
                    return;
                }
                MapScenePresenter.this.mMainContext.getCurrentScene().onClickBlank(j, f, f2);
            }
        });
    }

    public void initMapLevel(int i) {
        if (2 == i) {
            this.mMapViewWrapper.setMapLevel(17.0f);
        } else {
            this.mMapViewWrapper.setMapLevel(15.0f);
        }
    }

    public void onLongPress(final long j, final long j2) {
        this.mLogicView.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.13
            @Override // java.lang.Runnable
            public void run() {
                if (LocationServiceManager.getInstance().getCurrentStatus() == 4) {
                    Coord2DDouble pixelToLonLat = MapScenePresenter.this.mMapViewWrapper.pixelToLonLat(j, j2);
                    if (pixelToLonLat == null) {
                        L.e(MapScenePresenter.TAG, "onLongPress pixelToLonLat is null.");
                        return;
                    }
                    Location location = new Location("gps");
                    location.setLatitude(pixelToLonLat.lat);
                    location.setLongitude(pixelToLonLat.lon);
                    LocationServiceManager.getInstance().setCarLocation(location);
                }
            }
        });
    }

    public void onMoveBegin(long j, long j2) {
        if (L.ENABLE) {
            L.d(TAG, "onMoveBegin");
        }
        sendStatDataWhenMapTouchDown(j, j2);
    }

    protected void sendStatDataWhenMapTouchDown(final long j, final long j2) {
        this.mLogicView.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.14
            @Override // java.lang.Runnable
            public void run() {
                if (L.ENABLE) {
                    L.d(MapScenePresenter.TAG, "onMoveBegin");
                }
                if (MapScenePresenter.this.mMainContext != null) {
                    MapScenePresenter.this.mMainContext.getCurrentScene().onMoveBegin(j, j2);
                }
            }
        });
        MapOpStatUtil.sendStatDataWhenMapTouchDown(this.mMainContext, (int) j, (int) j2);
    }

    public void onMoveEnd(final long j, final long j2) {
        this.mLogicView.runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.15
            @Override // java.lang.Runnable
            public void run() {
                if (L.ENABLE) {
                    L.d(MapScenePresenter.TAG, "onMoveEnd");
                }
                MapScenePresenter.this.queryChargeDB(false);
                MapScenePresenter.this.updateVPAOverlay();
                if (MapScenePresenter.this.mMainContext != null) {
                    MapScenePresenter.this.mMainContext.getCurrentScene().onMoveEnd(j, j2);
                }
            }
        });
        sendStatDataWhenMapTouchUp((int) j, (int) j2);
    }

    protected void sendStatDataWhenMapTouchUp(int i, int i2) {
        MapOpStatUtil.sendStatDataWhenMapTouchUp(this.mMainContext, i, i2);
    }

    public void setChargeEnable(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setChargeEnable enable:" + z);
        }
        if (this.mChargeEnable == z) {
            return;
        }
        this.mChargeEnable = z;
        MapViewWrapper mapViewWrapper = this.mMapViewWrapper;
        if (mapViewWrapper == null) {
            L.w(TAG, "mMapViewWrapper is null");
        } else if (mapViewWrapper.getMapLevel() >= 10) {
            queryChargeDB(true);
        } else {
            this.mMainContext.getDecoratorManager().removeMapDecorator(DecoratorType.CHARGE);
        }
    }

    public void setScratchSpotEnable(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "setScratchSpotEnable enable:" + z);
        if (z) {
            if (this.mScratchSpotBroadcastHelper == null) {
                this.mScratchSpotBroadcastHelper = new ScratchSpotBroadcastHelper();
            }
            this.mScratchSpotBroadcastHelper.start();
            return;
        }
        ScratchSpotBroadcastHelper scratchSpotBroadcastHelper = this.mScratchSpotBroadcastHelper;
        if (scratchSpotBroadcastHelper != null) {
            scratchSpotBroadcastHelper.stop();
        }
    }

    public void onMapLabelClick(ArrayList<MapLabelItem> arrayList, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            MapLabelItem mapLabelItem = arrayList.get(0);
            if (4 == mapLabelItem.type) {
                showPoiTrafficEventPop(z, mapLabelItem);
            } else if (mapLabelItem.type == 0 || 1 == mapLabelItem.type) {
                showPoiDetailPop(z, mapLabelItem);
            }
        }
    }

    private void showPoiDetailPop(boolean z, MapLabelItem mapLabelItem) {
        boolean z2 = true;
        boolean z3 = (mapLabelItem == null || TextUtils.isEmpty(mapLabelItem.poiid)) ? false : true;
        boolean isRestrictScene = Utils.isRestrictScene(this.mMainContext.getCurrentScene());
        if (!z3 || z || isRestrictScene) {
            z2 = false;
        }
        if (!z2) {
            L.w(TAG, "showPoiDetailPop failure isDataLegal:" + z3 + ",isMapPoiLocked:" + z + ",isRestrictScene:" + isRestrictScene);
            return;
        }
        focusPoiDecorator(DecoratorType.POI_DETAIL, mapLabelItem.poiid, mapLabelItem.name, mapLabelItem.pixel20X, mapLabelItem.pixel20Y);
    }

    private void showPoiTrafficEventPop(boolean z, MapLabelItem mapLabelItem) {
        boolean z2 = true;
        boolean z3 = (mapLabelItem == null || TextUtils.isEmpty(mapLabelItem.poiid)) ? false : true;
        boolean isPreScene = this.mMainContext.getCurrentScene().isPreScene(StatusConst.Mode.ROUTE, true);
        boolean isRestrictScene = Utils.isRestrictScene(this.mMainContext.getCurrentScene());
        if (!z3 || z || isPreScene || isRestrictScene) {
            z2 = false;
        }
        if (!z2) {
            L.w(TAG, "showPoiTrafficEventPop failure isDataLegal:" + z3 + ",isMapPoiLocked:" + z + ",isPreSceneRoute:" + isPreScene + ",isRestrictScene:" + isRestrictScene);
            return;
        }
        this.mLogicView.showPoiTrafficEventPop(new TrafficEventPopParam.Builder(0).setEventId(mapLabelItem.poiid).setLoc(getMapView().pixelToLonLat(mapLabelItem.x, mapLabelItem.y)).build());
    }

    public void onFreeTrafficLayerStateUpdate(boolean z) {
        if (z) {
            return;
        }
        this.mLogicView.hidePoiTrafficEventPop();
    }

    private void initFavoriteOverlay() {
        this.mMapDataProvider.initFavoriteOverlay();
    }

    public void updateVPAOverlay() {
        if (this.mMapViewWrapper == null) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateVPAOverlay vpa = " + CarFeatureManager.INSTANCE.isVPAEnable());
        }
        if (CarFeatureManager.INSTANCE.isVPAEnable()) {
            if (this.mMapViewWrapper.getMapLevel() < 17) {
                this.mMainContext.getDecoratorManager().removeMapDecorator(DecoratorType.VPA);
            } else {
                this.mMapDataProvider.updateVPAOverlay(new Coord2DDouble[]{getMapView().pixelToLonLat(0L, 0L), getMapView().pixelToLonLat(0L, this.mMapViewWrapper.getMapHeight()), getMapView().pixelToLonLat(this.mMapViewWrapper.getMapWidth(), 0L), getMapView().pixelToLonLat(this.mMapViewWrapper.getMapWidth(), this.mMapViewWrapper.getMapHeight())}, this.mMapViewWrapper.getMapLevel());
            }
        }
    }

    public void queryChargeDB(boolean z) {
        MapViewWrapper mapViewWrapper = this.mMapViewWrapper;
        if (mapViewWrapper == null || mapViewWrapper.isLaneMode()) {
            return;
        }
        Coord2DDouble[] coord2DDoubleArr = {getMapView().pixelToLonLat(0L, 0L), getMapView().pixelToLonLat(0L, this.mMapViewWrapper.getMapHeight()), getMapView().pixelToLonLat(this.mMapViewWrapper.getMapWidth(), 0L), getMapView().pixelToLonLat(this.mMapViewWrapper.getMapWidth(), this.mMapViewWrapper.getMapHeight())};
        if (z) {
            this.mMapDataProvider.queryChargeDB(coord2DDoubleArr, this.mMapViewWrapper.getMapLevel());
        } else {
            this.mMapDataProvider.queryChargeDBPre(coord2DDoubleArr, this.mMapViewWrapper.getMapLevel());
        }
    }

    private void queryCloud(List<XPPoiInfo> list) {
        this.mMapDataProvider.queryCloud(list, this.mMapViewWrapper.getMapLevel());
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataFetched(MapSceneResultData mapSceneResultData) {
        if (L.ENABLE) {
            L.d(TAG, "onDataFetched");
        }
        if (mapSceneResultData == null) {
            return;
        }
        int searchType = mapSceneResultData.getSearchType();
        if (searchType != 0 && searchType != 1) {
            if (searchType == 3) {
                if (this.mMapViewWrapper.getMapLevel() != mapSceneResultData.getScaleLevel()) {
                    return;
                }
                this.mShowCPList = mapSceneResultData.getList();
                updateChargeDecorator(this.mShowCPList);
            } else if (searchType == 4) {
                updateFavoriteOverlay();
            } else if (searchType == 5 && this.mMapViewWrapper.getMapLevel() == mapSceneResultData.getScaleLevel()) {
                updateVPADecorator(mapSceneResultData.getList());
            }
        } else if (this.mMapViewWrapper.getMapLevel() != mapSceneResultData.getScaleLevel()) {
            L.Tag tag = TAG;
            L.i(tag, "Map level change from " + mapSceneResultData.getScaleLevel() + " to " + this.mMapViewWrapper.getMapLevel() + ". Ignore this data.");
            queryChargeDB(false);
        } else {
            this.mShowCPList.clear();
            List<XPPoiInfo> list = mapSceneResultData.getList();
            if (CollectionUtils.isNotEmpty(list)) {
                this.mShowCPList.addAll(list);
            }
            updateChargeDecorator(this.mShowCPList);
            if (CollectionUtils.isNotEmpty(this.mShowCPList)) {
                queryCloud(this.mShowCPList);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onError(int i, String str) {
        if (L.ENABLE) {
            L.d(TAG, "onError");
        }
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchComplete(MapSceneRequestParam mapSceneRequestParam) {
        if (L.ENABLE) {
            L.d(TAG, "onFetchComplete");
        }
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public boolean isLegal() {
        return this.mLogicView.isSceneLegal();
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack
    public MapStatus getMapStatus() {
        if (this.mMapViewWrapper != null) {
            MapStatus mapStatus = new MapStatus();
            mapStatus.setHeight(this.mMapViewWrapper.getMapHeight());
            mapStatus.setWidth(this.mMapViewWrapper.getMapWidth());
            mapStatus.setLevel(this.mMapViewWrapper.getMapLevel());
            mapStatus.setCarLocation(TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation());
            return mapStatus;
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack
    public Point lonLatToPoint(XPCoordinate2DDouble xPCoordinate2DDouble) {
        MapViewWrapper mapViewWrapper = this.mMapViewWrapper;
        if (mapViewWrapper != null) {
            return mapViewWrapper.lonLatToPixel(xPCoordinate2DDouble);
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack
    public void updateChargeDecorator(List<XPPoiInfo> list) {
        if (list == null) {
            this.mMainContext.getDecoratorManager().removeMapDecorator(DecoratorType.CHARGE);
        } else if (this.mMainContext.isMapPoiLocked()) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt(SearchDecorator.KEY_SEARCH_TYPE, 100);
            bundle.putParcelableArrayList(BaseMapDecorator.KEY_POI_LIST, new ArrayList<>(list));
            this.mMainContext.getDecoratorManager().showMapDecorator(null, DecoratorType.CHARGE, bundle);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack
    public void removeChargeDecorator() {
        this.mMainContext.getDecoratorManager().removeMapDecorator(DecoratorType.CHARGE);
    }

    private void updateVPADecorator(List<XPPoiInfo> list) {
        MapViewWrapper mapViewWrapper = this.mMapViewWrapper;
        if (mapViewWrapper == null) {
            return;
        }
        if (mapViewWrapper.getMapLevel() < 17 || CollectionUtils.isEmpty(list)) {
            this.mMainContext.getDecoratorManager().removeMapDecorator(DecoratorType.VPA);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(BaseMapDecorator.KEY_POI_LIST, new ArrayList<>(list));
        this.mMainContext.getDecoratorManager().showMapDecorator(null, DecoratorType.VPA, bundle);
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack
    public boolean isChargeEnabled() {
        return this.mChargeEnable;
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack
    public Coord2DDouble getLonLatFromCenter() {
        MapViewWrapper mapViewWrapper = this.mMapViewWrapper;
        if (mapViewWrapper != null) {
            return mapViewWrapper.getLonLatFromCenter();
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.views.volumn.VolumePanelView.IVolumePanelEventListener
    public void onPanelProcessChanged(int i, boolean z, boolean z2) {
        if (z) {
            setVolume(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.volumn.VolumePanelView.IVolumePanelEventListener
    public void onMuteClick() {
        switchMuteState();
    }

    @Override // com.xiaopeng.montecarlo.views.volumn.VolumePanelView.IVolumePanelEventListener
    public void onPanelHide() {
        this.mLogicView.hideVolumePanel();
    }

    @Override // com.xiaopeng.montecarlo.views.volumn.VolumePanelView.IVolumePanelEventListener
    public void onUserTouchEnd() {
        sendStatDataForVolSet(true);
        AudioManagerWrapper.getInstance().playSettingVolumeFinishSound();
    }

    @Override // com.xiaopeng.montecarlo.util.AudioUtil.IAudioChangedListener
    public void onAudioChanged(boolean z) {
        if (checkIsLegal()) {
            int volume = getVolume();
            if (this.mLogicView.isVolumePanelVisible()) {
                this.mLogicView.updateVolumeProcess(volume, isMute());
            } else {
                sendStatDataForVolSet(false);
            }
            updateVolumeBtnStatus();
        }
    }

    private void updateVolumeBtnStatus() {
        IMapContract.LogicView logicView = this.mLogicView;
        if (logicView != null) {
            logicView.updateVolumeBtnStatus();
        }
    }

    public void showVolumePanelView() {
        IMapContract.LogicView logicView = this.mLogicView;
        if (logicView != null) {
            if (logicView.isVolumePanelVisible()) {
                if (Utils.isPortrait()) {
                    this.mLogicView.hideVolumePanel();
                    return;
                } else {
                    switchMuteState();
                    return;
                }
            }
            this.mLogicView.showVolumePanel();
            this.mLogicView.updateVolumeBtnStatus();
        }
    }

    public int getVolume() {
        return AudioUtil.getInstance().getVolume();
    }

    public void setVolume(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onVolumeChanged__setVolume" + i);
        }
        AudioUtil.getInstance().setVolume(i < 0 ? 0 : Math.min(i, maxVolume()));
        IMapContract.LogicView logicView = this.mLogicView;
        if (logicView != null) {
            logicView.updateVolumeBtnStatus();
        }
    }

    public boolean isMute() {
        return AudioUtil.getInstance().isMute();
    }

    private void setMute(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setMute : " + z);
        }
        AudioUtil.getInstance().setMute(z);
        MapOpStatUtil.sendStatDataForVolumeBtn(this.mMainContext, !z);
    }

    public int maxVolume() {
        return AudioUtil.getInstance().getMaxVolume();
    }

    public int getVolumeLevel() {
        if (isMute()) {
            return 0;
        }
        float volume = getVolume() / maxVolume();
        if (volume > 0.6f) {
            return 3;
        }
        return volume > 0.2f ? 2 : 1;
    }

    public void setTtsEnabledStatus(boolean z) {
        setMute(!z);
    }

    private void switchMuteState() {
        setMute(!AudioUtil.getInstance().isMute());
    }

    private void sendStatDataForVolSet(final boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "sendStatDataForVolSet : " + z);
        }
        if (z) {
            MapOpStatUtil.sendStatDataForVolSet(this.mMainContext, z, AudioUtil.getInstance().getVolume());
            return;
        }
        int volume = AudioUtil.getInstance().getVolume();
        int i = this.mSystemVolume;
        if (-1 == i || volume == i) {
            this.mSystemVolume = volume;
            return;
        }
        this.mSystemVolume = volume;
        if (this.mHasSendVolStatData) {
            return;
        }
        this.mHasSendVolStatData = true;
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.16
            @Override // java.lang.Runnable
            public void run() {
                MapScenePresenter.this.mHasSendVolStatData = false;
                MapOpStatUtil.sendStatDataForVolSet(MapScenePresenter.this.mMainContext, z, AudioUtil.getInstance().getVolume());
            }
        }, 1000L);
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.IMapContract.Presenter
    public void showRecenterBtnAlways(boolean z) {
        this.mShowRecenterAlways = z;
        updateRecenterStatus();
    }

    public void showRgcPoiPop(boolean z, int i, int i2) {
        boolean isRestrictScene = Utils.isRestrictScene(this.mMainContext.getCurrentScene());
        if (!((z || isRestrictScene) ? false : true)) {
            L.Tag tag = TAG;
            L.w(tag, "showRgcPoiPop failure isMapPoiLocked:" + z + ",isRestrictScene:" + isRestrictScene);
            return;
        }
        focusPoiDecorator(DecoratorType.RGC, "", "", i, i2);
    }

    public void registerXPCarStateListener() {
        CarServiceManager.getInstance().addCarStateListener(this.mXPCarStateListener);
    }

    public void unregisterXPCarStateListener() {
        CarServiceManager.getInstance().removeCarStateListener(this.mXPCarStateListener);
    }

    public void checkTopChildScene(SpeechNaviEvent speechNaviEvent) {
        IBaseScene currentScene = this.mMainContext.getCurrentScene();
        IBaseScene topChildScene = currentScene.getTopChildScene();
        if (topChildScene == null || topChildScene.getMode().ordinal() == speechNaviEvent.getSceneMode()) {
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "executePrepareJobForPageOpening remove top child scene");
        }
        currentScene.removeAllChildScene();
    }

    public void noticeFirstFrameDrawToAI(boolean z) {
        MapStatusService.noticeMapFirstFrameDrawStatus(z);
    }

    public void enableLccGeoFence(final boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "enableLccGeoFence enable:" + z);
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter.17
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    boolean parseData = LccGeoFenceDataHelper.parseData(RootUtil.SD_CARD_NAVI_PATH + File.separator + "lcc.json");
                    L.Tag tag2 = MapScenePresenter.TAG;
                    L.i(tag2, "enableLccGeoFence parseData " + parseData);
                    List<LccGeoFenceInfo> listAll = LccGeoFenceDataHelper.listAll();
                    L.Tag tag3 = MapScenePresenter.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("enableLccGeoFence size ");
                    sb.append(listAll == null ? "null" : Integer.valueOf(listAll.size()));
                    L.i(tag3, sb.toString());
                    if (CollectionUtils.isEmpty(listAll)) {
                        return;
                    }
                    XPPointBaseData[] xPPointBaseDataArr = {new XPPointBaseData()};
                    int size = listAll.size();
                    XPPointBaseData[] xPPointBaseDataArr2 = new XPPointBaseData[size * 2];
                    for (int i = 0; i < size; i++) {
                        xPPointBaseDataArr2[i] = new XPPointBaseData();
                        XPPointBaseData xPPointBaseData = xPPointBaseDataArr2[i];
                        xPPointBaseData.id = "gpstrace" + i;
                        xPPointBaseDataArr2[i].position.lat = listAll.get(i).getRangeLeftBottomLat();
                        xPPointBaseDataArr2[i].position.lon = listAll.get(i).getRangeLeftBottomLon();
                        int i2 = i + size;
                        xPPointBaseDataArr2[i2] = new XPPointBaseData();
                        XPPointBaseData xPPointBaseData2 = xPPointBaseDataArr2[i2];
                        xPPointBaseData2.id = "gpstrace" + i2;
                        xPPointBaseDataArr2[i2].position.lat = listAll.get(i).getRangeRightTopLat();
                        xPPointBaseDataArr2[i2].position.lon = listAll.get(i).getRangeRightTopLon();
                    }
                    MapScenePresenter.this.mMapViewWrapper.getBizControlManager().drawGPSandDRDataAddIOverlay(xPPointBaseDataArr, xPPointBaseDataArr2);
                }
            }
        });
        LccGeoFenceHelper lccGeoFenceHelper = this.mLccGeoFenceHelper;
        if (lccGeoFenceHelper != null) {
            lccGeoFenceHelper.enableBroadcast(z);
            this.mLccGeoFenceHelper.stop();
            this.mLccGeoFenceHelper.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class MapDataProviderProxy implements IMapDataCallBack {
        private IMapDataCallBack mMapDataCallBack;

        public MapDataProviderProxy(IMapDataCallBack iMapDataCallBack) {
            this.mMapDataCallBack = iMapDataCallBack;
        }

        void connect(IMapDataCallBack iMapDataCallBack) {
            this.mMapDataCallBack = iMapDataCallBack;
        }

        void disConnecte() {
            this.mMapDataCallBack = null;
        }

        @Override // com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack
        public MapStatus getMapStatus() {
            IMapDataCallBack iMapDataCallBack = this.mMapDataCallBack;
            if (iMapDataCallBack != null) {
                return iMapDataCallBack.getMapStatus();
            }
            return new MapStatus();
        }

        @Override // com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack
        public Point lonLatToPoint(XPCoordinate2DDouble xPCoordinate2DDouble) {
            IMapDataCallBack iMapDataCallBack = this.mMapDataCallBack;
            if (iMapDataCallBack != null) {
                return iMapDataCallBack.lonLatToPoint(xPCoordinate2DDouble);
            }
            return new Point();
        }

        @Override // com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack
        public void updateChargeDecorator(List<XPPoiInfo> list) {
            IMapDataCallBack iMapDataCallBack = this.mMapDataCallBack;
            if (iMapDataCallBack != null) {
                iMapDataCallBack.updateChargeDecorator(list);
            }
        }

        @Override // com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack
        public void removeChargeDecorator() {
            IMapDataCallBack iMapDataCallBack = this.mMapDataCallBack;
            if (iMapDataCallBack != null) {
                iMapDataCallBack.removeChargeDecorator();
            }
        }

        @Override // com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack
        public int getChargeUpdateInterval() {
            IMapDataCallBack iMapDataCallBack = this.mMapDataCallBack;
            if (iMapDataCallBack != null) {
                return iMapDataCallBack.getChargeUpdateInterval();
            }
            return 0;
        }

        @Override // com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack
        public boolean isChargeEnabled() {
            IMapDataCallBack iMapDataCallBack = this.mMapDataCallBack;
            if (iMapDataCallBack != null) {
                return iMapDataCallBack.isChargeEnabled();
            }
            return false;
        }

        @Override // com.xiaopeng.montecarlo.scenes.mapscene.dataprovider.IMapDataCallBack
        public Coord2DDouble getLonLatFromCenter() {
            IMapDataCallBack iMapDataCallBack = this.mMapDataCallBack;
            if (iMapDataCallBack != null) {
                return iMapDataCallBack.getLonLatFromCenter();
            }
            return null;
        }

        @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
        public void onDataFetched(@NonNull MapSceneResultData mapSceneResultData) {
            IMapDataCallBack iMapDataCallBack = this.mMapDataCallBack;
            if (iMapDataCallBack != null) {
                iMapDataCallBack.onDataFetched(mapSceneResultData);
            }
        }

        @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
        public void onDataCache(@NonNull MapSceneResultData mapSceneResultData) {
            IMapDataCallBack iMapDataCallBack = this.mMapDataCallBack;
            if (iMapDataCallBack != null) {
                iMapDataCallBack.onDataCache(mapSceneResultData);
            }
        }

        @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
        public void onError(int i, @NonNull String str) {
            IMapDataCallBack iMapDataCallBack = this.mMapDataCallBack;
            if (iMapDataCallBack != null) {
                iMapDataCallBack.onError(i, str);
            }
        }

        @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
        public void onFetchStart(MapSceneRequestParam mapSceneRequestParam) {
            IMapDataCallBack iMapDataCallBack = this.mMapDataCallBack;
            if (iMapDataCallBack != null) {
                iMapDataCallBack.onFetchStart(mapSceneRequestParam);
            }
        }

        @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
        public void onFetchComplete(MapSceneRequestParam mapSceneRequestParam) {
            IMapDataCallBack iMapDataCallBack = this.mMapDataCallBack;
            if (iMapDataCallBack != null) {
                iMapDataCallBack.onFetchComplete(mapSceneRequestParam);
            }
        }

        @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
        public boolean isLegal() {
            IMapDataCallBack iMapDataCallBack = this.mMapDataCallBack;
            if (iMapDataCallBack != null) {
                return iMapDataCallBack.isLegal();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class XPCarStateListener implements CarServiceManager.IXPCarStateListener {
        XPCarStateListener() {
        }

        @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
        public void onIgStatusChange(int i) {
            if (i == 1) {
                MapScenePresenter.this.mLogicView.onScreenOn();
            }
        }
    }

    public StatusConst.Mode getCurrentSceneMode() {
        return this.mLogicView.getCurrentSceneMode();
    }
}
