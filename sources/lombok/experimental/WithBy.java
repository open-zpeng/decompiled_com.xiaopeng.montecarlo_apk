package lombok.experimental;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import lombok.AccessLevel;
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface WithBy {

    @Target({})
    @Deprecated
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AnyAnnotation {
    }

    AnyAnnotation[] onMethod() default {};

    AccessLevel value() default AccessLevel.PUBLIC;
}
