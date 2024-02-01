package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsShieldSearchRanklistPortalRequestParam extends BLRequestBase implements Serializable {
    public String view_region = "";
    public String user_loc = "";
    public String user_adcode = "";
    public String business = "";
    public String type = "";
    public String area_type = "";
    public String area_value = "";
    public String adcode = "";
    public String business_args = "";
    public String list_tag = "";
    public String page_type = "";
    public String selection_changed = "";
    public String poi_rank_method = "";

    public GWsShieldSearchRanklistPortalRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SHIELD_SEARCH_RANKLIST_PORTAL;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
