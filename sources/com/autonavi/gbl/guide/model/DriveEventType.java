package com.autonavi.gbl.guide.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class DriveEventType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int DriveEventTypeMaxSpeed = 0;
    public static final int DriveEventTypeOverSpeed = 2;
    public static final int DriveEventTypeSuddenBrake = 3;
    public static final int DriveEventTypeYaw = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface DriveEventType1 {
    }
}
