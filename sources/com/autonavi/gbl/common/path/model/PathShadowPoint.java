package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class PathShadowPoint implements Serializable {
    public int curLinkIndex;
    public int curPointIndex;
    public int curSegmentIndex;
    public long naviPathId;
    public Coord2DDouble point2d;
    public Coord3DDouble point3d;
    public boolean valid3d;

    public PathShadowPoint() {
        this.curSegmentIndex = 0;
        this.curLinkIndex = 0;
        this.curPointIndex = 0;
        this.point2d = new Coord2DDouble();
        this.point3d = new Coord3DDouble();
        this.valid3d = false;
        this.naviPathId = 0L;
    }

    public PathShadowPoint(int i, int i2, int i3, Coord2DDouble coord2DDouble, Coord3DDouble coord3DDouble, boolean z, long j) {
        this.curSegmentIndex = i;
        this.curLinkIndex = i2;
        this.curPointIndex = i3;
        this.point2d = coord2DDouble;
        this.point3d = coord3DDouble;
        this.valid3d = z;
        this.naviPathId = j;
    }
}
