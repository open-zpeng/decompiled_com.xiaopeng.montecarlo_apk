package com.xiaopeng.montecarlo.root.httpclient.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface RequestParam {
    String value();
}
