package com.autonavi.gbl.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ItemDynamicId implements Serializable {
    public int dynamicId;
    public String itemId;
    public String markerGroup;
    public String markerId;
    public String markerKey;

    public ItemDynamicId() {
        this.markerGroup = "";
        this.markerKey = "";
        this.markerId = "";
        this.itemId = "";
        this.dynamicId = -1;
    }

    public ItemDynamicId(String str, String str2, String str3, String str4, int i) {
        this.markerGroup = str;
        this.markerKey = str2;
        this.markerId = str3;
        this.itemId = str4;
        this.dynamicId = i;
    }
}
