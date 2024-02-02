package com.autonavi.gbl.map.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class QuadrantType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int QuadrantTypeDown = 4;
    public static final int QuadrantTypeLeft = 1;
    public static final int QuadrantTypeLeftDown = 7;
    public static final int QuadrantTypeLeftUp = 6;
    public static final int QuadrantTypeNone = 0;
    public static final int QuadrantTypeRight = 2;
    public static final int QuadrantTypeRightDown = 8;
    public static final int QuadrantTypeRightUp = 5;
    public static final int QuadrantTypeUp = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface QuadrantType1 {
    }
}
