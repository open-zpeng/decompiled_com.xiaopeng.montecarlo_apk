package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class AlongWayLabelType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int AlongWayLabelTypeBestWay = 1;
    public static final int AlongWayLabelTypeExtraETA = 3;
    public static final int AlongWayLabelTypeFastWay = 2;
    public static final int AlongWayLabelTypeNone = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface AlongWayLabelType1 {
    }
}
