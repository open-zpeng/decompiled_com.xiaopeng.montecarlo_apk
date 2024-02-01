package com.autonavi.gbl.lane.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LanePlayerOpenMessageType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LanePlayerOpenMessageTypeDynamicViewAngle = 1;
    public static final int LanePlayerOpenMessageTypeLCC = 2;
    public static final int LanePlayerOpenMessageTypeLaneChangeFocusing = 6;
    public static final int LanePlayerOpenMessageTypeShowNaviLine = 3;
    public static final int LanePlayerOpenMessageTypeShowNaviLineFishbone = 4;
    public static final int LanePlayerOpenMessageTypeShowNaviLineOutline = 5;
    public static final int LanePlayerOpenMessageTypeUnknown = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LanePlayerOpenMessageType1 {
    }
}
