package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class PlayPointType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int PlayPointTypeComplex = 2;
    public static final int PlayPointTypeDetermine = 3;
    public static final int PlayPointTypeMix = 4;
    public static final int PlayPointTypeNormal = 1;
    public static final int PlayPointTypeVariable = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface PlayPointType1 {
    }
}
