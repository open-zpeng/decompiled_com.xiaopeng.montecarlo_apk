package com.autonavi.gbl.user.msgpush.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class MsgPushStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MsgPushStatusConnected = 0;
    public static final int MsgPushStatusDisconnected = 1;
    public static final int MsgPushStatusInvaild = -1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface MsgPushStatus1 {
    }
}
