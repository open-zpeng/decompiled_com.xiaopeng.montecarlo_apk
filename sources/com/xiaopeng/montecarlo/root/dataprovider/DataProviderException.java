package com.xiaopeng.montecarlo.root.dataprovider;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class DataProviderException extends Exception {
    public static final int DB_COMMON_ERROR_CODE = 300;
    public static final int ERROR_CODE_NONE = 0;
    public static final int IO_COMMON_ERROR_CODE = 500;
    public static final int NETWORK_COMMON_ERROR_CODE = 100;
    public static final int SERVER_COMMON_ERROR_CODE = 200;
    public static final int TIMEOUT_ERROR_CODE = 600;
    public static final int UNKNOWN_COMMON_ERROR_CODE = 400;
    private int mErrorCode;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface DataProviderCommonErrorCode {
    }

    public DataProviderException(String str) {
        this(400, str);
    }

    public DataProviderException(int i, String str) {
        super(str == null ? "" : str);
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }
}
