package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DFloat;
import com.autonavi.gbl.common.model.Coord3DFloat;
import java.io.Serializable;
/* loaded from: classes.dex */
public class AvoidJamArea implements Serializable {
    public boolean bIsVaild;
    public int detourDis;
    public long distance;
    public long eventType;
    public Coord2DFloat pos2D;
    public Coord3DFloat pos3D;
    public String roadName;
    public long saveTime;
    public short state;

    public AvoidJamArea() {
        this.bIsVaild = false;
        this.pos2D = new Coord2DFloat();
        this.pos3D = new Coord3DFloat();
        this.eventType = 0L;
        this.roadName = "";
        this.saveTime = 0L;
        this.detourDis = 0;
        this.distance = 0L;
        this.state = (short) 0;
    }

    public AvoidJamArea(boolean z, Coord2DFloat coord2DFloat, Coord3DFloat coord3DFloat, long j, String str, long j2, int i, long j3, short s) {
        this.bIsVaild = z;
        this.pos2D = coord2DFloat;
        this.pos3D = coord3DFloat;
        this.eventType = j;
        this.roadName = str;
        this.saveTime = j2;
        this.detourDis = i;
        this.distance = j3;
        this.state = s;
    }
}
