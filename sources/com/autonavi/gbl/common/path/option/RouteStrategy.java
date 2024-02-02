package com.autonavi.gbl.common.path.option;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class RouteStrategy {
    public static final int AUTO_UNKNOWN_ERROR = Integer.MIN_VALUE;
    public static final int RequestRouteTypeBest = 0;
    public static final int RequestRouteTypeDist = 2;
    public static final int RequestRouteTypeMoney = 1;
    public static final int RequestRouteTypeMostly = 13;
    public static final int RequestRouteTypeMulti = 5;
    public static final int RequestRouteTypeNULL = -1;
    public static final int RequestRouteTypeNorm = 3;
    public static final int RequestRouteTypeTMC = 4;
    public static final int RequestRouteTypeTMCFree = 12;
    public static final int RequestRouteTypeThree = 9;
    public static final int RouteStrategyGaodeBest = 17;
    public static final int RouteStrategyHighwayFirst = 19;
    public static final int RouteStrategyLessHighway = 21;
    public static final int RouteStrategyLessMoney = 20;
    public static final int RouteStrategyNewTMCFree = 18;
    public static final int RouteStrategyPersonalGaodeBest = 32;
    public static final int RouteStrategyPersonalHighwayFirst = 34;
    public static final int RouteStrategyPersonalLessHighway = 35;
    public static final int RouteStrategyPersonalLessMoney = 36;
    public static final int RouteStrategyPersonalLessMoney2LessHighway = 42;
    public static final int RouteStrategyPersonalSpeedFirst = 38;
    public static final int RouteStrategyPersonalTMC = 33;
    public static final int RouteStrategyPersonalTMC2Highway = 39;
    public static final int RouteStrategyPersonalTMC2LessHighway = 40;
    public static final int RouteStrategyPersonalTMC2LessMondy2LessHighway = 43;
    public static final int RouteStrategyPersonalTMC2LessMoney = 41;
    public static final int RouteStrategyPersonalTMC2SpeedFirst = 45;
    public static final int RouteStrategyPersonalTMC2WidthFirst = 44;
    public static final int RouteStrategyPersonalWidthFirst = 37;
    public static final int RouteStrategySpeedFirst = 23;
    public static final int RouteStrategyWidthFirst = 22;

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface RouteStrategy1 {
    }
}
