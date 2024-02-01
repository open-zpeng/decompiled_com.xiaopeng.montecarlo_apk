package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class TrafficEventInfo implements Serializable {
    public Coord2DDouble coord2D;
    public Coord3DDouble coord3D;
    public boolean detail;
    public long endLinkId;
    public String ext;
    public int id;
    public int label;
    public String labelDesc;
    public String lane;
    public int laneId;
    public int layer;
    public int layerTag;
    public boolean official;
    public long pathId;
    public long startLinkId;
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
        this.label = 0;
        this.laneId = -1;
        this.startLinkId = 0L;
        this.endLinkId = 0L;
        this.ext = "";
        this.labelDesc = "";
    }

    public TrafficEventInfo(int i, long j, int i2, int i3, int i4, Coord2DDouble coord2DDouble, Coord3DDouble coord3DDouble, boolean z, boolean z2, String str, int i5, int i6, long j2, long j3, String str2, String str3) {
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
        this.label = i5;
        this.laneId = i6;
        this.startLinkId = j2;
        this.endLinkId = j3;
        this.ext = str2;
        this.labelDesc = str3;
    }
}
