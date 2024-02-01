package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchCacheFilter implements Serializable {
    public int expires;
    public int flag;

    public SearchCacheFilter() {
        this.flag = -1;
        this.expires = -1;
    }

    public SearchCacheFilter(int i, int i2) {
        this.flag = i;
        this.expires = i2;
    }
}
