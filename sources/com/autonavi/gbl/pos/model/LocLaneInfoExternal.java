package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.pos.model.ELocalizationType;
import com.autonavi.gbl.pos.model.EMapType;
import com.autonavi.gbl.pos.model.LocDataType;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes2.dex */
public class LocLaneInfoExternal implements Serializable {
    public float alt;
    public float course;
    @EMapType.EMapType1
    public int dataSource;
    @LocDataType.LocDataType1
    public int dataType;
    public short dataVersion;
    public LaneReference laneRef;
    public LinkReference linkRef;
    @ELocalizationType.ELocalizationType1
    public int locType;
    public Coord3DDouble pos;
    public float speed;
    public BigInteger tickTime;
    public BigInteger unixTime;

    public LocLaneInfoExternal() {
        this.dataType = LocDataType.LocDataLaneInfoExternal;
        this.tickTime = new BigInteger("0");
        this.locType = -1;
        this.dataVersion = (short) 0;
        this.dataSource = -1;
        this.linkRef = new LinkReference();
        this.laneRef = new LaneReference();
        this.pos = new Coord3DDouble();
        this.alt = 0.0f;
        this.course = 0.0f;
        this.speed = 0.0f;
        this.unixTime = new BigInteger("0");
        this.linkRef.positiveDir = true;
    }

    public LocLaneInfoExternal(@LocDataType.LocDataType1 int i, BigInteger bigInteger, @ELocalizationType.ELocalizationType1 int i2, short s, @EMapType.EMapType1 int i3, LinkReference linkReference, LaneReference laneReference, Coord3DDouble coord3DDouble, float f, float f2, float f3, BigInteger bigInteger2) {
        this.dataType = i;
        this.tickTime = bigInteger;
        this.locType = i2;
        this.dataVersion = s;
        this.dataSource = i3;
        this.linkRef = linkReference;
        this.laneRef = laneReference;
        this.pos = coord3DDouble;
        this.alt = f;
        this.course = f2;
        this.speed = f3;
        this.unixTime = bigInteger2;
    }
}
