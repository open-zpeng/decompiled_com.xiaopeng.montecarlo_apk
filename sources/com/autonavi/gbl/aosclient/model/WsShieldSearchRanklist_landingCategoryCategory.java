package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingCategoryCategory implements Serializable {
    public String alias;
    public int checked;
    public int is_current;
    public String location_current_text;
    public String name;
    public WsShieldSearchRanklist_landingParseValueClass parse_value;

    public WsShieldSearchRanklist_landingCategoryCategory() {
        this.name = "";
        this.checked = 0;
        this.is_current = 0;
        this.location_current_text = "";
        this.parse_value = new WsShieldSearchRanklist_landingParseValueClass();
        this.alias = "";
    }

    public WsShieldSearchRanklist_landingCategoryCategory(String str, int i, int i2, String str2, WsShieldSearchRanklist_landingParseValueClass wsShieldSearchRanklist_landingParseValueClass, String str3) {
        this.name = str;
        this.checked = i;
        this.is_current = i2;
        this.location_current_text = str2;
        this.parse_value = wsShieldSearchRanklist_landingParseValueClass;
        this.alias = str3;
    }
}
