package com.autonavi.gbl.information.nearby.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class NearbyRecommendPoiRetainParam implements Serializable {
    public int adcode;
    public String bizType;
    public long index;
    public long pageNumber;
    public String poiId;
    public String tag;

    public NearbyRecommendPoiRetainParam() {
        this.bizType = "";
        this.tag = "";
        this.poiId = "";
        this.index = 0L;
        this.pageNumber = 0L;
        this.adcode = 0;
    }

    public NearbyRecommendPoiRetainParam(String str, String str2, String str3, long j, long j2, int i) {
        this.bizType = str;
        this.tag = str2;
        this.poiId = str3;
        this.index = j;
        this.pageNumber = j2;
        this.adcode = i;
    }
}
