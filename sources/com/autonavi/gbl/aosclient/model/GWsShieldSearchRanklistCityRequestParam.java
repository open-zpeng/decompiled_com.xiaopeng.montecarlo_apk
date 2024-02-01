package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsShieldSearchRanklistCityRequestParam extends BLRequestBase implements Serializable {
    public String industry = "";
    public String type = "";

    public GWsShieldSearchRanklistCityRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SHIELD_SEARCH_RANKLIST_CITY;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
