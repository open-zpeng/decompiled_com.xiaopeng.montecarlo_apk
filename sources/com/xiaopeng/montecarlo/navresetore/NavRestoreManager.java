package com.xiaopeng.montecarlo.navresetore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.InitializerManager;
import com.xiaopeng.montecarlo.account.AccountManager;
import com.xiaopeng.montecarlo.aimessage.AiMsgManager;
import com.xiaopeng.montecarlo.aimessage.AiMsgUtils;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.events.RestoreNaviEvent;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.bean.CityDataBean;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.tts.TTSProxy;
import com.xiaopeng.montecarlo.navcore.util.UserLogControl;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.DebugCacheConsts;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import com.xiaopeng.montecarlo.root.util.ioutil.FileIOUtil;
import com.xiaopeng.montecarlo.root.util.logcat.LogHelper;
import com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer;
import com.xiaopeng.montecarlo.stat.MapOpStatUtil;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class NavRestoreManager implements CarServiceManager.IXPCarStateListener, AiMsgManager.MsgListener {
    private static final int NAVI_RESTORE_DIRECTLY = 0;
    private static final int NAVI_RESTORE_WITH_ASK = 1;
    private static final int NAV_DEBUG_POWER_ON_OFF_INTERVAL_TIME = 5000;
    public static final int NAV_LEFT_DISTANCE_100KM = 100000;
    public static final int NAV_LEFT_DISTANCE_1KM = 1000;
    private static final int NAV_POWER_ON_OFF_INTERVAL_TIME = 300000;
    private static final int NAV_REBOOT_TIME = 600;
    public static final String NAV_RESTORE_FILE_NAME = "nav_restore_file";
    public static final long SILENCE_TIME_SPAN_12H = 43200000;
    public static final long SILENCE_TIME_SPAN_3H = 10800000;
    public static final long SILENCE_TIME_SPAN_90MIN = 5400000;
    public static final long WAKELOCK_TIMEOUT_10SEC = 10000;
    private AiMsgManager mAiMsgManager;
    private MainContext mMainContext;
    private Disposable mNavRebootDisposable;
    private PowerOnNavStatusListener mNavStatusListener;
    private int mSeatStatus;
    private XCountDownTimer mTimer;
    private static final L.Tag TAG = new L.Tag("NavRestoreManager");
    private static final NavRestoreManager sInstance = new NavRestoreManager();
    private final List<NavRestoreListener> mNavRestoreListeners = new CopyOnWriteArrayList();
    private long mLastPowerOffTime = 0;
    private boolean mAiMsgShownFromPowerOn = false;
    private boolean mIsInPowerCycle = false;
    private volatile boolean mIsPowerOn = false;
    private int mLocalIgStatus = -1;
    private PublishSubject mNavRebootSubject = PublishSubject.create();
    private RestoreNaviEvent mBackUpRestoreNaviEvent = null;
    private int mLastNaviRestoreAction = -1;
    private XCountDownTimer.ITimerCallback mTimerCallback = new XCountDownTimer.ITimerCallback() { // from class: com.xiaopeng.montecarlo.navresetore.NavRestoreManager.1
        @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
        public void onTick(long j) {
        }

        @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
        public void onTimeOut() {
            L.i(NavRestoreManager.TAG, ">>> onTimeOut");
            NavRestoreManager.this.powerOff();
        }
    };

    /* loaded from: classes3.dex */
    public interface CheckRestoreCallback {
        void restoreNavImmediate(RouteParams routeParams);

        void restoreNavLater();

        void restoreNone();
    }

    /* loaded from: classes3.dex */
    public interface NavRestoreListener {
        void onNavRestore(RestoreNaviEvent restoreNaviEvent);
    }

    /* loaded from: classes3.dex */
    public interface PowerOnNavStatusListener {
        void onNavStatus(boolean z);
    }

    @Override // com.xiaopeng.montecarlo.aimessage.AiMsgManager.MsgListener
    public String getName() {
        return "NavRestoreManager";
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onDrivingModeChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnduranceMileageModeChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onEnergyRecycleLevelChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onGearLevelChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onHVACPowerModeChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmConnectionStateChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapDisplayStateChange(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapFpsChange(int i) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIcmMapSizeChange(int i, int i2) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onImuNavDataChange(float[] fArr) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onRawCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onScuCarSpeedChange(float f) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onXPolitDriveModeStatusChange(CarServiceManager.XPolitDriveMode xPolitDriveMode) {
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onXpuNedcStatusChange(int i) {
    }

    public static NavRestoreManager getInstance() {
        return sInstance;
    }

    public static boolean isRestoreExplore(boolean z) {
        boolean z2 = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.KEY_NAVIGATION_STATUS, 1) == 2;
        return z ? z2 : z2 && DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_RESTORE_EXPLORE_STATUS, false);
    }

    public void init() {
        this.mLocalIgStatus = CarServiceManager.getInstance().getIgStatus();
        this.mLastPowerOffTime = DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.KEY_POWER_OFF_LAST_TIME_STAMP, 0L);
        this.mAiMsgManager = new AiMsgManager();
        if (isEnableRelaunchNavi()) {
            this.mNavRebootDisposable = subscribeSubject(this.mNavRebootSubject, 600L);
        }
        if (!RootUtil.isUserVersion() && DebugConfiguration.Debug.DEBUG_RECEIVER) {
            test();
        }
        if (this.mLocalIgStatus < 0) {
            L.w(TAG, "init !  but get ig status failed");
        } else {
            L.Tag tag = TAG;
            L.i(tag, "init !  current ig status is: " + this.mLocalIgStatus);
        }
        this.mTimer = new XCountDownTimer(CityDataBean.UNZIPPING_BLOCKING_TIME, this.mTimerCallback);
        CarServiceManager.getInstance().addCarStateListener(this);
    }

    private boolean isEnableRelaunchNavi() {
        return DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_RELAUNCH_NAVI, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_RELAUNCH_NAVI);
    }

    private Disposable subscribeSubject(Subject subject, long j) {
        if (L.ENABLE) {
            L.d(TAG, "init reboot disposable");
        }
        return subject.debounce(j, TimeUnit.SECONDS).subscribeOn(Schedulers.computation()).subscribe(new Consumer<Runnable>() { // from class: com.xiaopeng.montecarlo.navresetore.NavRestoreManager.2
            @Override // io.reactivex.functions.Consumer
            public void accept(Runnable runnable) throws Exception {
                if (L.ENABLE) {
                    L.d(NavRestoreManager.TAG, "ready to run");
                }
                runnable.run();
            }
        });
    }

    private void test() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DebugConfiguration.RegisterAction.AI_MSG_SHOWN_TEST_ACTION);
        ContextUtils.getContext().registerReceiver(new BroadcastReceiver() { // from class: com.xiaopeng.montecarlo.navresetore.NavRestoreManager.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                L.Tag tag = NavRestoreManager.TAG;
                L.i(tag, "test Receiver: " + intent.getAction() + ", mLocalIgStatus: " + NavRestoreManager.this.mLocalIgStatus);
                if (intent.getAction().equals(DebugConfiguration.RegisterAction.AI_MSG_SHOWN_TEST_ACTION)) {
                    NavRestoreManager.this.setAiMsgShownFromPowerOn(true);
                }
            }
        }, intentFilter);
    }

    @Override // com.xiaopeng.montecarlo.aimessage.AiMsgManager.MsgListener
    public void onReceive(@NonNull AiMsgManager.IpcMessage ipcMessage) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onReceive if car state: ");
            sb.append(ipcMessage.getIntValue() == 1);
            L.d(tag, sb.toString());
        }
        if (AiMsgUtils.isCarStateGetOnMsg(ipcMessage)) {
            L.Tag tag2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("last navi action: ");
            sb2.append(this.mLastNaviRestoreAction);
            sb2.append(", is restore home/company recommendation: ");
            sb2.append(!this.mAiMsgShownFromPowerOn);
            L.i(tag2, sb2.toString());
            int i = this.mLastNaviRestoreAction;
            if (i == 1) {
                notifyRestoreAction(new RestoreNaviEvent.Builder(1).setNeedConfirm(true).setRestoreRouteParams(getRestoreRouteParams()).build());
                removeRestoreParam();
            } else if (i < 0) {
                notifyRestoreAction(2);
            }
            this.mLastNaviRestoreAction = -1;
        }
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onIgStatusChange(int i) {
        int driveSeatState = CarServiceManager.getInstance().getDriveSeatState();
        L.Tag tag = TAG;
        L.i(tag, "received ig status change: " + i + ", seat status: " + driveSeatState);
        if (i == 0) {
            onPowerOff(driveSeatState);
        } else if (1 == i) {
            onPowerOn(driveSeatState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void powerOff() {
        int i;
        String name;
        TTSProxy.getInstance().setTtsEnable(false);
        this.mLocalIgStatus = 0;
        setLastPowerOffTime(System.currentTimeMillis());
        this.mIsPowerOn = false;
        this.mIsInPowerCycle = false;
        this.mLastNaviRestoreAction = -1;
        MapDataManager.getInstance().outputDataVersion();
        if (MapDataManager.getInstance().hasDataBlockedInUnzipping()) {
            RootUtil.delayExitApp(RootUtil.KILL_NAVI_OFFLINE_DATA_BLOCK_IN_UNZIP);
        }
        uploadAccountData();
        if (isEnableRelaunchNavi()) {
            Disposable disposable = this.mNavRebootDisposable;
            if (disposable == null || disposable.isDisposed()) {
                this.mNavRebootDisposable = subscribeSubject(this.mNavRebootSubject, 600L);
            }
            PublishSubject publishSubject = this.mNavRebootSubject;
            if (publishSubject != null) {
                publishSubject.onNext(new Runnable() { // from class: com.xiaopeng.montecarlo.navresetore.NavRestoreManager.4
                    @Override // java.lang.Runnable
                    public void run() {
                        L.Tag tag = NavRestoreManager.TAG;
                        L.i(tag, "power off handle, mIsPowerOn = " + NavRestoreManager.this.mIsPowerOn);
                        if (!NavRestoreManager.this.mIsPowerOn && RootUtil.isUserVersion() && RootUtil.isOpenNaviLogIn131()) {
                            LogHelper.clearBLUselessLogFile();
                        }
                    }
                });
            }
        }
        if (TBTManager.getInstance().isInit()) {
            if (this.mSeatStatus == 0) {
                i = 3;
                notifyRestoreAction(4);
            } else {
                i = 4;
            }
            XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentNaviId());
            int currentStatus = TBTManager.getInstance().getCurrentStatus();
            if (currentStatus != 0) {
                int i2 = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.ROUTE_HISTROY_DISTANCE_KEY, 0);
                double d = DataSetHelper.GlobalSet.getDouble(DataSetHelper.GlobalSet.ROUTE_HISTORY_LINEAR_DISTANCE_KEY, 0.0d);
                RouteParams restoreRouteParams = TBTManager.getInstance().getRestoreRouteParams();
                boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.KEY_IS_RESTORE_EXPLORE_STATUS, false);
                L.Tag tag = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("screen off ==> tbt routeParams: ");
                if (restoreRouteParams == null) {
                    name = "null";
                } else {
                    name = restoreRouteParams.mEndInfo == null ? "" : restoreRouteParams.mEndInfo.getName();
                }
                sb.append(name);
                sb.append(", lastLeftDistance: ");
                sb.append(i2);
                sb.append(", lastLinearDistance: ");
                sb.append(d);
                sb.append(", currentNaviStatus: ");
                sb.append(currentStatus);
                sb.append(", isRestoreExplore: ");
                sb.append(z);
                L.i(tag, sb.toString());
                if (d > 1000.0d && (currentStatus == 1 || z)) {
                    saveRestoreParam(restoreRouteParams, i2);
                    i--;
                }
                notifyRestoreAction(0);
                i--;
            }
            int i3 = i;
            InitializerManager.getInstance().setInApplicationRestore(false);
            MapOpStatUtil.sendStatDataForPowOff(this.mMainContext, i3, endInfo != null ? endInfo.getDisplayLon() : 0.0d, endInfo != null ? endInfo.getDisplayLat() : 0.0d);
        }
    }

    private void onPowerOff(int i) {
        if (this.mLocalIgStatus == 0) {
            if (L.ENABLE) {
                L.d(TAG, "ignore repeated pm status change");
                return;
            }
            return;
        }
        L.i(TAG, "onPowerOff perpare lock");
        UserLogControl.INSTANCE.checkAndRebootNavi();
        if (ContextUtils.getContext() != null) {
            PowerManager.WakeLock newWakeLock = ((PowerManager) ContextUtils.getContext().getSystemService("power")).newWakeLock(1, ContextUtils.getContext().getPackageName());
            L.i(TAG, "onPowerOff start lock");
            newWakeLock.acquire(WAKELOCK_TIMEOUT_10SEC);
            this.mSeatStatus = i;
            powerOff();
            newWakeLock.release();
            L.i(TAG, "onPowerOff release lock");
        }
    }

    private void onPowerOn(int i) {
        this.mLastPowerOffTime = getLastPowerOffTime();
        this.mTimer.stop();
        LogHelper.getInstance().checkLogDiskSize(true);
        UserLogControl.INSTANCE.checkAndReportLogStatus();
        TTSProxy.getInstance().setTtsEnable(true);
        if (0 == this.mLastPowerOffTime) {
            L.i(TAG, "ignore power on by reboot.");
        } else if (this.mLocalIgStatus == 1) {
        } else {
            this.mLocalIgStatus = 1;
            this.mIsPowerOn = true;
            if (isEnableRelaunchNavi() && this.mNavRebootDisposable != null) {
                if (L.ENABLE) {
                    L.d(TAG, "cancel reboot");
                }
                this.mNavRebootDisposable.dispose();
                this.mNavRebootDisposable = subscribeSubject(this.mNavRebootSubject, 600L);
            }
            this.mIsInPowerCycle = true;
            this.mAiMsgShownFromPowerOn = false;
            long currentTimeMillis = System.currentTimeMillis() - this.mLastPowerOffTime;
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "seatStatus: " + i + ", last power off time: " + TimeFormatUtil.formatTime(this.mLastPowerOffTime) + ", timeSpan: " + ((((float) currentTimeMillis) * 1.0f) / 60000.0f) + " min");
            }
            MapOpStatUtil.sendStatDataForPowOn(this.mMainContext);
            notifyRestoreAction(4);
            checkRestoreNavi(i, currentTimeMillis);
            if (currentTimeMillis >= SILENCE_TIME_SPAN_90MIN) {
                AccountManager.getInstance().getAccountSyncSession().startSync(55);
            }
            notifyRestoreAction(5);
            notifyRestoreAction(3);
            uploadAccountData();
        }
    }

    private void checkRestoreNavi(int i, long j) {
        String name;
        if (!TBTManager.getInstance().isInit()) {
            L.w(TAG, "TBTManager has not init");
            return;
        }
        boolean z = false;
        boolean z2 = true;
        if (i == 0) {
            RouteParams restoreRouteParams = getRestoreRouteParams();
            int i2 = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.KEY_ROUTE_LAST_DISTANCE, 0);
            double d = DataSetHelper.GlobalSet.getDouble(DataSetHelper.GlobalSet.KEY_ROUTE_LAST_LINEAR_DISTANCE, 0.0d);
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("screen on ==> tbt routeParams: ");
            if (restoreRouteParams == null) {
                name = "null";
            } else {
                name = restoreRouteParams.mEndInfo == null ? "" : restoreRouteParams.mEndInfo.getName();
            }
            sb.append(name);
            sb.append(", lastLeftDistance: ");
            sb.append(i2);
            sb.append(", lastLinearDistance: ");
            sb.append(d);
            sb.append("timespan");
            sb.append(j);
            L.i(tag, sb.toString());
            if (d > 1000.0d) {
                if (j <= SILENCE_TIME_SPAN_90MIN) {
                    this.mLastNaviRestoreAction = 0;
                    RestoreNaviEvent build = new RestoreNaviEvent.Builder(1).setNeedConfirm(false).setRestoreRouteParams(restoreRouteParams).build();
                    if (!notifyRestoreAction(build)) {
                        this.mBackUpRestoreNaviEvent = build;
                        TBTManager.getInstance().setRestoreRouteParams(restoreRouteParams);
                    }
                    z = true;
                } else if ((d < 100000.0d && j < SILENCE_TIME_SPAN_3H) || (d >= 100000.0d && j < SILENCE_TIME_SPAN_12H)) {
                    this.mLastNaviRestoreAction = 1;
                    z2 = false;
                    z = true;
                } else {
                    L.i(TAG, "reset user sr settings");
                    SettingWrapper.setCanAutoEnterSRWhenEnterHDArea(false);
                    SettingWrapper.setFirstTimeUserEnterSR(true);
                    SettingWrapper.setNeedBroadEnterLaneWhenExitNgp(true);
                }
            }
        }
        if (z2) {
            removeRestoreParam();
        }
        PowerOnNavStatusListener powerOnNavStatusListener = this.mNavStatusListener;
        if (powerOnNavStatusListener != null) {
            powerOnNavStatusListener.onNavStatus(z);
        }
    }

    private void uploadAccountData() {
        L.i(TAG, "uploadAccountData TYPE_XP_UPLOAD_IF_FAIL");
        AccountManager.getInstance().getAccountSyncSession().startSync(3);
    }

    @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
    public void onBCMDriveSeatStateChange(int i) {
        AiMsgManager aiMsgManager;
        L.Tag tag = TAG;
        L.i(tag, "onBCMDriveSeatStateChange: " + i + ",mIsInPowerCycle: " + this.mIsInPowerCycle);
        if (!this.mIsInPowerCycle || i != 1 || (aiMsgManager = this.mAiMsgManager) == null || this.mLastNaviRestoreAction == 0) {
            return;
        }
        aiMsgManager.requestCarState(this);
        this.mIsInPowerCycle = false;
    }

    public long getLastPowerOffTime() {
        if (this.mLastPowerOffTime <= 0) {
            this.mLastPowerOffTime = DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.KEY_POWER_OFF_LAST_TIME_STAMP, 0L);
        }
        return this.mLastPowerOffTime;
    }

    private void setLastPowerOffTime(long j) {
        this.mLastPowerOffTime = j;
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_POWER_OFF_LAST_TIME_STAMP, this.mLastPowerOffTime);
    }

    public void setNavStatusListener(PowerOnNavStatusListener powerOnNavStatusListener) {
        this.mNavStatusListener = powerOnNavStatusListener;
    }

    public void removeNavStatusListener() {
        this.mNavStatusListener = null;
    }

    public void addRestoreListener(NavRestoreListener navRestoreListener) {
        if (navRestoreListener == null || this.mNavRestoreListeners.contains(navRestoreListener)) {
            return;
        }
        this.mNavRestoreListeners.add(navRestoreListener);
    }

    public void removeRestoreListener(NavRestoreListener navRestoreListener) {
        this.mNavRestoreListeners.remove(navRestoreListener);
    }

    private void notifyRestoreAction(int i) {
        L.Tag tag = TAG;
        L.i(tag, "action: " + i);
        if (this.mNavRestoreListeners.size() > 0) {
            for (NavRestoreListener navRestoreListener : this.mNavRestoreListeners) {
                navRestoreListener.onNavRestore(new RestoreNaviEvent.Builder(i).build());
            }
        }
    }

    private boolean notifyRestoreAction(RestoreNaviEvent restoreNaviEvent) {
        L.Tag tag = TAG;
        L.i(tag, "action: " + restoreNaviEvent.getAction());
        if (this.mNavRestoreListeners.size() == 0) {
            L.w(TAG, "no activity");
            return false;
        } else if (this.mNavRestoreListeners.size() > 0) {
            for (NavRestoreListener navRestoreListener : this.mNavRestoreListeners) {
                navRestoreListener.onNavRestore(restoreNaviEvent);
            }
            return true;
        } else {
            return true;
        }
    }

    public boolean isAiMsgShownFromPowerOn() {
        return this.mAiMsgShownFromPowerOn;
    }

    public void setAiMsgShownFromPowerOn(boolean z) {
        if (1 == CarServiceManager.getInstance().getIgStatus()) {
            L.i(TAG, "AI msg shown");
            this.mAiMsgShownFromPowerOn = true;
        }
    }

    public void setMainContext(MainContext mainContext) {
        this.mMainContext = mainContext;
    }

    public void releaseMainContext() {
        this.mMainContext = null;
    }

    public RestoreNaviEvent getRestoreNaviEvent() {
        return this.mBackUpRestoreNaviEvent;
    }

    public void clearNavRestoreEvent() {
        this.mBackUpRestoreNaviEvent = null;
    }

    private void saveRestoreParam(RouteParams routeParams, long j) {
        if (routeParams != null && routeParams.mEndInfo != null) {
            new FileIOUtil().writeObject2SDCard(RootUtil.SD_CARD_DIR_GUIDE, NAV_RESTORE_FILE_NAME, routeParams);
        }
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_ROUTE_LAST_DISTANCE, j);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_ROUTE_LAST_LINEAR_DISTANCE, LocationUtils.getLinearDistance(routeParams));
    }

    private void removeRestoreParam() {
        if (RootUtil.isSdcardExist()) {
            File file = new File(RootUtil.SD_CARD_DIR_GUIDE, NAV_RESTORE_FILE_NAME);
            if (file.exists()) {
                file.delete();
            }
        }
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_ROUTE_LAST_DISTANCE, 0);
    }

    private RouteParams getRestoreRouteParams() {
        FileIOUtil fileIOUtil = new FileIOUtil();
        return (RouteParams) fileIOUtil.readObjectFromSDCard(RootUtil.SD_CARD_DIR_GUIDE + NAV_RESTORE_FILE_NAME);
    }
}
