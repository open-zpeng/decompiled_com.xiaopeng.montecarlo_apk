package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RouteInfoDataDetailItem implements Serializable {
    public String color;
    public String ratio;
    public String status;

    public RouteInfoDataDetailItem() {
        this.status = "";
        this.ratio = "";
        this.color = "";
    }

    public RouteInfoDataDetailItem(String str, String str2, String str3) {
        this.status = str;
        this.ratio = str2;
        this.color = str3;
    }
}
