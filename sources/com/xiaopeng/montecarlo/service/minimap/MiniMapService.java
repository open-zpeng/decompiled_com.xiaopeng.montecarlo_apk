package com.xiaopeng.montecarlo.service.minimap;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.autonavi.gbl.map.model.MapModelConstants;
import com.xiaopeng.montecarlo.navcore.xptbt.XUIServiceManager;
import com.xiaopeng.montecarlo.root.theme.ThemeType;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.theme.IThemeSwitchListener;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import java.io.File;
/* loaded from: classes3.dex */
public class MiniMapService extends Service {
    private static final String ACTION_CAR_ICON_CHANGE = "com.xiaopeng.montecarlo.minimap.ACTION_CAR_ICON_CHANGE";
    private static final String ACTION_CHANGE_CAMERA_DEGREE = "com.xiaopeng.montecarlo.minimap.ACTION_CHANGE_CAMERA_DEGREE";
    private static final String ACTION_CHANGE_CAR_POSITION_RATIO = "com.xiaopeng.montecarlo.minimap.ACTION_CHANGE_CAR_POSITION_RATIO";
    private static final String ACTION_CHANGE_SR_SD = "com.xiaopeng.montecarlo.minimap.ACTION_CHANGE_SR_SD";
    private static final String ACTION_DUMP_FRAME_IMAGE = "com.xiaopeng.montecarlo.minimap.ACTION_DUMP_FRAME_IMAGE";
    private static final String ACTION_GO_BACK_CENTER = "com.xiaopeng.montecarlo.minimap.ACTION_GO_BACK_CENTER";
    private static final String ACTION_HIDE_LOCAL_VIEW = "com.xiaopeng.montecarlo.minimap.ACTION_HIDE_LOCAL_VIEW";
    private static final String ACTION_MAP_SURFACE_CHANGED = "com.xiaopeng.montecarlo.minimap.ACTION_MAP_SURFACE_CHANGED";
    private static final String ACTION_MAP_SURFACE_CREATE = "com.xiaopeng.montecarlo.minimap.ACTION_MAP_SURFACE_CREATE";
    private static final String ACTION_MAP_SURFACE_DESTROY = "com.xiaopeng.montecarlo.minimap.ACTION_MAP_SURFACE_DESTROY";
    private static final String ACTION_MINIMAP_DISPLAY_CHANGE = "com.xiaopeng.montecarlo.minimap.ACTION_DISPLAY_CHANGE";
    private static final String ACTION_MINIMAP_DISPLAY_SIZE_CHANGE = "com.xiaopeng.montecarlo.minimap.ACTION_DISPLAY_SIZE_CHANGE";
    private static final String ACTION_MINIMAP_SIZE_CHANGE = "com.xiaopeng.montecarlo.minimap.ACTION_SIZE_CHANGE";
    private static final String ACTION_NGP_TO_XUISERVICE = "com.xiaopeng.montecarlo.ngp.ACTION_SIGNAL_TO_XUI";
    private static final String ACTION_RADAR_STATUS_CHANGE = "com.xiaopeng.montecarlo.minimap.ACTION_RADAR_STATUS_CHANGE";
    private static final String ACTION_REALTIME_TRAFFIC_CHANGE = "com.xiaopeng.montecarlo.minimap.ACTION_REALTIME_TRAFFIC_CHANGE";
    private static final String ACTION_RESET_MINIMAP = "com.xiaopeng.montecarlo.minimap.RESET";
    private static final String ACTION_SEND_MAP_IMAGE_TYPE = "com.xiaopeng.montecarlo.minimap.ACTION_SEND_MAP_IMAGE_TYPE";
    private static final String ACTION_SET_MAP_LEVEL = "com.xiaopeng.montecarlo.minimap.ACTION_SET_MAP_LEVEL";
    private static final String ACTION_SET_MAP_MODE = "com.xiaopeng.montecarlo.minimap.ACTION_SET_MAP_MODE";
    private static final String ACTION_SHOW_LOCAL_VIEW = "com.xiaopeng.montecarlo.minimap.ACTION_SHOW_LOCAL_VIEW";
    private static final String ACTION_STOP_MAP = "com.xiaopeng.montecarlo.minimap.ACTION_STOP_MAP";
    private static final L.Tag TAG = new L.Tag("MiniMapService");
    private MiniMapServiceHelper mMiniMapServiceHelper;
    private ViewGroup mRootView;
    public Surface mSurface;
    private TextureView mTextureView;
    private WindowManager mWindowManager;
    private final WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
    File mDirFile = new File("/sdcard/mapimage");
    File mBmpDirFile = new File(this.mDirFile, "bitmap");
    File mJpgDirFile = new File(this.mDirFile, "jpg");
    private Paint mPaint = new Paint();
    private int mDumpImgFormat = -1;
    private TextureView.SurfaceTextureListener mSurfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            MiniMapService.this.mSurface = new Surface(surfaceTexture);
            MiniMapService.this.mMiniMapServiceHelper.surfaceCreate(MiniMapService.this.mSurface, i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            MiniMapService.this.mSurface.release();
            MiniMapService.this.mMiniMapServiceHelper.surfaceDestroy();
            MiniMapService.this.mSurface = null;
            return false;
        }
    };
    private long mImageCount = 0;
    private Runnable mInitDirRun = new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.2
        @Override // java.lang.Runnable
        public void run() {
            if (!MiniMapService.this.mDirFile.exists()) {
                MiniMapService.this.mDirFile.mkdir();
            }
            if (!MiniMapService.this.mBmpDirFile.exists()) {
                MiniMapService.this.mBmpDirFile.mkdir();
            } else {
                File[] listFiles = MiniMapService.this.mBmpDirFile.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file : listFiles) {
                        file.delete();
                    }
                }
            }
            if (!MiniMapService.this.mJpgDirFile.exists()) {
                MiniMapService.this.mJpgDirFile.mkdir();
                return;
            }
            File[] listFiles2 = MiniMapService.this.mJpgDirFile.listFiles();
            if (listFiles2 == null || listFiles2.length <= 0) {
                return;
            }
            for (File file2 : listFiles2) {
                file2.delete();
            }
        }
    };
    private IThemeSwitchListener mThemeSwitchListener = new IThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.3
        @Override // com.xiaopeng.montecarlo.theme.IThemeSwitchListener
        public void onSwitchTheme(String str, final ThemeType themeType) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MiniMapService.this.mMiniMapServiceHelper != null) {
                        MiniMapService.this.mMiniMapServiceHelper.updateDayNightMode(ThemeWatcherUtil.getMapModeByCurrentTheme(), themeType);
                    }
                }
            });
        }
    };

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        L.i(TAG, "======onCreate");
        ThemeWatcherUtil.addThemeListener(this.mThemeSwitchListener);
        this.mMiniMapServiceHelper = new MiniMapServiceHelper(this);
        this.mMiniMapServiceHelper.init();
        this.mWindowManager = (WindowManager) getSystemService("window");
    }

    public void refreshTestWin(Bitmap bitmap, int i, int i2) {
        Surface surface = this.mSurface;
        if (surface != null) {
            Canvas lockCanvas = surface.lockCanvas(new Rect(0, 0, i, i2));
            lockCanvas.drawBitmap(bitmap, 0.0f, 0.0f, this.mPaint);
            this.mSurface.unlockCanvasAndPost(lockCanvas);
        }
    }

    private void addTestWin() {
        if (this.mRootView == null) {
            WindowManager.LayoutParams layoutParams = this.mParams;
            layoutParams.type = MapModelConstants.MAP_PARAMETERNAME_TRAFFIC_REFRESH;
            layoutParams.format = 1;
            layoutParams.flags = 16777224;
            layoutParams.gravity = 51;
            layoutParams.x = 0;
            layoutParams.y = 0;
            layoutParams.width = this.mMiniMapServiceHelper.mMiniMapWidth;
            this.mParams.height = this.mMiniMapServiceHelper.mMiniMapHeight;
            this.mRootView = new FrameLayout(this);
            this.mTextureView = new TextureView(this);
            this.mTextureView.setSurfaceTextureListener(this.mSurfaceTextureListener);
            this.mRootView.addView(this.mTextureView, this.mMiniMapServiceHelper.mMiniMapWidth, this.mMiniMapServiceHelper.mMiniMapHeight);
            this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 2) {
                        MiniMapService.this.mParams.x = ((int) motionEvent.getRawX()) - (view.getWidth() / 2);
                        MiniMapService.this.mParams.y = ((int) motionEvent.getRawY()) - (view.getHeight() / 2);
                        MiniMapService.this.mWindowManager.updateViewLayout(view, MiniMapService.this.mParams);
                        return true;
                    }
                    return true;
                }
            });
            this.mWindowManager.addView(this.mRootView, this.mParams);
        }
    }

    private void removeTestWin() {
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            this.mWindowManager.removeView(viewGroup);
            this.mRootView = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String action = intent.getAction();
        L.Tag tag = TAG;
        L.i(tag, "======onStartCommand==== action:" + action);
        if (ACTION_STOP_MAP.equals(action)) {
            stopSelf();
        } else if (ACTION_GO_BACK_CENTER.equals(action)) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.5
                @Override // java.lang.Runnable
                public void run() {
                    MiniMapService.this.mMiniMapServiceHelper.goBackCenter();
                }
            });
        } else if (ACTION_SET_MAP_LEVEL.equals(action)) {
            final float floatExtra = intent.getFloatExtra("float_level", 19.0f);
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.6
                @Override // java.lang.Runnable
                public void run() {
                    MiniMapService.this.mMiniMapServiceHelper.setMapLevel(floatExtra);
                }
            });
        } else if (ACTION_SET_MAP_MODE.equals(action)) {
            final int intExtra = intent.getIntExtra("map_mode", 2);
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.7
                @Override // java.lang.Runnable
                public void run() {
                    MiniMapService.this.mMiniMapServiceHelper.setMapMode(intExtra, true, false);
                }
            });
        } else if (ACTION_SHOW_LOCAL_VIEW.equals(action)) {
            addTestWin();
        } else if (ACTION_HIDE_LOCAL_VIEW.equals(action)) {
            removeTestWin();
        } else if (ACTION_DUMP_FRAME_IMAGE.equals(action)) {
            final int intExtra2 = intent.getIntExtra("format", -1);
            if (intExtra2 > 0) {
                WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.8
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniMapService.this.mDumpImgFormat = intExtra2;
                        MiniMapService.this.mImageCount = 0L;
                        MiniMapService.this.mInitDirRun.run();
                    }
                });
            } else {
                WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.9
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniMapService.this.mDumpImgFormat = -1;
                        MiniMapService.this.mImageCount = 0L;
                    }
                });
            }
        } else if (ACTION_MINIMAP_SIZE_CHANGE.equals(action)) {
            final int intExtra3 = intent.getIntExtra("minimap_width", 0);
            final int intExtra4 = intent.getIntExtra("minimap_height", 0);
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.10
                @Override // java.lang.Runnable
                public void run() {
                    MiniMapService.this.mMiniMapServiceHelper.updateMiniMapSize(intExtra3, intExtra4);
                }
            });
        } else if (ACTION_MINIMAP_DISPLAY_CHANGE.equals(action)) {
            this.mMiniMapServiceHelper.updateMiniMapDisplayState(intent.getBooleanExtra("minimap_display", false));
        } else if (ACTION_MINIMAP_DISPLAY_SIZE_CHANGE.equals(action)) {
            final int intExtra5 = intent.getIntExtra("minimap_display_width", 0);
            final int intExtra6 = intent.getIntExtra("minimap_display_height", 0);
            if (intExtra5 != 0 && intExtra6 != 0) {
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.11
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniMapService.this.mMiniMapServiceHelper.setMapDensityDpiByHW(intExtra5, intExtra6);
                    }
                });
            }
        } else if (ACTION_RADAR_STATUS_CHANGE.equals(action)) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.12
                @Override // java.lang.Runnable
                public void run() {
                    MiniMapService.this.mMiniMapServiceHelper.refreshMultiAlternativeLabel();
                }
            });
        } else if (ACTION_CAR_ICON_CHANGE.equals(action)) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.13
                @Override // java.lang.Runnable
                public void run() {
                    MiniMapService.this.mMiniMapServiceHelper.updateCarIcon();
                }
            });
        } else if (ACTION_REALTIME_TRAFFIC_CHANGE.equals(action)) {
            final boolean booleanExtra = intent.getBooleanExtra("realtime_traffic_state", false);
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.14
                @Override // java.lang.Runnable
                public void run() {
                    MiniMapService.this.mMiniMapServiceHelper.updateRealTimeTrafficState(booleanExtra);
                }
            });
        } else if (ACTION_RESET_MINIMAP.equals(action)) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.15
                @Override // java.lang.Runnable
                public void run() {
                    MiniMapService.this.mMiniMapServiceHelper.forceResetMiniMap();
                }
            });
        } else if (ACTION_NGP_TO_XUISERVICE.equals(action)) {
            int intExtra7 = intent.getIntExtra("ngp_type", 1);
            int intExtra8 = intent.getIntExtra("ngp_value", 0);
            if (1 == intExtra7) {
                XUIServiceManager.getInstance().sendXPilotTTS(intExtra8);
            } else if (2 == intExtra7) {
                XUIServiceManager.getInstance().sendXPilotStrongAlert(intExtra8);
            } else if (3 == intExtra7) {
                XUIServiceManager.getInstance().sendNavTTS(intExtra8);
            }
        } else if (ACTION_SEND_MAP_IMAGE_TYPE.equals(action)) {
            this.mMiniMapServiceHelper.updateMapImageType(intent.getIntExtra("send_map_image_type", -1));
        } else if (!ACTION_CHANGE_SR_SD.equals(action)) {
            if (ACTION_MAP_SURFACE_CREATE.equals(action)) {
                int intExtra9 = intent.getIntExtra("map_width", 0);
                int intExtra10 = intent.getIntExtra("map_height", 0);
                Surface surface = (Surface) intent.getParcelableExtra("map_surface");
                L.Tag tag2 = TAG;
                L.i(tag2, "width:" + intExtra9 + ", height:" + intExtra10 + ", surface:" + surface);
                this.mMiniMapServiceHelper.surfaceCreate(surface, intExtra9, intExtra10);
            } else if (ACTION_MAP_SURFACE_DESTROY.equals(action)) {
                this.mMiniMapServiceHelper.surfaceDestroy();
            } else if (ACTION_MAP_SURFACE_CHANGED.equals(action)) {
                final int intExtra11 = intent.getIntExtra("map_width", 0);
                final int intExtra12 = intent.getIntExtra("map_height", 0);
                Surface surface2 = (Surface) intent.getParcelableExtra("map_surface");
                L.Tag tag3 = TAG;
                L.i(tag3, "width:" + intExtra11 + ", height:" + intExtra12 + ", surface:" + surface2);
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.16
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniMapService.this.mMiniMapServiceHelper.updateMiniMapSize(intExtra11, intExtra12);
                    }
                });
                this.mMiniMapServiceHelper.surfaceSizeChanged(surface2, intExtra11, intExtra12);
            } else if (ACTION_CHANGE_CAMERA_DEGREE.equals(action)) {
                this.mMiniMapServiceHelper.setCameraDegree(intent.getFloatExtra("map_degree", 50.0f));
            } else if (ACTION_CHANGE_CAR_POSITION_RATIO.equals(action)) {
                float floatExtra2 = intent.getFloatExtra("map_ratio", 0.7f);
                this.mMiniMapServiceHelper.setCarPositionRatio(floatExtra2, floatExtra2);
            }
        }
        return 2;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        L.i(TAG, "======onDestroy");
        ThemeWatcherUtil.removeThemeListener(this.mThemeSwitchListener);
        removeTestWin();
        this.mMiniMapServiceHelper.release();
    }
}
