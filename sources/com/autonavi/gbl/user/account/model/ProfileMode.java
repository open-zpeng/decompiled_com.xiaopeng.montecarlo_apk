package com.autonavi.gbl.user.account.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class ProfileMode {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int ProfileModeBasic = 1;
    public static final int ProfileModeCar = 32;
    public static final int ProfileModeCheckin = 16;
    public static final int ProfileModeContact = 2;
    public static final int ProfileModeDefault = 0;
    public static final int ProfileModeLevel = 8;
    public static final int ProfileModeProvider = 4;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface ProfileMode1 {
    }
}
