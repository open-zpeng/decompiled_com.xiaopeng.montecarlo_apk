package com.autonavi.gbl.guide.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class TrafficEventAction {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int TrafficEventActionCountdown = 3;
    public static final int TrafficEventActionDMCountdown = 5;
    public static final int TrafficEventActionDataMining = 4;
    public static final int TrafficEventActionPopup = 2;
    public static final int TrafficEventActionShow = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface TrafficEventAction1 {
    }
}
