package com.autonavi.gbl.multi.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class DisplayType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int DISP_TYPE_DEFAULT = 1;
    public static final int DISP_TYPE_EAGLE_EYE = 25;
    public static final int DISP_TYPE_HUD = 17;
    public static final int DISP_TYPE_INVALID = -1;
    public static final int DISP_TYPE_JV = 23;
    public static final int DISP_TYPE_MAIN_DISP = 0;
    public static final int DISP_TYPE_WIDGET_NORMAL = 7;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface DisplayType1 {
    }
}
