package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ExactTrafficItem implements Serializable {
    public Coord2DDouble endPnt;
    public ArrayList<TrafficItem> trafficItems;

    public ExactTrafficItem() {
        this.trafficItems = new ArrayList<>();
        this.endPnt = new Coord2DDouble();
    }

    public ExactTrafficItem(ArrayList<TrafficItem> arrayList, Coord2DDouble coord2DDouble) {
        this.trafficItems = arrayList;
        this.endPnt = coord2DDouble;
    }
}
