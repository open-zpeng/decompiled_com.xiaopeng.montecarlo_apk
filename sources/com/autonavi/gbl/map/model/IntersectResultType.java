package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class IntersectResultType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int HIDE_BOTH_PARAM = 3;
    public static final int HIDE_FIRST_PARAM = 1;
    public static final int HIDE_SECOND_PARAM = 2;
    public static final int NONE_INTERSECT = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface IntersectResultType1 {
    }
}
