package com.autonavi.gbl.guide.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class SoundCategory {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SoundCategoryAfter = 1;
    public static final int SoundCategoryCnt = 6;
    public static final int SoundCategoryFar = 2;
    public static final int SoundCategoryMiddle = 3;
    public static final int SoundCategoryNear = 4;
    public static final int SoundCategoryNull = 0;
    public static final int SoundCategoryOk = 5;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface SoundCategory1 {
    }
}
