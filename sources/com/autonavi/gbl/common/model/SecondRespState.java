package com.autonavi.gbl.common.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class SecondRespState {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int SecondRespFail = 2;
    public static final int SecondRespSuccess = 1;
    public static final int UnknownSecondResp = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface SecondRespState1 {
    }
}
