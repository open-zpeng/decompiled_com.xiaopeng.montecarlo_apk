package com.autonavi.gbl.guide.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class SapaDetailType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SapaDetailTypeChargeStation = 64;
    public static final int SapaDetailTypeGasStation = 1;
    public static final int SapaDetailTypeHotel = 32;
    public static final int SapaDetailTypeRepair = 8;
    public static final int SapaDetailTypeRestaurant = 2;
    public static final int SapaDetailTypeShopping = 16;
    public static final int SapaDetailTypeToilet = 4;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface SapaDetailType1 {
    }
}
