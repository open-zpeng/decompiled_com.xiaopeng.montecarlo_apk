package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class FlylineDrawMode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int FLYLINE_CLICKED_CHARGING_STATION_END = 5;
    public static final int FLYLINE_CLICKED_NORMAL_END = 3;
    public static final int FLYLINE_CLICKED_TRAFFIC_EVENT_END = 4;
    public static final int FLYLINE_MOVE_END = 1;
    public static final int FLYLINE_NONE_END = 0;
    public static final int FLYLINE_SELECT_END = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface FlylineDrawMode1 {
    }
}
