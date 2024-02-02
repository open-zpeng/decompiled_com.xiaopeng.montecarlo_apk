package com.autonavi.gbl.map.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class CalMapZoomerLonLatParam implements Serializable {
    public int height;
    public Coord3DDouble mapPointer1;
    public Coord3DDouble mapPointer2;
    public float mapZoomScale;
    public int width;

    public CalMapZoomerLonLatParam() {
        this.mapPointer1 = new Coord3DDouble();
        this.mapPointer2 = new Coord3DDouble();
        this.width = 0;
        this.height = 0;
        this.mapZoomScale = 0.0f;
    }

    public CalMapZoomerLonLatParam(Coord3DDouble coord3DDouble, Coord3DDouble coord3DDouble2, int i, int i2, float f) {
        this.mapPointer1 = coord3DDouble;
        this.mapPointer2 = coord3DDouble2;
        this.width = i;
        this.height = i2;
        this.mapZoomScale = f;
    }
}
