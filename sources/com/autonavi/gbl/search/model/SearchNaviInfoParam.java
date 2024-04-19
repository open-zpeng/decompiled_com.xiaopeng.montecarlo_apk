package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchNaviInfoParam implements Serializable {
    public String poiid;
    public String rel_type;

    public SearchNaviInfoParam() {
        this.poiid = "";
        this.rel_type = "";
    }

    public SearchNaviInfoParam(String str, String str2) {
        this.poiid = str;
        this.rel_type = str2;
    }
}
