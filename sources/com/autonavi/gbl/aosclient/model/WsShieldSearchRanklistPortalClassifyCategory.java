package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalClassifyCategory implements Serializable {
    public int checked;
    public String name;
    public WsShieldSearchRanklistPortalParseValue parse_value;

    public WsShieldSearchRanklistPortalClassifyCategory() {
        this.name = "";
        this.checked = 0;
        this.parse_value = new WsShieldSearchRanklistPortalParseValue();
    }

    public WsShieldSearchRanklistPortalClassifyCategory(String str, int i, WsShieldSearchRanklistPortalParseValue wsShieldSearchRanklistPortalParseValue) {
        this.name = str;
        this.checked = i;
        this.parse_value = wsShieldSearchRanklistPortalParseValue;
    }
}
