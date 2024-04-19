package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalParseValue implements Serializable {
    public String business;
    public String business_args;

    public WsShieldSearchRanklistPortalParseValue() {
        this.business = "";
        this.business_args = "";
    }

    public WsShieldSearchRanklistPortalParseValue(String str, String str2) {
        this.business = str;
        this.business_args = str2;
    }
}
