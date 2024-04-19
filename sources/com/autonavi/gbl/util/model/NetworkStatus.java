package com.autonavi.gbl.util.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class NetworkStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int NetworkStatus2G = 3;
    public static final int NetworkStatus3G = 4;
    public static final int NetworkStatus4G = 5;
    public static final int NetworkStatus5G = 7;
    public static final int NetworkStatusNotReachable = 1;
    public static final int NetworkStatusOther = 6;
    public static final int NetworkStatusWiFi = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface NetworkStatus1 {
    }
}
