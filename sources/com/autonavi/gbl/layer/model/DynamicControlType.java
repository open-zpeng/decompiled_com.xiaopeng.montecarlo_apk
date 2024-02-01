package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class DynamicControlType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int Biz = 0;
    public static final int Custom1 = 2;
    public static final int Custom2 = 3;
    public static final int Custom3 = 4;
    public static final int Custom4 = 5;
    public static final int Custom5 = 6;
    public static final int Scene = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface DynamicControlType1 {
    }
}
