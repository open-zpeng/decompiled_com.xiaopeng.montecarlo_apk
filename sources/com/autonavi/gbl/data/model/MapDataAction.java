package com.autonavi.gbl.data.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class MapDataAction {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MAP_DATA_ACTION_ADD = 1;
    public static final int MAP_DATA_ACTION_DELETE = 2;
    public static final int MAP_DATA_ACTION_SWITCH_SD = 4;
    public static final int MAP_DATA_ACTION_UPDATE = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface MapDataAction1 {
    }
}
