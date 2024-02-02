package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class PlayMode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int PlayModeCyclePerSegment = 3;
    public static final int PlayModeOncePerSegment = 2;
    public static final int PlayModeOnlyOnce = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface PlayMode1 {
    }
}
