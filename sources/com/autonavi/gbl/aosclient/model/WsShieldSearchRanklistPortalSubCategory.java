package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalSubCategory implements Serializable {
    public String Second_Tab_ID;
    public int checked;
    public String name;
    public WsShieldSearchRanklistPortalParseValue parse_value;
    public String toplist_id;

    public WsShieldSearchRanklistPortalSubCategory() {
        this.toplist_id = "";
        this.name = "";
        this.checked = 0;
        this.Second_Tab_ID = "";
        this.parse_value = new WsShieldSearchRanklistPortalParseValue();
    }

    public WsShieldSearchRanklistPortalSubCategory(String str, String str2, int i, String str3, WsShieldSearchRanklistPortalParseValue wsShieldSearchRanklistPortalParseValue) {
        this.toplist_id = str;
        this.name = str2;
        this.checked = i;
        this.Second_Tab_ID = str3;
        this.parse_value = wsShieldSearchRanklistPortalParseValue;
    }
}
