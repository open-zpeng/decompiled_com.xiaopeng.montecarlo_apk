package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MapViewPortParam implements Serializable {
    public long height;
    public long screenHeight;
    public long screenWidth;
    public long width;
    public long x;
    public long y;

    public MapViewPortParam() {
        this.x = 0L;
        this.y = 0L;
        this.width = 0L;
        this.height = 0L;
        this.screenWidth = 0L;
        this.screenHeight = 0L;
    }

    public MapViewPortParam(long j, long j2, long j3, long j4, long j5, long j6) {
        this.x = j;
        this.y = j2;
        this.width = j3;
        this.height = j4;
        this.screenWidth = j5;
        this.screenHeight = j6;
    }
}
