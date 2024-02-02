package com.xiaopeng.montecarlo.navcore.search.offlinedata;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.database.CPDataHelper;
import com.xiaopeng.montecarlo.navcore.database.KeywordDataHelper;
import com.xiaopeng.montecarlo.navcore.database.LccGeoFenceDataHelper;
import com.xiaopeng.montecarlo.navcore.database.ScratchSpotDataHelper;
import com.xiaopeng.montecarlo.navcore.database.ServiceCenterDataHelper;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.XPKeywordConfigInfo;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.util.CommonUtil;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.network.IXPNetworkListener;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class XPOfflineDataManager {
    private static final int RETRY_TIME_INTERVAL = 30000;
    private static final int TIME_OUT = 60000;
    private static final L.Tag TAG = new L.Tag("XPOfflineDataManager");
    private static volatile XPOfflineDataManager sInstance = new XPOfflineDataManager();
    private List<XPOfflineDataInitTask> mInitTasks = new CopyOnWriteArrayList();
    private Disposable mDisposable = null;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable mRetryRunnable = new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.search.offlinedata.XPOfflineDataManager.1
        @Override // java.lang.Runnable
        public void run() {
            if (CollectionUtils.isNotEmpty(XPOfflineDataManager.this.mInitTasks)) {
                XPOfflineDataManager.this.startInitTask();
            }
        }
    };
    private final IXPNetworkListener mNetworkListener = new IXPNetworkListener() { // from class: com.xiaopeng.montecarlo.navcore.search.offlinedata.XPOfflineDataManager.2
        @Override // com.xiaopeng.montecarlo.root.network.IXPNetworkListener
        public void onNetworkChanged(XPNetworkManager.XPNetworkType xPNetworkType, boolean z) {
            if (z && XPOfflineDataManager.this.mService != null && XPOfflineDataManager.this.mService.getCurrentVersion() == 0) {
                L.i(XPOfflineDataManager.TAG, "onNetworkChanged:6");
                XPOfflineDataManager.this.initDataOnce(6);
                XPNetworkManager.INSTANCE.removeNetworkListener(this);
            }
        }
    };
    private CarServiceManager.IXPCarStateListener mXPCarStateListener = new CarServiceManager.IXPCarStateListener() { // from class: com.xiaopeng.montecarlo.navcore.search.offlinedata.XPOfflineDataManager.3
        @Override // com.xiaopeng.montecarlo.root.carservice.CarServiceManager.IXPCarStateListener
        public void onIgStatusChange(int i) {
            if (L.ENABLE) {
                L.Tag tag = XPOfflineDataManager.TAG;
                L.d(tag, "onIgStatusChange pmStatus = " + i);
            }
            if (i == 1) {
                XPOfflineDataManager.this.initData();
            }
        }
    };
    private XPOfflineDataService mService = new XPOfflineDataService();

    public static XPOfflineDataManager getInstance() {
        return sInstance;
    }

    private XPOfflineDataManager() {
        registerXPCarStateListener();
        initDataOnce(1);
    }

    public void initData() {
        L.i(TAG, "initData");
        if (!hasTask(1)) {
            this.mInitTasks.add(new XPOfflineDataInitTask(1));
        }
        if (!hasTask(2)) {
            this.mInitTasks.add(new XPOfflineDataInitTask(2));
        }
        if (CommonUtil.isScratchSpotEnable() && !hasTask(3)) {
            this.mInitTasks.add(new XPOfflineDataInitTask(3));
        }
        if (!hasTask(4)) {
            this.mInitTasks.add(new XPOfflineDataInitTask(4));
        }
        if (!hasTask(5)) {
            this.mInitTasks.add(new XPOfflineDataInitTask(5));
        }
        if (CarServiceManager.getInstance().hasXpuForNgp() && !hasTask(6)) {
            this.mInitTasks.add(new XPOfflineDataInitTask(6));
        }
        if (CarFeatureManager.INSTANCE.isLccGeoFenceEnable() && !hasTask(7)) {
            this.mInitTasks.add(new XPOfflineDataInitTask(7));
        }
        this.mHandler.removeCallbacks(this.mRetryRunnable);
        this.mHandler.postDelayed(this.mRetryRunnable, 60000L);
    }

    public void initDataOnce(final int i) {
        L.Tag tag = TAG;
        L.i(tag, "initDataOnce type:" + i);
        if (hasTask(i)) {
            return;
        }
        Observable.create(new ObservableOnSubscribe<Object>() { // from class: com.xiaopeng.montecarlo.navcore.search.offlinedata.XPOfflineDataManager.5
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
                XPOfflineDataManager.this.doInitTask(new XPOfflineDataInitTask(i));
                observableEmitter.onComplete();
            }
        }).timeout(60000L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Object>() { // from class: com.xiaopeng.montecarlo.navcore.search.offlinedata.XPOfflineDataManager.4
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Object obj) {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }
        });
    }

    public void destroy() {
        Disposable disposable = this.mDisposable;
        if (disposable != null) {
            if (!disposable.isDisposed()) {
                this.mDisposable.dispose();
            }
            this.mDisposable = null;
        }
        this.mInitTasks.clear();
        this.mHandler.removeCallbacks(this.mRetryRunnable);
        unregisterXPCarStateListener();
        XPNetworkManager.INSTANCE.removeNetworkListener(this.mNetworkListener);
    }

    public String keyword2Category(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        List<XPKeywordConfigInfo> xPKeywordData = getXPKeywordData();
        if (CollectionUtils.isNotEmpty(xPKeywordData)) {
            for (XPKeywordConfigInfo xPKeywordConfigInfo : xPKeywordData) {
                List<String> keywordList = xPKeywordConfigInfo.getKeywordList();
                if (CollectionUtils.isNotEmpty(keywordList)) {
                    for (String str2 : keywordList) {
                        if (str.equalsIgnoreCase(str2)) {
                            return xPKeywordConfigInfo.getCategory();
                        }
                    }
                    continue;
                }
            }
        }
        return "";
    }

    public List<XPKeywordConfigInfo> getXPKeywordData() {
        return this.mService.getXPKeywordData();
    }

    public void clearKeywordConfigData() {
        if (L.ENABLE) {
            L.d(TAG, "clearKeywordConfigData");
        }
        KeywordDataHelper.clearData();
        SettingWrapper.setKeywordConfigVersion(XPOfflineDataService.DEFAULT_VERSION_ID);
        SettingWrapper.setKeywordConfigUpdateTime(0L);
    }

    public void clearScratchSpotData() {
        if (L.ENABLE) {
            L.d(TAG, "clearScratchSpotData");
        }
        ScratchSpotDataHelper.clearData();
        SettingWrapper.setXPScratchSpotDataVersion(XPOfflineDataService.DEFAULT_VERSION_ID);
        SettingWrapper.setXPScratchSpotUpdateTime(0L);
    }

    public void clearSeamlessData() {
        if (L.ENABLE) {
            L.d(TAG, "clearSeamlessData");
        }
        SettingWrapper.setSeamlessDataVersion(XPOfflineDataService.DEFAULT_VERSION_ID);
        SettingWrapper.setSeamlessUpdateTime(0L);
        SettingWrapper.setSeamlessDataPath("");
    }

    public void clearServiceCenterData() {
        if (L.ENABLE) {
            L.d(TAG, "clearServiceCenterData");
        }
        ServiceCenterDataHelper.clearData();
        SettingWrapper.setXPServiceCenterDataVersion(XPOfflineDataService.DEFAULT_VERSION_ID);
        SettingWrapper.setXPServiceCenterUpdateTime(0L);
    }

    public void clearChargeData() {
        if (L.ENABLE) {
            L.d(TAG, "clearChargeData");
        }
        CPDataHelper.clearData();
        SettingWrapper.setChargeDbVersion(XPOfflineDataService.CHARGE_DEFAULT_VERSION_ID);
        SettingWrapper.setChargeDataUpdateTime(0L);
    }

    public void clearLccGeoFenceData() {
        if (L.ENABLE) {
            L.d(TAG, "clearLccGeoFenceData");
        }
        LccGeoFenceDataHelper.clearData();
        SettingWrapper.setLccGeoFenceDataVersion(0L);
        SettingWrapper.setLccGeoFenceUpdateTime(0L);
    }

    private boolean hasTask(int i) {
        if (CollectionUtils.isNotEmpty(this.mInitTasks)) {
            for (XPOfflineDataInitTask xPOfflineDataInitTask : this.mInitTasks) {
                if (i == xPOfflineDataInitTask.getTaskType()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInitTask() {
        L.Tag tag = TAG;
        L.i(tag, "startInitTask size:" + this.mInitTasks.size());
        Observable.create(new ObservableOnSubscribe<Object>() { // from class: com.xiaopeng.montecarlo.navcore.search.offlinedata.XPOfflineDataManager.7
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
                for (XPOfflineDataInitTask xPOfflineDataInitTask : XPOfflineDataManager.this.mInitTasks) {
                    XPOfflineDataManager.this.doInitTask(xPOfflineDataInitTask);
                }
                observableEmitter.onComplete();
            }
        }).timeout(60000L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Object>() { // from class: com.xiaopeng.montecarlo.navcore.search.offlinedata.XPOfflineDataManager.6
            @Override // io.reactivex.Observer
            public void onNext(Object obj) {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                XPOfflineDataManager.this.mDisposable = disposable;
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                L.Tag tag2 = XPOfflineDataManager.TAG;
                L.w(tag2, "onError " + th.getMessage());
                XPOfflineDataManager.this.handleResult();
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                L.i(XPOfflineDataManager.TAG, "onComplete");
                XPOfflineDataManager.this.handleResult();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInitTask(XPOfflineDataInitTask xPOfflineDataInitTask) {
        xPOfflineDataInitTask.setRemainTryTimes(xPOfflineDataInitTask.getRemainTryTimes() - 1);
        switch (xPOfflineDataInitTask.getTaskType()) {
            case 1:
                if (this.mService.initKeywordConfigData()) {
                    L.i(TAG, "initKeywordConfigData success");
                    xPOfflineDataInitTask.setTaskStatus(0);
                    return;
                }
                L.i(TAG, "initKeywordConfigData fail");
                xPOfflineDataInitTask.setTaskStatus(1);
                return;
            case 2:
                if (this.mService.initXPServiceCenterData()) {
                    L.i(TAG, "initXPServiceCenterData success");
                    xPOfflineDataInitTask.setTaskStatus(0);
                    return;
                }
                L.i(TAG, "initXPServiceCenterData fail");
                xPOfflineDataInitTask.setTaskStatus(1);
                return;
            case 3:
                if (this.mService.initXPScratchSpotData()) {
                    L.i(TAG, "initXPScratchSpotData success");
                    xPOfflineDataInitTask.setTaskStatus(0);
                    return;
                }
                L.i(TAG, "initXPScratchSpotData fail");
                xPOfflineDataInitTask.setTaskStatus(1);
                return;
            case 4:
                if (this.mService.initChargeData()) {
                    L.i(TAG, "initChargeData success");
                    xPOfflineDataInitTask.setTaskStatus(0);
                    return;
                }
                L.i(TAG, "initChargeData fail");
                xPOfflineDataInitTask.setTaskStatus(1);
                return;
            case 5:
                if (this.mService.initSeamlessData()) {
                    L.i(TAG, "initSeamlessData success");
                    xPOfflineDataInitTask.setTaskStatus(0);
                    return;
                }
                L.i(TAG, "initSeamlessData fail");
                xPOfflineDataInitTask.setTaskStatus(1);
                return;
            case 6:
                if (this.mService.initSRCarModelData()) {
                    L.i(TAG, "initSRCarModelData success");
                    xPOfflineDataInitTask.setTaskStatus(0);
                    return;
                }
                L.i(TAG, "initSRCarModelData fail");
                xPOfflineDataInitTask.setTaskStatus(1);
                return;
            case 7:
                if (this.mService.initLccGeoFenceData()) {
                    L.i(TAG, "initLccGeoFenceData success");
                    xPOfflineDataInitTask.setTaskStatus(0);
                    return;
                }
                L.i(TAG, "initLccGeoFenceData fail");
                xPOfflineDataInitTask.setTaskStatus(1);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleResult() {
        if (CollectionUtils.isEmpty(this.mInitTasks)) {
            return;
        }
        ArrayList<XPOfflineDataInitTask> arrayList = new ArrayList();
        for (XPOfflineDataInitTask xPOfflineDataInitTask : this.mInitTasks) {
            if (xPOfflineDataInitTask.getTaskStatus() == 0) {
                L.Tag tag = TAG;
                L.i(tag, "remove success task:" + xPOfflineDataInitTask.getTaskType());
                arrayList.add(xPOfflineDataInitTask);
            } else if (xPOfflineDataInitTask.getRemainTryTimes() <= 0) {
                L.Tag tag2 = TAG;
                L.i(tag2, "remove failed task:" + xPOfflineDataInitTask.getTaskType());
                arrayList.add(xPOfflineDataInitTask);
            }
        }
        for (XPOfflineDataInitTask xPOfflineDataInitTask2 : arrayList) {
            this.mInitTasks.remove(xPOfflineDataInitTask2);
            if (xPOfflineDataInitTask2.getTaskType() == 6) {
                XPNetworkManager.INSTANCE.addNetworkListener(this.mNetworkListener);
            }
        }
        if (CollectionUtils.isNotEmpty(this.mInitTasks)) {
            this.mHandler.removeCallbacks(this.mRetryRunnable);
            this.mHandler.postDelayed(this.mRetryRunnable, 30000L);
        }
    }

    public void registerXPCarStateListener() {
        CarServiceManager.getInstance().addCarStateListener(this.mXPCarStateListener);
    }

    public void unregisterXPCarStateListener() {
        CarServiceManager.getInstance().removeCarStateListener(this.mXPCarStateListener);
    }
}
