package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingDataBookIcon implements Serializable {
    public String bg_img;
    public String text;
    public String text_color;

    public WsShieldSearchRanklist_landingDataBookIcon() {
        this.text = "";
        this.text_color = "";
        this.bg_img = "";
    }

    public WsShieldSearchRanklist_landingDataBookIcon(String str, String str2, String str3) {
        this.text = str;
        this.text_color = str2;
        this.bg_img = str3;
    }
}
