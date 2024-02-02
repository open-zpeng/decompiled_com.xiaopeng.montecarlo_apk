package lombok.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/core/PrintAST.SCL.lombok */
public @interface PrintAST {
    String outfile() default "";

    boolean printContent() default false;

    boolean printPositions() default false;
}
