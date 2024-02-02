package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class NetworkType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int NetworkType2G = 3;
    public static final int NetworkType3G = 4;
    public static final int NetworkType4G = 5;
    public static final int NetworkTypeNone = 0;
    public static final int NetworkTypeWifi = 2;
    public static final int NetworkTypeWwan = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface NetworkType1 {
    }
}
