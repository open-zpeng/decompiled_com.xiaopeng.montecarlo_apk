package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RoutepathrestorationPoints implements Serializable {
    public ArrayList<RoutepathrestorationPointInfo> points;

    public RoutepathrestorationPoints() {
        this.points = new ArrayList<>();
    }

    public RoutepathrestorationPoints(ArrayList<RoutepathrestorationPointInfo> arrayList) {
        this.points = arrayList;
    }
}
