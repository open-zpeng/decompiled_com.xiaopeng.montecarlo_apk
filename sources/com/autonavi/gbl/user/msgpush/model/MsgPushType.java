package com.autonavi.gbl.user.msgpush.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class MsgPushType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MsgPushDestination = 11;
    public static final int MsgPushLinkStatus = 7;
    public static final int MsgPushPlanPref = 9;
    public static final int MsgPushQuitNavi = 8;
    public static final int MsgPushSafeShare = 10;
    public static final int MsgPushTripod = 6;
    public static final int MsgPushTypeAimPoi = 1;
    public static final int MsgPushTypeAimRoute = 2;
    public static final int MsgPushTypeAutoPush = 0;
    public static final int MsgPushTypeEnd = 12;
    public static final int MsgPushTypeInvaild = -1;
    public static final int MsgPushTypePark = 3;
    public static final int MsgPushTypeTeam = 4;
    public static final int MsgResponseTypeTeam = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface MsgPushType1 {
    }
}
