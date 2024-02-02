package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PosGeoLineRoadId implements Serializable {
    public short dataSelector;
    public boolean isGeoLine;
    public boolean isOnline;
    public long lineTPID;
    public long lineTileID;
    public long linkID;
    public int onlineGeoVersion;
    public int ordinalNum;

    public PosGeoLineRoadId() {
        this.linkID = 0L;
        this.isGeoLine = false;
        this.dataSelector = (short) 0;
        this.ordinalNum = 0;
        this.lineTileID = 0L;
        this.lineTPID = 0L;
        this.isOnline = false;
        this.onlineGeoVersion = 0;
    }

    public PosGeoLineRoadId(long j, boolean z, short s, int i, long j2, long j3, boolean z2, int i2) {
        this.linkID = j;
        this.isGeoLine = z;
        this.dataSelector = s;
        this.ordinalNum = i;
        this.lineTileID = j2;
        this.lineTPID = j3;
        this.isOnline = z2;
        this.onlineGeoVersion = i2;
    }
}
