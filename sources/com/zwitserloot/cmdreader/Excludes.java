package com.zwitserloot.cmdreader;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
/* loaded from: xp_Montecarlo-benchEdward.apk:com/zwitserloot/cmdreader/Excludes.SCL.lombok */
public @interface Excludes {
    String[] value();
}
