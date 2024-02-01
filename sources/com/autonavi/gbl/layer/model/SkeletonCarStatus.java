package com.autonavi.gbl.layer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class SkeletonCarStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SkeletonCarStatusMove = 1;
    public static final int SkeletonCarStatusSpeed = 2;
    public static final int SkeletonCarStatusStatic = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface SkeletonCarStatus1 {
    }
}
