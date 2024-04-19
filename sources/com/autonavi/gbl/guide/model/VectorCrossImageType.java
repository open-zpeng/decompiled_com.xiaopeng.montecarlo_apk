package com.autonavi.gbl.guide.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class VectorCrossImageType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int VectorCrossImageTypeCnt = 4;
    public static final int VectorCrossImageTypeCommon = 0;
    public static final int VectorCrossImageTypeConfusion = 2;
    public static final int VectorCrossImageTypeInvalid = -1;
    public static final int VectorCrossImageTypeNear = 3;
    public static final int VectorCrossImageTypeRoundabout = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface VectorCrossImageType1 {
    }
}
