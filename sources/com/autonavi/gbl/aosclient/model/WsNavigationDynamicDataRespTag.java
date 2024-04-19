package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataRespTag implements Serializable {
    public String bgImgUrl;
    public String color;
    public boolean onlyImg;

    public WsNavigationDynamicDataRespTag() {
        this.color = "";
        this.bgImgUrl = "";
        this.onlyImg = false;
    }

    public WsNavigationDynamicDataRespTag(String str, String str2, boolean z) {
        this.color = str;
        this.bgImgUrl = str2;
        this.onlyImg = z;
    }
}
