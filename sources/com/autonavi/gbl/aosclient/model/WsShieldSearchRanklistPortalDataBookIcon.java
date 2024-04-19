package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalDataBookIcon implements Serializable {
    public String bg_img;
    public String text;
    public String text_color;

    public WsShieldSearchRanklistPortalDataBookIcon() {
        this.text = "";
        this.text_color = "";
        this.bg_img = "";
    }

    public WsShieldSearchRanklistPortalDataBookIcon(String str, String str2, String str3) {
        this.text = str;
        this.text_color = str2;
        this.bg_img = str3;
    }
}
