package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class TrafficLightCountDownStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int EnterGreenLight = 4;
    public static final int GreenLight = 5;
    public static final int None = 0;
    public static final int RedLight = 2;
    public static final int Suspend = 7;
    public static final int WaitRoundCount = 1;
    public static final int WillGreenLight = 3;
    public static final int WillRedLight = 6;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface TrafficLightCountDownStatus1 {
    }
}
