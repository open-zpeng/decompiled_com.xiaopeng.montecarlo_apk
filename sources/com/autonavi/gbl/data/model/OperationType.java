package com.autonavi.gbl.data.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class OperationType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int OPERATION_TYPE_CANCEL = 2;
    public static final int OPERATION_TYPE_DELETE = 3;
    public static final int OPERATION_TYPE_MAX = 4;
    public static final int OPERATION_TYPE_PAUSE = 1;
    public static final int OPERATION_TYPE_START = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface OperationType1 {
    }
}
