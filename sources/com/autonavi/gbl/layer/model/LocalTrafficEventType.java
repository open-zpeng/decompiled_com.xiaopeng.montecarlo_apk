package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocalTrafficEventType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocalTrafficEventTypeAccident = 0;
    public static final int LocalTrafficEventTypeBreakdownVehicle = 1;
    public static final int LocalTrafficEventTypeRoadSlippery = 3;
    public static final int LocalTrafficEventTypeStaticEV = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocalTrafficEventType1 {
    }
}
