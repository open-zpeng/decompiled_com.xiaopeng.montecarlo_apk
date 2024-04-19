package com.xiaopeng.montecarlo.account.sync;

import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
/* loaded from: classes.dex */
public interface IAccountSync {
    void addAccountSyncObserver(IAccountSyncObserver iAccountSyncObserver);

    void addFavoriteForAmapSync();

    void clearAllFavorites();

    int clearAllHistoryRecords();

    int clearAllSettings();

    void clearNormalFavorites();

    void delAccountSyncObserver(IAccountSyncObserver iAccountSyncObserver);

    void delFavorite(FavoriteAddress favoriteAddress, boolean z);

    int delHistoryRecord(HistoryRecordInfo historyRecordInfo, boolean z);

    void delUserData();

    void disableAMapFavoriteSyncPull();

    void enableAMapFavoriteSyncPull();

    void insertOrReplaceFavorite(FavoriteAddress favoriteAddress, boolean z);

    int insertOrReplaceHistoryRecord(HistoryRecordInfo historyRecordInfo, boolean z);

    boolean isAMapFavoriteSyncPullDisabled();

    int isSyncing(int i);

    void startSync(int i);

    int updateSetting(String str, String str2, boolean z);
}
