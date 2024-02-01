package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class RoutePoint implements Serializable {
    public boolean mIsDraw;
    public long mPathId;
    public Coord3DDouble mPos;
    public int mType;

    public RoutePoint() {
        this.mIsDraw = true;
        this.mPathId = 0L;
        this.mType = -1;
        this.mPos = new Coord3DDouble();
    }

    public RoutePoint(boolean z, long j, int i, Coord3DDouble coord3DDouble) {
        this.mIsDraw = z;
        this.mPathId = j;
        this.mType = i;
        this.mPos = coord3DDouble;
    }
}
