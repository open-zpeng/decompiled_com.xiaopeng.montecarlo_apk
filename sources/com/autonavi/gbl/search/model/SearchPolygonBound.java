package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchPolygonBound implements Serializable {
    public ArrayList<Coord2DDouble> points;

    public SearchPolygonBound() {
        this.points = new ArrayList<>();
    }

    public SearchPolygonBound(ArrayList<Coord2DDouble> arrayList) {
        this.points = arrayList;
    }
}
