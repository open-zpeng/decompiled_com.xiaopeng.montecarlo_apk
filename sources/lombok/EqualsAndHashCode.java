package lombok;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface EqualsAndHashCode {

    @Target({})
    @Deprecated
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AnyAnnotation {
    }

    /* loaded from: classes3.dex */
    public enum CacheStrategy {
        NEVER,
        LAZY;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static CacheStrategy[] valuesCustom() {
            CacheStrategy[] valuesCustom = values();
            int length = valuesCustom.length;
            CacheStrategy[] cacheStrategyArr = new CacheStrategy[length];
            System.arraycopy(valuesCustom, 0, cacheStrategyArr, 0, length);
            return cacheStrategyArr;
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Exclude {
    }

    @Target({ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Include {
        int rank() default 0;

        String replaces() default "";
    }

    CacheStrategy cacheStrategy() default CacheStrategy.NEVER;

    boolean callSuper() default false;

    boolean doNotUseGetters() default false;

    String[] exclude() default {};

    String[] of() default {};

    AnyAnnotation[] onParam() default {};

    boolean onlyExplicitlyIncluded() default false;
}
