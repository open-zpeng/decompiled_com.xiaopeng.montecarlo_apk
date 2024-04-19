package com.autonavi.gbl.map.model;

import com.autonavi.gbl.map.layer.model.MapRGBA;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class PointLightParam implements Serializable {
    public float attenuation;
    public MapRGBA color;
    public boolean onOff;
    public float radius;
    public float strength;
    public float zOffset;

    public PointLightParam() {
        this.onOff = false;
        this.color = new MapRGBA((short) 87, (short) 116, (short) 131, (short) 0);
        this.radius = 10.0f;
        this.strength = 6.0f;
        this.attenuation = -1.0f;
        this.zOffset = 0.0f;
    }

    public PointLightParam(boolean z, MapRGBA mapRGBA, float f, float f2, float f3, float f4) {
        this.onOff = z;
        this.color = mapRGBA;
        this.radius = f;
        this.strength = f2;
        this.attenuation = f3;
        this.zOffset = f4;
    }
}
