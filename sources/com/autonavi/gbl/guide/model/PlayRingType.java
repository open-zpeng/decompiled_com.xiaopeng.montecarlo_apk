package com.autonavi.gbl.guide.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class PlayRingType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int PlayRingTypeDing = 100;
    public static final int PlayRingTypeDong = 101;
    public static final int PlayRingTypeElecDing = 102;
    public static final int PlayRingTypeNULL = 0;
    public static final int PlayRingTypeNoPassbyNavi = 108;
    public static final int PlayRingTypeReroute = 1;
    public static final int PlayRingTypeSpeedOverDing = 103;
    public static final int PlayRingTypeTrafficLight = 110;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface PlayRingType1 {
    }
}
