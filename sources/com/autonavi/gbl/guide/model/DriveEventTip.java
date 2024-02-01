package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.guide.model.DriveEventType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class DriveEventTip implements Serializable {
    public int cameraSpeed;
    public int curSpeed;
    public Coord2DDouble point;
    @DriveEventType.DriveEventType1
    public int type;

    public DriveEventTip() {
        this.point = new Coord2DDouble();
        this.type = 0;
        this.curSpeed = 0;
        this.cameraSpeed = 0;
    }

    public DriveEventTip(Coord2DDouble coord2DDouble, @DriveEventType.DriveEventType1 int i, int i2, int i3) {
        this.point = coord2DDouble;
        this.type = i;
        this.curSpeed = i2;
        this.cameraSpeed = i3;
    }
}
