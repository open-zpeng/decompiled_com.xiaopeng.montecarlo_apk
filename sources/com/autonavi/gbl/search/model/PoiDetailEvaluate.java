package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PoiDetailEvaluate implements Serializable {
    public SearchNaviVisit naviVisit;

    public PoiDetailEvaluate() {
        this.naviVisit = new SearchNaviVisit();
    }

    public PoiDetailEvaluate(SearchNaviVisit searchNaviVisit) {
        this.naviVisit = searchNaviVisit;
    }
}
