package com.xiaopeng.montecarlo.navcore.mapdisplay;

import android.app.Application;
import android.graphics.Point;
import android.location.Location;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord2DInt32;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.path.model.RoutePoint;
import com.autonavi.gbl.common.path.model.RoutePoints;
import com.autonavi.gbl.layer.model.BizAGroupBusinessInfo;
import com.autonavi.gbl.layer.model.BizLayerUtil;
import com.autonavi.gbl.layer.model.RouteDrawStyle;
import com.autonavi.gbl.map.MapDevice;
import com.autonavi.gbl.map.MapService;
import com.autonavi.gbl.map.MapView;
import com.autonavi.gbl.map.OperatorAnimation;
import com.autonavi.gbl.map.OperatorBusiness;
import com.autonavi.gbl.map.OperatorCollision;
import com.autonavi.gbl.map.OperatorGesture;
import com.autonavi.gbl.map.OperatorPosture;
import com.autonavi.gbl.map.OperatorScale;
import com.autonavi.gbl.map.OperatorStyle;
import com.autonavi.gbl.map.adapter.MapHelper;
import com.autonavi.gbl.map.adapter.MapSurfaceView;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.model.LayerTexture;
import com.autonavi.gbl.map.layer.model.PathMatchInfo;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
import com.autonavi.gbl.map.model.CalMapZoomerLonLatParam;
import com.autonavi.gbl.map.model.DeviceAttribute;
import com.autonavi.gbl.map.model.EGLSurfaceAttr;
import com.autonavi.gbl.map.model.GLGeoPoint;
import com.autonavi.gbl.map.model.InitMapParam;
import com.autonavi.gbl.map.model.MapModelConstants;
import com.autonavi.gbl.map.model.MapParameter;
import com.autonavi.gbl.map.model.MapRenderMode;
import com.autonavi.gbl.map.model.MapResourceParam;
import com.autonavi.gbl.map.model.MapSkyboxParam;
import com.autonavi.gbl.map.model.MapStyleParam;
import com.autonavi.gbl.map.model.MapViewParam;
import com.autonavi.gbl.map.model.MapViewPortParam;
import com.autonavi.gbl.map.model.MapViewStateType;
import com.autonavi.gbl.map.model.MapviewModeParam;
import com.autonavi.gbl.map.model.PointD;
import com.autonavi.gbl.map.model.PreviewParam;
import com.autonavi.gbl.map.observer.IBLMapViewProxy;
import com.autonavi.gbl.map.observer.IDeviceObserver;
import com.autonavi.gbl.map.observer.IEGLScreenshotObserver;
import com.autonavi.gbl.map.observer.ITextTextureObserver;
import com.autonavi.gbl.pos.model.LocInfo;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.autonavi.gbl.util.model.BinaryStream;
import com.xiaopeng.montecarlo.navcore.IMapListener;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.map.MapLevelInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.control.BizControlManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.sr.LaneServiceManager;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.sr.SRShowLogHelper;
import com.xiaopeng.montecarlo.navcore.util.CommonUtil;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.PosServiceWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCarLocation;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.theme.ThemeType;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class MapViewWrapper implements PosServiceWrapper.IPosUpdateOneShotCallback {
    public static final float CAR_HEADING_UP_RATIO = 0.7f;
    protected static final float CAR_NORTH_UP_RATIO = 0.55f;
    public static final int DEFAULT_MAP_COLOR_FOR_DAY = -1;
    public static final int DEFAULT_MAP_COLOR_FOR_NIGHT = -16777216;
    private static final int INVALID_DAY_NIGHT_MODE = -1;
    public static final float LANE_MODE_MAP_TOP_RATIO = 0.8f;
    public static final float MAP_CENTER_DEFAULT_RATIO = 0.5f;
    public static final int MAP_STATE_SD = 1;
    public static final int MAP_STATE_SR = 2;
    private static final int MAX_BL_TEXTURE_CACHE_COUNT = 500;
    protected static final int MAX_TEXTURE_CACHE_SIZE = 10485760;
    public static final float MINI_MAP_LANE_MODE_MAP_TOP_RATIO = 0.75f;
    public static final int RENDER_MODE_ANIM_FPS = 30;
    public static final int RENDER_MODE_ANIM_LANE_FPS = 20;
    public static final int RENDER_MODE_BACKGROUND_FPS = 1;
    public static final int RENDER_MODE_GESTURE_FPS = 20;
    public static final int RENDER_MODE_NAV_FPS = 10;
    public static final int RENDER_MODE_NAV_LANE_FPS = 16;
    public static final int RENDER_MODE_NORMAL_FPS = 15;
    private static final L.Tag TAG = new L.Tag("MapViewWrapper");
    @Nullable
    protected Application mApplication;
    protected BizControlManager mBizControlManager;
    @Nullable
    private CarLoc mCarLoc;
    private int mCenterMarginLeft;
    protected int mDeviceId;
    private MapParameter mLastMapParameter;
    private MapStatus mLastMapStatus;
    protected MapDevice mMapDevice;
    protected MapService mMapService;
    protected MapTextureCache mMapTextureCache;
    @Nullable
    protected MapView mMapView;
    private OperatorAnimation mOperatorAnimation;
    protected OperatorBusiness mOperatorBusiness;
    private OperatorCollision mOperatorCollision;
    protected OperatorGesture mOperatorGesture;
    private OperatorPosture mOperatorPosture;
    private OperatorScale mOperatorScale;
    private OperatorStyle mOperatorStyle;
    private float mPoiMarginBottom;
    private float mPoiMarginLeft;
    private float mPoiMarginRight;
    private float mPoiMarginTop;
    protected IXPMapSurfaceListener mXPMapSurfaceListener;
    private final List<IMapPreviewListener> mMapPreviewListeners = new CopyOnWriteArrayList();
    protected volatile boolean mGlMapViewInitialized = false;
    protected int mMainEngineID = -1;
    protected boolean mIsRequestRenderPause = false;
    protected boolean mIsMapSurfaceCreate = false;
    @Nullable
    protected IMapListener mCustomMapListener = null;
    protected int mMapViewState = 0;
    private int mRestoreMapState = 1;
    protected final IDeviceObserver mIDeviceObserver = new IDeviceObserver() { // from class: com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper.1
        @Override // com.autonavi.gbl.map.observer.IDeviceObserver
        public void onDeviceCreated(int i) {
        }

        @Override // com.autonavi.gbl.map.observer.IDeviceObserver
        public void onDeviceDestroyed(int i) {
        }

        @Override // com.autonavi.gbl.map.observer.IDeviceObserver
        public void onEGLDoRender(int i) {
        }

        @Override // com.autonavi.gbl.map.observer.IDeviceObserver
        public void onSurfaceCreated(int i, int i2, int i3, int i4) {
            L.Tag tag = MapViewWrapper.TAG;
            L.d(tag, L.formatWithEngine("map surface onSurfaceCreated --- i : " + i, MapViewWrapper.this.getMainEngineID()));
            MapViewWrapper mapViewWrapper = MapViewWrapper.this;
            mapViewWrapper.mIsMapSurfaceCreate = true;
            if (mapViewWrapper.mXPMapSurfaceListener != null) {
                MapViewWrapper.this.mXPMapSurfaceListener.onSurfaceCreated(i);
            }
        }

        @Override // com.autonavi.gbl.map.observer.IDeviceObserver
        public void onSurfaceDestroyed(int i, int i2, int i3, int i4) {
            MapViewWrapper mapViewWrapper = MapViewWrapper.this;
            mapViewWrapper.mIsMapSurfaceCreate = false;
            if (mapViewWrapper.mXPMapSurfaceListener != null) {
                MapViewWrapper.this.mXPMapSurfaceListener.onSurfaceDestroy(i);
            }
        }

        @Override // com.autonavi.gbl.map.observer.IDeviceObserver
        public void onSurfaceChanged(int i, int i2, int i3, int i4) {
            MapViewWrapper mapViewWrapper = MapViewWrapper.this;
            mapViewWrapper.mIsMapSurfaceCreate = true;
            if (mapViewWrapper.mMapDevice != null) {
                if (L.ENABLE) {
                    L.Tag tag = MapViewWrapper.TAG;
                    L.d(tag, L.formatWithEngine("map surface onSurfaceChanged --- isRequestRenderPause : " + MapViewWrapper.this.mIsRequestRenderPause + " --- isMapRendering: " + (true ^ MapViewWrapper.this.mMapDevice.isRenderPaused()), MapViewWrapper.this.getMainEngineID()));
                }
                if (MapViewWrapper.this.mIsRequestRenderPause) {
                    if (!MapViewWrapper.this.mMapDevice.isRenderPaused()) {
                        MapViewWrapper.this.mMapDevice.renderPause();
                    }
                } else if (MapViewWrapper.this.mMapDevice.isRenderPaused()) {
                    MapViewWrapper.this.mMapDevice.renderResume();
                }
            }
            if (MapViewWrapper.this.mXPMapSurfaceListener != null) {
                MapViewWrapper.this.mXPMapSurfaceListener.onSurfaceChanged(i, i2, i3);
            }
        }

        @Override // com.autonavi.gbl.map.observer.IDeviceObserver
        public void onDeviceRender(int i, int i2) {
            if (MapViewWrapper.this.mXPMapSurfaceListener != null) {
                MapViewWrapper.this.mXPMapSurfaceListener.onDeviceRender(i, i2);
            }
        }
    };
    protected int mCurrentDayNightMode = -1;
    protected ITextTextureObserver mITextTextureObserver = new ITextTextureObserver() { // from class: com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper.2
        @Override // com.autonavi.gbl.map.observer.ITextTextureObserver
        public byte[] getCharBitmap(long j, int i, int i2) {
            byte[] charBitmap = MapHelper.getTextTextureHelper().getCharBitmap(i, i2);
            if (MapViewWrapper.this.mMapDevice != null) {
                MapViewWrapper.this.mMapDevice.resetTickCount(6);
            }
            return charBitmap;
        }

        @Override // com.autonavi.gbl.map.observer.ITextTextureObserver
        public byte[] getCharsWidths(long j, short[] sArr, int i) {
            return MapHelper.getTextTextureHelper().getCharsWidths(sArr, i);
        }
    };
    protected IBLMapViewProxy mIBLMapViewProxy = new IBLMapViewProxy() { // from class: com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper.3
        @Override // com.autonavi.gbl.map.observer.IBLMapEngineProxy
        public void onMapLogReporter(long j, int i, int i2, String str) {
        }

        @Override // com.autonavi.gbl.map.observer.IBLMapEngineProxy
        public void onSendBehaviorLog(long j, String str, String str2, String str3) {
        }

        @Override // com.autonavi.gbl.map.observer.IBLMapViewProxy
        public void reloadMapResource(long j, byte[] bArr, int i) {
        }

        @Override // com.autonavi.gbl.map.observer.IBLMapViewProxy, com.autonavi.gbl.map.observer.IBLMapEngineProxy
        public void requireMapRender(long j, int i, int i2) {
            if (MapViewWrapper.this.mMapDevice != null) {
                MapViewWrapper.this.mMapDevice.resetTickCount(i);
            }
        }

        @Override // com.autonavi.gbl.map.observer.IBLMapEngineProxy
        public byte[] requireMapResource(long j, MapResourceParam mapResourceParam) {
            return MapHelper.getMapAssetHelper().requireResource(MapViewWrapper.this.mApplication, mapResourceParam);
        }
    };
    private boolean mIsRouteScene = false;
    private HashSet<Integer> mTextureIds = new HashSet<>();
    private volatile boolean mIsMapModeChangedWithAnimation = false;
    private ICarLocIconHelper mCarLocIconHelper = null;
    private int mTrafficLayerState = 0;
    private boolean mFreeTrafficLayerEnable = false;
    private Stack<PreviewParam> mPreviewParamStack = new Stack<>();
    private boolean mIsNeedBackToStartForSimulate = false;
    private boolean mIsDayNightSwitching = false;
    private boolean mIsRestrictShow = false;
    private SRShowLogHelper mSRShowLogHelper = new SRShowLogHelper();

    /* loaded from: classes3.dex */
    public interface IXPMapSurfaceListener {
        void onDeviceRender(int i, int i2);

        void onSurfaceChanged(int i, int i2, int i3);

        void onSurfaceCreated(int i);

        void onSurfaceDestroy(int i);
    }

    public boolean isLaneMode() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatWithEngine("isLaneMode mMapViewState: " + this.mMapViewState, getMainEngineID()));
        }
        return this.mMapViewState == 22;
    }

    @NonNull
    public SRShowLogHelper getSRShowLogHelper() {
        return this.mSRShowLogHelper;
    }

    public int getMapViewState() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatWithEngine("getMapViewState : " + this.mMapViewState, getMainEngineID()));
        }
        return this.mMapViewState;
    }

    public boolean needRestoreSR() {
        return this.mRestoreMapState == 2;
    }

    public void setRestoreMapState(int i) {
        this.mRestoreMapState = i;
    }

    public void resetRestoreMapState() {
        this.mRestoreMapState = 1;
    }

    public boolean isMapSurfaceCreate() {
        return this.mIsMapSurfaceCreate;
    }

    protected void creatMapSurfaceView(@Nullable Application application, int i, int i2, int i3, IXPMapSurfaceListener iXPMapSurfaceListener) {
        if (this.mMapService == null) {
            this.mXPMapSurfaceListener = iXPMapSurfaceListener;
            this.mMapService = (MapService) ServiceMgr.getServiceMgrInstance().getBLService(0);
            InitMapParam initMapParam = new InitMapParam();
            initMapParam.systemParam.dpi = (short) 160;
            initMapParam.systemParam.cpucorenum = 4;
            initMapParam.systemParam.memory = 4;
            initMapParam.systemParam.permitPreLoad = true;
            initMapParam.systemParam.memoryRation = 1.0f;
            initMapParam.systemParam.mobiletype = "";
            initMapParam.systemParam.platform = "android";
            initMapParam.systemParam.platform_version = "9.0";
            initMapParam.systemParam.cpuname = "骁龙";
            initMapParam.systemParam.gpuname = "骁龙";
            initMapParam.dataPath = RootUtil.SD_CARD_NAVI_PATH + "/data/";
            initMapParam.fontPath = "";
            initMapParam.basePath = "http://mps.amap.com:80/";
            initMapParam.indoorPath = "http://m5.amap.com/";
            initMapParam.assetPath = RootUtil.SD_CARD_NAVI_PATH + "/MapAsset/";
            initMapParam.buildingHeight = -1.0f;
            initMapParam.hardwareJsonParam = null;
            initMapParam.configBuffer = CommonUtil.getConfigBuffer(RootUtil.SD_CARD_NAVI_PATH);
            int initMap = this.mMapService.initMap(initMapParam);
            L.i(TAG, "initMap: i = " + initMap);
            int availableMainDeviceId = MapDeviceIdUtil.getAvailableMainDeviceId(false);
            if (availableMainDeviceId < 0) {
                L.w(TAG, L.formatWithEngine("map device create failed, no available device type, so far only 4 main engine with same type can be created", getMainEngineID()));
                return;
            }
            this.mDeviceId = availableMainDeviceId;
            DeviceAttribute deviceAttribute = new DeviceAttribute();
            deviceAttribute.isNeedAntialias = true;
            deviceAttribute.samples = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.DEBUG_MAP_SAMPLES, 4);
            deviceAttribute.uiTaskDeviceId = this.mDeviceId;
            deviceAttribute.deviceWorkMode = 0;
            deviceAttribute.maxVideoMemory = 800;
            L.i(TAG, L.formatWithEngine("default map device id = " + this.mDeviceId, getMainEngineID()));
            this.mBizControlManager = new BizControlManager();
            this.mBizControlManager.init(this.mDeviceId, WorkThreadUtil.getInstance().getBizControlLooper());
            this.mMapDevice = this.mMapService.createDevice(this.mDeviceId, deviceAttribute, this.mIDeviceObserver);
            this.mMapDevice.addDeviceObserver(this.mIDeviceObserver);
            MapViewParam mapViewParam = new MapViewParam();
            mapViewParam.mapDevice = 0L;
            mapViewParam.glThreadId = new BigInteger("0");
            mapViewParam.deviceId = this.mMapDevice.getDeviceId();
            mapViewParam.engineId = 1L;
            mapViewParam.x = 0L;
            mapViewParam.y = 0L;
            long j = i;
            mapViewParam.width = j;
            long j2 = i2;
            mapViewParam.height = j2;
            mapViewParam.screenWidth = j;
            mapViewParam.screenHeight = j2;
            mapViewParam.cacheCountFactor = DataSetHelper.GlobalSet.getFloat(DataSetHelper.GlobalSet.DEBUG_MAP_CACHE_FACTOR, 2.0f);
            mapViewParam.asyncTaskThreadCount = i3;
            this.mMapView = this.mMapService.createMapView(mapViewParam, this.mIBLMapViewProxy, null, null, null);
            initOperator();
            this.mOperatorGesture.setMapLabelClickable(true);
            this.mMapView.setTextTextureObserver(this.mITextTextureObserver);
            setMapTextScale(DataSetHelper.GlobalSet.getFloat(DataSetHelper.GlobalSet.DEBUG_MAP_TEXTSCALE_SETTING, ContextUtils.getFloat(R.dimen.default_value_map_text_scale)));
            setMapZoomScale(61.25f / i, application.getResources().getDisplayMetrics().densityDpi);
            this.mMapView.setCarPositionRatio(0.7f, CAR_NORTH_UP_RATIO);
            setMaxZoomLevel(19.0f);
            this.mOperatorGesture.hidePoiOn3DMoving(false);
            this.mOperatorGesture.enableSliding(true);
            this.mMainEngineID = this.mMapView.getEngineId();
            this.mOperatorBusiness.appendOpenLayer(NavCoreUtil.OPEN_LAYER_USER_TRAFFIC_JSON.getBytes());
            this.mMapTextureCache = new MapTextureCache(MAX_TEXTURE_CACHE_SIZE, this);
        }
    }

    public void switchToSD(int i) {
        if (checkMapViewValid() && isLaneMode()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("switchToSD status:" + TBTManager.getInstance().getCurrentStatus(), getMainEngineID()));
            if (TBTManager.getInstance().getCurrentStatus() == 0) {
                initCruiseCar(i);
            } else {
                initNaviCar(i);
                this.mBizControlManager.initNaviCar(false);
            }
            restoreCarPosition();
        }
    }

    private void exitLane() {
        L.i(TAG, L.formatWithEngine("exitLane", getMainEngineID()));
        setRenderFpsByMode(1, 10);
        setRenderFpsByMode(2, 30);
        int i = this.mMainEngineID;
        if (1 == i) {
            SRNaviManager.getInstance().setMainMapSrResume(false);
        } else if (3 == i) {
            SRNaviManager.getInstance().setMiniMapSrResume(false);
        }
        LaneServiceManager.getInstance().enterLane(this.mMainEngineID, false);
        finishAllAnimation();
        updateMapViewState(false);
        this.mBizControlManager.updateResMarker(this.mCurrentDayNightMode == 0);
        getSRShowLogHelper().logSRHide();
    }

    public void switchToLane(int i) {
        L.i(TAG, L.formatWithEngine("switchToLane", getMainEngineID()));
        if (!checkMapViewValid() || isLaneMode()) {
            return;
        }
        L.i(TAG, "switchToLane ");
        getSRShowLogHelper().logSRShow();
        this.mBizControlManager.initLaneCar();
        updateMapViewState(true);
        initLaneCar(i);
        setRenderFpsByMode(1, 16);
        setRenderFpsByMode(2, 20);
        int i2 = this.mMainEngineID;
        if (1 == i2) {
            SRNaviManager.getInstance().setMainMapSrResume(true);
        } else if (3 == i2) {
            SRNaviManager.getInstance().setMiniMapSrResume(true);
        }
        finishAllAnimation();
        LaneServiceManager.getInstance().enterLane(this.mMainEngineID, true);
        restoreCarPosition();
    }

    @MainThread
    public void bindMapSurfaceView(@Nullable Application application, @Nullable MapSurfaceView mapSurfaceView, int i, int i2, @Nullable IMapListener iMapListener, int i3, IXPMapSurfaceListener iXPMapSurfaceListener) {
        L.i(TAG, L.formatWithEngine(" init map view start..", getMainEngineID()));
        if (application == null) {
            return;
        }
        this.mCurrentDayNightMode = -1;
        this.mApplication = application;
        this.mPoiMarginLeft = ContextUtils.getFloat(R.dimen.self_poi_rect_margin_percent_left);
        this.mPoiMarginRight = ContextUtils.getFloat(R.dimen.self_poi_rect_margin_percent_right);
        this.mPoiMarginTop = ContextUtils.getFloat(R.dimen.self_poi_rect_margin_percent_top);
        this.mPoiMarginBottom = ContextUtils.getFloat(R.dimen.self_poi_rect_margin_percent_bottom);
        this.mCenterMarginLeft = ContextUtils.getDimensionPixelSize(R.dimen.base_scene_margin_start);
        creatMapSurfaceView(application, i, i2, DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.DEBUG_ASYNCTASK_THREADCOUNT, 8), iXPMapSurfaceListener);
        setGlMapBackground(i3);
        if (mapSurfaceView != null) {
            mapSurfaceView.setMapService(this.mMapService);
            mapSurfaceView.setDefaultDevice(this.mMapDevice);
            mapSurfaceView.setDefaultMapView(this.mMapView);
        }
        if (iMapListener != null) {
            MapView mapView = this.mMapView;
            if (mapView != null) {
                mapView.addMapviewObserver(iMapListener);
                this.mMapView.addGestureObserver(iMapListener);
            }
            this.mCustomMapListener = iMapListener;
        }
        MapView mapView2 = this.mMapView;
        if (mapView2 != null) {
            mapView2.setMapNeedForceDrawLabel();
        }
        L.i(TAG, L.formatWithEngine("init map view end", getMainEngineID()));
    }

    public void setXPMapSurfaceListener(IXPMapSurfaceListener iXPMapSurfaceListener) {
        this.mXPMapSurfaceListener = iXPMapSurfaceListener;
    }

    public IBLMapViewProxy getIBLMapViewProxy() {
        return this.mIBLMapViewProxy;
    }

    private void setGlMapBackground(int i) {
        if (this.mMapDevice == null) {
            return;
        }
        EGLSurfaceAttr eGLSurfaceAttr = new EGLSurfaceAttr();
        if (i == 1) {
            eGLSurfaceAttr.initColor = -16777216;
        } else if (i == 0) {
            eGLSurfaceAttr.initColor = -1;
        }
        this.mMapDevice.attachSurfaceToDevice(eGLSurfaceAttr);
    }

    public boolean isDayNightSwitching() {
        return this.mIsDayNightSwitching;
    }

    public void setIsDayNightSwitching(boolean z) {
        this.mIsDayNightSwitching = z;
    }

    public void setCarLocIconHelper(ICarLocIconHelper iCarLocIconHelper) {
        this.mCarLocIconHelper = iCarLocIconHelper;
    }

    public void addMapPreviewListener(IMapPreviewListener iMapPreviewListener) {
        if (iMapPreviewListener == null || this.mMapPreviewListeners.contains(iMapPreviewListener)) {
            return;
        }
        this.mMapPreviewListeners.add(iMapPreviewListener);
    }

    public void removeMapPreviewListener(IMapPreviewListener iMapPreviewListener) {
        if (iMapPreviewListener != null) {
            this.mMapPreviewListeners.remove(iMapPreviewListener);
        }
    }

    public void startCheckCarIconStatus() {
        ICarLocIconHelper iCarLocIconHelper = this.mCarLocIconHelper;
        if (iCarLocIconHelper != null) {
            iCarLocIconHelper.start();
        }
    }

    public void stopCheckCarIconStatus() {
        ICarLocIconHelper iCarLocIconHelper = this.mCarLocIconHelper;
        if (iCarLocIconHelper != null) {
            iCarLocIconHelper.stop();
        }
    }

    @Nullable
    public MapView getGLMapView() {
        return this.mMapView;
    }

    public int getMapWidth() {
        MapViewPortParam mapviewPort;
        if (checkMapViewValid() && (mapviewPort = this.mMapView.getMapviewPort()) != null) {
            return (int) mapviewPort.width;
        }
        return 0;
    }

    public int getMapHeight() {
        MapViewPortParam mapviewPort;
        if (checkMapViewValid() && (mapviewPort = this.mMapView.getMapviewPort()) != null) {
            return (int) mapviewPort.height;
        }
        return 0;
    }

    public int getMapCurrentDayNightMode() {
        if (checkMapViewValid()) {
            return getMapStyleTime();
        }
        return 0;
    }

    public int getMainEngineID() {
        return this.mMainEngineID;
    }

    @MainThread
    public void initBizStyleReader(IPrepareLayerStyle iPrepareLayerStyle, int i, ThemeType themeType) {
        if (this.mMapView == null) {
            return;
        }
        initMapLayerStyle(iPrepareLayerStyle, i, themeType);
        XPCarLocation currentCarLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentCarLocation(this);
        boolean z = true;
        if (currentCarLocation != null && NavCoreUtil.isInChina(currentCarLocation.mLongitude, currentCarLocation.mLatitude)) {
            z = false;
        }
        this.mCarLoc = new CarLoc();
        this.mCarLoc.vecPathMatchInfo = new ArrayList<>();
        PathMatchInfo pathMatchInfo = new PathMatchInfo();
        if (z) {
            L.w(TAG, L.formatWithEngine(" Default initialize car location", getMainEngineID()));
            long j = DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.VALUE_LAST_LOCAL_SAVE_LON, 113385075L);
            long j2 = DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.VALUE_LAST_LOCAL_SAVE_LAT, 23159586L);
            pathMatchInfo.longitude = j / 1000000.0d;
            pathMatchInfo.latitude = j2 / 1000000.0d;
            float f = 0.0f;
            try {
                f = DataSetHelper.GlobalSet.getFloat(DataSetHelper.GlobalSet.VALUE_LAST_LOCAL_SAVE_DIR, 0.0f);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            pathMatchInfo.carDir = f;
        } else {
            L.i(TAG, L.formatWithEngine(" use real location: lat --- " + currentCarLocation.mLatitude + ", lon --- " + currentCarLocation.mLongitude, getMainEngineID()));
            pathMatchInfo.longitude = currentCarLocation.mLongitude;
            pathMatchInfo.latitude = currentCarLocation.mLatitude;
            pathMatchInfo.carDir = currentCarLocation.mCarDir;
        }
        this.mCarLoc.vecPathMatchInfo.add(pathMatchInfo);
        getBizControlManager().initCar(iPrepareLayerStyle, this.mCarLoc);
        setMapViewStatesOperator(29, 0);
    }

    public void initMapLayerStyle(IPrepareLayerStyle iPrepareLayerStyle, int i, ThemeType themeType) {
        initLayerControl(iPrepareLayerStyle, i, themeType);
    }

    public void initLayerControl(IPrepareLayerStyle iPrepareLayerStyle, int i, ThemeType themeType) {
        if (this.mGlMapViewInitialized) {
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, L.formatWithEngine("initLayerControl: start", getMainEngineID()));
        }
        this.mGlMapViewInitialized = true;
        getBizControlManager().initBizService(this.mMainEngineID);
        getBizControlManager().setStyle(this.mMainEngineID, iPrepareLayerStyle);
        getBizControlManager().setStyle(this.mMainEngineID + 1, iPrepareLayerStyle);
        getBizControlManager().initBizControl(this.mMapView, this.mCustomMapListener);
        getBizControlManager().setOperatorFlyline();
        getBizControlManager().setFlyLineStyle(iPrepareLayerStyle);
        getBizControlManager().setDrawFlyLine(true, true);
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("ThemeWatcher==>: updateDayNightMode nTime:" + getDayNightMode(), getMainEngineID()));
        updateDayNightMode(i, themeType);
    }

    public void unInitMapView(@NonNull MapSurfaceView mapSurfaceView) {
        if (checkMapViewValid()) {
            L.i(TAG, L.formatWithEngine("unInitMapView start", getMainEngineID()));
            mapSurfaceView.setMapService(null);
            mapSurfaceView.setDefaultDevice(null);
            mapSurfaceView.setDefaultMapView(null);
            this.mMapView.removeMapviewObserver(this.mCustomMapListener);
            this.mMapView.removeGestureObserver(this.mCustomMapListener);
            this.mCustomMapListener = null;
            this.mGlMapViewInitialized = false;
            this.mCurrentDayNightMode = -1;
            unInitLayerControl();
            L.i(TAG, L.formatWithEngine("unInitMapView end", getMainEngineID()));
        }
    }

    public void updateCarLocIcon() {
        ICarLocIconHelper iCarLocIconHelper = this.mCarLocIconHelper;
        if (iCarLocIconHelper != null) {
            iCarLocIconHelper.updateCarLocIcon();
        }
    }

    public void renderResume() {
        if (checkMapViewValid()) {
            L.i(TAG, L.formatWithEngine("renderResume", getMainEngineID()));
            this.mIsRequestRenderPause = false;
            this.mMapDevice.renderResume();
        }
    }

    public void renderPause() {
        if (checkMapViewValid()) {
            L.i(TAG, L.formatWithEngine("renderPause", getMainEngineID()));
            this.mIsRequestRenderPause = true;
            this.mMapDevice.renderPause();
        }
    }

    public boolean isRenderPaused() {
        if (checkMapViewValid()) {
            return this.mMapDevice.isRenderPaused();
        }
        return false;
    }

    @Nullable
    public Coord2DDouble pixelToLonLat(long j, long j2) {
        Coord2DDouble screenToMap;
        if (checkMapViewValid() && (screenToMap = screenToMap(j, j2)) != null) {
            return OperatorPosture.mapToLonLat(screenToMap.lon, screenToMap.lat);
        }
        return null;
    }

    @Nullable
    public Coord2DDouble lonLatToMap(double d, double d2) {
        if (checkMapViewValid()) {
            return OperatorPosture.lonLatToMap(d, d2);
        }
        return null;
    }

    public Point lonLatToPixel(XPCoordinate2DDouble xPCoordinate2DDouble) {
        PointD mapToScreen;
        if (!checkMapViewValid()) {
            return new Point();
        }
        Coord2DDouble lonLatToGeoPoint = lonLatToGeoPoint(xPCoordinate2DDouble);
        if (lonLatToGeoPoint != null && (mapToScreen = mapToScreen(lonLatToGeoPoint.lon, lonLatToGeoPoint.lat, 0.0d)) != null) {
            return new Point(Double.valueOf(mapToScreen.x).intValue(), Double.valueOf(mapToScreen.y).intValue());
        }
        return new Point();
    }

    @Nullable
    public Coord2DDouble lonLatToGeoPoint(XPCoordinate2DDouble xPCoordinate2DDouble) {
        if (checkMapViewValid()) {
            return lonLatToMap(xPCoordinate2DDouble.mLon, xPCoordinate2DDouble.mLat);
        }
        return null;
    }

    @Nullable
    public Coord2DDouble p20ToLonLat(GLGeoPoint gLGeoPoint) {
        if (gLGeoPoint == null) {
            return null;
        }
        return p20ToLonLat(gLGeoPoint.m_X, gLGeoPoint.m_Y);
    }

    @Nullable
    public Coord2DDouble p20ToLonLat(int i, int i2) {
        if (checkMapViewValid()) {
            return OperatorPosture.mapToLonLat(i, i2);
        }
        return null;
    }

    @Nullable
    public Coord2DInt32 lonLatToP20(Coord2DDouble coord2DDouble) {
        if (coord2DDouble == null) {
            return null;
        }
        return lonLatToP20(coord2DDouble.lon, coord2DDouble.lat);
    }

    @Nullable
    public Coord2DInt32 lonLatToP20(double d, double d2) {
        Coord2DDouble lonLatToMap = OperatorPosture.lonLatToMap(d, d2);
        return new Coord2DInt32(Double.valueOf(lonLatToMap.lon).intValue(), Double.valueOf(lonLatToMap.lat).intValue());
    }

    @Nullable
    public MapStatus storeMapState() {
        if (checkMapViewValid()) {
            MapStatus mapStatus = new MapStatus();
            Coord2DDouble lonLatFromCenter = getLonLatFromCenter();
            if (lonLatFromCenter != null) {
                mapStatus.mMapCenterLon = lonLatFromCenter.lon;
                mapStatus.mMapCenterLat = lonLatFromCenter.lat;
            }
            mapStatus.mMapCenterLeft = getMapViewLeft();
            mapStatus.mMapCenterTop = getMapViewTop();
            mapStatus.mMapLevel = getMapLevelF();
            mapStatus.mMapMode = this.mMapView.getMapMode();
            mapStatus.mFollowMode = isFollowMode() ? 1 : 0;
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("storeMapState : " + mapStatus, getMainEngineID()));
            return mapStatus;
        }
        return null;
    }

    public void setIsNeedBackToStart(boolean z) {
        this.mIsNeedBackToStartForSimulate = z;
    }

    public void restoreMapState(@NonNull MapStatus mapStatus) {
        if (checkMapViewValid()) {
            if (!mapStatus.isValid()) {
                L.i(TAG, L.formatWithEngine("restoreMapState mapStatus inValid!", getMainEngineID()));
                return;
            }
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("restoreMapState : " + mapStatus, getMainEngineID()));
            if (!Double.isNaN(mapStatus.mMapCenterLon) && !Double.isNaN(mapStatus.mMapCenterLat)) {
                if (!TBTManager.getInstance().isSimulateGuidance() || !this.mIsNeedBackToStartForSimulate) {
                    setPoiToCenter(new XPCoordinate2DDouble(mapStatus.mMapCenterLon, mapStatus.mMapCenterLat), true);
                }
                if (this.mIsNeedBackToStartForSimulate) {
                    this.mIsNeedBackToStartForSimulate = false;
                }
            }
            if (mapStatus.mMapCenterLeft != -1 && mapStatus.mMapCenterTop != -1) {
                this.mMapView.setMapLeftTop(mapStatus.mMapCenterLeft, mapStatus.mMapCenterTop);
            }
            if (mapStatus.mMapMode != Integer.MIN_VALUE) {
                setMapMode(mapStatus.mMapMode, true, false);
            }
            if (mapStatus.mMapLevel != -1000.0f) {
                setMapLevel(mapStatus.mMapLevel);
            }
            if (mapStatus.mFollowMode >= 0) {
                getBizControlManager().setFollowMode(mapStatus.mFollowMode == 1);
            }
        }
    }

    public BizControlManager getBizControlManager() {
        return this.mBizControlManager;
    }

    @MainThread
    public void initCruiseCar(int i) {
        initCruiseCar(i, true);
        getBizControlManager().initCruiseCar(true);
    }

    @MainThread
    public void initCruiseCar(int i, boolean z) {
        if (checkMapViewValid()) {
            L.i(TAG, L.formatWithEngine("initCruiseCar", getMainEngineID()));
            if (isLaneMode()) {
                exitLane();
            }
            this.mIsRouteScene = false;
            setMapViewState(0);
            setMapStyle(formatMapStyleParam(i, this.mMapViewState), false, false);
        }
    }

    @MainThread
    public void initNaviCar(int i) {
        if (checkMapViewValid()) {
            L.i(TAG, L.formatWithEngine("initNaviCar", getMainEngineID()));
            if (isLaneMode()) {
                exitLane();
            }
            this.mIsRouteScene = false;
            setMapViewState(1);
            setMapStyle(formatMapStyleParam(i, this.mMapViewState), false, false);
        }
    }

    @MainThread
    public void initLaneCar(int i) {
        if (checkMapViewValid()) {
            L.i(TAG, L.formatWithEngine("initLaneCar", getMainEngineID()));
            this.mIsRouteScene = false;
            setMapViewState(22);
            setMapStyle(formatMapStyleParam(i, this.mMapViewState), false, false);
        }
    }

    private void updateMapViewState(boolean z) {
        setPoiState(!z);
        setRoadLableState(!z);
        setTrafficState(!z && SettingWrapper.isRealTimeTraffic());
        setRoadBoardState(!z);
        setMapLabelState(!z);
        lockMapCameraDegree(!z);
        lockMapAngle(!z);
        setMaxZoomLevel(z ? 20.0f : 19.0f);
        setMinZoomLevel(z ? 17.0f : 3.0f);
        if (z) {
            this.mLastMapStatus = storeMapState();
            if (2 != getMapMode()) {
                setMapMode(2);
            }
            this.mLastMapParameter = this.mOperatorBusiness.getMapBusinessDataPara(81);
            this.mOperatorBusiness.setMapBusinessDataPara(81, new MapParameter(0, 1500, 1000, 0, 0L));
            setMapViewStatesOperator(25, 1);
            this.mOperatorBusiness.setMapBusinessDataPara(102, new MapParameter(1, 17, 0, 0, 0L));
            return;
        }
        MapStatus mapStatus = this.mLastMapStatus;
        if (mapStatus != null) {
            if (Integer.MIN_VALUE != mapStatus.mMapMode) {
                setMapMode(this.mLastMapStatus.mMapMode);
            }
            this.mLastMapStatus = null;
        }
        MapParameter mapParameter = this.mLastMapParameter;
        if (mapParameter != null) {
            this.mOperatorBusiness.setMapBusinessDataPara(81, mapParameter);
            this.mLastMapParameter = null;
        }
        setMapViewStatesOperator(25, 0);
        this.mOperatorBusiness.setMapBusinessDataPara(102, new MapParameter(0, 17, 0, 0, 0L));
    }

    public void updateMapModeForLane(int i) {
        if (this.mLastMapStatus == null) {
            this.mLastMapStatus = storeMapState();
        }
        MapStatus mapStatus = this.mLastMapStatus;
        if (mapStatus != null) {
            mapStatus.mMapMode = i;
        }
    }

    public boolean setMapViewStatesOperator(@MapViewStateType.MapViewStateType1 int i, int i2) {
        if (checkMapViewValid()) {
            return this.mMapView.setMapViewStatesOperator(i, i2);
        }
        return false;
    }

    @MainThread
    public void initRouteCar(int i) {
        if (checkMapViewValid()) {
            L.i(TAG, L.formatWithEngine("initRouteCar", getMainEngineID()));
            setMapViewState(1);
            setMapStyle(formatMapStyleParam(i, this.mMapViewState), false, false);
            this.mIsRouteScene = true;
        }
    }

    @MainThread
    public boolean isBLRouteScene() {
        if (checkMapViewValid()) {
            return this.mIsRouteScene;
        }
        return false;
    }

    public void updateRouteStyle(int i, int i2) {
        if (checkMapViewValid()) {
            L.i(TAG, L.formatWithEngine("updateRouteStyle", getMainEngineID()));
            setMapStyle(formatMapStyleParam(i, i2), true, false);
        }
    }

    public void updateDayNightMode(int i, ThemeType themeType) {
        if (!checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine(L.formatDayNightSwitchLog("updateDayNightMode failure nTime:" + i + ",mCurrentDayNightMode:" + this.mCurrentDayNightMode), getMainEngineID()));
            return;
        }
        this.mCurrentDayNightMode = i;
        L.Tag tag2 = TAG;
        L.i(tag2, L.formatWithEngine(L.formatDayNightSwitchLog("updateDayNightMode nTime:" + i + ",mMapViewState:" + this.mMapViewState), getMainEngineID()));
        setSkyBoxModeByMode(true, themeType);
        getBizControlManager().updateResMarker(i == 0);
        setMapStyle(formatMapStyleParam(i, this.mMapViewState), false, false);
    }

    public int getDayNightMode() {
        if (!checkMapViewValid()) {
            L.i(TAG, L.formatWithEngine(L.formatDayNightSwitchLog("getDayNightMode failure!"), getMainEngineID()));
            return -1;
        }
        int mapStyleTime = getMapStyleTime();
        if (mapStyleTime != this.mCurrentDayNightMode) {
            L.Tag tag = TAG;
            L.w(tag, "getDayNightMode mode is not same,set mCurrentDayNightMode to mode,mode:" + mapStyleTime + ",mCurrentDayNightMode:" + this.mCurrentDayNightMode);
            mapStyleTime = this.mCurrentDayNightMode;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, L.formatWithEngine(L.formatDayNightSwitchLog("getDayNightMode mode:" + mapStyleTime), getMainEngineID()));
        }
        return mapStyleTime;
    }

    public void enableEagleEyeState(int i, boolean z, int[] iArr) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "enableEagleEyeState width:" + i + " isDayNight : " + z);
        }
        if (!checkMapViewValid()) {
        }
    }

    @NonNull
    protected MapStyleParam formatMapStyleParam(int i, int i2) {
        boolean z = i == 0;
        MapStyleParam mapStyleParam = new MapStyleParam();
        mapStyleParam.time = i;
        mapStyleParam.mode = 0;
        mapStyleParam.state = i2;
        mapStyleParam.fadeOut = isMapSurfaceCreate();
        if (i2 == 1) {
            mapStyleParam.style = z ? MapModelConstants.MAP_STYLE_PLAN_DAY : MapModelConstants.MAP_STYLE_PLAN_NIGHT;
        } else if (i2 == 4) {
            mapStyleParam.style = z ? MapModelConstants.MAP_STYLE_NAVI_DAY : MapModelConstants.MAP_STYLE_NAVI_NIGHT;
        } else if (i2 == 22) {
            mapStyleParam.style = z ? MapModelConstants.MAP_STYLE_LANE_DAY : MapModelConstants.MAP_STYLE_LANE_NIGHT;
        } else {
            mapStyleParam.style = z ? MapModelConstants.MAP_STYLE_NORMAL_DAY : MapModelConstants.MAP_STYLE_NORMAL_NIGHT;
        }
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("formatMapStyleParam param time:" + mapStyleParam.time + ",mode:" + mapStyleParam.mode + ",state:" + mapStyleParam.state + ",style:" + mapStyleParam.style, getMainEngineID()));
        return mapStyleParam;
    }

    public boolean isFollowMode() {
        if (checkMapViewValid()) {
            boolean followMode = getBizControlManager().getFollowMode();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatWithEngine("isFollowMode ： " + followMode, getMainEngineID()));
            }
            return followMode;
        }
        return false;
    }

    public int getMapMode() {
        if (checkMapViewValid()) {
            int mapMode = this.mMapView.getMapMode();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatWithEngine("getMapMode ： " + mapMode, getMainEngineID()));
            }
            return mapMode;
        }
        return 0;
    }

    public void setMapMode(int i) {
        setMapMode(i, true, false);
    }

    public void setMapMode(int i, boolean z) {
        setMapMode(i, z, false);
    }

    public boolean isMapModeChangedWithAnimation() {
        return this.mIsMapModeChangedWithAnimation;
    }

    public void setMapMode(int i, boolean z, boolean z2) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("setMapMode : " + i + " , animation : " + z, getMainEngineID()));
            this.mIsMapModeChangedWithAnimation = z;
            MapviewModeParam mapviewModeParam = new MapviewModeParam();
            mapviewModeParam.mode = i;
            mapviewModeParam.bChangeCenter = z2;
            this.mMapView.setMapMode(mapviewModeParam, z);
            getBizControlManager().updateCarStyle(TBTManager.getInstance().getCurrentStatus() != 0 ? 2001 : 2002);
            if (2 == i) {
                TBTManager.getInstance().setEnter3D(true);
            } else {
                TBTManager.getInstance().setEnter3D(false);
            }
        }
    }

    public void moveMapCenter(@NonNull CarLoc carLoc, boolean z) {
        String str;
        if (!checkMapViewValid() || carLoc == null || CollectionUtils.isEmpty(carLoc.vecPathMatchInfo) || carLoc.vecPathMatchInfo.get(0) == null) {
            return;
        }
        Coord3DDouble coord3DDouble = new Coord3DDouble(carLoc.vecPathMatchInfo.get(0).longitude, carLoc.vecPathMatchInfo.get(0).latitude, 0.0d);
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("goBackCenter : carLocation");
        if (carLoc == null) {
            str = " null ";
        } else {
            str = " [ lat->" + carLoc.vecPathMatchInfo.get(0).latitude + ", lon -> " + carLoc.vecPathMatchInfo.get(0).longitude + " , carDir -> " + carLoc.vecPathMatchInfo.get(0).carDir + "] ";
        }
        sb.append(str);
        L.i(tag, L.formatWithEngine(sb.toString(), getMainEngineID()));
        this.mOperatorPosture.setMapCenter(coord3DDouble.lon, coord3DDouble.lat, 0.0d, z, true);
    }

    public void goToMapCenter(@Nullable CarLoc carLoc) {
        if (!checkMapViewValid() || carLoc == null) {
            return;
        }
        moveMapCenter(carLoc, true);
        getBizControlManager().setFollowMode(true);
    }

    public void goBackCenterAndRestoreCarPosition(boolean z) {
        restoreCarPosition();
        goBackCenter(z, false, true);
    }

    public CarLoc getCarLocation(CarLoc carLoc) {
        CarLoc carLocation = getBizControlManager().getCarLocation();
        if (carLocation == null || CollectionUtils.isEmpty(carLocation.vecPathMatchInfo)) {
            L.i(TAG, L.formatWithEngine("getCarLocation is Empty! ", getMainEngineID()));
            return carLoc;
        }
        return carLocation;
    }

    public void goBackCenter(boolean z, boolean z2, boolean z3) {
        OperatorAnimation operatorAnimation;
        if (checkMapViewValid()) {
            CarLoc carLocation = getCarLocation(this.mCarLoc);
            if (carLocation == null || CollectionUtils.isEmpty(carLocation.vecPathMatchInfo) || carLocation.vecPathMatchInfo.get(0) == null) {
                L.i(TAG, "carLocation is null ");
                return;
            }
            L.Tag tag = TAG;
            L.i(tag, "carLocation [ lat->" + carLocation.vecPathMatchInfo.get(0).latitude + ", lon -> " + carLocation.vecPathMatchInfo.get(0).longitude + ",isFinishAni:" + z2 + ",animation:" + z3);
            if (z2 && (operatorAnimation = this.mOperatorAnimation) != null) {
                operatorAnimation.finishAllAnimation(true);
            }
            moveMapCenter(carLocation, z3);
            getBizControlManager().setFollowMode(z);
            if (isLaneMode()) {
                LaneServiceManager.getInstance().openFollowMode(1, z);
            }
            resetTickCount(1);
        }
    }

    public void finishAllAnimation() {
        OperatorAnimation operatorAnimation = this.mOperatorAnimation;
        if (operatorAnimation != null) {
            operatorAnimation.finishAllAnimation(true);
        }
    }

    public void initMapCenter(boolean z, boolean z2) {
        OperatorAnimation operatorAnimation;
        if (checkMapViewValid()) {
            if (z2 && (operatorAnimation = this.mOperatorAnimation) != null) {
                operatorAnimation.finishAllAnimation(true);
            }
            LocInfo currentLocInfo = TBTManager.getInstance().getCurrentLocInfo();
            if (currentLocInfo != null) {
                this.mCarLoc = BizLayerUtil.locToCarLoc(currentLocInfo);
            }
            moveMapCenter(this.mCarLoc, true);
            getBizControlManager().setFollowMode(z);
        }
    }

    public void goBackCenter() {
        goBackCenter(true, false, true);
    }

    public void goBackCenter(boolean z) {
        goBackCenter(true, false, z);
    }

    public void setPoiToCenter(XPCoordinate2DDouble xPCoordinate2DDouble) {
        setPoiToCenter(xPCoordinate2DDouble, true);
    }

    public void setPoiToCenter(XPCoordinate2DDouble xPCoordinate2DDouble, boolean z) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("setPoiToCenter : glGeoPoint [ lat->" + xPCoordinate2DDouble.mLat + ", lon -> " + xPCoordinate2DDouble.mLon + " ]", getMainEngineID()));
            this.mOperatorPosture.setMapCenter(xPCoordinate2DDouble.mLon, xPCoordinate2DDouble.mLat, 0.0d, z, true);
            resetTickCount(1);
        }
    }

    @Nullable
    public Coord2DDouble getLonLatFromCenter() {
        Coord3DDouble mapCenter;
        if (checkMapViewValid() && (mapCenter = getMapCenter()) != null) {
            return new Coord2DDouble(mapCenter.lon, mapCenter.lat);
        }
        return null;
    }

    public void lockMapCameraDegree(boolean z) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("lockMapCameraDegree", getMainEngineID()) + ", lock = " + z);
            this.mMapView.getOperatorGesture().lockMapPitchAngle(z);
        }
    }

    public void lockMapAngle(boolean z) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("lockMapAngle", getMainEngineID()) + ", lock = " + z);
            this.mOperatorGesture.lockMapRollAngle(z);
        }
    }

    public void addOverlayTexture(@NonNull LayerTexture layerTexture) {
        addOverlayTexture(layerTexture, false);
    }

    public boolean mapTextureCacheContains(int i) {
        MapTextureCache mapTextureCache = this.mMapTextureCache;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        return mapTextureCache.get(sb.toString()) != null;
    }

    public void updateOverlayTexture(@NonNull LayerTexture layerTexture, boolean z) {
        addOverlayTexture(layerTexture, z, true);
    }

    public void addOverlayTexture(@NonNull LayerTexture layerTexture, boolean z) {
        addOverlayTexture(layerTexture, z, false);
    }

    private void addOverlayTexture(@NonNull LayerTexture layerTexture, boolean z, boolean z2) {
        if (this.mMapView == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (L.ENABLE) {
            sb.append("OVERLAY_TEXTURE addOverlayTexture --- id: ");
            sb.append(layerTexture.resID);
        }
        if (!z) {
            if (!z2) {
                MapTextureCache mapTextureCache = this.mMapTextureCache;
                if (mapTextureCache.get(layerTexture.resID + "") != null) {
                    L.Tag tag = TAG;
                    L.i(tag, L.formatWithEngine("OVERLAY_TEXTURE addOverlayTexture size to add texture hit cache id : " + layerTexture.resID, getMainEngineID()));
                    return;
                }
            }
            int length = layerTexture.dataBuff == null ? 1 : layerTexture.dataBuff.buffer.length;
            MapTextureCache mapTextureCache2 = this.mMapTextureCache;
            mapTextureCache2.put(layerTexture.resID + "", Integer.valueOf(length));
            if (L.ENABLE) {
                sb.append(" --- size : ");
                sb.append(length);
                sb.append(" --- current size : ");
                sb.append(this.mMapTextureCache.size());
            }
        }
        boolean addLayerTexture = this.mMapView.addLayerTexture(layerTexture);
        if (this.mTextureIds.size() >= 500 && !this.mTextureIds.contains(Integer.valueOf(layerTexture.resID))) {
            L.Tag tag2 = TAG;
            L.w(tag2, "OVERLAY_TEXTURE texture count exceeded 500, current: " + this.mTextureIds.size() + ", id: " + layerTexture.resID);
        } else {
            this.mTextureIds.add(Integer.valueOf(layerTexture.resID));
            if (L.ENABLE) {
                sb.append(", total texture count: ");
                sb.append(this.mTextureIds.size());
            }
        }
        if (layerTexture.resID == 294) {
            sb.append("add result :");
            sb.append(addLayerTexture);
            L.i(TAG, L.formatWithEngine(sb.toString(), getMainEngineID()));
        }
        if (L.ENABLE) {
            L.d(TAG, L.formatWithEngine(sb.toString(), getMainEngineID()));
        }
    }

    public void cleanOverlayTexture(int i, boolean z) {
        if (checkMapViewValid()) {
            if (!z) {
                MapTextureCache mapTextureCache = this.mMapTextureCache;
                mapTextureCache.remove(i + "");
            }
            boolean destroyTexture = this.mMapView.destroyTexture(i);
            if (destroyTexture) {
                this.mTextureIds.remove(Integer.valueOf(i));
            }
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatWithEngine("OVERLAY_TEXTURE cleanOverlayTexture makerId : " + i + ", isSuccess: " + destroyTexture + ", texture count: " + this.mTextureIds.size(), getMainEngineID()));
            }
        }
    }

    public int getMapLevel() {
        if (checkMapViewValid()) {
            int zoomLevel = (int) this.mOperatorPosture.getZoomLevel();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatWithEngine("getMapLevel : " + zoomLevel, getMainEngineID()));
            }
            return zoomLevel;
        }
        return -1000;
    }

    public void setMapLevel(float f) {
        if (checkMapViewValid()) {
            if (getMapLevelF() == f) {
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, L.formatWithEngine("setMapLevel, map level is already " + f, getMainEngineID()));
                    return;
                }
                return;
            }
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, L.formatWithEngine("setMapLevel : " + f, getMainEngineID()));
            }
            resetTickCount(1);
            this.mOperatorPosture.setZoomLevel(f);
        }
    }

    public float getMapLevelF() {
        if (checkMapViewValid()) {
            float zoomLevel = this.mOperatorPosture.getZoomLevel();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatWithEngine("getMapLevel : " + zoomLevel, getMainEngineID()));
            }
            return zoomLevel;
        }
        return -1000.0f;
    }

    public void zoomMax() {
        if (checkMapViewValid()) {
            if (isLaneMode()) {
                setMapLevel(MapLevelInfo.getMaxLaneMapLevel());
            } else {
                setMapLevel(MapLevelInfo.getMaxMapLevel());
            }
        }
    }

    public void zoomMin() {
        if (checkMapViewValid()) {
            if (isLaneMode()) {
                setMapLevel(MapLevelInfo.getMinLaneMapLevel());
            } else {
                setMapLevel(MapLevelInfo.getMinMapLevel());
            }
        }
    }

    public float getCameraDegree() {
        if (checkMapViewValid()) {
            float pitchAngle = this.mOperatorPosture.getPitchAngle();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatWithEngine("getCameraDegree : " + pitchAngle, getMainEngineID()));
            }
            return pitchAngle;
        }
        return -1.0f;
    }

    public void setCameraDegree(float f) {
        if (checkMapViewValid()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatWithEngine("setCameraDegree : " + f, getMainEngineID()));
            }
            this.mOperatorPosture.setPitchAngle(f);
        }
    }

    public int getScaleLineLength() {
        if (checkMapViewValid()) {
            int scaleLineLength = this.mOperatorScale.getScaleLineLength();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatWithEngine("getScaleLineLength : " + scaleLineLength, getMainEngineID()));
            }
            return scaleLineLength;
        }
        return 100;
    }

    public int getMaxMapLevel() {
        if (checkMapViewValid()) {
            int maxScale = (int) this.mOperatorPosture.getMaxScale();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatWithEngine("getMaxMapLevel : " + maxScale, getMainEngineID()));
            }
            return maxScale;
        }
        return -1000;
    }

    public int getMinMapLevel() {
        if (checkMapViewValid()) {
            int minScale = (int) this.mOperatorPosture.getMinScale();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatWithEngine("getMinZoomLevel : " + minScale, getMainEngineID()));
            }
            return minScale;
        }
        return -1000;
    }

    public void setMapViewLeftTop(int i, int i2) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("setMapViewLeftTop : [ left -> " + i + " , top -> " + i2 + " ]", getMainEngineID()));
            this.mMapView.setMapLeftTop(i, i2);
        }
    }

    public void setMapProjectionCenter(float f, float f2) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("SetMapProjectionCenter : [ percentX -> " + f + " , percentY -> " + f2 + " ]", getMainEngineID()));
            this.mMapView.setMapProjectionCenter(f, f2);
        }
    }

    public int getMapViewLeft() {
        if (checkMapViewValid()) {
            return this.mMapView.getMapLeftTop().left;
        }
        return 0;
    }

    public int getMapViewTop() {
        if (checkMapViewValid()) {
            return this.mMapView.getMapLeftTop().top;
        }
        return 0;
    }

    public float getMapAngle() {
        if (checkMapViewValid()) {
            return this.mOperatorPosture.getRollAngle();
        }
        return 0.0f;
    }

    public void setMapAngle(float f) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("setMapAngle : " + f, getMainEngineID()));
            this.mOperatorPosture.setRollAngle(f);
        }
    }

    public void showPreview(@Nullable PreviewParam previewParam, boolean z, int i, int i2) {
        if (!checkMapViewValid() || previewParam == null) {
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("showPreviewWithParam bUseRect:" + previewParam.bUseRect + "; bAdjustHeaderAngle : " + previewParam.bAdjustHeaderAngle + " : mapBound : [ left -> " + previewParam.mapBound.left + ", top -> " + previewParam.mapBound.top + ", right -> " + previewParam.mapBound.right + ", bottom -> " + previewParam.mapBound.bottom + " ]  Screen rect : [ left -> " + previewParam.screenLeft + ", top -> " + previewParam.screenTop + ", right -> " + previewParam.screenRight + ", bottom -> " + previewParam.screenBottom + " ]", getMainEngineID()));
        previewParam.topOfMap = (int) (((float) getMapHeight()) * 0.050000012f * 2.0f);
        previewParam.leftOfMap = 0;
        this.mPreviewParamStack.push(previewParam);
        for (IMapPreviewListener iMapPreviewListener : this.mMapPreviewListeners) {
            iMapPreviewListener.onBeforeMapPreviewEnter();
        }
        getBizControlManager().setPreviewMode(true);
        this.mMapView.showPreview(previewParam, z, i, i2);
        for (IMapPreviewListener iMapPreviewListener2 : this.mMapPreviewListeners) {
            iMapPreviewListener2.onAfterMapPreviewEnter();
        }
    }

    public void showPreview(ArrayList<PointD> arrayList, int i, int i2, int i3, int i4) {
        PreviewParam previewParam = new PreviewParam();
        previewParam.points = arrayList;
        previewParam.bUseRect = false;
        previewParam.screenLeft = i;
        previewParam.screenTop = i2;
        previewParam.screenRight = i3;
        previewParam.screenBottom = i4;
        previewParam.leftOfMap = previewParam.screenLeft;
        previewParam.topOfMap = previewParam.screenTop;
        previewParam.bAdjustHeaderAngle = true;
        showPreview(previewParam);
    }

    public void showPreviewWithoutAnimation(ArrayList<PointD> arrayList, int i, int i2, int i3, int i4) {
        PreviewParam previewParam = new PreviewParam();
        previewParam.points = arrayList;
        previewParam.bUseRect = false;
        previewParam.screenLeft = i;
        previewParam.screenTop = i2;
        previewParam.screenRight = i3;
        previewParam.screenBottom = i4;
        previewParam.leftOfMap = previewParam.screenLeft;
        previewParam.topOfMap = previewParam.screenTop;
        previewParam.bAdjustHeaderAngle = true;
        showPreview(previewParam, false);
    }

    public void showPreview(RectDouble rectDouble, int i, int i2, int i3, int i4) {
        PreviewParam previewParam = new PreviewParam();
        previewParam.bAdjustHeaderAngle = true;
        previewParam.mapBound = rectDouble;
        previewParam.bUseRect = true;
        previewParam.screenLeft = i;
        previewParam.screenTop = i2;
        previewParam.screenRight = i3;
        previewParam.screenBottom = i4;
        showPreview(previewParam);
    }

    public void showPreview(PreviewParam previewParam, boolean z) {
        if (checkMapViewValid()) {
            showPreview(previewParam, z, 500, -1);
        }
    }

    public void showPreview(PreviewParam previewParam) {
        showPreview(previewParam, true);
    }

    public void exitPreview(boolean z, boolean z2) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("exitPreview :  isChangeCenter -> " + z + " , isSync -> " + z2, getMainEngineID()));
            this.mPreviewParamStack.clear();
            for (IMapPreviewListener iMapPreviewListener : this.mMapPreviewListeners) {
                iMapPreviewListener.onBeforeMapPreviewExit();
            }
            getBizControlManager().setPreviewMode(false);
            this.mMapView.exitPreview(z);
            for (IMapPreviewListener iMapPreviewListener2 : this.mMapPreviewListeners) {
                iMapPreviewListener2.onAfterMapPreviewExit();
            }
        }
    }

    public void exitPreviewImplicit() {
        L.i(TAG, "exitPreview Implicit");
        if (this.mPreviewParamStack.isEmpty()) {
            return;
        }
        this.mPreviewParamStack.pop();
    }

    public boolean isPreview() {
        if (checkMapViewValid()) {
            return !this.mPreviewParamStack.isEmpty();
        }
        return false;
    }

    public PreviewParam getPreviewParam() {
        if (this.mPreviewParamStack.isEmpty()) {
            return null;
        }
        return this.mPreviewParamStack.peek();
    }

    public void setTrafficState(boolean z) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("setTrafficState :  isTrafficState -> " + z, getMainEngineID()));
            this.mMapView.setControllerStatesOperator(1, z ? 1 : 0, true);
            this.mMapView.resetTickCount(1);
        }
    }

    public void setSimple3DState(boolean z) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("setSimple3DState :  state -> " + z, getMainEngineID()));
            this.mMapView.setMapViewStatesOperator(29, z ? 1 : 0);
        }
    }

    public void setPoiState(boolean z) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("setPoiState :  state -> " + z, getMainEngineID()));
            this.mMapView.setMapViewStatesOperator(28, z ? 1 : 0);
        }
    }

    public void setRoadLableState(boolean z) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("setRoadLableState :  state -> " + z, getMainEngineID()));
            this.mMapView.setMapViewStatesOperator(106, z ? 1 : 0);
        }
    }

    public void setMapLabelState(boolean z) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("setMapLabelState :  state -> " + z, getMainEngineID()));
            this.mMapView.getOperatorBusiness().setLabelVisable(z);
        }
    }

    public void setRoadBoardState(boolean z) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("setRoadBoardState :  state -> " + z, getMainEngineID()));
            this.mMapView.setMapViewStatesOperator(20, z ? 1 : 0);
            this.mMapView.setMapViewStatesOperator(58, z ? 1 : 0);
        }
    }

    public void setTrafficEventLayerState(int i) {
        this.mTrafficLayerState = i;
        updateTrafficEventLayerState();
    }

    public void updateTrafficEventLayerState() {
        if (checkMapViewValid()) {
            L.i(TAG, L.formatWithEngine("updateTrafficEventLayerState :  current state -> " + this.mTrafficLayerState, getMainEngineID()));
            int i = this.mTrafficLayerState;
            boolean z = true;
            if (i != 0) {
                if (i == 1) {
                    this.mOperatorBusiness.showOpenLayer(9003, false);
                    return;
                } else if (i == 2) {
                    this.mOperatorBusiness.showOpenLayer(9003, false);
                    return;
                } else {
                    return;
                }
            }
            boolean isRealTimeTraffic = SettingWrapper.isRealTimeTraffic();
            boolean isNetworkConnected = XPNetworkManager.INSTANCE.isNetworkConnected();
            if (!isRealTimeTraffic || !isNetworkConnected) {
                z = false;
            }
            this.mOperatorBusiness.showOpenLayer(9003, z);
            if (this.mFreeTrafficLayerEnable != z) {
                this.mFreeTrafficLayerEnable = z;
                IMapListener iMapListener = this.mCustomMapListener;
                if (iMapListener != null) {
                    iMapListener.onFreeTrafficLayerStateUpdate(z);
                }
            }
        }
    }

    public boolean zoomIn() {
        boolean canZoomIn = canZoomIn();
        if (canZoomIn) {
            this.mMapView.mapZoomIn(true, true);
            this.mMapView.resetTickCount(1);
        }
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("zoomIn action taken : " + canZoomIn + ", after zoom level : " + this.mOperatorPosture.getZoomLevel(), getMainEngineID()));
        return canZoomIn;
    }

    public boolean zoomOut() {
        boolean canZoomOut = canZoomOut();
        if (canZoomOut) {
            this.mMapView.mapZoomOut(true, true);
            this.mMapView.resetTickCount(1);
        }
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("zoomOut action taken : " + canZoomOut + ", after zoom level : " + this.mOperatorPosture.getZoomLevel(), getMainEngineID()));
        return canZoomOut;
    }

    public boolean canZoomIn() {
        boolean z = false;
        if (checkMapViewValid()) {
            float zoomLevel = this.mOperatorPosture.getZoomLevel();
            if (!isLaneMode() ? zoomLevel < this.mOperatorPosture.getMaxScale() : zoomLevel < MapLevelInfo.getMaxLaneMapLevel()) {
                z = true;
            }
            if (L.ENABLE) {
                L.d(TAG, L.formatWithEngine("canZoomIn:" + z + ",currentZoomLevel:" + zoomLevel, getMainEngineID()));
            }
            return z;
        }
        return false;
    }

    public boolean canZoomOut() {
        boolean z = false;
        if (checkMapViewValid()) {
            float zoomLevel = this.mOperatorPosture.getZoomLevel();
            if (!isLaneMode() ? zoomLevel > this.mOperatorPosture.getMinScale() : zoomLevel > MapLevelInfo.getMinLaneMapLevel()) {
                z = true;
            }
            if (L.ENABLE) {
                L.d(TAG, L.formatWithEngine("canZoomOut:" + z + ",currentZoomLevel:" + zoomLevel, getMainEngineID()));
            }
            return z;
        }
        return false;
    }

    public boolean canZoom(int i) {
        boolean z = false;
        if (checkMapViewValid()) {
            if (!isLaneMode() ? !(i < MapLevelInfo.getMinMapLevel() || i > MapLevelInfo.getMaxMapLevel()) : !(i < MapLevelInfo.getMinLaneMapLevel() || i > MapLevelInfo.getMaxLaneMapLevel())) {
                z = true;
            }
            if (L.ENABLE) {
                L.d(TAG, L.formatWithEngine("canZoom:" + z + ",targetLevel:" + i, getMainEngineID()));
            }
            return z;
        }
        return false;
    }

    public void resetMapviewPort(int i, int i2) {
        if (checkMapViewValid()) {
            MapViewPortParam mapViewPortParam = new MapViewPortParam();
            long j = i;
            mapViewPortParam.width = j;
            long j2 = i2;
            mapViewPortParam.height = j2;
            mapViewPortParam.screenWidth = j;
            mapViewPortParam.screenHeight = j2;
            this.mMapView.setMapviewPort(mapViewPortParam);
        }
    }

    public void restoreCarPosition() {
        if (checkMapViewValid()) {
            int defaultMapViewTop = getDefaultMapViewTop();
            int defaultMapViewLeft = getDefaultMapViewLeft();
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("restoreCarPosition: left -> " + defaultMapViewLeft + " top -> " + defaultMapViewTop, getMainEngineID()));
            this.mMapView.setMapLeftTop(defaultMapViewLeft, defaultMapViewTop);
        }
    }

    public XPCarLocation getXPCarLocation() {
        CarLoc carPosition;
        if (!checkMapViewValid() || (carPosition = getBizControlManager().getCarPosition()) == null || carPosition.vecPathMatchInfo == null || carPosition.vecPathMatchInfo.size() <= 0 || carPosition.vecPathMatchInfo.get(0) == null) {
            return null;
        }
        return new XPCarLocation(carPosition);
    }

    public boolean needShowRecenter() {
        return needShowRecenterIsNavi(false);
    }

    public boolean needShowRecenterIsNavi(boolean z) {
        boolean isPoiOutOfScreen;
        if (checkMapViewValid()) {
            if (!this.mPreviewParamStack.isEmpty()) {
                PreviewParam peek = this.mPreviewParamStack.peek();
                return (peek == null || peek.mapBound == null || (!isPoiOutOfScreen(lonLatToPixel(new XPCoordinate2DDouble(peek.mapBound.left, peek.mapBound.top)), getMapWidth(), getMapHeight()) && !isPoiOutOfScreen(lonLatToPixel(new XPCoordinate2DDouble(peek.mapBound.right, peek.mapBound.bottom)), getMapWidth(), getMapHeight()))) ? false : true;
            }
            XPCarLocation xPCarLocation = getXPCarLocation();
            if (xPCarLocation == null) {
                return false;
            }
            Point lonLatToPixel = lonLatToPixel(new XPCoordinate2DDouble(xPCarLocation.mLongitude, xPCarLocation.mLatitude));
            if (z) {
                isPoiOutOfScreen = isCarOutOfScreenWhenNavi(lonLatToPixel, getMapWidth(), getMapHeight());
            } else {
                isPoiOutOfScreen = isPoiOutOfScreen(lonLatToPixel, getMapWidth(), getMapHeight());
            }
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatWithEngine("needShowRecenter : map width : " + getMapWidth() + " ; height :  " + getMapHeight() + ": isOutScreen -> " + isPoiOutOfScreen + ", point : [ x -> " + lonLatToPixel.x + ", y -> " + lonLatToPixel.y + " ]", getMainEngineID()));
            }
            return isPoiOutOfScreen;
        }
        return false;
    }

    private boolean isCarOutOfScreenWhenNavi(@Nullable Point point, int i, int i2) {
        if (point == null || i == 0 || i2 == 0) {
            return false;
        }
        float f = i;
        if (point.x > this.mPoiMarginLeft * f && point.x < f * (1.0f - this.mPoiMarginRight)) {
            float f2 = i2;
            if (point.y > this.mPoiMarginTop * f2 && point.y < f2 * (1.0f - this.mPoiMarginBottom)) {
                return false;
            }
        }
        return true;
    }

    public void checkCCPOutOfScreen() {
        XPCarLocation xPCarLocation;
        if (!checkMapViewValid() || this.mCustomMapListener == null || (xPCarLocation = getXPCarLocation()) == null) {
            return;
        }
        Point lonLatToPixel = lonLatToPixel(new XPCoordinate2DDouble(xPCarLocation.mLongitude, xPCarLocation.mLatitude));
        boolean isPoiOutOfScreen = isPoiOutOfScreen(lonLatToPixel, getMapWidth(), getMapHeight());
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatWithEngine("checkCCPOutOfScreen: x -> " + lonLatToPixel.x + ", y -> " + lonLatToPixel.y + " isOutScreen -> " + isPoiOutOfScreen + " map width: " + getMapWidth() + " height : " + getMapHeight(), getMainEngineID()));
        }
        if (isPoiOutOfScreen) {
            this.mCustomMapListener.onCarOutOfScreen();
        }
    }

    public boolean isPoiOutOfScreen(double d, double d2) {
        return isPoiOutOfScreen(lonLatToPixel(new XPCoordinate2DDouble(d, d2)), getMapWidth(), getMapHeight());
    }

    public boolean isPoiOutOfScreen(XPCoordinate2DDouble xPCoordinate2DDouble) {
        return isPoiOutOfScreen(lonLatToPixel(xPCoordinate2DDouble), getMapWidth(), getMapHeight());
    }

    public boolean isPoiOutOfBound(double d, double d2, int i, int i2, int i3, int i4) {
        Point lonLatToPixel = lonLatToPixel(new XPCoordinate2DDouble(d, d2));
        return lonLatToPixel != null && i3 > 0 && i4 > 0 && i3 > i && i4 > i2 && (lonLatToPixel.x < i || lonLatToPixel.x > i3 || lonLatToPixel.y < i2 || lonLatToPixel.y > i4);
    }

    private boolean isPoiOutOfScreen(@Nullable Point point, int i, int i2) {
        if (point == null || i == 0 || i2 == 0) {
            return false;
        }
        return point.x <= 0 || point.x >= i || point.y <= 0 || point.y >= i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkMapViewValid() {
        return (!this.mGlMapViewInitialized || this.mMapView == null || this.mMapDevice == null) ? false : true;
    }

    @NonNull
    private RouteDrawStyle getRouteDrawStyleParam(boolean z, boolean z2) {
        RouteDrawStyle routeDrawStyle = new RouteDrawStyle();
        routeDrawStyle.mIsNavi = z;
        routeDrawStyle.mIsOffLine = false;
        routeDrawStyle.mRouteScene = 0;
        routeDrawStyle.mRouteMapMode = 0;
        routeDrawStyle.mIsMultipleMode = z2;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatWithEngine("getRouteDrawStyleParam : mIsNavi->" + z + ",isAlternate->" + z2, getMainEngineID()));
        }
        return routeDrawStyle;
    }

    public int getDefaultMapViewLeft() {
        if (checkMapViewValid()) {
            int mapWidth = this.mCenterMarginLeft + ((getMapWidth() - this.mCenterMarginLeft) / 2);
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatWithEngine("getDefaultMapViewLeft: " + mapWidth, getMainEngineID()));
            }
            return mapWidth;
        }
        return 0;
    }

    public int getDefaultMapViewTop() {
        float mapHeight;
        float f;
        if (checkMapViewValid()) {
            int mapMode = this.mMapView.getMapMode();
            if (isLaneMode()) {
                mapHeight = getMapHeight();
                f = 0.8f;
            } else if (2 == mapMode || 1 == mapMode) {
                mapHeight = getMapHeight();
                f = 0.7f;
            } else {
                mapHeight = getMapHeight();
                f = CAR_NORTH_UP_RATIO;
            }
            int i = (int) (mapHeight * f);
            if (L.ENABLE) {
                L.d(TAG, L.formatWithEngine("mapMode = " + mapMode + " ,getDefaultMapViewTop: " + i, getMainEngineID()));
            }
            return i;
        }
        return 0;
    }

    public void animateZoomTo(float f) {
        if (checkMapViewValid() && getMapLevelF() != f) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("animateZoomTo : " + f, getMainEngineID()));
            resetTickCount(1);
            this.mOperatorPosture.setZoomLevel(f, true, true);
        }
    }

    public float getMapZoom(XPCoordinate2DDouble xPCoordinate2DDouble, XPCoordinate2DDouble xPCoordinate2DDouble2, int i, int i2) {
        if (checkMapViewValid()) {
            CalMapZoomerLonLatParam calMapZoomerLonLatParam = new CalMapZoomerLonLatParam();
            calMapZoomerLonLatParam.mapPointer1.lon = xPCoordinate2DDouble.mLon;
            calMapZoomerLonLatParam.mapPointer1.lat = xPCoordinate2DDouble.mLat;
            calMapZoomerLonLatParam.mapPointer2.lon = xPCoordinate2DDouble2.mLon;
            calMapZoomerLonLatParam.mapPointer2.lat = xPCoordinate2DDouble2.mLat;
            calMapZoomerLonLatParam.width = i;
            calMapZoomerLonLatParam.height = i2;
            return this.mOperatorPosture.calculateMapZoomerLonLat(calMapZoomerLonLatParam);
        }
        return 3.0f;
    }

    public float getMapZoom(XPCoordinate2DDouble xPCoordinate2DDouble, XPCoordinate2DDouble xPCoordinate2DDouble2) {
        if (checkMapViewValid()) {
            CalMapZoomerLonLatParam calMapZoomerLonLatParam = new CalMapZoomerLonLatParam();
            calMapZoomerLonLatParam.mapPointer1.lon = xPCoordinate2DDouble.mLon;
            calMapZoomerLonLatParam.mapPointer1.lat = xPCoordinate2DDouble.mLat;
            calMapZoomerLonLatParam.mapPointer2.lon = xPCoordinate2DDouble2.mLon;
            calMapZoomerLonLatParam.mapPointer2.lat = xPCoordinate2DDouble2.mLat;
            calMapZoomerLonLatParam.width = getMapWidth();
            calMapZoomerLonLatParam.height = getMapHeight();
            return this.mOperatorPosture.calculateMapZoomerLonLat(calMapZoomerLonLatParam);
        }
        return 3.0f;
    }

    public float getMapZoom(int i, int i2, int i3, int i4) {
        Coord2DDouble p20ToLonLat;
        Coord2DDouble p20ToLonLat2;
        if (!checkMapViewValid() || (p20ToLonLat = p20ToLonLat(i, i2)) == null || (p20ToLonLat2 = p20ToLonLat(i3, i4)) == null) {
            return 3.0f;
        }
        return getMapZoom(new XPCoordinate2DDouble(p20ToLonLat), new XPCoordinate2DDouble(p20ToLonLat2));
    }

    public float getMapZoom(double d, double d2, double d3, double d4, int i, int i2) {
        if (checkMapViewValid()) {
            CalMapZoomerLonLatParam calMapZoomerLonLatParam = new CalMapZoomerLonLatParam();
            calMapZoomerLonLatParam.mapPointer1.lon = d;
            calMapZoomerLonLatParam.mapPointer1.lat = d2;
            calMapZoomerLonLatParam.mapPointer2.lon = d3;
            calMapZoomerLonLatParam.mapPointer2.lat = d4;
            calMapZoomerLonLatParam.width = i;
            calMapZoomerLonLatParam.height = i2;
            return this.mOperatorPosture.calculateMapZoomerLonLat(calMapZoomerLonLatParam);
        }
        return 3.0f;
    }

    private void setSkyBoxModeByMode(boolean z, ThemeType themeType) {
        String str;
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(L.formatWithEngine(" setSkyBoxModeByMode bOpen = " + z, getMainEngineID()));
        sb.append(",themeType:");
        sb.append(themeType);
        L.i(tag, sb.toString());
        if (themeType.isNightMode()) {
            if (themeType == ThemeType.THEME_NIGHT_XSPORT) {
                str = "skybox_xsport_night.data";
            } else {
                str = themeType == ThemeType.THEME_NIGHT_BOOST ? "skybox_boost_night.data" : "skybox_night.data";
            }
        } else if (themeType == ThemeType.THEME_DAY_XSPORT) {
            str = "skybox_xsport_day.data";
        } else {
            str = themeType == ThemeType.THEME_DAY_BOOST ? "skybox_boost_day.data" : "skybox_day.data";
        }
        final String str2 = "blRes/MapAsset/" + str;
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper.4
            @Override // java.lang.Runnable
            public void run() {
                ByteArrayOutputStream byteArrayOutputStream;
                Throwable th;
                InputStream inputStream;
                ByteArrayOutputStream byteArrayOutputStream2;
                IOException e;
                try {
                    try {
                        try {
                            if (MapViewWrapper.this.mApplication == null || !MapViewWrapper.this.checkMapViewValid()) {
                                return;
                            }
                            inputStream = MapViewWrapper.this.mApplication.getAssets().open(str2);
                            try {
                                byteArrayOutputStream2 = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[4096];
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (-1 == read) {
                                            break;
                                        }
                                        byteArrayOutputStream2.write(bArr, 0, read);
                                    }
                                    byteArrayOutputStream2.flush();
                                    if (MapViewWrapper.this.mOperatorBusiness != null) {
                                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                        MapSkyboxParam mapSkyboxParam = new MapSkyboxParam();
                                        mapSkyboxParam.isOn = true;
                                        mapSkyboxParam.is3DRes = false;
                                        mapSkyboxParam.DataBuff = new BinaryStream(byteArray);
                                        MapViewWrapper.this.mOperatorBusiness.setMapSkyboxParam(mapSkyboxParam);
                                        L.i(MapViewWrapper.TAG, L.formatWithEngine(" setSkyBoxModeByMode to bl", MapViewWrapper.this.getMainEngineID()) + ", byte[]=" + Arrays.hashCode(byteArray) + ", source=" + str2);
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    byteArrayOutputStream2.close();
                                } catch (IOException e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.close();
                                    }
                                }
                            } catch (IOException e3) {
                                byteArrayOutputStream2 = null;
                                e = e3;
                            } catch (Throwable th2) {
                                byteArrayOutputStream = null;
                                th = th2;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (IOException e5) {
                        byteArrayOutputStream2 = null;
                        e = e5;
                        inputStream = null;
                    } catch (Throwable th4) {
                        byteArrayOutputStream = null;
                        th = th4;
                        inputStream = null;
                    }
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.PosServiceWrapper.IPosUpdateOneShotCallback
    public void locationOneShotUpdated(@NonNull XPCoordinate2DDouble xPCoordinate2DDouble) {
        L.Tag tag = TAG;
        L.i(tag, L.formatWithEngine("get position to initialize : lat --- " + xPCoordinate2DDouble.mLat + " lon --- " + xPCoordinate2DDouble.mLon, getMainEngineID()));
        Location location = new Location("gps");
        location.setLatitude(xPCoordinate2DDouble.mLat);
        location.setLongitude(xPCoordinate2DDouble.mLon);
        getBizControlManager().setCarLocation(location);
        goBackCenter();
    }

    public void createBitmapFromGLSurface(IEGLScreenshotObserver iEGLScreenshotObserver, View view) {
        if (!checkMapViewValid() || iEGLScreenshotObserver == null || view == null) {
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, L.formatWithEngine("createBitmapFromGLSurface", getMainEngineID()));
        }
        this.mMapDevice.setScreenshotRect(view.getTop(), view.getLeft(), view.getRight(), view.getBottom());
        this.mMapDevice.setScreenshotCallBackMethod(0);
        this.mMapDevice.setScreenshotMode(2, iEGLScreenshotObserver);
        this.mMapDevice.setScreenshotCarType(0);
    }

    public void unCreateBitmapFromGLSurface() {
        if (checkMapViewValid()) {
            this.mMapDevice.setScreenshotMode(2, null);
        }
    }

    private RoutePoints createPathPoints(RouteParams routeParams) {
        RoutePoints routePoints = new RoutePoints();
        if (routeParams != null) {
            routePoints.mStartPoints = new ArrayList<>();
            routePoints.mEndPoints = new ArrayList<>();
            routePoints.mStartPoints.add(new RoutePoint());
            if (routeParams.mStartInfo != null) {
                routePoints.mStartPoints.get(0).mPos.lat = routeParams.mStartInfo.getDisplayLat();
                routePoints.mStartPoints.get(0).mPos.lon = routeParams.mStartInfo.getDisplayLon();
            } else if (L.ENABLE) {
                L.d(TAG, L.formatWithEngine(">>> createPathPoints startInfo is null", getMainEngineID()));
            }
            routePoints.mEndPoints.add(new RoutePoint());
            if (routeParams.mEndInfo != null) {
                routePoints.mEndPoints.get(0).mPos.lat = routeParams.mEndInfo.getDisplayLat();
                routePoints.mEndPoints.get(0).mPos.lon = routeParams.mEndInfo.getDisplayLon();
            } else if (L.ENABLE) {
                L.d(TAG, L.formatWithEngine(">>> createPathPoints endInfo is null", getMainEngineID()));
            }
            if (routeParams.mViaInfos != null) {
                List<XPViaPoint> list = routeParams.mViaInfos;
                if (CollectionUtils.isNotEmpty(list)) {
                    routePoints.mViaPoints = new ArrayList<>();
                    for (int i = 0; i < list.size(); i++) {
                        RoutePoint routePoint = new RoutePoint();
                        if (list.get(i).getPoiPoint() != null) {
                            routePoint.mPos.lat = list.get(i).getPoiPoint().getDisplayLat();
                            routePoint.mPos.lon = list.get(i).getPoiPoint().getDisplayLon();
                        }
                        routePoints.mViaPoints.add(routePoint);
                    }
                }
                L.i(TAG, L.formatWithEngine("createPathPoints: ", routePoints.mViaPoints != null ? routePoints.mViaPoints.size() : 0));
            } else if (L.ENABLE) {
                L.d(TAG, L.formatWithEngine(">>> createPathPoints pointInfos is null", getMainEngineID()));
            }
        } else if (L.ENABLE) {
            L.d(TAG, L.formatWithEngine(">>> createPathPoints mRouteOption is null", getMainEngineID()));
        }
        return routePoints;
    }

    public boolean getBldAndModelVisibility() {
        if (checkMapViewValid()) {
            return this.mOperatorBusiness.getMapViewState(26);
        }
        return false;
    }

    public boolean setBldAndModelVisibility(boolean z) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, "setBldAndModelVisibility " + z);
            this.mOperatorBusiness.showBuilding3D(z);
            return true;
        }
        return false;
    }

    public boolean setRealCityEnable(boolean z) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, "setRealCityEnable " + z);
            this.mOperatorBusiness.setRealCityEnable(z);
            return true;
        }
        return false;
    }

    public boolean setMapTouchEnable(boolean z) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, "setMapTouchEnable " + z);
            this.mOperatorGesture.setTouchEnable(z);
            return true;
        }
        return false;
    }

    public boolean setRenderFpsByMode(@MapRenderMode.MapRenderMode1 int i, int i2) {
        if (checkMapViewValid()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "setRenderFpsByMode mode: " + i + " fps：" + i2);
            }
            this.mMapDevice.setRenderFpsByMode(i, i2);
            return true;
        }
        return false;
    }

    public boolean setFboEnable(boolean z) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, "setFboEnable enable：" + z);
            this.mOperatorBusiness.setFBOEnable(z);
            return true;
        }
        return false;
    }

    public void resetTickCount(int i) {
        if (checkMapViewValid()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.i(tag, "resetTickCount tickcount=" + i);
            }
            this.mMapDevice.resetTickCount(i);
        }
    }

    public void setCarPositionRatio(float f, float f2) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("setCarPositionRatio " + f + "," + f2, getMainEngineID()));
            this.mMapView.setCarPositionRatio(f, f2);
        }
    }

    public void updateRestrictStatus(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "updateRestrictStatus isRestrictShow:" + z);
        this.mIsRestrictShow = z;
    }

    public boolean getRestrictStatus() {
        return this.mIsRestrictShow;
    }

    public void setMapDensityDpiByHW(int i, int i2) {
        if (checkMapViewValid()) {
            setMapZoomScale(61.25f / i, ContextUtils.getDensityDpi());
        }
    }

    public void unInitLayerControl() {
        getBizControlManager().unInitBizControl();
        L.i(TAG, "unInitLayerControl finish");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initOperator() {
        setOperatorAnimation();
        setOperatorBusiness();
        setOperatorCollision();
        setOperatorPosture();
        setOperatorScale();
        setOperatorStyle();
        setOperatorGesture();
    }

    private void deleteOperator() {
        deleteOperatorAnimation();
        deleteOperatorBusiness();
        deleteOperatorCollision();
        deleteOperatorPosture();
        deleteOperatorScale();
        deleteOperatorStyle();
        deleteOperatorGesture();
    }

    public void setOperatorAnimation() {
        MapView mapView = this.mMapView;
        if (mapView != null) {
            this.mOperatorAnimation = mapView.getOperatorAnimation();
        }
    }

    public void deleteOperatorAnimation() {
        if (this.mOperatorAnimation != null) {
            this.mOperatorAnimation = null;
        }
    }

    public void setOperatorBusiness() {
        MapView mapView = this.mMapView;
        if (mapView != null) {
            this.mOperatorBusiness = mapView.getOperatorBusiness();
        }
    }

    public void deleteOperatorBusiness() {
        if (this.mOperatorBusiness != null) {
            this.mOperatorBusiness = null;
        }
    }

    public void setMapTextScale(float f) {
        OperatorBusiness operatorBusiness = this.mOperatorBusiness;
        if (operatorBusiness != null) {
            operatorBusiness.setMapTextScale(f);
        }
    }

    public void setMapZoomScale(float f, float f2) {
        OperatorBusiness operatorBusiness = this.mOperatorBusiness;
        if (operatorBusiness != null) {
            operatorBusiness.setMapZoomScale(f, f2);
        }
    }

    public boolean setRestoredMapModeState(MapStyleParam mapStyleParam) {
        OperatorBusiness operatorBusiness = this.mOperatorBusiness;
        if (operatorBusiness != null) {
            return operatorBusiness.setRestoredMapModeState(mapStyleParam);
        }
        return false;
    }

    public MapStyleParam getRestoredMapModeState() {
        OperatorBusiness operatorBusiness = this.mOperatorBusiness;
        if (operatorBusiness != null) {
            return operatorBusiness.getRestoredMapModeState();
        }
        return null;
    }

    public void setOperatorCollision() {
        MapView mapView = this.mMapView;
        if (mapView != null) {
            this.mOperatorCollision = mapView.getOperatorCollision();
        }
    }

    public void deleteOperatorCollision() {
        if (this.mOperatorCollision != null) {
            this.mOperatorCollision = null;
        }
    }

    public void setOperatorPosture() {
        MapView mapView = this.mMapView;
        if (mapView != null) {
            this.mOperatorPosture = mapView.getOperatorPosture();
        }
    }

    public void deleteOperatorPosture() {
        if (this.mOperatorPosture != null) {
            this.mOperatorPosture = null;
        }
    }

    public void setMaxZoomLevel(float f) {
        OperatorPosture operatorPosture = this.mOperatorPosture;
        if (operatorPosture != null) {
            operatorPosture.setMaxZoomLevel(f);
        }
    }

    public void setMinZoomLevel(float f) {
        OperatorPosture operatorPosture = this.mOperatorPosture;
        if (operatorPosture != null) {
            operatorPosture.setMinZoomLevel(f);
        }
    }

    public Coord2DDouble screenToMap(double d, double d2) {
        OperatorPosture operatorPosture = this.mOperatorPosture;
        if (operatorPosture != null) {
            return operatorPosture.screenToMap(d, d2);
        }
        return null;
    }

    public Coord2DDouble screenToLonLat(double d, double d2) {
        OperatorPosture operatorPosture = this.mOperatorPosture;
        if (operatorPosture != null) {
            return operatorPosture.screenToLonLat(d, d2);
        }
        return null;
    }

    public PointD mapToScreen(double d, double d2, double d3) {
        OperatorPosture operatorPosture = this.mOperatorPosture;
        if (operatorPosture != null) {
            return operatorPosture.mapToScreen(d, d2, d3);
        }
        return null;
    }

    public PointD lonLatToScreen(double d, double d2, double d3) {
        OperatorPosture operatorPosture = this.mOperatorPosture;
        if (operatorPosture != null) {
            return operatorPosture.lonLatToScreen(d, d2, d3);
        }
        return null;
    }

    public Coord3DDouble getMapCenter() {
        OperatorPosture operatorPosture = this.mOperatorPosture;
        if (operatorPosture != null) {
            return operatorPosture.getMapCenter();
        }
        return null;
    }

    public Coord3DDouble getMapCenterWithZ() {
        OperatorPosture operatorPosture = this.mOperatorPosture;
        if (operatorPosture != null) {
            return operatorPosture.getMapCenter();
        }
        return null;
    }

    public ArrayList<Double> getProjectionCenter() {
        OperatorPosture operatorPosture = this.mOperatorPosture;
        if (operatorPosture != null) {
            operatorPosture.getProjectionCenter();
            return null;
        }
        return null;
    }

    public void setOperatorScale() {
        MapView mapView = this.mMapView;
        if (mapView != null) {
            this.mOperatorScale = mapView.getOperatorScale();
        }
    }

    public void deleteOperatorScale() {
        if (this.mOperatorScale != null) {
            this.mOperatorScale = null;
        }
    }

    public void setOperatorStyle() {
        MapView mapView = this.mMapView;
        if (mapView != null) {
            this.mOperatorStyle = mapView.getOperatorStyle();
        }
    }

    public void deleteOperatorStyle() {
        if (this.mOperatorStyle != null) {
            this.mOperatorStyle = null;
        }
    }

    public void setOperatorGesture() {
        MapView mapView = this.mMapView;
        if (mapView != null) {
            this.mOperatorGesture = mapView.getOperatorGesture();
        }
    }

    public void deleteOperatorGesture() {
        if (this.mOperatorGesture != null) {
            this.mOperatorGesture = null;
        }
    }

    public int getMapStyleMode() {
        OperatorStyle operatorStyle = this.mOperatorStyle;
        if (operatorStyle != null) {
            operatorStyle.getMapStyleMode();
            return -2;
        }
        return -2;
    }

    public int getMapStyleTime() {
        OperatorStyle operatorStyle = this.mOperatorStyle;
        if (operatorStyle != null) {
            return operatorStyle.getMapStyleTime();
        }
        return -2;
    }

    public int getMapStyleState() {
        OperatorStyle operatorStyle = this.mOperatorStyle;
        if (operatorStyle != null) {
            return operatorStyle.getMapStyleState();
        }
        return -2;
    }

    public MapStyleParam getMapStyle() {
        OperatorStyle operatorStyle = this.mOperatorStyle;
        if (operatorStyle != null) {
            return operatorStyle.getMapStyle();
        }
        return null;
    }

    public boolean setMapStyle(MapStyleParam mapStyleParam, boolean z, boolean z2) {
        OperatorStyle operatorStyle = this.mOperatorStyle;
        if (operatorStyle != null) {
            operatorStyle.setMapStyle(mapStyleParam, z);
            resetTickCount(1);
            return true;
        }
        return false;
    }

    public RectDouble getPreviewRect(ArrayList<BizAGroupBusinessInfo> arrayList) {
        ArrayList arrayList2;
        int size;
        if (arrayList == null || (size = arrayList.size()) <= 0) {
            arrayList2 = null;
        } else {
            arrayList2 = new ArrayList();
            for (int i = 0; i < size; i++) {
                arrayList2.add(arrayList.get(i).mPos3D);
            }
        }
        return BizLayerUtil.getRect(arrayList2);
    }

    private void setMapViewState(int i) {
        this.mMapViewState = i;
        getBizControlManager().setMapViewState(this.mMapViewState);
    }
}
