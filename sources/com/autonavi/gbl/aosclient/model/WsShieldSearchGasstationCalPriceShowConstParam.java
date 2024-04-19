package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchGasstationCalPriceShowConstParam implements Serializable {
    public String query_keywords;
    public String t_tag;
    public String type;

    public WsShieldSearchGasstationCalPriceShowConstParam() {
        this.query_keywords = "";
        this.type = "";
        this.t_tag = "";
    }

    public WsShieldSearchGasstationCalPriceShowConstParam(String str, String str2, String str3) {
        this.query_keywords = str;
        this.type = str2;
        this.t_tag = str3;
    }
}
