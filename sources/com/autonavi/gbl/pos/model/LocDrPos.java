package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.pos.model.LocDataType;
import com.autonavi.gbl.pos.model.LocDrType;
import com.autonavi.gbl.pos.model.LocGNSSStatus;
import com.autonavi.gbl.pos.model.LocMoveStatus;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocDrPos implements Serializable {
    public byte EW;
    public byte NS;
    public float alt;
    public float altAcc;
    public float course;
    public float courseAcc;
    @LocDataType.LocDataType1
    public int dataType;
    public GPSDatetime dateTime;
    public float deltaAlt;
    public float deltaAltAcc;
    @LocDrType.LocDrType1
    public int drType;
    @LocGNSSStatus.LocGNSSStatus1
    public int gpsStatus;
    public float hdop;
    public short isEncrypted;
    public double moveDist;
    @LocMoveStatus.LocMoveStatus1
    public int moveStatus;
    public float pdop;
    public float posAcc;
    public int rev;
    public float rollAcc;
    public float rollValue;
    public int satNum;
    public float slopeAcc;
    public float slopeValue;
    public float speed;
    public float speedAcc;
    public Coord2DDouble stPos;
    public Coord2DDouble stPosRaw;
    public BigInteger tickTime;
    public LocViaductValid validField;
    public float vdop;

    public LocDrPos() {
        this.dataType = 512;
        this.gpsStatus = 86;
        this.isEncrypted = (short) 0;
        this.NS = (byte) 0;
        this.EW = (byte) 0;
        this.rev = 0;
        this.stPos = new Coord2DDouble();
        this.stPosRaw = new Coord2DDouble();
        this.speed = 0.0f;
        this.course = 0.0f;
        this.alt = 0.0f;
        this.posAcc = 0.0f;
        this.courseAcc = 0.0f;
        this.altAcc = 0.0f;
        this.speedAcc = 0.0f;
        this.satNum = 0;
        this.hdop = 0.0f;
        this.vdop = 0.0f;
        this.pdop = 0.0f;
        this.dateTime = new GPSDatetime();
        this.tickTime = new BigInteger("0");
        this.drType = 0;
        this.moveStatus = 0;
        this.validField = new LocViaductValid();
        this.deltaAlt = 0.0f;
        this.deltaAltAcc = 0.0f;
        this.slopeValue = 0.0f;
        this.slopeAcc = 0.0f;
        this.rollValue = 0.0f;
        this.rollAcc = 0.0f;
        this.moveDist = 0.0d;
    }

    public LocDrPos(@LocDataType.LocDataType1 int i, @LocGNSSStatus.LocGNSSStatus1 int i2, short s, byte b, byte b2, int i3, Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, float f, float f2, float f3, float f4, float f5, float f6, float f7, int i4, float f8, float f9, float f10, GPSDatetime gPSDatetime, BigInteger bigInteger, @LocDrType.LocDrType1 int i5, @LocMoveStatus.LocMoveStatus1 int i6, LocViaductValid locViaductValid, float f11, float f12, float f13, float f14, float f15, float f16, double d) {
        this.dataType = i;
        this.gpsStatus = i2;
        this.isEncrypted = s;
        this.NS = b;
        this.EW = b2;
        this.rev = i3;
        this.stPos = coord2DDouble;
        this.stPosRaw = coord2DDouble2;
        this.speed = f;
        this.course = f2;
        this.alt = f3;
        this.posAcc = f4;
        this.courseAcc = f5;
        this.altAcc = f6;
        this.speedAcc = f7;
        this.satNum = i4;
        this.hdop = f8;
        this.vdop = f9;
        this.pdop = f10;
        this.dateTime = gPSDatetime;
        this.tickTime = bigInteger;
        this.drType = i5;
        this.moveStatus = i6;
        this.validField = locViaductValid;
        this.deltaAlt = f11;
        this.deltaAltAcc = f12;
        this.slopeValue = f13;
        this.slopeAcc = f14;
        this.rollValue = f15;
        this.rollAcc = f16;
        this.moveDist = d;
    }
}
