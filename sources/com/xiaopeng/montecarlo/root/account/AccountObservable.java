package com.xiaopeng.montecarlo.root.account;

import com.xiaopeng.montecarlo.root.account.UserInfo;
import java.util.Observable;
/* loaded from: classes2.dex */
public class AccountObservable extends Observable {
    public static final int USER_DRIVER = 4;
    public static final int USER_OWNER = 1;
    public static final int USER_TEMP = 0;
    public static final int USER_TENANT = 3;
    public static final int USER_USER = 2;
    private static final AccountObservable sInstance = new AccountObservable();
    private volatile int mUserHandle = getType(UserInfo.UserType.TEMP);
    private volatile String mUserId = "-1";

    public void setUserHandle(int i) {
        this.mUserHandle = i;
    }

    public int getUserHandle() {
        return this.mUserHandle;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public String getUserId() {
        return this.mUserId;
    }

    private AccountObservable() {
    }

    public static AccountObservable getInstance() {
        return sInstance;
    }

    public static int getType(UserInfo.UserType userType) {
        if (userType == UserInfo.UserType.USER) {
            return 2;
        }
        if (userType == UserInfo.UserType.OWNER) {
            return 1;
        }
        if (userType == UserInfo.UserType.TEMP) {
            return 0;
        }
        if (userType == UserInfo.UserType.TENANT) {
            return 3;
        }
        return userType == UserInfo.UserType.DRIVER ? 4 : 0;
    }

    public static UserInfo.UserType getUserType(int i) {
        if (i == 2) {
            return UserInfo.UserType.USER;
        }
        if (i == 1) {
            return UserInfo.UserType.OWNER;
        }
        if (i == 3) {
            return UserInfo.UserType.TENANT;
        }
        if (i == 4) {
            return UserInfo.UserType.DRIVER;
        }
        return UserInfo.UserType.TEMP;
    }

    public void changed() {
        setChanged();
    }
}
