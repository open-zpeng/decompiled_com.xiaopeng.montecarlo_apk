package com.autonavi.gbl.data.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class OperationErrCode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int OPERATION_CODE_MAX = 19;
    public static final int OPERATION_CODE_UNKONW_INVALID = 16;
    public static final int OPERATION_ERROR_CODE_NET_DATA_INVALID = 6;
    public static final int OPERATION_ERR_CODE_CHECK_INVALID = 7;
    public static final int OPERATION_ERR_CODE_CORRECT = 0;
    public static final int OPERATION_ERR_CODE_DB_INVALID = 17;
    public static final int OPERATION_ERR_CODE_FILE_MOVE_INVALID = 15;
    public static final int OPERATION_ERR_CODE_FILE_OPEN_INVALID = 11;
    public static final int OPERATION_ERR_CODE_FILE_READ_INVALID = 13;
    public static final int OPERATION_ERR_CODE_FILE_RENAME_INVALID = 12;
    public static final int OPERATION_ERR_CODE_FILE_WRITE_INVALID = 14;
    public static final int OPERATION_ERR_CODE_JSON_INVALID = 18;
    public static final int OPERATION_ERR_CODE_MERGER_INVALID = 9;
    public static final int OPERATION_ERR_CODE_NET_CONNECT_TIMEOUT = 3;
    public static final int OPERATION_ERR_CODE_NET_DNS_TIMEOUT = 2;
    public static final int OPERATION_ERR_CODE_NET_NONE = 1;
    public static final int OPERATION_ERR_CODE_NET_RECV_FAILED = 5;
    public static final int OPERATION_ERR_CODE_NET_SEND_FAILED = 4;
    public static final int OPERATION_ERR_CODE_SPACE_UNENOUTH = 10;
    public static final int OPERATION_ERR_CODE_UNZIP_INVALID = 8;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface OperationErrCode1 {
    }
}
