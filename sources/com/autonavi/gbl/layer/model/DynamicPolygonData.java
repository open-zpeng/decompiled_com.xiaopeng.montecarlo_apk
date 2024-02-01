package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class DynamicPolygonData implements Serializable {
    public String bizDataDSL;
    public String id;
    public String itemDataDSL;
    public ArrayList<Coord3DDouble> points;

    public DynamicPolygonData() {
        this.id = "";
        this.itemDataDSL = "";
        this.bizDataDSL = "";
        this.points = new ArrayList<>();
    }

    public DynamicPolygonData(String str, String str2, String str3, ArrayList<Coord3DDouble> arrayList) {
        this.id = str;
        this.itemDataDSL = str2;
        this.bizDataDSL = str3;
        this.points = arrayList;
    }
}
