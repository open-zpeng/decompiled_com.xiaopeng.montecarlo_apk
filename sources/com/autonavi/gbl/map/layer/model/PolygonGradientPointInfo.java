package com.autonavi.gbl.map.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PolygonGradientPointInfo implements Serializable {
    public ArrayList<Coord3DDouble> pointsInner;
    public ArrayList<Coord3DDouble> pointsOut;

    public PolygonGradientPointInfo() {
        this.pointsOut = new ArrayList<>();
        this.pointsInner = new ArrayList<>();
    }

    public PolygonGradientPointInfo(ArrayList<Coord3DDouble> arrayList, ArrayList<Coord3DDouble> arrayList2) {
        this.pointsOut = arrayList;
        this.pointsInner = arrayList2;
    }
}
