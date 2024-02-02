package com.autonavi.gbl.user.account.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class AccountRequestType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int AccountTypeAvatar = 10;
    public static final int AccountTypeBindMobile = 1;
    public static final int AccountTypeCarltdBind = 11;
    public static final int AccountTypeCarltdCheckBind = 13;
    public static final int AccountTypeCarltdCheckToken = 14;
    public static final int AccountTypeCarltdLogin = 15;
    public static final int AccountTypeCarltdQLogin = 16;
    public static final int AccountTypeCarltdUnBind = 12;
    public static final int AccountTypeCheckExist = 0;
    public static final int AccountTypeInvaild = -1;
    public static final int AccountTypeLogout = 7;
    public static final int AccountTypeMobileLogin = 4;
    public static final int AccountTypeProfile = 9;
    public static final int AccountTypeQRCodeLogin = 5;
    public static final int AccountTypeQRCodeLoginConfirm = 6;
    public static final int AccountTypeRegister = 8;
    public static final int AccountTypeUnBindMobile = 2;
    public static final int AccountTypeUnRegister = 17;
    public static final int AccountTypeVerificationCode = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface AccountRequestType1 {
    }
}
