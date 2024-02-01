package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingClassifyCategory implements Serializable {
    public int checked;
    public String name;
    public WsShieldSearchRanklist_landingParseValue parse_value;

    public WsShieldSearchRanklist_landingClassifyCategory() {
        this.name = "";
        this.checked = 0;
        this.parse_value = new WsShieldSearchRanklist_landingParseValue();
    }

    public WsShieldSearchRanklist_landingClassifyCategory(String str, int i, WsShieldSearchRanklist_landingParseValue wsShieldSearchRanklist_landingParseValue) {
        this.name = str;
        this.checked = i;
        this.parse_value = wsShieldSearchRanklist_landingParseValue;
    }
}
