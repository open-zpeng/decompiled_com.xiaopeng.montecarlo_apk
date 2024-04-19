package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GRangeSpiderAckLineGroupIsolineConnection implements Serializable {
    public int end;
    public int id;
    public ArrayList<GRangeSpiderPoint> shape;
    public int start;

    public GRangeSpiderAckLineGroupIsolineConnection() {
        this.id = 0;
        this.start = 0;
        this.end = 0;
        this.shape = new ArrayList<>();
    }

    public GRangeSpiderAckLineGroupIsolineConnection(int i, int i2, int i3, ArrayList<GRangeSpiderPoint> arrayList) {
        this.id = i;
        this.start = i2;
        this.end = i3;
        this.shape = arrayList;
    }
}
