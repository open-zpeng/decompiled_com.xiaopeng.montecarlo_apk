package com.autonavi.gbl.map.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class ViaETAPathPointType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ViaETAPathPointTypeAutoAdd = 4;
    public static final int ViaETAPathPointTypeNone = 0;
    public static final int ViaETAPathPointTypeNormalVia = 1;
    public static final int ViaETAPathPointTypeUserAdd = 5;
    public static final int ViaETAPathPointTypeUserAddButNoNeedToCharge = 2;
    public static final int ViaETAPathPointTypeUserAddNeedToCharge = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface ViaETAPathPointType1 {
    }
}
