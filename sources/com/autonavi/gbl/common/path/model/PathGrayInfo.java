package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PathGrayInfo implements Serializable {
    public int index2d;
    public int index3d;
    public long pathId;
    public double scale2d;
    public double scale3d;

    public PathGrayInfo() {
        this.index2d = 0;
        this.index3d = 0;
        this.scale2d = 0.0d;
        this.scale3d = 0.0d;
        this.pathId = 0L;
    }

    public PathGrayInfo(int i, int i2, double d, double d2, long j) {
        this.index2d = i;
        this.index3d = i2;
        this.scale2d = d;
        this.scale3d = d2;
        this.pathId = j;
    }
}
