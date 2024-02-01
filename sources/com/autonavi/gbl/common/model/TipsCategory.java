package com.autonavi.gbl.common.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class TipsCategory {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int CategoryAvoidJam = 2;
    public static final int CategoryCommon = 0;
    public static final int CategoryEventInfo = 4;
    public static final int CategoryForbidden = 1;
    public static final int CategoryHoliday = 5;
    public static final int CategoryOpentime = 6;
    public static final int CategoryRestrict = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface TipsCategory1 {
    }
}
