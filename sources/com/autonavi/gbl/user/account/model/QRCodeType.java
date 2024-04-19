package com.autonavi.gbl.user.account.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class QRCodeType {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int QRCodeTypeAuthPay = 2;
    public static final int QRCodeTypeDefault = 0;
    public static final int QRCodeTypeLoginPay = 1;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface QRCodeType1 {
    }
}
