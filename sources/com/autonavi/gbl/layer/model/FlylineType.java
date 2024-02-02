package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class FlylineType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int FlylineTypeCruise = 0;
    public static final int FlylineTypeResultDetail = 2;
    public static final int FlylineTypeResultList = 1;
    public static final int FlylineTypeSelectPOI = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface FlylineType1 {
    }
}
