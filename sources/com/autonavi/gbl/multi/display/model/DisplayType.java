package com.autonavi.gbl.multi.display.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class DisplayType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int DisplayTypeDefault = 1;
    public static final int DisplayTypeEagleEye = 25;
    public static final int DisplayTypeHud = 17;
    public static final int DisplayTypeInvalid = -1;
    public static final int DisplayTypeJv = 23;
    public static final int DisplayTypeMainDisplay = 0;
    public static final int DisplayTypeWidget = 7;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface DisplayType1 {
    }
}
