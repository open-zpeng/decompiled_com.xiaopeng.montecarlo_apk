package com.xiaopeng.montecarlo.scenes.restrictscene;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class RestrictUtils {
    public static final short AVOID_RULES = 3;
    public static final short CITY_TYPE_END = 2;
    public static final short CITY_TYPE_ERROR = 0;
    public static final short CITY_TYPE_START = 1;
    public static final short CITY_TYPE_VIAS = 3;
    public static final String KEY_RESTRICT = "restrictinfo";
    public static final String KEY_RESTRICT_CITY_INDEX = "restrictinfo_cityindex";
    public static final String KEY_RESTRICT_RULE_INDEX = "restrictinfo_ruleindex";
    public static final short NOT_AVOID_RULES = 4;
    public static final short NOT_OPEN_SWITCH = 2;
    public static final short NOT_SHOW = 0;
    public static final short NO_PLATE = 1;
    public static final int RESTRICTED_AREA_AVOID = 1;
    public static final int RESTRICTED_AREA_NOT_AVOID = 2;
    public static final int RESTRICTED_AREA_NO_INFO = 0;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes2.dex */
    public @interface RestrictMode {
    }
}
