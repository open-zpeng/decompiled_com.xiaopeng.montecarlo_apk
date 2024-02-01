package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GRangeSpiderAckLineGroup implements Serializable {
    public int id;
    public ArrayList<GRangeSpiderAckLineGroupIsoline> isoline;

    public GRangeSpiderAckLineGroup() {
        this.id = 0;
        this.isoline = new ArrayList<>();
    }

    public GRangeSpiderAckLineGroup(int i, ArrayList<GRangeSpiderAckLineGroupIsoline> arrayList) {
        this.id = i;
        this.isoline = arrayList;
    }
}
