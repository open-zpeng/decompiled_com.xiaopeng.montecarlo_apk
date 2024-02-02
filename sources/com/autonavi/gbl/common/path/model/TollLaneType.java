package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class TollLaneType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int TollLaneTypeAliPay = 8;
    public static final int TollLaneTypeAutomatric = 4;
    public static final int TollLaneTypeETC = 2;
    public static final int TollLaneTypeITC = 32;
    public static final int TollLaneTypeNULL = 0;
    public static final int TollLaneTypeNormal = 1;
    public static final int TollLaneTypeWechatPay = 16;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface TollLaneType1 {
    }
}
