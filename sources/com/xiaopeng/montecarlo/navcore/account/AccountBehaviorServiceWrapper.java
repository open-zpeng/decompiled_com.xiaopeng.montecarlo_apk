package com.xiaopeng.montecarlo.navcore.account;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.autonavi.gbl.user.behavior.BehaviorService;
import com.autonavi.gbl.user.behavior.model.BehaviorServiceParam;
import com.autonavi.gbl.user.behavior.model.ConfigKey;
import com.autonavi.gbl.user.behavior.model.ConfigValue;
import com.autonavi.gbl.user.behavior.model.FavoriteBaseItem;
import com.autonavi.gbl.user.behavior.model.FavoriteItem;
import com.autonavi.gbl.user.behavior.model.SimpleFavoriteItem;
import com.autonavi.gbl.user.behavior.observer.IBehaviorServiceObserver;
import com.autonavi.gbl.user.model.UserLoginInfo;
import com.autonavi.gbl.user.syncsdk.SyncSdkService;
import com.autonavi.gbl.user.syncsdk.model.SyncMode;
import com.autonavi.gbl.user.syncsdk.model.SyncSdkServiceParam;
import com.autonavi.gbl.user.syncsdk.observer.ISyncSDKServiceObserver;
import com.autonavi.gbl.user.usertrack.UserTrackService;
import com.autonavi.gbl.user.usertrack.model.GpsTrackPoint;
import com.autonavi.gbl.user.usertrack.model.SearchHistoryItem;
import com.autonavi.gbl.user.usertrack.observer.IGpsInfoGetter;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AccountBehaviorServiceWrapper {
    private volatile BehaviorService mAccountBehaviorService;
    private volatile SyncSdkService mSyncSdkService;
    private volatile UserTrackService mUserTrackService;
    private static final AccountBehaviorServiceWrapper sOurInstance = new AccountBehaviorServiceWrapper();
    @NonNull
    private static final L.Tag TAG = new L.Tag("AccountBeSerWrap");

    private AccountBehaviorServiceWrapper() {
    }

    @NonNull
    public static AccountBehaviorServiceWrapper getInstance() {
        return sOurInstance;
    }

    public BehaviorService getAccountBehaviorService() {
        if (this.mAccountBehaviorService == null) {
            getAccountSyncSdkService();
            initBehaviorService();
        }
        return this.mAccountBehaviorService;
    }

    public SyncSdkService getAccountSyncSdkService() {
        if (this.mSyncSdkService == null) {
            initSyncSdkService();
            BLAccountServiceWrapper.getInstance().getAccountService();
        }
        return this.mSyncSdkService;
    }

    public UserTrackService getAccountUserTrackService() {
        if (this.mUserTrackService == null) {
            initUserTrackService();
        }
        return this.mUserTrackService;
    }

    private void initSyncSdkService() {
        synchronized (this) {
            if (this.mSyncSdkService != null) {
                L.d(TAG, "initSyncSdkService success as mSyncSdkService not null");
                return;
            }
            this.mSyncSdkService = (SyncSdkService) ServiceMgr.getServiceMgrInstance().getBLService(4);
            SyncSdkServiceParam syncSdkServiceParam = new SyncSdkServiceParam();
            syncSdkServiceParam.dataPath = RootUtil.SD_CARD_DIR_ACCOUNT_BEHAVIOR_SERVICE_FILE_PATH;
            File file = new File(syncSdkServiceParam.dataPath);
            if (!file.exists()) {
                boolean mkdirs = file.mkdirs();
                L.Tag tag = TAG;
                L.i(tag, "initSyncSdkService: mkdirs = " + mkdirs);
            }
            int init = this.mSyncSdkService.init(syncSdkServiceParam);
            L.Tag tag2 = TAG;
            L.i(tag2, "initSyncSdkService: init1=" + init);
            int isInit = this.mSyncSdkService.isInit();
            L.Tag tag3 = TAG;
            L.i(tag3, "initSyncSdkService: init2=" + isInit);
            this.mSyncSdkService.addObserver(new DefaultAccountSyncSDKServiceObserver());
        }
    }

    private void initBehaviorService() {
        synchronized (this) {
            if (this.mAccountBehaviorService == null) {
                this.mAccountBehaviorService = (BehaviorService) ServiceMgr.getServiceMgrInstance().getBLService(3);
                int init = this.mAccountBehaviorService.init(new BehaviorServiceParam());
                ConfigValue configValue = new ConfigValue();
                configValue.intValue = 1;
                int config = this.mAccountBehaviorService.setConfig(104, configValue, 1);
                int config2 = this.mAccountBehaviorService.setConfig(ConfigKey.ConfigKeyOftenArrived, configValue, 1);
                this.mAccountBehaviorService.addObserver(new DefaultAccountBehaviorServiceObserver());
                int syncFrequentData = this.mAccountBehaviorService.syncFrequentData();
                L.Tag tag = TAG;
                L.i(tag, "initBehaviorService: init=" + init + "configResult=" + config + "=configResultArr=" + config2 + "=syncResult=" + syncFrequentData + "=value=" + getInstance().getAccountBehaviorService().getConfig(ConfigKey.ConfigKeyOftenArrived).intValue + "=valuefav=" + getInstance().getAccountBehaviorService().getConfig(104).intValue);
            }
        }
    }

    private void initUserTrackService() {
        synchronized (this) {
            if (this.mUserTrackService == null) {
                this.mUserTrackService = (UserTrackService) ServiceMgr.getServiceMgrInstance().getBLService(5);
                int init = this.mUserTrackService.init(new GpsInfoGetterImpl());
                L.Tag tag = TAG;
                L.d(tag, "initUserTrackService: init1=" + init);
                this.mUserTrackService.addObserver(new DefaultAccountUserTrackServiceObserver());
                L.Tag tag2 = TAG;
                L.i(tag2, "initUserTrackService: init2=" + this.mUserTrackService.isInit());
            }
        }
    }

    public void setDefaultConfig() {
        if (L.ENABLE) {
            L.d(TAG, "setDefaultConfig");
        }
        ConfigValue configValue = new ConfigValue();
        configValue.intValue = 0;
        configValue.strArrayValue = null;
        configValue.strArrayValue = null;
        getAccountBehaviorService().setConfig(302, configValue, 1);
    }

    public ConfigValue getConfigByKey(@ConfigKey.ConfigKey1 int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getConfigByKey configKey = [" + i + "]");
        }
        return getAccountBehaviorService().getConfig(i);
    }

    public void setConfig(@Nullable ConfigValue configValue, @SyncMode.SyncMode1 int i) {
        if (configValue == null) {
            configValue = new ConfigValue();
            configValue.intValue = 0;
            configValue.strValue = null;
            configValue.strArrayValue = null;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setConfig value = [" + GsonUtil.toJson(configValue) + "]");
        }
        getAccountBehaviorService().setConfig(608, configValue, i);
    }

    public int setLoginInfo(String str) {
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.userId = str;
        return getAccountBehaviorService().setLoginInfo(userLoginInfo);
    }

    public String addFavorite(@Nullable FavoriteItem favoriteItem, @SyncMode.SyncMode1 int i) {
        if (favoriteItem == null) {
            return "";
        }
        String addFavorite = getAccountBehaviorService().addFavorite(favoriteItem, i);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "addFavorite favoriteItem = [" + GsonUtil.toJson(favoriteItem) + "] return value=" + addFavorite);
        }
        return addFavorite;
    }

    public String updateFavorite(@Nullable FavoriteItem favoriteItem, @SyncMode.SyncMode1 int i) {
        if (favoriteItem == null) {
            return "";
        }
        String updateFavorite = getAccountBehaviorService().updateFavorite(favoriteItem, i);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateFavorite favoriteItem = [" + GsonUtil.toJson(favoriteItem) + "] return value=" + updateFavorite);
        }
        return updateFavorite;
    }

    public String delFavorite(@Nullable FavoriteBaseItem favoriteBaseItem, @SyncMode.SyncMode1 int i) {
        if (favoriteBaseItem == null) {
            return "";
        }
        String delFavorite = getAccountBehaviorService().delFavorite(favoriteBaseItem, i);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "delFavorite favoriteItem = [" + GsonUtil.toJson(favoriteBaseItem) + "] return value=" + delFavorite);
        }
        return delFavorite;
    }

    public int clearAllFavorite(@SyncMode.SyncMode1 int i) {
        int clearFavorite = getAccountBehaviorService().clearFavorite(i);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "clearAllFavorite return value=" + clearFavorite);
        }
        return clearFavorite;
    }

    public String topFavorite(@Nullable FavoriteBaseItem favoriteBaseItem, @SyncMode.SyncMode1 int i) {
        if (favoriteBaseItem == null) {
            return "";
        }
        String str = getAccountBehaviorService().topFavorite(favoriteBaseItem, true, i);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "topFavorite favoriteItem = [" + GsonUtil.toJson(favoriteBaseItem) + "] return value=" + str);
        }
        return str;
    }

    @Nullable
    public FavoriteItem getFavorite(@Nullable FavoriteBaseItem favoriteBaseItem) {
        if (favoriteBaseItem == null) {
            return null;
        }
        FavoriteItem favorite = getAccountBehaviorService().getFavorite(favoriteBaseItem);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getFavorite favoriteItem = [" + GsonUtil.toJson(favorite) + "]");
        }
        return favorite;
    }

    public ArrayList<SimpleFavoriteItem> getSimpleFavoriteList(int i) {
        ArrayList<SimpleFavoriteItem> simpleFavoriteList = getAccountBehaviorService().getSimpleFavoriteList(i, false);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getSimpleFavoriteList favoriteItem = [" + GsonUtil.toJson(simpleFavoriteList) + "]");
        }
        return simpleFavoriteList;
    }

    public ArrayList<SimpleFavoriteItem> getSimpleFavoriteList() {
        return getSimpleFavoriteList(0);
    }

    public ArrayList<SimpleFavoriteItem> getSimpleHomeList() {
        return getSimpleFavoriteList(1);
    }

    public ArrayList<SimpleFavoriteItem> getSimpleCompanyList() {
        return getSimpleFavoriteList(2);
    }

    public ArrayList<SearchHistoryItem> getSearchHistoryList() {
        ArrayList<SearchHistoryItem> searchHistory = getAccountUserTrackService().getSearchHistory();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getSearchHistoryList favoriteItem = [" + GsonUtil.toJson(searchHistory) + "]");
        }
        return searchHistory;
    }

    public ConfigValue getFavoriteConfigByKey() {
        if (L.ENABLE) {
            L.d(TAG, "getFavoriteConfigByKey");
        }
        return getAccountBehaviorService().getConfig(104);
    }

    public int clearSearchHistory(@SyncMode.SyncMode1 int i) {
        int clearSearchHistory = getAccountUserTrackService().clearSearchHistory(i);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "clearSearchHistory mode = [" + i + "]searchHistory=" + clearSearchHistory);
        }
        return clearSearchHistory;
    }

    public int delSearchHistory(SearchHistoryItem searchHistoryItem, @SyncMode.SyncMode1 int i) {
        int delSearchHistory = getAccountUserTrackService().delSearchHistory(searchHistoryItem, i);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "delSearchHistory item = [" + GsonUtil.toJson(searchHistoryItem) + "], mode = [" + i + "]delSearchHistory=" + delSearchHistory);
        }
        return delSearchHistory;
    }

    public int startSync() {
        if (L.ENABLE) {
            L.d(TAG, "start bl Sync");
        }
        return getAccountSyncSdkService().startSync();
    }

    public int isSyncing() {
        int isSyncing = getAccountSyncSdkService().isSyncing();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "isSyncing value=" + isSyncing);
        }
        return isSyncing;
    }

    public void addSyncSdkServiceObserver(ISyncSDKServiceObserver iSyncSDKServiceObserver) {
        if (this.mSyncSdkService != null) {
            this.mSyncSdkService.addObserver(iSyncSDKServiceObserver);
        }
    }

    public void removeSyncSdkServiceObserver(ISyncSDKServiceObserver iSyncSDKServiceObserver) {
        if (this.mSyncSdkService != null) {
            this.mSyncSdkService.removeObserver(iSyncSDKServiceObserver);
        }
    }

    public void addBehaviorServiceObserver(IBehaviorServiceObserver iBehaviorServiceObserver) {
        if (this.mAccountBehaviorService != null) {
            this.mAccountBehaviorService.addObserver(iBehaviorServiceObserver);
        }
    }

    public void removeBehaviorServiceObserver(IBehaviorServiceObserver iBehaviorServiceObserver) {
        if (this.mAccountBehaviorService != null) {
            this.mAccountBehaviorService.removeObserver(iBehaviorServiceObserver);
        }
    }

    /* loaded from: classes2.dex */
    public static class GpsInfoGetterImpl implements IGpsInfoGetter {
        private IGpsInfoGetter mIGpsInfoGetter;

        @Override // com.autonavi.gbl.user.usertrack.observer.IGpsInfoGetter
        public GpsTrackPoint getGpsTrackPoint() {
            IGpsInfoGetter iGpsInfoGetter = this.mIGpsInfoGetter;
            if (iGpsInfoGetter != null) {
                return iGpsInfoGetter.getGpsTrackPoint();
            }
            return null;
        }
    }
}
