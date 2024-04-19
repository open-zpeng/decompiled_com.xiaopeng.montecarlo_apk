package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchPoiFloor implements Serializable {
    public String floorName;
    public int floorNo;
    public String floorTitle;

    public SearchPoiFloor() {
        this.floorNo = 0;
        this.floorName = "";
        this.floorTitle = "";
    }

    public SearchPoiFloor(int i, String str, String str2) {
        this.floorNo = i;
        this.floorName = str;
        this.floorTitle = str2;
    }
}
