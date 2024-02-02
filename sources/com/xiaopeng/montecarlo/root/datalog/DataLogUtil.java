package com.xiaopeng.montecarlo.root.datalog;

import com.xiaopeng.montecarlo.mapoverlay.poidetail.PoiDetailDecorator;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.speech.speechwidget.SpeechWidget;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class DataLogUtil {
    protected static final L.Tag TAG = new L.Tag("DataLogUtil");
    private static final String[] sParamArray = {"screen_coord", "mapcenter_coord", "zoom_level", "map_view", "car_heading", "status", "map_layer", "map_featureclass", "map_feature_coord", "routing_strategy", "route_distance", "route_eta", "route_fee", "route_traffic_light", "poi_type", PoiDetailDecorator.SEARCH_POI_ID, "poi_category_code", "panel_count", "car_coord", "left_navi_distance", "endpoint_coord", "voice_type", "voice_status", "input_keywords", "result_coord", SpeechWidget.DATA_SOURCE_SELECT, "page_src", "message_src", "vehicle_speed", "vehicle_plate", "binding_result_amap", "network_status", "data_size", "city_code", "city_type", "route_lable", "road_class", "formway", "link_type", "is_silent", "odtime", "is_voice_activated", "accel", "gyro", "car_icon", "charge_id", "navidis_fromcar", "used_charge_dis", "left_charge_dis", "is_serv_area", "is_recommend", "next_chargeid", "value", "lbs_type", "acc_msg_type", "charge_dis", "real_navidis", "on_timer", "on_car_coord", "off_timer", "off_car_coord", "last_status", "lane_data_version", "city_adCode", "lane_data_size", "lane_data_update_error", "time_percent"};
    private static final DataLogDelegate sDataLogDelegate = new DataLogDelegate(RootUtil.isTabletApp());

    public static void onStart() {
        sDataLogDelegate.onStart();
    }

    public static void sendStatData(PageType pageType, BtnType btnType, Object... objArr) {
        if (pageType == null || btnType == null) {
            return;
        }
        int[] paramIndexArray = btnType.getParamIndexArray();
        DataLogMessage dataLogMessage = new DataLogMessage(pageType.getPageName(), pageType.getPageId(), btnType.getButtonId(), btnType.getLevel());
        if (objArr != null && paramIndexArray != null && paramIndexArray.length > 0 && objArr.length == paramIndexArray.length) {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < paramIndexArray.length; i++) {
                int i2 = paramIndexArray[i] - 1;
                String[] strArr = sParamArray;
                if (i2 < strArr.length && i2 >= 0) {
                    hashMap.put(strArr[i2], objArr[i]);
                }
            }
            dataLogMessage.setParaMap(hashMap);
        }
        sDataLogDelegate.sendStatData(dataLogMessage);
    }
}
