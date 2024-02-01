package com.zwitserloot.cmdreader;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:com/zwitserloot/cmdreader/Requires.SCL.lombok */
public @interface Requires {
    String[] value();
}
