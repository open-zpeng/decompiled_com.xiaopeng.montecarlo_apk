package com.autonavi.gbl.guide.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class ChangeNaviPathResult {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ChangeNaviPathResultErrorPathIDInvalid = 2;
    public static final int ChangeNaviPathResultErrorSamePathID = 3;
    public static final int ChangeNaviPathResultNULL = 0;
    public static final int ChangeNaviPathResultSuccess = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface ChangeNaviPathResult1 {
    }
}
