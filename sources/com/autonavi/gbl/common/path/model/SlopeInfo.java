package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class SlopeInfo implements Serializable {
    public short heightDiff;
    public short slopeAngle;
    public long slopeLength;
    public Coord2DDouble slopePoint;

    public SlopeInfo() {
        this.slopePoint = new Coord2DDouble();
        this.heightDiff = (short) 0;
        this.slopeAngle = (short) 0;
        this.slopeLength = 0L;
    }

    public SlopeInfo(Coord2DDouble coord2DDouble, short s, short s2, long j) {
        this.slopePoint = coord2DDouble;
        this.heightDiff = s;
        this.slopeAngle = s2;
        this.slopeLength = j;
    }
}
