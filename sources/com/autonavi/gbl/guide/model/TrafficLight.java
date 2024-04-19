package com.autonavi.gbl.guide.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class TrafficLight {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int GREEN = 1;
    public static final int INIT = 0;
    public static final int RED = 3;
    public static final int TRAFFICERROR = 9;
    public static final int YELLOW = 2;
    public static final int YELLOWFLASHING = 4;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface TrafficLight1 {
    }
}
