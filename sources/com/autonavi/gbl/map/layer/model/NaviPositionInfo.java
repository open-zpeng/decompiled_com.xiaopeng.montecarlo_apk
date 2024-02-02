package com.autonavi.gbl.map.layer.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class NaviPositionInfo implements Serializable {
    public float carBearing;
    public float carPitch;
    public Coord3DDouble postion;

    public NaviPositionInfo() {
        this.postion = new Coord3DDouble();
        this.carBearing = 0.0f;
        this.carPitch = 0.0f;
    }

    public NaviPositionInfo(Coord3DDouble coord3DDouble, float f, float f2) {
        this.postion = coord3DDouble;
        this.carBearing = f;
        this.carPitch = f2;
    }
}
