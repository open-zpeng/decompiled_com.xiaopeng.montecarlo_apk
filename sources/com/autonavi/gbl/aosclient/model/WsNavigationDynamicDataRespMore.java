package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataRespMore implements Serializable {
    public String color;
    public String moreImg;
    public String splitLineColor;

    public WsNavigationDynamicDataRespMore() {
        this.color = "";
        this.splitLineColor = "";
        this.moreImg = "";
    }

    public WsNavigationDynamicDataRespMore(String str, String str2, String str3) {
        this.color = str;
        this.splitLineColor = str2;
        this.moreImg = str3;
    }
}
