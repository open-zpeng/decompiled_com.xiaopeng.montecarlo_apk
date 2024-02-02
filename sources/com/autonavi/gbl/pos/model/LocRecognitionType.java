package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocRecognitionType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocRecognitionDivergingPaths = 4;
    public static final int LocRecognitionNormalMainSideRoad = 1;
    public static final int LocRecognitionNull = 0;
    public static final int LocRecognitionTurningMainSideRoad = 2;
    public static final int LocRecognitionUTurnMainSideRoad = 3;
    public static final int LocRecognitionViaduct = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocRecognitionType1 {
    }
}
