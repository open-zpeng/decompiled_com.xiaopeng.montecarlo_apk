package com.autonavi.gbl.search.model;

import com.autonavi.gbl.search.model.LineDeepQueryType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LinePoiBase implements Serializable {
    public String name;
    public String poiId;
    @LineDeepQueryType.LineDeepQueryType1
    public int queryType;
    public String typecode;

    public LinePoiBase() {
        this.queryType = 0;
        this.poiId = "";
        this.name = "";
        this.typecode = "";
    }

    public LinePoiBase(@LineDeepQueryType.LineDeepQueryType1 int i, String str, String str2, String str3) {
        this.queryType = i;
        this.poiId = str;
        this.name = str2;
        this.typecode = str3;
    }
}
