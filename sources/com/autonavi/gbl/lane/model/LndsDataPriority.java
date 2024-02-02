package com.autonavi.gbl.lane.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class LndsDataPriority {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LndsDataDefault = 0;
    public static final int LndsDataOffline = 1;
    public static final int LndsDataOfflineFirst = 3;
    public static final int LndsDataOnline = 2;
    public static final int LndsDataOnlineFirst = 4;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface LndsDataPriority1 {
    }
}
