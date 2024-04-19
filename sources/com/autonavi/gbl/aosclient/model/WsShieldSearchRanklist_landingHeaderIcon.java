package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingHeaderIcon implements Serializable {
    public String src;
    public WsShieldSearchRanklist_landingTitleIconSize style;

    public WsShieldSearchRanklist_landingHeaderIcon() {
        this.src = "";
        this.style = new WsShieldSearchRanklist_landingTitleIconSize();
    }

    public WsShieldSearchRanklist_landingHeaderIcon(String str, WsShieldSearchRanklist_landingTitleIconSize wsShieldSearchRanklist_landingTitleIconSize) {
        this.src = str;
        this.style = wsShieldSearchRanklist_landingTitleIconSize;
    }
}
