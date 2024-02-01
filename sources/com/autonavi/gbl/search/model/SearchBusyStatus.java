package com.autonavi.gbl.search.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class SearchBusyStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int Busy = 4;
    public static final int Enough = 2;
    public static final int Full = 5;
    public static final int Idle = 1;
    public static final int Less = 3;
    public static final int Unknown = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface SearchBusyStatus1 {
    }
}
