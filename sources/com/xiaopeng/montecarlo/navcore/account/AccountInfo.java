package com.xiaopeng.montecarlo.navcore.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class AccountInfo {
    private static final L.Tag TAG = new L.Tag("AccountInfo");
    private final Account mAccount;
    private final UserInfo mUserInfo = new UserInfo();

    public AccountInfo(Account account) {
        this.mAccount = account;
    }

    public void init(AccountManager accountManager) {
        try {
            String userData = accountManager.getUserData(this.mAccount, "name");
            String userData2 = accountManager.getUserData(this.mAccount, Constants.USER_DATA_EXTRA_AVATAR);
            String userData3 = accountManager.getUserData(this.mAccount, "update");
            String userData4 = accountManager.getUserData(this.mAccount, Constants.ACCOUNT_USER_TYPE);
            String userData5 = accountManager.getUserData(this.mAccount, "uid");
            L.Tag tag = TAG;
            L.i(tag, "getCurrentAccountInfo name=" + userData + ";头像=" + userData2 + ";是否是更新=" + userData3 + ";账号类型=" + userData4 + ";uid=" + userData5);
            this.mUserInfo.setData(Integer.parseInt(userData3), Integer.parseInt(userData4), userData5, userData, userData2);
        } catch (Exception unused) {
        }
    }

    public Account getAccount() {
        return this.mAccount;
    }

    public UserInfo getUserInfo() {
        return this.mUserInfo;
    }

    public String toString() {
        return "AccountInfo{mAccount=" + this.mAccount.name + ", mUserInfo=" + this.mUserInfo + '}';
    }
}
