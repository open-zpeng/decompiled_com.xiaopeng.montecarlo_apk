package com.autonavi.gbl.map.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class AnimationState {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int AnimationStateFinished = 0;
    public static final int AnimationStateTouchesBeganMapZoomOrMoveFinish = 1;
    public static final int AnimationStateZoomOrMoveFinish = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface AnimationState1 {
    }
}
