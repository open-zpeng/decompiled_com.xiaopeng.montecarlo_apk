package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DFloat;
import com.autonavi.gbl.common.model.Coord3DFloat;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ForbiddenInfo implements Serializable {
    public short action;
    public boolean bIsVaild;
    public long distance;
    public int endTime;
    public long id;
    public Coord2DFloat pos2D;
    public Coord3DFloat pos3D;
    public String roadName;
    public int starTime;

    public ForbiddenInfo() {
        this.bIsVaild = false;
        this.pos2D = new Coord2DFloat();
        this.pos3D = new Coord3DFloat();
        this.starTime = 0;
        this.endTime = 0;
        this.roadName = "";
        this.distance = 0L;
        this.id = 0L;
        this.action = (short) 0;
    }

    public ForbiddenInfo(boolean z, Coord2DFloat coord2DFloat, Coord3DFloat coord3DFloat, int i, int i2, String str, long j, long j2, short s) {
        this.bIsVaild = z;
        this.pos2D = coord2DFloat;
        this.pos3D = coord3DFloat;
        this.starTime = i;
        this.endTime = i2;
        this.roadName = str;
        this.distance = j;
        this.id = j2;
        this.action = s;
    }
}
