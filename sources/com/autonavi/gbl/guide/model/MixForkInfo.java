package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class MixForkInfo implements Serializable {
    public int dist;
    public Coord2DDouble pos;
    public int roadclass;
    public int segmentIndex;

    public MixForkInfo() {
        this.pos = new Coord2DDouble();
        this.dist = 0;
        this.roadclass = 0;
        this.segmentIndex = 0;
    }

    public MixForkInfo(Coord2DDouble coord2DDouble, int i, int i2, int i3) {
        this.pos = coord2DDouble;
        this.dist = i;
        this.roadclass = i2;
        this.segmentIndex = i3;
    }
}
