package com.autonavi.gbl.search.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class SearchPoiIndoorType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SearchPoiIndoorMapAndParking = 3;
    public static final int SearchPoiIndoorMapOnly = 2;
    public static final int SearchPoiIndoorNo = 0;
    public static final int SearchPoiIndoorParkingOnly = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface SearchPoiIndoorType1 {
    }
}
