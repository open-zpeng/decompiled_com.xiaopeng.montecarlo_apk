package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.path.model.RoadClass;
import java.io.Serializable;
/* loaded from: classes.dex */
public class TrafficIncident implements Serializable {
    public long ID;
    public short credibility;
    public String desc;
    public long eventType;
    public int lane;
    public long layerId;
    public long layerTag;
    public int linkIndex;
    public Coord2DDouble pos;
    public short priority;
    public short reversed;
    @RoadClass.RoadClass1
    public int roadClass;
    public int segIndex;
    public short source;
    public String title;
    public short titleType;
    public short type;

    public TrafficIncident() {
        this.pos = new Coord2DDouble();
        this.title = "";
        this.desc = "";
        this.type = (short) 0;
        this.priority = (short) 0;
        this.credibility = (short) 0;
        this.source = (short) 0;
        this.ID = 0L;
        this.eventType = 0L;
        this.layerId = 0L;
        this.layerTag = 0L;
        this.segIndex = 0;
        this.linkIndex = 0;
        this.titleType = (short) 0;
        this.reversed = (short) 0;
        this.lane = 0;
        this.roadClass = -1;
    }

    public TrafficIncident(Coord2DDouble coord2DDouble, String str, String str2, short s, short s2, short s3, short s4, long j, long j2, long j3, long j4, int i, int i2, short s5, short s6, int i3, @RoadClass.RoadClass1 int i4) {
        this.pos = coord2DDouble;
        this.title = str;
        this.desc = str2;
        this.type = s;
        this.priority = s2;
        this.credibility = s3;
        this.source = s4;
        this.ID = j;
        this.eventType = j2;
        this.layerId = j3;
        this.layerTag = j4;
        this.segIndex = i;
        this.linkIndex = i2;
        this.titleType = s5;
        this.reversed = s6;
        this.lane = i3;
        this.roadClass = i4;
    }
}
