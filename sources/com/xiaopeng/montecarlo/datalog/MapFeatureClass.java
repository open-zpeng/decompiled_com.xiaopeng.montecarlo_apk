package com.xiaopeng.montecarlo.datalog;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class MapFeatureClass {
    public static final int CHARGE = 3;
    public static final int PATH = 5;
    public static final int PATH_BUBBLE = 4;
    public static final int RECOMMENDPARK = 2;
    public static final int RGC = 0;
    public static final int SEARCH_RESULT = 1;
    public static final int TRAFFIC = 6;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface MapFeatureCategory {
    }
}
