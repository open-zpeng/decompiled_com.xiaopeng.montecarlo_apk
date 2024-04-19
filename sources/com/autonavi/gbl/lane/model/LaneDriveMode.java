package com.autonavi.gbl.lane.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LaneDriveMode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LANE_DRIVE_MODE_AUTO_PILOT = 1;
    public static final int LANE_DRIVE_MODE_INVALID = 0;
    public static final int LANE_DRIVE_MODE_MANUAL_PILOT = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LaneDriveMode1 {
    }
}
