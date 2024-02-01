package com.autonavi.gbl.information.nearby.model;

import com.autonavi.gbl.common.model.RectDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class NearbyRecommendParam implements Serializable {
    public long pageNumber;
    public RectDouble viewRegion;

    public NearbyRecommendParam() {
        this.pageNumber = 0L;
        this.viewRegion = new RectDouble();
    }

    public NearbyRecommendParam(long j, RectDouble rectDouble) {
        this.pageNumber = j;
        this.viewRegion = rectDouble;
    }
}
