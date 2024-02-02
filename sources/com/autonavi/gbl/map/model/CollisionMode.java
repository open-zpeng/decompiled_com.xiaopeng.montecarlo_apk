package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class CollisionMode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int CollisionModeCollision = 0;
    public static final int CollisionModeNoCollision = 1;
    public static final int CollisionModeNoCollisionInCombination = 7;
    public static final int CollisionModeNoCollisionInGroup = 4;
    public static final int CollisionModeNotCollideOther = 3;
    public static final int CollisionModeNotCollideOtherInCombination = 9;
    public static final int CollisionModeNotCollideOtherInGroup = 6;
    public static final int CollisionModeNotCollidedByOther = 2;
    public static final int CollisionModeNotCollidedByOtherInCombination = 8;
    public static final int CollisionModeNotCollidedByOtherInGroup = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface CollisionMode1 {
    }
}
