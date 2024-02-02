package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class IndoorBuildingFloor implements Serializable {
    public int floorIndex;
    public String floorName;
    public String floorNona;
    public boolean isParkFloor;

    public IndoorBuildingFloor() {
        this.isParkFloor = false;
        this.floorIndex = 0;
        this.floorName = "";
        this.floorNona = "";
    }

    public IndoorBuildingFloor(boolean z, int i, String str, String str2) {
        this.isParkFloor = z;
        this.floorIndex = i;
        this.floorName = str;
        this.floorNona = str2;
    }
}
