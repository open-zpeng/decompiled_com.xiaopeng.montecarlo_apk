package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GroupSegment implements Serializable {
    public boolean isCrucial;
    public boolean isViaPoint;
    public long length;
    public String roadName;
    public int segmentCount;
    public short speed;
    public int startSegmentIndex;
    public short status;
    public long tollCost;

    public GroupSegment() {
        this.length = 0L;
        this.tollCost = 0L;
        this.roadName = "";
        this.startSegmentIndex = 0;
        this.segmentCount = 0;
        this.status = (short) 0;
        this.speed = (short) 0;
        this.isViaPoint = false;
        this.isCrucial = false;
    }

    public GroupSegment(long j, long j2, String str, int i, int i2, short s, short s2, boolean z, boolean z2) {
        this.length = j;
        this.tollCost = j2;
        this.roadName = str;
        this.startSegmentIndex = i;
        this.segmentCount = i2;
        this.status = s;
        this.speed = s2;
        this.isViaPoint = z;
        this.isCrucial = z2;
    }
}
