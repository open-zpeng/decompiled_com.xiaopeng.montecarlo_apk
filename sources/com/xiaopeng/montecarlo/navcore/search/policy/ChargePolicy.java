package com.xiaopeng.montecarlo.navcore.search.policy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class ChargePolicy extends OrderPolicy {
    public static final String LOW_BATTERY = "LOW_BATTERY";
    public static final String SUFFICIENT_BATTERY = "SUFFICIENT_BATTERY";
    public static final int TYPE_AREA = 4;
    public static final int TYPE_AROUND = 2;
    public static final int TYPE_KEYWORD = 5;
    public static final int TYPE_PATH = 3;
    public static final int TYPE_POINT = 1;
    public static final int TYPE_RECOMMEND_CHARGE = 9;
    public static final int TYPE_RECOMMEND_FREQUENTLY = 6;
    public static final int TYPE_RECOMMEND_FREQUENTLY_UPDATE = 7;
    public static final int TYPE_ROUTE_PLAN_CHARGE = 8;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface BatteryState {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Type {
    }
}
