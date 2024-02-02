package com.xiaopeng.montecarlo.navcore.mapdisplay;

import android.app.Application;
import android.view.Surface;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.autonavi.gbl.map.MapService;
import com.autonavi.gbl.map.adapter.MapSurfaceView;
import com.autonavi.gbl.map.model.DeviceAttribute;
import com.autonavi.gbl.map.model.EGLSurfaceAttr;
import com.autonavi.gbl.map.model.InitMapParam;
import com.autonavi.gbl.map.model.MapViewParam;
import com.autonavi.gbl.map.model.MapviewModeParam;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.xiaopeng.montecarlo.navcore.IMapListener;
import com.xiaopeng.montecarlo.navcore.control.BizControlManager;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.util.CommonUtil;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class MiniMapViewWrapper extends MapViewWrapper {
    private static final int MINIMAP_ASYNCTASK_THREADCOUNT = 4;
    private static final float SIZE_SCALE = 0.6f;
    private static final L.Tag TAG = new L.Tag("MiniMapViewWrapper");

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper
    @MainThread
    public void bindMapSurfaceView(@Nullable Application application, @Nullable MapSurfaceView mapSurfaceView, int i, int i2, @Nullable IMapListener iMapListener, int i3, MapViewWrapper.IXPMapSurfaceListener iXPMapSurfaceListener) {
        this.mApplication = application;
        creatMapSurfaceView(application, i, i2, 4, iXPMapSurfaceListener);
        super.bindMapSurfaceView(application, mapSurfaceView, i, i2, iMapListener, i3, iXPMapSurfaceListener);
        if (this.mMapView != null) {
            float miniMapCarUpRatio = CarFeatureManager.INSTANCE.getMiniMapCarUpRatio();
            this.mMapView.setCarPositionRatio(miniMapCarUpRatio, miniMapCarUpRatio);
            setFboEnable(false);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper
    protected void creatMapSurfaceView(@Nullable Application application, int i, int i2, int i3, MapViewWrapper.IXPMapSurfaceListener iXPMapSurfaceListener) {
        if (this.mMapView == null) {
            L.i(TAG, L.formatWithEngine(" mGlMapView is null, creating ....", getMainEngineID()));
            this.mXPMapSurfaceListener = iXPMapSurfaceListener;
            this.mMapService = (MapService) ServiceMgr.getServiceMgrInstance().getBLService(0);
            if (this.mMapService.isInit() == 1) {
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
                initMapParam.assetPath = RootUtil.SD_CARD_NAVI_PATH + "MapAsset/";
                initMapParam.buildingHeight = -1.0f;
                initMapParam.hardwareJsonParam = null;
                initMapParam.configBuffer = CommonUtil.getConfigBuffer(RootUtil.SD_CARD_NAVI_PATH);
                int initMap = this.mMapService.initMap(initMapParam);
                L.i(TAG, "initMap: i = " + initMap);
            }
            DeviceAttribute deviceAttribute = new DeviceAttribute();
            deviceAttribute.isNeedAntialias = true;
            deviceAttribute.samples = 4;
            deviceAttribute.deviceWorkMode = 0;
            int availableMainDeviceId = MapDeviceIdUtil.getAvailableMainDeviceId(true);
            if (availableMainDeviceId < 0) {
                L.w(TAG, L.formatWithEngine("map device create failed, no available device type, so far only 4 main engine with same type can be created", getMainEngineID()));
                return;
            }
            this.mDeviceId = availableMainDeviceId;
            L.i(TAG, L.formatWithEngine("map device id = " + this.mDeviceId, getMainEngineID()));
            this.mBizControlManager = new BizControlManager();
            this.mBizControlManager.init(this.mDeviceId, WorkThreadUtil.getInstance().getMiniBizControlLooper());
            this.mMapDevice = this.mMapService.createDevice(this.mDeviceId, deviceAttribute, this.mIDeviceObserver);
            this.mMapDevice.addDeviceObserver(this.mIDeviceObserver);
            this.mMapDevice.setRenderFpsByMode(0, 5);
            this.mMapDevice.setRenderFpsByMode(1, 6);
            this.mMapDevice.setRenderFpsByMode(2, 10);
            this.mMapDevice.setRenderFpsByMode(3, 10);
            MapViewParam mapViewParam = new MapViewParam();
            mapViewParam.mapDevice = 0L;
            mapViewParam.glThreadId = new BigInteger("0");
            mapViewParam.deviceId = this.mMapDevice.getDeviceId();
            mapViewParam.engineId = 3L;
            mapViewParam.x = 0L;
            mapViewParam.y = 0L;
            long j = i;
            mapViewParam.width = j;
            long j2 = i2;
            mapViewParam.height = j2;
            mapViewParam.screenWidth = j;
            mapViewParam.screenHeight = j2;
            mapViewParam.cacheCountFactor = 2.0f;
            mapViewParam.asyncTaskThreadCount = i3;
            this.mMapView = this.mMapService.createMapView(mapViewParam, this.mIBLMapViewProxy, null, null, null);
            initOperator();
            this.mOperatorGesture.setMapLabelClickable(true);
            this.mMapView.setTextTextureObserver(this.mITextTextureObserver);
            setMapTextScale(1.3f);
            setMapZoomScale(61.25f / (ContextUtils.getScreenWidth() * 0.6f), ContextUtils.getDensityDpi());
            this.mMapView.setCarPositionRatio(0.7f, 0.55f);
            setMaxZoomLevel(19.0f);
            this.mMainEngineID = this.mMapView.getEngineId();
            this.mOperatorBusiness.appendOpenLayer(NavCoreUtil.OPEN_LAYER_USER_TRAFFIC_JSON.getBytes());
            this.mMapTextureCache = new MapTextureCache(10485760, this);
        }
    }

    public void initCarScaleByMapLevel() {
        getBizControlManager().initMiniCarScaleByMapLevel();
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper
    public int getDefaultMapViewLeft() {
        if (checkMapViewValid()) {
            int mapWidth = getMapWidth() / 2;
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatWithEngine("getDefaultMapViewLeft: " + mapWidth, getMainEngineID()));
            }
            return mapWidth;
        }
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper
    public int getDefaultMapViewTop() {
        if (checkMapViewValid()) {
            int mapHeight = (int) (getMapHeight() * CarFeatureManager.INSTANCE.getMiniMapCarUpRatio());
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatWithEngine("getDefaultMapViewTop: " + mapHeight, getMainEngineID()));
            }
            return mapHeight;
        }
        return 0;
    }

    public void unInitMapView() {
        if (checkMapViewValid()) {
            L.i(TAG, L.formatWithEngine("unInitMapView start", getMainEngineID()));
            this.mMapDevice.detachSurfaceFromDevice();
            this.mMapView.removeMapviewObserver(this.mCustomMapListener);
            this.mMapView.removeGestureObserver(this.mCustomMapListener);
            this.mCustomMapListener = null;
            this.mGlMapViewInitialized = false;
            unInitLayerControl();
            L.i(TAG, L.formatWithEngine("unInitMapView end", getMainEngineID()));
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper
    public void setMapMode(int i, boolean z, boolean z2) {
        if (checkMapViewValid()) {
            L.Tag tag = TAG;
            L.i(tag, L.formatWithEngine("setMapMode : " + i + " , animation : " + z, getMainEngineID()));
            MapviewModeParam mapviewModeParam = new MapviewModeParam();
            mapviewModeParam.mode = i;
            mapviewModeParam.bChangeCenter = z2;
            if (2 == i) {
                mapviewModeParam.pitchAngle = 60.0f;
            }
            this.mMapView.setMapMode(mapviewModeParam, z);
            getBizControlManager().updateCarStyle(TBTManager.getInstance().getCurrentStatus() != 0 ? 2001 : 2002);
        }
    }

    public void attachSurfaceToDevice(Surface surface, EGLSurfaceAttr eGLSurfaceAttr) {
        this.mMapDevice.detachSurfaceFromDevice();
        eGLSurfaceAttr.nativeWindow = this.mMapDevice.getWindowFromSurface(surface);
        this.mMapDevice.attachSurfaceToDevice(eGLSurfaceAttr);
    }
}
