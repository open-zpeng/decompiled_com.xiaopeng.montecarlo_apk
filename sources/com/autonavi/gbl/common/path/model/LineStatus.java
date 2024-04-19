package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LineStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LineStatusAmble = 4;
    public static final int LineStatusArrow = -1;
    public static final int LineStatusCharge = 16;
    public static final int LineStatusCongested = 6;
    public static final int LineStatusDefault = 2;
    public static final int LineStatusFaster = 128;
    public static final int LineStatusFerry = 7;
    public static final int LineStatusFree = 0;
    public static final int LineStatusInnerNavi = 1;
    public static final int LineStatusInnerNotNavi = 0;
    public static final int LineStatusJam = 5;
    public static final int LineStatusLimit = 32;
    public static final int LineStatusNoLimit = 0;
    public static final int LineStatusNormal = 0;
    public static final int LineStatusOpen = 3;
    public static final int LineStatusSlower = 64;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LineStatus1 {
    }
}
