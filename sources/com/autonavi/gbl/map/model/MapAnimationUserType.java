package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class MapAnimationUserType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MapAnimationNone = 0;
    public static final int MapAnimationNormalPitch = 32;
    public static final int MapAnimationNormalRoll = 16;
    public static final int MapAnimationNormalScale = 8;
    public static final int MapAnimationPivotRoll = 2;
    public static final int MapAnimationPivotScale = 1;
    public static final int MapAnimationProjctCenter = 64;
    public static final int MapAnimationTranslation = 4;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface MapAnimationUserType1 {
    }
}
