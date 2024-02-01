package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class RoadClass {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int RoadClassCitySpeedway = 6;
    public static final int RoadClassCommonRoad = 9;
    public static final int RoadClassCount = 11;
    public static final int RoadClassCountyRoad = 3;
    public static final int RoadClassFreeway = 0;
    public static final int RoadClassInCountyRoad = 5;
    public static final int RoadClassMainRoad = 7;
    public static final int RoadClassNULL = -1;
    public static final int RoadClassNationalRoad = 1;
    public static final int RoadClassNonNaviRoad = 10;
    public static final int RoadClassProvinceRoad = 2;
    public static final int RoadClassRuralRoad = 4;
    public static final int RoadClassSecondaryRoad = 8;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface RoadClass1 {
    }
}
