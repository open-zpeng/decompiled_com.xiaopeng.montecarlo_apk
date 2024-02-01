package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingParseValueClass implements Serializable {
    public int area_type;
    public String area_value;
    public String business_args;
    public String poi_rank_method;

    public WsShieldSearchRanklist_landingParseValueClass() {
        this.area_type = 0;
        this.area_value = "";
        this.business_args = "";
        this.poi_rank_method = "";
    }

    public WsShieldSearchRanklist_landingParseValueClass(int i, String str, String str2, String str3) {
        this.area_type = i;
        this.area_value = str;
        this.business_args = str2;
        this.poi_rank_method = str3;
    }
}
