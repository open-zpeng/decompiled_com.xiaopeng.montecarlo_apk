package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchNearestParam implements Serializable {
    public Coord2DDouble poi_loc;

    public SearchNearestParam() {
        this.poi_loc = new Coord2DDouble();
    }

    public SearchNearestParam(Coord2DDouble coord2DDouble) {
        this.poi_loc = coord2DDouble;
    }
}
