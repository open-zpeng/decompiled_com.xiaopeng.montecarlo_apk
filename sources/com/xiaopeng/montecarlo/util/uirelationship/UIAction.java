package com.xiaopeng.montecarlo.util.uirelationship;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface UIAction {
    public static final int TYPE_HIDE = 0;
    public static final int TYPE_SHOW = 1;
    public static final int TYPE_UPDATE = 2;

    /* loaded from: classes3.dex */
    public @interface MethodType {
    }

    @MethodType
    int methodType() default 2;

    String name() default "";

    int priority() default -1;
}
