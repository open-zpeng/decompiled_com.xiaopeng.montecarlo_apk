package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ParkingSlope implements Serializable {
    public float parkingSlopeAngle;
    public short parkingSlopeFromFloor;
    public float parkingSlopeHeight;
    public float parkingSlopeLength;
    public short parkingSlopeToFloor;
    public short parkingSlopeType;

    public ParkingSlope() {
        this.parkingSlopeFromFloor = (short) 0;
        this.parkingSlopeToFloor = (short) 0;
        this.parkingSlopeType = (short) 0;
        this.parkingSlopeLength = 0.0f;
        this.parkingSlopeHeight = 0.0f;
        this.parkingSlopeAngle = 0.0f;
    }

    public ParkingSlope(short s, short s2, short s3, float f, float f2, float f3) {
        this.parkingSlopeFromFloor = s;
        this.parkingSlopeToFloor = s2;
        this.parkingSlopeType = s3;
        this.parkingSlopeLength = f;
        this.parkingSlopeHeight = f2;
        this.parkingSlopeAngle = f3;
    }
}
