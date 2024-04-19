package com.autonavi.gbl.user.account.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class VerificationCodeType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int VerificationCodeTypeBindEmail = 4;
    public static final int VerificationCodeTypeBindMobile = 3;
    public static final int VerificationCodeTypeChangeBind = 15;
    public static final int VerificationCodeTypeInvalid = 0;
    public static final int VerificationCodeTypeMobileLogin = 9;
    public static final int VerificationCodeTypeRegister = 1;
    public static final int VerificationCodeTypeResetPassword = 2;
    public static final int VerificationCodeTypeTakeTaxi = 5;
    public static final int VerificationCodeTypeUnRegister = 16;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface VerificationCodeType1 {
    }
}
