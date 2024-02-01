package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class MergeInfoType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MergeInfoAutoAdd = 4;
    public static final int MergeInfoNormalVia = 1;
    public static final int MergeInfoUnknownType = 0;
    public static final int MergeInfoUserAddButNoNeedToCharge = 2;
    public static final int MergeInfoUserAddNeedToCharge = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface MergeInfoType1 {
    }
}
