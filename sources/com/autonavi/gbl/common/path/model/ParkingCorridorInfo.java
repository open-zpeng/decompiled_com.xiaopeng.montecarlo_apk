package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DInt32;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ParkingCorridorInfo implements Serializable {
    public byte endFloor;
    public Coord2DInt32 endPoint;
    public byte floorNum;
    public byte startFloor;
    public boolean startFloorInvalid;
    public Coord2DInt32 startPoint;

    public ParkingCorridorInfo() {
        this.floorNum = (byte) 0;
        this.startFloorInvalid = false;
        this.startFloor = (byte) 0;
        this.endFloor = (byte) 0;
        this.startPoint = new Coord2DInt32();
        this.endPoint = new Coord2DInt32();
    }

    public ParkingCorridorInfo(byte b, boolean z, byte b2, byte b3, Coord2DInt32 coord2DInt32, Coord2DInt32 coord2DInt322) {
        this.floorNum = b;
        this.startFloorInvalid = z;
        this.startFloor = b2;
        this.endFloor = b3;
        this.startPoint = coord2DInt32;
        this.endPoint = coord2DInt322;
    }
}
