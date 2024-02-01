package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocPosFusionInputState {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LOC_POS_FUSION_INPUT_LOW_FREQUENCY = 1;
    public static final int LOC_POS_FUSION_INPUT_NORMAL_FREQUENCY = 0;
    public static final int LOC_POS_FUSION_INPUT_NULL = -1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocPosFusionInputState1 {
    }
}
