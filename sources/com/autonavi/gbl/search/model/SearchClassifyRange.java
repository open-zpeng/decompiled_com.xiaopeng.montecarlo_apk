package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchClassifyRange implements Serializable {
    public int districtAdcode;
    public int districtEnable;
    public int nearbyEnable;
    public int subwayAdcode;
    public int subwayEnable;

    public SearchClassifyRange() {
        this.districtAdcode = 0;
        this.subwayAdcode = 0;
        this.nearbyEnable = 0;
        this.subwayEnable = 0;
        this.districtEnable = 0;
    }

    public SearchClassifyRange(int i, int i2, int i3, int i4, int i5) {
        this.districtAdcode = i;
        this.subwayAdcode = i2;
        this.nearbyEnable = i3;
        this.subwayEnable = i4;
        this.districtEnable = i5;
    }
}
