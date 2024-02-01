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
import com.autonavi.gbl.util.errorcode.common.System;
import com.xiaopeng.montecarlo.navcore.xptbt.XUIServiceManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.theme.IThemeSwitchListener;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import java.io.File;
/* loaded from: classes3.dex */
public class MiniMapService extends Service {
    private static final String ACTION_CAR_ICON_CHANGE = "com.xiaopeng.montecarlo.minimap.ACTION_CAR_ICON_CHANGE";
    private static final String ACTION_DUMP_FRAME_IMAGE = "com.xiaopeng.montecarlo.minimap.ACTION_DUMP_FRAME_IMAGE";
    private static final String ACTION_GO_BACK_CENTER = "com.xiaopeng.montecarlo.minimap.ACTION_GO_BACK_CENTER";
    private static final String ACTION_HIDE_LOCAL_VIEW = "com.xiaopeng.montecarlo.minimap.ACTION_HIDE_LOCAL_VIEW";
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
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            MiniMapService.this.mSurface.release();
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
        public void onSwitchTheme(String str, boolean z) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MiniMapService.this.mMiniMapServiceHelper != null) {
                        MiniMapService.this.mMiniMapServiceHelper.updateDayNightMode(ThemeWatcherUtil.getMapModeByCurrentTheme());
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
            layoutParams.type = 2003;
            layoutParams.format = 1;
            layoutParams.flags = System.ErrorCodeDeleteFile;
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
            final int intExtra = intent.getIntExtra("int_level", 19);
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.6
                @Override // java.lang.Runnable
                public void run() {
                    MiniMapService.this.mMiniMapServiceHelper.setMapLevel(intExtra);
                }
            });
        } else if (ACTION_SET_MAP_MODE.equals(action)) {
            final int intExtra2 = intent.getIntExtra("map_mode", 2);
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.7
                @Override // java.lang.Runnable
                public void run() {
                    MiniMapService.this.mMiniMapServiceHelper.setMapMode(intExtra2, true, false);
                }
            });
        } else if (ACTION_SHOW_LOCAL_VIEW.equals(action)) {
            addTestWin();
        } else if (ACTION_HIDE_LOCAL_VIEW.equals(action)) {
            removeTestWin();
        } else if (ACTION_DUMP_FRAME_IMAGE.equals(action)) {
            final int intExtra3 = intent.getIntExtra("format", -1);
            if (intExtra3 > 0) {
                WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.8
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniMapService.this.mDumpImgFormat = intExtra3;
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
            final int intExtra4 = intent.getIntExtra("minimap_width", 0);
            final int intExtra5 = intent.getIntExtra("minimap_height", 0);
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.10
                @Override // java.lang.Runnable
                public void run() {
                    MiniMapService.this.mMiniMapServiceHelper.updateMiniMapSize(intExtra4, intExtra5);
                }
            });
        } else if (ACTION_MINIMAP_DISPLAY_CHANGE.equals(action)) {
            this.mMiniMapServiceHelper.updateMiniMapDisplayState(intent.getBooleanExtra("minimap_display", false));
        } else if (ACTION_MINIMAP_DISPLAY_SIZE_CHANGE.equals(action)) {
            final int intExtra6 = intent.getIntExtra("minimap_display_width", 0);
            final int intExtra7 = intent.getIntExtra("minimap_display_height", 0);
            if (intExtra6 != 0 && intExtra7 != 0) {
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapService.11
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniMapService.this.mMiniMapServiceHelper.setMapDensityDpiByHW(intExtra6, intExtra7);
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
            int intExtra8 = intent.getIntExtra("ngp_type", 1);
            int intExtra9 = intent.getIntExtra("ngp_value", 0);
            if (1 == intExtra8) {
                XUIServiceManager.getInstance().sendXPilotTTS(intExtra9);
            } else if (2 == intExtra8) {
                XUIServiceManager.getInstance().sendXPilotStrongAlert(intExtra9);
            } else if (3 == intExtra8) {
                XUIServiceManager.getInstance().sendNavTTS(intExtra9);
            }
        } else if (ACTION_SEND_MAP_IMAGE_TYPE.equals(action)) {
            this.mMiniMapServiceHelper.updateMapImageType(intent.getIntExtra("send_map_image_type", 2));
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
