package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalHeaderIcon implements Serializable {
    public String src;
    public WsShieldSearchRanklistPortalTitleIconSize style;

    public WsShieldSearchRanklistPortalHeaderIcon() {
        this.src = "";
        this.style = new WsShieldSearchRanklistPortalTitleIconSize();
    }

    public WsShieldSearchRanklistPortalHeaderIcon(String str, WsShieldSearchRanklistPortalTitleIconSize wsShieldSearchRanklistPortalTitleIconSize) {
        this.src = str;
        this.style = wsShieldSearchRanklistPortalTitleIconSize;
    }
}
