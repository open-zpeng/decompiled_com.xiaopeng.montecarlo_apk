package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class VisualFrontVehicle implements Serializable {
    public float dis;
    public boolean isValid;
    public int prob;
    public VisualObjScrCoord scrCoor;
    public int type;

    public VisualFrontVehicle() {
        this.isValid = false;
        this.type = 0;
        this.prob = 0;
        this.scrCoor = new VisualObjScrCoord();
        this.dis = 0.0f;
    }

    public VisualFrontVehicle(boolean z, int i, int i2, VisualObjScrCoord visualObjScrCoord, float f) {
        this.isValid = z;
        this.type = i;
        this.prob = i2;
        this.scrCoor = visualObjScrCoord;
        this.dis = f;
    }
}
