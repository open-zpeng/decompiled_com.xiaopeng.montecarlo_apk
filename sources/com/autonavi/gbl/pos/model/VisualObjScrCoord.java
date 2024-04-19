package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class VisualObjScrCoord implements Serializable {
    public int bottomRightX;
    public int bottomRightY;
    public int topLeftX;
    public int topLeftY;

    public VisualObjScrCoord() {
        this.topLeftX = 0;
        this.topLeftY = 0;
        this.bottomRightX = 0;
        this.bottomRightY = 0;
    }

    public VisualObjScrCoord(int i, int i2, int i3, int i4) {
        this.topLeftX = i;
        this.topLeftY = i2;
        this.bottomRightX = i3;
        this.bottomRightY = i4;
    }
}
