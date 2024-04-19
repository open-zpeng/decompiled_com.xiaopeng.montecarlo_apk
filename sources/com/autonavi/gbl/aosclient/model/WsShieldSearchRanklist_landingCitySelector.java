package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingCitySelector implements Serializable {
    public String business;
    public String type;

    public WsShieldSearchRanklist_landingCitySelector() {
        this.business = "";
        this.type = "";
    }

    public WsShieldSearchRanklist_landingCitySelector(String str, String str2) {
        this.business = str;
        this.type = str2;
    }
}
