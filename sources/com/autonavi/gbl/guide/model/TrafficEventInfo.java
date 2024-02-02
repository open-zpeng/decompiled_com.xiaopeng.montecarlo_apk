package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class TrafficEventInfo implements Serializable {
    public Coord2DDouble coord2D;
    public Coord3DDouble coord3D;
    public boolean detail;
    public int id;
    public String lane;
    public int layer;
    public int layerTag;
    public boolean official;
    public long pathId;
    public int type;

    public TrafficEventInfo() {
        this.type = 0;
        this.pathId = 0L;
        this.layer = 0;
        this.layerTag = 0;
        this.id = 0;
        this.coord2D = new Coord2DDouble();
        this.coord3D = new Coord3DDouble();
        this.official = false;
        this.detail = false;
        this.lane = "";
    }

    public TrafficEventInfo(int i, long j, int i2, int i3, int i4, Coord2DDouble coord2DDouble, Coord3DDouble coord3DDouble, boolean z, boolean z2, String str) {
        this.type = i;
        this.pathId = j;
        this.layer = i2;
        this.layerTag = i3;
        this.id = i4;
        this.coord2D = coord2DDouble;
        this.coord3D = coord3DDouble;
        this.official = z;
        this.detail = z2;
        this.lane = str;
    }
}
