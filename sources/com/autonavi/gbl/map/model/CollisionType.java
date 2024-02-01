package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class CollisionType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int COLLISION_COMBINATION = 1;
    public static final int COLLISION_COMBINATION_AREA = 3;
    public static final int COLLISION_GROUP = 0;
    public static final int COLLISION_GROUP_AREA = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface CollisionType1 {
    }
}
