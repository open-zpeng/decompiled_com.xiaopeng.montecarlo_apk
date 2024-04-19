package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PathIndoorParkingInfo implements Serializable {
    public IndoorParkingInfo endParkingInfo;
    public short exist;
    public IndoorParkingInfo startParkingInfo;

    public PathIndoorParkingInfo() {
        this.exist = (short) 0;
        this.startParkingInfo = new IndoorParkingInfo();
        this.endParkingInfo = new IndoorParkingInfo();
    }

    public PathIndoorParkingInfo(short s, IndoorParkingInfo indoorParkingInfo, IndoorParkingInfo indoorParkingInfo2) {
        this.exist = s;
        this.startParkingInfo = indoorParkingInfo;
        this.endParkingInfo = indoorParkingInfo2;
    }
}
