package com.autonavi.gbl.map.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class CalMapZoomerParam implements Serializable {
    public Coord3DDouble mapCenter;
    public Coord3DDouble mapPointer;
    public int screenY;

    public CalMapZoomerParam() {
        this.mapCenter = new Coord3DDouble();
        this.mapPointer = new Coord3DDouble();
        this.screenY = 0;
    }

    public CalMapZoomerParam(Coord3DDouble coord3DDouble, Coord3DDouble coord3DDouble2, int i) {
        this.mapCenter = coord3DDouble;
        this.mapPointer = coord3DDouble2;
        this.screenY = i;
    }
}
