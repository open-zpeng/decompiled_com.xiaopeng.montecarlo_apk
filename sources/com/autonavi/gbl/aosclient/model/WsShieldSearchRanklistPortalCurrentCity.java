package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalCurrentCity implements Serializable {
    public String adcode;
    public String name;

    public WsShieldSearchRanklistPortalCurrentCity() {
        this.adcode = "";
        this.name = "";
    }

    public WsShieldSearchRanklistPortalCurrentCity(String str, String str2) {
        this.adcode = str;
        this.name = str2;
    }
}
