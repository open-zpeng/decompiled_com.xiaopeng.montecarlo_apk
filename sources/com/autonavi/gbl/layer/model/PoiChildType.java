package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class PoiChildType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int PoiChildTypeAirPort = 34;
    public static final int PoiChildTypeArrive = 44;
    public static final int PoiChildTypeDoor = 31;
    public static final int PoiChildTypeFly = 43;
    public static final int PoiChildTypeIn = 45;
    public static final int PoiChildTypeOut = 46;
    public static final int PoiChildTypePark = 41;
    public static final int PoiChildTypeStation = 999;
    public static final int PoiChildTypeSubway = 107;
    public static final int PoiChildTypeTicket = 42;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface PoiChildType1 {
    }
}
