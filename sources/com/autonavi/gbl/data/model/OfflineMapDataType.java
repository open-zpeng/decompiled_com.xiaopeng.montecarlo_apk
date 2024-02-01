package com.autonavi.gbl.data.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class OfflineMapDataType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int OFFLINE_MAP_DATA_TYPE_MAP = 1;
    public static final int OFFLINE_MAP_DATA_TYPE_MAP_INDOOR = 11;
    public static final int OFFLINE_MAP_DATA_TYPE_MAP_ROUTE = 2;
    public static final int OFFLINE_MAP_DATA_TYPE_MAP_ROUTE_EHP = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface OfflineMapDataType1 {
    }
}
