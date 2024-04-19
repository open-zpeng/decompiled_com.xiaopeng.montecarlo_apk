package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DFloat;
import com.autonavi.gbl.common.model.Coord3DFloat;
import java.io.Serializable;
import java.math.BigInteger;
/* loaded from: classes.dex */
public class RoadClosedArea implements Serializable {
    public boolean bIsVaild;
    public String desc;
    public long distance;
    public BigInteger endTime;
    public long eventType;
    public Coord2DFloat pos2D;
    public Coord3DFloat pos3D;
    public BigInteger startTime;
    public String title;

    public RoadClosedArea() {
        this.bIsVaild = false;
        this.pos2D = new Coord2DFloat();
        this.pos3D = new Coord3DFloat();
        this.title = "";
        this.desc = "";
        this.startTime = new BigInteger("0");
        this.endTime = new BigInteger("0");
        this.eventType = 0L;
        this.distance = 0L;
    }

    public RoadClosedArea(boolean z, Coord2DFloat coord2DFloat, Coord3DFloat coord3DFloat, String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, long j, long j2) {
        this.bIsVaild = z;
        this.pos2D = coord2DFloat;
        this.pos3D = coord3DFloat;
        this.title = str;
        this.desc = str2;
        this.startTime = bigInteger;
        this.endTime = bigInteger2;
        this.eventType = j;
        this.distance = j2;
    }
}
