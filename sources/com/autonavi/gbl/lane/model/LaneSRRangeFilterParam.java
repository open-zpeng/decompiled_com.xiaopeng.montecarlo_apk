package com.autonavi.gbl.lane.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LaneSRRangeFilterParam implements Serializable {
    public ArrayList<Integer> exceptTypes;

    public LaneSRRangeFilterParam() {
        this.exceptTypes = new ArrayList<>();
    }

    public LaneSRRangeFilterParam(ArrayList<Integer> arrayList) {
        this.exceptTypes = arrayList;
    }
}
