package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingParseValue implements Serializable {
    public String business;
    public String business_args;

    public WsShieldSearchRanklist_landingParseValue() {
        this.business = "";
        this.business_args = "";
    }

    public WsShieldSearchRanklist_landingParseValue(String str, String str2) {
        this.business = str;
        this.business_args = str2;
    }
}
