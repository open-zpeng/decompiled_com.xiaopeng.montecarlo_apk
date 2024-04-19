package com.autonavi.gbl.map.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class VectorCrossViewPostureEvent {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ViewPostureCrossingSwitch = 4;
    public static final int ViewPostureSwitch = 1;
    public static final int ViewPostureTrackStart = 2;
    public static final int ViewPostureTrackStop = 3;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface VectorCrossViewPostureEvent1 {
    }
}
