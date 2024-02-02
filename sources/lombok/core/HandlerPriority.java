package lombok.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/core/HandlerPriority.SCL.lombok */
public @interface HandlerPriority {
    int value();

    int subValue() default 0;
}
