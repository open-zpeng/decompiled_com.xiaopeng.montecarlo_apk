package com.autonavi.gbl.common.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class DetailCategory {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int CategoryAvoidJamDetail = 1;
    public static final int CategoryDefaultDetail = 0;
    public static final int CategoryEventDetail = 2;
    public static final int CategoryForbiddenDetail = 3;
    public static final int CategoryRestrictDetail = 4;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface DetailCategory1 {
    }
}
