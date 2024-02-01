package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsNavigationDynamicDataRequestParam extends BLRequestBase implements Serializable {
    public String dynamic_scene = "";
    public String s_poiid = "";
    public String s_typecode = "";
    public String e_poiid = "";
    public String e_typecode = "";
    public String s_adcode = "";
    public String e_adcode = "";
    public double s_longitude = 0.0d;
    public double s_latitude = 0.0d;
    public double e_longitude = 0.0d;
    public double e_latitude = 0.0d;
    public ArrayList<WsNavigationDynamicDataNaviRouteLink> navi_route_links = new ArrayList<>();
    public String data_version = "";
    public String carplate = "";
    public String car_type = "";
    public String is_etc = "";
    public String user_loc = "";
    public String user_citycode = "";
    public String sub_e_poiid = "";
    public String navi_via_citycode = "";
    public String navi_count = "";
    public String jump_type = "";
    public String jump_sa = "";
    public String service_area_ids = "";
    public String is_charging_user = "";
    public int online_status = 0;
    public String navigation_type = "";
    public String navigation_id = "";
    public String cpcode = "";
    public int vehicleType = 0;
    public String appVersion = "";
    public String navigation_scene = "";
    public ArrayList<String> scenes = new ArrayList<>();
    public String endurance = "";
    public String endurance_current = "";
    public ArrayList<WsNavigationDynamicDataMidpoi> midpoi = new ArrayList<>();
    public String phoneModel = "";
    public String sunriseTime = "";
    public String noonTime = "";
    public String sunsetTime = "";
    public String userNickname = "";
    public ArrayList<WsNavigationDynamicDataRequestPoiidList> poiid_list = new ArrayList<>();
    public int page_scene = 0;

    public GWsNavigationDynamicDataRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_NAVIGATION_DYNAMIC_DATA;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
