package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GRangeSpiderAckLineGroupIsolineBbox implements Serializable {
    public GRangeSpiderPoint bottomright;
    public GRangeSpiderPoint topleft;

    public GRangeSpiderAckLineGroupIsolineBbox() {
        this.topleft = new GRangeSpiderPoint();
        this.bottomright = new GRangeSpiderPoint();
    }

    public GRangeSpiderAckLineGroupIsolineBbox(GRangeSpiderPoint gRangeSpiderPoint, GRangeSpiderPoint gRangeSpiderPoint2) {
        this.topleft = gRangeSpiderPoint;
        this.bottomright = gRangeSpiderPoint2;
    }
}
