package com.autonavi.gbl.user.msgpush.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class ParkCode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MsgPushParkEnter = 0;
    public static final int MsgPushParkInvalid = -1;
    public static final int MsgPushParkLeave = 4;
    public static final int MsgPushParkSentryPaid = 2;
    public static final int MsgPushParkSentryPayFailed = 3;
    public static final int MsgPushParkSentryUnpaid = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface ParkCode1 {
    }
}
