package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsShieldSearchMainPageRecRequestParam extends BLRequestBase implements Serializable {
    public String level = "";
    public String poiid = "";
    public String scene_type = "";
    public String types = "";
    public String geoobj = "";
    public String user_loc = "";
    public String adcode = "";
    public int need_traffic = 0;
    public String home = "";
    public String company = "";
    public String click_history = "";
    public String city_code = "";
    public boolean algorithm_flag = false;

    public GWsShieldSearchMainPageRecRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SHIELD_SEARCH_MAIN_PAGE_REC;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
