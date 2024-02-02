package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class SearchAlongwayType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SearchAlongwayTypeATM = 2;
    public static final int SearchAlongwayTypeCharge = 1;
    public static final int SearchAlongwayTypeCng = 6;
    public static final int SearchAlongwayTypeFood = 7;
    public static final int SearchAlongwayTypeGas = 0;
    public static final int SearchAlongwayTypeMaintenance = 4;
    public static final int SearchAlongwayTypeNone = 9;
    public static final int SearchAlongwayTypeRestArea = 5;
    public static final int SearchAlongwayTypeRoadInfo = 8;
    public static final int SearchAlongwayTypeToilet = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface SearchAlongwayType1 {
    }
}
