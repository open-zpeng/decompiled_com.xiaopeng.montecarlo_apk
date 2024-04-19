package com.xiaopeng.montecarlo.root.account;
/* loaded from: classes3.dex */
public class UserInfo {
    public static final int USER_CHANGE = 0;
    public static final int USER_TYPE_DRIVER = 4;
    public static final int USER_TYPE_TEMP = 0;
    public static final int USER_TYPE_TENANT = 3;
    public static final int USER_TYPE_TOWNER = 1;
    public static final int USER_TYPE_USER = 2;
    public static final int USER_UPDATE = 1;
    private InfoType mInfoType = InfoType.CHANGED;
    private UserType mUserType = UserType.TEMP;
    private String mUserId = "-1";
    private String mName = "";
    private String mAvatar = "";

    /* loaded from: classes3.dex */
    public enum InfoType {
        CHANGED,
        UPDATE
    }

    /* loaded from: classes3.dex */
    public enum UserType {
        TEMP,
        OWNER,
        USER,
        TENANT,
        DRIVER
    }

    public String toString() {
        return "UserInfo{mInfoType=" + this.mInfoType + ", mUserType=" + this.mUserType + ", mUserId='" + this.mUserId + "', mName='" + this.mName + "'}";
    }

    public void setData(int i, int i2, String str, String str2, String str3) {
        this.mUserId = str;
        this.mName = str2;
        this.mAvatar = str3;
        if (i == 0) {
            this.mInfoType = InfoType.CHANGED;
        } else if (i == 1) {
            this.mInfoType = InfoType.UPDATE;
        }
        if (i2 == 1) {
            this.mUserType = UserType.OWNER;
        } else if (i2 == 2) {
            this.mUserType = UserType.USER;
        } else if (i2 == 3) {
            this.mUserType = UserType.TENANT;
        } else if (i2 == 4) {
            this.mUserType = UserType.DRIVER;
        } else {
            this.mUserType = UserType.TEMP;
        }
    }

    public InfoType getInfoType() {
        return this.mInfoType;
    }

    public UserType getUserType() {
        return this.mUserType;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mName;
    }

    public String getAvatar() {
        return this.mAvatar;
    }
}
