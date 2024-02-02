package com.autonavi.gbl.common.path.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class AbnormalStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int AbnormalStatusFaster = 2;
    public static final int AbnormalStatusNULL = 0;
    public static final int AbnormalStatusSlower = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface AbnormalStatus1 {
    }
}
