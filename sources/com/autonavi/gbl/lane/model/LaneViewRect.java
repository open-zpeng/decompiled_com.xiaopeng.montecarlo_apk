package com.autonavi.gbl.lane.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LaneViewRect implements Serializable {
    public int height;
    public int width;
    public int x;
    public int y;

    public LaneViewRect() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
    }

    public LaneViewRect(int i, int i2, int i3, int i4) {
        this.x = i;
        this.y = i2;
        this.width = i3;
        this.height = i4;
    }
}
