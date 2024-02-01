package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchPageParam implements Serializable {
    public int pageNum;
    public int pageSize;

    public SearchPageParam() {
        this.pageNum = 1;
        this.pageSize = 10;
    }

    public SearchPageParam(int i, int i2) {
        this.pageNum = i;
        this.pageSize = i2;
    }
}
