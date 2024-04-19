package com.autonavi.gbl.common.path.option;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class RouteConstrainCode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int RouteAvoidFreeway = 1;
    public static final int RouteCalcKeyPoint = 512;
    public static final int RouteCalcLocal = 256;
    public static final int RouteCalcMulti = 4;
    public static final int RouteConstrainCodeInvalid = 0;
    public static final int RouteElecContinue = 16384;
    public static final int RouteExclusive = 8;
    public static final int RouteFreewayStrategy = 64;
    public static final int RouteNetWorking = 8192;
    public static final int RouteTMCStrategy = 16;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface RouteConstrainCode1 {
    }
}
