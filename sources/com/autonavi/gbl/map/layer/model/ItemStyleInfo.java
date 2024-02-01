package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ItemStyleInfo implements Serializable {
    public String markerGroup;
    public String markerId;
    public String markerInfo;
    public String markerKey;

    public ItemStyleInfo() {
        this.markerGroup = "";
        this.markerKey = "";
        this.markerId = "";
        this.markerInfo = "";
    }

    public ItemStyleInfo(String str, String str2, String str3, String str4) {
        this.markerGroup = str;
        this.markerKey = str2;
        this.markerId = str3;
        this.markerInfo = str4;
    }
}
