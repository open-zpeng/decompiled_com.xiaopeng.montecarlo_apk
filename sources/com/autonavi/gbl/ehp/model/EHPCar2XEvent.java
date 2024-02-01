package com.autonavi.gbl.ehp.model;

import com.autonavi.gbl.common.model.Coord2DInt32;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class EHPCar2XEvent implements Serializable {
    public int eventId;
    public int eventType;
    public BigInteger linkId;
    public Coord2DInt32 point;
    public int reliability;
    public long status;
    public long systemId;

    public EHPCar2XEvent() {
        this.linkId = new BigInteger("0");
        this.status = 0L;
        this.systemId = 0L;
        this.reliability = 0;
        this.eventType = 0;
        this.eventId = 0;
        this.point = new Coord2DInt32();
    }

    public EHPCar2XEvent(BigInteger bigInteger, long j, long j2, int i, int i2, int i3, Coord2DInt32 coord2DInt32) {
        this.linkId = bigInteger;
        this.status = j;
        this.systemId = j2;
        this.reliability = i;
        this.eventType = i2;
        this.eventId = i3;
        this.point = coord2DInt32;
    }
}
