package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class FloorInfo implements Serializable {
    public byte floorNum;
    public short indoorLinkType;

    public FloorInfo() {
        this.floorNum = (byte) 0;
        this.indoorLinkType = (short) 0;
    }

    public FloorInfo(byte b, short s) {
        this.floorNum = b;
        this.indoorLinkType = s;
    }
}
