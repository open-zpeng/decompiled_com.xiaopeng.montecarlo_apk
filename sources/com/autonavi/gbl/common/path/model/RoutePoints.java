package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RoutePoints implements Serializable {
    public ArrayList<RoutePoint> mEndPoints;
    public ArrayList<RoutePoint> mStartPoints;
    public ArrayList<RoutePoint> mViaPoints;

    public RoutePoints() {
        this.mStartPoints = new ArrayList<>();
        this.mEndPoints = new ArrayList<>();
        this.mViaPoints = new ArrayList<>();
    }

    public RoutePoints(ArrayList<RoutePoint> arrayList, ArrayList<RoutePoint> arrayList2, ArrayList<RoutePoint> arrayList3) {
        this.mStartPoints = arrayList;
        this.mEndPoints = arrayList2;
        this.mViaPoints = arrayList3;
    }
}
