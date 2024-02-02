package com.autonavi.gbl.data.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class DataErrorType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int DATA_ERROR_TYPE_MAX = 4;
    public static final int DATA_ERROR_TYPE_NOT_MATCHED = 0;
    public static final int DATA_ERROR_TYPE_OPEN_FAILED = 1;
    public static final int DATA_ERROR_TYPE_PARSE_FAILED = 2;
    public static final int DATA_ERROR_TYPE_VERSION_NOT_MATCHED = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface DataErrorType1 {
    }
}
