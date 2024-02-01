package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingSubCategory implements Serializable {
    public String Second_Tab_ID;
    public int checked;
    public String name;
    public WsShieldSearchRanklist_landingParseValue parse_value;
    public String toplist_id;

    public WsShieldSearchRanklist_landingSubCategory() {
        this.toplist_id = "";
        this.name = "";
        this.checked = 0;
        this.Second_Tab_ID = "";
        this.parse_value = new WsShieldSearchRanklist_landingParseValue();
    }

    public WsShieldSearchRanklist_landingSubCategory(String str, String str2, int i, String str3, WsShieldSearchRanklist_landingParseValue wsShieldSearchRanklist_landingParseValue) {
        this.toplist_id = str;
        this.name = str2;
        this.checked = i;
        this.Second_Tab_ID = str3;
        this.parse_value = wsShieldSearchRanklist_landingParseValue;
    }
}
