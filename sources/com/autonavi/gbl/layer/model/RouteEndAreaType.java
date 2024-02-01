package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class RouteEndAreaType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int RouteEndAreaTypeAll = 4;
    public static final int RouteEndAreaTypeChild = 3;
    public static final int RouteEndAreaTypeInvalid = 0;
    public static final int RouteEndAreaTypeParent = 2;
    public static final int RouteEndAreaTypePolygon = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface RouteEndAreaType1 {
    }
}
