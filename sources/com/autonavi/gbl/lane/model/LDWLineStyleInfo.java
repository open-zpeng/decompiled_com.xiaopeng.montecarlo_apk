package com.autonavi.gbl.lane.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class LDWLineStyleInfo implements Serializable {
    public int fillResID;
    public float lineWidth;

    public LDWLineStyleInfo() {
        this.lineWidth = 0.0f;
        this.fillResID = -1;
    }

    public LDWLineStyleInfo(float f, int i) {
        this.lineWidth = f;
        this.fillResID = i;
    }
}
