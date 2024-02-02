package com.xiaopeng.montecarlo.root.httpclient.annotations;

import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface RemoteClient {
    String path() default "";

    RemoteServiceNameEnum serviceName();

    String url() default "";
}
