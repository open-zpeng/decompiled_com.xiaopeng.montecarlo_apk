package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DInt32;
import com.autonavi.gbl.pos.model.LocDataType;
import com.autonavi.gbl.pos.model.LocDrType;
import com.autonavi.gbl.pos.model.LocGNSSStatus;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocInnerPDRSignal implements Serializable {
    public float airAlt;
    public float azi;
    public float aziAcc;
    @LocDataType.LocDataType1
    public int dataType;
    @LocDrType.LocDrType1
    public int drStatus;
    public Coord3DInt32 ectRawPos;
    public short fusionType;
    @LocGNSSStatus.LocGNSSStatus1
    public int gpsStatus;
    public BigInteger gpsTime;
    public int num;
    public Coord3DInt32 pos;
    public float posAcc;
    public Coord3DInt32 rawPos;
    public int sourType;
    public float speed;
    public float speedAcc;
    public BigInteger tickTime;

    public LocInnerPDRSignal() {
        this.dataType = 0;
        this.gpsTime = new BigInteger("0");
        this.tickTime = new BigInteger("0");
        this.sourType = 0;
        this.pos = new Coord3DInt32();
        this.rawPos = new Coord3DInt32();
        this.ectRawPos = new Coord3DInt32();
        this.azi = 0.0f;
        this.speed = 0.0f;
        this.airAlt = 0.0f;
        this.posAcc = 0.0f;
        this.aziAcc = 0.0f;
        this.speedAcc = 0.0f;
        this.gpsStatus = 86;
        this.drStatus = 0;
        this.fusionType = (short) 0;
        this.num = 0;
    }

    public LocInnerPDRSignal(@LocDataType.LocDataType1 int i, BigInteger bigInteger, BigInteger bigInteger2, int i2, Coord3DInt32 coord3DInt32, Coord3DInt32 coord3DInt322, Coord3DInt32 coord3DInt323, float f, float f2, float f3, float f4, float f5, float f6, @LocGNSSStatus.LocGNSSStatus1 int i3, @LocDrType.LocDrType1 int i4, short s, int i5) {
        this.dataType = i;
        this.gpsTime = bigInteger;
        this.tickTime = bigInteger2;
        this.sourType = i2;
        this.pos = coord3DInt32;
        this.rawPos = coord3DInt322;
        this.ectRawPos = coord3DInt323;
        this.azi = f;
        this.speed = f2;
        this.airAlt = f3;
        this.posAcc = f4;
        this.aziAcc = f5;
        this.speedAcc = f6;
        this.gpsStatus = i3;
        this.drStatus = i4;
        this.fusionType = s;
        this.num = i5;
    }
}
