package com.xiaopeng.montecarlo.scenes.settingscene.recycleview;

import com.xiaopeng.montecarlo.util.uirelationship.UIRelationshipConfig;
/* loaded from: classes3.dex */
public enum SettingPreferenceTypeEnum {
    SETTING_PREFERENCE_ROUTE_PREFERENCE(0, "route_preference", "线路偏好"),
    SETTING_PREFERENCE_NAVI_BROADCAST(1, "navi_broadcast", "导航播报"),
    SETTING_PREFERENCE_MINIMAP(2, "minimap", "仪表视角"),
    SETTING_PREFERENCE_CRUISE_BROADCAST(3, "cruise_broadcast", "巡航播报"),
    SETTING_PREFERENCE_ROUTE_RADAR(4, "route_radar", "线路雷达"),
    SETTING_PREFERENCE_CAR_LOGO(5, "car_logo", "车标"),
    SETTING_PREFERENCE_AVOID_LIMIT_ROUTE(6, "avoid_limit_route", "避开限行"),
    SETTING_PREFERENCE_AVOID_LIMIT_ROUTE_LICENSE_PLATE(7, "avoid_limit_route_license_plate", "车牌号"),
    SETTING_PREFERENCE_CHARGING_STATION(8, "charging_station", "充电站优先显示"),
    SETTING_PREFERENCE_REAL_TIME_TRAFFIC(9, "real_time_traffic", "实时交通显示"),
    SETTING_PREFERENCE_SCRATCH_SPOT(10, "scratch_spot", "路面状况播报"),
    SETTING_PREFERENCE_DYNAMIC_LEVEL(11, "dynamic_level", "智能比例尺开关"),
    SETTING_PREFERENCE_MAP_SEAMLESS_NAVI(12, "map_seamless_navi", "无缝导航"),
    SETTING_PREFERENCE_OFFLINE_MAP(13, "offline_map", "离线地图"),
    SETTING_PREFERENCE_OFFLINE_MAP_AUTO_UPDATE(14, "_offline_map_auto_update", "离线地图自动更新"),
    SETTING_PREFERENCE_TRIP(15, "trip", "组队开关"),
    SETTING_PREFERENCE_USER_DATA_DELETE(16, "user_data_delete", "用户数据删除"),
    SETTING_PREFERENCE_DATA_RESET(17, "data_reset", "恢复默认设置"),
    SETTING_PREFERENCE_MAP_VERSION(18, "map_version", "导航版本信息"),
    SETTING_PREFERENCE_RECOMMEND_PARK(19, UIRelationshipConfig.ELEMENT_RECOMMEND_PARK, "推荐停车场");
    
    private String mChineseName;
    private int mId;
    private String mName;

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String getChineseName() {
        return this.mChineseName;
    }

    SettingPreferenceTypeEnum(int i, String str, String str2) {
        this.mId = i;
        this.mName = str;
        this.mChineseName = str2;
    }

    public Integer getValue() {
        return Integer.valueOf(this.mId);
    }

    public static SettingPreferenceTypeEnum parse(int i) {
        SettingPreferenceTypeEnum[] values;
        for (SettingPreferenceTypeEnum settingPreferenceTypeEnum : values()) {
            if (settingPreferenceTypeEnum.getId() == i) {
                return settingPreferenceTypeEnum;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mName;
    }
}
