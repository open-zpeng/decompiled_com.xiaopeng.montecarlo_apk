package com.xiaopeng.montecarlo.navcore.search.policy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class OrderPolicy {
    public static final String SEARCH_ORDER_DISTANCE = "DISTANCE";
    public static final String SEARCH_ORDER_FREE = "FREE";
    public static final String SEARCH_ORDER_SCORE = "SCORE";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Order {
    }
}
