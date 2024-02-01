package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingMetaShare implements Serializable {
    public String desc;
    public String icon;
    public String jump_amap_url;
    public String jump_url;
    public String title;

    public WsShieldSearchRanklist_landingMetaShare() {
        this.title = "";
        this.desc = "";
        this.icon = "";
        this.jump_url = "";
        this.jump_amap_url = "";
    }

    public WsShieldSearchRanklist_landingMetaShare(String str, String str2, String str3, String str4, String str5) {
        this.title = str;
        this.desc = str2;
        this.icon = str3;
        this.jump_url = str4;
        this.jump_amap_url = str5;
    }
}
