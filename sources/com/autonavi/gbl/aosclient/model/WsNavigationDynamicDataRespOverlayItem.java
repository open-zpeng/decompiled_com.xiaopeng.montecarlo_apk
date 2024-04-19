package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataRespOverlayItem implements Serializable {
    public WsNavigationDynamicDataRespData data;
    public String type;

    public WsNavigationDynamicDataRespOverlayItem() {
        this.type = "";
        this.data = new WsNavigationDynamicDataRespData();
    }

    public WsNavigationDynamicDataRespOverlayItem(String str, WsNavigationDynamicDataRespData wsNavigationDynamicDataRespData) {
        this.type = str;
        this.data = wsNavigationDynamicDataRespData;
    }
}
