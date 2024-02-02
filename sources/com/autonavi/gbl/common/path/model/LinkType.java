package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LinkType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LinkTypeBridge = 3;
    public static final int LinkTypeCommon = 0;
    public static final int LinkTypeCount = 5;
    public static final int LinkTypeElevatedRd = 4;
    public static final int LinkTypeFerry = 1;
    public static final int LinkTypeNull = -1;
    public static final int LinkTypeTunnel = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LinkType1 {
    }
}
