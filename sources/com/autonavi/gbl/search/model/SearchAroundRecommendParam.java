package com.autonavi.gbl.search.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
@Deprecated
/* loaded from: classes2.dex */
public class SearchAroundRecommendParam implements Serializable {
    public String category;
    public int pagesize;
    public int range;
    public Coord2DDouble user_loc;

    public SearchAroundRecommendParam() {
        this.user_loc = new Coord2DDouble();
        this.category = "";
        this.pagesize = -1;
        this.range = -1;
    }

    public SearchAroundRecommendParam(Coord2DDouble coord2DDouble, String str, int i, int i2) {
        this.user_loc = coord2DDouble;
        this.category = str;
        this.pagesize = i;
        this.range = i2;
    }
}
