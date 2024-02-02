package com.autonavi.gbl.lane.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class SRType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int Animal = 2;
    public static final int Bicycle = 6;
    public static final int Bus = 10;
    public static final int ConeBarrel = 82;
    public static final int ConstructionFence = 81;
    public static final int CrashBarrels = 80;
    public static final int MaxSRType = 200;
    public static final int Motorcycle = 8;
    public static final int Person = 1;
    public static final int Pickup = 11;
    public static final int SUV = 4;
    public static final int Sedan = 3;
    public static final int Tricycle = 7;
    public static final int Truck = 9;
    public static final int Unknown = 0;
    public static final int VAN = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface SRType1 {
    }
}
