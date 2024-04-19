package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.path.model.CameraType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class Camera3d implements Serializable {
    public short flags;
    public double lat;
    public double lon;
    public short speed;
    @CameraType.CameraType1
    public int type;
    public double zlevel;

    public Camera3d() {
        this.type = 0;
        this.speed = (short) 0;
        this.flags = (short) 0;
        this.lon = 0.0d;
        this.lat = 0.0d;
        this.zlevel = 0.0d;
    }

    public Camera3d(@CameraType.CameraType1 int i, short s, short s2, double d, double d2, double d3) {
        this.type = i;
        this.speed = s;
        this.flags = s2;
        this.lon = d;
        this.lat = d2;
        this.zlevel = d3;
    }
}
