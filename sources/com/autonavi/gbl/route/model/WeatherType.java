package com.autonavi.gbl.route.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class WeatherType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int WeatherTypeBad = 2;
    public static final int WeatherTypeNormal = 1;
    public static final int WeatherTypeUndefined = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface WeatherType1 {
    }
}
