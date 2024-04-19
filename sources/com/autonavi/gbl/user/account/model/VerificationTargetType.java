package com.autonavi.gbl.user.account.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class VerificationTargetType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int VerificationTargetTypeEmail = 1;
    public static final int VerificationTargetTypeInvalid = 0;
    public static final int VerificationTargetTypeSms = 2;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface VerificationTargetType1 {
    }
}
