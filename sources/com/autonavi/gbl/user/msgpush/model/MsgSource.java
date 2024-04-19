package com.autonavi.gbl.user.msgpush.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class MsgSource {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MsgSourceInvalid = 0;
    public static final int MsgSourceMqtt = 1;
    public static final int MsgSourceWebSocket = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface MsgSource1 {
    }
}
