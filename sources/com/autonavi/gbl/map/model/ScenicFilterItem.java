package com.autonavi.gbl.map.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ScenicFilterItem implements Serializable {
    public long index;
    public ArrayList<ScenicFilter> scenicFilters;

    public ScenicFilterItem() {
        this.index = 0L;
        this.scenicFilters = new ArrayList<>();
    }

    public ScenicFilterItem(long j, ArrayList<ScenicFilter> arrayList) {
        this.index = j;
        this.scenicFilters = arrayList;
    }
}
