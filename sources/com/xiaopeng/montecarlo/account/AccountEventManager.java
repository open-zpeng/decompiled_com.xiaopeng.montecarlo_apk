package com.xiaopeng.montecarlo.account;

import android.os.Handler;
import com.xiaopeng.montecarlo.account.sync.GuestDataMergeOperation;
import com.xiaopeng.montecarlo.account.sync.XpAccountUtil;
import com.xiaopeng.montecarlo.navcore.account.GuestAccountDataManager;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.account.AccountEventCallback;
import com.xiaopeng.montecarlo.root.account.GuestAccountDataCallback;
import com.xiaopeng.montecarlo.root.account.PreSwitchUserCallback;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
/* loaded from: classes.dex */
public class AccountEventManager {
    private static final L.Tag TAG = new L.Tag("Sync_account_event");
    private Handler mHandler;
    private GuestDataMergeOperation mGuestDataMergeOperation = new GuestDataMergeOperation(FavoriteDataManager.getInstance()) { // from class: com.xiaopeng.montecarlo.account.AccountEventManager.1
        @Override // com.xiaopeng.montecarlo.account.sync.GuestDataMergeOperation
        public boolean isThreadInterrupted() {
            return WorkThreadUtil.getInstance().getAccountSyncThread().isThreadInterrupted(1);
        }
    };
    private PreSwitchUserCallback mPreSwitchUserCallback = new PreSwitchUserCallback() { // from class: com.xiaopeng.montecarlo.account.AccountEventManager.2
        @Override // com.xiaopeng.montecarlo.root.account.PreSwitchUserCallback
        public void preSwitchUser(UserInfo.UserType userType, String str) {
            WorkThreadUtil.getInstance().getAccountSyncThread().interruptThread(1);
        }
    };
    private AccountEventCallback mAccountEventCallback = new AccountEventCallback() { // from class: com.xiaopeng.montecarlo.account.AccountEventManager.3
        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void accountSyncFinish() {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void initAccountFinish() {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void refreshSettingInfos(int i, int i2) {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void xpMapLogin() {
            AccountManager.getInstance().getAccountSyncSession().startSync(1);
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void amapQuickLogin() {
            AccountManager.getInstance().getAccountSyncSession().addFavoriteForAmapSync();
        }
    };
    private GuestAccountDataCallback mGuestAccountDataCallback = new GuestAccountDataCallback() { // from class: com.xiaopeng.montecarlo.account.AccountEventManager.4
        @Override // com.xiaopeng.montecarlo.root.account.GuestAccountDataCallback
        public void handleGuestAccountData(UserInfo.UserType userType, UserInfo.UserType userType2, final int i) {
            Runnable runnable;
            L.Tag tag = AccountEventManager.TAG;
            L.i(tag, "handleGuestAccountData preUserType = " + userType + ", curUserType = " + userType2);
            if (UserInfo.UserType.TEMP != userType) {
                runnable = new Runnable() { // from class: com.xiaopeng.montecarlo.account.AccountEventManager.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GuestAccountDataManager.clearGuestAccountData();
                        XPAccountServiceWrapper.getInstance().invokeRefreshSettingCallback(i, SettingWrapper.getAllSettingValue());
                    }
                };
            } else {
                runnable = UserInfo.UserType.TEMP != userType2 ? new Runnable() { // from class: com.xiaopeng.montecarlo.account.AccountEventManager.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!XPNetworkManager.INSTANCE.isNetworkConnected() && !XpAccountUtil.hasAccountLocalData()) {
                            L.i(AccountEventManager.TAG, "handleGuestAccountData mergeGuestAccountData start");
                            AccountEventManager.this.mGuestDataMergeOperation.mergeGuestAccountData();
                        }
                        XPAccountServiceWrapper.getInstance().invokeRefreshSettingCallback(i, SettingWrapper.getAllSettingValue());
                    }
                } : null;
            }
            if (runnable != null) {
                WorkThreadUtil.getInstance().getAccountSyncThread().resumeThread(1);
                AccountEventManager.this.mHandler.post(runnable);
            }
        }
    };

    public AccountEventManager() {
        this.mHandler = null;
        this.mHandler = new Handler(WorkThreadUtil.getInstance().getAccountSyncThread().getLooper());
    }

    public void registerEvent() {
        XPAccountServiceWrapper.getInstance().registerPreCallback(this.mPreSwitchUserCallback);
        XPAccountServiceWrapper.getInstance().registerAccountEventCallback(this.mAccountEventCallback);
        XPAccountServiceWrapper.getInstance().setGuestAccountDataCallback(this.mGuestAccountDataCallback);
    }

    public void unRegisterEvent() {
        XPAccountServiceWrapper.getInstance().unRegisterPreCallback(this.mPreSwitchUserCallback);
        XPAccountServiceWrapper.getInstance().unRegisterAccountEventCallback(this.mAccountEventCallback);
        XPAccountServiceWrapper.getInstance().setGuestAccountDataCallback(null);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}
