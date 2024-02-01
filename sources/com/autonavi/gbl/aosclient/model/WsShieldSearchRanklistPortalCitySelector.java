package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalCitySelector implements Serializable {
    public String business;
    public String type;

    public WsShieldSearchRanklistPortalCitySelector() {
        this.business = "";
        this.type = "";
    }

    public WsShieldSearchRanklistPortalCitySelector(String str, String str2) {
        this.business = str;
        this.type = str2;
    }
}
