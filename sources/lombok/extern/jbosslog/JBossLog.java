package lombok.extern.jbosslog;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface JBossLog {
    String topic() default "";
}
