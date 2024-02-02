package com.xiaopeng.montecarlo.account.sync.datahelper;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.account.IThreadOperation;
import com.xiaopeng.montecarlo.account.sync.AccountDeleteUserDataResult;
import com.xiaopeng.montecarlo.account.sync.GuestDataMergeOperation;
import com.xiaopeng.montecarlo.account.sync.IncrementDataLogic;
import com.xiaopeng.montecarlo.account.sync.SyncNetworkWrapper;
import com.xiaopeng.montecarlo.navcore.account.XpUserData;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDataPullResponse;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDeleteUserDataRequest;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDeleteUserDataResponse;
import com.xiaopeng.montecarlo.navcore.bean.sync.SyncDataType;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class XpAccountDataSyncHelper {
    private static final L.Tag TAG = new L.Tag("Xp_Sync_PullHelper");
    private final IThreadOperation mThreadOperation;
    private XpUserData mUserData;
    private boolean mIsLogout = false;
    private IncrementDataLogic mIncrementDataLogic = new IncrementDataLogic();
    private GuestDataMergeOperation mGuestDataMergeOperation = new GuestDataMergeOperation(FavoriteDataManager.getInstance()) { // from class: com.xiaopeng.montecarlo.account.sync.datahelper.XpAccountDataSyncHelper.1
        @Override // com.xiaopeng.montecarlo.account.sync.GuestDataMergeOperation
        public boolean isThreadInterrupted() {
            return XpAccountDataSyncHelper.this.mThreadOperation.isThreadInterrupted();
        }
    };

    public boolean isLogout() {
        return this.mIsLogout;
    }

    public void setLogout(boolean z) {
        this.mIsLogout = z;
    }

    public XpAccountDataSyncHelper(@NonNull IThreadOperation iThreadOperation, @NonNull XpUserData xpUserData) {
        this.mThreadOperation = iThreadOperation;
        this.mUserData = xpUserData;
        this.mIncrementDataLogic.setIThreadOperation(this.mThreadOperation);
    }

    public boolean hasAccountCloudData(AccountDataPullResponse accountDataPullResponse) {
        if (accountDataPullResponse == null || accountDataPullResponse.getData() == null) {
            return false;
        }
        int serverVersion = accountDataPullResponse.getData().getServerVersion();
        SettingWrapper.setServerVersion(serverVersion);
        return serverVersion > 0;
    }

    public AccountDataPullResponse getCloudDataResponse(@NonNull XpUserData xpUserData) {
        return SyncNetworkWrapper.getAccountSyncData(xpUserData, !this.mIsLogout);
    }

    public List<AccountDeleteUserDataResult> delUserData() {
        AccountDeleteUserDataRequest accountDeleteUserDataRequest = new AccountDeleteUserDataRequest();
        accountDeleteUserDataRequest.setLocalVer(SettingWrapper.getLocalVersion());
        accountDeleteUserDataRequest.setScrapDelFavVer(SettingWrapper.getDeletedAllNormalFavVersion());
        accountDeleteUserDataRequest.setScrapHistoryVer(SettingWrapper.getDeletedAllNormalHistoryVersion());
        return deleteUserData(accountDeleteUserDataRequest);
    }

    private List<AccountDeleteUserDataResult> deleteUserData(AccountDeleteUserDataRequest accountDeleteUserDataRequest) {
        L.Tag tag = TAG;
        L.i(tag, " del_user_data request:" + accountDeleteUserDataRequest);
        AccountDeleteUserDataResponse accountDeleteUserDataResponse = null;
        if (!accountDeleteUserDataRequest.isValid()) {
            L.i(TAG, " del_user_data request not valid");
            return null;
        } else if (this.mUserData == null) {
            L.e(TAG, "deleteUserData mUserData is null!!");
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            if (accountDeleteUserDataRequest.isDelAll()) {
                hashMap.put(1, Arrays.asList(SyncDataType.SYNC_EVENT_ALL_CHILD_TYPE_LIST));
                hashMap.put(2, Arrays.asList(SyncDataType.SYNC_EVENT_ALL_CHILD_TYPE_LIST));
                arrayList.add(constructAccountDelResult(SyncNetworkWrapper.deleteUserData(this.mUserData, accountDeleteUserDataRequest.getLocalVer(), accountDeleteUserDataRequest.getDelVer(), hashMap), 3));
            } else {
                if (accountDeleteUserDataRequest.isDelFav()) {
                    hashMap.put(1, Arrays.asList(SyncDataType.SYNC_EVENT_FAVORITE_CHLID_TYPE_LIST));
                    accountDeleteUserDataResponse = SyncNetworkWrapper.deleteUserData(this.mUserData, accountDeleteUserDataRequest.getLocalVer(), accountDeleteUserDataRequest.getScrapDelFavVer(), hashMap);
                    arrayList.add(constructAccountDelResult(accountDeleteUserDataResponse, 1));
                }
                if (accountDeleteUserDataResponse != null && 11081122 == accountDeleteUserDataResponse.getCode()) {
                    return arrayList;
                }
                if (accountDeleteUserDataRequest.isDelHis()) {
                    hashMap.clear();
                    hashMap.put(2, Arrays.asList(SyncDataType.SYNC_EVENT_HISTORY_CHILD_TYPE_LIST));
                    arrayList.add(constructAccountDelResult(SyncNetworkWrapper.deleteUserData(this.mUserData, accountDeleteUserDataRequest.getLocalVer(), accountDeleteUserDataRequest.getScrapHistoryVer(), hashMap), 2));
                }
            }
            L.Tag tag2 = TAG;
            L.i(tag2, " del_user_data response:" + arrayList);
            return arrayList;
        }
    }

    private AccountDeleteUserDataResult constructAccountDelResult(AccountDeleteUserDataResponse accountDeleteUserDataResponse, int i) {
        AccountDeleteUserDataResult accountDeleteUserDataResult = new AccountDeleteUserDataResult();
        accountDeleteUserDataResult.setDelType(i);
        accountDeleteUserDataResult.setResponse(accountDeleteUserDataResponse);
        return accountDeleteUserDataResult;
    }

    public boolean checkDeletedStatus() {
        return SettingWrapper.getDeletedAllNormalFavVersion() > 0 || SettingWrapper.getDeletedAllNormalHistoryVersion() > 0;
    }

    public boolean checkPullStatus(AccountDataPullResponse accountDataPullResponse) {
        return accountDataPullResponse != null && 200 == accountDataPullResponse.getCode();
    }

    public boolean checkCloudData(AccountDataPullResponse accountDataPullResponse) {
        return hasAccountCloudData(accountDataPullResponse);
    }

    public void mergeCloudAccountData(AccountDataPullResponse accountDataPullResponse) {
        if (accountDataPullResponse != null) {
            filterDataResponseAndMerge(accountDataPullResponse);
        }
    }

    private void filterDataResponseAndMerge(AccountDataPullResponse accountDataPullResponse) {
        this.mIncrementDataLogic.handlePullResponse(accountDataPullResponse);
    }

    public void mergeGuestAccountData() {
        GuestDataMergeOperation guestDataMergeOperation = this.mGuestDataMergeOperation;
        if (guestDataMergeOperation != null) {
            guestDataMergeOperation.mergeGuestAccountData();
        }
    }
}
