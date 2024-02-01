package com.autonavi.gbl.consis.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class ChannelMessagePosType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int MessagePosMax = 6999;
    public static final int MessagePosMin = 6000;
    public static final int MessagePosOnAttitudeAngleUpdate = 6006;
    public static final int MessagePosOnDebugInfoUpdate = 6009;
    public static final int MessagePosOnDrInfoUpdate = 6007;
    public static final int MessagePosOnLocInfoUpdate = 6001;
    public static final int MessagePosOnMapMatchFeedbackUpdate = 6010;
    public static final int MessagePosOnNgmInfoUpdate = 6005;
    public static final int MessagePosOnParallelRoadUpdate = 6002;
    public static final int MessagePosOnSensorParaUpdate = 6008;
    public static final int MessagePosOnSignInfoUpdate = 6004;
    public static final int MessagePosOnSwitchParallelRoadFinished = 6003;
    public static final int MessagePosRequestCallBackPos = 6501;
    public static final int MessagePosSwitchParallelRoad = 6502;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface ChannelMessagePosType1 {
    }
}
