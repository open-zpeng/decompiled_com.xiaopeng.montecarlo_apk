package com.autonavi.gbl.common.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class ShowPathType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int PointShow = 0;
    public static final int SelectPathShow = 1;
    public static final int UnSelectPathShow = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface ShowPathType1 {
    }
}
