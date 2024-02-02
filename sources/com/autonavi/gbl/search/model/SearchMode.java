package com.autonavi.gbl.search.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class SearchMode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SEARCH_MODE_MAX = 4;
    public static final int SEARCH_MODE_OFFLINE_ADVANCED = 1;
    public static final int SEARCH_MODE_OFFLINE_ONLY = 3;
    public static final int SEARCH_MODE_ONLINE_ADVANCED = 0;
    public static final int SEARCH_MODE_ONLINE_ONLY = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface SearchMode1 {
    }
}
