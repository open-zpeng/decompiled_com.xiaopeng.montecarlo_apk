package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DInt32;
import com.autonavi.gbl.pos.model.LocDrType;
import com.autonavi.gbl.pos.model.LocGNSSStatus;
import com.autonavi.gbl.pos.model.LocMoveStatus;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class DrInfo implements Serializable {
    public float aziAcc;
    public boolean bMountAngleReady;
    public float deltaAlt;
    public float deltaAltAcc;
    public double deltaBearing;
    public double deltaPos;
    public float drAzi;
    public float drMatchAzi;
    public Coord3DInt32 drMatchPos;
    public Coord3DInt32 drRawPos;
    @LocDrType.LocDrType1
    public int drStatus;
    @LocGNSSStatus.LocGNSSStatus1
    public int gpsStatus;
    public boolean matchStatus;
    public double moveDist;
    @LocMoveStatus.LocMoveStatus1
    public int moveStatus;
    public float pluseSpd;
    public float posAcc;
    public long sceneState;
    public float slopeAcc;
    public float slopeValue;
    public float spd;
    public BigInteger tickTime;

    public DrInfo() {
        this.tickTime = new BigInteger("0");
        this.gpsStatus = 86;
        this.drRawPos = new Coord3DInt32();
        this.drAzi = 0.0f;
        this.spd = 0.0f;
        this.posAcc = 0.0f;
        this.aziAcc = 0.0f;
        this.moveStatus = 0;
        this.drStatus = 0;
        this.sceneState = 0L;
        this.deltaBearing = 0.0d;
        this.deltaPos = 0.0d;
        this.pluseSpd = 0.0f;
        this.deltaAlt = 0.0f;
        this.deltaAltAcc = 0.0f;
        this.slopeValue = 0.0f;
        this.slopeAcc = 0.0f;
        this.moveDist = 0.0d;
        this.bMountAngleReady = false;
        this.matchStatus = false;
        this.drMatchPos = new Coord3DInt32();
        this.drMatchAzi = 0.0f;
    }

    public DrInfo(BigInteger bigInteger, @LocGNSSStatus.LocGNSSStatus1 int i, Coord3DInt32 coord3DInt32, float f, float f2, float f3, float f4, @LocMoveStatus.LocMoveStatus1 int i2, @LocDrType.LocDrType1 int i3, long j, double d, double d2, float f5, float f6, float f7, float f8, float f9, double d3, boolean z, boolean z2, Coord3DInt32 coord3DInt322, float f10) {
        this.tickTime = bigInteger;
        this.gpsStatus = i;
        this.drRawPos = coord3DInt32;
        this.drAzi = f;
        this.spd = f2;
        this.posAcc = f3;
        this.aziAcc = f4;
        this.moveStatus = i2;
        this.drStatus = i3;
        this.sceneState = j;
        this.deltaBearing = d;
        this.deltaPos = d2;
        this.pluseSpd = f5;
        this.deltaAlt = f6;
        this.deltaAltAcc = f7;
        this.slopeValue = f8;
        this.slopeAcc = f9;
        this.moveDist = d3;
        this.bMountAngleReady = z;
        this.matchStatus = z2;
        this.drMatchPos = coord3DInt322;
        this.drMatchAzi = f10;
    }
}
