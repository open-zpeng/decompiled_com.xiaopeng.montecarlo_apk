package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocFeedbackType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocFeedbackBridge = 16;
    public static final int LocFeedbackCrossLink = 32;
    public static final int LocFeedbackElevated = 8;
    public static final int LocFeedbackInvalid = 0;
    public static final int LocFeedbackMatch = 1;
    public static final int LocFeedbackParking = 64;
    public static final int LocFeedbackRoundabout = 4;
    public static final int LocFeedbackTunnel = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocFeedbackType1 {
    }
}
