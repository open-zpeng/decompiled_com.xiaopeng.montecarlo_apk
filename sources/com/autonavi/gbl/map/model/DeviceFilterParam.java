package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DeviceFilterParam implements Serializable {
    public float bluehue;
    public float brightness;
    public float contrast;
    public float greenhue;
    public float redhue;
    public float saturation;

    public DeviceFilterParam() {
        this.brightness = 1.0f;
        this.saturation = 1.0f;
        this.contrast = 1.0f;
        this.redhue = 0.0f;
        this.greenhue = 0.0f;
        this.bluehue = 0.0f;
    }

    public DeviceFilterParam(float f, float f2, float f3, float f4, float f5, float f6) {
        this.brightness = f;
        this.saturation = f2;
        this.contrast = f3;
        this.redhue = f4;
        this.greenhue = f5;
        this.bluehue = f6;
    }
}
