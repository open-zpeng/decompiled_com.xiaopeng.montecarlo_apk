package com.autonavi.gbl.common.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class CloudInfoErrorCode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int cloudInfoAbort = 2;
    public static final int cloudInfoAccessErr = 3;
    public static final int cloudInfoGetAdcodeError = 9;
    public static final int cloudInfoGetAdcodeFail = 13;
    public static final int cloudInfoInnerError = 8;
    public static final int cloudInfoNoFound = 11;
    public static final int cloudInfoNoInfo = 7;
    public static final int cloudInfoNoNet = 1;
    public static final int cloudInfoNoPath = 12;
    public static final int cloudInfoNoPlateInfo = 6;
    public static final int cloudInfoParamErr = 4;
    public static final int cloudInfoRequestFail = 10;
    public static final int cloudInfoSuccess = 0;
    public static final int cloudInfoUnkonwErr = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface CloudInfoErrorCode1 {
    }
}
