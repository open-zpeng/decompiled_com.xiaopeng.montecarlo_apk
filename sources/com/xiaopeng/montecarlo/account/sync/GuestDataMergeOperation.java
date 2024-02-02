package com.xiaopeng.montecarlo.account.sync;

import android.database.sqlite.SQLiteDatabase;
import com.xiaopeng.montecarlo.navcore.account.GuestAccountDataManager;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountSettingInfo;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class GuestDataMergeOperation {
    private static final L.Tag TAG = new L.Tag("Sync_guest_merge");
    private FavoriteDataManager mDataManager;

    public abstract boolean isThreadInterrupted();

    public GuestDataMergeOperation(FavoriteDataManager favoriteDataManager) {
        this.mDataManager = favoriteDataManager;
    }

    public void mergeGuestAccountData() {
        if (L.ENABLE) {
            L.d(TAG, "GuestDataMergeOperation mergeGuestAccountData start");
        }
        if (isThreadInterrupted()) {
            return;
        }
        SQLiteDatabase guestFavoriteDatabase = GuestAccountDataManager.getGuestFavoriteDatabase();
        if (guestFavoriteDatabase != null) {
            List<HistoryRecordInfo> guestAccountHistory = getGuestAccountHistory(guestFavoriteDatabase);
            if (isThreadInterrupted()) {
                return;
            }
            if (CollectionUtils.isNotEmpty(guestAccountHistory)) {
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "GuestDataMergeOperation mergeGuestAccountData insertOrReplaceHistoryList size:" + guestAccountHistory.size());
                }
                this.mDataManager.insertOrReplaceHistoryList(guestAccountHistory);
                if (isThreadInterrupted()) {
                    return;
                }
            }
            setHome(getGuestAccountHomeAddress(guestFavoriteDatabase));
            setCompany(getGuestAccountCompanyAddress(guestFavoriteDatabase));
        } else {
            L.i(TAG, "guestAccountDataMerge getGuestFavoriteDatabase favoriteDb is null");
        }
        if (guestFavoriteDatabase != null) {
            guestFavoriteDatabase.close();
        }
        SQLiteDatabase guestSettingDatabase = GuestAccountDataManager.getGuestSettingDatabase();
        if (guestSettingDatabase != null) {
            AccountSettingInfo guestSettingList = GuestAccountDataManager.getGuestSettingList(guestSettingDatabase);
            if (guestSettingList != null) {
                DataSetHelper.AccountSet.set(guestSettingList.getName(), guestSettingList.getValue());
            }
        } else {
            L.i(TAG, "guestAccountDataMerge getGuestSettingDatabase settingDb is null");
        }
        if (guestSettingDatabase != null) {
            guestSettingDatabase.close();
        }
        if (L.ENABLE) {
            L.d(TAG, "GuestDataMergeOperation mergeGuestAccountData finish");
        }
    }

    private FavoriteAddress getGuestAccountHomeAddress(SQLiteDatabase sQLiteDatabase) {
        if (isThreadInterrupted()) {
            return null;
        }
        FavoriteAddress guestHome = GuestAccountDataManager.getGuestHome(sQLiteDatabase);
        if (guestHome == null) {
            L.i(TAG, "getGuestAccountHomeAddress guest home is empty");
        }
        return guestHome;
    }

    private FavoriteAddress getGuestAccountCompanyAddress(SQLiteDatabase sQLiteDatabase) {
        if (isThreadInterrupted()) {
            return null;
        }
        FavoriteAddress guestCompany = GuestAccountDataManager.getGuestCompany(sQLiteDatabase);
        if (guestCompany == null) {
            L.i(TAG, "getGuestAccountCompanyAddress guest company is empty");
        }
        return guestCompany;
    }

    private List<HistoryRecordInfo> getGuestAccountHistory(SQLiteDatabase sQLiteDatabase) {
        if (isThreadInterrupted()) {
            return null;
        }
        List<HistoryRecordInfo> listGuestHistoryRecords = GuestAccountDataManager.listGuestHistoryRecords(sQLiteDatabase);
        if (CollectionUtils.isEmpty(listGuestHistoryRecords)) {
            L.i(TAG, "getGuestAccountHistory temp account HistoryRecord is empty");
            return null;
        }
        return listGuestHistoryRecords;
    }

    public void setHome(FavoriteAddress favoriteAddress) {
        if (isThreadInterrupted() || favoriteAddress == null) {
            return;
        }
        this.mDataManager.setHome(favoriteAddress);
    }

    public void setCompany(FavoriteAddress favoriteAddress) {
        if (isThreadInterrupted() || favoriteAddress == null) {
            return;
        }
        this.mDataManager.setCompany(favoriteAddress);
    }
}
