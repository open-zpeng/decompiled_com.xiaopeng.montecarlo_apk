package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ManeuverIcon implements Serializable {
    public ArrayList<IconRoad> roads;

    public ManeuverIcon() {
        this.roads = new ArrayList<>();
    }

    public ManeuverIcon(ArrayList<IconRoad> arrayList) {
        this.roads = arrayList;
    }
}
