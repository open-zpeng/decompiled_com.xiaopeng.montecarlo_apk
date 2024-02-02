package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RouteForbidden implements Serializable {
    public long linkIndex;
    public long segIndex;
    public ArrayList<Short> timeDescription;
    public short type;
    public short vehicleType;

    public RouteForbidden() {
        this.type = (short) 0;
        this.vehicleType = (short) 0;
        this.segIndex = 0L;
        this.linkIndex = 0L;
        this.timeDescription = new ArrayList<>();
    }

    public RouteForbidden(short s, short s2, long j, long j2, ArrayList<Short> arrayList) {
        this.type = s;
        this.vehicleType = s2;
        this.segIndex = j;
        this.linkIndex = j2;
        this.timeDescription = arrayList;
    }
}
