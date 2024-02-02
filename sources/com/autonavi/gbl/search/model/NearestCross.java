package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class NearestCross implements Serializable {
    public Coord2DDouble coord;
    public String crossid;
    public String direction;
    public int distance;
    public String level;
    public String name;
    public int weight;
    public String width;

    public NearestCross() {
        this.crossid = "";
        this.name = "";
        this.direction = "";
        this.level = "";
        this.distance = 0;
        this.weight = 0;
        this.width = "";
        this.coord = new Coord2DDouble();
    }

    public NearestCross(String str, String str2, String str3, String str4, int i, int i2, String str5, Coord2DDouble coord2DDouble) {
        this.crossid = str;
        this.name = str2;
        this.direction = str3;
        this.level = str4;
        this.distance = i;
        this.weight = i2;
        this.width = str5;
        this.coord = coord2DDouble;
    }
}
