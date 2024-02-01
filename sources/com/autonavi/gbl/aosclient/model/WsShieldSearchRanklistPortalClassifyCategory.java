package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalClassifyCategory implements Serializable {
    public String business;
    public String business_args;
    public int checked;
    public String name;
    public WsShieldSearchRanklistPortalParseValue parse_value;

    public WsShieldSearchRanklistPortalClassifyCategory() {
        this.name = "";
        this.checked = 0;
        this.business = "";
        this.business_args = "";
        this.parse_value = new WsShieldSearchRanklistPortalParseValue();
    }

    public WsShieldSearchRanklistPortalClassifyCategory(String str, int i, String str2, String str3, WsShieldSearchRanklistPortalParseValue wsShieldSearchRanklistPortalParseValue) {
        this.name = str;
        this.checked = i;
        this.business = str2;
        this.business_args = str3;
        this.parse_value = wsShieldSearchRanklistPortalParseValue;
    }
}
