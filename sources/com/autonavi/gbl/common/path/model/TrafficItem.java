package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class TrafficItem implements Serializable {
    public short credibility;
    public int endIndex;
    public Coord3DDouble endPnt;
    public int fineStatus;
    public long length;
    public int ratio;
    public short reverse;
    public short speed;
    public int startIndex;
    public Coord3DDouble startPnt;
    public short status;
    public int travelTime;

    public TrafficItem() {
        this.length = 0L;
        this.travelTime = 0;
        this.ratio = 0;
        this.startIndex = 0;
        this.endIndex = 0;
        this.status = (short) 0;
        this.fineStatus = 0;
        this.speed = (short) 0;
        this.credibility = (short) 0;
        this.reverse = (short) 0;
        this.startPnt = new Coord3DDouble();
        this.endPnt = new Coord3DDouble();
    }

    public TrafficItem(long j, int i, int i2, int i3, int i4, short s, int i5, short s2, short s3, short s4, Coord3DDouble coord3DDouble, Coord3DDouble coord3DDouble2) {
        this.length = j;
        this.travelTime = i;
        this.ratio = i2;
        this.startIndex = i3;
        this.endIndex = i4;
        this.status = s;
        this.fineStatus = i5;
        this.speed = s2;
        this.credibility = s3;
        this.reverse = s4;
        this.startPnt = coord3DDouble;
        this.endPnt = coord3DDouble2;
    }
}
