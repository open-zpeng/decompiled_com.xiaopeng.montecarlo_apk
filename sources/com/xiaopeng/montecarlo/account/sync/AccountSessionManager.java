package com.xiaopeng.montecarlo.account.sync;

import com.xiaopeng.montecarlo.account.IThreadOperation;
import com.xiaopeng.montecarlo.account.sync.scheduler.BlAccountDataSyncScheduler;
import com.xiaopeng.montecarlo.navcore.account.AccountStore;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.account.AccountEventCallback;
import com.xiaopeng.montecarlo.root.account.AccountObservable;
import com.xiaopeng.montecarlo.root.account.PreSwitchUserCallback;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes.dex */
public class AccountSessionManager {
    private static final L.Tag TAG = new L.Tag("Sync_session_manager");
    private BlAccountDataSyncScheduler mBlAccountDataSyncScheduler;
    private IThreadOperation mThreadOperation;
    private HashMap<String, AccountSyncSession> mAccountSessionMap = new HashMap<>();
    private PreSwitchUserCallback mPreSwitchUserCallback = new PreSwitchUserCallback() { // from class: com.xiaopeng.montecarlo.account.sync.AccountSessionManager.1
        @Override // com.xiaopeng.montecarlo.root.account.PreSwitchUserCallback
        public void preSwitchUser(UserInfo.UserType userType, String str) {
            int type = AccountObservable.getType(userType);
            L.Tag tag = AccountSessionManager.TAG;
            L.i(tag, "PreSwitchUserCallback preSwitchUser preUserHandle:" + type + "  preUserId:" + str);
            AccountSyncSession currentSession = AccountSessionManager.this.getCurrentSession(str);
            if (currentSession == null) {
                L.i(AccountSessionManager.TAG, "PreSwitchUserCallback preSwitchUser() session is null");
                return;
            }
            AccountSessionManager.this.interruptHandlerThread();
            if (type == 0) {
                L.Tag tag2 = AccountSessionManager.TAG;
                L.i(tag2, "PreSwitchUserCallback temp account not need upload preUserHandle:" + type);
                return;
            }
            currentSession.swichLoginStatus(true);
        }
    };
    private Observer mObserver = new Observer() { // from class: com.xiaopeng.montecarlo.account.sync.AccountSessionManager.2
        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            UserInfo userInfo;
            if (!(obj instanceof UserInfo) || (userInfo = (UserInfo) obj) == null) {
                return;
            }
            UserInfo.InfoType infoType = userInfo.getInfoType();
            UserInfo.UserType userType = userInfo.getUserType();
            L.Tag tag = AccountSessionManager.TAG;
            L.i(tag, "mObserver update infoType = " + infoType + ", userType = " + userType);
            if (infoType == UserInfo.InfoType.CHANGED) {
                String userId = XPAccountServiceWrapper.getInstance().getUserId();
                if (L.ENABLE) {
                    L.Tag tag2 = AccountSessionManager.TAG;
                    L.d(tag2, "Observer update userId = " + userId);
                }
                AccountSyncSession currentSession = AccountSessionManager.this.getCurrentSession(userId);
                currentSession.initXpUserInfo("", "");
                currentSession.swichLoginStatus(false);
                currentSession.resetAmapFavoriteSyncPull();
            }
        }
    };
    private AccountEventCallback mAccountEventCallback = new AccountEventCallback() { // from class: com.xiaopeng.montecarlo.account.sync.AccountSessionManager.3
        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void accountSyncFinish() {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void amapQuickLogin() {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void initAccountFinish() {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void refreshSettingInfos(int i, int i2) {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void xpMapLogin() {
            AccountSessionManager.this.initXpUserInfo();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void initXpUserInfo() {
        getCurrentSession().initXpUserInfo(SettingWrapper.getAccountSid(), SettingWrapper.getAccountOpenId());
    }

    public AccountSyncSession getCurrentSession() {
        return getCurrentSession(XPAccountServiceWrapper.getInstance().getUserId());
    }

    public AccountSyncSession getCurrentSession(String str) {
        AccountSyncSession accountSyncSession = this.mAccountSessionMap.get(str);
        if (accountSyncSession == null) {
            AccountSyncSession accountSyncSession2 = new AccountSyncSession(AccountStore.getInstance().getXpAccountInfo(str), this.mThreadOperation, this.mBlAccountDataSyncScheduler);
            this.mAccountSessionMap.put(str, accountSyncSession2);
            return accountSyncSession2;
        }
        return accountSyncSession;
    }

    public void initBlScheduler() {
        this.mBlAccountDataSyncScheduler.initBlLoginInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void interruptHandlerThread() {
        this.mThreadOperation.interruptThread();
    }

    public void initAccountSessionManager(IThreadOperation iThreadOperation, BlAccountDataSyncScheduler blAccountDataSyncScheduler) {
        this.mBlAccountDataSyncScheduler = blAccountDataSyncScheduler;
        this.mThreadOperation = iThreadOperation;
        XPAccountServiceWrapper.getInstance().registerPreCallback(this.mPreSwitchUserCallback);
        XPAccountServiceWrapper.getInstance().registerAccountEventCallback(this.mAccountEventCallback);
        AccountObservable.getInstance().addObserver(this.mObserver);
        initXpUserInfo();
    }

    public void release() {
        XPAccountServiceWrapper.getInstance().unRegisterAccountEventCallback(this.mAccountEventCallback);
        XPAccountServiceWrapper.getInstance().unRegisterPreCallback(this.mPreSwitchUserCallback);
        AccountObservable.getInstance().deleteObserver(this.mObserver);
        getCurrentSession().close();
    }
}
