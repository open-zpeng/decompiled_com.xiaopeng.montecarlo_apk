package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class BizTempErrorCode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int BIZ_TEMP_ERROR_FAILED = -2;
    public static final int BIZ_TEMP_ERROR_LOAD_FAILD = -3;
    public static final int BIZ_TEMP_ERROR_NOT_INITED = -4;
    public static final int BIZ_TEMP_ERROR_SCENE_NOT_FOUND = -1;
    public static final int BIZ_TEMP_OK = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface BizTempErrorCode1 {
    }
}
