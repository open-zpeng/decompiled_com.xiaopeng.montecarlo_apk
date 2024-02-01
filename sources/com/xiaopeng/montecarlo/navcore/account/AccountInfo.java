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
            String userData = accountManager.getUserData(this.mAccount, Constants.USER_DATA_EXTRA_AVATAR);
            String userData2 = accountManager.getUserData(this.mAccount, "update");
            String userData3 = accountManager.getUserData(this.mAccount, Constants.ACCOUNT_USER_TYPE);
            String userData4 = accountManager.getUserData(this.mAccount, "uid");
            L.Tag tag = TAG;
            L.i(tag, "getCurrentAccountInfo name=" + this.mAccount.name + ";头像=" + userData + ";是否是更新=" + userData2 + ";账号类型=" + userData3 + ";uid=" + userData4);
            this.mUserInfo.setData(Integer.parseInt(userData2), Integer.parseInt(userData3), userData4, this.mAccount.name);
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
