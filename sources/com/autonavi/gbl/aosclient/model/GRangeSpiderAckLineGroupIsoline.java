package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GRangeSpiderAckLineGroupIsoline implements Serializable {
    public GRangeSpiderAckLineGroupIsolineBbox bbox;
    public ArrayList<GRangeSpiderAckLineGroupIsolineComponent> component;
    public ArrayList<GRangeSpiderAckLineGroupIsolineConnection> connection;
    public int drivemode;
    public double energy;
    public int fesmode;
    public int strategy;
    public int travel;
    public int unit;

    public GRangeSpiderAckLineGroupIsoline() {
        this.bbox = new GRangeSpiderAckLineGroupIsolineBbox();
        this.energy = 0.0d;
        this.unit = 0;
        this.strategy = 0;
        this.drivemode = 0;
        this.fesmode = 0;
        this.travel = 0;
        this.component = new ArrayList<>();
        this.connection = new ArrayList<>();
    }

    public GRangeSpiderAckLineGroupIsoline(GRangeSpiderAckLineGroupIsolineBbox gRangeSpiderAckLineGroupIsolineBbox, double d, int i, int i2, int i3, int i4, int i5, ArrayList<GRangeSpiderAckLineGroupIsolineComponent> arrayList, ArrayList<GRangeSpiderAckLineGroupIsolineConnection> arrayList2) {
        this.bbox = gRangeSpiderAckLineGroupIsolineBbox;
        this.energy = d;
        this.unit = i;
        this.strategy = i2;
        this.drivemode = i3;
        this.fesmode = i4;
        this.travel = i5;
        this.component = arrayList;
        this.connection = arrayList2;
    }
}
