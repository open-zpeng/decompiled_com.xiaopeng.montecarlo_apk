package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DInt32;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ChargeStationInfo implements Serializable {
    public String brandName;
    public short chargePercent;
    public int chargeTime;
    public short direction;
    public int maxPower;
    public String name;
    public String poiID;
    public Coord2DInt32 projective;
    public int remainingCapacity;
    public int segmentIdx;
    public Coord2DInt32 show;

    public ChargeStationInfo() {
        this.segmentIdx = 0;
        this.direction = (short) 0;
        this.show = new Coord2DInt32();
        this.projective = new Coord2DInt32();
        this.poiID = "";
        this.name = "";
        this.brandName = "";
        this.maxPower = 0;
        this.chargePercent = (short) 0;
        this.chargeTime = 0;
        this.remainingCapacity = 0;
    }

    public ChargeStationInfo(int i, short s, Coord2DInt32 coord2DInt32, Coord2DInt32 coord2DInt322, String str, String str2, String str3, int i2, short s2, int i3, int i4) {
        this.segmentIdx = i;
        this.direction = s;
        this.show = coord2DInt32;
        this.projective = coord2DInt322;
        this.poiID = str;
        this.name = str2;
        this.brandName = str3;
        this.maxPower = i2;
        this.chargePercent = s2;
        this.chargeTime = i3;
        this.remainingCapacity = i4;
    }
}
