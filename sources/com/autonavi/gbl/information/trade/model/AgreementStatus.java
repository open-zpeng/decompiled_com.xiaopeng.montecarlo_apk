package com.autonavi.gbl.information.trade.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class AgreementStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int Expired = 3;
    public static final int Init = 0;
    public static final int SignFail = 1;
    public static final int Success = 2;
    public static final int Unknown = -1;
    public static final int Unsign = 4;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface AgreementStatus1 {
    }
}
