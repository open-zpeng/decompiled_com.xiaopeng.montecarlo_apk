package com.autonavi.gbl.search.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class SearchPoiRegionLevel {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SearchPoiRegionCity = 2;
    public static final int SearchPoiRegionDistrict = 3;
    public static final int SearchPoiRegionProvince = 1;
    public static final int SearchPoiRegionUndefined = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface SearchPoiRegionLevel1 {
    }
}
