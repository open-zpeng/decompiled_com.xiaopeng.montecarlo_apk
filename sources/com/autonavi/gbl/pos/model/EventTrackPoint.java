package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.pos.model.LocGNSSStatus;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class EventTrackPoint implements Serializable {
    public float course;
    @LocGNSSStatus.LocGNSSStatus1
    public int gnssStatus;
    public Coord3DDouble pos;
    public float posAccuracy;
    public float speed;
    public BigInteger timeStamp;

    public EventTrackPoint() {
        this.pos = new Coord3DDouble();
        this.speed = -1.0f;
        this.course = -1.0f;
        this.timeStamp = new BigInteger("0");
        this.gnssStatus = 86;
        this.posAccuracy = -1.0f;
    }

    public EventTrackPoint(Coord3DDouble coord3DDouble, float f, float f2, BigInteger bigInteger, @LocGNSSStatus.LocGNSSStatus1 int i, float f3) {
        this.pos = coord3DDouble;
        this.speed = f;
        this.course = f2;
        this.timeStamp = bigInteger;
        this.gnssStatus = i;
        this.posAccuracy = f3;
    }
}
