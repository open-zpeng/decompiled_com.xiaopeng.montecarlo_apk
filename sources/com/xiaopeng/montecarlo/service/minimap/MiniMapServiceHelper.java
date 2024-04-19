package com.xiaopeng.montecarlo.service.minimap;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.MainThread;
import com.autonavi.gbl.layer.model.BizRouteType;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.model.PathMatchInfo;
import com.autonavi.gbl.map.model.EGLSurfaceAttr;
import com.xiaopeng.montecarlo.IBLCompleteListener;
import com.xiaopeng.montecarlo.InitializerManager;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MiniMapViewWrapper;
import com.xiaopeng.montecarlo.navcore.mapdisplay.PoolBytes;
import com.xiaopeng.montecarlo.navcore.setting.SettingBLManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener;
import com.xiaopeng.montecarlo.navcore.sr.LaneServiceManager;
import com.xiaopeng.montecarlo.navcore.sr.SRDataUtil;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import com.xiaopeng.montecarlo.navcore.util.BMPDataUtil;
import com.xiaopeng.montecarlo.navcore.util.TBTUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.theme.ThemeType;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.scenes.mapscene.CarLocIconHelper;
import com.xiaopeng.montecarlo.scenes.mapscene.MapDisplayManager;
import com.xiaopeng.montecarlo.scenes.mapscene.MapPrepareLayerStyle;
import com.xiaopeng.montecarlo.service.minimap.LocalMiniMapSurface;
import com.xiaopeng.montecarlo.service.minimap.dynamiclevel.MiniMapCruiseDynamicLevelHelper;
import com.xiaopeng.montecarlo.service.minimap.dynamiclevel.MiniMapGuideDynamicLevelHelper;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MiniMapServiceHelper implements MapViewWrapper.IXPMapSurfaceListener, ISRInfoChangedListener {
    private static final int LOG_CONTROL_LIMIT = 50;
    private static final L.Tag TAG = new L.Tag("MiniMapServiceHelper");
    private Bitmap mBitmap;
    private LocalMiniMapSurface mLocalMiniMapSurface;
    private MapPrepareLayerStyle mMapStyleReader;
    protected MiniMapViewWrapper mMapViewWrapper;
    private MiniMapAccountEventCallback mMiniMapAccountEventCallback;
    private MiniMapCruiseDynamicLevelHelper mMiniMapCruiseDynamicLevelHelper;
    private int mMiniMapFps;
    private MiniMapGuideDynamicLevelHelper mMiniMapGuideDynamicLevelHelper;
    protected int mMiniMapHeight;
    private MiniMapListener mMiniMapListener;
    protected int mMiniMapWidth;
    private MiniMapXPCarStateListener mMiniMapXPCarStateListener;
    private MiniNaviListener mMiniNaviListener;
    private byte[] mSendData;
    private WeakReference<MiniMapService> mServiceWeakReference;
    private Surface mSurface;
    private boolean mIsNeedSendToIcm = false;
    private boolean mIsInitMapView = false;
    private boolean mIsMapSizeChanged = false;
    private int mLogCounter = 0;
    private int mSendMapImageType = -1;
    private boolean firstNotifyInstrument = true;
    private LocalMiniMapSurface.Callback mCallback = new LocalMiniMapSurface.Callback() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapServiceHelper.1
        @Override // com.xiaopeng.montecarlo.service.minimap.LocalMiniMapSurface.Callback
        public void onReaderCreated(Surface surface, int i, int i2) {
            MiniMapServiceHelper.this.surfaceCreate(surface, i, i2);
        }

        @Override // com.xiaopeng.montecarlo.service.minimap.LocalMiniMapSurface.Callback
        public void onReaderDestroy(Surface surface, int i, int i2) {
            MiniMapServiceHelper.this.surfaceDestroy();
        }

        @Override // com.xiaopeng.montecarlo.service.minimap.LocalMiniMapSurface.Callback
        public void onReaderSizeChanged(Surface surface, int i, int i2) {
            MiniMapServiceHelper.this.surfaceSizeChanged(surface, i, i2);
        }

        @Override // com.xiaopeng.montecarlo.service.minimap.LocalMiniMapSurface.Callback
        public void onImageReaderError() {
            MiniMapServiceHelper.this.forceResetMiniMap();
        }

        @Override // com.xiaopeng.montecarlo.service.minimap.LocalMiniMapSurface.Callback
        public void onFrameUpdate(Image.Plane plane, int i, int i2) {
            if (MiniMapServiceHelper.this.mLogCounter % 50 == 0) {
                L.Tag tag = MiniMapServiceHelper.TAG;
                L.i(tag, ">>> onFrameUpdate width=" + i + " height=" + i2 + " mIsNeedSendToIcm=" + MiniMapServiceHelper.this.mIsNeedSendToIcm);
                MiniMapServiceHelper.this.mLogCounter = 0;
            } else if (L.ENABLE) {
                L.Tag tag2 = MiniMapServiceHelper.TAG;
                L.d(tag2, ">>> onFrameUpdate width=" + i + " height=" + i2 + " mIsNeedSendToIcm=" + MiniMapServiceHelper.this.mIsNeedSendToIcm);
            }
            RootUtil.updateMiniMapTimeTick();
            MiniMapServiceHelper.access$008(MiniMapServiceHelper.this);
            if ((MiniMapServiceHelper.this.mIsNeedSendToIcm || TBTManager.getInstance().isNeedMiniMap()) && MiniMapServiceHelper.this.mIsInitMapView) {
                ByteBuffer buffer = plane.getBuffer();
                PoolBytes obtainBytes = PoolBytes.obtainBytes(buffer.remaining(), i, i2);
                buffer.get(obtainBytes.mBytes);
                Handler handler = MiniMapServiceHelper.this.mSendHandler;
                MiniMapServiceHelper miniMapServiceHelper = MiniMapServiceHelper.this;
                handler.post(new SendDataRunnable(obtainBytes, miniMapServiceHelper.mSendMapImageType));
            }
        }
    };
    private Handler mSendHandler = new Handler(WorkThreadUtil.getInstance().getMiniMapThreadLooper());
    private boolean mIsRadarEnable = SettingBLManager.isRadarEnableInNavigation();

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper.IXPMapSurfaceListener
    public void onDeviceRender(int i, int i2) {
    }

    public void onMapModeChanged(int i) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper.IXPMapSurfaceListener
    public void onSurfaceDestroy(int i) {
    }

    static /* synthetic */ int access$008(MiniMapServiceHelper miniMapServiceHelper) {
        int i = miniMapServiceHelper.mLogCounter;
        miniMapServiceHelper.mLogCounter = i + 1;
        return i;
    }

    public void surfaceCreate(final Surface surface, final int i, final int i2) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapServiceHelper.2
            @Override // java.lang.Runnable
            public void run() {
                if (MiniMapServiceHelper.this.mMapViewWrapper != null) {
                    MiniMapServiceHelper.this.mSurface = null;
                    if (MiniMapServiceHelper.this.mMapViewWrapper.getGLMapView() == null) {
                        L.w(MiniMapServiceHelper.TAG, "glMapView is null");
                        return;
                    }
                    MiniMapServiceHelper.this.attachSurfaceToDevice(surface, i, i2);
                    MiniMapServiceHelper.this.mMapViewWrapper.resetMapviewPort(i, i2);
                    if (MiniMapServiceHelper.this.mMapViewWrapper.isMapSurfaceCreate() && !MiniMapServiceHelper.this.mIsInitMapView) {
                        MiniMapServiceHelper.this.initMiniMap();
                    } else {
                        MiniMapServiceHelper.this.mMapViewWrapper.restoreCarPosition();
                        MiniMapServiceHelper.this.mMapViewWrapper.initMapCenter(true, true);
                    }
                    if (MiniMapServiceHelper.this.isNeedCreateSurface()) {
                        RootUtil.startExceptionWatcher();
                        return;
                    }
                    return;
                }
                MiniMapServiceHelper.this.mSurface = surface;
                MiniMapServiceHelper miniMapServiceHelper = MiniMapServiceHelper.this;
                miniMapServiceHelper.mMiniMapWidth = i;
                miniMapServiceHelper.mMiniMapHeight = i2;
            }
        });
    }

    public void surfaceSizeChanged(final Surface surface, final int i, final int i2) {
        L.Tag tag = TAG;
        L.i(tag, ">>> surfaceSizeChanged width=" + i + " height=" + i2);
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapServiceHelper.3
            @Override // java.lang.Runnable
            public void run() {
                if (MiniMapServiceHelper.this.mMapViewWrapper == null) {
                    MiniMapServiceHelper.this.mSurface = surface;
                    MiniMapServiceHelper miniMapServiceHelper = MiniMapServiceHelper.this;
                    miniMapServiceHelper.mMiniMapWidth = i;
                    miniMapServiceHelper.mMiniMapHeight = i2;
                    return;
                }
                RootUtil.stopExceptionWatcher();
                if (MiniMapServiceHelper.this.mMapViewWrapper.getGLMapView() == null) {
                    return;
                }
                MiniMapServiceHelper.this.attachSurfaceToDevice(surface, i, i2);
                MiniMapServiceHelper.this.mIsMapSizeChanged = false;
                if (MiniMapServiceHelper.this.isNeedCreateSurface()) {
                    RootUtil.startExceptionWatcher();
                }
            }
        });
    }

    public void surfaceDestroy() {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapServiceHelper.4
            @Override // java.lang.Runnable
            public void run() {
                MiniMapServiceHelper.this.mSurface = null;
                RootUtil.stopExceptionWatcher();
                MiniMapServiceHelper.this.mMapViewWrapper.detachSurfaceToDevice();
                MiniMapServiceHelper.this.mMapViewWrapper.stopCheckCarIconStatus();
            }
        });
    }

    public MiniMapServiceHelper(MiniMapService miniMapService) {
        this.mServiceWeakReference = new WeakReference<>(miniMapService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attachSurfaceToDevice(Surface surface, int i, int i2) {
        L.Tag tag = TAG;
        L.i(tag, "attachSurfaceToDevice width = " + i + " height = " + i2);
        int mapModeByCurrentTheme = ThemeWatcherUtil.getMapModeByCurrentTheme();
        EGLSurfaceAttr eGLSurfaceAttr = new EGLSurfaceAttr();
        eGLSurfaceAttr.width = i;
        eGLSurfaceAttr.height = i2;
        eGLSurfaceAttr.display = -1L;
        eGLSurfaceAttr.isBackSurface = false;
        if (mapModeByCurrentTheme == 1) {
            eGLSurfaceAttr.initColor = -16777216;
        } else if (mapModeByCurrentTheme == 0) {
            eGLSurfaceAttr.initColor = -1;
        }
        this.mMapViewWrapper.attachSurfaceToDevice(surface, eGLSurfaceAttr);
    }

    public void createMapView(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            L.Tag tag = TAG;
            L.w(tag, "createMapView but width or height was 0 width=" + i + " height=" + i2);
            return;
        }
        MiniMapService miniMapService = this.mServiceWeakReference.get();
        if (miniMapService == null) {
            L.w(TAG, "createMapView but service was died");
        }
        L.i(TAG, "createMapView");
        if (this.mMapViewWrapper == null) {
            this.mMiniMapListener = new MiniMapListener(this);
            this.mMapViewWrapper = (MiniMapViewWrapper) MapDisplayManager.getInstance().createMiniMapEngineWrapper(miniMapService.getApplication(), null, i, i2, this.mMiniMapListener, ThemeWatcherUtil.getMapModeByCurrentTheme(), 3, this);
            this.mMapViewWrapper.setCarLocIconHelper(new CarLocIconHelper(this.mMapViewWrapper));
            MiniMapViewWrapper miniMapViewWrapper = this.mMapViewWrapper;
            this.mMapStyleReader = new MapPrepareLayerStyle(miniMapViewWrapper, miniMapViewWrapper.getMainEngineID(), null, true);
            this.mMapStyleReader.init();
            this.mMapViewWrapper.initBizStyleReader(this.mMapStyleReader, ThemeWatcherUtil.getMapModeByCurrentTheme(), ThemeWatcherUtil.getCurrentTheme());
            this.mMapViewWrapper.lockMapCameraDegree(true);
            this.mMapViewWrapper.lockMapAngle(true);
            this.mMapViewWrapper.getBizControlManager().openDynamicLevel(false);
            refreshFps(this.mMiniMapFps);
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            surfaceCreate(surface, this.mMiniMapWidth, this.mMiniMapHeight);
        }
        createMiniMapSurface();
        if (this.mMiniMapCruiseDynamicLevelHelper == null) {
            this.mMiniMapCruiseDynamicLevelHelper = new MiniMapCruiseDynamicLevelHelper(this.mMapViewWrapper);
        }
        if (this.mMiniMapGuideDynamicLevelHelper == null) {
            this.mMiniMapGuideDynamicLevelHelper = new MiniMapGuideDynamicLevelHelper(this.mMapViewWrapper);
        }
        if (this.mMiniNaviListener == null) {
            this.mMiniNaviListener = new MiniNaviListener(this);
            TBTManager.getInstance().addNaviListener(this.mMiniNaviListener);
            TBTManager.getInstance().addRerouteListener(this.mMiniNaviListener);
        }
    }

    public void initMiniMap() {
        this.mIsInitMapView = true;
        this.mMapViewWrapper.setMapLevel(18.0f);
        this.mMapViewWrapper.setMapMode(SettingWrapper.getCurrentMinimapMapMode(), true, false);
        updateRealTimeTrafficState(SettingWrapper.isRealTimeTraffic());
        this.mMapViewWrapper.startCheckCarIconStatus();
        L.Tag tag = TAG;
        L.i(tag, "initMiniMap:" + this.mMiniMapWidth + ", " + this.mMiniMapHeight);
        this.mMapViewWrapper.resetMapviewPort(this.mMiniMapWidth, this.mMiniMapHeight);
        this.mMapViewWrapper.restoreCarPosition();
        if (TBTManager.getInstance().getCurrentStatus() == 0) {
            startCruise();
        } else {
            startNavi();
        }
    }

    public void removeMapView() {
        TBTManager.getInstance().removeNaviListener(this.mMiniNaviListener);
        TBTManager.getInstance().removeRerouteListener(this.mMiniNaviListener);
        MiniNaviListener miniNaviListener = this.mMiniNaviListener;
        if (miniNaviListener != null) {
            miniNaviListener.release();
            this.mMiniNaviListener = null;
        }
        MiniMapCruiseDynamicLevelHelper miniMapCruiseDynamicLevelHelper = this.mMiniMapCruiseDynamicLevelHelper;
        if (miniMapCruiseDynamicLevelHelper != null) {
            miniMapCruiseDynamicLevelHelper.release();
            this.mMiniMapCruiseDynamicLevelHelper = null;
        }
        MiniMapGuideDynamicLevelHelper miniMapGuideDynamicLevelHelper = this.mMiniMapGuideDynamicLevelHelper;
        if (miniMapGuideDynamicLevelHelper != null) {
            miniMapGuideDynamicLevelHelper.release();
            this.mMiniMapGuideDynamicLevelHelper = null;
        }
        LocalMiniMapSurface localMiniMapSurface = this.mLocalMiniMapSurface;
        if (localMiniMapSurface != null) {
            localMiniMapSurface.release();
        }
        MiniMapViewWrapper miniMapViewWrapper = this.mMapViewWrapper;
        if (miniMapViewWrapper != null) {
            miniMapViewWrapper.unInitMapView();
            this.mMapViewWrapper.setXPMapSurfaceListener(null);
            this.mMiniMapListener = null;
        }
    }

    public void init() {
        this.mIsNeedSendToIcm = CarServiceManager.getInstance().getIcmMapDisplayState();
        this.mMiniMapWidth = CarServiceManager.getInstance().getIcmMapWidth();
        this.mMiniMapHeight = CarServiceManager.getInstance().getIcmMapHeight();
        this.mMiniMapFps = CarServiceManager.getInstance().getIcmMapFps();
        this.mSendMapImageType = CarServiceManager.getInstance().getIcmMapImageType();
        if (this.mMiniMapXPCarStateListener == null) {
            this.mMiniMapXPCarStateListener = new MiniMapXPCarStateListener(this);
            CarServiceManager.getInstance().addCarStateListener(this.mMiniMapXPCarStateListener);
        }
        if (this.mMiniMapAccountEventCallback == null) {
            this.mMiniMapAccountEventCallback = new MiniMapAccountEventCallback(this);
            XPAccountServiceWrapper.getInstance().registerAccountEventCallback(this.mMiniMapAccountEventCallback);
        }
        updateMiniMapSize(this.mMiniMapWidth, this.mMiniMapHeight);
        SRNaviManager.getInstance().addSRInfoChangedListener(this);
    }

    public void release() {
        CarServiceManager.getInstance().removeCarStateListener(this.mMiniMapXPCarStateListener);
        this.mMiniMapXPCarStateListener = null;
        XPAccountServiceWrapper.getInstance().unRegisterAccountEventCallback(this.mMiniMapAccountEventCallback);
        this.mMiniMapAccountEventCallback = null;
        SRNaviManager.getInstance().removeSRInfoChangedListener(this);
        removeMapView();
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.mBitmap.recycle();
        this.mBitmap = null;
    }

    public void updateMapImageType(int i) {
        LocalMiniMapSurface localMiniMapSurface;
        this.mSendMapImageType = i;
        if (isNeedCreateSurface()) {
            createBitmap(this.mMiniMapWidth, this.mMiniMapHeight);
            createMiniMapSurface();
        }
        if (isSendTypeSurface() && (localMiniMapSurface = this.mLocalMiniMapSurface) != null) {
            localMiniMapSurface.release();
        }
        this.mSendData = null;
    }

    public void updateFps(int i) {
        if (i == this.mMiniMapFps || i <= 0) {
            return;
        }
        this.mMiniMapFps = i;
        refreshFps(this.mMiniMapFps);
    }

    private void refreshFps(int i) {
        MiniMapViewWrapper miniMapViewWrapper;
        if (i <= 0 || (miniMapViewWrapper = this.mMapViewWrapper) == null) {
            return;
        }
        miniMapViewWrapper.setRenderFpsByMode(0, this.mMiniMapFps);
        this.mMapViewWrapper.setRenderFpsByMode(1, this.mMiniMapFps);
    }

    public void updateMiniMapSize(int i, int i2) {
        L.Tag tag = TAG;
        L.i(tag, "updateMiniMapSize width=" + i + " height=" + i2);
        if (!InitializerManager.getInstance().isBLInitialized()) {
            L.w(TAG, "updateMiniMapSize but bl is not initialized!!!");
            checkBLInitialized();
        } else if (this.mMapViewWrapper == null) {
            this.mMiniMapWidth = i;
            this.mMiniMapHeight = i2;
            if (isNeedCreateSurface()) {
                createBitmap(this.mMiniMapWidth, this.mMiniMapHeight);
            }
            createMapView(i, i2);
        } else if (this.mMiniMapWidth == i && this.mMiniMapHeight == i2) {
        } else {
            this.mIsMapSizeChanged = true;
            this.mSendData = null;
            this.mMiniMapWidth = i;
            this.mMiniMapHeight = i2;
            if (isNeedCreateSurface()) {
                createBitmap(this.mMiniMapWidth, this.mMiniMapHeight);
                LocalMiniMapSurface localMiniMapSurface = this.mLocalMiniMapSurface;
                if (localMiniMapSurface != null) {
                    localMiniMapSurface.updateSize(i, i2);
                }
            }
        }
    }

    private void createMiniMapSurface() {
        if (isNeedCreateSurface()) {
            MiniMapService miniMapService = this.mServiceWeakReference.get();
            if (miniMapService == null) {
                L.w(TAG, "createMapView but service was died");
            }
            if (this.mMiniMapWidth <= 0 || this.mMiniMapHeight <= 0) {
                L.Tag tag = TAG;
                L.w(tag, "createMiniMapSurface mMiniMapWidth:" + this.mMiniMapWidth + ", mMiniMapHeight:" + this.mMiniMapHeight);
            } else if (this.mLocalMiniMapSurface == null) {
                this.mLocalMiniMapSurface = new LocalMiniMapSurface(miniMapService, this.mCallback);
                this.mLocalMiniMapSurface.initCodec(this.mMiniMapWidth, this.mMiniMapHeight);
            }
        }
    }

    private boolean isSendTypeSurface() {
        return 6 == this.mSendMapImageType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedCreateSurface() {
        int i = this.mSendMapImageType;
        return (-1 == i || 6 == i) ? false : true;
    }

    private void createBitmap(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mBitmap.recycle();
        }
        this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
    }

    private void checkBLInitialized() {
        InitializerManager.getInstance().addBLInitCompleteListener(new IBLCompleteListener() { // from class: com.xiaopeng.montecarlo.service.minimap.-$$Lambda$MiniMapServiceHelper$W42ZGOHR8BEzr9ou1JGOOc2u6mc
            @Override // com.xiaopeng.montecarlo.IBLCompleteListener
            public final void onResult() {
                MiniMapServiceHelper.this.lambda$checkBLInitialized$0$MiniMapServiceHelper();
            }
        });
    }

    public /* synthetic */ void lambda$checkBLInitialized$0$MiniMapServiceHelper() {
        L.Tag tag = TAG;
        L.i(tag, " onResult is call in thread : " + Thread.currentThread().getName());
        if (InitializerManager.getInstance().isBLInitialized()) {
            L.i(TAG, "BLInitCompleteListener onResult : isBLInitialized is true");
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapServiceHelper.5
                @Override // java.lang.Runnable
                public void run() {
                    MiniMapServiceHelper.this.updateMiniMapSize(CarServiceManager.getInstance().getIcmMapWidth(), CarServiceManager.getInstance().getIcmMapHeight());
                }
            });
            return;
        }
        L.e(TAG, "BLInitCompleteListener onResult : isBLInitialized is false  ...");
        checkBLInitialized();
    }

    public void forceResetMiniMap() {
        if (isNeedCreateSurface()) {
            this.mIsMapSizeChanged = true;
            L.Tag tag = TAG;
            L.i(tag, "forceResetMiniMap:" + this.mMiniMapWidth + "x" + this.mMiniMapHeight);
            LocalMiniMapSurface localMiniMapSurface = this.mLocalMiniMapSurface;
            if (localMiniMapSurface != null) {
                localMiniMapSurface.updateSize(this.mMiniMapWidth, this.mMiniMapHeight);
            }
            DataLogUtil.sendStatData(PageType.NONE_UI_RELATED, BtnType.RESET_MINIMAP, new Object[0]);
        }
    }

    public void setMapDensityDpiByHW(int i, int i2) {
        MiniMapViewWrapper miniMapViewWrapper = this.mMapViewWrapper;
        if (miniMapViewWrapper != null) {
            miniMapViewWrapper.setMapDensityDpiByHW(i, i2);
        }
    }

    public void updateMiniMapDisplayState(boolean z) {
        this.mIsNeedSendToIcm = z;
        if (this.mMapViewWrapper != null) {
            this.mMapStyleReader.setIsNeedRefresh(this.mIsNeedSendToIcm);
            if (this.mIsNeedSendToIcm) {
                if (this.mMapViewWrapper.isRenderPaused()) {
                    this.mMapViewWrapper.renderResume();
                    if (isNeedCreateSurface()) {
                        RootUtil.startExceptionWatcher();
                    }
                }
                this.mMapViewWrapper.getBizControlManager().updateResMarker(ThemeWatcherUtil.isDayMode());
                this.mMapViewWrapper.resetTickCount(1);
                return;
            }
            RootUtil.stopExceptionWatcher();
            this.mMapViewWrapper.renderPause();
        }
    }

    public void goBackCenter() {
        MiniMapViewWrapper miniMapViewWrapper = this.mMapViewWrapper;
        if (miniMapViewWrapper != null) {
            miniMapViewWrapper.goBackCenter();
        }
    }

    public void setMapLevel(float f) {
        MiniMapViewWrapper miniMapViewWrapper = this.mMapViewWrapper;
        if (miniMapViewWrapper != null) {
            miniMapViewWrapper.setMapLevel(f);
        }
    }

    public void setCarPositionRatio(float f, float f2) {
        MiniMapViewWrapper miniMapViewWrapper = this.mMapViewWrapper;
        if (miniMapViewWrapper != null) {
            miniMapViewWrapper.setCarPositionRatio(f, f2);
        }
    }

    public void setCameraDegree(float f) {
        MiniMapViewWrapper miniMapViewWrapper = this.mMapViewWrapper;
        if (miniMapViewWrapper != null) {
            miniMapViewWrapper.setCameraDegree(f);
        }
    }

    public void setMapMode(int i, boolean z, boolean z2) {
        if (this.mMapViewWrapper != null) {
            if (isMiniMapLaneMode()) {
                this.mMapViewWrapper.updateMapModeForLane(i);
                return;
            }
            boolean z3 = true;
            boolean z4 = TBTManager.getInstance().getCurrentStatus() != 0;
            MiniMapViewWrapper miniMapViewWrapper = this.mMapViewWrapper;
            if (!z || z4) {
                z3 = false;
            }
            miniMapViewWrapper.setMapMode(i, z3, z2);
        }
    }

    public void updateDayNightMode(int i, ThemeType themeType) {
        MiniMapViewWrapper miniMapViewWrapper = this.mMapViewWrapper;
        if (miniMapViewWrapper != null) {
            miniMapViewWrapper.updateDayNightMode(i, themeType);
            this.mMapViewWrapper.updateCarLocIcon();
        }
    }

    @MainThread
    public void startCruise() {
        nofityInstrumentStatus(false);
        this.mMapViewWrapper.initCruiseCar(ThemeWatcherUtil.getMapModeByCurrentTheme());
        this.mMapViewWrapper.goBackCenter(false);
        clearOverlay();
        enableCruiseDynamicLevel();
    }

    @MainThread
    public void startNavi() {
        this.mIsRadarEnable = SettingBLManager.isRadarEnableInNavigation();
        updateMapViewState(isMiniMapLaneMode(), true);
        this.mMapViewWrapper.goBackCenter(false);
        updateMultiAlternativeLabel();
        drawRoute();
        enableGuideDynamicLevel();
    }

    public void updateResMarker() {
        MiniMapViewWrapper miniMapViewWrapper = this.mMapViewWrapper;
        if (miniMapViewWrapper != null) {
            miniMapViewWrapper.getBizControlManager().updateResMarker(ThemeWatcherUtil.isDayMode());
        }
    }

    public void updateNaviInfo(XPNaviInfo xPNaviInfo) {
        MiniMapGuideDynamicLevelHelper miniMapGuideDynamicLevelHelper = this.mMiniMapGuideDynamicLevelHelper;
        if (miniMapGuideDynamicLevelHelper != null) {
            miniMapGuideDynamicLevelHelper.sendUpdateInfoMsg(xPNaviInfo);
        }
    }

    @MainThread
    public void updateRouteTmc(List<ILightBarInfo> list) {
        this.mMapViewWrapper.getBizControlManager().updateRouteTmc(list);
    }

    public void onShowCrossImage(XPCrossImageInfo xPCrossImageInfo) {
        if (xPCrossImageInfo == null || 4 != xPCrossImageInfo.mType) {
            return;
        }
        this.mMapViewWrapper.getBizControlManager().showCross(xPCrossImageInfo, null);
    }

    public void onHideCrossImage(int i) {
        if (4 == i) {
            this.mMapViewWrapper.getBizControlManager().hideCross(i, null);
        }
    }

    @SuppressLint({"WrongConstant"})
    @MainThread
    public void deletePath(List<Long> list, long j, boolean z) {
        this.mMapViewWrapper.getBizControlManager().deletePath();
        if (z) {
            return;
        }
        drawRoute();
    }

    @SuppressLint({"WrongConstant"})
    public void updateViaPass(long j) {
        RouteParams currentNaviRouteParams = TBTManager.getInstance().getCurrentNaviRouteParams();
        if (currentNaviRouteParams != null) {
            this.mMapViewWrapper.getBizControlManager().updateRouteOverlayElem(currentNaviRouteParams);
        }
    }

    @SuppressLint({"WrongConstant"})
    public void showNaviManeuver(XPManeuverInfo xPManeuverInfo) {
        if (xPManeuverInfo != null) {
            ArrayList<Long> arrayList = new ArrayList<>(1);
            arrayList.add(Long.valueOf(xPManeuverInfo.mSegmentIndex));
            this.mMapViewWrapper.getBizControlManager().setRouteArrowShowSegment(arrayList);
        }
    }

    @MainThread
    public void drawRoute() {
        long currentNaviId = TBTManager.getInstance().getCurrentNaviId();
        int currentNaviPathIndex = TBTManager.getInstance().getCurrentNaviPathIndex();
        if (-1 != currentNaviId) {
            this.mMapViewWrapper.getBizControlManager().drawRoute(BLParams.RouteOverlayGuide, TBTManager.getInstance().getCurrentNaviPathResult(), TBTManager.getInstance().getCurrentNaviRouteParams(), currentNaviId, currentNaviPathIndex, true);
        }
    }

    @MainThread
    public void selectMainPath(long j) {
        int pathIndexFromPathId = TBTUtil.getPathIndexFromPathId(TBTManager.getInstance().getCurrentNaviPathResult(), j);
        if (pathIndexFromPathId > -1) {
            this.mMapViewWrapper.getBizControlManager().setSelectedPath(BLParams.RouteOverlayGuide, TBTManager.getInstance().getCurrentNaviId(), pathIndexFromPathId);
        }
    }

    @SuppressLint({"WrongConstant"})
    @MainThread
    public void clearOverlay() {
        this.mMapViewWrapper.getBizControlManager().clearOverlay();
    }

    @SuppressLint({"WrongConstant"})
    @MainThread
    public void onNaviStop(int i) {
        CarLoc originCarLocation;
        PathMatchInfo pathMatchInfo;
        if (2 != i) {
            clearOverlay();
            this.mMapViewWrapper.getBizControlManager().clearAllItems(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, 6031L);
            if (1 != i || (originCarLocation = TBTManager.getInstance().getOriginCarLocation()) == null) {
                return;
            }
            if (CollectionUtils.isNotEmpty(originCarLocation.vecPathMatchInfo) && (pathMatchInfo = originCarLocation.vecPathMatchInfo.get(0)) != null) {
                TBTManager.getInstance().getPosServiceWrapper().setMockCarLocation(new XPCoordinate2DDouble(pathMatchInfo.longitude, pathMatchInfo.latitude));
            }
            this.mMapViewWrapper.getBizControlManager().setCarLocation(originCarLocation);
            this.mMapViewWrapper.setMapMode(SettingWrapper.getCurrentMinimapMapMode(), true, true);
        }
    }

    public void updateCarIcon() {
        MiniMapViewWrapper miniMapViewWrapper = this.mMapViewWrapper;
        if (miniMapViewWrapper != null) {
            miniMapViewWrapper.updateCarLocIcon();
        }
    }

    public void updateRealTimeTrafficState(boolean z) {
        MiniMapViewWrapper miniMapViewWrapper = this.mMapViewWrapper;
        if (miniMapViewWrapper != null) {
            miniMapViewWrapper.setTrafficState(z);
        }
    }

    public void refreshMultiAlternativeLabel() {
        boolean isRadarEnableInNavigation;
        if (this.mMapViewWrapper == null || this.mIsRadarEnable == (isRadarEnableInNavigation = SettingBLManager.isRadarEnableInNavigation())) {
            return;
        }
        this.mIsRadarEnable = isRadarEnableInNavigation;
        this.mMapViewWrapper.getBizControlManager().refreshMultiAlternativeLabel();
    }

    public void updateMapViewState(boolean z, boolean z2) {
        int icmMapWidth;
        int icmMapHeight;
        int icmMapFps;
        if (z) {
            icmMapWidth = CarServiceManager.getInstance().getIcmSrMapWidth() > 0 ? CarServiceManager.getInstance().getIcmSrMapWidth() : this.mMiniMapWidth;
            icmMapHeight = CarServiceManager.getInstance().getIcmSrMapHeight() > 0 ? CarServiceManager.getInstance().getIcmSrMapHeight() : this.mMiniMapHeight;
            icmMapFps = CarServiceManager.getInstance().getIcmSrMapFps() > 0 ? CarServiceManager.getInstance().getIcmSrMapFps() : this.mMiniMapFps;
        } else {
            icmMapWidth = CarServiceManager.getInstance().getIcmMapWidth() > 0 ? CarServiceManager.getInstance().getIcmMapWidth() : this.mMiniMapWidth;
            icmMapHeight = CarServiceManager.getInstance().getIcmMapHeight() > 0 ? CarServiceManager.getInstance().getIcmMapHeight() : this.mMiniMapHeight;
            icmMapFps = CarServiceManager.getInstance().getIcmMapFps() > 0 ? CarServiceManager.getInstance().getIcmMapFps() : this.mMiniMapFps;
        }
        if (icmMapWidth == 0 || icmMapHeight == 0) {
            L.Tag tag = TAG;
            L.e(tag, "updateMapViewState width:" + icmMapWidth + ", height:" + icmMapHeight);
            return;
        }
        updateMiniMapSize(icmMapWidth, icmMapHeight);
        updateFps(icmMapFps);
        nofityInstrumentStatus(z);
        if (this.mMapViewWrapper != null) {
            if (z) {
                disableDynamicLevel();
                this.mMapViewWrapper.switchToLane(ThemeWatcherUtil.getMapModeByCurrentTheme());
                return;
            }
            if (TBTManager.getInstance().getCurrentStatus() == 0) {
                enableCruiseDynamicLevel();
            } else {
                enableGuideDynamicLevel();
            }
            if (z2) {
                this.mMapViewWrapper.initNaviCar(ThemeWatcherUtil.getMapModeByCurrentTheme());
                this.mMapViewWrapper.getBizControlManager().initNaviCar(true);
                return;
            }
            this.mMapViewWrapper.switchToSD(ThemeWatcherUtil.getMapModeByCurrentTheme());
        }
    }

    public boolean isMiniMapLaneMode() {
        MiniMapViewWrapper miniMapViewWrapper = this.mMapViewWrapper;
        return miniMapViewWrapper != null && miniMapViewWrapper.isLaneMode();
    }

    private void updateMultiAlternativeLabel() {
        this.mMapViewWrapper.getBizControlManager().setVisible(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, BizRouteType.BizRouteTypeGuideLabel, SettingBLManager.isRadarEnableInNavigation());
    }

    private void enableCruiseDynamicLevel() {
        MiniMapGuideDynamicLevelHelper miniMapGuideDynamicLevelHelper = this.mMiniMapGuideDynamicLevelHelper;
        if (miniMapGuideDynamicLevelHelper != null) {
            miniMapGuideDynamicLevelHelper.disableDynamicLevel();
        }
        MiniMapCruiseDynamicLevelHelper miniMapCruiseDynamicLevelHelper = this.mMiniMapCruiseDynamicLevelHelper;
        if (miniMapCruiseDynamicLevelHelper != null) {
            miniMapCruiseDynamicLevelHelper.enableDynamicLevel();
        }
    }

    private void enableGuideDynamicLevel() {
        MiniMapCruiseDynamicLevelHelper miniMapCruiseDynamicLevelHelper = this.mMiniMapCruiseDynamicLevelHelper;
        if (miniMapCruiseDynamicLevelHelper != null) {
            miniMapCruiseDynamicLevelHelper.disableDynamicLevel();
        }
        MiniMapGuideDynamicLevelHelper miniMapGuideDynamicLevelHelper = this.mMiniMapGuideDynamicLevelHelper;
        if (miniMapGuideDynamicLevelHelper != null) {
            miniMapGuideDynamicLevelHelper.enableDynamicLevel();
        }
    }

    private void disableDynamicLevel() {
        MiniMapCruiseDynamicLevelHelper miniMapCruiseDynamicLevelHelper = this.mMiniMapCruiseDynamicLevelHelper;
        if (miniMapCruiseDynamicLevelHelper != null) {
            miniMapCruiseDynamicLevelHelper.disableDynamicLevel();
        }
        MiniMapGuideDynamicLevelHelper miniMapGuideDynamicLevelHelper = this.mMiniMapGuideDynamicLevelHelper;
        if (miniMapGuideDynamicLevelHelper != null) {
            miniMapGuideDynamicLevelHelper.disableDynamicLevel();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper.IXPMapSurfaceListener
    public void onSurfaceCreated(int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapServiceHelper.6
            @Override // java.lang.Runnable
            public void run() {
                if (MiniMapServiceHelper.this.mIsInitMapView) {
                    L.Tag tag = MiniMapServiceHelper.TAG;
                    L.i(tag, "onSurfaceChanged:" + MiniMapServiceHelper.this.mMiniMapWidth + ", " + MiniMapServiceHelper.this.mMiniMapHeight);
                    MiniMapServiceHelper.this.mMapViewWrapper.resetMapviewPort(MiniMapServiceHelper.this.mMiniMapWidth, MiniMapServiceHelper.this.mMiniMapHeight);
                    MiniMapServiceHelper.this.mMapViewWrapper.restoreCarPosition();
                    MiniMapServiceHelper.this.mMapViewWrapper.goBackCenter();
                    return;
                }
                MiniMapServiceHelper.this.initMiniMap();
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper.IXPMapSurfaceListener
    public void onSurfaceChanged(int i, int i2, int i3) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapServiceHelper.7
            @Override // java.lang.Runnable
            public void run() {
                if (MiniMapServiceHelper.this.mIsInitMapView) {
                    L.Tag tag = MiniMapServiceHelper.TAG;
                    L.i(tag, "onSurfaceChanged:" + MiniMapServiceHelper.this.mMiniMapWidth + ", " + MiniMapServiceHelper.this.mMiniMapHeight);
                    MiniMapServiceHelper.this.mMapViewWrapper.resetMapviewPort(MiniMapServiceHelper.this.mMiniMapWidth, MiniMapServiceHelper.this.mMiniMapHeight);
                    MiniMapServiceHelper.this.mMapViewWrapper.restoreCarPosition();
                    return;
                }
                MiniMapServiceHelper.this.initMiniMap();
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener
    public void onDriveModeChanged(final int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapServiceHelper.8
            @Override // java.lang.Runnable
            public void run() {
                LaneServiceManager.getInstance().openNaviLineRender(3, !SRDataUtil.isNgpDriveMode(i) && MiniMapServiceHelper.this.isMiniMapLaneMode() && SRNaviManager.getInstance().isLaneEnabled());
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener
    public void onXpuSRDisplayStChanged(int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapServiceHelper.9
            @Override // java.lang.Runnable
            public void run() {
                if (SRNaviManager.getInstance().canShowMiniMapSRScene()) {
                    MiniMapServiceHelper.this.enableMiniMapLaneMode(true);
                } else {
                    MiniMapServiceHelper.this.enableMiniMapLaneMode(false);
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener
    public void onLaneViewDisplayChanged(int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapServiceHelper.10
            @Override // java.lang.Runnable
            public void run() {
                if (SRNaviManager.getInstance().canShowMiniMapSRScene()) {
                    MiniMapServiceHelper.this.enableMiniMapLaneMode(true);
                } else {
                    MiniMapServiceHelper.this.enableMiniMapLaneMode(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableMiniMapLaneMode(boolean z) {
        updateMapViewState(z, false);
    }

    private void nofityInstrumentStatus(boolean z) {
        if (this.firstNotifyInstrument) {
            L.i(TAG, "nofityInstrumentStatus");
            this.firstNotifyInstrument = false;
            TBTManager.getInstance().updateSRInfo(z);
        } else if (isMiniMapLaneMode() == z) {
            if (L.ENABLE) {
                L.d(TAG, "nofityInstrumentStatus ignore");
            }
        } else {
            TBTManager.getInstance().updateSRInfo(z);
        }
    }

    /* loaded from: classes3.dex */
    class SendDataRunnable implements Runnable {
        private final PoolBytes mPoolBytes;
        private int mType;

        SendDataRunnable(PoolBytes poolBytes, int i) {
            this.mPoolBytes = poolBytes;
            this.mType = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!MiniMapServiceHelper.this.mIsMapSizeChanged) {
                int i = this.mType;
                if (i != 1) {
                    if (i == 2) {
                        if (MiniMapServiceHelper.this.mSendData == null) {
                            MiniMapServiceHelper miniMapServiceHelper = MiniMapServiceHelper.this;
                            miniMapServiceHelper.mSendData = new byte[miniMapServiceHelper.mMiniMapWidth * MiniMapServiceHelper.this.mMiniMapHeight * 2];
                        }
                        this.mPoolBytes.raw2RGB565(MiniMapServiceHelper.this.mSendData, MiniMapServiceHelper.this.mMiniMapWidth, MiniMapServiceHelper.this.mMiniMapHeight);
                        MiniMapServiceHelper.this.mBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(MiniMapServiceHelper.this.mSendData));
                        if (MiniMapServiceHelper.this.mServiceWeakReference.get() != null && ((MiniMapService) MiniMapServiceHelper.this.mServiceWeakReference.get()).mSurface != null) {
                            ((MiniMapService) MiniMapServiceHelper.this.mServiceWeakReference.get()).refreshTestWin(MiniMapServiceHelper.this.mBitmap, MiniMapServiceHelper.this.mMiniMapWidth, MiniMapServiceHelper.this.mMiniMapHeight);
                        }
                        CarServiceManager.getInstance().setIcmNavigationBmp(BMPDataUtil.bitmap2JpgData(MiniMapServiceHelper.this.mBitmap));
                    } else if (i != 3) {
                        if (i == 4) {
                            if (MiniMapServiceHelper.this.mSendData == null) {
                                MiniMapServiceHelper miniMapServiceHelper2 = MiniMapServiceHelper.this;
                                miniMapServiceHelper2.mSendData = new byte[miniMapServiceHelper2.mMiniMapWidth * MiniMapServiceHelper.this.mMiniMapHeight * 3];
                            }
                            this.mPoolBytes.raw2RGB888(MiniMapServiceHelper.this.mSendData, MiniMapServiceHelper.this.mMiniMapWidth, MiniMapServiceHelper.this.mMiniMapHeight);
                            CarServiceManager.getInstance().setIcmNavigationBmp(MiniMapServiceHelper.this.mSendData);
                        }
                    }
                }
                if (MiniMapServiceHelper.this.mSendData == null) {
                    MiniMapServiceHelper miniMapServiceHelper3 = MiniMapServiceHelper.this;
                    miniMapServiceHelper3.mSendData = new byte[miniMapServiceHelper3.mMiniMapWidth * MiniMapServiceHelper.this.mMiniMapHeight * 2];
                }
                this.mPoolBytes.raw2RGB565(MiniMapServiceHelper.this.mSendData, MiniMapServiceHelper.this.mMiniMapWidth, MiniMapServiceHelper.this.mMiniMapHeight);
                CarServiceManager.getInstance().setIcmNavigationBmp(MiniMapServiceHelper.this.mSendData);
                if (MiniMapServiceHelper.this.mServiceWeakReference.get() != null && ((MiniMapService) MiniMapServiceHelper.this.mServiceWeakReference.get()).mSurface != null) {
                    ByteBuffer wrap = ByteBuffer.wrap(MiniMapServiceHelper.this.mSendData);
                    Bitmap createBitmap = Bitmap.createBitmap(MiniMapServiceHelper.this.mMiniMapWidth, MiniMapServiceHelper.this.mMiniMapHeight, Bitmap.Config.RGB_565);
                    createBitmap.copyPixelsFromBuffer(wrap);
                    ((MiniMapService) MiniMapServiceHelper.this.mServiceWeakReference.get()).refreshTestWin(createBitmap, MiniMapServiceHelper.this.mMiniMapWidth, MiniMapServiceHelper.this.mMiniMapHeight);
                    if (createBitmap != null && !createBitmap.isRecycled()) {
                        createBitmap.recycle();
                    }
                }
            }
            this.mPoolBytes.recycle();
        }
    }
}
