package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocStartDirType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocStartDirCompass = 3;
    public static final int LocStartDirFit = 2;
    public static final int LocStartDirGPS = 1;
    public static final int LocStartDirRoad = 4;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocStartDirType1 {
    }
}
