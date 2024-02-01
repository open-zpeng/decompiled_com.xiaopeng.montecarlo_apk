package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocPageType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocPageTypeDriveRadar = 4;
    public static final int LocPageTypeMain = 0;
    public static final int LocPageTypeNavi = 2;
    public static final int LocPageTypeNull = -1;
    public static final int LocPageTypePlan = 1;
    public static final int LocPageTypeResult = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocPageType1 {
    }
}
