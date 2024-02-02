package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class TrafficJamInfo implements Serializable {
    public Coord2DDouble pos;
    public short speed;

    public TrafficJamInfo() {
        this.pos = new Coord2DDouble();
        this.speed = (short) 0;
    }

    public TrafficJamInfo(Coord2DDouble coord2DDouble, short s) {
        this.pos = coord2DDouble;
        this.speed = s;
    }
}
