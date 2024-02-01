package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LimitTipsType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LimitTipsTypeAvoidFutureSuccess = 7;
    public static final int LimitTipsTypeAvoidSuccess = 2;
    public static final int LimitTipsTypeExpiredImmediately = 8;
    public static final int LimitTipsTypeInvalid = -1;
    public static final int LimitTipsTypeLimitMax = 11;
    public static final int LimitTipsTypeNoPlate = 0;
    public static final int LimitTipsTypeNotOpen = 1;
    public static final int LimitTipsTypeRegionCross = 6;
    public static final int LimitTipsTypeRegionEnd = 4;
    public static final int LimitTipsTypeRegionStart = 3;
    public static final int LimitTipsTypeRegionVia = 5;
    public static final int LimitTipsTypeWaitLimitOff = 9;
    public static final int LimitTipsTypeWaitLimitOffShort = 10;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LimitTipsType1 {
    }
}
