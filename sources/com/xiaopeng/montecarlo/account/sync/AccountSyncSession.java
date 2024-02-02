package com.xiaopeng.montecarlo.account.sync;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.account.IThreadOperation;
import com.xiaopeng.montecarlo.account.sync.datahelper.XpAccountDataSyncHelper;
import com.xiaopeng.montecarlo.account.sync.datahelper.XpAccountDataUploadHelper;
import com.xiaopeng.montecarlo.account.sync.scheduler.BlAccountDataSyncScheduler;
import com.xiaopeng.montecarlo.account.sync.scheduler.XpAccountDataSyncScheduler;
import com.xiaopeng.montecarlo.account.sync.scheduler.XpAccountDataUploadScheduler;
import com.xiaopeng.montecarlo.navcore.account.XpUserData;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class AccountSyncSession implements IAccountSync {
    private static final int LOGIN_IN = 1;
    private static final int LOGIN_NONE = 0;
    private static final int LOGIN_OUT = 2;
    private static final L.Tag TAG = new L.Tag("Sync_account_session");
    private final BlAccountDataSyncScheduler mBlAccountDataSyncScheduler;
    private final IThreadOperation mThreadOperation;
    private final XpAccountDataSyncScheduler mXpAccountDataSyncScheduler;
    private final XpAccountDataUploadScheduler mXpAccountDataUploadScheduler;
    private final XpUserData mXpUserData;
    private int mLoginStatus = 0;
    private volatile int mDisableBlFavoritePullCount = 0;

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public void addAccountSyncObserver(IAccountSyncObserver iAccountSyncObserver) {
    }

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public void clearAllFavorites() {
    }

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public int clearAllHistoryRecords() {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public int clearAllSettings() {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public void clearNormalFavorites() {
    }

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public void delAccountSyncObserver(IAccountSyncObserver iAccountSyncObserver) {
    }

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public void delFavorite(FavoriteAddress favoriteAddress, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public int delHistoryRecord(HistoryRecordInfo historyRecordInfo, boolean z) {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public void delUserData() {
    }

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public void insertOrReplaceFavorite(FavoriteAddress favoriteAddress, boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public int insertOrReplaceHistoryRecord(HistoryRecordInfo historyRecordInfo, boolean z) {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public int isSyncing(int i) {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public int updateSetting(String str, String str2, boolean z) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountSyncSession(@NonNull XpUserData xpUserData, IThreadOperation iThreadOperation, BlAccountDataSyncScheduler blAccountDataSyncScheduler) {
        this.mXpUserData = xpUserData;
        this.mThreadOperation = iThreadOperation;
        this.mXpAccountDataUploadScheduler = new XpAccountDataUploadScheduler(this.mThreadOperation, this.mXpUserData);
        this.mXpAccountDataSyncScheduler = new XpAccountDataSyncScheduler(this.mThreadOperation, this.mXpUserData);
        this.mBlAccountDataSyncScheduler = blAccountDataSyncScheduler;
        this.mXpAccountDataSyncScheduler.setXpAccountDataSyncHelper(new XpAccountDataSyncHelper(this.mThreadOperation, this.mXpUserData));
        this.mXpAccountDataUploadScheduler.setXpAccountDataUploadHelper(new XpAccountDataUploadHelper(this.mThreadOperation, this.mXpUserData));
    }

    public void initXpUserInfo(String str, String str2) {
        this.mXpUserData.setSid(str);
        this.mXpUserData.setOpenId(str2);
    }

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public void startSync(int i) {
        L.Tag tag = TAG;
        L.i(tag, "startSync type = " + i);
        startAccountDataSync(i, false);
    }

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public void addFavoriteForAmapSync() {
        startBlSyncAccountData(103);
    }

    private void startAccountDataSync(int i, boolean z) {
        if (this.mXpAccountDataSyncScheduler.isWaitingToRun()) {
            L.i(TAG, "AccountSyncSession startAccountDataSync has pull running");
            return;
        }
        boolean isPullSuccess = XpAccountUtil.isPullSuccess();
        L.Tag tag = TAG;
        L.i(tag, "AccountSyncSession startAccountDataSync last pullSuccess = " + isPullSuccess);
        if (!isPullSuccess && !this.mXpAccountDataSyncScheduler.isPulling()) {
            startPullAccountData();
        } else if (i == 1) {
            startPullAccountData();
        } else if (i != 2 && i != 3) {
            if (i == 4) {
                this.mXpAccountDataSyncScheduler.startDelUserData();
            } else if (i == 55) {
                startBlSyncAccountData(100);
            } else if (i != 56) {
            } else {
                startBlSyncAccountData(101);
            }
        } else {
            boolean isLessThanUploadTimes = XpAccountUtil.isLessThanUploadTimes();
            L.Tag tag2 = TAG;
            L.i(tag2, "AccountSyncSession startAccountDataSync isLessUploadTimes = " + isLessThanUploadTimes);
            if (isLessThanUploadTimes) {
                if (i == 3) {
                    boolean isUploadSuccess = XpAccountUtil.isUploadSuccess();
                    L.Tag tag3 = TAG;
                    L.i(tag3, "AccountSyncSession startAccountDataSync last uploadSuccess = " + isUploadSuccess);
                    if (isUploadSuccess) {
                        return;
                    }
                    startUploadAccountData(z);
                    return;
                }
                startUploadAccountData(z);
            }
        }
    }

    private void startBlSyncAccountData(int i) {
        this.mBlAccountDataSyncScheduler.startBlSyncAccountData(i);
    }

    private void startBlSyncAccountData(int i, FavoriteAddress favoriteAddress, boolean z) {
        this.mBlAccountDataSyncScheduler.startBlSyncAccountData(i, favoriteAddress, z);
    }

    private void startPullAccountData() {
        this.mXpAccountDataSyncScheduler.startPullAccountData();
    }

    private void startUploadAccountData(boolean z) {
        this.mXpAccountDataUploadScheduler.reset();
        if (z) {
            this.mXpAccountDataUploadScheduler.setDataOperationList(IncrementDataManager.getInstance().getIncrementDataOp());
        }
        this.mXpAccountDataUploadScheduler.start();
    }

    public void close() {
        this.mXpAccountDataSyncScheduler.close();
        this.mXpAccountDataUploadScheduler.close();
    }

    public final void swichLoginStatus(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "swichLoginStatus isLogOut:" + z + "  mLoginStatus: " + this.mLoginStatus);
        }
        setLogOut(z);
        if (!z) {
            int i = this.mLoginStatus;
            if (i == 0 || i == 2) {
                this.mLoginStatus = 1;
                return;
            }
            return;
        }
        int i2 = this.mLoginStatus;
        if (i2 == 0 || i2 == 1) {
            this.mLoginStatus = 2;
            this.mXpAccountDataUploadScheduler.reset();
            this.mXpAccountDataSyncScheduler.reset();
            startAccountDataSync(2, true);
        }
    }

    private void setLogOut(boolean z) {
        this.mXpAccountDataUploadScheduler.setLogout(z);
        this.mXpAccountDataSyncScheduler.setLogout(z);
    }

    public synchronized void resetAmapFavoriteSyncPull() {
        this.mDisableBlFavoritePullCount = 0;
    }

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public synchronized void disableAMapFavoriteSyncPull() {
        this.mDisableBlFavoritePullCount++;
    }

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public synchronized void enableAMapFavoriteSyncPull() {
        if (this.mDisableBlFavoritePullCount > 0) {
            this.mDisableBlFavoritePullCount--;
        } else {
            L.e(TAG, "enableAMapFavoriteSyncPull error,count=" + this.mDisableBlFavoritePullCount);
        }
    }

    @Override // com.xiaopeng.montecarlo.account.sync.IAccountSync
    public synchronized boolean isAMapFavoriteSyncPullDisabled() {
        return this.mDisableBlFavoritePullCount > 0;
    }
}
