package com.autonavi.gbl.common.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LayType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LayTypeForbidden = 4;
    public static final int LayTypeJam = 1;
    public static final int LayTypeNotDef = 0;
    public static final int LayTypeOffMainRoadEvent = 2;
    public static final int LayTypeOnMainRoadEvent = 3;
    public static final int LayTypeTruckLimit = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LayType1 {
    }
}
