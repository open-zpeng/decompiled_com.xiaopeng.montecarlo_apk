package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataRespStyle implements Serializable {
    public String backgroundColor;
    public String backgroundUrl;
    public WsNavigationDynamicDataRespTag tag;

    public WsNavigationDynamicDataRespStyle() {
        this.backgroundColor = "";
        this.backgroundUrl = "";
        this.tag = new WsNavigationDynamicDataRespTag();
    }

    public WsNavigationDynamicDataRespStyle(String str, String str2, WsNavigationDynamicDataRespTag wsNavigationDynamicDataRespTag) {
        this.backgroundColor = str;
        this.backgroundUrl = str2;
        this.tag = wsNavigationDynamicDataRespTag;
    }
}
