package com.xiaopeng.montecarlo.account.sync.datahelper;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.autonavi.gbl.data.model.AreaExtraInfo;
import com.autonavi.gbl.user.account.model.AccountProfile;
import com.autonavi.gbl.user.behavior.model.FavoriteItem;
import com.xiaopeng.montecarlo.account.AccountManager;
import com.xiaopeng.montecarlo.account.IThreadOperation;
import com.xiaopeng.montecarlo.account.SyncAlarmManager;
import com.xiaopeng.montecarlo.account.sync.FavoriteSyncUtil;
import com.xiaopeng.montecarlo.account.sync.IncrementDataManager;
import com.xiaopeng.montecarlo.account.sync.scheduler.BlAccountDataSyncScheduler;
import com.xiaopeng.montecarlo.navcore.account.AccountBehaviorServiceWrapper;
import com.xiaopeng.montecarlo.navcore.account.BLMsgPushServiceWrapper;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.favorite.BlBehaviorServiceHelper;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.provider.favorite.NavFavoriteProvider;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
/* loaded from: classes.dex */
public class BlAccountDataSyncHelper {
    private static final L.Tag TAG = new L.Tag("Bl_Sync_Helper");
    private IThreadOperation mIThreadOperation;
    private boolean mIsLoginInfoReady = false;
    private BlAccountDataSyncScheduler mSyncScheduler;

    public void setIThreadOperation(IThreadOperation iThreadOperation) {
        this.mIThreadOperation = iThreadOperation;
    }

    public void setSyncScheduler(BlAccountDataSyncScheduler blAccountDataSyncScheduler) {
        this.mSyncScheduler = blAccountDataSyncScheduler;
    }

    public boolean isSyncing() {
        return BlBehaviorServiceHelper.isSyncing();
    }

    public String getBlUserId() {
        AccountProfile accountProfile;
        String blAccountProfile = SettingWrapper.getBlAccountProfile();
        if (TextUtils.isEmpty(blAccountProfile) || (accountProfile = (AccountProfile) GsonUtil.fromJson(blAccountProfile, (Class<Object>) AccountProfile.class)) == null) {
            return null;
        }
        String str = accountProfile.uid;
        L.Tag tag = TAG;
        L.i(tag, "getUserId BL userId = " + str);
        return str;
    }

    public boolean isLoginInfoReady() {
        return this.mIsLoginInfoReady;
    }

    private boolean setLoginInfo(String str) {
        int loginInfo = AccountBehaviorServiceWrapper.getInstance().setLoginInfo(str);
        int loginInfo2 = BLMsgPushServiceWrapper.getInstance().setLoginInfo(str);
        L.Tag tag = TAG;
        L.i(tag, "setLoginInfo setLoginResult = " + loginInfo + "  setMsgPushLoginResult = " + loginInfo2 + ", userId = " + str);
        boolean z = loginInfo == 0;
        this.mIsLoginInfoReady = z;
        return z;
    }

    public void initBlLoginInfo() {
        String blUserId = getBlUserId();
        if (blUserId == null) {
            L.Tag tag = TAG;
            L.i(tag, "initBlLoginInfo BL userId = " + blUserId);
        } else if (setLoginInfo(blUserId)) {
        } else {
            L.i(TAG, "initBlLoginInfo  error ");
            updateFavoriteSyncAlarm();
        }
    }

    public boolean startSync() {
        if (isThreadInterrupted()) {
            L.w(TAG, "startSync interrupted return ");
            return false;
        }
        int startSync = AccountBehaviorServiceWrapper.getInstance().startSync();
        boolean z = startSync == 0;
        if (!z) {
            L.Tag tag = TAG;
            L.w(tag, "startSync() error code = " + startSync);
            updateFavoriteSyncAlarm();
        } else {
            resetHomeCompanyConflictStatus();
        }
        return z;
    }

    private void startFavoriteSyncPullService() {
        BlAccountDataSyncScheduler blAccountDataSyncScheduler = this.mSyncScheduler;
        if (blAccountDataSyncScheduler != null) {
            blAccountDataSyncScheduler.startBlSyncAccountData(100);
        }
    }

    private void startFavoriteSyncUploadService() {
        BlAccountDataSyncScheduler blAccountDataSyncScheduler = this.mSyncScheduler;
        if (blAccountDataSyncScheduler != null) {
            blAccountDataSyncScheduler.startBlSyncAccountData(101);
        }
    }

    private void resetHomeCompanyConflictStatus() {
        if (isThreadInterrupted()) {
            return;
        }
        FavoriteSyncUtil.resetHomeCompanyConflictStatus();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean pullHomeCompanyAddress() {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.account.sync.datahelper.BlAccountDataSyncHelper.pullHomeCompanyAddress():boolean");
    }

    public void startMerge(boolean z) {
        if (z) {
            boolean pullHomeCompanyAddress = pullHomeCompanyAddress();
            boolean pullFavoriteAddress = pullFavoriteAddress();
            if (pullHomeCompanyAddress || pullFavoriteAddress) {
                notifyDatabaseChange();
            }
            L.Tag tag = TAG;
            L.i(tag, "startMerge sync finish, homeCompanyChange = " + pullHomeCompanyAddress + ", favoriteChange = " + pullFavoriteAddress);
        }
        setFavoriteSyncStatus(true);
        SettingWrapper.setBlFavSyncTime(System.currentTimeMillis());
        SyncAlarmManager.cancelAccountSyncAlarm();
        if (L.ENABLE) {
            L.d(TAG, "startMerge sync finish invokeAccountSyncFinishCallback");
        }
        XPAccountServiceWrapper.getInstance().invokeAccountSyncFinishCallback();
    }

    private void notifyDatabaseChange() {
        ContextUtils.getContext().getContentResolver().notifyChange(NavFavoriteProvider.FAVORITE_CONTENT_URI, null);
    }

    private boolean isPullFavoriteUnAvailable() {
        return isThreadInterrupted() || AccountManager.getInstance().getAccountSyncSession().isAMapFavoriteSyncPullDisabled();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0244 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x020e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean pullFavoriteAddress() {
        /*
            Method dump skipped, instructions count: 717
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.account.sync.datahelper.BlAccountDataSyncHelper.pullFavoriteAddress():boolean");
    }

    private String getAddressByLonLat(double d, double d2) {
        AreaExtraInfo areaExtraInfo = MapDataManager.getInstance().getAreaExtraInfo(MapDataManager.getInstance().getAdCodeByLonLat(new XPCoordinate2DDouble(d, d2)));
        if (areaExtraInfo != null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(areaExtraInfo.provName)) {
                sb.append(areaExtraInfo.provName);
            }
            if (!TextUtils.isEmpty(areaExtraInfo.cityName)) {
                sb.append(" ");
                sb.append(areaExtraInfo.cityName);
            }
            if (!TextUtils.isEmpty(areaExtraInfo.townName)) {
                sb.append(" ");
                sb.append(areaExtraInfo.townName);
            }
            return sb.toString();
        }
        return null;
    }

    private boolean isAmapModifed(@NonNull FavoriteAddress favoriteAddress, @NonNull FavoriteAddress favoriteAddress2) {
        if (((int) (favoriteAddress.getBLCreateTime() / 1000)) > ((int) (favoriteAddress2.getBLCreateTime() / 1000))) {
            return true;
        }
        String bLCustomName = favoriteAddress.getBLCustomName();
        String bLCustomName2 = favoriteAddress2.getBLCustomName();
        if (bLCustomName == null && bLCustomName2 == null) {
            return false;
        }
        return bLCustomName == null || bLCustomName2 == null || !bLCustomName.equals(bLCustomName2);
    }

    private void setHome(FavoriteAddress favoriteAddress) {
        if (!isPullFavoriteUnAvailable() && BlFavDataManager.getInstance().setHome(favoriteAddress) && L.ENABLE) {
            L.d(TAG, "pullHomeAddress setHome success");
        }
    }

    private void setCompany(FavoriteAddress favoriteAddress) {
        if (!isPullFavoriteUnAvailable() && BlFavDataManager.getInstance().setCompany(favoriteAddress) && L.ENABLE) {
            L.d(TAG, "pullHomeAddress setCompany success");
        }
    }

    public void updateFavoriteSyncAlarm() {
        if (isThreadInterrupted()) {
            return;
        }
        if (SettingWrapper.getFavoriteSyncStatus()) {
            SyncAlarmManager.cancelAccountSyncAlarm();
        } else {
            SyncAlarmManager.setAccountSyncAlarm();
        }
    }

    private void setAmapHomeConflictStatus(boolean z, FavoriteItem favoriteItem) {
        if (isPullFavoriteUnAvailable()) {
            return;
        }
        FavoriteSyncUtil.setAmapHomeConflictStatus(z, favoriteItem);
    }

    private void setAmapCompanyConflictStatus(boolean z, FavoriteItem favoriteItem) {
        if (isPullFavoriteUnAvailable()) {
            return;
        }
        FavoriteSyncUtil.setAmapCompanyConflictStatus(z, favoriteItem);
    }

    private void resetHomeConflictStatus() {
        if (isPullFavoriteUnAvailable()) {
            return;
        }
        FavoriteSyncUtil.resetHomeConflictStatus();
    }

    private void resetCompanyConflictStatus() {
        if (isPullFavoriteUnAvailable()) {
            return;
        }
        FavoriteSyncUtil.resetCompanyConflictStatus();
    }

    private int deleteAllNormalFavorites() {
        if (isPullFavoriteUnAvailable()) {
            return 0;
        }
        return BlFavDataManager.getInstance().deleteAllNormalFavorites();
    }

    public void setFavoriteSyncStatus(boolean z) {
        if (isPullFavoriteUnAvailable()) {
            return;
        }
        SettingWrapper.setFavoriteSyncStatus(z);
    }

    private boolean isThreadInterrupted() {
        IThreadOperation iThreadOperation = this.mIThreadOperation;
        return iThreadOperation != null && iThreadOperation.isThreadInterrupted();
    }

    public boolean addFavoriteForAmapSync() {
        if (XPAccountServiceWrapper.getInstance().isLoginXp()) {
            List<FavoriteAddress> listFavorites = BlFavDataManager.getInstance().listFavorites();
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("addFavoriteForAmapSync list: ");
            sb.append(listFavorites == null ? "null" : Integer.valueOf(listFavorites.size()));
            L.i(tag, sb.toString());
            if (CollectionUtils.isNotEmpty(listFavorites)) {
                IncrementDataManager.getInstance().addFavList(2, listFavorites);
                return true;
            }
            return true;
        }
        return false;
    }
}
