package com.autonavi.gbl.search.model;

import com.autonavi.gbl.search.model.LineDeepQueryType;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SearchLineDeepInfoParam implements Serializable {
    public ArrayList<String> poiIds;
    @LineDeepQueryType.LineDeepQueryType1
    public int queryType;

    public SearchLineDeepInfoParam() {
        this.queryType = 0;
        this.poiIds = new ArrayList<>();
    }

    public SearchLineDeepInfoParam(@LineDeepQueryType.LineDeepQueryType1 int i, ArrayList<String> arrayList) {
        this.queryType = i;
        this.poiIds = arrayList;
    }
}
