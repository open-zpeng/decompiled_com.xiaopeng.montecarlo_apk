package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.pos.model.LocFeedbackType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocFeedbackNode implements Serializable {
    public float aziDiffRoad2DR;
    public short buildingFloor;
    public long buildingID;
    public byte buildingLinkType;
    public ParkingSlope buildingSlope;
    public Coord3DDouble deltaPoint;
    public BigInteger linkID;
    public Coord3DDouble matchPoint;
    public boolean positiveLinkDirection;
    public float probability;
    public float roadAzi;
    public int roadWidth;
    public float toLinkStartDist;
    @LocFeedbackType.LocFeedbackType1
    public int type;

    public LocFeedbackNode() {
        this.matchPoint = new Coord3DDouble();
        this.deltaPoint = new Coord3DDouble();
        this.roadAzi = 0.0f;
        this.probability = 0.0f;
        this.type = 0;
        this.roadWidth = 0;
        this.aziDiffRoad2DR = 0.0f;
        this.positiveLinkDirection = false;
        this.linkID = new BigInteger("0");
        this.toLinkStartDist = 0.0f;
        this.buildingID = 0L;
        this.buildingLinkType = (byte) 0;
        this.buildingFloor = (short) 0;
        this.buildingSlope = new ParkingSlope();
    }

    public LocFeedbackNode(Coord3DDouble coord3DDouble, Coord3DDouble coord3DDouble2, float f, float f2, @LocFeedbackType.LocFeedbackType1 int i, int i2, float f3, boolean z, BigInteger bigInteger, float f4, long j, byte b, short s, ParkingSlope parkingSlope) {
        this.matchPoint = coord3DDouble;
        this.deltaPoint = coord3DDouble2;
        this.roadAzi = f;
        this.probability = f2;
        this.type = i;
        this.roadWidth = i2;
        this.aziDiffRoad2DR = f3;
        this.positiveLinkDirection = z;
        this.linkID = bigInteger;
        this.toLinkStartDist = f4;
        this.buildingID = j;
        this.buildingLinkType = b;
        this.buildingFloor = s;
        this.buildingSlope = parkingSlope;
    }
}
