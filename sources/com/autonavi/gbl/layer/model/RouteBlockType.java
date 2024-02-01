package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class RouteBlockType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int RouteBlockHasAvoid = 4;
    public static final int RouteBlockInEndPoint = 2;
    public static final int RouteBlockInPath = 3;
    public static final int RouteBlockInStartPoint = 0;
    public static final int RouteBlockInViaPoint = 1;
    public static final int RouteNonblockInPath = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface RouteBlockType1 {
    }
}
