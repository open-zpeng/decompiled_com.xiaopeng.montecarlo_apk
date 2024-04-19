package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class RoutePoint implements Serializable {
    public boolean mIsDraw;
    public Coord3DDouble mPos;
    public int mType;

    public RoutePoint() {
        this.mIsDraw = true;
        this.mType = -1;
        this.mPos = new Coord3DDouble();
    }

    public RoutePoint(boolean z, int i, Coord3DDouble coord3DDouble) {
        this.mIsDraw = z;
        this.mType = i;
        this.mPos = coord3DDouble;
    }
}
