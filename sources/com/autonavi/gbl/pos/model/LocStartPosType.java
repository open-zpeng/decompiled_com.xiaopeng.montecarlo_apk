package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocStartPosType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocStartPosGPS = 1;
    public static final int LocStartPosMatchRoad = 3;
    public static final int LocStartPosMatchRoute = 4;
    public static final int LocStartPosNetwork = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocStartPosType1 {
    }
}
