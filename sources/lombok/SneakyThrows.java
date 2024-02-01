package lombok;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface SneakyThrows {
    Class<? extends Throwable>[] value() default {Throwable.class};
}
