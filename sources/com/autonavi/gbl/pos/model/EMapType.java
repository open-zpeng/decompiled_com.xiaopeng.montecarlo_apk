package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class EMapType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int EMapTypeInit = 0;
    public static final int EMapTypeNull = -1;
    public static final int EMapTypeOffline = 1;
    public static final int EMapTypeOnline = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface EMapType1 {
    }
}
