package com.autonavi.gbl.common.path.option;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes.dex */
public class SelectedPathInfo implements Serializable {
    public int originalNaviRouteIndex;
    public Coord2DDouble originalNaviRouteStart;

    public SelectedPathInfo() {
        this.originalNaviRouteStart = new Coord2DDouble();
        this.originalNaviRouteIndex = -1;
    }

    public SelectedPathInfo(Coord2DDouble coord2DDouble, int i) {
        this.originalNaviRouteStart = coord2DDouble;
        this.originalNaviRouteIndex = i;
    }
}
