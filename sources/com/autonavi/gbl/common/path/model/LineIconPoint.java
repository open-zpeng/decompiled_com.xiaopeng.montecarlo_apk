package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.path.model.LineIconType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LineIconPoint implements Serializable {
    public Coord2DDouble point;
    @LineIconType.LineIconType1
    public int type;

    public LineIconPoint() {
        this.point = new Coord2DDouble();
        this.type = -1;
    }

    public LineIconPoint(Coord2DDouble coord2DDouble, @LineIconType.LineIconType1 int i) {
        this.point = coord2DDouble;
        this.type = i;
    }
}
