package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class VehicleType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int VehicleTypeAll = 1;
    public static final int VehicleTypeHeavy = 32;
    public static final int VehicleTypeLight = 8;
    public static final int VehicleTypeMedium = 16;
    public static final int VehicleTypeMini = 4;
    public static final int VehicleTypePreserve = 128;
    public static final int VehicleTypePull = 64;
    public static final int VehicleTypeSmall = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface VehicleType1 {
    }
}
