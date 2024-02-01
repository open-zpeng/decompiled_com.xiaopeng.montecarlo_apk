package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RouteHttpProtocolParam implements Serializable {
    public String contentOptions;
    public String requestBody;

    public RouteHttpProtocolParam() {
        this.requestBody = "";
        this.contentOptions = "";
    }

    public RouteHttpProtocolParam(String str, String str2) {
        this.requestBody = str;
        this.contentOptions = str2;
    }
}
