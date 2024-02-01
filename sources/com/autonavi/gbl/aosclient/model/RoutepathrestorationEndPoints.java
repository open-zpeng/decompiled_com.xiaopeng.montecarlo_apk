package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RoutepathrestorationEndPoints implements Serializable {
    public String name;
    public ArrayList<RoutepathrestorationPointInfo> points;

    public RoutepathrestorationEndPoints() {
        this.name = "";
        this.points = new ArrayList<>();
    }

    public RoutepathrestorationEndPoints(String str, ArrayList<RoutepathrestorationPointInfo> arrayList) {
        this.name = str;
        this.points = arrayList;
    }
}
