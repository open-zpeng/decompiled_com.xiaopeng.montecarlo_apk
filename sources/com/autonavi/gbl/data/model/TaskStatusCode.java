package com.autonavi.gbl.data.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class TaskStatusCode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int TASK_STATUS_CODE_CHECKED = 6;
    public static final int TASK_STATUS_CODE_CHECKING = 5;
    public static final int TASK_STATUS_CODE_DOING = 2;
    public static final int TASK_STATUS_CODE_DONE = 4;
    public static final int TASK_STATUS_CODE_ERR = 10;
    public static final int TASK_STATUS_CODE_INVALID = 12;
    public static final int TASK_STATUS_CODE_MAX = 13;
    public static final int TASK_STATUS_CODE_PAUSE = 3;
    public static final int TASK_STATUS_CODE_READY = 0;
    public static final int TASK_STATUS_CODE_RECOVERING = 11;
    public static final int TASK_STATUS_CODE_SUCCESS = 9;
    public static final int TASK_STATUS_CODE_UNZIPPED = 8;
    public static final int TASK_STATUS_CODE_UNZIPPING = 7;
    public static final int TASK_STATUS_CODE_WAITING = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface TaskStatusCode1 {
    }
}
