package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GRangeSpiderAckLineGroupIsolineComponent implements Serializable {
    public int id;
    public ArrayList<GRangeSpiderPoint> shape;

    public GRangeSpiderAckLineGroupIsolineComponent() {
        this.id = 0;
        this.shape = new ArrayList<>();
    }

    public GRangeSpiderAckLineGroupIsolineComponent(int i, ArrayList<GRangeSpiderPoint> arrayList) {
        this.id = i;
        this.shape = arrayList;
    }
}
