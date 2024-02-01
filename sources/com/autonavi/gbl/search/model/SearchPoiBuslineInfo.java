package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchPoiBuslineInfo implements Serializable {
    public Coord2DDouble location;
    public String name;
    public String poiId;

    public SearchPoiBuslineInfo() {
        this.poiId = "";
        this.name = "";
        this.location = new Coord2DDouble();
    }

    public SearchPoiBuslineInfo(String str, String str2, Coord2DDouble coord2DDouble) {
        this.poiId = str;
        this.name = str2;
        this.location = coord2DDouble;
    }
}
