package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class ELaneAlgType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ELaneAlgAR = 1;
    public static final int ELaneAlgComb = 2;
    public static final int ELaneAlgDrAFSV2 = 3;
    public static final int ELaneAlgNone = -1;
    public static final int ELaneAlgRTK = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface ELaneAlgType1 {
    }
}
