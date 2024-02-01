package com.autonavi.gbl.information.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class InformationBizType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int CarWash = 4;
    public static final int Dining = 2;
    public static final int Fuel = 1;
    public static final int Unknown = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface InformationBizType1 {
    }
}
