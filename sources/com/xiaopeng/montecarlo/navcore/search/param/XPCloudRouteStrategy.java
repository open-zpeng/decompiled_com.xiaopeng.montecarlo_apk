package com.xiaopeng.montecarlo.navcore.search.param;
/* loaded from: classes3.dex */
public class XPCloudRouteStrategy {
    public static final int XP_CLOUD_ROUTE_CONG_MONEY = 8;
    public static final int XP_CLOUD_ROUTE_CONG_MONEY_HIGHWAY = 9;
    public static final int XP_CLOUD_ROUTE_MONEY_FIRST_AVOID_HIGHWAY = 7;
    public static final int XP_CLOUD_ROUTE_SINGLE_AVOID_CONG = 4;
    public static final int XP_CLOUD_ROUTE_SINGLE_DISTANCE_FIRST = 2;
    public static final int XP_CLOUD_ROUTE_SINGLE_DISTANCE_FIRST_NO_EXPRESS = 3;
    public static final int XP_CLOUD_ROUTE_SINGLE_LOW_COST = 1;
    public static final int XP_CLOUD_ROUTE_SINGLE_MULTI = 5;
    public static final int XP_CLOUD_ROUTE_SINGLE_SPEED_FIRST = 0;
    public static final int XP_CLOUD_ROUTE_SPEED_FIRST_AVOID_HIGHWAY = 6;
    public static final int XP_CLOUD_ROUTE_STRATEGY_AVOID_CHARGE = 14;
    public static final int XP_CLOUD_ROUTE_STRATEGY_AVOID_CHARGE_HIGHWAY = 16;
    public static final int XP_CLOUD_ROUTE_STRATEGY_AVOID_CONGESTION = 12;
    public static final int XP_CLOUD_ROUTE_STRATEGY_AVOID_CONG_CHARGE = 17;
    public static final int XP_CLOUD_ROUTE_STRATEGY_AVOID_CONG_CHARGE_HIGHWAY = 18;
    public static final int XP_CLOUD_ROUTE_STRATEGY_AVOID_CONG_HIGHWAY = 15;
    public static final int XP_CLOUD_ROUTE_STRATEGY_AVOID_CONG_HIGHWAY_FIRST = 20;
    public static final int XP_CLOUD_ROUTE_STRATEGY_AVOID_HIGHWAY = 13;
    public static final int XP_CLOUD_ROUTE_STRATEGY_BEST = 11;
    public static final int XP_CLOUD_ROUTE_STRATEGY_DEFAULT = 10;
    public static final int XP_CLOUD_ROUTE_STRATEGY_HIGHWAY_FIRST = 19;
    public static final int XP_CLOUD_ROUTE_STRATEGY_MAX = 20;
    public static final int XP_CLOUD_ROUTE_STRATEGY_MIN = 0;

    public static boolean isLegal(int i) {
        return i <= 20 && i >= 0;
    }
}
