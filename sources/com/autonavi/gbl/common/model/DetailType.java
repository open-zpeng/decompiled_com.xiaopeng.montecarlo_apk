package com.autonavi.gbl.common.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class DetailType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int AvoidForbidden = 23;
    public static final int Congest = 1;
    public static final int DetailTypeNull = 0;
    public static final int OutLineTruckLimit = 16;
    public static final int PoliceEnd = 7;
    public static final int PoliceRoute = 6;
    public static final int Restiction = 21;
    public static final int RestrictETD = 22;
    public static final int TrafficUgc = 2;
    public static final int TruckLimit = 15;
    public static final int UnAvoidForbidden = 4;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface DetailType1 {
    }
}
