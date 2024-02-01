package com.autonavi.gbl.common.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class PlayStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int finishPlay = 2;
    public static final int playFail = 3;
    public static final int startPlay = 1;
    public static final int statNotDef = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface PlayStatus1 {
    }
}
