package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.pos.model.LocDataType;
import com.autonavi.gbl.pos.model.LocGNSSStatus;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocAllFusionPos implements Serializable {
    public byte EW;
    public byte NS;
    public float alt;
    public float altAcc;
    public float course;
    public float courseAcc;
    @LocDataType.LocDataType1
    public int dataType;
    public GPSDatetime dateTime;
    public int fusionStatus;
    public byte fusionType;
    public short isEncrypted;
    public short isEnuLocalPos;
    public boolean isUseRotation;
    public int locAccStatus;
    public BigInteger localTickTime;
    public Coord3DDouble pos;
    public float posAcc;
    public PosCoordLocal posEnu;
    public Coord3DDouble posRaw;
    public PosCoordLocal refPosEcef;
    public PosRotation rotation;
    public float speed;
    public float speedAcc;
    @LocGNSSStatus.LocGNSSStatus1
    public int status;
    public BigInteger tickTime;

    public LocAllFusionPos() {
        this.dataType = LocDataType.LocDataAllFusion;
        this.tickTime = new BigInteger("0");
        this.status = 65;
        this.isEncrypted = (short) 1;
        this.NS = (byte) 78;
        this.EW = (byte) 69;
        this.pos = new Coord3DDouble();
        this.posRaw = new Coord3DDouble();
        this.isEnuLocalPos = (short) 1;
        this.posEnu = new PosCoordLocal(0.0d, 0.0d, 0.0d);
        this.refPosEcef = new PosCoordLocal(0.0d, 0.0d, 0.0d);
        this.isUseRotation = false;
        this.rotation = new PosRotation();
        this.speed = 0.0f;
        this.course = 0.0f;
        this.alt = 0.0f;
        this.posAcc = -1.0f;
        this.courseAcc = -1.0f;
        this.altAcc = -1.0f;
        this.speedAcc = -1.0f;
        this.dateTime = new GPSDatetime();
        this.fusionType = (byte) -1;
        this.fusionStatus = 0;
        this.locAccStatus = 0;
        this.localTickTime = new BigInteger("0");
        Coord3DDouble coord3DDouble = this.posRaw;
        coord3DDouble.z = 0.0d;
        coord3DDouble.lon = 0.0d;
        coord3DDouble.lat = 0.0d;
        Coord3DDouble coord3DDouble2 = this.pos;
        coord3DDouble2.lon = 0.0d;
        GPSDatetime gPSDatetime = this.dateTime;
        gPSDatetime.day = -1;
        gPSDatetime.hour = -1;
        PosRotation posRotation = this.rotation;
        posRotation.qw = 0.0d;
        posRotation.qx = 0.0d;
        posRotation.qy = 0.0d;
        posRotation.qz = 0.0d;
        gPSDatetime.minute = -1;
        gPSDatetime.month = -1;
        gPSDatetime.year = -1;
        coord3DDouble2.lat = 0.0d;
        coord3DDouble2.z = 0.0d;
        gPSDatetime.second = -1;
    }

    public LocAllFusionPos(@LocDataType.LocDataType1 int i, BigInteger bigInteger, @LocGNSSStatus.LocGNSSStatus1 int i2, short s, byte b, byte b2, Coord3DDouble coord3DDouble, Coord3DDouble coord3DDouble2, short s2, PosCoordLocal posCoordLocal, PosCoordLocal posCoordLocal2, boolean z, PosRotation posRotation, float f, float f2, float f3, float f4, float f5, float f6, float f7, GPSDatetime gPSDatetime, byte b3, int i3, int i4, BigInteger bigInteger2) {
        this.dataType = i;
        this.tickTime = bigInteger;
        this.status = i2;
        this.isEncrypted = s;
        this.NS = b;
        this.EW = b2;
        this.pos = coord3DDouble;
        this.posRaw = coord3DDouble2;
        this.isEnuLocalPos = s2;
        this.posEnu = posCoordLocal;
        this.refPosEcef = posCoordLocal2;
        this.isUseRotation = z;
        this.rotation = posRotation;
        this.speed = f;
        this.course = f2;
        this.alt = f3;
        this.posAcc = f4;
        this.courseAcc = f5;
        this.altAcc = f6;
        this.speedAcc = f7;
        this.dateTime = gPSDatetime;
        this.fusionType = b3;
        this.fusionStatus = i3;
        this.locAccStatus = i4;
        this.localTickTime = bigInteger2;
    }
}
