package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalParseValue implements Serializable {
    public String business;
    public String business_args;
    public String list_tag;
    public String poi_rank_method;
    public String real_business;

    public WsShieldSearchRanklistPortalParseValue() {
        this.business = "";
        this.business_args = "";
        this.real_business = "";
        this.list_tag = "";
        this.poi_rank_method = "";
    }

    public WsShieldSearchRanklistPortalParseValue(String str, String str2, String str3, String str4, String str5) {
        this.business = str;
        this.business_args = str2;
        this.real_business = str3;
        this.list_tag = str4;
        this.poi_rank_method = str5;
    }
}
