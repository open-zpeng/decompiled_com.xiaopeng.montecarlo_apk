package com.autonavi.gbl.lane.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class RoadLaneType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int Bus = 32;
    public static final int Emergency = 4;
    public static final int Hov = 262144;
    public static final int None = 0;
    public static final int Normal = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface RoadLaneType1 {
    }
}
