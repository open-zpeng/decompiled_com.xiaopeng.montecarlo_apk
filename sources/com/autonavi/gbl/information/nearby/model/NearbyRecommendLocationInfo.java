package com.autonavi.gbl.information.nearby.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class NearbyRecommendLocationInfo implements Serializable {
    public int adcode;
    public String name;
    public String poiId;

    public NearbyRecommendLocationInfo() {
        this.poiId = "";
        this.name = "";
        this.adcode = 0;
    }

    public NearbyRecommendLocationInfo(String str, String str2, int i) {
        this.poiId = str;
        this.name = str2;
        this.adcode = i;
    }
}
