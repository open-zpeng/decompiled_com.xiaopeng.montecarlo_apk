package com.autonavi.gbl.data.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class MapDataFileType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MAP_DATA_TYPE_FILE_3D = 3;
    public static final int MAP_DATA_TYPE_FILE_BUILDING_INDOOR = 11;
    public static final int MAP_DATA_TYPE_FILE_JV = 4;
    public static final int MAP_DATA_TYPE_FILE_JVLINK = 5;
    public static final int MAP_DATA_TYPE_FILE_MAP = 0;
    public static final int MAP_DATA_TYPE_FILE_MAP_INDOOR = 9;
    public static final int MAP_DATA_TYPE_FILE_POI = 1;
    public static final int MAP_DATA_TYPE_FILE_ROUTE = 2;
    public static final int MAP_DATA_TYPE_FILE_ROUTE_ADAS = 8;
    public static final int MAP_DATA_TYPE_FILE_ROUTE_INDOOR = 10;
    public static final int MAP_DATA_TYPE_FILE_ROUTE_LANE = 7;
    public static final int MAP_DATA_TYPE_FILE_VM = 6;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface MapDataFileType1 {
    }
}
