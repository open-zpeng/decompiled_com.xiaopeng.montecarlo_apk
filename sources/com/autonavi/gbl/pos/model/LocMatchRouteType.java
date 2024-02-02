package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocMatchRouteType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocRouteBus = 1;
    public static final int LocRouteSubway = 2;
    public static final int LocRouteUnknown = 0;
    public static final int LocRouteWalk = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocMatchRouteType1 {
    }
}
