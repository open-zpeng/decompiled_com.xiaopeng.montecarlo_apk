package com.autonavi.gbl.pos.replay.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class PosReplayStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int PosReplayStatusInvalidStatus = 3;
    public static final int PosReplayStatusPause = 1;
    public static final int PosReplayStatusRunning = 0;
    public static final int PosReplayStatusStop = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface PosReplayStatus1 {
    }
}
