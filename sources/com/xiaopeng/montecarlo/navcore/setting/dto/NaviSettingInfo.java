package com.xiaopeng.montecarlo.navcore.setting.dto;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.setting.constant.MinimapTypeEnum;
import com.xiaopeng.montecarlo.navcore.setting.constant.NaviBroadcastTypeEnum;
/* loaded from: classes3.dex */
public class NaviSettingInfo {
    @SerializedName("isAvoidCongestionEnable")
    private boolean mIsAvoidCongestionEnable = false;
    @SerializedName("isAvoidChargeEnable")
    private boolean mIsAvoidChargeEnable = false;
    @SerializedName("isNoFreewaysEnable")
    private boolean mIsNoFreewaysEnable = false;
    @SerializedName("isHighwayPriorityEnable")
    private boolean mIsHighwayPriorityEnable = false;
    private NaviBroadcastTypeEnum mNaviBroadcastType = NaviBroadcastTypeEnum.NAVI_NORMAL_BROADCAST;
    private MinimapTypeEnum mMinimapTypeEnum = MinimapTypeEnum.MINIMAP_MAPMODE_3D_CAR;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviSettingInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviSettingInfo) {
            NaviSettingInfo naviSettingInfo = (NaviSettingInfo) obj;
            if (naviSettingInfo.canEqual(this) && isAvoidCongestionEnable() == naviSettingInfo.isAvoidCongestionEnable() && isAvoidChargeEnable() == naviSettingInfo.isAvoidChargeEnable() && isNoFreewaysEnable() == naviSettingInfo.isNoFreewaysEnable() && isHighwayPriorityEnable() == naviSettingInfo.isHighwayPriorityEnable()) {
                NaviBroadcastTypeEnum naviBroadcastType = getNaviBroadcastType();
                NaviBroadcastTypeEnum naviBroadcastType2 = naviSettingInfo.getNaviBroadcastType();
                if (naviBroadcastType != null ? naviBroadcastType.equals(naviBroadcastType2) : naviBroadcastType2 == null) {
                    MinimapTypeEnum minimapTypeEnum = getMinimapTypeEnum();
                    MinimapTypeEnum minimapTypeEnum2 = naviSettingInfo.getMinimapTypeEnum();
                    return minimapTypeEnum != null ? minimapTypeEnum.equals(minimapTypeEnum2) : minimapTypeEnum2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i = (((((((isAvoidCongestionEnable() ? 79 : 97) + 59) * 59) + (isAvoidChargeEnable() ? 79 : 97)) * 59) + (isNoFreewaysEnable() ? 79 : 97)) * 59) + (isHighwayPriorityEnable() ? 79 : 97);
        NaviBroadcastTypeEnum naviBroadcastType = getNaviBroadcastType();
        int hashCode = (i * 59) + (naviBroadcastType == null ? 43 : naviBroadcastType.hashCode());
        MinimapTypeEnum minimapTypeEnum = getMinimapTypeEnum();
        return (hashCode * 59) + (minimapTypeEnum != null ? minimapTypeEnum.hashCode() : 43);
    }

    public NaviSettingInfo setAvoidChargeEnable(boolean z) {
        this.mIsAvoidChargeEnable = z;
        return this;
    }

    public NaviSettingInfo setAvoidCongestionEnable(boolean z) {
        this.mIsAvoidCongestionEnable = z;
        return this;
    }

    public NaviSettingInfo setHighwayPriorityEnable(boolean z) {
        this.mIsHighwayPriorityEnable = z;
        return this;
    }

    public NaviSettingInfo setMinimapTypeEnum(MinimapTypeEnum minimapTypeEnum) {
        this.mMinimapTypeEnum = minimapTypeEnum;
        return this;
    }

    public NaviSettingInfo setNaviBroadcastType(NaviBroadcastTypeEnum naviBroadcastTypeEnum) {
        this.mNaviBroadcastType = naviBroadcastTypeEnum;
        return this;
    }

    public NaviSettingInfo setNoFreewaysEnable(boolean z) {
        this.mIsNoFreewaysEnable = z;
        return this;
    }

    public String toString() {
        return "NaviSettingInfo(mIsAvoidCongestionEnable=" + isAvoidCongestionEnable() + ", mIsAvoidChargeEnable=" + isAvoidChargeEnable() + ", mIsNoFreewaysEnable=" + isNoFreewaysEnable() + ", mIsHighwayPriorityEnable=" + isHighwayPriorityEnable() + ", mNaviBroadcastType=" + getNaviBroadcastType() + ", mMinimapTypeEnum=" + getMinimapTypeEnum() + ")";
    }

    public boolean isAvoidCongestionEnable() {
        return this.mIsAvoidCongestionEnable;
    }

    public boolean isAvoidChargeEnable() {
        return this.mIsAvoidChargeEnable;
    }

    public boolean isNoFreewaysEnable() {
        return this.mIsNoFreewaysEnable;
    }

    public boolean isHighwayPriorityEnable() {
        return this.mIsHighwayPriorityEnable;
    }

    public NaviBroadcastTypeEnum getNaviBroadcastType() {
        return this.mNaviBroadcastType;
    }

    public MinimapTypeEnum getMinimapTypeEnum() {
        return this.mMinimapTypeEnum;
    }
}
