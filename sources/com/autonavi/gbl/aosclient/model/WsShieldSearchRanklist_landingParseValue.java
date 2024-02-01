package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingParseValue implements Serializable {
    public String business;
    public String business_args;
    public String poi_rank_method;
    public String real_business;

    public WsShieldSearchRanklist_landingParseValue() {
        this.business = "";
        this.business_args = "";
        this.real_business = "";
        this.poi_rank_method = "";
    }

    public WsShieldSearchRanklist_landingParseValue(String str, String str2, String str3, String str4) {
        this.business = str;
        this.business_args = str2;
        this.real_business = str3;
        this.poi_rank_method = str4;
    }
}
