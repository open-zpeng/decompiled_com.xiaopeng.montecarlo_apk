package com.autonavi.gbl.data.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class MapDataMode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MAP_DATA_MODE_BASE = 0;
    public static final int MAP_DATA_MODE_EHP_ADAS = 1;
    public static final int MAP_DATA_MODE_EHP_ADAS_LANE = 2;
    public static final int MAP_DATA_MODE_EHP_ADAS_LANE_PARKING = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface MapDataMode1 {
    }
}
