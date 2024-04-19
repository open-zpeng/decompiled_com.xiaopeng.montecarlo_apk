package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocOnRouteState {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocRerouting = 4;
    public static final int LocRouteFirstVirtual = 8;
    public static final int LocRouteNetwork = 128;
    public static final int LocRouteOff = 0;
    public static final int LocRouteOffPos = 256;
    public static final int LocRouteOn = 1;
    public static final int LocRoutePreMatch = 2;
    public static final int LocRouteSlightlyDeviation = 32;
    public static final int LocRouteTurnBackOff = 64;
    public static final int LocRouteViaductRerouting = 16;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocOnRouteState1 {
    }
}
