package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalUnionEntrance implements Serializable {
    public String schema;
    public String text;

    public WsShieldSearchRanklistPortalUnionEntrance() {
        this.text = "";
        this.schema = "";
    }

    public WsShieldSearchRanklistPortalUnionEntrance(String str, String str2) {
        this.text = str;
        this.schema = str2;
    }
}
