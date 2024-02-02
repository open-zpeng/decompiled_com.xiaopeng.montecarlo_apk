package com.autonavi.gbl.aosclient.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class ENETWORKSTATUS {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int NETWORKSTATUS_CANCELED = 6;
    public static final int NETWORKSTATUS_FAILED = 5;
    public static final int NETWORKSTATUS_IDLE = 0;
    public static final int NETWORKSTATUS_RECEIVING = 3;
    public static final int NETWORKSTATUS_RECEIVING_HEADER = 2;
    public static final int NETWORKSTATUS_SENDING = 1;
    public static final int NETWORKSTATUS_SUCCESSED = 4;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface ENETWORKSTATUS1 {
    }
}
