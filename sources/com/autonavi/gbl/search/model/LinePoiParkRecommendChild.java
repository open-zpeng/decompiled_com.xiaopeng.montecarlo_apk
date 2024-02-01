package com.autonavi.gbl.search.model;

import com.autonavi.gbl.search.model.ParkColorType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LinePoiParkRecommendChild implements Serializable {
    public LinePoiChildBase childBase;
    @ParkColorType.ParkColorType1
    public int parkColor;
    public String tagCategory;

    public LinePoiParkRecommendChild() {
        this.childBase = new LinePoiChildBase();
        this.tagCategory = "";
        this.parkColor = 0;
    }

    public LinePoiParkRecommendChild(LinePoiChildBase linePoiChildBase, String str, @ParkColorType.ParkColorType1 int i) {
        this.childBase = linePoiChildBase;
        this.tagCategory = str;
        this.parkColor = i;
    }
}
