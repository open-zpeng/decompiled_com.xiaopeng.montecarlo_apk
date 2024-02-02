package com.autonavi.gbl.activation.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class ActivateErrorCode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int RETURN_NET_DEVICEID_NOT_EXIST = 106;
    public static final int RETURN_NET_DEVICEID_NOT_PASS = 107;
    public static final int RETURN_NET_ERROR_ACTIVATION = 110;
    public static final int RETURN_NET_ITEMNUM_NOT_EXIST = 104;
    public static final int RETURN_NET_ITEMNUM_NOT_NETACTIVE = 105;
    public static final int RETURN_NET_ORDERS_NOT_ENOUGH = 108;
    public static final int RETURN_NET_OVER_ACTIVATION = 109;
    public static final int RETURN_NET_SUCCESS = 101;
    public static final int RETURN_NET_UNKNOW_ERROR = 100;
    public static final int RETURN_NET_UUID_ERROR = 103;
    public static final int RETURN_NET_UUID_NULL = 102;
    public static final int RETURN_VALUE_CODE_CHECKERROR = 2;
    public static final int RETURN_VALUE_FAIL = 0;
    public static final int RETURN_VALUE_FILE_FLUSHFAIL = 10;
    public static final int RETURN_VALUE_FILE_OPENERROR = 3;
    public static final int RETURN_VALUE_FILE_SYNCFAIL = 9;
    public static final int RETURN_VALUE_INPUT_DEVIDERROR = 4;
    public static final int RETURN_VALUE_INPUT_ERROR = 8;
    public static final int RETURN_VALUE_INPUT_FILEDIRERROR = 5;
    public static final int RETURN_VALUE_INPUT_LOGINCODEERROR = 7;
    public static final int RETURN_VALUE_INPUT_USERCODEERROR = 6;
    public static final int RETURN_VALUE_SUCCESS = 1;
    public static final int RETURN_VALUE_UNINIT = -1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface ActivateErrorCode1 {
    }
}
