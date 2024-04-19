package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataEntranceListItem implements Serializable {
    public String lat;
    public String lon;

    public WsNavigationDynamicDataEntranceListItem() {
        this.lon = "";
        this.lat = "";
    }

    public WsNavigationDynamicDataEntranceListItem(String str, String str2) {
        this.lon = str;
        this.lat = str2;
    }
}
