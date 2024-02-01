package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GRangeSpiderPointList implements Serializable {
    public ArrayList<GRangeSpiderPoint> pointlist;

    public GRangeSpiderPointList() {
        this.pointlist = new ArrayList<>();
    }

    public GRangeSpiderPointList(ArrayList<GRangeSpiderPoint> arrayList) {
        this.pointlist = arrayList;
    }
}
