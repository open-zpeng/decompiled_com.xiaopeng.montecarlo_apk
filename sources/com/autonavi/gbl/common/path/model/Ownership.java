package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class Ownership {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int Ownership3DParkRoad = 4;
    public static final int OwnershipInternalRoad = 1;
    public static final int OwnershipPrivateRoad = 2;
    public static final int OwnershipPublicRoad = 0;
    public static final int OwnershipUndergroundParkRoad = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface Ownership1 {
    }
}
