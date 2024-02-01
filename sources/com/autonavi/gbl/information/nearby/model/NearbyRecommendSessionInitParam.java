package com.autonavi.gbl.information.nearby.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class NearbyRecommendSessionInitParam implements Serializable {
    public long networkTimeout;

    public NearbyRecommendSessionInitParam() {
        this.networkTimeout = 30L;
    }

    public NearbyRecommendSessionInitParam(long j) {
        this.networkTimeout = j;
    }
}
