package com.xiaopeng.montecarlo;

import android.app.Application;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.multidex.MultiDex;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.xiaopeng.lib.bughunter.StartPerfUtils;
import com.xiaopeng.lib.framework.locationmodule.LocationModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.montecarlo.InitializerManager;
import com.xiaopeng.montecarlo.account.AccountManager;
import com.xiaopeng.montecarlo.appengine.FullScenesObserver;
import com.xiaopeng.montecarlo.appengine.MapStatusService;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.datalog.DataLogHelper;
import com.xiaopeng.montecarlo.navcore.activate.ActivateManager;
import com.xiaopeng.montecarlo.navcore.adasehp.EHPServiceManager;
import com.xiaopeng.montecarlo.navcore.aos.TrafficEventServiceWrapper;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.location.LocationServiceManager;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.offlinedata.XPOfflineDataManager;
import com.xiaopeng.montecarlo.navcore.sr.LaneServiceManager;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.tts.TTSProxy;
import com.xiaopeng.montecarlo.navcore.util.CommonUtil;
import com.xiaopeng.montecarlo.navcore.util.TBTUtil;
import com.xiaopeng.montecarlo.navcore.util.UserLogControl;
import com.xiaopeng.montecarlo.navcore.xptbt.RouteManager;
import com.xiaopeng.montecarlo.navcore.xptbt.SrCarServiceManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navresetore.NavRestoreManager;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.carservice.MockCarService;
import com.xiaopeng.montecarlo.root.carservice.XpSRCarService;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.theme.ThemeType;
import com.xiaopeng.montecarlo.root.util.AfterSalesUtil;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.DebugCacheConsts;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.LogDiskCacheUtil;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.TraceUtils;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import com.xiaopeng.montecarlo.root.util.config.SettingProperties;
import com.xiaopeng.montecarlo.root.util.logcat.LogHelper;
import com.xiaopeng.montecarlo.service.navi.binder.NaviStatusService;
import com.xiaopeng.montecarlo.speech.manager.NaviSpeechManager;
import com.xiaopeng.montecarlo.speech.manager.SpeechRequestFactoryImpl;
import com.xiaopeng.montecarlo.theme.IThemeSwitchListener;
import com.xiaopeng.montecarlo.util.ActivityLifecycleHelper;
import com.xiaopeng.montecarlo.util.AudioUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.views.HappyEndingView;
import com.xiaopeng.speech.vui.VuiEngine;
import com.xiaopeng.xui.Xui;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
/* loaded from: classes.dex */
public class InitializerManager {
    private static final int CHECK_EXT_SDCARD_MAX_COUNT = 10;
    public static final String MAIN_PROCESS_NAME;
    public static final int PHASE_ACTIVITY_RESUME = 1001;
    public static final int PHASE_APPLICATION_ATTACH_CONTEXT = 100;
    public static final int PHASE_APPLICATION_ON_CREATE = 101;
    public static final String PROCESS_NAME;
    private static final InitializerManager sInitializerManager = new InitializerManager();
    public static volatile int sMapFragmentLifeCycleInitCount = 0;
    private static L.Tag sTAG;
    private Application mApplication;
    private volatile AbstractApplicationInitializer mApplicationInitializer;
    private IRestoreCallback mIRestoreCallback;
    private boolean mIsInRouteRestore = false;
    private boolean mInApplicationRestore = false;
    private IntentFilter mFlushLogFilter = null;
    BroadcastReceiver mLogReceive = new BroadcastReceiver() { // from class: com.xiaopeng.montecarlo.InitializerManager.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (DebugConfiguration.RegisterAction.FLUSH_BLLOG.equals(intent.getAction())) {
                L.i(InitializerManager.sTAG, "stop amap log");
                ServiceMgr.logStop();
            }
        }
    };
    private final List<IInitializerListener> mInitializerBaseListenerList = new ArrayList();
    private final List<IBLCompleteListener> mBLInitCompleteListenerList = new ArrayList();
    private LocationModuleEntry mLocationModuleEntry = null;
    private volatile boolean mBLIsDoingInit = false;
    private volatile boolean mBLInitialized = false;
    private IThemeSwitchListener mThemeSwitchListener = new IThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.InitializerManager.2
        @Override // com.xiaopeng.montecarlo.theme.IThemeSwitchListener
        public void onSwitchTheme(String str, ThemeType themeType) {
            if (L.ENABLE) {
                L.Tag tag = InitializerManager.sTAG;
                L.d(tag, "onSwitchTheme themeName:" + str + ",themeType:" + themeType);
            }
            Utils.setAppTheme();
            TBTManager.getInstance().initAsyncInfoColor(ContextUtils.getColor(R.color.color_route_detail_bg), ContextUtils.getColor(R.color.color_guide_turn_icon_road), ContextUtils.getColor(R.color.color_route_detail_arrow));
            TBTManager.getInstance().onSwitchTheme(themeType);
            LaneServiceManager.getInstance().onSwitchTheme(themeType.isDayMode());
        }
    };

    /* loaded from: classes.dex */
    public interface IRestoreCallback {
        void finish();
    }

    static {
        String str;
        String processName = Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
        String[] split = processName != null ? processName.split(LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR) : null;
        if (split == null) {
            str = "unll";
        } else {
            str = split.length > 1 ? split[1] : split[0];
        }
        PROCESS_NAME = str;
        MAIN_PROCESS_NAME = split != null ? split[0] : "unll";
    }

    public static InitializerManager getInstance() {
        return sInitializerManager;
    }

    public void initAfterBLActivation() {
        L.Tag tag = sTAG;
        L.i(tag, "initAfterBLActivation is called in thread : " + Thread.currentThread().getName());
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.-$$Lambda$InitializerManager$sNdfDafZYrmFnLPcS0AblZL5WJo
            @Override // java.lang.Runnable
            public final void run() {
                InitializerManager.lambda$initAfterBLActivation$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$initAfterBLActivation$0() {
        L.Tag tag = sTAG;
        L.i(tag, "initAfterBLActivation start in work thread : " + Thread.currentThread().getName());
        TraceUtils.alwaysTraceBegin("Application_onCreate_after_BL_activate__init_MapDataManager");
        L.i(sTAG, "Application_onCreate_after_BL_activate_MapDataManager init start");
        MapDataManager.getInstance().init();
        L.i(sTAG, "Application_onCreate_after_BL_activate_MapDataManager init end");
        TraceUtils.alwaysTraceEnd();
        L.Tag tag2 = sTAG;
        L.i(tag2, "initAfterBLActivation end in work thread : " + Thread.currentThread().getName());
    }

    @MainThread
    public void init(@NonNull Application application, L.Tag tag) {
        this.mApplication = application;
        sTAG = tag;
    }

    @MainThread
    public void onBootPhase(int i) {
        if (i == 100) {
            handleAppAttach();
        } else if (i == 101) {
            handleAppOnCreate();
        } else if (i != 1001) {
        } else {
            handleOtherStart();
        }
    }

    @MainThread
    private void handleAppAttach() {
        TraceUtils.alwaysTraceBegin("Application_Attach_MultiDex_install");
        L.i(sTAG, "Application_Attach_MultiDex_install start ");
        MultiDex.install(this.mApplication);
        L.i(sTAG, "Application_Attach_MultiDex_install end ");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_Attach_init_SettingProperties");
        L.i(sTAG, "Application_Attach_init_SettingProperties start ");
        SettingProperties.initSettingProperties(this.mApplication);
        L.i(sTAG, "Application_Attach_init_SettingProperties end ");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_Attach_ContextUtils");
        L.i(sTAG, "Application_Attach_ContextUtils init start ");
        ContextUtils.initApp(this.mApplication);
        L.i(sTAG, "Application_Attach_ContextUtils init end ");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_Attach_init_RootUtil");
        L.i(sTAG, "Application_Attach_RootUtil init start ");
        RootUtil.init();
        L.i(sTAG, "Application_Attach_RootUtil init end ");
        TraceUtils.alwaysTraceEnd();
    }

    private void startLogcatProcessAfterExternalStorage() {
        getInstance().waitExternalStorage(new IWaitExternalStorageCallback() { // from class: com.xiaopeng.montecarlo.-$$Lambda$InitializerManager$0owcg_Ht-WjfZEPjPLc7Aw2PXCc
            @Override // com.xiaopeng.montecarlo.IWaitExternalStorageCallback
            public final void onResult() {
                InitializerManager.this.lambda$startLogcatProcessAfterExternalStorage$1$InitializerManager();
            }
        });
    }

    public /* synthetic */ void lambda$startLogcatProcessAfterExternalStorage$1$InitializerManager() {
        boolean z = RootUtil.isLogcatEnabled() && RootUtil.isWriteLogToFile();
        boolean z2 = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_XP_LOG, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_XP_LOG);
        L.Tag tag = sTAG;
        L.i(tag, "startLogcatProcessAfterExternalStorage onResult extSD status : " + RootUtil.extsd_status + " , logEnabled : " + z + ", isXpLogSettingOpen : " + z2);
        if (z && z2) {
            LogHelper.getInstance().init(RootUtil.getLogcatLogPath());
            if (this.mFlushLogFilter == null) {
                this.mFlushLogFilter = new IntentFilter();
                this.mFlushLogFilter.addAction(DebugConfiguration.RegisterAction.FLUSH_BLLOG);
                L.i(sTAG, "register FlushLogFilter");
                ContextUtils.getContext().registerReceiver(this.mLogReceive, this.mFlushLogFilter);
            }
        } else if (RootUtil.isUserVersion() && RootUtil.isOpenNaviLogIn131()) {
            LogHelper.getInstance().initNaviLogFolder();
        } else if (RootUtil.isUserVersion()) {
        } else {
            LogHelper.getInstance().initNaviLogFolder();
        }
    }

    @MainThread
    private void handleAppOnCreate() {
        L.Tag tag = sTAG;
        L.i(tag, "Application onCreate start. Version: " + RootUtil.getVersionName() + ", cur: " + PROCESS_NAME + ", MAIN: " + MAIN_PROCESS_NAME);
        if (PROCESS_NAME.equals(MAIN_PROCESS_NAME)) {
            try {
                StartPerfUtils.appOnCreateBegin();
            } catch (Exception e) {
                e.printStackTrace();
            }
            TraceUtils.alwaysTraceBegin("Application_initMainProcessInitializer_start");
            L.Tag tag2 = sTAG;
            L.i(tag2, " initMainProcessInitializer start. Version: " + RootUtil.getVersionName());
            if (!isApplicationInitialized()) {
                TraceUtils.alwaysTraceBegin("Application_generateApplicationInitializer");
                L.i(sTAG, "initApplicationInitializer start ");
                MapStatusService.noticeMapFirstFrameDrawStatus(false);
                this.mApplicationInitializer = AbstractApplicationInitializer.generateApplicationInitializer(this.mApplication, sTAG);
                if (this.mApplicationInitializer == null) {
                    throw new IllegalArgumentException("initApplicationInitializer error !");
                }
                L.i(sTAG, "initApplicationInitializer end ");
                TraceUtils.alwaysTraceEnd();
                initCommonJobsShouldInMainThread();
                addInitBaseListener(new IInitializerListener() { // from class: com.xiaopeng.montecarlo.-$$Lambda$InitializerManager$MlcOPQcCXwdrSxCl3GoLID2Rd7M
                    @Override // com.xiaopeng.montecarlo.IInitializerListener
                    public final void onResult() {
                        InitializerManager.this.lambda$handleAppOnCreate$2$InitializerManager();
                    }
                });
                addInitBaseListener(new IInitializerListener() { // from class: com.xiaopeng.montecarlo.-$$Lambda$InitializerManager$wVOeie3GutoIxFUHTEtW6Dc6fbg
                    @Override // com.xiaopeng.montecarlo.IInitializerListener
                    public final void onResult() {
                        InitializerManager.this.lambda$handleAppOnCreate$3$InitializerManager();
                    }
                });
                WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.-$$Lambda$InitializerManager$Q-paiGBxLnxA8GkdqpCHxA2yOF4
                    @Override // java.lang.Runnable
                    public final void run() {
                        InitializerManager.this.lambda$handleAppOnCreate$4$InitializerManager();
                    }
                });
            }
            L.i(sTAG, " initMainProcessInitializer end. ");
            TraceUtils.alwaysTraceEnd();
            try {
                StartPerfUtils.appOnCreateEnd();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @MainThread
    private void handleOtherStart() {
        if (L.ENABLE) {
            L.d(sTAG, "handleOtherStart start ");
        }
        UserLogControl.INSTANCE.check131NaviLog();
        if (RootUtil.isTabletApp()) {
            ((UiModeManager) this.mApplication.getSystemService("uimode")).setNightMode(DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.DAY_NIGHT_MODE_SET, 0));
        }
        if (L.ENABLE) {
            L.d(sTAG, "handleOtherStart end ");
        }
    }

    @MainThread
    public void onTerminate() {
        if (this.mApplicationInitializer != null) {
            this.mApplicationInitializer.onTerminate();
        }
        unregisterDynamicThemeSwitchListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initCommonJobsCanInWorkThread */
    public void lambda$handleAppOnCreate$4$InitializerManager() {
        TraceUtils.alwaysTraceBegin("Application_onCreate_work_thread_initLayerStyle");
        L.i(sTAG, "Application_onCreate_work_thread_initLayerStyle start");
        CommonUtil.initLayerStyle();
        L.i(sTAG, "Application_onCreate_work_thread_initLayerStyle end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_onCreate_work_thread_init_UserLogControl");
        L.i(sTAG, "Application_onCreate_work_thread_init_UserLogControl start");
        UserLogControl.INSTANCE.init();
        L.i(sTAG, "Application_onCreate_work_thread_init_UserLogControl end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_onCreate_work_thread_init_Xp_Log");
        L.i(sTAG, "Application_onCreate_work_thread_init_Xp_Log start");
        initXpLog();
        L.i(sTAG, "Application_onCreate_work_thread_init_Xp_Log end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_onCreate_main_LogcatProcess");
        L.i(sTAG, "Application_onCreate_work_thread_LogcatProcess start");
        startLogcatProcessAfterExternalStorage();
        L.i(sTAG, "Application_onCreate_work_thread_LogcatProcess end");
        TraceUtils.alwaysTraceEnd();
        L.Tag tag = sTAG;
        L.i(tag, "initCommon in work thread start, thread : " + Thread.currentThread().getName());
        TraceUtils.alwaysTraceBegin("Application_onCreate_work_thread_init_CarServiceManager");
        L.i(sTAG, "Application_onCreate_work_thread_init_CarServiceManager start");
        initCarServiceManager();
        L.i(sTAG, "Application_onCreate_work_thread_init_CarServiceManager end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_onCreate_work_thread_connectSystemCarService");
        L.i(sTAG, "Application_onCreate_work_thread_connectSystemCarService start");
        connectSystemCarService();
        L.i(sTAG, "Application_onCreate_work_thread_connectSystemCarService end");
        TraceUtils.alwaysTraceEnd();
        if (CarFeatureManager.INSTANCE.isFullScenesVoiceEnable()) {
            TraceUtils.alwaysTraceBegin("Application_onCreate_work_thread_VuiEngine");
            L.i(sTAG, L.formatVoiceFullScenesLog("Application_onCreate_work_thread_init_vui_engine start"));
            VuiEngine vuiEngine = VuiEngine.getInstance(this.mApplication);
            vuiEngine.subscribe(Utils.getPackageName(this.mApplication) + "." + FullScenesObserver.class.getSimpleName());
            Xui.setVuiEnable(true);
            VoiceFullScenesUtil.initVuiLogLevel();
            L.i(sTAG, L.formatVoiceFullScenesLog("Application_onCreate_work_thread_init_vui_engine end"));
            TraceUtils.alwaysTraceEnd();
        }
        notifyInitCommonFinished();
        L.Tag tag2 = sTAG;
        L.i(tag2, "initCommon in work thread end, thread : " + Thread.currentThread().getName());
    }

    private void initCommonJobsShouldInMainThread() {
        TraceUtils.alwaysTraceBegin("Application_onCreate_main_eventBus_init");
        L.i(sTAG, " Application_onCreate_main_initEventBus start ");
        initEventBus();
        L.i(sTAG, " Application_onCreate_main_initEventBus end ");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_create_ActivityLifecycleHelper");
        TraceUtils.alwaysTraceBegin("Application_onCreate_main_ActivityLifecycleHelper");
        L.i(sTAG, "Application_onCreate_main_ActivityLifecycleHelper_init start");
        ActivityLifecycleHelper.getInstance().init(this.mApplication);
        L.i(sTAG, "Application_onCreate_main_ActivityLifecycleHelper_init end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_onCreate_main_ThemeWatcherUtil");
        L.i(sTAG, "Application_onCreate_main_ThemeWatcherUtil start");
        this.mApplicationInitializer.initThemeWatcher(this.mApplication);
        registerDynamicThemeSwitchListener();
        L.i(sTAG, "Application_onCreate_main_ThemeWatcherUtil end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_onCreate_main_init_xui");
        L.i(sTAG, "Application_onCreate_main_init_xui start");
        this.mApplicationInitializer.initXui(this.mApplication);
        L.i(sTAG, "Application_onCreate_main_init_xui end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_onCreate_main_FavoriteDataManager");
        L.i(sTAG, "Application_onCreate_main_FavoriteDataManager start");
        FavoriteDataManager.getInstance().init(this.mApplication);
        L.i(sTAG, "Application_onCreate_main_FavoriteDataManager end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_onCreate_work_thread_initCarServiceManager");
        L.i(sTAG, "Application_onCreate_work_thread_initCarServiceManager start");
        initCarServiceManager();
        L.i(sTAG, "Application_onCreate_work_thread_initCarServiceManager end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_onCreate_work_thread_init_CarFeatureManager");
        L.i(sTAG, "Application_onCreate_work_thread_init_CarFeatureManager start");
        CarFeatureManager.INSTANCE.init();
        L.i(sTAG, "Application_onCreate_work_thread_init_CarFeatureManager end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_onCreate_work_thread_check_vmap_size");
        if (RootUtil.isRemoteOpenLog()) {
            LogHelper.getInstance().checkLogDiskSize(true);
        }
        TraceUtils.alwaysTraceEnd();
    }

    private void initCarServiceManager() {
        if (RootUtil.isCarServiceDebugMode()) {
            CarServiceManager.getInstance().init(new MockCarService());
            RootUtil.setCarSerivceDebugMode(false);
            XPNetworkManager.INSTANCE.updateTboxApnConnected(true);
            return;
        }
        CarServiceManager.getInstance().init(this.mApplicationInitializer.getCarService());
    }

    private void connectSystemCarService() {
        CarServiceManager.getInstance().connectSystemCarService();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: initBLTasks */
    public final void lambda$handleAppOnCreate$2$InitializerManager() {
        L.i(sTAG, "initBLTasks start");
        if (this.mBLInitialized || this.mBLIsDoingInit) {
            L.w(sTAG, "initBLTasks isBLInitialized || mBLIsDoingInit == true");
        } else {
            WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.-$$Lambda$InitializerManager$sGfKgJiZgFDU5n1j2Bfv3IMcT2o
                @Override // java.lang.Runnable
                public final void run() {
                    InitializerManager.this.lambda$initBLTasks$6$InitializerManager();
                }
            });
        }
    }

    public /* synthetic */ void lambda$initBLTasks$6$InitializerManager() {
        L.Tag tag = sTAG;
        L.i(tag, "initBLTasks in work thread start, thread : " + Thread.currentThread().getName());
        TraceUtils.alwaysTraceBegin("Application_create_LocationModuleEntry");
        L.i(sTAG, "Application_onCreate_BL_thread_LocationModuleEntry register start");
        if (this.mLocationModuleEntry == null) {
            this.mLocationModuleEntry = new LocationModuleEntry();
            Module.register(LocationModuleEntry.class, this.mLocationModuleEntry);
        }
        L.i(sTAG, "Application_onCreate_BL_thread_ALocationModuleEntry register end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_create_LocationServiceManager");
        L.i(sTAG, "Application_onCreate_BL_thread_LocationServiceManager init start");
        LocationServiceManager locationServiceManager = LocationServiceManager.getInstance();
        Application application = this.mApplication;
        locationServiceManager.init(application, RootUtil.SD_CARD_NAVI_PATH + "/debug/");
        L.i(sTAG, "Application_onCreate_BL_thread_LocationServiceManager init end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_onCreate_BL_thread_initBL");
        L.i(sTAG, "Application_onCreate_BL_thread_initBL start");
        boolean initBL = this.mApplicationInitializer.initBL();
        L.Tag tag2 = sTAG;
        L.i(tag2, "Application_onCreate_BL_thread_initBL end : " + initBL);
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_onCreate_BL_thread_initTBT");
        L.i(sTAG, "Application_onCreate_BL_thread_initTBT start");
        boolean initTBT = this.mApplicationInitializer.initTBT();
        L.Tag tag3 = sTAG;
        L.i(tag3, "Application_onCreate_BL_thread_initTBT end : " + initTBT);
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_init_xui_service");
        L.i(sTAG, "Application_init_xui_service start");
        this.mApplicationInitializer.initXUIService(this.mApplication);
        L.i(sTAG, "Application_init_xui_service end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_onCreate_BL_thread_init_NetworkReceiver");
        L.i(sTAG, "Application_onCreate_BL_thread_initNetworkReceiver start");
        this.mApplicationInitializer.initNetworkReceiver();
        L.i(sTAG, "Application_onCreate_BL_thread_initNetworkReceiver end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_create_SRNaviManager");
        L.i(sTAG, "Application_onCreate_BL_thread_SRNaviManager init start");
        SRNaviManager.getInstance().init();
        L.i(sTAG, "Application_onCreate_BL_thread_SRNaviManager init end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_onCreate_BL_thread_init_updateBLNetworkStatus");
        L.i(sTAG, "Application_onCreate_BL_thread_updateBLNetworkStatus start");
        this.mApplicationInitializer.updateBLNetworkStatus();
        L.i(sTAG, "Application_onCreate_BL_thread_updateBLNetworkStatus end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_onCreate_BL_thread__init_SearchClient");
        L.i(sTAG, "Application_onCreate_BL_thread_SearchClient init start");
        SearchClient.getInstance().init();
        L.i(sTAG, "Application_onCreate_BL_thread_SearchClient init end");
        TraceUtils.alwaysTraceEnd();
        this.mBLIsDoingInit = initBL && initTBT;
        L.Tag tag4 = sTAG;
        L.i(tag4, "Application_onCreate_BL_thread_set mBLIsDoingInit: " + initTBT + " in thread : " + Thread.currentThread().getName());
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.InitializerManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (TBTManager.getInstance().isMiniMapEnable()) {
                    L.i(InitializerManager.sTAG, "MiniMapService startService in BLInit");
                    Intent intent = new Intent();
                    intent.setClassName(ContextUtils.getContext().getPackageName(), "com.xiaopeng.montecarlo.service.minimap.MiniMapService");
                    ContextUtils.getContext().startService(intent);
                }
            }
        });
        if (!ActivateManager.getInstance().isActivateSuccess()) {
            initEhpAndLane(true);
            notifyBLInitFinished();
            return;
        }
        if (TBTManager.getInstance().isNeedRestoreRoute() && !isInRouteRestore()) {
            initEhpAndLane(false);
            TBTManager.getInstance().initAsyncInfoColor(ContextUtils.getColor(R.color.color_route_detail_bg), ContextUtils.getColor(R.color.color_guide_turn_icon_road), ContextUtils.getColor(R.color.color_route_detail_arrow));
            TTSProxy.getInstance().setTtsEnable(true);
            setInApplicationRestore(true);
            setInRouteRestore(true);
            final RouteParams restoreRouteParams = TBTManager.getInstance().getRestoreRouteParams();
            L.Tag tag5 = sTAG;
            L.i(tag5, "isNeedRestoreRoute params = " + restoreRouteParams);
            if (restoreRouteParams != null) {
                TBTManager.getInstance().restoreNavi(ThemeWatcherUtil.getMapModeByCurrentTheme(), true, new RouteManager.IRestoreListener() { // from class: com.xiaopeng.montecarlo.-$$Lambda$InitializerManager$yy5kYFaQM5Sm85z_bh1pmkwnD98
                    @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRestoreListener
                    public final void onRestoreResult(boolean z) {
                        InitializerManager.this.lambda$null$5$InitializerManager(restoreRouteParams, z);
                    }
                });
            } else {
                notifyBLInitFinished();
            }
        } else {
            initEhpAndLane(true);
            notifyBLInitFinished();
        }
        initAfterBLActivation();
    }

    public /* synthetic */ void lambda$null$5$InitializerManager(RouteParams routeParams, boolean z) {
        L.Tag tag = sTAG;
        L.i(tag, "RestoreFromByteData >>> restored = " + z);
        if (z) {
            setInRouteRestore(false);
            IRestoreCallback iRestoreCallback = this.mIRestoreCallback;
            if (iRestoreCallback != null) {
                iRestoreCallback.finish();
            }
            notifyBLInitFinished();
            return;
        }
        routeParams.mStartInfo = TBTManager.getInstance().getStartPOIFromCurrent();
        TBTManager.getInstance().requestRoute(routeParams, new AnonymousClass4());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.InitializerManager$4  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass4 implements RouteManager.IRouteResultListener {
        AnonymousClass4() {
        }

        @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
        public void onNewRouteSuccess(final long j, RouteResult routeResult) {
            L.Tag tag = InitializerManager.sTAG;
            L.i(tag, "onNewRouteSuccess requestId = " + j);
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.-$$Lambda$InitializerManager$4$R9sQz8ZcFCO8Vcn-KdQiAb7MnHQ
                @Override // java.lang.Runnable
                public final void run() {
                    InitializerManager.AnonymousClass4.this.lambda$onNewRouteSuccess$0$InitializerManager$4(j);
                }
            });
        }

        public /* synthetic */ void lambda$onNewRouteSuccess$0$InitializerManager$4(long j) {
            SrCarServiceManager.getInstance().init(new XpSRCarService());
            TBTManager.getInstance().setEhpConfigValue(false);
            TBTManager.getInstance().startNavi(j, 0, ThemeWatcherUtil.getMapModeByCurrentTheme(), TBTUtil.getRestoreStatus(), false);
            InitializerManager.this.setInRouteRestore(false);
            if (InitializerManager.this.mIRestoreCallback != null) {
                InitializerManager.this.mIRestoreCallback.finish();
            }
            InitializerManager.this.notifyBLInitFinished();
        }

        @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
        public void onNewRouteError(final long j, final RouteResult routeResult) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.-$$Lambda$InitializerManager$4$Fago4YEoR3oR6u1zzZxvcHdaaO0
                @Override // java.lang.Runnable
                public final void run() {
                    InitializerManager.AnonymousClass4.this.lambda$onNewRouteError$1$InitializerManager$4(routeResult, j);
                }
            });
        }

        public /* synthetic */ void lambda$onNewRouteError$1$InitializerManager$4(RouteResult routeResult, long j) {
            InitializerManager.this.setInRouteRestore(false);
            InitializerManager.this.setInApplicationRestore(false);
            L.Tag tag = InitializerManager.sTAG;
            L.e(tag, "requestRouteSync Error, error code: " + routeResult.mErrorCode);
            if (routeResult.mErrorCode != 37) {
                TBTManager.getInstance().clearRouteData(j);
            }
            InitializerManager.this.notifyBLInitFinished();
        }
    }

    private void initEhpAndLane(boolean z) {
        TraceUtils.alwaysTraceBegin("Application_init_ehp_service");
        L.i(sTAG, "Application_init_ehp_service start");
        EHPServiceManager.getInstance().init(z);
        L.i(sTAG, "Application_init_ehp_service end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_create_LaneServiceManager");
        L.i(sTAG, "Application_onCreate_BL_thread_LaneServiceManager init start");
        LaneServiceManager.getInstance().init();
        LaneServiceManager.getInstance().registerHappyEnding(new HappyEndingView());
        LaneServiceManager.getInstance().onSwitchTheme(ThemeWatcherUtil.isDayMode());
        L.i(sTAG, "Application_onCreate_BL_thread_LaneServiceManager init end");
        TraceUtils.alwaysTraceEnd();
    }

    public synchronized boolean isInRouteRestore() {
        return this.mIsInRouteRestore;
    }

    public synchronized void setInRouteRestore(boolean z) {
        this.mIsInRouteRestore = z;
    }

    public synchronized boolean isInApplicationRestore() {
        return this.mInApplicationRestore;
    }

    public synchronized void setInApplicationRestore(boolean z) {
        this.mInApplicationRestore = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initXp */
    public void lambda$handleAppOnCreate$3$InitializerManager() {
        L.Tag tag = sTAG;
        L.i(tag, "initXp is called in thread : " + Thread.currentThread().getName());
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.-$$Lambda$InitializerManager$m61ZWBqUakIU4K9c-7FGIeco3d4
            @Override // java.lang.Runnable
            public final void run() {
                InitializerManager.this.lambda$initXp$7$InitializerManager();
            }
        });
    }

    public /* synthetic */ void lambda$initXp$7$InitializerManager() {
        L.Tag tag = sTAG;
        L.i(tag, "initXp in work thread start, thread : " + Thread.currentThread().getName());
        L.i(sTAG, "preload class start");
        L.Tag tag2 = sTAG;
        L.i(tag2, "pre :" + BtnType.EXPOSURE);
        L.Tag tag3 = sTAG;
        L.i(tag3, "pre :" + PageType.NONE);
        L.i(sTAG, "preload class end");
        TraceUtils.alwaysTraceBegin("Application_init_XP_Module");
        L.i(sTAG, "Application_init_XP_Module start");
        this.mApplicationInitializer.initXPModule(this.mApplication);
        L.i(sTAG, "Application_init_XP_Module end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_create_BugHunter");
        L.i(sTAG, "Application_create_BugHunter start");
        this.mApplicationInitializer.initBugHunter();
        L.i(sTAG, "Application_create_BugHunter end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_init_power_dis_energy");
        L.i(sTAG, "Application_init_power_dis_energy start");
        this.mApplicationInitializer.initPowerDisEnergy();
        L.i(sTAG, "Application_init_power_dis_energy end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_LogDiskCacheUtil_clearDiskCache");
        L.i(sTAG, "Application_LogDiskCacheUtil_clearDiskCache start");
        LogDiskCacheUtil.clearDiskCache();
        L.i(sTAG, "Application_LogDiskCacheUtil_clearDiskCache end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_checkAndCloseLogs");
        L.i(sTAG, "Application_checkAndCloseLogs start");
        this.mApplicationInitializer.checkAndCloseLogs();
        L.i(sTAG, "Application_checkAndCloseLogs end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_create_TTS");
        L.i(sTAG, "Application_create_TTS start");
        this.mApplicationInitializer.initTTS();
        L.i(sTAG, "Application_create_TTS end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_create_Speech");
        L.i(sTAG, "Application_create_Speech start");
        this.mApplicationInitializer.initSpeech();
        new SpeechRequestFactoryImpl();
        L.i(sTAG, "Application_create_Speech end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_init_charge_db");
        L.i(sTAG, "Application_init_charge_db start");
        this.mApplicationInitializer.initChargeDB();
        L.i(sTAG, "Application_init_charge_db end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_init_account");
        L.i(sTAG, "Application_init_AccountManager start");
        AccountManager.getInstance().init(this.mApplication);
        L.i(sTAG, "Application_init_AccountManager end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_init_nav_restore_manager");
        L.i(sTAG, "Application_init_nav_restore_manager start");
        NavRestoreManager.getInstance().init();
        L.i(sTAG, "Application_init_nav_restore_manager end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_init_traffic_event_service");
        L.i(sTAG, "Application_init_traffic_event_service start");
        TrafficEventServiceWrapper.getInstance().init();
        L.i(sTAG, "Application_init_traffic_event_service end");
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_init_audio_manager");
        L.i(sTAG, "Application_init_audio_manager start");
        AudioUtil.getInstance().init();
        L.i(sTAG, "Application_init_audio_manager end");
        TraceUtils.alwaysTraceBegin("Application_init_after_sales_manager");
        L.i(sTAG, "Application_init_after_sales_manager start");
        AfterSalesUtil.getInstance().init();
        L.i(sTAG, "Application_init_after_sales_manager end");
        XPOfflineDataManager.getInstance().initData();
        L.Tag tag4 = sTAG;
        L.i(tag4, "initXp in work thread end, thread : " + Thread.currentThread().getName());
    }

    private void addInitBaseListener(@NonNull IInitializerListener iInitializerListener) {
        synchronized (this.mInitializerBaseListenerList) {
            if (!this.mInitializerBaseListenerList.contains(iInitializerListener)) {
                this.mInitializerBaseListenerList.add(iInitializerListener);
            }
        }
    }

    public void notifyInitCommonFinished() {
        ArrayList<IInitializerListener> arrayList;
        synchronized (this.mInitializerBaseListenerList) {
            if (CollectionUtils.isNotEmpty(this.mInitializerBaseListenerList)) {
                arrayList = new ArrayList();
                arrayList.addAll(this.mInitializerBaseListenerList);
                this.mInitializerBaseListenerList.clear();
            } else {
                arrayList = null;
            }
        }
        if (CollectionUtils.isNotEmpty(arrayList)) {
            for (IInitializerListener iInitializerListener : arrayList) {
                iInitializerListener.onResult();
            }
        }
    }

    final void initXpLog() {
        L.setLoggable(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_XP_LOG, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_XP_LOG));
        L.Tag tag = sTAG;
        L.i(tag, "xp log is opened : " + L.ENABLE);
    }

    final void initEventBus() {
        try {
            EventBus.builder().addIndex(new AppEventBusIndex()).addIndex(new NavCoreEventBusIndex()).sendNoSubscriberEvent(false).logNoSubscriberMessages(false).logSubscriberExceptions(false).throwSubscriberException(!RootUtil.isUserVersion()).installDefaultEventBus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isBLInitialized() {
        L.Tag tag = sTAG;
        L.i(tag, "mBLInitialized = " + this.mBLInitialized);
        return this.mBLInitialized;
    }

    private boolean isApplicationInitialized() {
        return this.mApplicationInitializer != null;
    }

    public void addBLInitCompleteListener(@NonNull IBLCompleteListener iBLCompleteListener) {
        synchronized (this.mBLInitCompleteListenerList) {
            if (!this.mBLInitCompleteListenerList.contains(iBLCompleteListener)) {
                this.mBLInitCompleteListenerList.add(iBLCompleteListener);
            }
        }
        if (this.mBLInitialized) {
            notifyBLInitFinished();
        }
    }

    public void removeBLCompleteInitListener(@NonNull IBLCompleteListener iBLCompleteListener) {
        synchronized (this.mBLInitCompleteListenerList) {
            this.mBLInitCompleteListenerList.remove(iBLCompleteListener);
        }
    }

    public void notifyBLInitFinished() {
        ArrayList<IBLCompleteListener> arrayList;
        this.mBLInitialized = this.mBLIsDoingInit;
        synchronized (this.mBLInitCompleteListenerList) {
            if (CollectionUtils.isNotEmpty(this.mBLInitCompleteListenerList)) {
                arrayList = new ArrayList();
                arrayList.addAll(this.mBLInitCompleteListenerList);
                this.mBLInitCompleteListenerList.clear();
            } else {
                arrayList = null;
            }
        }
        if (CollectionUtils.isNotEmpty(arrayList)) {
            for (IBLCompleteListener iBLCompleteListener : arrayList) {
                iBLCompleteListener.onResult();
            }
        }
    }

    private void registerDynamicThemeSwitchListener() {
        ThemeWatcherUtil.addThemeListener(this.mThemeSwitchListener);
    }

    private void unregisterDynamicThemeSwitchListener() {
        ThemeWatcherUtil.removeThemeListener(this.mThemeSwitchListener);
    }

    public void waitExternalStorage(final IWaitExternalStorageCallback iWaitExternalStorageCallback) {
        if (this.mApplicationInitializer == null) {
            throw new IllegalArgumentException("mApplicationInitializer is null when waitExternalStorage is called");
        }
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.-$$Lambda$InitializerManager$GE0oVR8sM6ooE2j8g7JBUQ3ybrc
            @Override // java.lang.Runnable
            public final void run() {
                InitializerManager.lambda$waitExternalStorage$8(IWaitExternalStorageCallback.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$waitExternalStorage$8(IWaitExternalStorageCallback iWaitExternalStorageCallback) {
        L.i(sTAG, "waitExternalStorage in work thread, add task to IO thread ");
        L.Tag tag = sTAG;
        L.i(tag, "ExternalStorage start checking in work thread : " + Thread.currentThread().getName());
        TraceUtils.alwaysTraceBegin("waitExternalStorage");
        RootUtil.sdcard_status = RootUtil.getSDCardState();
        while (RootUtil.sdcard_status != 0 && !RootUtil.isSdCardMount()) {
            try {
                Thread.sleep(100L);
            } catch (Exception unused) {
            }
            RootUtil.sdcard_status = RootUtil.getSDCardState();
        }
        int i = 0;
        RootUtil.extsd_status = 0;
        while (i < 10) {
            RootUtil.extsd_status = RootUtil.isExSDCardExist();
            if (RootUtil.extsd_status == 0 || RootUtil.isTfExtSdExist()) {
                break;
            }
            try {
                Thread.sleep(100L);
            } catch (Exception unused2) {
            }
            i++;
        }
        if (2 != RootUtil.extsd_status) {
            L.w(sTAG, "waitExternalStorage can not find extSD");
        }
        if (2 != RootUtil.sdcard_status) {
            L.w(sTAG, "waitExternalStorage can not find SD");
        }
        L.Tag tag2 = sTAG;
        L.i(tag2, "waitExternalStorage extSD_status :" + RootUtil.extsd_status + " check times: " + i);
        iWaitExternalStorageCallback.onResult();
        TraceUtils.alwaysTraceEnd();
    }

    public void initMapFragmentCycleInstanceSerivce(MainContext mainContext) {
        L.Tag tag = sTAG;
        L.i(tag, "initMapFragmentCycleInstanceSerivce Count:" + sMapFragmentLifeCycleInitCount);
        sMapFragmentLifeCycleInitCount = sMapFragmentLifeCycleInitCount + 1;
        NaviSpeechManager.getInstance().initSpeechDispatcher(mainContext.getSpeechEvent());
        NavRestoreManager.getInstance().setMainContext(mainContext);
        AccountManager.getInstance().setMainContext(mainContext);
        NaviStatusService.setMainContext(mainContext);
        DataLogHelper.setMainContext(mainContext);
    }

    public void deInitMapFragmentLifeCycleInstanceSerivce() {
        L.Tag tag = sTAG;
        L.i(tag, "deInitMapFragmentLifeCycleInstanceSerivce Count:" + sMapFragmentLifeCycleInitCount);
        sMapFragmentLifeCycleInitCount = sMapFragmentLifeCycleInitCount + (-1);
        if (sMapFragmentLifeCycleInitCount == 0) {
            NaviSpeechManager.getInstance().deinitSpeechDispatcher();
            NaviStatusService.setMainContext(null);
            DataLogHelper.setMainContext(null);
            AccountManager.getInstance().setMainContext(null);
            NavRestoreManager.getInstance().releaseMainContext();
        }
    }

    public void addRestoreCallback(IRestoreCallback iRestoreCallback) {
        this.mIRestoreCallback = iRestoreCallback;
    }
}
