package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataRespDetail implements Serializable {
    public String requestParams;
    public WsNavigationDynamicDataRespStyleClass style;
    public WsNavigationDynamicDataRespTitle title;

    public WsNavigationDynamicDataRespDetail() {
        this.style = new WsNavigationDynamicDataRespStyleClass();
        this.title = new WsNavigationDynamicDataRespTitle();
        this.requestParams = "";
    }

    public WsNavigationDynamicDataRespDetail(WsNavigationDynamicDataRespStyleClass wsNavigationDynamicDataRespStyleClass, WsNavigationDynamicDataRespTitle wsNavigationDynamicDataRespTitle, String str) {
        this.style = wsNavigationDynamicDataRespStyleClass;
        this.title = wsNavigationDynamicDataRespTitle;
        this.requestParams = str;
    }
}
