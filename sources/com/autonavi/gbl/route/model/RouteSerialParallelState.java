package com.autonavi.gbl.route.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class RouteSerialParallelState {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int RouteConcurrent = 1;
    public static final int RouteSerial = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface RouteSerialParallelState1 {
    }
}
