package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class UGCType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int UGCTypeClosed = 1;
    public static final int UGCTypeEffect = 2;
    public static final int UGCTypeJam = 3;
    public static final int UGCTypeNULL = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface UGCType1 {
    }
}
