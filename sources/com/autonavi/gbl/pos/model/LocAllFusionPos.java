package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.pos.model.LocDataType;
import com.autonavi.gbl.pos.model.LocGNSSStatus;
import com.autonavi.gbl.pos.model.LocPosFusionInputState;
import com.autonavi.gbl.pos.model.LocPosFusionType;
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
    public short isEnuLocalPos;
    public boolean isUseRotation;
    public int locAccStatus;
    public BigInteger localTickTime;
    public Coord3DDouble pos;
    public float posAcc;
    public PosCoordLocal posEnu;
    @LocPosFusionType.LocPosFusionType1
    public int posFusionType;
    @LocPosFusionInputState.LocPosFusionInputState1
    public int posInputState;
    public PosCoordLocal refPosEcef;
    public PosRotation rotation;
    public float speed;
    public float speedAcc;
    @LocGNSSStatus.LocGNSSStatus1
    public int status;
    public BigInteger tickTime;
    public long unixTime;

    public LocAllFusionPos() {
        this.dataType = LocDataType.LocDataAllFusion;
        this.tickTime = new BigInteger("0");
        this.status = 65;
        this.NS = (byte) 78;
        this.EW = (byte) 69;
        this.pos = new Coord3DDouble();
        this.isEnuLocalPos = (short) 1;
        this.posEnu = new PosCoordLocal();
        this.refPosEcef = new PosCoordLocal();
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
        this.unixTime = 0L;
        this.posFusionType = 0;
        this.posInputState = 0;
        this.fusionType = (byte) -1;
        this.fusionStatus = 0;
        this.locAccStatus = 0;
        this.localTickTime = new BigInteger("0");
    }

    public LocAllFusionPos(@LocDataType.LocDataType1 int i, BigInteger bigInteger, @LocGNSSStatus.LocGNSSStatus1 int i2, byte b, byte b2, Coord3DDouble coord3DDouble, short s, PosCoordLocal posCoordLocal, PosCoordLocal posCoordLocal2, boolean z, PosRotation posRotation, float f, float f2, float f3, float f4, float f5, float f6, float f7, GPSDatetime gPSDatetime, long j, @LocPosFusionType.LocPosFusionType1 int i3, @LocPosFusionInputState.LocPosFusionInputState1 int i4, byte b3, int i5, int i6, BigInteger bigInteger2) {
        this.dataType = i;
        this.tickTime = bigInteger;
        this.status = i2;
        this.NS = b;
        this.EW = b2;
        this.pos = coord3DDouble;
        this.isEnuLocalPos = s;
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
        this.unixTime = j;
        this.posFusionType = i3;
        this.posInputState = i4;
        this.fusionType = b3;
        this.fusionStatus = i5;
        this.locAccStatus = i6;
        this.localTickTime = bigInteger2;
    }
}
