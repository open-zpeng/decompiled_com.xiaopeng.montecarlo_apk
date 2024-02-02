package com.autonavi.gbl.map.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SelectOutInfo implements Serializable {
    public ArrayList<MapPoi> pois;

    public SelectOutInfo() {
        this.pois = new ArrayList<>();
    }

    public SelectOutInfo(ArrayList<MapPoi> arrayList) {
        this.pois = arrayList;
    }
}
