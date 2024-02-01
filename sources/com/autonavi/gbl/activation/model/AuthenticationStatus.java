package com.autonavi.gbl.activation.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class AuthenticationStatus {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int AuthenticationStatusExpired = 2;
    public static final int AuthenticationStatusInUse = 3;
    public static final int AuthenticationStatusNotOpen = 1;
    public static final int AuthenticationStatusNotSync = -1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface AuthenticationStatus1 {
    }
}
