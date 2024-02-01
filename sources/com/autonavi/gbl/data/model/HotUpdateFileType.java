package com.autonavi.gbl.data.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class HotUpdateFileType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int HOTUPDATE_FILE_CHANGEPLAY = 2;
    public static final int HOTUPDATE_FILE_COMMON = 3;
    public static final int HOTUPDATE_FILE_CONFIG_FILE = 5;
    public static final int HOTUPDATE_FILE_GLOBAL = 0;
    public static final int HOTUPDATE_FILE_GLOBAL_E = 1;
    public static final int HOTUPDATE_FILE_INVALID = -1;
    public static final int HOTUPDATE_FILE_MIT_COMMOM = 6;
    public static final int HOTUPDATE_FILE_ROUTE_FILE = 4;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface HotUpdateFileType1 {
    }
}
