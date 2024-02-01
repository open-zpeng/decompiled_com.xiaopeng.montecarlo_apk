package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocPosFusionType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LOC_POS_FUSION_TYPE_NULL = -1;
    public static final int LOC_POS_FUSION_TYPE_WITHOUT_HDMAP = 2;
    public static final int LOC_POS_FUSION_TYPE_WITH_AUTONAVI_HDMAP = 0;
    public static final int LOC_POS_FUSION_TYPE_WITH_OTHER_HDMAP = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocPosFusionType1 {
    }
}
