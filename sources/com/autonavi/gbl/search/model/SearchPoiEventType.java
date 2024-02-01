package com.autonavi.gbl.search.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class SearchPoiEventType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SearchPoiEventImportance = 1;
    public static final int SearchPoiEventNoType = 0;
    public static final int SearchPoiEventNormal = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface SearchPoiEventType1 {
    }
}
