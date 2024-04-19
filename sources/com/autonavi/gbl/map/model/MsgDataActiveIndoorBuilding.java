package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MsgDataActiveIndoorBuilding implements Serializable {
    public int floorIndex;
    public String floorName;
    public String poiId;

    public MsgDataActiveIndoorBuilding() {
        this.floorIndex = 0;
        this.floorName = "";
        this.poiId = "";
    }

    public MsgDataActiveIndoorBuilding(int i, String str, String str2) {
        this.floorIndex = i;
        this.floorName = str;
        this.poiId = str2;
    }
}
