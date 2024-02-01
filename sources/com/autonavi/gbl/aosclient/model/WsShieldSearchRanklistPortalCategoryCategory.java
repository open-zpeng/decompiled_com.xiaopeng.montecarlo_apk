package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalCategoryCategory implements Serializable {
    public String alias;
    public int checked;
    public int is_current;
    public String location_current_text;
    public String name;
    public WsShieldSearchRanklistPortalParseValueClass parse_value;

    public WsShieldSearchRanklistPortalCategoryCategory() {
        this.name = "";
        this.checked = 0;
        this.is_current = 0;
        this.location_current_text = "";
        this.parse_value = new WsShieldSearchRanklistPortalParseValueClass();
        this.alias = "";
    }

    public WsShieldSearchRanklistPortalCategoryCategory(String str, int i, int i2, String str2, WsShieldSearchRanklistPortalParseValueClass wsShieldSearchRanklistPortalParseValueClass, String str3) {
        this.name = str;
        this.checked = i;
        this.is_current = i2;
        this.location_current_text = str2;
        this.parse_value = wsShieldSearchRanklistPortalParseValueClass;
        this.alias = str3;
    }
}
