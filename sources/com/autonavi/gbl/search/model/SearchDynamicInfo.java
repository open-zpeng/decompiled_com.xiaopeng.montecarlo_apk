package com.autonavi.gbl.search.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SearchDynamicInfo implements Serializable {
    public int space;
    public int spaceFree;

    public SearchDynamicInfo() {
        this.space = -1;
        this.spaceFree = -1;
    }

    public SearchDynamicInfo(int i, int i2) {
        this.space = i;
        this.spaceFree = i2;
    }
}
