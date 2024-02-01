package com.xiaopeng.montecarlo.navcore.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OnAccountsUpdateListener;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.Application;
import android.content.ContentProviderClient;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.navcore.exceptions.OnMainThreadException;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.account.AccountEventCallback;
import com.xiaopeng.montecarlo.root.account.AccountObservable;
import com.xiaopeng.montecarlo.root.account.GuestAccountDataCallback;
import com.xiaopeng.montecarlo.root.account.PreSwitchUserCallback;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.httpclient.constants.HttpConst;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.provider.favorite.NavFavoriteProvider;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class XPAccountServiceWrapper implements OnAccountsUpdateListener {
    private static final String NAVI_APP_ID = "xp_gd_navigation";
    private static final L.Tag TAG = new L.Tag("XPAccountServiceWrapper");
    private static final XPAccountServiceWrapper sInstance = new XPAccountServiceWrapper();
    private AccountInfo mAccountInfo;
    private volatile AccountManager mAccountManager;
    private Context mContext;
    private INavcoreContextInterface mContextInterface;
    private volatile boolean mIsLoginXp;
    private volatile UserInfo mUserInfo;
    @Nullable
    private volatile boolean mIsInitialized = false;
    private List<PreSwitchUserCallback> mPreCallbackList = new CopyOnWriteArrayList();
    private List<AccountEventCallback> mEventCallbackList = new CopyOnWriteArrayList();
    private volatile GuestAccountDataCallback mGuestAccountDataCallback = null;
    private UserInfo mTempUserInfo = new UserInfo();

    private XPAccountServiceWrapper() {
        this.mTempUserInfo.setData(0, 0, "-1", "");
    }

    @NonNull
    public static XPAccountServiceWrapper getInstance() {
        return sInstance;
    }

    public synchronized void setContextInterface(INavcoreContextInterface iNavcoreContextInterface) {
        this.mContextInterface = iNavcoreContextInterface;
    }

    @Override // android.accounts.OnAccountsUpdateListener
    public void onAccountsUpdated(Account[] accountArr) {
        handleAccountsUpdate();
    }

    private void handleAccountsUpdate() {
        initAccountLoginInfo(getCurrentAccountInfo());
        UserInfo userInfo = getUserInfo();
        if (userInfo == null) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, " onAccountsUpdated userInfo:" + userInfo.toString());
        }
        UserInfo.UserType userType = userInfo.getUserType();
        String userId = getUserId();
        RootUtil.saveTargetAccountProperty(this.mContext, userType);
        SettingWrapper.setTargetAccountUserId(userId);
        UserInfo.UserType naviAccountProperty = RootUtil.getNaviAccountProperty(this.mContext);
        String naviAccountUserId = SettingWrapper.getNaviAccountUserId();
        boolean z = (userType == naviAccountProperty && userId.equals(naviAccountUserId)) ? false : true;
        L.Tag tag2 = TAG;
        L.i(tag2, "onAccountsUpdated naviUserId=" + naviAccountUserId + "  targetUserId=" + userId + "---userNaviType=" + naviAccountProperty + " userTargetType=" + userType + ", userDiff = " + z);
        if (z) {
            if (this.mPreCallbackList.size() > 0) {
                for (int i = 0; i < this.mPreCallbackList.size(); i++) {
                    this.mPreCallbackList.get(i).preSwitchUser(naviAccountProperty, naviAccountUserId);
                }
            }
            int allSettingValue = SettingWrapper.getAllSettingValue();
            if (doUserStateUpdate(userType, userId)) {
                RootUtil.saveNaviAccountProperty(this.mContext, userType);
                SettingWrapper.setNaviAccountUserId(userId);
                if (this.mGuestAccountDataCallback != null) {
                    this.mGuestAccountDataCallback.handleGuestAccountData(naviAccountProperty, userType, allSettingValue);
                }
            }
            AccountObservable.getInstance().changed();
            AccountObservable.getInstance().notifyObservers(userInfo);
        }
    }

    public void login() {
        Activity currentActivity;
        synchronized (this) {
            currentActivity = this.mContextInterface != null ? this.mContextInterface.getCurrentActivity() : null;
        }
        if (!this.mIsInitialized || currentActivity == null) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "login failed --not init -- activity:" + currentActivity + " mIsInitialized:" + this.mIsInitialized);
                return;
            }
            return;
        }
        L.i(TAG, "login");
        this.mAccountManager.addAccount(Constants.ACCOUNT_TYPE_XP_VEHICLE, null, null, null, currentActivity, null, null);
    }

    private synchronized boolean doUserStateUpdate(UserInfo.UserType userType, String str) {
        boolean z;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "doUserStateUpdate userType= " + userType);
        }
        z = true;
        int type = AccountObservable.getType(userType);
        if (type != AccountObservable.getInstance().getUserHandle() || !AccountObservable.getInstance().getUserId().equals(str)) {
            AccountObservable.getInstance().setUserHandle(type);
            AccountObservable accountObservable = AccountObservable.getInstance();
            if (str == null) {
                str = "";
            }
            accountObservable.setUserId(str);
            L.Tag tag2 = TAG;
            L.i(tag2, "doUserStateUpdate account change to : " + type);
            z = true & updateContentProvider();
            FavoriteDataManager.getInstance().clearAllCache();
            if (UserInfo.UserType.TEMP != userType) {
                FavoriteDataManager.getInstance().getHome();
                FavoriteDataManager.getInstance().getCompany();
            }
        }
        return z;
    }

    public void initAccount(@NonNull Application application) {
        if (this.mIsInitialized) {
            return;
        }
        this.mContext = application;
        this.mAccountManager = AccountManager.get(this.mContext);
        if (this.mAccountManager != null) {
            L.i(TAG, "IAccount init successfully !");
            initAccountLoginInfo(getCurrentAccountInfo());
            if (doUserStateUpdate(getUserType(), getUserId())) {
                invokeInitAccountFinish();
            }
            FavoriteDataManager.getInstance().getHome();
            FavoriteDataManager.getInstance().getCompany();
            if (Build.VERSION.SDK_INT >= 26) {
                this.mAccountManager.addOnAccountsUpdatedListener(this, null, true, new String[]{Constants.ACCOUNT_TYPE_XP_VEHICLE});
            }
            this.mIsInitialized = true;
            return;
        }
        this.mIsInitialized = false;
        L.i(TAG, "IAccount init failed : can't get mIAccount ");
    }

    public void unInitAccount() {
        L.Tag tag = TAG;
        L.i(tag, "IAccount unInitAccount mIsInitialized=" + this.mIsInitialized);
        if (this.mIsInitialized) {
            this.mIsInitialized = false;
            if (Build.VERSION.SDK_INT >= 26) {
                this.mAccountManager.removeOnAccountsUpdatedListener(this);
            }
            this.mIsLoginXp = false;
            this.mUserInfo = null;
            this.mAccountInfo = null;
            this.mAccountManager = null;
            this.mIsInitialized = false;
            this.mPreCallbackList.clear();
            this.mEventCallbackList.clear();
            this.mGuestAccountDataCallback = null;
            this.mPreCallbackList = null;
            this.mEventCallbackList = null;
        }
    }

    private void initAccountLoginInfo(AccountInfo accountInfo) {
        synchronized (this) {
            this.mUserInfo = null;
            this.mAccountInfo = accountInfo;
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("initAccountLoginInfo ");
            sb.append(this.mAccountInfo != null ? this.mAccountInfo.toString() : "null");
            L.i(tag, sb.toString());
            if (this.mAccountInfo != null) {
                this.mUserInfo = this.mAccountInfo.getUserInfo();
            }
            if (this.mUserInfo == null) {
                this.mUserInfo = this.mTempUserInfo;
            }
            this.mIsLoginXp = getUserType() != UserInfo.UserType.TEMP;
        }
    }

    public void asyncGetOAuthCode(ICallback<String, IError> iCallback) {
        asyncGetOAuthCode(NAVI_APP_ID, iCallback);
    }

    public void asyncGetOAuthCode(@NonNull String str, @Nullable final ICallback<String, IError> iCallback) {
        synchronized (this) {
            Activity currentActivity = this.mContextInterface != null ? this.mContextInterface.getCurrentActivity() : null;
            if (iCallback != null && this.mIsInitialized && currentActivity != null) {
                Account account = this.mAccountInfo != null ? this.mAccountInfo.getAccount() : null;
                if (account == null) {
                    L.i(TAG, "asyncGetOAuthCode start login");
                    login();
                    return;
                }
                L.Tag tag = TAG;
                L.i(tag, "asyncGetOAuthCode start appId=" + str);
                Bundle bundle = new Bundle();
                bundle.putString("app_id", str);
                this.mAccountManager.getAuthToken(account, Constants.AUTH_TYPE_AUTH_CODE, bundle, currentActivity, new AccountManagerCallback<Bundle>() { // from class: com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper.1
                    @Override // android.accounts.AccountManagerCallback
                    public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                        XPAccountServiceWrapper.this.handleAccountResult(accountManagerFuture, iCallback);
                    }
                }, (Handler) null);
                return;
            }
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "asyncGetOAuthCode failed  mIsInitialized:" + this.mIsInitialized + " activity:" + currentActivity);
            }
        }
    }

    public void getOAuthCode(ICallback<String, IError> iCallback) {
        getOAuthCode(NAVI_APP_ID, iCallback);
    }

    public void getOAuthCode(@NonNull String str, @Nullable ICallback<String, IError> iCallback) {
        synchronized (this) {
            if (iCallback != null) {
                if (this.mIsInitialized) {
                    Account account = this.mAccountInfo != null ? this.mAccountInfo.getAccount() : null;
                    if (account == null) {
                        L.i(TAG, "getOAuthCode start login");
                        login();
                        return;
                    }
                    L.Tag tag = TAG;
                    L.i(tag, "getOAuthCode start appId=" + str);
                    Bundle bundle = new Bundle();
                    bundle.putString("app_id", str);
                    handleAccountResult(this.mAccountManager.getAuthToken(account, Constants.AUTH_TYPE_AUTH_CODE, bundle, false, (AccountManagerCallback<Bundle>) null, (Handler) null), iCallback);
                    return;
                }
            }
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "getOAuthCode failed --not init -- mIsInitialized:" + this.mIsInitialized);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAccountResult(AccountManagerFuture<Bundle> accountManagerFuture, ICallback<String, IError> iCallback) {
        try {
            String string = accountManagerFuture.getResult().getString("authtoken");
            String string2 = accountManagerFuture.getResult().getString("errorMessage", "");
            int i = accountManagerFuture.getResult().getInt("errorCode", -1);
            if (TextUtils.isEmpty(string)) {
                iCallback.onFail(new AutoCodeError(string2, i));
                L.Tag tag = TAG;
                L.i(tag, "handleAccountResult errMsg=" + string2 + " errCode:" + i);
            } else {
                L.Tag tag2 = TAG;
                L.i(tag2, "handleAccountResult onSuccess=" + string);
                iCallback.onSuccess(string);
            }
        } catch (AuthenticatorException | OperationCanceledException | IOException e) {
            e.printStackTrace();
            L.i(TAG, "handleAccountResult Exception");
            iCallback.onFail(new AutoCodeError("", 1));
        }
    }

    public UserInfo.UserType getUserType() {
        UserInfo.UserType targetAccountProperty;
        UserInfo userInfo = getUserInfo();
        if (userInfo != null) {
            targetAccountProperty = userInfo.getUserType();
        } else {
            L.e(TAG, "getUserType userInfo is null !");
            targetAccountProperty = RootUtil.getTargetAccountProperty(this.mContext);
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getUserType return " + targetAccountProperty.name());
        }
        return targetAccountProperty;
    }

    public String getUserId() {
        UserInfo userInfo = getUserInfo();
        if (userInfo != null) {
            return userInfo.getUserId();
        }
        L.e(TAG, "getUserType userInfo is null !");
        return SettingWrapper.getTargetAccountUserId();
    }

    public boolean isLoginXp() {
        return this.mIsLoginXp;
    }

    public boolean isTempType() {
        return !this.mIsLoginXp;
    }

    @Nullable
    public UserInfo getUserInfo() {
        return this.mUserInfo;
    }

    private AccountInfo getCurrentAccountInfo() {
        Account[] accountsByType = this.mAccountManager.getAccountsByType(Constants.ACCOUNT_TYPE_XP_VEHICLE);
        if (accountsByType.length > 0) {
            Account account = accountsByType[0];
            L.Tag tag = TAG;
            L.i(tag, "getCurrentAccountInfo accounts.length=" + accountsByType.length + ";account[0].name=" + account.name);
            String userData = this.mAccountManager.getUserData(account, Constants.USER_DATA_EXTRA_AVATAR);
            String userData2 = this.mAccountManager.getUserData(account, "update");
            String userData3 = this.mAccountManager.getUserData(account, "uid");
            String userData4 = this.mAccountManager.getUserData(account, Constants.ACCOUNT_USER_TYPE);
            L.Tag tag2 = TAG;
            L.i(tag2, "getCurrentAccountInfo1111  name=" + account.name + ";头像=" + userData + ";是否是更新=" + userData2 + ";账号类型=" + userData4 + ";uid=" + userData3);
            AccountInfo accountInfo = new AccountInfo(account);
            accountInfo.init(this.mAccountManager);
            return accountInfo;
        }
        return null;
    }

    private void printfAccounts(Account[] accountArr) {
        if (!L.ENABLE || accountArr == null) {
            return;
        }
        for (int i = 0; i < accountArr.length; i++) {
            Account account = accountArr[i];
            L.Tag tag = TAG;
            L.d(tag, "printfAccounts account[" + i + "].name=" + account.name);
        }
    }

    public boolean checkLoginState() {
        if (isLoginXp()) {
            return true;
        }
        login();
        return false;
    }

    private boolean updateContentProvider() {
        if (this.mContext == null) {
            return false;
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        ContentProviderClient acquireContentProviderClient = this.mContext.getContentResolver().acquireContentProviderClient(NavFavoriteProvider.AUTHORITY);
        try {
            if (acquireContentProviderClient != null) {
                try {
                    z = true & acquireContentProviderClient.getLocalContentProvider().onCreate();
                } catch (Exception e) {
                    L.Tag tag = TAG;
                    L.e(tag, "User switch updateContentProvider NavFavoriteProvider : " + e.getMessage());
                }
                acquireContentProviderClient.release();
            } else {
                L.Tag tag2 = TAG;
                L.e(tag2, "User switch updateContentProvider NavFavoriteProvider client = " + acquireContentProviderClient);
            }
            acquireContentProviderClient = this.mContext.getContentResolver().acquireContentProviderClient(DataSetHelper.AccountSet.AUTHORITY);
            if (acquireContentProviderClient != null) {
                try {
                    try {
                        z &= acquireContentProviderClient.getLocalContentProvider().onCreate();
                    } catch (Exception e2) {
                        L.Tag tag3 = TAG;
                        L.e(tag3, "User switch updateContentProvider AccountContentProvider : " + e2.getMessage());
                    }
                } finally {
                }
            } else {
                L.Tag tag4 = TAG;
                L.e(tag4, "User switch updateContentProvider AccountContentProvider client = " + acquireContentProviderClient);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            L.Tag tag5 = TAG;
            L.i(tag5, "updateContentProvider time cost : " + (currentTimeMillis2 - currentTimeMillis) + " ms");
            return z;
        } finally {
        }
    }

    public void registerPreCallback(PreSwitchUserCallback preSwitchUserCallback) {
        CollectionUtils.listAdd(this.mPreCallbackList, preSwitchUserCallback);
    }

    public void unRegisterPreCallback(PreSwitchUserCallback preSwitchUserCallback) {
        if (preSwitchUserCallback != null) {
            this.mPreCallbackList.remove(preSwitchUserCallback);
        }
    }

    public void registerAccountEventCallback(AccountEventCallback accountEventCallback) {
        CollectionUtils.listAdd(this.mEventCallbackList, accountEventCallback);
    }

    public void unRegisterAccountEventCallback(AccountEventCallback accountEventCallback) {
        if (accountEventCallback != null) {
            this.mEventCallbackList.remove(accountEventCallback);
        }
    }

    public void invokeXpMapLoginCallback() {
        for (int i = 0; i < this.mEventCallbackList.size(); i++) {
            this.mEventCallbackList.get(i).xpMapLogin();
        }
    }

    public void invokeAmapQuickLoginCallback() {
        for (int i = 0; i < this.mEventCallbackList.size(); i++) {
            this.mEventCallbackList.get(i).amapQuickLogin();
        }
    }

    public synchronized void invokeRefreshSettingCallback(int i, int i2) {
        L.Tag tag = TAG;
        L.i(tag, "refresh_setting_change invokeRefreshSettingCallback pre = " + i + " cur = " + i2);
        for (int i3 = 0; i3 < this.mEventCallbackList.size(); i3++) {
            this.mEventCallbackList.get(i3).refreshSettingInfos(i, i2);
        }
    }

    public void invokeAccountSyncFinishCallback() {
        for (int i = 0; i < this.mEventCallbackList.size(); i++) {
            this.mEventCallbackList.get(i).accountSyncFinish();
        }
    }

    public void invokeInitAccountFinish() {
        for (int i = 0; i < this.mEventCallbackList.size(); i++) {
            this.mEventCallbackList.get(i).initAccountFinish();
        }
    }

    public void setGuestAccountDataCallback(GuestAccountDataCallback guestAccountDataCallback) {
        this.mGuestAccountDataCallback = guestAccountDataCallback;
    }

    public String fetchAuthToken() {
        String str;
        Exception e;
        if (this.mAccountManager == null) {
            L.i(TAG, "XPAccountServiceWrapper has not init yet, mAccountManager is null");
            return null;
        } else if (RootUtil.isMainThread()) {
            throw new OnMainThreadException("fetchAuthToken can not run on main thread");
        } else {
            Account[] accountsByType = this.mAccountManager.getAccountsByType(Constants.ACCOUNT_TYPE_XP_VEHICLE);
            Account account = accountsByType.length > 0 ? accountsByType[0] : null;
            if (account == null) {
                L.i(TAG, "account is null, not login yet");
                return "";
            }
            Bundle bundle = new Bundle();
            bundle.putString("app_id", HttpConst.APP_ID_VALUE);
            AccountManagerFuture<Bundle> authToken = this.mAccountManager.getAuthToken(account, Constants.AUTH_TYPE_AUTH_CODE, bundle, false, (AccountManagerCallback<Bundle>) null, (Handler) null);
            try {
                str = authToken.getResult().getString("authtoken");
                try {
                    String string = authToken.getResult().getString("errorMessage", "");
                    this.mAccountManager.invalidateAuthToken(Constants.ACCOUNT_TYPE_XP_VEHICLE, str);
                    if (TextUtils.isEmpty(str)) {
                        L.Tag tag = TAG;
                        L.w(tag, "fetchAuthToken failed, token is empty, errMsg=" + string);
                    }
                    return str;
                } catch (AuthenticatorException e2) {
                    e = e2;
                    L.printStackTrace(TAG, e);
                    L.Tag tag2 = TAG;
                    L.d(tag2, "fetchAuthToken, token = " + str);
                    return str;
                } catch (OperationCanceledException e3) {
                    e = e3;
                    L.printStackTrace(TAG, e);
                    L.Tag tag22 = TAG;
                    L.d(tag22, "fetchAuthToken, token = " + str);
                    return str;
                } catch (IOException e4) {
                    e = e4;
                    L.printStackTrace(TAG, e);
                    L.Tag tag222 = TAG;
                    L.d(tag222, "fetchAuthToken, token = " + str);
                    return str;
                }
            } catch (AuthenticatorException | OperationCanceledException | IOException e5) {
                str = "";
                e = e5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class AutoCodeError implements IError {
        private int mCode;
        private String mMessage;

        public AutoCodeError(String str, int i) {
            this.mMessage = str;
            this.mCode = i;
        }

        @Override // com.xiaopeng.montecarlo.navcore.account.IError
        public String getMessage() {
            return this.mMessage;
        }

        @Override // com.xiaopeng.montecarlo.navcore.account.IError
        public int getCode() {
            return this.mCode;
        }
    }
}
