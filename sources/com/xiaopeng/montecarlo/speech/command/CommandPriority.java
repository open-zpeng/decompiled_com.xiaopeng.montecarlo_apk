package com.xiaopeng.montecarlo.speech.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface CommandPriority {
    @PriorityScope
    int priority() default Integer.MAX_VALUE;
}
