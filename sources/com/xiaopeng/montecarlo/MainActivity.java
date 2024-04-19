package com.xiaopeng.montecarlo;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.xiaopeng.lib.bughunter.StartPerfUtils;
import com.xiaopeng.montecarlo.action.schedule.IntentTask;
import com.xiaopeng.montecarlo.action.schedule.IntentTaskScheduler;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.MapFragment;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.navcore.location.DRServiceManager;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.tts.TTSProxy;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.theme.ThemeType;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.TraceUtils;
import com.xiaopeng.montecarlo.scenes.cruisescene.card.NotificationHelper;
import com.xiaopeng.montecarlo.scenes.debugscene.ScreenShotHelper;
import com.xiaopeng.montecarlo.theme.IThemeSwitchListener;
import com.xiaopeng.montecarlo.util.ActivityLifecycleHelper;
import com.xiaopeng.montecarlo.util.PermissionHelper;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.views.dialog.LocationDebugDialog;
/* loaded from: classes.dex */
public class MainActivity extends AppCompatActivity {
    public static final int KEYCODE_CAR_BACK = 1016;
    private static final String MAIN_FRAGMENT_TAG = "main_fragment";
    private static final L.Tag TAG = new L.Tag("MainActivity");
    private WindowManager.LayoutParams mLayoutParams;
    private MapFragment mMapFragment;
    private View mRootContent;
    protected ThemeType mCurrentTheme = ThemeType.DEFAULT_THEME_TYPE;
    private boolean mIsFirstFrame = true;
    private boolean mIsSaveInstanceState = false;
    private IntentTaskScheduler mIntentTaskScheduler = new IntentTaskScheduler();
    private View mLocDebugView = null;
    private final DRServiceManager.ILocDebugSwitchListener mILocDebugSwitchListener = new DRServiceManager.ILocDebugSwitchListener() { // from class: com.xiaopeng.montecarlo.-$$Lambda$MainActivity$vHI6Eh5dEsq-M9M_H7ZHqAskHGQ
        @Override // com.xiaopeng.montecarlo.navcore.location.DRServiceManager.ILocDebugSwitchListener
        public final void locDebugSwitch(boolean z) {
            MainActivity.this.lambda$new$0$MainActivity(z);
        }
    };
    private final Choreographer.FrameCallback mFrameCallback = new Choreographer.FrameCallback() { // from class: com.xiaopeng.montecarlo.MainActivity.1
        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            if (MainActivity.this.mIsFirstFrame) {
                Choreographer.getInstance().postFrameCallback(MainActivity.this.mFrameCallback);
                MainActivity.this.mIsFirstFrame = false;
            }
        }
    };
    private final IThemeSwitchListener mThemeSwitchListener = new IThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.-$$Lambda$MainActivity$2ZwU4Xfl506iquFvGyOonjKsip8
        @Override // com.xiaopeng.montecarlo.theme.IThemeSwitchListener
        public final void onSwitchTheme(String str, ThemeType themeType) {
            MainActivity.this.lambda$new$1$MainActivity(str, themeType);
        }
    };

    public /* synthetic */ void lambda$new$0$MainActivity(boolean z) {
        if (z) {
            showLocationDebugDialog();
        } else {
            hideLocDebugDialog();
        }
    }

    public /* synthetic */ void lambda$new$1$MainActivity(String str, ThemeType themeType) {
        getWindow().setAttributes(getWindow().getAttributes());
        L.Tag tag = TAG;
        L.i(tag, L.formatDayNightSwitchLog("onSwitchTheme mCurrentTheme:" + this.mCurrentTheme + ",new themeType:" + themeType));
        if (this.mCurrentTheme == themeType) {
            L.i(TAG, L.formatDayNightSwitchLog("onSwitchTheme theme is same as current,no need to change"));
            return;
        }
        this.mCurrentTheme = themeType;
        TBTManager.getInstance().setCurrentThemeType(this.mCurrentTheme);
        sendBroadcastToThemeSwitch(this.mCurrentTheme.ordinal());
        L.i(TAG, L.formatDayNightSwitchLog("broadcast day night switch"));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        TraceUtils.alwaysTraceBegin("MainActivity onCreate");
        try {
            StartPerfUtils.onCreateBegin();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!RootUtil.isTabletApp()) {
            Choreographer.getInstance().postFrameCallback(this.mFrameCallback);
        } else {
            RootUtil.setStatusBarTransparent(getWindow());
        }
        if (bundle != null) {
            bundle.putParcelable("android:fragments", null);
            bundle.putParcelable("android:support:fragments", null);
        }
        getSavedStateRegistry().unregisterSavedStateProvider("android:support:fragments");
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_main);
        L.Tag tag = TAG;
        L.i(tag, "MainActivity onCreate savedInstanceState=" + bundle);
        getWindow().setFormat(-3);
        boolean z = false;
        if (bundle != null && InitializerManager.getInstance().isBLInitialized()) {
            z = true;
        } else if (!RootUtil.isTabletApp()) {
            setUpInitializerManager();
        } else {
            checkPermission();
        }
        this.mRootContent = findViewById(16908290);
        View view = this.mRootContent;
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).removeAllViews();
        }
        initMapFragmentForCreate(bundle);
        if (z) {
            initMapInstance();
        }
        registerDynamicThemeSwitchListener();
        try {
            StartPerfUtils.onCreateEnd();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        TraceUtils.alwaysTraceEnd();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        TraceUtils.alwaysTraceBegin("MainActivity onNewIntent");
        super.onNewIntent(intent);
        L.i(TAG, "=============>onNewIntent");
        createIntentTask(intent);
        TraceUtils.alwaysTraceEnd();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        L.i(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(bundle);
        this.mIsSaveInstanceState = true;
        MapFragment mapFragment = this.mMapFragment;
        if (mapFragment != null) {
            mapFragment.saveSceneManagerState(bundle);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        L.i(TAG, "=============>onStart");
        try {
            StartPerfUtils.onStartBegin();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onStart();
        DataLogUtil.onStart();
        TTSProxy.getInstance().setTtsEnable(true);
        DRServiceManager.getInstance().setLocDebugSwitchListener(this.mILocDebugSwitchListener);
        try {
            StartPerfUtils.onStartEnd();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        TraceUtils.alwaysTraceBegin("MainActivity onRestart");
        L.i(TAG, "=============>onRestart");
        try {
            StartPerfUtils.onReStartBegin();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onRestart();
        clearSceneManagerStateIfNeed();
        try {
            StartPerfUtils.onReStartEnd();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        TraceUtils.alwaysTraceEnd();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        TraceUtils.alwaysTraceBegin("MainActivity onResume");
        try {
            StartPerfUtils.onResumeBegin();
        } catch (Exception e) {
            e.printStackTrace();
        }
        L.i(TAG, "=============>onResume");
        super.onResume();
        clearSceneManagerStateIfNeed();
        ThemeWatcherUtil.checkCachedThemeIsSameWithSystemTheme();
        initDayNightMode();
        InitializerManager.getInstance().onBootPhase(1001);
        try {
            StartPerfUtils.onResumeEnd();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        TraceUtils.alwaysTraceEnd();
        showLocationDebugDialog();
    }

    protected void onPause(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "onPause visible:" + z);
        ActivityLifecycleHelper.getInstance().handleMapCovered(z);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        hideLocDebugDialog();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        L.i(TAG, "onStop");
        super.onStop();
        DRServiceManager.getInstance().setLocDebugSwitchListener(null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        L.i(TAG, "onDestroy");
        this.mIntentTaskScheduler.destroy();
        if (VoiceFullScenesUtil.isSceneVuiSupport()) {
            VoiceFullScenesUtil.clearJobs();
        }
        unregisterDynamicThemeSwitchListener();
        System.gc();
        Runtime.getRuntime().gc();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        StateManager.getInstance().resetTimer();
        MapFragment mapFragment = this.mMapFragment;
        if (mapFragment != null && !mapFragment.isInPreload() && this.mMapFragment.isAdded() && this.mMapFragment.getMainContext().getCurrentScene() != null) {
            this.mMapFragment.getMainContext().getCurrentScene().dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onKeyDown keyCode:" + i + ",event:" + keyEvent);
        }
        boolean z = i == 4 || i == 1016;
        if (VoiceFusionUtil.getInstance().isVoiceFusionSupported() && VoiceFusionUtil.getInstance().isInVoiceSearchFusionMode() && z) {
            L.w(TAG, "onKeyDown no need to response");
            VoiceFusionUtil.getInstance().sendGUIEventWhenBackPressed();
            return true;
        } else if (i == 4) {
            MapFragment mapFragment = this.mMapFragment;
            if (mapFragment != null && !mapFragment.isInPreload() && !this.mMapFragment.backScene()) {
                ContextUtils.gotoHome();
            }
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    protected void initMapFragmentForCreate(Bundle bundle) {
        initMapFragment();
        if (bundle != null && InitializerManager.getInstance().isBLInitialized()) {
            this.mMapFragment.restoreSceneManagerState(bundle);
        }
        if (this.mMapFragment.isAdded()) {
            return;
        }
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        View view = this.mRootContent;
        if (view instanceof FrameLayout) {
            this.mMapFragment.preloadView(layoutInflater, (FrameLayout) view);
        }
    }

    private void setUpInitializerManager() {
        InitializerManager.getInstance().waitExternalStorage(new IWaitExternalStorageCallback() { // from class: com.xiaopeng.montecarlo.-$$Lambda$MainActivity$gTUgAbrqlbrfQm1uGolc1Ksx0pA
            @Override // com.xiaopeng.montecarlo.IWaitExternalStorageCallback
            public final void onResult() {
                MainActivity.this.checkBLInitialized();
            }
        });
    }

    private void clearSceneManagerStateIfNeed() {
        if (this.mIsSaveInstanceState) {
            MapFragment mapFragment = this.mMapFragment;
            if (mapFragment != null && !mapFragment.isInPreload() && this.mMapFragment.isAdded() && this.mMapFragment.getMainContext().getCurrentScene() != null) {
                this.mMapFragment.clearSceneManagerState();
            }
            this.mIsSaveInstanceState = false;
        }
    }

    private void createIntentTask(Intent intent) {
        if (intent == null) {
            L.i(TAG, "createIntentTask intent is null");
            return;
        }
        this.mIntentTaskScheduler.executeTaskProduct(new IntentTask(intent));
    }

    private void registerDynamicThemeSwitchListener() {
        L.i(TAG, L.formatDayNightSwitchLog("registerDynamicThemeSwitchListener"));
        ThemeWatcherUtil.addThemeListener(this.mThemeSwitchListener);
    }

    private void unregisterDynamicThemeSwitchListener() {
        L.i(TAG, L.formatDayNightSwitchLog("unregisterDynamicThemeSwitchListener"));
        ThemeWatcherUtil.removeThemeListener(this.mThemeSwitchListener);
    }

    private void sendBroadcastToThemeSwitch(int i) {
        Intent intent = new Intent(IntentActions.ACTION_XP_THEME_SWITCH);
        Bundle bundle = new Bundle();
        bundle.putInt("theme", i);
        intent.putExtras(bundle);
        sendBroadcast(intent);
    }

    public void initDayNightMode() {
        ThemeType currentTheme = ThemeWatcherUtil.getCurrentTheme();
        L.Tag tag = TAG;
        L.i(tag, L.formatDayNightSwitchLog("initDayNightMode currentTheme:" + this.mCurrentTheme + ", new theme: " + currentTheme));
        if (this.mCurrentTheme == currentTheme) {
            return;
        }
        this.mCurrentTheme = currentTheme;
        sendBroadcastToThemeSwitch(this.mCurrentTheme.ordinal());
        TBTManager.getInstance().setCurrentThemeType(this.mCurrentTheme);
    }

    private void showLocationDebugDialog() {
        if (DRServiceManager.getInstance().isLocDebugSwitch() && this.mLocDebugView == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mLayoutParams = new WindowManager.LayoutParams();
            int i = displayMetrics.widthPixels / 2;
            int i2 = displayMetrics.heightPixels / 2;
            WindowManager.LayoutParams layoutParams = this.mLayoutParams;
            layoutParams.width = i;
            layoutParams.height = i2;
            layoutParams.x = i;
            layoutParams.y = i2;
            if (Build.VERSION.SDK_INT >= 26) {
                this.mLayoutParams.type = 2008;
            } else {
                this.mLayoutParams.type = 2002;
            }
            this.mLayoutParams.flags = 40;
            this.mLocDebugView = LayoutInflater.from(this).inflate(R.layout.location_debug_dialog, (ViewGroup) null, false);
            getWindow().getWindowManager().addView(this.mLocDebugView, this.mLayoutParams);
            ((LocationDebugDialog) this.mLocDebugView).setSwitchStateCallback(new LocationDebugDialog.SwitchStateCallback() { // from class: com.xiaopeng.montecarlo.MainActivity.2
                @Override // com.xiaopeng.montecarlo.views.dialog.LocationDebugDialog.SwitchStateCallback
                public void updateViewLayout(int i3, int i4) {
                    if (MainActivity.this.mLocDebugView == null) {
                        return;
                    }
                    MainActivity.this.mLayoutParams.x += i3;
                    MainActivity.this.mLayoutParams.y += i4;
                    MainActivity.this.getWindowManager().updateViewLayout(MainActivity.this.mLocDebugView, MainActivity.this.mLayoutParams);
                }

                @Override // com.xiaopeng.montecarlo.views.dialog.LocationDebugDialog.SwitchStateCallback
                public void updateViewLayoutSize(boolean z) {
                    if (MainActivity.this.mLocDebugView == null) {
                        return;
                    }
                    if (z) {
                        DisplayMetrics displayMetrics2 = new DisplayMetrics();
                        MainActivity.this.getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
                        MainActivity.this.mLayoutParams.width = displayMetrics2.widthPixels / 2;
                        MainActivity.this.mLayoutParams.height = displayMetrics2.heightPixels / 2;
                    } else {
                        Resources resources = MainActivity.this.getResources();
                        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.location_debug_coord_xy);
                        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.location_debug_xy_width);
                        MainActivity.this.mLayoutParams.x = dimensionPixelSize;
                        MainActivity.this.mLayoutParams.y = dimensionPixelSize;
                        MainActivity.this.mLayoutParams.width = dimensionPixelSize2;
                        MainActivity.this.mLayoutParams.height = dimensionPixelSize2;
                    }
                    MainActivity.this.getWindowManager().updateViewLayout(MainActivity.this.mLocDebugView, MainActivity.this.mLayoutParams);
                }

                @Override // com.xiaopeng.montecarlo.views.dialog.LocationDebugDialog.SwitchStateCallback
                public void updateViewHeight(int i3) {
                    if (MainActivity.this.mLocDebugView == null) {
                        return;
                    }
                    MainActivity.this.mLayoutParams.height += i3;
                    MainActivity.this.getWindowManager().updateViewLayout(MainActivity.this.mLocDebugView, MainActivity.this.mLayoutParams);
                }
            });
        }
    }

    private void hideLocDebugDialog() {
        if (this.mLocDebugView != null) {
            getWindowManager().removeView(this.mLocDebugView);
            this.mLocDebugView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMapInstance() {
        TraceUtils.alwaysTraceBegin("MainActivity initMapInstance");
        L.i(TAG, "initMapInstance");
        initMapFragment();
        getWindow().getDecorView().setBackground(null);
        if (!this.mMapFragment.isAdded()) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(16908290, this.mMapFragment, MAIN_FRAGMENT_TAG);
            if (Build.VERSION.SDK_INT >= 24) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitAllowingStateLoss();
            }
        }
        L.Tag tag = TAG;
        L.i(tag, "createIntentTask intent:" + getIntent());
        createIntentTask(getIntent());
        NotificationHelper.getInstance().addNaviListener();
        TraceUtils.alwaysTraceEnd();
    }

    private void initMapFragment() {
        if (this.mMapFragment == null) {
            this.mMapFragment = new MapFragment();
            this.mMapFragment.setIntentTaskScheduler(this.mIntentTaskScheduler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkBLInitialized() {
        L.Tag tag = TAG;
        L.i(tag, "checkBLInitialized is called in thread : " + Thread.currentThread().getName());
        InitializerManager.getInstance().addBLInitCompleteListener(new IBLCompleteListener() { // from class: com.xiaopeng.montecarlo.-$$Lambda$MainActivity$sFXrZiFmjNddus0BVe9vx43zMXA
            @Override // com.xiaopeng.montecarlo.IBLCompleteListener
            public final void onResult() {
                MainActivity.this.lambda$checkBLInitialized$2$MainActivity();
            }
        });
    }

    public /* synthetic */ void lambda$checkBLInitialized$2$MainActivity() {
        L.Tag tag = TAG;
        L.i(tag, " onResult is call in thread : " + Thread.currentThread().getName());
        L.i(TAG, " execute task on main thread !");
        if (InitializerManager.getInstance().isBLInitialized()) {
            L.i(TAG, "BLInitCompleteListener onResult : isBLInitialized is true");
            runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.-$$Lambda$MainActivity$XoiLvA-C2vfPqrJXGusPWT5LVNQ
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.this.initMapInstance();
                }
            });
            return;
        }
        L.i(TAG, "BLInitCompleteListener onResult : isBLInitialized is false, retry initBLTasks ...");
        checkBLInitialized();
        InitializerManager.getInstance().lambda$handleAppOnCreate$2$InitializerManager();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        reCheckPermission(i);
        if (ScreenShotHelper.REQUEST_MEDIA_PROJECTION == i && -1 == i2 && intent != null) {
            new ScreenShotHelper(i2, intent, null).startScreenShot();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        reCheckPermission(i);
    }

    private void checkPermission() {
        if (PermissionHelper.hasPermissions(this)) {
            setUpInitializerManager();
        } else {
            PermissionHelper.verifyPermissions(this);
        }
    }

    private void reCheckPermission(int i) {
        if (i == 1) {
            checkPermission();
        }
    }

    public IBaseScene getCurrentScene() {
        MainContext mainContext;
        MapFragment mapFragment = this.mMapFragment;
        if (mapFragment == null || (mainContext = mapFragment.getMainContext()) == null) {
            return null;
        }
        return mainContext.getCurrentScene();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        L.i(TAG, "onConfigurationChanged");
        super.onConfigurationChanged(configuration);
        ThemeWatcherUtil.executeOnConfigurationChanged(configuration, true);
    }
}
