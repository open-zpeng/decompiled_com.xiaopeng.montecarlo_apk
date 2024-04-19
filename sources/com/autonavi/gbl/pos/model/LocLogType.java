package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocLogType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocLogALL = 7;
    public static final int LocLogCKR = 4;
    public static final int LocLogEmpty = 0;
    public static final int LocLogLOC = 1;
    public static final int LocLogLOG = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocLogType1 {
    }
}
