package com.autonavi.gbl.map.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class PathPointType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int PathPointTypeElecContinueVia = 3;
    public static final int PathPointTypeEnd = 1;
    public static final int PathPointTypeEnergyEmpty = 4;
    public static final int PathPointTypeEnergyRemain = 5;
    public static final int PathPointTypeNone = -1;
    public static final int PathPointTypeStart = 0;
    public static final int PathPointTypeVia = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface PathPointType1 {
    }
}
