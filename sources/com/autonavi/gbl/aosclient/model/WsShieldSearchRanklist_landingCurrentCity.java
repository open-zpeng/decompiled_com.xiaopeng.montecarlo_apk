package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingCurrentCity implements Serializable {
    public String adcode;
    public String name;

    public WsShieldSearchRanklist_landingCurrentCity() {
        this.adcode = "";
        this.name = "";
    }

    public WsShieldSearchRanklist_landingCurrentCity(String str, String str2) {
        this.adcode = str;
        this.name = str2;
    }
}
