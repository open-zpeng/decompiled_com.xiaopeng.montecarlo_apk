package com.xiaopeng.montecarlo.speech.utils;

import com.xiaopeng.montecarlo.navcore.setting.SettingBLManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
/* loaded from: classes3.dex */
public class SpeechSettingUtil {
    private static final L.Tag TAG = new L.Tag("SpeechSettingUtil");

    /* loaded from: classes3.dex */
    public enum RouteStrategy {
        ROUTE_PREF_AVOID_CHARGE("避免收费", 1),
        ROUTE_PREF_HIGHWAY_PRIORITY("高速优先", 2),
        ROUTE_PREF_AVOID_CONGESTION("躲避拥堵", 4),
        ROUTE_PREF_NO_FREEWAYS("不走高速", 6),
        ROUTE_PREF_NO_FREEWAYS_AVOID_CHARGE("不走高速+避免收费", 7),
        ROUTE_PREF_AVOID_CONGESTION_AVOID_CHARGE("躲避拥堵+避免收费", 8),
        ROUTE_PREF_NO_FREEWAYS_AVOID_CONGESTION_AVOID_CHARGE("不走高速+躲避拥堵+避免收费", 9),
        ROUTE_PREF_DEFAULT("默认", -1);
        
        private int mIndex;
        private String mStrategyName;

        public String getStrategyName() {
            return this.mStrategyName;
        }

        public void setStrategyName(String str) {
            this.mStrategyName = str;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public void setIndex(int i) {
            this.mIndex = i;
        }

        RouteStrategy(String str, int i) {
            this.mStrategyName = str;
            this.mIndex = i;
        }

        public static RouteStrategy getStrategy(int i) {
            RouteStrategy[] values;
            for (RouteStrategy routeStrategy : values()) {
                if (routeStrategy.getIndex() == i) {
                    return routeStrategy;
                }
            }
            return ROUTE_PREF_DEFAULT;
        }
    }

    public static int modifySettingParam(RouteStrategy routeStrategy) {
        L.Tag tag = TAG;
        L.i(tag, "modifySettingParam, strategy=" + routeStrategy);
        int allSettingValue = SettingWrapper.getAllSettingValue();
        if (routeStrategy != null) {
            switch (routeStrategy) {
                case ROUTE_PREF_AVOID_CHARGE:
                    allSettingValue = SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(allSettingValue, 2, true), 4, false), 8, false), 1, false);
                    break;
                case ROUTE_PREF_HIGHWAY_PRIORITY:
                    allSettingValue = SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(allSettingValue, 2, false), 4, false), 8, true), 1, false);
                    break;
                case ROUTE_PREF_AVOID_CONGESTION:
                    allSettingValue = SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(allSettingValue, 2, false), 4, false), 8, false), 1, true);
                    break;
                case ROUTE_PREF_NO_FREEWAYS:
                    allSettingValue = SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(allSettingValue, 2, false), 4, true), 8, false), 1, false);
                    break;
                case ROUTE_PREF_NO_FREEWAYS_AVOID_CHARGE:
                    allSettingValue = SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(allSettingValue, 2, true), 4, true), 8, false), 1, false);
                    break;
                case ROUTE_PREF_AVOID_CONGESTION_AVOID_CHARGE:
                    allSettingValue = SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(allSettingValue, 2, true), 4, false), 8, false), 1, true);
                    break;
                case ROUTE_PREF_NO_FREEWAYS_AVOID_CONGESTION_AVOID_CHARGE:
                    allSettingValue = SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(allSettingValue, 2, true), 4, true), 8, false), 1, true);
                    break;
            }
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "old=" + SettingWrapper.getAllSettingValue() + " new=" + allSettingValue);
        return allSettingValue;
    }

    public static int modifySettingParam(int i) {
        L.Tag tag = TAG;
        L.i(tag, "modifySettingParam, strategy=" + i);
        if (i > 0) {
            return modifySettingParam(RouteStrategy.getStrategy(i));
        }
        return SettingWrapper.getAllSettingValue();
    }

    public static RouteStrategy mergeStrategy(RouteStrategy routeStrategy, RouteStrategy routeStrategy2) {
        if (routeStrategy2 == routeStrategy || routeStrategy2 == RouteStrategy.ROUTE_PREF_DEFAULT) {
            return routeStrategy;
        }
        switch (routeStrategy) {
            case ROUTE_PREF_AVOID_CHARGE:
                return routeStrategy2 == RouteStrategy.ROUTE_PREF_NO_FREEWAYS ? RouteStrategy.ROUTE_PREF_NO_FREEWAYS_AVOID_CHARGE : routeStrategy;
            case ROUTE_PREF_HIGHWAY_PRIORITY:
            case ROUTE_PREF_NO_FREEWAYS_AVOID_CONGESTION_AVOID_CHARGE:
            default:
                return routeStrategy;
            case ROUTE_PREF_AVOID_CONGESTION:
                return routeStrategy2 == RouteStrategy.ROUTE_PREF_AVOID_CHARGE ? RouteStrategy.ROUTE_PREF_AVOID_CONGESTION_AVOID_CHARGE : routeStrategy;
            case ROUTE_PREF_NO_FREEWAYS:
                return routeStrategy2 == RouteStrategy.ROUTE_PREF_AVOID_CHARGE ? RouteStrategy.ROUTE_PREF_NO_FREEWAYS_AVOID_CHARGE : routeStrategy;
            case ROUTE_PREF_NO_FREEWAYS_AVOID_CHARGE:
                return routeStrategy2 == RouteStrategy.ROUTE_PREF_AVOID_CONGESTION ? RouteStrategy.ROUTE_PREF_NO_FREEWAYS_AVOID_CONGESTION_AVOID_CHARGE : routeStrategy;
            case ROUTE_PREF_AVOID_CONGESTION_AVOID_CHARGE:
                return routeStrategy2 == RouteStrategy.ROUTE_PREF_NO_FREEWAYS ? RouteStrategy.ROUTE_PREF_NO_FREEWAYS_AVOID_CONGESTION_AVOID_CHARGE : routeStrategy;
            case ROUTE_PREF_DEFAULT:
                return routeStrategy2;
        }
    }

    public static void setAvoidCongestion(boolean z) {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 1, z);
        L.Tag tag = TAG;
        L.i(tag, "avoidCongestion, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingWrapper.saveSettingPreference(modifySettingPreference);
    }

    public static void setRealTimeTrafficState(boolean z) {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 32768, z);
        L.Tag tag = TAG;
        L.i(tag, "setRealTimeTrafficState, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingWrapper.saveSettingPreference(modifySettingPreference);
    }

    public static void setAvoidCharge(boolean z) {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 2, z);
        L.Tag tag = TAG;
        L.i(tag, "setAvoidCharge, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingWrapper.saveSettingPreference(modifySettingPreference);
        if (z && SettingWrapper.isHighwayPriorityEnabled(modifySettingPreference)) {
            setHighwayPriority(false);
        }
    }

    public static void setAvoidFreeway(boolean z) {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 4, z);
        L.Tag tag = TAG;
        L.i(tag, "setAvoidFreeway, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingWrapper.saveSettingPreference(modifySettingPreference);
        if (z && SettingWrapper.isHighwayPriorityEnabled(modifySettingPreference)) {
            setHighwayPriority(false);
        }
    }

    public static void setHighwayPriority(boolean z) {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 8, z);
        L.Tag tag = TAG;
        L.i(tag, "setHighwayPriority, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingWrapper.saveSettingPreference(modifySettingPreference);
        if (z) {
            if (SettingWrapper.isAvoidChargeEnabled(modifySettingPreference)) {
                setAvoidCharge(false);
            }
            if (SettingWrapper.isNoFreewaysEnabled(modifySettingPreference)) {
                setAvoidFreeway(false);
            }
        }
    }

    public static void enableSimpleBroadcast() {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 1048576, true), 16, false), 32, false);
        L.Tag tag = TAG;
        L.i(tag, "enableSimpleBroadcast, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingWrapper.saveSettingPreference(modifySettingPreference);
    }

    public static void enableNormalBroadcast() {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 32, true), 16, false), 1048576, false);
        L.Tag tag = TAG;
        L.i(tag, "enableNormalBroadcast, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingWrapper.saveSettingPreference(modifySettingPreference);
    }

    public static void enableDetailBroadcast() {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 16, true), 32, false), 1048576, false);
        L.Tag tag = TAG;
        L.i(tag, "enableDetailBroadcast, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingWrapper.saveSettingPreference(modifySettingPreference);
    }

    public static void setChargingStationShowState(boolean z) {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 16384, z);
        L.Tag tag = TAG;
        L.i(tag, "setChargingStationShowState, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingWrapper.saveSettingPreference(modifySettingPreference);
    }

    public static boolean isChargingStationOpen() {
        return SettingWrapper.isSettingOptionSelected(SettingWrapper.getAllSettingValue(), 16384);
    }

    public static boolean isSettingOptionSelected(int i) {
        return SettingWrapper.isSettingOptionSelected(SettingWrapper.getAllSettingValue(), i);
    }

    public static void setAvoidControlsState(boolean z) {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 512, z);
        SettingWrapper.saveSettingPreference(modifySettingPreference);
        L.Tag tag = TAG;
        L.i(tag, "setAvoidControlsState, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingStatUtil.sendStatDataAvoidRestrictionRoute(z);
    }

    public static void setRadarRouteState(boolean z) {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 1024, z);
        SettingWrapper.saveSettingPreference(modifySettingPreference);
        L.Tag tag = TAG;
        L.i(tag, "setRadarRouteState, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingStatUtil.sendStatDataRouteRadar(z);
        SettingBLManager.getInstance().setRadarState();
    }

    public static void enableControlSpeechSuperSimple() {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 16, false), 32, false), 1048576, true);
        SettingWrapper.saveSettingPreference(modifySettingPreference);
        L.Tag tag = TAG;
        L.i(tag, "enableControlSpeechSuperSimple, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingStatUtil.sendStatDataUltraSimpleBroadcast(true);
    }

    public static void enableControlSpeechGeneral() {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 16, false), 32, true), 1048576, false);
        SettingWrapper.saveSettingPreference(modifySettingPreference);
        L.Tag tag = TAG;
        L.i(tag, "enableControlSpeechGeneral, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingStatUtil.sendStatDataNormalBroadcast(true);
    }

    public static void setControlSpeechEyeState(boolean z) {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 128, z);
        SettingWrapper.saveSettingPreference(modifySettingPreference);
        L.Tag tag = TAG;
        L.i(tag, "setControlSpeechEyeState, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingStatUtil.sendStatDataCruiseElectronicEyeBroadcast(z);
    }

    public static void setControlSmartScaleState(boolean z) {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 131072, z);
        SettingWrapper.saveSettingPreference(modifySettingPreference);
        L.Tag tag = TAG;
        L.i(tag, "setControlSmartScaleState, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingStatUtil.sendStatDynamicLevel(z);
    }

    public static void setControlRecommendParkState(boolean z) {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 16777216, z);
        SettingWrapper.saveSettingPreference(modifySettingPreference);
        L.Tag tag = TAG;
        L.i(tag, "setControlRecommendParkState, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingStatUtil.sendStatRecommendPark(z);
    }

    public static void setControlSecurityRemindState(boolean z) {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 256, z);
        SettingWrapper.saveSettingPreference(modifySettingPreference);
        L.Tag tag = TAG;
        L.i(tag, "setControlSecurityRemindState, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingStatUtil.sendStatDataCruiseSafetyBroadcast(z);
    }

    public static void setControlRoadAheadState(boolean z) {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 64, z);
        SettingWrapper.saveSettingPreference(modifySettingPreference);
        L.Tag tag = TAG;
        L.i(tag, "setControlRoadAheadState, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingStatUtil.sendStatDataCruiseAheadTraffic(z);
    }

    public static void setSmallMapState(boolean z) {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 262144, z), 524288, !z);
        SettingWrapper.saveSettingPreference(modifySettingPreference);
        L.Tag tag = TAG;
        L.i(tag, "setSmallMapState, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingStatUtil.sendStatDataMapThumbnail();
    }

    public static void setRibbonMapState(boolean z) {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 524288, z), 262144, !z);
        SettingWrapper.saveSettingPreference(modifySettingPreference);
        L.Tag tag = TAG;
        L.i(tag, "setRibbonMapState, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingStatUtil.sendStatDataMapLightColumn();
    }

    public static void setScratchSpotBroadcastState(boolean z) {
        int modifySettingPreference = SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), 8388608, z);
        SettingWrapper.saveSettingPreference(modifySettingPreference);
        L.Tag tag = TAG;
        L.i(tag, "setScratchSpotBroadcastState, mSettingPreferenceValue =" + Integer.toBinaryString(modifySettingPreference));
        SettingStatUtil.sendStatDataScratchSpot(z);
    }
}
