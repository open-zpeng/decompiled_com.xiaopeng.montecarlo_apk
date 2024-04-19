package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocSlopeType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocSlopeDown = 2;
    public static final int LocSlopeFlat = 3;
    public static final int LocSlopeNull = 0;
    public static final int LocSlopeUp = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocSlopeType1 {
    }
}
