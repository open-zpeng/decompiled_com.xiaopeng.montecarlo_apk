package com.xiaopeng.montecarlo.account.sync;

import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDeleteUserDataResponse;
/* loaded from: classes.dex */
public class AccountDeleteUserDataResult {
    public static final int DEL_ALL = 3;
    public static final int DEL_FAV = 1;
    public static final int DEL_HISTOTY = 2;
    int mDelType;
    AccountDeleteUserDataResponse mResponse;

    public void setDelType(int i) {
        this.mDelType = i;
    }

    public int getDelType() {
        return this.mDelType;
    }

    public void setResponse(AccountDeleteUserDataResponse accountDeleteUserDataResponse) {
        this.mResponse = accountDeleteUserDataResponse;
    }

    public AccountDeleteUserDataResponse getResponse() {
        return this.mResponse;
    }

    public String toString() {
        return "AccountDeleteUserDataResult{mDelType=" + this.mDelType + ", mResponse=" + this.mResponse + '}';
    }
}
