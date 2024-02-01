package com.autonavi.gbl.information.nearby.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class NearbyRecommendImage implements Serializable {
    public long height;
    public String imageUrl;
    public String source;
    public long width;

    public NearbyRecommendImage() {
        this.imageUrl = "";
        this.width = 0L;
        this.height = 0L;
        this.source = "";
    }

    public NearbyRecommendImage(String str, long j, long j2, String str2) {
        this.imageUrl = str;
        this.width = j;
        this.height = j2;
        this.source = str2;
    }
}
