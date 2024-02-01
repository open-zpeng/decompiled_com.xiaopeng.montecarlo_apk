package com.autonavi.gbl.route.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class RouteCollisionSolution {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int AutoCollision = 1;
    public static final int DiceCollision = 0;
    public static final int JsonFileCollision = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface RouteCollisionSolution1 {
    }
}
