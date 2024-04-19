package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataRespPoint implements Serializable {
    public String latitude;
    public String longitude;

    public WsNavigationDynamicDataRespPoint() {
        this.longitude = "";
        this.latitude = "";
    }

    public WsNavigationDynamicDataRespPoint(String str, String str2) {
        this.longitude = str;
        this.latitude = str2;
    }
}
