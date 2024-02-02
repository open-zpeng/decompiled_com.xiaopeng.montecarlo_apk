package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class NearestRoad implements Serializable {
    public Coord2DDouble coord;
    public String direction;
    public int distance;
    public int level;
    public String name;
    public String roadid;
    public int width;

    public NearestRoad() {
        this.roadid = "";
        this.name = "";
        this.direction = "";
        this.level = 0;
        this.distance = 0;
        this.width = 0;
        this.coord = new Coord2DDouble();
    }

    public NearestRoad(String str, String str2, String str3, int i, int i2, int i3, Coord2DDouble coord2DDouble) {
        this.roadid = str;
        this.name = str2;
        this.direction = str3;
        this.level = i;
        this.distance = i2;
        this.width = i3;
        this.coord = coord2DDouble;
    }
}
