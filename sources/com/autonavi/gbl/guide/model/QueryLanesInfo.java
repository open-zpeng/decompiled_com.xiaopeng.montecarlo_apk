package com.autonavi.gbl.guide.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class QueryLanesInfo implements Serializable {
    public int linkIdx;
    public int num;
    public int segmentIdx;

    public QueryLanesInfo() {
        this.segmentIdx = 0;
        this.linkIdx = 0;
        this.num = 0;
    }

    public QueryLanesInfo(int i, int i2, int i3) {
        this.segmentIdx = i;
        this.linkIdx = i2;
        this.num = i3;
    }
}
