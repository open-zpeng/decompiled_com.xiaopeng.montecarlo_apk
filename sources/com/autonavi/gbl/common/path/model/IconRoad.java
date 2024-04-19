package com.autonavi.gbl.common.path.model;

import com.autonavi.gbl.common.path.model.IconRoadType;
import com.autonavi.gbl.common.path.model.IconRoadUsage;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class IconRoad implements Serializable {
    public ArrayList<Short> points;
    @IconRoadType.IconRoadType1
    public int type;
    @IconRoadUsage.IconRoadUsage1
    public int usage;

    public IconRoad() {
        this.usage = 0;
        this.type = 0;
        this.points = new ArrayList<>();
    }

    public IconRoad(@IconRoadUsage.IconRoadUsage1 int i, @IconRoadType.IconRoadType1 int i2, ArrayList<Short> arrayList) {
        this.usage = i;
        this.type = i2;
        this.points = arrayList;
    }
}
