package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocTypeDrBack = 1;
    public static final int LocTypeDrFront = 2;
    public static final int LocTypeGNSS = 0;
    public static final int LocTypeUnknown = -1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocType1 {
    }
}
