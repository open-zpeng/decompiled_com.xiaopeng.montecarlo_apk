package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class LinePoiServiceAreaChild implements Serializable {
    public LinePoiChildBase childBase;
    public boolean discount;
    public String gasType;

    public LinePoiServiceAreaChild() {
        this.childBase = new LinePoiChildBase();
        this.discount = false;
        this.gasType = "";
    }

    public LinePoiServiceAreaChild(LinePoiChildBase linePoiChildBase, boolean z, String str) {
        this.childBase = linePoiChildBase;
        this.discount = z;
        this.gasType = str;
    }
}
