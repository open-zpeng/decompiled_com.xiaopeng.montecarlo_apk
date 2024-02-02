package com.xiaopeng.montecarlo.root.httpclient.annotations;

import com.xiaopeng.montecarlo.root.httpclient.constants.ClientEncodingTypeEnum;
import com.xiaopeng.montecarlo.root.httpclient.constants.ClientTypeEnum;
import com.xiaopeng.montecarlo.root.httpclient.constants.EncryptTypeEnum;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface Header {
    ClientEncodingTypeEnum clientEncodingType() default ClientEncodingTypeEnum.XP_CLIENT_ENCODING_NONE;

    ClientTypeEnum clientType() default ClientTypeEnum.XP_CLIENT_TYPE_XMARTOS;

    EncryptTypeEnum encryptType() default EncryptTypeEnum.XP_ENCRYPT_TYPE_NONE;

    boolean requireClientKey() default true;

    boolean requireNonce() default true;

    boolean requireOpenId() default false;

    boolean requireOtp() default false;

    boolean requireSid() default false;

    boolean requireUid() default false;

    boolean requireVin() default true;
}
