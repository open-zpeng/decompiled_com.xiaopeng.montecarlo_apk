package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchPoiDetailParam implements Serializable {
    public int adcode;
    public String poiId;
    public SearchRetainParam retainParam;
    public Coord2DDouble userLoc;

    public SearchPoiDetailParam() {
        this.adcode = 0;
        this.poiId = "";
        this.userLoc = new Coord2DDouble();
        this.retainParam = new SearchRetainParam();
    }

    public SearchPoiDetailParam(int i, String str, Coord2DDouble coord2DDouble, SearchRetainParam searchRetainParam) {
        this.adcode = i;
        this.poiId = str;
        this.userLoc = coord2DDouble;
        this.retainParam = searchRetainParam;
    }
}
