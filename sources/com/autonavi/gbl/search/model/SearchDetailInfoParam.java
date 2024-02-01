package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
@Deprecated
/* loaded from: classes2.dex */
public class SearchDetailInfoParam implements Serializable {
    public String id;
    public Coord2DDouble poi_loc;
    public String poi_name;
    public Coord2DDouble user_loc;

    public SearchDetailInfoParam() {
        this.id = "";
        this.user_loc = new Coord2DDouble();
        this.poi_name = "";
        this.poi_loc = new Coord2DDouble();
        Coord2DDouble coord2DDouble = this.user_loc;
        coord2DDouble.lon = -999.0d;
        coord2DDouble.lat = -999.0d;
        Coord2DDouble coord2DDouble2 = this.poi_loc;
        coord2DDouble2.lon = -999.0d;
        coord2DDouble2.lat = -999.0d;
    }

    public SearchDetailInfoParam(String str, Coord2DDouble coord2DDouble, String str2, Coord2DDouble coord2DDouble2) {
        this.id = str;
        this.user_loc = coord2DDouble;
        this.poi_name = str2;
        this.poi_loc = coord2DDouble2;
    }
}
