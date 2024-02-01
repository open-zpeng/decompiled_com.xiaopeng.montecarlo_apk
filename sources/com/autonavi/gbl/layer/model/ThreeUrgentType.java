package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class ThreeUrgentType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int OverSpeed = 4;
    public static final int RapidAcceleration = 1;
    public static final int RapidDeceleration = 3;
    public static final int SharpTurn = 2;
    public static final int ThreeUrgentAndOneOverSpeedTypeNone = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface ThreeUrgentType1 {
    }
}
