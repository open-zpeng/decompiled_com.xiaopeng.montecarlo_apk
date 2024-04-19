package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LinePoiChildBase implements Serializable {
    public String business;
    public String id;
    public String minMame;
    public String name;
    public String parentId;
    public Coord2DDouble poi_loc;
    public String tag;
    public String typecode;

    public LinePoiChildBase() {
        this.id = "";
        this.name = "";
        this.minMame = "";
        this.parentId = "";
        this.typecode = "";
        this.business = "";
        this.tag = "";
        this.poi_loc = new Coord2DDouble();
    }

    public LinePoiChildBase(String str, String str2, String str3, String str4, String str5, String str6, String str7, Coord2DDouble coord2DDouble) {
        this.id = str;
        this.name = str2;
        this.minMame = str3;
        this.parentId = str4;
        this.typecode = str5;
        this.business = str6;
        this.tag = str7;
        this.poi_loc = coord2DDouble;
    }
}
