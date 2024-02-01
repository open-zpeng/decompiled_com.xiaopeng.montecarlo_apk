package com.autonavi.gbl.pos.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class LocNaviType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int LocNaviTypeBike = 1;
    public static final int LocNaviTypeBus = 3;
    public static final int LocNaviTypeCarplay = 4;
    public static final int LocNaviTypeDrive = 0;
    public static final int LocNaviTypeNull = -1;
    public static final int LocNaviTypeWalk = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface LocNaviType1 {
    }
}
