package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocFuncSwitch {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocFuncAbsolutePosCorrection = 8;
    public static final int LocFuncConfusingTurning = 1024;
    public static final int LocFuncDelayTurningLowSpeed = 64;
    public static final int LocFuncDivergingPathsRecognize = 16;
    public static final int LocFuncEHPEnable = 16384;
    public static final int LocFuncForbinParkingReroute = 33554432;
    public static final int LocFuncForkQuickCorrection = 512;
    public static final int LocFuncLeaveRoundabout = 4096;
    public static final int LocFuncMainSideRoadDecision = 4;
    public static final int LocFuncParallelRecognize = 2;
    public static final int LocFuncPatchFrameForFeiGeG8G9 = 536870912;
    public static final int LocFuncPosDataEnable = 8192;
    public static final int LocFuncRerouteByLaneResult = 67108864;
    public static final int LocFuncReroutingByCruiseDivergingPaths = 4194304;
    public static final int LocFuncReroutingByCruiseMainSideRoad = 2097152;
    public static final int LocFuncReroutingByCruiseTunnelCorrection = 8388608;
    public static final int LocFuncReroutingByCruiseViaduct = 1048576;
    public static final int LocFuncReroutingRejectorARS = 131072;
    public static final int LocFuncReroutingRejectorCross = 524288;
    public static final int LocFuncReroutingRejectorDist = 262144;
    public static final int LocFuncReroutingRejectorPassOver = 65536;
    public static final int LocFuncTrackGraspRoad = 1073741824;
    public static final int LocFuncTunnelCorrection = 2048;
    public static final int LocFuncTurningMainSideRoad = 128;
    public static final int LocFuncTurningSmooth = 32;
    public static final int LocFuncUTurnMatch = 256;
    public static final int LocFuncViaductRecognize = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocFuncSwitch1 {
    }
}
