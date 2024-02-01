package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class ELaneSignalExceptReason {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ELaneSignalExceptEphemeris = 2;
    public static final int ELaneSignalExceptMounted = 4;
    public static final int ELaneSignalExceptNull = 0;
    public static final int ELaneSignalExceptPosEngine = 8;
    public static final int ELaneSignalExceptUnknown = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface ELaneSignalExceptReason1 {
    }
}
