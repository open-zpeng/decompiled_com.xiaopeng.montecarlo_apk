package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class PointCloudControl implements Serializable {
    public long id;
    public long lay;
    public long lineCollision;
    public long mapCollision;
    public long pTType;
    public int pathIdx;
    public Coord2DDouble pos2D;
    public Coord3DDouble pos3D;
    public long prio;
    public long ptCollision;
    public long showPath;
    public long shwType;
    public long type;
    public long ver;

    public PointCloudControl() {
        this.type = 0L;
        this.pTType = 0L;
        this.id = 0L;
        this.shwType = 0L;
        this.pathIdx = 0;
        this.prio = 0L;
        this.ver = 0L;
        this.showPath = 0L;
        this.pos2D = new Coord2DDouble();
        this.pos3D = new Coord3DDouble();
        this.lay = 0L;
        this.ptCollision = 0L;
        this.lineCollision = 0L;
        this.mapCollision = 0L;
    }

    public PointCloudControl(long j, long j2, long j3, long j4, int i, long j5, long j6, long j7, Coord2DDouble coord2DDouble, Coord3DDouble coord3DDouble, long j8, long j9, long j10, long j11) {
        this.type = j;
        this.pTType = j2;
        this.id = j3;
        this.shwType = j4;
        this.pathIdx = i;
        this.prio = j5;
        this.ver = j6;
        this.showPath = j7;
        this.pos2D = coord2DDouble;
        this.pos3D = coord3DDouble;
        this.lay = j8;
        this.ptCollision = j9;
        this.lineCollision = j10;
        this.mapCollision = j11;
    }
}
