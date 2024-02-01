package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class TrafficLightCountdown implements Serializable {
    public LightInfo lightInfo;
    public long linkID;
    public long linkIndex;
    public long pathID;
    public Coord2DDouble position;
    public long segmentIndex;
    public int status;

    public TrafficLightCountdown() {
        this.pathID = 0L;
        this.status = 0;
        this.linkID = 0L;
        this.segmentIndex = 0L;
        this.linkIndex = 0L;
        this.position = new Coord2DDouble();
        this.lightInfo = new LightInfo();
    }

    public TrafficLightCountdown(long j, int i, long j2, long j3, long j4, Coord2DDouble coord2DDouble, LightInfo lightInfo) {
        this.pathID = j;
        this.status = i;
        this.linkID = j2;
        this.segmentIndex = j3;
        this.linkIndex = j4;
        this.position = coord2DDouble;
        this.lightInfo = lightInfo;
    }
}
