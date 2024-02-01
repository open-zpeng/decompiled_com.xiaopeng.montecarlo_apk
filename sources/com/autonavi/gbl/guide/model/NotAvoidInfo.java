package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class NotAvoidInfo implements Serializable {
    public Coord2DDouble coord2D;
    public Coord3DDouble coord3D;
    public int distToCar;
    public int forbidType;
    public int type;
    public boolean valid;

    public NotAvoidInfo() {
        this.type = 0;
        this.distToCar = 0;
        this.coord2D = new Coord2DDouble();
        this.coord3D = new Coord3DDouble();
        this.forbidType = 0;
        this.valid = false;
    }

    public NotAvoidInfo(int i, int i2, Coord2DDouble coord2DDouble, Coord3DDouble coord3DDouble, int i3, boolean z) {
        this.type = i;
        this.distToCar = i2;
        this.coord2D = coord2DDouble;
        this.coord3D = coord3DDouble;
        this.forbidType = i3;
        this.valid = z;
    }
}
