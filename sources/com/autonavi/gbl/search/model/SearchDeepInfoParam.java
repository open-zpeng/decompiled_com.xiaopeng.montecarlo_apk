package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchDeepInfoParam implements Serializable {
    public Coord2DDouble poi_loc;
    public String poiid;

    public SearchDeepInfoParam() {
        this.poiid = "";
        this.poi_loc = new Coord2DDouble();
    }

    public SearchDeepInfoParam(String str, Coord2DDouble coord2DDouble) {
        this.poiid = str;
        this.poi_loc = coord2DDouble;
    }
}
