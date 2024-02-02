package com.xiaopeng.montecarlo;

import android.app.Application;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.autonavi.gbl.servicemanager.model.ALCGroup;
import com.autonavi.gbl.servicemanager.model.BLInitParam;
import com.autonavi.gbl.servicemanager.model.BaseInitParam;
import com.xiaopeng.lib.bughunter.BugHunter;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.montecarlo.account.AccountManager;
import com.xiaopeng.montecarlo.navcore.account.BLMsgPushServiceWrapper;
import com.xiaopeng.montecarlo.navcore.activate.ActivateManager;
import com.xiaopeng.montecarlo.navcore.adasehp.EHPServiceManager;
import com.xiaopeng.montecarlo.navcore.configurationmodule.ConfigurationModuleManager;
import com.xiaopeng.montecarlo.navcore.database.DatabaseManager;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.location.CalibrationVersionChecker;
import com.xiaopeng.montecarlo.navcore.powerdistance.PowerDistanceManager;
import com.xiaopeng.montecarlo.navcore.search.offlinedata.XPOfflineDataManager;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.util.CommonUtil;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.util.UserLogControl;
import com.xiaopeng.montecarlo.navcore.xptbt.SrCarServiceManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.XUIServiceManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.carservice.ICarService;
import com.xiaopeng.montecarlo.root.carservice.MockCarService;
import com.xiaopeng.montecarlo.root.network.IXPNetworkListener;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.DebugCacheConsts;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.TraceUtils;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import com.xiaopeng.montecarlo.root.util.logcat.LogHelper;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchSceneDataHelper;
import com.xiaopeng.montecarlo.util.ActivityLifecycleHelper;
import com.xiaopeng.montecarlo.util.AudioUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.speech.vui.VuiEngine;
import com.xiaopeng.xui.Xui;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class AbstractApplicationInitializer {
    private static final long FIRST_REBOOT_CHECK_TIME = 60000;
    private static final long INIT_BL_DELAY_TIME = 15000;
    protected static L.Tag sTAG;
    protected Application mContext;
    private IXPNetworkListener mIXPNetworkListener;
    private NetworkChangedReceiver mNetworkReceiver;
    private AbstractPlatformInterface mPlatformInterface;

    private String getCurrentServerEnv(int i) {
        return i == 0 ? "dev_env" : i == 1 ? "test_env" : i == 2 ? "pre_release_env" : "product_env";
    }

    abstract void deInitSelf();

    abstract void deInitSpeech();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void initSpeech();

    abstract void initStoragePath();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean initTBT();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void initTTS();

    public void initXUIService(Application application) {
    }

    public static AbstractApplicationInitializer generateApplicationInitializer(@NonNull Application application, L.Tag tag) {
        try {
            PackageType currentPackageType = PackageType.getCurrentPackageType(application);
            if (currentPackageType == null) {
                return null;
            }
            AbstractApplicationInitializer abstractApplicationInitializer = (AbstractApplicationInitializer) Class.forName(currentPackageType.getInitializerName()).newInstance();
            sTAG = tag;
            AbstractPlatformInterface abstractPlatformInterface = (AbstractPlatformInterface) Class.forName(currentPackageType.getInterfaceName()).newInstance();
            if (abstractPlatformInterface != null) {
                abstractPlatformInterface.setContext(application);
            }
            if (abstractApplicationInitializer != null) {
                abstractApplicationInitializer.initStoragePath();
                abstractApplicationInitializer.setApplication(application);
                abstractApplicationInitializer.setPlatformInterface(abstractPlatformInterface);
            }
            return abstractApplicationInitializer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void setApplication(@NonNull Application application) {
        this.mContext = application;
    }

    void setPlatformInterface(@NonNull AbstractPlatformInterface abstractPlatformInterface) {
        this.mPlatformInterface = abstractPlatformInterface;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean initBL() {
        TraceUtils.alwaysTraceBegin("load BL Library");
        System.loadLibrary("GPlatformInterface");
        System.loadLibrary("base_utils");
        System.loadLibrary("GComm3rd");
        System.loadLibrary("GNet");
        System.loadLibrary("GNaviDice");
        System.loadLibrary("Gbl");
        TraceUtils.alwaysTraceEnd();
        checkCondition();
        CalibrationVersionChecker.checkAndRemoveOldBlDataFile();
        String bLLogRootPath = RootUtil.getBLLogRootPath();
        BaseInitParam baseInitParam = new BaseInitParam();
        baseInitParam.logPath = bLLogRootPath;
        UserLogControl userLogControl = UserLogControl.INSTANCE;
        baseInitParam.logLevel = UserLogControl.getBLLogLevel();
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_BL_LOG_IS_SYNC, DebugCacheConsts.DEFAULT_VALUE_CACHE_BL_LOG_IS_SYNC);
        baseInitParam.async = !z;
        L.i(sTAG, "bl log is sync:" + z);
        baseInitParam.groupMask = ALCGroup.GROUP_MASK_ALL;
        baseInitParam.setIPlatformInterface(this.mPlatformInterface);
        baseInitParam.restConfigPath = RootUtil.SD_CARD_NAVI_PATH;
        if (DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_FUCTION_ACCOUNT_SERVICE_ENV, 3) == 3) {
            if (L.ENABLE) {
                L.d(sTAG, "bindmap open prd_env");
            }
            baseInitParam.serverType = 0;
            baseInitParam.restKey = RootUtil.AOS_PRODUCT_REST_KEY;
            baseInitParam.restSecurityCode = RootUtil.AOS_PRODUCT_REST_SECURITY_CODE;
        } else {
            if (L.ENABLE) {
                L.d(sTAG, "bindmap open dev_env");
            }
            baseInitParam.serverType = 1;
            baseInitParam.restKey = RootUtil.AOS_DEVELOP_REST_KEY;
            baseInitParam.restSecurityCode = RootUtil.AOS_DEVELOP_REST_SECURITY_CODE;
        }
        if (L.ENABLE) {
            int i = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_FUCTION_ACCOUNT_SERVICE_ENV, 3);
            int i2 = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_FUCTION_CHARGE_SERVICE_ENV, 3);
            int i3 = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_FUCTION_ASSISTANT_SERVICE_ENV, 3);
            int i4 = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_FUCTION_BIZ_SERVICE_ENV, 3);
            int i5 = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_MAP_SERVER_SERVICE_ENV, 3);
            String str = "Bl server env = " + getCurrentServerEnv(i) + "\r\n envCharge server:" + getCurrentServerEnv(i2) + "\r\nenvAss server:" + getCurrentServerEnv(i3) + "\r\n wechat qrcode server:" + getCurrentServerEnv(i4) + "\r\n xpmap server" + getCurrentServerEnv(i5);
            L.d(sTAG, "bindmap current init env \r\n" + str);
        }
        baseInitParam.aosDBPath = RootUtil.SD_CARD_NAVI_PATH;
        baseInitParam.recordCacheMaxFileSize = NavCoreUtil.BL_LOG_MAX_FILE_SIZE;
        baseInitParam.recordCacheMaxFiles = 200L;
        baseInitParam.bLogcat = false;
        int initBaseLibs = ServiceMgr.getServiceMgrInstance().initBaseLibs(baseInitParam);
        L.i(sTAG, "initBaseLibs = " + initBaseLibs);
        if (103 == initBaseLibs || 102 == initBaseLibs || -1 == initBaseLibs) {
            FileUtil.deleteDir(new File(RootUtil.SD_CARD_NAVI_PATH));
            RootUtil.delayExitApp(RootUtil.KILL_NAVI_BL_INIT_ERROR);
            return false;
        }
        ActivateManager.getInstance().startCheckActivateAsync();
        BLInitParam bLInitParam = new BLInitParam();
        bLInitParam.dataPath.cfgFilePath = RootUtil.SD_CARD_NAVI_PATH;
        bLInitParam.dataPath.offlinePath = RootUtil.DIR_OFFLINE_RELATIVE_PATH;
        bLInitParam.dataPath.off3DDataPath = RootUtil.DIR_OFFLINE_RELATIVE_PATH;
        bLInitParam.dataPath.onlinePath = RootUtil.SD_CARD_ONLINEPATH;
        bLInitParam.dataPath.lndsOfflinePath = RootUtil.LAN_DIR_OFFLINE_LANE_DATA_PATH;
        L.i(sTAG, "offlinePath: " + bLInitParam.dataPath.offlinePath);
        L.i(sTAG, "cfgFilePath: " + bLInitParam.dataPath.cfgFilePath);
        L.i(sTAG, "off3DDataPath: " + bLInitParam.dataPath.off3DDataPath);
        L.i(sTAG, "onlinePath: " + bLInitParam.dataPath.onlinePath);
        L.i(sTAG, "lndsOfflinePath: " + bLInitParam.dataPath.lndsOfflinePath);
        File file = new File(bLInitParam.dataPath.offlinePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(bLInitParam.dataPath.onlinePath);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        int initBL = ServiceMgr.getServiceMgrInstance().initBL(bLInitParam, this.mContext);
        L.i(sTAG, "initBL = " + initBL);
        if (103 == initBL || 200 == initBL) {
            FileUtil.deleteDir(new File(RootUtil.SD_CARD_NAVI_PATH));
            RootUtil.delayExitApp(RootUtil.KILL_NAVI_BL_INIT_ERROR);
            return false;
        } else if (initBL != 0) {
            return false;
        } else {
            BLMsgPushServiceWrapper.getInstance().initMsgPushService();
            return true;
        }
    }

    final void deInitBL() {
        ServiceMgr.getServiceMgrInstance().unInitBaseLibs();
        ServiceMgr.getServiceMgrInstance().unInitBL();
        BLMsgPushServiceWrapper.getInstance().stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void initNetworkReceiver() {
        checkCondition();
        if (this.mNetworkReceiver == null) {
            this.mNetworkReceiver = new NetworkChangedReceiver();
            XPNetworkManager.INSTANCE.getConnectivityManager().registerDefaultNetworkCallback(this.mNetworkReceiver);
            L.i(sTAG, "do initNetworkReceiver!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void updateBLNetworkStatus() {
        checkCondition();
        if (this.mIXPNetworkListener == null) {
            this.mIXPNetworkListener = new IXPNetworkListener() { // from class: com.xiaopeng.montecarlo.-$$Lambda$AbstractApplicationInitializer$tS9fnBDizcn8k4OsrVrfAVlvJ0w
                @Override // com.xiaopeng.montecarlo.root.network.IXPNetworkListener
                public final void onNetworkChanged(XPNetworkManager.XPNetworkType xPNetworkType, boolean z) {
                    AbstractApplicationInitializer.lambda$updateBLNetworkStatus$0(xPNetworkType, z);
                }
            };
            XPNetworkManager.INSTANCE.addNetworkListener(this.mIXPNetworkListener);
        }
        int bLNetworkStatus = CommonUtil.getBLNetworkStatus(XPNetworkManager.INSTANCE.getNetworkType(), XPNetworkManager.INSTANCE.isNetworkConnected());
        L.Tag tag = sTAG;
        L.i(tag, "Do updateBLNetworkStatus:" + bLNetworkStatus);
        TBTManager.getInstance().updateNetworkStatus(bLNetworkStatus);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$updateBLNetworkStatus$0(XPNetworkManager.XPNetworkType xPNetworkType, boolean z) {
        int bLNetworkStatus = CommonUtil.getBLNetworkStatus(xPNetworkType, z);
        L.Tag tag = sTAG;
        L.i(tag, "do updateBLNetworkStatus onNetworkChanged :" + bLNetworkStatus);
        TBTManager.getInstance().updateNetworkStatus(bLNetworkStatus);
    }

    final void deInitNetworkReceiver() {
        if (this.mNetworkReceiver != null) {
            XPNetworkManager.INSTANCE.getConnectivityManager().unregisterNetworkCallback(this.mNetworkReceiver);
            this.mNetworkReceiver = null;
            L.i(sTAG, "do deInitNetworkReceiver!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void initBugHunter() {
        BugHunter.init(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void checkAndCloseLogs() {
        int i = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.KEY_NAVI_REBOOT_DR_MODE, 0);
        L.Tag tag = sTAG;
        L.i(tag, "reboot mode is : " + i);
        if (2 == i) {
            LogHelper.clearAllLog(false);
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_NAVI_REBOOT_DR_MODE, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void initXPModule(Application application) {
        TraceUtils.alwaysTraceBegin("Application_init_NetworkUtil");
        HttpClientManager.getInstance().init(application);
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_init_IpcModuleEntry");
        Module.register(IpcModuleEntry.class, new IpcModuleEntry(application));
        ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).init();
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_init_ConfigurationModuleEntry");
        ConfigurationModuleManager.getInstance().init(application);
        TraceUtils.alwaysTraceEnd();
    }

    final void deInitRootUtil() {
        RootUtil.setLeftPanelWidth(0);
        RootUtil.setLeftPanelHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void initChargeDB() {
        DatabaseManager.getInstance().init(ContextUtils.getContext());
    }

    final void deInitChargeDB() {
        DatabaseManager.getInstance().close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void initPowerDisEnergy() {
        PowerDistanceManager.getInstance().init(this.mContext);
    }

    final void deInitPowerDisEnergy() {
        PowerDistanceManager.getInstance().close();
    }

    final void deInitAccount() {
        AccountManager.getInstance().unInit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void onTerminate() {
        deInitRootUtil();
        WorkThreadUtil.getInstance().release();
        deInitNetworkReceiver();
        deInitSelf();
        deInitSpeech();
        deInitChargeDB();
        deInitPowerDisEnergy();
        SearchSceneDataHelper.release();
        LogHelper.getInstance().release();
        deInitThemeWatcher();
        AudioUtil.getInstance().release();
        ActivityLifecycleHelper.getInstance().deInit(this.mContext);
        deInitAccount();
        CarServiceManager.getInstance().release();
        SrCarServiceManager.getInstance().release();
        deInitXUIService();
        EHPServiceManager.getInstance().uninit();
        SRNaviManager.getInstance().unInit();
        deInitVui();
        deInitXPOfflineData();
        deInitBL();
    }

    private void deInitXPOfflineData() {
        XPOfflineDataManager.getInstance().destroy();
    }

    private void deInitVui() {
        VuiEngine.getInstance(this.mContext).unSubscribe();
    }

    private void deInitThemeWatcher() {
        ThemeWatcherUtil.release(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ICarService getCarService() {
        return new MockCarService();
    }

    protected void checkCondition() {
        if (this.mContext == null || this.mPlatformInterface == null) {
            throw new IllegalArgumentException("This no application context and platform interface for AbstractApplicationInitializer");
        }
    }

    public void initThemeWatcher(Application application) {
        if (L.ENABLE) {
            L.d(sTAG, L.formatDayNightSwitchLog("initThemeWatcher"));
        }
        ThemeWatcherUtil.init(application);
    }

    public void initXui(Application application) {
        Xui.init(application);
        Xui.setFontScaleDynamicChangeEnable(true);
    }

    public void deInitXUIService() {
        XUIServiceManager.getInstance().unInit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum PackageType {
        MONTECALO("com.xiaopeng.montecarlo", "com.xiaopeng.montecarlo.BenchApplicationInitializer", "com.xiaopeng.montecarlo.BenchPlatformInterface"),
        MONTECALO_TABLET("com.xiaopeng.montecarlo.tablet", "com.xiaopeng.montecarlo.TabletApplicationInitializer", "com.xiaopeng.montecarlo.TabletPlatformInterface");
        
        private String mInitializerName;
        private String mInterfaceName;
        private String mPackageName;

        PackageType(String str, String str2, String str3) {
            this.mPackageName = str;
            this.mInitializerName = str2;
            this.mInterfaceName = str3;
        }

        public static PackageType getCurrentPackageType(Application application) {
            PackageType[] values;
            try {
                String str = application.getPackageManager().getPackageInfo(application.getPackageName(), 0).packageName;
                for (PackageType packageType : values()) {
                    if (packageType.getPackageName().equals(str)) {
                        return packageType;
                    }
                }
                return null;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                L.e(AbstractApplicationInitializer.sTAG, e.getMessage());
                return null;
            }
        }

        public String getPackageName() {
            return this.mPackageName;
        }

        public String getInitializerName() {
            return this.mInitializerName;
        }

        public String getInterfaceName() {
            return this.mInterfaceName;
        }
    }
}
