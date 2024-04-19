package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class TrafficStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int TrafficStatusCongested = 4;
    public static final int TrafficStatusJam = 3;
    public static final int TrafficStatusOpen = 1;
    public static final int TrafficStatusSlow = 2;
    public static final int TrafficStatusUnkonw = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface TrafficStatus1 {
    }
}
