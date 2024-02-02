package com.xiaopeng.montecarlo.account.sync;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.account.AccountManager;
import com.xiaopeng.montecarlo.account.IThreadOperation;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountSettingInfo;
import com.xiaopeng.montecarlo.navcore.bean.sync.IncrementDataRecord;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.DataOperation;
import com.xiaopeng.montecarlo.navcore.util.NaviLogUtil;
import com.xiaopeng.montecarlo.root.account.AccountObservable;
import com.xiaopeng.montecarlo.root.account.PreSwitchUserCallback;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil;
import com.xiaopeng.montecarlo.root.provider.favorite.NavFavoriteProvider;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class IncrementDataManager {
    private static final L.Tag TAG = new L.Tag("Xp_Sync_IncreManager");
    private static final IncrementDataManager sInstance = new IncrementDataManager();
    private BlIncrementDataHelper mBlIncrementDataHelper;
    private Handler mHandler;
    private IThreadOperation mIThreadOperation = new IThreadOperation() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.1
        @Override // com.xiaopeng.montecarlo.account.IThreadOperation
        public void interruptThread() {
            WorkThreadUtil.getInstance().getAccountSyncThread().interruptThread(2);
        }

        @Override // com.xiaopeng.montecarlo.account.IThreadOperation
        public boolean isThreadInterrupted() {
            return WorkThreadUtil.getInstance().getAccountSyncThread().isThreadInterrupted(2);
        }

        @Override // com.xiaopeng.montecarlo.account.IThreadOperation
        public void resumeThread() {
            WorkThreadUtil.getInstance().getAccountSyncThread().resumeThread(2);
        }

        @Override // com.xiaopeng.montecarlo.account.IThreadOperation
        public Looper getLooper() {
            return WorkThreadUtil.getInstance().getAccountSyncThread().getLooper();
        }
    };
    private PreSwitchUserCallback mPreSwitchUserCallback = new PreSwitchUserCallback() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.2
        @Override // com.xiaopeng.montecarlo.root.account.PreSwitchUserCallback
        public void preSwitchUser(UserInfo.UserType userType, String str) {
            int type = AccountObservable.getType(userType);
            L.Tag tag = IncrementDataManager.TAG;
            L.i(tag, "PreSwitchUserCallback preSwitchUser preUserHandle:" + type + "  preUserId:" + str);
            IncrementDataManager.this.mIThreadOperation.interruptThread();
        }
    };
    private IncrementDataHelper mIncrementDataHelper = new IncrementDataHelper();

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blNeedSync(int i) {
        return i == 1 || i == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xpNeedSync(int i) {
        return i == 1 || i == 3;
    }

    public IncrementDataManager() {
        this.mHandler = null;
        this.mHandler = new Handler(WorkThreadUtil.getInstance().getAccountSyncThread().getLooper());
        this.mIncrementDataHelper.setIThreadOperation(this.mIThreadOperation);
        this.mBlIncrementDataHelper = new BlIncrementDataHelper();
        this.mBlIncrementDataHelper.setIThreadOperation(this.mIThreadOperation);
        registerPreSwitchUserCallback();
    }

    public static IncrementDataManager getInstance() {
        return sInstance;
    }

    private void registerPreSwitchUserCallback() {
        unRegisterPreSwitchUserCallback();
        XPAccountServiceWrapper.getInstance().registerPreCallback(this.mPreSwitchUserCallback);
        if (L.ENABLE) {
            L.d(TAG, "IncrementDataManager registerPreSwitchUserCallback()");
        }
    }

    private void unRegisterPreSwitchUserCallback() {
        XPAccountServiceWrapper.getInstance().unRegisterPreCallback(this.mPreSwitchUserCallback);
        if (L.ENABLE) {
            L.d(TAG, "IncrementDataManager unRegisterPreSwitchUserCallback()");
        }
    }

    public void release() {
        unRegisterPreSwitchUserCallback();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private void interruptAMapFavoriteSyncPull(int i) {
        if (!blNeedSync(i) || this.mBlIncrementDataHelper == null) {
            return;
        }
        AccountManager.getInstance().getAccountSyncSession().disableAMapFavoriteSyncPull();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreAMapFavoriteSyncPull() {
        AccountManager.getInstance().getAccountSyncSession().enableAMapFavoriteSyncPull();
    }

    public void addFavItem(final int i, final FavoriteAddress favoriteAddress) {
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.xpNeedSync(i) && IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.insertFavorite(favoriteAddress, 1);
                }
                if (!IncrementDataManager.this.blNeedSync(i) || IncrementDataManager.this.mBlIncrementDataHelper == null) {
                    return;
                }
                IncrementDataManager.this.mBlIncrementDataHelper.insertOrReplaceFavoriteForSync(favoriteAddress, true);
            }
        });
    }

    public void updateFavItem(final int i, final FavoriteAddress favoriteAddress) {
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.4
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.xpNeedSync(i) && IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.insertFavorite(favoriteAddress, 2);
                }
                if (!IncrementDataManager.this.blNeedSync(i) || IncrementDataManager.this.mBlIncrementDataHelper == null) {
                    return;
                }
                IncrementDataManager.this.mBlIncrementDataHelper.insertOrReplaceFavoriteForSync(favoriteAddress, true);
            }
        });
    }

    public void removeFavItem(final int i, final FavoriteAddress favoriteAddress) {
        interruptAMapFavoriteSyncPull(i);
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.5
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.xpNeedSync(i) && IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.insertFavorite(favoriteAddress, 3);
                }
                if (!IncrementDataManager.this.blNeedSync(i) || IncrementDataManager.this.mBlIncrementDataHelper == null) {
                    return;
                }
                IncrementDataManager.this.restoreAMapFavoriteSyncPull();
                IncrementDataManager.this.mBlIncrementDataHelper.deleteFavoriteForSync(favoriteAddress, true);
            }
        });
    }

    public void clearNormalFav(final List<FavoriteAddress> list) {
        interruptAMapFavoriteSyncPull(1);
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.6
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.clearNormalFav(list);
                }
                if (IncrementDataManager.this.mBlIncrementDataHelper != null) {
                    IncrementDataManager.this.restoreAMapFavoriteSyncPull();
                    IncrementDataManager.this.mBlIncrementDataHelper.clearNormalFavorite();
                }
            }
        });
    }

    public void clearAllFav(final List<FavoriteAddress> list) {
        interruptAMapFavoriteSyncPull(1);
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.7
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.clearAllFav(list);
                }
                if (IncrementDataManager.this.mBlIncrementDataHelper != null) {
                    IncrementDataManager.this.restoreAMapFavoriteSyncPull();
                    IncrementDataManager.this.mBlIncrementDataHelper.clearFavorite(true);
                }
            }
        });
    }

    public void deleteUserData(final int i, final int i2) {
        interruptAMapFavoriteSyncPull(1);
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.8
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.deleteUserData(i, i2);
                }
                if (IncrementDataManager.this.mBlIncrementDataHelper != null) {
                    L.d(IncrementDataManager.TAG, "del_user_data bl clear all--- ");
                    IncrementDataManager.this.restoreAMapFavoriteSyncPull();
                    IncrementDataManager.this.mBlIncrementDataHelper.clearFavorite(true);
                }
            }
        });
    }

    public void addFavList(final int i, final List<FavoriteAddress> list) {
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.9
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.xpNeedSync(i) && IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.addFavList(list);
                }
                if (!IncrementDataManager.this.blNeedSync(i) || IncrementDataManager.this.mBlIncrementDataHelper == null) {
                    return;
                }
                IncrementDataManager.this.mBlIncrementDataHelper.addFavList(list);
            }
        });
    }

    public void updateFavList(final int i, final List<FavoriteAddress> list) {
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.10
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.xpNeedSync(i) && IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.updateFavList(list);
                }
                if (!IncrementDataManager.this.blNeedSync(i) || IncrementDataManager.this.mBlIncrementDataHelper == null) {
                    return;
                }
                IncrementDataManager.this.mBlIncrementDataHelper.updateFavList(list);
            }
        });
    }

    public void removeFavList(final int i, final List<FavoriteAddress> list) {
        interruptAMapFavoriteSyncPull(i);
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.11
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.xpNeedSync(i) && IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.removeFavList(list);
                }
                if (!IncrementDataManager.this.blNeedSync(i) || IncrementDataManager.this.mBlIncrementDataHelper == null) {
                    return;
                }
                IncrementDataManager.this.restoreAMapFavoriteSyncPull();
                IncrementDataManager.this.mBlIncrementDataHelper.removeFavList(list);
            }
        });
    }

    public void addOrUpdateFavList(final int i, final List<FavoriteAddress> list, final List<FavoriteAddress> list2) {
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.12
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.xpNeedSync(i) && IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.addOrUpdateFavList(list, list2);
                }
                if (!IncrementDataManager.this.blNeedSync(i) || IncrementDataManager.this.mBlIncrementDataHelper == null) {
                    return;
                }
                IncrementDataManager.this.mBlIncrementDataHelper.addOrUpdateFavList(list, list2);
            }
        });
    }

    public void replaceFavItem(final int i, final List<FavoriteAddress> list, final List<FavoriteAddress> list2) {
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.13
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.xpNeedSync(i) && IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.replaceFavorite(list, list2);
                }
                if (!IncrementDataManager.this.blNeedSync(i) || IncrementDataManager.this.mBlIncrementDataHelper == null) {
                    return;
                }
                IncrementDataManager.this.mBlIncrementDataHelper.replaceFavItem(list, list2);
            }
        });
    }

    public void addHistoryRecordInfo(final HistoryRecordInfo historyRecordInfo) {
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.14
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.insertHistoryRecord(historyRecordInfo, 1);
                }
            }
        });
    }

    public void updateHistoryRecordInfo(final HistoryRecordInfo historyRecordInfo) {
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.15
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.insertHistoryRecord(historyRecordInfo, 2);
                }
            }
        });
    }

    public void removeHistoryRecordInfo(final HistoryRecordInfo historyRecordInfo) {
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.16
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.insertHistoryRecord(historyRecordInfo, 3);
                }
            }
        });
    }

    public void clearAllHistoryRecordInfo(final List<HistoryRecordInfo> list) {
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.17
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.clearAllHistoryRecordInfo(list);
                }
            }
        });
    }

    public void addHistoryRecordInfoList(final List<HistoryRecordInfo> list) {
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.18
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.addHistoryRecordInfoList(list);
                }
            }
        });
    }

    public void updateHistoryRecordInfoList(final List<HistoryRecordInfo> list) {
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.19
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.updateHistoryRecordInfoList(list);
                }
            }
        });
    }

    public void removeHistoryRecordInfoList(final List<HistoryRecordInfo> list) {
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.20
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.removeHistoryRecordInfoList(list);
                }
            }
        });
    }

    public void addOrUpdateHistoryRecordInfoList(final List<HistoryRecordInfo> list, final List<HistoryRecordInfo> list2) {
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.21
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.addOrUpdateHistoryRecordInfoList(list, list2);
                }
            }
        });
    }

    public void insertSetting(final AccountSettingInfo accountSettingInfo) {
        execute(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.22
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.mIncrementDataHelper != null) {
                    IncrementDataManager.this.mIncrementDataHelper.insertSettings(accountSettingInfo, 4);
                }
            }
        });
    }

    public boolean deleteIncrementDataOperation(long j) {
        IncrementDataHelper incrementDataHelper = this.mIncrementDataHelper;
        if (incrementDataHelper != null) {
            return incrementDataHelper.deleteIncrementDataOperation(j);
        }
        return false;
    }

    public boolean insertIncrementRecords(@NonNull List<IncrementDataRecord> list) {
        IncrementDataHelper incrementDataHelper = this.mIncrementDataHelper;
        if (incrementDataHelper != null) {
            return incrementDataHelper.insertIncrementRecords(list);
        }
        return false;
    }

    public boolean hasIncrementData() {
        IncrementDataHelper incrementDataHelper = this.mIncrementDataHelper;
        if (incrementDataHelper != null) {
            return incrementDataHelper.hasIncrementData();
        }
        return false;
    }

    public List<DataOperation> getIncrementDataOp() {
        IncrementDataHelper incrementDataHelper = this.mIncrementDataHelper;
        if (incrementDataHelper != null) {
            return mergeIncrementDataOp(incrementDataHelper.getIncrementDataOp());
        }
        return null;
    }

    private List<DataOperation> mergeIncrementDataOp(Map<String, List<IncrementDataRecord>> map) {
        IncrementDataRecord incrementDataRecord;
        int size = map.size();
        L.Tag tag = TAG;
        L.i(tag, "mergeIncrementDataRecord recordMap.size = " + size);
        if (size > 0) {
            ArrayList<DataOperation> arrayList = new ArrayList();
            for (List<IncrementDataRecord> list : map.values()) {
                if (L.ENABLE) {
                    for (IncrementDataRecord incrementDataRecord2 : list) {
                        L.d(TAG, NaviLogUtil.dumpDataOperation(incrementDataRecord2));
                    }
                }
                if (CollectionUtils.isNotEmpty(list)) {
                    int size2 = list.size();
                    if (size2 >= 2) {
                        IncrementDataRecord incrementDataRecord3 = list.get(0);
                        for (int i = 1; i < size2; i++) {
                            if (incrementDataRecord3 == null) {
                                incrementDataRecord3 = list.get(i);
                            } else {
                                incrementDataRecord3 = getNewIncrementOp(incrementDataRecord3, list.get(i));
                            }
                        }
                        if (incrementDataRecord3 != null) {
                            arrayList.add(incrementDataRecord3.toDataOperation());
                        }
                    } else if (size2 == 1 && (incrementDataRecord = list.get(0)) != null) {
                        arrayList.add(incrementDataRecord.toDataOperation());
                    }
                }
            }
            L.Tag tag2 = TAG;
            L.i(tag2, "mergeIncrementDataRecord operationList.size = " + arrayList.size());
            if (L.ENABLE) {
                for (DataOperation dataOperation : arrayList) {
                    L.i(TAG, NaviLogUtil.dumpDataOperation(dataOperation));
                }
            }
            return arrayList;
        }
        return null;
    }

    private IncrementDataRecord getNewIncrementOp(@NonNull IncrementDataRecord incrementDataRecord, @NonNull IncrementDataRecord incrementDataRecord2) {
        int operationType = incrementDataRecord.getOperationType();
        int operationType2 = incrementDataRecord2.getOperationType();
        if (operationType == operationType2) {
            return incrementDataRecord2.getUpdateTime() > incrementDataRecord.getUpdateTime() ? incrementDataRecord2 : incrementDataRecord;
        }
        if (operationType == 1) {
            if (operationType2 == 2) {
                incrementDataRecord2.setOperationType(1);
                return incrementDataRecord2;
            } else if (operationType2 != 3 && operationType2 == 4) {
                return incrementDataRecord2;
            }
        } else if (operationType == 2) {
            if (operationType2 == 1 || operationType2 == 3 || operationType2 == 4) {
                return incrementDataRecord2;
            }
        } else if (operationType == 3) {
            if (operationType2 == 1) {
                return incrementDataRecord2;
            }
            if (operationType2 == 2) {
                return incrementDataRecord;
            }
            if (operationType2 == 4) {
                return incrementDataRecord2;
            }
        } else if (operationType == 4) {
            if (operationType2 == 1) {
                return incrementDataRecord2;
            }
            if (operationType2 == 2) {
                incrementDataRecord2.setOperationType(4);
                return incrementDataRecord2;
            } else if (operationType2 == 3) {
                return incrementDataRecord2;
            }
        }
        return null;
    }

    public void compareServerDataOperation(@NonNull List<DataOperation> list, @NonNull List<DataOperation> list2, @NonNull List<DataOperation> list3, @NonNull List<DataOperation> list4) {
        FavoriteAddress favoriteAddress;
        FavoriteAddress favoriteAddress2;
        HashMap hashMap = new HashMap();
        ArrayList<DataOperation> arrayList = new ArrayList<>();
        ArrayList<DataOperation> arrayList2 = new ArrayList<>();
        DataOperation dataOperation = null;
        DataOperation dataOperation2 = null;
        DataOperation dataOperation3 = null;
        for (DataOperation dataOperation4 : list) {
            if (1 == dataOperation4.getDataType()) {
                String dataContent = dataOperation4.getDataContent();
                if (!TextUtils.isEmpty(dataContent) && (favoriteAddress2 = (FavoriteAddress) GsonUtil.fromJson(dataContent, (Class<Object>) FavoriteAddress.class)) != null) {
                    if (2 == favoriteAddress2.getFavoriteType()) {
                        dataOperation2 = dataOperation4;
                    } else if (3 == favoriteAddress2.getFavoriteType()) {
                        dataOperation3 = dataOperation4;
                    }
                }
            }
            hashMap.put(dataOperation4.getDataId(), dataOperation4);
        }
        DataOperation dataOperation5 = null;
        for (DataOperation dataOperation6 : list2) {
            if (1 == dataOperation6.getDataType()) {
                String dataContent2 = dataOperation6.getDataContent();
                if (!TextUtils.isEmpty(dataContent2) && (favoriteAddress = (FavoriteAddress) GsonUtil.fromJson(dataContent2, (Class<Object>) FavoriteAddress.class)) != null) {
                    if (2 == favoriteAddress.getFavoriteType()) {
                        arrayList.add(dataOperation6);
                        dataOperation = dataOperation6;
                    } else if (3 == favoriteAddress.getFavoriteType()) {
                        arrayList2.add(dataOperation6);
                        dataOperation5 = dataOperation6;
                    }
                }
            }
            if (hashMap.containsKey(dataOperation6.getDataId())) {
                DataOperation dataOperation7 = (DataOperation) hashMap.get(dataOperation6.getDataId());
                if (dataOperation7.getUpdateTime() < dataOperation6.getUpdateTime()) {
                    list3.add(dataOperation6);
                    list4.add(dataOperation7);
                } else if (dataOperation7.getUpdateTime() == dataOperation6.getUpdateTime()) {
                    list4.add(dataOperation7);
                }
            } else {
                list3.add(dataOperation6);
            }
        }
        clearHomeOrCompanyDirtyData(arrayList, arrayList2);
        if (L.ENABLE) {
            L.d(TAG, "compareServerDataOperation localHomeOp = " + dataOperation2 + ", serverHomeOp = " + dataOperation);
        }
        if (dataOperation2 == null || dataOperation == null) {
            if (dataOperation != null) {
                list3.add(dataOperation);
            }
        } else if (dataOperation2.getDataId().equals(dataOperation.getDataId())) {
            if (L.ENABLE) {
                L.d(TAG, "compareServerDataOperation serverHomeOp.getUpdateTime() = " + dataOperation.getUpdateTime() + ", localHomeOp.getUpdateTime() = " + dataOperation2.getUpdateTime());
            }
            if (dataOperation.getUpdateTime() > dataOperation2.getUpdateTime()) {
                list3.add(dataOperation);
                list4.add(dataOperation2);
            } else if (dataOperation.getUpdateTime() == dataOperation2.getUpdateTime()) {
                list4.add(dataOperation2);
            }
        } else if (dataOperation.getUpdateTime() > dataOperation2.getUpdateTime()) {
            list3.add(dataOperation);
        }
        if (dataOperation3 == null || dataOperation5 == null) {
            if (dataOperation5 != null) {
                list3.add(dataOperation5);
            }
        } else if (dataOperation3.getDataId().equals(dataOperation5.getDataId())) {
            if (L.ENABLE) {
                L.d(TAG, "compareServerDataOperation serverCompanyOp.getUpdateTime() = " + dataOperation5.getUpdateTime() + ", localCompanyOp.getUpdateTime() = " + dataOperation3.getUpdateTime());
            }
            if (dataOperation5.getUpdateTime() > dataOperation3.getUpdateTime()) {
                list3.add(dataOperation5);
                list4.add(dataOperation3);
            } else if (dataOperation5.getUpdateTime() == dataOperation3.getUpdateTime()) {
                list4.add(dataOperation3);
            }
        } else if (dataOperation5.getUpdateTime() > dataOperation3.getUpdateTime()) {
            list3.add(dataOperation5);
        }
    }

    private void clearHomeOrCompanyDirtyData(ArrayList<DataOperation> arrayList, ArrayList<DataOperation> arrayList2) {
        if (L.ENABLE) {
            L.d(TAG, " clearHomeOrCompanyDirtyData homeAddressList size = " + arrayList.size() + "  companyAddressList size =" + arrayList2.size());
        }
        ArrayList arrayList3 = new ArrayList();
        for (int size = arrayList.size() - 2; size >= 0; size--) {
            DataOperation dataOperation = arrayList.get(size);
            long currentTimeMillis = System.currentTimeMillis();
            dataOperation.setCreateTime(currentTimeMillis);
            dataOperation.setUpdateTime(currentTimeMillis);
            dataOperation.setOperationType(3);
            arrayList3.add(new IncrementDataRecord(dataOperation));
            if (L.ENABLE) {
                L.d(TAG, " clearHomeDirtyData i = " + size + " " + NaviLogUtil.dumpDataOperation(dataOperation));
            }
        }
        for (int size2 = arrayList2.size() - 2; size2 >= 0; size2--) {
            DataOperation dataOperation2 = arrayList2.get(size2);
            long currentTimeMillis2 = System.currentTimeMillis();
            dataOperation2.setCreateTime(currentTimeMillis2);
            dataOperation2.setUpdateTime(currentTimeMillis2);
            dataOperation2.setOperationType(3);
            arrayList3.add(new IncrementDataRecord(dataOperation2));
            if (L.ENABLE) {
                L.d(TAG, " clearCompanyDirtyData i = " + size2 + " " + NaviLogUtil.dumpDataOperation(dataOperation2));
            }
        }
        if (CollectionUtils.isEmpty(arrayList3)) {
            return;
        }
        try {
            ContentResolver contentResolver = ContextUtils.getContext().getContentResolver();
            int size3 = arrayList3.size();
            ArrayList<ContentProviderOperation> arrayList4 = new ArrayList<>();
            for (int i = 0; i < size3; i++) {
                ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(NavFavoriteProvider.XPINCRE_CONTENT_URI);
                newInsert.withValues(((IncrementDataRecord) arrayList3.get(i)).toContentValues());
                if (newInsert != null) {
                    arrayList4.add(newInsert.build());
                }
            }
            if (contentResolver.applyBatch(NavFavoriteProvider.AUTHORITY, arrayList4).length == size3) {
                AccountManager.getInstance().getAccountSyncSession().startSync(2);
            }
        } catch (Exception e) {
            DatabaseExceptionUtil.handleException(e);
        }
    }

    public void resumeThread() {
        IThreadOperation iThreadOperation = this.mIThreadOperation;
        if (iThreadOperation == null || !iThreadOperation.isThreadInterrupted()) {
            return;
        }
        this.mIThreadOperation.resumeThread();
    }

    private void execute(final Runnable runnable) {
        if (this.mHandler == null) {
            this.mHandler = new Handler(WorkThreadUtil.getInstance().getAccountSyncThread().getLooper());
        }
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.account.sync.IncrementDataManager.23
            @Override // java.lang.Runnable
            public void run() {
                if (IncrementDataManager.this.mIThreadOperation != null) {
                    IncrementDataManager.this.mIThreadOperation.resumeThread();
                }
                runnable.run();
            }
        });
    }
}
