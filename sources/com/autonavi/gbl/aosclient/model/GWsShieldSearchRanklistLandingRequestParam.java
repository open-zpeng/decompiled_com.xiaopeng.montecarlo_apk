package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsShieldSearchRanklistLandingRequestParam extends BLRequestBase implements Serializable {
    public String view_region = "";
    public String user_loc = "";
    public String list_tag = "";
    public String user_adcode = "";
    public String adcode = "";
    public String business = "";
    public String area_type = "";
    public String area_value = "";
    public String business_args = "";
    public String selection_changed = "";
    public String poi_rank_method = "";

    public GWsShieldSearchRanklistLandingRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SHIELD_SEARCH_RANKLIST_LANDING;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
