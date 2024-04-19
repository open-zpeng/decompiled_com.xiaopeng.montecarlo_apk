package com.zwitserloot.cmdreader;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
/* loaded from: xp_Montecarlo-benchDavid55.apk:com/zwitserloot/cmdreader/Shorthand.SCL.lombok */
public @interface Shorthand {
    String[] value() default {};
}
