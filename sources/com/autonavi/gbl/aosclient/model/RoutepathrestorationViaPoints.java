package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RoutepathrestorationViaPoints implements Serializable {
    public ArrayList<RouteDisplayPoints> display_points;
    public ArrayList<RoutePathProjectPoints> path_project_points;

    public RoutepathrestorationViaPoints() {
        this.display_points = new ArrayList<>();
        this.path_project_points = new ArrayList<>();
    }

    public RoutepathrestorationViaPoints(ArrayList<RouteDisplayPoints> arrayList, ArrayList<RoutePathProjectPoints> arrayList2) {
        this.display_points = arrayList;
        this.path_project_points = arrayList2;
    }
}
