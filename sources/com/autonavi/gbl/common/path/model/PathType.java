package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class PathType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int PathTypeCustom = 255;
    public static final int PathTypeDrive = 1;
    public static final int PathTypeNULL = 0;
    public static final int PathTypeRide = 2;
    public static final int PathTypeWalk = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface PathType1 {
    }
}
