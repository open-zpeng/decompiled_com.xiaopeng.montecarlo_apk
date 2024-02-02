package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RealCityNaviTextures implements Serializable {
    public int carResID;
    public float carScale;
    public int compassResID;
    public float compassScale;
    public int shineResID;
    public float shineScale;

    public RealCityNaviTextures() {
        this.carResID = -1;
        this.carScale = 1.0f;
        this.compassResID = -1;
        this.compassScale = 1.0f;
        this.shineResID = -1;
        this.shineScale = 1.0f;
    }

    public RealCityNaviTextures(int i, float f, int i2, float f2, int i3, float f3) {
        this.carResID = i;
        this.carScale = f;
        this.compassResID = i2;
        this.compassScale = f2;
        this.shineResID = i3;
        this.shineScale = f3;
    }
}
