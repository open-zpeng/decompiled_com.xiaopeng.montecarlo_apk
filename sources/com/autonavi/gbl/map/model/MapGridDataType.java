package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class MapGridDataType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MAP_GRID_DATA_TYPE_INDOOR = 512;
    public static final int MAP_GRID_DATA_TYPE_LABEL = 64;
    public static final int MAP_GRID_DATA_TYPE_OPEN_LAYER = 128;
    public static final int MAP_GRID_DATA_TYPE_POI = 4;
    public static final int MAP_GRID_DATA_TYPE_POLYGON = 1;
    public static final int MAP_GRID_DATA_TYPE_ROAD = 2;
    public static final int MAP_GRID_DATA_TYPE_SATELLITE = 256;
    public static final int MAP_GRID_DATA_TYPE_SCENIC_GUIDE = 1024;
    public static final int MAP_GRID_DATA_TYPE_SCENIC_HDMAP = 4096;
    public static final int MAP_GRID_DATA_TYPE_SCENIC_HEAT = 2048;
    public static final int MAP_GRID_DATA_TYPE_SIMPLE3D = 8;
    public static final int MAP_GRID_DATA_TYPE_TMC2D = 16;
    public static final int MAP_GRID_DATA_TYPE_TMC3D = 32;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface MapGridDataType1 {
    }
}
